'use strict';

/**
 * @ngdoc function
 * @name dashyAngular.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of dashyAngular
 */
angular.module('cookorico').controller('PopoverDemoCtrl', function ($scope) {
  $scope.dynamicPopover = 'Hello, World!';
  $scope.dynamicPopoverTitle = 'Title';
});