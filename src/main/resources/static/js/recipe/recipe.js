
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
}).controller('addRecipeCtrl', ['$scope','$http', function ($scope, $http) {
	
	var recipe;
	//var user;
	
	this.add = function () {
		/*
		// get user info
		$http({
    		method: 'GET', 
    		url : '/user'
    	})
    	.success(function(data, status, header, config){
    		user = data.principal.member;
    		$scope.recipe["fk_creator"] = user.idMember;
    	})
    	.error(function(data, status, header, config){
    		//console.log(data);
    	});*/
		
		recipe = angular.toJson($scope.recipe);		
		console.log($scope.recipe);
		
		// send recipe to the recipe controller
		/*$http({
    		method: 'POST', 
    		url : '/recipe/add',
    		data : recipe
    	})
    	.success(function(data, status, header, config){
    		//console.log(data, status, header, config);
    	})
    	.error(function(data, status, header, config){
    		//console.log(data, status, header, config);
    	});*/
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
	
	
	
}]);