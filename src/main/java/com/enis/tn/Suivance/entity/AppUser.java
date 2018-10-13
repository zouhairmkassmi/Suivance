package com.enis.tn.Suivance.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import lombok.Data;
@Entity
@Data
public class AppUser  implements Serializable{
	@Id @GeneratedValue
	private Long id;
	@Column(unique=true)
	private String username;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@JsonIgnore
	public String getPassword() {
		return password;
	}
	@JsonSetter
	public void setPassword(String password) {
		this.password = password;
	}
	public Collection<AppRole> getRoles() {
		return roles;
	}
	public void setRoles(Collection<AppRole> roles) {
		this.roles = roles;
	}
	public AppUser() {
		super();
	}
	public AppUser(String username, String password, Collection<AppRole> roles) {
		super();
		this.username = username;
		this.password = password;
		this.roles = roles;
	}
	private String password ;
	@ManyToMany(fetch=FetchType.EAGER)
	private Collection<AppRole> roles= new ArrayList<>();
}
