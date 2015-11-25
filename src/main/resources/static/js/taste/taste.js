/**
 * Created by leemans on 03/11/15.
 */
/*angular.module('taste').controller('taste', function($scope, $http) {
    $http.get('/resource/').success(function(data) {
        $scope.greeting = data;
    });
});*/


angular.module('cookorico').controller('tasteCtrl', ['$scope', '$http', function($scope, $http){
	
	$scope.bdd_taste = {
			'ingredients':[
				{
				'url':'js/taste/artichaut.png',
				'name':'choux',
				'css_value': 'taste-eight',
				'value':''
			},
			
			{
				'url':'js/taste/artichaut.png',
				'name':'choux-fleur',
				'css_value': 'taste-eight',
				'value':''
			},
			{
				'url':'js/taste/artichaut.png',
				'name':'artichaut',
				'css_value': 'taste-eight',
				'value':''
			},
			{
				'url':'js/taste/radis.png',
				'name':'radis',
				'css_value': 'taste-seven',
				'value':''
			}
			]
			
	}
	
	$scope.taste = {
			'ingredients':[]
	}
	
	$scope.inputIngredient = '';
	
	$scope.findIngredient = function(ingredient){

		return ingredient.name.indexOf($scope.inputIngredient) != -1 
		&& $scope.inputIngredient.length >= 3 
		&& $.inArray(ingredient, $scope.taste['ingredients']) == -1; 
	}
	
	$scope.addPersonnalTaste = function(ingredient){
		$scope.taste['ingredients'].push(ingredient);
		$scope.inputIngredient = "";
		
		//TODO req GET -> bdd
	}
	
}]);
