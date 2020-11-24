package io.shangan23.api.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.shangan23.api.exception.InvalidCredentials;
import io.shangan23.api.model.Authentication;
import io.shangan23.api.util.JwtUtil;

@RestController
@RequestMapping("/api/v1/")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping("/authenticate")
	public ResponseEntity<?> authenticate(@RequestBody Authentication auth) {
		try {
			authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(auth.getUsertName(), auth.getPassword()));
		} catch (Exception e) {
			throw new InvalidCredentials("Invalid Username and Password!");
		}
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(auth.getUsertName());
		
		final String jwt = jwtUtil.generateToken(userDetails);
		auth.setJwt(jwt);	
		Map<String,String> jwtToken = new HashMap<>();
		jwtToken.put("jwt", auth.getJwt());
		return ResponseEntity.ok(jwtToken);
	}

}
