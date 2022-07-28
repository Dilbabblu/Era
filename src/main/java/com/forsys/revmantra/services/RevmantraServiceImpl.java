package com.forsys.revmantra.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.forsys.revmantra.exceptions.AyaraCustomException;
import com.forsys.revmantra.listener.BaseListener;
import com.forsys.revmantra.model.AyaraDocTransactionsInt;
import com.forsys.revmantra.model.RmanContTransToRelease;
import com.forsys.revmantra.model.RmanConversionRatesInt;
import com.forsys.revmantra.model.RmanCustomers;
import com.forsys.revmantra.model.RmanCustomersInterface;
import com.forsys.revmantra.model.RmanDealArrangements;
import com.forsys.revmantra.model.RmanEntityParametersV;
import com.forsys.revmantra.model.RmanFileUploadJobs;
import com.forsys.revmantra.model.RmanFiscalPeriods;
import com.forsys.revmantra.model.RmanFiscalPeriodsInterface;
import com.forsys.revmantra.model.RmanFmvRulesDef;
import com.forsys.revmantra.model.RmanFmvRulesDefParaValue;
import com.forsys.revmantra.model.RmanGlAccountsInterface;
import com.forsys.revmantra.model.RmanIntfDealDetails;
import com.forsys.revmantra.model.RmanInvoiceLinesInterface;
import com.forsys.revmantra.model.RmanLegalEntities;
import com.forsys.revmantra.model.RmanOrdersInterface;
import com.forsys.revmantra.model.RmanPobMapping;
import com.forsys.revmantra.model.RmanProducts;
import com.forsys.revmantra.model.RmanProductsInterface;
import com.forsys.revmantra.model.RmanRevenueTemplates;
import com.forsys.revmantra.model.RmanRuleParameterValue;
import com.forsys.revmantra.model.RmanRulesHeader;
import com.forsys.revmantra.model.RmanSalesforceQuoteLine;
import com.forsys.revmantra.model.RmanUsageSummaryInterface;
import com.forsys.revmantra.model.RmanUsers;
import com.forsys.revmantra.model.SSPBooks;
import com.forsys.revmantra.model.SfqiExceptions;
import com.forsys.revmantra.model.SspRulesInterface;
import com.forsys.revmantra.pojo.BulkResponse;
import com.forsys.revmantra.pojo.ErrorMessage;
import com.forsys.revmantra.pojo.MailSend;
import com.forsys.revmantra.pojo.ResponseData;
import com.forsys.revmantra.pojo.UpstreamResponse;
import com.forsys.revmantra.repositories.AyaraDocTransactionsIntRepository;
import com.forsys.revmantra.repositories.RmanContTransToReleaseRepository;
import com.forsys.revmantra.repositories.RmanConversionRatesIntRepository;
import com.forsys.revmantra.repositories.RmanCustomersInterfaceRepository;
import com.forsys.revmantra.repositories.RmanCustomersRepository;
import com.forsys.revmantra.repositories.RmanDealArrangementsRepository;
import com.forsys.revmantra.repositories.RmanDealHeadersRepository;
import com.forsys.revmantra.repositories.RmanEntityParametersVRepository;
import com.forsys.revmantra.repositories.RmanFileUploadJobsRepository;
import com.forsys.revmantra.repositories.RmanFiscalPeriodsInterfaceRepository;
import com.forsys.revmantra.repositories.RmanFiscalPeriodsRepository;
import com.forsys.revmantra.repositories.RmanFmvRulesDefParaValueRepository;
import com.forsys.revmantra.repositories.RmanFmvRulesDefRepository;
import com.forsys.revmantra.repositories.RmanGlAccountsInterfaceRepository;
import com.forsys.revmantra.repositories.RmanIntfDealDetailsRepository;
import com.forsys.revmantra.repositories.RmanInvoiceLinesInterfaceRepository;
import com.forsys.revmantra.repositories.RmanLegalEntitiesRepository;
import com.forsys.revmantra.repositories.RmanOrderLinesBookingsVRepository;
import com.forsys.revmantra.repositories.RmanOrdersInterfaceRepository;
import com.forsys.revmantra.repositories.RmanPobMappingRepository;
import com.forsys.revmantra.repositories.RmanProductsInterfaceRepository;
import com.forsys.revmantra.repositories.RmanProductsRepository;
import com.forsys.revmantra.repositories.RmanRevenueTemplatesRepository;
import com.forsys.revmantra.repositories.RmanRuleParameterValueRepository;
import com.forsys.revmantra.repositories.RmanRulesHeaderRepository;
import com.forsys.revmantra.repositories.RmanSalesforceQuoteLineRepository;
import com.forsys.revmantra.repositories.RmanUsageSummaryInterfaceRepository;
import com.forsys.revmantra.repositories.SSPBooksRepository;
import com.forsys.revmantra.repositories.SspRulesInterfaceRepository;
import com.forsys.revmantra.utils.CONSTANTS;
import com.forsys.revmantra.utils.MailSender;
import com.forsys.revmantra.utils.RevmantraUtils;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

@Service
public class RevmantraServiceImpl implements RevmantraService {
	
	 /* 
	  * AYAR-1801 Added @Async annotation for the file uplaoded callable Methods
	  *  for the Separate Thread to run in backend process
	  *  And added the CreateJobRecord,UpdateJobRecord and MailSender private Methods 
	  * By Chandra Kota on 05-JAN-2021
	  */
	
	private static final Logger logger = LogManager.getLogger(RevmantraServiceImpl.class);
	
	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	RmanRulesHeaderRepository rmanRulesHeaderRepo;
	
	@Autowired
	RmanRuleParameterValueRepository rmanRuleParameterValueRepo;

	@Autowired
	private RmanContTransToReleaseRepository rmanContTransToReleaseRepo;

	@Autowired
	private RmanOrderLinesBookingsVRepository rmanOrderLinesBookingsVRepository;

	@Autowired
	private RmanCustomersInterfaceRepository rmanCustomersInterfaceRepository;

	
	@Autowired
	private RmanIntfDealDetailsRepository rmanIntfDealDetailsRepository;

	@Autowired
	private RmanOrdersInterfaceRepository rmanOrdersInterfaceRepository;

	@Autowired
	private RmanProductsInterfaceRepository rmanProductsInterfaceRepository;

	@Autowired
	private SspRulesInterfaceRepository sspRulesInterfaceRepository;

	@Autowired
	private RmanGlAccountsInterfaceRepository rmanGlAccountsInterfaceRepository;

	@Autowired
	private RmanFileUploadJobsRepository rmanFileUploadJobRepository;

	@Autowired
	private RmanInvoiceLinesInterfaceRepository rmanInvoiceLinesInterfaceRepository;

	@Autowired
	private RmanConversionRatesIntRepository rmanConversionRatesIntRepository;

	@Autowired
	private RmanFiscalPeriodsInterfaceRepository rmanFiscalPeriodsInterfaceRepo;
	
	@Autowired
	public RmanDealHeadersRepository rmanDealHeadersRepository;

	@Autowired
	public RmanSalesforceQuoteLineRepository rmanSalesforceQuoteLineRepository;

	@Autowired
	public AyaraDocTransactionsIntRepository ayaraDocTransactionsIntRepo;

	
	@Autowired
	private RmanLegalEntitiesRepository rmanLegalEntitiesRepository;
	
	@Autowired
	private RmanCustomersRepository rmanCustomersRepository;
	
	@Autowired
	private RmanRevenueTemplatesRepository rmanRevenueTemplatesRepository;
	
	@Autowired
	private RmanProductsRepository rmanProductsRepoitory;
	
	@Autowired
	private RmanPobMappingRepository rmanPobMappingRepository;

	@Autowired
	private RmanFiscalPeriodsRepository rmanFiscalPeriodsRepository;
	
	@Autowired
	private RmanFmvRulesDefRepository rmanFmvRulesDefRepository;
	
	@Autowired
	private RmanFmvRulesDefParaValueRepository rmanFmvRulesDefParaValueRepository;
	
	@Autowired
	private RmanEntityParametersVRepository rmanEntityParametersVRepository;
	
	@Autowired
	private RmanUsageSummaryInterfaceRepository rmanUsageSummaryInterfaceRepo;

	@Autowired
	private RmanDealArrangementsRepository rmanDealArrangementsRepository;
	
	@Autowired
	private SSPBooksRepository sspBooksRepository;

	
	public enum accountingPeriodColumns {
		PERIOD_SET_NAME, PERIOD_NAME, LAST_UPDATE_DATE, LAST_UPDATED_BY, START_DATE, END_DATE, YEAR_START_DATE, QUARTER_START_DATE, PERIOD_TYPE, PERIOD_YEAR, PERIOD_NUM, QUARTER_NUM, ENTERED_PERIOD_NAME, ADJUSTMENT_PERIOD_FLAG, CREATION_DATE, CREATED_BY, LAST_UPDATE_LOGIN, DESCRIPTION

	}

	@Override
	public void readyToReleaseContengency(BigDecimal transHeaderId, BigDecimal transLineId) {

		StoredProcedureQuery storedProcedure;
			try {
				storedProcedure = manager
						.createStoredProcedureQuery("rman_deal_util_pkg.ready_to_release")
						.registerStoredProcedureParameter(CONSTANTS.P_TRANS_HEADER_ID, BigDecimal.class, ParameterMode.IN)
						.registerStoredProcedureParameter(CONSTANTS.P_TRANS_LINE_ID, BigDecimal.class, ParameterMode.IN);
				storedProcedure.setParameter(CONSTANTS.P_TRANS_HEADER_ID, transHeaderId);
				storedProcedure.setParameter(CONSTANTS.P_TRANS_LINE_ID, transLineId);
				storedProcedure.execute();
			}catch(Exception e) {
				throw new AyaraCustomException("Failed to push the Contingency Line to cont_trans_to_release table");
			}
	}

	@Override
	public void readyToReleaseline(BigDecimal transHeaderId, BigDecimal transLineId) {
		StoredProcedureQuery storedProcedure;
		try {
			storedProcedure = manager
					.createStoredProcedureQuery("rman_deal_util_pkg.insert_release_line")
					.registerStoredProcedureParameter(CONSTANTS.P_TRANS_HEADER_ID, BigDecimal.class, ParameterMode.IN)
					.registerStoredProcedureParameter(CONSTANTS.P_TRANS_LINE_ID, BigDecimal.class, ParameterMode.IN);
			storedProcedure.setParameter(CONSTANTS.P_TRANS_HEADER_ID, transHeaderId);
			storedProcedure.setParameter(CONSTANTS.P_TRANS_LINE_ID, transLineId);
			storedProcedure.execute();
		}catch(Exception e) {
			throw new AyaraCustomException("Failed to create the Contingency Release Line to rman_cont_release_lines table");
		}


	}

	@Override
	public void unlinkSalesOrder(BigDecimal arrangementId, BigDecimal soLineId, BigDecimal loggedUser) {
		try {
			rmanOrderLinesBookingsVRepository.unlinksoLine(arrangementId, soLineId, loggedUser);
		} catch (Exception e) {
			logger.error("Getting error when Unlink Sales Order action due to {}" , e.getMessage());
		}

	}

	@Override
	public void linkSalesOrder(BigDecimal arrangementId, BigDecimal soLineId, String dealNumber,
			BigDecimal dealLineNumber, BigDecimal loggedUser) {
		try {
			rmanOrderLinesBookingsVRepository.linksoLine(arrangementId, soLineId, dealNumber, dealLineNumber,
					loggedUser);
		} catch (Exception e) {
			logger.error("Getting error when Link Sales Order action due to {}" , e.getMessage());
		}

	}

	public Timestamp convertStringtoTimestamp(String pDate) {
		return RevmantraUtils.getDateValue(pDate);
	}
	
	@Override
	public void processDealFile(String batchNo,BufferedReader bufferedReader, String fileName) throws IOException {
		List<RmanIntfDealDetails> contractsList = new ArrayList<>();
		BigDecimal uploadUserId = BaseListener.getCurrentUserId() != null ? BaseListener.getCurrentUserId()
				: new BigDecimal(-1);
		BigDecimal batchId = new BigDecimal(batchNo);
		Timestamp currentDate = new Timestamp(System.currentTimeMillis());
		RmanFileUploadJobs job = new RmanFileUploadJobs();
		job.setJobId(batchId.toString());
		job.setJobName("Contracts File Process job");
		job.setStartDate(currentDate);
		job.setAttribute3(fileName);
		rmanFileUploadJobRepository.save(job);
		String fileType = fileName.subSequence(0, 5).toString();
		CSVParser csvParser = null;

		try {
			 csvParser = new CSVParser(bufferedReader,
			                      CSVFormat.DEFAULT.withHeader("OperationCode","SalesNodeLevel1","SalesNodeLevel2","SalesNodeLevel3","SalesNodeLevel4",
								  "CurrencyCode","CustomerName","ArrangementNumber","ArrangementName","AgreementId","AgreementName","DealNumber",
								  "DealLineNumber","DealName","AdditionalLineAttribute3","ProductName","AdditionalLineAttribute2",
								  "AdditionalLineAttribute1","StartDate","EndDate","Duration","DurationUom","Quantity","FxRate","FxDate",
								  "UnitSellingPrice","UnitListPrice","ContractUnitType","UnitCost","BillToCustomerName","EntityName","PriceList",
								  "MsaNumber","MsaName","ParentLineId","FvPercent","AccountingRuleName","EitfSop","BespPerUnit","ArrgSource",
								  "ArrgBasis","customerNumber").withSkipHeaderRecord().withIgnoreHeaderCase().withTrim());
			
			for (CSVRecord csvRecord : csvParser) {

				if (!csvRecord.isConsistent()) {
					throw new AyaraCustomException(CONSTANTS.ROW_SIZE_MISMATCH);
				}

				RmanIntfDealDetails rmanIntfDetails = new RmanIntfDealDetails();
					
				rmanIntfDetails.setOperationCode(csvRecord.get(0));
				rmanIntfDetails.setSalesNodeLevel1(csvRecord.get(1));
				rmanIntfDetails.setSalesNodeLevel2(csvRecord.get(2));
				rmanIntfDetails.setSalesNodeLevel3(csvRecord.get(3));
				rmanIntfDetails.setSalesNodeLevel4(csvRecord.get(4));
				rmanIntfDetails.setCurrencyCode(csvRecord.get(5));
				rmanIntfDetails.setCustomerName(csvRecord.get(6));
				rmanIntfDetails.setArrangementNumber(csvRecord.get(7));
				rmanIntfDetails.setArrangementName(csvRecord.get(8));
				rmanIntfDetails.setAgreementId(csvRecord.get(9));
				rmanIntfDetails.setAgreementName(csvRecord.get(10));
				rmanIntfDetails.setDealNumber(csvRecord.get(11));
				if (!csvRecord.get(12).isEmpty()) {
					try{
						rmanIntfDetails.setDealLineNumber(new BigDecimal(csvRecord.get(12)));
					}catch(Exception e){
						throw new NumberFormatException("Deal Line Number not in Numeric format");
					}
				}
				
				rmanIntfDetails.setDealName(csvRecord.get(13));
				rmanIntfDetails.setAdditionalAttribute3(csvRecord.get(14));
				rmanIntfDetails.setProductName(csvRecord.get(15));
				rmanIntfDetails.setAdditionalAttribute2(csvRecord.get(16));
				rmanIntfDetails.setAdditionalAttribute1(csvRecord.get(17));
				
				if (!csvRecord.get(18).isEmpty()) {
					rmanIntfDetails.setStartDate(convertStringtoTimestamp(csvRecord.get(18)));
				}
				if (!csvRecord.get(19).isEmpty()) {
					rmanIntfDetails.setEndDate(convertStringtoTimestamp(csvRecord.get(19)));
				}
				if (!csvRecord.get(20).isEmpty()) {
					try{
						rmanIntfDetails.setDuration(new BigDecimal(csvRecord.get(20)));
					}catch(Exception e){
						throw new NumberFormatException("Duration not in Numeric format");
					}
				}
				
				rmanIntfDetails.setDurationUom(csvRecord.get(21));
				
				if (!csvRecord.get(22).isEmpty()) {
					try{
						rmanIntfDetails.setQuantity(new BigDecimal(csvRecord.get(22)));
					}catch(Exception e){
						throw new NumberFormatException("Quantity not in Numeric format");
					}
				}

				if (!csvRecord.get(23).isEmpty()) {
					try{
						rmanIntfDetails.setFxRate(new BigDecimal(csvRecord.get(23)));
					}catch(Exception e){
						throw new NumberFormatException("FxRate not in Numeric");
					}
				}
				
				if (!csvRecord.get(24).isEmpty()) {
					rmanIntfDetails.setFxDate(convertStringtoTimestamp(csvRecord.get(24)));
				}
				if (!csvRecord.get(25).isEmpty()) {
					try{
						rmanIntfDetails.setUnitSellingPrice(new BigDecimal(csvRecord.get(25)));
					}catch(Exception e){
						throw new NumberFormatException("Unit Selling Price not in Numeric");
					}
				}
				if (!csvRecord.get(26).isEmpty()) {
					try{
						rmanIntfDetails.setUnitListPrice(new BigDecimal(csvRecord.get(26)));
					}catch(Exception e){
						throw new NumberFormatException("Unit List Price not in Numeric");
					}
				}

				
				rmanIntfDetails.setContractUnitType(csvRecord.get(27));
				if (!csvRecord.get(28).isEmpty()) {
					try{
						rmanIntfDetails.setUnitCost(new BigDecimal(csvRecord.get(28)));
					}catch(Exception e){
						throw new NumberFormatException("Unit Cost not in Numeric");
					}
				}

				rmanIntfDetails.setBillToCustomerName(csvRecord.get(29));
				rmanIntfDetails.setEntityName(csvRecord.get(30));
				rmanIntfDetails.setPriceList(csvRecord.get(31));
				if (!csvRecord.get(32).isEmpty()) {
					try{
						rmanIntfDetails.setMsaNumber(new BigDecimal(csvRecord.get(32)));
					}catch(Exception e){
						throw new NumberFormatException("MSA Number not in Numeric");
					}
				}
				
				rmanIntfDetails.setMsaName(csvRecord.get(33));
				if (!csvRecord.get(34).isEmpty()) {
					try{
						rmanIntfDetails.setParentLineId(new BigDecimal(csvRecord.get(34)));
					}catch(Exception e){
						throw new NumberFormatException("Parent Line Id not in Numeric");
					}
				}
				if (!csvRecord.get(35).isEmpty()) {
					try{
						rmanIntfDetails.setFvPercent(new BigDecimal(csvRecord.get(35)));
					}catch(Exception e){
						throw new NumberFormatException("FV Percent not in Numeric");
					}
				}
				
				rmanIntfDetails.setAccountingRuleName(csvRecord.get(36));
				rmanIntfDetails.setEitfSop(csvRecord.get(37));
				if (!csvRecord.get(38).isEmpty()) {
					try{
						rmanIntfDetails.setBespPerUnit(new BigDecimal(csvRecord.get(38)));
						
					}catch(Exception e){
						throw new NumberFormatException("Besp Price Per Unit not in Numeric");
					}
				}
				rmanIntfDetails.setArrgSource(csvRecord.get(39));
				rmanIntfDetails.setArrgBasis(csvRecord.get(40));
				rmanIntfDetails.setCustomerNumber(csvRecord.get(41));
				
				rmanIntfDetails.setProcessId(batchId);
				rmanIntfDetails.setCreatedBy(uploadUserId);
				rmanIntfDetails.setCreationDate(currentDate);
				rmanIntfDetails.setProcessDate(currentDate);
				rmanIntfDetails.setFileName(fileName);
				rmanIntfDetails.setFileType(fileType);

				contractsList.add(rmanIntfDetails);

			}
			
			if (!contractsList.isEmpty()) {

				RmanFileUploadJobs job1 = rmanFileUploadJobRepository.getOne(batchId.toString());
				job1.setTotalProcessRecords(new BigDecimal(contractsList.size()));
				rmanFileUploadJobRepository.save(job1);
				saveContractsDataAndProcess(contractsList, BaseListener.getCurrentUserId(), batchId);
				List<RmanIntfDealDetails> failedList = rmanIntfDealDetailsRepository
						.findByInterfaceStatusAndProcessId("E", batchId);
				int failedRecs = failedList.size();
				int successRecs = contractsList.size() - failedList.size();
				RmanFileUploadJobs job2 = rmanFileUploadJobRepository.getOne(batchId.toString());
				job2.setTotalFailedRecords(new BigDecimal(failedRecs));
				job2.setTotalSuccessRecords(new BigDecimal(successRecs));
				job2.setFinishedDate(new Timestamp(System.currentTimeMillis()));
				rmanFileUploadJobRepository.save(job2);
			}

		} catch (Exception e) {
			logger.error("Contracts file upload process failed due to {}" , e.getMessage());
			throw new AyaraCustomException(e.getMessage());
		}finally {
			csvParser.close();
		}
	}

	

	@Override
	public void processPostBookingFile(String batchId,BufferedReader bufferedReader, String fileName) {
		RmanFileUploadJobs job = new RmanFileUploadJobs();
		job.setJobId(batchId);
		job.setJobName("Bookings File Process job");
		job.setStartDate(new Timestamp(System.currentTimeMillis()));
		job.setAttribute1(fileName.subSequence(0, 4).toString());
		job.setAttribute3(fileName);
		rmanFileUploadJobRepository.save(job);
		try {
			List<RmanOrdersInterface> pblist = parseBookShipCSV(batchId, bufferedReader, fileName);
			if (!pblist.isEmpty()) {
				RmanFileUploadJobs job1 = rmanFileUploadJobRepository.getOne(batchId);
				job1.setTotalProcessRecords(new BigDecimal(pblist.size()));
				rmanFileUploadJobRepository.save(job1);
				saveBookingsDataAndProcess(pblist, BaseListener.getCurrentUserId(), new BigDecimal(batchId));
				List<RmanOrdersInterface> failedList = rmanOrdersInterfaceRepository
						.findByInterfaceStatusAndGroupId("E", batchId);
				int failedRecs = failedList.size();
				int successRecs = pblist.size() - failedList.size();
				RmanFileUploadJobs job2 = rmanFileUploadJobRepository.getOne(batchId);
				job2.setTotalFailedRecords(new BigDecimal(failedRecs));
				job2.setTotalSuccessRecords(new BigDecimal(successRecs));
				job2.setFinishedDate(new Timestamp(System.currentTimeMillis()));
				rmanFileUploadJobRepository.save(job2);
			}
		} catch (Exception e) {
			logger.error("Getting error when Bookings file upload process due to {}" , e.getCause().getMessage());
			throw new AyaraCustomException(e.getCause().getMessage());
		}
	}

	@Override
	public void processshipmentsFile(String batchId,BufferedReader bufferedReader, String fileName) {
		RmanFileUploadJobs job = new RmanFileUploadJobs();
		job.setJobId(batchId);
		job.setJobName("Shipments File Process job");
		job.setStartDate(new Timestamp(System.currentTimeMillis()));
		job.setAttribute3(fileName);
		rmanFileUploadJobRepository.save(job);
		try {
			List<RmanOrdersInterface> shipmentslist = parseBookShipCSV(batchId, bufferedReader, fileName);
			if (!shipmentslist.isEmpty()) {
				RmanFileUploadJobs job1 = rmanFileUploadJobRepository.getOne(batchId);
				job1.setTotalProcessRecords(new BigDecimal(shipmentslist.size()));
				rmanFileUploadJobRepository.save(job1);
				saveShipmentsDataAndProcess(shipmentslist, BaseListener.getCurrentUserId(), batchId);
				List<RmanOrdersInterface> failedList = rmanOrdersInterfaceRepository
						.findByInterfaceStatusAndGroupId("E", batchId);
				int failedRecs = failedList.size();
				int successRecs = shipmentslist.size() - failedList.size();
				RmanFileUploadJobs job2 = rmanFileUploadJobRepository.getOne(batchId);
				job2.setTotalFailedRecords(new BigDecimal(failedRecs));
				job2.setTotalSuccessRecords(new BigDecimal(successRecs));
				job2.setFinishedDate(new Timestamp(System.currentTimeMillis()));
				rmanFileUploadJobRepository.save(job2);
			}
		} catch (Exception e) {
			logger.error("Getting error when Shipments file upload process due to {}" , e.getCause().getMessage());
			throw new AyaraCustomException(e.getCause().getMessage());
		}
	}

	@Override
	public void processInvoicesFile(String batchId,BufferedReader bufferedReader, String fileName) throws IOException {

		List<RmanInvoiceLinesInterface> invlist = new ArrayList<>();
		BigDecimal uploadUserId = BaseListener.getCurrentUserId();
		RmanFileUploadJobs job = new RmanFileUploadJobs();
		job.setJobId(batchId);
		job.setJobName("Billings File Process job");
		job.setStartDate(new Timestamp(System.currentTimeMillis()));
		job.setAttribute3(fileName);
		rmanFileUploadJobRepository.save(job);
		String fileType = fileName.subSequence(0, 3).toString();
		CSVParser csvParser  = null;
		try {
			 csvParser = new CSVParser(bufferedReader,
					CSVFormat.DEFAULT
							.withHeader("SOURCE_INVOICE_ID", "SOURCE_INVOICE_LINE_ID", "INVOICE_TYPE", "INVOICE_SOURCE",
									"INVOICE_TRX_TYPE", "INVOICE_NUMBER", "INVOICE_DATE", "SALES_ORDER",
									"SALES_ORDER_LINE", "SALES_ORDER_LINE_ID", "INVOICE_LINE_NUMBER", "LINE_TYPE",
									"QUANTITY_INVOICED", "UNIT_STANDARD_PRICE", "INVOICE_CURRENCY_CODE",
									"INVOICE_AMOUNT", "ACCOUNTED_CURRENCY", "ACCOUNTED_AMOUNT", "FX_RATE", "FX_DATE")
							.withSkipHeaderRecord().withIgnoreHeaderCase().withTrim());

			for (CSVRecord csvRecord : csvParser) {
				if (!csvRecord.isConsistent()) {
					throw new AyaraCustomException(CONSTANTS.ROW_SIZE_MISMATCH);
				}

				RmanInvoiceLinesInterface inv = new RmanInvoiceLinesInterface();

				if (!csvRecord.get(0).isEmpty()) {
					try {
						inv.setSourceInvoiceId(new BigDecimal(csvRecord.get(0).replace(",", "")));
					} catch (Exception e) {
						throw new AyaraCustomException("Source Invoice Id not in Numeric format");
					}
				}
				if (!csvRecord.get(1).isEmpty()) {
					try {
						inv.setSourceInvoiceLineId(new BigDecimal(csvRecord.get(1).replace(",", "")));
					} catch (Exception e) {
						throw new AyaraCustomException("Source Invoice Line Id not in Numeric format");
					}
				}
				inv.setInvoiceType(csvRecord.get(2));
				inv.setInvoiceSource(csvRecord.get(3));
				inv.setInvoiceTrxType(csvRecord.get(4));
				inv.setInvoiceNumber(csvRecord.get(5));
				if (!csvRecord.get(6).isEmpty()) {
					inv.setInvoicedDate(convertStringtoTimestamp(csvRecord.get(6)));
				}
				inv.setSalesOrderNumber(csvRecord.get(7));
				inv.setSalesOrderLine(csvRecord.get(8));
				inv.setSalesOrderLineId(csvRecord.get(9));
				if (!csvRecord.get(9).isEmpty()) {
					try {
						inv.setSourceOrderLineId(new BigDecimal(csvRecord.get(9).replace(",", "")));
					} catch (Exception e) {
						throw new AyaraCustomException("Source Order Line Id Quantity  not in Numeric format");
					}
				}
				inv.setInvoiceLineNumber(csvRecord.get(10));
				inv.setLineType(csvRecord.get(11));
				if (!csvRecord.get(12).isEmpty()) {
					try {
						inv.setQuantityInvoiced(new BigDecimal(csvRecord.get(12).replace(",", "")));
					} catch (Exception e) {
						throw new AyaraCustomException("Invoice Quantity  not in Numeric format");
					}
				}
				if (!csvRecord.get(13).isEmpty()) {
					try {
						inv.setUnitSellingPrice(new BigDecimal(csvRecord.get(13).replace(",", "")));
					} catch (Exception e) {
						throw new AyaraCustomException("Invoice Unit Selling Price  not in Numeric format");
					}
				}
				inv.setInvoiceCurrency(csvRecord.get(14));
				if (!csvRecord.get(15).isEmpty()) {
					try {
						inv.setRevenueAmount(new BigDecimal(csvRecord.get(15).replace(",", "")));
					} catch (Exception e) {

						throw new AyaraCustomException("Invoice Amount  not in Numeric format");
					}
				}

				inv.setAcctdCurrency(csvRecord.get(16));
				if (!csvRecord.get(17).isEmpty()) {
					try {
						inv.setAcctdRevAmount(new BigDecimal(csvRecord.get(17).replace(",", "")));
					} catch (Exception e) {
						throw new AyaraCustomException("Accounted Revenue Amount  not in Numeric format");
					}
				}
				if (!csvRecord.get(18).isEmpty()) {
					try {
						inv.setFxRate(new BigDecimal(csvRecord.get(18).replace(",", "")));
					} catch (Exception e) {
						throw new AyaraCustomException("Exchange Rate  not in Numeric format");
					}
				}
				if (!csvRecord.get(19).isEmpty()) {
					inv.setFxDate(convertStringtoTimestamp(csvRecord.get(19)));
				}

				inv.setInterfaceStatus("R");
				inv.setProcessId(batchId);
				inv.setCreatedBy(uploadUserId);
				inv.setFileName(fileName);
				inv.setFileType(fileType);

				invlist.add(inv);

			}
			if (!invlist.isEmpty()) {
				RmanFileUploadJobs job1 = rmanFileUploadJobRepository.getOne(batchId);
				job1.setTotalProcessRecords(new BigDecimal(invlist.size()));
				rmanFileUploadJobRepository.save(job1);
				saveBillingsDataAndProcess(invlist, batchId);
				List<RmanInvoiceLinesInterface> failedList = rmanInvoiceLinesInterfaceRepository
						.findByInterfaceStatusAndProcessId("E", batchId);
				int failedRecs = failedList.size();
				int successRecs = invlist.size() - failedList.size();
				RmanFileUploadJobs job2 = rmanFileUploadJobRepository.getOne(batchId);
				job2.setTotalFailedRecords(new BigDecimal(failedRecs));
				job2.setTotalSuccessRecords(new BigDecimal(successRecs));
				job2.setFinishedDate(new Timestamp(System.currentTimeMillis()));
				rmanFileUploadJobRepository.save(job2);
			}

		} catch (Exception e) {
			logger.error("Getting error when Billings file upload process due to {}" , e.getMessage());
			throw new AyaraCustomException(e.getMessage());
		}finally {
			csvParser.close();
		}
	}
	
	@Async
	@Override
	public void processCustomersFile(String batchId,BufferedReader bufferedReader, String fileName,RmanUsers loggedUserInfo) throws IOException {
		List<RmanCustomersInterface> customersList = new ArrayList<>();
		createJobRecord(batchId,"Customers File Process job","CUSTOMERS",fileName,loggedUserInfo);
		
		try {	
				
						CompletableFuture.supplyAsync(()->{
							Timestamp currentDate = new Timestamp(System.currentTimeMillis());
							BigDecimal createdBy = loggedUserInfo.getRmanUserId();
				CSVParser csvParser = null;
					
					try {
						csvParser = new CSVParser(bufferedReader,
										CSVFormat.DEFAULT.withHeader("CUSTOMER_ID", "CUSTOMER_NAME", "CUSTOMER_NUMBER", "STATUS")
										.withSkipHeaderRecord().withIgnoreHeaderCase().withTrim());
						for (CSVRecord csvRecord : csvParser) {
							if (!csvRecord.isConsistent()) {
								throw new AyaraCustomException(CONSTANTS.ROW_SIZE_MISMATCH);
							}
			
							if (!csvRecord.get(0).isEmpty()) {
								RmanCustomersInterface cust = new RmanCustomersInterface();
			
								if (!csvRecord.get(0).isEmpty()) {
									try {
										cust.setCustomerId(new BigDecimal(csvRecord.get(0).replace(",", "")));
									} catch (Exception e) {
										throw new AyaraCustomException("Customer Id not in Numeric format");
									}
								}
								cust.setCustomerName(csvRecord.get(1));
								cust.setCustomerNumber(csvRecord.get(2));
								cust.setStatus(csvRecord.get(3));
								if (!csvRecord.get(0).isEmpty()) {
									cust.setOrigSystemReference(csvRecord.get(0));
								}
			
								cust.setCreationDate(currentDate);
								cust.setCreatedBy(createdBy);
								cust.setLastUpdateDate(currentDate);
								cust.setLastUpdatedBy(createdBy);
								cust.setAttribute23("R");
								cust.setAttribute24(String.valueOf(batchId));
								customersList.add(cust);
							}
						}
					} catch (IOException e1) {
						logger.error("Getting error  while processed customer file due to {}"+e1.getMessage());
					}finally {
						try {
							csvParser.close();
						} catch (IOException e) {
							logger.error("Error Occured while closing csvParser: {}" ,e.getMessage());
						}
					}
								return customersList;
						}).thenApply(x -> {
							 if(x.isEmpty()) {
									throw new AyaraCustomException("No Data insered into Customers Interface table");
							 }
							CompletableFuture<Boolean> cf2 = CompletableFuture.completedFuture(saveCustomersDataAndProcess(customersList));
							if(cf2.isDone()) {
								List<RmanCustomersInterface> failedList = rmanCustomersInterfaceRepository
										.findByAttribute23AndAttribute24("E", String.valueOf(batchId));
								int processRecs = customersList.size();
								int failedRecs = failedList.size();
								int successRecs = customersList.size() - failedList.size();
								RmanFileUploadJobs job2 = rmanFileUploadJobRepository.findByJobId(String.valueOf(batchId));
								RmanFileUploadJobs job3 = updateJobRecord(job2, new BigDecimal(processRecs), new BigDecimal(failedRecs), new BigDecimal(successRecs), CONSTANTS.COMPLETED);
								//Job Notification email condition
								if(RevmantraUtils.getProperty(CONSTANTS.JOB_COMPLETE_NOTIFICATION).equalsIgnoreCase("Yes")) {
									jobNotificationMail(loggedUserInfo, job3);
								}
							}
							return x;
						});
		} catch (Exception e) {
			logger.error("Getting error when Customers file upload process due to {}" , e.getMessage());
			RmanFileUploadJobs job4 = updateJobRecord(rmanFileUploadJobRepository.findByJobId(batchId)
					 ,new BigDecimal(0)
					 ,new BigDecimal(0)
	                 ,new BigDecimal(0)
	                 ,CONSTANTS.FAILED
	                 );
			//Job Notification email condition
			if(RevmantraUtils.getProperty(CONSTANTS.JOB_COMPLETE_NOTIFICATION).equalsIgnoreCase("Yes")) {
				jobNotificationMail(loggedUserInfo, job4);
			}
			throw new AyaraCustomException(e.getMessage());
		}

	}
	
	@Async
	@Override
	public void processProductsFile(String batchId,BufferedReader bufferedReader, String fileName,RmanUsers loggedUserInfo) {
		List<RmanProductsInterface> productsList = new ArrayList<>();
		createJobRecord(batchId,"Products File Process job","PRODUCTS",fileName,loggedUserInfo);
		
		try {
					CompletableFuture
					.supplyAsync(()->{
						CSVParser csvParser;
						try {
							csvParser = new CSVParser(bufferedReader,
									CSVFormat.DEFAULT
											.withHeader("INVENTORY_ITEM_ID", "SEGMENT1", "DESCRIPTION", "ORGANIZATION_ID", "PROD_ORG",
													"BUSINESS_UNIT", "INVENTORY_ITEM_STATUS_CODE", "ITEM_TYPE", "PRODUCT_COST",
													"SALES_ACCOUNT", "CORP", "DIVISION", "DEPARTMENT", "NATURAL_ACCOUNT",
													"SHIPPABLE_ITEM_FLAG", "PRODUCT_FAMILY", "PRODUCT_PORTFOLIO", "PRODUCT_LINE",
													"Part Product Line", "LINE_OF_BUSINESS", "INVOICING_RULE", "PRODUCT_ELEMENT",
													"BUNDLED_ITEM", "PRIMARY_UNIT_OF_MEASURE", "START_DATE_ACTIVE", "END_DATE_ACTIVE",
													"INVOICE_ENABLED_FLAG", "PRODUCT_SERVICE", "PRODUCT_ FAMILY2", "REVENUE_TEMPLATE")
											.withSkipHeaderRecord().withIgnoreHeaderCase().withTrim());
							for (CSVRecord csvRecord : csvParser) {

								if (!csvRecord.isConsistent()) {
									throw new AyaraCustomException(CONSTANTS.ROW_SIZE_MISMATCH);
								}

								if (!csvRecord.get(0).isEmpty()) {
									RmanProductsInterface prod = new RmanProductsInterface();

									if (!csvRecord.get(0).isEmpty()) {
										try {
											prod.setSourceProductId(new BigDecimal(csvRecord.get(0).replace(",", "")));
										} catch (Exception e) {
											throw new AyaraCustomException("Inventory Item Id not in Numeric format");
										}
									}
									prod.setProductName(csvRecord.get(1));
									prod.setProductDescription(csvRecord.get(2));
									if (!csvRecord.get(3).isEmpty()) {
										try {
											prod.setProductOrgId(new BigDecimal(csvRecord.get(3).replace(",", "")));
										} catch (Exception e) {
											throw new AyaraCustomException("Product Org Id not in Numeric format");
										}
									}
									prod.setProductOrgName(csvRecord.get(4));
									prod.setProductOrgCode(csvRecord.get(5));
									prod.setProductStatus(csvRecord.get(6));
									prod.setProductType(csvRecord.get(7));

									if (!csvRecord.get(8).isEmpty()) {
										try {
											prod.setProductCost(new BigDecimal(csvRecord.get(8).replace(",", "")));
										} catch (Exception e) {
											throw new AyaraCustomException("Product Cost not in Numeric format");
										}
									}
									if (!csvRecord.get(9).isEmpty()) {
										try {
											prod.setRevAccountId(new BigDecimal(csvRecord.get(9).replace(",", "")));
										} catch (Exception e) {
											throw new AyaraCustomException("Sales Account Id not in Numeric format");
										}
									}
									prod.setShippableFlag(csvRecord.get(14));
									prod.setAttribute1(csvRecord.get(16));
									prod.setAttribute2(csvRecord.get(15));
									prod.setAttribute3(csvRecord.get(17));
									prod.setAttribute4(csvRecord.get(18));
									prod.setInterfaceStatus("R");
									prod.setUom(csvRecord.get(23));
									prod.setInvoiceEnabledFlag(csvRecord.get(26));
									// Added below line to product_Service value on May 5th 2020
									prod.setAttribute5(csvRecord.get(27));
									// Added below line to product_Service value on May 5th 2020
									prod.setAttribute6(csvRecord.get(28));
									//Added below line for mapping REVENUE_TEMPLATE to attribute25 by Madhu Sri - #AYAR-397
									prod.setAttribute25(csvRecord.get(29));
									prod.setInterfaceProcessId(new BigDecimal(batchId));
									productsList.add(prod);
								}
							}

						} catch (IOException e1) {
							logger.error(e1);
						}
						return productsList;
					 })
					.thenApply(pList -> {
						if (!pList.isEmpty()) {
							saveProductsDataAndProcess(pList);
							List<RmanProductsInterface> failedList = rmanProductsInterfaceRepository
									.findByInterfaceStatusAndInterfaceProcessId("E", new BigDecimal(batchId));
							int processRecs = pList.size();
							int failedRecs = failedList.size();
							int successRecs = pList.size() - failedList.size();
							RmanFileUploadJobs job2 = rmanFileUploadJobRepository.findByJobId(String.valueOf(batchId));
							RmanFileUploadJobs job3 = updateJobRecord(job2, new BigDecimal(processRecs), new BigDecimal(failedRecs), new BigDecimal(successRecs), CONSTANTS.COMPLETED);
							//Job Notification email condition
							if(RevmantraUtils.getProperty(CONSTANTS.JOB_COMPLETE_NOTIFICATION).equalsIgnoreCase("Yes")) {
								jobNotificationMail(loggedUserInfo, job3);
							}
						} else {
							throw new AyaraCustomException("No Data insered into Products Interface table");
						}
						
						return pList;
					});
			
		} catch (Exception e) {
			logger.error("Getting error when Products file upload process due to {}" , e.getMessage());
			throw new AyaraCustomException(e.getMessage());
		}
	}
	
	/**
	 * 
	 * @param batchId
	 * @param bufferedReader
	 * @param fileName
	 * @param loggedUserInfo
	 * #AYARA-1816 by chandra Kota on 07 JAN 2022
	 * The following method not Used for the SSP File Upload Process CSV File Upload instead use the processSSPRulesFile method
	 */
	public void processSSPRulesFileBkp(String batchId,BufferedReader bufferedReader, String fileName,RmanUsers loggedUserInfo) {
		List<SspRulesInterface> sspRulesList = new ArrayList<>();
		createJobRecord(batchId,"SSP Rules File Process job","SSP",fileName,loggedUserInfo);
		Timestamp currentDate = new Timestamp(System.currentTimeMillis());
		
		try {
					CompletableFuture.supplyAsync(()-> {
						CSVParser csvParser;
						
						try {
							csvParser= new CSVParser(bufferedReader,
									CSVFormat.DEFAULT
											.withHeader("SSP_RULE_NAME","SSP_CATEGORY", "SSP_TYPE","SSP_PRICE", "SSP_MIN","SSP_MEDIAN", "SSP_MAX", "SSP_START_DATE",
													"SSP_END_DATE","SSP_CURRENCY","SSP_RULE_STATUS","SSP_PARAM1","SSP_PARAM1_QUALIFIER", "SSP_PARAM1_VALUE", "SSP_PARAM2","SSP_PARAM2_QUALIFIER","SSP_PARAM2_VALUE",
													"SSP_PARAM3","SSP_PARAM3_QUALIFIER","SSP_PARAM3_VALUE","SSP_PARAM4","SSP_PARAM4_QUALIFIER","SSP_PARAM4_VALUE")
											.withSkipHeaderRecord().withIgnoreHeaderCase().withTrim());
							
							for (CSVRecord csvRecord : csvParser) {
								if (!csvRecord.isConsistent()) {
									throw new AyaraCustomException(CONSTANTS.ROW_SIZE_MISMATCH);
								}
				
									SspRulesInterface sspRule = new SspRulesInterface();
									sspRule.setSspRuleName(csvRecord.get(0));
									sspRule.setSspCategory(csvRecord.get(1));
									sspRule.setSspType(csvRecord.get(2));
									if (!csvRecord.get(3).isEmpty()) {
										try {
											sspRule.setSspPrice(new BigDecimal(csvRecord.get(3).replace(",", "")));
										} catch (Exception e) {
											throw new AyaraCustomException("SSP Price value not in Numeric format");
										}
									}
									if (!csvRecord.get(4).isEmpty()) {
										try {
											sspRule.setSspMin(new BigDecimal(csvRecord.get(4).replace(",", "")));
										} catch (Exception e) {
											throw new AyaraCustomException("SSP Min value not in Numeric format");
										}
									}
									if (!csvRecord.get(5).isEmpty()) {
										try {
											sspRule.setSspMedian(new BigDecimal(csvRecord.get(5).replace(",", "")));
										} catch (Exception e) {
											throw new AyaraCustomException("SSP Median value not in Numeric format");
										}
									}
									if (!csvRecord.get(6).isEmpty()) {
										try {
											sspRule.setSspMax(new BigDecimal(csvRecord.get(6).replace(",", "")));
										} catch (Exception e) {
											throw new AyaraCustomException("SSP Max value not in Numeric format");
										}
									}
									if (!csvRecord.get(7).isEmpty()) {
										sspRule.setSspStartDate(convertStringtoTimestamp(csvRecord.get(7)));
									}
				
									if (!csvRecord.get(8).isEmpty()) {
										sspRule.setSspEndDate(convertStringtoTimestamp(csvRecord.get(8)));
									}
									
									sspRule.setSspcurrency(csvRecord.get(9));
									sspRule.setSspRuleStatus(csvRecord.get(10));
									
									sspRule.setSspParam1(csvRecord.get(11));
									sspRule.setSspParam1Qualifier(csvRecord.get(12));
									sspRule.setSspParam1Value(csvRecord.get(13));
									
									sspRule.setSspParam2(csvRecord.get(14));
									sspRule.setSspParam2Qualifier(csvRecord.get(15));
									sspRule.setSspParam2Value(csvRecord.get(16));
									
									
									sspRule.setSspParam3(csvRecord.get(17));
									sspRule.setSspParam3Qualifier(csvRecord.get(18));
									sspRule.setSspParam3Value(csvRecord.get(19));
									
									sspRule.setSspParam4(csvRecord.get(20));
									sspRule.setSspParam4Qualifier(csvRecord.get(21));
									sspRule.setSspParam4Value(csvRecord.get(22));
									
									sspRule.setCreationDate(currentDate);
									sspRule.setProcessFlag("N");
									sspRule.setProcessId(batchId);
									sspRulesList.add(sspRule);
								
							}
						}catch(IOException ie) {
							logger.error(ie);
						}
						return sspRulesList;
					}).thenApply(sspList ->{
						if (!sspList.isEmpty()) {
							saveSSPRulesDataAndProcess(sspList,batchId);
							
							List<SspRulesInterface> failedList = sspRulesInterfaceRepository.findByProcessFlagAndProcessId("E",
									batchId);
							int failedRecs = failedList.size();
							int successRecs = sspList.size() - failedList.size();
							RmanFileUploadJobs job2 = rmanFileUploadJobRepository.getOne(batchId);
							RmanFileUploadJobs job3 = updateJobRecord(job2, new BigDecimal(sspList.size()), new BigDecimal(failedRecs), new BigDecimal(successRecs), CONSTANTS.COMPLETED);
							//Job Notification email condition
							if(RevmantraUtils.getProperty(CONSTANTS.JOB_COMPLETE_NOTIFICATION).equalsIgnoreCase("Yes")) {
								jobNotificationMail(loggedUserInfo, job3);
							}
							
						} else {
							throw new AyaraCustomException("No Data insered into SSP Rules Interface table");
						}
						return sspList;
					});
		} catch (Exception e) {
			logger.error("Getting error when SSP Rules file upload process due to {}" , e.getMessage());
			throw new AyaraCustomException(e.getMessage());
		}

	}
	
	@Async
	@Override
	public void processGLAccountsFile(String batchId,BufferedReader bufferedReader, String fileName,RmanUsers loggedUserInfo) {
		List<RmanGlAccountsInterface> glAcctsList = new ArrayList<>();
		createJobRecord(batchId,"GL Accounts File Process job","GL_ACCOUNTS",fileName,loggedUserInfo);
		
		try {
			
					CompletableFuture.supplyAsync(()->{
						CSVParser csvParser;
						try {
							csvParser = new CSVParser(bufferedReader, CSVFormat.DEFAULT
									.withHeader("CODE_COMBINATION_ID", "LAST_UPDATE_DATE", "LAST_UPDATED_BY", "CHART_OF_ACCOUNTS_ID",
											"DETAIL_POSTING_ALLOWED_FLAG", "DETAIL_BUDGETING_ALLOWED_FLAG", "ACCOUNT_TYPE",
											"ENABLED_FLAG", "SUMMARY_FLAG", "SEGMENT1", "SEGMENT2", "SEGMENT3", "SEGMENT4", "SEGMENT5",
											"SEGMENT6", "SEGMENT7", "SEGMENT8", "SEGMENT9", "SEGMENT10", "SEGMENT11", "SEGMENT12",
											"SEGMENT13", "SEGMENT14", "SEGMENT15", "SEGMENT16", "SEGMENT17", "SEGMENT18", "SEGMENT19",
											"SEGMENT20", "SEGMENT21", "SEGMENT22", "SEGMENT23", "SEGMENT24", "SEGMENT25", "SEGMENT26",
											"SEGMENT27", "SEGMENT28", "SEGMENT29", "SEGMENT30")
									.withSkipHeaderRecord().withIgnoreHeaderCase().withTrim());
							for (CSVRecord csvRecord : csvParser) {
								if (!csvRecord.get(0).isEmpty()) {

									RmanGlAccountsInterface glAcct = new RmanGlAccountsInterface();
									if (!csvRecord.get(0).isEmpty()) {
										try {
											glAcct.setSourceAccountId(new BigDecimal(csvRecord.get(0).replace(",", "")));
										} catch (Exception e) {
											throw new AyaraCustomException("GL Code Combination Id value not in Numeric format");
										}
									}
									if (!csvRecord.get(3).isEmpty()) {
										try {
											glAcct.setSourceLedgerId(new BigDecimal(csvRecord.get(3).replace(",", "")));
										} catch (Exception e) {
											throw new AyaraCustomException("Sets of Book Id value not in Numeric format");
										}
									}
									glAcct.setAccountType(csvRecord.get(6));
									glAcct.setEnabledFlag(csvRecord.get(7));
									glAcct.setSegment1(csvRecord.get(9));
									glAcct.setSegment2(csvRecord.get(10));
									glAcct.setSegment3(csvRecord.get(11));
									glAcct.setSegment4(csvRecord.get(12));
									glAcct.setSegment5(csvRecord.get(13));
									glAcct.setSegment6(csvRecord.get(14));
									StringBuilder sf = new StringBuilder();
									sf.append(csvRecord.get(9)).append("-").append(csvRecord.get(10)).append("-")
											.append(csvRecord.get(11)).append("-").append(csvRecord.get(12)).append("-")
											.append(csvRecord.get(13)).append("-").append(csvRecord.get(14));
									glAcct.setAccountingString(sf.toString());
									glAcct.setInterfaceStatus("N");
									glAcct.setRequestId(new BigDecimal(batchId));
									glAcctsList.add(glAcct);
								}
							}
						} catch (IOException e1) {
							logger.error(e1);
						}
						return glAcctsList;
					}).thenApply(
							glaList ->{
								if (!glaList.isEmpty()) {
									saveGLAccountsDataAndProcess(glaList,new BigDecimal(batchId));
									List<RmanGlAccountsInterface> failedList = rmanGlAccountsInterfaceRepository
											.findByInterfaceStatusAndRequestId("E", new BigDecimal(batchId));
									int failedRecs = failedList.size();
									int successRecs = glaList.size() - failedList.size();
									RmanFileUploadJobs job2 = rmanFileUploadJobRepository.findByJobId(String.valueOf(batchId));
									RmanFileUploadJobs job3 = updateJobRecord(job2, new BigDecimal(glaList.size()), new BigDecimal(failedRecs), new BigDecimal(successRecs), CONSTANTS.COMPLETED);
									//Job Notification email condition
									if(RevmantraUtils.getProperty(CONSTANTS.JOB_COMPLETE_NOTIFICATION).equalsIgnoreCase("Yes")) {
										jobNotificationMail(loggedUserInfo, job3);
									}
									
								} else {
									throw new AyaraCustomException("No Data insered into SSP Rules Interface table");
								}
								return glaList;
					});
		} catch (Exception e) {
			logger.error("Getting error when GL Accounts/CCIDs file upload process due to {}" , e.getMessage());
			RmanFileUploadJobs job4 = updateJobRecord(rmanFileUploadJobRepository.findByJobId(batchId)
					 ,new BigDecimal(0)
					 ,new BigDecimal(0)
	                 ,new BigDecimal(0)
	                 ,CONSTANTS.FAILED
	                 );
			//Job Notification email condition
			if(RevmantraUtils.getProperty(CONSTANTS.JOB_COMPLETE_NOTIFICATION).equalsIgnoreCase("Yes")) {
				jobNotificationMail(loggedUserInfo, job4);
			}
			throw new AyaraCustomException(e.getMessage());
		}

	}

	@Transactional
	private void saveBookingsDataAndProcess(List<RmanOrdersInterface> rmanOrdersList, BigDecimal userId,
			BigDecimal batchId) {
		int size = rmanOrdersList.size();
		int counter = 0;
		List<RmanOrdersInterface> temp = new ArrayList<>();
		for (RmanOrdersInterface emp : rmanOrdersList) {
			temp.add(emp);
			if ((counter + 1) % 500 == 0 || (counter + 1) == size) {
				rmanOrdersInterfaceRepository.saveAll(temp);
				temp.clear();
			}

			counter++;
		}
		try {
			StoredProcedureQuery storedProcedure = manager
					.createStoredProcedureQuery("rman_import_pkg.import_from_interface")
					.registerStoredProcedureParameter("pv_req_id", BigDecimal.class, ParameterMode.IN);
			storedProcedure.setParameter("pv_req_id", batchId);
			storedProcedure.execute();
		} catch (Exception e) {
			throw new AyaraCustomException("Bookings Process job failed.Contact System Administrator.");
		}

	}

	@Transactional
	private void saveShipmentsDataAndProcess(List<RmanOrdersInterface> rmanOrdersList, BigDecimal userId,
			String groupId) {
		int size = rmanOrdersList.size();
		int counter = 0;
		List<RmanOrdersInterface> temp = new ArrayList<>();
		for (RmanOrdersInterface emp : rmanOrdersList) {
			temp.add(emp);
			if ((counter + 1) % 500 == 0 || (counter + 1) == size) {
				rmanOrdersInterfaceRepository.saveAll(temp);
				temp.clear();
			}

			counter++;
		}
		try {
			StoredProcedureQuery storedProcedure = manager
					.createStoredProcedureQuery("rman_import_pkg.process_shipments_interface")
					.registerStoredProcedureParameter("p_group_id", String.class, ParameterMode.IN);
			storedProcedure.setParameter("p_group_id", groupId);
			storedProcedure.execute();
		} catch (Exception e) {
			throw new AyaraCustomException("Shipments Process job failed.Contact System Administrator.");
		}

	}

	@Transactional
	private void saveBillingsDataAndProcess(List<RmanInvoiceLinesInterface> rmanBillingsList, String processId) {
		int size = rmanBillingsList.size();
		int counter = 0;
		List<RmanInvoiceLinesInterface> temp = new ArrayList<>();
		for (RmanInvoiceLinesInterface emp : rmanBillingsList) {
			temp.add(emp);
			if ((counter + 1) % 500 == 0 || (counter + 1) == size) {
				rmanInvoiceLinesInterfaceRepository.saveAll(temp);
				temp.clear();
			}

			counter++;
		}

		try {

			StoredProcedureQuery storedProcedure = manager
					.createStoredProcedureQuery("rman_process_invoices_pkg.main_proc")
					.registerStoredProcedureParameter(CONSTANTS.P_PROCESS_ID, String.class, ParameterMode.IN);
			storedProcedure.setParameter(CONSTANTS.P_PROCESS_ID, processId);
			storedProcedure.execute();
		} catch (Exception e) {
			throw new AyaraCustomException("Billings Process job failed.Contact System Administrator.");
		}
	}

	@Transactional
	private Boolean saveCustomersDataAndProcess(List<RmanCustomersInterface> rmanCustomersList) {
		int size = rmanCustomersList.size();
		int counter = 0;
		List<RmanCustomersInterface> temp = new ArrayList<>();
		for (RmanCustomersInterface emp : rmanCustomersList) {
			temp.add(emp);
			if ((counter + 1) % 500 == 0 || (counter + 1) == size) {
				rmanCustomersInterfaceRepository.saveAll(temp);
				temp.clear();
			}

			counter++;
		}
		try {
			StoredProcedureQuery storedProcedure = manager
					.createStoredProcedureQuery("import_customers_pkg.import_customers");
			storedProcedure.execute();
		} catch (Exception e) {
			throw new AyaraCustomException("Customers Process job failed in Ayara.Contact System Administrator.");
		}
		return true;
		
	}

	@Transactional
	private void saveProductsDataAndProcess(List<RmanProductsInterface> rmanProductsist) {
		int size = rmanProductsist.size();
		int counter = 0;
		List<RmanProductsInterface> temp = new ArrayList<>();
		for (RmanProductsInterface emp : rmanProductsist) {
			temp.add(emp);
			if ((counter + 1) % 500 == 0 || (counter + 1) == size) {
				rmanProductsInterfaceRepository.saveAll(temp);
				temp.clear();
			}

			counter++;
		}
		try {
			StoredProcedureQuery storedProcedure = manager
					.createStoredProcedureQuery("rman_process_pkg.populate_products");
			storedProcedure.execute();
		} catch (Exception e) {
			throw new AyaraCustomException("Products Process job failed in Ayara.Contact System Administrator.");
		}
	}

	@Transactional
	private Boolean saveSSPRulesDataAndProcess(List<SspRulesInterface> sspRulesInterfaceList,String batchId) {
		int size = sspRulesInterfaceList.size();
		int counter = 0;
		List<SspRulesInterface> temp = new ArrayList<>();
		for (SspRulesInterface emp : sspRulesInterfaceList) {
			temp.add(emp);
			if ((counter + 1) % 500 == 0 || (counter + 1) == size) {
				sspRulesInterfaceRepository.saveAll(temp);
				temp.clear();
			}

			counter++;
		}
		try {
			StoredProcedureQuery storedProcedure = manager
					.createStoredProcedureQuery("rman_ssp_rules_process_pkg.populate_ssp_rules")
					.registerStoredProcedureParameter(CONSTANTS.P_PROCESS_ID, String.class, ParameterMode.IN);
					storedProcedure.setParameter(CONSTANTS.P_PROCESS_ID, batchId);
			storedProcedure.execute();
		} catch (Exception e) {
			throw new AyaraCustomException("SSP Rules Process job failed in Ayara.Contact System Administrator.");
		}
		
		return true;
	}

	@Transactional
	private void saveGLAccountsDataAndProcess(List<RmanGlAccountsInterface> rmanGLAccountsInterfaceList,BigDecimal processId) {
		int size = rmanGLAccountsInterfaceList.size();
		int counter = 0;
		List<RmanGlAccountsInterface> temp = new ArrayList<>();
		for (RmanGlAccountsInterface emp : rmanGLAccountsInterfaceList) {
			temp.add(emp);
			if ((counter + 1) % 500 == 0 || (counter + 1) == size) {
				rmanGlAccountsInterfaceRepository.saveAll(temp);
				temp.clear();
			}

			counter++;
		}
		try {
			StoredProcedureQuery storedProcedure = manager
					.createStoredProcedureQuery("POPULATE_GL_ACCOUNTS_PKG.POPULATE_GL_ACCOUNTS")
					.registerStoredProcedureParameter(CONSTANTS.P_PROCESS_ID, BigDecimal.class, ParameterMode.IN);
					storedProcedure.setParameter(CONSTANTS.P_PROCESS_ID, processId);
			storedProcedure.execute();
		} catch (Exception e) {
			throw new AyaraCustomException("GL Accounts creation job failed in Ayara.Contact System Administrator.");
		}
	}

	@Override
	public void processConversionRatesFile(String batchId,BufferedReader bufferedReader, String fileName) {
		List<RmanConversionRatesInt> convRateslist = new ArrayList<>();
		BigDecimal uploadUserId = BaseListener.getCurrentUserId() != null ? BaseListener.getCurrentUserId()
				: new BigDecimal(-1);
		Timestamp currentDate = new Timestamp(System.currentTimeMillis());
		RmanFileUploadJobs job = new RmanFileUploadJobs();
		job.setJobId(batchId);
		job.setJobName("Conversion Rates File Process job");
		job.setStartDate(currentDate);
		job.setAttribute1("CONV_RATES");
		job.setAttribute2(BaseListener.getUserInfo().getFullName());
		job.setAttribute3(fileName);
		job.setCreatedBY(BaseListener.getCurrentUserId());
		job.setLastUpdatedBy(BaseListener.getCurrentUserId());
		job.setJobStatus("INPROGRESS");
		
		rmanFileUploadJobRepository.save(job);

		try {
			CSVParser csvParser = new CSVParser(bufferedReader, CSVFormat.DEFAULT
					.withHeader("FROM_CURRENCY", "TO_CURRENCY", "CONVERSION_DATE", "CONVERSION_TYPE", "CONVERSION_RATE",
							"STATUS_CODE", "CREATION_DATE", "CREATED_BY", "LAST_UPDATE_DATE", "LAST_UPDATED_BY",
							"LAST_UPDATE_LOGIN", "CONTEXT", "ATTRIBUTE1", "ATTRIBUTE2", "ATTRIBUTE3", "ATTRIBUTE4",
							"ATTRIBUTE5", "ATTRIBUTE6", "ATTRIBUTE7", "ATTRIBUTE8", "ATTRIBUTE9", "ATTRIBUTE10",
							"ATTRIBUTE11", "ATTRIBUTE12", "ATTRIBUTE13", "ATTRIBUTE14", "ATTRIBUTE15")
					.withSkipHeaderRecord().withIgnoreHeaderCase().withTrim());

			for (CSVRecord csvRecord : csvParser) {
				RmanConversionRatesInt convRate = new RmanConversionRatesInt();
				if (!csvRecord.get(0).isEmpty()) {
					convRate.setFromCurrency(csvRecord.get(0));
				}
				if (!csvRecord.get(1).isEmpty()) {
					convRate.setToCurrency(csvRecord.get(1));
				}
				if (!csvRecord.get(2).isEmpty()) {
					convRate.setConversionDate(convertStringtoTimestamp(csvRecord.get(2)));
				}
				if (!csvRecord.get(3).isEmpty()) {
					convRate.setConversionType(csvRecord.get(3));
				}
				if (!csvRecord.get(4).isEmpty()) {
					convRate.setConversionRate(new BigDecimal(csvRecord.get(4).replace(",", "")));
				}
				if (!csvRecord.get(5).isEmpty()) {
					convRate.setStatusCode(csvRecord.get(5));
				}
				if (!csvRecord.get(6).isEmpty()) {
					convRate.setOriginalCreatedDate(convertStringtoTimestamp(csvRecord.get(6)));
				}
				if (!csvRecord.get(7).isEmpty()) {
					convRate.setOriginalCreatedBy(new BigDecimal(csvRecord.get(7).replace(",", "")));
				}
				if (!csvRecord.get(8).isEmpty()) {
					convRate.setOrginalLastUpdatedDate(convertStringtoTimestamp(csvRecord.get(8)));
				}
				if (!csvRecord.get(9).isEmpty()) {
					convRate.setOriginalLastUpdatedBy(new BigDecimal(csvRecord.get(9).replace(",", "")));
				}
				if (!csvRecord.get(10).isEmpty()) {
					convRate.setOriginalLastUpdatedLogin(
							new BigDecimal(csvRecord.get(10).replace(",", "")));
				}

				if (!csvRecord.get(11).isEmpty()) {
					convRate.setContext(csvRecord.get(11));
				}
				convRate.setAttribute1(csvRecord.get(12));
				convRate.setAttribute2(csvRecord.get(13));
				convRate.setAttribute3(csvRecord.get(14));
				convRate.setAttribute4(csvRecord.get(15));
				convRate.setAttribute5(csvRecord.get(16));
				convRate.setAttribute6(csvRecord.get(17));
				convRate.setAttribute7(csvRecord.get(18));
				convRate.setAttribute8(csvRecord.get(19));
				convRate.setAttribute9(csvRecord.get(20));
				convRate.setAttribute10(csvRecord.get(21));
				convRate.setAttribute11(csvRecord.get(22));
				convRate.setAttribute12(csvRecord.get(23));
				convRate.setAttribute13(csvRecord.get(24));
				convRate.setAttribute14(csvRecord.get(25));
				convRate.setAttribute15(csvRecord.get(26));

				convRate.setCreatedDate(currentDate);
				convRate.setCreatedBy(uploadUserId);
				convRate.setLastUpdatedBy(uploadUserId);
				convRate.setLastUpdatedDate(currentDate);

				convRate.setInterfaceStatus("R");
				convRate.setProcessId(batchId);

				convRateslist.add(convRate);

			}
			if (!convRateslist.isEmpty()) {

				RmanFileUploadJobs job1 = rmanFileUploadJobRepository.getOne(batchId);
				job1.setTotalProcessRecords(new BigDecimal(convRateslist.size()));
				rmanFileUploadJobRepository.save(job1);
				saveConversionRatesDataAndProcess(convRateslist, batchId, BaseListener.getCurrentUserId());
				List<RmanConversionRatesInt> failedList = rmanConversionRatesIntRepository
						.findByInterfaceStatusAndProcessId("E", batchId);
				int failedRecs = failedList.size();
				int successRecs = convRateslist.size() - failedList.size();
				RmanFileUploadJobs job2 = rmanFileUploadJobRepository.getOne(batchId);
				job2.setTotalFailedRecords(new BigDecimal(failedRecs));
				job2.setTotalSuccessRecords(new BigDecimal(successRecs));
				job2.setFinishedDate(new Timestamp(System.currentTimeMillis()));
				job2.setJobStatus(CONSTANTS.COMPLETED);
				rmanFileUploadJobRepository.save(job2);
			}

		} catch (Exception e) {
			logger.error("Getting error when Conversion Rates file upload process due to {}" , e.getMessage());
			throw new AyaraCustomException(e.getMessage());
		}

	}

	@Transactional
	private void saveConversionRatesDataAndProcess(List<RmanConversionRatesInt> convRateslist, String processId,
			BigDecimal currentUserId) {
		int size = convRateslist.size();
		int counter = 0;
		List<RmanConversionRatesInt> temp = new ArrayList<>();
		for (RmanConversionRatesInt emp : convRateslist) {
			temp.add(emp);
			if ((counter + 1) % 500 == 0 || (counter + 1) == size) {
				rmanConversionRatesIntRepository.saveAll(temp);
				temp.clear();
			}

			counter++;
		}
		try {
			StoredProcedureQuery storedProcedure = manager
					.createStoredProcedureQuery("RMAN_CONV_RATES_PKG.PROCESS_CONVERSION_RATES_PROC")
					.registerStoredProcedureParameter(CONSTANTS.P_PROCESS_ID, String.class, ParameterMode.IN)
					.registerStoredProcedureParameter(CONSTANTS.P_USER_ID, BigDecimal.class, ParameterMode.IN);
			storedProcedure.setParameter(CONSTANTS.P_PROCESS_ID, processId);
			storedProcedure.setParameter(CONSTANTS.P_USER_ID, currentUserId);
			storedProcedure.execute();
		} catch (Exception e) {
			throw new AyaraCustomException("Conversion Rates Process job failed.Contact System Administrator.");
		}

	}

	@Override
	public String checkOpenLineExists(BigDecimal transLineId) {
		logger.info("Checking open line exists or not while release contingency");
		return rmanContTransToReleaseRepo.checkOpenLineExists(transLineId);
	}
	
	@Override
	public String validatePeriodStatus(String periodName, String periodStatus, Date startDate, Date endDate) {
		logger.info("Checking Period Status");
		return rmanFiscalPeriodsRepository.validatePeriodStatus(periodName, periodStatus, startDate, endDate);
	}

	@Override
	public RmanContTransToRelease getRecord(BigDecimal transLineId) {
		logger.info("Fetching Trans to release contingency");
		return rmanContTransToReleaseRepo.getOne(transLineId);
	}

	@Override
	public RmanContTransToRelease updateContReleaseRecord(RmanContTransToRelease r) {

		return rmanContTransToReleaseRepo.save(r);
	}
	
	@Async
	@Override
	public void processAccountingPeriods(String batchId,BufferedReader bufferedReader, String fileName,RmanUsers loggedUserInfo) {

		List<RmanFiscalPeriodsInterface> acctPeriodslist = new ArrayList<>();
		BigDecimal uploadUserId = BaseListener.getCurrentUserId() != null ? BaseListener.getCurrentUserId()
				: new BigDecimal(-1);
		BigDecimal processId = new BigDecimal(batchId);
		Timestamp currentDate = new Timestamp(System.currentTimeMillis());
		createJobRecord(batchId, "Accounting Periods File Process job", "PERIODS", fileName, loggedUserInfo);
		try {
			
					CompletableFuture.supplyAsync(() ->{
						CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader(accountingPeriodColumns.class).withSkipHeaderRecord()
								.withIgnoreHeaderCase().withTrim();
						CSVParser csvParser;
						try {
							csvParser = new CSVParser(bufferedReader, csvFormat);
							for (CSVRecord csvRecord : csvParser) {

								if (!csvRecord.isConsistent()) {
									throw new AyaraCustomException(CONSTANTS.ROW_SIZE_MISMATCH);
								}
								RmanFiscalPeriodsInterface rfp = new RmanFiscalPeriodsInterface();

								if (!csvRecord.get(0).isEmpty()) {
									rfp.setPeriodSetName(csvRecord.get(0));
								} else {
									throw new AyaraCustomException("Period SetName must required");
								}
								if (!csvRecord.get(1).isEmpty()) {
									rfp.setPeriodName(csvRecord.get(1));
								} else {
									throw new AyaraCustomException("Period Name must required");
								}
								if (!csvRecord.get(2).isEmpty()) {
									rfp.setOrigLastUpdateDate(convertStringtoTimestamp(csvRecord.get(2)));
								}
								if (!csvRecord.get(3).isEmpty()) {
									rfp.setOrigLastUpdatedBy(new BigDecimal(csvRecord.get(3)));
								}
								if (!csvRecord.get(4).isEmpty()) {
									rfp.setStartDate(convertStringtoTimestamp(csvRecord.get(4)));
								} else {
									throw new AyaraCustomException("Start Date must required");
								}
								if (!csvRecord.get(5).isEmpty()) {
									rfp.setEndDate(convertStringtoTimestamp(csvRecord.get(5)));
								} else {
									throw new AyaraCustomException("End Date must required");
								}
								if (!csvRecord.get(6).isEmpty()) {
									rfp.setYearStartDate(convertStringtoTimestamp(csvRecord.get(6)));
								} else {
									throw new AyaraCustomException("Year Start Date must required");
								}
								if (!csvRecord.get(7).isEmpty()) {
									rfp.setQuarterStartDate(convertStringtoTimestamp(csvRecord.get(7)));
								} else {
									throw new AyaraCustomException("Quarter Start Date must required");
								}

								if (!csvRecord.get(8).isEmpty()) {
									rfp.setPeriodType(csvRecord.get(8));
								} else {
									throw new AyaraCustomException("Period Type must required");
								}

								if (!csvRecord.get(9).isEmpty()) {
									rfp.setPeriodYear(new BigDecimal(csvRecord.get(9)));
								} else {
									throw new AyaraCustomException("Period Year must required");
								}
								if (!csvRecord.get(10).isEmpty()) {
									rfp.setPeriodNum(new BigDecimal(csvRecord.get(10)));
								} else {
									throw new AyaraCustomException("Period Num must required");
								}
								if (!csvRecord.get(11).isEmpty()) {
									rfp.setQuarterNum(new BigDecimal(csvRecord.get(11)));
								} else {
									throw new AyaraCustomException("Quarter Num must required");
								}
								if (!csvRecord.get(12).isEmpty()) {
									rfp.setEnteredPeriodName(csvRecord.get(12));
								} else {
									throw new AyaraCustomException("Entered Period Name must required");
								}
								if (!csvRecord.get(13).isEmpty()) {
									rfp.setAdjustmentPeriodFlag(csvRecord.get(13));
								}
								if (!csvRecord.get(14).isEmpty()) {
									rfp.setOrigCreationDate(convertStringtoTimestamp(csvRecord.get(14)));
								}
								if (!csvRecord.get(15).isEmpty()) {
									rfp.setOrigCreatedBy(new BigDecimal(csvRecord.get(15)));
								}
								if (!csvRecord.get(16).isEmpty()) {
									rfp.setOrigLastUpdatedBy(new BigDecimal(csvRecord.get(16)));
								}

								rfp.setCreatedBy(uploadUserId);
								rfp.setLastUpdatedBy(uploadUserId);
								rfp.setCreationDate(currentDate);
								rfp.setLastUpdateDate(currentDate);
								rfp.setInterfaceProcessId(processId);
								rfp.setInterfaceStatus("R");
								rfp.setProcessedDate(currentDate);

								acctPeriodslist.add(rfp);

							}

						} catch (IOException e) {
							logger.error(e);
							throw new AyaraCustomException("Getting error while processing accounting Periods file to assign to list object");
						}

						
						return acctPeriodslist;
					})
			.thenApply(fpList -> {
				if (!fpList.isEmpty()) {
					RmanFileUploadJobs job1 = rmanFileUploadJobRepository.findByJobId(processId.toString());
					job1.setTotalProcessRecords(new BigDecimal(acctPeriodslist.size()));
					rmanFileUploadJobRepository.save(job1);
					saveAccountPeriodsAndProcess(acctPeriodslist);
					List<RmanFiscalPeriodsInterface> failedList = rmanFiscalPeriodsInterfaceRepo
							.findByInterfaceStatusAndInterfaceProcessId("E", processId);
					int failedRecs = failedList.size();
					int successRecs = acctPeriodslist.size() - failedList.size();
					RmanFileUploadJobs job2 = rmanFileUploadJobRepository.findByJobId(processId.toString());
					RmanFileUploadJobs job3 = updateJobRecord(job2, job2.getTotalProcessRecords(), new BigDecimal(failedRecs), new BigDecimal(successRecs), CONSTANTS.COMPLETED);
					
					//Job Notification email condition
					if(RevmantraUtils.getProperty(CONSTANTS.JOB_COMPLETE_NOTIFICATION).equalsIgnoreCase("Yes")) {
						jobNotificationMail(loggedUserInfo, job3);
					}
		
				}else {
					throw new AyaraCustomException("No Periods in the given file to process");
				}
				return fpList;
			});
					
			
			
		} catch (Exception e) {
			logger.error("Getting error when Accounting Periods file upload process due to {}" , e.getMessage());
			RmanFileUploadJobs job4 = updateJobRecord(rmanFileUploadJobRepository.findByJobId(batchId)
					 ,new BigDecimal(0)
					 ,new BigDecimal(0)
	                 ,new BigDecimal(0)
	                 ,CONSTANTS.FAILED
	                 );
			//Job Notification email condition
			if(RevmantraUtils.getProperty(CONSTANTS.JOB_COMPLETE_NOTIFICATION).equalsIgnoreCase("Yes")) {
				jobNotificationMail(loggedUserInfo, job4);
			}
			throw new AyaraCustomException(e.getMessage());
		}
	}

	@Transactional
	private void saveAccountPeriodsAndProcess(List<RmanFiscalPeriodsInterface> rmanPeriodsList) {
		int size = rmanPeriodsList.size();
		int counter = 0;
		List<RmanFiscalPeriodsInterface> temp = new ArrayList<>();
		for (RmanFiscalPeriodsInterface emp : rmanPeriodsList) {
			temp.add(emp);
			if ((counter + 1) % 500 == 0 || (counter + 1) == size) {
				rmanFiscalPeriodsInterfaceRepo.saveAll(temp);
				temp.clear();
			}

			counter++;
		}
		try {
			StoredProcedureQuery storedProcedure = manager
					.createStoredProcedureQuery("rman_process_pkg.populate_periods");
			storedProcedure.execute();
		} catch (Exception e) {
			throw new AyaraCustomException("Accounting Periods Process job failed.Contact System Administrator.");
		}

	}
	
	private void saveContractsDataAndProcess(List<RmanIntfDealDetails> contractsList, BigDecimal currentUserId,
			BigDecimal batchId) {
		int size = contractsList.size();
		int counter = 0;
		List<RmanIntfDealDetails> temp = new ArrayList<>();
		for (RmanIntfDealDetails contract : contractsList) {
			temp.add(contract);
			if ((counter + 1) % 500 == 0 || (counter + 1) == size) {
				rmanIntfDealDetailsRepository.saveAll(temp);
				temp.clear();
			}

			counter++;
		}
		try {
			StoredProcedureQuery storedProcedure = manager
					.createStoredProcedureQuery("AYARA_DEAL_INTF_PROCESS_PKG.PROCESS_DEALS")
					.registerStoredProcedureParameter(CONSTANTS.P_BATCH_ID, BigDecimal.class, ParameterMode.IN);
			storedProcedure.setParameter(CONSTANTS.P_BATCH_ID, batchId);
			storedProcedure.execute();
		} catch (Exception e) {
			throw new AyaraCustomException("Contracts Process job failed.Contact System Administrator.");
		}
		
	}
	
	@SuppressWarnings("unused")
	@Override
	public RmanLegalEntities upsertLegalEntity(RmanLegalEntities rle) {
		if((rle.getReportingCurrency() == null)) {
			throw new AyaraCustomException("Reporting Currency is null");
		}
		if((rle.getFunctionalCurrency() == null)) {
			throw new AyaraCustomException("Functional Currency is null");
		}
		if((rle.getCurrencyCode() == null)) {
			throw new AyaraCustomException("Currency Code is null");
		}
		if((rle.getAllocationCurrency() == null)) {
			throw new AyaraCustomException("Allocation Currency is null");
		}
		if((rle.getName() == null)) {
			throw new AyaraCustomException("Legal Entity Name is null");
		}
		if((rle.getEnabledFlag() == null)) {
			throw new AyaraCustomException("Enabled Flag is null");
		}
		
		if(rle.getAdditionalAttribute1()!=null){
			RmanLegalEntities rl= rmanLegalEntitiesRepository.findByAdditionalAttribute1(rle.getAdditionalAttribute1());

			if(rl!=null){
				if (rl.getCreatedBy()!=null) {
					rle.setCreatedBy(rl.getCreatedBy());	
				}
				if(rl.getCreationDate()!=null) {
					rle.setCreationDate(rl.getCreationDate());	
				}
				if(rl.getLegalEntityId()!=null) {
					rle.setLegalEntityId(rl.getLegalEntityId());	
				}
				
				return rmanLegalEntitiesRepository.save(rle);
			}else{
				
				RmanLegalEntities rlen = rmanLegalEntitiesRepository.findByNameIgnoreCase(rle.getName());
				
				if(rlen!=null){
					throw new AyaraCustomException("Legal Entity Name already exists");
				}else{
					return rmanLegalEntitiesRepository.save(rle);
				}
		
			}
		}else{
			throw new AyaraCustomException("No Reference Id Send to the Ayara");
		}		
	}


	@Override
	public RmanCustomers upsertCustomer(RmanCustomers rc) {
		if(rc.getCustomerName() == null) {
			throw new AyaraCustomException("Cutomer Name is null");
		}
		if(rc.getCustomerNumber() == null) {
			throw new AyaraCustomException("Cutomer Number is null");
		}
		if(rc.getStatus() == null) {
			throw new AyaraCustomException("Cutomer Status is null");
		}
		
		if(rc.getAdditionalAttribute1()!=null){
			
			RmanCustomers rcust = rmanCustomersRepository.findByAdditionalAttribute1(rc.getAdditionalAttribute1());
			
			if(rcust!=null){
				if(rcust.getCreationDate()!=null) {
					rc.setCreationDate(rcust.getCreationDate());	
				}
				
				if(rcust.getCreatedBy()!=null) {
					rc.setCreatedBy(rcust.getCreatedBy());
				}
				if(rcust.getCustomerId()!=null) {
					rc.setCustomerId(rcust.getCustomerId());
				}
				
				return rmanCustomersRepository.save(rc);
			}else{
				RmanCustomers rct = rmanCustomersRepository.findByCustomerNumber(rc.getCustomerNumber());
				
				if(rct!=null) {
					throw new AyaraCustomException("Cutomer Number already assigned to "+rct.getCustomerName());
				}else {
					return rmanCustomersRepository.save(rc);
				}
				
			}
		}else{
			throw new AyaraCustomException("No Customer Account Reference Id Send to the Ayara");
		}		
	}

	@Override
	public RmanRevenueTemplates upsertRevenueTemplate(RmanRevenueTemplates rrt) {
		if(rrt.getTemplateName() == null) {
			throw new AyaraCustomException("Revenue Template Name is null");
		}
		if(rrt.getAccTriggerRevenue() == null) {
			throw new AyaraCustomException("Accounting Trigger Revenue is null");
		}
		if(rrt.getAccRuleRevenue() == null) {
			throw new AyaraCustomException("Accounting Rule Revenue is null");
		}
		
		/*
		 * #Bug AYARA-1806 Added condition for the RATABLE Revenue Templates 
		 * By chandra on 06-JAN-2022
		 */
		
		if(rrt.getAccRuleRevenue().equals("RATABLE") && rrt.getAmortRuleRevenue() == null) {
			throw new AyaraCustomException("Amortization Rule Revenue is null for the given RATABLE Revenue Template");
		}
		
		if(rrt.getAccRuleRevenue().equals("RATABLE") && rrt.getAmortMethodRevenue() == null) {
			throw new AyaraCustomException("Amortization Method Revenue is null for the given RATABLE Revenue Template");
		}
		
		if(rrt.getActiveFlag() == null) {
			throw new AyaraCustomException("Active Flag is null");
		}
		
		if(rrt.getAdditionalAttribute1()!=null){
			RmanRevenueTemplates rtemplate = rmanRevenueTemplatesRepository.findByAdditionalAttribute1IgnoreCase(rrt.getAdditionalAttribute1());
			
			if(rtemplate!=null){
				if(rtemplate.getCreatedBy()!=null) {
					rrt.setCreatedBy(rtemplate.getCreatedBy());
				}
				
				if(rtemplate.getCreatedDate()!=null) {
					rrt.setCreatedDate(rtemplate.getCreatedDate());
				}
				
				if(rtemplate.getRevenueTemplateId()!=null) {
					rrt.setRevenueTemplateId(rtemplate.getRevenueTemplateId());
				}
				return rmanRevenueTemplatesRepository.save(rrt);
			}else{
				RmanRevenueTemplates rt = rmanRevenueTemplatesRepository.findByTemplateNameIgnoreCase(rrt.getTemplateName());
				if(rt!=null) {
					throw new AyaraCustomException("Revenue Template name aready exists in Ayara");
				}else {
					return rmanRevenueTemplatesRepository.save(rrt);
				}
			}
		}else{
			throw new AyaraCustomException("No Revenue Template Reference Id Send to Ayara");
			
		}		
	}

	@Override
	public RmanProducts upsertProduct(RmanProducts rp) {
		
		if((rp.getProductName()==null)) {
			throw new AyaraCustomException("Product Name is null");
		}
		
		if(rp.getAdditionalAttribute1()!=null){
			
			RmanProducts rprod = rmanProductsRepoitory.findByAdditionalAttribute1IgnoreCase(rp.getAdditionalAttribute1());
			
			if(rprod!=null) {
				if(rprod.getCreatedBy()!=null) {
					rp.setCreatedBy(rprod.getCreatedBy());
				}
				if(rprod.getCreationDate()!=null) {
					rp.setCreationDate(rprod.getCreationDate());
				}
				if(rprod.getProductId()!=null) {
					rp.setProductId(rprod.getProductId());
				}
				
				return 	 rmanProductsRepoitory.save(rp);
			}else {
				RmanProducts checkProd = null;
				if(rp.getProductName()!=null && rp.getProductOrgId()!=null) {
					checkProd = rmanProductsRepoitory.findByProductNameIgnoreCase(rp.getProductName());	
				}
				if(rp.getProductName()!=null && (rp.getProductOrgId()==null)) {
					checkProd = rmanProductsRepoitory.findByProductNameIgnoreCaseAndProductOrgId(rp.getProductName(),rp.getProductOrgId());	
				}
				
				if(checkProd!=null) {
					throw new AyaraCustomException("Product exists in Ayara");
				}else {
					return rmanProductsRepoitory.save(rp);
				}
			}
			
				
		}else{
			throw new AyaraCustomException("No Product Reference Id Send to Ayara");
			}
		
	}

	@Override
	public UpstreamResponse upsertProducts(List<RmanProducts> rpList) {
		
		List<RmanProducts> rps = new ArrayList<>();
		List<ErrorMessage> failedProducts = new ArrayList<>();
		
		rpList.stream().forEach(rp->{
			boolean isErrorOccured = false;
			String errorMessage = "";
			
			if(rp.getProductName() == null) {
				errorMessage = errorMessage + "Product Name is null";
			}
			
			
			if((rp.getSource() == null)) {
				errorMessage = errorMessage + " | Source is null";
			}else {
				if(rp.getSource().equalsIgnoreCase("SFDC") || rp.getSource().equalsIgnoreCase("salesforce")) {
					
					if (rp.getAdditionalAttribute5()!=null) 
					{
						RmanRevenueTemplates rrt = rmanRevenueTemplatesRepository.findByTemplateNameIgnoreCase(rp.getAdditionalAttribute5());
						if(rrt !=null){
							rp.setRevenueTemplateId(rrt.getRevenueTemplateId());
						} else{
							errorMessage = errorMessage + " | Revenue Recoginition Rule not defined in Ayara";
						}
						
					}
					
					if((rp.getRevenueTemplateId() == null)) {
						errorMessage = errorMessage + " | Revenue Template not defined in Ayara";
					}
					if((rp.getProductOrgId() == null)) {
						errorMessage = errorMessage + " | Legal Entity id not added to this Product";
					}
					if((rp.getProductOrgName() == null)) {
						errorMessage = errorMessage + " | Legal Entity Name is null";
					}
				}
			}
			
			if(rp.getAdditionalAttribute1()!=null) {
				RmanProducts rprod = rmanProductsRepoitory.findByAdditionalAttribute1IgnoreCase(rp.getAdditionalAttribute1());
				if((rprod==null)){
					RmanProducts checkProd = null;
					if(rp.getProductName()!=null && rp.getProductOrgId()!=null) {
						checkProd = rmanProductsRepoitory.findByProductNameIgnoreCase(rp.getProductName());	
					}
					if(rp.getProductName()!=null && (rp.getProductOrgId()==null)) {
						checkProd = rmanProductsRepoitory.findByProductNameIgnoreCaseAndProductOrgId(rp.getProductName(),rp.getProductOrgId());	
					}
					
					if(checkProd!=null) {
						errorMessage = errorMessage + " | Product exists in Ayara";
					}
				}else {
					rp.setProductId(rprod.getProductId());
				}
				
			}else {
				errorMessage = errorMessage + " | no product reference Id send to Ayara";
			}
			
			if(!errorMessage.isEmpty()) {
				failedProducts.add(new ErrorMessage(rp.getAdditionalAttribute1(), errorMessage));
				isErrorOccured = true;
			}
			if(!isErrorOccured) {
				rps.add(rp);
			}
		});
		UpstreamResponse upResponse = new UpstreamResponse();
		upResponse.setExceptions(failedProducts);
		List<RmanProducts> succesProdList = rmanProductsRepoitory.saveAll(rps);
		List<BulkResponse> bulkResponseList = new ArrayList<>();
		succesProdList.stream().forEach(rp-> bulkResponseList.add(new BulkResponse(rp.getAdditionalAttribute1(),rp.getProductId())));
		upResponse.setSuccessList(bulkResponseList);
		return upResponse;
	}
	
	@Override
	public RmanPobMapping upsertPOBMapping(RmanPobMapping rpm) {
		if((rpm.getSkuType()==null)) {
			throw new AyaraCustomException("POB Type is null");
		}
		
		if((rpm.getStandaloneSubSku()==null) && !(rpm.getSkuType().equalsIgnoreCase("Order Line POB Group"))) {
			throw new AyaraCustomException("Child SKU is null");
		}
		
		if((rpm.getAttribute1()==null)) {
			throw new AyaraCustomException("Legal Entity is null");
		}else {
			Optional<RmanLegalEntities> rle = rmanLegalEntitiesRepository.findById(new BigDecimal(rpm.getAttribute1()));
			if(!(rle.isPresent())) {
				throw new AyaraCustomException("Legal Entity is not configured in Ayara");
			}
		}
		
		
		if(rpm.getAdditionalAttribute1()!=null) {
			
			RmanPobMapping rpobmapp = rmanPobMappingRepository.findByAdditionalAttribute1IgnoreCase(rpm.getAdditionalAttribute1());
			if(rpobmapp!=null) {
				if(rpobmapp.getCreationDate()!=null) {
					rpm.setCreationDate(rpobmapp.getCreationDate());
				}
				if(rpobmapp.getCreatedBy()!=null) {
					rpm.setCreatedBy(rpobmapp.getCreatedBy());
				}
				if(rpobmapp.getPobMapId()!=null) {
					rpm.setPobMapId(rpobmapp.getPobMapId());
				}
				return rmanPobMappingRepository.save(rpm);
			}else {
				return rmanPobMappingRepository.save(rpm);
			}
			
		}else {
			throw new AyaraCustomException("No POB Reference ID send to Ayara");
		}
		
	}
	
	@Override
	public RmanFiscalPeriods upsertPeriod(RmanFiscalPeriods rfp) {
		if(rfp.getRmanPeriodId()!=null){
			Optional<RmanFiscalPeriods> rfperiod = rmanFiscalPeriodsRepository.findById(rfp.getRmanPeriodId());
			if(rfperiod.isPresent()){
				rfp.setAdjustmentPeriodFlag("N");
				return rmanFiscalPeriodsRepository.save(rfp);
			}else{
				throw new AyaraCustomException("Fiscal Period creation failed");
			}
		}else{
			RmanFiscalPeriods rfperiod = rmanFiscalPeriodsRepository.findByPeriodNameIgnoreCase(rfp.getPeriodName());
			if(rfperiod!=null){
				throw new AyaraCustomException("Fiscal Period Already Exists in the Ayara");
			}else{
				rfp.setAdjustmentPeriodFlag("N");
				return rmanFiscalPeriodsRepository.save(rfp);
			}
		}
	}

	@Override
	public List<RmanCustomers> upsertCustomers(List<RmanCustomers> rcList) {
		return rmanCustomersRepository.saveAll(rcList);
	}

	@Override
	public RmanFmvRulesDef upsertSSP(RmanFmvRulesDef ssp) {
		if((ssp.getFmvRuleName() == null)) {
			throw new AyaraCustomException("SSP Rule Name is null");
		}
		if((ssp.getFmvCategory() == null)) {
			throw new AyaraCustomException("SSP Category is null");
		}
		if((ssp.getFmvType() == null)) {
			throw new AyaraCustomException("SSP Type is null");
		}
		if((ssp.getMin() == null)) {
			throw new AyaraCustomException("SSP Min value is null");
		}
		if((ssp.getMedian() == null)) {
			throw new AyaraCustomException("SSP Median value is null");
		}
		if((ssp.getMax() == null)) {
			throw new AyaraCustomException("SSP Max value is null");
		}
		if((ssp.getFmvRuleStatus() == null)) {
			throw new AyaraCustomException("SSP Rule Status is null");
		}
		if((ssp.getQuarterStartDate() == null)) {
			throw new AyaraCustomException("SSP Rule Start Date is null");
		}
		if((ssp.getQuarterEndDate() == null)) {
			throw new AyaraCustomException("SSP Rule End Date is null");
		}
		ssp.setDealFlag("Y");
		ssp.setEnabledFlag("Y");
		ssp.setFmvPrice(ssp.getMedian());
		
		if(ssp.getAdditionalAttribute2() != null) {
			ssp.setQuarterStartDate(RevmantraUtils.getDateValue(ssp.getAdditionalAttribute2()));
		}
		if(ssp.getAdditionalAttribute3() != null) {
			ssp.setQuarterEndDate(RevmantraUtils.getDateValue(ssp.getAdditionalAttribute3()));
		}
		ssp.setAdditionalAttribute2(null);
		ssp.setAdditionalAttribute3(null);
		
		if(ssp.getAdditionalAttribute1()!=null) {
			
			RmanFmvRulesDef rssp = rmanFmvRulesDefRepository.findByAdditionalAttribute1IgnoreCase(ssp.getAdditionalAttribute1());
			if(rssp!=null) {
				if(rssp.getCreationDate()!=null) {
					ssp.setCreationDate(rssp.getCreationDate());
				}
				if(rssp.getCreationDate()!=null) {
					ssp.setCreationDate(rssp.getCreationDate());
				}
				if(rssp.getFmvRuleDefId()!=null) {
					ssp.setFmvRuleDefId(rssp.getFmvRuleDefId());
				}
				// Setting the default Active SSP Book for the SSP 
				if(rssp.getBookId() !=null) {
					ssp.setBookId(rssp.getBookId());
				}else {
					List<SSPBooks> sspBooks = sspBooksRepository.findByStatusIgnoreCase("ACTIVE");
					if (sspBooks!=null) {
						ssp.setBookId(sspBooks.get(0).getBookId());
					}
				}
				return rmanFmvRulesDefRepository.save(ssp);
			}else {
				// Setting the default Active SSP Book for the SSP
				List<SSPBooks> sspBooks = sspBooksRepository.findByStatusIgnoreCase("ACTIVE");
				if (sspBooks!=null) {
					ssp.setBookId(sspBooks.get(0).getBookId());
				}
				return rmanFmvRulesDefRepository.save(ssp);
			}
			
			
		}else {
			throw new AyaraCustomException("No SSP Reference ID send to Ayara");
		}
	
	}

	@Override
	public RmanFmvRulesDefParaValue upsertSSPParam(RmanFmvRulesDefParaValue sspParam) {
		RmanEntityParametersV rep = rmanEntityParametersVRepository.findByEntityCategoryAndParameterName("DEAL_FMV",sspParam.getAdditionalAttribute2());
		if((sspParam.getParameterValue() == null)) {
			throw new AyaraCustomException("Parameter value is null");
		}
		
		if((sspParam.getQualifier() == null)) {
			throw new AyaraCustomException("Qualifier value is null");
		}
		
		if(rep!=null){
			sspParam.setParameterId(rep.getEntityParameterId());
		}else{	
			throw new AyaraCustomException("Parmater is not defined in Ayara System");
		}
		Optional<RmanFmvRulesDef> ssp = rmanFmvRulesDefRepository.findById(sspParam.getFmvRuleDefId());
		if(ssp.isPresent()){
			sspParam.setDealFlag("Y");
			if(sspParam.getAdditionalAttribute1()!=null) {
				RmanFmvRulesDefParaValue esspParam = rmanFmvRulesDefParaValueRepository.findByAdditionalAttribute1IgnoreCase(sspParam.getAdditionalAttribute1());
				if(esspParam!=null) {
					if(esspParam.getCreatedBy()!=null) {
						sspParam.setCreatedBy(esspParam.getCreatedBy());
					}
					if(esspParam.getCreationDate()!=null) {
						sspParam.setCreationDate(esspParam.getCreationDate());
					}
					if(esspParam.getParameterValueId()!=null) {
						sspParam.setParameterValueId(esspParam.getParameterValueId());
					}
					return rmanFmvRulesDefParaValueRepository.save(sspParam);
				}else {
					return rmanFmvRulesDefParaValueRepository.save(sspParam);
				}
			}else {
				throw new AyaraCustomException("No SSP Rule Parameter Reference ID send to Ayara");
			}
			
		}else{
			throw new AyaraCustomException("SSP Rule is not created for this parameter");
		}
	}
	
	@Override
	public ResponseData upsertOrdersInterfaceLegacy(List<RmanOrdersInterface> rmanOrders) {
		String orderNumber = String.valueOf(rmanOrders.get(0).getOrderNumber());
		String batchId = String.valueOf(System.currentTimeMillis());
		ResponseData response = new ResponseData();
		List<SfqiExceptions> exceptions = new ArrayList<>();
		try {
			setUpsertOrdersShipmentsMappingVals(rmanOrders, batchId, "BOOK");
			saveBookingsDataAndProcess(rmanOrders, BaseListener.getCurrentUserId(), new BigDecimal(batchId));
			List<Object[]> failedOrderObj = rmanOrdersInterfaceRepository.getSfFailedOrdersList(batchId);
			
			failedOrderObj.stream().forEach(orderObj -> {
				SfqiExceptions exception = new SfqiExceptions(orderObj[0].toString(), orderObj[1].toString());
				exceptions.add(exception);
			});
			
			
			
			response.setBatchId(new BigDecimal(batchId));
			
			
			
			if(failedOrderObj.isEmpty()) {
				
				String ord;
				try {
					ord = String.valueOf(Integer.valueOf(orderNumber));
				}catch(Exception e) {
					ord = orderNumber;
				}
				
				if (rmanDealHeadersRepository.findByDealNumber(ord)!=null){
					List<RmanSalesforceQuoteLine> allocations = rmanSalesforceQuoteLineRepository.findByQuoteId(rmanDealHeadersRepository.findByDealNumber(ord).getDealArrangementId());
					response.setStatus(CONSTANTS.SUCCESS);
					response.setMessage("Orders Processed Successfully");
					response.setRevenueAllocations(allocations);
				}
				
				
			}else {
				response.setStatus(CONSTANTS.failed_Msg);
				response.setMessage("Some Orders are failed to process");
				response.setExceptions(exceptions);
			}
		}catch(Exception e) {
			response.setStatus(CONSTANTS.failed_Msg);
			response.setBatchId(new BigDecimal(batchId));
			response.setMessage(e.getMessage());
		}
		return response;
	}
	
	/**
	 * #ISV-298 for Order sync in Quote to Billing Process
	 * Added the setUpsertOrdersShipmentsMappingVals Method call 
	 * for Quote to Order Sync to Billing process
	 * And in this process it won't Return the allocation 
	 */
	@Override
	public ResponseData upsertOrdersInterface(List<RmanOrdersInterface> rmanOrders) {
		String batchId = String.valueOf(System.currentTimeMillis());
		ResponseData response = new ResponseData();
		List<SfqiExceptions> exceptions = new ArrayList<>();
		try {
//			setUpsertOrdersMappingVals(rmanOrders, batchId, "BOOK"); // #ISV-298 commented by chandra Kota on 2021-JUN-07
			setUpsertOrdersShipmentsMappingVals(rmanOrders, batchId, "BOOK"); // #ISV-298 Addedd by chandra Kota on 2021-JUN-07
			saveBookingsDataAndProcess(rmanOrders, BaseListener.getCurrentUserId(), new BigDecimal(batchId));
			List<Object[]> failedOrderObj = rmanOrdersInterfaceRepository.getSfFailedOrdersList(batchId);
			
			failedOrderObj.stream().forEach(orderObj -> {
				SfqiExceptions exception = new SfqiExceptions(orderObj[0].toString(), orderObj[1].toString());
				exceptions.add(exception);
			});
			
			response.setBatchId(new BigDecimal(batchId));
			if(failedOrderObj.isEmpty()) {
				response.setStatus(CONSTANTS.SUCCESS);
				response.setMessage("Orders Processed Successfully");
				
			}else {
				response.setStatus(CONSTANTS.failed_Msg);
				response.setMessage("Some Orders are failed to process");
				response.setExceptions(exceptions);
			}
		}catch(Exception e) {
			response.setStatus(CONSTANTS.failed_Msg);
			response.setBatchId(new BigDecimal(batchId));
			response.setMessage(e.getMessage());
		}
		return response;
	}
	
	@Override
	public ResponseData upsertShipments(List<RmanOrdersInterface> rmanOrders) {
		String batchId = String.valueOf(System.currentTimeMillis());
		ResponseData response = new ResponseData();
		List<SfqiExceptions> exceptions = new ArrayList<>();
		try {
			setUpsertOrdersShipmentsMappingVals(rmanOrders, batchId, "SHIP");
			saveShipmentsDataAndProcess(rmanOrders, BaseListener.getCurrentUserId(), batchId);
			List<Object[]> failedShipObj = rmanOrdersInterfaceRepository.getFailedOrdersList(batchId);
			
			failedShipObj.stream().forEach(shipObj -> {
				SfqiExceptions exception = new SfqiExceptions(shipObj[0].toString(), shipObj[1].toString());
				exceptions.add(exception);
			});
			
			response.setBatchId(new BigDecimal(batchId));
			if(failedShipObj.isEmpty()) {
				response.setStatus(CONSTANTS.SUCCESS);
				response.setMessage("Shipments Processed Successfully");
			}else {
				response.setStatus(CONSTANTS.failed_Msg);
				response.setMessage("Some Shipments are failed to process");
				response.setExceptions(exceptions);
			}
		}catch(Exception e) {
			response.setStatus(CONSTANTS.failed_Msg);
			response.setMessage(e.getMessage());
		}
		return response;
	}
	
	private List<RmanOrdersInterface> setUpsertOrdersShipmentsMappingVals(List<RmanOrdersInterface> orders, String batchId, String type){
		BigDecimal userId = BaseListener.getCurrentUserId()!=null? BaseListener.getCurrentUserId() : new BigDecimal(-1);
		orders.forEach(order -> {
			if(order.getLineAttribute2() != null) {
				order.setBookedDate(RevmantraUtils.getDateValue(order.getLineAttribute2()));
				order.setOrderedDate(RevmantraUtils.getDateValue(order.getLineAttribute2()));
				order.setFxDate(RevmantraUtils.getDateValue(order.getLineAttribute2()));
			}
			if(order.getLineAttribute4() != null) {
				order.setServiceStartDate(RevmantraUtils.getDateValue(order.getLineAttribute4()));
			}
			if(order.getLineAttribute5() != null) {
				order.setServiceEndDate(RevmantraUtils.getDateValue(order.getLineAttribute5()));
			}
			if(order.getLineAttribute6() != null) {
				order.setActualFulfilledDate(RevmantraUtils.getDateValue(order.getLineAttribute6()));
			}
			order.setLineAttribute2(null);
			order.setLineAttribute4(null);
			order.setLineAttribute5(null);
			order.setLineAttribute6(null);
			order.setGroupId(batchId); 
			order.setFileType(type);
			order.setInterfaceStatus("R");
			order.setCreatedBy(userId);
			order.setLastUpdatedBy(userId);
		});
		return orders;
	}
	
	@SuppressWarnings("unused")
	private List<RmanOrdersInterface> setUpsertOrdersMappingVals(List<RmanOrdersInterface> orders, String batchId, String type){
		orders.forEach(order -> {
			if(order.getLineAttribute1() != null) {
				order.setBookedDate(RevmantraUtils.getDateValue(order.getLineAttribute1()));
				order.setScheduleShipDate(RevmantraUtils.getDateValue(order.getLineAttribute1()));
			}
			if(order.getLineAttribute2() != null) {
				order.setOrderedDate(RevmantraUtils.getDateValue(order.getLineAttribute2()));
			}
			if(order.getLineAttribute3() != null) {
				order.setFxDate(RevmantraUtils.getDateValue(order.getLineAttribute3()));
			}
			if(order.getLineAttribute4() != null) {
				order.setServiceStartDate(RevmantraUtils.getDateValue(order.getLineAttribute4()));
			}
			if(order.getLineAttribute5() != null) {
				order.setServiceEndDate(RevmantraUtils.getDateValue(order.getLineAttribute5()));
			}
			if(order.getLineAttribute7() != null) {
				order.setCancelledDate(RevmantraUtils.getDateValue(order.getLineAttribute7()));
			}
			order.setGroupId(batchId); 
			order.setFileType(type);
			order.setInterfaceStatus("R");
		});
		return orders;
	}
	
	@Override
	public ResponseData upsertUsageSummary(List<RmanUsageSummaryInterface> rusList) {
		String batchId = String.valueOf(System.currentTimeMillis());
		ResponseData response = new ResponseData();
		List<SfqiExceptions> exceptions = new ArrayList<>();
		try {
			rusList.forEach(summary -> {
				if(summary.getAttribute1() != null) {
					summary.setSummaryStartDate(RevmantraUtils.getDateValue(summary.getAttribute1()));
				}
				if(summary.getAttribute2() != null) {
					summary.setSummaryEndDate(RevmantraUtils.getDateValue(summary.getAttribute2()));
				}
				summary.setAttribute1(null);
				summary.setAttribute2(null);
				summary.setInterfaceStatus("R");
				summary.setInterfaceProcessId(new BigDecimal(batchId));
			});
			saveUsageSummaryDataAndProcess(rusList, BaseListener.getCurrentUserId(), new BigDecimal(batchId));
			List<Object[]> failesSummariesObj =  rmanUsageSummaryInterfaceRepo.getFailedUsageSummaries(new BigDecimal(batchId));
			
			failesSummariesObj.stream().forEach(summaryObj -> {
				SfqiExceptions exception = new SfqiExceptions(summaryObj[0].toString(), summaryObj[1].toString());
				exceptions.add(exception);
			});
			
			response.setBatchId(new BigDecimal(batchId));
			if(failesSummariesObj.isEmpty()) {
				response.setStatus(CONSTANTS.SUCCESS);
				response.setMessage("Usage Summary Processed Successfully");
			}else {
				response.setStatus(CONSTANTS.failed_Msg);
				response.setMessage("Some Usage Summaries are failed to process");
				response.setExceptions(exceptions);
			}
		}catch(Exception e) {
			response.setStatus(CONSTANTS.failed_Msg);
			response.setMessage(e.getMessage());
		}
		return response;
		
	}

	@Transactional
	private void saveUsageSummaryDataAndProcess(List<RmanUsageSummaryInterface> usageSumList, BigDecimal userId,
			BigDecimal batchId) {
		int size = usageSumList.size();
		int counter = 0;
		List<RmanUsageSummaryInterface> temp = new ArrayList<>();
		for (RmanUsageSummaryInterface emp : usageSumList) {
			temp.add(emp);
			if ((counter + 1) % 500 == 0 || (counter + 1) == size) {
				rmanUsageSummaryInterfaceRepo.saveAll(temp);
				temp.clear();
			}

			counter++;
		}
		try {
			StoredProcedureQuery storedProcedure = manager
					.createStoredProcedureQuery("RMAN_USAGE_SUMMARIES_PROCESS_PKG.PROCESS_USAGE_SUMMARIES")
					.registerStoredProcedureParameter(CONSTANTS.P_BATCH_ID, BigDecimal.class, ParameterMode.IN);
			storedProcedure.setParameter(CONSTANTS.P_BATCH_ID, batchId);
			storedProcedure.execute();
		} catch (Exception e) {
			throw new AyaraCustomException("Usage Summary Process job failed.Contact System Administrator.");
		}
	}
	
	@Override
	public ResponseData upsertInvoices(List<RmanInvoiceLinesInterface> invList) {
		String batchId = String.valueOf(System.currentTimeMillis());
		ResponseData response = new ResponseData();
		List<SfqiExceptions> exceptions = new ArrayList<>();
		try {
			invList.forEach(invoice -> {
				if(invoice.getAdditionalAttribute1() != null) {
					invoice.setInvoicedDate(RevmantraUtils.getDateValue(invoice.getAdditionalAttribute1()));
				}
				if(invoice.getAdditionalAttribute2() != null) {
					invoice.setFxDate(RevmantraUtils.getDateValue(invoice.getAdditionalAttribute2()));
				}
				invoice.setAdditionalAttribute1(null);
				invoice.setAdditionalAttribute2(null);
				invoice.setProcessId(batchId);
				invoice.setInvoiceType("INV");
				invoice.setInterfaceStatus("R");
			});
			
			saveBillingsDataAndProcess(invList, batchId);
			List<Object[]> failedInvObj = rmanInvoiceLinesInterfaceRepository.getInvoiceFailedList(batchId);
			
			failedInvObj.stream().forEach(invObj -> {
				SfqiExceptions exception = new SfqiExceptions(invObj[0].toString(), invObj[1].toString());
				exceptions.add(exception);
			});
			
			response.setBatchId(new BigDecimal(batchId));
			if(failedInvObj.isEmpty()) {
				response.setStatus(CONSTANTS.SUCCESS);
				response.setMessage("Invoices Processed Successfully");
			}else {
				response.setStatus(CONSTANTS.failed_Msg);
				response.setMessage("Some Invoices are failed to process");
				response.setExceptions(exceptions);
			}
		}catch(Exception e) {
			response.setStatus(CONSTANTS.failed_Msg);
			response.setMessage(e.getMessage());
		}
		return response;
	}

	@Override
	public RmanRulesHeader upsertRuleHeader(RmanRulesHeader rulesHeader) {
				if((rulesHeader.getRuleName()==null)) {
					throw new AyaraCustomException("Rule Name is null");
				}
				if((rulesHeader.getRuleCategory()==null)) {
					throw new AyaraCustomException("Rule Category is null");
				}
				
				if(rulesHeader.getAttribute27()!=null) {
					RmanRulesHeader rh = rmanRulesHeaderRepo.findByAttribute27IgnoreCase(rulesHeader.getAttribute27());
					if(rh!=null) {
						if(rh.getCreatedBy()!=null) {
							rulesHeader.setCreatedBy(rh.getCreatedBy());
						}
						if(rh.getCreationDate()!=null) {
							rulesHeader.setCreationDate(rh.getCreationDate());
						}
						if(rh.getRuleHeaderId()!=null) {
							rulesHeader.setRuleHeaderId(rh.getRuleHeaderId());
						}
						
						if(!(rh.getRuleName().equalsIgnoreCase(rulesHeader.getRuleName()))) {
							RmanRulesHeader rhs = rmanRulesHeaderRepo.findByRuleNameIgnoreCase(rulesHeader.getRuleName());
							if(rhs!=null) {
								throw new AyaraCustomException("Rule Name Already Exists");
							}
						}
						return rmanRulesHeaderRepo.save(rulesHeader);
					}else {
						RmanRulesHeader rhruleCheck = rmanRulesHeaderRepo.findByRuleNameIgnoreCase(rulesHeader.getRuleName());
						if(rhruleCheck!=null) {
							throw new AyaraCustomException("Rule Name Already Exists");
						}else {
							return rmanRulesHeaderRepo.save(rulesHeader);
						}
					}
				}else{
					throw new AyaraCustomException("No Revenue Contract Rule Reference ID send to Ayara");
				}
	}

	@Override
	public RmanRuleParameterValue upsertRuleParameterValue(RmanRuleParameterValue rulesParameterValue) {
		RmanRulesHeader rrh = rmanRulesHeaderRepo.findById(rulesParameterValue.getRuleHeaderId()).get();
		if((rrh.getRuleHeaderId()==null)){
			throw new AyaraCustomException("Grouping Rule not must be create.");
		}
		RmanEntityParametersV rep = rmanEntityParametersVRepository.findByEntityCategoryAndParameterName(rrh.getRuleCategory(),rulesParameterValue.getAttribute27());
		if(rep!=null){
			rulesParameterValue.setParameterId(rep.getEntityParameterId());
		}else{
			throw new AyaraCustomException("No Parameter defined for the Revenue Contract Grouping rule in Ayara");
		}
		
		if(rulesParameterValue.getAttribute28()!=null) {
			RmanRuleParameterValue rrpv = rmanRuleParameterValueRepo.findByAttribute28IgnoreCase(rulesParameterValue.getAttribute28());
			if(rrpv!=null) {
				if(rrpv.getCreatedBy()!=null) {
					rulesParameterValue.setCreatedBy(rrpv.getCreatedBy());
				}
				if(rrpv.getCreationDate()!=null) {
					rulesParameterValue.setCreationDate(rrpv.getCreationDate());
				}
				if(rrpv.getParameterValueId()!=null) {
					rulesParameterValue.setParameterValueId(rrpv.getParameterValueId());
				}
				return rmanRuleParameterValueRepo.save(rulesParameterValue);
			}else {
				return rmanRuleParameterValueRepo.save(rulesParameterValue);
			}
		}else {
			throw new AyaraCustomException("No Rule Parameter Reference Id Send to Ayara");
		}
	}

	private List<RmanOrdersInterface> parseBookShipCSV(String batchId,BufferedReader bufferedReader, String fileName) {
		BigDecimal uploadUserId = BaseListener.getCurrentUserId() != null ? BaseListener.getCurrentUserId() : new BigDecimal(-1);
		Timestamp currentDate = new Timestamp(System.currentTimeMillis());
		
		CsvToBean<RmanOrdersInterface> beans = new CsvToBeanBuilder<RmanOrdersInterface>(bufferedReader)
			        .withType(RmanOrdersInterface.class)
			        .withIgnoreQuotations(false)
			        .withThrowExceptions(false)
			        .withIgnoreLeadingWhiteSpace(true)
			        .build();
		
	    List<RmanOrdersInterface> beanList = beans.parse();
	    
	    beanList.stream().forEach(user -> {
	    	user.setGroupId(batchId);
	    	user.setCreatedBy(uploadUserId);
	    	user.setCreationDate(currentDate);
	    	user.setLastUpdatedBy(uploadUserId);
	    	user.setLastUpdateDate(currentDate);
	    	user.setFileName(fileName);
	    	user.setFileType(fileName.subSequence(0, 4).toString());
	    	user.setInterfaceStatus("R");
	    });
	    
		return beanList;
	}
	
	@Override
	public RmanFiscalPeriods upsertfiscalPeriods(RmanFiscalPeriods rfp) {
		
		
		if((rfp.getStartDate()==null)){
			throw new AyaraCustomException("start Date cannot be null");
		}
		
		if((rfp.getEndDate()==null)){
			throw new AyaraCustomException("End Date cannot be null");
		}
		if((rfp.getYearStartDate()==null)){
			throw new AyaraCustomException("Year Start Date cannot be null");
		}
		if((rfp.getLedgerName()==null)) {
			throw new AyaraCustomException("Ledger Name/Legal Entity cannot be null");
		}
		
		if(rfp.getAdditionalAttribute2()!=null) {
			rfp.setStartDate(RevmantraUtils.getDateValue(rfp.getAdditionalAttribute2()));
		}
		if(rfp.getAdditionalAttribute3()!=null) {
			rfp.setEndDate(RevmantraUtils.getDateValue(rfp.getAdditionalAttribute3()));
		}
		if(rfp.getAdditionalAttribute4()!=null) {
			rfp.setYearStartDate(RevmantraUtils.getDateValue(rfp.getAdditionalAttribute4()));
		}
		rfp.setAdditionalAttribute2(null);
		rfp.setAdditionalAttribute3(null);
		rfp.setAdditionalAttribute4(null);
		
		LocalDate yearStartDate = rfp.getYearStartDate().toLocalDateTime().toLocalDate();
		LocalDate periodStartDate = rfp.getStartDate().toLocalDateTime().toLocalDate();
		rfp.setPeriodNum(new BigDecimal(Period.between(yearStartDate, periodStartDate).getMonths()+1));
		int quarterNum = getQuarterNum(yearStartDate,periodStartDate);
		rfp.setQuarterNum(new BigDecimal(quarterNum));
		rfp.setQuarterName("Q"+quarterNum+"-"+periodStartDate.getYear());
		String periodName = periodStartDate.getMonth().name().substring(0,3).toLowerCase();
		rfp.setAdjustmentPeriodFlag("N");
		rfp.setPeriodYear(new BigDecimal(periodStartDate.getYear()));
		rfp.setPeriodName(periodName.substring(0,1).toUpperCase()+periodName.substring(1,periodName.length())+"-"+periodStartDate.getYear()%100);
		LocalDate qstartDate = yearStartDate.plusMonths((getQuarterNum(yearStartDate,periodStartDate)-1)*3L);
		rfp.setQuarterStartDate(Timestamp.valueOf(qstartDate.atStartOfDay()));
		rfp.setEnteredPeriodName(periodName.substring(0,1).toUpperCase()+periodName.substring(1,periodName.length()));
		
		List<String> periodStatusList = new ArrayList<>();
		periodStatusList.add("OPEN");
		periodStatusList.add(CONSTANTS.CLOSED);
		periodStatusList.add(CONSTANTS.FUTURE);
		if((rfp.getPeriodStatus()==null)) {
			throw new AyaraCustomException("Period status can not be empty");
		}
		if(!periodStatusList.contains(rfp.getPeriodStatus().toUpperCase())) {
			throw new AyaraCustomException("Period status should be like either 'OPEN' or 'CLOSED' or 'FUTURE'");
		}
		if(rfp.getPeriodStatus().equalsIgnoreCase("OPEN")) {
			rfp.setOpenFlag("Y");
		}else if(rfp.getPeriodStatus().equalsIgnoreCase(CONSTANTS.CLOSED)) {
			rfp.setOpenFlag("N");
		}else if(rfp.getPeriodStatus().equalsIgnoreCase(CONSTANTS.FUTURE)){
			rfp.setOpenFlag("F");
		}
		if(rfp.getAdditionalAttribute1()!=null) {
			RmanFiscalPeriods rfps =  rmanFiscalPeriodsRepository.findByAdditionalAttribute1IgnoreCase(rfp.getAdditionalAttribute1());
			if(rfps!=null) {
				if(rfps.getCreatedBy()!=null) {
					rfp.setCreatedBy(rfps.getCreatedBy());
				}
				if(rfps.getCreationDate()!=null) {
					rfp.setCreationDate(rfps.getCreationDate());
				}
				if(rfps.getRmanPeriodId()!=null) {
					rfp.setRmanPeriodId(rfps.getRmanPeriodId());
				}
				return rmanFiscalPeriodsRepository.save(rfp);
			}else{
				RmanFiscalPeriods rfperiod=rmanFiscalPeriodsRepository.findByPeriodNameIgnoreCase(rfp.getPeriodName());
				if(rfperiod!=null) {
					throw new AyaraCustomException("Fiscal period"+rfp.getPeriodName()+ " exists in the Ayara");
				}else {
					return rmanFiscalPeriodsRepository.save(rfp);
				}
				
			}
		}else {
			throw new AyaraCustomException("No Source Fiscal Period Reference Id Send to Ayara");
		}
		
	}

	private  int getQuarterNum(LocalDate yearStartDate,LocalDate periodStartDate ) {
		int p = Period.between(yearStartDate, periodStartDate).getMonths()+1;
		if (p>=1 && p<=3) return 1;
		if (p>=4 && p<=6) return 2;
		if (p>=7 && p<=9) return 3;
		if (p>=10 && p<=12) return 4;
		return 0;
	}

	@Override
	public UpstreamResponse upsertBulkFiscalPeriods(List<RmanFiscalPeriods> rfpsList) {
		List<RmanFiscalPeriods> rfps = new ArrayList<>();
		List<ErrorMessage> failedPeriods = new ArrayList<>();
		
		int noOfRecords = rfpsList.size();
		
		rfpsList.stream().forEach(rfp->{
			boolean isErrorOccured = false;
			String errorMessage = "";
			
			if((rfp.getStartDate()==null)){
				
				errorMessage = errorMessage + "start Date cannot be null";
			}
			
			if((rfp.getEndDate()==null)){
				errorMessage = errorMessage + "| End Date cannot be null";
			}
			if((rfp.getYearStartDate()==null)){
				errorMessage = errorMessage + "| Year Start Date cannot be null";
			}
			if((rfp.getLedgerName()==null)){
				errorMessage = errorMessage + "| Ledger Name/Legal Entity cannot be null";
			}
			
			if(rfp.getAdditionalAttribute2()!=null) {
				rfp.setStartDate(RevmantraUtils.getDateValue(rfp.getAdditionalAttribute2()));
			}
			if(rfp.getAdditionalAttribute3()!=null) {
				rfp.setEndDate(RevmantraUtils.getDateValue(rfp.getAdditionalAttribute3()));
			}
			if(rfp.getAdditionalAttribute4()!=null) {
				rfp.setYearStartDate(RevmantraUtils.getDateValue(rfp.getAdditionalAttribute4()));
			}
			rfp.setAdditionalAttribute2(null);
			rfp.setAdditionalAttribute3(null);
			rfp.setAdditionalAttribute4(null);
			LocalDate yearStartDate = rfp.getYearStartDate().toLocalDateTime().toLocalDate();
			LocalDate periodStartDate = rfp.getStartDate().toLocalDateTime().toLocalDate();
			rfp.setPeriodNum(new BigDecimal(Period.between(yearStartDate, periodStartDate).getMonths()+1));
			int quarterNum = getQuarterNum(yearStartDate,periodStartDate);
			rfp.setQuarterNum(new BigDecimal(quarterNum));
			rfp.setQuarterName("Q"+quarterNum+"-"+periodStartDate.getYear());
			String periodName = periodStartDate.getMonth().name().substring(0,3).toLowerCase();
			rfp.setAdjustmentPeriodFlag("N");
			rfp.setPeriodYear(new BigDecimal(periodStartDate.getYear()));
			rfp.setPeriodName(periodName.substring(0,1).toUpperCase()+periodName.substring(1,periodName.length())+"-"+periodStartDate.getYear()%100);
			LocalDate qstartDate = yearStartDate.plusMonths((getQuarterNum(yearStartDate,periodStartDate)-1)*3L);
			rfp.setQuarterStartDate(Timestamp.valueOf(qstartDate.atStartOfDay()));
			rfp.setEnteredPeriodName(periodName.substring(0,1).toUpperCase()+periodName.substring(1,periodName.length()));
			
			List<String> periodStatusList = new ArrayList<>();
			periodStatusList.add("OPEN");
			periodStatusList.add(CONSTANTS.CLOSED);
			periodStatusList.add(CONSTANTS.FUTURE);
			if((rfp.getPeriodStatus()==null)) {
				errorMessage = errorMessage + "| Period status can not be empty";
			}
			if(!periodStatusList.contains(rfp.getPeriodStatus().toUpperCase())) {
				errorMessage = errorMessage + "| Period status should be like either 'OPEN' or 'CLOSED' or 'FURURE'";
			}
			if(rfp.getPeriodStatus().equalsIgnoreCase("OPEN")) {
				rfp.setOpenFlag("Y");
			}else if(rfp.getPeriodStatus().equalsIgnoreCase(CONSTANTS.CLOSED)) {
				rfp.setOpenFlag("N");
			}else if(rfp.getPeriodStatus().equalsIgnoreCase(CONSTANTS.FUTURE)){
				rfp.setOpenFlag("F");
			}
			rfp.setPeriodStatus(rfp.getPeriodStatus());
			
			if(rfp.getAdditionalAttribute1()!=null) {
				RmanFiscalPeriods rfps1 =  rmanFiscalPeriodsRepository.findByAdditionalAttribute1IgnoreCase(rfp.getAdditionalAttribute1());
				if(rfps1!=null) {
					if(rfps1.getCreatedBy()!=null) {
						rfp.setCreatedBy(rfps1.getCreatedBy());
					}
					if(rfps1.getCreationDate()!=null) {
						rfp.setCreationDate(rfps1.getCreationDate());
					}
					if(rfps1.getRmanPeriodId()!=null) {
						rfp.setRmanPeriodId(rfps1.getRmanPeriodId());
					}
				}else{
					RmanFiscalPeriods rfperiod=rmanFiscalPeriodsRepository.findByPeriodNameIgnoreCase(rfp.getPeriodName());
					if(rfperiod!=null) {
						errorMessage = errorMessage + "| Fiscal period"+rfp.getPeriodName()+ " exists in the Ayara";
					}
				}
			}else {
				errorMessage = errorMessage + "| No Source Fiscal Period Reference Id Send to Ayara";
			}
			
			
			if(!errorMessage.isEmpty()) {
				failedPeriods.add(new ErrorMessage(rfp.getAdditionalAttribute1(), errorMessage));
				isErrorOccured = true;
			}
			if(!isErrorOccured) {
				rfps.add(rfp);
			}
			
		});
		
		UpstreamResponse upResponse = new UpstreamResponse();
		upResponse.setExceptions(failedPeriods);
		
		if(noOfRecords==1 && rfps.size()==1 && rfps.get(0).getRmanPeriodId()!=null) {
			
			RmanFiscalPeriods checkPeriod = rmanFiscalPeriodsRepository.findById(rfps.get(0).getRmanPeriodId()).get();
			
			String previousPeriod = checkPeriod.getPeriodStatus();
			
			/** 
			 * Check for the Period Status Before CLOSE from OPEN
			 * Calling the Usage Adjustment Program before the CLOSE Period
			 */
			
			if(previousPeriod.equalsIgnoreCase("OPEN") && rfps.get(0).getPeriodStatus().equalsIgnoreCase(CONSTANTS.CLOSED)) {
				logger.info("Calling the Usage Adjustment Program Before Closed Period");
				usageAdjustmentProgramBeforeClosePeriod();
			}
			
			List<RmanFiscalPeriods> succesFiscalPeriodsList = rmanFiscalPeriodsRepository.saveAll(rfps);
			
			List<BulkResponse> bulkResponseList = new ArrayList<>();
			succesFiscalPeriodsList.stream().forEach(rfp-> bulkResponseList.add(new BulkResponse(rfp.getAdditionalAttribute1(),rfp.getRmanPeriodId())));
			upResponse.setSuccessList(bulkResponseList);
			/** 
			 * Check for the Period Status From FUTURE to OPEN
			 * Calling the Usage Adjustment Program after the OPEN Period
			 */
			if((previousPeriod.equalsIgnoreCase(CONSTANTS.FUTURE) || previousPeriod.equalsIgnoreCase(CONSTANTS.CLOSED)) && succesFiscalPeriodsList.get(0).getPeriodStatus().equalsIgnoreCase("OPEN")) {
				logger.info("Calling the Usage Adjustment Program before Closing Period");
				usageAdjustmentProgramAfterOpenPeriod();
			}
			return upResponse;
			
		}
		
		List<RmanFiscalPeriods> succesFiscalPeriodsList = rmanFiscalPeriodsRepository.saveAll(rfps);
		List<BulkResponse> bulkResponseList = new ArrayList<>();
		succesFiscalPeriodsList.stream().forEach(rfp-> bulkResponseList.add(new BulkResponse(rfp.getAdditionalAttribute1(),rfp.getRmanPeriodId())));
		upResponse.setSuccessList(bulkResponseList);
		return upResponse;
		
	}

	@Override
	public void usageAdjustmentProgramAfterOpenPeriod() {
		try {
			StoredProcedureQuery storedProcedure = manager
					.createStoredProcedureQuery("RMAN_USAGE_SUMMARIES_PROCESS_PKG.PERIOD_USAGE_CHECK");
			storedProcedure.execute();
		} catch (Exception e) {
			logger.error("Usage Adjustment Program Calling failed due to {}" , e.getMessage());
		}
	}

	@Override
	public void usageAdjustmentProgramBeforeClosePeriod() {
		
		try {
			StoredProcedureQuery storedProcedure = manager
					.createStoredProcedureQuery("RMAN_USAGE_SUMMARIES_PROCESS_PKG.CHECK_USAGE_ADJ");
			storedProcedure.execute();
		} catch (Exception e) {
			logger.error("Usage Adjustment Program Before Close Period failed due to {}", e.getMessage());
		}
	}

	private List<AyaraDocTransactionsInt> parseDocumentsCSV(BigDecimal batchId,BufferedReader bufferedReader, String fileName,String loggedUser) {
		Timestamp currentDate = new Timestamp(System.currentTimeMillis());
		CsvToBean<AyaraDocTransactionsInt> beans = new CsvToBeanBuilder<AyaraDocTransactionsInt>(bufferedReader)
			        .withType(AyaraDocTransactionsInt.class)
			        .withIgnoreQuotations(false)
			        .withThrowExceptions(false)
			        .withIgnoreLeadingWhiteSpace(true)
			        .build();
		
	    List<AyaraDocTransactionsInt> beanList = beans.parse();
	    
	    beanList.stream().forEach(doc -> {
	    	doc.setProcessId(batchId);
	    	doc.setCreatedBy(loggedUser);
	    	doc.setCreationDate(currentDate);
	    	doc.setLastUpdatedBy(loggedUser);
	    	doc.setLastUpdateDate(currentDate);
	    	doc.setProcessFlag("N");
	    });
	    
	    return beanList;
	}
	
	/*
	 *  Impletation logic updated for the processDocuments Method  for File Upload Processes
	 *  #AYAR-479 By Chandra on 9th Jun 2021
	 * #AYAR-1083 By Chandra on 23rd July 2021 by calling the Release Contingency package 
	 */
	@Async
	@Override
	public void processDocuments(BigDecimal processId, BufferedReader bufferedReader, String documentName,String documentType,RmanUsers loggedUserInfo) {
		try {
			createJobRecord(processId.toString(), documentType+" File Process job", documentType, documentName, loggedUserInfo);
			String loggedUser = loggedUserInfo.getUserName();
			CompletableFuture<List<AyaraDocTransactionsInt>> f = 
					CompletableFuture.completedFuture(parseDocumentsCSV(processId, bufferedReader, documentName,loggedUser));
			if (f.isDone()) {
				Thread.sleep(3000);
				if( f.get().isEmpty()) {
					throw new AyaraCustomException("CSV File Upload failed to Read Records due to CSV Parse error");
				}
				
				List<AyaraDocTransactionsInt> doclist = f.get(); 
				RmanFileUploadJobs job1 = rmanFileUploadJobRepository.findByJobId(processId.toString());
				job1.setTotalProcessRecords(new BigDecimal(doclist.size()));
				rmanFileUploadJobRepository.save(job1);
				CompletableFuture<Boolean> f2 = 
						CompletableFuture.completedFuture(saveDocumentsDataAndProcess(doclist, BaseListener.getCurrentUserId(), processId, documentType));
				if(f2.isDone()) {
					Thread.sleep(3000);
					List<AyaraDocTransactionsInt> failedList = ayaraDocTransactionsIntRepo
							.findByProcessFlagAndProcessId("E", processId);
					int failedRecs = failedList.size();
					int successRecs = doclist.size() - failedList.size();
					RmanFileUploadJobs job2 = rmanFileUploadJobRepository.findByJobId(processId.toString());
					RmanFileUploadJobs job3 = updateJobRecord(job2, job2.getTotalProcessRecords(), new BigDecimal(failedRecs), new BigDecimal(successRecs), CONSTANTS.COMPLETED);
		
					//Job Notification email condition
					if(RevmantraUtils.getProperty(CONSTANTS.JOB_COMPLETE_NOTIFICATION).equalsIgnoreCase("Yes")) {
						jobNotificationMail(loggedUserInfo, job3);
					}
				}
			}
			
		} catch (Exception e) {
			logger.error("Getting error when {} file upload process due to {} ", documentType, e.getCause().getMessage());
			RmanFileUploadJobs job4 = updateJobRecord(rmanFileUploadJobRepository.findByJobId(processId.toString())
					                                 ,new BigDecimal(0)
					                                 ,new BigDecimal(0)
					                                 ,new BigDecimal(0)
					                                 ,CONSTANTS.FAILED
					                                 );
			//Job Notification email condition
			if(RevmantraUtils.getProperty(CONSTANTS.JOB_COMPLETE_NOTIFICATION).equalsIgnoreCase("Yes")) {
				jobNotificationMail(loggedUserInfo, job4);
			}
			throw new AyaraCustomException(e.getCause().getMessage());
		}

		
	}
	
	@Transactional
	private boolean saveDocumentsDataAndProcess(List<AyaraDocTransactionsInt> documentslist, BigDecimal currentUserId,
			BigDecimal processId,String documentType) {
		int size = documentslist.size();
		int counter = 0;
		List<AyaraDocTransactionsInt> temp = new ArrayList<>();
		for (AyaraDocTransactionsInt rec : documentslist) {
			temp.add(rec);
			if ((counter + 1) % 500 == 0 || (counter + 1) == size) {
				ayaraDocTransactionsIntRepo.saveAll(temp);
				temp.clear();
			}
			
			counter++;
		}
		
		StoredProcedureQuery storedProcedure;
		
		try {
			
			if(documentType.equals("QUOTE")) {
				storedProcedure = manager
						.createStoredProcedureQuery("ayara_quotes_process_pkg.process_quotes")
						.registerStoredProcedureParameter(CONSTANTS.P_PROCESS_ID, BigDecimal.class, ParameterMode.IN);
				storedProcedure.setParameter(CONSTANTS.P_PROCESS_ID, processId);
				storedProcedure.execute();
			}else if(documentType.equals("BOOK")) {
				storedProcedure = manager
						.createStoredProcedureQuery("ayara_process_document_pkg.process_booking")
						.registerStoredProcedureParameter(CONSTANTS.P_PROCESS_ID, BigDecimal.class, ParameterMode.IN);
				storedProcedure.setParameter(CONSTANTS.P_PROCESS_ID, processId);
				storedProcedure.execute();
			}else if(documentType.equals("SHIP")) {
				storedProcedure = manager
						.createStoredProcedureQuery("ayara_process_document_pkg.process_shipments")
						.registerStoredProcedureParameter(CONSTANTS.P_PROCESS_ID, BigDecimal.class, ParameterMode.IN);
				storedProcedure.setParameter(CONSTANTS.P_PROCESS_ID, processId);
				storedProcedure.execute();
			}else if(documentType.equals("INV")) {
				storedProcedure = manager
						.createStoredProcedureQuery("ayara_process_doc_invoices_pkg.main_proc")
						.registerStoredProcedureParameter(CONSTANTS.P_PROCESS_ID, BigDecimal.class, ParameterMode.IN);

				storedProcedure.setParameter(CONSTANTS.P_PROCESS_ID, processId);
				storedProcedure.execute();
			}else if(documentType.equals("VCR")) {
				storedProcedure = manager
						.createStoredProcedureQuery("ayara_process_document_pkg.process_cont_releases")
						.registerStoredProcedureParameter(CONSTANTS.P_PROCESS_ID, BigDecimal.class, ParameterMode.IN);

				storedProcedure.setParameter(CONSTANTS.P_PROCESS_ID, processId);
				storedProcedure.execute();
			}else {
				throw new AyaraCustomException("No Document Type defined to Process");
			}
			
		} catch (Exception e) {
			throw new AyaraCustomException(documentType+ " Process job failed.Contact System Administrator.");
		}
		
		return true;
		
	}
	/*
	 *  Impletation logic updated for the processIntegrationDocuments Method  for Integration API
	 *  #AYAR-476 By Chandra on 9th Jun 2021
	 * 
	 */
	@Override
	public ResponseData processIntegrationDocuments(BigDecimal processId, List<AyaraDocTransactionsInt> docs,String documentType,BigDecimal currentUserId,String source) {
		ResponseData response = new ResponseData();
		List<SfqiExceptions> exceptions = new ArrayList<>();
		
		try {
			saveDocumentsDataAndProcess(docs, currentUserId, processId, documentType);
			
			List<Object[]> failedOrderObj = ayaraDocTransactionsIntRepo.getFailedDocumentsList(processId);
			
			failedOrderObj.stream().forEach(orderObj -> {
				SfqiExceptions exception = new SfqiExceptions(orderObj[0].toString(), orderObj[1].toString());
				exceptions.add(exception);
			});
			
			Set<String> documentNumbers = docs.stream().map(doc->doc.getDocumentNumber()).collect(Collectors.toSet());
			
			
			List<RmanSalesforceQuoteLine> allocations=new ArrayList<>();
			
			if(!(source.equalsIgnoreCase("EBS")) && (documentType.equalsIgnoreCase("QUOTE") || documentType.equalsIgnoreCase("BOOK"))) {
				
				for(String doc: documentNumbers) {
					String ord;
					try {
						ord = String.valueOf(Integer.valueOf(doc));
					}catch(Exception e) {
						ord = doc;
					}
					if (rmanDealHeadersRepository.findByDealNumber(ord)!=null){
						allocations.addAll(rmanSalesforceQuoteLineRepository.findByQuoteId(rmanDealHeadersRepository.findByDealNumber(ord).getDealArrangementId()));
						response.setTargetArrangementId(rmanDealHeadersRepository.findByDealNumber(ord).getDealArrangementId());
					}
				}
				response.setRevenueAllocations(allocations);
				
				long redCnt = allocations.stream().filter(alloc -> CONSTANTS.RED.equalsIgnoreCase(alloc.getRevenueGuidance()!=null ? alloc.getRevenueGuidance() : "")).count();
				if (redCnt > 0) {
					response.setRevenueGuidance(CONSTANTS.RED);
				}else {
					long yellowCnt = allocations.stream().filter(alloc -> CONSTANTS.YELLOW.equalsIgnoreCase(alloc.getRevenueGuidance()!=null ? alloc.getRevenueGuidance() : "")).count();
					if(yellowCnt > 0) {
						response.setRevenueGuidance(CONSTANTS.YELLOW);
					}else {
						long greenCnt = allocations.stream().filter(alloc -> alloc.getRevenueGuidance()!=null).count();
						if(greenCnt > 0) {
							response.setRevenueGuidance(CONSTANTS.GREEN);
						}
					}
								}
				
			}
			
			response.setBatchId(processId);
			response.setExceptions(exceptions);
			
			if(failedOrderObj.isEmpty()) {
				response.setStatus(CONSTANTS.SUCCESS);
				response.setMessage("All Documents are Successfully Processed");
			}else if(!failedOrderObj.isEmpty() && allocations.isEmpty()) {
				response.setStatus(CONSTANTS.failed_Msg);
				response.setMessage("All Documents are Processed and failed to generate Allocations");
			}else {
				response.setStatus("Warning");
				response.setMessage("All of the Documents are processed and some of them processed Successfully and some of them failed");
			}
			
			
		}catch(Exception e) {
			response.setStatus(CONSTANTS.failed_Msg);
			response.setBatchId(processId);
			response.setMessage("All Documents are failed to process due to" + e.getMessage());
		}
		
		return response;
	}

	@Override
	public String approveBookSSPRules(BigDecimal sspBookId) {
		return callApprovalProcess(sspBookId);
	}
	
	@Transactional
	String callApprovalProcess(BigDecimal pSSPBookId){
		StoredProcedureQuery storedProcedure;
		try {
			storedProcedure = manager
					.createStoredProcedureQuery("ayara_approve_ssp_rules_proc")
					.registerStoredProcedureParameter("p_book_id", BigDecimal.class, ParameterMode.IN)
					.registerStoredProcedureParameter(CONSTANTS.P_USER_ID, BigDecimal.class, ParameterMode.IN)
					.registerStoredProcedureParameter("o_status", String.class, ParameterMode.OUT);
			storedProcedure.setParameter("p_book_id", pSSPBookId);
			storedProcedure.setParameter(CONSTANTS.P_USER_ID, BaseListener.getCurrentUserId());
			storedProcedure.execute();
			return storedProcedure.getOutputParameterValue("o_status").toString();
		}catch(Exception e) {
			throw new AyaraCustomException("Failed to approve all the SSP Rules for the Selected SSP Book");
		}
				
	}

	@Override
	public void updateRCApprovalStatus(String status, BigDecimal arrangementId) {
		RmanDealArrangements rda = rmanDealArrangementsRepository.findById(arrangementId).get();
		rda.setAttribute12(status); //Set Approval Status
		rmanDealArrangementsRepository.save(rda);
	}

	@Override
	public void updateRCProcessInstance(String processInstanceID, BigDecimal arrangementId) {
		RmanDealArrangements rda = rmanDealArrangementsRepository.findById(arrangementId).get();
		rda.setAttribute11(processInstanceID); //Set Approval Status
		rmanDealArrangementsRepository.save(rda);
	}
	
	private List<RmanUsageSummaryInterface> parseUsageDocumentsCSV(BigDecimal batchId,BufferedReader bufferedReader,BigDecimal uploadUserId) {
		Timestamp currentDate = new Timestamp(System.currentTimeMillis());
		CsvToBean<RmanUsageSummaryInterface> beans = new CsvToBeanBuilder<RmanUsageSummaryInterface>(bufferedReader)
			        .withType(RmanUsageSummaryInterface.class)
			        .withIgnoreQuotations(false)
			        .withThrowExceptions(false)
			        .withIgnoreLeadingWhiteSpace(true)
			        .build();
		
	    List<RmanUsageSummaryInterface> beanList = beans.parse();
	    
	    beanList.stream().forEach(doc -> {
	    	doc.setInterfaceProcessId(batchId);
	    	doc.setCreatedBy(uploadUserId);
	    	doc.setCreationDate(currentDate);
	    	doc.setLastUpdatedBy(uploadUserId);
	    	doc.setLastUpdateDate(currentDate);
	    	doc.setInterfaceStatus("R");
	    });
	    
		return beanList;
}

		
	/*
	 *  Parsing Usage file data and storing into a list
	 *  #AYAR-1616 By Madhu Sri Thota on 29th Sep 2021
	 */
	@Async
	@Override
	public void processUsageFile(String batchId,BufferedReader bufferedReader, String fileName,RmanUsers loggedUserInfo) {
		logger.info("Started Processing Usage File Data");
		try {
			createJobRecord(batchId, "USAGES File Process job", "USAGES", fileName, loggedUserInfo);
			CompletableFuture<List<RmanUsageSummaryInterface>> f = 
					CompletableFuture.completedFuture(parseUsageDocumentsCSV(new BigDecimal(batchId),bufferedReader,loggedUserInfo.getRmanUserId()));
			if (f.isDone()) {
				Thread.sleep(3000);
				if( f.get().isEmpty()) {
					throw new AyaraCustomException("CSV File Upload failed to Read Records due to CSV Parse error");
				}
				List<RmanUsageSummaryInterface> usageSummariesList = f.get();
				RmanFileUploadJobs job1 = rmanFileUploadJobRepository.findByJobId(batchId);
				job1.setTotalProcessRecords(new BigDecimal(usageSummariesList.size()));
				rmanFileUploadJobRepository.save(job1);
				CompletableFuture<Boolean> f1 = 
						CompletableFuture.completedFuture(saveUsageSummaries(usageSummariesList, batchId));
				if(f1.isDone()) {
					Thread.sleep(3000);
					List<RmanUsageSummaryInterface> failedList = rmanUsageSummaryInterfaceRepo
							.findByInterfaceStatusAndInterfaceProcessId("E", new BigDecimal(batchId));
					int processRecs = usageSummariesList.size();
					int failedRecs = failedList.size();
					int successRecs = usageSummariesList.size() - failedList.size();
					RmanFileUploadJobs job2 = rmanFileUploadJobRepository.findByJobId(batchId);
					RmanFileUploadJobs job3= updateJobRecord(job2, new BigDecimal(processRecs), new BigDecimal(failedRecs), new BigDecimal(successRecs), CONSTANTS.COMPLETED);
					//Job Notification email condition
					if(RevmantraUtils.getProperty(CONSTANTS.JOB_COMPLETE_NOTIFICATION).equalsIgnoreCase("Yes")) {
						jobNotificationMail(loggedUserInfo, job3);
					}
				}
				
			}
		} catch (Exception e) {
			logger.error("Getting error when processing Usage File {}" , e.getMessage());
			RmanFileUploadJobs job4 = updateJobRecord(rmanFileUploadJobRepository.findByJobId(batchId)
                    								 ,new BigDecimal(0)
                    								 ,new BigDecimal(0)
									                 ,new BigDecimal(0)
									                 ,CONSTANTS.FAILED
									                 );
			//Job Notification email condition
			if(RevmantraUtils.getProperty(CONSTANTS.JOB_COMPLETE_NOTIFICATION).equalsIgnoreCase("Yes")) {
				jobNotificationMail(loggedUserInfo, job4);
			}
			throw new AyaraCustomException(e.getMessage());
		}

	}
	
	/*
	 *  Saving data to interface table and executing corresponding procedure
	 *  #AYAR-1616 By Madhu Sri Thota on 29th Sep 2021
	 */
	@Transactional
	private boolean saveUsageSummaries(List<RmanUsageSummaryInterface> usageSummariesList, String batchId) {
		int size = usageSummariesList.size();
		int counter = 0;
		List<RmanUsageSummaryInterface> temp = new ArrayList<>();
		for (RmanUsageSummaryInterface emp : usageSummariesList) {
			temp.add(emp);
			if ((counter + 1) % 500 == 0 || (counter + 1) == size) {
				rmanUsageSummaryInterfaceRepo.saveAll(temp);
				temp.clear();
			}
			counter++;
		}
		logger.info("Saved Usage File Data Successfully");
		try {
			StoredProcedureQuery storedProcedure = manager
					.createStoredProcedureQuery("RMAN_USAGE_SUMMARIES_PROCESS_PKG.PROCESS_USAGE_SUMMARIES")
					.registerStoredProcedureParameter(CONSTANTS.P_BATCH_ID, BigDecimal.class, ParameterMode.IN);
			storedProcedure.setParameter(CONSTANTS.P_BATCH_ID, new BigDecimal(batchId));
			storedProcedure.execute();
			logger.info("PROCESS_USAGE_SUMMARIES package executed Successfully");
		} catch (Exception e) {
			throw new AyaraCustomException("Usage Process Failed. Please Contact Administrator");
		}
		
		return true;

	}

	@Override
	public void approvalRevRecognising(BigDecimal arrangementId) {
		try {
			StoredProcedureQuery storedProcedure = manager
					.createStoredProcedureQuery("AYARA_APPROVAL_REV_REC_PROC")
					.registerStoredProcedureParameter("p_arrg_id", BigDecimal.class, ParameterMode.IN);
			storedProcedure.setParameter("p_arrg_id", arrangementId);
			storedProcedure.execute();
			logger.info("AYARA_APPROVAL_REV_REC_PROC procedure executed Successfully");
		} catch (Exception e) {
			throw new AyaraCustomException("Revenue Recognisation Process Failed. Please Contact Administrator");
		}
		
	}
	
	private void jobNotificationMail(RmanUsers loggedUserInfo,RmanFileUploadJobs job) {
			long totalTimeInMilliSeconds;
			try {
				totalTimeInMilliSeconds = job.getFinishedDate().getTime() - job.getStartDate().getTime();
			}catch(Exception e){
				totalTimeInMilliSeconds = System.currentTimeMillis()-job.getStartDate().getTime();
			}
			int seconds = (int) totalTimeInMilliSeconds / 1000;
			int days = (seconds / 3600)/24;
		    int hours = (seconds % 3600)/(24*60);
		    int minutes = (seconds % 3600) / 60;
		    	seconds = (seconds % 3600) % 60;
		    	
			MailSend mailSendBean = new MailSend();
			 mailSendBean.setToAddress(loggedUserInfo.getEmailAddress());
			 mailSendBean.setSubject("Status of Job Id  "+job.getJobId()+" for the "+job.getJobName());
			 mailSendBean.setMailBody(
					 "Job Id "+job.getJobId()+" and Status is "+job.getJobStatus()+".\n"
					+ "Find the below statistics regarding the file upload Process\n"
					+ "Total Number of Processed Records    : "+(job.getTotalProcessRecords()!=null ? job.getTotalProcessRecords() : new BigDecimal(0))+"\n"
			 		+ "Total Number of Failed Records       : "+(job.getTotalFailedRecords()!=null ? job.getTotalFailedRecords() : new BigDecimal(0))+"\n"
			 		+ "Total Number of Success Records      : "+(job.getTotalSuccessRecords()!=null ? job.getTotalSuccessRecords() : new BigDecimal(0))+"\n\n"
			 		+ "Total time taken to complete Process : "+days+"d "+hours+"h "+minutes+"m "+seconds+"s"+"\n"
			 		);
			 MailSender.sendMail(mailSendBean, false);
	}
	
	private RmanFileUploadJobs createJobRecord(String jobId,String jobName,String jobType,String fileName,RmanUsers loggedUserInfo){
		RmanFileUploadJobs job = new RmanFileUploadJobs();
		job.setJobId(jobId);
		job.setJobName(jobName);
		job.setStartDate(new Timestamp(System.currentTimeMillis()));
		job.setAttribute1(jobType);
		job.setAttribute2(loggedUserInfo.getFullName());
		job.setAttribute3(fileName);
		job.setJobStatus("INPROGRESS");
		job.setCreatedBY(loggedUserInfo.getRmanUserId());
		job.setLastUpdatedBy(loggedUserInfo.getRmanUserId());
		return rmanFileUploadJobRepository.save(job);
	}
	
	private RmanFileUploadJobs updateJobRecord(RmanFileUploadJobs job,BigDecimal processRecs,BigDecimal failedRecs,BigDecimal successRecs,String jobStatus){
		job.setFinishedDate(new Timestamp(System.currentTimeMillis()));
		if(jobStatus.equalsIgnoreCase(CONSTANTS.COMPLETED)) {
			job.setTotalProcessRecords(processRecs);
			job.setTotalFailedRecords(failedRecs);
			job.setTotalSuccessRecords(successRecs);
		}
		job.setJobStatus(jobStatus);
		return rmanFileUploadJobRepository.save(job);
	}
	
	private List<SspRulesInterface> parseSSPRulesCSV(BigDecimal batchId,BufferedReader bufferedReader,BigDecimal uploadUserId) {
		Timestamp currentDate = new Timestamp(System.currentTimeMillis());
		try {
			CsvToBean<SspRulesInterface> beans = new CsvToBeanBuilder<SspRulesInterface>(bufferedReader)
			        .withType(SspRulesInterface.class)
			        .withIgnoreQuotations(false)
			        .withThrowExceptions(false)
			        .withIgnoreLeadingWhiteSpace(true)
			        .build();
			List<SspRulesInterface> beanList = beans.parse();
			beanList.stream().forEach(doc -> {
		    	doc.setProcessId(batchId.toString());
		    	doc.setCreatedBy(uploadUserId);
		    	doc.setCreationDate(currentDate);
		    	doc.setLastUpdatedBy(uploadUserId);
		    	doc.setLastUpdateDate(currentDate);
		    	doc.setProcessFlag("N");
		    });
		    return beanList;
		
		}catch(Exception e) {
			throw new AyaraCustomException("Unable to Read the file Due to {} " +e.getMessage());
		}
	}
	
	/**
	 *  AYAR-1816 Recently updated logic for the SSP Book Name Reference in File
	 *  Upload file Header Column should be like Interface columns 
	 *  Added the logic by chandra Kota on 07 JAN 2022
	 */
	@Async
	@Override
	public void processSSPRulesFile(String batchId,BufferedReader bufferedReader, String fileName,RmanUsers loggedUserInfo) {
		logger.info("Started Processing SSP Rules File Data");
		try {
			createJobRecord(batchId, "SSP File Process job", "SSP", fileName, loggedUserInfo);
			CompletableFuture<List<SspRulesInterface>> f = 
					CompletableFuture.completedFuture(parseSSPRulesCSV(new BigDecimal(batchId),bufferedReader,loggedUserInfo.getRmanUserId()));
			if (f.isDone()) {
				if(f.get().isEmpty()) {
					throw new AyaraCustomException("No Record is Parsing through the CSV file due to parsing error and check the Numbers and Date formats");
				}
				List<SspRulesInterface> sspRulesList = f.get();
				RmanFileUploadJobs job1 = rmanFileUploadJobRepository.findByJobId(batchId);
				job1.setTotalProcessRecords(new BigDecimal(sspRulesList.size()));
				rmanFileUploadJobRepository.save(job1);
				CompletableFuture<Boolean> f1 = 
						CompletableFuture.completedFuture(saveSSPRulesDataAndProcess(sspRulesList, batchId));
				if(f1.isDone()) {
					Thread.sleep(3000);
					List<SspRulesInterface> failedList = sspRulesInterfaceRepository.findByProcessFlagAndProcessId("E", batchId);
					int processRecs = sspRulesList.size();
					int failedRecs = failedList.size();
					int successRecs = sspRulesList.size() - failedList.size();
					RmanFileUploadJobs job2 = rmanFileUploadJobRepository.findByJobId(batchId);
					RmanFileUploadJobs job3= updateJobRecord(job2, new BigDecimal(processRecs), new BigDecimal(failedRecs), new BigDecimal(successRecs), CONSTANTS.COMPLETED);
					//Job Notification email condition
					if(RevmantraUtils.getProperty(CONSTANTS.JOB_COMPLETE_NOTIFICATION).equalsIgnoreCase("Yes")) {
						jobNotificationMail(loggedUserInfo, job3);
					}
				}
				
			}
		} catch (Exception e) {
			logger.error("Getting error when processing SSP Rules File {}" , e.getMessage());
			RmanFileUploadJobs job4 = updateJobRecord(rmanFileUploadJobRepository.findByJobId(batchId)
                    								 ,new BigDecimal(0)
                    								 ,new BigDecimal(0)
									                 ,new BigDecimal(0)
									                 ,CONSTANTS.FAILED
									                 );
			//Job Notification email condition
			if(RevmantraUtils.getProperty(CONSTANTS.JOB_COMPLETE_NOTIFICATION).equalsIgnoreCase("Yes")) {
				jobNotificationMail(loggedUserInfo, job4);
			}
			throw new AyaraCustomException(e.getMessage());
		}

	}
	
}