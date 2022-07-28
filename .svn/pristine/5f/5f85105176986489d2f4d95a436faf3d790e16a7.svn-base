package com.forsys.revmantra.salesforce;

import org.springframework.http.ResponseEntity;

import com.forsys.revmantra.model.RmanFiscalPeriods;
import com.forsys.revmantra.model.RmanRuleParameterValue;
import com.forsys.revmantra.model.RmanRulesHeader;

public interface SalesforceService {
	public AuthenticationResponse login();
	public ResponseEntity<String> syncFiscalPeriods(RmanFiscalPeriods rfp,String accessToken,String instanceUrl);
	public ResponseEntity<String> syncArrgGroupingRule(RmanRulesHeader rfp,String accessToken,String instanceUrl);
	public ResponseEntity<String> syncArrgGroupingRuleParameterVal(RmanRuleParameterValue rrpv,String accessToken,String instanceUrl);
}
