package fil.iagl.cookorico.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import fil.iagl.cookorico.AbstractCookoricoTest;
import fil.iagl.cookorico.dao.RecipeDao;
import fil.iagl.cookorico.entity.Recipe;
import fil.iagl.cookorico.service.impl.RecipeServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class RecipeServiceTest extends AbstractCookoricoTest {
	
	@InjectMocks
	private RecipeServiceImpl recipeService;
	
	@Mock
	private RecipeDao recipeDao;

	public RecipeServiceTest() throws Exception {
		super();
	}
	
	@Test
	public void testGetAllRecipes() {
		recipeService.getAllRecipes();
		
		Mockito.verify(recipeDao, Mockito.times(1)).getAllRecipes();
	}
	
	@Test
	public void testGetAllRecipesByUserId() {
		recipeService.getAllRecipesByUserId(1);
		
		Mockito.verify(recipeDao, Mockito.times(1)).getAllRecipesByUserId(1);
	}
	
	@Test
	public void testRecipeById() {
		recipeService.getRecipeById(1);
		
		Mockito.verify(recipeDao, Mockito.times(1)).getRecipeById(1);
	}
	
	@Test
	public void testAddRecipe() {
		final Recipe recipe = new Recipe();
		
		recipeService.addRecipe(recipe);
		
		Mockito.verify(recipeDao, Mockito.times(1)).addRecipe(recipe);
	}

	@Test
	public void testGetRandomRecipes() {
		recipeService.getRandomRecipes(5);
		
		Mockito.verify(recipeDao, Mockito.times(1)).getRandomRecipes(5);
	}

}
