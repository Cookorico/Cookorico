package fil.iagl.cookorico.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import fil.iagl.cookorico.entity.Ingredient;

public interface IngredientDao {
	
	List<Ingredient> getAllIngredients();
	
	Ingredient getIngredientById(int idIngredient);
	
	void deleteIngredient(@Param("ingredient") Ingredient ingredient);
	
	void addIngredient(@Param("ingredient") Ingredient ingredient);

}
