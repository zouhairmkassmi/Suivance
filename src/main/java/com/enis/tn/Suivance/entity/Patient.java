package com.enis.tn.Suivance.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Data
public class Patient implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name = "id", unique = true, nullable = true)
private Long id;
@Column(name = "nom", nullable = true, length = 50)
private String nom;
    @Column(name = "prenom", nullable = true, length = 50)
private String prenom;
    //coulon date
    @Temporal(TemporalType.DATE)
    @Column(name = "date")
private Date date;
    @Column(name = "email", nullable = true, length = 50)
private String email;

    @Column(name = "tel", nullable = true, length = 50)
	private String telephone;
    @Lob
    @Column(name = "photo", nullable = true)
	private byte[] photo;
    @Column(name = "numeroCnam", nullable = true, length = 50)
     private String numeroCnam;
    
    @ManyToMany(cascade=CascadeType.ALL) 
    @JoinTable(name= "Patient_Medecin", joinColumns=@JoinColumn(name= "PM_Patient_ID"), inverseJoinColumns= @JoinColumn(name= "PM_Medecin_ID"))
    private Set<MedecinSpecialiste> medSpec;
    
    @OneToMany(mappedBy= "patient") 
    private Set<Consultation> consultation;
    @ManyToOne(cascade= CascadeType.ALL)
    private MedecinGeneraliste medGen;
	public Patient(String nom, String prenom, Date date, String email, String telephone, byte[] photo,
			String numeroCnam) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.date = date;
		this.email = email;
		this.telephone = telephone;
		this.photo = photo;
		this.numeroCnam = numeroCnam;
	} 
    
}
