package fil.iagl.cookorico.dao;

import org.apache.ibatis.annotations.Param;

//import fil.iagl.cookorico.entity.Member;
import fil.iagl.cookorico.entity.Picture;

public interface PictureDao {
	
	/**
	   * Sauvegarde une image en base de donnée ( son path )
	   * 
	   * @param image l'image à sauvegarder
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
	   * @param idImage l'id de l'image
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

}
