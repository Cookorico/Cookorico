package fil.iagl.cookorico.entity;

import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

@JsonSerialize
@Data
public class Recipe {
	
	private Integer idRecipe;
	private String name;
	private String description;
	private Integer preparationTime;
	private Integer cookingTime;
	private Member creator;
	//private int fkCreator; //TEMPORAIRE. EN ATTENDANT DE GERER LES OBJETS ETC ON SAIT PAS FAIRE.
	private String dishType; //TO DO ENUM
	private int difficulty;
	private boolean draft;
	private Timestamp creationDate;
	private Timestamp modifDate;
	private Boolean validation;
	private Administrator validator;
	private Boolean disabled;
	private List<Tag> tags; // TO CHECK IF NOT NEW OBJECT, CREATION DATE IS MISSING.
	private List<RecipeStep> steps;
	private List<Photo> photos;
}
