'use strict';
    
var loginModule = angular.module('Login-module', []);

loginModule.controller('LoginController', ['$scope','$http', function ($scope, $http) {
	var user = $scope.user
	
	this.login = function () {
		
    	$http({
    		method: 'POST', 
    		url : '/login',
    		data : user
    	}).success(function(data, status, header, config){
    		console.log(data, status, header, config);
    	}).error(function(data, status, header, config){
    		console.log(data, status, header, config);
    	});
		
    };
    
    this.logout = function () {
        alert('logout')
    };
}]);
 