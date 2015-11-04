/**
 * Created by leemans on 03/11/15.
 */
angular
    .module('cookorico', [ 'ngRoute', 'auth', 'home', 'message', 'navigation', 'taste' ])
    .config(

        function($routeProvider, $httpProvider, $locationProvider) {

            $locationProvider.html5Mode(true);

            $routeProvider.when('/', {
                templateUrl : 'js/home/home.html',
                controller : 'home'
            }).when('/message', {
                templateUrl : 'js/message/message.html',
                controller : 'message'
            }).when('/login', {
                templateUrl : 'js/navigation/login.html',
                controller : 'navigation'
            }).when('/taste', {
                templateUrl : 'js/taste/taste.html',
                controller : 'taste'
            }).otherwise('/');

            $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';

        }).run(function(auth) {

    // Initialize auth module with the home page and login/logout path
    // respectively
    auth.init('/', '/login', '/logout');

});