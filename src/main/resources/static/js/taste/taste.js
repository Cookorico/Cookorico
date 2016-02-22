angular.module('cookorico').directive('myEnter', function () {
    return function (scope, element, attrs) {
        element.bind("keydown keypress", function (event) {
            if (event.which === 13) {
                scope.$apply(function () {
                    scope.$eval(attrs.myEnter);
                });

                event.preventDefault();
            }
        });
    };
});

angular.module('cookorico').directive('autoFocus', function ($timeout) {
    return {
        restrict: 'AC',
        link: function (_scope, _element) {
            $timeout(function () {
                _element[0].focus();
            }, 0);
        }
    };
});

angular.module('cookorico').filter('orderObjectBy', function () {
    return function (items, field, reverse) {
        var filtered = [];
        angular.forEach(items, function (item) {
            filtered.push(item);
        });
        filtered.sort(function (a, b) {
            return (a[field] > b[field] ? 1 : -1);
        });
        if (reverse) filtered.reverse();
        return filtered;
    };
});

angular.module('cookorico').controller('tasteCtrl', ['$scope', '$http', function ($scope, $http) {

    $scope.order_item;
    $scope.order_reverse;
    $scope.button_order_alpha = 'A--Z';
    $scope.button_order_num = '0--10';
    $scope.show_delete_icon = false;

    $scope.taste = {
        'ingredients': []
    };

    $http({
        method: 'GET',
        url: '/ingredients?mainpic=true'
    }).success(function (data, status, headers, config) {
            $scope.bdd_taste = data;

//		    console.log($scope.bdd_taste);
        })
        .error(function (data, status, headers, config) {
            // TODO : erreur de récupération :(
        });

    $http({
        method: 'GET',
        url: '/tastes'
    }).success(function (data, status, headers, config) {
//		    $scope.taste = data;
            var ingredient;
            angular.forEach(data, function (value, key) {
                ingredient = value.ingredient;
                ingredient.grading = value.grading;
                $scope.taste.ingredients.push(ingredient);
            });
        })
        .error(function (data, status, headers, config) {
            // TODO : erreur de récupération :(
        });


    $scope.inputIngredient = '';

    $scope.findIngredient = function (ingredient) {
//		if(ingredient.name.toLowerCase().match($scope.inputIngredient.toLowerCase()))
//			console.log(ingredient.name.toLowerCase().match($scope.inputIngredient.toLowerCase()));
//		console.log($scope.inputIngredient.toLowerCase());
        return ingredient.name.toLowerCase().match($scope.inputIngredient.toLowerCase())
            && $scope.inputIngredient.length >= 1
            && $.inArray(ingredient.name.toLowerCase(), $scope.taste['ingredients']) == -1;
    };

    $scope.addPersonnalTaste = function (ingredient) {
        ingredient.name = ingredient.name.toLowerCase();
        $scope.taste['ingredients'].push(ingredient);
        //console.log($scope.taste['ingredients']);
        $('input[type="number"]:first').focus();
        $scope.inputIngredient = "";

    };

    $scope.sendUserTaste = function (ingredient) {
        console.log("ingredient sent !");
        var http_method = 'POST';
        if (ingredient.grading != undefined)
            http_method = 'PUT';
        ingredient.grading = $('input[type="number"]:first').val();
        $('input[type="number"]:first').remove();

        if (ingredient.grading != '') {
            $http({
                method: http_method,
                url: '/taste',
                data: {'idIngredient': ingredient.idIngredient, 'grading': ingredient.grading}
            }).success(function (data, status, headers, config) {
                    console.log("SUCCESS");
                    //			   console.log($scope.bdd_taste);
                })
                .error(function (data, status, headers, config) {
                    // TODO : erreur de récupération :(
                });
        }

    };

    $scope.updatePersonnalTaste = function (ingredient) {
        $http({
            method: 'PUT',
            url: '/taste',
            data: {'idIngredient': ingredient.idIngredient, 'grading': ingredient.grading}
        }).success(function (data, status, headers, config) {
                console.log("SUCCESS");
            })
            .error(function (data, status, headers, config) {
                // TODO : erreur de récupération :(
            });
    };

    $scope.sortByName = function () {

    };

    $scope.deletePersonnalTaste = function (ingredient) {
        //console.log($(this));
        var index;
        $http({
            method: 'DELETE',
            url: '/taste/' + ingredient.idIngredient,
        }).success(function (data, status, headers, config) {
                index = $scope.taste['ingredients'].indexOf(ingredient);
            })
            .error(function (data, status, headers, config) {
                // TODO : erreur de récupération :(
                console.log(data);
                console.log("not working :(");
            });

        $scope.taste['ingredients'].slice(index, 1);

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
