package fil.iagl.cookorico.dao;

import org.apache.ibatis.annotations.Param;

import fil.iagl.cookorico.entity.PictureInRecipe;

public interface PictureInRecipeDao {
	
	/**
	 * Associe une recette à une image
	 * 
	 * @param l'entité PictureInRecipe
	 */
	void associatePictureWithRecipe(@Param("pictureInRecipe") PictureInRecipe pictureInRecipe);
	
	/**
	   * supprime l'assocition par la clé de l'image
	   * 
	   * @param idPicture l'id de l'image
	   */
	void deleteByPictureId(@Param("idPicture") Integer idPicture);
	
	/**
	   * supprime l'assocition par la clé de la recette
	   * 
	   * @param idPicture l'id de l'image
	   */
	void deleteByRecipeId(@Param("idRecipe") Integer idRecipe);
}
