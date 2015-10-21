package fil.iagl.cookorico.controller;

import org.neo4j.cypher.internal.compiler.v2_1.functions.Str;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fil.iagl.cookorico.entity.Member;
import fil.iagl.cookorico.service.MemberService;
import fil.iagl.cookorico.wrapper.LoginWrapper;
import fil.iagl.cookorico.wrapper.RegisterWrapper;

@RestController
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Member login(@RequestBody LoginWrapper wrapper) {
		final String username = wrapper.getUsername();
		final String password = wrapper.getPassword();
		return memberService.getMember(username, password);
	}
	
	@RequestMapping(value = "user/register", method = RequestMethod.POST)
	public boolean registerUser(@RequestBody RegisterWrapper wrapper) {
		
		
		
		
		final String email = wrapper.getEmail();
		final String username = wrapper.getUsername();
		final String password = wrapper.getPassword();
		final String firstName = wrapper.getFirstName();
		final String lastName = wrapper.getLastName();
		final String gender = wrapper.getGender();
		final String city = wrapper.getCity();
		
		final Member member = new Member();
		member.setFirstname(firstName);
		member.setLastname(lastName);
		member.setCity(city);
		member.setGender(gender);
		member.setEmail(email);
		member.setUsername(username);
		member.setPassword(password);
		
		return memberService.addMember(member);
	}
}
