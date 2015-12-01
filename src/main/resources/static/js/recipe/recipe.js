angular.module('recipe', ['flash', 'ngAnimate'])
.controller('listingRecipeCtrl', function($scope, $http) {
    $http.get('/recipe/list')
    .success(function(data, status, headers, config) {
    	
    	objects = data;
    	
    	for(var key in objects) {
    	    var value = objects[key];
    	    //console.log(value);
    	}
    	
        $scope.recipes = data;
    })
    .error(function(data, status, headers, config) {
        // log error
    });
}).controller('addRecipeCtrl', ['$rootScope', '$scope', 'Flash', '$location', '$http',  function ($rootScope, $scope, Flash, $location, $http) {
	
	$scope.add = function () {
		
		var recipe = angular.toJson($scope.recipe);
		console.log($scope.recipe);
		console.log(recipe);
		
		// send recipe to the recipe controller
		$http({
    		method: 'POST', 
    		url : '/recipe/add',
    		data : recipe
    	})
    	.success(function(data, status, header, config){
    		Flash.create('success', 'Votre nouvelle recette a été bien ajoutée !');
    		$location.path('/dashboard/recipe');
    	})
    	.error(function(data, status, header, config){
    		Flash.create('danger', 'Suite à une erreur votre recette na pas été sauvegardée');
    		$location.path('/dashboard/home');
    	});
    };
}]);