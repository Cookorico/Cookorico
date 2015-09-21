package fil.iagl.cookorico.dao;

import java.util.List;

import fil.iagl.cookorico.entity.Member;

public interface MemberDao {

	List<Integer> getMembersIds();
	
	List<Member> getAllMembers();

}
