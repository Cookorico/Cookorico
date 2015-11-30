
angular.module('recipe', [])
.controller('listingRecipeCtrl', function($scope, $http) {
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
}).controller('addRecipeCtrl', function ($scope, $location, $http) {
	
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
    		$location.path('/recipe');
    		//$flash.create('success', 'Recette crée', 'custom-class');
    	})
    	.error(function(data, status, header, config){
    		//console.log(data, status, header, config);
    	});
    };
});