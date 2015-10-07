(function () {
    'use strict';
    
    var app = angular.module('Login-module', []);
    
    app.controller('LoginController', ['$http', function ($http, username, password) {
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
    
  
})();
