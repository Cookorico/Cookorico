/**
 * Angular module to manage recipe
 */
var recipeModule = angular.module('recipe', ['flash', 'ngAnimate', 'ngFileUpload']);

/**
 * Controller to show recipes list
 */
recipeModule.controller('RecipesCtrl', function($scope, $http) {
	
	$http.get('/recipes?mainpic=true').success(function(data, status, headers, config) {

		objects = data;

		for(var key in objects) {
			var value = objects[key];
		}

		$scope.recipes = data;
	}).error(function(data, status, headers, config) {
		
	});
});

/**
 * Conroller to save pictures
 */
recipeModule.controller('savePictureCtrl', ['$scope', 'Upload', '$modal', '$http', function ($scope, Upload, $modal, $http) {
	
	// initialize the images paths array
	$scope.images = new Array();
	
	// define function to show picture
	$scope.display = function (filePath) {
		var modalInstance = $modal.open({
            templateUrl: 'js/recipe/imagestemplate.html',
            controller: 'displayPicturesCtrl',
            resolve: {
            	path: function () {
                	return filePath;
                }
            },
			size: 300
	    });
	}
	
	// define function to delete a specified picture object
	$scope.deletePicture = function (picture) {
		
		var pictureJson = angular.toJson(picture);
		
		$http({
			method: 'POST', 
			url : '/picture/delete',
			data : pictureJson
		}).success(function(data, status, header, config){
			
			// TODO : remove element from DOM
			$( "#" + picture.fileName ).remove();
		}).error(function(data, status, header, config){
			console.log('error');
		});
	}
	
	// define function to upload picture file
    $scope.upload = function (files) {
    	
        if (files && files.length) {
        	
            for (var i = 0; i < files.length; i++) {
                
            	var file = files[i];
                
                Upload.upload({
                    url: '/picture',
                    data: {file: file}
                }).success(function (data, status, headers, config) {
                	$scope.images = $scope.images.concat([data]);
                });
                
                
                /*Upload.upload({
                    url: 'https://angular-file-upload-cors-srv.appspot.com/upload',
                    fields: {
                        'username': $scope.username
                    },
                    file: file
                }).progress(function (evt) {
                    var progressPercentage = parseInt(100.0 * evt.loaded / evt.total);
                    $scope.log = 'progress: ' + progressPercentage + '% ' +
                                evt.config.file.name + '\n' + $scope.log;
                }).success(function (data, status, headers, config) {
                    $scope.log = 'file ' + config.file.name + 'uploaded. Response: ' + JSON.stringify(data) + '\n' + $scope.log;
                    $scope.$apply();
                });*/
            }
        }
    };
}]);

/**
 * Controller to display image by modal
 */
recipeModule.controller('displayPicturesCtrl', ['$scope', 'path', '$modalInstance', function($scope, path, $modalInstance){
    
    $scope.path = path;
    
    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
    };
    
}]);

/**
 * Controller to add new recipe
 */
recipeModule.controller('addRecipeCtrl', ['$scope','$window', '$location','$http','Flash',  function ($scope, $window, $location, $http, Flash) {

	//Function to add a new recipe
	$scope.add = function () {
		
		//Set the value of experienceVal
		$scope.recipe.rcp_experienceVal = parseInt($scope.recipe.rcp_difficulty) * 10;
		
		var recipe = angular.toJson($scope.recipe);

		// send recipe to the recipe controller
		$http({
			method: 'POST', 
			url : '/recipe/add',
			data : recipe
		}).success(function(data, status, header, config){
			Flash.create('success', 'Votre nouvelle recette a été bien ajoutée !');
			$window.location.href = '#/dashboard/recipe/'+data.idRecipe+'/addstep';
		}).error(function(data, status, header, config){
			Flash.create('danger', 'Suite à une erreur votre recette n\'a pas pu être sauvegardée');
			$location.path('/dashboard/home');
		});
	};
}]);

/**
 * Controller to show a recipe content
 */
recipeModule.controller('RecipeCtrl',  ['$scope','$stateParams','$http', '$rootScope', function ($scope, $stateParams, $http, $rootScope, auth, cssInjector) {

	$http({
		method: 'GET', 
		url : '/recipe/'+$stateParams.idRecipe
	}).then(function successCallback(response) {
		$scope.recipe = response.data;
	}, function errorCallback(response) {
		console.error(data, status, header, config);
	});

	$http({
		method: 'GET', 
		url : '/recipe/'+$stateParams.idRecipe+'/currentUserIsCreator'
	}).then(function successCallback(response) {
		$scope.iscreator = response.data;
	}, function errorCallback(response) {
		console.error(data, status, header, config);
	});

	//Valider une recette
	$scope.doneRecipe = function(){
		console.log("DONE RECIPE");

		$scope.idUser;
		$rootScope.newXp;
		//Get user details
		$http({
			method: 'GET', 
			url : '/profile'
		}).then(function successCallback(response) {

			$scope.idUser = response.data.idMember;
			if($rootScope.newXp == null){
				$scope.newXp = response.data.experience + $scope.recipe.experienceVal;
				$rootScope.newXp = $scope.newXp;
			}else{
				$scope.newXp = $rootScope.newXp + $scope.recipe.experienceVal;
				$rootScope.newXp = $scope.newXp;
			}

			$http({
				method: 'GET', 
				url : '/level/xp/'+ $rootScope.newXp
			}).then(function successCallback(response){
				$rootScope.level = response.data;
			},function errorCallback(response) {
				console.error(data, status, header, config);
			});
		}, function errorCallback(response) {
			console.log(data, status, header, config);
		});
	}
}]);

/**
 * Controller to add a step of a specified recipe
 */
recipeModule.controller('addRecipeStepCtrl',  ['$scope','$window','$stateParams','$http', function ($scope, $window, $stateParams, $http, auth, cssInjector) {

	$http({
		method: 'GET', 
		url : '/recipe/'+$stateParams.idRecipe
	}).then(function successCallback(response) {
		$scope.recipe = response.data;
	}, function errorCallback(response) {
		console.log(data, status, header, config);
	});

	$scope.addStep = function () {

		$scope.recipestep.idRecipe = $stateParams.idRecipe;
		var recipestep = angular.toJson($scope.recipestep);

		$http({
			method: 'POST', 
			url : '/recipestep/add',
			data : recipestep
		}).success(function(data, status, header, config){
			$window.location.href = '#/dashboard/recipe/'+$stateParams.idRecipe;
		}).error(function(data, status, header, config){
		});
	};
}]);
