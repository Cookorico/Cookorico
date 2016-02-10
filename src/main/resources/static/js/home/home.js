/**
 * Created by leemans on 03/11/15.
 */
window.app_version = 2;

angular.module('home', ['angular.css.injector', 'auth'])
.controller('homeCtrl', function ($scope, $http, auth, cssInjector) {

	
	$scope.recipesUne={};
	$scope.producteurs={};
	console.log("HOME CTRL");
	$http({
		method: 'GET', 
		url : '/recipeUne/3'
	}).then(function successCallback(response) {
		$scope.recipesUne = response.data;
		
	}, function errorCallback(response) {
		console.log(data, status, header, config);
	});    	

});
