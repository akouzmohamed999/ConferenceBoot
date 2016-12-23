var app = angular.module("myApp",[]);
app.controller("inscriptionController",function($http,$scope){
	$scope.etudiant={};
	$scope.errors=null;
	$scope.mode="form";
	$scope.inscrire=function(){
		$http.post("etudiants",$scope.etudiant).success(function(data) {
		if(!data.errors){
			$scope.etudiant=data;
			$scope.mode="infos";
			$scope.errors=null;
		}else{
			$scope.errors=data;
		}
		
	});
    }
});

app.controller("homeController",function($http,$scope){
	$scope.
});