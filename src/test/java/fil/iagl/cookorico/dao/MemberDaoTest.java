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
import fil.iagl.cookorico.entity.Member;

@RunWith(Parameterized.class)
public class MemberDaoTest extends AbstractCookoricoTest {
	
	@Autowired
	private MemberDao memberDao;
	
	private Integer id;
	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private String gender;
	private String city;
	
	public MemberDaoTest(Integer id, String username, String firstName, String lastName, String email, String gender,
			String city) throws Exception {
		super();
		this.id = id;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.city = city;
	}

	@Parameters
	public static Collection<Object[]> data() {
		final Object[][] data = {
				{ 1, "user", null, null, "user@user.be", null, "Lille" },
				{ 2, "dufaux", "johan", "dufaux", "johan.dufaux@etudiant.univ-lille1.fr", "M", "Lille" },
				{ 3, "cookorico", "cookorico", "cookorico", "cookorico@yopmail.com", "M", "Lille" },
				{ 4, "Dieulin", "Dieulin", "Mambouana", "dieulin@cookorico.com", "M", "Lille" },
				{ 5, "Ly4m", "William", "Leemans", "Ly4m@cookorico.com", "M", "Lille" },
				{ 6, "Mandrivia", "Antoine", "Philippe", "Mandrivia@cookorico.com", "M", "Lille" },
				{ 7, "sallareznov", "Salla", "Diagne", "sallareznov@cookorico.com", "M", "Lille" },
				{ 8, "sofianekabylino", "Sofiane", "Yousfi", "sofianekabylino@cookorico.com", "M", "Lille" },
				{ 9, "ouams", "Ouamar", "Sais", "ouams@gmail.com", "M", "Lille" }
			};
		return Arrays.asList(data);
	}
	
	
	@Test
	public void testGetMemberByIdSuccess() {
		// when
		final Member member = memberDao.getMemberById(id);

		// then
		Assertions.assertThat(member.getIdMember()).isEqualTo(id);
		Assertions.assertThat(member.getUsername()).isEqualTo(username);
		Assertions.assertThat(member.getFirstname()).isEqualTo(firstName);
		Assertions.assertThat(member.getLastname()).isEqualTo(lastName);
		Assertions.assertThat(member.getEmail()).isEqualTo(email);
		Assertions.assertThat(member.getGender()).isEqualTo(gender);
		Assertions.assertThat(member.getCity()).isEqualTo(city);
	}

	@Test
	public void testGetMemberMethodsFailure() {
		// getMemberById
		Assertions.assertThat(memberDao.getMemberById(null)).isNull();
		Assertions.assertThat(memberDao.getMemberById(Integer.MIN_VALUE)).isNull();
		Assertions.assertThat(memberDao.getMemberById(Integer.MAX_VALUE)).isNull();
		
		// getMemberWithCredentials
		Assertions.assertThat(memberDao.getMemberWithCredentials(null, null)).isNull();
		Assertions.assertThat(memberDao.getMemberWithCredentials("dumbUsername", "dumbPassword")).isNull();
		
		// getMemberWithUsername
		Assertions.assertThat(memberDao.getMemberWithUsername(null)).isNull();
		Assertions.assertThat(memberDao.getMemberWithUsername("dumbUsername")).isNull();
	}
	
	@Test
	public void testAddMember() {
		// TODO not implemented for the moment, since we are using the real database for the tests.
		// TODO we have to mock the database (and therefore create a fake one) to run execute this test
	}
	
	@Test
	public void testGetAllMembers() {
		// given
		
		// when
		final List<Member> allMembers = memberDao.getAllMembers();
		
		// then
		Assertions.assertThat(allMembers).hasSize(9);
	}

	@Test
	public void testGetMemberWithUsernameSuccess() {
		// given
		
		// when
		final Member member = memberDao.getMemberWithUsername(username);
		
		// then
		Assertions.assertThat(member.getIdMember()).isEqualTo(id);
		Assertions.assertThat(member.getUsername()).isEqualTo(username);
		Assertions.assertThat(member.getFirstname()).isEqualTo(firstName);
		Assertions.assertThat(member.getLastname()).isEqualTo(lastName);
		Assertions.assertThat(member.getEmail()).isEqualTo(email);
		Assertions.assertThat(member.getGender()).isEqualTo(gender);
		Assertions.assertThat(member.getCity()).isEqualTo(city);
	}

}
