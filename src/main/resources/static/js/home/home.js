/**
 * Created by leemans on 03/11/15.
 */
angular.module('home', []).controller('home', function($scope, $http, auth) {
    $http.get('/user/').success(function(data) {
        $scope.user = data.name;
    });

    $scope.logout = function(){
        auth.clear;
    }
});