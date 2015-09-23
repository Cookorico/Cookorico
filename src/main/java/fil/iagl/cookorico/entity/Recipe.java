package fil.iagl.cookorico.entity;

import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

@JsonSerialize
@Data
public class Recipe {
	
	private int idRecipe;
	private String name;
	private String description;
	private int preparationTime;
	private int cookingTime;
	private Member creator;
	private String dish_type; //TO DO ENUM
	private String difficulty; //TO DO ENUM
	private Timestamp creationDate;
	private Timestamp modifDate;
	private boolean Validation;
	private Administrator validator;
	private boolean disabled;
	private List<Tag> tags; // TO CHECK IF NOT NEW OBJECT, CREATION DATE IS MISSING.
	private List<RecipeStep> steps;
	private List<Photo> photos;
}
