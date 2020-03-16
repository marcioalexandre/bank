
var app = angular.module('app-saldo', []); 

app.controller('saldo-controller', ['$http','$scope', function ($http, $scope) {
	
  $scope.saldo = {} ; 
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
  
  $scope.getSaldo = function(cliente){
	  
	  $scope.depositos = 0;
	  $scope.saques = 0;
	  $scope.saldoresultado = 0;
	  
	  $http({ 
	      method:'GET', 
	      url: $scope.host+'/valor-depositos/'+cliente.cpf, 
	  }).then(function success(response){
	      $scope.depositos = response.data;
	      $scope.saldoresultado += response.data;
	  },function unsuccess(response){ 
	      console.log(response); 
	  });
	  
	  $http({ 
	      method:'GET', 
	      url: $scope.host+'/valor-saques/'+cliente.cpf, 
	  }).then(function success(response){
	      $scope.saques = response.data;
	      $scope.saldoresultado -= response.data;
	  },function unsuccess(response){ 
	      console.log(response); 
	  });
	  
  }

}]);