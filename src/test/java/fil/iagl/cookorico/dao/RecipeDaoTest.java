package fil.iagl.cookorico.dao;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;

import fil.iagl.cookorico.AbstractCookoricoTest;

@RunWith(Parameterized.class)
public class RecipeDaoTest extends AbstractCookoricoTest {
	
	@Autowired
	private RecipeDao recipeDao;

	public RecipeDaoTest() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

}
