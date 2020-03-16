
var app = angular.module('app-transacao', []); 

app.controller('transacao-controller', ['$http','$scope', function ($http, $scope) {
	
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
  
  $scope.buscar = function(cliente){
	    
	  $http({ 
	      method:'GET', 
	      url: $scope.host+'/depositos/'+cliente.cpf, 
	  }).then(function success(response){
		  console.log(response.data);
		  $scope.depositos = response.data;
	  },function unsuccess(response){ 
	      console.log(response); 
	  });
	  
	  
	  
	  $http({ 
	      method:'GET', 
	      url: $scope.host+'/saques/'+cliente.cpf, 
	  }).then(function success(response){
		  console.log(response.data);
		  $scope.saques = response.data;
	  },function unsuccess(response){ 
	      console.log(response); 
	  });
	  
  }

}]);