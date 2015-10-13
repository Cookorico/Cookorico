'use strict';
    var recetteModule = angular.module('Recette-module', []);
    
    
    recetteModule.controller('RecetteController', ['$scope','$http', function ($scope, $http) {
    	this.recettes = [{
    			name : 'Coulée de lave',
    			description:'Cette recette est très brulante, attention !',
    			preparation_time: 45,
    			coocking_time: 120,
    			dish_type : 'hot',
    			creator: 'Vesuve'
    			}];
    	
    	this.test = function(){
    		alert("test");
    	};
        
    
    
    }]);
 