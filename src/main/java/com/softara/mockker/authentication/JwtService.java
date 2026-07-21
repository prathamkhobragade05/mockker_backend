package com.softara.mockker.authentication;

import java.util.Date;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
	private final String secreteKey="8jM4yLq9vW2nX7rKbP5sFd1HcR8tY6zNaE3mU9iLsQ0xVbW7n";
	
	public String generateToken(String email) {
//		email="pratham@gmail.com";
		String token=Jwts.builder().subject(email)
				.issuedAt(new Date())
				.expiration(new Date(System.currentTimeMillis()+86400000))
				.signWith(Keys.hmacShaKeyFor(secreteKey.getBytes()))
				.compact();
		return token;
	}
	
	public String extractEmail(String token) {
		return Jwts.parser()
				.verifyWith(Keys.hmacShaKeyFor(secreteKey.getBytes()))
				.build().parseSignedClaims(token)
				.getPayload()
				.getSubject();
	}
	
	public boolean validateToken(String token) {
		try {
			extractEmail(token);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
}

