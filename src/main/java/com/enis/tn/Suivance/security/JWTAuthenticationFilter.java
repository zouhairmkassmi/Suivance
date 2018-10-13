package com.enis.tn.Suivance.security;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.enis.tn.Suivance.entity.AppUser;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTAuthenticationFilter  extends UsernamePasswordAuthenticationFilter{
 
	private AuthenticationManager authenticationManager;

	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		super();
		this.authenticationManager = authenticationManager;
	}
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		AppUser user=null;
		try {
			user=new ObjectMapper().readValue(request.getInputStream(), AppUser.class);
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		System.out.println("**********************");
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				user.getUsername(), user.getPassword()));
	}
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		User springUser= (User) authResult.getPrincipal();
		String JwtToken = Jwts.builder()
				.setSubject(springUser.getUsername())
				.setExpiration(new Date(System.currentTimeMillis()+SecurityConstants.EXPERATION_TIME))
				.signWith(SignatureAlgorithm.HS256, SecurityConstants.SECRET)
				.claim("roles",springUser.getAuthorities() )
				.compact();
		response.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX
				+JwtToken);
		System.out.println("**********************");
		System.out.println( SecurityConstants.HEADER_STRING+"*" +SecurityConstants.TOKEN_PREFIX
				+JwtToken);
		System.out.println(response.getHeader(SecurityConstants.HEADER_STRING));
	
	}
}
