package fil.iagl.cookorico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fil.iagl.cookorico.entity.Recipe;
import fil.iagl.cookorico.entity.RecipeStep;
import fil.iagl.cookorico.service.RecipeService;
import fil.iagl.cookorico.service.RecipeStepService;

@RestController
public class RecipeStepController {

	@Autowired
	private RecipeStepService recipeStepService;
		
	@RequestMapping(value = "/recipestep/add", method = RequestMethod.POST)
	public @ResponseBody RecipeStep addRecipeStep(@RequestBody ModelMap model){
		
		RecipeStep step = new RecipeStep();
		

		int idRecipe = Integer.valueOf(String.valueOf(model.get("idRecipe")));
		int durationTime = Integer.valueOf(String.valueOf(model.get("durationTime")));
		String description = String.valueOf(model.get("description"));
		String name = String.valueOf(model.get("name"));
		
		System.out.println(idRecipe+" "+durationTime+" "+description+" "+name);
		
		
		step.setRecipe(new Recipe(idRecipe));
		step.setDescription(description);
		step.setName(name);
		step.setDurationTime(durationTime);
		
		recipeStepService.addRecipeStep(step);
		return step;
	}
	
}
