package com.forsys.revmantra.salesforce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.forsys.revmantra.model.RmanFiscalPeriods;
import com.forsys.revmantra.model.RmanRuleParameterValue;
import com.forsys.revmantra.model.RmanRulesHeader;
import com.forsys.revmantra.repositories.RmanEntityParametersRepository;
import com.forsys.revmantra.utils.CONSTANTS;
import com.forsys.revmantra.utils.RevmantraUtils;

@Service
public class SalesforceServiceImpl implements SalesforceService {
	
	@Autowired
	private RmanEntityParametersRepository rmanEntityParametersRepo;
	
	@Override
	public AuthenticationResponse login() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		MultiValueMap<String, String> params= new LinkedMultiValueMap<>();
		 
		params.add("username", RevmantraUtils.getProperty("sf.username"));
		params.add("password", RevmantraUtils.getProperty("sf.password"));
		params.add("client_secret", RevmantraUtils.getProperty("sf.clientSecret"));
		params.add("client_id", RevmantraUtils.getProperty("sf.clientId"));
		params.add("grant_type","password");
		 
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);
		 
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<AuthenticationResponse> response = restTemplate.postForEntity(RevmantraUtils.getProperty("sf.url"), request, AuthenticationResponse.class);
		return response.getBody();
	}

	@Override
	public ResponseEntity<String> syncFiscalPeriods(RmanFiscalPeriods rfp, String accessToken, String instanceUrl) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set(CONSTANTS.AUTHORIZATION, CONSTANTS.BEARER + accessToken);
		FiscalPeriods fp = new FiscalPeriods();
		fp.setYearStartDate(rfp.getYearStartDate());
		fp.setStartDate(rfp.getStartDate());
		fp.setEndDate(rfp.getEndDate());
		fp.setRmanPeriodId(rfp.getRmanPeriodId());
		fp.setQuarterStartDate(rfp.getQuarterStartDate());
		fp.setQuarterNum(rfp.getQuarterNum());
		fp.setQuarterName(rfp.getQuarterName());
		fp.setPeriodName(rfp.getPeriodName());
		fp.setOpenFlag(rfp.getOpenFlag());
		fp.setLedgerName(rfp.getLedgerName());
		fp.setPeriodNum(rfp.getPeriodNum());
		fp.setPeriodYear(rfp.getPeriodYear());
		fp.setPeriodStatus(rfp.getPeriodStatus());
		fp.setAdditionalAttribute1(rfp.getAdditionalAttribute1());
		FiscalPeriodsRequest fpr = new  FiscalPeriodsRequest();
		fpr.setWrap(fp);
		/**MultiValueMap<String, String> params= new LinkedMultiValueMap<String, String>(); */
		HttpEntity<FiscalPeriodsRequest> request = new HttpEntity<>(fpr, headers);
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.exchange(instanceUrl+ "/services/apexrest/FiscalPeriod/", HttpMethod.POST,request, String.class);
	}

	@Override
	public ResponseEntity<String> syncArrgGroupingRule(RmanRulesHeader rrh, String accessToken, String instanceUrl) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set(CONSTANTS.AUTHORIZATION, CONSTANTS.BEARER + accessToken);
		ArrangementGroupingRules agr = new ArrangementGroupingRules();
		agr.setRuleHeaderId(rrh.getRuleHeaderId());
		agr.setRuleName(rrh.getRuleName());
		agr.setDescription(rrh.getDescription());
		agr.setRuleCategory(rrh.getRuleCategory());
		agr.setRuleStartDate(rrh.getRuleStartDate());
		agr.setRuleEndDate(rrh.getRuleEndDate());
		agr.setSequenceNumber(rrh.getSequenceNumber());
		
		ArrangementGroupingRulesRequest agrRequest = new  ArrangementGroupingRulesRequest();
		agrRequest.setWrap(agr);
		/**MultiValueMap<String, String> params= new LinkedMultiValueMap<String, String>(); */
		HttpEntity<ArrangementGroupingRulesRequest> request = new HttpEntity<>(agrRequest, headers);
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.exchange(instanceUrl+ "/services/apexrest/groupingRule/", HttpMethod.POST,request, String.class);
	}

	@Override
	public ResponseEntity<String> syncArrgGroupingRuleParameterVal(RmanRuleParameterValue rrpv, String accessToken,
			String instanceUrl) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set(CONSTANTS.AUTHORIZATION, CONSTANTS.BEARER + accessToken);
		ArrangementGroupingRuleParameters agrpv = new ArrangementGroupingRuleParameters();
		agrpv.setParameterValueId(rrpv.getParameterValueId());
		agrpv.setRuleHeaderId(rrpv.getRuleHeaderId());
		agrpv.setParameterGroup(rrpv.getParameterGroup());
		agrpv.setParameterId(rmanEntityParametersRepo.findById(rrpv.getParameterId()).get().getParameterName());
		agrpv.setQualifier(rrpv.getQualifier());
		agrpv.setParameterValue(rrpv.getParameterValue());
		agrpv.setAndOr(rrpv.getAndOr());
		
		ArrangementGroupingRuleParametersRequest agrPvRequest = new  ArrangementGroupingRuleParametersRequest();
		agrPvRequest.setWrap(agrpv);
		/**MultiValueMap<String, String> params= new LinkedMultiValueMap<String, String>(); */
		HttpEntity<ArrangementGroupingRuleParametersRequest> request = new HttpEntity<>(agrPvRequest, headers);
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.exchange(instanceUrl+ "/services/apexrest/ruleParameter/", HttpMethod.POST,request, String.class);
	}
	
	}
