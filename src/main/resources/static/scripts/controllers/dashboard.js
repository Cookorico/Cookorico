'use strict';

angular.module('cookorico')
    .controller('DashboardCtrl', function ($scope, $state, cssInjector) {


        cssInjector.add("bower_components/fontawesome/css/fonts-awesome.css");
        cssInjector.add("bower_components/textAngular/src/textAngular.css");
        cssInjector.add("bower_components/fullcalendar/fullcalendar.css");
        cssInjector.add("bower_components/perfect-scrollbar/src/perfect-scrollbar.css");
        cssInjector.add("bower_components/angular-chart.js/dist/angular-chart.css");
        cssInjector.add("bower_components/c3/c3.css");
        cssInjector.add("bower_components/angular-loading-bar/build/loading-bar.css");
        cssInjector.add("bower_components/angular-growl-v2/build/angular-growl.css");
        cssInjector.add("styles/app-orange.css");


        $scope.$state = $state;

        $scope.date = new Date();
        $scope.eventSources = [];


    });
