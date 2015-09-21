package fil.iagl.cookorico.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

@JsonSerialize
@Data
public class IngredientInRecipe {
	
	private int idIngredientInRecipe;
	private int ingredient;
	private int recipe;
	private int quantity;
	private String unitOfMeasurement; // TO DO ENUM
}
