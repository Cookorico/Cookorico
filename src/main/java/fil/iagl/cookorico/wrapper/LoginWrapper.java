package fil.iagl.cookorico.wrapper;

import org.springframework.beans.factory.annotation.Autowired;

import fil.iagl.cookorico.service.MemberService;
import lombok.Data;

@Data
public class LoginWrapper {
	


	public LoginWrapper() {
		
	}

	private String	username;
	private String	password;

}
