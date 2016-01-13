package fil.iagl.cookorico.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import fil.iagl.cookorico.entity.Member;

public interface MemberDao {

	List<Member> getAllMembers();
	
	Member getMemberWithCredentials(@Param("username") String username, @Param("password") String password);
	
	Member getMemberWithUsername(@Param("username") String username);
	
	void addMember(@Param("member") Member member);
	
	Member getMemberById(@Param("id") int id);

	void updateXpMember( int id,  int newXp);

	void updateXpMember(Map<String, Integer> parms);

}
