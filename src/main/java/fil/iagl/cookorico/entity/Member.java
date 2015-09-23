package fil.iagl.cookorico.entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Getter;
import lombok.Setter;

@JsonSerialize
@Getter
@Setter
public class Member {

	private int		idMember;
	private String	username;
	private String	firstname;
	private String	lastname;
	private String	email;
	private Date	birthday;
	private char	gender;
	private String	city;
	private Photo currentAvatar;
	private List<Photo> photosOfUser;
	private Timestamp creationDate;
	private Timestamp modifDate;
	private boolean disabled;

	public Member() {

	}
}
