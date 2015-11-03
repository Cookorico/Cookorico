var cookorico = angular.module('cookorico', ['ngRoute'])
    .config(function ($routeProvider, $httpProvider) {

        $routeProvider.when('/', {
            templateUrl: 'home.html',
            controller: 'navigation'
        }).when('/login', {
            templateUrl: 'templates/login.html',
            controller: 'LoginController'
        }).otherwise('/');

        $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
});
