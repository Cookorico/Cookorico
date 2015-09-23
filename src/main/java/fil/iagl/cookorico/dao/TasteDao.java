package fil.iagl.cookorico.dao;


import java.util.List;

import fil.iagl.cookorico.entity.Taste;
public interface TasteDao {

	List<Taste> getTastesById(Integer id);
}
