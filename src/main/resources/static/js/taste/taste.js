/**
 * Created by leemans on 03/11/15.
 */
/*angular.module('taste').controller('taste', function($scope, $http) {
    $http.get('/resource/').success(function(data) {
        $scope.greeting = data;
    });
});*/

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


cookorico.controller('tasteCtrl', ['$scope', '$http', function($scope, $http){
	
//	$scope.bdd_taste = {
//			'ingredients':[
//				{
//				'url':'js/taste/artichaut.png',
//				'name':'choux',
//				'css_value': 'taste-eight',
//				'value':''
//			},
//			
//			{
//				'url':'js/taste/artichaut.png',
//				'name':'choux-fleur',
//				'css_value': 'taste-eight',
//				'value':''
//			},
//			{
//				'url':'js/taste/artichaut.png',
//				'name':'artichaut',
//				'css_value': 'taste-eight',
//				'value':''
//			},
//			{
//				'url':'js/taste/radis.png',
//				'name':'radis',
//				'css_value': 'taste-seven',
//				'value':''
//			}
//			]
//			
//	}
	
	$http({
	    method: 'GET',
	    url: '/ingredients'
	  }).success(function (data, status, headers, config) {
		    $scope.bdd_taste = data;
		    console.log($scope.bdd_taste);
	  })
	  .error(function (data, status, headers, config) {
	    // erreur de récupération :(
	  });
	
	$scope.taste = {
			'ingredients':[]
	}
	
	$scope.inputIngredient = '';
	
	$scope.findIngredient = function(ingredient){
		if(ingredient.name.toLowerCase().match($scope.inputIngredient.toLowerCase()))
			console.log(ingredient.name.toLowerCase().match($scope.inputIngredient.toLowerCase()));
//		console.log($scope.inputIngredient.toLowerCase());
		return ingredient.name.toLowerCase().match($scope.inputIngredient.toLowerCase()) 
		&& $scope.inputIngredient.length >= 1 
		&& $.inArray(ingredient.name.toLowerCase(), $scope.taste['ingredients']) == -1; 
	}
	
	$scope.addPersonnalTaste = function(ingredient){
		ingredient.name = ingredient.name.toLowerCase();
		$scope.taste['ingredients'].push(ingredient);
		$('input[type="number"]:first').focus();
		$scope.inputIngredient = "";
		
		//TODO req GET -> bdd
	}
	
	$scope.sendUserTaste = function(ingredient){
		console.log("ingredient sent !");
		ingredient.value = $('input[type="number"]:first').val();
		$('input[type="number"]:first').remove();
		

	}
	
	
	
}]);
