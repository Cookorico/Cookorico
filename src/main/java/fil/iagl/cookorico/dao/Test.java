package fil.iagl.cookorico.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import fil.iagl.cookorico.entity.Member;

public interface Test {

	@Select("Select * from USER")
	public List<Member> idlist();

}
