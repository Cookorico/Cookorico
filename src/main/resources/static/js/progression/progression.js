/**
 * Angular module to manage user progression
 */
var progressionModule = angular.module('progression', ['flash', 'ngAnimate']);

/**
 * Controller to show user progression infos
 */
progressionModule.controller('progressionCtrl', ['$scope','$rootScope', '$http', function($scope, $rootScope, $http) {
	$scope.progression = "The best!!";
}]);