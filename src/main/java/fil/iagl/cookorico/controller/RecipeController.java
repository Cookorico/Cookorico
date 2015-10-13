package fil.iagl.cookorico.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fil.iagl.cookorico.entity.Recipe;
import fil.iagl.cookorico.service.MemberService;
import fil.iagl.cookorico.service.RecipeService;
import fil.iagl.cookorico.wrapper.RecipeWrapper;

@RestController
public class RecipeController {

	@Autowired
	RecipeService recipeService;
	
	
	@RequestMapping(value="/recipelist", method = RequestMethod.GET)
	public @ResponseBody List<Recipe> getListRecipe() {
		
		// USED TO TEST WITHOUT DATABASE
		/*List<Recipe> lst = new ArrayList();
		Recipe r1 = new Recipe();
		r1.setName("COUCOU 1");
		r1.setDescription("la description");
		Recipe r2 = new Recipe();
		r2.setName("Deuxieme recette");
		r2.setDescription("description de la deuxieme");		
		lst.add(r1);
		lst.add(r2);
		
		return lst;*/
		
		return recipeService.getAllRecipes();

	}
	
	
	@RequestMapping(value = "/addrecipe", method = RequestMethod.POST)
	public void addRecipe(@RequestBody RecipeWrapper wrapper){
		
		System.out.println(wrapper.getName());
		System.out.println(wrapper.getDescription());
		System.out.println(wrapper.getPreparation_time());
		System.out.println(wrapper.getCooking_time());
		
		
		Recipe recipe = new Recipe();
		recipe.setName(wrapper.getName());
		recipe.setDescription(wrapper.getDescription());
		recipe.setPreparationTime(wrapper.getPreparation_time());
		recipe.setCookingTime(wrapper.getCooking_time());
		recipe.setFkCreator(1);
		recipeService.addRecipe(recipe);
		
		
		System.out.println("UNE RECETTE A ETE AJOUTEE. VOICI LA LISTE DES RECETTES PRESENTES EN BASE DE DONNEES:");
		
		for(Recipe r : recipeService.getAllRecipes()){
			System.out.println(r.getName());
		}
		/*Recipe recipe = memberService.getMember(wrapper.getUsername(), wrapper.getPassword());
		System.out.println(recipe);*/
		//return member;
	}
	
}
