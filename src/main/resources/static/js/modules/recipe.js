'use strict';
    var recipeModule = angular.module('Recette-module', []);
    
    
    recipeModule.controller('RecetteController', ['$scope','$http', function ($scope, $http) {
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
 
    
    recipeModule.controller('AddRecipeController', ['$scope','$http', function ($scope, $http) {
    	var recipe;
    	
    	this.add = function () {
    		
    		recipe = angular.toJson($scope.recipe);
        	console.log(recipe);

        	$http({
        		method: 'POST', 
        		url : '/addrecipe',
        		data : recipe
        	}).success(function(data, status, header, config){
        		console.log(data, status, header, config);
        	}).error(function(data, status, header, config){
        		console.log(data, status, header, config);
        	});
    		
        };
    
    
    }]);