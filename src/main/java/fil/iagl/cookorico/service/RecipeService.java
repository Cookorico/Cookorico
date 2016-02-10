package fil.iagl.cookorico.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import fil.iagl.cookorico.entity.Recipe;

public interface RecipeService {

	/**
	 * Ajout recette dans la BDD
	 * @param recipe l'entité recette à sauvegarder
	 */
	void addRecipe(Recipe recipe);
	
	/**
	 * Recuperation des recettes
	 * @return liste des recettes trouvées
	 */
	List<Recipe> getAllRecipes();
	
	
	List<Recipe> getAllRecipesByUserId(@Param("id") int id);
	
	/**
	 * Recuperation des recettes
	 * @param mainpic Si à true alors on recupère aussi les photos de la recette
	 * @param tags Si à true alors on recupère aussi les tags de la recette
	 * @return liste des recettes trouvées
	 */
	List<Recipe> getAllRecipes(boolean mainpic, boolean tags);
	
	/**
	 * Recherche une recette par son id
	 * @param id L'id de la recette
	 * @return La recette trouvée
	 */
	Recipe getRecipeById(int id);
}
