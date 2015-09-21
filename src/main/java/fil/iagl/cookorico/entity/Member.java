package fil.iagl.cookorico.entity;

import java.sql.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;


@JsonSerialize
@Data
public class Member {
	
	private int idUser;
	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String salt;
	private Date birthday;
	private char gender;
	private String city;
	private int currentAvatar;
	private Date creationDate;
	private Date modifDate;
	private boolean disabled;
	
}
