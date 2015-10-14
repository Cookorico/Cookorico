package fil.iagl.cookorico.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import fil.iagl.cookorico.entity.Recipe;

public interface RecipeDao {

	List<Recipe> getAllRecipes();
	
	Recipe getRecipeWithName(@Param("name") String name);
	
	void addRecipe(@Param("recipe") Recipe recipe);

	Recipe getRecipeById(@Param("id") int id);

}
