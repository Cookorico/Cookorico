'use strict';

/**
 * @ngdoc directive
 * @name DashdashyAngular.directive:pageHeader
 * @description
 * # pageHeader
 */
angular.module('dashyAngular')
	.directive('homeChart',function(){
		return {
	        templateUrl:'scripts/directives/home-chart/home-chart.html?v='+window.app_version,
	        restrict: 'E',
	        replace: true,
	        controller: function($scope){

		        	$scope.line = {
					    labels: ['', '', '', '', '', '', ''],
					    
					    data: [
					      [65, 59, 80, 81, 56, 55, 40],
					      [28, 48, 40, 19, 86, 27, 90]
					    ],
					    colours: ['#a2d19e','#e8b769','#d57d6d','#06c5ac','#80b1cb'],

					    onClick: function (points, evt) {
					      console.log(points, evt);
					    }

				    };

		        },
	    	}
		});


