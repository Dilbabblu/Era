package com.forsys.revmantra.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.forsys.revmantra.security.RmanPrincipal;
import com.forsys.revmantra.services.RmanUserDetailsService;

@RestController
public class Oauth2LoginController {
	
	@Autowired
	private RmanUserDetailsService userDetailsService;
	
	@GetMapping("/oauth2/loginsuccess")
	public RedirectView indexPage(@AuthenticationPrincipal OidcUser oidcUser) {
		
		RmanPrincipal userDetails = (RmanPrincipal) userDetailsService.loadUserByUsername(oidcUser.getEmail());
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		List<GrantedAuthority> updatedAuthorities = new ArrayList<>(auth.getAuthorities());
		UsernamePasswordAuthenticationToken newAuth = new UsernamePasswordAuthenticationToken(auth.getPrincipal(), auth.getCredentials(), updatedAuthorities);
		newAuth.setDetails(userDetails.getUser());
		SecurityContextHolder.getContext().setAuthentication(newAuth);
		return new  RedirectView("/index.html");
	}

}
