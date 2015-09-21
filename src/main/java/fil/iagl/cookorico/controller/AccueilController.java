package fil.iagl.cookorico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fil.iagl.cookorico.dao.MemberDao;
import fil.iagl.cookorico.entity.Member;

@RestController
public class AccueilController {
	
	
	private static final String phrase = ("phrase de presentation");
	
	@Autowired
	private MemberDao userinterface;
	
	@RequestMapping("accueil")
	public List<Member> accueil(){
		System.out.println("Display accueil");
		/*List<Member> lst = userinterface.completelist();
		for(Member m : lst){
			System.out.println(m.getUsername());
			
		}
		return lst;*/
		return userinterface.completelist();
	}
}
