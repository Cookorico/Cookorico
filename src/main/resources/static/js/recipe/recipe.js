angular.module('cookorico')
    .controller('recipe', function($scope, $http) {
    $http.get('/recipe/list').success(function(data, status, headers, config) {
    	
    	objects = data;
         console.debug(data);
    	
    	for(var key in objects) {
    	    var value = objects[key];
    	    console.log(value);
    	}
    	
        $scope.recipes = data;
    }).
    error(function(data, status, headers, config) {
        // log error
    });
});