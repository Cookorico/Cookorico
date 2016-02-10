package fil.iagl.cookorico.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import fil.iagl.cookorico.entity.Recipe;

public interface RecipeDao {

	/**
	 * Recuperation des recettes
	 * @return liste des recettes trouvées
	 */
	List<Recipe> getAllRecipes();
	
	
	List<Recipe> getAllRecipesByUserId(@Param("id") int id);
	
	/**
	 * Recuperation des recettes avec tous les pictures et les tags
	 * @return liste des recettes trouvées
	 */
	List<Recipe> getFullRecipes();
	
	/**
	 * Recuperation des recettes avec tous les tags uniquement
	 * @return liste des recettes trouvées
	 */
	List<Recipe> getAllRecipesWithTags();
	
	/**
	 * Recuperation des recettes avec tous les pictures uniquement
	 * @return liste des recettes trouvées
	 */
	List<Recipe> getAllRecipesWithMainPicture();
	
	Recipe getRecipeWithName(@Param("name") String name);
	
	/**
	 * Ajout recette dans la BDD
	 * @param recipe l'entité recette à sauvegarder
	 */
	void addRecipe(@Param("recipe") Recipe recipe);

	/**
	 * Recherche une recette par son id
	 * @param id L'id de la recette
	 * @return La recette trouvée
	 */
	Recipe getRecipeById(@Param("id") int id);

}
