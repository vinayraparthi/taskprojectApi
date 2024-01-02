package com.teluguskillhub.taskproject.payload;

import lombok.Getter;

@Getter
public class JWTAuthResponse {
	
	private String token;
	private String tokenType="Bearer";
	
	public JWTAuthResponse(String token) {
		this.token=token;
	}

}
