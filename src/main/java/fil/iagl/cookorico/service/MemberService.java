package fil.iagl.cookorico.service;

import java.util.List;
import java.util.Map;

import fil.iagl.cookorico.entity.Member;

public interface MemberService {

	Member getMemberByUserName(String username);
	
	boolean addMember(Member member);
	
	List<Member> getAllMembers();
		
	Member getMemberById(int id);
	
	void updateXpMember(Map<String, Integer> parms);
}
