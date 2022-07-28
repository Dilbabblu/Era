package com.forsys.revmantra.services;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forsys.revmantra.exceptions.AyaraCustomException;
import com.forsys.revmantra.listener.BaseListener;
import com.forsys.revmantra.model.AyaraApprovalRules;
import com.forsys.revmantra.model.AyaraRevenueContractInfo;
import com.forsys.revmantra.model.RmanDealArrangements;
import com.forsys.revmantra.model.RmanUsers;
import com.forsys.revmantra.repositories.AyaraApprovalRulesRepository;
import com.forsys.revmantra.repositories.RmanDealArrangementsRepository;
import com.forsys.revmantra.repositories.RmanDealStatusRepository;
import com.forsys.revmantra.repositories.RmanUserResponsibilitiesRepository;
import com.forsys.revmantra.repositories.RmanUsersRepository;
import com.forsys.revmantra.utils.ActivityUtils;
import com.forsys.revmantra.utils.CONSTANTS;

@Service
public class RCApprovalProcessService {
	
	private static final Logger logger = LogManager.getLogger(RCApprovalProcessService.class);
	
	@Autowired
	RuntimeService runtimeService;
	
	@Autowired
	TaskService taskService;
	
	@Autowired
	HistoryService historyService;
	
	@Autowired
	IdentityService identityService;

		
	@Autowired
	AyaraApprovalRulesRepository ayaraApprovalRulesRepository;
	
	@Autowired
	RmanDealArrangementsRepository rmanDealArrangementsRepository;
	
	
	@Autowired
	RmanDealStatusRepository rmanDealStatusRepository;
	
	@Autowired
	RmanUsersRepository rmanUsersRepository;
	
	@Autowired
	RmanUserResponsibilitiesRepository rmanUserResponsibilitiesRepository;
	
	@Autowired
	RCApprovalProcessHelper rcApprovalProcessHelper;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ActivityUtils activityUtils;
	
	public boolean processRevenueContractforApproval(AyaraRevenueContractInfo ayaraRevenueContractInfo) {
		logger.info("Process Revenue Contract for Approval");
		try {
		RmanDealArrangements dealStatusObject = rmanDealArrangementsRepository.
				findByDealArrangementId(new BigDecimal(ayaraRevenueContractInfo.getArrangementId()));
		if(dealStatusObject != null) {
			dealStatusObject.setDealArrangementTotal(new BigDecimal(ayaraRevenueContractInfo.getArrangementTotal()));
		}else {
			logger.error("Revenue Contract Number {} doesn't exist" , ayaraRevenueContractInfo.getArrangementId());
			return false;
		}
		Map<String, Object> processMap = new HashMap<>();
		processMap.put("comments", ayaraRevenueContractInfo.getComments());
		processMap.put("arrangementIdKey", ayaraRevenueContractInfo.getArrangementId());
		String assignee = BaseListener.getCurrentUser();
		if (ayaraRevenueContractInfo.getDecision() != null) {
			dealStatusObject.setAttribute12(ayaraRevenueContractInfo.getDecision().toUpperCase());
		}
		if (dealStatusObject.getAttribute11() != null) {
			rcApprovalProcessHelper.setArrangementStatusAndTaskVariable(ayaraRevenueContractInfo.getDecision(),
					ayaraRevenueContractInfo.getComments(), dealStatusObject, assignee);
			return true;
		}
		BigDecimal legalEntityId = dealStatusObject.getLegalEntityId();
		List<AyaraApprovalRules> aarulesList = ayaraApprovalRulesRepository.findByEntityIdAndActiveFlagOrderByRankingAsc(legalEntityId,"Y");
		AyaraApprovalRules aar = aarulesList.get(0);
		if (aar.getAssigneeType().equalsIgnoreCase("user")) {
				processMap.put("user",assignee);
				processMap.put("analystUser",assignee);
				processMap.put(CONSTANTS.GROUP,"");
				processMap.put("ranking", aar.getRanking().toString());
				processMap.put("analystMail", rmanUsersRepository.findByUserNameIgnoreCase(assignee).getEmailAddress());
				RmanUsers auser = rmanUsersRepository.findByUserNameIgnoreCase(assignee);
				RmanUsers muser = null;
				RmanUsers duser = null;
				if(auser.getMgrId()!=null) {
					muser = rmanUsersRepository.findByRmanUserId(auser.getMgrId());
					processMap.put("managerUser",muser.getUserName());
				}else {
					throw new AyaraCustomException("No Manager Assigned to the "+auser.getUserName());
				}
				if(muser.getMgrId()!=null) {
					duser = rmanUsersRepository.findByRmanUserId(muser.getMgrId());
					processMap.put("directorUser",duser.getUserName());
				}else {
					throw new AyaraCustomException("No Manager Assigned to the "+muser.getUserName());
				} 
			}else if(aar.getAssigneeType().equalsIgnoreCase(CONSTANTS.GROUP)) {
				processMap.put("user","");
				processMap.put(CONSTANTS.GROUP,aar.getUserRole());
				processMap.put("ranking", aar.getRanking().toString());
			}
			
			//fetch mail list of Manager and Director
			processMap.put("managerMailList", userService.fetchRoleBasedEmailList(aarulesList.get(1).getUserRole(), aarulesList.get(1).getEntityId().toString()));
			processMap.put("directorMailList", userService.fetchRoleBasedEmailList(aarulesList.get(2).getUserRole(), aarulesList.get(2).getEntityId().toString()));
			
			rcApprovalProcessHelper.initializeAndCompleteProcess(processMap, dealStatusObject, ayaraRevenueContractInfo.getComments(), assignee,ayaraRevenueContractInfo.getDecision().toUpperCase());
				return true;
		}catch(Exception e) {
			logger.error("Reevnue Contract Approval Process Service failed due to {}", e.getMessage());
			return false;
		}
					
	}
	
	public boolean delegateTaskService(String processInstanceId,String assignee) {
		logger.info("Delegate Task");
		try {
			activityUtils.delegateTask(processInstanceId, assignee);
			return true;
		} catch (Exception e) {
			logger.error("Delgate task failed due to {}", e.getMessage());
			return false;
		}
		
	}
	
	 
}
