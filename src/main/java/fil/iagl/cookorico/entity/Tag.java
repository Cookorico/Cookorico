package fil.iagl.cookorico.entity;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

@JsonSerialize
@Data
@Alias("Tag")
public class Tag {
	
	private Integer idTag;
	private String name;
	private String tagType; //TO DO ENUM
	private Timestamp creationDate;
	private Timestamp creationDateTagToRecipe;
	private Timestamp creationDateTagToIngredient;
}
