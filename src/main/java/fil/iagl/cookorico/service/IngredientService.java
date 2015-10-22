package fil.iagl.cookorico.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import fil.iagl.cookorico.entity.Ingredient;

public interface IngredientService {

	void addIngredient(@Param("ingredient") Ingredient ingredient);
	
	List<Ingredient> getAllIngredients();
	
	Ingredient getIngredientById(int idIngredient);
	
	void deleteIngredient(@Param("ingredient") Ingredient ingredient); 
	
}