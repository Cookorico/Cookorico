package fil.iagl.cookorico.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import fil.iagl.cookorico.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fil.iagl.cookorico.service.MemberService;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {
    
    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

}
