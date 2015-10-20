package fil.iagl.cookorico.wrapper;

import lombok.Data;

@Data
public class RegisterWrapper {
	
	private String firstName;
	private String lastName;
	private Character gender;
	private String city;
	private String email;
	private String username;
	private String password;

}
