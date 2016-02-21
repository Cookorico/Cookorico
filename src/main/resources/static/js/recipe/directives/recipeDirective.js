angular.module('cookorico').directive('ccRecipe', function () {
	return {
		restrict: 'E',
		templateUrl: 'js/recipe/templates/recipeThumbnail.html',
		scope: {
			recipe: '='
		}
	}
});

angular.module('cookorico').directive('ccRecipesHeader', function () {
	return {
		restrict: 'E',
		templateUrl: 'js/recipe/templates/recipeFilter.html',
		controller: function ($scope) {
			$scope.typePlat = 'Plat';
		}
	}
});

angular.module('cookorico').directive('ccRecipeInfos', function () {
	return {
		restrict: 'E',
		templateUrl: 'js/recipe/templates/recipeInfos.html'
	}
});

angular.module('cookorico').directive('ccRecipeMainPicture', function () {
	return {
		restrict: 'E',
		templateUrl: 'js/recipe/templates/recipePictures.html'
	}
});

angular.module('cookorico').directive('ccRecipeIngredients', function () {
	return {
		restrict: 'E',
		templateUrl: 'js/recipe/templates/recipeIngredients.html'
	}
});

angular.module('cookorico').directive('ccRecipeSteps', function () {
	return {
		restrict: 'E',
		templateUrl: 'js/recipe/templates/recipeSteps.html'
	}
});

angular.module('cookorico').directive('modalDialog', function (){
	return {
		restrict: 'E',
		scope: {
			show: '='
		},
		replace: true, // Replace with the template below
		transclude: true, // we want to insert custom content inside the directive
		link: function(scope, element, attrs) {
			scope.dialogStyle = {};
			if (attrs.width)
				scope.dialogStyle.width = attrs.width;
			if (attrs.height)
				scope.dialogStyle.height = attrs.height;
			scope.hideModal = function() {
				scope.show = false;
			};
		},
		templateUrl: 'js/recipe/templates/modalProducer.html'
	};

});

angular.module('cookorico').directive('ccRecipeComments', function () {
	return {
		restrict: 'E',
		templateUrl: 'js/recipe/templates/recipeComments.html',
		controller: function ($scope, $http, $stateParams) {

			refresh();

			$scope.saveComment = function (newComment, idRecipe) {

				$scope.newComment.recipe = {};
				$scope.newComment.recipe.idRecipe = idRecipe;

				$http({
					method: 'POST',
					url: '/comment/add',
					data: newComment
				}).success(function () {
					refresh();
				});

			};

			function refresh() {
				$http({
					method: 'GET',
					url: '/comments/recipe/' + $stateParams.idRecipe
				}).success(function (response) {
					$scope.recipe.comments = response;
					$scope.newComment = {};
				});
			}

		}
	}
});