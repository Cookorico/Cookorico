package fil.iagl.cookorico.entity;

import java.sql.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;


@JsonSerialize
@Data
public class Member {
	
	private int id_user;
	private String username;
	private String firstname;
	private String lastname;
	private String email;
	private Date birthday;
	private char gender;
	private String city;
}
