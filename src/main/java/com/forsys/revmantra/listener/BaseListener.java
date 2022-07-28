package com.forsys.revmantra.listener;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import com.forsys.revmantra.model.RmanUserResponsibilities;
import com.forsys.revmantra.model.RmanUsers;
import com.forsys.revmantra.security.RmanPrincipal;

public class BaseListener {

	private static Log logger = LogFactory.getLog(BaseListener.class);

	public static String getCurrentUser() {
		if (SecurityContextHolder.getContext() != null
				&& SecurityContextHolder.getContext().getAuthentication() != null) {

			Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
			RmanUsers rmanUser = null;
			if (userDetails instanceof WebAuthenticationDetails) {

				Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

				if (principal instanceof RmanPrincipal) {

					rmanUser = ((RmanPrincipal) principal).getUser();

				}
			} else if (userDetails instanceof RmanUsers) {

				rmanUser = (RmanUsers) userDetails;
			}
			
			if(rmanUser!=null) {
				logger.info("Getting logged in user info  :"+rmanUser.getUserName());
				return rmanUser.getUserName();
				
				
			}else {
				logger.info("Not able to retrive logged in user ifo");
			}
		}
		return null;
		
	}

	public static RmanUsers getUserInfo() {

		if (SecurityContextHolder.getContext() != null
				&& SecurityContextHolder.getContext().getAuthentication() != null) {
			Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
			RmanUsers rmanUser = null;
			if (userDetails instanceof WebAuthenticationDetails) {

				Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

				if (principal instanceof RmanPrincipal) {
					rmanUser = ((RmanPrincipal) principal).getUser();
				}
			} else if (userDetails instanceof RmanUsers) {
				rmanUser = (RmanUsers) userDetails;
			}
			
			if(rmanUser!=null) {
				return rmanUser;
				
			}
		}
		return null;
	}

	public static BigDecimal getCurrentUserId() {

		if (SecurityContextHolder.getContext() != null
				&& SecurityContextHolder.getContext().getAuthentication() != null) {
			Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
			RmanUsers rmanUser = null;
			if (userDetails instanceof WebAuthenticationDetails) {
				Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				if (principal instanceof RmanPrincipal) {
					rmanUser = ((RmanPrincipal) principal).getUser();
				}
			} else if (userDetails instanceof RmanUsers) {
				rmanUser = (RmanUsers) userDetails;
			}
			if(rmanUser!=null) {
				return rmanUser.getRmanUserId();
			}
		}
		return null;
	}

	public static Integer getLegalEntityId() {

		if (SecurityContextHolder.getContext() != null
				&& SecurityContextHolder.getContext().getAuthentication() != null) {
			Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
			RmanUsers rmanUser = null;
			if (userDetails instanceof WebAuthenticationDetails) {
				Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				if (principal instanceof RmanPrincipal) {
					rmanUser = ((RmanPrincipal) principal).getUser();
				}
			} else if (userDetails instanceof RmanUsers) {
				rmanUser = (RmanUsers) userDetails;
			}
			if(rmanUser!=null) {
				return Integer.valueOf(rmanUser.getAttribute1());
			}
		}
		return null;
	}

	public static List<String> getUserRole() {
		
		List<String> rolesList = new ArrayList<>();
		if (SecurityContextHolder.getContext() != null
				&& SecurityContextHolder.getContext().getAuthentication() != null) {

			Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
			RmanUsers rmanUser = null;
			if (userDetails instanceof WebAuthenticationDetails) {
				Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				if (principal instanceof RmanPrincipal) {
					rmanUser = ((RmanPrincipal) principal).getUser();
				}
			} else if (userDetails instanceof RmanUsers) {
				rmanUser = (RmanUsers) userDetails;
			}
			if(rmanUser!=null) {
				Iterator<RmanUserResponsibilities> x = rmanUser
						.getRmanUserResponsibilitiesSet().iterator();
				if (x.hasNext())
					rolesList.add(x.next().getRmanResponsibilities().getResponsibilityName());
				return rolesList;
			}
		}
		return null;
	}
}
