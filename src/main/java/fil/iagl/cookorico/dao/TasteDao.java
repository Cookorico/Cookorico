package fil.iagl.cookorico.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import fil.iagl.cookorico.entity.Ingredient;
import fil.iagl.cookorico.entity.Taste;
public interface TasteDao {

	List<Taste> getAllTaste();
	
	List<Taste> getTastesByMember(@Param("member") Integer id);
	
	boolean addTaste(@Param("taste") Taste taste, Ingredient ingredient);
	
	boolean deleteTaste(@Param("taste") Taste taste);
	
}
