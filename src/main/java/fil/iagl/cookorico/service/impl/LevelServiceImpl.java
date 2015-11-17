package fil.iagl.cookorico.service.impl;

import org.springframework.stereotype.Service;

import fil.iagl.cookorico.dao.LevelDao;
import fil.iagl.cookorico.entity.Level;
import fil.iagl.cookorico.service.LevelService;

@Service
public class LevelServiceImpl implements LevelService{

	private LevelDao levelDao;
	
	@Override
	public Level getLevelByXP(int xp) {
		return levelDao.getLevelByXp(xp);
	}
	
	@Override
	public Level getLevelById(int id) {
		return levelDao.getLevelById(id);
	}

}
