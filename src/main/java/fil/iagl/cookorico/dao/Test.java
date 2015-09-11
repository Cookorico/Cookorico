package fil.iagl.cookorico.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;

public interface Test {

	@Select("Select id from test")
	public List<Integer> idlist();

}
