package com.enis.tn.Suivance.service;

import com.enis.tn.Suivance.entity.AppRole;
import com.enis.tn.Suivance.entity.AppUser;

public interface AccountService {
	public AppUser saveUser(AppUser user);
	public AppRole saveRole(AppRole role);
	public void addRoleToUser(String username,String roleName);
	public AppUser findUserByUsername(String username);
}
