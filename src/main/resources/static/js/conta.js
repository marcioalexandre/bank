
var app = angular.module('app-conta', []); 

app.controller('conta-controller', ['$http','$scope', function ($http, $scope) {
	
  $scope.conta = {} ;
  $scope.listaclientes = [];
  $scope.host = 'http://localhost:8080';
  $scope.msg = ''; 
  $scope.numerosdeconta = ['escolha uma agência'];

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
  
  $scope.agencias = [{"id":"00025-4"}, {"id":"00026-3"}]; // dados ficticios
  
  $scope.numerosdeconta = function(agencia){
	  // dados ficticios 
	  if (agencia.id == "00025-4")
	  {
		$scope.numeros = [{"id":"128769-5"},{"id":"138767-3"} ,{"id":"148763-0"}];   
	  }
	  if ((agencia.id == "00026-3")){
		  $scope.numeros = [{"id":"968769-5"},{"id":"988767-3"} ,{"id":"978763-0"}]; 
	  }
  }
  
  $scope.salvar = function(conta, cliente) 
  {   
	  
	if ( !conta.agencia || !conta.numeroconta || !conta.observacao || !cliente)
	{
		alert("Favor preencher todos os campos");
		window.location.href("/conta");
		
	}
		  
	$scope.conta = angular.copy(conta);
	$scope.conta.agencia = conta.agencia.id;
	$scope.conta.cpf = cliente.cpf;
	$scope.conta.numeroconta = conta.numeroconta.id;
	console.log($scope.conta);
	
	if (conta.tipo == "Corrente")
	{
		
	    $http({ 
	        method:'POST', 
	        url: $scope.host+'/conta-corrente', 
	        data: $scope.conta 
	      }).then(function success(response){
	      	console.log(response);
	         $scope.msg = response.data.msg;
	      },function unsuccess(response){ 
	         console.log(response); 
	         $scope.msg = response.data.msg;
	      }); 
		
	}else
	{
		alert("Poupança não está no escopo do teste =)"+conta.tipo);
	}

    
  } 

}]);