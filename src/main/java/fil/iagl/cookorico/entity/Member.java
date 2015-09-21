package fil.iagl.cookorico.entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;


@JsonSerialize
@Data
public class Member {
	
	private int idMember;
	private String username;
	private String firstname;
	private String lastname;
	private String email;
	private Date birthday;
	private char gender;
	private String city;
	private int currentAvatar; //TO DO OBJET
	private Timestamp creationDate;
	private Timestamp modifDate;
	private boolean disabled;
	private List<Taste> tastes;
	
}







