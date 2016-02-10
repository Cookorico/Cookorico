/**
 * Angular module to manage recipe
 */
var producerModule = angular.module('producer', ['flash', 'ngAnimate', 'ngFileUpload']);


/**
 * Controller to show recipes list
 */
producerModule.controller('ProducersCtrl', function($scope, $http) {
    
    $http.get('/producers').success(function(data, status, headers, config) {
        $scope.producers = data;
        console.log($scope.producers);
    }).error(function(data, status, headers, config) {
        console.log(data);
    });
});


/**
 * Controller to show recipes list
 */
producerModule.controller('ProducerCtrl',  ['$scope','$stateParams','$http', '$rootScope', function ($scope, $stateParams, $http, $rootScope, auth, cssInjector) {
    
	//get main infos
    $http({
        method: 'GET', 
        url : '/producer/'+$stateParams.idProducer
    }).then(function successCallback(response) {
        $scope.producer = response.data;
    }, function errorCallback(response) {
        console.error(data, status, header, config);
    });
    
}]);
