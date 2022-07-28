package com.forsys.revmantra.utils;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.forsys.revmantra.exceptions.AyaraCustomException;
import com.forsys.revmantra.model.AyaraApprovalRules;
import com.forsys.revmantra.model.AyaraRCTaskApprovalStatus;
import com.forsys.revmantra.model.RmanDealArrangements;
import com.forsys.revmantra.repositories.AyaraApprovalRulesRepository;
import com.forsys.revmantra.repositories.AyaraRCTaskApprovalStatusRepository;
import com.forsys.revmantra.repositories.RmanDealArrangementsRepository;
import com.forsys.revmantra.services.RevmantraService;

@PropertySource("classpath:META-INF/application.properties")
@Component
public class ActivityUtils {
	
	private static final Logger logger = LogManager.getLogger(ActivityUtils.class);
	
	@Autowired 
	private RuntimeService runtimeService;
	
	@Autowired 
	private TaskService taskService;
	
	@Autowired
	private RevmantraService revmantraService;
	
	@Autowired
	private RmanDealArrangementsRepository rmanDealArrangementsRepository;
	
	@Autowired
	private AyaraApprovalRulesRepository ayaraApprovalRulesRepository;
	
	@Autowired
	AyaraRCTaskApprovalStatusRepository ayaraRCTaskApprovalStatusRepository;
	
	
	@Autowired
	private ObjectMapper objectMapper;
	
	
	public ProcessInstance getProcessInstance(Map<String, Object> processMap,String processKeyId) throws AyaraCustomException{
		try {
			return runtimeService.startProcessInstanceByKey(processKeyId,processMap);
		} catch (Exception e) {
			logger.error("Error in creating activity process workflow");
			throw new AyaraCustomException("Error in creating activity process workflow exception "+e);
		}
	}
	
	public void taskComplete(Map<String,Object> taskVaribales,String processId,String comment,String assignee,String rcNumber) throws AyaraCustomException{
		Task task = null;
		String taskExecutionId = null;
		logger.info("Task Complete process");
		try{
			task = taskService.createTaskQuery().active().processInstanceId(processId).singleResult();
			taskExecutionId = task.getExecutionId();
			String taskId = task.getId();
			RmanDealArrangements arrgDeal = objectMapper.readValue(runtimeService.getVariable(taskExecutionId,"arrangementObject").toString(),RmanDealArrangements.class);
			runtimeService.setVariable(taskExecutionId,CONSTANTS.ISAPPROVED,taskVaribales.get(CONSTANTS.ISAPPROVED));
			runtimeService.setVariable(taskExecutionId,"comments",taskVaribales.get("comments"));
			
			if(!(boolean) taskVaribales.get(CONSTANTS.ISAPPROVED)) {
				BigDecimal ranking = new BigDecimal(runtimeService.getVariable(taskExecutionId, CONSTANTS.RANKING).toString());
				if(ranking.compareTo(new BigDecimal(0)) != 0) {
					BigDecimal rank = ranking.subtract(new BigDecimal(1));
					runtimeService.setVariable(taskExecutionId,CONSTANTS.RANKING,rank.toString()); 
					AyaraApprovalRules aar = ayaraApprovalRulesRepository.findByEntityIdAndRanking(arrgDeal.getLegalEntityId(), rank); //Fetch the Ayara Approval Rule Object
					if(aar!=null && rank.compareTo(new BigDecimal(0))==0) {
						if(aar.getAssigneeType().equalsIgnoreCase("user")) {
							runtimeService.setVariable(taskExecutionId,"user",runtimeService.getVariable(task.getExecutionId(), "analystMail").toString());
							runtimeService.setVariable(taskExecutionId,CONSTANTS.GROUP,"");
						}
					}else if(aar!=null && rank.compareTo(new BigDecimal(1))==0) {
						if(aar.getAssigneeType().equalsIgnoreCase("user")) {
							runtimeService.setVariable(taskExecutionId,"user",runtimeService.getVariable(taskExecutionId, "managerMailList").toString());
							runtimeService.setVariable(task.getExecutionId(),CONSTANTS.GROUP,"");
						}else if(aar.getAssigneeType().equalsIgnoreCase(CONSTANTS.GROUP)) {
							runtimeService.setVariable(taskExecutionId,"user","");
							runtimeService.setVariable(taskExecutionId,CONSTANTS.GROUP,aar.getUserRole());
						}
					}
				}
			}
			
			if (StringUtils.isNotEmpty(comment))
				taskService.addComment(task.getId(),processId,comment);
			
			if (assignee != null){
				taskService.setAssignee(task.getId(), assignee);
			}
			taskService.complete(task.getId());
			Optional<AyaraRCTaskApprovalStatus> ayaraRCTaskApprovalStatus = 
					ayaraRCTaskApprovalStatusRepository.findById(taskId);
			if(!ayaraRCTaskApprovalStatus.isPresent()) {
				AyaraRCTaskApprovalStatus arctas = new AyaraRCTaskApprovalStatus();
				arctas.setTaskId(taskId);
				arctas.setTaskAction(taskVaribales.get("outcome").toString());
				arctas.setRcNumber(new BigDecimal(rcNumber));
				saveTaskActionStatus(arctas);
				RmanDealArrangements rc = rmanDealArrangementsRepository.findByDealArrangementId(arrgDeal.getDealArrangementId());
				rc.setAttribute12(taskVaribales.get("outcome").toString());
				rmanDealArrangementsRepository.save(rc);
			}else {
				RmanDealArrangements rc = rmanDealArrangementsRepository.findByDealArrangementId(arrgDeal.getDealArrangementId());
				rc.setAttribute12(ayaraRCTaskApprovalStatus.get().getTaskAction());
				rmanDealArrangementsRepository.save(rc);
			}
			/*
			 * #AYAR-1683 By Chandra on 21-10-2021 Added below Code for the RevRec call upon Approval
			 */
			RmanDealArrangements rc = rmanDealArrangementsRepository.findByDealArrangementId(arrgDeal.getDealArrangementId());
			
			if (rc.getAttribute12()!=null && rc.getAttribute12().equalsIgnoreCase("APPROVED")) {
				logger.info("Revenue Recognition Call Initiated for the Revenue Contract : {}", rc.getDealArrangementId());
				revmantraService.approvalRevRecognising(rc.getDealArrangementId());
				logger.info("Revenue Recognition Call completed for the Revenue Contract : {}", rc.getDealArrangementId());
			}
			logger.info("Task {} for processId {}  is complete", task, processId);
		}
		catch(Exception e){
			if (task!=null) {
				BigDecimal ranking = new BigDecimal(runtimeService.getVariable(taskExecutionId, CONSTANTS.RANKING).toString());
				runtimeService.setVariable(taskExecutionId,CONSTANTS.RANKING,ranking.add(new BigDecimal(1)).toString());
			}
			logger.error("Complete task failed exception {}", e.getMessage());
			throw new AyaraCustomException("Error in completing the task "+e);
		}
		
	}
	
	public void delegateTask(String processId,String assignee) throws AyaraCustomException{
		try{
			Task task = taskService.createTaskQuery().active().processInstanceId(processId).list().get(0);
			if (assignee != null){
				taskService.setAssignee(task.getId(), assignee);
			}
		}
		catch(Exception e){
			logger.error("Delgate Task failed exception due to {}", e.getMessage());
			throw new AyaraCustomException("Delgate Task failed due to "+e);
		}
		
	}
	
	public void saveTaskActionStatus(AyaraRCTaskApprovalStatus ayaraRCTaskApprovalStatus) {
		try{
			ayaraRCTaskApprovalStatusRepository.save(ayaraRCTaskApprovalStatus);
		}catch (Exception e) {
			logger.error(e);
			throw new AyaraCustomException("Getting error while persist the Approval Status for Task due to "+e);
		}
	}

}
