package com.enis.tn.Suivance.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JWTAuthorizationFilter  extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, 
			FilterChain filterChain)
			throws ServletException, IOException {
	
		System.out.println("******** test ********");
		response.addHeader("Access-Control-Allow-Origin","*");
	
		response.addHeader("Access-Control-Allow-Headers","Origin,Accept,X-REquested-With,"
				+ "Content-Type,Access-Control-Request-Method,"
				+ "Access-Control-Request-Headers,authorization");
		response.addHeader("Access-Control-Expose-Headers","Access-Control-Allow-Origin,"
				+ "Access-Control-Allow-Credentials,authorization");
		if(request.getMethod().equals("OPTIONS")){
			response.setStatus(HttpServletResponse.SC_OK);
			System.out.println("******** tester Option ********");
		}
		else {
			String JwtToken= request.getHeader(SecurityConstants.HEADER_STRING);
			System.out.println("****1 ******"+JwtToken);
			if(JwtToken==null || !JwtToken.startsWith(SecurityConstants.TOKEN_PREFIX)){
				filterChain.doFilter(request, response);
				return;
			}
			System.out.println("******** 2 ******** jwt   !=null"  );
			Claims claims=Jwts.parser()
					.setSigningKey(SecurityConstants.SECRET)
					.parseClaimsJws(JwtToken.replaceAll(SecurityConstants.TOKEN_PREFIX,""))
		              .getBody();
			System.out.println("******** 3 apres verification de signe ********" +JwtToken );
			String username=claims.getSubject();
			System.out.println("******** 4 ********" +username );
			ArrayList<Map<String,String>> roles =(ArrayList<Map<String, String>>) claims.get("roles");
			
			Collection<GrantedAuthority> autoroties = new ArrayList<>();
			roles.forEach(r->{
				autoroties.add(new SimpleGrantedAuthority(r.get("authority")) );
			
			});
			UsernamePasswordAuthenticationToken  authenticatedUser =
					new UsernamePasswordAuthenticationToken(username,null, autoroties);
			SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
			filterChain.doFilter(request, response);
		}
	
	}

}
