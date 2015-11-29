window.app_version = 2;

cookoricoApp.controller('profileCtrl', function ($scope, $http) {

	$scope.user= {};
	$scope.level ={};

	//Get user details
	$http({
		method: 'GET', 
		url : '/profile'
	}).then(function successCallback(response) {

		$scope.user = response.data;
		
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
	
	

});