package fil.iagl.cookorico.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fil.iagl.cookorico.dao.MemberDao;
import fil.iagl.cookorico.entity.Member;
import fil.iagl.cookorico.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDao memberDao;
	
	@Override
	public Member getMember(String username, String password) {
		Member member = memberDao.getMemberWithCredentials(username, password);
		return member;
	}
	
	@Override
	public void addMember(Member member) {
		final String memberUsername = member.getUsername();
		if (memberDao.getMemberWithUsername(memberUsername) == null) {
			memberDao.addMember(member);
		}
	}
	
	public List<Member> getAllMembers(){
		return memberDao.getAllMembers();
	}

}
