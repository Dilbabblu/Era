package com.forsys.revmantra.controller;

import java.util.Objects;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.forsys.revmantra.exceptions.AyaraCustomException;
import com.forsys.revmantra.model.JwtRequest;
import com.forsys.revmantra.model.JwtResponse;

@Controller
public class JwtAuthenticationController {
	
	private static final  Logger logger = LogManager.getLogger(JwtAuthenticationController.class);

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private com.forsys.revmantra.config.JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserDetailsService jwtInMemoryUserDetailsService;

	@PostMapping(value = "/api/sfqi/authenticate")
	public ResponseEntity<JwtResponse> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest)
			throws AyaraCustomException {
		try {
			authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
	
			final UserDetails userDetails = jwtInMemoryUserDetailsService
					.loadUserByUsername(authenticationRequest.getUsername());
	
			final String token = jwtTokenUtil.generateToken(userDetails);
	
			return ResponseEntity.ok(new JwtResponse(token));
		}catch(Exception e) {
			logger.error(e);
			throw new AyaraCustomException(e.getMessage());
		}
	}

	private void authenticate(String username, String password) throws AyaraCustomException {
		Objects.requireNonNull(username);
		Objects.requireNonNull(password);

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new AyaraCustomException("USER_DISABLED: "+e);
		} catch (BadCredentialsException e) {
			throw new AyaraCustomException("INVALID_CREDENTIALS: "+ e);
		}
	}
}
