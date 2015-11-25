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
		// TODO Auto-generated method stub
		return ingredientdao.addIngredient(ingredient);
	}

	@Override
	public List<Ingredient> getAllIngredients() {
		// TODO Auto-generated method stub
		
		return ingredientdao.getAllIngredients();
	}
	
	@Override
	public List<Ingredient> getAllIngredientsWithTags(){
		
		return ingredientdao.getAllIngredientsWithTags();
	}

	@Override
	public Ingredient getIngredientById(int idIngredient) {
		// TODO Auto-generated method stub
		return ingredientdao.getIngredientById(idIngredient);
	}

	@Override
	public boolean deleteIngredient(Ingredient ingredient) {
		// TODO Auto-generated method stub
		return ingredientdao.deleteIngredient(ingredient);
	}
	
	
}
