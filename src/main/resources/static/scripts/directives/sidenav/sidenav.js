'use strict';

angular.module('dashyAngular')
	.directive('sidenav',function(){
		return {
	        templateUrl:'scripts/directives/sidenav/sidenav.html?v='+window.app_version,
	        restrict: 'E',
	        replace: true,
	        controller: function($scope, $timeout, $rootScope){

	        	$scope.tabActive = [];       	

	        	$scope.$watch('tabActive', function(){

	        		if($scope.perfectSCrollbarObj) {
	        			setTimeout(function(){
		        			$scope.perfectSCrollbarObj.perfectScrollbar('update');
	        			}, 100);
	        		}
	        	}, true);

	        	$scope.menuToggle = function  () {
	        		$('body').toggleClass('menu-hidden');	
	        		$scope.tabActive = [1];	
	        		console.log($('body').hasClass('menu-hidden'));
	        		if ($('body').hasClass('menu-hidden')== 1) 
	        		{
	        			$rootScope.$broadcast('resize');
	        			$scope.perfectSCrollbarObj.perfectScrollbar('destroy');	        			
	        			$(document).click(function (e)
	        			{
	        				

							if (!$(".sidenav-sub-menu").is(e.target) )
							{
								$(".sidenav-sub-menu").hide();
							}
						}); 			

	        		}

	        		else {
	        		$timeout(function () {
	        			$rootScope.$broadcast('resize');	
	        			$scope.perfectSCrollbarObj.perfectScrollbar();	
	        			}, 100);
	        			$(document).click(function (e)
	        			{
	        				

							if (!$(".sidenav-sub-menu").is(e.target) )
							{
								$(".sidenav-sub-menu").show();
							}
						}); 	
	        		}

	        			
	        	}
	        	if ($('body').hasClass('menu-hidden')== 1) 
	        		{
	        			
	        		}
	        	else 
	        	{
	        		
	        	}
	        },	
	        link: function(scope, el, attrs){
	        	
	        	setTimeout(function(){

		        	scope.perfectSCrollbarObj = el.find('.tab-content').perfectScrollbar();

	        	}, 0);


	        }
    	}
	});


