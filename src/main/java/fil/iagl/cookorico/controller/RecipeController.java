package fil.iagl.cookorico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fil.iagl.cookorico.entity.Recipe;
import fil.iagl.cookorico.service.MemberService;
import fil.iagl.cookorico.service.RecipeService;
import fil.iagl.cookorico.wrapper.RecipeWrapper;

@RestController
public class RecipeController {

	@Autowired
	RecipeService recipeService;
	
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
