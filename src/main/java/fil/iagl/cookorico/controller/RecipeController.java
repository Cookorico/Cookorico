package fil.iagl.cookorico.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.sql.Timestamp;
import java.util.List;

import org.apache.catalina.connector.Request;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fil.iagl.cookorico.entity.Administrator;
import fil.iagl.cookorico.entity.CurrentUser;
import fil.iagl.cookorico.entity.Ingredient;
import fil.iagl.cookorico.entity.IngredientInRecipe;
import fil.iagl.cookorico.entity.Member;
import fil.iagl.cookorico.entity.Picture;
import fil.iagl.cookorico.entity.Recipe;
import fil.iagl.cookorico.entity.RecipeStep;
import fil.iagl.cookorico.entity.Tag;
import fil.iagl.cookorico.service.AdministratorService;
import fil.iagl.cookorico.service.IngredientInRecipeService;
import fil.iagl.cookorico.service.MemberService;
import fil.iagl.cookorico.service.RecipeService;
import fil.iagl.cookorico.service.RecipeStepService;

@RestController
public class RecipeController {

	@Autowired
	private RecipeService recipeService;
	
	@Autowired
	private IngredientInRecipeService ingredientInRecipeService;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	AdministratorService administratorService;
	
	
	@RequestMapping(value="/recipe/{id}", method = RequestMethod.GET)
	public @ResponseBody Recipe getRecipe(@PathVariable String id) {
		
		/* // USED TO TEST WITHOUT DATABASE
		Member createur = new Member();
		createur.setUsername("Jean-Pierre");
		Recipe r1 = new Recipe();
		r1.setName("Recette des chips salés");
		r1.setDescription("Attraper un paquet de chips, pincer les deux cotés avec chacun une main. En tirant vous ouvrirez le sachet. Puis déguster.");
		r1.setPreparationTime(30);
		r1.setCookingTime(5);
		r1.setCreator(createur);
		r1.setDifficulty("Facile");
		r1.setDishType("Apéro");
		return r1;*/
		System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		System.out.println("ID = "+id);
		System.out.println((Integer.parseInt(id)));
		System.out.println(recipeService.getRecipeById(Integer.parseInt(id)));
		return recipeService.getRecipeById(Integer.parseInt(id));
	}
	
	/*
	 * fonction ajouté en vitesse le 02/12, nom à check, utilisé dans recipectrl.
	 */
	@RequestMapping(value="/recipe/{id}/currentUserIsCreator", method = RequestMethod.GET)
	public @ResponseBody Boolean currentUserIsCreator(@PathVariable String id) {
		
		Recipe recipe = recipeService.getRecipeById(Integer.parseInt(id));
		CurrentUser currentUser = (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    Member m = currentUser.getMember();
	    
	    return m.getIdMember() == recipe.getCreator().getIdMember();
	}
	
	
	
	@RequestMapping(value="/recipes", method = RequestMethod.GET)
	public @ResponseBody List<Recipe> getListRecipe(
			@RequestParam(value = "mainpic", required = false) boolean mainpic, 
			@RequestParam(value = "tags", required = false) boolean tags) {
		/*
		// USED TO TEST WITHOUT DATABASE
		List<Recipe> lst = new ArrayList();
		Recipe r1 = new Recipe();
		r1.setIdRecipe(1);
		r1.setName("Recette des chips salés");
		r1.setDescription("Attraper un paquet de chips, pincer les deux cotés avec chacun une main. En tirant vous ouvrirez le sachet. Puis déguster.");
		Recipe r2 = new Recipe();
		r2.setIdRecipe(2);
		r2.setName("Deuxieme recette");
		r2.setDescription("description de la deuxieme");		
		lst.add(r1);
		lst.add(r2);
		
		return lst;
		List<Recipe> lst = recipeService.getAllRecipes();
		ystem.out.println(lst.size());
		for (Recipe recipe : lst) {
			System.out.println("RECETTE :");
			System.out.println(recipe.getCreator());
			System.out.println(recipe.getName());
		}*/
		
		return recipeService.getAllRecipes(mainpic, tags);

	}
	
	
	@RequestMapping(value = "/recipe/add", method = RequestMethod.POST)
	public @ResponseBody Recipe addRecipe(@RequestBody ModelMap model){
		

		/* ajoute les ingredients à la recette */
		List<LinkedHashMap> ingredientsReciped = (List<LinkedHashMap>) model.get("ingredients");
		List<IngredientInRecipe> ingredients = new ArrayList<IngredientInRecipe>();
		for(LinkedHashMap ingredient_in_recipe : ingredientsReciped){
			LinkedHashMap ingredient = (LinkedHashMap) ingredient_in_recipe.get("ingredient");
			int idIng = (int) ingredient.get("idIngredient");
			int quantity = (int) ingredient_in_recipe.get("quantity");
			String unit_of_measure = (String) ingredient_in_recipe.get("measurement");
			Ingredient ing = new Ingredient(idIng);
			IngredientInRecipe ingrInRecipe = new IngredientInRecipe();
			ingrInRecipe.setIngredient(ing);
			ingrInRecipe.setQuantity(quantity);
			ingrInRecipe.setUnitOfMeasurement(unit_of_measure);
			ingredients.add(ingrInRecipe);
			
		}
		
		
		
		// get form data
		int preparationTime = Integer.valueOf(String.valueOf(model.get("rcp_preparation_time")));
		int cookingTime = Integer.valueOf(String.valueOf(model.get("rcp_cooking_time")));
		int difficulty = Integer.valueOf(String.valueOf(model.get("rcp_difficulty")));
		int experienceVal = Integer.valueOf(String.valueOf(model.get("rcp_experienceVal")));
		String description = String.valueOf(model.get("rcp_description"));
		String name = String.valueOf(model.get("rcp_name"));
		String dish_type = String.valueOf(model.get("rcp_dish_type")); // TODO : vérifier valeur dans l'enum
		Date date = new Date();
		Timestamp creationDate = new Timestamp(date.getTime());
		CurrentUser currentUser = (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    Member creator = currentUser.getMember();
	    
	    
	    
	    // create recipe object
		Recipe recipe = new Recipe();
		recipe.setName(name);
		recipe.setDescription(description);
		recipe.setPreparationTime(preparationTime);
		recipe.setCookingTime(cookingTime);
		recipe.setCreator(creator);
		recipe.setDishType(dish_type);
		recipe.setDifficulty(difficulty);
		recipe.setDraft(false); // TODO : valeur par défaut ?
		// TODO : recipe.setPicture(integer)
		recipe.setCreationDate(creationDate);
		recipe.setModifDate(creationDate);
		recipe.setValidation(false);
		// TODO : recipe.SetValidator(integer)
		recipe.setDisabled(false);
		recipe.setExperienceVal(experienceVal); // TODO : à automatiser
		 
		recipe.setIngredients(ingredients);
		
		
		// save the recipe to db
		this.recipeService.addRecipe(recipe);
		
		//if well done, add ingredients in recipe to db
		for(IngredientInRecipe ingredient : recipe.getIngredients()){
			ingredient.setRecipe(new Recipe(recipe.getIdRecipe()));
			this.ingredientInRecipeService.addIngredientInRecipe(ingredient);
			ingredient.getIngredient().getIdIngredient();
		}
		
		return recipe;
	}
	
}
