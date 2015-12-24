'use strict';

angular.module('cookorico')
	.directive('topnav',function(){
		return {
	        templateUrl:'scripts/directives/topnav/topnav.html?v='+window.app_version,
	        restrict: 'E',
	        replace: true,
	        controller: function($scope, $rootScope){
	        	
	        	$scope.toggleBodyLayout = function(){

			        $('body').toggleClass('box-section');
			        $scope.val = !$scope.val;
	        	}


			            	
	        	$scope.$watch('val', function  () {
	        		if ($scope.val == true) {
	        			// alert("message");
			        	$rootScope.$broadcast('resize');
			        }
			        else if($scope.val == false){
			        	$rootScope.$broadcast('resize');
			        }
			        localStorage.setItem("switched", JSON.stringify($scope.val));
	        	});

	        	$scope.val = JSON.parse(localStorage.getItem("switched"));

	        	

	        	$scope.showMenu = function(){

			        $('#app-container').toggleClass('push-right');

	        	}

	        	


	        	$scope.changeTheme = function(setTheme){

					$('<link>')
					  .appendTo('head')
					  .attr({type : 'text/css', rel : 'stylesheet'})
					  .attr('href', 'styles/app-'+setTheme+'.css');
					  console.log('hey');

					// $.get('/api/change-theme?setTheme='+setTheme);

				}
	        }
    	}
	});



angular.module('topnav', ['angular.css.injector', 'auth'])
.controller('topnavCtrl', function ($scope, $http, auth, cssInjector) {
		console.log("-------------------- menuCtrl --------------------");
		$scope.user= {};
		$scope.level ={};

		//Get user details
		$http({
			method: 'GET', 
			url : '/profile'
		}).then(function successCallback(response) {

			$scope.user = response.data;
			
			console.log($scope.user);
			
			
		  }, function errorCallback(response) {
				console.log(data, status, header, config);
		  });
		
		

	});

