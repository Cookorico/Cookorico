package cookorico;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import fil.iagl.cookorico.CookoricoApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CookoricoApplication.class)
@WebAppConfiguration
public class CookoricoApplicationTests {

	@Test
	public void contextLoads() {
	}

}
