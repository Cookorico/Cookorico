'use strict';
    
var UserModule = angular.module('User-module', []);

UserModule.controller('RegisterController', ['$scope','$http', function ($scope, $http) {
	var user
	
	this.register = function () {
		
		user = angular.toJson($scope.user);
    	console.log(user);
		
    	$http({
    		method: 'POST', 
    		url : '/user/register',
    		data : user
    	}).success(function(data, status, header, config){
    		console.log(data, status, header, config);
    	}).error(function(data, status, header, config){
    		console.log(data, status, header, config);
    	});
    };
}]);
 

/*recipeModule.controller('AddRecipeController', ['$scope','$http', function ($scope, $http) {
	var recipe;
	
	this.add = function () {
		
		recipe = angular.toJson($scope.recipe);
    	console.log(recipe);

    	$http({
    		method: 'POST', 
    		url : '/recipe/add',
    		data : recipe
    	}).success(function(data, status, header, config){
    		console.log(data, status, header, config);
    	}).error(function(data, status, header, config){
    		console.log(data, status, header, config);
    	});
		
    };


}]);*/