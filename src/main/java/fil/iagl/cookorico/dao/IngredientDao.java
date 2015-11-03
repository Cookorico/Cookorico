package fil.iagl.cookorico.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import fil.iagl.cookorico.entity.Ingredient;

public interface IngredientDao {
	
	List<Ingredient> getAllIngredients();
	
	Ingredient getIngredientById(int idIngredient);
	
	boolean deleteIngredient(@Param("ingredient") Ingredient ingredient);
	
	boolean addIngredient(@Param("ingredient") Ingredient ingredient);

}
