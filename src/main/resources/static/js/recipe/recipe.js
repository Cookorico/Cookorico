angular.module('cookorico').controller('recipe', function($scope, $http) {
    $http.get('/recipe/list').success(function(data, status, headers, config) {
    	
    	objects = data;
    	
    	for(var key in objects) {
    	    var value = objects[key];
    	    //console.log(value);
    	}
    	
        $scope.recipes = data;
    }).error(function(data, status, headers, config) {
        // log error
    });
});

angular.module('cookorico').controller('newrecipe', ['$scope','$http', function ($scope, $http) {
	var recipe;
	
	this.add = function () {
		
		recipe = angular.toJson($scope.recipe);
		//console.log(recipe);
	
		$http({
	    		method: 'POST', 
	    		url : '/recipe/add',
	    		data : recipe
	    	}).success(function(data, status, header, config){
	    		console.log(data, status, header, config);
	    	}).error(function(data, status, header, config){
	    		console.log(data, status, header, config);
	    	});
			
	    };
	}]
);