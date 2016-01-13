package fil.iagl.cookorico.service;

import java.util.List;

import fil.iagl.cookorico.entity.IngredientInRecipe;
import fil.iagl.cookorico.entity.RecipeStep;

public interface IngredientInRecipeService {


	public List<String> getAllMeasurements();
	
	public void addIngredientInRecipe(IngredientInRecipe ingredientInRecipe);
}
