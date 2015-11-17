package fil.iagl.cookorico.service;

import java.util.List;

import fil.iagl.cookorico.entity.Member;

public interface MemberService {

	Member getMemberByUserName(String username);
	
	boolean addMember(Member member);
	
	List<Member> getAllMembers();
		
	Member getMemberById(int id);
}
