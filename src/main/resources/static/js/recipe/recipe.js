
angular.module('recipe', ['flash', 'ngAnimate'])
.controller('RecipesCtrl', function($scope, $http) {
    $http.get('/recipes?mainpic=true')
    .success(function(data, status, headers, config) {
    	
    	objects = data;
    	
    	for(var key in objects) {
    	    var value = objects[key];
    	    //console.log(value);
    	}
    	
    	//console.log(data);
        $scope.recipes = data;
    })
    .error(function(data, status, headers, config) {
        // log error
    });
}).controller('addRecipeCtrl', ['$rootScope', '$scope', 'Flash', '$location', '$http',  function ($rootScope, $scope, Flash, $location, $http) {
	
	$scope.add = function () {
		
		var recipe = angular.toJson($scope.recipe);
		//console.log($scope.recipe);
		//console.log(recipe);
		//
		// send recipe to the recipe controller
		$http({
    		method: 'POST', 
    		url : '/recipe/add',
    		data : recipe
    	})
    	.success(function(data, status, header, config){
    		Flash.create('success', 'Votre nouvelle recette a été bien ajoutée !');
    		$location.path('/dashboard/recipes');
    	})
    	.error(function(data, status, header, config){
    		Flash.create('danger', 'Suite à une erreur votre recette na pas été sauvegardée');
    		$location.path('/dashboard/home');
    	});
    };
}]).controller('RecipeCtrl',  ['$scope','$stateParams','$http', function ($scope, $stateParams, $http, auth, cssInjector) {
	console.log("-------------------- RecipeCtrl --------------------");
	
	
	$http({
		method: 'GET', 
		url : '/recipe/'+$stateParams.idRecipe
	}).then(function successCallback(response) {

		$scope.recipe = response.data;
		//console.log(response.data);

		
	  }, function errorCallback(response) {
			//console.log(data, status, header, config);
	  });
	
	
	
}]);

