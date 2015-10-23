package fil.iagl.cookorico.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import fil.iagl.cookorico.entity.Member;

public interface AdministratorDao {

	List<Member> getAllAdministrator();
	
}
