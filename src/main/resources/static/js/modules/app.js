var cookorico = angular.module('cookorico', ['ngRoute'])
    .config(function ($routeProvider, $httpProvider) {

        $routeProvider.when('/', {
            templateUrl: 'home.html',
            controller: 'home'
        }).when('/login', {
            templateUrl: 'templates/login.html',
            controller: 'navigation'
        }).otherwise('/');

        $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';

    });