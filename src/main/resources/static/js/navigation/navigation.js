/**
 * Created by leemans on 03/11/15.
 */
cookorico.controller(
    'navigation',

    function($scope, $route, $uibModal, cssInjector, $state) {

        cssInjector.add("bower_components/freelancer/freelancer.css");
        cssInjector.add("bower_components/freelancer/custom.css");

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

cookorico.controller('ModalInstanceCtrl', function ($scope, $route, $uibModalInstance, auth, cssInjector) {

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
                console.log("Login succeeded")
                $scope.error = false;
                cssInjector.removeAll();
                $uibModalInstance.dismiss('cancel');
            } else {
                console.log("Login failed")
                $scope.error = true;
            }
        })
    };

    $scope.logout = auth.clear;

    $scope.cancel = function () {
        $uibModalInstance.dismiss('cancel');
    };
});