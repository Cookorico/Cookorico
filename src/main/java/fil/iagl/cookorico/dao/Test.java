package fil.iagl.cookorico.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import fil.iagl.cookorico.entity.User;

public interface Test {

	@Select("Select * from USER")
	public List<User> idlist();

}
