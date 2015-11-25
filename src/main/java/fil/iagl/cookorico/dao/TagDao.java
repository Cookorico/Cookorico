package fil.iagl.cookorico.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import fil.iagl.cookorico.entity.Tag;

public interface TagDao {

	List<Tag> selectTagFromIngredient(@Param("id_ingredient") int id_ingredient);
}
