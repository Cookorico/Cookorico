'use strict';

/**
 * @ngdoc directive
 * @name cookorico.directive:pageHeader
 * @description
 * # pageHeader
 */
angular.module('cookorico')
	.directive('pageheader',function(){
		return {
        templateUrl:'scripts/directives/pageheader/pageheader.html',
        restrict: 'E',
        replace: true,
        scope: {
	        'pagename': '@',
	        'subtitle': '@'
  		}
    	}
	});


