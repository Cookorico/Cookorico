'use strict';
    
var loginModule = angular.module('Register-module', []);

loginModule.controller('RegisterController', ['$scope','$http', function ($scope, $http) {
	var user = $scope.user
	
	this.register = function () {
		
    	$http({
    		method: 'PUT', 
    		url : '/register',
    		data : user
    	}).success(function(data, status, header, config){
    		console.log(data, status, header, config);
    	}).error(function(data, status, header, config){
    		console.log(data, status, header, config);
    	});
    };
}]);
 