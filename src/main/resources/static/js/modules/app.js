var cookorico = angular.module('cookorico', ['ngRoute', 'Login-module', 'Recipe-module']);

cookorico.config(['$routeProvider', function($routeProvider) {

	$routeProvider.when('/', {
		templateUrl : '../templates/logoutHome.html',
		controller : 'LoginController'			
	})
	.when('/login', {
		templateUrl : '../templates/logoutHome.html',
		controller : 'mainCtrl'
	}).when('/loghome', {
		templateUrl : '../templates/loginHome.html',
		controller : 'ListRecipeController'
	}).when('/recipe/:recipeId', {
		templateUrl : '../templates/showRecipe.html',
		controller : 'ShowRecipeController'
	}).when('/recipe/add', {
		templateUrl : '../templates/addRecipe.html',
		controller : 'AddRecipeController'
	})
	.otherwise({
		redirectTo : '/login'
	});
	
}]);


cookorico.controller('mainCtrl', ['$scope', '$http', function($scope, $http){
	//alert("toto");
}]);

cookorico.controller('indexCtrl', ['$scope', '$http', function($scope, $http){
	//alert("tata");
}]);
	
/*app.config(function($routeProvider, $httpProvider) {
    $routeProvider.when('/', {
		templateUrl : 'index.html',
		controller : 'mainCtrl'
    }).when('/login', {
		templateUrl : 'login.html',
		controller : 'navigation'
    }).otherwise('/');

    $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';

}).controller('navigation',

function($rootScope, $scope, $http, $location, $route) {

    $scope.tab = function(route) {
	return $route.current && route === $route.current.controller;
    };

    var authenticate = function(credentials, callback) {

	var headers = credentials ? {
	    authorization : "Basic " + btoa(credentials.username + ":" + credentials.password)
	} : {};

	$http.get('user', {
	    headers : headers
	}).success(function(data) {
	    if (data.name) {
		$rootScope.authenticated = true;
	    } else {
		$rootScope.authenticated = false;
	    }
	    callback && callback($rootScope.authenticated);
	}).error(function() {
	    $rootScope.authenticated = false;
	    callback && callback(false);
	});

    }

    authenticate();

    $scope.credentials = {};
    $scope.login = function() {
	authenticate($scope.credentials, function(authenticated) {
	    if (authenticated) {
		console.log("Login succeeded")
		$location.path("/");
		$scope.error = false;
		$rootScope.authenticated = true;
	    } else {
		console.log("Login failed")
		$location.path("/login");
		$scope.error = true;
		$rootScope.authenticated = false;
	    }
	})
    };

    $scope.logout = function() {
	$http.post('logout', {}).success(function() {
	    $rootScope.authenticated = false;
	    $location.path("/");
	}).error(function(data) {
	    console.log("Logout failed")
	    $rootScope.authenticated = false;
	});
    }

}).controller('mainCtrl', function($scope, $http) {
    $http.get('/resource/').success(function(data) {
    	alert("tptp");
	$scope.greeting = data;
    })
});*/