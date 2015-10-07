package fil.iagl.cookorico.wrapper;

import org.springframework.beans.factory.annotation.Autowired;

import fil.iagl.cookorico.service.impl.MemberServiceImpl;
import lombok.Data;

@Data
public class LoginWrapper {
	


	public LoginWrapper() {
		
	}

	private String	username;
	private String	password;

}
