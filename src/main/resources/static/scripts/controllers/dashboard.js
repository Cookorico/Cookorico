'use strict';

angular.module('cookorico')
    .controller('DashboardCtrl', function ($scope, $state) {

        $scope.$state = $state;

        $scope.date = new Date();
        $scope.eventSources = [];


    });
