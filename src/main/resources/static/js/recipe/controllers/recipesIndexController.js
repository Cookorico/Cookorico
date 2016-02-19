/**
 * Controller to show recipes list
 */
angular.module('cookorico').controller('RecipesCtrl', function ($scope, $http) {

    $http.get('/recipes?mainpic=true').success(function (data) {
        $scope.recipes = data;
    });

});