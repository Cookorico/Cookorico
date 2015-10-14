'use strict';
    
    var loginModule = angular.module('Login-module', []);
    
    loginModule.controller('LoginController', ['$scope','$http','$location',  function ($scope, $http, $location) {
    	var user;
    	this.login = function () {
        	user = angular.toJson($scope.user);
        	console.log(user);

        	$http({
        		method: 'POST', 
        		url : '/login',
        		data : user
        	}).success(function(data, status, header, config){
        		console.log(data, status, header, config);
        	       $location.search(data);
        	       $location.path("/profile");      	
            }).error(function(data, status, header, config){
        		console.log(data, status, header, config);
        	});
    	
        	
    		
        };
        
        this.logout = function () {
            alert('logout')
        };
    
    
    }]);
    
    
    loginModule.controller('ProfileController', ['$scope', '$http', '$location', function($scope, $http, $location){
        var queryString = $location.search();
        if (queryString) {
        	console.log(queryString)
        	$scope.user = queryString;
        }
    	/*$http({
    		method: 'GET', 
    		url : '/user/:username',
    	}).success(function(data, status, header, config){
    		console.log(data, status, header, config);
    		
    	}).error(function(data, status, header, config){
    		console.log(data, status, header, config);
    	});*/
    }]);
 