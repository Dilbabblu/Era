package com.forsys.revmantra.utils;

import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.forsys.revmantra.model.RmanResponsibilities;
import com.forsys.revmantra.model.RmanUsers;

@Component
public class IdentityServiceUtils {

	@Autowired
	private IdentityService identityService;
	
	public void addIdentityuser(RmanUsers user) {
		User identityUser = identityService.newUser(user.getUserName());
		identityUser.setFirstName(user.getFirstName());
		identityUser.setLastName(user.getLastName());
		identityUser.setId(user.getUserName());
		identityUser.setPassword(user.getUserPassword());
		identityService.saveUser(identityUser);
	}
	
	public void addIdentityGroup(RmanResponsibilities resp) {
		Group identityGroup = identityService.newGroup(resp.getResponsibilityName());
		identityGroup.setId(resp.getResponsibilityName());
		identityGroup.setName(resp.getResponsibilityName());
		identityGroup.setType("assignment");
		identityService.saveGroup(identityGroup);
	}
	
	public void addIdentityMemberShip(String userName, String respName) {
		identityService.createMembership(userName, respName);
	}
}

