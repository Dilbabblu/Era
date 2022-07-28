package com.forsys.revmantra.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.forsys.revmantra.exceptions.AyaraCustomException;
import com.forsys.revmantra.model.AyaraRevenueContractInfo;
import com.forsys.revmantra.model.DelegateUsersWithRoles;
import com.forsys.revmantra.services.RCApprovalProcessService;
import com.forsys.revmantra.services.UserService;

@RestController
public class RCApprovalProcessController {
	
	@Autowired
	private RCApprovalProcessService rcApprovalProcessService;
	
	@Autowired
	private UserService userService;
	
	/*
	 * Method will start the Activiti process engine and set employee to perform
	 * the task
	 */
    @PostMapping(value = "/api/processContract")
    @ResponseBody
	public boolean startProcessInstance(@RequestBody AyaraRevenueContractInfo ayaraRevenueContractInfo) {
    	try {
    		return rcApprovalProcessService.processRevenueContractforApproval(ayaraRevenueContractInfo);
    	}catch(Exception e) {
    		throw new AyaraCustomException("Approval Process Controller Exception due to "+e);
    	}
    	
	}
    
    @GetMapping("/api/delegateTask")
    @ResponseBody
    public boolean delgateTask(@RequestParam(value="processInstanceId") String processInstanceId,@RequestParam(value="assignee") String assignee) {
    	try {
    		return rcApprovalProcessService.delegateTaskService(processInstanceId, assignee);
    	}catch(Exception e) {
    		throw new AyaraCustomException("Exception occured while delegating task: "+e);
    	}
    }
    /**
	 * @author chandra.kota
	 * AYARA-1664
	 */
    @GetMapping(value = "/api/fetchDelegateUsers")
	@ResponseBody
	public List<DelegateUsersWithRoles> fetchDelegateUsersList()  {
		return userService.fetchDelegateUsers();
	}
}
