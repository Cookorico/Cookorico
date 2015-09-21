package fil.iagl.cookorico.entity;


import java.sql.Timestamp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

@JsonSerialize
@Data
public class RecipeStep {
	
	private int idRecipeStep;
	private Recipe recipe;
	private int rank;
	private String name;
	private String description;
	private int durationTime;
	private Timestamp creationDate;
	private Timestamp modifDate;
	private boolean disabled;
}
