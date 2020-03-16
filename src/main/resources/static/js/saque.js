
var app = angular.module('app-saque', []); 

app.controller('saque-controller', ['$http','$scope', function ($http, $scope) {
	
  $scope.saque = {} ; 
  $scope.host = 'http://localhost:8080';
  $scope.msg = ''; 

  $scope.clientes = function()
  {
	  $http({ 
	      method:'GET', 
	      url: $scope.host+'/clientes', 
	    }).then(function success(response){
	    	if (response.data.length == 0)
	    	{
	    		alert("Não há clientes cadastrados.");
	    		window.location.replace("/");
	    	}
	    	$scope.listaclientes = response.data;
	    },function unsuccess(response){ 
	       console.log(response); 
	    }); 
	
  }
  
  $scope.clientes();
  
  $scope.salvar = function(saque, cliente) 
  {   
	  
	if (!cliente || !saque.agencia || !saque.numeroconta || !saque.valor || !saque.observacao)
	{
		alert("Favor preencher todos os campos");
		window.location.href("/saque");
	}
	  
	  
	$scope.saque = angular.copy(saque);
	$scope.saque.cpf = cliente.cpf;
	console.log($scope.saque);

    $http({ 
      method:'POST', 
      url: $scope.host+'/saque', 
      data: $scope.saque 
    }).then(function success(response){
    	console.log(response);
       $scope.msg = response.data.msg;
    },function unsuccess(response){ 
       console.log(response); 
       $scope.msg = response.data.msg;
    }); 
    
  } 
  
  $scope.getConta = function(cliente){
	  
	  console.log(cliente);
	  
	  $http({ 
	      method:'GET', 
	      url: $scope.host+'/conta-corrente/'+cliente.cpf, 
	  }).then(function success(response){
	      console.log(response);
	      
	      if (!response.data.agencia || !response.data.numero)
	      {
	    	alert("Não há conta/numero cadastrados.");
	    	window.location.replace("/conta");
	      }
	      
	      $scope.saque.agencia = response.data.agencia;
	      $scope.saque.numeroconta = response.data.numero;
	  },function unsuccess(response){ 
	      console.log(response); 
	      $scope.msg = response.data.msg;
	  }); 
  }

}]);