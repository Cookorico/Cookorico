package fil.iagl.cookorico.entity;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

@JsonSerialize
@Data
@Alias("Ingredient")
public class IngredientInRecipe {
	
	private Integer idIngredientInRecipe;
	private Ingredient ingredient;
	private Recipe recipe;
	private Integer quantity; //can be null
	private String unitOfMeasurement; //can be null

}
