package com.cognizant.auditchecklist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.auditchecklist.model.TokenValidator;
import com.cognizant.auditchecklist.proxy.AuthenticationProxy;

@Service
public class ValidateToken {
	@Autowired
	private AuthenticationProxy proxy;
	
	public Boolean isValidToken(String token) {
		return proxy.validateToken(new TokenValidator(token)).getIsValid();
	}
}
