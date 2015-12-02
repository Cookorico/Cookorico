/**
 * Created by leemans on 03/11/15.
 */

var cookorico = angular.module('cookorico');


cookorico.directive('myEnter', function () {
    return function (scope, element, attrs) {
        element.bind("keydown keypress", function (event) {
            if(event.which === 13) {
                scope.$apply(function (){
                    scope.$eval(attrs.myEnter);
                });

                event.preventDefault();
            }
        });
    };
});

cookorico.directive('autoFocus', function($timeout) {
    return {
        restrict: 'AC',
        link: function(_scope, _element) {
            $timeout(function(){
                _element[0].focus();
            }, 0);
        }
    };
});

cookorico.controller('tasteCtrl', ['$scope', '$http', function($scope, $http){
	
	
	$scope.taste = {
			'ingredients':[]
	};
	
	$http({
	    method: 'GET',
	    url: '/ingredients?mainpic=true'
	  }).success(function (data, status, headers, config) {
		    $scope.bdd_taste = data;
		    
//		    console.log($scope.bdd_taste);
	  })
	  .error(function (data, status, headers, config) {
	    // TODO : erreur de récupération :(
	  });
	
	$http({
		method: 'GET', 
		url: '/tastes'
	 }).success(function (data, status, headers, config) {
//		    $scope.taste = data;
		 	var ingredient;
		 	angular.forEach(data, function(value, key){
		 		console.log(data);
		 		 ingredient = value.ingredient;
		 		 ingredient.grading = value.grading;
		 		 
		 		 $scope.taste.ingredients.push(ingredient);
		 	});
	  })
	  .error(function (data, status, headers, config) {
	    // TODO : erreur de récupération :(
	  });
	


	
	$scope.inputIngredient = '';
	
	$scope.findIngredient = function(ingredient){
//		if(ingredient.name.toLowerCase().match($scope.inputIngredient.toLowerCase()))
//			console.log(ingredient.name.toLowerCase().match($scope.inputIngredient.toLowerCase()));
//		console.log($scope.inputIngredient.toLowerCase());
		return ingredient.name.toLowerCase().match($scope.inputIngredient.toLowerCase()) 
		&& $scope.inputIngredient.length >= 1 
		&& $.inArray(ingredient.name.toLowerCase(), $scope.taste['ingredients']) == -1; 
	}
	
	$scope.addPersonnalTaste = function(ingredient){
		ingredient.name = ingredient.name.toLowerCase();
		$scope.taste['ingredients'].push(ingredient);
		console.log($scope.taste['ingredients']);
		$('input[type="number"]:first').focus();
		$scope.inputIngredient = "";
		
	}
	
	$scope.sendUserTaste = function(ingredient){
		console.log("ingredient sent !");
		ingredient.grading = $('input[type="number"]:first').val();
		$('input[type="number"]:first').remove();
		$http({
		    method: 'POST',
		    url: '/taste',
		    data: {'idIngredient':ingredient.idIngredient, 'grading': ingredient.grading}
		  }).success(function (data, status, headers, config) {
			  console.log("SUCCESS");
//			   console.log($scope.bdd_taste);
		  })
		  .error(function (data, status, headers, config) {
		    // TODO : erreur de récupération :(
		  });

	}
	
	$scope.updatePersonnalTaste = function(ingredient){
		$http({
		    method: 'PUT',
		    url: '/taste',
		    data: {'idIngredient':ingredient.idIngredient, 'grading': ingredient.grading}
		  }).success(function (data, status, headers, config) {
			  console.log("SUCCESS");
		  })
		  .error(function (data, status, headers, config) {
		    // TODO : erreur de récupération :(
		  });
	}
	
	
	
}]);
