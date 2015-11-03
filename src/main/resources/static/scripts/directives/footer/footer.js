'use strict';

angular.module('dashyAngular')
	.directive('footer',function(){
		return {
        templateUrl:'scripts/directives/footer/footer.html?v='+window.app_version,
        restrict: 'E',
        replace: true,
    	}
	});


