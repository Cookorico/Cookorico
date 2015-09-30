package fil.iagl.cookorico.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fil.iagl.cookorico.dao.MemberDao;

@RestController
public class HomeController {

	 @Autowired
	 private MemberDao userinterface;

	// @RequestMapping("home")
	// public List<Member> home() {
	// final List<Member> members = userinterface.getAllMembers();
	// for (final Member member : members) {
	// System.out.println(member.getUsername());
	// }
	// return members;
	// }

	@RequestMapping("/user")
	public Principal user(Principal user) {
		return user;
	}

	@RequestMapping("/resource")
	public Map<String, Object> home() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("members", userinterface.getAllMembers());
		return model;
	}

}
