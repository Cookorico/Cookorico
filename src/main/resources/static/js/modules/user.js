'use strict';

var registerModule = angular.module('User-module', []);

registerModule.controller('RegisterController', ['$scope','$http','$location', function ($scope, $http, $location) {
	var user
	
	this.register = function () {
		
		user = angular.toJson($scope.user);
    	// console.log(user);
		
    	$http({
    		method: 'POST', 
    		url : '/user/register',
    		data : user
    	}).success(function(data, status, header, config){
    		console.log(data, status, header, config);
    		$location.path("/loghome");
    	}).error(function(data, status, header, config){
    		console.log(data, status, header, config);
    	});
    };
}]);