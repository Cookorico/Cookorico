package fil.iagl.cookorico.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fil.iagl.cookorico.entity.CurrentUser;
import fil.iagl.cookorico.entity.Level;
import fil.iagl.cookorico.entity.Member;
import fil.iagl.cookorico.service.LevelService;
import fil.iagl.cookorico.service.MemberService;

@RestController
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private LevelService levelService;

	
	@RequestMapping(value = "/level/xp/{xp}", method = RequestMethod.GET)
	public @ResponseBody Level getLevelByXP(@PathVariable String xp) {
		System.out.println("LEVEL XP");
		return levelService.getLevelByXP(Integer.parseInt(xp));
	}
	
	
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public @ResponseBody Member getProfile() {
		//En attendant recupération de l'user loggé ??
		
		CurrentUser currentUser = (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    Member m = currentUser.getMember();
		/*Member m = new Member();
		m.setIdMember(1);
		m.setUsername("Gordevil");
		m.setFirstname("Gordon");
		m.setLastname("Ramsay");
		m.setGender("M");
		m.setEmail("gordon@ramsay.com");
		m.setExperience(3250);
		m.setLevel(34);*/
		
		return m;
	}
	
	@RequestMapping(value = "/profile/{id}", method = RequestMethod.GET)
	public @ResponseBody Member getProfileById(@PathVariable int id) {
		//En attendant recupération de l'user loggé ??
		
		Member m = memberService.getMemberById(id);
		return m;
	}
	
	@RequestMapping(value = "/profile/{id}/{newXp}", method = RequestMethod.POST)
	public void updateXpMember(@PathVariable int id, @PathVariable int newXp) {
		Map<String, Integer> parms = new HashMap<String, Integer>();
		parms.put("id", id);
		parms.put("newXp", newXp);

		//Mise à jour de l'xp
		memberService.updateXpMember( parms);

	
	}
	
	
	
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public Member login(@RequestBody LoginWrapper wrapper) {
//		final String username = wrapper.getUsername();
//		final String password = wrapper.getPassword();
//		return memberService.getMember(username, password);
//	}
//
//	@RequestMapping(value = "user/register", method = RequestMethod.POST)
//	public boolean registerUser(@RequestBody RegisterWrapper wrapper) {
//
//		final String email = wrapper.getEmail();
//		final String username = wrapper.getUsername();
//		final String password = wrapper.getPassword();
//		final String firstName = wrapper.getFirstName();
//		final String lastName = wrapper.getLastName();
//		final String gender = wrapper.getGender();
//		final String city = wrapper.getCity();
//
//		final Member member = new Member();
//		member.setFirstname(firstName);
//		member.setLastname(lastName);
//		member.setCity(city);
//		member.setGender(gender);
//		member.setEmail(email);
//		member.setUsername(username);
//		member.setPassword(password);
//
//		return memberService.addMember(member);
//	}
}
