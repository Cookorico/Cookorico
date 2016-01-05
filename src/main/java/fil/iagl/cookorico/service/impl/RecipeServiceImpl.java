package fil.iagl.cookorico.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fil.iagl.cookorico.dao.RecipeDao;
import fil.iagl.cookorico.entity.Recipe;
import fil.iagl.cookorico.service.RecipeService;

@Service
public class RecipeServiceImpl implements RecipeService {
	
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

	@Override
	/*
	 * can probably be improved to avoid 4 differents requests...?
	 */
	public List<Recipe> getAllRecipes(boolean mainpic, boolean tags) {
		if(mainpic & tags){
			return recipeDao.getFullRecipes();
		}
		else if(mainpic){
			return recipeDao.getAllRecipesWithMainPicture();
		}
		else if(tags){
			return recipeDao.getAllRecipesWithTags();
		}
		return recipeDao.getAllRecipes();
	}
	
	
	@Override
	public Recipe getRecipeById(int id) {
		return recipeDao.getRecipeById(id);
	}

}
