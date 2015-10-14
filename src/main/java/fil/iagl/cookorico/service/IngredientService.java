package fil.iagl.cookorico.service;

import java.util.List;

import fil.iagl.cookorico.entity.Ingredient;

public interface IngredientService {

	void addIngredient(Ingredient recipe);
	
	List<Ingredient> getAllIngredients();
	
	Ingredient getIngredientById(int id);
	
}