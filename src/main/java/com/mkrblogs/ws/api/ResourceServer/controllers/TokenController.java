package com.mkrblogs.ws.api.ResourceServer.controllers;

import static java.util.Collections.singletonMap;

import java.util.Collections;
import java.util.Map;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/token")
public class TokenController {
	
	@GetMapping
	public Map<String, Object> getToken(@AuthenticationPrincipal Jwt jwt) {
		// Maps AuthenticatedPrincipal(User) to JWT
		return singletonMap("principal", jwt);
	}

}
