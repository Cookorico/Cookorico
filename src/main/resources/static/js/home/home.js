/**
 * Created by leemans on 03/11/15.
 */
angular.module('home', []).controller('home', function($scope, $http) {
    $http.get('/user/').success(function(data) {
        $scope.user = data.name;
    });
});