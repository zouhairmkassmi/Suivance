package com.enis.tn.Suivance.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enis.tn.Suivance.entity.AppUser;

public interface UserRepository extends JpaRepository<AppUser, Long> {
 public AppUser findByUsername(String username);
}
