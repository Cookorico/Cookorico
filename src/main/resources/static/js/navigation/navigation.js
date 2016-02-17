cookorico.controller(
    'navigation',

    function($scope, $route, $uibModal, $state) {

        $scope.open = function (size) {

            var modalInstance = $uibModal.open({
                animation: true,
                templateUrl: 'myModalContent.html',
                controller: 'ModalInstanceCtrl',
                size: size
            });

            modalInstance.result.then(function (selectedItem) {
                $scope.selected = selectedItem;
            }, function () {
                $state.go('home');
                //window.location = '/dashboard';
            });
        };





    });

cookorico.controller('ModalInstanceCtrl', function ($scope, $route, $uibModalInstance, auth) {

    $scope.credentials = {};

    $scope.tab = function(route) {
        return $route.current && route === $route.current.controller;
    };

    $scope.authenticated = function() {
        return auth.authenticated;
    };

    $scope.login = function() {
        auth.authenticate($scope.credentials, function(authenticated) {
            if (authenticated) {
                $scope.error = false;
                $uibModalInstance.dismiss('cancel');
            } else {
                $scope.error = true;
            }
        })
    };

    $scope.logout = auth.clear;

    $scope.cancel = function () {
        $uibModalInstance.dismiss('cancel');
    };
});