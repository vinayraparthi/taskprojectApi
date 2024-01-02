package com.teluguskillhub.taskproject.security;

import java.util.Date;

import org.springframework.security.config.annotation.rsocket.RSocketSecurity.JwtSpec;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.teluguskillhub.taskproject.exception.APIException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@Component
public class JwtTokenProvider {
	
	public String generatToken(Authentication authentication) {
		
		String email = authentication.getName();
		
		Date currentDate = new Date();
		Date exporeDate = new Date(currentDate.getTime()+3600000);
		
		String token = Jwts.builder()
				.setSubject(email)
				.setIssuedAt(currentDate)
				.setExpiration(exporeDate)
				.signWith(SignatureAlgorithm.HS512,"JWTSecretKey")
				.compact();
		
		return token;
		
	}
	
	public String getEmailFromToken(String token) {
		Claims claims = Jwts.parser().setSigningKey("JWTSecretKwy")
		.parseClaimsJws(token).getBody();
		
		return claims.getSubject();
	}
	
	public boolean validateToken(String token) {
		try {
			Jwts.parser().setSigningKey("JWTSecretKey")
			.parseClaimsJws(token);
			return true;
    	}
		catch(Exception e) {
			throw new APIException("Token issue :" +e.getMessage());
		}
		
	}

}
