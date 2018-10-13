package com.enis.tn.Suivance.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
@Entity
@Data
public class Consultation implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name = "id", unique = true, nullable = true)
private Long id;
@Column(name = "notes", nullable = true, length = 50)
private String notes;

    //coulon date
    @Temporal(TemporalType.DATE)
    @Column(name = "date")
private Date date;	

    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Medecin getMed() {
		return med;
	}
	public void setMed(Medecin med) {
		this.med = med;
	}
	public Consultation() {
		super();
	}
	public Consultation(String notes, Date date, Patient patient, Medecin med) {
		super();
		this.notes = notes;
		this.date = date;
		this.patient = patient;
		this.med = med;
	}
	@ManyToOne(cascade= CascadeType.ALL)
    private Patient patient; 
    @ManyToOne(cascade= CascadeType.ALL)
    private Medecin med; 
}
