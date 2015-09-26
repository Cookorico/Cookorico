package fil.iagl.cookorico.entity;


import java.sql.Timestamp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

@JsonSerialize
@Data
public class RecipeStep {
	
	private Integer idRecipeStep;
	private Recipe recipe;
	private Integer rank;
	private String name;
	private String description;
	private Integer durationTime;
	private Timestamp creationDate;
	private Timestamp modifDate;
	private Boolean disabled;
}
