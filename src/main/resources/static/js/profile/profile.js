window.app_version = 2;

angular.module('profile', ['angular.css.injector', 'auth'])
.controller('profileCtrl', function ($scope, $rootScope, $http, auth, cssInjector) {
	console.log("-------------------- profileCtrl --------------------");
	$scope.user= {};
	$scope.level ={};

	//Get user details
	$http({
		method: 'GET', 
		url : '/profile'
	}).then(function successCallback(response) {

		$scope.user = response.data;
		if($rootScope.newXp != null){
			$scope.user.experience = $rootScope.newXp;

		}
		console.log($scope.user);
		
		/*
		$http({
			method: 'GET', 
			url : '/level/xp/' + $scope.user.experience
		}).success(function(data, status, header, config){
			$scope.level = data;
		}).error(function(data, status, header, config){
			console.log(data, status, header, config);
		});
		*/
			
		
	  }, function errorCallback(response) {
			console.log(data, status, header, config);
	  });
	
	

}).controller('profileMemberCtrl', ['$scope','$stateParams','$http', function ($scope, $stateParams, $http, auth, cssInjector) {
	console.log("-------------------- profileMemberCtrl --------------------");
	// utilise le fichier profileMember.html mais est presque une copie de views/pages/dashboard/profile.html?
	
	
	$http({
		method: 'GET', 
		url : '/profile/'+$stateParams.idMember
	}).then(function successCallback(response) {

		$scope.user = response.data;
		
		console.log($scope.user);

		
	  }, function errorCallback(response) {
			console.log(data, status, header, config);
	  });
	
	

}]);