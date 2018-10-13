package com.enis.tn.Suivance.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.enis.tn.Suivance.entity.AppUser;
import com.enis.tn.Suivance.service.AccountService;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
	private AccountService accountService;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser u=accountService.findUserByUsername(username);
		if(u==null) throw new UsernameNotFoundException(username);
		Collection<GrantedAuthority> autoroties = new ArrayList<>();
		u.getRoles().forEach(r->{
			autoroties.add(new SimpleGrantedAuthority(r.getRoleName()) );
		});
		return new User(u.getUsername(),u.getPassword(),autoroties);
	}

}
