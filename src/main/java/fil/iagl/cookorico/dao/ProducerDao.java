package fil.iagl.cookorico.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import fil.iagl.cookorico.entity.Producer;

public interface ProducerDao {
	
	void addProducer(@Param("Producer") Producer producer);
	
	void deleteProducer(@Param("Producer") Producer producer);
	
	Producer getProducerById(int idProducer);

	List<Producer> getAllProducers();
	
	List<Producer> getProducersByIngredient(int idIngredient);
	
	List<Producer> getRandomProducers(int nb);
	
	void addIngredientOfProduct(int id_ingredient, int id_producer);
}
