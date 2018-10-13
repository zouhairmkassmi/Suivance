package com.enis.tn.Suivance.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enis.tn.Suivance.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
