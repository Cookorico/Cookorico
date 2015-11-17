
window.app_version = 2;

angular.module('profile', ['angular.css.injector', 'auth'])
.controller('profileCtrl', function ($scope, $http, auth, cssInjector) {
	
	$scope.user= {};

	$http({
		method: 'GET', 
		url : '/user'
	}).success(function(data, status, header, config){
		console.log(data.principal.member);
			$scope.user = data.principal.member;
	}).error(function(data, status, header, config){
		console.log(data, status, header, config);
	});

});
