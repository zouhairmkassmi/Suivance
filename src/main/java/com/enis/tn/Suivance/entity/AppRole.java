package com.enis.tn.Suivance.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
@Entity
@Data
public class AppRole implements Serializable{
	@Id @GeneratedValue
	private Long id;
	
	private String roleName;

	public AppRole(String roleName) {
		super();
		this.roleName = roleName;
	}

	public AppRole() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


}
