var cookorico = angular.module('cookorico', ['ngRoute']);

cookorico.config(['$routeProvider', function ($routeProvider, $httpProvider) {

    $routeProvider.when('/', {
        templateUrl : 'home.html',
        controller : 'home'
    }).when('/login', {
        templateUrl : 'login.html',
        controller : 'navigation'
    }).otherwise('/');

    $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';

}
]);