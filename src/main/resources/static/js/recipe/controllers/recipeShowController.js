angular.module('cookorico').controller('recipeShowCtrl', function ($scope, $http, $stateParams) {

    $http({
        method: 'GET',
        url: '/recipe/' + $stateParams.idRecipe
    }).success(function (response) {
        $scope.recipe = response;

        if($scope.recipe.mainPicture == undefined){
           $scope.recipe.mainPicture = {filePath: 'images/default-recipe-icon.png'}
        }

    });



});