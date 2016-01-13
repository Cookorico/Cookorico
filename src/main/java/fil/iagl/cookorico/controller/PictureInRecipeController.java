package fil.iagl.cookorico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fil.iagl.cookorico.entity.PictureInRecipe;
import fil.iagl.cookorico.service.PictureInRecipeService;

@RestController
@RequestMapping("/pictureinrecipe")
public class PictureInRecipeController {

	@Autowired
	private PictureInRecipeService pictureInRecipeService;
	
	@RequestMapping(value = "/associate", method = RequestMethod.POST)
	public void save(@RequestBody ModelMap modelMap) {
		
		// create PictureInRecipe entity
		Integer idComment = (Integer.valueOf(String.valueOf(modelMap.get("idComment"))) == 0) ? null : Integer.valueOf(String.valueOf(modelMap.get("idComment")));
		Integer idPicture = Integer.valueOf(String.valueOf(modelMap.get("idPicture")));
		Integer idRecipe = Integer.valueOf(String.valueOf(modelMap.get("idRecipe")));
		
		PictureInRecipe pictureInRecipe = new PictureInRecipe();
		pictureInRecipe.setComment(idComment);
		pictureInRecipe.setPicture(idPicture);
		pictureInRecipe.setRecipe(idRecipe);
		
		this.pictureInRecipeService.associatePictureWithRecipe(pictureInRecipe);
	}
	
	@RequestMapping(value="/delete/recipe/{idRecipe}", method = RequestMethod.GET)
	public void deleteByRecipeId(@PathVariable Integer idRecipe) {
		this.pictureInRecipeService.deleteByRecipeId(idRecipe);
	}
	
	@RequestMapping(value="/delete/picture/{idPicture}", method = RequestMethod.GET)
	public void deleteByPictureId(@PathVariable Integer idPicture) {
		this.pictureInRecipeService.deleteByPictureId(idPicture);
	}
}
