package com.enis.tn.Suivance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.enis.tn.Suivance.dao.ConsultationRepository;
import com.enis.tn.Suivance.entity.AppRole;
import com.enis.tn.Suivance.entity.AppUser;
import com.enis.tn.Suivance.entity.Consultation;
import com.enis.tn.Suivance.service.AccountService;

@SpringBootApplication
public class SuivanceApplication implements CommandLineRunner{
    @Autowired
	private AccountService accountService;
    @Autowired
    private ConsultationRepository consultationRepository;
	public static void main(String[] args)  {
		SpringApplication.run(SuivanceApplication.class, args);
	}
	
	@Bean
	public BCryptPasswordEncoder getBCPE() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void run(String... args) throws Exception {
	/*	accountService.saveUser(new AppUser("admin","1234", null));
		accountService.saveUser(new AppUser("user","1234", null));
		accountService.saveRole(new AppRole("ADMIN"));
		accountService.saveRole(new AppRole("User"));
		accountService.addRoleToUser("admin", "ADMIN");
		accountService.addRoleToUser("admin", "USER");
		accountService.addRoleToUser("user", "USER");
		consultationRepository.save(new Consultation("aaaa", null, null, null));*/
		
		
	}
}
