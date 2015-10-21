package fil.iagl.cookorico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fil.iagl.cookorico.entity.Ingredient;
import fil.iagl.cookorico.entity.Recipe;
import fil.iagl.cookorico.service.IngredientService;

@RestController
public class IngredientController {

	
	@Autowired
	IngredientService ingredientService;
	
	
	@RequestMapping(value="/ingredient/list", method = RequestMethod.GET)
	public @ResponseBody List<Ingredient> getListIngredient() {
		
		
		return ingredientService.getAllIngredients();

	}
}
