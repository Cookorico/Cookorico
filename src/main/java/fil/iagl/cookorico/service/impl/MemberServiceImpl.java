package fil.iagl.cookorico.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
	
	@Override
	public void updateXpMember(Map<String, Integer> parms){
		memberDao.updateXpMember(parms);
		
	}

}
