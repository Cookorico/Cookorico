angular.module('cookorico').directive('ccRecipe', function(){
   return {
       restrict: 'E',
       templateUrl: 'js/recipe/template/recipeThumbnail.html',
       scope: {
            recipe : '='
       },
       controller: function($scope){

       }
   }
});