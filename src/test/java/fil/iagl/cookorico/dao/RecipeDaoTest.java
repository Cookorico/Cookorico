package fil.iagl.cookorico.dao;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.springframework.beans.factory.annotation.Autowired;

import fil.iagl.cookorico.AbstractCookoricoTest;
import fil.iagl.cookorico.entity.Recipe;

@RunWith(Parameterized.class)
public class RecipeDaoTest extends AbstractCookoricoTest {

	@Autowired
	private RecipeDao recipeDao;

	private Integer id;
	private String name;
	private String description;
	private Integer preparationTime;
	private Integer cookingTime;

	public RecipeDaoTest(Integer id, String name, String description, Integer preparationTime, Integer cookingTime)
			throws Exception {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.preparationTime = preparationTime;
		this.cookingTime = cookingTime;
	}

	@Parameters
	public static Collection<Object[]> data() {
		final Object[][] data = { { 1, "Omelette", "Une superbe omelette baveuse", 300, 360 },
				{ 6, "Recette Ouap", "Recette ouap", 70, 125 },
				{ 7, "Tartelette aux fraises", "Tartelette", 600, 1200 },
				{ 12, "Une entree de la mer", "Une superbe entree venue de la mer !", 20, 0 },
				{ 28, "Pizza", "Pizza Orientale", 300, 360 } };
		return Arrays.asList(data);
	}

	@Test
	public void getAllRecipesTest() {
		final List<Recipe> allRecipes = recipeDao.getAllRecipes();

		Assertions.assertThat(allRecipes.size()).isEqualTo(15);
	}

	@Test
	public void getFullRecipesTest() {
		final List<Recipe> fullRecipes = recipeDao.getFullRecipes();

		Assertions.assertThat(fullRecipes.size()).isEqualTo(15);
	}

	@Test
	public void getAllRecipesWithTagsTest() {
		final List<Recipe> recipesWithTags = recipeDao.getAllRecipesWithTags();

		Assertions.assertThat(recipesWithTags.size()).isEqualTo(15);
	}

	@Test
	public void getAllRecipesWithMainPictureTest() {
		final List<Recipe> recipesWithMainPicture = recipeDao.getAllRecipesWithMainPicture();

		Assertions.assertThat(recipesWithMainPicture.size()).isEqualTo(15);
	}

	@Test
	public void addRecipeTest() {
		// TODO new database
	}

	@Test
	public void getRecipeByIdTest() {
		final Recipe recipe = recipeDao.getRecipeById(id);

		Assertions.assertThat(recipe.getIdRecipe()).isEqualTo(id);
		Assertions.assertThat(recipe.getName()).isEqualTo(name);
		Assertions.assertThat(recipe.getDescription()).isEqualTo(description);
		Assertions.assertThat(recipe.getPreparationTime()).isEqualTo(preparationTime);
		Assertions.assertThat(recipe.getCookingTime()).isEqualTo(cookingTime);
	}

}
