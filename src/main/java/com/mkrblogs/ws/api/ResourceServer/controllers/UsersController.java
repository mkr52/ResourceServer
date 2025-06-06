package com.mkrblogs.ws.api.ResourceServer.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController {
	
	@GetMapping("/status/check")
	public String status() {
		return "Working...";
	}
	
	@PreAuthorize("hasAuthority('ROLE_developer') and #id == #jwt.subject")
//	@PreAuthorize(value = "hasRole('developer')")
//	@PostAuthorize(value = "")
//	@Secured("ROLE_developer")
	@DeleteMapping(path = "/{id}")
    public String deleteUser(@PathVariable String id, @AuthenticationPrincipal Jwt jwt) {
        return "Deleted user with id " + id + " and JWT subject " + jwt.getSubject();
    }

}
