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
import fil.iagl.cookorico.entity.Ingredient;

@RunWith(Parameterized.class)
public class IngredientDaoTest extends AbstractCookoricoTest {
	
	@Autowired
	private IngredientDao ingredientDao;
	
	private Integer id;
	private String name;
	
	public IngredientDaoTest(Integer id, String name) throws Exception {
		super();
		this.id = id;
		this.name = name;
	}

	@Parameters
	public static Collection<Object[]> data() {
		final Object[][] data = {
				{ 1, "Banane" },
				{ 2, "Citron" },
				{ 3, "Viande hachée" },
				{ 4, "Pied de porc" },
				{ 5, "Oeuf" },
				{ 6, "Sel" },
				{ 7, "Sucre" },
				{ 8, "Poivre" },
				{ 9, "Huile d'Olive" },
				{ 10, "Beurre" },
				{ 11, "Farine" },
				{ 12, "Beurre salé" },
				{ 13, "Lait" },
				{ 14, "Huile" }
			};
		return Arrays.asList(data);
	}
	
	
	@Test
	public void testIngredientByIdSuccess() {
		
		// when
		final Ingredient ingredient = ingredientDao.getIngredientById(id);

		// then
		Assertions.assertThat(ingredient.getIdIngredient()).isEqualTo(id);
		Assertions.assertThat(ingredient.getName()).isEqualTo(name);
	}

	@Test
	public void testIngredientByIdFailure() {
		// getMemberById
		Assertions.assertThat(ingredientDao.getIngredientById(null)).isNull();
		Assertions.assertThat(ingredientDao.getIngredientById(Integer.MIN_VALUE)).isNull();
		Assertions.assertThat(ingredientDao.getIngredientById(Integer.MAX_VALUE)).isNull();
	}
	
	@Test
	public void testGetAllIngredients() {
		// given
		
		// when
		final List<Ingredient> allIngredients = ingredientDao.getAllIngredients();
		
		// then
		Assertions.assertThat(allIngredients).hasSize(14);
	}
	
}
