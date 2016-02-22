angular.module('cookorico')
.controller('profileCtrl', function ($scope, $rootScope, $http) {
	console.log("-------------------- profileCtrl --------------------");
	$scope.user= {};
	$scope.level ={};

	//Get user details
	$http({
		method: 'GET', 
		url : '/profile'
	}).then(function successCallback(response) {

		$scope.user = response.data;
		
		
		$http({
			method: 'GET', 
			url : '/level/xp/' + $scope.user.experience
		}).success(function(data, status, header, config){
			$scope.level = data;
		}).error(function(data, status, header, config){
			console.log(data, status, header, config);
		});
		
			
		
	  }, function errorCallback(response) {
			console.log(data, status, header, config);
	  });
	
	

}).controller('profileMemberCtrl', ['$scope','$stateParams','$http', function ($scope, $stateParams, $http, auth) {
	console.log("-------------------- profileMemberCtrl --------------------");
	// utilise le fichier profileMember.html mais est presque une copie de views/pages/dashboard/profile.html?
	
	
	$http({
		method: 'GET', 
		url : '/profile/'+$stateParams.idMember
	}).then(function successCallback(response) {

		$scope.user = response.data;
		
		
	  }, function errorCallback(response) {
			console.log(data, status, header, config);
	  });
	
	

}]);