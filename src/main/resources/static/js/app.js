'use strict';

var cookorico = angular.module('cookorico', ['ngRoute', 'Login-module', 'Register-module']);

cookorico.config(['$routeProvider', function($routeProvider){
	
	$routeProvider.when('/', {
		templateUrl: 'templates/homeTemplate.html',
		controller: 'LoginController'	
	}).when("/test", {
		templateUrl : 'home.html'
	}).when("/register", {
		templateUrl : 'templates/registerTemplate.html',
		controller : 'RegisterController'
	}).otherwise({
		redirectTo:'/'
	});
}]);


    
