package fil.iagl.cookorico.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	/**
	 * recuperer tout les producteurs 
	 * @return
	 */
	@RequestMapping(value="/producers", method = RequestMethod.GET)
	public @ResponseBody List<Producer> getAllProducers(){
		return producerService.getAllProducers();
	}
	
	/**
	 * recuperer tout les producteurs 
	 * @return
	 */
	@RequestMapping(value="/producerUne/{nb}", method = RequestMethod.GET)
	public @ResponseBody List<Producer> getRandomProducers(@PathVariable int nb){
		return producerService.getRandomProducers(nb);
	}
	
	/**
	 * Recuperer les producteurs d'un ingredient
	 * @param idIngredient
	 * @return
	 */
	@RequestMapping(value="/producers/ingredient/{idIngredient}", method = RequestMethod.GET)
	public @ResponseBody List<Producer> getProducersByIngredient (@PathVariable int idIngredient){
		System.out.println("******* "+ idIngredient);
		return producerService.getProducersByIngredient(idIngredient);
	}
	
	/**
	 * Recuperer un producteur par son id
	 * @return
	 */
	@RequestMapping(value="/producer/{idProducer}", method = RequestMethod.GET)
	public @ResponseBody Producer getProducerById (@PathVariable int idProducer){
		return producerService.getProducerById(idProducer);
	}
	
	/**
	 * Ajouter un producteur
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/producer/add", method = RequestMethod.POST)
	public @ResponseBody Producer addProducer(@RequestBody ModelMap model){
		
		String description = String.valueOf(model.get("description"));
		String name = String.valueOf(model.get("name"));
		String city = String.valueOf(model.get("city"));
		
		Producer producer = new Producer();
		
		producer.setDescription(description);
		producer.setName(name);
		producer.setCity(city);
		
		producerService.addProducer(producer);
		return producer;
	}
	
	@RequestMapping(value = "/producer/addProduct/{id_ingredient}/{id_producer}", method = RequestMethod.POST)
	public void addProduct(@PathVariable int id_ingredient, @PathVariable int id_producer){
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("id_ingredient", id_ingredient);
		params.put("id_producer", id_producer);
		
		System.out.println("ingredient : " + id_ingredient);
		System.out.println("producer : " + id_producer);
		
		producerService.addIngredientOfProduct(params);
	}
}