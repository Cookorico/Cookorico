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

cookorico.filter('orderObjectBy', function() {
	  return function(items, field, reverse) {
	    var filtered = [];
	    angular.forEach(items, function(item) {
	      filtered.push(item);
	    });
	    filtered.sort(function (a, b) {
	      return (a[field] > b[field] ? 1 : -1);
	    });
	    if(reverse) filtered.reverse();
	    return filtered;
	  };
	});

cookorico.controller('tasteCtrl', ['$scope', '$http', function($scope, $http){
	
	$scope.order_item;
	$scope.order_reverse;
	$scope.button_order_alpha = 'A--Z';
	$scope.button_order_num = '0--10';
	$scope.show_delete_icon = false;
	
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
		var http_method = 'POST';
		if(ingredient.grading != undefined)
			http_method = 'PUT';
		ingredient.grading = $('input[type="number"]:first').val();
		$('input[type="number"]:first').remove();
		
		if(ingredient.grading != ''){
			$http({
			    method: http_method,
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
	
	$scope.sortByName = function(){
		
	}
	
	
}]);
