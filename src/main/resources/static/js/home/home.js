

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
		console.log($scope.slides)

		var log = [];
		angular.forEach($scope.slides, function(value, key) {
			if (value.mainPicture == undefined) {
				console.log("CHANGEEMENT PIC")
				value.mainPicture = {filePath: 'images/default-recipe-icon.png'}
			}
		}, log);

		console.log($scope.slides)

	}, function errorCallback(response) {
		console.log(data, status, header, config);
	});

	$http({
		method: 'GET',
		url: '/producers'
	}).then(function successCallback(response) {
		$scope.producers = response.data;
		console.log($scope.producers)


	}, function errorCallback(response) {
		console.log(data, status, header, config);
	});

});


