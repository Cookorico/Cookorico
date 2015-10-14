package fil.iagl.cookorico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fil.iagl.cookorico.entity.Member;
import fil.iagl.cookorico.service.MemberService;

@RestController
public class UserController {

	@Autowired
	MemberService memberService;
	
	@RequestMapping(value = "/user/register", method = RequestMethod.POST)
	public void registerUser(@RequestBody Member member){
		memberService.addMember(member);
	}	
}
