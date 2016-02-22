package fil.iagl.cookorico.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fil.iagl.cookorico.dao.ProducerDao;
import fil.iagl.cookorico.entity.Producer;
import fil.iagl.cookorico.service.ProducerService;

@Service
public class ProducerServiceImpl implements ProducerService {

	@Autowired
	private ProducerDao producerdao;
	
	@Override
	public void addProducer(Producer producer) {
		producerdao.addProducer(producer);
	}

	@Override
	public void deleteProducer(Producer producer) {
		producerdao.deleteProducer(producer);
		
	}

	@Override
	public List<Producer> getAllProducers() {
		return  producerdao.getAllProducers();
	}

	@Override
	public List<Producer> getProducersByIngredient(int idIngredient) {
		
		return producerdao.getProducersByIngredient(idIngredient);
	}

	@Override
	public Producer getProducerById(int idProducer) {
		
		return producerdao.getProducerById(idProducer);
	}

	@Override
	public List<Producer> getRandomProducers(int nb) {
		return producerdao.getRandomProducers(nb);
	}
	
	public void addProduct(int id_ingredient, int id_producer){
		producerdao.addIngredientOfProduct(id_ingredient, id_producer);
	}
}
