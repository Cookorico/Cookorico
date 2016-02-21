

angular.module('cookorico').controller('carrouselCtrl', function ($scope, $http) {
	$scope.myInterval = 5000;
	$scope.noWrapSlides = false;

	var slides = $scope.slides = [];
	var producers = $scope.producers = [];


	$http({
		method: 'GET',
		url: '/recipeUne/3'
	}).then(function successCallback(response) {
		$scope.slides = response.data;

		var log = [];
		angular.forEach($scope.slides, function(value, key) {
			if (value.mainPicture == undefined) {
				value.mainPicture = {filePath: 'images/default-recipe-icon.png'}
			}
		}, log);


	}, function errorCallback(response) {
		console.log(data, status, header, config);
	});

	$http({
		method: 'GET',
		url: '/producerUne/3'
	}).then(function successCallback(response) {
		console.log(response);
		$scope.producers = response.data;

	}, function errorCallback(response) {
		console.log(data, status, header, config);
	});

});


