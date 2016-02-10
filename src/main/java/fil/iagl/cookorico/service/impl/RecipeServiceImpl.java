package fil.iagl.cookorico.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fil.iagl.cookorico.dao.IngredientInRecipeDao;
import fil.iagl.cookorico.dao.RecipeDao;
import fil.iagl.cookorico.entity.Recipe;
import fil.iagl.cookorico.service.RecipeService;

@Service
public class RecipeServiceImpl implements RecipeService{
    
    @Autowired
    private RecipeDao recipeDao;

    
	@Autowired
	private IngredientInRecipeDao ingredientInRecipeDao;
	
	/**
	 * Ajout recette dans la BDD
	 * @param recipe l'entité recette à sauvegarder
	 */
	@Override
	public void addRecipe(Recipe recipe) {
		recipeDao.addRecipe(recipe);
	}


    /**
	 * Recuperation des recettes
	 * @return liste des recettes trouvées
	 */
    @Override
    public List<Recipe> getAllRecipes() {
        return this.recipeDao.getAllRecipes();
    }

    /**
	 * Recuperation des recettes
	 * @param mainpic Si à true alors on recupère aussi les photos de la recette
	 * @param tags Si à true alors on recupère aussi les tags de la recette
	 * @return liste des recettes trouvées
	 */
    @Override
    public List<Recipe> getAllRecipes(boolean mainpic, boolean tags) {
        
        if(mainpic & tags) {
            return this.recipeDao.getFullRecipes();
        }
        
        if(mainpic) {
            return this.recipeDao.getAllRecipesWithMainPicture();
        }
        
        if(tags) {
            return this.recipeDao.getAllRecipesWithTags();
        }
        
        return this.recipeDao.getAllRecipes();
    }
    
    /**
	 * Recherche une recette par son id
	 * @param id L'id de la recette
	 * @return La recette trouvée
	 */
    @Override
    public Recipe getRecipeById(int id) {
        return this.recipeDao.getRecipeById(id);
    }


	@Override
	public List<Recipe> getRandomRecipes(int nb) {
		return this.recipeDao.getRandomRecipes(nb);
	}
}
