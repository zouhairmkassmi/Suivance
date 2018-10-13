package com.enis.tn.Suivance.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Data;
@Entity 
@Data
@DiscriminatorValue("MG")
public class MedecinGeneraliste extends Medecin implements Serializable  {
	   @OneToMany(mappedBy= "medGen") 
	    private Set<Patient> patient;

	public MedecinGeneraliste() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MedecinGeneraliste(String nom, String prenom, Date date, String email, String telephone, byte[] photo,
			String codePublic, Set<Consultation> consultation) {
		super(nom, prenom, date, email, telephone, photo, codePublic, consultation);
		// TODO Auto-generated constructor stub
	}

	public Set<Patient> getPatient() {
		return patient;
	}

	public void setPatient(Set<Patient> patient) {
		this.patient = patient;
	}

}
