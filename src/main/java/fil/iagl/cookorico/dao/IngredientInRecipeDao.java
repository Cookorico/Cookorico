package fil.iagl.cookorico.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import fil.iagl.cookorico.entity.Ingredient;
import fil.iagl.cookorico.entity.IngredientInRecipe;
import fil.iagl.cookorico.entity.RecipeStep;

public interface IngredientInRecipeDao {
	
	List<IngredientInRecipe> getIngredientsInRecipeByIdRecipe();
	
	List<String> getAllMeasurements();
	
	void addIngredientInRecipe(@Param("ingredientInRecipe") IngredientInRecipe ingredientInRecipe);
}
