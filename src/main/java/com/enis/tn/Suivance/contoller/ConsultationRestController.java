package com.enis.tn.Suivance.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.enis.tn.Suivance.dao.ConsultationRepository;
import com.enis.tn.Suivance.entity.Consultation;

@RestController
public class ConsultationRestController {
	@Autowired
 private ConsultationRepository consultationRepository;
	
	@GetMapping("/consultation")
	public  List<Consultation> getAllConsultation(){
		
		return this.consultationRepository.findAll();
	}
	
	@PostMapping("/consultation")
	public Consultation ajouteConsultation(@RequestBody Consultation consultation) {
		//Consultation c = new Consultation(consultation, null, null, null);
		
		 return this.consultationRepository.save(consultation);
	}
}
