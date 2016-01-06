package fil.iagl.cookorico.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fil.iagl.cookorico.dao.IngredientDao;
import fil.iagl.cookorico.dao.IngredientInRecipeDao;
import fil.iagl.cookorico.entity.Ingredient;
import fil.iagl.cookorico.entity.IngredientInRecipe;
import fil.iagl.cookorico.service.IngredientInRecipeService;

@Service
public class IngredientInRecipeServiceImpl implements IngredientInRecipeService{
	
	@Autowired
	private IngredientInRecipeDao ingredientInRecipedao;
	
	@Override
	public List<String> getAllMeasurements() {
		// TODO Auto-generated method stub
		
		return ingredientInRecipedao.getAllMeasurements();
	}
	

	/*
	 * le choix a été fait ici de ne pas passer recetteId en argument mais de set recette de ingredient et d'utiliser
	 * recetteId de ingredient. Choix discutable.
	 */
	@Override
	public void addIngredientInRecipe(IngredientInRecipe ingredientInRecipe){
		ingredientInRecipedao.addIngredientInRecipe(ingredientInRecipe);
	}
}
