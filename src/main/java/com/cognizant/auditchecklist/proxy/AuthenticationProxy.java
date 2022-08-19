package com.cognizant.auditchecklist.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cognizant.auditchecklist.model.IsValidToken;
import com.cognizant.auditchecklist.model.TokenValidator;

@FeignClient(name="authorization-application",url="${AUTHENTICATION.URI:localhost:9000}")
public interface AuthenticationProxy {
	
	@PostMapping("/api/authorize/validate")
	public IsValidToken validateToken(@RequestBody TokenValidator inputToken);
}
