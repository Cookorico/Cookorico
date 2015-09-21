package fil.iagl.cookorico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fil.iagl.cookorico.dao.MemberDao;
import fil.iagl.cookorico.entity.Member;

@RestController
public class HomeController {

	@Autowired
	private MemberDao userinterface;

	@RequestMapping("home")
	public List<Member> home() {
		final List<Member> members = userinterface.getAllMembers();
		for (final Member member : members) {
			System.out.println(member.getUsername());
		}
		return members;
	}

}
