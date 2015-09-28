package fil.iagl.cookorico.entity;

import java.sql.Timestamp;
import java.util.List;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

@JsonSerialize
@Data
public class Ingredient {

	private Integer idIngredient;
	private String name;
	private String description;
	private Timestamp creationDate;
	private Timestamp modifDate;
	private boolean validation;
	private boolean disabled;
	private List<Tag> tags; // TO CHECK IF NOT NEW OBJECT, CREATION DATE IS MISSING.
	private List<Photo> photos;
	private Integer quantity; //can be null
	private String unitOfMeasurement; //can be null

}
