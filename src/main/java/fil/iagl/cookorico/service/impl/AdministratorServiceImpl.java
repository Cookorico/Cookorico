package fil.iagl.cookorico.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fil.iagl.cookorico.dao.AdministratorDao;
import fil.iagl.cookorico.entity.Member;
import fil.iagl.cookorico.service.AdministratorService;

@Service
public class AdministratorServiceImpl implements AdministratorService{
	
	@Autowired
	private AdministratorDao adminDao;

	public List<Member> getAllAdministrator(){
		return adminDao.getAllAdministrator();
	}

}