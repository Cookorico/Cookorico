package fil.iagl.cookorico.service;

import fil.iagl.cookorico.entity.Member;

public interface MemberService {

	Member getMember(String username, String password);
	
	void addMember(Member member);
		
	
}
