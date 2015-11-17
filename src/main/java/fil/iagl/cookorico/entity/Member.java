package fil.iagl.cookorico.entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

@JsonSerialize
@Data
@Alias("Member")
public class Member {

	private Integer idMember;
	private String username;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private Date birthday;
	private String gender;
	private String city;
	private Photo currentAvatar;
	private List<Photo> photosOfUser;
	private Timestamp creationDate;
	private Timestamp modifDate;
	private Boolean disabled;
	private Integer experience;
	private Integer level;

}
