package com.forsys.revmantra.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class BasicLoginController {
	
	private static final Logger logger = LogManager.getLogger(BasicLoginController.class);
	
	
	@GetMapping("/basic/loginsuccess")
	public RedirectView indexPage() {
		final String INTEGRATION_USER_ROLE="ROLE_FLODATA_INTEGRATION";
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		try {
			
			List<GrantedAuthority> updatedAuthorities = new ArrayList<>(auth.getAuthorities());
			if(updatedAuthorities.contains(new SimpleGrantedAuthority(INTEGRATION_USER_ROLE)) || updatedAuthorities.isEmpty()) {
				return new  RedirectView("/logout");
			}
			return new  RedirectView("/index.html");
		}catch(Exception e) {
			logger.error("Getting error while the user {} login with basic Authentication due to {}",auth.getPrincipal(), e.getMessage());
			return new  RedirectView("/logout");
		}
		
	}
	
}
