package com.forsys.revmantra.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forsys.revmantra.exceptions.AyaraCustomException;
import com.forsys.revmantra.listener.BaseListener;
import com.forsys.revmantra.model.DelegateUsersWithRoles;
import com.forsys.revmantra.model.RmanResponsibilities;
import com.forsys.revmantra.model.RmanUserResponsibilities;
import com.forsys.revmantra.model.RmanUsers;
import com.forsys.revmantra.repositories.RmanResponsibilitiesRepository;
import com.forsys.revmantra.repositories.RmanUserResponsibilitiesRepository;
import com.forsys.revmantra.repositories.RmanUsersRepository;


@Service
public class UserService {
	
	private static final Logger logger = LogManager.getLogger(UserService.class);
	
	
	@Autowired
	private RmanUsersRepository rmanUsersRepository;
	
	@Autowired
	private RmanResponsibilitiesRepository rmanResponsibilitiesRepository;
	
	@Autowired
	private RmanUserResponsibilitiesRepository rmanUserResponsibilitiesRepository;
	
	
	public RmanUsers fetchUserDetails(String username) {
		return rmanUsersRepository.findByUserNameIgnoreCase(username);
	}
	
	public String fetchRoleBasedEmailList(String roleName,String entityId){
		List<String> emailList = new ArrayList<>();
		List<RmanUsers> usersList = new ArrayList<>();
		RmanResponsibilities rr = rmanResponsibilitiesRepository.findByResponsibilityName(roleName);
		
		List<RmanUserResponsibilities> rur = rmanUserResponsibilitiesRepository.findByResponsibilityId(rr.getResponsibilityId());
		
		rur.stream().forEach(user ->{
			if(rmanUsersRepository.findByRmanUserIdAndAttribute1(user.getRmanUserId(),entityId)!=null) {
				usersList.add(rmanUsersRepository.findByRmanUserIdAndAttribute1(user.getRmanUserId(),entityId));
			}	
		});
		
		
		usersList.stream().forEach(u->
			emailList.add(u.getEmailAddress())
		);
		
		return (!emailList.isEmpty() ? emailList.stream().collect(Collectors.joining(",")) : "");
	}
	
	public List<String> fetchUserRole(String userName){
		List<String> roles = new ArrayList<>();
		
		RmanUsers user = rmanUsersRepository.findByUserNameIgnoreCase(userName);
		
		List<RmanUserResponsibilities> rur = rmanUserResponsibilitiesRepository.findByRmanUserId(user.getRmanUserId());
		rur.stream().forEach(r->{
			RmanResponsibilities rr = rmanResponsibilitiesRepository.findByResponsibilityId(r.getResponsibilityId());
			roles.add(rr.getResponsibilityName());
		});
		return roles;
	}
	/**
	 * @author chandra.kota
	 * AYARA-1664
	 */
	public List<DelegateUsersWithRoles> fetchDelegateUsers(){
		try {
			List<Object[]> usersList = rmanUsersRepository.fetchDelegateUsersList(BaseListener.getCurrentUser());
			return usersList.stream().map(externalToDelagteUsersFunc)
					.collect(Collectors.<DelegateUsersWithRoles> toList());
		}catch(Exception e) {
			logger.error(e);
			throw new AyaraCustomException("Getting Error while fetching the dlegate Users for the current user due to "+e);
		}
	}
	
	Function<Object[], DelegateUsersWithRoles> externalToDelagteUsersFunc = new Function<Object[], DelegateUsersWithRoles>() {

		public DelegateUsersWithRoles apply(Object[] o) {
			DelegateUsersWithRoles dUser = new DelegateUsersWithRoles();
			dUser.setRmanUserId((BigDecimal) o[0]);
			dUser.setUserName((String) o[1]);
			dUser.setEmailAddress((String) o[2]);
			dUser.setFullName((String) o[3]);
			dUser.setEntityName((String) o[4]);
			dUser.setEntityId((BigDecimal) o[5]);
			dUser.setUserRole((String) o[6]);
			dUser.setUserRoleId((BigDecimal) o[7]);
			return dUser;
		}
	};


}
