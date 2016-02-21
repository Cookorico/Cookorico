angular.module('cookorico').controller('recipeCreateCtrl', function ($scope, $http, $stateParams) {


    $http({
        method: 'GET',
        url: '/ingredients'
    }).then(function successCallback(response) {
        $scope.ingredients = response;
    });

    $scope.recipe = {
        dishType: 'Plat',
        difficulty: 5
    }

});