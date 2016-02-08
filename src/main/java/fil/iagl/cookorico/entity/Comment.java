package fil.iagl.cookorico.entity;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

@JsonSerialize
@Data
public class Comment {

	private int idComment;
	private String title;
	private String description;
	private Member member; //why not creator ?!
	private Recipe recipe;
	private int validator;
	private boolean validation;
	private boolean disabled;
	private Timestamp creationDate;
	private Timestamp modifDate;
}
