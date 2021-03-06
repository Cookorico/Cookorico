package fil.iagl.cookorico.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fil.iagl.cookorico.dao.TasteDao;
import fil.iagl.cookorico.entity.Ingredient;
import fil.iagl.cookorico.entity.Taste;
import fil.iagl.cookorico.service.TasteService;

@Service
public class TasteServiceImpl implements TasteService{
	
	@Autowired
	private TasteDao tasteDao;

	@Override
	public List<Taste> getAllTaste() {
		return tasteDao.getAllTaste();
	}

	@Override
	public List<Taste> getTastesByMember(Integer id) {
		return tasteDao.getTastesByMember(id);
	}
	
	@Override
	public boolean deleteTaste(Integer idIngredient, Integer idMember) {
		return tasteDao.deleteTaste(idIngredient, idMember);
	}

	@Override
	public boolean addTaste(Taste taste) {
		return tasteDao.addTaste(taste);
	}

	@Override
	public boolean updateTaste(Taste taste) {
		return tasteDao.updateTaste(taste);
	}

}
