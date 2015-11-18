package fil.iagl.cookorico.service;

import fil.iagl.cookorico.entity.Level;

public interface LevelService {
	
	 Level getLevelByXP(int xp);
	 
	 Level getLevelById(int id);

}
