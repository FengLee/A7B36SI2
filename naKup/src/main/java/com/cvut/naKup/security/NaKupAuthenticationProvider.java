package com.cvut.naKup.security;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.cvut.naKup.dao.UserDao;
import com.cvut.naKup.domain.User;

@Component("naKupAuthenticationProvider")
public class NaKupAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
	private UserDao userDao;

	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
		String login = token.getName();
        String password = token.getCredentials().toString();
        
        Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("login", login);
	    List<User> result = userDao.find(User.FIND_BY_LOGIN, parameters);
	    if (result.isEmpty()) {
	    	return null;
	    }
	    User persistedUser = result.get(0);
	    boolean correctPassword = persistedUser.hasPassword(password);
	    if (correctPassword) {
	    	//TODO: handle NaKup user roles
	    	List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
            grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
            
            Authentication auth = new UsernamePasswordAuthenticationToken(login, password, grantedAuths);
            return auth;
	    }
		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
	
}
