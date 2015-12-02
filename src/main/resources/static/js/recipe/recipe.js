
angular.module('recipe', [])
.controller('RecipesCtrl', function($scope, $http) {
    $http.get('/recipes?mainpic=true')
    .success(function(data, status, headers, config) {
    	
    	objects = data;
    	
    	for(var key in objects) {
    	    var value = objects[key];
    	    //console.log(value);
    	}
    	
    	console.log(data);
        $scope.recipes = data;
    })
    .error(function(data, status, headers, config) {
        // log error
    });
}).controller('addRecipeCtrl', ['$scope','$window', '$location','$http', function ($scope, $window, $location, $http) {
	
	$scope.add = function () {
		
		var recipe = angular.toJson($scope.recipe);		
		console.log($scope.recipe);		
		
		// send recipe to the recipe controller
		$http({
    		method: 'POST', 
    		url : '/recipe/add',
    		data : recipe
    	})
    	.success(function(data, status, header, config){
    		//console.log(data);
    		$window.location.href = '#/dashboard/recipe/'+data.idRecipe+'/addstep';
    		
    		//$flash.create('success', 'Recette crée', 'custom-class');
    	})
    	.error(function(data, status, header, config){
    		//console.log(data, status, header, config);
    	});
    };
}]).controller('RecipeCtrl',  ['$scope','$stateParams','$http', function ($scope, $stateParams, $http, auth, cssInjector) {
	console.log("-------------------- RecipeCtrl --------------------");
	
	
	$http({
		method: 'GET', 
		url : '/recipe/'+$stateParams.idRecipe
	}).then(function successCallback(response) {

		$scope.recipe = response.data;
		console.log(response.data);

		
	  }, function errorCallback(response) {
			console.log(data, status, header, config);
	  });
	
	
	$http({
		method: 'GET', 
		url : '/recipe/'+$stateParams.idRecipe+'/currentUserIsCreator'
	}).then(function successCallback(response) {

		$scope.iscreator = response.data;
		console.log(response.data);

		
	  }, function errorCallback(response) {
			console.log(data, status, header, config);
	  });
	
	
}]).controller('addRecipeStepCtrl',  ['$scope','$window','$stateParams','$http', function ($scope, $window, $stateParams, $http, auth, cssInjector) {
	console.log("-------------------- addRecipeStepCtrl --------------------");
	
	
	$http({
		method: 'GET', 
		url : '/recipe/'+$stateParams.idRecipe
	}).then(function successCallback(response) {

		$scope.recipe = response.data;
		console.log(response.data);

		
	  }, function errorCallback(response) {
			console.log(data, status, header, config);
	  });

	$scope.addStep = function () {
		
		$scope.recipestep.idRecipe = $stateParams.idRecipe;
		var recipestep = angular.toJson($scope.recipestep);
		//recipestep['idRecipe'] = $stateParams.idRecipe;
		
		$http({
			method: 'POST', 
			url : '/recipestep/add',
			data : recipestep
		})
		.success(function(data, status, header, config){
			console.log(data);
			$window.location.href = '#/dashboard/recipe/'+$stateParams.idRecipe;

		})
		.error(function(data, status, header, config){
		});
	};
	
	
	
}]);
