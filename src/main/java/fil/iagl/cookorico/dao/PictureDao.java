package fil.iagl.cookorico.dao;

import fil.iagl.cookorico.entity.Picture;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//import fil.iagl.cookorico.entity.Member;

public interface PictureDao {
	
	/**
	   * Sauvegarde une image en base de donnée ( son path )
	   * 
	   * @param picture l'image à sauvegarder
	   * @return le nombre de ligne sauvegarder
	   */
	Integer savePicture(@Param("picture") Picture picture);
	
	/**
	   * supprime l'image correspondant à l'objet
	   * 
	   * @param picture l'objet de l'image
	   */
	void delete(@Param("picture") Picture picture);
	
	/**
	   * Recupere l'image d'id passé en parametre
	   * 
	   * @param idPicture l'id de l'image
	   * @return l'image
	   */
	Picture getPictureById(@Param("idPicture") Integer idPicture);
	
	/**
	   * Sauvegarde une image pour la table d'association des member
	   * 
	   * @param idImage l'id de l'image
	   * @param idOffre l'id du membre
	   * @return le nombre de ligne sauvegarder  
	   */
	// Integer saveForMember(@Param("idPicture") Integer idImage, @Param("idMember") Integer idMember);
	
	/**
	   * Supprime les images relatifs à un membre dans la table d'association uniquement
	   * 
	   * @param idOffre l'id du membre
	   * @return le nombre de ligne supprimer
	   */
	// Integer deleteForMember(@Param("idMember") Integer idMember);
	
	/**
	   * Supprime les images relatifs à un membre dans la table d'association uniquement
	   * 
	   * @param idOffre l'objet correspondant au membre
	   * @return le nombre de ligne supprimer
	   */
	// Integer deleteForMember(@Param("member") Member member);
	
	/*List<Picture> getAllPictures();
	
	Picture getMemberPicture(Member member);*/

	/**
	 * Recupere la liste d'images correspondantes a une recette
	 *
	 * @param recipeId l'id de la recette
	 * @return la liste d'images
	 */
	List<Picture> getPictureByRecipeId(@Param("idRecipe") Integer recipeId);
}
