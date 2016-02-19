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

angular.module('cookorico').directive('ccRecipeComments', function () {
    return {
        restrict: 'E',
        templateUrl: 'js/recipe/templates/recipeComments.html'
    }
});