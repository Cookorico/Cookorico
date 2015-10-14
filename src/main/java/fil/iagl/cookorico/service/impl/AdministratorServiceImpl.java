package fil.iagl.cookorico.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fil.iagl.cookorico.dao.AdministratorDao;
import fil.iagl.cookorico.entity.Member;
import fil.iagl.cookorico.service.AdministratorService;

public class AdministratorServiceImpl implements AdministratorService{
	
	@Autowired
	private AdministratorDao adminDao;
	
	public List<Member> getAllMember(){
		return adminDao.getAllMembers();
	}
	
	public int deleteMember(String username){
		return adminDao.deleteMember(username);
	}
}