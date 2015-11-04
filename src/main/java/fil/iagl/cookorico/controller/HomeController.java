package fil.iagl.cookorico.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fil.iagl.cookorico.service.MemberService;

@RestController
public class HomeController {

    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

}
