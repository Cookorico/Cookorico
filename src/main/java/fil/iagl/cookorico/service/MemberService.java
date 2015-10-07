package fil.iagl.cookorico.service;

import org.springframework.beans.factory.annotation.Autowired;

import fil.iagl.cookorico.dao.MemberDao;
import fil.iagl.cookorico.entity.Member;

public class MemberService {
	
	@Autowired
	private MemberDao memberDao;
	
	public Member getMember(String username, String password) {
		return memberDao.getMemberWithCredentials(username, password);
	}
	
	public void addMember(Member member) {
		final String memberUsername = member.getUsername();
		if (memberDao.getMemberWithUsername(memberUsername) == null) {
			memberDao.addMember(member);
		}
	}

}
