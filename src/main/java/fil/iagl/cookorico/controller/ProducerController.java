package fil.iagl.cookorico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fil.iagl.cookorico.entity.Producer;
import fil.iagl.cookorico.service.ProducerService;

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
		return producerService.getProducersByIngredient(idIngredient);
	}
}