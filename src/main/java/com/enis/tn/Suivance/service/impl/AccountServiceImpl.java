package com.enis.tn.Suivance.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.enis.tn.Suivance.dao.RoleRepository;
import com.enis.tn.Suivance.dao.UserRepository;
import com.enis.tn.Suivance.entity.AppRole;
import com.enis.tn.Suivance.entity.AppUser;
import com.enis.tn.Suivance.service.AccountService;
@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Override
	public AppUser saveUser(AppUser user) {
		String hashPw= bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(hashPw);
		return userRepository.save(user);
	}

	@Override
	public AppRole saveRole(AppRole role) {
		
		return roleRepository.save(role);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		AppRole role= roleRepository.findByRoleName(roleName);
		AppUser user=userRepository.findByUsername(username);
		user.getRoles().add(role);
		
	}

	@Override
	public AppUser findUserByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(username);
	}

}
