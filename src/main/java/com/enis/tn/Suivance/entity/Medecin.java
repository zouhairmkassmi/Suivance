package com.enis.tn.Suivance.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity 
@Data
@Inheritance(strategy=InheritanceType.SINGLE_TABLE) 
@DiscriminatorColumn(name="type_med", discriminatorType=DiscriminatorType.STRING,length=2)
@Table(name = "medecin", schema = "public")
public class Medecin implements Serializable{
	
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
        @Column(name = "codePublic", nullable = true, length = 50)
	private String codePublic;
        @OneToMany(mappedBy= "med") 
        private Set<Consultation> consultation;
        
        
        
    	public Medecin() {
    		super();
    		// TODO Auto-generated constructor stub
    	}
    
	public Medecin(String nom, String prenom, Date date, String email, String telephone, byte[] photo,
				String codePublic, Set<Consultation> consultation) {
			super();
			this.nom = nom;
			this.prenom = prenom;
			this.date = date;
			this.email = email;
			this.telephone = telephone;
			this.photo = photo;
			this.codePublic = codePublic;
			this.consultation = consultation;
		}
	public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		public String getPrenom() {
			return prenom;
		}
		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getTelephone() {
			return telephone;
		}
		public void setTelephone(String telephone) {
			this.telephone = telephone;
		}
		public byte[] getPhoto() {
			return photo;
		}
		public void setPhoto(byte[] photo) {
			this.photo = photo;
		}
		public String getCodePublic() {
			return codePublic;
		}
		public void setCodePublic(String codePublic) {
			this.codePublic = codePublic;
		}
		public Set<Consultation> getConsultation() {
			return consultation;
		}
		public void setConsultation(Set<Consultation> consultation) {
			this.consultation = consultation;
		}


}
