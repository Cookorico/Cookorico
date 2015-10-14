package fil.iagl.cookorico.service;

import java.util.List;

import fil.iagl.cookorico.entity.Recipe;

public interface RecipeService {

	void addRecipe(Recipe recipe);
	
	List<Recipe> getAllRecipes();
	
	Recipe getRecipeById(int id);
	
}
