package com.forsys.revmantra.services;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;

import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.forsys.revmantra.model.AyaraActiveDelegateUsersListV;
import com.forsys.revmantra.model.RmanDealArrangements;
import com.forsys.revmantra.model.RmanLookupsV;
import com.forsys.revmantra.repositories.AyaraActiveDelegateUsersListVRepository;
import com.forsys.revmantra.repositories.RmanDealArrangementsRepository;
import com.forsys.revmantra.repositories.RmanLookupsVRepository;
import com.forsys.revmantra.utils.ActivityUtils;
import com.forsys.revmantra.utils.CONSTANTS;

@PropertySource("classpath:META-INF/application.properties")
@Component("rcApprovalProcessHelper")
public class RCApprovalProcessHelper {
	
	private static final Logger logger = LogManager.getLogger(RCApprovalProcessHelper.class);
	
	@Autowired
	private TaskService taskService;
		
	@Autowired
	private RmanDealArrangementsRepository rmanDealArrangementRepository;
	
	@Autowired
	private ActivityUtils activityUtils;
	
	@Value("${mail.username}")
	String mailFrom;
	
	@Value("${analystMailSubject}")
	String analystMailSubject;
	
	@Value("${analystMailBody}")
	String analystMailBody;

	@Value("${analystAutoApprovalMailSubject}")
	String analystAutoApprovalMailSubject;
	
	@Value("${analystAutoApprovalMailBody}")
	String analystAutoApprovalMailBody;

	@Value("${managerMailSubject}")
	String managerMailSubject;
	
	@Value("${managerMailBody}")
	String managerMailBody;
	
	@Value("${managerAutoApprovalMailSubject}")
	String managerAutoApprovalMailSubject;
	
	@Value("${managerAutoApprovalMailBody}")
	String managerAutoApprovalMailBody;
	
	@Value("${managerApprovalMailSubject}")
	String managerApprovalMailSubject;
	
	@Value("${managerApprovalMailBody}")
	String managerApprovalMailBody;

	@Value("${managerRejectionMailSubject}")
	String managerRejectionMailSubject;

	@Value("${managerRejectionMailBody}")
	String managerRejectionMailBody;

	
	@Value("${directorApprovalMailSubject}")
	String directorApprovalMailSubject;
	
	@Value("${directorApprovalMailBody}")
	String directorApprovalMailBody;

	@Value("${directorRejectionMailSubject}")
	String directorRejectionMailSubject;
	
	@Value("${directorRejectionMailBody}")
	String directorRejectionMailBody;
	
	@Value("${arrangementProcessId}")
	String arrangementProcessId;
	
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private RmanLookupsVRepository rmanLookupsVRepository;
	
	@Autowired
	private AyaraActiveDelegateUsersListVRepository ayaraActiveDelegateUsersListVRepository;
	
	@Autowired
	RmanDealArrangementsRepository rmanDealArrangementsRepository;

	@Transactional
	public void setArrangementStatusAndTaskVariable(String status, String comments, RmanDealArrangements dealStatusObject,
			String taskAsignee) {
		logger.info("Setting of Arrangement Status and Task vriables");
		try {
			String processId = String.valueOf(dealStatusObject.getAttribute11());
			Task task = taskService.createTaskQuery().active().processInstanceId(processId).singleResult();
			Map<String,Object> taskVariables = new HashMap<>();
			if(status.equalsIgnoreCase("APPROVED") || status.equalsIgnoreCase("SUBMITTED") || status.equalsIgnoreCase("SUBMITTED_FOR_APPROVAL")) {
				taskVariables.put(CONSTANTS.ISAPPROVED, true);
				taskVariables.put(CONSTANTS.COMMENTS,comments);
				taskVariables.put("RCNumber", String.valueOf(dealStatusObject.getDealAgreementId()));
				AyaraActiveDelegateUsersListV userInfo = ayaraActiveDelegateUsersListVRepository.findByUserName(taskAsignee);
				RmanLookupsV approvalStatus = rmanLookupsVRepository.findBylookupTypeNameAndLookupCode("RANK_BASED_APPROVAL_STAUS", userInfo.getRank()); 
				taskVariables.put(CONSTANTS.OUTCOME, approvalStatus.getLookupDescription());
			}else {
				
				taskVariables.put(CONSTANTS.ISAPPROVED, false);
				taskVariables.put(CONSTANTS.COMMENTS,comments);
				taskVariables.put("RCNumber", String.valueOf(dealStatusObject.getDealAgreementId()));
				taskVariables.put(CONSTANTS.OUTCOME, "Request for more Info");
			}
			dealStatusObject.setAttribute12(taskVariables.get(CONSTANTS.OUTCOME).toString());
			activityUtils.taskComplete(taskVariables,processId,comments,taskAsignee,String.valueOf(dealStatusObject.getDealArrangementId()));
			rmanDealArrangementsRepository.save(dealStatusObject);
			logger.info("Task {} for Revenue Contract Number {} is complete.", task, dealStatusObject.getDealArrangementId());
		} catch (Exception e) {
			logger.error("Task failed for Revenue Contract Number {} exception {} ", dealStatusObject.getDealArrangementId(), e.getMessage());
		}
	}
	
	@Transactional
	public void initializeAndCompleteProcess(Map<String, Object> processMap, RmanDealArrangements rmanDealArrangements, String comments,
			String taskAssignee,String status) {
		logger.info("initializeAndCompleteProcess");
		try {
				processMap.put(CONSTANTS.ARRANGEMENT_OBJECT,
					objectMapper.writeValueAsString(rmanDealArrangements));
				String arrgId = rmanDealArrangements.getDealArrangementNumber();
				processMap.put(CONSTANTS.COMMENTS, comments);
				setArrangementProcessMapHelper(processMap, arrgId);
				ProcessInstance processInstance = activityUtils.getProcessInstance(processMap, arrangementProcessId);
				Task task = taskService.createTaskQuery().active().processInstanceId(processInstance.getId())
					.singleResult();
				rmanDealArrangements.setAttribute11(processInstance.getId());
				taskService.setVariable(task.getId(), "dealObject", objectMapper.writeValueAsString(rmanDealArrangements));
				rmanDealArrangementRepository.save(rmanDealArrangements);
				Map<String,Object> taskVariables = new HashMap<>();
				taskVariables.put(CONSTANTS.ISAPPROVED, true);
				taskVariables.put(CONSTANTS.COMMENTS, comments);
				AyaraActiveDelegateUsersListV userInfo = ayaraActiveDelegateUsersListVRepository.findByUserName(taskAssignee);
				RmanLookupsV approvalStatus = rmanLookupsVRepository.findBylookupTypeNameAndLookupCode("RANK_BASED_APPROVAL_STAUS", userInfo.getRank()); 
				taskVariables.put(CONSTANTS.OUTCOME, approvalStatus.getLookupDescription());
				activityUtils.taskComplete(taskVariables,processInstance.getId(), comments, taskAssignee,arrgId);
				
		} catch (Exception e) {
			logger.error("error in completing submit arrangement task for arrangementId {} exception {}" , rmanDealArrangements.getDealArrangementId(), e.getMessage());
		}
	}
	private void setArrangementProcessMapHelper(Map<String, Object> processMap, String arrgId) {
		logger.info("setArrangementProcessMapHelper");
		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		String strDate = dateFormat.format(date);
		analystMailBody = MessageFormat.format(analystMailBody, arrgId, strDate);
		analystAutoApprovalMailBody = MessageFormat.format(analystAutoApprovalMailBody, arrgId);
		managerMailBody = MessageFormat.format(managerMailBody, arrgId, strDate);
		managerAutoApprovalMailBody = MessageFormat.format(managerAutoApprovalMailBody, arrgId);
		managerApprovalMailBody = MessageFormat.format(managerApprovalMailBody, arrgId);
		managerRejectionMailBody = MessageFormat.format(managerRejectionMailBody, arrgId);
		directorApprovalMailBody = MessageFormat.format(directorApprovalMailBody, arrgId);
		directorRejectionMailBody = MessageFormat.format(directorRejectionMailBody, arrgId);
		analystMailSubject = MessageFormat.format(analystMailSubject,arrgId);
		analystAutoApprovalMailSubject = MessageFormat.format(analystAutoApprovalMailSubject,arrgId);
		analystAutoApprovalMailSubject = MessageFormat.format(analystAutoApprovalMailSubject,arrgId);
		managerMailSubject = MessageFormat.format(managerMailSubject,arrgId);
		managerAutoApprovalMailSubject = MessageFormat.format(managerAutoApprovalMailSubject,arrgId);
		managerApprovalMailSubject = MessageFormat.format(managerApprovalMailSubject,arrgId);
		managerRejectionMailSubject = MessageFormat.format(managerRejectionMailSubject,arrgId);
		directorApprovalMailSubject = MessageFormat.format(directorApprovalMailSubject,arrgId);
		directorRejectionMailSubject = MessageFormat.format(directorRejectionMailSubject,arrgId);
		processMap.put("analystMailSubject", analystMailSubject);		
		processMap.put("analystMailBody", analystMailBody);
		processMap.put("analystAutoApprovalMailSubject", analystAutoApprovalMailSubject);
		processMap.put("analystAutoApprovalMailBody", analystAutoApprovalMailBody);
		processMap.put("managerMailSubject", managerMailSubject);
		processMap.put("managerMailBody", managerMailBody);
		processMap.put("managerAutoApprovalMailSubject", managerAutoApprovalMailSubject);
		processMap.put("managerAutoApprovalMailBody", managerAutoApprovalMailBody);
		processMap.put("managerApprovalMailSubject", managerApprovalMailSubject);
		processMap.put("managerApprovalMailBody", managerApprovalMailBody);
		processMap.put("managerRejectionMailSubject", managerRejectionMailSubject);
		processMap.put("managerRejectionMailBody", managerRejectionMailBody);
		processMap.put("directorApprovalMailSubject", directorApprovalMailSubject);
		processMap.put("directorApprovalMailBody", directorApprovalMailBody);
		processMap.put("directorRejectionMailSubject", directorRejectionMailSubject);
		processMap.put("directorRejectionMailBody", directorRejectionMailBody);
		processMap.put("mailFrom", mailFrom);
	}

}
