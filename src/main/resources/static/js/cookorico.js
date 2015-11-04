/**
 * Created by leemans on 03/11/15.
 */
angular
    .module('cookorico', [ 'ngRoute', 'auth', 'home', 'message', 'navigation', 'recipe' ])
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
            }).when('/show', {
                templateUrl : 'js/recipe/recipe.html',
                controller : 'recipe'
            }).otherwise('/');

            $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';

        }).run(function(auth) {

    // Initialize auth module with the home page and login/logout path
    // respectively
    auth.init('/', '/login', '/logout');

});