angular.module('cookorico').controller('recipeShowCtrl', function ($scope, $http, $stateParams) {
	$scope.modalShown = false;

	$http({
		method: 'GET',
		url: '/recipe/' + $stateParams.idRecipe
	}).success(function (response) {
		$scope.recipe = response;

		if ($scope.recipe.mainPicture == undefined) {
			$scope.recipe.mainPicture = {filePath: 'images/default-recipe-icon.png'}
		}

	});


	$scope.toggleModal = function(idIngredient, ingredient) {
		$scope.ingredientName = ingredient;

		$http({
			method: 'GET',
			url: '/producers/ingredient/' + idIngredient
		}).success(function (response) {
			console.log(response)
		
			$scope.producers = response;
		});


		$scope.modalShown = !$scope.modalShown;
	};


});