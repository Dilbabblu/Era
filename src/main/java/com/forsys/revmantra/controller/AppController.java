package com.forsys.revmantra.controller;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TimeZone;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.forsys.revmantra.cpk.id.AyaraUserTableColumnsPkId;
import com.forsys.revmantra.cpk.id.RmanContLinkedtemplatesId;
import com.forsys.revmantra.cpk.id.RmanUserResponsibilitiesPk;
import com.forsys.revmantra.custom.RmanConcurrentProgramsDAO;
import com.forsys.revmantra.exceptions.AyaraCustomException;
import com.forsys.revmantra.listener.BaseListener;
import com.forsys.revmantra.model.*;
import com.forsys.revmantra.repositories.*;
import com.forsys.revmantra.utils.CONSTANTS;
import com.forsys.revmantra.utils.ExportColumns;
import com.forsys.revmantra.utils.IdentityServiceUtils;
import com.forsys.revmantra.utils.RevmantraUtils;

@Controller
@PropertySource("classpath:META-INF/application.properties")
public class AppController extends ExportColumns {

	private static final Logger logger = LogManager.getLogger(AppController.class);

	public static final String SEARCH_PATTERN = "([\\S\\s]+?)(:|<|>|=)([\\S\\s]+?),";

	private static final String P_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";

	private static final Pattern pattern = Pattern.compile(P_PATTERN);

	@Resource
	private Environment env;

	@Autowired
	private RmanConcurrentProgramsDAO rmanConcurrentProgramsDAO;

	@Autowired
	private RmanOrdersInterfaceRepository rmanOrdersInterfaceRepo;

	@Autowired
	private RmanInvoiceLinesInterfaceRepository rmanInvoiceLinesInterfaceRepo;

	@Autowired
	private RmanFmvRulesDefRepository rmanFmvRulesDefRepo;

	@Autowired
	private RmanIntfDealDetailsRepository rmanIntfDealDetailsRepo;

	@Autowired
	private RmanArrangementsAllVRepository rmanArrangementsAllVRepo;

	@Autowired
	private RmanLookupsVRepository rmanLookupsVRepo;

	@Autowired
	private RmanCurrencyRepository rmanCurrencyRepo;

	@Autowired
	private RmanFmvRulesDefParaValueRepository rmanFmvRulesDefParaValueRepo;

	@Autowired
	private RmanLegalEntitiesRepository rmanLegalEntitiesRepo;

	@Autowired
	private RmanRulesHeaderRepository rmanRulesHeaderRepo;

	@Autowired
	private RmanUsersRepository rmanUsersRepo;

	@Autowired
	private RmanRuleParameterValueRepository rmanRuleParameterValueRepo;

	@Autowired
	private RmanEntityParametersVRepository rmanEntityParametersVRepo;

	@Autowired
	private RmanEntityParametersRepository rmanEntityParametersRepo;

	@Autowired
	private RmanEntitiesRepository rmanEntitiesRepo;

	@Autowired
	private RmanContHeaderRepository rmanContHeaderRepo;

	@Autowired
	private RmanContTemplateRepository rmanContTemplateRepo;

	@Autowired
	private RmanFiscalPeriodsRepository rmanFiscalPeriodsRepo;

	@Autowired
	private RmanResponsibilitiesRepository rmanResponsibilitiesRepo;

	@Autowired
	private RmanUserResponsibilitiesRepository rmanUserResponsibilitiesRepo;

	@Autowired
	private AllTabColumnsRepository allTabColumnsRepo;

	@Autowired
	private RmanContTransLinesRepository rmanContTransLinesRepo;

	@Autowired
	private RmanContTransToReleaseRepository rmanContTransToReleaseRepo;

	@Autowired
	private RmanContHeaderVRepository rmanContHeaderVRepo;

	@Autowired
	private RmanContLinkTemplateVRepository rmanContLinkTemplateVRepo;

	@Autowired
	private RmanContSourceLovRepository rmanContSourceLovRepo;

	@Autowired
	private RmanContProdNameLovVRepository rmanContProdNameLovVRepo;

	@Autowired
	private RmanCustomersRepository rmanCustomersRepo;

	@Autowired
	private RmanProductsRepository rmanProductsRepo;

	@Autowired
	private RmanLookupTypesRepository rmanLookupTypesRepo;

	@Autowired
	private RmanLookupCodesRepository rmanLookupCodesRepo;

	@Autowired
	private RmanPobMappingRepository rmanPobMappingRepo;

	@Autowired
	private RmanDealArrangementsRepository rmanDealArrangementsRepo;

	@Autowired
	private ArrgContractAllocationsVRepository arrgContractAllocationsVRepo;

	@Autowired
	private RmanOrderBookingsVRepository rmanOrderBookingsVRepo;

	@Autowired
	private RmanOrderLinesBookingsVRepository rmanOrderLinesBookingsVRepo;

	@Autowired
	private ContractHeadersInfoVRepository contractHeadersInfoVRepo;

	@Autowired
	private RmanDealDetailsRepository rmanDealDetailsRepo;

	@Autowired
	private RmanMasterArrangementsVRepository rmanMasterArrangementsVRepo;

	@Autowired
	private RmanDealGmAsvRepository rmanDealGmAsvRepo;

	@Autowired
	private RmanRevDetailsVRepository rmanRevDetailsVRepo;

	@Autowired
	private RmanArrangementTotalLevelsRepository rmanArrangementTotalLevelsRepo;

	@Autowired
	private RmanArrgTotalsDateBasedVRepository rmanArrgTotalsDateBasedVRepo;

	@Autowired
	private RmanArrgLineOfBusinessVRepository rmanArrgLineOfBusinessVRepo;

	@Autowired
	private RmanContLinkedTemplateSvRepository rmanContLinkedTemplateSvRepo;

	@Autowired
	private RmanRevenueTemplatesRepository rmanRevenueTemplatesRepo;

	@Autowired
	private RmanGlAccountsRepository rmanGlAccountsRepo;

	@Autowired
	private RmanAccountSetupRepository rmanAccountSetupRepo;

	@Autowired
	private RmanDealHeadersRepository rmanDealHeadersRepo;

	@Autowired
	private RmanDealStatusRepository rmanDealStatusRepo;

	@Autowired
	private RmanEventsRepository rmanEventsRepo;

	@Autowired
	private RmanContReleaseLinesRepository rmanContReleaseLinesRepo;

	@Autowired
	private RmanContReleaseEventsVRepository rmanContReleaseEventsVRepo;

	@Autowired
	private RmanDealRfcstVRepository rmanDealRfcstVRepo;

	@Autowired
	private RmanContReleaseLinesVRepository rmanContReleaseLinesVRepo;

	@Autowired
	private ConsolidatedArrgSummaryRepRepository consolidatedArrgSummaryRepRepo;

	@Autowired
	private RmanArrgWaterFallRepV2Repository rmanArrgWaterFallRepV2Repo;

	@Autowired
	private RmanOrdersRepository rmanOrdersRepo;

	@Autowired
	private RmanArrgWaterfallReportNvRepository rmanArrgWaterfallReportNvRepo;

	@Autowired
	private RmanInvoicesStgRepository rmanInvoicesStgRepo;

	@Autowired
	private RmanInvoiceHeadersVRepository rmanInvoiceHeadersVRepo;

	@Autowired
	private RmanInvoiceLinesVRepository rmanInvoiceLinesVRepo;

	@Autowired
	private RmanOrdersAuditVRepository rmanOrdersAuditVRepo;

	@Autowired
	private RmanCustomersInterfaceRepository rmanCustomersInterfaceRepo;

	@Autowired
	private RmanProductsInterfaceRepository rmanProductsInterfaceRepo;

	@Autowired
	private SspRulesInterfaceRepository sspRulesInterfaceRepo;

	@Autowired
	private RmanGlAccountsInterfaceRepository rmanGlAccountsInterfaceRepo;

	@Autowired
	private RmanFileUploadJobsRepository rmanFileUploadJobsRepo;

	@Autowired
	private RmanFmvRulesExportVRepository rmanFmvRulesExportVRepo;

	@Autowired
	private RmanOpenDealArrangementsRepository rmanOpenDealArrangementsRepo;

	@Autowired
	private RmanConversionRatesIntRepository rmanConversionRatesIntRepo;

	@Autowired
	private RmanFiscalPeriodsInterfaceRepository rmanFiscalPeriodsInterfaceRepo;

	@Autowired
	private RmanContRulesLovRepository rmanContRulesLovRepo;

	@Autowired
	private RmanFcBucketsRepository rmanFcBucketsRepo;
	@Autowired
	private RmanFcstActualDetailsVRepository rmanFcstActualDetailsVRepo;

	@Autowired
	private RmanForecastingDetailsRepository rmanForecastingDetailsRepo;

	@Autowired
	private RmanFcConversionTypesRepository rmanFcConversionTypesRepo;

	@Autowired
	private RmanFcLevelRepository rmanFcLevelRepo;

	@Autowired
	private RmanFcMethodsRepository rmanFcMethodsRepo;

	@Autowired
	private RmanDealUsagesSummaryRepository rmanDealUsagesSummaryRepo;

	@Autowired
	private RmanBookedOrdersArchiveRepository rmanBookedOrdersArchiveRepo;

	@Autowired
	private RmanCustomersFileArchiveRepository rmanCustomersFileArchiveRepo;

	@Autowired
	private RmanProductsFileArchiveRepository rmanProductsFileArchiveRepo;

	@Autowired
	private RmanSspOrdersFileArchiveRepository rmanSspOrdersFileArchiveRepo;

	@Autowired
	private XTestClobRepository xTestClobRepo;

	@Autowired
	private RmanRoleFunctionsRepository rmanRoleFunctionsRepo;

	@Autowired
	private RmanFunctionsRepository rmanFunctionsRepo;

	@Autowired
	private AyaraReportsRepository ayaraReportsRepo;

	@Autowired
	private RmanUsageSummaryDetailsRepository rmanUsageSummaryDetailsRepo;

	@Autowired
	private AyaraUserTableColumnsRepository ayaraUserTableColumnsRepo;

	@Autowired
	private ArrgOrderAllocationsVRepository arrgOrderAllocationsVRepo;

	@Autowired
	private AyaraIntRecordExceptionsVRepository ayaraIntRecordExceptionsVRepo;

	@Autowired
	private SSPBooksRepository sspBooksRepo;

	@Autowired
	private AyaraSspGroupingRulesRepository ayaraSspGroupingRulesRepo;

	@Autowired
	private AyaraSspGroupingRuleDimensionsRepository ayaraSspGroupingRuleDimensionsRepo;

	@Autowired
	private AyaraDocTransactionsIntRepository ayaraDocTransactionsIntRepo;

	@Autowired
	private RmanUserActivityLogRepository rmanUserActivityLogRepo;

	@Autowired
	private AyaraReleaseLogTblRepository ayaraReleaseLogTblRepo;

	@Autowired
	private AyaraApprovalRulesRepository ayaraApprovalRulesRepository;

	@Autowired
	private IdentityServiceUtils identityServiceUtils;

	@Autowired
	private AyaraPendingSubmissionApprovalsVRepository ayaraPendingSubmissionApprovalsVRepo;

	@Autowired
	private AyaraRcPendingApprovalsVRepository ayaraRcPendingApprovalsVRepo;

	@Autowired
	private AyaraRcApprovalHistoryVRepository ayaraRcApprovalHistoryVRepo;

	@Autowired
	private AyaraOrderDeliveryDetailsInfoVRepository ayaraOrderDeliveryDetailsInfoVRepo;

	/*
	 * AYAR-1787 By Chandra on Dec 30th 2021
	 */

	@GetMapping(value = "/api/ayaraOrderDeliveryDetailsInfoVSearch")
	@ResponseBody
	public Page<AyaraOrderDeliveryDetailsInfoV> searchAyaraOrderDeliveryDetailsInfoV(
			@RequestParam(value = "search") String search, @PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		Pageable paging = PageRequest.of(pageRequest.getPageNumber(), pageRequest.getPageSize());
		return ayaraOrderDeliveryDetailsInfoVRepo
				.findAll(RevmantraUtils.fetchSpecification(AyaraOrderDeliveryDetailsInfoV.class, search), paging);
	}

	@GetMapping(value = "/api/ayaraRcApprovalHistoryVSearch")
	@ResponseBody
	public Page<AyaraRcApprovalHistoryV> searchAyaraRcApprovalHistoryV(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		Pageable paging = PageRequest.of(pageRequest.getPageNumber(), pageRequest.getPageSize(),
				Sort.by(Direction.DESC, "commentDate"));
		return ayaraRcApprovalHistoryVRepo
				.findAll(RevmantraUtils.fetchSpecification(AyaraRcApprovalHistoryV.class, search), paging);
	}

	@GetMapping(value = "/api/ayaraRcPendingApprovalsVSearch")
	@ResponseBody
	public Page<AyaraRcPendingApprovalsV> searchAyaraRcPendingApprovalsV(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		Pageable paging = PageRequest.of(pageRequest.getPageNumber(), pageRequest.getPageSize());
		String user = SecurityContextHolder.getContext().getAuthentication().getName();
		return ayaraRcPendingApprovalsVRepo.findByDelegateUserOrOriginalUser(user, user, paging);
	}

	@GetMapping(value = "/api/ayaraPendingSubmissionApprovalsVSearch")
	@ResponseBody
	public Page<AyaraPendingSubmissionApprovalsV> searchAyaraPendingSubmissionApprovalsV(
			@RequestParam(value = "search") String search, @PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		Pageable paging = PageRequest.of(pageRequest.getPageNumber(), pageRequest.getPageSize());
		String user = SecurityContextHolder.getContext().getAuthentication().getName();
		return ayaraPendingSubmissionApprovalsVRepo.findByUserName(user, paging);
	}

	@GetMapping(value = "/api/ayaraApprovalRulesSearch")
	@ResponseBody
	public Page<AyaraApprovalRules> searchAyaraApprovalRules(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		Pageable paging = PageRequest.of(pageRequest.getPageNumber(), pageRequest.getPageSize());
		return ayaraApprovalRulesRepository.findAll(RevmantraUtils.fetchSpecification(AyaraApprovalRules.class, search),
				paging);
	}

	@GetMapping(value = "/api/ayaraReleaseLogTblSearch")
	@ResponseBody
	public Page<AyaraReleaseLogTbl> searchAyaraReleaseLogTbl(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		Page<AyaraReleaseLogTbl> pages = ayaraReleaseLogTblRepo.findAll(
				RevmantraUtils.fetchSpecification(AyaraReleaseLogTbl.class, search),
				PageRequest.of(pageRequest.getPageNumber(), pageRequest.getPageSize(),
						Sort.by(Direction.DESC, "firmwareVersion")));
		pages.forEach(item -> item.setReleaseNotesList(Arrays.asList(item.getReleaseNotes().split(","))));
		return pages;
	}

	@GetMapping(value = "/api/rmanUserActivityLogSearch")
	@ResponseBody
	public Page<RmanUserActivityLog> searchRmanUserActivityLog(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		Pageable paging = PageRequest.of(pageRequest.getPageNumber(), pageRequest.getPageSize(),
				Sort.by(Direction.DESC, "modifiedDate"));
		return rmanUserActivityLogRepo.findAll(RevmantraUtils.fetchSpecification(RmanUserActivityLog.class, search),
				paging);
	}

	/*
	 * Added the Upload File API for the Quote,Book,Ship and Invoice files #AYAR-479
	 * By Chandra on 9th Jun 2021
	 */
	@GetMapping(value = "/api/ayaraDocTransactionsIntSearch")
	@ResponseBody
	public Page<AyaraDocTransactionsInt> searchAyaraDocTransactionsInt(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return ayaraDocTransactionsIntRepo
				.findAll(RevmantraUtils.fetchSpecification(AyaraDocTransactionsInt.class, search), pageRequest);

	}

	@GetMapping(value = "/api/ayaraDocTransactionsIntExport", produces = "application/vnd.ms-excel")
	@ResponseBody
	public String exportAllExceptions(@RequestParam(value = "search") String search,
			@RequestParam(value = "exportCols", required = false) List<String> columns,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest,
			@RequestParam(value = "exceptionType") String exceptionType, HttpServletResponse response) {
		response.setHeader(CONSTANTS.CONTENT_DISPOSITION, "inline; filename=All Exceptions-" + exceptionType + ".csv");

		List<AyaraDocTransactionsInt> ayaraDocTransactionsList = ayaraDocTransactionsIntRepo
				.findAll(RevmantraUtils.fetchSpecification(AyaraDocTransactionsInt.class, search));

		CsvMapper mapper = new CsvMapper();
		mapper.setDateFormat(new SimpleDateFormat(CONSTANTS.MM_DD_YYYY));
		mapper.enable(JsonGenerator.Feature.IGNORE_UNKNOWN);
		CsvSchema schema = null;
		List<String> line1 = new ArrayList<>();

		if (columns != null) {
			com.fasterxml.jackson.dataformat.csv.CsvSchema.Builder schemaBuilder = CsvSchema.builder()
					.setColumnSeparator(',');
			for (String column : columns) {
				schemaBuilder.addColumn(column);
				if (exceptionType.equalsIgnoreCase("QUOTE")) {
					line1.add(ExportColumns.quoteDocFields.get(column));
				}
				if (exceptionType.equalsIgnoreCase("BOOK")) {
					line1.add(ExportColumns.bookDocFields.get(column));
				}
				if (exceptionType.equalsIgnoreCase("SHIP")) {
					line1.add(ExportColumns.shipDocFields.get(column));
				}
				if (exceptionType.equalsIgnoreCase("INV")) {
					line1.add(ExportColumns.invDocFields.get(column));
				}
				if (exceptionType.equalsIgnoreCase("CONT_RELEASE")) {
					line1.add(ExportColumns.vcDocFields.get(column));
				}
			}
			schema = schemaBuilder.setUseHeader(false).build();
		}
		return exportAyaraDocTransactionsInt(line1, mapper, schema, ayaraDocTransactionsList);

	}

	private String exportAyaraDocTransactionsInt(List<String> line1, CsvMapper mapper, CsvSchema schema,
			List<AyaraDocTransactionsInt> ayaraDocTransactionsList) {
		ObjectWriter objectWriter = mapper.writer(schema);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		try {
			objectWriter.writeValue(baos, line1);
		} catch (JsonGenerationException jge) {
			logger.error(jge);
		} catch (JsonMappingException jme) {
			logger.error(jme);
		} catch (IOException ioe) {
			logger.error(ioe);
		}

		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(baos, 1024);
		OutputStreamWriter writerOutputStream;
		try {
			writerOutputStream = new OutputStreamWriter(bufferedOutputStream, StandardCharsets.UTF_8);
			objectWriter.writeValue(writerOutputStream, ayaraDocTransactionsList);
			writerOutputStream.close();
		} catch (UnsupportedEncodingException uee) {
			logger.error(uee);
		} catch (JsonGenerationException jge) {
			logger.error(jge);
		} catch (JsonMappingException jme) {
			logger.error(jme);
		} catch (IOException ioe) {
			logger.error(ioe);
		}
		String csvData = baos.toString();
		try {
			baos.close();
		} catch (IOException ioe) {
			logger.error(ioe);
		}
		return csvData;
	}

	@DeleteMapping(value = "/api/bulkDelExceptions")
	@ResponseBody
	public String bulkDelAllExceptions(@RequestParam("trxIds") BigDecimal[] trxIds) {
		rmanConcurrentProgramsDAO.deleteAllExceptions(trxIds);
		return "Y";
	}

	@GetMapping(value = "/api/sspGroupingRulesSearch")
	@ResponseBody
	public Page<AyaraSspGroupingRules> searchAyaraSspGroupingRules(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest,
			@RequestParam(value = "fetchAll", required = false) boolean fetchAll) {
		return ayaraSspGroupingRulesRepo.findAll(RevmantraUtils.fetchSpecification(AyaraSspGroupingRules.class, search),
				!fetchAll ? pageRequest : PageRequest.of(0, Integer.MAX_VALUE));
	}

	@GetMapping(value = "/api/sspGroupingRuleDimensionsSearch")
	@ResponseBody
	public Page<AyaraSspGroupingRuleDimensions> searchAyaraSspGroupingRuleDimensions(
			@RequestParam(value = "search") String search, @PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return ayaraSspGroupingRuleDimensionsRepo
				.findAll(RevmantraUtils.fetchSpecification(AyaraSspGroupingRuleDimensions.class, search), pageRequest);
	}

	@GetMapping(value = "/api/ayaraIntRecordExceptionsVSearch")
	@ResponseBody
	public Page<AyaraIntRecordExceptionsV> searchAyaraIntRecordExceptionsV(
			@RequestParam(value = "search") String search, @PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return ayaraIntRecordExceptionsVRepo
				.findAll(RevmantraUtils.fetchSpecification(AyaraIntRecordExceptionsV.class, search), pageRequest);

	}

	@GetMapping(value = { "/api/arrgOrderAllocationsVSearch", "/api/sfqi/arrgOrderAllocationsVSearch" })
	@ResponseBody
	public Page<ArrgOrderAllocationsV> searchArrgOrderAllocationsV(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return arrgOrderAllocationsVRepo.findAll(RevmantraUtils.fetchSpecification(ArrgOrderAllocationsV.class, search),
				pageRequest);
	}

	@GetMapping(value = "/api/ayaraUserTableColumnsSearch")
	@ResponseBody
	public Page<AyaraUserTableColumns> searchAyaraUserTableColumns(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return ayaraUserTableColumnsRepo.findAll(RevmantraUtils.fetchSpecification(AyaraUserTableColumns.class, search),
				pageRequest);
	}

	@GetMapping(value = "/api/ayaraUserTableColumns")
	@ResponseBody
	public AyaraUserTableColumns getUserBasedColumns(@RequestParam("pageName") String pageName,
			@RequestParam("tableName") String tableName) {
		return ayaraUserTableColumnsRepo.findByPageNameAndTableNameAndUserId(pageName, tableName,
				BaseListener.getCurrentUserId());
	}

	@PutMapping(value = "/api/updateRmanRolePermissions")
	@ResponseBody
	public List<RmanRoleFunctions> updateRmanRoleFunctions(@RequestBody List<RmanRoleFunctions> roleFunctions) {
		return rmanRoleFunctionsRepo.saveAll(roleFunctions);
	}

	@GetMapping(value = "/api/rmanUsageSummaryDetailsSearch")
	@ResponseBody
	public Page<RmanUsageSummaryDetails> searchRmanUsageSummaryDetails(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {

		return rmanUsageSummaryDetailsRepo
				.findAll(RevmantraUtils.fetchSpecification(RmanUsageSummaryDetails.class, search), pageRequest);
	}

	@DeleteMapping(value = "/api/bulkDeleteQuotes")
	@ResponseBody
	public String bulkDeleteQuotes(@RequestParam("slid") String[] arrangementNumbers) {
		rmanIntfDealDetailsRepo.deleteByArrangementNumberIn(Arrays.asList(arrangementNumbers));
		return "Y";
	}

	@DeleteMapping(value = "/api/bulkDeleteBillingsExceptions")
	@ResponseBody
	public String bulkDeleteBillingsExceptions(@RequestParam("slid") BigDecimal[] sourceInvoiceLineIds) {
		rmanInvoiceLinesInterfaceRepo.deleteBySourceInvoiceLineIdIn(Arrays.asList(sourceInvoiceLineIds));
		return "Y";
	}

	@GetMapping(value = "/api/rmanBookedOrdersArchiveSearch")
	@ResponseBody
	public Page<RmanBookedOrdersArchive> searchRmanBookedOrdersArchive(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {

		return rmanBookedOrdersArchiveRepo
				.findAll(RevmantraUtils.fetchSpecification(RmanBookedOrdersArchive.class, search), pageRequest);
	}

	@GetMapping(value = "/api/rmanSspOrdersFileArchiveSearch")
	@ResponseBody
	public Page<RmanSspOrdersFileArchive> searchRmanSspOrdersFileArchive(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return rmanSspOrdersFileArchiveRepo
				.findAll(RevmantraUtils.fetchSpecification(RmanSspOrdersFileArchive.class, search), pageRequest);
	}

	@GetMapping(value = "/api/xTestClobSearch")
	@ResponseBody
	public Page<XTestClob> searchJsonDocuments(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return xTestClobRepo.findAll(RevmantraUtils.fetchSpecification(XTestClob.class, search), pageRequest);
	}

	@GetMapping(value = "/api/ayaraReportsSearch")
	@ResponseBody
	public Page<AyaraReports> searchAyaraReportsList(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return ayaraReportsRepo.findAll(RevmantraUtils.fetchSpecification(AyaraReports.class, search), pageRequest);
	}

	@GetMapping(value = "/api/rmanFunctionsSearch")
	@ResponseBody
	public Page<RmanFunctions> searchRmanFunctions(@RequestParam(value = "search") String search,
			@RequestParam(value = "allVals", required = false) String allVals,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		if (allVals != null) {
			pageRequest = PageRequest.of(0, 1000, Sort.by(Direction.ASC, "fid"));
		}
		Pageable paging = PageRequest.of(pageRequest.getPageNumber(), pageRequest.getPageSize(),
				Sort.by(Direction.ASC, "fid"));
		return rmanFunctionsRepo.findAll(RevmantraUtils.fetchSpecification(RmanFunctions.class, search), paging);
	}

	@GetMapping(value = "/api/rmanRoleFunctionsSearch")
	@ResponseBody
	public Page<RmanRoleFunctions> searchRmanRoleFunctions(@RequestParam(value = "search") String search,
			@RequestParam(value = "allVals", required = false) String allVals,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {

		if (allVals != null) {
			pageRequest = PageRequest.of(0, 1000, Sort.by(Direction.ASC, "rfid"));
		}
		Pageable paging = PageRequest.of(pageRequest.getPageNumber(), pageRequest.getPageSize(),
				Sort.by(Direction.ASC, "rfid"));
		return rmanRoleFunctionsRepo.findAll(RevmantraUtils.fetchSpecification(RmanRoleFunctions.class, search),
				paging);
	}

	@GetMapping(value = "/api/rmanDealUsagesSummarySearch")
	@ResponseBody
	public Page<RmanDealUsagesSummary> searchRmanDealUsagesSummary(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return rmanDealUsagesSummaryRepo.findAll(RevmantraUtils.fetchSpecification(RmanDealUsagesSummary.class, search),
				pageRequest);
	}

	@GetMapping(value = "/api/rmanConversionRatesIntSearch")
	@ResponseBody
	public Page<RmanConversionRatesInt> searchRmanConversionRatesInt(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return rmanConversionRatesIntRepo
				.findAll(RevmantraUtils.fetchSpecification(RmanConversionRatesInt.class, search), pageRequest);
	}

	@GetMapping(value = "/api/rmanOpenDealArrangementsVSearch")
	@ResponseBody
	public Page<RmanOpenDealArrangements> searchRmanOpenDealArrangements(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return rmanOpenDealArrangementsRepo
				.findAll(RevmantraUtils.fetchSpecification(RmanOpenDealArrangements.class, search), pageRequest);

	}

	@GetMapping(value = "/api/rmanFileUploadJobsSearch")
	@ResponseBody
	public Page<RmanFileUploadJobs> searchRmanFileUploadJobs(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		Pageable paging = PageRequest.of(pageRequest.getPageNumber(), pageRequest.getPageSize(),
				Sort.by(Direction.DESC, CONSTANTS.START_DATE));
		return rmanFileUploadJobsRepo.findAll(RevmantraUtils.fetchSpecification(RmanFileUploadJobs.class, search),
				paging);

	}

	@GetMapping(value = "/api/rmanGlAccountsInterfaceSearch")
	@ResponseBody
	public Page<RmanGlAccountsInterface> searchRmanGlAccountsInterface(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return rmanGlAccountsInterfaceRepo
				.findAll(RevmantraUtils.fetchSpecification(RmanGlAccountsInterface.class, search), pageRequest);
	}

	@GetMapping(value = "/api/sspRulesInterfaceSearch")
	@ResponseBody
	public Page<SspRulesInterface> searchSspRulesInterface(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return sspRulesInterfaceRepo.findAll(RevmantraUtils.fetchSpecification(SspRulesInterface.class, search),
				pageRequest);
	}

	@GetMapping(value = "/api/rmanProductsInterfaceSearch")
	@ResponseBody
	public Page<RmanProductsInterface> searchRmanProductsInterface(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return rmanProductsInterfaceRepo.findAll(RevmantraUtils.fetchSpecification(RmanProductsInterface.class, search),
				pageRequest);
	}

	@GetMapping(value = "/api/rmanCustomersInterfaceSearch")
	@ResponseBody
	public Page<RmanCustomersInterface> searchRmanCustomersInterface(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return rmanCustomersInterfaceRepo
				.findAll(RevmantraUtils.fetchSpecification(RmanCustomersInterface.class, search), pageRequest);
	}

	@GetMapping(value = "/api/rmanOrdersAuditVSearch")
	@ResponseBody
	public Page<RmanOrdersAuditV> searchRmanOrdersAuditV(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return rmanOrdersAuditVRepo.findAll(RevmantraUtils.fetchSpecification(RmanOrdersAuditV.class, search),
				pageRequest);
	}

	@Autowired
	private RmanConversionRatesRepository rmanConversionRatesRepo;

	@GetMapping(value = "/api/rmanConversionRatesSearch")
	@ResponseBody
	public Page<RmanConversionRates> searchRmanConversionRates(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return rmanConversionRatesRepo.findAll(RevmantraUtils.fetchSpecification(RmanConversionRates.class, search),
				pageRequest);
	}

	@GetMapping(value = "/api/rmanConversionRatesExport", produces = "application/vnd.ms-excel")
	@ResponseBody
	public String exportRmanConversionRates(@RequestParam(value = "search") String search,
			@RequestParam(value = "exportCols", required = false) List<String> columns,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest, HttpServletResponse response) {
		response.setHeader(CONSTANTS.CONTENT_DISPOSITION, "inline; filename=Rman_Conversion_Rates.csv");

		List<RmanConversionRates> convRatesList = rmanConversionRatesRepo
				.findAll(RevmantraUtils.fetchSpecification(RmanConversionRates.class, search));
		CsvMapper mapper = new CsvMapper();
		mapper.setDateFormat(new SimpleDateFormat(CONSTANTS.MM_DD_YYYY));
		mapper.enable(JsonGenerator.Feature.IGNORE_UNKNOWN);

		CsvSchema schema = null;
		List<String> line1 = new ArrayList<>();

		if (columns != null) {
			com.fasterxml.jackson.dataformat.csv.CsvSchema.Builder schemaBuilder = CsvSchema.builder()
					.setColumnSeparator(',');
			for (String column : columns) {
				schemaBuilder.addColumn(column);
				line1.add(ExportColumns.conversionRatesFields.get(column));
			}
			schema = schemaBuilder.setUseHeader(false).build();
		}

		ObjectWriter objectWriter = mapper.writer(schema);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		try {
			objectWriter.writeValue(baos, line1);
		} catch (JsonGenerationException jge) {
			logger.error(jge);
		} catch (JsonMappingException jme) {
			logger.error(jme);
		} catch (IOException ioe) {
			logger.error(ioe);
		}

		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(baos, 1024);
		OutputStreamWriter writerOutputStream;
		try {
			writerOutputStream = new OutputStreamWriter(bufferedOutputStream, StandardCharsets.UTF_8);
			objectWriter.writeValue(writerOutputStream, convRatesList);
			writerOutputStream.close();
		} catch (UnsupportedEncodingException uee) {
			logger.error(uee);
		} catch (JsonGenerationException jge) {
			logger.error(jge);
		} catch (JsonMappingException jme) {
			logger.error(jme);
		} catch (IOException ioe) {
			logger.error(ioe);
		}

		String csvData = baos.toString();
		try {
			baos.close();
		} catch (IOException ioe) {
			logger.error(ioe);
		}
		return csvData;

	}

	@GetMapping(value = { "/api/rmanInvoiceLinesVSearch", "/api/sfqi/rmanInvoiceLinesVSearch" })
	@ResponseBody
	public Page<RmanInvoiceLinesV> searchRmanInvoiceLinesV(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return rmanInvoiceLinesVRepo.findAll(RevmantraUtils.fetchSpecification(RmanInvoiceLinesV.class, search),
				pageRequest);
	}

	@GetMapping(value = { "/api/rmanInvoiceHeadersVSearch", "/api/sfqi/rmanInvoiceHeadersVSearch" })
	@ResponseBody
	public Page<RmanInvoiceHeadersV> searchRmanInvoiceHeadersV(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return rmanInvoiceHeadersVRepo.findAll(RevmantraUtils.fetchSpecification(RmanInvoiceHeadersV.class, search),
				pageRequest);
	}

	@GetMapping(value = "/api/rmanInvoiceHeadersVExport", produces = "application/vnd.ms-excel")
	@ResponseBody
	public String exportRmanInvoiceHeadersV(@RequestParam(value = "search") String search,
			@RequestParam(value = "exportCols", required = false) List<String> columns,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest, HttpServletResponse response) {
		response.setHeader(CONSTANTS.CONTENT_DISPOSITION, "inline; filename=Rman_Invoice_Headers.csv");
		List<RmanInvoiceHeadersV> invHeadersList = rmanInvoiceHeadersVRepo
				.findAll(RevmantraUtils.fetchSpecification(RmanInvoiceHeadersV.class, search));
		CsvMapper mapper = new CsvMapper();
		mapper.setDateFormat(new SimpleDateFormat(CONSTANTS.MM_DD_YYYY));
		mapper.enable(JsonGenerator.Feature.IGNORE_UNKNOWN);
		CsvSchema schema = null;
		List<String> line1 = new ArrayList<>();

		if (columns != null) {
			com.fasterxml.jackson.dataformat.csv.CsvSchema.Builder schemaBuilder = CsvSchema.builder()
					.setColumnSeparator(',').addColumn(CONSTANTS.ARRANGEMENTID);
			line1.add(CONSTANTS.REVENUE_CONTRACT_NUMBER);
			for (String column : columns) {
				schemaBuilder.addColumn(column);
				line1.add(ExportColumns.invoiceHeadersFields.get(column));
			}
			schema = schemaBuilder.setUseHeader(false).build();
		}

		ObjectWriter objectWriter = mapper.writer(schema);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		try {
			objectWriter.writeValue(baos, line1);
		} catch (JsonGenerationException jge) {
			logger.error(jge);
		} catch (JsonMappingException jme) {
			logger.error(jme);
		} catch (IOException ioe) {
			logger.error(ioe);
		}

		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(baos, 1024);
		OutputStreamWriter writerOutputStream;
		try {
			writerOutputStream = new OutputStreamWriter(bufferedOutputStream, StandardCharsets.UTF_8);
			objectWriter.writeValue(writerOutputStream, invHeadersList);
			writerOutputStream.close();
		} catch (UnsupportedEncodingException uee) {
			logger.error(uee);
		} catch (JsonGenerationException jge) {
			logger.error(jge);
		} catch (JsonMappingException jme) {
			logger.error(jme);
		} catch (IOException ioe) {
			logger.error(ioe);
		}
		String csvData = baos.toString();
		try {
			baos.close();
		} catch (IOException ioe) {
			logger.error(ioe);
		}
		return csvData;
	}

	@GetMapping(value = "/api/rmanInvoiceLinesVExport", produces = "application/vnd.ms-excel")
	@ResponseBody
	public String exportRmanInoviceLines(@RequestParam(value = "search") String search,
			@RequestParam(value = "exportCols", required = false) List<String> columns,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest, HttpServletResponse response) {
		response.setHeader(CONSTANTS.CONTENT_DISPOSITION, "inline; filename=RMAN_Invoice_Lines.csv");
		OutputStreamWriter writerOutputStream = null;

		Page<RmanInvoiceHeadersV> page = null;
		page = rmanInvoiceHeadersVRepo.findAll(RevmantraUtils.fetchSpecification(RmanInvoiceHeadersV.class, search),
				pageRequest);
		CsvMapper mapper = new CsvMapper();
		mapper.setDateFormat(new SimpleDateFormat(CONSTANTS.MM_DD_YYYY));
		mapper.enable(JsonGenerator.Feature.IGNORE_UNKNOWN);
		CsvSchema schema = CsvSchema.builder().setColumnSeparator(',').addColumn(CONSTANTS.ARRANGEMENTID)
				.addColumn("invoiceNumber").addColumn("invoicedDate").addColumn("invoiceType")
				.addColumn("invoiceTrxType").addColumn(CONSTANTS.FX_RATE).addColumn(CONSTANTS.FX_DATE)
				.addColumn("invoiceCurrency").addColumn("acctdCurrency").addColumn("salesOrderNumber")
				.addColumn("invoiceSource").addColumn("invoiceAmount").setUseHeader(false).build();
		ObjectWriter objectWriter = mapper.writer(schema);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		List<String> line1 = new ArrayList<>();
		line1.add(CONSTANTS.REVENUE_CONTRACT_NUMBER);
		line1.add("Invoice Number");
		line1.add("Invoiced Date");
		line1.add("Invoice Type");
		line1.add("InvoiceTrx Type");
		line1.add("Fx Rate");
		line1.add("Fx Date");
		line1.add("Invoice Currency");
		line1.add("Functional Currency");
		line1.add("SO#");
		line1.add("Invoice Source");
		line1.add("Invoice Amount");

		try {
			objectWriter.writeValue(baos, line1);
		} catch (JsonGenerationException jge) {
			logger.error(jge);
		} catch (JsonMappingException jme) {
			logger.error(jme);
		} catch (IOException ioe) {
			logger.error(ioe);
		}

		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(baos, 1024);
		try {
			writerOutputStream = new OutputStreamWriter(bufferedOutputStream, StandardCharsets.UTF_8);
			objectWriter.writeValue(writerOutputStream, page.getContent());
			writerOutputStream.close();
		} catch (UnsupportedEncodingException uee) {
			logger.error(uee);
		} catch (JsonGenerationException jge) {
			logger.error(jge);
		} catch (JsonMappingException jme) {
			logger.error(jme);
		} catch (IOException ioe) {
			logger.error(ioe);
		}
		String csvData = baos.toString();

		List<RmanInvoiceLinesV> invLinesList = rmanInvoiceLinesVRepo
				.findAll(RevmantraUtils.fetchSpecification(RmanInvoiceLinesV.class, search));
		mapper = new CsvMapper();
		mapper.setDateFormat(new SimpleDateFormat(CONSTANTS.MM_DD_YYYY));
		mapper.enable(JsonGenerator.Feature.IGNORE_UNKNOWN);
		List<String> line2 = new ArrayList<>();

		if (columns != null) {
			com.fasterxml.jackson.dataformat.csv.CsvSchema.Builder schemaBuilder = CsvSchema.builder()
					.setColumnSeparator(',').addColumn(CONSTANTS.ARRANGEMENTID);
			line2.add(CONSTANTS.REVENUE_CONTRACT_NUMBER);
			for (String column : columns) {
				schemaBuilder.addColumn(column);
				line2.add(ExportColumns.invoiceLinesFields.get(column));
			}
			schema = schemaBuilder.setUseHeader(false).build();
		}

		objectWriter = mapper.writer(schema);
		try {
			baos.write("\n\n".getBytes());
			objectWriter.writeValue(baos, line2);
			writerOutputStream = new OutputStreamWriter(bufferedOutputStream, StandardCharsets.UTF_8);
			objectWriter.writeValue(writerOutputStream, invLinesList);
			writerOutputStream.close();
			csvData = baos.toString();
			baos.close();
		} catch (UnsupportedEncodingException uee) {
			logger.error(uee);
		} catch (JsonGenerationException jge) {
			logger.error(jge);
		} catch (JsonMappingException jme) {
			logger.error(jme);
		} catch (IOException ioe) {
			logger.error(ioe);
		}

		return csvData;

	}

	@GetMapping(value = "/api/rmanInvoicesStgSearch")
	@ResponseBody
	public Page<RmanInvoicesStg> searchRmanInvoicesStg(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {

		return rmanInvoicesStgRepo.findAll(RevmantraUtils.fetchSpecification(RmanInvoicesStg.class, search),
				pageRequest);
	}

	@GetMapping(value = "/api/rmanArrgWaterfallReportNvSearch")
	@ResponseBody
	public Page<RmanArrgWaterfallReportNv> searchRmanArrgWaterfallReportNv(
			@RequestParam(value = "search") String search, @PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		rmanConcurrentProgramsDAO.waterFallReportParams("Jan-18", "Feb-19", 21);
		return rmanArrgWaterfallReportNvRepo.findAll(
				RevmantraUtils.fetchSpecification(RmanArrgWaterfallReportNv.class, search),
				PageRequest.of(0, Integer.MAX_VALUE));
	}

	@GetMapping(value = "/api/rmanGlAccountsSearch")
	@ResponseBody
	public Page<RmanGlAccounts> searchRmanGlAccounts(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return rmanGlAccountsRepo.findAll(RevmantraUtils.fetchSpecification(RmanGlAccounts.class, search), pageRequest);
	}

	@GetMapping(value = { "/api/rmanArrgLineOfBusinessVSearch", "/api/sfqi/rmanArrgLineOfBusinessVSearch" })
	@ResponseBody
	public Page<RmanArrgLineOfBusinessV> searchRmanArrgLineOfBusinessV(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return rmanArrgLineOfBusinessVRepo
				.findAll(RevmantraUtils.fetchSpecification(RmanArrgLineOfBusinessV.class, search), pageRequest);
	}

	@GetMapping(value = { "/api/rmanArrangementTotalLevelsSearch", "/api/sfqi/rmanArrangementTotalLevelsSearch" })
	@ResponseBody
	public Page<RmanArrangementTotalLevels> searchRmanArrangementTotalLevels(
			@RequestParam(value = "search") String search, @PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return rmanArrangementTotalLevelsRepo
				.findAll(RevmantraUtils.fetchSpecification(RmanArrangementTotalLevels.class, search), pageRequest);
	}

	@GetMapping(value = { "/api/rmanArrgTotalsDateBasedVSearch", "/api/sfqi/rmanArrgTotalsDateBasedVSearch" })
	@ResponseBody
	public Page<RmanArrgTotalsDateBasedV> searchRmanArrgTotalsDateBasedV(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return rmanArrgTotalsDateBasedVRepo
				.findAll(RevmantraUtils.fetchSpecification(RmanArrgTotalsDateBasedV.class, search), pageRequest);
	}

	@GetMapping(value = { "/api/rmanRevDetailsVSearch", "/api/sfqi/rmanRevDetailsVSearch" })
	@ResponseBody
	public Page<RmanRevDetailsV> searchRmanRevDetailsV(/*
														 * @RequestParam(value = "search") String search,
														 */
			@RequestParam(value = "arrgId") BigDecimal pArrgId, @RequestParam(value = "so") BigDecimal pso,
			@RequestParam(value = "soLine") String pSoLine, @RequestParam(value = "revType") String pRevType,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		List<Object[]> revsList = null;

		if (pso != null && pSoLine != null) {
			revsList = rmanRevDetailsVRepo.listOfRevDetials4(pArrgId, pso, pSoLine, pRevType);
		} else if (pso != null) {
			revsList = rmanRevDetailsVRepo.listOfRevDetials2(pArrgId, pso, pRevType);
		} else if (pSoLine != null) {
			revsList = rmanRevDetailsVRepo.listOfRevDetials3(pArrgId, pSoLine, pRevType);
		} else {
			revsList = rmanRevDetailsVRepo.listOfRevDetials1(pArrgId, pRevType);
		}

		List<RmanRevDetailsV> xRevDeatils = revsList.stream().map(externalToMyLocationFunc)
				.collect(Collectors.<RmanRevDetailsV>toList());
		int startIndex = (int) pageRequest.getOffset();
		int endIndex = (int) ((pageRequest.getOffset() + pageRequest.getPageSize()) > revsList.size() ? revsList.size()
				: pageRequest.getOffset() + pageRequest.getPageSize());
		List<RmanRevDetailsV> subList = xRevDeatils.subList(startIndex, endIndex);
		return new PageImpl<>(subList, pageRequest, xRevDeatils.size());
	}

	@GetMapping(value = "/api/rmanRevDetailsVExport", produces = "application/vnd.ms-excel")
	@ResponseBody
	public String exportRmanRevDetailsV(/*
										 * @RequestParam(value = "search") String search,
										 */
			@RequestParam(value = "arrgId") BigDecimal pArrgId, @RequestParam(value = "so") BigDecimal pso,
			@RequestParam(value = "soLine") String pSoLine, @RequestParam(value = "revType") String pRevType,
			@RequestParam(value = "exportCols", required = false) List<String> columns,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest, HttpServletResponse response) {
		response.setHeader(CONSTANTS.CONTENT_DISPOSITION, "inline; filename=RmanRevDetailsV.csv");
		List<Object[]> revsList = null;

		if (pso != null && pSoLine != null) {
			revsList = rmanRevDetailsVRepo.listOfRevDetials4(pArrgId, pso, pSoLine, pRevType);
		} else if (pso != null) {
			revsList = rmanRevDetailsVRepo.listOfRevDetials2(pArrgId, pso, pRevType);
		} else if (pSoLine != null) {
			revsList = rmanRevDetailsVRepo.listOfRevDetials3(pArrgId, pSoLine, pRevType);
		} else {
			revsList = rmanRevDetailsVRepo.listOfRevDetials1(pArrgId, pRevType);
		}
		List<RmanRevDetailsV> xRevDeatils = revsList.stream().map(externalToMyLocationFunc)
				.collect(Collectors.<RmanRevDetailsV>toList());
		PageRequest prequest = PageRequest.of(0, Integer.MAX_VALUE);
		Page<RmanRevDetailsV> page = new PageImpl<>(xRevDeatils, prequest, xRevDeatils.size());

		CsvMapper mapper = new CsvMapper();
		mapper.setDateFormat(new SimpleDateFormat(CONSTANTS.MM_DD_YYYY));
		mapper.enable(JsonGenerator.Feature.IGNORE_UNKNOWN);
		CsvSchema schema = null;
		List<String> line1 = new ArrayList<>();

		if (columns != null) {
			com.fasterxml.jackson.dataformat.csv.CsvSchema.Builder schemaBuilder = CsvSchema.builder()
					.setColumnSeparator(',').addColumn(CONSTANTS.DEAL_ARRANGEMENT_ID);
			line1.add(CONSTANTS.REVENUE_CONTRACT_NUMBER);
			for (String column : columns) {
				schemaBuilder.addColumn(column);
				line1.add(ExportColumns.revenueFields.get(column));
			}
			schema = schemaBuilder.setUseHeader(false).build();
		}

		ObjectWriter objectWriter = mapper.writer(schema);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		try {
			objectWriter.writeValue(baos, line1);
		} catch (JsonGenerationException jge) {
			logger.error(jge);
		} catch (JsonMappingException jme) {
			logger.error(jme);
		} catch (IOException ioe) {
			logger.error(ioe);
		}

		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(baos, 1024);
		OutputStreamWriter writerOutputStream;
		try {
			writerOutputStream = new OutputStreamWriter(bufferedOutputStream, StandardCharsets.UTF_8);
			objectWriter.writeValue(writerOutputStream, page.getContent());
			writerOutputStream.close();
		} catch (UnsupportedEncodingException uee) {
			logger.error(uee);
		} catch (JsonGenerationException jge) {
			logger.error(jge);
		} catch (JsonMappingException jme) {
			logger.error(jme);
		} catch (IOException ioe) {
			logger.error(ioe);
		}

		String csvData = baos.toString();
		try {
			baos.close();
		} catch (IOException ioe) {
			logger.error(ioe);
		}
		return csvData;
	}

	@GetMapping(value = "/api/rmanPobMappingSearch")
	@ResponseBody
	public Page<RmanPobMapping> searchRmanPobMapping(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return rmanPobMappingRepo.findAll(RevmantraUtils.fetchSpecification(RmanPobMapping.class, search), pageRequest);
	}

	@GetMapping(value = "/api/rmanArrangementsAllVSearch")
	@ResponseBody
	public Page<RmanArrangementsAllV> searchRmanArrangementsAllV(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10, sort = "creationDate", direction = Sort.Direction.DESC) Pageable pageRequest) {
		return rmanArrangementsAllVRepo.findAll(RevmantraUtils.fetchSpecification(RmanArrangementsAllV.class, search),
				pageRequest);
	}

	@GetMapping(value = { "/api/rmanArrangementsAllVCommonSearch", "/api/sfqi/rmanArrangementsAllVCommonSearch" })
	@ResponseBody
	public Page<RmanArrangementsAllV> rmanArrangementsAllVLocalSearch(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return rmanArrangementsAllVRepo.findAll(RevmantraUtils.fetchSpecification(RmanArrangementsAllV.class, search),
				pageRequest);
	}

	@GetMapping(value = "/api/rmanArrangementsAllVExport", produces = "application/vnd.ms-excel")
	@ResponseBody
	public String exportRmanArrangementsAllV(@RequestParam(value = "search") String search,
			@RequestParam(value = "exportCols", required = false) List<String> columns,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest, HttpServletResponse response) {
		response.setHeader(CONSTANTS.CONTENT_DISPOSITION, "inline; filename=RmanArrangementsAllV.csv");
		List<RmanArrangementsAllV> arrgsList = rmanArrangementsAllVRepo
				.findAll(RevmantraUtils.fetchSpecification(RmanArrangementsAllV.class, search));
		CsvMapper mapper = new CsvMapper();
		mapper.setDateFormat(new SimpleDateFormat(CONSTANTS.MM_DD_YYYY));
		mapper.enable(JsonGenerator.Feature.IGNORE_UNKNOWN);
		List<String> line1 = new ArrayList<>();
		CsvSchema schema = null;
		com.fasterxml.jackson.dataformat.csv.CsvSchema.Builder schemaBuilder = CsvSchema.builder()
				.setColumnSeparator(',');
		if (columns != null) {
			for (String column : columns) {
				schemaBuilder.addColumn(column);
				line1.add(ExportColumns.arrangementsFields.get(column));
			}
			schema = schemaBuilder.setUseHeader(false).build();
		}

		ObjectWriter objectWriter = mapper.writer(schema);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			objectWriter.writeValue(baos, line1);
		} catch (JsonGenerationException jge) {
			logger.error(jge);
		} catch (JsonMappingException jme) {
			logger.error(jme);
		} catch (IOException ioe) {
			logger.error(ioe);
		}
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(baos, 1024);
		OutputStreamWriter writerOutputStream;
		try {
			writerOutputStream = new OutputStreamWriter(bufferedOutputStream, StandardCharsets.UTF_8);
			objectWriter.writeValue(writerOutputStream, arrgsList);
			writerOutputStream.close();
		} catch (UnsupportedEncodingException uee) {
			logger.error(uee);
		} catch (JsonGenerationException jge) {
			logger.error(jge);
		} catch (JsonMappingException jme) {
			logger.error(jme);
		} catch (IOException ioe) {
			logger.error(ioe);
		}
		String csvData = baos.toString();
		try {
			baos.close();
		} catch (IOException ioe) {
			logger.error(ioe);
		}
		return csvData;
	}

	@PostMapping(value = "/api/saveRmanDealDetails")
	@ResponseBody
	public RmanDealDetails saveRmanDealDetails(@RequestBody RmanDealDetails rmanDealDetails) {
		try {
			RmanDealArrangements rmanDealArrangements = rmanDealArrangementsRepo
					.findByDealArrangementId(rmanDealDetails.getDealArrangementId());
			Integer arrgLineNo = rmanDealArrangements.getAttribute28() != null
					? Integer.valueOf(rmanDealArrangements.getAttribute28()) + 1
					: Integer.valueOf(1);
			rmanDealDetails.setAttribute10(String.valueOf(arrgLineNo));
			rmanDealDetailsRepo.save(rmanDealDetails);
			rmanDealArrangements.setAttribute28(String.valueOf(arrgLineNo));
			rmanDealArrangementsRepo.saveAndFlush(rmanDealArrangements);
			return rmanDealDetails;
		} catch (Exception e) {
			logger.error("Getting Error while Saving the Deal Line due to {}", e.getMessage());
			return null;
		}
	}

	@GetMapping(value = "/api/rmanLookupTypesSearch")
	@ResponseBody
	public Page<RmanLookupTypes> searchRmanLookupTypes(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return rmanLookupTypesRepo.findAll(RevmantraUtils.fetchSpecification(RmanLookupTypes.class, search),
				pageRequest);
	}

	@GetMapping(value = "/api/rmanLookupCodesSearch")
	@ResponseBody
	public Page<RmanLookupCodes> searchRmanLookupCodes(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return rmanLookupCodesRepo.findAll(RevmantraUtils.fetchSpecification(RmanLookupCodes.class, search),
				pageRequest);
	}

	@GetMapping(value = "/api/rmanCustomersSearch")
	@ResponseBody
	public Page<RmanCustomers> searchRmanCustomers(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest,
			@RequestParam(value = "fetchAll", required = false) boolean fetchAll) {
		return rmanCustomersRepo.findAll(RevmantraUtils.fetchSpecification(RmanCustomers.class, search),
				!fetchAll ? pageRequest : PageRequest.of(0, Integer.MAX_VALUE));
	}

	@GetMapping(value = "/api/rmanProductsSearch")
	@ResponseBody
	public Page<RmanProducts> searchRmanProducts(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest,
			@RequestParam(value = "fetchAll", required = false) boolean fetchAll) {
		return rmanProductsRepo.findAll(RevmantraUtils.fetchSpecification(RmanProducts.class, search),
				!fetchAll ? pageRequest : PageRequest.of(0, Integer.MAX_VALUE));
	}

	@GetMapping(value = "/api/rmanFmvRulesDefSearch")
	@ResponseBody
	public Page<RmanFmvRulesDef> searchRmanFmvRulesDef(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return rmanFmvRulesDefRepo.findAll(RevmantraUtils.fetchSpecification(RmanFmvRulesDef.class, search),
				pageRequest);
	}

	@GetMapping(value = "/api/rmanLookupsVSearch")
	@ResponseBody
	public Page<RmanLookupsV> searchRmanLookupsV(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return rmanLookupsVRepo.findAll(RevmantraUtils.fetchSpecification(RmanLookupsV.class, search),
				PageRequest.of(0, Integer.MAX_VALUE));
	}

	@GetMapping(value = "/api/rmanCurrencySearch")
	@ResponseBody
	public Page<RmanCurrency> searchRmanCurrency(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return rmanCurrencyRepo.findAll(RevmantraUtils.fetchSpecification(RmanCurrency.class, search), pageRequest);
	}

	@GetMapping(value = "/api/rmanFmvRulesDefParaValueSearch")
	@ResponseBody
	public Page<RmanFmvRulesDefParaValue> searchRmanFmvRulesDefParaValue(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return rmanFmvRulesDefParaValueRepo
				.findAll(RevmantraUtils.fetchSpecification(RmanFmvRulesDefParaValue.class, search), pageRequest);
	}

	@GetMapping(value = "/api/rmanLegalEntitiesSearch")
	@ResponseBody
	public Page<RmanLegalEntities> searchRmanLegalEntities(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest,
			@RequestParam(value = "fetchAll", defaultValue = "N") String fetchAll) {
		return rmanLegalEntitiesRepo.findAll(RevmantraUtils.fetchSpecification(RmanLegalEntities.class, search),
				fetchAll.equals("Y") ? PageRequest.of(0, Integer.MAX_VALUE) : pageRequest);
	}

	@GetMapping(value = "/api/rmanRulesHeaderSearch")
	@ResponseBody
	public Page<RmanRulesHeader> searchRmanRulesHeader(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return rmanRulesHeaderRepo.findAll(RevmantraUtils.fetchSpecification(RmanRulesHeader.class, search),
				pageRequest);
	}

	@GetMapping(value = "/api/rmanUsersSearch")
	@ResponseBody
	public Page<RmanUsers> searchRmanUsers(@RequestParam(value = "search") String search,
			@RequestParam(value = "fetchAll", required = false) boolean fetchAll,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return rmanUsersRepo.findAll(RevmantraUtils.fetchSpecification(RmanUsers.class, search),
				!fetchAll ? pageRequest : PageRequest.of(0, Integer.MAX_VALUE));
	}

	@GetMapping(value = "/api/sspBooksSearch")
	@ResponseBody
	public Page<SSPBooks> searchSSPBooks(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return sspBooksRepo.findAll(RevmantraUtils.fetchSpecification(SSPBooks.class, search), pageRequest);
	}

	@PostMapping(value = "/api/AYARA_SSP_BOOKS")
	@ResponseBody
	public SSPBooks saveSSPBook(@RequestBody SSPBooks sspBook) {
		return saveUpdateSspBook(sspBook);
	}

	@PutMapping(value = "/api/AYARA_SSP_BOOKS/{bookId}")
	@ResponseBody
	public SSPBooks updateSSPBook(@RequestBody SSPBooks sspBook, @PathVariable("bookId") BigDecimal bookId) {
		return saveUpdateSspBook(sspBook);
	}

	@DeleteMapping(value = "/api/AYARA_SSP_BOOKS/{bookId}")
	@ResponseBody
	public void deleteSSPBook(@PathVariable("bookId") BigDecimal bookId) {
		Optional<SSPBooks> book = sspBooksRepo.findById(bookId);
		if (book.isPresent()) {
			sspBooksRepo.deleteById(book.get().getBookId());
		}
	}

	private SSPBooks saveUpdateSspBook(SSPBooks sspBook) {
		List<SSPBooks> books = sspBooksRepo.findByBookName(sspBook.getBookName());
		if (books.isEmpty()) {
			return sspBooksRepo.save(sspBook);
		} else {
			if (!sspBook.getStatus().equalsIgnoreCase(books.get(0).getStatus())) {
				if (sspBook.getStatus().equalsIgnoreCase("ACTIVE")) {
					List<SSPBooks> bookList = sspBooksRepo.findByStatus(sspBook.getStatus());
					if (!bookList.isEmpty()) {
						throw new AyaraCustomException(
								"More than one SSP Book can not be Active and Current Active Book Name is : "
										+ bookList.get(0).getBookName());
					}
				}
				return sspBooksRepo.save(sspBook);
			} else {
				throw new AyaraCustomException("SSP Book is already present with same Date Ranges and Book Name is : "
						+ books.get(0).getBookName());
			}
		}
	}

	@GetMapping(value = "/api/rmanRuleParameterValueSearch")
	@ResponseBody
	public Page<RmanRuleParameterValue> searchRmanRuleParameterValue(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return rmanRuleParameterValueRepo
				.findAll(RevmantraUtils.fetchSpecification(RmanRuleParameterValue.class, search), pageRequest);
	}

	@GetMapping(value = "/api/rmanEntityParametersVSearch")
	@ResponseBody
	public Page<RmanEntityParametersV> searchRmanEntityParametersV(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest,
			@RequestParam(value = "fetchAll", defaultValue = "N") String fetchAll) {
		return rmanEntityParametersVRepo.findAll(RevmantraUtils.fetchSpecification(RmanEntityParametersV.class, search),
				fetchAll.equals("Y") ? PageRequest.of(0, Integer.MAX_VALUE) : pageRequest);
	}

	@GetMapping(value = "/api/rmanEntityParametersSearch")
	@ResponseBody
	public Page<RmanEntityParameters> searchRmanEntityParameters(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return rmanEntityParametersRepo.findAll(RevmantraUtils.fetchSpecification(RmanEntityParameters.class, search),
				pageRequest);
	}

	@GetMapping(value = "/api/rmanEntitiesSearch")
	@ResponseBody
	public Page<RmanEntities> searchRmanEntities(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return rmanEntitiesRepo.findAll(RevmantraUtils.fetchSpecification(RmanEntities.class, search), pageRequest);
	}

	@GetMapping(value = "/api/rmanContHeaderSearch")
	@ResponseBody
	public Page<RmanContHeader> searchRmanContHeader(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return rmanContHeaderRepo.findAll(RevmantraUtils.fetchSpecification(RmanContHeader.class, search), pageRequest);
	}

	@GetMapping(value = "/api/rmanContTemplateSearch")
	@ResponseBody
	public Page<RmanContTemplate> searchRmanContTemplate(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest,
			@RequestParam(value = "fetchAll", defaultValue = "N") String fetchAll) {
		return rmanContTemplateRepo.findAll(RevmantraUtils.fetchSpecification(RmanContTemplate.class, search),
				fetchAll.equals("Y") ? PageRequest.of(0, Integer.MAX_VALUE) : pageRequest);
	}

	@GetMapping(value = "/api/rmanFiscalPeriodsSearch")
	@ResponseBody
	public Page<RmanFiscalPeriods> searchRmanFiscalPeriods(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return rmanFiscalPeriodsRepo.findAll(RevmantraUtils.fetchSpecification(RmanFiscalPeriods.class, search),
				pageRequest);
	}

	@GetMapping(value = "/api/rmanResponsibilitiesSearch")
	@ResponseBody
	public Page<RmanResponsibilities> searchRmanResponsibilities(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return rmanResponsibilitiesRepo.findAll(RevmantraUtils.fetchSpecification(RmanResponsibilities.class, search),
				pageRequest);
	}

	@GetMapping(value = "/api/rmanUserResponsibilitiesSearch")
	@ResponseBody
	public Page<RmanUserResponsibilities> searchRmanUserResponsibilities(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return rmanUserResponsibilitiesRepo
				.findAll(RevmantraUtils.fetchSpecification(RmanUserResponsibilities.class, search), pageRequest);
	}

	@GetMapping(value = "/api/allTabColumnsSearch")
	@ResponseBody
	public Page<AllTabColumns> searchAllTabColumns(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return allTabColumnsRepo.findAll(RevmantraUtils.fetchSpecification(AllTabColumns.class, search), pageRequest);
	}

	@GetMapping(value = { "/api/rmanDealArrangementsSearch", "/api/sfqi/rmanDealArrangementsSearch" })
	@ResponseBody
	public Page<RmanDealArrangements> searchRmanDealArrangements(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return rmanDealArrangementsRepo.findAll(RevmantraUtils.fetchSpecification(RmanDealArrangements.class, search),
				pageRequest);

	}

	@GetMapping(value = "/api/getDealArrangementBasis")
	@ResponseBody
	public String getDealArrangementBasis(@RequestParam(value = "arrgId") String arrgId) {
		return rmanDealArrangementsRepo.getByDealArrangementId(new BigDecimal(arrgId));
	}

	@GetMapping(value = { "/api/arrgContractAllocationsVSearch", "/api/sfqi/arrgContractAllocationsVSearch" })
	@ResponseBody
	public Page<ArrgContractAllocationsV> searchArrgContractAllocationsV(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return arrgContractAllocationsVRepo
				.findAll(RevmantraUtils.fetchSpecification(ArrgContractAllocationsV.class, search), pageRequest);

	}

	@GetMapping(value = "/api/arrgContractAllocationsVExport", produces = "application/vnd.ms-excel")
	@ResponseBody
	public String exportArrgContractAllocationsV(@RequestParam(value = "search") String search,
			@RequestParam(value = "exportCols", required = false) List<String> columns,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest, HttpServletResponse response,
			@RequestParam(value = "quoteOrderSwitch") boolean quoteOrderSwitch) {
		response.setHeader(CONSTANTS.CONTENT_DISPOSITION, "inline; filename=ArrgContractAllocationsV.csv");
		List<?> allocList = null;
		if (!quoteOrderSwitch) {
			response.setHeader(CONSTANTS.CONTENT_DISPOSITION, "inline; filename=ArrgContractAllocationsV.csv");
			allocList = arrgContractAllocationsVRepo
					.findAll(RevmantraUtils.fetchSpecification(ArrgContractAllocationsV.class, search));
		} else {
			response.setHeader(CONSTANTS.CONTENT_DISPOSITION, "inline; filename=ArrgOrderAllocationsV.csv");
			allocList = arrgOrderAllocationsVRepo
					.findAll(RevmantraUtils.fetchSpecification(ArrgOrderAllocationsV.class, search));
		}

		CsvMapper mapper = new CsvMapper();
		mapper.setDateFormat(new SimpleDateFormat(CONSTANTS.MM_DD_YYYY));
		mapper.enable(JsonGenerator.Feature.IGNORE_UNKNOWN);
		CsvSchema schema = null;
		List<String> line1 = new ArrayList<>();
		if (columns != null) {
			com.fasterxml.jackson.dataformat.csv.CsvSchema.Builder schemaBuilder = CsvSchema.builder()
					.setColumnSeparator(',').addColumn(CONSTANTS.DEAL_ARRANGEMENT_ID);
			line1.add(CONSTANTS.REVENUE_CONTRACT_NUMBER);
			for (String column : columns) {
				schemaBuilder.addColumn(column);
				line1.add(ExportColumns.allocationsFields.get(column));
			}
			schema = schemaBuilder.setUseHeader(false).build();
		}

		ObjectWriter objectWriter = mapper.writer(schema);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		try {
			objectWriter.writeValue(baos, line1);
		} catch (JsonGenerationException jge) {
			logger.error(jge);
		} catch (JsonMappingException jme) {
			logger.error(jme);
		} catch (IOException ioe) {
			logger.error(ioe);
		}

		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(baos, 1024);
		OutputStreamWriter writerOutputStream;
		try {
			writerOutputStream = new OutputStreamWriter(bufferedOutputStream, StandardCharsets.UTF_8);
			objectWriter.writeValue(writerOutputStream, allocList);
			writerOutputStream.close();
		} catch (UnsupportedEncodingException uee) {
			logger.error(uee);
		} catch (JsonGenerationException jge) {
			logger.error(jge);
		} catch (JsonMappingException jme) {
			logger.error(jme);
		} catch (IOException ioe) {
			logger.error(ioe);
		}
		String csvData = baos.toString();
		try {
			baos.close();
		} catch (IOException ioe) {
			logger.error(ioe);
		}
		return csvData;
	}

	@GetMapping(value = { "/api/rmanOrderBookingsVSearch", "/api/sfqi/rmanOrderBookingsVSearch" })
	@ResponseBody
	public Page<RmanOrderBookingsV> searchRmanOrderBookingsV(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return rmanOrderBookingsVRepo.findAll(RevmantraUtils.fetchSpecification(RmanOrderBookingsV.class, search),
				pageRequest);

	}

	@GetMapping(value = "/api/rmanOrderBookingsVExport", produces = "application/vnd.ms-excel")
	@ResponseBody
	public String exportRmanOrderBookingsV(@RequestParam(value = "search") String search,
			@RequestParam(value = "exportCols", required = false) List<String> columns,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest, HttpServletResponse response) {
		response.setHeader(CONSTANTS.CONTENT_DISPOSITION, "inline; filename=RmanOrderBookingsV.csv");
		List<RmanOrderBookingsV> bkHeadersList = rmanOrderBookingsVRepo
				.findAll(RevmantraUtils.fetchSpecification(RmanOrderBookingsV.class, search));
		CsvMapper mapper = new CsvMapper();
		mapper.setDateFormat(new SimpleDateFormat(CONSTANTS.MM_DD_YYYY));
		mapper.enable(JsonGenerator.Feature.IGNORE_UNKNOWN);
		CsvSchema schema = null;
		List<String> line1 = new ArrayList<>();

		if (columns != null) {
			com.fasterxml.jackson.dataformat.csv.CsvSchema.Builder schemaBuilder = CsvSchema.builder()
					.setColumnSeparator(',').addColumn(CONSTANTS.ARRANGEMENTID);
			line1.add(CONSTANTS.REVENUE_CONTRACT_NUMBER);
			for (String column : columns) {
				schemaBuilder.addColumn(column);
				line1.add(ExportColumns.bookingsFields.get(column));
			}
			schema = schemaBuilder.setUseHeader(false).build();
		}

		ObjectWriter objectWriter = mapper.writer(schema);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		try {
			objectWriter.writeValue(baos, line1);
		} catch (JsonGenerationException jge) {
			logger.error(jge);
		} catch (JsonMappingException jme) {
			logger.error(jme);
		} catch (IOException ioe) {
			logger.error(ioe);
		}

		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(baos, 1024);
		OutputStreamWriter writerOutputStream;
		try {
			writerOutputStream = new OutputStreamWriter(bufferedOutputStream, StandardCharsets.UTF_8);
			objectWriter.writeValue(writerOutputStream, bkHeadersList);
			writerOutputStream.close();
		} catch (UnsupportedEncodingException uee) {
			logger.error(uee);
		} catch (JsonGenerationException jge) {
			logger.error(jge);
		} catch (JsonMappingException jme) {
			logger.error(jme);
		} catch (IOException ioe) {
			logger.error(ioe);
		}
		String csvData = baos.toString();
		try {
			baos.close();
		} catch (IOException ioe) {
			logger.error(ioe);
		}
		return csvData;
	}

	@GetMapping(value = { "/api/rmanOrderLinesBookingsVSearch", "/api/sfqi/rmanOrderLinesBookingsVSearch" })
	@ResponseBody
	public Page<RmanOrderLinesBookingsV> searchRmanOrderLinesBookingsV(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return rmanOrderLinesBookingsVRepo
				.findAll(RevmantraUtils.fetchSpecification(RmanOrderLinesBookingsV.class, search), pageRequest);

	}

	@GetMapping(value = "/api/rmanOrderLinesBookingsVExport", produces = "application/vnd.ms-excel")
	@ResponseBody
	public String exportRmanOrderLinesBookingsV(@RequestParam(value = "search") String search,
			@RequestParam(value = "exportCols", required = false) List<String> columns,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest, HttpServletResponse response) {
		response.setHeader(CONSTANTS.CONTENT_DISPOSITION, "inline; filename=RmanOrderLinesBookingsV.csv");

		OutputStreamWriter writerOutputStream = null;

		Page<RmanOrderBookingsV> page = null;
		page = rmanOrderBookingsVRepo.findAll(RevmantraUtils.fetchSpecification(RmanOrderBookingsV.class, search),
				PageRequest.of(0, Integer.MAX_VALUE));
		CsvMapper mapper = new CsvMapper();
		mapper.setDateFormat(new SimpleDateFormat(CONSTANTS.MM_DD_YYYY));
		mapper.enable(JsonGenerator.Feature.IGNORE_UNKNOWN);
		CsvSchema schema = CsvSchema.builder().setColumnSeparator(',').addColumn(CONSTANTS.ARRANGEMENTID)
				.addColumn("so").addColumn("orderNumModifier")
				// .addColumn("serviceRefOrder").addColumn("serviceRefOrdLineNum")
				.addColumn("ouName").addColumn("endCustomer").addColumn(CONSTANTS.CUSTOMER_NUMBER)
				.addColumn("billToLocation").addColumn("shipToLocation").addColumn(CONSTANTS.SALES_REP)
				.addColumn(CONSTANTS.PRICE_LIST).addColumn(CONSTANTS.CUSTOMER_PO_NUMBER)
				.addColumn(CONSTANTS.BOOKINGCURRENCY).addColumn("funcCurrencyCode").addColumn("orderAcctdAmount")
				.addColumn("orderBookedDate")
				// .addColumn("linkedDate")
				.setUseHeader(false).build();
		ObjectWriter objectWriter = mapper.writer(schema);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		List<String> line1 = new ArrayList<>();
		line1.add(CONSTANTS.REVENUE_CONTRACT_NUMBER);
		line1.add("SO#");
		line1.add("Contract Modifier");
		line1.add("Operating Unit");
		line1.add(CONSTANTS.CUSTOMER_NAME);
		line1.add(CONSTANTS.CUSTOMERNUMBER);
		line1.add("Bill to Location");
		line1.add("Ship to Location");
		line1.add("Sales Rep");
		line1.add(CONSTANTS.PRICE_LIST);
		line1.add("PO#");
		line1.add("Booking Currency");
		line1.add("Functionl Currency");
		line1.add("Ordered Amount");
		line1.add("Ordered Date");
		try {
			objectWriter.writeValue(baos, line1);
		} catch (JsonGenerationException jge) {
			logger.error(jge);
		} catch (JsonMappingException jme) {
			logger.error(jme);
		} catch (IOException ioe) {
			logger.error(ioe);
		}

		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(baos, 1024);
		try {
			writerOutputStream = new OutputStreamWriter(bufferedOutputStream, StandardCharsets.UTF_8);
			objectWriter.writeValue(writerOutputStream, page.getContent());
			writerOutputStream.close();
		} catch (UnsupportedEncodingException uee) {
			logger.error(uee);
		} catch (JsonGenerationException jge) {
			logger.error(jge);
		} catch (JsonMappingException jme) {
			logger.error(jme);
		} catch (IOException ioe) {
			logger.error(ioe);
		}

		List<RmanOrderLinesBookingsV> bkLinesList = rmanOrderLinesBookingsVRepo
				.findAll(RevmantraUtils.fetchSpecification(RmanOrderLinesBookingsV.class, search));
		mapper = new CsvMapper();
		mapper.setDateFormat(new SimpleDateFormat(CONSTANTS.MM_DD_YYYY));
		mapper.enable(JsonGenerator.Feature.IGNORE_UNKNOWN);
		List<String> line2 = new ArrayList<>();

		if (columns != null) {
			com.fasterxml.jackson.dataformat.csv.CsvSchema.Builder schemaBuilder = CsvSchema.builder()
					.setColumnSeparator(',').addColumn(CONSTANTS.ARRANGEMENTID);
			line2.add(CONSTANTS.REVENUE_CONTRACT_NUMBER);
			for (String column : columns) {
				schemaBuilder.addColumn(column);
				line2.add(ExportColumns.bookingLinesFields.get(column));
			}
			schema = schemaBuilder.setUseHeader(false).build();
		}
		objectWriter = mapper.writer(schema);

		try {
			baos.write("\n \n \n \n".getBytes());
		} catch (IOException ioe) {
			logger.error(ioe);
		}

		try {
			objectWriter.writeValue(baos, line2);
		} catch (JsonGenerationException jge) {
			logger.error(jge);
		} catch (JsonMappingException jme) {
			logger.error(jme);
		} catch (IOException ioe) {
			logger.error(ioe);
		}

		try {
			writerOutputStream = new OutputStreamWriter(bufferedOutputStream, StandardCharsets.UTF_8);
			objectWriter.writeValue(writerOutputStream, bkLinesList);
			writerOutputStream.close();
		} catch (UnsupportedEncodingException uee) {
			logger.error(uee);
		} catch (JsonGenerationException jge) {
			logger.error(jge);
		} catch (JsonMappingException jme) {
			logger.error(jme);
		} catch (IOException ioe) {
			logger.error(ioe);
		}

		try {
			baos.close();
		} catch (IOException ioe) {
			logger.error(ioe);
		}
		return baos.toString();
	}

	@GetMapping(value = { "/api/contractHeadersInfoVSearch", "/api/sfqi/contractHeadersInfoVSearch" })
	@ResponseBody
	public Page<ContractHeadersInfoV> searchContractHeadersInfoV(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return contractHeadersInfoVRepo.findAll(RevmantraUtils.fetchSpecification(ContractHeadersInfoV.class, search),
				pageRequest);
	}

	@GetMapping(value = "/api/contractHeadersInfoVExport", produces = "application/vnd.ms-excel")
	@ResponseBody
	public String exportContractHeadersInfoV(@RequestParam(value = "search") String search,
			@RequestParam(value = "exportCols", required = false) List<String> columns,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest, HttpServletResponse response) {
		response.setHeader(CONSTANTS.CONTENT_DISPOSITION, "inline; filename=ContractHeadersInfoV.csv");
		List<ContractHeadersInfoV> cheaderList = contractHeadersInfoVRepo
				.findAll(RevmantraUtils.fetchSpecification(ContractHeadersInfoV.class, search));
		CsvMapper mapper = new CsvMapper();
		mapper.setDateFormat(new SimpleDateFormat(CONSTANTS.MM_DD_YYYY));
		mapper.enable(JsonGenerator.Feature.IGNORE_UNKNOWN);
		List<String> line1 = new ArrayList<>();
		CsvSchema schema = null;
		if (columns != null) {
			com.fasterxml.jackson.dataformat.csv.CsvSchema.Builder schemaBuilder = CsvSchema.builder()
					.setColumnSeparator(',').addColumn(CONSTANTS.DEAL_ARRANGEMENT_ID);
			line1.add(CONSTANTS.REVENUE_CONTRACT_NUMBER);
			for (String column : columns) {
				schemaBuilder.addColumn(column);
				line1.add(ExportColumns.contractHeadersFields.get(column));
			}
			schema = schemaBuilder.setUseHeader(false).build();
		}

		ObjectWriter objectWriter = mapper.writer(schema);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			objectWriter.writeValue(baos, line1);
		} catch (JsonGenerationException | JsonMappingException e1) {
			logger.error("Exception Occured in exportContractHeadersInfoV method: {}", e1.getMessage());
		} catch (IOException e1) {
			logger.error(e1);
		}
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(baos, 1024);
		OutputStreamWriter writerOutputStream;
		try {
			writerOutputStream = new OutputStreamWriter(bufferedOutputStream, StandardCharsets.UTF_8);
			objectWriter.writeValue(writerOutputStream, cheaderList);
			writerOutputStream.close();
		} catch (UnsupportedEncodingException | JsonMappingException e) {
			logger.error(CONSTANTS.ERROR_EXPORT_CONTRACT_HEADERS, e.getMessage());
		} catch (JsonGenerationException jge) {
			logger.error(CONSTANTS.ERROR_EXPORT_CONTRACT_HEADERS, jge.getMessage());
		} catch (IOException ioe) {
			logger.error(CONSTANTS.ERROR_EXPORT_CONTRACT_HEADERS, ioe.getMessage());
		}
		String csvData = baos.toString();
		try {
			baos.close();
		} catch (IOException e) {
			logger.error(e);
		}
		return csvData;
	}

	@GetMapping(value = { "/api/rmanDealDetailsSearch", "/api/sfqi/rmanDealDetailsSearch" })
	@ResponseBody
	public Page<RmanDealDetails> searchRmanDealDetails(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return rmanDealDetailsRepo.findAll(RevmantraUtils.fetchSpecification(RmanDealDetails.class, search), PageRequest
				.of(pageRequest.getPageNumber(), pageRequest.getPageSize(), Direction.ASC, CONSTANTS.DEAL_LINE_NUMBER));
	}

	@GetMapping(value = "/api/rmanDealDetailsExport", produces = "application/vnd.ms-excel")
	@ResponseBody
	public String exportRmanDealDetails(@RequestParam(value = "search") String search,
			@RequestParam(value = "exportCols", required = false) List<String> columns,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest, HttpServletResponse response) {
		response.setHeader(CONSTANTS.CONTENT_DISPOSITION, "inline; filename=RmanDealDetails.csv");

		Page<ContractHeadersInfoV> page = contractHeadersInfoVRepo
				.findAll(RevmantraUtils.fetchSpecification(ContractHeadersInfoV.class, search), pageRequest);
		CsvMapper mapper = new CsvMapper();
		mapper.setDateFormat(new SimpleDateFormat(CONSTANTS.MM_DD_YYYY));
		mapper.enable(JsonGenerator.Feature.IGNORE_UNKNOWN);
		CsvSchema schema = CsvSchema.builder().setColumnSeparator(',').addColumn(CONSTANTS.DEAL_ARRANGEMENT_ID)
				.addColumn(CONSTANTS.DEAL_NUMBER).addColumn(CONSTANTS.DEAL_NAME).addColumn("agreementNumber")
				.addColumn(CONSTANTS.AGREEMENTNAME).addColumn("opportunityNum").addColumn("opportunityName")
				.addColumn("endCustomerName").addColumn("salesChannel").addColumn("dealCurrencyCode")
				.addColumn("dealAmount").addColumn("createdDate").addColumn("additionalInfo1")
				.addColumn(CONSTANTS.PRICE_LIST).setUseHeader(false).build();
		ObjectWriter objectWriter = mapper.writer(schema);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		List<String> line1 = new ArrayList<>();
		line1.add(CONSTANTS.REVENUE_CONTRACT_NUMBER);
		line1.add("Contract/Deal#");
		line1.add("Contract/Deal Name");
		line1.add("Agreement#");
		line1.add("Agreement Name");
		line1.add("Opportunity #");
		line1.add("Opportunity Name");
		line1.add(CONSTANTS.CUSTOMER_NAME);
		line1.add("Sales Channel");
		line1.add(CONSTANTS.CURRENCY);
		line1.add(CONSTANTS.AMOUNT);
		line1.add("Created Date");
		line1.add("Additional Info1");
		line1.add(CONSTANTS.PRICE_LIST);

		try {
			objectWriter.writeValue(baos, line1);
		} catch (JsonGenerationException jge) {
			logger.error(jge);
		} catch (JsonMappingException jme) {
			logger.error(jme);
		} catch (IOException ioe) {
			logger.error(ioe);
		}

		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(baos, 1024);
		OutputStreamWriter writerOutputStream;
		try {
			writerOutputStream = new OutputStreamWriter(bufferedOutputStream, StandardCharsets.UTF_8);
			objectWriter.writeValue(writerOutputStream, page.getContent());
			writerOutputStream.close();
		} catch (UnsupportedEncodingException uee) {
			logger.error(uee);
		} catch (JsonGenerationException jge) {
			logger.error(jge);
		} catch (JsonMappingException jme) {
			logger.error(jme);
		} catch (IOException ioe) {
			logger.error(ioe);
		}

		List<RmanDealDetails> cLinesList = rmanDealDetailsRepo.findAll(
				RevmantraUtils.fetchSpecification(RmanDealDetails.class, search),
				Sort.by(Direction.ASC, CONSTANTS.DEAL_LINE_NUMBER));
		mapper = new CsvMapper();
		mapper.setDateFormat(new SimpleDateFormat(CONSTANTS.MM_DD_YYYY));
		mapper.enable(JsonGenerator.Feature.IGNORE_UNKNOWN);
		List<String> line2 = new ArrayList<>();
		CsvSchema schema1 = null;

		if (columns != null) {
			com.fasterxml.jackson.dataformat.csv.CsvSchema.Builder schemaBuilder = CsvSchema.builder()
					.setColumnSeparator(',').addColumn(CONSTANTS.DEAL_ARRANGEMENT_ID);
			line2.add(CONSTANTS.REVENUE_CONTRACT_NUMBER);
			for (String column : columns) {
				// 1
				if (column.equals("attribute1")) {
					schemaBuilder.addArrayColumn("rmanproducts[attribute1]");
				} else if (column.equals(CONSTANTS.ATTRIBUTE2)) {
					schemaBuilder.addArrayColumn("rmanproducts[attribute2]");
				} else if (column.equals(CONSTANTS.ATTRIBUTE3)) {
					schemaBuilder.addArrayColumn("rmanproducts[attribute3]");
				}
				// 2
				else if (column.equals("accRuleRevenue")) {
					schemaBuilder.addColumn("acctRevRuleName");
				}
				// 3
				else if (column.equals("lookupDescription")) {
					schemaBuilder.addColumn("amortRevRuleName");
				}
				// 0
				else {
					schemaBuilder.addColumn(column);
				}
				line2.add(ExportColumns.contractLinesFields.get(column));
			}
			schema1 = schemaBuilder.setUseHeader(false).build();
		}
		objectWriter = mapper.writer(schema1);

		try {
			baos.write(CONSTANTS.NEW_LINE_EXPRESSION.getBytes());
		} catch (IOException e1) {
			logger.error(e1);
		}

		try {
			objectWriter.writeValue(baos, line2);
		} catch (JsonGenerationException jge) {
			logger.error(jge);
		} catch (JsonMappingException jme) {
			logger.error(jme);
		} catch (IOException ioe) {
			logger.error(ioe);
		}

		try {
			writerOutputStream = new OutputStreamWriter(bufferedOutputStream, StandardCharsets.UTF_8);
			objectWriter.writeValue(writerOutputStream, cLinesList);
			writerOutputStream.close();
		} catch (UnsupportedEncodingException uee) {
			logger.error(uee);
		} catch (JsonGenerationException jge) {
			logger.error(jge);
		} catch (JsonMappingException jme) {
			logger.error(jme);
		} catch (IOException ioe) {
			logger.error(ioe);
		}

		try {
			baos.close();
		} catch (IOException ioe) {
			logger.error(ioe);
		}
		return baos.toString();

	}

	@GetMapping(value = "/api/rmanMasterArrangementsVSearch")
	@ResponseBody
	public Page<RmanMasterArrangementsV> searchRmanMasterArrangementsV(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return rmanMasterArrangementsVRepo
				.findAll(RevmantraUtils.fetchSpecification(RmanMasterArrangementsV.class, search), pageRequest);

	}

	@GetMapping(value = { "/api/rmanDealGmAsvSearch", "/api/sfqi/rmanDealGmAsvSearch" })
	@ResponseBody
	public Page<RmanDealGmAsv> searchRmanDealGmAsv(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return rmanDealGmAsvRepo.findAll(RevmantraUtils.fetchSpecification(RmanDealGmAsv.class, search), pageRequest);

	}

	@GetMapping(value = "/api/rmanDealGmAsvExport", produces = "application/vnd.ms-excel")
	@ResponseBody
	public String exportRmanDealGmAsv(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest, HttpServletResponse response) {
		response.setHeader(CONSTANTS.CONTENT_DISPOSITION, "inline; filename=RmanDealGmAsv.csv");
		List<RmanDealGmAsv> dealGMList = rmanDealGmAsvRepo
				.findAll(RevmantraUtils.fetchSpecification(RmanDealGmAsv.class, search));
		CsvMapper mapper = new CsvMapper();
		mapper.setDateFormat(new SimpleDateFormat(CONSTANTS.MM_DD_YYYY));
		mapper.enable(JsonGenerator.Feature.IGNORE_UNKNOWN);
		CsvSchema schema = CsvSchema.builder().setColumnSeparator(',').addColumn(CONSTANTS.ARRANGEMENTID)
				.addColumn("arrgLineNumber").addColumn("sku")
				// .addColumn("elementType")
				.addColumn("shippedQty").addColumn("shippedAllocation").addColumn("lineShipmentAmount")
				.addColumn("lineShipmentCost").addColumn("shipmentGrossMargin").setUseHeader(false).build();
		ObjectWriter objectWriter = mapper.writer(schema);

		List<String> line1 = new ArrayList<>();
		line1.add(CONSTANTS.REVENUE_CONTRACT_NUMBER);
		line1.add("Revenue Contract Line #");
		line1.add(CONSTANTS.PRODUCTNAME);
		line1.add("Delivered Quantity");
		line1.add("Delivered Allocation Amount");
		line1.add("Delivered Amount");
		line1.add("Line Cost");
		line1.add("Gross Margin");

		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		try {
			objectWriter.writeValue(baos, line1);
		} catch (JsonGenerationException jge) {
			logger.error(jge);
		} catch (JsonMappingException jme) {
			logger.error(jme);
		} catch (IOException ioe) {
			logger.error(ioe);
		}

		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(baos, 1024);
		OutputStreamWriter writerOutputStream;
		try {
			writerOutputStream = new OutputStreamWriter(bufferedOutputStream, StandardCharsets.UTF_8);
			objectWriter.writeValue(writerOutputStream, dealGMList);
			writerOutputStream.close();
		} catch (UnsupportedEncodingException uee) {
			logger.error(uee);
		} catch (JsonGenerationException jge) {
			logger.error(jge);
		} catch (JsonMappingException jme) {
			logger.error(jme);
		} catch (IOException ioe) {
			logger.error(ioe);
		}
		String csvData = baos.toString();
		try {
			baos.close();
		} catch (IOException ioe) {
			logger.error(ioe);
		}
		return csvData;
	}

	@GetMapping(value = "/api/rmanContTransLinesSearch")
	@ResponseBody
	public Page<RmanContTransLines> searchRmanContTransLines(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return rmanContTransLinesRepo.findAll(RevmantraUtils.fetchSpecification(RmanContTransLines.class, search),
				pageRequest);

	}

	@GetMapping(value = { "/api/rmanContTransToReleaseSearch", "/api/sfqi/rmanContTransToReleaseSearch" })
	@ResponseBody
	public Page<RmanContTransToRelease> searchRmanContTransToRelease(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return rmanContTransToReleaseRepo
				.findAll(RevmantraUtils.fetchSpecification(RmanContTransToRelease.class, search), pageRequest);

	}

	@GetMapping(value = "/api/rmanContHeaderVSearch")
	@ResponseBody
	public Page<RmanContHeaderV> searchRmanContHeaderV(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return rmanContHeaderVRepo.findAll(RevmantraUtils.fetchSpecification(RmanContHeaderV.class, search),
				pageRequest);

	}

	@GetMapping(value = "/api/rmanContLinkTemplateVSearch")
	@ResponseBody
	public Page<RmanContLinkTemplateV> searchRmanContLinkTemplateV(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return rmanContLinkTemplateVRepo.findAll(RevmantraUtils.fetchSpecification(RmanContLinkTemplateV.class, search),
				pageRequest);

	}

	@GetMapping(value = "/api/rmanContSourceLovSearch")
	@ResponseBody
	public Page<RmanContSourceLov> searchRmanContSourceLov(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return rmanContSourceLovRepo.findAll(RevmantraUtils.fetchSpecification(RmanContSourceLov.class, search),
				PageRequest.of(0, Integer.MAX_VALUE));

	}

	@GetMapping(value = "/api/rmanContProdNameLovVSearch")
	@ResponseBody
	public Page<RmanContProdNameLovV> searchRmanContProdNameLovV(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return rmanContProdNameLovVRepo.findAll(RevmantraUtils.fetchSpecification(RmanContProdNameLovV.class, search),
				pageRequest);

	}

	@GetMapping(value = "/api/rmanContLinkedTemplateSvSearch")
	@ResponseBody
	public Page<RmanContLinkedTemplateSv> searchRmanContLinkedTemplateSv(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest,
			@RequestParam(value = "fetchAll", defaultValue = "N") String fetchAll) {
		return rmanContLinkedTemplateSvRepo.findAll(
				RevmantraUtils.fetchSpecification(RmanContLinkedTemplateSv.class, search),
				fetchAll.equals("Y") ? PageRequest.of(0, Integer.MAX_VALUE) : pageRequest);
	}

	@DeleteMapping(value = "/api/RMAN_CONT_LINKED_TEMPLATE_SV/{rid}/{tid}")
	public ResponseEntity<Void> deleteContLinkedRecord(@PathVariable BigDecimal rid, @PathVariable BigDecimal tid) {

		rmanContLinkedTemplateSvRepo.deleteById(new RmanContLinkedtemplatesId(rid, tid));
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping(value = "/api/rmanRevenueTemplatesSearch")
	@ResponseBody
	public Page<RmanRevenueTemplates> searchRmanRevenueTemplates(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest,
			@RequestParam(value = "fetchAll", required = false) boolean fetchAll) {
		return rmanRevenueTemplatesRepo.findAll(RevmantraUtils.fetchSpecification(RmanRevenueTemplates.class, search),
				fetchAll ? PageRequest.of(0, Integer.MAX_VALUE) : pageRequest);

	}

	@GetMapping(value = "/api/rmanAccountSetupSearch")
	@ResponseBody
	public Page<RmanAccountSetup> searchRmanAccountSetup(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return rmanAccountSetupRepo.findAll(RevmantraUtils.fetchSpecification(RmanAccountSetup.class, search),
				pageRequest);
	}

	@GetMapping(value = "/api/rmanDealHeadersSearch")
	@ResponseBody
	public Page<RmanDealHeaders> searchRmanDealHeaders(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return rmanDealHeadersRepo.findAll(RevmantraUtils.fetchSpecification(RmanDealHeaders.class, search),
				pageRequest);
	}

	@GetMapping(value = "/api/rmanDealStatusSearch")
	@ResponseBody
	public Page<RmanDealStatus> searchRmanDealStatus(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return rmanDealStatusRepo.findAll(RevmantraUtils.fetchSpecification(RmanDealStatus.class, search), pageRequest);
	}

	@GetMapping(value = "/api/rmanEventsSearch")
	@ResponseBody
	public Page<RmanEvents> searchRmanEvents(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return rmanEventsRepo.findAll(RevmantraUtils.fetchSpecification(RmanEvents.class, search), pageRequest);
	}

	@GetMapping(value = "/api/rmanContReleaseLinesSearch")
	@ResponseBody
	public Page<RmanContReleaseLines> searchRmanContReleaseLines(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return rmanContReleaseLinesRepo.findAll(RevmantraUtils.fetchSpecification(RmanContReleaseLines.class, search),
				pageRequest);
	}

	@GetMapping(value = "/api/rmanContReleaseLinesExport", produces = "application/vnd.ms-excel")
	@ResponseBody
	public String exportRmanContReleaseLines(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest, HttpServletResponse response) {
		response.setHeader(CONSTANTS.CONTENT_DISPOSITION, "inline; filename=RmanContReleaseLines.csv");

		OutputStreamWriter writerOutputStream = null;

		Page<RmanContTransToRelease> page = rmanContTransToReleaseRepo.findAll(
				RevmantraUtils.fetchSpecification(RmanContTransToRelease.class, search),
				PageRequest.of(0, Integer.MAX_VALUE));
		CsvMapper mapper = new CsvMapper();
		mapper.setDateFormat(new SimpleDateFormat(CONSTANTS.MM_DD_YYYY));
		mapper.enable(JsonGenerator.Feature.IGNORE_UNKNOWN);
		CsvSchema schema = CsvSchema.builder().setColumnSeparator(',').addColumn(CONSTANTS.APPLICATIONLEVEL)
				.addColumn(CONSTANTS.SOURCE_HEADER_ID).addColumn(CONSTANTS.SOURCE_LINE_ID).addColumn("attribute26")
				.addColumn("element").addColumn(CONSTANTS.ATTRIBUTE3).addColumn(CONSTANTS.ATTRIBUTE2)
				.addColumn(CONSTANTS.PRODUCT_NAME).addColumn(CONSTANTS.ATTRIBUTE29).addColumn(CONSTANTS.CONT_EVENT_TYPE)
				.addColumn("ruleHeaderId").addColumn(CONSTANTS.RANKING).addColumn(CONSTANTS.RULE_CATEGORY)
				.addColumn(CONSTANTS.ATTRIBUTE28).addColumn("templateId").addColumn(CONSTANTS.REVENUE).addColumn("cogs")
				.addColumn(CONSTANTS.INVOICE_HOLD).addColumn(CONSTANTS.APPLYTYPE).addColumn(CONSTANTS.DEFERRED_METHOD)
				.addColumn("releaseType").addColumn("releaseRevenue").addColumn("releaseCogs").addColumn("comments")
				.addColumn("attribute14").setUseHeader(true).build();
		ObjectWriter objectWriter = mapper.writer(schema);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(baos, 1024);
		try {
			writerOutputStream = new OutputStreamWriter(bufferedOutputStream, StandardCharsets.UTF_8);
			objectWriter.writeValue(writerOutputStream, page.getContent());
			writerOutputStream.close();
		} catch (UnsupportedEncodingException uee) {
			logger.error(uee);
		} catch (JsonGenerationException jge) {
			logger.error(jge);
		} catch (JsonMappingException jme) {
			logger.error(jme);
		} catch (IOException ioe) {
			logger.error(ioe);
		}

		List<RmanContReleaseLines> contReleaseLinesList = rmanContReleaseLinesRepo
				.findAll(RevmantraUtils.fetchSpecification(RmanContReleaseLines.class, search));
		mapper = new CsvMapper();
		mapper.setDateFormat(new SimpleDateFormat(CONSTANTS.MM_DD_YYYY));
		mapper.enable(JsonGenerator.Feature.IGNORE_UNKNOWN);
		schema = CsvSchema.builder().setColumnSeparator(',').addColumn("releaseLineId").addColumn("transHeaderId")
				.addColumn("transLineId").addColumn(CONSTANTS.SOURCE_HEADER_ID).addColumn(CONSTANTS.SOURCE_LINE_ID)
				.addColumn("ruleHeaderId").addColumn("templateId").addColumn(CONSTANTS.APPLYTYPE)
				.addColumn(CONSTANTS.RANKING).addColumn(CONSTANTS.RULE_CATEGORY).addColumn(CONSTANTS.REVENUE)
				.addColumn("cogs").addColumn("releaseRevenue").addColumn("releaseCogs").addColumn("completeFlag")
				.addColumn("event").setUseHeader(true).build();

		objectWriter = mapper.writer(schema);
		try {
			baos.write(CONSTANTS.NEW_LINE_EXPRESSION.getBytes());
		} catch (IOException ioe) {
			logger.error(ioe);
		}

		try {
			writerOutputStream = new OutputStreamWriter(bufferedOutputStream, StandardCharsets.UTF_8);
			objectWriter.writeValue(writerOutputStream, contReleaseLinesList);
			writerOutputStream.close();
		} catch (UnsupportedEncodingException uee) {
			logger.error(uee);
		} catch (JsonGenerationException jge) {
			logger.error(jge);
		} catch (JsonMappingException jme) {
			logger.error(jme);
		} catch (IOException ioe) {
			logger.error(ioe);
		}

		try {
			baos.close();
		} catch (IOException ioe) {
			logger.error(ioe);
		}
		return baos.toString();
	}

	@PostMapping(value = "/api/saveUserInfo")
	@ResponseBody
	public RmanUsers saveRmanUsers(@RequestBody RmanUsers rmanUsers) {
		try {
			rmanUsers.setUserPassword(new BCryptPasswordEncoder().encode(rmanUsers.getUserPassword()));
			if (rmanUsers.getRmanUserId() != null) {
				rmanUsersRepo.save(rmanUsers);
			} else {
				rmanUsersRepo.saveAndFlush(rmanUsers);
			}

			identityServiceUtils.addIdentityuser(rmanUsers);

			return rmanUsers;
		} catch (Exception e) {
			logger.error("Getting Error while Saving the UserInfo due to {}", e.getMessage());
			return null;
		}
	}

	@PostMapping(value = "/api/RMAN_RESPONSIBILITIES")
	@ResponseBody
	public RmanResponsibilities saveResponsibility(@RequestBody RmanResponsibilities rmanResponsibilities) {
		try {
			rmanResponsibilitiesRepo.save(rmanResponsibilities);
			identityServiceUtils.addIdentityGroup(rmanResponsibilities);
			return rmanResponsibilities;
		} catch (Exception e) {
			logger.error("Getting Error while Saving Responsibility due to {}", e.getMessage());
			return null;
		}
	}

	@PostMapping(value = "/api/RMAN_USER_RESPONSIBILITIES")
	@ResponseBody
	public RmanUserResponsibilities saveResponsibility(@RequestBody RmanUserResponsibilities rmanUserResponsibilities) {
		try {
			rmanUserResponsibilitiesRepo.save(rmanUserResponsibilities);
			identityServiceUtils.addIdentityMemberShip(
					rmanUsersRepo.findByRmanUserId(rmanUserResponsibilities.getRmanUserId()).getUserName(),
					rmanResponsibilitiesRepo.findByResponsibilityId(rmanUserResponsibilities.getResponsibilityId())
							.getResponsibilityName());

			return rmanUserResponsibilities;
		} catch (Exception e) {
			logger.error("Getting Error while Saving User Responsibility due to {}", e.getMessage());
			return null;
		}
	}

	@PostMapping(value = "/api/changePassword")
	@ResponseBody
	public void updateRmanUsers(@RequestBody String userDetails) {
		BigDecimal userId = BaseListener.getCurrentUserId();

		String oldPassword = null;
		String newPassword = null;
		String cnfrmPassword = null;
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node;
		try {
			node = mapper.readTree(userDetails);
			if (node.isObject()) {
				oldPassword = node.get("oldPassword").textValue();
				newPassword = node.get("newPassword").textValue();
				cnfrmPassword = node.get("cnfrmPassword").textValue();

				if (oldPassword != null && !oldPassword.isEmpty() && !newPassword.isEmpty()) {
					if (!isValid(newPassword)) {
						throw new AyaraCustomException("Password Criteria should match the criteria like "
								+ "Minimum length should be 8 characters, "
								+ "Must contain at least one lower case letter,one upper case letter, one digit and one special character."
								+ "Valid special characters are !@#$%^&*");
					}

					if (newPassword.length() < 8) {
						throw new AyaraCustomException("Minimum Password length is 8 characters required");
					}
				} else {
					throw new AyaraCustomException(
							"Either Old password or New Password is Empty/Null. Please check and try again");
				}
			}
		} catch (JsonProcessingException e) {
			logger.error(e);
			throw new AyaraCustomException("Unable to Fetch the User Credentials");
		} 

		RmanUsers rmanUser = rmanUsersRepo.findByRmanUserId(userId);

		if (oldPassword != null && !oldPassword.isEmpty() && !newPassword.isEmpty()) {
			if (!newPassword.equals(cnfrmPassword)) {
				throw new AyaraCustomException("New Password doesn't match with Confirm Password");
			}

			if (!oldPassword.equals(newPassword)) {
				BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

				if (encoder.matches(oldPassword, rmanUser.getUserPassword())) {
					rmanUser.setUserPassword(new BCryptPasswordEncoder().encode(newPassword));
					rmanUsersRepo.save(rmanUser);

				} else {
					throw new AyaraCustomException("Old Password doesn't match with existing User Password");
				}
			} else {
				throw new AyaraCustomException("Old Password and New Password Should be different");
			}
		}
	}

	private boolean isValid(final String password) {
		Matcher matcher = pattern.matcher(password);
		return matcher.matches();
	}

	@GetMapping(value = "/api/rmanContReleaseEventsVSearch")
	@ResponseBody
	public Page<RmanContReleaseEventsV> searchRmanContReleaseEventsV(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return rmanContReleaseEventsVRepo
				.findAll(RevmantraUtils.fetchSpecification(RmanContReleaseEventsV.class, search), pageRequest);
	}

	@GetMapping(value = "/api/rmanContReleaseEventsVExport", produces = "application/vnd.ms-excel")
	@ResponseBody
	public String exportRmanContReleaseEventsV(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest, HttpServletResponse response) {
		response.setHeader(CONSTANTS.CONTENT_DISPOSITION, "inline; filename=RmanContReleaseEventsV.csv");
		List<RmanContReleaseEventsV> releaseEventsVList = rmanContReleaseEventsVRepo
				.findAll(RevmantraUtils.fetchSpecification(RmanContReleaseEventsV.class, search));
		CsvMapper mapper = new CsvMapper();
		mapper.setDateFormat(new SimpleDateFormat(CONSTANTS.MM_DD_YYYY));
		mapper.enable(JsonGenerator.Feature.IGNORE_UNKNOWN);
		CsvSchema schema = CsvSchema.builder().setColumnSeparator(',').addColumn("so")
				.addColumn(CONSTANTS.SOURCE_LINE_NUMBER).addColumn("trxCurrency").addColumn("bookedAmount")
				.addColumn("deliveredAmount").addColumn("contingencyName").addColumn(CONSTANTS.RULE_CATEGORY)
				.addColumn("templateName").addColumn("deferredAmount").addColumn("deferredReleaseAmount")
				.addColumn("undeferredAmount").setUseHeader(false).build();
		ObjectWriter objectWriter = mapper.writer(schema);

		List<String> line1 = new ArrayList<>();
		line1.add("SO");
		line1.add("Source Line Number");
		line1.add("Transaction Currency");
		line1.add("Booked Amount");
		line1.add("Delivered Amount");
		line1.add("Contingency Name");
		line1.add(CONSTANTS.RULECATEGORY);
		line1.add("Template Name");
		line1.add("Deferred Amount");
		line1.add("Release Amount");
		line1.add("Undeferred Amount");

		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		try {
			objectWriter.writeValue(baos, line1);
		} catch (JsonGenerationException jge) {
			logger.error(jge);
		} catch (JsonMappingException jme) {
			logger.error(jme);
		} catch (IOException ioe) {
			logger.error(ioe);
		}

		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(baos, 1024);

		OutputStreamWriter writerOutputStream;
		try {
			writerOutputStream = new OutputStreamWriter(bufferedOutputStream, StandardCharsets.UTF_8);
			objectWriter.writeValue(writerOutputStream, releaseEventsVList);
			writerOutputStream.close();
		} catch (UnsupportedEncodingException uee) {
			logger.error(uee);
		} catch (JsonGenerationException jge) {
			logger.error(jge);
		} catch (JsonMappingException jme) {
			logger.error(jme);
		} catch (IOException ioe) {
			logger.error(ioe);
		}

		String csvData = baos.toString();
		try {
			baos.close();
		} catch (IOException ioe) {
			logger.error(ioe);
		}
		return csvData;
	}

	@GetMapping(value = "/api/rmanDealRfcstVSearch")
	@ResponseBody
	public Page<RmanDealRfcstV> searchRmanDealRfcstV(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return rmanDealRfcstVRepo.findAll(RevmantraUtils.fetchSpecification(RmanDealRfcstV.class, search), pageRequest);
	}

	@GetMapping(value = "/api/rmanDealRfcstVExport", produces = "application/vnd.ms-excel")
	@ResponseBody
	public String exportRmanDealRfcstV(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest, HttpServletResponse response) {
		response.setHeader(CONSTANTS.CONTENT_DISPOSITION, "inline; filename=RmanDealRfcstV.csv");
		Page<RmanDealRfcstV> page = rmanDealRfcstVRepo.findAll(
				RevmantraUtils.fetchSpecification(RmanDealRfcstV.class, search), PageRequest.of(0, Integer.MAX_VALUE));
		CsvMapper mapper = new CsvMapper();
		mapper.setDateFormat(new SimpleDateFormat(CONSTANTS.MM_DD_YYYY));
		mapper.enable(JsonGenerator.Feature.IGNORE_UNKNOWN);
		CsvSchema schema = CsvSchema.builder().setColumnSeparator(',').addColumn(CONSTANTS.ARRANGEMENTNAME)
				.addColumn("sku").addColumn("qty").addColumn("elementType").addColumn("netPrice")
				.addColumn("expectedBookingAmount").addColumn("amount").addColumn("glPeriod").setUseHeader(false)
				.build();
		ObjectWriter objectWriter = mapper.writer(schema);

		List<String> line1 = new ArrayList<>();
		line1.add(CONSTANTS.REVENUE_CONTRACT_NAME);
		line1.add("SKU");
		line1.add("QTY");
		line1.add("Element Type");
		line1.add("Unit Selling Price");
		line1.add("Expected Booking Amount");
		line1.add(CONSTANTS.AMOUNT);
		line1.add("Period");

		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		try {
			objectWriter.writeValue(baos, line1);
		} catch (JsonGenerationException jge) {
			logger.error(jge);
		} catch (JsonMappingException jme) {
			logger.error(jme);
		} catch (IOException ioe) {
			logger.error(ioe);
		}

		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(baos, 1024);
		OutputStreamWriter writerOutputStream;
		try {
			writerOutputStream = new OutputStreamWriter(bufferedOutputStream, StandardCharsets.UTF_8);
			objectWriter.writeValue(writerOutputStream, page.getContent());
			writerOutputStream.close();
		} catch (UnsupportedEncodingException uee) {
			logger.error(uee);
		} catch (JsonGenerationException jge) {
			logger.error(jge);
		} catch (JsonMappingException jme) {
			logger.error(jme);
		} catch (IOException ioe) {
			logger.error(ioe);
		}
		String csvData = baos.toString();
		try {
			baos.close();
		} catch (IOException ioe) {
			logger.error(ioe);
		}
		return csvData;
	}

	@GetMapping(value = { "/api/rmanContReleaseLinesVSearch", "/api/sfqi/rmanContReleaseLinesVSearch" })
	@ResponseBody
	public Page<RmanContReleaseLinesV> searchRmanContReleaseLinesV(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return rmanContReleaseLinesVRepo.findAll(RevmantraUtils.fetchSpecification(RmanContReleaseLinesV.class, search),
				pageRequest);
	}

	@GetMapping(value = "/api/rmanContReleaseLinesVExport", produces = "application/vnd.ms-excel")
	@ResponseBody
	public String exportRmanContReleaseLinesV(@RequestParam(value = "search") String search,
			@RequestParam(value = "exportCols", required = false) List<String> columns,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest, HttpServletResponse response) {
		response.setHeader(CONSTANTS.CONTENT_DISPOSITION, "inline; filename=RmanContReleaseLinesV.csv");

		OutputStreamWriter writerOutputStream = null;

		Page<RmanContTransToRelease> page = rmanContTransToReleaseRepo.findAll(
				RevmantraUtils.fetchSpecification(RmanContTransToRelease.class, search),
				PageRequest.of(0, Integer.MAX_VALUE));
		CsvMapper mapper = new CsvMapper();
		mapper.setDateFormat(new SimpleDateFormat(CONSTANTS.MM_DD_YYYY));
		mapper.enable(JsonGenerator.Feature.IGNORE_UNKNOWN);
		CsvSchema schema = null;

		schema = CsvSchema.builder().setColumnSeparator(',').addColumn(CONSTANTS.DEAL_ARRANGEMENT_ID)
				.addColumn(CONSTANTS.APPLICATIONLEVEL).addColumn("attribute4").addColumn("attribute5")
				.addColumn("attribute6")
				// .addColumn(CONSTANTS.SOURCE_HEADER_ID).addColumn(CONSTANTS.SOURCE_LINE_ID)
				.addColumn(CONSTANTS.ATTRIBUTE3).addColumn(CONSTANTS.ATTRIBUTE2).addColumn(CONSTANTS.PRODUCT_NAME)
				.addColumn(CONSTANTS.ATTRIBUTE29).addColumn(CONSTANTS.CONT_EVENT_TYPE).addColumn("attribute7")
				.addColumn(CONSTANTS.RANKING).addColumn(CONSTANTS.RULE_CATEGORY).addColumn(CONSTANTS.ATTRIBUTE28)
				.addColumn("attribute8").addColumn(CONSTANTS.REVENUE).addColumn("cogs")
				.addColumn(CONSTANTS.INVOICE_HOLD).addColumn(CONSTANTS.APPLYTYPE).addColumn(CONSTANTS.DEFERRED_METHOD)
				// .addColumn("releaseType").addColumn("releaseRevenue")
				// .addColumn("releaseCogs").addColumn("comments").addColumn("attribute14")
				.setUseHeader(false).build();
		ObjectWriter objectWriter = mapper.writer(schema);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		List<String> line1 = new ArrayList<>();
		line1.add(CONSTANTS.REVENUE_CONTRACT_NUMBER);
		line1.add("Release Level");
		line1.add("Contingency Type");
		line1.add(CONSTANTS.SO_NUMBER);
		line1.add("SO Line Number");
		line1.add(CONSTANTS.PRODUCTGROUP);
		line1.add("Product Category");
		line1.add(CONSTANTS.PRODUCTNAME);
		line1.add("Post Allocation Contingency");
		line1.add("Current/Future");
		line1.add("Name");
		line1.add(CONSTANTS.RANKING);
		line1.add(CONSTANTS.RULECATEGORY);
		line1.add("Include FV Allocation");
		line1.add("Template");
		line1.add(CONSTANTS.REVENUE);
		line1.add("COGS");
		line1.add("Invoice Hold");
		line1.add("Type");
		line1.add("Method");
		try {
			objectWriter.writeValue(baos, line1);
		} catch (JsonGenerationException jge) {
			logger.error(jge);
		} catch (JsonMappingException jme) {
			logger.error(jme);
		} catch (IOException ioe) {
			logger.error(ioe);
		}

		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(baos, 1024);
		try {
			writerOutputStream = new OutputStreamWriter(bufferedOutputStream, StandardCharsets.UTF_8);
			objectWriter.writeValue(writerOutputStream, page.getContent());
			writerOutputStream.close();
		} catch (UnsupportedEncodingException uee) {
			logger.error(uee);
		} catch (JsonGenerationException jge) {
			logger.error(jge);
		} catch (JsonMappingException jme) {
			logger.error(jme);
		} catch (IOException ioe) {
			logger.error(ioe);
		}

		List<RmanContReleaseLinesV> contRLinesList = rmanContReleaseLinesVRepo
				.findAll(RevmantraUtils.fetchSpecification(RmanContReleaseLinesV.class, search));
		mapper = new CsvMapper();
		mapper.setDateFormat(new SimpleDateFormat(CONSTANTS.MM_DD_YYYY));
		mapper.enable(JsonGenerator.Feature.IGNORE_UNKNOWN);
		List<String> line2 = new ArrayList<>();

		if (columns != null) {
			com.fasterxml.jackson.dataformat.csv.CsvSchema.Builder schemaBuilder = CsvSchema.builder()
					.setColumnSeparator(',').addColumn(CONSTANTS.DEAL_ARRANGEMENT_ID);
			line2.add(CONSTANTS.REVENUE_CONTRACT_NUMBER);
			for (String column : columns) {
				schemaBuilder.addColumn(column);
				line2.add(ExportColumns.releaseLinesFields.get(column));
			}
			schema = schemaBuilder.setUseHeader(false).build();
		}

		objectWriter = mapper.writer(schema);
		try {
			baos.write(CONSTANTS.NEW_LINE_EXPRESSION.getBytes());
		} catch (IOException ioe) {
			logger.error(ioe);
		}

		try {
			objectWriter.writeValue(baos, line2);
		} catch (JsonGenerationException jge) {
			logger.error(jge);
		} catch (JsonMappingException jme) {
			logger.error(jme);
		} catch (IOException ioe) {
			logger.error(ioe);
		}

		try {
			writerOutputStream = new OutputStreamWriter(bufferedOutputStream, StandardCharsets.UTF_8);
			objectWriter.writeValue(writerOutputStream, contRLinesList);
			writerOutputStream.close();
		} catch (UnsupportedEncodingException uee) {
			logger.error(uee);
		} catch (JsonGenerationException jge) {
			logger.error(jge);
		} catch (JsonMappingException jme) {
			logger.error(jme);
		} catch (IOException ioe) {
			logger.error(ioe);
		}

		try {
			baos.close();
		} catch (IOException ioe) {
			logger.error(ioe);
		}
		return baos.toString();
	}

	@GetMapping(value = "/api/rmanContTransToReleaseExport", produces = "application/vnd.ms-excel")
	@ResponseBody
	public String exportRmanContTransToRelease(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest, HttpServletResponse response) {
		response.setHeader(CONSTANTS.CONTENT_DISPOSITION, "inline; filename=RmanContTransToRelease.csv");

		OutputStreamWriter writerOutputStream = null;

		List<RmanContTransToRelease> contTransReleaseList = rmanContTransToReleaseRepo
				.findAll(RevmantraUtils.fetchSpecification(RmanContTransToRelease.class, search));
		CsvMapper mapper = new CsvMapper();
		mapper.setDateFormat(new SimpleDateFormat(CONSTANTS.MM_DD_YYYY));
		mapper.enable(JsonGenerator.Feature.IGNORE_UNKNOWN);
		CsvSchema schema = CsvSchema.builder().setColumnSeparator(',').addColumn(CONSTANTS.DEAL_ARRANGEMENT_ID)
				.addColumn(CONSTANTS.APPLICATIONLEVEL).addColumn("attribute4").addColumn("attribute5")
				.addColumn("attribute6").addColumn(CONSTANTS.ATTRIBUTE3).addColumn(CONSTANTS.ATTRIBUTE2)
				.addColumn(CONSTANTS.PRODUCT_NAME).addColumn(CONSTANTS.ATTRIBUTE29).addColumn(CONSTANTS.CONT_EVENT_TYPE)
				.addColumn("attribute7").addColumn(CONSTANTS.RANKING).addColumn(CONSTANTS.RULE_CATEGORY)
				.addColumn(CONSTANTS.ATTRIBUTE28).addColumn("attribute8").addColumn(CONSTANTS.REVENUE).addColumn("cogs")
				.addColumn(CONSTANTS.INVOICE_HOLD).addColumn(CONSTANTS.APPLYTYPE).addColumn(CONSTANTS.DEFERRED_METHOD)
				/*
				 * .addColumn("releaseType").addColumn("releaseRevenue")
				 * .addColumn("releaseCogs").addColumn("comments").addColumn( "attribute14")
				 */
				.setUseHeader(false).build();
		ObjectWriter objectWriter = mapper.writer(schema);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		List<String> line1 = new ArrayList<>();
		line1.add(CONSTANTS.REVENUE_CONTRACT_NUMBER);
		line1.add("Release Level");
		line1.add("Contingency Type");
		line1.add(CONSTANTS.SO_NUMBER);
		line1.add("SO Line Number");
		line1.add(CONSTANTS.PRODUCTGROUP);
		line1.add("Product Category");
		line1.add(CONSTANTS.PRODUCTNAME);
		line1.add("Post Allocation Contingency");
		line1.add("Current/Future");
		line1.add("Name");
		line1.add(CONSTANTS.RANKING);
		line1.add(CONSTANTS.RULECATEGORY);
		line1.add("Include FV Allocation");
		line1.add("Template");
		line1.add(CONSTANTS.REVENUE);
		line1.add("COGS");
		line1.add("Invoice Hold");
		line1.add("Type");
		line1.add("Method");
		try {
			objectWriter.writeValue(baos, line1);
		} catch (JsonGenerationException jge) {
			logger.error(jge);
		} catch (JsonMappingException jme) {
			logger.error(jme);
		} catch (IOException ioe) {
			logger.error(ioe);
		}

		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(baos, 1024);
		try {
			writerOutputStream = new OutputStreamWriter(bufferedOutputStream, StandardCharsets.UTF_8);
			objectWriter.writeValue(writerOutputStream, contTransReleaseList);
			writerOutputStream.close();
		} catch (UnsupportedEncodingException uee) {
			logger.error(uee);
		} catch (JsonGenerationException jge) {
			logger.error(jge);
		} catch (JsonMappingException jme) {
			logger.error(jme);
		} catch (IOException ioe) {
			logger.error(ioe);
		}

		return baos.toString();
	}

	@GetMapping(value = "/api/consolidatedArrgSummaryRepSearch")
	@ResponseBody
	public Page<ConsolidatedArrgSummaryRep> searchConsolidatedArrgSummaryRep(
			@RequestParam(value = "search") String search, @PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return consolidatedArrgSummaryRepRepo
				.findAll(RevmantraUtils.fetchSpecification(ConsolidatedArrgSummaryRep.class, search), pageRequest);
	}

	@GetMapping(value = "/api/consolidatedArrgSummaryRepExport", produces = "application/vnd.ms-excel")
	@ResponseBody
	public String exportConsolidatedArrgSummaryRep(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest, HttpServletResponse response) {
		response.setHeader(CONSTANTS.CONTENT_DISPOSITION, "inline; filename=ConsolidatedArrgSummaryRep.csv");
		List<ConsolidatedArrgSummaryRep> consArrgList = consolidatedArrgSummaryRepRepo
				.findAll(RevmantraUtils.fetchSpecification(ConsolidatedArrgSummaryRep.class, search));
		CsvMapper mapper = new CsvMapper();
		mapper.setDateFormat(new SimpleDateFormat(CONSTANTS.MM_DD_YYYY));
		mapper.enable(JsonGenerator.Feature.IGNORE_UNKNOWN);
		CsvSchema schema = CsvSchema.builder().setColumnSeparator(',').addColumn(CONSTANTS.CUSTOMER_NUMBER)
				.addColumn(CONSTANTS.CUSTOMER_NAME).addColumn("dealStatus").addColumn("legalEntity")
				.addColumn("currency").addColumn(CONSTANTS.ARRANGEMENTNAME).addColumn("arrangementType")
				.addColumn("status").addColumn("arrangementBasis").addColumn("arrangementSource")
				.addColumn(CONSTANTS.SALES_NODE_LVL_1).addColumn(CONSTANTS.SALES_NODE_LVL_2)
				.addColumn(CONSTANTS.SALES_NODE_LVL_3).addColumn(CONSTANTS.ARRANGEMENTNUMBER)
				.addColumn("approvalStatus").addColumn("approvedDate").addColumn("approvedBy")
				.addColumn(CONSTANTS.DEAL_NUMBER).addColumn(CONSTANTS.DEAL_NAME).addColumn("agreementNumber")
				.addColumn("agreementCode").addColumn("transactionCurrencyCode").addColumn(CONSTANTS.PRICE_LIST)
				.addColumn(CONSTANTS.BILLTOCUSTOMERNAME).addColumn(CONSTANTS.BILLTOCUSTOMERNUMBER)
				.addColumn("lineNumber").addColumn(CONSTANTS.PRODUCT_NAME).addColumn(CONSTANTS.QUANTITY)
				.addColumn("elementType").addColumn("accountingScope").addColumn(CONSTANTS.START_DATE)
				.addColumn(CONSTANTS.END_DATE).addColumn("uomCode").addColumn("transactionListPrice")
				.addColumn("transactionSellingPrice").addColumn("listPrice").addColumn("netPrice")
				.addColumn("dealLineCost").addColumn("allocationAmount").addColumn("cvInOutAmount")
				.addColumn("trxAllocUnitAmt")

				.setUseHeader(false).build();
		ObjectWriter objectWriter = mapper.writer(schema);
		List<String> line1 = new ArrayList<>();
		line1.add(CONSTANTS.CUSTOMERNUMBER);
		line1.add(CONSTANTS.CUSTOMER_NAME);
		line1.add("Deal Status");
		line1.add("Legal Entity");
		line1.add(CONSTANTS.CURRENCY);
		line1.add(CONSTANTS.REVENUE_CONTRACT_NAME);
		line1.add("Revenue Contract Type");
		line1.add("Status");
		line1.add("Revenue Contract Basis");
		line1.add("Revenue Contract Source");
		line1.add("Sales Theater");
		line1.add("Sales Region");
		line1.add("Sales Territory");
		line1.add(CONSTANTS.REVENUE_CONTRACT_NUMBER);
		line1.add("Approval Status");
		line1.add("Approved Date");
		line1.add("Approved By");
		line1.add("Deal Number");
		line1.add("Deal Name");
		line1.add("Agreement Number");
		line1.add("Agreement Name");
		line1.add("Transaction Currency");
		line1.add(CONSTANTS.PRICE_LIST);
		line1.add("Bill To Customer Name");
		line1.add("Bill To Customer Number");
		line1.add("Line Number");
		line1.add(CONSTANTS.PRODUCTNAME);
		line1.add(CONSTANTS.QUANTITY);
		line1.add("Element Type");
		line1.add("Accounting Scope");
		line1.add("Start Date");
		line1.add("End Date");
		line1.add("UOM");
		line1.add("Transaction List Price");
		line1.add("Transaction Selling Price");
		line1.add("Unit List Price");
		line1.add("Unit Selling Price");
		line1.add("Total Cost");
		line1.add("Allocation Amount");
		line1.add("Carve In/Carve Out Amount");
		line1.add("TRX Alloc Unit Amt");

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			objectWriter.writeValue(baos, line1);
		} catch (JsonGenerationException jge) {
			logger.error(jge);
		} catch (JsonMappingException jme) {
			logger.error(jme);
		} catch (IOException ioe) {
			logger.error(ioe);
		}

		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(baos, 1024);
		OutputStreamWriter writerOutputStream;
		try {
			writerOutputStream = new OutputStreamWriter(bufferedOutputStream, StandardCharsets.UTF_8);
			objectWriter.writeValue(writerOutputStream, consArrgList);
			writerOutputStream.close();
		} catch (UnsupportedEncodingException uee) {
			logger.error(uee);
		} catch (JsonGenerationException jge) {
			logger.error(jge);
		} catch (JsonMappingException jme) {
			logger.error(jme);
		} catch (IOException ioe) {
			logger.error(ioe);
		}
		String csvData = baos.toString();
		try {
			baos.close();
		} catch (IOException ioe) {
			logger.error(ioe);
		}
		return csvData;
	}

	@GetMapping(value = "/api/rmanArrgWaterFallRepV2Search")
	@ResponseBody
	public Page<RmanArrgWaterFallRepV2> searchRmanArrgWaterFallRepV2(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return rmanArrgWaterFallRepV2Repo
				.findAll(RevmantraUtils.fetchSpecification(RmanArrgWaterFallRepV2.class, search), pageRequest);
	}

	@GetMapping(value = "/api/rmanOrdersSearch")
	@ResponseBody
	public Page<RmanOrders> searchRmanOrders(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest,
			@RequestParam(value = "fetchAll", required = false) boolean fetchAll) {
		return rmanOrdersRepo.findAll(RevmantraUtils.fetchSpecification(RmanOrders.class, search),
				!fetchAll ? pageRequest : PageRequest.of(0, Integer.MAX_VALUE));
	}

	@GetMapping(value = "/api/checkFVExists")
	@ResponseBody
	public Boolean checkFVExists(@RequestParam(value = "fmvRuleName") String ruleName) {
		try {
			List<RmanFmvRulesDef> fmvRulesList = rmanFmvRulesDefRepo.findByFmvRuleNameIgnoreCase(ruleName);
			return fmvRulesList.isEmpty();

		} catch (Exception e) {
			logger.error("Getting error while validating the FMV Rule Name exists due to {}", e.getMessage());
			return false;
		}
	}

	@GetMapping(value = "/api/rmanPobMappingExport", produces = "application/vnd.ms-excel")
	@ResponseBody
	public String exportRmanPobMapping(@RequestParam(value = "search") String search,
			@RequestParam(value = "exportCols", required = false) List<String> columns,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest, HttpServletResponse response) {
		response.setHeader(CONSTANTS.CONTENT_DISPOSITION, "inline; filename=Rman_POB_Mappings.csv");
		Page<RmanPobMapping> page = rmanPobMappingRepo.findAll(
				RevmantraUtils.fetchSpecification(RmanPobMapping.class, search), PageRequest.of(0, Integer.MAX_VALUE));
		CsvMapper mapper = new CsvMapper();
		mapper.setDateFormat(new SimpleDateFormat(CONSTANTS.MM_DD_YYYY));
		mapper.enable(JsonGenerator.Feature.IGNORE_UNKNOWN);

		List<String> line1 = new ArrayList<>();
		CsvSchema schema = null;
		com.fasterxml.jackson.dataformat.csv.CsvSchema.Builder schemaBuilder = CsvSchema.builder()
				.setColumnSeparator(',');
		if (columns != null) {
			for (String column : columns) {
				if (column.equals("rmanLookupsV")) {
					schemaBuilder.addColumn("splitBasis");
				} else {
					schemaBuilder.addColumn(column);
				}
				line1.add(ExportColumns.pobMappingFields.get(column));
			}
			schema = schemaBuilder.setUseHeader(false).build();
		}

		ObjectWriter objectWriter = mapper.writer(schema);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		try {
			objectWriter.writeValue(baos, line1);
		} catch (JsonGenerationException jge) {
			logger.error(jge);
		} catch (JsonMappingException jme) {
			logger.error(jme);
		} catch (IOException ioe) {
			logger.error(ioe);
		}

		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(baos, 1024);
		OutputStreamWriter writerOutputStream;
		try {
			writerOutputStream = new OutputStreamWriter(bufferedOutputStream, StandardCharsets.UTF_8);
			objectWriter.writeValue(writerOutputStream, page.getContent());
			writerOutputStream.close();
		} catch (UnsupportedEncodingException uee) {
			logger.error(uee);
		} catch (JsonGenerationException jge) {
			logger.error(jge);
		} catch (JsonMappingException jme) {
			logger.error(jme);
		} catch (IOException ioe) {
			logger.error(ioe);
		}

		String csvData = baos.toString();
		try {
			baos.close();
		} catch (IOException ioe) {
			logger.error(ioe);
		}
		return csvData;
	}

	@GetMapping(value = "/api/getPeriodStartDate")
	@ResponseBody
	public String searchPeriodStartDate(@RequestParam(value = "periodName") String periodName) {
		return rmanFiscalPeriodsRepo.getPeriodStartDate(periodName);
	}

	@GetMapping(value = "/api/getPeriodEndDate")
	@ResponseBody
	public String searchPeriodEndDate(@RequestParam(value = "periodName") String periodName) {
		return rmanFiscalPeriodsRepo.getPeriodEndDate(periodName);
	}

	@GetMapping(value = "/api/rmanOrdersExport", produces = "application/vnd.ms-excel")
	@ResponseBody
	public String exportRmanOrdersExceptions(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest, HttpServletResponse response) {
		response.setHeader(CONSTANTS.CONTENT_DISPOSITION, "inline; filename=OrderLevelExceptions.csv");
		Page<RmanOrders> page = rmanOrdersRepo.findAll(RevmantraUtils.fetchSpecification(RmanOrders.class, search),
				PageRequest.of(0, Integer.MAX_VALUE));
		CsvMapper mapper = new CsvMapper();
		mapper.setDateFormat(new SimpleDateFormat(CONSTANTS.MM_DD_YYYY));
		mapper.enable(JsonGenerator.Feature.IGNORE_UNKNOWN);
		CsvSchema schema = CsvSchema.builder().setColumnSeparator(',').addColumn(CONSTANTS.ORDER_NUMBER)
				.addColumn(CONSTANTS.PRODUCT_NAME).addColumn(CONSTANTS.DEAL_NUMBER)
				.addColumn(CONSTANTS.DEAL_LINE_NUMBER).addColumn("exceptionMessage").setUseHeader(false).build();
		ObjectWriter objectWriter = mapper.writer(schema);

		List<String> line1 = new ArrayList<>();
		line1.add(CONSTANTS.SO_NUMBER);
		line1.add("Product in SO");
		line1.add("Deal Number");
		line1.add("Deal Line Number");
		line1.add("Exception Message");
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		try {
			objectWriter.writeValue(baos, line1);
		} catch (JsonGenerationException e1) {
			logger.error(e1);
		} catch (JsonMappingException e2) {
			logger.error(e2);
		} catch (IOException e3) {
			logger.error(e3);
		}

		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(baos, 1024);
		OutputStreamWriter writerOutputStream;
		try {
			writerOutputStream = new OutputStreamWriter(bufferedOutputStream, StandardCharsets.UTF_8);
			objectWriter.writeValue(writerOutputStream, page.getContent());
			writerOutputStream.close();
		} catch (UnsupportedEncodingException e) {
			logger.error(e);
		} catch (JsonGenerationException e1) {
			logger.error(e1);
		} catch (JsonMappingException e2) {
			logger.error(e2);
		} catch (IOException e3) {
			logger.error(e3);
		}
		String csvData = baos.toString();
		try {
			baos.close();
		} catch (IOException e) {
			logger.error(e);
		}
		return csvData;

	}

	@DeleteMapping(value = "/api/rmanUserResponsibility")
	public ResponseEntity<Void> deleteUserResponsibility(
			@RequestBody RmanUserResponsibilities rmanUserResponsibilities) {

		RmanUserResponsibilitiesPk id = new RmanUserResponsibilitiesPk(rmanUserResponsibilities.getRmanUserId(),
				rmanUserResponsibilities.getResponsibilityId());
		rmanUserResponsibilitiesRepo.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping(value = "/api/saveArrangement")
	@ResponseBody
	public RmanDealArrangements saveDealArrangement(@RequestBody RmanDealArrangements rmanDealArrangements) {

		try {
			RmanDealArrangements rmanDealArrangement = null;
			if (rmanDealArrangements.getDealAgreementId() != null) {
				rmanDealArrangement = rmanDealArrangementsRepo.save(rmanDealArrangements);
			} else {
				rmanDealArrangement = rmanDealArrangementsRepo.save(rmanDealArrangements);
				RmanDealStatus rmanDealStatus = new RmanDealStatus();
				rmanDealStatus.setDealHeaderId(rmanDealArrangement.getDealArrangementId());
				rmanDealStatus.setDealStatus("INPROGRESS");
				rmanDealStatusRepo.save(rmanDealStatus);
			}
			return rmanDealArrangement;
		} catch (Exception e) {
			logger.error("Getting Error while save the Arrangement due to {}", e.getMessage());
			return null;
		}
	}

	@GetMapping(value = "/api/rmanGetRevTotals", produces = "application/json")
	@ResponseBody
	public RmanRevenueTotals getRevTotals(@RequestParam(value = "arrgId") BigDecimal pArrgId,
			@RequestParam(value = "so") BigDecimal pso, @RequestParam(value = "soLine") String psoLine,
			@RequestParam(value = "revType") String pRevType) {
		List<Object[]> listTotals = null;

		if (pso != null && psoLine != null) {
			listTotals = rmanRevDetailsVRepo.revTotals4(pArrgId, pso, psoLine, pRevType);
		} else if (pso != null) {
			listTotals = rmanRevDetailsVRepo.revTotals2(pArrgId, pso, pRevType);
		} else if (psoLine != null) {
			listTotals = rmanRevDetailsVRepo.revTotals3(pArrgId, psoLine, pRevType);
		} else {
			listTotals = rmanRevDetailsVRepo.revTotals1(pArrgId, pRevType);
		}
		RmanRevenueTotals pRevTotal = new RmanRevenueTotals();
		pRevTotal.setTotalAllocation((BigDecimal) listTotals.get(0)[0]);
		pRevTotal.setDeliveredAllocationRsp((BigDecimal) listTotals.get(0)[1]);
		pRevTotal.setPostBillingContingency((BigDecimal) listTotals.get(0)[2]);
		pRevTotal.setPostBillingDeffered((BigDecimal) listTotals.get(0)[3]);
		pRevTotal.setPostBillingAllocation((BigDecimal) listTotals.get(0)[4]);
		pRevTotal.setRevenueBeginBalance((BigDecimal) listTotals.get(0)[5]);
		pRevTotal.setRevenueCurrentMonthBalance((BigDecimal) listTotals.get(0)[6]);
		pRevTotal.setRevenueEndBalance((BigDecimal) listTotals.get(0)[7]);
		pRevTotal.setTotalAllocationFc((BigDecimal) listTotals.get(0)[8]);
		pRevTotal.setDeliveredAllocFcRsp((BigDecimal) listTotals.get(0)[9]);
		pRevTotal.setPbDeferralFc((BigDecimal) listTotals.get(0)[10]);
		pRevTotal.setTotalBookedAmount((BigDecimal) listTotals.get(0)[11]);
		pRevTotal.setTotalShippedAmount((BigDecimal) listTotals.get(0)[12]);
		pRevTotal.setTotalBilledAmount((BigDecimal) listTotals.get(0)[13]);
		pRevTotal.setTotalUnamortizedAmount((BigDecimal) listTotals.get(0)[14]);
		pRevTotal.setTotalBilledAmountFc((BigDecimal) listTotals.get(0)[15]);
		pRevTotal.setTotalPostBollingAllocAmtTc((BigDecimal) listTotals.get(0)[16]);
		pRevTotal.setTotalRevBegBalTc((BigDecimal) listTotals.get(0)[17]);
		pRevTotal.setTotalRevCurrBalTc((BigDecimal) listTotals.get(0)[18]);
		pRevTotal.setTotalRevEndBalTc((BigDecimal) listTotals.get(0)[19]);
		pRevTotal.setTotalUnamortizedAmountTc((BigDecimal) listTotals.get(0)[20]);
		pRevTotal.setTotalRevenueAdjustment((BigDecimal) listTotals.get(0)[21]); // AYAR-1692 Added by chandra on
																					// 25-10-2021
		return pRevTotal;
	}

	@GetMapping(value = "/api/rmanGetAllocationTotals", produces = "application/json")
	@ResponseBody
	public RmanAllocationTotals getAllocationTotals(@RequestParam(value = "arrgId") BigDecimal pArrgId) {
		RmanAllocationTotals pAllocTotal = new RmanAllocationTotals();
		List<Object[]> listTotals = arrgContractAllocationsVRepo.allocationTotals(pArrgId);
		List<ArrgContractAllocationsV> allLines = arrgContractAllocationsVRepo
				.getAllocationsStatusByDealArrgId(pArrgId);
		for (ArrgContractAllocationsV eachLine : allLines) {
			if (eachLine.getRevenueGuidance() != null && eachLine.getRevenueGuidance().equalsIgnoreCase("RED")) {
				pAllocTotal.setTotalRevenueGuidanceAnalysis("RED");
				break;
			} else if (eachLine.getRevenueGuidance() != null
					&& eachLine.getRevenueGuidance().equalsIgnoreCase(CONSTANTS.YELLOW)) {
				pAllocTotal.setTotalRevenueGuidanceAnalysis(CONSTANTS.YELLOW);
				break;
			} else if (eachLine.getRevenueGuidance() != null) {
				pAllocTotal.setTotalRevenueGuidanceAnalysis("GREEN");
			}
		}

		List<String> linesFailed = new ArrayList<>();

		for (ArrgContractAllocationsV eachLine : allLines) {
			if (pAllocTotal.getTotalRevenueGuidanceAnalysis() != null
					&& pAllocTotal.getTotalRevenueGuidanceAnalysis().equalsIgnoreCase("RED")
					&& eachLine.getRevenueGuidance() != null && eachLine.getRevenueGuidance().equalsIgnoreCase("RED")) {
				linesFailed.add(eachLine.getDealLineNumber().toString());
			}
		}

		if (!linesFailed.isEmpty()) {
			pAllocTotal.setTotalRevenueGuidanceDescription(
					linesFailed.stream().map(Object::toString).collect(Collectors.joining(",")));
		}

		pAllocTotal.setTotalLineAmount((BigDecimal) listTotals.get(0)[0]);
		pAllocTotal.setTotalVCAmount((BigDecimal) listTotals.get(0)[1]);
		pAllocTotal.setTotalAllocableNetPrice((BigDecimal) listTotals.get(0)[2]);
		pAllocTotal.setTotalSSPAmount((BigDecimal) listTotals.get(0)[3]);
		pAllocTotal.setTotalAllocationAmount((BigDecimal) listTotals.get(0)[4]);
		pAllocTotal.setTotalAllocationFcAmount((BigDecimal) listTotals.get(0)[5]);
		pAllocTotal.setTotalCvInOutAmount((BigDecimal) listTotals.get(0)[6]);
		pAllocTotal.setTotalListAmount((BigDecimal) listTotals.get(0)[7]);
		pAllocTotal.setTotalEsp((BigDecimal) listTotals.get(0)[8]);
		pAllocTotal.setTotalEspinst((BigDecimal) listTotals.get(0)[9]);
		return pAllocTotal;
	}

	@GetMapping(value = "/api/rmanGetOrderAllocationTotals", produces = "application/json")
	@ResponseBody
	public RmanAllocationTotals getOrderAllocationTotals(@RequestParam(value = "arrgId") BigDecimal pArrgId) {
		RmanAllocationTotals pAllocTotal = new RmanAllocationTotals();
		List<Object[]> listTotals = arrgOrderAllocationsVRepo.allocationTotals(pArrgId);
		List<ArrgOrderAllocationsV> allLines = arrgOrderAllocationsVRepo.getAllocationsStatusByDealArrgId(pArrgId);
		for (ArrgOrderAllocationsV eachLine : allLines) {
			if (eachLine.getRevenueGuidance() != null && eachLine.getRevenueGuidance().equalsIgnoreCase("RED")) {
				pAllocTotal.setTotalRevenueGuidanceAnalysis("RED");
				break;
			} else if (eachLine.getRevenueGuidance() != null
					&& eachLine.getRevenueGuidance().equalsIgnoreCase(CONSTANTS.YELLOW)) {
				pAllocTotal.setTotalRevenueGuidanceAnalysis(CONSTANTS.YELLOW);
				break;
			} else if (eachLine.getRevenueGuidance() != null) {
				pAllocTotal.setTotalRevenueGuidanceAnalysis("GREEN");
			}
		}

		List<String> linesFailed = new ArrayList<>();

		for (ArrgOrderAllocationsV eachLine : allLines) {
			if (pAllocTotal.getTotalRevenueGuidanceAnalysis() != null
					&& pAllocTotal.getTotalRevenueGuidanceAnalysis().equalsIgnoreCase("RED")
					&& eachLine.getRevenueGuidance() != null && eachLine.getRevenueGuidance().equalsIgnoreCase("RED")) {
				linesFailed.add(eachLine.getDealLineNumber().toString());
			}
		}

		if (!linesFailed.isEmpty()) {
			pAllocTotal.setTotalRevenueGuidanceDescription(
					linesFailed.stream().map(Object::toString).collect(Collectors.joining(",")));
		}

		pAllocTotal.setTotalLineAmount((BigDecimal) listTotals.get(0)[0]);
		pAllocTotal.setTotalVCAmount((BigDecimal) listTotals.get(0)[1]);
		pAllocTotal.setTotalAllocableNetPrice((BigDecimal) listTotals.get(0)[2]);
		pAllocTotal.setTotalSSPAmount((BigDecimal) listTotals.get(0)[3]);
		pAllocTotal.setTotalAllocationAmount((BigDecimal) listTotals.get(0)[4]);
		pAllocTotal.setTotalAllocationFcAmount((BigDecimal) listTotals.get(0)[5]);
		pAllocTotal.setTotalCvInOutAmount((BigDecimal) listTotals.get(0)[6]);
		pAllocTotal.setTotalListAmount((BigDecimal) listTotals.get(0)[7]);
		pAllocTotal.setTotalEsp((BigDecimal) listTotals.get(0)[8]);
		pAllocTotal.setTotalEspinst((BigDecimal) listTotals.get(0)[9]);

		return pAllocTotal;
	}

	@PostMapping(value = "/api/rmanGetLookupCodes")
	@ResponseBody
	public Map<String, List<RmanLookupCodes>> fetchLookupCodes(@RequestBody Map<String, List<String>> y) {

		List<RmanLookupCodes> lcList = rmanLookupCodesRepo.fetchAllLookupCodes(y.get("lookupTypes"));

		return lcList.stream().collect(Collectors.groupingBy(w -> w.getLookupTypeCode()));

	}

	@PostMapping(value = "/api/saveRmanContLinkedTemplates", consumes = "application/json")
	@ResponseBody
	public void saveAssigedTemplatedToContingency(@RequestBody TargetContTemplates trgContTemplatesList) {
		BigDecimal contRuleId = trgContTemplatesList.getContRuleHeaderId();
		List<RmanContLinkedTemplateSv> existsList = rmanContLinkedTemplateSvRepo.findByRuleHeaderId(contRuleId);
		List<BigDecimal> existsTemps = new ArrayList<>();
		List<BigDecimal> trgTemps = trgContTemplatesList.getRmanContTemplateList();

		existsList.forEach(el -> existsTemps.add(el.getTemplateId()));

		if (existsTemps.isEmpty() && trgTemps.isEmpty()) {
			throw new AyaraCustomException("Assign at least one template to the selected contingency");
		}

		List<BigDecimal> sTemps = trgTemps.stream().filter(i -> !existsTemps.contains(i)).collect(Collectors.toList());

		List<BigDecimal> dTemps = existsTemps.stream().filter(i -> !trgTemps.contains(i)).collect(Collectors.toList());

		if (!sTemps.isEmpty()) {
			List<RmanContLinkedTemplateSv> sList = new ArrayList<>();
			sTemps.forEach(st -> {
				RmanContLinkedTemplateSv rct = new RmanContLinkedTemplateSv();
				rct.setRuleHeaderId(contRuleId);
				rct.setTemplateId(st);
				sList.add(rct);
			});

			if (!sList.isEmpty())
				rmanContLinkedTemplateSvRepo.saveAll(sList);
		}
		if (!dTemps.isEmpty()) {
			List<RmanContLinkedTemplateSv> dList = new ArrayList<>();
			dTemps.forEach(st -> {
				Optional<RmanContLinkedTemplateSv> x = rmanContLinkedTemplateSvRepo
						.findById(new RmanContLinkedtemplatesId(contRuleId, st));
				x.ifPresent(dList::add);
			});
			if (!dList.isEmpty())
				rmanContLinkedTemplateSvRepo.deleteInBatch(dList);
		}

	}

	@GetMapping(value = "/api/rmanOrdersInterfaceSearch")
	@ResponseBody
	public Page<RmanOrdersInterface> searchRmanOrdersInterface(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return rmanOrdersInterfaceRepo.findAll(RevmantraUtils.fetchSpecification(RmanOrdersInterface.class, search),
				pageRequest);
	}

	@PostMapping(value = "/api/saveRmanOrdersInterface")
	@ResponseBody
	public Map<String, String> saveRmanOrdersInterface(@RequestBody List<RmanOrdersInterface> rmanOrdersInterfaceList) {
		if (!rmanOrdersInterfaceList.isEmpty()) {
			rmanOrdersInterfaceRepo.saveAll(rmanOrdersInterfaceList);
		} else {
			throw new AyaraCustomException("At least one record must be change to submit.");
		}
		Map<String, String> x = new HashMap<>();
		x.put("Sucess", "true");
		return x;

	}

	@GetMapping(value = "/api/rmanInvoiceLinesInterfaceSearch")
	@ResponseBody
	public Page<RmanInvoiceLinesInterface> searchRmanInvoiceLinesInterface(
			@RequestParam(value = "search") String search, @PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return rmanInvoiceLinesInterfaceRepo
				.findAll(RevmantraUtils.fetchSpecification(RmanInvoiceLinesInterface.class, search), pageRequest);
	}

	@PostMapping(value = "/api/saveRmanInvoiceLinesInterface")
	@ResponseBody
	public Map<String, String> saveRmanInvoiceLinesInterface(
			@RequestBody List<RmanInvoiceLinesInterface> rmanInvoiceLinesInterfaceList) {
		if (!rmanInvoiceLinesInterfaceList.isEmpty()) {
			rmanInvoiceLinesInterfaceRepo.saveAll(rmanInvoiceLinesInterfaceList);
		} else {
			throw new AyaraCustomException("At least one record must be change to submit.");
		}
		Map<String, String> x = new HashMap<>();
		x.put("Sucess", "true");
		return x;

	}

	@GetMapping(value = "/api/rmanBookedOrdersInterfaceSearch")
	@ResponseBody
	public Page<RmanOrdersInterface> searchRmanBookedOrdersInterface(
			@RequestParam(value = CONSTANTS.ORDER_NUMBER, required = false) String orderNumber,
			@RequestParam(value = CONSTANTS.SOURCE_LINE_NUMBER, required = false) String sourceLineNumber,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest,
			@RequestParam(value = "otype", defaultValue = "B") String orderType) {

		return rmanOrdersInterfaceRepo.bookedOrders(orderNumber, sourceLineNumber, pageRequest);
	}

	@GetMapping(value = "/api/rmanShippedOrdersInterfaceSearch")
	@ResponseBody
	public Page<RmanOrdersInterface> searchRmanShippedOrdersInterface(
			@RequestParam(value = CONSTANTS.ORDER_NUMBER, required = false) String orderNumber,
			@RequestParam(value = CONSTANTS.SOURCE_LINE_NUMBER, required = false) String sourceLineNumber,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest,
			@RequestParam(value = "otype", defaultValue = "S") String orderType) {

		return rmanOrdersInterfaceRepo.shippedOrders(orderNumber, sourceLineNumber, pageRequest);
	}

	// Interface Exceptions Export Methods for Bookings,Shipments and Billings

	@GetMapping(value = "/api/rmanOrderBookingsInterfaceExport", produces = "application/vnd.ms-excel")
	@ResponseBody
	public String exportRmanOrderBookingsInterface(
			@RequestParam(value = CONSTANTS.ORDER_NUMBER, required = false) String orderNumber,
			@RequestParam(value = CONSTANTS.SOURCE_LINE_NUMBER, required = false) String sourceLineNumber,
			@RequestParam(value = "otype", defaultValue = "B") String orderType,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest, HttpServletResponse response) {
		response.setHeader(CONSTANTS.CONTENT_DISPOSITION, "inline; filename=RmanOrderBookingsInterface.csv");

		Page<RmanOrdersInterface> page = null;
		page = rmanOrdersInterfaceRepo.bookedOrders(orderNumber, sourceLineNumber,
				PageRequest.of(0, Integer.MAX_VALUE));
		CsvMapper mapper = new CsvMapper();
		mapper.setDateFormat(new SimpleDateFormat(CONSTANTS.MM_DD_YYYY));
		mapper.enable(JsonGenerator.Feature.IGNORE_UNKNOWN);
		CsvSchema schema = CsvSchema.builder().setColumnSeparator(',').addColumn(CONSTANTS.SOURCE_HEADER_ID)
				.addColumn(CONSTANTS.ORDER_NUMBER).addColumn(CONSTANTS.CUSTOMER_PO_NUMBER)
				.addColumn(CONSTANTS.ORDER_TYPE).addColumn("bookingEntityId").addColumn("shippingEntityId")
				.addColumn(CONSTANTS.SOLD_TO_CUSTOMER).addColumn(CONSTANTS.BILLTOCUSTOMERNUMBER)
				.addColumn(CONSTANTS.BILLTOCUSTOMER).addColumn(CONSTANTS.SHIP_TO_CUSTOMER)
				.addColumn(CONSTANTS.SHIP_TO_CUSTOMER_NUMBER).addColumn(CONSTANTS.BILLTOCOUNTRY)
				.addColumn(CONSTANTS.SHIP_TO_COUNTRY).addColumn(CONSTANTS.SHIPPING_ORG_CODE)
				.addColumn(CONSTANTS.BOOKEDDATE).addColumn(CONSTANTS.ORDERED_DATE)
				.addColumn(CONSTANTS.SCHEDULE_SHIP_DATE).addColumn(CONSTANTS.ORDER_STATUS)
				.addColumn(CONSTANTS.PRICE_LIST).addColumn(CONSTANTS.BOOKINGCURRENCY)
				.addColumn(CONSTANTS.SOURCE_LINE_ID).addColumn(CONSTANTS.SOURCE_LINE_NUMBER)
				.addColumn(CONSTANTS.PRODUCT_NAME).addColumn(CONSTANTS.PRODUCT_ORG_NAME)
				.addColumn(CONSTANTS.ORDERED_QUANTITY).addColumn(CONSTANTS.SHIPPED_QUANTITY)
				.addColumn(CONSTANTS.FULFILLED_QUANTITY).addColumn(CONSTANTS.LINE_STATUS)
				.addColumn(CONSTANTS.UNIT_SELLING_PRICE).addColumn(CONSTANTS.UNIT_LIST_PRICE)
				.addColumn(CONSTANTS.EXTENDED_LIST_AMOUNT).addColumn(CONSTANTS.EXTENDED_SELLING_AMOUNT)
				.addColumn(CONSTANTS.DISCOUNT_PERCENTAGE).addColumn(CONSTANTS.ORIGINAL_LINE_ID)
				.addColumn(CONSTANTS.ORIGINAL_LINE_NUMBER).addColumn(CONSTANTS.ORIGINAL_ORDER_NUMBER)
				.addColumn(CONSTANTS.SERVICE_START_DATE).addColumn(CONSTANTS.SERVICE_END_DATE)
				.addColumn(CONSTANTS.SERVICE_DURATION).addColumn(CONSTANTS.SERVICE_PERIOD)
				.addColumn(CONSTANTS.ACTUALFULFILLEDDATE).addColumn(CONSTANTS.LINE_COST)
				.addColumn(CONSTANTS.DOMESTRIC_INTERNATIONAL).addColumn(CONSTANTS.REGION).addColumn(CONSTANTS.TERRITORY)
				.addColumn(CONSTANTS.REV_REC_HOLD_TYPE).addColumn(CONSTANTS.CANCELLEDQTY)
				.addColumn(CONSTANTS.CANCELLEDDATE).addColumn(CONSTANTS.LINE_CATEGORY_CODE)
				.addColumn(CONSTANTS.CUSTOMER_NUMBER).addColumn(CONSTANTS.EXT_WARRANTY_SKU)
				.addColumn(CONSTANTS.EXT_SERVICE_START_DATE).addColumn(CONSTANTS.EXT_SERV_END_DATE)
				.addColumn(CONSTANTS.EXT_PERIOD).addColumn(CONSTANTS.EXT_DURATION).addColumn(CONSTANTS.EXT_LIST_PRICE)
				.addColumn(CONSTANTS.EXT_DISCOUNT).addColumn(CONSTANTS.SUPPORT_SKU)
				.addColumn(CONSTANTS.SUPPORT_SERVICE_START_DATE).addColumn(CONSTANTS.SUPPORT_SERVICE_END_DATE)
				.addColumn(CONSTANTS.SUPPORT_PERIOD).addColumn(CONSTANTS.SUPPORT_DURATION)
				.addColumn(CONSTANTS.SUPPORT_LIST_PRICE).addColumn(CONSTANTS.SUPPORT_DISCOUNT)
				.addColumn(CONSTANTS.TRAINING_SKU).addColumn(CONSTANTS.PERCENTAGE_SPLIT).addColumn(CONSTANTS.SALES_REP)
				.addColumn(CONSTANTS.DEAL_NUMBER).addColumn(CONSTANTS.DEAL_LINE_NUMBER)
				.addColumn(CONSTANTS.ERROR_MESSAGE).setUseHeader(false).build();
		ObjectWriter objectWriter = mapper.writer(schema);
		List<String> line1 = new ArrayList<>();

		line1.add(CONSTANTS.HEADER_ID);
		line1.add(CONSTANTS.ORDER_NUMBER_CAPS);
		line1.add(CONSTANTS.CUSTOMER_PO);
		line1.add(CONSTANTS.ORDER_TYPE);
		line1.add("BOOKING_ENTITY_ID");
		line1.add("SHIPPING_ENTITY_ID");
		line1.add(CONSTANTS.SOLD_TO_CUSTOMER);
		line1.add(CONSTANTS.BILL_TO_CUSTOMER_NUMBER_CAPS);
		line1.add(CONSTANTS.BILL_TO_CUSTOMER);
		line1.add(CONSTANTS.SHIP_TO_CUSTOMER);
		line1.add(CONSTANTS.SHIP_TO_CUSTOMER_NUMBER);
		line1.add(CONSTANTS.BILL_TO_COUNTRY);
		line1.add(CONSTANTS.SHIP_TO_COUNTRY);
		line1.add(CONSTANTS.SHIPPING_ORG_CODE);
		line1.add(CONSTANTS.BOOKED_DATE_CAPS);
		line1.add(CONSTANTS.ORDERED_DATE);
		line1.add(CONSTANTS.SCHEDULE_SHIP_DATE);
		line1.add(CONSTANTS.ORDER_STATUS);
		line1.add(CONSTANTS.PRICE_LIST_CAPS);
		line1.add(CONSTANTS.BOOKING_CURRENCY_CAPS);
		line1.add(CONSTANTS.SOURCE_LINE_ID_CAPS);
		line1.add(CONSTANTS.SOURCE_LINE_NUMBER_CAPS);
		line1.add(CONSTANTS.PRODUCT_NAME_CAPS);
		line1.add(CONSTANTS.PRODUCT_ORG_NAME);
		line1.add(CONSTANTS.ORDERED_QUANTITY_CAPS);
		line1.add(CONSTANTS.SHIPPED_QUANTITY);
		line1.add(CONSTANTS.FULFILLED_QUANTITY);
		line1.add(CONSTANTS.LINE_STATUS_CAPS);
		line1.add(CONSTANTS.SELLING_PRICE);
		line1.add(CONSTANTS.LIST_PRICE);
		line1.add(CONSTANTS.EXTENDED_LIST_AMT);
		line1.add(CONSTANTS.EXT_SELLING_AMT);
		line1.add(CONSTANTS.DISCOUNT_PERCENT);
		line1.add(CONSTANTS.REFERECE_LINE_ID);
		line1.add(CONSTANTS.REFERENCE_LINE_NUMBER);
		line1.add(CONSTANTS.REFERENCE_ORDER_NUMBER);
		line1.add(CONSTANTS.SERVICE_START_DATE_CAPS);
		line1.add(CONSTANTS.SERVICE_END_DATE_CAPS);
		line1.add(CONSTANTS.SERVICE_DURATION);
		line1.add(CONSTANTS.SERVICE_PERIOD);
		line1.add(CONSTANTS.ACTUAL_FULFILLED_DATE_CAPS);
		line1.add(CONSTANTS.UNIT_COST);
		line1.add(CONSTANTS.DOMESTIC_INTERNATIONAL);
		line1.add(CONSTANTS.REGION);
		line1.add(CONSTANTS.TERRITORY);
		line1.add(CONSTANTS.REV_REC_HOLD_TYPE);
		line1.add(CONSTANTS.CANCELLED_QTY);
		line1.add(CONSTANTS.CANCELLED_DATE);
		line1.add(CONSTANTS.LINE_CATEGORY_CODE);
		line1.add(CONSTANTS.CUSTOMER_NUMBER_CAPS);
		line1.add(CONSTANTS.EXT_WARRANTY_SKU);
		line1.add(CONSTANTS.EXT_SERV_START_DATE);
		line1.add(CONSTANTS.EXT_SERV_END_DATE);
		line1.add(CONSTANTS.EXT_PERIOD);
		line1.add(CONSTANTS.EXT_DURATION);
		line1.add(CONSTANTS.EXT_LIST_PRICE);
		line1.add(CONSTANTS.EXT_DISCOUNT);
		line1.add(CONSTANTS.SUPPORT_SKU);
		line1.add(CONSTANTS.SUPPORT_SERV_START_DATE);
		line1.add(CONSTANTS.SUPPORT_SERV_END_DATE);
		line1.add(CONSTANTS.SUPPORT_PERIOD);
		line1.add(CONSTANTS.SUPPORT_DURATION);
		line1.add(CONSTANTS.SUPPORT_LIST_PRICE);
		line1.add(CONSTANTS.SUPPORT_DISCOUNT);
		line1.add(CONSTANTS.TRAINING_SKU);
		line1.add(CONSTANTS.PERCENTAGE_SPLIT);
		line1.add(CONSTANTS.SALES_REP_CAPS);
		line1.add("DEAL_NUMBER");
		line1.add("DEAL_LINE_NUMBER");
		line1.add(CONSTANTS.ERROR_MESSAGE_LABEL);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		try {
			objectWriter.writeValue(baos, line1);
		} catch (JsonGenerationException jge) {
			logger.error(jge);
		} catch (JsonMappingException jme) {
			logger.error(jme);
		} catch (IOException ioe) {
			logger.error(ioe);
		}

		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(baos, 1024);
		OutputStreamWriter writerOutputStream;
		try {
			writerOutputStream = new OutputStreamWriter(bufferedOutputStream, StandardCharsets.UTF_8);
			objectWriter.writeValue(writerOutputStream, page.getContent());
			writerOutputStream.close();
		} catch (UnsupportedEncodingException uee) {
			logger.error(uee);
		} catch (JsonGenerationException jge) {
			logger.error(jge);
		} catch (JsonMappingException jme) {
			logger.error(jme);
		} catch (IOException ioe) {
			logger.error(ioe);
		}

		String csvData = baos.toString();
		try {
			baos.close();
		} catch (IOException ioe) {
			logger.error(ioe);
		}
		return csvData;
	}

	@GetMapping(value = "/api/rmanOrderShipmentsInterfaceExport", produces = "application/vnd.ms-excel")
	@ResponseBody
	public String exportRmanOrderShipmentsInterface(
			@RequestParam(value = CONSTANTS.ORDER_NUMBER, required = false) String orderNumber,
			@RequestParam(value = CONSTANTS.SOURCE_LINE_NUMBER, required = false) String sourceLineNumber,
			@RequestParam(value = "otype", defaultValue = "S") String orderType,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest, HttpServletResponse response) {
		response.setHeader(CONSTANTS.CONTENT_DISPOSITION, "inline; filename=RmanOrderShipmentsInterface.csv");

		Page<RmanOrdersInterface> page = null;
		page = rmanOrdersInterfaceRepo.shippedOrders(orderNumber, sourceLineNumber,
				PageRequest.of(0, Integer.MAX_VALUE));
		CsvMapper mapper = new CsvMapper();
		mapper.setDateFormat(new SimpleDateFormat(CONSTANTS.MM_DD_YYYY));
		mapper.enable(JsonGenerator.Feature.IGNORE_UNKNOWN);
		CsvSchema schema = CsvSchema.builder().setColumnSeparator(',').addColumn(CONSTANTS.SOURCE_HEADER_ID)
				.addColumn(CONSTANTS.ORDER_NUMBER).addColumn(CONSTANTS.CUSTOMER_PO_NUMBER)
				.addColumn(CONSTANTS.ORDER_TYPE).addColumn("bookingEntityId").addColumn("shippingEntityId")
				.addColumn(CONSTANTS.SOLD_TO_CUSTOMER).addColumn(CONSTANTS.BILLTOCUSTOMERNUMBER)
				.addColumn(CONSTANTS.BILLTOCUSTOMER).addColumn(CONSTANTS.SHIP_TO_CUSTOMER)
				.addColumn(CONSTANTS.SHIP_TO_CUSTOMER_NUMBER).addColumn(CONSTANTS.BILLTOCOUNTRY)
				.addColumn(CONSTANTS.SHIP_TO_COUNTRY).addColumn(CONSTANTS.SHIPPING_ORG_CODE)
				.addColumn(CONSTANTS.BOOKEDDATE).addColumn(CONSTANTS.ORDERED_DATE)
				.addColumn(CONSTANTS.SCHEDULE_SHIP_DATE).addColumn(CONSTANTS.ORDER_STATUS)
				.addColumn(CONSTANTS.PRICE_LIST).addColumn(CONSTANTS.BOOKINGCURRENCY)
				.addColumn(CONSTANTS.SOURCE_LINE_ID).addColumn(CONSTANTS.SOURCE_LINE_NUMBER)
				.addColumn(CONSTANTS.PRODUCT_NAME).addColumn(CONSTANTS.PRODUCT_ORG_NAME)
				.addColumn(CONSTANTS.ORDERED_QUANTITY).addColumn(CONSTANTS.SHIPPED_QUANTITY)
				.addColumn(CONSTANTS.FULFILLED_QUANTITY).addColumn(CONSTANTS.LINE_STATUS)
				.addColumn(CONSTANTS.UNIT_SELLING_PRICE).addColumn(CONSTANTS.UNIT_LIST_PRICE)
				.addColumn(CONSTANTS.EXTENDED_LIST_AMOUNT).addColumn(CONSTANTS.EXTENDED_SELLING_AMOUNT)
				.addColumn(CONSTANTS.DISCOUNT_PERCENTAGE).addColumn(CONSTANTS.ORIGINAL_LINE_ID)
				.addColumn(CONSTANTS.ORIGINAL_LINE_NUMBER).addColumn(CONSTANTS.ORIGINAL_ORDER_NUMBER)
				.addColumn(CONSTANTS.SERVICE_START_DATE).addColumn(CONSTANTS.SERVICE_END_DATE)
				.addColumn(CONSTANTS.SERVICE_DURATION).addColumn(CONSTANTS.SERVICE_PERIOD)
				.addColumn(CONSTANTS.ACTUALFULFILLEDDATE).addColumn(CONSTANTS.LINE_COST)
				.addColumn(CONSTANTS.DOMESTRIC_INTERNATIONAL).addColumn(CONSTANTS.REGION).addColumn(CONSTANTS.TERRITORY)
				.addColumn(CONSTANTS.REV_REC_HOLD_TYPE).addColumn(CONSTANTS.CANCELLEDQTY)
				.addColumn(CONSTANTS.CANCELLEDDATE).addColumn(CONSTANTS.LINE_CATEGORY_CODE)
				.addColumn(CONSTANTS.CUSTOMER_NUMBER).addColumn(CONSTANTS.EXT_WARRANTY_SKU)
				.addColumn(CONSTANTS.EXT_SERVICE_START_DATE).addColumn(CONSTANTS.EXT_SERV_END_DATE)
				.addColumn(CONSTANTS.EXT_PERIOD).addColumn(CONSTANTS.EXT_DURATION).addColumn(CONSTANTS.EXT_LIST_PRICE)
				.addColumn(CONSTANTS.EXT_DISCOUNT).addColumn(CONSTANTS.SUPPORT_SKU)
				.addColumn(CONSTANTS.SUPPORT_SERVICE_START_DATE).addColumn(CONSTANTS.SUPPORT_SERVICE_END_DATE)
				.addColumn(CONSTANTS.SUPPORT_PERIOD).addColumn(CONSTANTS.SUPPORT_DURATION)
				.addColumn(CONSTANTS.SUPPORT_LIST_PRICE).addColumn(CONSTANTS.SUPPORT_DISCOUNT)
				.addColumn(CONSTANTS.TRAINING_SKU).addColumn(CONSTANTS.PERCENTAGE_SPLIT).addColumn(CONSTANTS.SALES_REP)
				.addColumn(CONSTANTS.DEAL_NUMBER).addColumn(CONSTANTS.DEAL_LINE_NUMBER)
				.addColumn(CONSTANTS.ERROR_MESSAGE).setUseHeader(false).build();
		ObjectWriter objectWriter = mapper.writer(schema);
		List<String> line1 = new ArrayList<>();

		line1.add(CONSTANTS.HEADER_ID);
		line1.add(CONSTANTS.ORDER_NUMBER_CAPS);
		line1.add(CONSTANTS.CUSTOMER_PO);
		line1.add(CONSTANTS.ORDER_TYPE);
		line1.add("BOOKING_ENTITY_ID");
		line1.add("SHIPPING_ENTITY_ID");
		line1.add(CONSTANTS.SOLD_TO_CUSTOMER);
		line1.add(CONSTANTS.BILL_TO_CUSTOMER_NUMBER_CAPS);
		line1.add(CONSTANTS.BILL_TO_CUSTOMER);
		line1.add(CONSTANTS.SHIP_TO_CUSTOMER);
		line1.add(CONSTANTS.SHIP_TO_CUSTOMER_NUMBER);
		line1.add(CONSTANTS.BILL_TO_COUNTRY);
		line1.add(CONSTANTS.SHIP_TO_COUNTRY);
		line1.add(CONSTANTS.SHIPPING_ORG_CODE);
		line1.add(CONSTANTS.BOOKED_DATE_CAPS);
		line1.add(CONSTANTS.ORDERED_DATE);
		line1.add(CONSTANTS.SCHEDULE_SHIP_DATE);
		line1.add(CONSTANTS.ORDER_STATUS);
		line1.add(CONSTANTS.PRICE_LIST_CAPS);
		line1.add(CONSTANTS.BOOKING_CURRENCY_CAPS);
		line1.add(CONSTANTS.SOURCE_LINE_ID_CAPS);
		line1.add(CONSTANTS.SOURCE_LINE_NUMBER_CAPS);
		line1.add(CONSTANTS.PRODUCT_NAME_CAPS);
		line1.add(CONSTANTS.PRODUCT_ORG_NAME);
		line1.add(CONSTANTS.ORDERED_QUANTITY_CAPS);
		line1.add(CONSTANTS.SHIPPED_QUANTITY);
		line1.add(CONSTANTS.FULFILLED_QUANTITY);
		line1.add(CONSTANTS.LINE_STATUS_CAPS);
		line1.add(CONSTANTS.SELLING_PRICE);
		line1.add(CONSTANTS.LIST_PRICE);
		line1.add(CONSTANTS.EXTENDED_LIST_AMT);
		line1.add(CONSTANTS.EXT_SELLING_AMT);
		line1.add(CONSTANTS.DISCOUNT_PERCENT);
		line1.add(CONSTANTS.REFERECE_LINE_ID);
		line1.add(CONSTANTS.REFERENCE_LINE_NUMBER);
		line1.add(CONSTANTS.REFERENCE_ORDER_NUMBER);
		line1.add(CONSTANTS.SERVICE_START_DATE_CAPS);
		line1.add(CONSTANTS.SERVICE_END_DATE_CAPS);
		line1.add(CONSTANTS.SERVICE_DURATION);
		line1.add(CONSTANTS.SERVICE_PERIOD);
		line1.add(CONSTANTS.ACTUAL_FULFILLED_DATE_CAPS);
		line1.add(CONSTANTS.UNIT_COST);
		line1.add(CONSTANTS.DOMESTIC_INTERNATIONAL);
		line1.add(CONSTANTS.REGION);
		line1.add(CONSTANTS.TERRITORY);
		line1.add(CONSTANTS.REV_REC_HOLD_TYPE);
		line1.add(CONSTANTS.CANCELLED_QTY);
		line1.add(CONSTANTS.CANCELLED_DATE);
		line1.add(CONSTANTS.LINE_CATEGORY_CODE);
		line1.add(CONSTANTS.CUSTOMER_NUMBER_CAPS);
		line1.add(CONSTANTS.EXT_WARRANTY_SKU);
		line1.add(CONSTANTS.EXT_SERV_START_DATE);
		line1.add(CONSTANTS.EXT_SERV_END_DATE);
		line1.add(CONSTANTS.EXT_PERIOD);
		line1.add(CONSTANTS.EXT_DURATION);
		line1.add(CONSTANTS.EXT_LIST_PRICE);
		line1.add(CONSTANTS.EXT_DISCOUNT);
		line1.add(CONSTANTS.SUPPORT_SKU);
		line1.add(CONSTANTS.SUPPORT_SERV_START_DATE);
		line1.add(CONSTANTS.SUPPORT_SERV_END_DATE);
		line1.add(CONSTANTS.SUPPORT_PERIOD);
		line1.add(CONSTANTS.SUPPORT_DURATION);
		line1.add(CONSTANTS.SUPPORT_LIST_PRICE);
		line1.add(CONSTANTS.SUPPORT_DISCOUNT);
		line1.add(CONSTANTS.TRAINING_SKU);
		line1.add(CONSTANTS.PERCENTAGE_SPLIT);
		line1.add(CONSTANTS.SALES_REP_CAPS);
		line1.add("DEAL_NUMBER");
		line1.add("DEAL_LINE_NUMBER");
		line1.add(CONSTANTS.ERROR_MESSAGE_LABEL);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		try {
			objectWriter.writeValue(baos, line1);
		} catch (JsonGenerationException jge) {
			logger.error(jge);
		} catch (JsonMappingException jme) {
			logger.error(jme);
		} catch (IOException ioe) {
			logger.error(ioe);
		}

		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(baos, 1024);
		OutputStreamWriter writerOutputStream;
		try {
			writerOutputStream = new OutputStreamWriter(bufferedOutputStream, StandardCharsets.UTF_8);
			objectWriter.writeValue(writerOutputStream, page.getContent());
			writerOutputStream.close();
		} catch (UnsupportedEncodingException uee) {
			logger.error(uee);
		} catch (JsonGenerationException jge) {
			logger.error(jge);
		} catch (JsonMappingException jme) {
			logger.error(jme);
		} catch (IOException ioe) {
			logger.error(ioe);
		}

		String csvData = baos.toString();
		try {
			baos.close();
		} catch (IOException ioe) {
			logger.error(ioe);
		}
		return csvData;
	}

	@GetMapping(value = "/api/rmanBillingsInterfaceExport", produces = "application/vnd.ms-excel")
	@ResponseBody
	public String exportRmanBillingsInterface(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest, HttpServletResponse response) {
		response.setHeader(CONSTANTS.CONTENT_DISPOSITION, "inline; filename=RmanBillingsInterface.csv");
		List<RmanInvoiceLinesInterface> invInterfaceList = rmanInvoiceLinesInterfaceRepo
				.findAll(RevmantraUtils.fetchSpecification(RmanInvoiceLinesInterface.class, search));
		CsvMapper mapper = new CsvMapper();
		mapper.setDateFormat(new SimpleDateFormat(CONSTANTS.MM_DD_YYYY));
		mapper.enable(JsonGenerator.Feature.IGNORE_UNKNOWN);
		CsvSchema schema = CsvSchema.builder().setColumnSeparator(',').addColumn("sourceInvoiceId")
				.addColumn("sourceInvoiceLineId").addColumn("invoiceType").addColumn("invoiceSource")
				.addColumn("invoiceTrxType").addColumn("invoiceNumber").addColumn("invoicedDate")
				.addColumn("salesOrderNumber").addColumn("salesOrderLine").addColumn("salesOrderLineId")
				.addColumn("invoiceLineNumber").addColumn("lineType").addColumn("quantityInvoiced")
				.addColumn(CONSTANTS.UNIT_SELLING_PRICE).addColumn("invoiceCurrency").addColumn("revenueAmount")
				.addColumn("acctdCurrency").addColumn("acctdRevAmount").addColumn(CONSTANTS.FX_RATE)
				.addColumn(CONSTANTS.FX_DATE).addColumn(CONSTANTS.ERROR_MESSAGE).setUseHeader(false).build();
		ObjectWriter objectWriter = mapper.writer(schema);
		List<String> line1 = new ArrayList<>();

		line1.add("SOURCE_INVOICE_ID");
		line1.add("SOURCE_INVOICE_LINE_ID");
		line1.add("INVOICE_TYPE");
		line1.add("INVOICE_SOURCE");
		line1.add("INVOICE_TRX_TYPE");
		line1.add("INVOICE_NUMBER");
		line1.add("INVOICE_DATE");
		line1.add("SALES_ORDER");
		line1.add("SALES_ORDER_LINE");
		line1.add("SALES_ORDER_LINE_ID");
		line1.add("INVOICE_LINE_NUMBER");
		line1.add("LINE_TYPE");
		line1.add("QUANTITY_INVOICED");
		line1.add("UNIT_SELLING_PRICE");
		line1.add("INVOICE_CURRENCY_CODE");
		line1.add("INVOICE_AMOUNT");
		line1.add("ACCOUNTED_CURRENCY");
		line1.add("ACCOUNTED_AMOUNT");
		line1.add("FX_RATE");
		line1.add("FX_DATE");
		line1.add(CONSTANTS.ERROR_MESSAGE_LABEL);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		try {
			objectWriter.writeValue(baos, line1);
		} catch (JsonGenerationException jge) {
			logger.error(jge);
		} catch (JsonMappingException jme) {
			logger.error(jme);
		} catch (IOException ioe) {
			logger.error(ioe);
		}

		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(baos, 1024);
		OutputStreamWriter writerOutputStream;
		try {
			writerOutputStream = new OutputStreamWriter(bufferedOutputStream, StandardCharsets.UTF_8);
			objectWriter.writeValue(writerOutputStream, invInterfaceList);
			writerOutputStream.close();
		} catch (UnsupportedEncodingException uee) {
			logger.error(uee);
		} catch (JsonGenerationException jge) {
			logger.error(jge);
		} catch (JsonMappingException jme) {
			logger.error(jme);
		} catch (IOException ioe) {
			logger.error(ioe);
		}

		String csvData = baos.toString();
		try {
			baos.close();
		} catch (IOException ioe) {
			logger.error(ioe);
		}
		return csvData;
	}

	public void deletebookingsOrder() {
		Page<RmanOrdersInterface> bookingList = rmanOrdersInterfaceRepo.bookedOrders(null, null,
				PageRequest.of(0, Integer.MAX_VALUE));
		rmanOrdersInterfaceRepo.deleteInBatch(bookingList.getContent());

	}

	@GetMapping(value = "/api/rmanFMVRulesExport", produces = "application/vnd.ms-excel")
	@ResponseBody
	public String exportRmanFMVRules(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest, HttpServletResponse response) {

		response.setHeader(CONSTANTS.CONTENT_DISPOSITION, "inline; filename=Rman_FMV_Rules.csv");
		List<RmanFmvRulesExportV> sspList = rmanFmvRulesExportVRepo
				.findAll(RevmantraUtils.fetchSpecification(RmanFmvRulesExportV.class, search));
		CsvMapper mapper = new CsvMapper();
		mapper.setDateFormat(new SimpleDateFormat(CONSTANTS.MM_DD_YYYY));
		mapper.enable(JsonGenerator.Feature.IGNORE_UNKNOWN);
		CsvSchema schema = CsvSchema.builder().setColumnSeparator(',').addColumn("fmvRuleName").addColumn("fmvCategory")
				.addColumn("fmvType").addColumn("fmvRuleStatus").addColumn("fmvPrice").addColumn("min")
				.addColumn("median").addColumn("max").addColumn("quarterStartDate").addColumn("quarterEndDate")
				.addColumn("currency").addColumn("parameterName1").addColumn("parameterValue1")
				.addColumn("parameterName2").addColumn("parameterValue2").setUseHeader(false).build();
		ObjectWriter objectWriter = mapper.writer(schema);

		List<String> line1 = new ArrayList<>();

		line1.add("SSP Rule Name");
		line1.add("SSP Category");
		line1.add("SSP Type");
		line1.add("SSP Rule Status");
		line1.add("SSP Price");
		line1.add("Min");
		line1.add("Median");
		line1.add("Max");
		line1.add("Start Date");
		line1.add("End Date");
		line1.add(CONSTANTS.CURRENCY);
		line1.add("Parameter Name1");
		line1.add("Parameter Value1");
		line1.add("Parameter Name2");
		line1.add("Parameter Value2");
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		try {
			objectWriter.writeValue(baos, line1);
		} catch (JsonGenerationException jge) {
			logger.error(jge);
		} catch (JsonMappingException jme) {
			logger.error(jme);
		} catch (IOException ioe) {
			logger.error(ioe);
		}

		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(baos, 1024);
		OutputStreamWriter writerOutputStream;
		try {
			writerOutputStream = new OutputStreamWriter(bufferedOutputStream, StandardCharsets.UTF_8);
			objectWriter.writeValue(writerOutputStream, sspList);
			writerOutputStream.close();
		} catch (UnsupportedEncodingException uee) {
			logger.error(uee);
		} catch (JsonGenerationException jge) {
			logger.error(jge);
		} catch (JsonMappingException jme) {
			logger.error(jme);
		} catch (IOException ioe) {
			logger.error(ioe);
		}

		String csvData = baos.toString();
		try {
			baos.close();
		} catch (IOException ioe) {
			logger.error(ioe);
		}
		return csvData;
	}

	@GetMapping(value = "/utilapi/serverTimeZone")
	@ResponseBody
	public String serverTimeZone() {
		Calendar now = Calendar.getInstance();
		TimeZone timeZone = now.getTimeZone();
		return timeZone.getID();
	}

	@GetMapping(value = "/api/rmanFiscalPeriodsInterfaceSearch")
	@ResponseBody
	public Page<RmanFiscalPeriodsInterface> searchRmanFiscalPeriodsInterface(
			@RequestParam(value = "search") String search, @PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return rmanFiscalPeriodsInterfaceRepo
				.findAll(RevmantraUtils.fetchSpecification(RmanFiscalPeriodsInterface.class, search), pageRequest);
	}

	Function<Object[], RmanRevDetailsV> externalToMyLocationFunc = new Function<Object[], RmanRevDetailsV>() {

		public RmanRevDetailsV apply(Object[] o) {
			RmanRevDetailsV rev = new RmanRevDetailsV();
			rev.setDealHeaderId((BigDecimal) o[0]);
			rev.setDealArrangementId((BigDecimal) o[1]);
			rev.setArrgLineNumber((String) o[2]);
			rev.setDealLineId((BigDecimal) o[3]);
			rev.setDealArrangementName((String) o[4]);
			rev.setDealLineNumber((BigDecimal) o[5]);
			rev.setProductName((String) o[6]);
			rev.setElement((String) o[7]);
			rev.setProductType((String) o[8]);
			rev.setProductGroup((String) o[9]);
			rev.setPobGroup((String) o[10]);
			rev.setArrgLineAmount((BigDecimal) o[11]);
			rev.setArrgLineCost((BigDecimal) o[12]);
			rev.setAttributedNetPrice((BigDecimal) o[13]);
			rev.setTotalAllocation((BigDecimal) o[14]);
			rev.setTotalAllocationFc((BigDecimal) o[15]);
			rev.setBookedAmount((BigDecimal) o[16]);
			rev.setShippedAmount((BigDecimal) o[17]);
			rev.setDeliveredAttributedNetPrice((BigDecimal) o[18]);
			rev.setDeliveredAllocRsp((BigDecimal) o[19]);
			rev.setPreBillingContAmount((BigDecimal) o[20]);
			rev.setDeliveredAllocFcRsp((BigDecimal) o[21]);
			rev.setBilledAmount((BigDecimal) o[22]);
			rev.setPostBillingContAmount((BigDecimal) o[23]);
			rev.setPostBillingDeferrals((BigDecimal) o[24]);
			rev.setPbDeferralFc((BigDecimal) o[25]);
			rev.setPostBillingAllocationAmount((BigDecimal) o[26]);
			rev.setTotalGaapRevneueBegBal((BigDecimal) o[27]);
			rev.setTotalGaapRevenueCurrentMon((BigDecimal) o[28]);
			rev.setTotalGaapRevenueEndingBal((BigDecimal) o[29]);
			rev.setAccountingRuleName((String) o[30]);
			rev.setAmortRuleRevenue((String) o[31]);
			rev.setAmortMethodRevenue((String) o[32]);
			rev.setDuration((String) o[33]);
			rev.setCumGaapBegBalance((BigDecimal) o[34]);
			rev.setNetGappCurrMonth((BigDecimal) o[35]);
			rev.setCumGaapEndingBalance((BigDecimal) o[36]);
			rev.setGaapUnamortized((BigDecimal) o[37]);
			rev.setCogsBegiBalCogs((BigDecimal) o[38]);
			rev.setCurrentMonthCogs((BigDecimal) o[39]);
			rev.setEndingBalance((BigDecimal) o[40]);
			rev.setOrderNumber((BigDecimal) o[41]);
			rev.setSourceLineNumber((String) o[42]);
			rev.setSourceLineId((BigDecimal) o[43]);
			rev.setRevenueStartDate((Timestamp) o[44]);
			rev.setRevenueEndDate((Timestamp) o[45]);
			rev.setCustomerPoNum((String) o[46]);
			rev.setDealNumber((String) o[47]);
			rev.setBundleFlag((String) o[48]);
			rev.setParentLineId((BigDecimal) o[49]);
			rev.setBilledAmountFc((BigDecimal) o[50]);
			rev.setPbAllocAmountTc((BigDecimal) o[51]);
			rev.setRevBegBalTc((BigDecimal) o[52]);
			rev.setRevCurrMonthBalTc((BigDecimal) o[53]);
			rev.setRevEndBalTc((BigDecimal) o[54]);
			rev.setGaapUnamortizedTc((BigDecimal) o[55]);
			rev.setProductDescription((String) o[56]);
			rev.setQuoteRefLineId((String) o[57]);
			rev.setRevenueAdjustment((BigDecimal) o[58]); // AYAR-1692 Added by chandra on 25-10-2021
			return rev;
		}
	};

	@GetMapping(value = "/api/rmanContRulesLov")
	@ResponseBody
	public List<RmanContRulesLov> searchRmanContRulesLov() {
		return rmanContRulesLovRepo.findAll();
	}

	@DeleteMapping(value = "/api/bulkDelOrdersInterface")
	@ResponseBody
	public String bulkDelOrdersInterface(@RequestParam("slid") BigDecimal[] slids,
			@RequestParam("fileType") String fileType) {
		rmanConcurrentProgramsDAO.deleteOrdersInetrface(fileType, slids);
		return "Y";
	}

	@PostMapping(value = "/api/createContHeader")
	@ResponseBody
	public RmanContHeader saveRmanContHeaders(@RequestBody RmanContHeader rmanContHeader) {
		RmanContHeader rch = rmanContHeaderRepo.findByRuleName(rmanContHeader.getRuleName());
		if (rch != null) {
			throw new AyaraCustomException(rch.getRuleName() + " contingency Already Exists");
		} else {
			try {
				return rmanContHeaderRepo.saveAndFlush(rmanContHeader);
			} catch (Exception e) {
				throw new AyaraCustomException("Contingency Creation failed due to " + e.getMessage());
			}

		}
	}

	@GetMapping(value = "/api/rmanOrderBookings")
	@ResponseBody
	public List<RmanOrderBookingsV> getContracts(@RequestParam("arrangementId") String arrangementId) {
		List<RmanOrderBookingsV> orders = rmanOrderBookingsVRepo.findByArrangementId(new BigDecimal(arrangementId));
		orders.forEach(order -> order.setRmanOrderBookingLines(rmanOrderLinesBookingsVRepo
				.findByArrangementIdAndSourceHeaderId(order.getArrangementId(), order.getSo().toString())));
		return orders;
	}

	@PutMapping(value = "/api/rmanUserResponsibilities/{respId}")
	public ResponseEntity<Void> updateUserResponsibilities(
			@RequestBody RmanUserResponsibilities rmanUserResponsibilities, @PathVariable BigDecimal respId) {
		if (rmanUserResponsibilities != null && respId != null) {
			Optional<RmanUserResponsibilities> rmanUserResp = rmanUserResponsibilitiesRepo
					.findById(new RmanUserResponsibilitiesPk(rmanUserResponsibilities.getRmanUserId(),
							rmanUserResponsibilities.getRmanResponsibilities().getResponsibilityId()));
			if (rmanUserResp.isPresent()) {
				if (rmanUserResp.get().getResponsibilityId() != rmanUserResponsibilities.getResponsibilityId()) {
					rmanUserResponsibilitiesRepo.deleteById(new RmanUserResponsibilitiesPk(
							rmanUserResp.get().getRmanUserId(), rmanUserResp.get().getResponsibilityId()));
				}
				rmanUserResponsibilitiesRepo.save(rmanUserResponsibilities);
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
				throw new AyaraCustomException("Unable to update User Responsibility "
						+ rmanUserResponsibilities.getRmanResponsibilities().getResponsibilityName());
			}
		} else {
			throw new AyaraCustomException("Unable to update User Responsibility");
		}
	}

	@PostMapping(value = "/api/saveAyaraUserTableCoulmns")
	@ResponseBody
	public AyaraUserTableColumns saveAyaraUserTableColumns(@RequestBody AyaraUserTableColumns ayaraUserTableColumns) {
		if (ayaraUserTableColumns != null) {
			Optional<AyaraUserTableColumns> userTableColumns = ayaraUserTableColumnsRepo
					.findById(new AyaraUserTableColumnsPkId(ayaraUserTableColumns.getPageName(),
							ayaraUserTableColumns.getTableName(), ayaraUserTableColumns.getUserId()));
			if (!userTableColumns.isPresent()) {
				ayaraUserTableColumns.setUserId(BaseListener.getCurrentUserId());
				return ayaraUserTableColumnsRepo.save(ayaraUserTableColumns);
			} else {
				throw new AyaraCustomException("Unable to save Table Template");
			}
		} else {
			throw new AyaraCustomException("Unable to save Table Template");
		}
	}

	@PutMapping(value = "/api/updateAyaraUserTableCoulmns")
	@ResponseBody
	public AyaraUserTableColumns updateAyaraUserTableColumns(@RequestBody AyaraUserTableColumns ayaraUserTableColumns) {
		if (ayaraUserTableColumns != null) {
			Optional<AyaraUserTableColumns> userTableColumns = ayaraUserTableColumnsRepo
					.findById(new AyaraUserTableColumnsPkId(ayaraUserTableColumns.getPageName(),
							ayaraUserTableColumns.getTableName(), ayaraUserTableColumns.getUserId()));
			if (userTableColumns.isPresent()) {
				userTableColumns.get().setTableColumns(ayaraUserTableColumns.getTableColumns());
				return ayaraUserTableColumnsRepo.save(userTableColumns.get());
			} else {
				throw new AyaraCustomException("Unable to update Table Template");
			}
		} else {
			throw new AyaraCustomException("Unable to update Table Template");
		}
	}

	@GetMapping(value = "/api/rmanFcConversionTypesSearch")
	@ResponseBody
	public Page<RmanFcConversionTypes> searchRmanFcConversionTypes(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return rmanFcConversionTypesRepo.findAll(RevmantraUtils.fetchSpecification(RmanFcConversionTypes.class, search),
				pageRequest);
	}

	@GetMapping(value = "/api/rmanFcLevelSearch")
	@ResponseBody
	public Page<RmanFcLevel> searchRmanFcLevel(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return rmanFcLevelRepo.findAll(RevmantraUtils.fetchSpecification(RmanFcLevel.class, search), pageRequest);
	}

	@GetMapping(value = "/api/rmanFcMethodsSearch")
	@ResponseBody
	public Page<RmanFcMethods> searchRmanFcMethods(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return rmanFcMethodsRepo.findAll(RevmantraUtils.fetchSpecification(RmanFcMethods.class, search), pageRequest);
	}

	@GetMapping(value = "/api/rmanFcstActualDetailsVSearch")
	@ResponseBody
	public Page<RmanFcstActualDetailsV> searchRmanFcstActualDetailsV(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return rmanFcstActualDetailsVRepo
				.findAll(RevmantraUtils.fetchSpecification(RmanFcstActualDetailsV.class, search), pageRequest);
	}

	@GetMapping(value = "/api/rmanFcBucketsSearch")
	@ResponseBody
	public Page<RmanFcBuckets> searchRmanFcBuckets(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return rmanFcBucketsRepo.findAll(RevmantraUtils.fetchSpecification(RmanFcBuckets.class, search), pageRequest);
	}

	@PostMapping(value = "/api/updateForecastingDetails")
	@ResponseBody
	public String saveFCST(@RequestBody List<RmanForecastingDetails> fcstList) {
		try {
			rmanForecastingDetailsRepo.saveAll(fcstList);
			return "Successfully Updated";
		} catch (Exception e) {
			return "Updated failed.Try again..!";
		}
	}

	@GetMapping(value = "/api/rmanForecastingDetailsSearch")
	@ResponseBody
	public Page<RmanForecastingDetails> searchRmanForecastingDetails(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		return rmanForecastingDetailsRepo
				.findAll(RevmantraUtils.fetchSpecification(RmanForecastingDetails.class, search), pageRequest);
	}

	@GetMapping(value = "/api/rmanForecastingDetailsExport", produces = "application/vnd.ms-excel")
	@ResponseBody
	public String exportRmanForecastingDetails(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest, HttpServletResponse response) {
		response.setHeader(CONSTANTS.CONTENT_DISPOSITION, "inline; filename=RmanForecastingDetails.csv");
		Page<RmanForecastingDetails> page = rmanForecastingDetailsRepo.findAll(
				RevmantraUtils.fetchSpecification(RmanForecastingDetails.class, search),
				PageRequest.of(0, Integer.MAX_VALUE));
		CsvMapper mapper = new CsvMapper();
		mapper.setDateFormat(new SimpleDateFormat(CONSTANTS.MM_DD_YYYY));
		mapper.enable(JsonGenerator.Feature.IGNORE_UNKNOWN);
		CsvSchema schema = CsvSchema.builder().setColumnSeparator(',').addColumn("fcMethodId")
				.addColumn(CONSTANTS.ARRANGEMENTNAME).addColumn("amount").addColumn("level1Name")
				.addColumn("level2Name").addColumn("level3Name").addColumn("level4Name").addColumn("level5Name")
				.setUseHeader(false).build();
		ObjectWriter objectWriter = mapper.writer(schema);

		List<String> line1 = new ArrayList<>();
		line1.add("FC Method");
		line1.add(CONSTANTS.REVENUE_CONTRACT_NAME);
		line1.add(CONSTANTS.AMOUNT);
		line1.add("Revenue Contract");
		line1.add("Element");
		line1.add(CONSTANTS.PRODUCTGROUP);
		line1.add("Product Type");
		line1.add(CONSTANTS.PRODUCTNAME);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		try {
			objectWriter.writeValue(baos, line1);
		} catch (JsonGenerationException jge) {
			logger.error(jge);
		} catch (JsonMappingException jme) {
			logger.error(jme);
		} catch (IOException ioe) {
			logger.error(ioe);
		}

		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(baos, 1024);
		OutputStreamWriter writerOutputStream;
		try {
			writerOutputStream = new OutputStreamWriter(bufferedOutputStream, StandardCharsets.UTF_8);
			objectWriter.writeValue(writerOutputStream, page.getContent());
			writerOutputStream.close();
		} catch (UnsupportedEncodingException uee) {
			logger.error(uee);
		} catch (JsonGenerationException jge) {
			logger.error(jge);
		} catch (JsonMappingException jme) {
			logger.error(jme);
		} catch (IOException ioe) {
			logger.error(ioe);
		}
		String csvData = baos.toString();
		try {
			baos.close();
		} catch (IOException ioe) {
			logger.error(ioe);
		}
		return csvData;
	}

	@GetMapping(value = "/api/rmanIntfDealDetailsSearch")
	@ResponseBody
	public Page<RmanIntfDealDetails> searchRmanIntfDealDetails(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest,
			@RequestParam(value = "fetchAll", defaultValue = "N") String fetchAll) {
		return rmanIntfDealDetailsRepo.findAll(RevmantraUtils.fetchSpecification(RmanIntfDealDetails.class, search),
				fetchAll.equals("Y") ? PageRequest.of(0, Integer.MAX_VALUE) : pageRequest);
	}

	@GetMapping(value = "/api/rmanQuotesInterfaceExport", produces = "application/vnd.ms-excel")
	@ResponseBody
	public String exportRmanQuotesInterface(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest, HttpServletResponse response) {
		response.setHeader(CONSTANTS.CONTENT_DISPOSITION, "inline; filename=RmanQuotesInterface.csv");
		Page<RmanIntfDealDetails> page = rmanIntfDealDetailsRepo.findAll(
				RevmantraUtils.fetchSpecification(RmanIntfDealDetails.class, search),
				PageRequest.of(0, Integer.MAX_VALUE));
		CsvMapper mapper = new CsvMapper();
		mapper.setDateFormat(new SimpleDateFormat(CONSTANTS.MM_DD_YYYY));
		mapper.enable(JsonGenerator.Feature.IGNORE_UNKNOWN);
		CsvSchema schema = CsvSchema.builder().setColumnSeparator(',').addColumn("operationCode")
				.addColumn(CONSTANTS.SALES_NODE_LVL_1).addColumn(CONSTANTS.SALES_NODE_LVL_2)
				.addColumn(CONSTANTS.SALES_NODE_LVL_3).addColumn("salesNodeLevel4").addColumn("currencyCode")
				.addColumn(CONSTANTS.CUSTOMER_NAME).addColumn(CONSTANTS.ARRANGEMENTNUMBER)
				.addColumn(CONSTANTS.ARRANGEMENTNAME).addColumn("agreementId").addColumn(CONSTANTS.AGREEMENTNAME)
				.addColumn(CONSTANTS.DEAL_NUMBER).addColumn(CONSTANTS.DEAL_LINE_NUMBER).addColumn(CONSTANTS.DEAL_NAME)
				.addColumn("additionalLineAttribute3").addColumn(CONSTANTS.PRODUCT_NAME)
				.addColumn("additionalLineAttribute2").addColumn("additionalLineAttribute1")
				.addColumn(CONSTANTS.START_DATE).addColumn(CONSTANTS.END_DATE).addColumn("duration")
				.addColumn("durationUom").addColumn(CONSTANTS.QUANTITY).addColumn(CONSTANTS.FX_RATE)
				.addColumn(CONSTANTS.FX_DATE).addColumn(CONSTANTS.UNIT_SELLING_PRICE)
				.addColumn(CONSTANTS.UNIT_LIST_PRICE).addColumn("contractUnitType").addColumn("unitCost")
				.addColumn(CONSTANTS.BILLTOCUSTOMERNAME).addColumn("entityName").addColumn(CONSTANTS.PRICE_LIST)
				.addColumn("msaNumber").addColumn("msaName").addColumn("parentLineId").addColumn("fvPercent")
				.addColumn("accountingRuleName").addColumn("eitfSop").addColumn("bespPerUnit").addColumn("arrgSource")
				.addColumn("arrgBasis").addColumn("interfaceError").setUseHeader(false).build();
		ObjectWriter objectWriter = mapper.writer(schema);
		List<String> line1 = new ArrayList<>();

		line1.add("operationCode");
		line1.add(CONSTANTS.SALES_NODE_LVL_1);
		line1.add(CONSTANTS.SALES_NODE_LVL_2);
		line1.add(CONSTANTS.SALES_NODE_LVL_3);
		line1.add("salesNodeLevel4");
		line1.add("currencyCode");
		line1.add(CONSTANTS.CUSTOMER_NAME);
		line1.add(CONSTANTS.ARRANGEMENTNUMBER);
		line1.add(CONSTANTS.ARRANGEMENTNAME);
		line1.add("agreementId");
		line1.add(CONSTANTS.AGREEMENTNAME);
		line1.add(CONSTANTS.DEAL_NUMBER);
		line1.add(CONSTANTS.DEAL_LINE_NUMBER);
		line1.add(CONSTANTS.DEAL_NAME);
		line1.add("additionalLineAttribute3");
		line1.add(CONSTANTS.PRODUCT_NAME);
		line1.add("additionalLineAttribute2");
		line1.add("additionalLineAttribute1");
		line1.add(CONSTANTS.START_DATE);
		line1.add(CONSTANTS.END_DATE);
		line1.add("duration");
		line1.add("durationUom");
		line1.add(CONSTANTS.QUANTITY);
		line1.add(CONSTANTS.FX_RATE);
		line1.add(CONSTANTS.FX_DATE);
		line1.add(CONSTANTS.UNIT_SELLING_PRICE);
		line1.add(CONSTANTS.UNIT_LIST_PRICE);
		line1.add("contractUnitType");
		line1.add("unitCost");
		line1.add(CONSTANTS.BILLTOCUSTOMERNAME);
		line1.add("entityName");
		line1.add(CONSTANTS.PRICE_LIST);
		line1.add("msaNumber");
		line1.add("msaName");
		line1.add("parentLineId");
		line1.add("fvPercent");
		line1.add("accountingRuleName");
		line1.add("eitfSop");
		line1.add("bespPerUnit");
		line1.add("arrgSource");
		line1.add("arrgBasis");
		line1.add("interfaceError");
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		try {
			objectWriter.writeValue(baos, line1);
		} catch (JsonGenerationException jge) {
			logger.error(jge);
		} catch (JsonMappingException jme) {
			logger.error(jme);
		} catch (IOException ioe) {
			logger.error(ioe);
		}

		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(baos, 1024);
		OutputStreamWriter writerOutputStream;
		try {
			writerOutputStream = new OutputStreamWriter(bufferedOutputStream, StandardCharsets.UTF_8);
			objectWriter.writeValue(writerOutputStream, page.getContent());
			writerOutputStream.close();
		} catch (UnsupportedEncodingException uee) {
			logger.error(uee);
		} catch (JsonGenerationException jge) {
			logger.error(jge);
		} catch (JsonMappingException jme) {
			logger.error(jme);
		} catch (IOException ioe) {
			logger.error(ioe);
		}

		String csvData = baos.toString();
		try {
			baos.close();
		} catch (IOException ioe) {
			logger.error(ioe);
		}
		return csvData;
	}

	@GetMapping(value = "/api/FcBucketsSearch")
	@ResponseBody
	public List<RmanFcBuckets> searchFcBuckets() {

		return rmanFcBucketsRepo.RmanFcBucketsActiveList();
	}

	@GetMapping(value = "/api/rmanArchiveFileExport", produces = "application/vnd.ms-excel")
	@ResponseBody
	public String exportArchiveFiles(@RequestParam(value = "fileType") String fileType,
			@RequestParam(value = "groupId") String groupId, @RequestParam(value = "fileName") String uploadfileName,
			HttpServletResponse response) {

		response.setHeader(CONSTANTS.CONTENT_DISPOSITION, "inline; filename=" + uploadfileName);
		List<String> line1 = new ArrayList<>();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		CsvMapper mapper = new CsvMapper();
		ObjectWriter objectWriter = null;
		mapper.setDateFormat(new SimpleDateFormat(CONSTANTS.MM_DD_YYYY));
		mapper.enable(JsonGenerator.Feature.IGNORE_UNKNOWN);
		if (fileType.equals("BOOK")) {
			List<RmanBookedOrdersArchive> listOrders = rmanBookedOrdersArchiveRepo.findByGroupId(groupId);
			CsvSchema schema = CsvSchema.builder().setColumnSeparator(',').addColumn(CONSTANTS.SOURCE_HEADER_ID)
					.addColumn(CONSTANTS.ORDER_NUMBER).addColumn(CONSTANTS.CUSTOMER_PO_NUMBER)
					.addColumn(CONSTANTS.ORDER_TYPE).addColumn("bookingEntityName").addColumn("shippingEntityName")
					.addColumn(CONSTANTS.SOLD_TO_CUSTOMER).addColumn(CONSTANTS.BILLTOCUSTOMERNUMBER)
					.addColumn(CONSTANTS.BILLTOCUSTOMER).addColumn(CONSTANTS.SHIP_TO_CUSTOMER)
					.addColumn(CONSTANTS.SHIP_TO_CUSTOMER_NUMBER).addColumn(CONSTANTS.BILLTOCOUNTRY)
					.addColumn(CONSTANTS.SHIP_TO_COUNTRY).addColumn(CONSTANTS.SHIPPING_ORG_CODE)
					.addColumn(CONSTANTS.BOOKEDDATE).addColumn(CONSTANTS.ORDERED_DATE)
					.addColumn(CONSTANTS.SCHEDULE_SHIP_DATE).addColumn(CONSTANTS.ORDER_STATUS)
					.addColumn(CONSTANTS.PRICE_LIST).addColumn(CONSTANTS.BOOKINGCURRENCY)
					.addColumn(CONSTANTS.SOURCE_LINE_ID).addColumn(CONSTANTS.SOURCE_LINE_NUMBER)
					.addColumn(CONSTANTS.PRODUCT_NAME).addColumn(CONSTANTS.PRODUCT_ORG_NAME)
					.addColumn(CONSTANTS.ORDERED_QUANTITY).addColumn(CONSTANTS.SHIPPED_QUANTITY)
					.addColumn(CONSTANTS.FULFILLED_QUANTITY).addColumn(CONSTANTS.LINE_STATUS)
					.addColumn(CONSTANTS.UNIT_SELLING_PRICE).addColumn(CONSTANTS.UNIT_LIST_PRICE)
					.addColumn(CONSTANTS.EXTENDED_LIST_AMOUNT).addColumn(CONSTANTS.EXTENDED_SELLING_AMOUNT)
					.addColumn(CONSTANTS.DISCOUNT_PERCENTAGE).addColumn(CONSTANTS.ORIGINAL_LINE_ID)
					.addColumn(CONSTANTS.ORIGINAL_LINE_NUMBER).addColumn(CONSTANTS.ORIGINAL_ORDER_NUMBER)
					.addColumn(CONSTANTS.SERVICE_START_DATE).addColumn(CONSTANTS.SERVICE_END_DATE)
					.addColumn(CONSTANTS.SERVICE_DURATION).addColumn(CONSTANTS.SERVICE_PERIOD)
					.addColumn(CONSTANTS.ACTUALFULFILLEDDATE).addColumn(CONSTANTS.LINE_COST)
					.addColumn(CONSTANTS.DOMESTRIC_INTERNATIONAL).addColumn(CONSTANTS.REGION)
					.addColumn(CONSTANTS.TERRITORY).addColumn(CONSTANTS.REV_REC_HOLD_TYPE)
					.addColumn(CONSTANTS.CANCELLEDQTY).addColumn(CONSTANTS.CANCELLEDDATE)
					.addColumn(CONSTANTS.LINE_CATEGORY_CODE).addColumn(CONSTANTS.CUSTOMER_NUMBER)
					.addColumn(CONSTANTS.EXT_WARRANTY_SKU).addColumn(CONSTANTS.EXT_SERVICE_START_DATE)
					.addColumn(CONSTANTS.EXT_SERV_END_DATE).addColumn(CONSTANTS.EXT_PERIOD)
					.addColumn(CONSTANTS.EXT_DURATION).addColumn(CONSTANTS.EXT_LIST_PRICE)
					.addColumn(CONSTANTS.EXT_DISCOUNT).addColumn(CONSTANTS.SUPPORT_SKU)
					.addColumn(CONSTANTS.SUPPORT_SERVICE_START_DATE).addColumn(CONSTANTS.SUPPORT_SERVICE_END_DATE)
					.addColumn(CONSTANTS.SUPPORT_PERIOD).addColumn(CONSTANTS.SUPPORT_DURATION)
					.addColumn(CONSTANTS.SUPPORT_LIST_PRICE).addColumn(CONSTANTS.SUPPORT_DISCOUNT)
					.addColumn(CONSTANTS.TRAINING_SKU).addColumn(CONSTANTS.PERCENTAGE_SPLIT)
					.addColumn(CONSTANTS.SALES_REP).setUseHeader(false).build();
			objectWriter = mapper.writer(schema);

			line1.add(CONSTANTS.HEADER_ID);
			line1.add(CONSTANTS.ORDER_NUMBER_CAPS);
			line1.add(CONSTANTS.CUSTOMER_PO);
			line1.add(CONSTANTS.ORDER_TYPE);
			line1.add("BOOKING_ENTITY_NAME");
			line1.add("SHIPPING_ENTITY_NAME");
			line1.add(CONSTANTS.SOLD_TO_CUSTOMER);
			line1.add(CONSTANTS.BILL_TO_CUSTOMER_NUMBER_CAPS);
			line1.add(CONSTANTS.BILL_TO_CUSTOMER);
			line1.add(CONSTANTS.SHIP_TO_CUSTOMER);
			line1.add(CONSTANTS.SHIP_TO_CUSTOMER_NUMBER);
			line1.add(CONSTANTS.BILL_TO_COUNTRY);
			line1.add(CONSTANTS.SHIP_TO_COUNTRY);
			line1.add(CONSTANTS.SHIPPING_ORG_CODE);
			line1.add(CONSTANTS.BOOKED_DATE_CAPS);
			line1.add(CONSTANTS.ORDERED_DATE);
			line1.add(CONSTANTS.SCHEDULE_SHIP_DATE);
			line1.add(CONSTANTS.ORDER_STATUS);
			line1.add(CONSTANTS.PRICE_LIST_CAPS);
			line1.add(CONSTANTS.BOOKING_CURRENCY_CAPS);
			line1.add(CONSTANTS.SOURCE_LINE_ID_CAPS);
			line1.add(CONSTANTS.SOURCE_LINE_NUMBER_CAPS);
			line1.add(CONSTANTS.PRODUCT_NAME_CAPS);
			line1.add(CONSTANTS.PRODUCT_ORG_NAME);
			line1.add(CONSTANTS.ORDERED_QUANTITY_CAPS);
			line1.add(CONSTANTS.SHIPPED_QUANTITY);
			line1.add(CONSTANTS.FULFILLED_QUANTITY);
			line1.add(CONSTANTS.LINE_STATUS_CAPS);
			line1.add(CONSTANTS.SELLING_PRICE);
			line1.add(CONSTANTS.LIST_PRICE);
			line1.add(CONSTANTS.EXTENDED_LIST_AMT);
			line1.add(CONSTANTS.EXT_SELLING_AMT);
			line1.add(CONSTANTS.DISCOUNT_PERCENT);
			line1.add(CONSTANTS.REFERECE_LINE_ID);
			line1.add(CONSTANTS.REFERENCE_LINE_NUMBER);
			line1.add(CONSTANTS.REFERENCE_ORDER_NUMBER);
			line1.add(CONSTANTS.SERVICE_START_DATE_CAPS);
			line1.add(CONSTANTS.SERVICE_END_DATE_CAPS);
			line1.add(CONSTANTS.SERVICE_DURATION);
			line1.add(CONSTANTS.SERVICE_PERIOD);
			line1.add(CONSTANTS.ACTUAL_FULFILLED_DATE_CAPS);
			line1.add(CONSTANTS.UNIT_COST);
			line1.add(CONSTANTS.DOMESTIC_INTERNATIONAL);
			line1.add(CONSTANTS.REGION);
			line1.add(CONSTANTS.TERRITORY);
			line1.add(CONSTANTS.REV_REC_HOLD_TYPE);
			line1.add(CONSTANTS.CANCELLED_QTY);
			line1.add(CONSTANTS.CANCELLED_DATE);
			line1.add(CONSTANTS.LINE_CATEGORY_CODE);
			line1.add(CONSTANTS.CUSTOMER_NUMBER_CAPS);
			line1.add(CONSTANTS.EXT_WARRANTY_SKU);
			line1.add(CONSTANTS.EXT_SERV_START_DATE);
			line1.add(CONSTANTS.EXT_SERV_END_DATE);
			line1.add(CONSTANTS.EXT_PERIOD);
			line1.add(CONSTANTS.EXT_DURATION);
			line1.add(CONSTANTS.EXT_LIST_PRICE);
			line1.add(CONSTANTS.EXT_DISCOUNT);
			line1.add(CONSTANTS.SUPPORT_SKU);
			line1.add(CONSTANTS.SUPPORT_SERV_START_DATE);
			line1.add(CONSTANTS.SUPPORT_SERV_END_DATE);
			line1.add(CONSTANTS.SUPPORT_PERIOD);
			line1.add(CONSTANTS.SUPPORT_DURATION);
			line1.add(CONSTANTS.SUPPORT_LIST_PRICE);
			line1.add(CONSTANTS.SUPPORT_DISCOUNT);
			line1.add(CONSTANTS.TRAINING_SKU);
			line1.add(CONSTANTS.PERCENTAGE_SPLIT);
			line1.add(CONSTANTS.SALES_REP_CAPS);

			try {
				objectWriter.writeValue(baos, line1);
			} catch (JsonGenerationException jge) {
				logger.error(jge);
			} catch (JsonMappingException jme) {
				logger.error(jme);
			} catch (IOException ioe) {
				logger.error(ioe);
			}

			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(baos, 1024);
			OutputStreamWriter writerOutputStream;
			try {
				writerOutputStream = new OutputStreamWriter(bufferedOutputStream, StandardCharsets.UTF_8);
				objectWriter.writeValue(writerOutputStream, listOrders);
				writerOutputStream.close();
			} catch (UnsupportedEncodingException uee) {
				logger.error(uee);
			} catch (JsonGenerationException jge) {
				logger.error(jge);
			} catch (JsonMappingException jme) {
				logger.error(jme);
			} catch (IOException ioe) {
				logger.error(ioe);
			}

		}

		if (fileType.equals("SHIP")) {
			List<RmanBookedOrdersArchive> listOrders = rmanBookedOrdersArchiveRepo.findByGroupId(groupId);
			CsvSchema schema = CsvSchema.builder().setColumnSeparator(',').addColumn(CONSTANTS.SOURCE_HEADER_ID)
					.addColumn(CONSTANTS.ORDER_NUMBER).addColumn(CONSTANTS.CUSTOMER_PO_NUMBER)
					.addColumn(CONSTANTS.ORDER_TYPE).addColumn("bookingEntityName").addColumn("shippingEntityName")
					.addColumn(CONSTANTS.SOLD_TO_CUSTOMER).addColumn(CONSTANTS.BILLTOCUSTOMERNUMBER)
					.addColumn(CONSTANTS.BILLTOCUSTOMER).addColumn(CONSTANTS.SHIP_TO_CUSTOMER)
					.addColumn(CONSTANTS.SHIP_TO_CUSTOMER_NUMBER).addColumn(CONSTANTS.BILLTOCOUNTRY)
					.addColumn(CONSTANTS.SHIP_TO_COUNTRY).addColumn(CONSTANTS.SHIPPING_ORG_CODE)
					.addColumn(CONSTANTS.BOOKEDDATE).addColumn(CONSTANTS.ORDERED_DATE)
					.addColumn(CONSTANTS.SCHEDULE_SHIP_DATE).addColumn(CONSTANTS.ORDER_STATUS)
					.addColumn(CONSTANTS.PRICE_LIST).addColumn(CONSTANTS.BOOKINGCURRENCY)
					.addColumn(CONSTANTS.SOURCE_LINE_ID).addColumn(CONSTANTS.SOURCE_LINE_NUMBER)
					.addColumn(CONSTANTS.PRODUCT_NAME).addColumn(CONSTANTS.PRODUCT_ORG_NAME)
					.addColumn(CONSTANTS.ORDERED_QUANTITY).addColumn(CONSTANTS.SHIPPED_QUANTITY)
					.addColumn(CONSTANTS.FULFILLED_QUANTITY).addColumn(CONSTANTS.LINE_STATUS)
					.addColumn(CONSTANTS.UNIT_SELLING_PRICE).addColumn(CONSTANTS.UNIT_LIST_PRICE)
					.addColumn(CONSTANTS.EXTENDED_LIST_AMOUNT).addColumn(CONSTANTS.EXTENDED_SELLING_AMOUNT)
					.addColumn(CONSTANTS.DISCOUNT_PERCENTAGE).addColumn(CONSTANTS.ORIGINAL_LINE_ID)
					.addColumn(CONSTANTS.ORIGINAL_LINE_NUMBER).addColumn(CONSTANTS.ORIGINAL_ORDER_NUMBER)
					.addColumn(CONSTANTS.SERVICE_START_DATE).addColumn(CONSTANTS.SERVICE_END_DATE)
					.addColumn(CONSTANTS.SERVICE_DURATION).addColumn(CONSTANTS.SERVICE_PERIOD)
					.addColumn(CONSTANTS.ACTUALFULFILLEDDATE).addColumn(CONSTANTS.LINE_COST)
					.addColumn(CONSTANTS.DOMESTRIC_INTERNATIONAL).addColumn(CONSTANTS.REGION)
					.addColumn(CONSTANTS.TERRITORY).addColumn(CONSTANTS.REV_REC_HOLD_TYPE)
					.addColumn(CONSTANTS.CANCELLEDQTY).addColumn(CONSTANTS.CANCELLEDDATE)
					.addColumn(CONSTANTS.LINE_CATEGORY_CODE).addColumn(CONSTANTS.CUSTOMER_NUMBER)
					.addColumn(CONSTANTS.EXT_WARRANTY_SKU).addColumn(CONSTANTS.EXT_SERVICE_START_DATE)
					.addColumn(CONSTANTS.EXT_SERV_END_DATE).addColumn(CONSTANTS.EXT_PERIOD)
					.addColumn(CONSTANTS.EXT_DURATION).addColumn(CONSTANTS.EXT_LIST_PRICE)
					.addColumn(CONSTANTS.EXT_DISCOUNT).addColumn(CONSTANTS.SUPPORT_SKU)
					.addColumn(CONSTANTS.SUPPORT_SERVICE_START_DATE).addColumn(CONSTANTS.SUPPORT_SERVICE_END_DATE)
					.addColumn(CONSTANTS.SUPPORT_PERIOD).addColumn(CONSTANTS.SUPPORT_DURATION)
					.addColumn(CONSTANTS.SUPPORT_LIST_PRICE).addColumn(CONSTANTS.SUPPORT_DISCOUNT)
					.addColumn(CONSTANTS.TRAINING_SKU).addColumn(CONSTANTS.PERCENTAGE_SPLIT)
					.addColumn(CONSTANTS.SALES_REP).setUseHeader(false).build();
			objectWriter = mapper.writer(schema);

			line1.add(CONSTANTS.HEADER_ID);
			line1.add(CONSTANTS.ORDER_NUMBER_CAPS);
			line1.add(CONSTANTS.CUSTOMER_PO);
			line1.add(CONSTANTS.ORDER_TYPE);
			line1.add("BOOKING_ENTITY_NAME");
			line1.add("SHIPPING_ENTITY_NAME");
			line1.add(CONSTANTS.SOLD_TO_CUSTOMER);
			line1.add(CONSTANTS.BILL_TO_CUSTOMER_NUMBER_CAPS);
			line1.add(CONSTANTS.BILL_TO_CUSTOMER);
			line1.add(CONSTANTS.SHIP_TO_CUSTOMER);
			line1.add(CONSTANTS.SHIP_TO_CUSTOMER_NUMBER);
			line1.add(CONSTANTS.BILL_TO_COUNTRY);
			line1.add(CONSTANTS.SHIP_TO_COUNTRY);
			line1.add(CONSTANTS.SHIPPING_ORG_CODE);
			line1.add(CONSTANTS.BOOKED_DATE_CAPS);
			line1.add(CONSTANTS.ORDERED_DATE);
			line1.add(CONSTANTS.SCHEDULE_SHIP_DATE);
			line1.add(CONSTANTS.ORDER_STATUS);
			line1.add(CONSTANTS.PRICE_LIST_CAPS);
			line1.add(CONSTANTS.BOOKING_CURRENCY_CAPS);
			line1.add(CONSTANTS.SOURCE_LINE_ID_CAPS);
			line1.add(CONSTANTS.SOURCE_LINE_NUMBER_CAPS);
			line1.add(CONSTANTS.PRODUCT_NAME_CAPS);
			line1.add(CONSTANTS.PRODUCT_ORG_NAME);
			line1.add(CONSTANTS.ORDERED_QUANTITY_CAPS);
			line1.add(CONSTANTS.SHIPPED_QUANTITY);
			line1.add(CONSTANTS.FULFILLED_QUANTITY);
			line1.add(CONSTANTS.LINE_STATUS_CAPS);
			line1.add(CONSTANTS.SELLING_PRICE);
			line1.add(CONSTANTS.LIST_PRICE);
			line1.add(CONSTANTS.EXTENDED_LIST_AMT);
			line1.add(CONSTANTS.EXT_SELLING_AMT);
			line1.add(CONSTANTS.DISCOUNT_PERCENT);
			line1.add(CONSTANTS.REFERECE_LINE_ID);
			line1.add(CONSTANTS.REFERENCE_LINE_NUMBER);
			line1.add(CONSTANTS.REFERENCE_ORDER_NUMBER);
			line1.add(CONSTANTS.SERVICE_START_DATE_CAPS);
			line1.add(CONSTANTS.SERVICE_END_DATE_CAPS);
			line1.add(CONSTANTS.SERVICE_DURATION);
			line1.add(CONSTANTS.SERVICE_PERIOD);
			line1.add(CONSTANTS.ACTUAL_FULFILLED_DATE_CAPS);
			line1.add(CONSTANTS.UNIT_COST);
			line1.add(CONSTANTS.DOMESTIC_INTERNATIONAL);
			line1.add(CONSTANTS.REGION);
			line1.add(CONSTANTS.TERRITORY);
			line1.add(CONSTANTS.REV_REC_HOLD_TYPE);
			line1.add(CONSTANTS.CANCELLED_QTY);
			line1.add(CONSTANTS.CANCELLED_DATE);
			line1.add(CONSTANTS.LINE_CATEGORY_CODE);
			line1.add(CONSTANTS.CUSTOMER_NUMBER_CAPS);
			line1.add(CONSTANTS.EXT_WARRANTY_SKU);
			line1.add(CONSTANTS.EXT_SERV_START_DATE);
			line1.add(CONSTANTS.EXT_SERV_END_DATE);
			line1.add(CONSTANTS.EXT_PERIOD);
			line1.add(CONSTANTS.EXT_DURATION);
			line1.add(CONSTANTS.EXT_LIST_PRICE);
			line1.add(CONSTANTS.EXT_DISCOUNT);
			line1.add(CONSTANTS.SUPPORT_SKU);
			line1.add(CONSTANTS.SUPPORT_SERV_START_DATE);
			line1.add(CONSTANTS.SUPPORT_SERV_END_DATE);
			line1.add(CONSTANTS.SUPPORT_PERIOD);
			line1.add(CONSTANTS.SUPPORT_DURATION);
			line1.add(CONSTANTS.SUPPORT_LIST_PRICE);
			line1.add(CONSTANTS.SUPPORT_DISCOUNT);
			line1.add(CONSTANTS.TRAINING_SKU);
			line1.add(CONSTANTS.PERCENTAGE_SPLIT);
			line1.add(CONSTANTS.SALES_REP_CAPS);

			try {
				objectWriter.writeValue(baos, line1);
			} catch (JsonGenerationException jge) {
				logger.error(jge);
			} catch (JsonMappingException jme) {
				logger.error(jme);
			} catch (IOException ioe) {
				logger.error(ioe);
			}

			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(baos, 1024);
			OutputStreamWriter writerOutputStream;
			try {
				writerOutputStream = new OutputStreamWriter(bufferedOutputStream, StandardCharsets.UTF_8);
				objectWriter.writeValue(writerOutputStream, listOrders);
				writerOutputStream.close();
			} catch (UnsupportedEncodingException uee) {
				logger.error(uee);
			} catch (JsonGenerationException jge) {
				logger.error(jge);
			} catch (JsonMappingException jme) {
				logger.error(jme);
			} catch (IOException ioe) {
				logger.error(ioe);
			}

		}

		if (fileType.equals("SSPO")) {
			List<RmanSspOrdersFileArchive> listOrders = rmanSspOrdersFileArchiveRepo.findByGroupId(groupId);
			CsvSchema schema = CsvSchema.builder().setColumnSeparator(',').addColumn(CONSTANTS.BOOKEDDATE)
					.addColumn(CONSTANTS.CUSTOMER_PO_NUMBER).addColumn(CONSTANTS.ORDER_TYPE)
					.addColumn(CONSTANTS.BILLTOCUSTOMERNUMBER).addColumn(CONSTANTS.BILLTOCUSTOMER)
					.addColumn(CONSTANTS.PRODUCT_NAME).addColumn(CONSTANTS.UNIT_LIST_PRICE)
					.addColumn(CONSTANTS.UNIT_SELLING_PRICE).addColumn("netDiscount")
					.addColumn(CONSTANTS.ORDERED_QUANTITY).addColumn(CONSTANTS.EXTENDED_SELLING_AMOUNT)
					.addColumn(CONSTANTS.SERVICE_START_DATE).addColumn(CONSTANTS.SERVICE_END_DATE).addColumn("location")
					.setUseHeader(false).build();
			objectWriter = mapper.writer(schema);

			line1.add("Booked Date");
			line1.add("Order Number");
			line1.add("Order Type");
			line1.add("Customer Id");
			line1.add("Reseller");
			line1.add("Item Name");
			line1.add("List Price");
			line1.add("Sale Price");
			line1.add("Discount");
			line1.add(CONSTANTS.QUANTITY);
			line1.add("Amount (Net)");
			line1.add("Rev Start Date");
			line1.add("Rev End Date");
			line1.add("Location");

			try {
				objectWriter.writeValue(baos, line1);
			} catch (JsonGenerationException jge) {
				logger.error(jge);
			} catch (JsonMappingException jme) {
				logger.error(jme);
			} catch (IOException ioe) {
				logger.error(ioe);
			}

			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(baos, 1024);
			OutputStreamWriter writerOutputStream;
			try {
				writerOutputStream = new OutputStreamWriter(bufferedOutputStream, StandardCharsets.UTF_8);
				objectWriter.writeValue(writerOutputStream, listOrders);
				writerOutputStream.close();
			} catch (UnsupportedEncodingException uee) {
				logger.error(uee);
			} catch (JsonGenerationException jge) {
				logger.error(jge);
			} catch (JsonMappingException jme) {
				logger.error(jme);
			} catch (IOException ioe) {
				logger.error(ioe);
			}

		}
		if (fileType.equals("CUSTOMER")) {

			List<RmanCustomersFileArchive> custList = rmanCustomersFileArchiveRepo.findByProcessId(groupId);
			mapper.setDateFormat(new SimpleDateFormat(CONSTANTS.MM_DD_YYYY));
			mapper.enable(JsonGenerator.Feature.IGNORE_UNKNOWN);
			CsvSchema schema = CsvSchema.builder().setColumnSeparator(',').addColumn("customerId")
					.addColumn(CONSTANTS.CUSTOMER_NAME).addColumn(CONSTANTS.CUSTOMER_NUMBER).addColumn("status")
					.setUseHeader(false).build();
			objectWriter = mapper.writer(schema);

			line1.add("Customer ID");
			line1.add(CONSTANTS.CUSTOMER_NAME);
			line1.add(CONSTANTS.CUSTOMERNUMBER);
			line1.add("Status");

			try {
				objectWriter.writeValue(baos, line1);
			} catch (JsonGenerationException jge) {
				logger.error(jge);
			} catch (JsonMappingException jme) {
				logger.error(jme);
			} catch (IOException ioe) {
				logger.error(ioe);
			}

			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(baos, 1024);
			OutputStreamWriter writerOutputStream;
			try {
				writerOutputStream = new OutputStreamWriter(bufferedOutputStream, StandardCharsets.UTF_8);
				objectWriter.writeValue(writerOutputStream, custList);
				writerOutputStream.close();
			} catch (UnsupportedEncodingException uee) {
				logger.error(uee);
			} catch (JsonGenerationException jge) {
				logger.error(jge);
			} catch (JsonMappingException jme) {
				logger.error(jme);
			} catch (IOException ioe) {
				logger.error(ioe);
			}
		}

		if (fileType.equals("PRODUCT")) {

			List<RmanProductsFileArchive> productList = rmanProductsFileArchiveRepo.findByGroupId(groupId);
			mapper.setDateFormat(new SimpleDateFormat(CONSTANTS.MM_DD_YYYY));
			mapper.enable(JsonGenerator.Feature.IGNORE_UNKNOWN);
			CsvSchema schema = CsvSchema.builder().setColumnSeparator(',').addColumn("sourceProductId")
					.addColumn(CONSTANTS.PRODUCT_NAME).addColumn("productDescription").addColumn("productOrgId")
					.addColumn(CONSTANTS.PRODUCT_ORG_NAME).addColumn("productOrgCode").addColumn("productStatus")
					.addColumn("productType").addColumn("productCost").addColumn("revAccountId").addColumn("corp")
					.addColumn("division").addColumn("department").addColumn("naturalAccount")
					.addColumn("shippableFlag").addColumn("productFamily").addColumn("productPortfolio")
					.addColumn("productLine").addColumn("partProductLine").addColumn("lineOfBusiness")
					.addColumn("invoicingRule").addColumn("productElement").addColumn("bundledItem")
					.addColumn("primaryUnitOfMeasure").addColumn("startDateActive").addColumn("endDateActive")
					.addColumn("invoiceEnabledFlag").addColumn("productService").addColumn("productFamily2")
					.setUseHeader(false).build();
			objectWriter = mapper.writer(schema);

			line1.add("INVENTORY_ITEM_ID");
			line1.add("SEGMENT1");
			line1.add("DESCRIPTION");
			line1.add("ORGANIZATION_ID");
			line1.add("PROD_ORG");
			line1.add("BUSINESS_UNIT");
			line1.add("INVENTORY_ITEM_STATUS_CODE");
			line1.add("ITEM_TYPE");
			line1.add("PRODUCT_COST");
			line1.add("SALES_ACCOUNT");
			line1.add("CORP");
			line1.add("DIVISION");
			line1.add("DEPARTMENT");
			line1.add("NATURAL_ACCOUNT");
			line1.add("SHIPPABLE_ITEM_FLAG");
			line1.add("PRODUCT_FAMILY");
			line1.add("PRODUCT_PORTFOLIO");
			line1.add("PRODUCT_LINE");
			line1.add("Part Product Line");
			line1.add("LINE_OF_BUSINESS");
			line1.add("INVOICING_RULE");
			line1.add("PRODUCT_ELEMENT");
			line1.add("BUNDLED_ITEM");
			line1.add("PRIMARY_UNIT_OF_MEASURE");
			line1.add("START_DATE_ACTIVE");
			line1.add("END_DATE_ACTIVE");
			line1.add("INVOICE_ENABLED_FLAG");
			line1.add("PRODUCT_SERVICE");
			line1.add("PRODUCT_ FAMILY2");

			try {
				objectWriter.writeValue(baos, line1);
			} catch (JsonGenerationException jge) {
				logger.error(jge);
			} catch (JsonMappingException jme) {
				logger.error(jme);
			} catch (IOException ioe) {
				logger.error(ioe);
			}

			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(baos, 1024);
			OutputStreamWriter writerOutputStream;
			try {
				writerOutputStream = new OutputStreamWriter(bufferedOutputStream, StandardCharsets.UTF_8);
				objectWriter.writeValue(writerOutputStream, productList);
				writerOutputStream.close();
			} catch (UnsupportedEncodingException uee) {
				logger.error(uee);
			} catch (JsonGenerationException jge) {
				logger.error(jge);
			} catch (JsonMappingException jme) {
				logger.error(jme);
			} catch (IOException ioe) {
				logger.error(ioe);
			}

		}

		String csvData = baos.toString();
		try {
			baos.close();
		} catch (IOException ioe) {
			logger.error(ioe);
		}
		return csvData;

	}

}
