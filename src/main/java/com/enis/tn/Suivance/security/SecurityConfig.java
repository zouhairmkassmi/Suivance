package com.enis.tn.Suivance.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
 //Spring security va utilise le userdetailService et lorsque il va comparer le mot de
	//de passe il va connaitre qu'il faut hacher le mot de pass (par passwordEncoder)
	//puis comparer le mot de passe hacher avec celle hacher dans la base  
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService)
		.passwordEncoder(bCryptPasswordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//http.formLogin();
		http.csrf().disable();
		//desactivation des Session 
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		//l'operation d'authetification et d'inscription ne necessite pas d'etres 
		//authentitifer,si on a partie front qui a un formulaire de login ou sign
		//in l'utulisateur a le droit pour cela on a met la phrase ci dessus 
		//car sinon il ne peut pas faire aucun operaion 
		http.authorizeRequests().antMatchers("/login/**","/register/**").permitAll();
		
		//n'authorise pas l'ajout d'une consultation que pour le role adminatrateur 
		http.authorizeRequests().antMatchers(HttpMethod.POST,"/consulatation/**").hasAuthority("ADMIN");
		http.authorizeRequests().anyRequest().authenticated();
	
		
		//ce filtre va faire la generation de token s'il y une success athentication
		http.addFilter(new JWTAuthenticationFilter(authenticationManager()));
		http.addFilterBefore(new JWTAuthorizationFilter(),UsernamePasswordAuthenticationFilter.class );
	}
}
