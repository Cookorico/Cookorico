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
	public void addIngredient(Ingredient recipe) {
	}

	@Override
	public List<Ingredient> getAllIngredients() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ingredient getIngredientById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
