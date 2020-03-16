
var app = angular.module('app-cliente', []); 

app.controller('cliente-controller', ['$http','$scope', function ($http, $scope) {
	
  $scope.cliente = {} ; 
  $scope.host = 'http://localhost:8080';
  $scope.msg = ''; 

  $scope.salvar = function(cliente) 
  {   
	if (!cliente.cpf || !cliente.nome || !cliente.numerocelular || !cliente.login.email || !cliente.login.senha)
	{
		alert("Favor preencher todos os dados");
		window.location.href("/cliente")
	}  
	  
	$scope.cliente = angular.copy(cliente);
		
    $http({ 
      method:'POST', 
      url: $scope.host+'/cliente', 
      data: $scope.cliente 
    }).then(function success(response){
    	console.log(response);
       $scope.msg = response.data.msg;
    },function unsuccess(response){ 
       console.log(response); 
       $scope.msg = response.data.msg;
    }); 
    
  } 

}]);