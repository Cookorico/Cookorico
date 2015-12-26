package fil.iagl.cookorico.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

@JsonSerialize
@Data
//@Alias("Picture")
public class PictureInRecipe {
	
	private Integer idPictureInRecipe;
	private Integer recipe;
	private Integer picture;
	private Integer comment;
}
