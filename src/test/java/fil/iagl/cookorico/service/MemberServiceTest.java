package fil.iagl.cookorico.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import fil.iagl.cookorico.AbstractCookoricoTest;
import fil.iagl.cookorico.dao.MemberDao;
import fil.iagl.cookorico.entity.Member;
import fil.iagl.cookorico.service.impl.MemberServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class MemberServiceTest extends AbstractCookoricoTest {
	
	@InjectMocks
	private MemberServiceImpl memberService;
	
	@Mock
	private MemberDao memberDao;

	public MemberServiceTest() throws Exception {
		super();
	}
	
	@Test
	public void testGetMemberById() {
		// given
		
		// when
		memberService.getMemberById(1);
		
		// then
		Mockito.verify(memberDao, Mockito.times(1)).getMemberById(1);
	}
	
	@Test
	public void testAddMemberWithUsernameThatDoesntExist() {
		// given
		final Member memberWithUsernameThatDoesntExist = new Member();
		memberWithUsernameThatDoesntExist.setUsername("Bob");
		memberWithUsernameThatDoesntExist.setGender("M");
	
		// when
		memberService.addMember(memberWithUsernameThatDoesntExist);
		
		// then
		Mockito.verify(memberDao, Mockito.times(1)).addMember(memberWithUsernameThatDoesntExist);
	}
	
//	@Test
//	public void testAddMemberWithUsernameThatAlreadyExists() {
//		// given
//		final Member memberWithUsernameThatAlreadyExists = new Member();
//		memberWithUsernameThatAlreadyExists.setUsername("cookorico");
//		memberWithUsernameThatAlreadyExists.setGender("M");
//		
//		System.out.println(memberDao.getAllMembers().size());
//		
//		// when
//		memberService.addMember(memberWithUsernameThatAlreadyExists);
//		
//		// then
//		Mockito.verify(memberDao, Mockito.never()).addMember(memberWithUsernameThatAlreadyExists);
//	}
	
	@Test
	public void testAddMemberWithInvalidGender() {
		// given
		final Member memberWithInvalidGender = new Member();
		memberWithInvalidGender.setUsername("Alice");
		memberWithInvalidGender.setGender("A");
		
		// when
		memberService.addMember(memberWithInvalidGender);
		
		// then
		Mockito.verify(memberDao, Mockito.never()).addMember(memberWithInvalidGender);
	}
	
	

}
