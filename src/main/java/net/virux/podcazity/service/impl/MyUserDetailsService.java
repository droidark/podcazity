package net.virux.podcazity.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import net.virux.podcazity.dao.UserDao;
import net.virux.podcazity.model.Profile;

@Service("myUserDetailsService")
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(final String username) 
			throws UsernameNotFoundException {
		net.virux.podcazity.model.User user = userDao.getUser(username);
		System.out.println("User: " + user);
		if(user == null){
			System.out.println("User not found.");
			throw new UsernameNotFoundException("Username not found");
		}
		return new User(user.getUsername(), user.getPassword(), 
				user.getState().equals("Active"), true, true, true, 
				getGrantedAuthorities(user));
	}
	
	private List<GrantedAuthority> getGrantedAuthorities(
			net.virux.podcazity.model.User user){
		List<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
		
		for(Profile profile : user.getProfiles()){
			System.out.println("Profile: " + profile);
			auth.add(new SimpleGrantedAuthority("ROLE_" + profile.getProfile()));
		}
		
		System.out.println("Authorities: " + auth);
		return auth;		
	}
}
