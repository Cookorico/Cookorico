package fil.iagl.cookorico.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import fil.iagl.cookorico.entity.Taste;
public interface TasteDao {

	List<Taste> getAllTaste();
	
	List<Taste> getTastesByMember(Integer id);
	
	boolean addTaste(@Param("taste") Taste taste);
	
	boolean deleteTaste(@Param("taste") Taste taste);
	
	boolean updateTaste(@Param("taste") Taste taste);
	
}
