package fil.iagl.cookorico.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import fil.iagl.cookorico.entity.RecipeStep;

public interface RecipeStepDao {
	
	RecipeStep getRecipeStepById(@Param("id") int id);
	
	List<RecipeStep> getRecipeStepByIdRecipe(@Param("id") int id);
	
	void addRecipeStep(@Param("recipeStep") RecipeStep recipeStep);


}
