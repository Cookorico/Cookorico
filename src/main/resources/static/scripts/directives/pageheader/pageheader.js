'use strict';

/**
 * @ngdoc directive
 * @name DashdashyAngular.directive:pageHeader
 * @description
 * # pageHeader
 */
angular.module('cookorico')
	.directive('pageheader',function(){
		return {
        templateUrl:'scripts/directives/pageheader/pageheader.html?v='+window.app_version,
        restrict: 'E',
        replace: true,
        scope: {
	        'pagename': '@',
	        'subtitle': '@'
  		}
    	}
	});


