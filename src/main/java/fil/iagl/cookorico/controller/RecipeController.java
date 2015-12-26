package fil.iagl.cookorico.controller;

import java.util.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fil.iagl.cookorico.entity.CurrentUser;
import fil.iagl.cookorico.entity.Member;
import fil.iagl.cookorico.entity.Recipe;
import fil.iagl.cookorico.service.AdministratorService;
import fil.iagl.cookorico.service.PictureService;
import fil.iagl.cookorico.service.RecipeService;

@RestController
public class RecipeController {

	@Autowired
	private RecipeService recipeService;
	
	@Autowired
	private PictureService pictureServive;
	
	@Autowired
	AdministratorService administratorService;
	
	/**
	 * Recherche une recette par son id
	 * @param id L'id de la recette
	 * @return La recette trouvée
	 */
	@RequestMapping(value="/recipe/{id}", method = RequestMethod.GET)
	public @ResponseBody Recipe getRecipe(@PathVariable String id) {
		return recipeService.getRecipeById(Integer.parseInt(id));
	}
	
	/**
	 * Ajout en vitesse le 02/12, nom à check, utilisé dans recipectrl.
	 * @param id Id de la recette
	 * @return True si le user courrent est le créateur de la recette
	 */
	@RequestMapping(value="/recipe/{id}/currentUserIsCreator", method = RequestMethod.GET)
	public @ResponseBody Boolean currentUserIsCreator(@PathVariable String id) {
		
		Recipe recipe = recipeService.getRecipeById(Integer.parseInt(id));
		CurrentUser currentUser = (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    Member m = currentUser.getMember();
	    
	    return m.getIdMember() == recipe.getCreator().getIdMember();
	}
	
	/**
	 * Recuperation des recettes
	 * @param mainpic Si à true alors on recupère aussi les photos de la recette
	 * @param tags Si à true alors on recupère aussi les tags de la recette
	 * @return liste des recettes trouvées
	 */
	@RequestMapping(value="/recipes", method = RequestMethod.GET)
	public @ResponseBody List<Recipe> getListRecipe(@RequestParam(value = "mainpic", required = false) boolean mainpic, @RequestParam(value = "tags", required = false) boolean tags) {
		return recipeService.getAllRecipes(mainpic, tags);
	}
	
	/**
	 * Ajout recette dans la BDD
	 * @param model infos recette clé-valeur
	 * @return Recette créée
	 */
	@RequestMapping(value = "/recipe/add", method = RequestMethod.POST)
	public @ResponseBody Recipe addRecipe(@RequestBody ModelMap model){
		
		// get recipe form data
		int preparationTime = Integer.valueOf(String.valueOf(model.get("rcp_preparation_time")));
		int cookingTime = Integer.valueOf(String.valueOf(model.get("rcp_cooking_time")));
		int difficulty = Integer.valueOf(String.valueOf(model.get("rcp_difficulty")));
		int experienceVal = Integer.valueOf(String.valueOf(model.get("rcp_experienceVal")));
		String description = String.valueOf(model.get("rcp_description"));
		String name = String.valueOf(model.get("rcp_name"));
		String dish_type = String.valueOf(model.get("rcp_dish_type")); // TODO : vérifier valeur dans l'enum
		//int mainPictureId = Integer.valueOf(String.valueOf(model.get("mainPictureId")));
		
		Date date = new Date();
		Timestamp creationDate = new Timestamp(date.getTime());
		CurrentUser currentUser = (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    Member creator = currentUser.getMember();
	    
	    // create recipe entity
		Recipe recipe = new Recipe();
		recipe.setName(name);
		recipe.setDescription(description);
		recipe.setPreparationTime(preparationTime);
		recipe.setCookingTime(cookingTime);
		recipe.setCreator(creator);
		recipe.setDishType(dish_type);
		recipe.setDifficulty(difficulty);
		recipe.setDraft(false); // TODO : valeur par défaut ?
		//recipe.setMainPicture(this.pictureServive.getPictureById(mainPictureId));
		recipe.setCreationDate(creationDate);
		recipe.setModifDate(creationDate);
		recipe.setValidation(false);
		// TODO : recipe.SetValidator(integer)
		recipe.setDisabled(false);
		recipe.setExperienceVal(experienceVal); // TODO : à automatiser
		
		
		// save the recipe to bdd
		this.recipeService.addRecipe(recipe);
		
		return recipe;
	}	
}
