/**
 * Created by leemans on 03/11/15.
 */
angular.module('taste', []).controller('taste', function($scope, $http) {
    $http.get('/resource/').success(function(data) {
        $scope.greeting = data;
    });
});