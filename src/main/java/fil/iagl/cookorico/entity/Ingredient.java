package fil.iagl.cookorico.entity;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;


@JsonSerialize
@Data
@Alias("IngredientInRecipe")
public class Ingredient {

	private Integer idIngredient;
	private String name;
	private String description;
	private Timestamp creationDate;
	private Timestamp modifDate;
	private boolean validation;
	private boolean disabled;
	private Picture mainPicture;
	private List<Tag> tags; // TO CHECK IF NOT NEW OBJECT, CREATION DATE IS MISSING.
	private List<Picture> photos;
	
	public Ingredient() {
	}
	
	public Ingredient(int idIng) {
		this.idIngredient = idIng;
	}
}
