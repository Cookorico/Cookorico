angular.module('home', ['auth'])
    .controller('homeCtrl', function ($scope, $http) {


        $scope.recipesUne = {};
        $scope.producteurs = {};
        $http({
            method: 'GET',
            url: '/recipeUne/3'
        }).then(function successCallback(response) {
            $scope.recipesUne = response.data;

        }, function errorCallback(response) {
            console.log(data, status, header, config);
        });

    });
