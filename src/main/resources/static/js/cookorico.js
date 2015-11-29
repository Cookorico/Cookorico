/**
 * Created by leemans on 03/11/15.
 */

var cookoricoApp = angular.module('cookorico', [
        'ngRoute',
        'ui.router'
        //'auth',
        //'navigation',
        //'ngAnimate',
        //'ui.bootstrap',
        //'textAngular',
        //'ui.calendar',
        //'perfect_scrollbar',
        //'angular-loading-bar',
        //'angular.css.injector'
    ])
    .config(['cfpLoadingBarProvider', function (cfpLoadingBarProvider) {
        cfpLoadingBarProvider.latencyThreshold = 5;
        cfpLoadingBarProvider.includeSpinner = false;
    }])
    .config(function ($stateProvider, $urlRouterProvider, $locationProvider, $httpProvider) {

        $locationProvider.html5Mode(false);
        $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';

        $urlRouterProvider.when('/', '/home');
        $urlRouterProvider.otherwise('/');

        $stateProvider
            //.state('login', {
            //    url: '/login',
            //    templateUrl: 'js/navigation/login.html',
            //    controller: 'navigation'
            //})
            //
            //.state('plain', {
            //    abstract: true,
            //    url: '',
            //    templateUrl: 'views/layouts/plain.html'
            //})
            .state('boxed', {
                abstract: true,
                url: '',
                parent: 'plain',
                templateUrl: 'views/layouts/boxed.html'
            })
            .state('dashboard', {
                url: '/',
                parent: 'plain',
                templateUrl: 'views/layouts/dashboard.html',
                controller: 'DashboardCtrl'
            })
            .state('home', {
                url: '/home',
                parent: 'dashboard',
                templateUrl: 'views/pages/dashboard/home.html'
            });
            //.state('profile', {
            //    url: '/profile',
            //    parent: 'dashboard',
            //    templateUrl: 'views/pages/dashboard/profile.html',
            //    controller: 'profileCtrl'
            //})
            //.state('blank', {
            //    url: '/blank',
            //    parent: 'dashboard',
            //    templateUrl: 'views/pages/dashboard/blank.html'
            //})
            //.state('404-page', {
            //    url: '/404-page',
            //    parent: 'boxed',
            //    templateUrl: 'views/pages/404-page.html',
            //    controller: 'LoginCtrl'
            //})
            //.state('progression', {
            //    url: '/progression',
            //    parent: 'dashboard',
            //    templateUrl: 'views/pages/dashboard/maprogression.html',
            //    controller: 'maprogressionCtrl'
            //})
            //.state('taste', {
            //    url: '/taste',
            //    parent: 'dashboard',
            //    templateUrl: 'js/taste/taste.html'
            //})
            //.state('recipe', {
            //    url: '/recipe',
            //    parent: 'dashboard',
            //    templateUrl: 'js/recipe/recipe.html',
            //    controller: 'recipe'
            //})
            //.state('newrecipe', {
            //    url: '/newrecipe',
            //    parent: 'dashboard',
            //    templateUrl: 'js/recipe/newrecipe.html',
            //    controller: 'recipe'
            //});
    })
    .run(function () {

        var switchValue = JSON.parse(localStorage.getItem("switched"));

        if (switchValue)
            $('body').addClass('box-section');



    });