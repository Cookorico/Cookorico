package fil.iagl.cookorico.wrapper;

import org.springframework.beans.factory.annotation.Autowired;

import fil.iagl.cookorico.service.impl.MemberServiceImpl;
import lombok.Data;

@Data
public class RecipeWrapper {
	


	public RecipeWrapper() {
		
	}

	private String name;
	private String description;
	private int	cooking_time;
	private int	preparation_time;

}
