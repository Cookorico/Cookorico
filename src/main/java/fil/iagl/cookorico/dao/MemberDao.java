package fil.iagl.cookorico.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;

import fil.iagl.cookorico.entity.Member;

public interface MemberDao {

	@Select("Select id_user from MEMBER")
	public List<Integer> idlist();
	
	@Select("Select * from MEMBER")
	public List<Member> completelist();
}
