package com.forsys.revmantra.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.forsys.revmantra.model.AyaraDocTransactionsInt;
import com.forsys.revmantra.model.RmanContTransToRelease;
import com.forsys.revmantra.model.RmanCustomers;
import com.forsys.revmantra.model.RmanFiscalPeriods;
import com.forsys.revmantra.model.RmanFmvRulesDef;
import com.forsys.revmantra.model.RmanFmvRulesDefParaValue;
import com.forsys.revmantra.model.RmanInvoiceLinesInterface;
import com.forsys.revmantra.model.RmanLegalEntities;
import com.forsys.revmantra.model.RmanOrdersInterface;
import com.forsys.revmantra.model.RmanPobMapping;
import com.forsys.revmantra.model.RmanProducts;
import com.forsys.revmantra.model.RmanRevenueTemplates;
import com.forsys.revmantra.model.RmanRuleParameterValue;
import com.forsys.revmantra.model.RmanRulesHeader;
import com.forsys.revmantra.model.RmanUsageSummaryInterface;
import com.forsys.revmantra.model.RmanUsers;
import com.forsys.revmantra.pojo.ResponseData;
import com.forsys.revmantra.pojo.UpstreamResponse;

public interface RevmantraService {
	
   /* 
    * AYAR-1801 Added the loggedinUserInfo Parameter for the fileUpload Process Methods 
    * 	By Chandra Kota on 05-JAN-2021
    */
	public void readyToReleaseContengency(java.math.BigDecimal transHeaderId, java.math.BigDecimal transLineId);

	public void readyToReleaseline(java.math.BigDecimal transHeaderId, java.math.BigDecimal transLineId);

	public void unlinkSalesOrder(java.math.BigDecimal arrangementId, java.math.BigDecimal soLineId,
			BigDecimal loggedUser);

	public void linkSalesOrder(java.math.BigDecimal arrangementId, java.math.BigDecimal soLineId, String dealNumber,
			java.math.BigDecimal dealLineNumber, BigDecimal loggedUser);
	
	public void processDealFile(String batchId,BufferedReader bufferedReader, String fileName) throws NumberFormatException, IOException;

	public void processPostBookingFile(String batchId,BufferedReader bufferedReader, String fileName);

	public void processshipmentsFile(String batchId,BufferedReader bufferedReader, String fileName);

	public void processInvoicesFile(String batchId,BufferedReader bufferedReader, String fileName) throws IOException;

	public void processCustomersFile(String batchId,BufferedReader bufferedReader, String fileName,RmanUsers loggedUserInfo) throws IOException;

	public void processProductsFile(String batchId,BufferedReader bufferedReader, String fileName,RmanUsers loggedUserInfo);

	public void processSSPRulesFile(String batchId,BufferedReader bufferedReader, String fileName,RmanUsers loggedUserInfo);

	public void processGLAccountsFile(String batchId,BufferedReader bufferedReader, String fileName,RmanUsers loggedUserInfo);

	public void processConversionRatesFile(String batchId,BufferedReader bufferedReader, String fileName);

	public void processAccountingPeriods(String batchId,BufferedReader bufferedReader, String fileName,RmanUsers loggedUserInfo);

	public String checkOpenLineExists(BigDecimal transLineId);

	public RmanContTransToRelease getRecord(BigDecimal transLineId);

	public RmanContTransToRelease updateContReleaseRecord(RmanContTransToRelease r);
	
	public RmanLegalEntities upsertLegalEntity(RmanLegalEntities rle);
	
	public RmanCustomers upsertCustomer(RmanCustomers rc);
	
	public RmanRevenueTemplates upsertRevenueTemplate(RmanRevenueTemplates rrt);
	
	public RmanProducts upsertProduct(RmanProducts rp); 
	
	public UpstreamResponse upsertProducts(List<RmanProducts> rpList);
	
	public RmanPobMapping upsertPOBMapping(RmanPobMapping rpm);
	
	public RmanFiscalPeriods upsertPeriod(RmanFiscalPeriods rfp);
	
	public List<RmanCustomers> upsertCustomers(List<RmanCustomers> rcList);
	
	public RmanFmvRulesDef upsertSSP(RmanFmvRulesDef ssp);
	
	public RmanFmvRulesDefParaValue upsertSSPParam(RmanFmvRulesDefParaValue sspParam);
	
	 RmanRulesHeader upsertRuleHeader(RmanRulesHeader rulesHeader);
	 
	 RmanRuleParameterValue upsertRuleParameterValue(RmanRuleParameterValue rulesParameterValue);

	public ResponseData upsertOrdersInterfaceLegacy(List<RmanOrdersInterface> rmanOrders);
	
	public ResponseData upsertOrdersInterface(List<RmanOrdersInterface> rmanOrders);
	
	public ResponseData upsertShipments(List<RmanOrdersInterface> rmanOrders);
	
	public ResponseData upsertUsageSummary(List<RmanUsageSummaryInterface> rusList);
	
	public ResponseData upsertInvoices(List<RmanInvoiceLinesInterface> invList);
	
	public String validatePeriodStatus(String periodName, String periodStatus, Date startDate, Date endDate);
	
	public RmanFiscalPeriods upsertfiscalPeriods(RmanFiscalPeriods rfp);
	
	public UpstreamResponse  upsertBulkFiscalPeriods(List<RmanFiscalPeriods> rfp);
	
	public void  usageAdjustmentProgramAfterOpenPeriod();
	
	public void  usageAdjustmentProgramBeforeClosePeriod();
	
	/*
	 *  Created the processDocuments Method  for file Uploads Process
	 *  #AYAR-479 By Chandra on 9th Jun 2021
	 */
	public void processDocuments(BigDecimal processId, BufferedReader bufferedReader, String documentName,String docuemntType,RmanUsers loggedUserInfo);
	
	/*
	 *  Created the processIntegrationDocuments Method  for Integration API
	 *  #AYAR-476 By Chandra on 9th Jun 2021
	 */
	public ResponseData processIntegrationDocuments(BigDecimal processId, List<AyaraDocTransactionsInt> docs,String documentType,BigDecimal currentUserId,String source);
	
	public String approveBookSSPRules(BigDecimal sspBookId);
	
	public void processUsageFile(String batchId,BufferedReader bufferedReader, String fileName,RmanUsers loggedUserInfo);
	
	
	public void updateRCApprovalStatus(String status,BigDecimal arrangementId);
	
	public void updateRCProcessInstance(String processInstanceID,BigDecimal arrangementId);
	
	public void approvalRevRecognising(BigDecimal arrangementId);
	

}
