package fil.iagl.cookorico.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import fil.iagl.cookorico.entity.Ingredient;

public interface IngredientDao {
	
	List<Ingredient> getAllIngredients();
	
	List<Ingredient> getFullIngredients();
	
	List<Ingredient> getAllIngredientsWithTags();

	List<Ingredient> getAllIngredientsWithMainPicture();

	
	Ingredient getIngredientById(Integer idIngredient);
	
	boolean deleteIngredient(@Param("ingredient") Ingredient ingredient);
	
	boolean addIngredient(@Param("ingredient") Ingredient ingredient);

}
