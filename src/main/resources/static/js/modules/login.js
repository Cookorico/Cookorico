'use strict';
    


    cookorico.controller('LoginController', ['$scope','$http','$location',  function ($scope, $http, $location) {

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
					alert("SUCCESSSSSSSSSSSS");
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
    

 