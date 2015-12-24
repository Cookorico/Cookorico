'use strict';

angular.module('cookorico')
	.directive('notification',function(){
		return {
        templateUrl:'scripts/directives/sidenav/notification/notification.html',
        restrict: 'E',
        replace: true,
    	}
	});


