package fil.iagl.cookorico.controller;

import fil.iagl.cookorico.entity.Ingredient;
import fil.iagl.cookorico.service.IngredientInRecipeService;
import fil.iagl.cookorico.service.IngredientService;
import fil.iagl.cookorico.wrapper.IngredientWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IngredientController {


    @Autowired
    IngredientService ingredientService;

    @Autowired
    IngredientInRecipeService ingredientInRecipeService;


    @RequestMapping(value = "/measurements", method = RequestMethod.GET)
    public
    @ResponseBody
    List<String> getAllMeasurement() {
        return ingredientInRecipeService.getAllMeasurements();
    }


    @RequestMapping(value = "/ingredients", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Ingredient> getAllIngredients(
            @RequestParam(value = "mainpic", required = false) boolean mainpic,
            @RequestParam(value = "tags", required = false) boolean tags) {
        return ingredientService.getAllIngredients(mainpic, tags);
    }


    @RequestMapping(value = "/ingredient/list", method = RequestMethod.POST)
    public boolean addIngredientToList(@RequestBody IngredientWrapper wrapper) {
        final String name = wrapper.getName();
        final String description = wrapper.getDescription();

        final Ingredient ingredient = new Ingredient();
        ingredient.setName(name);
        ingredient.setDescription(description);

        return ingredientService.addIngredient(ingredient);

    }
    
    
    @RequestMapping(value="/ingredients/producer/{idProducer}", method = RequestMethod.GET)
	public @ResponseBody List<Ingredient> getProducersByIngredient (@PathVariable int idProducer){
		return ingredientService.getIngredientsByProducer(idProducer);

    }
    
    
    @RequestMapping(value = "/ingredient/delete", method = RequestMethod.DELETE)
    public boolean deleteIngredient(@RequestBody IngredientWrapper wrapper) {
        final String name = wrapper.getName();

        final Ingredient ingredient = new Ingredient();

        ingredient.setName(name);

        return ingredientService.deleteIngredient(ingredient);
    }


}
