package fil.iagl.cookorico.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import fil.iagl.cookorico.entity.Producer;

public interface ProducerService {

	void addProducer(@Param("Producer") Producer producer);
	
	void deleteProducer(@Param("Producer") Producer producer);
	
	Producer getProducerById(int idProducer);

	List<Producer> getAllProducers();
	
	List<Producer> getProducersByIngredient(int idIngredient);

	List<Producer> getRandomProducers(int nb);
	
	void addIngredientOfProduct(Map<String, Integer> params);

}
