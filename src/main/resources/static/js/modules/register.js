'use strict';
    
var RegisterModule = angular.module('Register-module', []);

RegisterModule.controller('RegisterController', ['$scope','$http', function ($scope, $http) {
	var member
	
	this.register = function () {
		
		member = angular.toJson($scope.member);
    	console.log(member);
		
    	$http({
    		method: 'POST', 
    		url : '/register',
    		data : member
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