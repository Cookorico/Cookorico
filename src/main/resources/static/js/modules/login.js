'use strict';
    
    var loginModule = angular.module('Login-module', []);
    
    loginModule.controller('LoginController', ['$http', function ($http, username, password) {
    	this.user = {
                username : "",
                password : "",
                logged : false
            };

        this.login = function () {
            alert('login');
        };
        
        this.logout = function () {
            alert('logout')
        };
    
    
    }]);
 