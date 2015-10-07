'use strict';

var cookorico = angular.module('cookorico', ['ngRoute', 'Login-module']);

cookorico.config(['$routeProvider', function($routeProvider){
	
	$routeProvider.when('/', {
		templateUrl: 'templates/homeTemplate.html',
		controller: 'LoginController'	
	}).when("/test", {
		templateUrl : 'home.html'
	}).otherwise({
		redirectTo:'/'
	});
	
	
}]);


    
