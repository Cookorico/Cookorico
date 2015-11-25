package fil.iagl.cookorico.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import fil.iagl.cookorico.entity.Ingredient;

public interface IngredientService {

	boolean addIngredient(@Param("ingredient") Ingredient ingredient);
	
	List<Ingredient> getAllIngredients();
	
	List<Ingredient> getAllIngredientsWithTags();
	
	Ingredient getIngredientById(int idIngredient);
	
	boolean deleteIngredient(@Param("ingredient") Ingredient ingredient); 
	
}