angular.module('profile', []).controller('profile',
		function($scope, $http){

		$scope.user={
				pseudo: "Max",
				name :"Maxime",
				gender: "Masculin",
				email: "max@gmail.com",
				birthday:"15/12/1993",
				experience: "1235",
				level: "3"
		};

		

		}

);