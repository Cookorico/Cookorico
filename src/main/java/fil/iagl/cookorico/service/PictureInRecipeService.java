package fil.iagl.cookorico.service;

import fil.iagl.cookorico.entity.PictureInRecipe;

public interface PictureInRecipeService {

   /**
    * Associe une recette à une image
    * 
    * @param l'entité PictureInRecipe à sauvegarder
    */
	public void associatePictureWithRecipe(PictureInRecipe pictureInRecipe);
	
	/**
	   * supprime l'assocition par la clé de l'image
	   * 
	   * @param idPicture l'id de l'image
	   */
	void deleteByPictureId(Integer idPicture);
	
	/**
	   * supprime l'assocition par la clé de la recette
	   * 
	   * @param idPicture l'id de l'image
	   */
	void deleteByRecipeId(Integer idRecipe);
}