package com.enis.tn.Suivance.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import lombok.Data;
@Entity 
@Data
@DiscriminatorValue("MS")
public class MedecinSpecialiste extends Medecin  implements Serializable {
	@Column(name = "specialite", nullable = true)
	private String specialite;
	@ManyToMany(mappedBy= "medSpec")
	private Set<Patient> patients;
	
	
	
	

	public String getSpecialite() {
		return specialite;
	}
	public MedecinSpecialiste(String nom, String prenom, Date date, String email, String telephone, byte[] photo,
			String codePublic, Set<Consultation> consultation, String specialite) {
		super(nom, prenom, date, email, telephone, photo, codePublic, consultation);
		this.specialite = specialite;
	}
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	public Set<Patient> getPatients() {
		return patients;
	}
	public void setPatients(Set<Patient> patients) {
		this.patients = patients;
	}

}
