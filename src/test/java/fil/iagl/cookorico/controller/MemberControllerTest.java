package fil.iagl.cookorico.controller;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(Parameterized.class)
public class MemberControllerTest extends AbstractCookoricoControllerTest {

	private Integer id;
	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private String gender;
	private String city;

	public MemberControllerTest(Integer id, String username, String firstName, String lastName, String email,
			String gender, String city) throws Exception {
		super();
		this.id = id;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.city = city;
		MockitoAnnotations.initMocks(this);
	}

	@Parameters
	public static Collection<Object[]> data() {
		final Object[][] data = { { 1, "user", null, null, "user@user.be", null, null },
				{ 2, "dufaux", "johan", "dufaux", "johan.dufaux@etudiant.univ-lille1.fr", "M", "Lille" },
				{ 3, "cookorico", "cookorico", "cookorico", "cookorico@yopmail.com", "M", "Villeneuve d'Ascq" },
				{ 4, "Dieulin", "Dieulin", "Mambouana", "dieulin@cookorico.com", "M", "Villeneuve d'Ascq" },
				{ 5, "Ly4m", "William", "Leemans", "Ly4m@cookorico.com", "M", "Villeneuve d'Ascq" },
				{ 6, "Mandrivia", "Antoine", "Philippe", "Mandrivia@cookorico.com", "M", null },
				{ 8, "sallareznov", "Salla", "Diagne", "sallareznov@cookorico.com", "M", null },
				{ 9, "sofianekabylino", "Sofiane", "Yousfi", "sofianekabylino@cookorico.com", "M", null },
				{ 7, "ouams", "Ouamar", "Sais", "ouams@gmail.com", "M", null } };
		return Arrays.asList(data);
	}

	@Test
	public void testGetProfileByIdSuccess() throws Exception {
		getMockMvc().perform(MockMvcRequestBuilders.get("/profile/{id}", id)).andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.idMember").value(id))
				.andExpect(MockMvcResultMatchers.jsonPath("$.username").value(username))
				.andExpect(MockMvcResultMatchers.jsonPath("$.firstname").value(firstName))
				.andExpect(MockMvcResultMatchers.jsonPath("$.lastname").value(lastName))
				.andExpect(MockMvcResultMatchers.jsonPath("$.email").value(email))
				.andExpect(MockMvcResultMatchers.jsonPath("$.gender").value(gender))
				.andExpect(MockMvcResultMatchers.jsonPath("$.city").value(city));
	}

	@Test
	public void testGetProfileByInvalidId() throws Exception {
		getMockMvc().perform(MockMvcRequestBuilders.get("/profile/{id}", Integer.MAX_VALUE))
				.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.content().string(""));
	}

	@Test
	public void testGetProfileByIdFailure() throws Exception {
		getMockMvc().perform(MockMvcRequestBuilders.post("/profile/{id}", id)).andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isMethodNotAllowed());
		getMockMvc().perform(MockMvcRequestBuilders.put("/profile/{id}", id)).andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isMethodNotAllowed());
		getMockMvc().perform(MockMvcRequestBuilders.delete("/profile/{id}", id)).andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isMethodNotAllowed());
	}

}
