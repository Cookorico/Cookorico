package fil.iagl.cookorico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import fil.iagl.cookorico.AbstractCookoricoTest;

public class AbstractCookoricoControllerTest extends AbstractCookoricoTest {

	public AbstractCookoricoControllerTest() throws Exception {
		super();
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	public WebApplicationContext getWebApplicationContext() {
		return webApplicationContext;
	}
	
	public MockMvc getMockMvc() {
		return mockMvc;
	}

}
