var cookorico = angular.module('cookorico', ['ngRoute'])
    .config(function ($routeProvider, $httpProvider) {

        $routeProvider.when('/', {
            templateUrl: 'home.html',
            controller: 'homeCtlr'
        }).when('/authentication', {
            templateUrl: 'authentication.html',
            controller: 'navigationCtlr'
        }).when('/mainScreen', {
            templateUrl: 'AccueilLogged.html',
            controller: 'mainCtlr'
        }).otherwise('/');

        $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
});
