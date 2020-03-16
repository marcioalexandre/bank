
var app = angular.module('app-deposito', []); 

app.controller('deposito-controller', ['$http','$scope', function ($http, $scope) {
	
  $scope.deposito = {} ; 
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
  
  $scope.salvar = function(deposito, cliente) 
  {   
	
	if (!cliente || !deposito.agencia || !deposito.numeroconta || !deposito.valor || !deposito.observacao)
	{
		alert ("Favor preencher todos os campos");
		window.location.href("/deposito");
	}
	  
	$scope.deposito = angular.copy(deposito);
	$scope.deposito.cpf = cliente.cpf;
	console.log($scope.deposito);

    $http({ 
      method:'POST', 
      url: $scope.host+'/deposito', 
      data: $scope.deposito 
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

	      $scope.deposito.agencia = response.data.agencia;
	      $scope.deposito.numeroconta = response.data.numero;
	  },function unsuccess(response){ 
	      console.log(response); 
	      $scope.msg = response.data.msg;
	  }); 
  }

}]);