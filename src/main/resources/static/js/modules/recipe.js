'use strict';
    var recipeModule = angular.module('Recipe-module', []);
    
    
    recipeModule.controller('ListRecipeController', ['$scope','$http', function ($scope, $http) {
    	
    	
    	$http({
    		method: 'GET', 
    		url : '/recipelist'
    	}).success(function(data, status, header, config){
    		$scope.recipes = data;
    	}).error(function(data, status, header, config){
    		console.log(data, status, header, config);
    	});
    	
    	
    	
    	/*this.recettes = [{
    			name : 'Coulée de lave',
    			description:'Cette recette est très brulante, attention !',
    			preparation_time: 45,
    			coocking_time: 120,
    			dish_type : 'hot',
    			creator: 'Vesuve'
    			},
    			{
        			name : 'Omelette',
        			description:'Baveuse ou pas. Au choix',
        			preparation_time: 45,
        			coocking_time: 120,
        			dish_type : 'hot',
        			creator: 'Vesuve'
        			}];
    	
    	this.test = function(){
    		alert("test");
    	};*/
        
    
    
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