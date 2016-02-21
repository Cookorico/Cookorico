/**
 * Angular module to manage recipe
 */
var producerModule = angular.module('producer', ['flash', 'ngAnimate', 'ngFileUpload']);


/**
 * Controller to show producers list
 */
producerModule.controller('ProducersCtrl', function($scope, $http) {
    
    $http.get('/producers').success(function(data, status, headers, config) {
        $scope.producers = data;
        console.log(data);
    }).error(function(data, status, headers, config) {
        console.log(data);
    });
});


/**
 * Controller to show one producer
 */
producerModule.controller('ProducerCtrl',  ['$scope','$stateParams','$http', '$rootScope', function ($scope, $stateParams, $http, $rootScope, auth, cssInjector) {
    
	
	var ingredients = [{'name':'carottes'}, {'name':'oeuf'}]
	$scope.producer = {'name':'Antoine', 'city':'Lille', 'description': 'blablalblabla', 'ingredients':ingredients}
	$scope.listIngre
	
	$scope.inputIngredient = '';
	

	//get main infos
    $http({
        method: 'GET', 
        url : '/producer/'+$stateParams.idProducer
    }).then(function successCallback(response) {
        //$scope.producer = response.data;
    }, function errorCallback(response) {
        console.error(data, status, header, config);
    });
    
    $http({
	    method: 'GET',
	    url: '/ingredients?mainpic=true'
	  }).success(function (data, status, headers, config) {
		    $scope.ingredients = data;
	  })
	  .error(function (data, status, headers, config) {
	  });
    
    
	$scope.findIngredient = function(ingredient){
//		if(ingredient.name.toLowerCase().match($scope.inputIngredient.toLowerCase()))
//			console.log(ingredient.name.toLowerCase().match($scope.inputIngredient.toLowerCase()));
//		console.log($scope.inputIngredient.toLowerCase());
		return ingredient.name.toLowerCase().match($scope.inputIngredient.toLowerCase()) 
		&& $scope.inputIngredient.length >= 2 
		&& $scope.ingredients.indexOf(ingredient.name.toLowerCase()) == -1; 
	}
	
}]);
