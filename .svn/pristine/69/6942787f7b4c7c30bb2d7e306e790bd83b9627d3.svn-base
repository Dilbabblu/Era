package com.forsys.revmantra.controller;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.forsys.revmantra.custom.RmanConcurrentProgramsDAO;
import com.forsys.revmantra.exceptions.AyaraCustomException;
import com.forsys.revmantra.model.AnalyticalReportData;
import com.forsys.revmantra.model.AyaraSalesForceQuoteResponse;
import com.forsys.revmantra.model.ProspectiveDeals;
import com.forsys.revmantra.model.RmanDealHeaders;
import com.forsys.revmantra.model.RmanErrorsInfo;
import com.forsys.revmantra.model.RmanIntfDealDetails;
import com.forsys.revmantra.model.RmanSalesforceQuoteLine;
import com.forsys.revmantra.pojo.ResponseData;
import com.forsys.revmantra.repositories.RmanDealHeadersRepository;
import com.forsys.revmantra.repositories.RmanFiscalPeriodsRepository;
import com.forsys.revmantra.repositories.RmanIntfDealDetailsRepository;
import com.forsys.revmantra.utils.CONSTANTS;
import com.forsys.revmantra.utils.RevmantraUtils;

@Controller
public class RevmantraConcurrentProgramsController {
	private static final Logger logger = LogManager.getLogger(RevmantraConcurrentProgramsController.class);

	@Autowired
	private RmanConcurrentProgramsDAO rmanConcurrentProgramsDAO;
	
	@Autowired
	private RmanDealHeadersRepository rmanDealHeadersRepository;
	
	@Autowired
	private RmanIntfDealDetailsRepository rmanIntfDealDetailsRepository;
	
	@Autowired
	private RmanFiscalPeriodsRepository rmanFiscalPeriodsRepo;
	
	@GetMapping(value = "/api/financialYears")
	@ResponseBody
	public List<BigDecimal> getFinancialYears(){
		 return rmanFiscalPeriodsRepo.getFinancialYears();
	}
	
	@GetMapping(value = "/api/periodDimensions")
	@ResponseBody
	public List<String> getPeriodDimensions(){
		 return rmanFiscalPeriodsRepo.getPeriodDimensions();
	}
	
	@GetMapping(value = "/api/dashboardOverviewFigures")
	@ResponseBody
	public String getDashboardOverviewFigures(@RequestParam(value = "fYear") String fYear, 
			@RequestParam(value = "pDimension") String pDimension,@RequestParam(value = "quarter") String quarter,
			@RequestParam(value = "period") String period) {
		return rmanConcurrentProgramsDAO.getDashboardArrangementFigures(fYear, pDimension, quarter, period);
	}
	
	@GetMapping(value = "/api/revmantra/processRmanRoleFunctions")
	@ResponseBody
	public ResponseData processRmanRoleFunctions(@RequestParam(value="responsibilityId") String responsibilityId) {
		return rmanConcurrentProgramsDAO.processRmanRoleFunctions(responsibilityId);
	}
	
	@GetMapping(value = "/api/revmantra/apivot")
	@ResponseBody
	public List<AnalyticalReportData> ayaraPivotReport(@RequestParam(value = "startDate") String startDate, @RequestParam(value = "endDate") String endDate) {
		return rmanConcurrentProgramsDAO.pivotReport(startDate,endDate);

	}
	
	@PostMapping(value = "/api/revmantra/processcontracts")
	@ResponseBody
	public boolean revmantraProcessDeals() {
		rmanConcurrentProgramsDAO.revmantraProcessContracts();
		return true;
	}
	

	@PostMapping(value = "/api/revmantra/dealFMVSubmitProcess")
	@ResponseBody
	public Boolean revmantraDealFMVSubmitProcess() {
		try {
			return rmanConcurrentProgramsDAO.revmantraDealSubmitFMVProcess();

		} catch (Exception e) {
			logger.error("Getting error while Fairvalues updating process for deal lines due to {}" , e.getMessage());
			return false;
		}
	}

	@PostMapping(value = "/api/revmantra/dealVCUpdateProcess")
	@ResponseBody
	public Boolean revmantraDealVCApplyProcess(@RequestParam(value = "arrangementId") BigDecimal arrangementID) {
		try {
			return rmanConcurrentProgramsDAO.revmantraDealVCUpdate(arrangementID);

		} catch (Exception e) {
			logger.error("Getting error while variable consideration is updating for deals due to {}" , e.getMessage());
			return false;
		}
	}

	@PostMapping(value = "/api/revmantra/dealAllocationProcess")
	@ResponseBody
	public Boolean revmantraDealAllocationProcess(@RequestParam(value = "arrangementId") BigDecimal arrangementID) {
		try {
			return rmanConcurrentProgramsDAO.revmantraDealAllocationProcess(arrangementID);

		} catch (Exception e) {
			logger.error("Getting error while Allocating the amount for deal lines due to {}" , e.getMessage());
			return false;
		}
	}

	@GetMapping(value = "/api/revmantra/getProspective")
	@ResponseBody
	public List<ProspectiveDeals> revmantraGetProspectiveProcess(
			@RequestParam(value = "arrangementId") BigDecimal arrangementID) {
		try {

			return rmanConcurrentProgramsDAO.revmantraProspectiveList(arrangementID);

		} catch (Exception e) {
			logger.error("Getting error while fetching deals to Prospective Analysis due to {}" , e.getMessage());
			return Collections.emptyList();
		}
	}

	@GetMapping(value = "/api/revmantra/mergedeals")
	@ResponseBody
	public Boolean revmantraMergeDeals(@RequestParam(value = "arrangementId") BigDecimal arrangementID,
			@RequestParam(value = "dealLinesList") BigDecimal[] dealLines,
			@RequestParam(value = "trgArrgId") BigDecimal trgArrgId) {
		try {

			return rmanConcurrentProgramsDAO.revmantraMergeDeals(arrangementID, dealLines, trgArrgId);

		} catch (Exception e) {
			logger.error("Getting error while Merge deals Process due to {}" , e.getMessage());
			return false;
		}
	}

	@GetMapping(value = "/api/revmantra/splitdeals")
	@ResponseBody
	public Boolean revmantraSplitDeals(@RequestParam(value = "arrangementId") BigDecimal arrangementID,
			@RequestParam(value = "dealLinesList") BigDecimal[] dealLines,
			@RequestParam(value = "arrgNumber") String arrgNumber, @RequestParam(value = "arrgName") String arrgName) {
		try {

			return rmanConcurrentProgramsDAO.revmantraSplitDeals(arrangementID, dealLines, arrgNumber, arrgName);

		} catch (Exception e) {
			logger.error("Getting error while Split Deal Process due to {}" , e.getMessage());
			return false;
		}
	}
	
	
	@GetMapping(value = "/api/revmantra/getProspDealsData")
	@ResponseBody
	public List<ProspectiveDeals> getRevmantraProspDealsData(
			@RequestParam(value = "arrangementId") BigDecimal arrangementID,
			@RequestParam(value = "dealLinesList") BigDecimal[] dealLines) {
		try {
			return rmanConcurrentProgramsDAO.testProspectiveDealsData(arrangementID, dealLines);

		} catch (Exception e) {
			logger.error("Getting error while fetching the deals for prospective analysis due to {}" , e.getMessage());
			return Collections.emptyList();
		}
	}

	@GetMapping(value = "/api/revmantra/prospdealsData")
	@ResponseBody
	public oracle.sql.ARRAY revmantraGetProspDeals(@RequestParam(value = "arrangementId") BigDecimal arrangementID) {
		try {

			return rmanConcurrentProgramsDAO.revmantraUndeliveredDeals(arrangementID);

		} catch (Exception e) {
			logger.error("Getting error while Prospecting the deals  due to {}" , e.getMessage());
			return null;
		}
	}
	
	/*
	 * Bug No: AYAR-403
	 * Commented the RevmantraUtils.getTime Method call due to unable to Convert the timestamp to date 
	 * and added the RevmantraUtils.getDateValue  method  to conversion Date 
	 * for the Json elements for conversionStartDate,conversionEndDate,serviceStartDate and serviceEndDate
	 * @author chandra kota on 2021-JUN-01
	 */
	@PostMapping(value = "/api/revmantra/processProspDealsData")
	@ResponseBody
	public boolean revmantraProcessProspDeals(@RequestBody String prospDeals) {
		JsonNode arrgId = null;
		JsonNode arrgNumber = null;
		JsonNode arrgName = null;
		List<ProspectiveDeals> pDealsList = new ArrayList<>();
		ProspectiveDeals[] pArray = null;
		logger.info(prospDeals);
		try {
			ObjectMapper mapper = new ObjectMapper();
			JsonNode json = mapper.readTree(prospDeals);
			if (json.isArray()) {
				arrgId = json.get(0);
				arrgNumber = json.get(1);
				arrgName = json.get(2);
				JsonNode prospdeal = json.get(3);

				if (prospdeal.isArray()) {
					for (JsonNode x : prospdeal) {
						ProspectiveDeals p = new ProspectiveDeals();
						if (x.get("dealArrangementId") != null) {
							p.setDealArrangementId(new BigDecimal(x.get("dealArrangementId").asLong()));
						}
						if (x.get("quantity") != null) {
							p.setQuantity(new BigDecimal(x.get("quantity").asLong()));
						}
						if (x.get("unitListPrice") != null) {
							p.setUnitListPrice(new BigDecimal(x.get("unitListPrice").asLong()));
						}
						if (x.get("unitSellingPrice") != null) {
							p.setUnitSellingPrice(new BigDecimal(x.get("unitSellingPrice").asLong()));
						}
						if (x.get("dealNumber") != null) {
							p.setDealNumber(x.get("dealNumber").asText());
						}
						if (x.get("dealLineNumber") != null) {
							p.setDealLineNumber(new BigDecimal(x.get("dealLineNumber").asLong()));
						}
						if (x.get("productName") != null) {
							p.setProductName(x.get("productName").asText());
						}
						if (x.get("uomCode") != null) {
							p.setUomCode(x.get("uomCode").asText());
						}
						if (x.get("dealCurrencyCode") != null) {
							p.setDealCurrencyCode(x.get("dealCurrencyCode").asText());
						}
						if (x.get("conversionRate") != null) {
							p.setConversionRate(new BigDecimal(x.get("conversionRate").asLong()));
						}
						if (!x.get("contractStartDate").isNull()) {
//							p.setContractStartDate(RevmantraUtils.getTime(x.get("contractStartDate").asText()));  // #AYAR-403 
							p.setContractStartDate(RevmantraUtils.getDateValue(x.get("contractStartDate").asText()));  // #AYAR-403  
						}
						if (!x.get("contractEndDate").isNull()) {
//							p.setContractEndDate(RevmantraUtils.getTime(x.get("contractEndDate").asText()));    // #AYAR-403 
							p.setContractEndDate(RevmantraUtils.getDateValue(x.get("contractEndDate").asText()));    // #AYAR-403 
						}
						if (!x.get("serviceStartDate").isNull()) {
//							p.setServiceStartDate(RevmantraUtils.getTime(x.get("serviceStartDate").asText()));    // #AYAR-403 
							p.setServiceStartDate(RevmantraUtils.getDateValue(x.get("serviceStartDate").asText()));   // #AYAR-403 
						}
						if (!x.get("serviceEndDate").isNull()) {
//							p.setServiceEndDate(RevmantraUtils.getTime(x.get("serviceEndDate").asText()));  // #AYAR-403 
							p.setServiceEndDate(RevmantraUtils.getDateValue(x.get("serviceEndDate").asText()));  // #AYAR-403 
						}

						if (x.get("dealLineId") != null) {
							p.setDealLineId(new BigDecimal(x.get("dealLineId").asLong()));
						}
						if (x.get("undeliveredQty") != null) {
							p.setUndeliveredQty(new BigDecimal(x.get("undeliveredQty").asLong()));

						}
						if (x.get("undQty") != null) {
							p.setUndQty(new BigDecimal(x.get("undQty").asLong()));

						}
						if (x.get("arrgType") != null) {
							p.setArrgType(x.get("arrgType").asText());
						}
						if (x.get("bundleFlag") != null) {
							p.setBundleFlag(x.get("bundleFlag").asText());
						}
						pDealsList.add(p);
					}

				}
				pArray = pDealsList.toArray(new ProspectiveDeals[pDealsList.size()]);
			}
			logger.info("The Size of PDeals Array: {}", pArray.length);

			return rmanConcurrentProgramsDAO.revmantraProcessProspectiveDeals(new BigDecimal(arrgId.asLong()),
					arrgNumber.asText(), arrgName.asText(), pDealsList);

		} catch (Exception e) {
			logger.error("Getting error while process the prospective Analysis on selected deals due to {}" , e.getMessage());
			return false;
		}
	}

	@PostMapping(value = "/api/revmantra/retrospectiveDeals")
	@ResponseBody
	public boolean revmantraRestrospectiveDeals(@RequestParam(value = "arrangementId") BigDecimal arrgId) {
		try {
			return rmanConcurrentProgramsDAO.revmantraRetrospectiveDeals(arrgId);

		} catch (Exception e) {
			logger.error("Getting error while Retrospective Analysis on Deals due to {}" , e.getMessage());
			return false;
		}
	}
	
	@GetMapping(value = "/api/revmantra/generateSSP")
	@ResponseBody
	public boolean generateSSP(@RequestParam(value = "bookId") BigDecimal bookId, @RequestParam(value = "sspType") String sspType,  @RequestParam(value = "sspCalc") String sspCalc, @RequestParam(value = "fromRange", required=false) BigDecimal fromRange, @RequestParam(value = "toRange", required=false) BigDecimal toRange, @RequestParam(value = "amount") String amount,
			@RequestParam(value = "date") String date, @RequestParam(value = "srcFrom") String srcFrom, @RequestParam(value = "srcTo") String srcTo, @RequestParam(value = "targetFrom") String targetFrom, @RequestParam(value = "targetTo") String targetTo, @RequestParam(value = "ruleName") String ruleName, @RequestParam(value = "rmanUserId") BigDecimal userId) {
		String status = null;
		String amountType = null;
		if(amount !=null && amount.equalsIgnoreCase("discount_value")) {
			amountType = "DISCOUNT";
		}else {
			amountType = amount;
		}
		try {
			if(fromRange !=null && toRange !=null)
				status =  rmanConcurrentProgramsDAO.revmantraGenerateSSP(bookId, sspType, sspCalc, fromRange, toRange, amountType, date, RevmantraUtils.getDateValue(srcFrom), RevmantraUtils.getDateValue(srcTo), RevmantraUtils.getDateValue(targetFrom), RevmantraUtils.getDateValue(targetTo), ruleName, userId);
			else
				status = rmanConcurrentProgramsDAO.revmantraGenerateSSP(bookId, sspType, sspCalc, new BigDecimal(0), new BigDecimal(0), amountType, date, RevmantraUtils.getDateValue(srcFrom), RevmantraUtils.getDateValue(srcTo), RevmantraUtils.getDateValue(targetFrom), RevmantraUtils.getDateValue(targetTo), ruleName, userId);
			return status.equals("SUCCESS");
		} catch (Exception e) {
			logger.error("Getting error while generating SSP due to {}" , e.getMessage());
			return false;
		}
	}
	

	@PostMapping(value = "/api/revmantra/dealPOBUpdateProcess")
	@ResponseBody
	public boolean revmantraRestrospectiveDeals() {
		try {
			return rmanConcurrentProgramsDAO.updatePOBIdForContracts();

		} catch (Exception e) {
			logger.error("Getting error while Update POB for Deals due to {}" , e.getMessage());
			return false;
		}
	}

	@PostMapping(value = "/api/revmantra/reallocation")
	@ResponseBody
	public boolean revmantraReAllocations(@RequestParam(value = "arrangementId") BigDecimal arrgId) {
		try {
			return rmanConcurrentProgramsDAO.reAllocation(arrgId);

		} catch (Exception e) {
			logger.error("Getting error while Re-Allocations for Deals due to {}" , e.getMessage());
			return false;
		}
	}

	@GetMapping(value = "/api/revmantra/revrecognition")
	@ResponseBody
	public boolean revmantraRevRecognition(@RequestParam(value = "orderLineId") BigDecimal orderLineId) {
		try {
			return rmanConcurrentProgramsDAO.callEventBasedRevRec(orderLineId);

		} catch (Exception e) {
			logger.error("Getting error while Rev Recognition based on event due to{}" , e.getMessage());
			return false;
		}
	}

	@GetMapping(value = "/api/revmantra/processEvents")
	@ResponseBody
	public Boolean revmantraPopulateEvents() {
		try {
			return rmanConcurrentProgramsDAO.importOrderEvents();

		} catch (Exception e) {
			logger.error("Getting error  While importing order Status Events to Revmantra due to {}" , e.getMessage());
			return false;
		}
	}
	
	@PostMapping(value = "/api/revmantra/releaseContingency")
	@ResponseBody
	public boolean revmantraContingencyRelease(@RequestParam(value = "headerId") String headerId,
			@RequestParam(value = "fromDate") String fromDate, @RequestParam(value = "toDate") String toDate,
			@RequestParam(value = "customerNumber",defaultValue = "",required = false) String customerNumber,@RequestParam(value = "productGroup",defaultValue = "",required = false) String productGroup,
			@RequestParam(value = "productFamily",defaultValue = "",required = false) String productFamily,@RequestParam(value = "productLine",defaultValue = "",required = false) String productLine,
			@RequestParam(value = "orderNumber",defaultValue = "",required = false) String orderNumber,@RequestParam(value = "customerPo",defaultValue = "",required = false) String customerPo, 
			@RequestParam(value = "releaseDate") String releaseDate) {
		try {
			return rmanConcurrentProgramsDAO.releaseContingency(headerId, fromDate, toDate, customerNumber, productGroup, productFamily, productLine, orderNumber, customerPo, releaseDate);

		} catch (Exception e) {
			logger.error("Getting error  While Releasing Contingency in Revmantra due to {}" , e.getMessage());
			return false;
		}
		
	}

	@GetMapping(value = "/api/revmantra/validateArrangementExists")
	@ResponseBody
	public String revmantraValidateArrangementExists(@RequestParam(value = "arrgNumber") String arrgNumber,
			@RequestParam(value = "arrgName") String arrgName) {
		try {
			return rmanConcurrentProgramsDAO.validateArrangementExists(arrgNumber, arrgName);

		} catch (Exception e) {
			logger.error("Getting error  While validating Arrangement exists in Revmantra due to {}" , e.getMessage());
			return null;
		}
	}

	@GetMapping(value = "/api/revmantra/soLink")
	@ResponseBody
	public List<RmanErrorsInfo> revmantraSOLinkProcess(@RequestParam(value = "ordNumber") BigDecimal orderNumber,
			@RequestParam(value = "srcArrgId") BigDecimal srcArrangementId,
			@RequestParam(value = "trgDealId") BigDecimal dealLineId) {
		try {

			return rmanConcurrentProgramsDAO.soLink(orderNumber, srcArrangementId, dealLineId);

		} catch (Exception e) {
			logger.error("Getting error while performing SO Link due to {}" , e.getMessage());
			return Collections.emptyList();
		}
	}

	@GetMapping(value = "/api/revmantra/unLinkPO")
	@ResponseBody
	public String revmantraPOUnLinkProcess(@RequestParam(value = "poNum") String poNumber,
			@RequestParam(value = "srcArrgId") BigDecimal srcArrangementId) {
		String status = null;
		try {

			status = rmanConcurrentProgramsDAO.unlinkPO(poNumber, srcArrangementId);
			if (status.equalsIgnoreCase("Y")) {
				return status;
			} else {
				throw new AyaraCustomException("Delink of PO " + poNumber + " failed");
			}

		} catch (Exception e) {
			logger.error("Getting error while performing PO {} UnLink due to {}" , poNumber, e.getMessage());
			if (status != null) {
				throw new AyaraCustomException(e.getMessage());
			} else {
				throw new AyaraCustomException("Delink of PO " + poNumber + " failed due to " + e.getMessage());
			}
		}
	}

	@GetMapping(value = "/api/revmantra/reLinkPO")
	@ResponseBody
	public String revmantraPOReLinkProcess(@RequestParam(value = "srcPoNum") String srcPoNumber,
			@RequestParam(value = "srcArrgId") BigDecimal srcArrangementId,
			@RequestParam(value = "trgPoNum") String trgPoNumber,
			@RequestParam(value = "trgArrgId") BigDecimal trgArrangementId) {
		String status = null;
		try {

			status = rmanConcurrentProgramsDAO.relinkPO(srcPoNumber, srcArrangementId, trgPoNumber, trgArrangementId);
			if (status.equalsIgnoreCase("Y")) {
				return status;
			} else {
				throw new AyaraCustomException("Relink of PO " + srcPoNumber + " failed with PO " + trgPoNumber);
			}
		} catch (Exception e) {
			logger.error("Getting error while performing PO {} ReLink With PO {} due to {}", srcPoNumber,trgPoNumber,  e.getMessage());
			if (status != null) {
				throw new AyaraCustomException(e.getMessage());
			} else {
				throw new AyaraCustomException(
						"Relink of PO " + srcPoNumber + " failed with PO " + trgPoNumber + " due to " + e.getMessage());
			}
		}
	}

	@GetMapping(value = "/api/updateGlStatus")
	@ResponseBody
	public String updateGlAcctsStatus(@RequestParam(value = "period") String period) {
		try {
			logger.info("GL Period Name: {}" , period);
			return rmanConcurrentProgramsDAO.updateGLStatus(period);

		} catch (Exception e) {
			logger.error("Getting while updating the GL Status based on the period closed due to {}" , e.getMessage());
			throw new AyaraCustomException(
					"Getting while updating the GL Status to posted for the the period closed of " + period + " due to "
							+ e.getMessage() + ".Please contact system admin.");
		}
	}
	
	@PostMapping(value = "/api/createDeal")
	@ResponseBody
    public List<RmanSalesforceQuoteLine> postDeals(@RequestBody List<RmanIntfDealDetails> rmanIntfDealDetails) throws Exception {
		try{
			
			rmanIntfDealDetailsRepository.saveAll(rmanIntfDealDetails);
			String quoteNumber = rmanIntfDealDetails.get(0).getArrangementNumber();
			List<RmanSalesforceQuoteLine> sfqList = rmanConcurrentProgramsDAO.processSFQuotes(quoteNumber);
			if (sfqList!=null) {
				return sfqList;
			} else {
				throw new AyaraCustomException("Quote "+quoteNumber+" not processed in Ayara system.Please try after sometime.");
			}
				
		} catch(Exception e){
			logger.error(e);
			throw new AyaraCustomException(e.getMessage());
			
		}
    }
	
	@PostMapping(value = "/api/sfqi/createDeal")
	@ResponseBody
    public AyaraSalesForceQuoteResponse postSfqiDeals(@RequestBody List<RmanIntfDealDetails> rmanIntfDealDetails) throws Exception {
		try{
			rmanIntfDealDetails.forEach(x->{
				if(x.getStartDate()!=null && x.getAdditionalAttribute1()!=null){
						x.setStartDate(RevmantraUtils.getDateValue(x.getAdditionalAttribute1()));
						x.setAdditionalAttribute1(null);
				}
				if(x.getEndDate()!=null && x.getAdditionalAttribute2()!=null){
						x.setEndDate(RevmantraUtils.getDateValue(x.getAdditionalAttribute2()));
						x.setAdditionalAttribute2(null);
				}
			});
			
			
			
			rmanIntfDealDetailsRepository.saveAll(rmanIntfDealDetails);
			String quoteNumber = rmanIntfDealDetails.get(0).getDealNumber();
			AyaraSalesForceQuoteResponse sfqResponse = rmanConcurrentProgramsDAO.processSFQuotesWithExceptions(quoteNumber);
			if (sfqResponse != null) {
				return sfqResponse;
			} else {
				throw new AyaraCustomException("Quote "+quoteNumber+" not processed in Ayara system.Please try after sometime.");
			}
				
		} catch(Exception e){
			logger.error(e);
			throw new AyaraCustomException(e.getMessage());
			
		}
    }
	
	@GetMapping(value = {"/api/getForecastingDeal","/api/sfqi/getForecastingDeal"},produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public String getDealsForecasting(@RequestParam(value="quoteNumber") String quoteNumber){
		try{
			
			RmanDealHeaders rmanDealHeaders = rmanDealHeadersRepository.findByDealNumber(quoteNumber);
			if (rmanDealHeaders!=null) {
				return rmanConcurrentProgramsDAO.dealForecastDetails(rmanDealHeaders.getDealArrangementId(),"N");
				
			} else {
				throw new AyaraCustomException("Unable to fetch Forecasting details for quote "+quoteNumber);
			}
				
		} catch(Exception e){
			logger.error(e);
			throw new AyaraCustomException(e.getMessage());
			
		}
    }
	
	
	@GetMapping(value = {"/api/revmantra/rfcstView","/api/sfqi/revmantra/rfcstView"})
	@ResponseBody
	public String revDealForecastingDetails(@RequestParam(value = "arrgId") BigDecimal pArrgId){
		return rmanConcurrentProgramsDAO.dealForecastDetails(pArrgId,"N");
	}
	
	@GetMapping(value = "/api/revmantra/ayaraForecastActuals")
	@ResponseBody
	public String ayaraForecastActualDetails(@RequestParam(value = "periodType", defaultValue = "PTD") String periodType){
		return rmanConcurrentProgramsDAO.ayaraForecastActualDetails(periodType);
	}
	
	@GetMapping(value = "/api/exportAyaraForecastActuals", produces = "application/vnd.ms-excel")
	@ResponseBody
	public String exportAyaraForecastActualsRep(@RequestParam(value = "periodType", defaultValue = "PTD") String periodType,
			 @RequestParam(value="exportCols", required=false) List<String> exportCols, HttpServletResponse response) {
		logger.info("Export of Ayara Forecast Actuals Report Initiated");
		String reportDate = new java.text.SimpleDateFormat(CONSTANTS.YYYY_MM_DD_HH_MM_SS)
				.format(new java.util.Date(System.currentTimeMillis()));
		response.setHeader(CONSTANTS.CONTENT_DISPOSITION, "inline; filename=Ayara Forecast Actuals Report Report_" + reportDate + ".csv");
		String json = rmanConcurrentProgramsDAO.ayaraForecastActualDetails(periodType);

		try {

			JsonNode arrNode = new ObjectMapper().readTree(json).get("Content");
			CsvMapper mapper = new CsvMapper();
			mapper.setDateFormat(new SimpleDateFormat(CONSTANTS.MM_DD_YYYY));
			mapper.enable(JsonGenerator.Feature.IGNORE_UNKNOWN);

			List<CsvSchema.Column> columns = new ArrayList<>();
			int i = 0; 
			
			for (Iterator<String> iterator = exportCols.iterator(); iterator.hasNext();) {
				String eachExportCol = iterator.next();
				
				Iterator<String> cols = arrNode.get(0).fieldNames();
				while(cols.hasNext()) {
					String str = cols.next();
					String replacedStr = str.replaceAll("[#$/()]*", "").trim(); 
					if(eachExportCol.equalsIgnoreCase(replacedStr)) {
						columns.add(new CsvSchema.Column(i,str));
						i++;
						break;
					}
				}
			}
			
			CsvSchema schema = CsvSchema.builder().setColumnSeparator(',').addColumns(columns).setUseHeader(true)
					.build();

			ObjectWriter objectWriter = mapper.writer(schema);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(baos, 1024);
			OutputStreamWriter writerOutputStream;
			writerOutputStream = new OutputStreamWriter(bufferedOutputStream, StandardCharsets.UTF_8);
			objectWriter.writeValue(writerOutputStream, arrNode);
			writerOutputStream.close();
			return getCSVData(CONSTANTS.ERROR_FORECAST_ACTUALS_REPORT_EXPORT, baos);
		} catch (IOException e) {
			logger.error(CONSTANTS.ERROR_FORECAST_ACTUALS_REPORT_EXPORT , e.getMessage());
		} 
		return null;
	}

	
	@PostMapping(value = "/api/revmantra/reverseLTandSTAccountEntry")
	@ResponseBody
	public boolean revmantraProcessLTAndSTReversaljob() {
		return rmanConcurrentProgramsDAO.revmantraLTandSTReversal();
	}

	@GetMapping(value = {"/api/revmantra/rfcstActualView","/api/sfqi/revmantra/rfcstActualView"})
	@ResponseBody
	public String revDealForecastActualDetails(@RequestParam(value = "arrgId") BigDecimal pArrgId){
		return rmanConcurrentProgramsDAO.dealForecastAcualDetails(pArrgId);
	}
	
	@PostMapping(value = "/api/revmantra/splitProcess")
	@ResponseBody
	public ResponseData revmantraSplitProcess(@RequestParam(value = "srcRc") BigDecimal srcRc,
			@RequestParam(value = "sourceContractHeaderIds") BigDecimal[] sourceContractHeaderIds,
			@RequestParam(value = "flag") String flag) {
		try {
			return rmanConcurrentProgramsDAO.processSplit(srcRc, sourceContractHeaderIds, flag);

		} catch (Exception e) {
			logger.error("Getting error in Split Process due to {}" , e.getMessage());
			return null;
		}
		
	}
	
	
	@PostMapping(value = "/api/revmantra/mergeProcess")
	@ResponseBody
	public ResponseData revmantraMergeProcess(@RequestParam(value = "srcRc") BigDecimal srcRc,
			@RequestParam(value = "sourceContractHeaderIds") BigDecimal[] sourceContractHeaderIds, @RequestParam(value = "trgRc") BigDecimal trgRc, 
			@RequestParam(value = "flag") String flag) {
		try {
			return rmanConcurrentProgramsDAO.processMerge(srcRc, sourceContractHeaderIds,trgRc, flag);
		} catch (Exception e) {
			logger.error("Getting error in Merge Process due to {}" , e.getMessage());
			return null;
		}
	}
	
	/*
	 * AYAR-1790 By Chandra on JAN 05th 2022
	 */
	@GetMapping(value = "/api/actualRevenueScheduleReport",produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public String actualRevenueScheduleReport(@RequestParam(value="arrgId") BigDecimal arrgId){
		try{
			
			return rmanConcurrentProgramsDAO.actualRevenueScheduleReport(arrgId);
				
		} catch(Exception e){
			logger.error(e);
			throw new AyaraCustomException(e.getMessage());
			
		}
    }
	
	public String getCSVData(String reportName, ByteArrayOutputStream baos) {
		String csvData = baos.toString();

		try {
			baos.close();
		} catch (IOException e) {
			logger.error(reportName , e.getMessage());
		}

		return csvData;
	}
	
}
