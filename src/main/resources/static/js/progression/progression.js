/**
 * Angular module to manage user progression
 */
var progressionModule = angular.module('progression', ['flash', 'ngAnimate']);

/**
 * Controller to show user progression infos
 */
progressionModule.controller('progressionCtrl', ['$scope','$rootScope', '$http', function($scope, $rootScope, $http) {
	
	$scope.level1 = 0;
	$scope.level2 = 0;
	$scope.level3 = 0;
	$scope.level4 = 0;
	$scope.level5 = 0;
	var current_level = 0;
	
	$http.get('/myrecipes').success(function(recipes, status, headers, config) {
		
		$scope.recipes = recipes;
		var level1 = 0;
		
		for (var i = 0; i < recipes.length; i++) {
			
			if (($scope.level1 + recipes[i].experienceVal) <= 500) {
				$scope.level1 += recipes[i].experienceVal + current_level;
				current_level = 0;
			} else {
				$scope.level1 = 500 - $scope.level1;
				current_level = recipes[i].experienceVal - (500 - $scope.level1);
			}
				
			/*	
			if (($scope.level2 + recipes[i].experienceVal) <= 500) {
				$scope.level2 += recipes[i].experienceVal + current_level;
				current_level = 0;
			} else {
				$scope.level2 = 500 - $scope.level2;
				current_level = recipes[i].experienceVal - (500 - $scope.level2);
			} 
			
			if (($scope.level3 + recipes[i].experienceVal) <= 500) {
				$scope.level3 += recipes[i].experienceVal + current_level;
				current_level = 0;
			} else {
				$scope.level3 = 500 - $scope.level3;
				current_level = recipes[i].experienceVal - (500 - $scope.level3);
			}
			
			if (($scope.level4 + recipes[i].experienceVal) <= 500) {
				$scope.level4 += recipes[i].experienceVal + current_level;
				current_level = 0;
			} else {
				$scope.level4 = 500 - $scope.level4;
				current_level = recipes[i].experienceVal - (500 - $scope.level4);
			}
			
			if (($scope.level4 + recipes[i].experienceVal) <= 100000) {
				$scope.level5 += recipes[i].experienceVal + current_level;
				current_level = 0;
			}
			*/
			
			level1 += recipes[i].experienceVal;
		}
		
		console.log(level1);
		console.log($scope.level1);
		console.log($scope.level2);
		console.log($scope.level3);
		console.log($scope.level4);
		console.log($scope.level5);
		console.log($scope.recipes);
		
    }).error(function(recipes, status, headers, config) {
        console.log(recipes);
    });
}]);