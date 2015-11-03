'use strict';

/**
 * @ngdoc function
 * @name dashyAngular.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of dashyAngular
 */
angular.module('dashyAngular')
  .controller('DashboardCtrl', function($scope, $state) {

    $scope.$state = $state;

    $scope.date = new Date();
    $scope.eventSources = [];

  
  });
