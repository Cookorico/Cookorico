package fil.iagl.cookorico.service;

import java.util.List;
import fil.iagl.cookorico.entity.RecipeStep;

public interface RecipeStepService {
	
	RecipeStep getRecipeStepById(int id);
	
	List<RecipeStep> getRecipeStepByIdRecipe( int id);
	
	void addRecipeStep(RecipeStep recipeStep);


}
