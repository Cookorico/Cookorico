package fil.iagl.cookorico.service;

import org.springframework.web.multipart.MultipartFile;

import fil.iagl.cookorico.entity.Picture;


public interface PictureService {

  /**
   * Sauvegarde l'image en base de donnée
   * 
   * @param image l'image à sauvegarder
   */
  Picture savePicture(MultipartFile image);
  
  /**
   * supprime l'image correspondant à l'objet
   * 
   * @param picture l'objet de l'image
   */
  void delete(Picture picture);

  /**
   * Recupere une image par son id
   * 
   * @param idImage l'id de l'image à recuperer
   * @return l'image contenant le path
   */
  Picture getPictureById(Integer idImage);

}