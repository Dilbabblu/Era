package com.forsys.revmantra.controller;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.forsys.revmantra.exceptions.AyaraCustomException;
import com.forsys.revmantra.listener.BaseListener;
import com.forsys.revmantra.model.AyaraDocTransactionsInt;
import com.forsys.revmantra.model.AyaraFileUploadStorage;
import com.forsys.revmantra.model.RmanAccountSetup;
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
import com.forsys.revmantra.model.XTestClob;
import com.forsys.revmantra.pojo.ResponseData;
import com.forsys.revmantra.pojo.UpstreamResponse;
import com.forsys.revmantra.repositories.AyaraDocTransactionsIntRepository;
import com.forsys.revmantra.repositories.AyaraFileUploadStorageRepository;
import com.forsys.revmantra.repositories.RmanAccountSetupRepository;
import com.forsys.revmantra.repositories.XTestClobRepository;
import com.forsys.revmantra.services.RevmantraService;
import com.forsys.revmantra.utils.CONSTANTS;

/*
 * AYAR-1801 Updated RevmnatraService Async Methods with new Parameters 
 * By Chandra Kota on 05-JAN-2021
 */

@Controller
public class RevmantraServiceController {

	private static final Logger logger = LogManager.getLogger(RevmantraServiceController.class);

	private static final String SUCCESS_MSG = "Success";
	private static final String FAILURE_MSG = "Failed";

	@Autowired
	private RevmantraService revmantraService;
	

	@Autowired
	private XTestClobRepository xTestClobRepo;
	
	@Autowired
	private RmanAccountSetupRepository rmanAccountSetupRepo;
	

	@Autowired
	private AyaraFileUploadStorageRepository ayaraFileUploadStorageRepository;
	
	@Autowired
	private AyaraDocTransactionsIntRepository ayaraDocTransactionsIntRepository;

	@PostMapping(value = "/api/saveTestClob")
	@ResponseBody
	public XTestClob saveXTestClob(@RequestBody XTestClob xTestClob) {
		try {
			return xTestClobRepo.save(xTestClob);
		} catch (Exception e) {
			logger.error(CONSTANTS.ERROR_WHILE_SAVING , e.getMessage());
			return null;
		}
	}
	
	@GetMapping(value = "/api/getClobs")
	@ResponseBody
	public List<XTestClob> getTestClob() {
		try {
			return xTestClobRepo.findAll();
		} catch (Exception e) {
			logger.error(CONSTANTS.ERROR_WHILE_SAVING , e.getMessage());
			return Collections.emptyList();
		}
	}
	
	@GetMapping(value = "/api/getOneClob")
	@ResponseBody
	public XTestClob getOneTestClob(@RequestParam("id") BigDecimal id) {
		try {
			return xTestClobRepo.findById(id).get();
		} catch (Exception e) {
			logger.error(CONSTANTS.ERROR_WHILE_SAVING , e.getMessage());
			return null;
		}
	}
	
	@DeleteMapping(value = "/api/deleteOneClob")
	@ResponseBody
	public void deleteTestClob(@RequestParam("id") BigDecimal id) {
		try {
			xTestClobRepo.deleteById(id);
		} catch (Exception e) {
			logger.error(CONSTANTS.ERROR_WHILE_SAVING , e.getMessage());
		}
	}
	
	@PutMapping(value = "/api/updateOneClob")
	@ResponseBody
	public XTestClob updateTestClob(@RequestBody XTestClob xTestClob) {
		try {
			return xTestClobRepo.save(xTestClob);
		} catch (Exception e) {
			logger.error(CONSTANTS.ERROR_WHILE_SAVING , e.getMessage());
			return null;
		}
	}
	
	@PutMapping(value = "/api/updateclobs")
	@ResponseBody
	public List<XTestClob> updateClobs(@RequestBody List<XTestClob> xTestClobs) {
		try {
			return xTestClobRepo.saveAll(xTestClobs);
		} catch (Exception e) {
			logger.error("Getting Error while updating Reports Data due to {}" , e.getMessage());
			return Collections.emptyList();
		}
	}
	
	@GetMapping(value = "/api/snapshotData")
	@ResponseBody
	public String getSnapshotData() {
		return null;
	}

	@GetMapping(value = "/api/loggedUserInfo")
	@ResponseBody
	public RmanUsers getloogedUserInfo() {
		try {
			RmanUsers userInfo = BaseListener.getUserInfo();
			userInfo.setUserPassword("********");
			return userInfo;
		} catch (Exception e) {
			logger.error("Getting while fetching user info when logged in Revmantra Application due to {}" , e.getMessage());
			return null;
		}
	}

	@GetMapping(value = "/api/releaseContingency")
	@ResponseBody
	public String releaseContingency(@RequestParam(value = "transHeaderId") BigDecimal transHeaderId,
			@RequestParam(value = "transLineId") BigDecimal transLineId) {
		try {
			revmantraService.readyToReleaseContengency(transHeaderId, transLineId);
			return SUCCESS_MSG;
		} catch (Exception e) {
			logger.error(" Getting error while contingency is ready to release due to {}" , e.getMessage());
			return FAILURE_MSG;
		}
	}

	@GetMapping(value = "/api/releaseContInsertReleaseLine")
	@ResponseBody
	public String releaseContingencyInsertReleaseLine(@RequestParam(value = "transHeaderId") BigDecimal transHeaderId,
			@RequestParam(value = "transLineId") BigDecimal transLineId) {
		logger.info("Release contingency process initiated");
		RmanContTransToRelease r = revmantraService.getRecord(transLineId);
		String chkVal = revmantraService.checkOpenLineExists(transLineId);

		logger.info("Fetching the results of the open Lines in Order while at line level : {}" , chkVal);

		if (chkVal.equalsIgnoreCase("N")) {
			revmantraService.readyToReleaseline(transHeaderId, transLineId);
		} else {
			if (r.getAttribute6() != null) {
				revmantraService.readyToReleaseContengency(transHeaderId, transLineId);
				throw new AyaraCustomException(
						"Selected Source Line Number " + r.getAttribute6() + " is still in Open State");
			} else {
				revmantraService.readyToReleaseContengency(transHeaderId, transLineId);
				throw new AyaraCustomException(
						"Selected Sales Order " + r.getAttribute5() + " has lines in Open State");
			}

		}

		logger.info("Contingency Rlease process completed");

		return SUCCESS_MSG;
	}
	
	@GetMapping(value = "/api/checkPeriodStatus")
	@ResponseBody
	public String checkPeriodStatus(@RequestParam(value = "periodName") String periodName, @RequestParam(value = "periodStatus") String periodStatus, 
			 @RequestParam(value = "startDate") String startDate,  @RequestParam(value = "endDate") String endDate) throws ParseException {
		
		logger.info("validating Period Status");
		String status = revmantraService.validatePeriodStatus(periodName, periodStatus,new SimpleDateFormat("yyyy-MM-dd").parse(startDate),new SimpleDateFormat("yyyy-MM-dd").parse(endDate));
		status = (status == null || status.equalsIgnoreCase("null") || status.equals("")) ?  "success":  status;
		return status;
	}

	@GetMapping(value = "/api/unlinkSoLine")
	@ResponseBody
	public String unLinkSoLine(@RequestParam(value = "arrangementId") BigDecimal arrangementId,
			@RequestParam(value = "soLineId") BigDecimal soLineId) {
		BigDecimal userId = BaseListener.getCurrentUserId();
		try {
			revmantraService.unlinkSalesOrder(arrangementId, soLineId, userId);
			return SUCCESS_MSG;
		} catch (Exception e) {
			logger.error("Getting error while Sales Order line is unlink from Arrangement the  due to {}" , e.getMessage());
			return FAILURE_MSG;
		}
	}

	@GetMapping(value = "/api/linkSoLine")
	@ResponseBody
	public String linkSoLine(@RequestParam(value = "arrangementId") BigDecimal arrangementId,
			@RequestParam(value = "soLineId") BigDecimal soLineId,
			@RequestParam(value = "dealNumber") String dealNumber,
			@RequestParam(value = "dealLineNumber") BigDecimal dealLineNumber) {
		BigDecimal userId = BaseListener.getCurrentUserId();
		try {
			revmantraService.linkSalesOrder(arrangementId, soLineId, dealNumber, dealLineNumber, userId);
			return SUCCESS_MSG;
		} catch (Exception e) {
			logger.error("Getting error while Sales Order line is unlink from Arrangement the  due to {}" , e.getMessage());
			return FAILURE_MSG;
		}
	}
	
	@PostMapping(value = "upload/quotes", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ResponseBody
	public String handleQuoteFileUpload(@RequestParam(value = "file") MultipartFile file) {
		byte[] byteArr = null;
		BufferedReader readCsvBuffer = null;
		InputStream inputStream = null;
		InputStreamReader insr = null;
		try {
			byteArr = file.getBytes();
		} catch (IOException e1) {
			throw new AyaraCustomException(CONSTANTS.FILE_READING_FAILED);
		}
		inputStream = new ByteArrayInputStream(byteArr);
		insr = new InputStreamReader(inputStream);
		readCsvBuffer = new BufferedReader(insr);
		String fileType = file.getOriginalFilename().subSequence(0, 5).toString();
		if (!fileType.equalsIgnoreCase("QUOTE")) {
			throw new AyaraCustomException(
					"This file name doesn't start With QUOTE key word (Fileformat: QUOTE-SALES-20201012.csv)");
		} else {
			try {
				String batchId = String.valueOf(System.currentTimeMillis());
				uploadFileStorageProcess(new BigDecimal(batchId),file.getContentType(),file.getOriginalFilename(),file.getBytes());
				revmantraService.processDealFile(batchId,readCsvBuffer, file.getOriginalFilename());
				return SUCCESS_MSG;
			} catch (Exception e) {
				throw new AyaraCustomException(e.getMessage());
			}

		}

	}


	@PostMapping(value = "upload/pb", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ResponseBody
	public String handlePBFileUpload(@RequestParam(value = "file") MultipartFile file) {
		byte[] byteArr = null;
		BufferedReader readCsvBuffer = null;
		InputStream inputStream = null;
		InputStreamReader insr = null;
		
		try {
			byteArr = file.getBytes();
		} catch (IOException e1) {
			throw new AyaraCustomException(CONSTANTS.FILE_READING_FAILED);
		}
		inputStream = new ByteArrayInputStream(byteArr);
		insr = new InputStreamReader(inputStream);
		readCsvBuffer = new BufferedReader(insr);
		String fileType = file.getOriginalFilename().subSequence(0, 4).toString();
		if (!fileType.equalsIgnoreCase("BOOK")) {
			throw new AyaraCustomException(
					"This file name doesn't start With BOOK key word (Fileformat: BOOK-OCT.csv)");
		} else {
			try {
				String batchId = String.valueOf(System.currentTimeMillis());
				uploadFileStorageProcess(new BigDecimal(batchId),file.getContentType(),file.getOriginalFilename(),file.getBytes());
				revmantraService.processPostBookingFile(batchId,readCsvBuffer, file.getOriginalFilename());
				return SUCCESS_MSG;
			} catch (Exception e) {
				throw new AyaraCustomException(e.getMessage());
			}

		}

	}

	@PostMapping(value = "upload/shipments", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ResponseBody
	public String handleshipmentsFileUpload(@RequestParam(value = "file") MultipartFile file) {
		byte[] byteArr = null;
		BufferedReader readCsvBuffer = null;
		InputStream inputStream = null;
		InputStreamReader insr = null;

		try {
			byteArr = file.getBytes();
		} catch (IOException e1) {
			logger.error(e1);
			throw new AyaraCustomException("This file getting convert into bytes failed.Please try after some time.");
		}
		inputStream = new ByteArrayInputStream(byteArr);
		insr = new InputStreamReader(inputStream);
		readCsvBuffer = new BufferedReader(insr);
		String fileType = file.getOriginalFilename().subSequence(0, 4).toString();
		if (!fileType.equalsIgnoreCase("SHIP")) {
			throw new AyaraCustomException(
					"This file name doesn't start With SHIP key word (Fileformat: SHIP-OCT.csv)");
		} else {
			try {
				String batchId = String.valueOf(System.currentTimeMillis());
				uploadFileStorageProcess(new BigDecimal(batchId),file.getContentType(),file.getOriginalFilename(),file.getBytes());
				revmantraService.processshipmentsFile(batchId,readCsvBuffer, file.getOriginalFilename());
				return SUCCESS_MSG;
			} catch (Exception e) {
				throw new AyaraCustomException(e.getMessage());
				
			}

		}

	}

	@PostMapping(value = "upload/invoices", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ResponseBody
	public String handleInvoicesFileUpload(@RequestParam(value = "file") MultipartFile file) {
		byte[] byteArr = null;
		BufferedReader readCsvBuffer = null;
		InputStream inputStream = null;
		InputStreamReader insr = null;

		try {
			byteArr = file.getBytes();
		} catch (IOException e1) {
			logger.error(e1);
			throw new AyaraCustomException("This file getting convert into bytes failed.Please try after some time.");
		}
		inputStream = new ByteArrayInputStream(byteArr);
		insr = new InputStreamReader(inputStream);
		readCsvBuffer = new BufferedReader(insr);
		String fileType =  file.getOriginalFilename().subSequence(0, 3).toString();
		if (fileType!=null && !fileType.equalsIgnoreCase("INV")) {
			throw new AyaraCustomException("This file name doesn't start With INV key word (Fileformat: INV-OCT.csv)");
		} else {
			try {
				String batchId = String.valueOf(System.currentTimeMillis());
				uploadFileStorageProcess(new BigDecimal(batchId),file.getContentType(),file.getOriginalFilename(),file.getBytes());
				revmantraService.processInvoicesFile(batchId,readCsvBuffer, file.getOriginalFilename());
				return SUCCESS_MSG;
			} catch (Exception e) {
				throw new AyaraCustomException(e.getMessage());
				
			}

		}

	}

	@PostMapping(value = "upload/customers", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ResponseBody
	public String handleCustomersFileUpload(@RequestParam(value = "file") MultipartFile file) {
		byte[] byteArr = null;
		BufferedReader readCsvBuffer = null;
		InputStream inputStream = null;
		InputStreamReader insr = null;

		try {

			byteArr = file.getBytes();
			inputStream = new ByteArrayInputStream(byteArr);
			insr = new InputStreamReader(inputStream);
			readCsvBuffer = new BufferedReader(insr);
			String batchId = String.valueOf(System.currentTimeMillis());
			uploadFileStorageProcess(new BigDecimal(batchId),file.getContentType(),file.getOriginalFilename(),file.getBytes());
			revmantraService.processCustomersFile(batchId,readCsvBuffer, file.getOriginalFilename(),BaseListener.getUserInfo());

			return SUCCESS_MSG;
		} catch (RuntimeException e) {
			logger.error(
					"Getting Runtime Exception while uploading the Customers file to Revmantra System due to {}" , e.getMessage());
			throw new AyaraCustomException(e.getMessage());
		} catch (Exception e) {
			logger.error("Getting  Exception while uploading the Customers file to Revmantra System due to {}" , e.getMessage());
			throw new AyaraCustomException(e.getMessage());
		}
	}

	@PostMapping(value = "upload/products", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ResponseBody
	public String handleProductsFileUpload(@RequestParam(value = "file") MultipartFile file) {
		byte[] byteArr = null;
		BufferedReader readCsvBuffer = null;
		InputStream inputStream = null;
		InputStreamReader insr = null;

		try {

			byteArr = file.getBytes();
			inputStream = new ByteArrayInputStream(byteArr);
			insr = new InputStreamReader(inputStream);
			readCsvBuffer = new BufferedReader(insr);
			String batchId = String.valueOf(System.currentTimeMillis());
			uploadFileStorageProcess(new BigDecimal(batchId),file.getContentType(),file.getOriginalFilename(),file.getBytes());
			revmantraService.processProductsFile(batchId,readCsvBuffer, file.getOriginalFilename(),BaseListener.getUserInfo());

			return SUCCESS_MSG;
		} catch (RuntimeException e) {
			logger.error("Getting Runtime Exception while uploading the Products file to Revmantra System due to {}" , e.getMessage());
			return FAILURE_MSG;
		} catch (Exception e) {
			logger.error("Getting  Exception while uploading the Products file to Revmantra System due to {}" , e.getMessage());
			throw new AyaraCustomException(e.getMessage());
			
		}
	}

	@PostMapping(value = "upload/ssprules", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ResponseBody
	public String handleSSPRulesFileUpload(@RequestParam(value = "file") MultipartFile file) {
		byte[] byteArr = null;
		BufferedReader readCsvBuffer = null;
		InputStream inputStream = null;
		InputStreamReader insr = null;

		try {

			byteArr = file.getBytes();
			inputStream = new ByteArrayInputStream(byteArr);
			insr = new InputStreamReader(inputStream);
			readCsvBuffer = new BufferedReader(insr);
			String batchId = String.valueOf(System.currentTimeMillis());
			uploadFileStorageProcess(new BigDecimal(batchId),file.getContentType(),file.getOriginalFilename(),file.getBytes());
			revmantraService.processSSPRulesFile(batchId,readCsvBuffer, file.getOriginalFilename(),BaseListener.getUserInfo());

			return SUCCESS_MSG;
		} catch (RuntimeException e) {
			logger.error(
					"Getting Runtime Exception while uploading the SSP Rules file to Revmantra System due to {}" , e.getMessage());
			return FAILURE_MSG;
		} catch (Exception e) {
			logger.error("Getting  Exception while uploading the SSP Rules file to Revmantra System due to {}" , e.getMessage());
			throw new AyaraCustomException(e.getMessage());
			
		}
	}

	@PostMapping(value = "upload/glaccounts", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ResponseBody
	public String handleGLAccountsFileUpload(@RequestParam(value = "file") MultipartFile file) {
		byte[] byteArr = null;
		BufferedReader readCsvBuffer = null;
		InputStream inputStream = null;
		InputStreamReader insr = null;

		try {

			byteArr = file.getBytes();
			inputStream = new ByteArrayInputStream(byteArr);
			insr = new InputStreamReader(inputStream);
			readCsvBuffer = new BufferedReader(insr);
			String batchId = String.valueOf(System.currentTimeMillis());
			uploadFileStorageProcess(new BigDecimal(batchId),file.getContentType(),file.getOriginalFilename(),file.getBytes());
			revmantraService.processGLAccountsFile(batchId,readCsvBuffer, file.getOriginalFilename(),BaseListener.getUserInfo());

			return SUCCESS_MSG;
		} catch (RuntimeException e) {
			logger.error(
					"Getting Runtime Exception while uploading the GL Accounts file to Revmantra System due to {}" , e.getMessage());
			throw new AyaraCustomException(e.getMessage());
			
		} catch (Exception e) {
			logger.error("Getting  Exception while uploading the GL Accounts file to Revmantra System due to {}" , e.getMessage());
			throw new AyaraCustomException(e.getMessage());
			
		}
	}

	@PostMapping(value = "upload/fxRates", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ResponseBody
	public String handleCongersionRatesFileUpload(@RequestParam(value = "file") MultipartFile file) {
		byte[] byteArr = null;
		BufferedReader readCsvBuffer = null;
		InputStream inputStream = null;
		InputStreamReader insr = null;

		try {

			byteArr = file.getBytes();
			inputStream = new ByteArrayInputStream(byteArr);
			insr = new InputStreamReader(inputStream);
			readCsvBuffer = new BufferedReader(insr);
			String batchId = String.valueOf(System.currentTimeMillis());
			uploadFileStorageProcess(new BigDecimal(batchId),file.getContentType(),file.getOriginalFilename(),file.getBytes());
			revmantraService.processConversionRatesFile(batchId,readCsvBuffer, file.getOriginalFilename());

			return SUCCESS_MSG;
		} catch (RuntimeException e) {
			logger.error(
					"Getting Runtime Exception while uploading the Conversion Rates file to Ayara System due to {}" , e.getMessage());
			return FAILURE_MSG;
		} catch (Exception e) {
			logger.error("Getting  Exception while uploading the Conversion Rates file to Ayara System due to {}" , e.getMessage());
			throw new AyaraCustomException(e.getMessage());
			
		}
	}

	@PostMapping(value = "upload/periods", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ResponseBody
	public String handleFiscalPeriodsFileUpload(@RequestParam(value = "file") MultipartFile file) {
		byte[] byteArr = null;
		BufferedReader readCsvBuffer = null;
		InputStream inputStream = null;
		InputStreamReader insr = null;
		try {
			byteArr = file.getBytes();
		} catch (IOException e1) {
			throw new AyaraCustomException(CONSTANTS.FILE_READING_FAILED);
		}
		inputStream = new ByteArrayInputStream(byteArr);
		insr = new InputStreamReader(inputStream);
		readCsvBuffer = new BufferedReader(insr);
		try {
			String batchId = String.valueOf(System.currentTimeMillis());
			uploadFileStorageProcess(new BigDecimal(batchId),file.getContentType(),file.getOriginalFilename(),file.getBytes());
			revmantraService.processAccountingPeriods(batchId,readCsvBuffer, file.getOriginalFilename(),BaseListener.getUserInfo());
			return SUCCESS_MSG;
		} catch (Exception e) {
			throw new AyaraCustomException(e.getMessage());
		}

	}
	
	@PostMapping(value = "/api/sfqi/upsertLegalEntity", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public RmanLegalEntities upsertLegalEntity(@RequestBody RmanLegalEntities rle) {
		try {
			return revmantraService.upsertLegalEntity(rle);
		} catch (Exception e) {
			throw new AyaraCustomException("Legal Entity Creation/updation operation failed due to "+e.getMessage());
		}

	}
	
	@PostMapping(value = "/api/sfqi/upsertCustomer", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public RmanCustomers upsertCustomer(@RequestBody RmanCustomers rc) {
		try {
			return revmantraService.upsertCustomer(rc);
		} catch (Exception e) {
			throw new AyaraCustomException("Customer Creation/updation operation failed due to "+e.getMessage());
		}

	}
	
	@PostMapping(value = "/api/sfqi/bulkCustomers", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<RmanCustomers> upsertCustomers(@RequestBody List<RmanCustomers> rclist) {
		try {
			return revmantraService.upsertCustomers(rclist);
		} catch (Exception e) {
			throw new AyaraCustomException("Bulk Customers Creation/updation operation failed due to "+e.getMessage());
		}

	}
	
	@PostMapping(value = "/api/sfqi/upsertRevenueTemplate", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public RmanRevenueTemplates upsertRevenueTemplate(@RequestBody RmanRevenueTemplates rrt) {
		try {
			return revmantraService.upsertRevenueTemplate(rrt);
		} catch (Exception e) {
			throw new AyaraCustomException("Revenue Template Creation/updation operation failed due to "+e.getMessage());
		}
	}
	
	@PostMapping(value = "/api/sfqi/upsertProduct", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public RmanProducts upsertProduct(@RequestBody RmanProducts rp) {
		try {
			return revmantraService.upsertProduct(rp);
		} catch (Exception e) {
			throw new AyaraCustomException("Products Creation/updation operation failed due to "+e.getMessage());
		}

	}
	
	@PostMapping(value = "/api/sfqi/bulkProducts", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public UpstreamResponse upsertProductsAll(@RequestBody List<RmanProducts> rplist) {
		try {
			return revmantraService.upsertProducts(rplist); 
		} catch (Exception e) {
			throw new AyaraCustomException("Bulk Products Creation/updation operation failed due to "+e.getMessage());
		}

	}
	
	@PostMapping(value = "/api/sfqi/upsertPOB", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public RmanPobMapping upsertPOB(@RequestBody RmanPobMapping rpm) {
		try {
			return revmantraService.upsertPOBMapping(rpm);
		} catch (Exception e) {
			throw new AyaraCustomException("POB Mapping Creation/updation operation failed due to "+e.getMessage());
		}

	}
	
	@PostMapping(value = "/api/sfqi/upsertPeriod", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public RmanFiscalPeriods upsertPeriod(@RequestBody RmanFiscalPeriods rfp) {
		try {
			return revmantraService.upsertPeriod(rfp);
		} catch (Exception e) {
			throw new AyaraCustomException("Fiscal Period Creation/updation operation failed due to "+e.getMessage());
		}

	}

	@PostMapping(value = "/api/sfqi/upsertSSP", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public RmanFmvRulesDef upsertFMV(@RequestBody RmanFmvRulesDef fmv) {
		try {
			return revmantraService.upsertSSP(fmv);
		} catch (Exception e) {
			throw new AyaraCustomException("SSP Rule Creation/updation operation failed due to "+e.getMessage());
		}

	}
	
	@PostMapping(value = "/api/sfqi/upsertSSPParam", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public RmanFmvRulesDefParaValue upsertFMV(@RequestBody RmanFmvRulesDefParaValue sspParam) {
		try {
			return revmantraService.upsertSSPParam(sspParam);
		} catch (Exception e) {
			throw new AyaraCustomException("SSP Rule Parameters Creation/updation operation failed due to "+e.getMessage());
		}

	}
	
	@PostMapping(value = "/api/sfqi/upsertOrdersLegacy", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseData upsertOrdersLegacy(@RequestBody List<RmanOrdersInterface> rmanOrders) {
		try {
			return revmantraService.upsertOrdersInterfaceLegacy(rmanOrders);
		} catch (Exception e) {
			throw new AyaraCustomException("Orders Creation/updation operation failed due to "+e.getMessage());
		}
	}
	
	@PostMapping(value = "/api/sfqi/upsertOrders", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseData upsertOrders(@RequestBody List<RmanOrdersInterface> rmanOrders) {
		try {
			return revmantraService.upsertOrdersInterface(rmanOrders);
		} catch (Exception e) {
			throw new AyaraCustomException("Orders Creation/updation operation failed due to "+e.getMessage());
		}
	}

	@PostMapping(value = "/api/sfqi/upsertShipments", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseData upsertShipments(@RequestBody List<RmanOrdersInterface> rmanOrders) {
		try {
			return revmantraService.upsertShipments(rmanOrders);
		} catch (Exception e) {
			throw new AyaraCustomException("Shipments Creation/updation operation failed due to "+e.getMessage());
		}
	}
	
	@PostMapping(value = "/api/sfqi/upsertUsageSummary", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseData upsertUsagesSummary(@RequestBody List<RmanUsageSummaryInterface> usageSummaries){
		try {
			return revmantraService.upsertUsageSummary(usageSummaries);
		} catch (Exception e) {
			throw new AyaraCustomException("Usage Summary Creation/updation operation failed due to "+e.getMessage());
		}
	}
	
	@PostMapping(value = "/api/sfqi/upsertInvoices", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseData upsertInvoices(@RequestBody List<RmanInvoiceLinesInterface> invList) {
		try {
			return revmantraService.upsertInvoices(invList);
		} catch (Exception e) {
			throw new AyaraCustomException("Invoices Creation/updation operation failed due to "+e.getMessage());
		}
	}

	private void uploadFileStorageProcess(BigDecimal batchId,String fileType,String fileName,byte[] fileData){
		AyaraFileUploadStorage afus =  new AyaraFileUploadStorage();
		afus.setProcessId(batchId);
		afus.setFileType(fileType);
		afus.setFileName(StringUtils.cleanPath(fileName));
		afus.setFileData(fileData);
		ayaraFileUploadStorageRepository.save(afus);
	}
	
	@GetMapping(value = "/api/downloadFile/{fileId}", produces = "application/vnd.ms-excel")
	@ResponseBody
	public ResponseEntity<byte[]> downloadSingleFile(@PathVariable BigDecimal fileId){
		AyaraFileUploadStorage doc =  ayaraFileUploadStorageRepository.findByProcessId(fileId);
		
		
		return ResponseEntity.ok()
			   .contentType(MediaType.parseMediaType(doc.getFileType()))
			   .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename="+doc.getFileName())
			   .body(doc.getFileData());
	}

	@PostMapping(value = "/api/sfqi/upsertRulesHeader", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public RmanRulesHeader upsertRulesHeader(@RequestBody RmanRulesHeader rrh) {
		try {
			return revmantraService.upsertRuleHeader(rrh);
		} catch (Exception e) {
			throw new AyaraCustomException("Rule Header Creation/updation operation failed due to "+e.getMessage());
		}

	}

	@PostMapping(value = "/api/sfqi/upsertRulesParamValue", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public RmanRuleParameterValue upsertRuleParameterValue(@RequestBody RmanRuleParameterValue rpv) {
		try {
			return revmantraService.upsertRuleParameterValue(rpv);
		} catch (Exception e) {
			throw new AyaraCustomException("Rule Parameter value Creation/updation operation failed due to "+e.getMessage());
		}

	}
	
	@PostMapping(value = "/api/sfqi/upsertRevenueAccount", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public RmanAccountSetup upsertRevenueAccount(@RequestBody RmanAccountSetup ras) {
		try {
			RmanAccountSetup ra = rmanAccountSetupRepo.findByAccountingStructure(ras.getAccountingStructure());
			if(ras.getRevenue() != null) {
				ra.setRevenue(ras.getRevenue());
			}else {
				throw new AyaraCustomException("Revenue account number is null");
			}
			return rmanAccountSetupRepo.save(ra);
		} catch (Exception e) {
			logger.error(e);
			throw new AyaraCustomException("Revenue  Creation/updation operation failed due to "+e.getMessage());
		}

	}
	
	@PostMapping(value = "/api/sfqi/upsertDeferredRevenueAccount", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public RmanAccountSetup upsertDeferredRevenueAccount(@RequestBody RmanAccountSetup ras) {
		try {
			RmanAccountSetup ra = rmanAccountSetupRepo.findByAccountingStructure(ras.getAccountingStructure());
			if(ras.getDeferredRevenue() != null) {
				ra.setDeferredRevenue(ras.getDeferredRevenue());
			}else {
				throw new AyaraCustomException("Deferred Revenue account number is null");
			}
			return rmanAccountSetupRepo.save(ra);
		} catch (Exception e) {
			logger.error(e);
			throw new AyaraCustomException("Deferred Revenue  Creation/updation operation failed due to "+e.getMessage());
		}

	}
	
	@PostMapping(value = "/api/sfqi/upsertFiscalPeriod", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public RmanFiscalPeriods upsertFiscalPeriod(@RequestBody RmanFiscalPeriods rfp) {
		try {
			return revmantraService.upsertfiscalPeriods(rfp);
		} catch (Exception e) {
			throw new AyaraCustomException("Fiscal Period Creation/updation operation failed due to "+e.getMessage());
		}

	}
	
	@PostMapping(value = "/api/sfqi/upsertBulkFiscalPeriods", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public UpstreamResponse upsertBulkFiscalPeriods(@RequestBody List<RmanFiscalPeriods> rfps) {
		try {
			return revmantraService.upsertBulkFiscalPeriods(rfps);
		} catch (Exception e) {
			throw new AyaraCustomException("Bulk Fiscal Periods Creation/updation operation failed due to "+e.getMessage());
		}

	}
	
	
	@PostMapping(value = "/api/sfqi/upsertClearingAccount", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public RmanAccountSetup upsertClearingAccount(@RequestBody RmanAccountSetup ras) {
		try {
			RmanAccountSetup ra = rmanAccountSetupRepo.findByAccountingStructure(ras.getAccountingStructure());
			if(ras.getCearingAccount() != null) {
				ra.setCearingAccount(ras.getCearingAccount());
			}else {
				throw new AyaraCustomException("Clearning Account number is null");
			}
			return rmanAccountSetupRepo.save(ra);
		} catch (Exception e) {
			logger.error(e);
			throw new AyaraCustomException("Clearing Account  Creation/updation operation failed due to "+e.getMessage());
		}

	}

	@PostMapping(value = "/api/sfqi/upsertContractLiabilityAccount", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public RmanAccountSetup upsertContractLiabilityAccount(@RequestBody RmanAccountSetup ras) {
		try {
			RmanAccountSetup ra = rmanAccountSetupRepo.findByAccountingStructure(ras.getAccountingStructure());
			if(ras.getContractLiability() != null) {
				ra.setContractLiability(ras.getContractLiability());
			}else {
				throw new AyaraCustomException("Contract Liability Account number is null");
			}
			return rmanAccountSetupRepo.save(ra);
		} catch (Exception e) {
			logger.error(e);
			throw new AyaraCustomException("Contract Liability Account  Creation/updation operation failed due to "+e.getMessage());
		}

	}

	@PostMapping(value = "/api/sfqi/upsertContractAssetAccount", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public RmanAccountSetup upsertContractAssetAccount(@RequestBody RmanAccountSetup ras) {
		try {
			RmanAccountSetup ra = rmanAccountSetupRepo.findByAccountingStructure(ras.getAccountingStructure());
			if(ras.getContractAsset() != null) {
				ra.setContractAsset(ras.getContractAsset());
			}else {
				throw new AyaraCustomException("Contract Asset Account number is null");
			}
			return rmanAccountSetupRepo.save(ra);
		} catch (Exception e) {
			logger.error(e);
			throw new AyaraCustomException("Contract Asset Account  Creation/updation operation failed due to "+e.getMessage());
		}

	}

	@PostMapping(value = "/api/sfqi/upsertDefRevenueContingencyAccount", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public RmanAccountSetup upsertDefRevenueContingencyAccount(@RequestBody RmanAccountSetup ras) {
		try {
			RmanAccountSetup ra = rmanAccountSetupRepo.findByAccountingStructure(ras.getAccountingStructure());
			if(ras.getDefRevenueContingency() != null) {
				ra.setDefRevenueContingency(ras.getDefRevenueContingency());
			}else {
				throw new AyaraCustomException("Deferred Revenue Contingency Account number is null");
			}
			return rmanAccountSetupRepo.save(ra);
		} catch (Exception e) {
			logger.error(e);
			throw new AyaraCustomException("Deferred Revenue Contingency Account  Creation/updation operation failed due to "+e.getMessage());
		}

	}
	
	/*
	 *  Added the Upload File API for the Quote,Book,Ship and Invoice files
	 *  #AYAR-479 By Chandra on 9th Jun 2021
	 */
	@PostMapping(value = "upload/documents/{documentType}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ResponseBody
	public String uploadDocumentsFile(@PathVariable String documentType,@RequestParam(value = "file") MultipartFile file) {
		byte[] byteArr = null;
		BufferedReader readCsvBuffer = null;
		InputStream inputStream = null;
		InputStreamReader insr = null;
		try {
			byteArr = file.getBytes();
		} catch (IOException e1) {
			throw new AyaraCustomException(CONSTANTS.FILE_READING_FAILED);
		}
		
		inputStream = new ByteArrayInputStream(byteArr);
		insr = new InputStreamReader(inputStream);
		readCsvBuffer = new BufferedReader(insr);
		try {
				String batchId = String.valueOf(System.currentTimeMillis());
				uploadFileStorageProcess(new BigDecimal(batchId),file.getContentType(),file.getOriginalFilename(),file.getBytes());
				revmantraService.processDocuments(new BigDecimal(batchId),readCsvBuffer, file.getOriginalFilename(),documentType,BaseListener.getUserInfo());
				return SUCCESS_MSG;
			} catch (Exception e) {
				throw new AyaraCustomException(e.getMessage());
			}

		
	}
	
	/*
	 *  Added the Single API  for all the Quote,Book,Ship and Invoice Transactions Integration with Third Party Systems
	 *  #AYAR-476 By Chandra on 9th Jun 2021
	 */
	@PostMapping(value = "/api/sfqi/V1/processdocuments", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public ResponseData processDocuments(@RequestBody List<AyaraDocTransactionsInt> ayaraDocTransactions,@RequestParam(value="documentType") String documentType,@RequestParam(value="source") String source) {
		BigDecimal processId = BigDecimal.valueOf(System.currentTimeMillis());
		Timestamp currentDate = new Timestamp(System.currentTimeMillis());
		String createdBy = BaseListener.getCurrentUser();
		BigDecimal currentUserId = BaseListener.getCurrentUserId();
		try{
			
			ayaraDocTransactions.forEach(d->{
				d.setProcessId(processId);
				d.setProcessFlag("N");
				d.setProcessedDate(currentDate);
				d.setCreatedBy(createdBy);
				d.setCreationDate(currentDate);
				d.setLastUpdatedBy(createdBy);
				d.setLastUpdateDate(currentDate);
			});
			
			ayaraDocTransactionsIntRepository.saveAll(ayaraDocTransactions);
			ResponseData responseData=revmantraService.processIntegrationDocuments(processId, ayaraDocTransactions, documentType, currentUserId, source);
			
			if (responseData != null) {
				return responseData;
			} else {
				throw new AyaraCustomException(documentType +" Documents are not processed in Ayara system.Please try after sometime.");
			}
				
		} catch(Exception e){
			logger.error(e);
			throw new AyaraCustomException(e.getMessage());
			
		}
    }
	
	@GetMapping(value = "/api/sspbook/ssprules/approve")
	@ResponseBody
    public boolean processDocuments(@RequestParam(value="sspBookId") BigDecimal sspBookId) {
		try{
			
			return revmantraService.approveBookSSPRules(sspBookId).equals("Y");		
		} catch(Exception e){
			logger.error(e);
			throw new AyaraCustomException(e.getMessage());
			
		}
    }
	
	/*
	 *  Added API call for loading usages file manually through Ayara application
	 *  #AYAR-1616 By Madhu Sri Thota on 29th Sep 2021
	 */
	
	@PostMapping(value = "upload/usageFile", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ResponseBody
	public String handleUsageFileUpload(@RequestParam(value = "file") MultipartFile file) {
		byte[] byteArr = null;
		BufferedReader readCsvBuffer = null;
		InputStream inputStream = null;
		InputStreamReader insr = null;

		try {

			byteArr = file.getBytes();
			inputStream = new ByteArrayInputStream(byteArr);
			insr = new InputStreamReader(inputStream);
			readCsvBuffer = new BufferedReader(insr);
			String batchId = String.valueOf(System.currentTimeMillis());
			revmantraService.processUsageFile(batchId,readCsvBuffer, file.getOriginalFilename(),BaseListener.getUserInfo());
			return SUCCESS_MSG;
		} catch (RuntimeException e) {
			logger.error("Getting Runtime Exception while uploading the Usage file to Ayara System due to {}" , e.getMessage());
			return FAILURE_MSG;
		} catch (Exception e) {
			logger.error("Getting  Exception while uploading the Usage file to Ayara System due to {}" , e.getMessage());
			throw new AyaraCustomException(e.getMessage());
		}
	}
	

}

