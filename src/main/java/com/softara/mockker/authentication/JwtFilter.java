package com.softara.mockker.authentication;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter {
	
	@Autowired
	JwtService jwtService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
//------
		String authHeader=request.getHeader("Authorization");
		String token=null;
		String email=null;
		
//-----check authorization header exists
		if(authHeader!=null && authHeader.startsWith("Bearer ")) {
			token=authHeader.substring(7);	//remove "Bearer "
			email= jwtService.extractEmail(token);
		}

//-----authenticate if token is valid
		if(email!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
			if(jwtService.validateToken(token)) {
				UsernamePasswordAuthenticationToken authentication= new UsernamePasswordAuthenticationToken(
						new User(email, "", java.util.Collections.emptyList()),
						null,
						java.util.Collections.emptyList());
				
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		}
		
		filterChain.doFilter(request, response);
	}

}
