'use strict';

angular.module('dashyAngular')
	.directive('comments',function(){
		return {
        templateUrl:'scripts/directives/sidenav/comments/comments.html?v='+window.app_version,
        restrict: 'E',
        replace: true,
    	}
	});


