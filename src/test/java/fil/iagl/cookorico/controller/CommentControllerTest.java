package fil.iagl.cookorico.controller;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(MockitoJUnitRunner.class)
public class CommentControllerTest extends AbstractCookoricoControllerTest {

	public CommentControllerTest() throws Exception {
		super();
	}

	@Test
	public void testGetAllCommentsByIdRecipe() throws Exception {
		getMockMvc().perform(MockMvcRequestBuilders.get("/comments/recipe/{id}", 1))
				.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.", Matchers.hasSize(2)));

		getMockMvc().perform(MockMvcRequestBuilders.get("/comments/recipe/{id}", 2))
				.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.", Matchers.hasSize(1)));
	}

}
