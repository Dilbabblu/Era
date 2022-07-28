package com.forsys.revmantra.model.service.beans;

import java.math.BigDecimal;
import java.util.Optional;

import org.activiti.engine.TaskService;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.activiti.engine.task.Task;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.forsys.revmantra.model.AyaraApprovalRules;
import com.forsys.revmantra.model.AyaraRCTaskApprovalStatus;
import com.forsys.revmantra.model.RmanDealArrangements;
import com.forsys.revmantra.model.RmanUsers;
import com.forsys.revmantra.repositories.AyaraApprovalRulesRepository;
import com.forsys.revmantra.repositories.AyaraRCTaskApprovalStatusRepository;
import com.forsys.revmantra.repositories.RmanUsersRepository;
import com.forsys.revmantra.services.RevmantraService;
import com.forsys.revmantra.services.UserService;
import com.forsys.revmantra.utils.CONSTANTS;

@Component("rcAutoApprovalTaskService")
public class RCAutoApprovalTaskService implements JavaDelegate {
	
	private static final Logger logger = LogManager.getLogger(RCAutoApprovalTaskService.class);
	
	@Autowired
	private AyaraApprovalRulesRepository ayaraApprovalRulesRepository;
	
	@Autowired
	private AyaraRCTaskApprovalStatusRepository ayaraRCTaskApprovalStatusRepository;
	
	@Autowired
	private RmanUsersRepository rmanUsersRepository;
	
	@Autowired
	private RevmantraService revmantraService;
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	
	@Override
	public void execute(DelegateExecution execution) {
		RmanDealArrangements arrgDeal;
		
		try {
			Task task = taskService.createTaskQuery().active().processInstanceId(execution.getProcessInstanceId()).singleResult();
			arrgDeal = objectMapper.readValue(execution.getVariable("arrangementObject").toString(),RmanDealArrangements.class);
			BigDecimal arrgTotal = arrgDeal.getDealArrangementTotal();
			BigDecimal legalEntityId = arrgDeal.getLegalEntityId();
			BigDecimal ranking = new BigDecimal(execution.getVariable("ranking").toString());
			BigDecimal arrgId =  arrgDeal.getDealArrangementId(); 
			AyaraApprovalRules aar = ayaraApprovalRulesRepository.findByEntityIdAndRanking(legalEntityId, ranking); //Fetch the Ayara Approval Rule Object
			
			if((aar!=null && aar.getMaxValue() !=null && arrgTotal.compareTo(aar.getMinValue())>=0 && arrgTotal.compareTo(aar.getMaxValue())<=0) || (aar!=null && (aar.getMaxValue()==null) && arrgTotal.compareTo(aar.getMinValue())>=0)) {
				execution.setVariable(CONSTANTS.ISAPPROVED,true); //Assign the Auto Approval variable value to Exclusive Task 
				revmantraService.updateRCApprovalStatus(CONSTANTS.APPROVED, arrgId);
				Optional<AyaraRCTaskApprovalStatus> ayaraRCTaskApprovalStatus = ayaraRCTaskApprovalStatusRepository.findById(task.getId());
				if(!ayaraRCTaskApprovalStatus.isPresent()) {
					AyaraRCTaskApprovalStatus artStatus = new AyaraRCTaskApprovalStatus();
					artStatus.setTaskId(task.getId());
					artStatus.setTaskAction(CONSTANTS.APPROVED);
					artStatus.setRcNumber(arrgDeal.getDealArrangementId());
					ayaraRCTaskApprovalStatusRepository.save(artStatus);
				}
			}else {
				execution.setVariable(CONSTANTS.ISAPPROVED,false); //Assign the Auto Approval variable value to Exclusive Task
				AyaraApprovalRules aarule = ayaraApprovalRulesRepository.findByEntityIdAndRanking(legalEntityId,ranking.add(new BigDecimal(1)));
				
				if(aarule!=null) {
					RmanUsers ru = rmanUsersRepository.findByUserNameIgnoreCase(execution.getVariable("user").toString());
					RmanUsers mgr = null;
					BigDecimal rank = aarule.getRanking();
					if(ru.getMgrId()!=null) {
						mgr = rmanUsersRepository.findByRmanUserId(ru.getMgrId());
					}
					
					if (aarule.getAssigneeType().equalsIgnoreCase("user") && mgr!=null) {
						execution.setVariable("user", mgr.getUserName());
						execution.setVariable(CONSTANTS.GROUP,"");
						if(rank.compareTo(new BigDecimal(1)) == 0) {
							execution.setVariable("managerMailList", mgr.getEmailAddress());
						}else if(rank.compareTo(new BigDecimal(2)) == 0) {
							execution.setVariable("directorMailList", mgr.getEmailAddress());
						} 
					}else if(aarule.getAssigneeType().equalsIgnoreCase(CONSTANTS.GROUP)) {
						execution.setVariable("user","");
						execution.setVariable(CONSTANTS.GROUP,aarule.getUserRole());
						if(rank.compareTo(new BigDecimal(1)) == 0) {
							execution.setVariable("managerMailList", userService.fetchRoleBasedEmailList(aarule.getUserRole(), aarule.getEntityId().toString()));
						}else if(rank.compareTo(new BigDecimal(2)) == 0) {
							execution.setVariable("directorMailList", userService.fetchRoleBasedEmailList(aarule.getUserRole(), aarule.getEntityId().toString()));
						} 
					}
					execution.setVariable("ranking",ranking.add(new BigDecimal(1)).toString());
				}
				
			}
		} catch (Exception e) {
			logger.error(e);
		} 
			
	}
	
	
}
