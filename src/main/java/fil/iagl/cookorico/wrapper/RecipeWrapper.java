package fil.iagl.cookorico.wrapper;

import lombok.Data;

@Data
public class RecipeWrapper {

	public RecipeWrapper() {
	}

	private String name;
	private String description;
	private int	cookingTime;
	private int	preparationTime;
	private int experience_val;

}
