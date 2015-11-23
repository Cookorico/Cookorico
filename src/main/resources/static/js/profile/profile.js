window.app_version = 2;

angular.module('profile', ['angular.css.injector', 'auth'])
.controller('profileCtrl', function ($scope, $http, auth, cssInjector) {

	$scope.user= {};
	$scope.level ={};

	//Get user details
	$http({
		method: 'GET', 
		url : '/user'
	}).then(function successCallback(response) {

		$scope.user = response.data.principal.member;
		
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
	
	

});