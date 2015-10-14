package fil.iagl.cookorico.service;

import java.util.List;

import fil.iagl.cookorico.entity.Member;

public interface AdministratorService {

	public List<Member> getAllMember();
	
	public int deleteMember(String username);
}
