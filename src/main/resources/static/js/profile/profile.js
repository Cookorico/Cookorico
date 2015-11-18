
window.app_version = 2;


angular.module('profile', ['angular.css.injector', 'auth'])
.service('profileService', function(){
	var userExperience = 15;

	return {
		getXP: function () {
			return userExperience;
		},
		setXP: function(value) {
			userExperience = value;
		}
	};


})
.controller('profileCtrl', function ($scope, $http, auth, cssInjector, profileService) {


	//Get user infos
	$http({
		method: 'GET', 
		url : '/user'
	}).success(function(data, status, header, config){
		profileService.setXP(data.principal.member);
	}).error(function(data, status, header, config){
		console.log(data, status, header, config);
	});

console.log(profileService.getXP());

	$http({
		method: 'GET', 
		url : '/level/xp/350'
	}).success(function(data, status, header, config){
		$scope.level = data;
	}).error(function(data, status, header, config){
		console.log(data, status, header, config);
	});

});
