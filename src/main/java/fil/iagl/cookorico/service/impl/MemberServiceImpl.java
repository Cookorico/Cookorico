package fil.iagl.cookorico.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import fil.iagl.cookorico.dao.MemberDao;
import fil.iagl.cookorico.entity.Member;
import fil.iagl.cookorico.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService{
	
	private MemberDao memberDao;
	
	public MemberServiceImpl(MemberDao memberDao) {
		this.memberDao = memberDao;
	}


	@Override
	public Member getMemberByUserName(String username) {
		return memberDao.getMemberWithUsername(username);
	}

	@Override
	public boolean addMember(Member member) {
		// check gender value is valid and the member username not yet exists
		if (memberDao.getMemberWithUsername(member.getUsername()) == null && Arrays.asList(new String[]{"M","F","U"}).contains(member.getGender())) {
			memberDao.addMember(member);
			return true;
		}
		return false;
	}
	
	public List<Member> getAllMembers(){
		return memberDao.getAllMembers();
	}
	
	public Member getMemberById(int id){
		return memberDao.getMemberById(id);
	}

}
