package fil.iagl.cookorico.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import fil.iagl.cookorico.entity.Ingredient;
import fil.iagl.cookorico.entity.Taste;

public interface TasteService {
	
	public List<Taste> getAllTaste();
	
	public List<Taste> getTastesByMember(@Param("member") Integer id);
	
	public boolean addTaste(@Param("taste") Taste taste, @Param("ingredient") Ingredient ingredient);
	
	public boolean deleteTaste(@Param("taste") Taste taste);

}
