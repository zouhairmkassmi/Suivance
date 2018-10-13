package com.enis.tn.Suivance.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enis.tn.Suivance.entity.AppRole;

public interface RoleRepository extends JpaRepository<AppRole, Long>{
	public AppRole findByRoleName(String roleName);
}
