package fil.iagl.cookorico.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import fil.iagl.cookorico.entity.Ingredient;
import fil.iagl.cookorico.entity.Taste;

public interface TasteService {
	
	public List<Taste> getAllTaste();
	
	public List<Taste> getTastesByMember(@Param("member") Integer id);
	
	public boolean addTaste(@Param("taste") Taste taste);
	
	public boolean deleteTaste(@Param("ingredient") Integer idIngredient, @Param("member") Integer idMember);

	public boolean updateTaste(@Param("taste") Taste taste);

}
