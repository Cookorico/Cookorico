angular.module('cookorico').directive('ccRecipe', function(){
   return {
       restrict: 'E',
       templateUrl: 'js/recipe/templates/recipeThumbnail.html',
       scope: {
            recipe : '='
       }
   }
});

angular.module('cookorico').directive('ccRecipesHeader', function(){
    return {
        restrict: 'E',
        templateUrl: 'js/recipe/templates/recipeFilter.html',
        controller: function($scope){
            $scope.typePlat = 'Plat';
        }
    }
});

angular.module('cookorico').directive('ccRecipeInfos', function(){
   return {
       restrict:'E',
       templateUrl: 'js/recipe/templates/recipeInfos.html',
       controller: function($scope){

       }
   }
});