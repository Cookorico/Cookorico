package fil.iagl.cookorico.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fil.iagl.cookorico.dao.RecipeDao;
import fil.iagl.cookorico.entity.Recipe;
import fil.iagl.cookorico.service.RecipeService;

@Service
public class RecipeServiceImpl implements RecipeService{
	
	@Autowired
	private RecipeDao recipeDao;

	@Override
	public void addRecipe(Recipe recipe) {
		final String recipeName = recipe.getName();
		if (recipeDao.getRecipeWithName(recipeName) == null) {
			recipeDao.addRecipe(recipe);
		}
	}

	@Override
	public List<Recipe> getAllRecipes() {
		return recipeDao.getAllRecipes();
	}

}
