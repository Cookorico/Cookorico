package fil.iagl.cookorico.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fil.iagl.cookorico.dao.IngredientDao;
import fil.iagl.cookorico.entity.Ingredient;
import fil.iagl.cookorico.service.IngredientService;

@Service
public class IngredientServiceImpl implements IngredientService{

	@Autowired
	private IngredientDao ingredientdao;

	@Override
	public boolean addIngredient(Ingredient ingredient) {
		return ingredientdao.addIngredient(ingredient);
	}

	@Override
	public List<Ingredient> getAllIngredients() {
		return ingredientdao.getAllIngredients();
	}
	

	@Override
	/*
	 * can probably be improved to avoid 4 differents requests...?
	 */
	public List<Ingredient> getAllIngredients(boolean mainpic, boolean tags) {
		if(mainpic & tags){
			return ingredientdao.getFullIngredients();
		}
		else if(mainpic){
			return ingredientdao.getAllIngredientsWithMainPicture();
		}
		else if(tags){
			return ingredientdao.getAllIngredientsWithTags();
		}
		return ingredientdao.getAllIngredients();
	}
	
	
	@Override
	public List<Ingredient> getAllIngredientsWithTags(){
		
		return ingredientdao.getAllIngredientsWithTags();
	}

	@Override
	public Ingredient getIngredientById(int idIngredient) {
		return ingredientdao.getIngredientById(idIngredient);
	}

	@Override
	public boolean deleteIngredient(Ingredient ingredient) {
		return ingredientdao.deleteIngredient(ingredient);
	}

	
	
}
