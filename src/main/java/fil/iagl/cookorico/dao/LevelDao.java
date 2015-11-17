package fil.iagl.cookorico.dao;

import org.apache.ibatis.annotations.Param;

import fil.iagl.cookorico.entity.Level;

public interface LevelDao {

	public Level getLevelByXp(@Param("xp") int xp);
	
	public Level getLevelById(@Param("id") int id);
}
