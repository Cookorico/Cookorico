package fil.iagl.cookorico.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;

import fil.iagl.cookorico.AbstractCookoricoTest;

@RunWith(Parameterized.class)
public class TasteDaoTest extends AbstractCookoricoTest {
	
	@Autowired
	private TasteDao tasteDao;

	public TasteDaoTest() throws Exception {
		super();
	}
	
	@Test
	public void getAllTastesTest() {
		
	}

	@Test
	public void getTastesByMemberTest() {
		//tasteDao.getTastesByMember();
	}
	
	@Test
	public void addTasteTest() {
		
	}
	
	@Test
	public void deleteTasteTest() {
		
	}

}
