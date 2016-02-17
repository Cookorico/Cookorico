window.app_version = 2;

var cookorico = angular.module('cookorico', [
        'ngRoute',
        'auth',
        'profile',
        'producer',
        'progression',
        'ui.router',
        //'ngAnimate',
        'ui.bootstrap',
        //'textAngular',
        //'ui.calendar',
        'perfect_scrollbar',
        'angular-loading-bar'
        //'chart.js',
        //'angular-growl',
        //'gridshore.c3js.chart',
        //'growlNotifications',
        //'angular.css.injector'
    ])
    .config(['cfpLoadingBarProvider', function (cfpLoadingBarProvider) {
        cfpLoadingBarProvider.latencyThreshold = 5;
        cfpLoadingBarProvider.includeSpinner = true;
    }])
    .config(function ($stateProvider, $urlRouterProvider, $locationProvider, $httpProvider) {

        $locationProvider.html5Mode(false);
        $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';

        $urlRouterProvider.when('/dashboard', '/dashboard/home');
        $urlRouterProvider.otherwise('/dashboard');

        $stateProvider
            .state('accueil', {
                url: '/',
                templateUrl: 'js/navigation/login.html',
                controller: 'navigation'
            })

            .state('plain', {
                abstract: true,
                url: '',
                templateUrl: 'views/layouts/plain.html'
            })
            .state('boxed', {
                abstract: true,
                url: '',
                parent: 'plain',
                templateUrl: 'views/layouts/boxed.html'
            })
            .state('login', {
                url: '/login',
                parent: 'boxed',
                templateUrl: 'views/pages/login.html',
                controller: 'LoginCtrl'
            })
            .state('dashboard', {
                url: '/dashboard',
                parent: 'plain',
                templateUrl: 'views/layouts/dashboard.html',
                controller: 'DashboardCtrl'
            })
            .state('home', {
                url: '/home',
                parent: 'dashboard',
                templateUrl: 'js/home/home.html',
            })
            .state('progressbars', {
                url: '/ui-elements/progressbars',
                parent: 'dashboard',
                templateUrl: 'views/pages/dashboard/ui-elements/progressbar.html?v=' + window.app_version,
                controller: 'ProgressDemoCtrl'
            })
            .state('profile', {
                url: '/profile',
                parent: 'dashboard',
                templateUrl: 'views/pages/dashboard/profile.html?v=' + window.app_version,
                controller: 'profileCtrl'
            })
            .state('profileMember', {
                url: '/profile/:idMember',
                parent: 'dashboard',
                templateUrl: 'js/profile/profileMember.html?v=' + window.app_version,
                controller: 'profileMemberCtrl'
            })
            .state('404-page', {
                url: '/404-page',
                parent: 'boxed',
                templateUrl: 'views/pages/404-page.html?v=' + window.app_version,
                controller: 'LoginCtrl'
            })
            .state('progression', {
                url: '/progression',
                parent: 'dashboard',
                templateUrl: 'js/progression/progression.html'
            })
            .state('taste', {
                url: '/taste',
                parent: 'dashboard',
                templateUrl: 'js/taste/taste.html'
            })
            .state('recipes', {
                url: '/recipes',
                parent: 'dashboard',
                templateUrl: 'js/recipe/recipes.html',
                controller: 'RecipesCtrl'
            })
            .state('newrecipe', {
                url: '/newrecipe',
                parent: 'dashboard',
                templateUrl: 'js/recipe/newrecipe.html',
                controller: 'addRecipeCtrl'
            })
            .state('recipe', {
                url: '/recipe/:idRecipe',
                parent: 'dashboard',
                templateUrl: 'js/recipe/recipe.html',
                controller: 'RecipeCtrl'
            })
            .state('newrecipestep', {
                url: '/recipe/:idRecipe/addstep',
                parent: 'dashboard',
                templateUrl: 'js/recipe/newrecipestep.html',
                controller: 'addRecipeStepCtrl'
            })
            .state('producers', {
                url: '/producers',
                parent: 'dashboard',
                templateUrl: 'js/producer/producers.html',
                controller: 'ProducersCtrl'
            })
            .state('producer', {
                url: '/producer/:idProducer',
                parent: 'dashboard',
                templateUrl: 'js/producer/producer.html',
                controller: 'ProducerCtrl'
            });
    })
    .run(function (auth, $rootScope) {

        var switchValue = JSON.parse(localStorage.getItem("switched"));

        if (switchValue)
            $('body').addClass('box-section');

        auth.init("/dashboard/home", "/", "/logout");

        $rootScope.$on('$routeChangeStart', function (event, next, current) {
            console.debug("COUCOU");
        });


    });