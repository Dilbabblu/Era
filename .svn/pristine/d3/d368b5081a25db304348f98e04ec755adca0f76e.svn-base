package com.forsys.revmantra.controller;

import java.math.BigDecimal
;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.forsys.revmantra.model.RmanFiscalPeriods;
import com.forsys.revmantra.model.RmanRuleParameterValue;
import com.forsys.revmantra.model.RmanRulesHeader;
import com.forsys.revmantra.repositories.RmanFiscalPeriodsRepository;
import com.forsys.revmantra.repositories.RmanRuleParameterValueRepository;
import com.forsys.revmantra.repositories.RmanRulesHeaderRepository;
import com.forsys.revmantra.salesforce.AuthenticationResponse;
import com.forsys.revmantra.salesforce.SalesforceService;
import com.forsys.revmantra.services.RevmantraServiceImpl;
import com.forsys.revmantra.utils.CONSTANTS;
import com.forsys.revmantra.utils.RevmantraUtils;

@Controller
public class SalesforceController {
	
	private static final Logger logger = LogManager.getLogger(SalesforceController.class);
	
	@Autowired
	private RevmantraServiceImpl revmantraService;
	
	@Autowired
	private SalesforceService salesforceService;
	
	@Autowired
	private RmanRulesHeaderRepository rmanRulesHeaderRepo;
	
	@Autowired
	private RmanRuleParameterValueRepository rmanRuleParameterValueRepo;
	
	@Autowired
	private RmanFiscalPeriodsRepository rmanFiscalPeriodsRepo;
	
	
	@PostMapping(value = "/api/RMAN_RULES_HEADER")
	@ResponseBody
	public RmanRulesHeader saveRuleHeaders(@RequestBody RmanRulesHeader rrh){
		RmanRulesHeader rrhs = rmanRulesHeaderRepo.save(rrh);
		if(RevmantraUtils.getProperty(CONSTANTS.SFDC_CONTROLLER_ENABLED).equals("true")){
			try{
				AuthenticationResponse authenticationResponse = salesforceService.login();
				ResponseEntity<String> fpResponse = salesforceService.syncArrgGroupingRule(rrhs,authenticationResponse.getAccess_token(), authenticationResponse.getInstance_url());
				String responseBody = fpResponse.getBody();
				if(responseBody!=null) {
					rrhs.setAttribute26("SFDC");
					rrhs.setAttribute27(responseBody.replaceAll(CONSTANTS.CHARS, ""));
					logger.info("Arrangement Grouing Rule Sync with SFDC Successfully: {}",responseBody);
					return rmanRulesHeaderRepo.save(rrhs);
				}
				else{
					logger.info("Arrangement Grouing Rule Sync with SFDC Failed");
				}
			}catch(NullPointerException e) {
				logger.error(CONSTANTS.NULL_PTR_EXCEPTION, e.getMessage());
			}catch(Exception e){
				logger.error(e);
			}
			
		}
		return rrhs;
	}
	
	@PutMapping(value = "/api/RMAN_RULES_HEADER/{ruleHeaderId}")
	@ResponseBody
	public RmanRulesHeader updateRuleHeaders(@PathVariable BigDecimal ruleHeaderId,@RequestBody RmanRulesHeader rrh){
		RmanRulesHeader rrhs = rmanRulesHeaderRepo.save(rrh);
		if(RevmantraUtils.getProperty(CONSTANTS.SFDC_CONTROLLER_ENABLED).equals("true")){
			try{
				AuthenticationResponse authenticationResponse = salesforceService.login();
				ResponseEntity<String> fpResponse = salesforceService.syncArrgGroupingRule(rrhs,authenticationResponse.getAccess_token(), authenticationResponse.getInstance_url());
				String responseBody = fpResponse.getBody();
				if(responseBody!=null) {
					rrhs.setAttribute26("SFDC");
					rrhs.setAttribute27(responseBody.replaceAll(CONSTANTS.CHARS, ""));
					logger.info("Updated Arrangement Grouing Rule Sync with SFDC Successfully: {}", responseBody);
					return rmanRulesHeaderRepo.save(rrhs);
				}
				else{
					logger.info("Updated Arrangement Grouing Rule Sync with SFDC Failed");
				}
			}catch(NullPointerException e) {
				logger.error(CONSTANTS.NULL_PTR_EXCEPTION, e.getMessage());
			}catch(Exception e){
				logger.error(e);
			}
		}
		return rrhs;
	}
	
	@DeleteMapping(value = "/api/RMAN_RULES_HEADER/{ruleHeaderId}")
	@ResponseBody
	public void deleteRuleHeaders(@PathVariable BigDecimal ruleHeaderId){
		rmanRulesHeaderRepo.deleteById(ruleHeaderId);
		
	}
	
	@PostMapping(value = "/api/RMAN_RULE_PARAMETER_VALUE")
	@ResponseBody
	public RmanRuleParameterValue saveRuleParameterValue(@RequestBody RmanRuleParameterValue rrp){
		RmanRuleParameterValue rrpv = rmanRuleParameterValueRepo.save(rrp);
		if(RevmantraUtils.getProperty(CONSTANTS.SFDC_CONTROLLER_ENABLED).equals("true")){
			try{
				AuthenticationResponse authenticationResponse = salesforceService.login();
				ResponseEntity<String> fpResponse = salesforceService.syncArrgGroupingRuleParameterVal(rrpv,authenticationResponse.getAccess_token(), authenticationResponse.getInstance_url());
				String responseBody = fpResponse.getBody();
				if(responseBody !=null) {
					rrpv.setAttribute26("SFDC");
					rrpv.setAttribute28(responseBody.replaceAll(CONSTANTS.CHARS, ""));
					logger.info("Arrangement Grouing Rule Parameter value Sync with SFDC Successfully: {}",responseBody);
					return rmanRuleParameterValueRepo.save(rrpv);
				}
				else{
					logger.info("Arrangement Grouing Rule Parameter value Sync with SFDC Failed");
				}
			}catch(NullPointerException e) {
				logger.error(CONSTANTS.NULL_PTR_EXCEPTION, e.getMessage());
			}catch(Exception e){
				logger.error(e);
			}
		}	
		return rrpv;
	}
	
	@PutMapping(value = "/api/RMAN_RULE_PARAMETER_VALUE/{parameterValueId}")
	@ResponseBody
	public RmanRuleParameterValue updateRuleParameterValue(@PathVariable BigDecimal parameterValueId,@RequestBody RmanRuleParameterValue rrp){
		RmanRuleParameterValue rrpv = rmanRuleParameterValueRepo.save(rrp);
		if(RevmantraUtils.getProperty(CONSTANTS.SFDC_CONTROLLER_ENABLED).equals("true")){
			try{
				AuthenticationResponse authenticationResponse = salesforceService.login();
				ResponseEntity<String> fpResponse = salesforceService.syncArrgGroupingRuleParameterVal(rrpv,authenticationResponse.getAccess_token(), authenticationResponse.getInstance_url());
				String responseBody = fpResponse.getBody();
				if(responseBody !=null) {
					rrpv.setAttribute26("SFDC");
					rrpv.setAttribute28(responseBody.replaceAll(CONSTANTS.CHARS, ""));
					logger.info("Updated Arrangement Grouing Rule Parameter Value Sync with SFDC Successfully: {}",responseBody);
					return rmanRuleParameterValueRepo.save(rrpv);
				}
				else{
					logger.info("Updated Arrangement Grouing Rule  Parameter Value Sync with SFDC Failed");
				}
			}catch(NullPointerException e) {
				logger.error(CONSTANTS.NULL_PTR_EXCEPTION, e.getMessage());
			}catch(Exception e){
				logger.error(e);
			}
		}	
		return rrpv;
	}
	
	@DeleteMapping(value = "/api/RMAN_RULE_PARAMETER_VALUE/{parameterValueId}")
	@ResponseBody
	public void deleteRuleParameterValue(@PathVariable BigDecimal parameterValueId){
		rmanRuleParameterValueRepo.deleteById(parameterValueId);
	}
	
	
	@PostMapping(value = "/api/RMAN_FISCAL_PERIODS")
	@ResponseBody
	public RmanFiscalPeriods saveFiscalPeriod(@RequestBody RmanFiscalPeriods rfp){
		RmanFiscalPeriods rfps = rmanFiscalPeriodsRepo.save(rfp);
		if(RevmantraUtils.getProperty(CONSTANTS.SFDC_CONTROLLER_ENABLED).equals("true")){
			try{
				AuthenticationResponse authenticationResponse = salesforceService.login();
				ResponseEntity<String> fpResponse = salesforceService.syncFiscalPeriods(rfps,authenticationResponse.getAccess_token(), authenticationResponse.getInstance_url());
				String responseBody = fpResponse.getBody();
				if(responseBody!=null) {
					rfps.setAdditionalAttribute1(responseBody.replaceAll(CONSTANTS.CHARS, ""));
					logger.info("Fiscal Period Sync with SFDC Successfully: {}",responseBody);
					return rmanFiscalPeriodsRepo.save(rfps);
				}
				else{
					logger.info("Fiscal Period Sync with SFDC Failed");
				}
			}catch(NullPointerException e) {
				logger.error(CONSTANTS.NULL_PTR_EXCEPTION, e.getMessage());
			}catch(Exception e){
				logger.error(e);
			}
			
		}	
		return rfps;
	}
	
	@PutMapping(value = "/api/RMAN_FISCAL_PERIODS/{rmanPeriodId}")
	@ResponseBody
	public RmanFiscalPeriods updateFiscalPeriod(@PathVariable BigDecimal rmanPeriodId,@RequestBody RmanFiscalPeriods rfp){
		
		RmanFiscalPeriods checkPeriod = rmanFiscalPeriodsRepo.findById(rfp.getRmanPeriodId()).get();
		
		String previousPeriod = checkPeriod.getPeriodStatus();
		
		/** 
		 * Check for the Period Status Before CLOSE from OPEN
		 * Calling the Usage Adjustment Program before the CLOSE Period
		 */
		
		if(checkPeriod.getPeriodStatus().equalsIgnoreCase("OPEN") && rfp.getPeriodStatus().equalsIgnoreCase("CLOSED")) {
			logger.info("Calling the Usage Adjustment Program before Closing Period");
		
			revmantraService.usageAdjustmentProgramBeforeClosePeriod();
		}
		
		
		RmanFiscalPeriods rfps = rmanFiscalPeriodsRepo.save(rfp);
		
		
		/** 
		 * Check for the Period Status From FUTURE to OPEN
		 * Calling the Usage Adjustment Program after the OPEN Period
		 */
		if((previousPeriod.equalsIgnoreCase("FUTURE")||previousPeriod.equalsIgnoreCase("CLOSED")) && rfps.getPeriodStatus().equalsIgnoreCase("OPEN")) {
			logger.info("Calling the Usage Adjustment Program after Open period");
			revmantraService.usageAdjustmentProgramAfterOpenPeriod();
		}
		
		
		if(RevmantraUtils.getProperty(CONSTANTS.SFDC_CONTROLLER_ENABLED).equals("true")){
			
			try {
				/** 
				 * #ISV-300 By Chandra on 2021-JUN-08
				 * Move the below line to try block to handle exception instead before try block
				 */
				
				AuthenticationResponse authenticationResponse = salesforceService.login();
				
				ResponseEntity<String> fpResponse = salesforceService.syncFiscalPeriods(rfps,authenticationResponse.getAccess_token(), authenticationResponse.getInstance_url());
				String responseBody = fpResponse.getBody();
				
				if(responseBody!=null) {
					if(rfps.getAdditionalAttribute1()!=null && responseBody.equalsIgnoreCase(rfps.getAdditionalAttribute1())) {
						logger.info("Updated Fiscal Period Sync with SFDC Successfully: {}",fpResponse.getBody());
					}else {
						rfps.setAdditionalAttribute1(responseBody.replaceAll(CONSTANTS.CHARS, ""));
						logger.info("Updated Fiscal Period Sync with SFDC Successfully and SFDC id updated in the Rman Fiscal Period: {}",fpResponse.getBody());
						return rmanFiscalPeriodsRepo.save(rfps);
					}
					
				}else{
					logger.info("Updated Fiscal Period Sync with SFDC Failed");
				}
			}catch(NullPointerException e) {
				logger.error(CONSTANTS.NULL_PTR_EXCEPTION, e.getMessage());
			}
			catch(Exception e) {
				logger.error("Updated Fiscal Period Sync with SFDC Failed due to");
				logger.error(e);
			}
			
		}	
		return rfps;
	}
	
	@DeleteMapping(value = "/api/RMAN_FISCAL_PERIODS/{rmanPeriodId}")
	@ResponseBody
	public void deleteFiscalPeriod(@PathVariable BigDecimal rmanPeriodId){
		rmanFiscalPeriodsRepo.deleteById(rmanPeriodId);
	}

}
