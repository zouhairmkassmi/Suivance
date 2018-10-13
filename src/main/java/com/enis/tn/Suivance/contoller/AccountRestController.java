package com.enis.tn.Suivance.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.enis.tn.Suivance.dao.UserRepository;
import com.enis.tn.Suivance.entity.AppUser;
import com.enis.tn.Suivance.service.AccountService;

@RestController
public class AccountRestController {
    @Autowired
	private AccountService accountService;
    @Autowired
    private UserRepository userRepo;
    @PostMapping("/register")
     public AppUser saveUser(@RequestBody RegisterForm userForm) {
    	if (! userForm.getPassword().equals(userForm.getRepassword()))
    		throw new RuntimeException("You must comfirm your password");
    	AppUser user= accountService.findUserByUsername(userForm.getUsername());
    	if(user !=null) throw new RuntimeException("User already  Exists");
    	AppUser appUser = new AppUser();
    	appUser.setUsername(userForm.getUsername());
    	appUser.setPassword(userForm.getPassword());
    	  accountService.saveUser(appUser);
    	  accountService.addRoleToUser(userForm.getUsername(),"USER");
    	  return appUser;
     }
    @GetMapping("/user")
    public List<AppUser> getUsers(){
		return this.userRepo.findAll();
    	
    }
}
