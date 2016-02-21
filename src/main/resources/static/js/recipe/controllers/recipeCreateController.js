angular.module('cookorico').controller('recipeCreateCtrl', function ($scope, $http, $state, $stateParams) {

    $scope.ingredientInRecipe = {
        ingredient: {}
    };

    $http({
        method: 'GET',
        url: '/ingredients'
    }).success(function successCallback(response) {
        $scope.ingredients = response;
    });

    $http({
        method: 'GET',
        url: '/measurements'
    }).then(function successCallback(response) {
        $scope.measurements = response.data;
    });

    $scope.recipe = {
        dishType: 'Plat',
        difficulty: 5,
        ingredients: []
    };

    $scope.addIngredient = function () {

        $scope.recipe.ingredients.push($scope.ingredientInRecipe);

        $scope.ingredientInRecipe = {
            ingredient: {}
        };
    };

    $scope.addRecipe = function () {

        $http({
            method: 'POST',
            url: '/recipe/add',
            data: angular.toJson($scope.recipe)
        }).success(function () {
            $state.go('recipes');
        });

    };
});