package fil.iagl.cookorico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fil.iagl.cookorico.entity.Ingredient;
import fil.iagl.cookorico.service.IngredientService;
import fil.iagl.cookorico.wrapper.IngredientWrapper;

@RestController
public class IngredientController {

	
	@Autowired
	IngredientService ingredientService;
	
	
	@RequestMapping(value="/ingredient/list", method = RequestMethod.GET)
	public @ResponseBody List<Ingredient> getListIngredient() {
		
		return ingredientService.getAllIngredients();

	}
	@RequestMapping(value="/ingredient/list", method = RequestMethod.POST)
	public boolean addIngredientToList(@RequestBody IngredientWrapper wrapper){
		final String name = wrapper.getName();
		final String description = wrapper.getDescription();
		
		final Ingredient ingredient = new Ingredient();
		ingredient.setName(name);
		ingredient.setDescription(description);
		
		return ingredientService.addIngredient(ingredient);
		
	}
	@RequestMapping(value="/ingredient/delete", method = RequestMethod.DELETE)
	public boolean deleteIngredient(@RequestBody IngredientWrapper wrapper){
		final String name = wrapper.getName();
		
		final Ingredient ingredient = new Ingredient();
		
		ingredient.setName(name);
		
		return ingredientService.deleteIngredient(ingredient);
	}
		
	
}
