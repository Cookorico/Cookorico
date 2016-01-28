package fil.iagl.cookorico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fil.iagl.cookorico.entity.Ingredient;
import fil.iagl.cookorico.entity.Producer;
import fil.iagl.cookorico.entity.Recipe;
import fil.iagl.cookorico.entity.RecipeStep;
import fil.iagl.cookorico.service.ProducerService;
import fil.iagl.cookorico.wrapper.IngredientWrapper;

@RestController
public class ProducerController {

	@Autowired
	ProducerService producerService;
	@RequestMapping(value="/producers", method = RequestMethod.GET)
	public @ResponseBody List<Producer> getAllProducers(){
		return producerService.getAllProducers();
	}
	
	@RequestMapping(value="/producer/{idIngredient}", method = RequestMethod.GET)
	public @ResponseBody List<Producer> getProducersByIngredient (@PathVariable int idIngredient){
		System.out.println("******* "+ idIngredient);
		return producerService.getProducersByIngredient(idIngredient);
	}
	
	@RequestMapping(value = "/producer/add", method = RequestMethod.POST)
	public @ResponseBody Producer addProducer(@RequestBody ModelMap model){
		
		Producer producer = new Producer();
		

		int idProducer = Integer.valueOf(String.valueOf(model.get("idProducer")));
		String description = String.valueOf(model.get("description"));
		String name = String.valueOf(model.get("name"));
		String city = String.valueOf(model.get("city"));
		
		System.out.println(idProducer+" "+description+" "+name);
		
		
		producer.setDescription(description);
		producer.setName(name);
		producer.setCity(city);
		
		producerService.addProducer(producer);
		return producer;
	}
	
}