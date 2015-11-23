package fil.iagl.cookorico.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.json.JSONObject;
import org.neo4j.cypher.internal.compiler.v2_1.functions.Str;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fil.iagl.cookorico.entity.Member;
import fil.iagl.cookorico.service.MemberService;
import fil.iagl.cookorico.wrapper.LoginWrapper;
import fil.iagl.cookorico.wrapper.RegisterWrapper;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MemberController {

	@Autowired
	private MemberService memberService;
	

	@RequestMapping(value = "user/register", method = RequestMethod.POST)
	public JSONObject registerUser(@RequestBody RegisterWrapper wrapper) {

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

		memberService.addMember(member);

		return new JSONObject();
	}

}
