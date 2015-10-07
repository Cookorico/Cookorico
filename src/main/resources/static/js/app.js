(function(){
    
    
var cookorico = angular.module('cookorico', ['ngRoute', 'Login-module']);

cookorico.config(['$routeProvider', function($routeProvider){
	
	$routeProvider.when('/', {
		templateUrl: 'templates/homeTemplate.html',
		controller: 'LoginController'	
	}).otherwise({
		redirectTo:'/'
	});
	
	
}]);

cookorico.controller('TestController', [function(){
	

	
}]);


    
})();