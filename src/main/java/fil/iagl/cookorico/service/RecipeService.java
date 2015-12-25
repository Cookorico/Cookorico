package fil.iagl.cookorico.service;

import java.util.List;
import fil.iagl.cookorico.entity.Recipe;

public interface RecipeService {

	void addRecipe(Recipe recipe);
	
	List<Recipe> getAllRecipes();
	
	List<Recipe> getAllRecipes(boolean mainpic, boolean tags);
	
	Recipe getRecipeById(int id);
}
