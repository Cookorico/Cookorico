package fil.iagl.cookorico.entity;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

/**
 * Created by willl on 17/11/2015.
 */
public class CurrentUser extends User {

	private static final long serialVersionUID = 1L;
	private Member member;

    public CurrentUser(Member member) {
        super(member.getUsername(), member.getPassword(), AuthorityUtils.createAuthorityList("Member"));
        this.member = member;
    }

    public Member getMember() {
        return member;
    }

    public Integer getId() {
        return member.getIdMember();
    }

}
