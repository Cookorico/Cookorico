/**
 * Angular module to manage recipe
 */
var recipeModule = angular.module('recipe', ['flash', 'ngAnimate', 'ngFileUpload']);

/**
 * Controller to upload images by modal
 */
recipeModule.controller('galeryCtrl', ['$scope','$rootScope', 'Upload', '$modal', '$http', /*$modalInstance, */ function($scope, $rootScope, Upload, $modal, $http /*, $modalInstance*/) {
	
	// initialize variables
	if (typeof $rootScope.allItems == 'undefined') {
		$rootScope.allItems = new Array();
	}
	
	if (typeof $rootScope.notUploadedItems == 'undefined') {
		$rootScope.notUploadedItems = new Array();
	}
	
	if (typeof $rootScope.uploadedItems == 'undefined') {
		$rootScope.uploadedItems = new Array();
	}
	
	if (typeof $rootScope.picturesIdItems == 'undefined') {
		$rootScope.picturesIdItems = new Array();
	}
	
	if (typeof $rootScope.pictures == 'undefined') {
		$rootScope.pictures = new Array();
	}
	
	/*
	// close modal
	$scope.closeWindowsFn = function () {
        $modalInstance.dismiss('cancel');
    };
    */
    
    // define function to upload a multipart file
    $scope.uploadFileFn = function (files) {
    	
        if (files && files.length) {
            for (var i = 0; i < files.length; i++) {
            	
            	$rootScope.allItems = $rootScope.allItems.concat([files[i]]);
            	$rootScope.notUploadedItems = $rootScope.notUploadedItems.concat([files[i]]);
            }
        }

        // debug
        console.log('***function : uploadFileFn***')
        console.log('$rootScope.allItems = ');
    	console.log($rootScope.allItems);
    	console.log('$rootScope.notUploadedItems = ');
    	console.log($rootScope.notUploadedItems);
    	console.log('$rootScope.uploadedItems = ');
    	console.log($rootScope.uploadedItems);
    	console.log('$rootScope.picturesIdItems = ');
    	console.log($rootScope.picturesIdItems);
    	console.log('$rootScope.pictures = ');
    	console.log($rootScope.pictures);
    };
    
    // function to upload a file to server
    $scope.saveUploadFileFn = function (multipartFile) {
        
    	$scope.progress = 0
    	
    	Upload.upload({
            url: '/picture',
            data: {file: multipartFile}
        }).success(function (data, status, headers, config) {
        	
        	$rootScope.uploadedItems = $rootScope.uploadedItems.concat([multipartFile]);
        	$rootScope.picturesIdItems[data.idPicture] = multipartFile;
        	$rootScope.pictures[data.idPicture] = data;
        	$rootScope.notUploadedItems.splice($rootScope.notUploadedItems.indexOf(multipartFile), 1);

        	// debug
        	console.log('***function : uploadFileFn***')
            console.log('$rootScope.allItems = ');
        	console.log($rootScope.allItems);
        	console.log('$rootScope.notUploadedItems = ');
        	console.log($rootScope.notUploadedItems);
        	console.log('$rootScope.uploadedItems = ');
        	console.log($rootScope.uploadedItems);
        	console.log('$rootScope.picturesIdItems = ');
        	console.log($rootScope.picturesIdItems);
        	console.log('$rootScope.pictures = ');
        	console.log($rootScope.pictures);
        }).progress(function (evt) {
        	$scope.progress = Math.min(100, parseInt(100.0 * evt.loaded / evt.total));
        });
    }
    
    // function to show a picture
	$scope.displayFn = function (multipartFile) {
		
		// debug
		console.log("***function : displayFn***");
		console.log('multipartFile = ');
		console.log(multipartFile);
		
		var modalInstance = $modal.open({
			
            templateUrl: 'js/recipe/imagestemplate.html',
            controller: 'displayPicturesCtrl',
            resolve: {
            	multipartFile: function () {
                	return multipartFile;
                }
            },
			size: 800
	    });
	};
	
	$scope.removeSavedFileFn = function(multipartFile) {
		
		var pictureIndex = $rootScope.picturesIdItems.indexOf(multipartFile);
		
		if (pictureIndex != -1) {
			
			picture = angular.toJson($rootScope.pictures[pictureIndex]);
			$rootScope.pictures.splice(pictureIndex, 1);
			
			// delete from server
			$http({
				method: 'POST', 
				url : '/picture/delete',
				data : picture
			}).success(function(data, status, header, config){
				
				var index = $rootScope.allItems.indexOf(multipartFile);
				console.log('allItems index = ' + index);
				
				if (index != -1) {
					$rootScope.allItems.splice(index, 1);
				}
				
				index = $rootScope.notUploadedItems.indexOf(multipartFile);
				console.log('notUploadedItems index = ' + index);
				
				if (index != -1) {
					$rootScope.notUploadedItems.splice(index, 1);
				}
				
				index = $rootScope.uploadedItems.indexOf(multipartFile);
				console.log('uploadedItems index = ' + index);
				
				if (index != -1) {
					$rootScope.uploadedItems.splice(index, 1);
				}
				
				console.log('picturesItems index = ' + pictureIndex);
				
				if (pictureIndex != -1) {
					$rootScope.picturesIdItems.splice(pictureIndex, 1);
				}
				
				// debug
				console.log('***function : removeSavedFileFn***');
		        console.log('$rootScope.allItems = ');
		    	console.log($rootScope.allItems);
		    	console.log('$rootScope.notUploadedItems = ');
		    	console.log($rootScope.notUploadedItems);
		    	console.log('$rootScope.uploadedItems = ');
		    	console.log($rootScope.uploadedItems);
		    	console.log('$rootScope.picturesIdItems = ');
		    	console.log($rootScope.picturesIdItems);
		    	console.log('$rootScope.pictures = ');
		    	console.log($rootScope.pictures);
			});
		} else {
			var index = $rootScope.allItems.indexOf(multipartFile);
			console.log('allItems index = ' + index);
			
			if (index != -1) {
				$rootScope.allItems.splice(index, 1);
			}
			
			index = $rootScope.notUploadedItems.indexOf(multipartFile);
			console.log('notUploadedItems index = ' + index);
			
			if (index != -1) {
				$rootScope.notUploadedItems.splice(index, 1);
			}
			
			// debug
			console.log('***function : removeSavedFileFn***');
	        console.log('$rootScope.allItems = ');
	    	console.log($rootScope.allItems);
	    	console.log('$rootScope.notUploadedItems = ');
	    	console.log($rootScope.notUploadedItems);
	    	console.log('$rootScope.uploadedItems = ');
	    	console.log($rootScope.uploadedItems);
	    	console.log('$rootScope.picturesIdItems = ');
	    	console.log($rootScope.picturesIdItems);
	    	console.log('$rootScope.pictures = ');
	    	console.log($rootScope.pictures);
		}
	};
	
	// function that delete all uploaded and unuploaded items
	$scope.removeAllItemsFn = function() {
		
		if ($rootScope.pictures.length > 0) {
			
			Object.keys($rootScope.pictures).forEach(function (idPicture) {
				$http({
					method: 'POST', 
					url : '/picture/delete',
					data : angular.toJson($rootScope.pictures[idPicture])
				}).success(function(data, status, header, config){
					
					$rootScope.allItems = [];
					$rootScope.notUploadedItems = [];
					$rootScope.uploadedItems = [];
					$rootScope.picturesIdItems = [];
					$rootScope.pictures = [];
					
					// debug
					console.log('***function : removeAllItemsFn***');
			        console.log('$rootScope.allItems = ');
			    	console.log($rootScope.allItems);
			    	console.log('$rootScope.notUploadedItems = ');
			    	console.log($rootScope.notUploadedItems);
			    	console.log('$rootScope.uploadedItems = ');
			    	console.log($rootScope.uploadedItems);
			    	console.log('$rootScope.picturesIdItems = ');
			    	console.log($rootScope.picturesIdItems);
			    	console.log('$rootScope.pictures = ');
			    	console.log($rootScope.pictures);
				});
			});
		} else {
			$rootScope.allItems = [];
			$rootScope.notUploadedItems = [];
			$rootScope.uploadedItems = [];
			$rootScope.picturesIdItems = [];
			
			// debug
			console.log('***function : removeAllItemsFn***');
	        console.log('$rootScope.allItems = ');
	    	console.log($rootScope.allItems);
	    	console.log('$rootScope.notUploadedItems = ');
	    	console.log($rootScope.notUploadedItems);
	    	console.log('$rootScope.uploadedItems = ');
	    	console.log($rootScope.uploadedItems);
	    	console.log('$rootScope.picturesIdItems = ');
	    	console.log($rootScope.picturesIdItems);
	    	console.log('$rootScope.pictures = ');
	    	console.log($rootScope.pictures);
		}
	};
	
	// function that save all unuploaded file to server
	$scope.saveAllUploadedItemsFn = function() {
		
		if ($rootScope.notUploadedItems.length != 0) {
			
			Object.keys($rootScope.notUploadedItems).forEach(function (key) {
				
				var multipartFile = $rootScope.notUploadedItems[key];
				
				Upload.upload({
		            url: '/picture',
		            data: {file: multipartFile}
		        }).success(function (data, status, headers, config) {
		        	
		        	$rootScope.uploadedItems = $rootScope.uploadedItems.concat([multipartFile]);
		        	$rootScope.picturesIdItems[data.idPicture] = multipartFile;
		        	$rootScope.pictures[data.idPicture] = data;
		        	$rootScope.notUploadedItems.splice($rootScope.notUploadedItems.indexOf(multipartFile), 1);   	
		        	
		        	// debug
					console.log('***function : saveAllUploadedItemsFn***');
			        console.log('$rootScope.allItems = ');
			    	console.log($rootScope.allItems);
			    	console.log('$rootScope.notUploadedItems = ');
			    	console.log($rootScope.notUploadedItems);
			    	console.log('$rootScope.uploadedItems = ');
			    	console.log($rootScope.uploadedItems);
			    	console.log('$rootScope.picturesIdItems = ');
			    	console.log($rootScope.picturesIdItems);
			    	console.log('$rootScope.pictures = ');
			    	console.log($rootScope.pictures);
		        });
			});
		}
	};
}]);

/**
 * Controller to display image by modal
 */
recipeModule.controller('displayPicturesCtrl', ['$scope', 'multipartFile', '$modalInstance', function($scope, multipartFile, $modalInstance){
    
	// debug
	console.log('***function : displayPicturesCtrl***');
	console.log('multipartFile');
	console.log(multipartFile)
	
    $scope.multipartFile = multipartFile;
    
    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
    };
}]);

/**
 * Controller to show recipes list
 */
recipeModule.controller('RecipesCtrl', function($scope, $http) {
	
	$http.get('/recipes?mainpic=true').success(function(data, status, headers, config) {
		$scope.recipes = data;
	}).error(function(data, status, headers, config) {
		console.log(data);
	});
});

/**
 * Conroller to manage carousel
 */
recipeModule.controller('carouselCtrl', ['$scope', '$rootScope', function ($scope, $rootScope) {
	
	$scope.interval = 4000;
	$scope.noWrapSlides = false;
	var slides = $scope.slides = [];
	
	$scope.addSlide = function(multipartFile) {
		slides.push({
			image: multipartFile,
			description: 'Petit descriptif'
	    });
	};
	
	if (typeof $rootScope.uploadedItems != 'undefined') {
		for (var i=0; i<$rootScope.uploadedItems.length; i++) {
			$scope.addSlide($rootScope.uploadedItems[i]);
		}
	}
}]);

/**
 * Conroller to save pictures
 */
recipeModule.controller('pictureCtrl', ['$scope', '$rootScope', 'Upload', '$modal', '$http', function ($scope, $rootScope, Upload, $modal, $http) {
	
	// define function to add photo
	$scope.galeryFn = function () {
		
		var modalInstance = $modal.open({
            templateUrl: 'js/recipe/galerytemplate.html',
            controller: 'galeryCtrl',
			size: 800
	    });
	};
	
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
	};

/*	
	// define function to delete a specified picture object
	$scope.deletePicture = function (picture) {
		
		var pictureJson = angular.toJson(picture);
		
		$http({
			method: 'POST', 
			url : '/picture/delete',
			data : pictureJson
		}).success(function(data, status, header, config){
			
			// remove related element deleted from DOM
			$("#img_" + picture.creationDate).remove();
			
			// remove element from array
			$scope.images = jQuery.grep($scope.images, function(value) {
		        return value != picture;
			});
			
			// update retained images
			picturesRetained = $scope.images;
			
		}).error(function(data, status, header, config){
			console.log(data);
		});
	};
*/
	
}]);

/**
 * Controller to add new recipe
 */
recipeModule.controller('addRecipeCtrl', ['$scope', '$rootScope', '$window', '$location', '$http', 'Flash',  function ($scope, $rootScope, $window, $location, $http, Flash) {
	
	$scope.infoDifficulteFn = function(value) {
	    $scope.experience = value * 10;
	    $scope.difficult = value;
	};
	
	//Function to add a new recipe
	$scope.addRecipeFn = function () {
		
		//Set the value of difficulty and experience
		if (typeof $scope.difficulty != 'undefined') {
			$scope.recipe.rcp_difficulty = $scope.difficulty;
		} else {
			$scope.recipe.rcp_difficulty = 0;
		}
		
		$scope.recipe.rcp_experienceVal = $scope.recipe.rcp_difficulty * 10;
		
		// set preparation time
		if (typeof $scope.preparation_time != 'undefined') {
			$scope.recipe.rcp_preparation_time = $scope.preparation_time.getHours() * 60 + $scope.preparation_time.getMinutes(); 
		} else {
			$scope.recipe.rcp_preparation_time = 0;
		}
		
		// set cooking time
		if (typeof $scope.cooking_time != 'undefined') {
			$scope.recipe.rcp_cooking_time = $scope.cooking_time.getHours() * 60 + $scope.cooking_time.getMinutes(); 
		} else {
			$scope.recipe.rcp_cooking_time = 0;
		}
		
		// Set main picture id
		if (typeof $rootScope.pictures != 'undefined' && $rootScope.pictures.length > 0) {
			
			Object.keys($rootScope.pictures).forEach(function(idPicture) {
				$scope.recipe.mainPictureId = idPicture;
			});
		}
		
		console.log('$scope.recipe = ');
		console.log($scope.recipe);
		
		// send recipe to the recipe controller
		$http({
			method: 'POST',
			url : '/recipe/add',
			data : angular.toJson($scope.recipe)
		}).success(function(data, status, header, config){
			
			console.log('data from add recipe');
			console.log(data);
			
			// associate images with recipe
			if (typeof $rootScope.pictures != 'undefined' && $rootScope.pictures.length > 0) {
				Object.keys($rootScope.pictures).forEach(function(key) {
					
					var picture = $rootScope.pictures[key];
					var associatedData = {
					    "idComment": 0,
					    "idPicture": picture.idPicture,
					    "idRecipe": data.idRecipe
					};
					
					// send data to the back-end controller
					$http({
						method: 'POST',
	                    url: '/pictureinrecipe/associate',
	                    data: angular.toJson(associatedData)
	                }).success(function (data, status, headers, config) {
	                	Flash.create('success', 'Votre nouvelle recette a été créée avec succès !');
	                }).error(function(data, status, header, config){
	        			Flash.create('danger', 'Suite à une erreur l\'association recette-photo n\a pas eu lieu');
	        		});
				});
			}
			
			// redirect to add recipe steps
			$window.location.href = '#/dashboard/recipe/'+data.idRecipe+'/addstep';
		}).error(function(data, status, header, config){
			
			// redirect to the home page
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