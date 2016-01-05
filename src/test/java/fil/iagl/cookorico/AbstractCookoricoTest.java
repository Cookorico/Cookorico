package fil.iagl.cookorico;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestContextManager;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringApplicationConfiguration(classes = CookoricoApplication.class)
@WebAppConfiguration
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class })
public class AbstractCookoricoTest {
	
	private TestContextManager testContextManager;
	
	public AbstractCookoricoTest() throws Exception {
		this.testContextManager = new TestContextManager(getClass());
        this.testContextManager.prepareTestInstance(this);
	}

}
