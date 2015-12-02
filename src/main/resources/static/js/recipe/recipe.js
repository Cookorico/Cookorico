angular.module('recipe', ['flash', 'ngAnimate'])
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
}).controller('addRecipeCtrl', ['$rootScope', '$scope', 'Flash', '$location', '$http',  function ($rootScope, $scope, Flash, $location, $http) {

	//Function to add a new recipe
	$scope.add = function () {
		//Set the value of experienceVal
		$scope.recipe.rcp_experienceVal = parseInt($scope.recipe.rcp_difficulty) * 10;

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
			$location.path('/dashboard/recipes');
		})
		.error(function(data, status, header, config){
			Flash.create('danger', 'Suite à une erreur votre recette na pas été sauvegardée');
			$location.path('/dashboard/home');
		});
	};
}]).controller('RecipeCtrl',  ['$scope','Flash', '$stateParams', '$http', '$rootScope', function ($scope, Flash, $stateParams, $http,  $rootScope,  auth, cssInjector) {
	console.log("-------------------- RecipeCtrl --------------------");

	$scope.recipe;
	
	$http({
		method: 'GET', 
		url : '/recipe/'+$stateParams.idRecipe
	}).then(function successCallback(response) {

		$scope.recipe = response.data;

	}, function errorCallback(response) {
		console.log(data, status, header, config);
	});

	//Valider une recette
	$scope.doneRecipe = function(){
		console.log("DONE RECIPE");

		$scope.idUser;
		$rootScope.newXp;
		//Get user details
		$http({
			method: 'GET', 
			url : '/profile'
		}).then(function successCallback(response) {
			
			$scope.idUser = response.data.idMember;
			if($rootScope.newXp == null){
				$scope.newXp = response.data.experience + $scope.recipe.experienceVal;
				$rootScope.newXp = $scope.newXp;
			}else{
				$scope.newXp = $rootScope.newXp + $scope.recipe.experienceVal;
				$rootScope.newXp = $scope.newXp;
			}
			
			
			console.log($scope.idUser +  "   " + $scope.newXp);
			
			
			$http({
				method: 'GET', 
				url : '/level/xp/'+ $rootScope.newXp
			}).then(function successCallback(response){
				console.log(response);
				$rootScope.level = response.data;
			},function errorCallback(response) {
				console.log(data, status, header, config);
			});
			
		
			
				
			
		  }, function errorCallback(response) {
				console.log(data, status, header, config);
		  });

	}



}]);

