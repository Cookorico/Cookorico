/**
 * Angular module to manage recipe
 */
var producerModule = angular.module('producer', ['flash', 'ngAnimate', 'ngFileUpload']);


/**
 * Controller to show recipes list
 */
recipeModule.controller('ProducersCtrl', function($scope, $http) {
    
    $http.get('/producers').success(function(data, status, headers, config) {
        $scope.recipes = data;
    }).error(function(data, status, headers, config) {
        console.log(data);
    });
});
