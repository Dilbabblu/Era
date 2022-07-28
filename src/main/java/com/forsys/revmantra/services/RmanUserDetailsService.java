package com.forsys.revmantra.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.forsys.revmantra.model.RmanUsers;
import com.forsys.revmantra.repositories.RmanUsersRepository;
import com.forsys.revmantra.security.RmanPrincipal;

@Service
public class RmanUserDetailsService implements UserDetailsService {
	
	private static final Logger logger = LogManager.getLogger(RmanUserDetailsService.class);

	@Autowired
	private RmanUsersRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) {
		logger.info(username, "{} Logged into the Ayara Application.");
		RmanUsers user = userRepository.findByUserNameIgnoreCaseAndEnabledFlag(username,"Y");
		if (user == null) {
			logger.info(username, "{} try to logged into the Ayara Application.But user doesn't exists");
			throw new UsernameNotFoundException(username);
		}
		return new RmanPrincipal(user);
	}
}