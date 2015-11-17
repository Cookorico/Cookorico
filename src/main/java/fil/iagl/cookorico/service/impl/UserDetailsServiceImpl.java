package fil.iagl.cookorico.service.impl;

import fil.iagl.cookorico.entity.CurrentUser;
import fil.iagl.cookorico.service.MemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by willl on 17/11/2015.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private MemberService memberService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new CurrentUser(memberService.getMemberByUserName(username));
    }
}
