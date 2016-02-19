/**
 * Controller to upload images by modal
 */
angular.module('cookorico').controller('galeryCtrl', ['$scope', '$rootScope', 'Upload', '$uibModal', '$http', /*$modalInstance, */ function ($scope, $rootScope, Upload, $modal, $http /*, $modalInstance*/) {

    // initialize variables
    if (typeof $rootScope.allItems == 'undefined') {
        $rootScope.allItems = [];
    }

    if (typeof $rootScope.notUploadedItems == 'undefined') {
        $rootScope.notUploadedItems = [];
    }

    if (typeof $rootScope.uploadedItems == 'undefined') {
        $rootScope.uploadedItems = [];
    }

    if (typeof $rootScope.picturesIdItems == 'undefined') {
        $rootScope.picturesIdItems = [];
    }

    if (typeof $rootScope.pictures == 'undefined') {
        $rootScope.pictures = [];
    }

    /*
     // close modal
     $scope.closeWindowsFn = function () {
     $modalInstance.dismiss('cancel');
     };
     */

    // Define function to upload a multipart file
    $scope.uploadFileFn = function (files) {

        if (files && files.length) {
            for (var i = 0; i < files.length; i++) {

                $rootScope.allItems = $rootScope.allItems.concat([files[i]]);
                $rootScope.notUploadedItems = $rootScope.notUploadedItems.concat([files[i]]);
            }
        }

    };

    // function to upload a file to server
    $scope.saveUploadFileFn = function (multipartFile) {

        $scope.progress = 0;

        Upload.upload({
            url: '/picture',
            data: {file: multipartFile}
        }).success(function (data) {

            $rootScope.uploadedItems = $rootScope.uploadedItems.concat([multipartFile]);
            $rootScope.picturesIdItems[data.idPicture] = multipartFile;
            $rootScope.pictures[data.idPicture] = data;
            $rootScope.notUploadedItems.splice($rootScope.notUploadedItems.indexOf(multipartFile), 1);


        }).progress(function (evt) {
            $scope.progress = Math.min(100, parseInt(100.0 * evt.loaded / evt.total));
        });
    };

    // function to show a picture
    $scope.displayFn = function (multipartFile) {


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

    $scope.removeSavedFileFn = function (multipartFile) {

        var pictureIndex = $rootScope.picturesIdItems.indexOf(multipartFile);

        if (pictureIndex != -1) {

            picture = angular.toJson($rootScope.pictures[pictureIndex]);
            $rootScope.pictures.splice(pictureIndex, 1);

            // delete from server
            $http({
                method: 'POST',
                url: '/picture/delete',
                data: picture
            }).success(function (data, status, header, config) {

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

        }
    };

    // function that delete all uploaded and unuploaded items
    $scope.removeAllItemsFn = function () {

        if ($rootScope.pictures.length > 0) {

            Object.keys($rootScope.pictures).forEach(function (idPicture) {
                $http({
                    method: 'POST',
                    url: '/picture/delete',
                    data: angular.toJson($rootScope.pictures[idPicture])
                }).success(function (data, status, header, config) {

                    $rootScope.allItems = [];
                    $rootScope.notUploadedItems = [];
                    $rootScope.uploadedItems = [];
                    $rootScope.picturesIdItems = [];
                    $rootScope.pictures = [];

                });
            });
        } else {
            $rootScope.allItems = [];
            $rootScope.notUploadedItems = [];
            $rootScope.uploadedItems = [];
            $rootScope.picturesIdItems = [];

        }
    };

    // function that save all unuploaded file to server
    $scope.saveAllUploadedItemsFn = function () {

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


                });
            });
        }
    };
}]);

/**
 * Controller to display image by modal
 */
angular.module('cookorico').controller('displayPicturesCtrl', ['$scope', 'multipartFile', '$modalInstance', function ($scope, multipartFile, $modalInstance) {

    $scope.multipartFile = multipartFile;

    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
    };
}]);



/**
 * Conroller to manage carousel
 */
angular.module('cookorico').controller('carouselCtrl', ['$scope', '$rootScope', function ($scope, $rootScope) {

    $scope.interval = 4000;
    $scope.noWrapSlides = false;
    var slides = $scope.slides = [];

    $scope.addSlide = function (multipartFile) {
        slides.push({
            image: multipartFile,
            description: 'Petit descriptif'
        });
    };

    if (typeof $rootScope.uploadedItems != 'undefined') {
        for (var i = 0; i < $rootScope.uploadedItems.length; i++) {
            $scope.addSlide($rootScope.uploadedItems[i]);
        }
    }
}]);

/**
 * Conroller to save pictures
 */
angular.module('cookorico').controller('pictureCtrl', ['$scope', '$rootScope', 'Upload', '$uibModal', '$http', function ($scope, $rootScope, Upload, $modal, $http) {

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
}]);

/**
 * Controller to add new recipe
 */
angular.module('cookorico').controller('addRecipeCtrl', ['$scope', '$rootScope', '$window', '$location', '$http', 'Flash', function ($scope, $rootScope, $window, $location, $http, Flash) {


    $scope.ingredients = []; //liste de tous les ingredients de la bdd
    $scope.measurement = []; //liste des unité de mesure possible (actuellement: gramme(s), litre(s), unité(s)).
    $scope.ingredients_in_recipe = []; //liste des ingrédients dans la recette (bindé au form front)


    //ajoute un ingredient vide dans la liste (et donc crée dans le form une new ligne vide).
    $scope.add_ingredient = function () {
        $scope.ingredients_in_recipe.push({
            ingredient: $scope.ingredients[0],
            quantity: 0,
            measurement: $scope.measurement[0]
        });
    };

    $scope.remove_ingredient = function (index) {
        $scope.ingredients_in_recipe.splice(index, 1);
    };

    //charge la liste des ingredients
    $http({
        method: 'GET',
        url: '/ingredients'
    }).then(function successCallback(response) {
        $scope.ingredients = response.data;
    }, function errorCallback(response) {
        console.log(data, status, header, config);
    });

    //charge la liste des unités de mesure
    $http({
        method: 'GET',
        url: '/measurements'
    }).then(function successCallback(response) {
        $scope.measurements = response.data;
    }, function errorCallback(response) {
        console.log(data, status, header, config);
    });

    /**
     * Function to get difficulty and experience level info
     */
    $scope.infoDifficultyFn = function (value) {
        $scope.experience = value * 10;
        $scope.difficulty = value;
        $scope.mouse = value;
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
        $scope.recipe.ingredients = $scope.ingredients_in_recipe;


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

            Object.keys($rootScope.pictures).forEach(function (idPicture) {
                $scope.recipe.mainPictureId = idPicture;
            });
        }

        // send recipe to the recipe controller
        $http({
            method: 'POST',
            url: '/recipe/add',
            data: angular.toJson($scope.recipe)
        }).success(function (data, status, header, config) {

            console.log('data from add recipe');
            console.log(data);

            // associate images with recipe
            if (typeof $rootScope.pictures != 'undefined' && $rootScope.pictures.length > 0) {
                Object.keys($rootScope.pictures).forEach(function (key) {

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
                    }).error(function (data, status, header, config) {
                        Flash.create('danger', 'Suite à une erreur l\'association recette-photo n\a pas eu lieu');
                    });
                });
            }

            // show message and redirect to add recipe steps
            var message = '<strong> Opération réussie </strong>  Votre nouvelle recette a été créée avec succès. ';
            Flash.create('success', message, 'custom-class');
            $window.location.href = '#/dashboard/recipe/' + data.idRecipe + '/addstep';
        }).error(function (data, status, header, config) {

            // redirect to the home page
            Flash.create('danger', 'Suite à une erreur votre recette n\'a pas pu être sauvegardée');
            $location.path('/dashboard/home');
        });
    };
}]);

/**
 * Controller to show a recipe content
 */
angular.module('cookorico').controller('RecipeCtrl', ['$scope', '$stateParams', '$http', '$rootScope', function ($scope, $stateParams, $http, $rootScope, auth, cssInjector) {

    //get main infos
    $http({
        method: 'GET',
        url: '/recipe/' + $stateParams.idRecipe
    }).then(function successCallback(response) {
        $scope.recipe = response.data;

        $scope.myVar = 12;
        if ($scope.recipe.tags.length > 0) {
            $scope.myVar = 6;
        }

    }, function errorCallback(response) {
        console.error(data, status, header, config);
    });

    //get comments
    $http({
        method: 'GET',
        url: '/comments/recipe/' + $stateParams.idRecipe
    }).then(function successCallback(response) {
        $scope.recipe.comments = response.data;
        console.log($scope.recipe.comments);
    }, function errorCallback(response) {
        console.error(data, status, header, config);
    });


    $http({
        method: 'GET',
        url: '/recipe/' + $stateParams.idRecipe + '/currentUserIsCreator'
    }).then(function successCallback(response) {
        $scope.iscreator = response.data;
    }, function errorCallback(response) {
        console.error(data, status, header, config);
    });


    //Valider une recette
    $scope.doneRecipe = function () {

        $scope.idUser;
        $rootScope.newXp;

        //Get user details
        $http({
            method: 'GET',
            url: '/profile'
        }).then(function successCallback(response) {

            $scope.idUser = response.data.idMember;
            if ($rootScope.newXp == null) {
                $scope.newXp = response.data.experience + $scope.recipe.experienceVal;
                $rootScope.newXp = $scope.newXp;
            } else {
                $scope.newXp = $rootScope.newXp + $scope.recipe.experienceVal;
                $rootScope.newXp = $scope.newXp;
            }

            $http({
                method: 'GET',
                url: '/level/xp/' + $rootScope.newXp
            }).then(function successCallback(response) {
                $rootScope.level = response.data;
            }, function errorCallback(response) {
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
angular.module('cookorico').controller('addRecipeStepCtrl', ['$scope', '$window', '$stateParams', '$http', 'Flash', function ($scope, $window, $stateParams, $http, Flash, auth, cssInjector) {

    $http({
        method: 'GET',
        url: '/recipe/' + $stateParams.idRecipe
    }).then(function successCallback(response) {
        $scope.recipe = response.data;
    }, function errorCallback(response) {
        console.log(data, status, header, config);
    });

    $scope.addStep = function () {

        // set duration time
        if (typeof $scope.duration_time != 'undefined') {
            $scope.recipestep.durationTime = $scope.duration_time.getHours() * 60 + $scope.duration_time.getMinutes();
        } else {
            $scope.recipestep.durationTime = 0;
        }

        $scope.recipestep.idRecipe = $stateParams.idRecipe;

        $http({
            method: 'POST',
            url: '/recipestep/add',
            data: angular.toJson($scope.recipestep)
        }).success(function (data, status, header, config) {
            $window.location.href = '#/dashboard/recipe/' + $stateParams.idRecipe;
        }).error(function (data, status, header, config) {
        });
    };
}]);