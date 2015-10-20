package fil.iagl.cookorico.service;

import java.util.List;

import fil.iagl.cookorico.entity.Member;

public interface AdministratorService {

	List<Member> getAllMembers();
	
	int deleteMember(String username);
}
