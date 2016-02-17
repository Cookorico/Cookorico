'use strict';

angular.module('cookorico')
	.directive('menu',function(){
		return {
	        templateUrl:'scripts/directives/sidenav/menu/menu.html',
	        restrict: 'E',
	        replace: true,

        	controller: function($scope, $http){

	        	$scope.selectedMenu = 'dashboard';
				$scope.showingSubNav = 0;

				$scope.showSubNav = function(x){

									if(x==$scope.showingSubNav)
						$scope.showingSubNav = 0;
					else
						$scope.showingSubNav = x;


				};	
				
	        	$scope.user= {};
	    		$scope.level ={};

	    		//Get user details
	    		$http({
	    			method: 'GET', 
	    			url : '/profile'
	    		}).then(function successCallback(response) {

	    			$scope.user = response.data;

	    		  }, function errorCallback(response) {
	    				console.log(data, status, header, config);
	    		  });
	    		
				

	        }
		}
	});
