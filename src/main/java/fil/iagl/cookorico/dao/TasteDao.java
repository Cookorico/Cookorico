package fil.iagl.cookorico.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import fil.iagl.cookorico.entity.Taste;
public interface TasteDao {

	List<Taste> getAllTaste();
	
	List<Taste> getTastesByMember(Integer id);
	
	boolean addTaste(@Param("taste") Taste taste);
	
	boolean deleteTaste(@Param("idIngredient") Integer idIngredient, @Param("idMember") Integer idMember);
	
	boolean updateTaste(@Param("taste") Taste taste);
	
}
