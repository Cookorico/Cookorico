package fil.iagl.cookorico.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fil.iagl.cookorico.AbstractCookoricoTest;
import fil.iagl.cookorico.dao.MemberDao;
import fil.iagl.cookorico.service.impl.MemberServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class MemberServiceTest extends AbstractCookoricoTest {
	
	private MemberService memberService;
	
	private MemberDao memberDao;
	
	public MemberServiceTest() throws Exception {
		super();
		memberDao = Mockito.mock(MemberDao.class);
		memberService = new MemberServiceImpl(memberDao);
		
	}
	
	@Test
	public void testGetMemberByUsername() {
		memberService.getMemberByUserName("sallareznov");
		Mockito.verify(memberDao.getMemberWithUsername("sallareznov"));
	}

}
