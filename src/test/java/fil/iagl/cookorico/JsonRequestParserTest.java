package fil.iagl.cookorico.controller.util;

import org.junit.Test;
import org.mockito.Mockito;

import junit.framework.TestCase;

public class JsonRequestParserTest extends TestCase {
	
	private JsonRequestParser requestParser;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		requestParser = Mockito.mock(JsonRequestParser.class);
	}
	
	@Test
	public void testGetValue() {
		final String jsonArray = "{\"username\" : \"admin\",\"password\":\"pwd\"}";
		Mockito.doCallRealMethod().when(requestParser).parse(Mockito.anyString());
		Mockito.doCallRealMethod().when(requestParser).getValue(Mockito.any());
		requestParser.parse(jsonArray);
		assertEquals(requestParser.getValue("username").toString(), "admin");
		assertEquals(requestParser.getValue("password").toString(), "pwd");
	}



}
