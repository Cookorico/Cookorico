/**
 * Created by leemans on 03/11/15.
 */
/*angular.module('taste').controller('taste', function($scope, $http) {
    $http.get('/resource/').success(function(data) {
        $scope.greeting = data;
    });
});*/

angular.module('taste').controller('maprogressionCtrl', ['$scope', '$timeout', function ($scope, $timeout) {

}]);

angular.module('taste').controller('ModalAddTasteCtrl', function ($scope, $modal, $log) {

	$scope.items = ['item1', 'item2', 'item3'];

	$scope.open = function (size) {

		var modalInstance = $modal.open({
			templateUrl: 'myModalContent.html',
			controller: 'ModalInstanceCtrl',
			size: size,
			resolve: {
				items: function () {
					return $scope.items;
				}
			}
		});

		modalInstance.result.then(function (selectedItem) {
			$scope.selected = selectedItem;
		}, function () {
			$log.info('Modal dismissed at: ' + new Date());
		});
	};
});

angular.module('taste').controller('ModalAddTasteInstanceCtrl', function ($scope, $modalInstance, items) {

	$scope.items = items;
	$scope.selected = {
			item: $scope.items[0]
	};

	$scope.ok = function () {
		$modalInstance.close($scope.selected.item);
	};

	$scope.cancel = function () {
		$modalInstance.dismiss('cancel');
	};
});