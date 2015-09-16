package fil.iagl.cookorico.entity;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class User {
	
	private int id_user;
	private String username;
	private String firstname;
	private String lastname;
	private String email;
	private Date birthday;
	private char gender;
	private String city;

}
