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
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.forsys.revmantra.custom.RmanConcurrentProgramsDAO;
import com.forsys.revmantra.model.BsbReport;
import com.forsys.revmantra.model.RmanArrgSummaryReportV;
import com.forsys.revmantra.model.RmanDefRollforwardReportV;
import com.forsys.revmantra.model.RmanDzsGlAccountingV;
import com.forsys.revmantra.model.RmanFiscalPeriods;
import com.forsys.revmantra.model.RmanGlAccountingV;
import com.forsys.revmantra.model.RmanReconDealsArggRep;
import com.forsys.revmantra.model.RmanReconInvoiceReportV;
import com.forsys.revmantra.model.RmanReconRevtrigRecogRep;
import com.forsys.revmantra.model.RmanReconShippedSoTrgRep;
import com.forsys.revmantra.model.RmanReconSosrcToBkingsRep;
import com.forsys.revmantra.model.RmanTrxDetailReport;
import com.forsys.revmantra.repositories.BsbReportRepository;
import com.forsys.revmantra.repositories.RmanArrgSummaryReportVRepository;
import com.forsys.revmantra.repositories.RmanDefRollforwardReportVRepository;
import com.forsys.revmantra.repositories.RmanDzsGlAccountingVRepository;
import com.forsys.revmantra.repositories.RmanFiscalPeriodsRepository;
import com.forsys.revmantra.repositories.RmanGlAccountingVRepository;
import com.forsys.revmantra.repositories.RmanReconDealsArggRepRepository;
import com.forsys.revmantra.repositories.RmanReconInvoiceReportVRepository;
import com.forsys.revmantra.repositories.RmanReconRevtrigRecogRepRepository;
import com.forsys.revmantra.repositories.RmanReconShippedSoTrgRepRepository;
import com.forsys.revmantra.repositories.RmanReconSosrcToBkingsRepRepository;
import com.forsys.revmantra.repositories.RmanTrxDetailReportRepository;
import com.forsys.revmantra.specification.BaseSpecificationBuilder;
import com.forsys.revmantra.utils.CONSTANTS;
import com.forsys.revmantra.utils.ExportColumns;
import com.forsys.revmantra.utils.RevmantraUtils;

@Controller
public class RevmantraReportsController extends ExportColumns{
	
	private static final PageRequest prequest = PageRequest.of(0, Integer.MAX_VALUE);
	private static final Logger logger = LogManager.getLogger(RevmantraReportsController.class);
	public static final String SEARCH_PATTERN = "([\\S\\s]+?)([:<>])([\\S\\s]+?),";

	@Autowired
	private RmanArrgSummaryReportVRepository rmanArrgSummaryReportVRepo;

	@Autowired
	private RmanFiscalPeriodsRepository rmanFiscalPeriodsRepo;

	@Autowired
	private RmanTrxDetailReportRepository rmanTrxDetailReportRepo;

	@Autowired
	private RmanConcurrentProgramsDAO rmanConcurrentProgramsDAO;

	@Autowired
	private RmanDefRollforwardReportVRepository rmanDefRollforwardReportVRepo;

	@Autowired
	private RmanGlAccountingVRepository rmanGlAccountingVRepo;

	@Autowired
	private RmanReconDealsArggRepRepository rmanReconDealsArggRepRepo;

	@Autowired
	private RmanReconSosrcToBkingsRepRepository rmanReconSosrcToBkingsRepRepo;

	@Autowired
	private RmanReconInvoiceReportVRepository rmanReconInvoiceReportVRepo;

	@Autowired
	private RmanReconShippedSoTrgRepRepository rmanReconShippedSoTrgRepRepo;

	@Autowired
	private RmanReconRevtrigRecogRepRepository rmanReconRevtrigRecogRepRepo;

	@Autowired
	private BsbReportRepository bsbReportRepo;

	@Autowired
	private RmanDzsGlAccountingVRepository rmanDzsGlAccountingVRepo;

	@GetMapping( value = "/api/rmanArrgSummaryReportVSearch")
	@ResponseBody
	public Page<RmanArrgSummaryReportV> searchRmanArrgSummaryReportV(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		BaseSpecificationBuilder<RmanArrgSummaryReportV> builder = new BaseSpecificationBuilder<>(RmanArrgSummaryReportV.class);
		Pattern pattern = Pattern.compile(SEARCH_PATTERN);
		Matcher matcher = pattern.matcher(search + ",");
		while (matcher.find()) {
			builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
		}
		
		if (!(matcher.matches())) {
			RmanFiscalPeriods rfp = rmanFiscalPeriodsRepo.getOpenFiscalPeriod();
			SimpleDateFormat formatter = new SimpleDateFormat(CONSTANTS.YYYY_MM_DD);
			builder.with(CONSTANTS.LAST_ARRG_MODIFIED_DATE, "<", formatter.format(rfp.getEndDate()));
			builder.with(CONSTANTS.LAST_ARRG_MODIFIED_DATE, ">", formatter.format(rfp.getStartDate()));
		}

		Specification<RmanArrgSummaryReportV> spec = builder.build();

		Page<RmanArrgSummaryReportV> page = rmanArrgSummaryReportVRepo.findAll(spec, pageRequest);
		if (page.getContent().isEmpty()) {
			logger.warn("No records fetched in the Consolidated Revenue Contract Summary Report.");
		}
		return page;
	}

	@GetMapping( value = "/api/rmanArrgSummaryReportVExport", produces = "application/vnd.ms-excel")
	@ResponseBody
	public String exportRmanArrgSummaryReportV(@RequestParam(value = "search") String search, @RequestParam(value="exportCols", required=false) List<String> columns,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest, HttpServletResponse response) {

		logger.info("Export of Consolidated Arrangement Summary Report  Initiated");

		String reportDate = new java.text.SimpleDateFormat(CONSTANTS.YYYY_MM_DD_HH_MM_SS)
				.format(new java.util.Date(System.currentTimeMillis()));
		response.setHeader(CONSTANTS.CONTENT_DISPOSITION,
				"inline; filename=Consolidated Arrangements Summary Report_" + reportDate + ".csv");
		BaseSpecificationBuilder<RmanArrgSummaryReportV> builder = new BaseSpecificationBuilder<>(RmanArrgSummaryReportV.class);
		Pattern pattern = Pattern.compile(SEARCH_PATTERN);
		Matcher matcher = pattern.matcher(search + ",");
		while (matcher.find()) {
			builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
		}
		if (!(matcher.matches())) {
			RmanFiscalPeriods rfp = rmanFiscalPeriodsRepo.getOpenFiscalPeriod();
			SimpleDateFormat formatter = new SimpleDateFormat(CONSTANTS.YYYY_MM_DD);
			builder.with(CONSTANTS.LAST_ARRG_MODIFIED_DATE, "<", formatter.format(rfp.getEndDate()));
			builder.with(CONSTANTS.LAST_ARRG_MODIFIED_DATE, ">", formatter.format(rfp.getStartDate()));

		}

		Specification<RmanArrgSummaryReportV> spec = builder.build();
		Page<RmanArrgSummaryReportV> asrList = rmanArrgSummaryReportVRepo.findAll(spec, prequest);
		CsvMapper mapper = new CsvMapper();
		mapper.setDateFormat(new SimpleDateFormat(CONSTANTS.MM_DD_YYYY));
		mapper.enable(JsonGenerator.Feature.IGNORE_UNKNOWN);
		CsvSchema schema = null;
		List<String> line1 = new ArrayList<>();
		
		if(columns !=null) {
			com.fasterxml.jackson.dataformat.csv.CsvSchema.Builder schemaBuilder = CsvSchema.builder().setColumnSeparator(',');
			for (String column : columns) {
				schemaBuilder.addColumn(column);
				line1.add(ExportColumns.rmanArrgSummaryRepV.get(column));
			}
			 schema = schemaBuilder.setUseHeader(false).build();
		}
		
		ObjectWriter objectWriter = mapper.writer(schema);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		try {
			objectWriter.writeValue(baos, line1);
		} catch (IOException e) {
			logger.error(CONSTANTS.ERROR_CONSOLIDATE_ARRG_SUMM_REPORT , e.getMessage());
		}

		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(baos, 1024);
		OutputStreamWriter writerOutputStream;
		try {
			writerOutputStream = new OutputStreamWriter(bufferedOutputStream, StandardCharsets.UTF_8);
			objectWriter.writeValue(writerOutputStream, asrList.getContent());
			writerOutputStream.close();
		} catch (IOException e) {
			logger.error(CONSTANTS.ERROR_CONSOLIDATE_ARRG_SUMM_REPORT , e.getMessage());
		}

		String csvData = baos.toString();
		try {
			baos.close();
		} catch (IOException e) {
			logger.error(CONSTANTS.ERROR_CONSOLIDATE_ARRG_SUMM_REPORT , e.getMessage());
		}
		return csvData;

	}

	@GetMapping( value = "/api/rmanTrxDetailReportSearch")
	@ResponseBody
	public Page<RmanTrxDetailReport> searchRmanTrxDetailReport(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest,
			@RequestParam(value = "period", required = false) String period) {
		logger.info("Transaction Details Report  Initiated");
		BaseSpecificationBuilder<RmanTrxDetailReport> builder = new BaseSpecificationBuilder<>(RmanTrxDetailReport.class);
		Pattern pattern = Pattern.compile(SEARCH_PATTERN);
		Matcher matcher = pattern.matcher(search + ",");
		while (matcher.find()) {
			builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
		}
		if (!(matcher.matches())) {
			RmanFiscalPeriods rfp = rmanFiscalPeriodsRepo.getOpenFiscalPeriod();
			builder.with(CONSTANTS.PERIOD_NAME, ":", rfp.getPeriodName());
		}
		Specification<RmanTrxDetailReport> spec = builder.build();

		Page<RmanTrxDetailReport> page = rmanTrxDetailReportRepo.findAll(spec, pageRequest);
		if (page.getContent().isEmpty()) {
			logger.warn("No records fetched in Transaction Details Report");
		}
		return page;
	}

	@GetMapping( value = "/api/rmanTrxDetailReportExport", produces = "application/vnd.ms-excel")
	@ResponseBody
	public String exportRmanTrxDetailReport(@RequestParam(value = "search") String search, @RequestParam(value="exportCols", required=false) List<String> columns,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest,
			@RequestParam(value = "period", required = false) String period, HttpServletResponse response) {
		logger.info("Export of Transaction Details Report  Initiated");
		String reportDate = new java.text.SimpleDateFormat(CONSTANTS.YYYY_MM_DD_HH_MM_SS)
				.format(new java.util.Date(System.currentTimeMillis()));
		response.setHeader(CONSTANTS.CONTENT_DISPOSITION, "inline; filename=Transaction Details Report_" + reportDate + ".csv");
		BaseSpecificationBuilder<RmanTrxDetailReport> builder = new BaseSpecificationBuilder<>(RmanTrxDetailReport.class);
		Pattern pattern = Pattern.compile(SEARCH_PATTERN);
		Matcher matcher = pattern.matcher(search + ",");
		while (matcher.find()) {
			builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
		}
		if (!(matcher.matches())) {
			RmanFiscalPeriods rfp = rmanFiscalPeriodsRepo.getOpenFiscalPeriod();
			builder.with(CONSTANTS.PERIOD_NAME, ":", rfp.getPeriodName());
		}
		Specification<RmanTrxDetailReport> spec = builder.build();
		Page<RmanTrxDetailReport> tdrList = rmanTrxDetailReportRepo.findAll(spec, prequest);

		CsvMapper mapper = new CsvMapper();
		mapper.setDateFormat(new SimpleDateFormat(CONSTANTS.MM_DD_YYYY));
		mapper.enable(JsonGenerator.Feature.IGNORE_UNKNOWN);
		List<String> line1 = new ArrayList<>();
		CsvSchema schema = null;
		
		if(columns !=null) {
			com.fasterxml.jackson.dataformat.csv.CsvSchema.Builder schemaBuilder = CsvSchema.builder().setColumnSeparator(',');
			for (String column : columns) {
				schemaBuilder.addColumn(column);
				line1.add(ExportColumns.rmanTrxDetailReportV.get(column));
			}
			 schema = schemaBuilder.setUseHeader(false).build();
		}
		
		ObjectWriter objectWriter = mapper.writer(schema);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		try {
			objectWriter.writeValue(baos, line1);
		} catch (IOException e) {
			logger.error(CONSTANTS.ERROR_TRANSACTION_DETAIL_REPORT_EXPORT , e.getMessage());
		}

		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(baos, 1024);
		OutputStreamWriter writerOutputStream;
		try {
			writerOutputStream = new OutputStreamWriter(bufferedOutputStream, StandardCharsets.UTF_8);
			objectWriter.writeValue(writerOutputStream, tdrList.getContent());
			writerOutputStream.close();
		} catch (IOException e) {
			logger.error(CONSTANTS.ERROR_TRANSACTION_DETAIL_REPORT_EXPORT , e.getMessage());
		}
		String csvData = baos.toString();
		try {
			baos.close();
		} catch (IOException e) {
			logger.error(CONSTANTS.ERROR_TRANSACTION_DETAIL_REPORT_EXPORT , e.getMessage());
		}
		return csvData;
	}

	@GetMapping(value = "/api/revmantra/wfr")
	@ResponseBody
	public String revmantraWaterfall(@RequestParam(value = "fromArrgId") BigDecimal fromArrgId,
			@RequestParam(value = "toArrgId") BigDecimal toArrgId,
			@RequestParam(value = "fromPeriod") String fromPeriod, @RequestParam(value = "toPeriod") String toPeriod,
			@RequestParam(value = "po") String po, @RequestParam(value = "so") String so,
			@RequestParam(value = "legalEntity") BigDecimal legalEntity) {
		logger.info("Waterfall Details Report Initiated");
		return rmanConcurrentProgramsDAO.waterFallRepDetails(fromArrgId, toArrgId, fromPeriod, toPeriod, po, so,
				legalEntity != null ? legalEntity : new BigDecimal(0));

	}

	@GetMapping(value = "/api/exportWFReport", produces = "application/vnd.ms-excel")
	@ResponseBody
	public String exportWaterfallRep(@RequestParam(value = "fromArrgId") BigDecimal fromArrgId,
			@RequestParam(value = "toArrgId") BigDecimal toArrgId,
			@RequestParam(value = "fromPeriod") String fromPeriod, @RequestParam(value = "toPeriod") String toPeriod,
			@RequestParam(value = "po") String po, @RequestParam(value = "so") String so,
			@RequestParam(value = "legalEntity") BigDecimal legalEntity, @RequestParam(value="exportCols", required=false) List<String> exportCols, HttpServletResponse response) {
		logger.info("Export of Waterfall Details Report Initiated");
		String reportDate = new java.text.SimpleDateFormat(CONSTANTS.YYYY_MM_DD_HH_MM_SS)
				.format(new java.util.Date(System.currentTimeMillis()));
		response.setHeader(CONSTANTS.CONTENT_DISPOSITION, "inline; filename=WaterFall Details Report_" + reportDate + ".csv");
		String json = rmanConcurrentProgramsDAO.waterFallRepDetails(fromArrgId, toArrgId, fromPeriod, toPeriod, po, so,
				legalEntity != null ? legalEntity : new BigDecimal(0));

		try {

			JsonNode arrNode = new ObjectMapper().readTree(json).get(CONSTANTS.CONTENT);
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
					String replacedStr = str.replaceAll(CONSTANTS.SPECIAL_CHARS, "").trim(); 
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
			return getCSVData(CONSTANTS.ERROR_WATERFALL_DETAIL_REPORT_EXPORT, baos);

		} catch (IOException e) {
			logger.error(CONSTANTS.ERROR_WATERFALL_DETAIL_REPORT_EXPORT , e.getMessage());
		}
		return null;
	}

	@GetMapping( value = "/api/rmanDefRollforwardReportVSearch")
	@ResponseBody
	public Page<RmanDefRollforwardReportV> searchRmanDefRollforwardReportV(
			@RequestParam(value = "search") String search, @PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		logger.info("Deferred Revenue Roll forward Report initiated");
		BaseSpecificationBuilder<RmanDefRollforwardReportV> builder = new BaseSpecificationBuilder<>(RmanDefRollforwardReportV.class);
		Pattern pattern = Pattern.compile(SEARCH_PATTERN);
		Matcher matcher = pattern.matcher(search + ",");

		while (matcher.find()) {
			builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
		}
		Page<RmanDefRollforwardReportV> page = null;
		if (!(matcher.matches())) {
			page = rmanConcurrentProgramsDAO.rmanDefRollforwardReportVParamSet(null, null,null,null,null, pageRequest);
		} else {
			Specification<RmanDefRollforwardReportV> spec = builder.build();
			page = rmanDefRollforwardReportVRepo.findAll(spec, pageRequest);
		}
		if (page.getContent().isEmpty()) {
			logger.warn("No records fetched from Search Results for this Deferred Revenue Rollforard Report.");
		}
		return page;
	}

	@GetMapping(value = "/api/revmantra/deferredRevenueRollForwardRep")
	@ResponseBody
	public Page<RmanDefRollforwardReportV> deferredRevenueRollForwardRep(
			@RequestParam(value = "periodType") String periodType,
			@RequestParam(value = "asOfPeriod") String asOfPeriod,
			@RequestParam(value = "dealArrgNum") String dealArrangementNumber,
			@RequestParam(value = "so") String so,
			@RequestParam(value = "po") String po,
			@PageableDefault(page = 0, size = 10) Pageable pageReq) {
		
		
		return rmanConcurrentProgramsDAO.rmanDefRollforwardReportVParamSet(periodType, asOfPeriod, dealArrangementNumber, so, po, pageReq);

	}

	@GetMapping( value = "/api/rmanDeferredRevenueRollForwardRepExport", produces = "application/vnd.ms-excel")
	@ResponseBody
	public String exportDeferredRevenueRollForwardRep(@RequestParam(value = "periodType") String periodType, 
			@RequestParam(value="exportCols", required=false) List<String> columns,
			@RequestParam(value = "asOfPeriod") String asOfPeriod, 
			@RequestParam(value = "dealArrgNum") String dealArrangementNumber,
			@RequestParam(value = "so") String so,
			@RequestParam(value = "po") String po,
			HttpServletResponse response) {
		logger.info("Export of Deferred Revenue Rollforard Report  Initiated");
		String reportDate = new java.text.SimpleDateFormat(CONSTANTS.YYYY_MM_DD_HH_MM_SS)
				.format(new java.util.Date(System.currentTimeMillis()));
		response.setHeader(CONSTANTS.CONTENT_DISPOSITION,
				"inline; filename=Deferred Revenue Roll Forward Report_" + reportDate + ".csv");
		List<RmanDefRollforwardReportV> drfRepList = rmanConcurrentProgramsDAO
				.rmanDefRollforwardReportVParamSetResults(periodType, asOfPeriod, dealArrangementNumber, so, po);
		CsvMapper mapper = new CsvMapper();
		mapper.setDateFormat(new SimpleDateFormat(CONSTANTS.MM_DD_YYYY));
		mapper.enable(JsonGenerator.Feature.IGNORE_UNKNOWN);
		CsvSchema schema = null;
		List<String> line1 = new ArrayList<>();

		if(columns !=null) {
			com.fasterxml.jackson.dataformat.csv.CsvSchema.Builder schemaBuilder = CsvSchema.builder().setColumnSeparator(',');
			for (String column : columns) {
				schemaBuilder.addColumn(column);
				line1.add(ExportColumns.rmanDeferredRollForwardRepV.get(column));
			}
			 schema = schemaBuilder.setUseHeader(false).build();
		}
		
		ObjectWriter objectWriter = mapper.writer(schema);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		try {
			objectWriter.writeValue(baos, line1);
		} catch (IOException e) {
			logger.error("Export of Deferred Revenue Rollforard Report failed due to  {}" , e.getMessage());
		}

		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(baos, 1024);
		OutputStreamWriter writerOutputStream;
		try {
			writerOutputStream = new OutputStreamWriter(bufferedOutputStream, StandardCharsets.UTF_8);
			objectWriter.writeValue(writerOutputStream, drfRepList);
			writerOutputStream.close();
		} catch (IOException e) {
			logger.error(CONSTANTS.ERROR_DEFERRED_REVENUE_ROLLFORWARD_REPORT_EXPORT , e.getMessage());
		}
		String csvData = baos.toString();
		try {
			baos.close();
		} catch (IOException e) {
			logger.error(CONSTANTS.ERROR_DEFERRED_REVENUE_ROLLFORWARD_REPORT_EXPORT , e.getMessage());
		}
		return csvData;

	}

	@GetMapping( value = {"/api/rmanGlAccountingVSearch","/api/sfqi/rmanGlAccountingVSearch"})
	@ResponseBody
	public Page<RmanGlAccountingV> searchRmanGlAccountingV(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		logger.info("Account Analysis Report  Initiated");
		BaseSpecificationBuilder<RmanGlAccountingV> builder = new BaseSpecificationBuilder<>(RmanGlAccountingV.class);
		Pattern pattern = Pattern.compile(SEARCH_PATTERN);
		Matcher matcher = pattern.matcher(search + ",");

		while (matcher.find()) {
			builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
		}
		Specification<RmanGlAccountingV> spec = builder.build();
		return rmanGlAccountingVRepo.findAll(spec, pageRequest);
	}

	@GetMapping( value = "/api/rmanGlAccountingVExport", produces = "application/vnd.ms-excel")
	@ResponseBody
	public String exportRmanGlAccountingV(@RequestParam(value = "search") String search,@RequestParam(value="exportCols", required=false) List<String> columns,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest, HttpServletResponse response) {
		logger.info("Export of Account Analasis Report  Initiated");
		String reportDate = new java.text.SimpleDateFormat(CONSTANTS.YYYY_MM_DD_HH_MM_SS)
				.format(new java.util.Date(System.currentTimeMillis()));
		response.setHeader(CONSTANTS.CONTENT_DISPOSITION, "inline; filename=Account Analysis Report_" + reportDate + ".csv");
		BaseSpecificationBuilder<RmanGlAccountingV> builder = new BaseSpecificationBuilder<>(RmanGlAccountingV.class);
		Pattern pattern = Pattern.compile(SEARCH_PATTERN);
		Matcher matcher = pattern.matcher(search + ",");
		while (matcher.find()) {
			builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
		}

		Specification<RmanGlAccountingV> spec = builder.build();
		Page<RmanGlAccountingV> glList = rmanGlAccountingVRepo.findAll(spec, prequest);
		CsvMapper mapper = new CsvMapper();
		mapper.setDateFormat(new SimpleDateFormat(CONSTANTS.MM_DD_YYYY));
		mapper.enable(JsonGenerator.Feature.IGNORE_UNKNOWN);
		CsvSchema schema = null;
		List<String> line1 = new ArrayList<>();
		
		/**  #AYAR-369 Anil Mullamuri on 22-MAY-2021 **/
		com.fasterxml.jackson.dataformat.csv.CsvSchema.Builder schemaBuilder = CsvSchema.builder().setColumnSeparator(',');
		if(columns !=null) {
			for (String column : columns) {
				schemaBuilder.addColumn(column);
				line1.add(ExportColumns.rmanGlAccountingV.get(column));
			}
		}else {
			ExportColumns.rmanGlAccountingV.forEach((key, value) -> {
				schemaBuilder.addColumn(key);
				line1.add(ExportColumns.rmanGlAccountingV.get(key));
			});
		}
		schema = schemaBuilder.setUseHeader(false).build();
		
		ObjectWriter objectWriter = mapper.writer(schema);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		try {
			objectWriter.writeValue(baos, line1);
		} catch (IOException e) {
			logger.error(CONSTANTS.ERROR_ACCOUNT_ANALYSIS_REPORT_EXPORT , e.getMessage());
		}

		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(baos, 1024);
		OutputStreamWriter writerOutputStream;
		try {
			writerOutputStream = new OutputStreamWriter(bufferedOutputStream, StandardCharsets.UTF_8);
			objectWriter.writeValue(writerOutputStream, glList.getContent());
			writerOutputStream.close();
		} catch (IOException e) {
			logger.error(CONSTANTS.ERROR_ACCOUNT_ANALYSIS_REPORT_EXPORT , e.getMessage());
		}

		String csvData = baos.toString();
		try {
			baos.close();
		} catch (IOException e) {
			logger.error(CONSTANTS.ERROR_ACCOUNT_ANALYSIS_REPORT_EXPORT , e.getMessage());
		}
		return csvData;
	}

	@GetMapping(value = "/api/revmantra/reconReportParams")
	@ResponseBody
	public Page<RmanReconDealsArggRep> revmantraReconparamsSet(@RequestParam(value = "fromDate") String fromDate,
			@RequestParam(value = "toDate") String toDate, @RequestParam(value = "legalEntity") BigDecimal legalEntity,
			@PageableDefault(page = 0, size = 10) Pageable pageReq) {
		Timestamp fDate = null;
		Timestamp tDate = null;
		if (fromDate != null && !fromDate.isEmpty()) {
			fDate = RevmantraUtils.convertStringtoTimestamp(fromDate);
		}
		if (toDate != null && !toDate.isEmpty()) {
			tDate = RevmantraUtils.convertStringtoTimestamp(toDate);
		}
		logger.info("Reconcilation of Quotes/Deals/Sales Order to Arrangements Report Initiated with Params");
		return rmanConcurrentProgramsDAO.reconParamsReports(fDate, tDate, legalEntity, pageReq);

	}

	@GetMapping( value = "/api/rmanReconDealsArggRepSearch")
	@ResponseBody
	public Page<RmanReconDealsArggRep> searchRmanReconDealsArggRep(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		logger.info("Reconcilation of Quotes/Deals/Sales Order to Arrangements Report Initiated");
		BaseSpecificationBuilder<RmanReconDealsArggRep> builder = new BaseSpecificationBuilder<>(RmanReconDealsArggRep.class);
		Pattern pattern = Pattern.compile(SEARCH_PATTERN);
		Matcher matcher = pattern.matcher(search + ",");

		while (matcher.find()) {
			builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
		}

		Page<RmanReconDealsArggRep> page = null;
		if (!(matcher.matches())) {
			page = rmanConcurrentProgramsDAO.reconParamsReports(null, null, null, pageRequest);
		} else {
			Specification<RmanReconDealsArggRep> spec = builder.build();

			page = rmanReconDealsArggRepRepo.findAll(spec, pageRequest);

		}
		if (page.getContent().isEmpty()) {
			logger.warn("No results fetch for Reconcilation of Quotes/Deals/Sales Order to Arrangements");
		}
		return page;
	}

	@GetMapping( value = "/api/rmanReconDealsArggRepExport", produces = "application/vnd.ms-excel")
	@ResponseBody
	public String exportRmanReconDealsArggRep(@RequestParam(value = "fromDate") String fromDate, @RequestParam(value="exportCols", required=false) List<String> columns,
			@RequestParam(value = "toDate") String toDate, @RequestParam(value = "legalEntity") BigDecimal legalEntity,
			HttpServletResponse response) {
		logger.info("Export of Reconcilation of Quotes/Deals/Sales Order to Arrangements initiated.");
		String reportDate = new java.text.SimpleDateFormat(CONSTANTS.YYYY_MM_DD_HH_MM_SS)
				.format(new java.util.Date(System.currentTimeMillis()));
		response.setHeader(CONSTANTS.CONTENT_DISPOSITION,
				"inline; filename=Reconciliation of Deals to Arrangements Report_" + reportDate + ".csv");
		Timestamp fDate = null;
		Timestamp tDate = null;
		if (fromDate != null && !fromDate.isEmpty()) {
			fDate = RevmantraUtils.convertStringtoTimestamp(fromDate);
		}
		if (toDate != null && !toDate.isEmpty()) {
			tDate = RevmantraUtils.convertStringtoTimestamp(toDate);
		}
		Page<RmanReconDealsArggRep> page = null;
		page = rmanConcurrentProgramsDAO.reconParamsReports(fDate, tDate, legalEntity, prequest);
		CsvMapper mapper = new CsvMapper();
		mapper.setDateFormat(new SimpleDateFormat(CONSTANTS.MM_DD_YYYY));
		mapper.enable(JsonGenerator.Feature.IGNORE_UNKNOWN);
		CsvSchema schema = null;
		List<String> line1 = new ArrayList<>();
		
		if(columns !=null) {
			com.fasterxml.jackson.dataformat.csv.CsvSchema.Builder schemaBuilder = CsvSchema.builder().setColumnSeparator(',');
			for (String column : columns) {
				schemaBuilder.addColumn(column);
				line1.add(ExportColumns.rmanReconDealsArggRepV.get(column));
			}
			 schema = schemaBuilder.setUseHeader(false).build();
		}
		
		ObjectWriter objectWriter = mapper.writer(schema);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		try {
			objectWriter.writeValue(baos, line1);
		} catch (IOException e) {
			logger.error(CONSTANTS.ERROR_RECON_Q_D_S_TO_ARRG , e.getMessage());
		}

		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(baos, 1024);
		OutputStreamWriter writerOutputStream;
		try {
			writerOutputStream = new OutputStreamWriter(bufferedOutputStream, StandardCharsets.UTF_8);
			objectWriter.writeValue(writerOutputStream, page.getContent());
			writerOutputStream.close();
		} catch (IOException e) {
			logger.error(CONSTANTS.ERROR_RECON_Q_D_S_TO_ARRG , e.getMessage());
		}
		String csvData = baos.toString();
		try {
			baos.close();
		} catch (IOException e) {
			logger.error(CONSTANTS.ERROR_RECON_Q_D_S_TO_ARRG , e.getMessage());
		}
		return csvData;

	}

	@GetMapping( value = "/api/rmanReconSosrcToBkingsRepSearch")
	@ResponseBody
	public Page<RmanReconSosrcToBkingsRep> searchRmanReconSosrcToBkingsRep(
			@RequestParam(value = "search") String search, @PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		logger.info("Reconciliation Sales Order/Service Contracts to Bookings Report iniated");
		BaseSpecificationBuilder<RmanReconSosrcToBkingsRep> builder = new BaseSpecificationBuilder<>(RmanReconSosrcToBkingsRep.class);
		Pattern pattern = Pattern.compile(SEARCH_PATTERN);
		Matcher matcher = pattern.matcher(search + ",");

		while (matcher.find()) {
			builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
		}
		Page<RmanReconSosrcToBkingsRep> page = null;
		if (!(matcher.matches())) {
			page = rmanConcurrentProgramsDAO.reconSoSrcToBkingsRepo(null, null, null, pageRequest);
		} else {
			Specification<RmanReconSosrcToBkingsRep> spec = builder.build();
			page = rmanReconSosrcToBkingsRepRepo.findAll(spec, pageRequest);
		}
		if (page.getContent().isEmpty()) {
			logger.warn("No results fetch for Reconciliation Sales Order/Service Contracts to Bookings Report.");
		}
		return page;
	}

	@GetMapping(value = "/api/revmantra/reconSoSrcToBkingsParams")
	@ResponseBody
	public Page<RmanReconSosrcToBkingsRep> revmantraReconSOSrcBkings(@RequestParam(value = "fromDate") String fromDate,
			@RequestParam(value = "toDate") String toDate, @RequestParam(value = "legalEntity") BigDecimal legalEntity,
			@PageableDefault(page = 0, size = 10) Pageable pageReq) {
		logger.info("Reconciliation Sales Order/Service Contracts to Bookings Report Initiated with backend api call");
		Timestamp fDate = null;
		Timestamp tDate = null;
		if (fromDate != null && !fromDate.isEmpty()) {
			fDate = RevmantraUtils.convertStringtoTimestamp(fromDate);
		}
		if (toDate != null && !toDate.isEmpty()) {
			tDate = RevmantraUtils.convertStringtoTimestamp(toDate);
		}

		return rmanConcurrentProgramsDAO.reconSoSrcToBkingsRepo(fDate, tDate, legalEntity, pageReq);

	}

	@GetMapping( value = "/api/rmanReconSosrcToBkingsRepExport", produces = "application/vnd.ms-excel")
	@ResponseBody
	public String exportRmanReconSosrcToBkingsRep(@RequestParam(value = "fromDate") String fromDate, @RequestParam(value="exportCols", required=false) List<String> columns,
			@RequestParam(value = "toDate") String toDate, @RequestParam(value = "legalEntity") BigDecimal legalEntity,
			@PageableDefault(page = 0, size = 10) Pageable pageReq, HttpServletResponse response) {
		logger.info("Export of Reconciliation Sales Order/Service Contracts to Bookings Report Initiated.");

		String reportDate = new java.text.SimpleDateFormat(CONSTANTS.YYYY_MM_DD_HH_MM_SS)
				.format(new java.util.Date(System.currentTimeMillis()));
		response.setHeader(CONSTANTS.CONTENT_DISPOSITION,
				"inline; filename=Reconciliation of Sales Orders/Service Contracts to Bookings Report_" + reportDate
						+ ".csv");

		Timestamp fDate = RevmantraUtils.convertStringtoTimestamp(fromDate);

		Timestamp tDate = RevmantraUtils.convertStringtoTimestamp(toDate);

		Page<RmanReconSosrcToBkingsRep> page = null;
		page = rmanConcurrentProgramsDAO.reconSoSrcToBkingsRepo(fDate, tDate, legalEntity, prequest);
		CsvMapper mapper = new CsvMapper();
		mapper.setDateFormat(new SimpleDateFormat(CONSTANTS.MM_DD_YYYY));
		mapper.enable(JsonGenerator.Feature.IGNORE_UNKNOWN);
		CsvSchema schema = null;

		List<String> line1 = new ArrayList<>();
		
		if(columns !=null) {
			com.fasterxml.jackson.dataformat.csv.CsvSchema.Builder schemaBuilder = CsvSchema.builder().setColumnSeparator(',');
			for (String column : columns) {
				schemaBuilder.addColumn(column);
				line1.add(ExportColumns.rmanReconSosrcToBkingsRepV.get(column));
			}
			 schema = schemaBuilder.setUseHeader(false).build();
		}
		
		ObjectWriter objectWriter = mapper.writer(schema);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		try {
			objectWriter.writeValue(baos, line1);
		} catch (IOException e) {
			logger.error(
					CONSTANTS.ERROR_RECON_Q_D_S_TO_BOOK , e.getMessage());
		}

		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(baos, 1024);
		OutputStreamWriter writerOutputStream;
		try {
			writerOutputStream = new OutputStreamWriter(bufferedOutputStream, StandardCharsets.UTF_8);
			objectWriter.writeValue(writerOutputStream, page.getContent());
			writerOutputStream.close();
		} catch (IOException e) {
			logger.error(
					CONSTANTS.ERROR_RECON_Q_D_S_TO_BOOK, e.getMessage());
		}
		String csvData = baos.toString();
		try {
			baos.close();
		} catch (IOException e) {
			logger.error(
					CONSTANTS.ERROR_RECON_Q_D_S_TO_BOOK , e.getMessage());
		}
		return csvData;

	}

	@GetMapping( value = "/api/rmanReconInvoiceReportVSearch")
	@ResponseBody
	public Page<RmanReconInvoiceReportV> searchRmanReconInvoiceReportV(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		logger.info("Reconciliation of Shipments/Fulfillments to Billings Report Initiated");
		BaseSpecificationBuilder<RmanReconInvoiceReportV> builder = new BaseSpecificationBuilder<>(RmanReconInvoiceReportV.class);
		Pattern pattern = Pattern.compile(SEARCH_PATTERN);
		Matcher matcher = pattern.matcher(search + ",");

		while (matcher.find()) {
			builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
		}
		if (!(matcher.matches())) {
			SimpleDateFormat formatter = new SimpleDateFormat(CONSTANTS.YYYY_MM_DD);
			RmanFiscalPeriods rfp = rmanFiscalPeriodsRepo.getOpenFiscalPeriod();
			builder.with(CONSTANTS.ACTUAL_FULFILLED_DATE, ">", formatter.format(rfp.getStartDate()));
			builder.with(CONSTANTS.ACTUAL_FULFILLED_DATE, "<", formatter.format(rfp.getEndDate()));
		}

		Specification<RmanReconInvoiceReportV> spec = builder.build();

		Page<RmanReconInvoiceReportV> page = rmanReconInvoiceReportVRepo.findAll(spec, pageRequest);
		if (page.getContent().isEmpty()) {
			logger.warn("No Results fetch for Reconciliation of Shipments/Fulfillments to Billings Report");
		}
		return page;
	}

	@GetMapping( value = "/api/rmanReconInvoiceReportVExport", produces = "application/vnd.ms-excel")
	@ResponseBody
	public String exportRmanReconInvoiceReportV(@RequestParam(value = "search") String search, @RequestParam(value="exportCols", required=false) List<String> columns,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest, HttpServletResponse response) {
		logger.info("Export of Reconciliation of Shipments/Fulfillments to Billings Report Initiaed");
		String reportDate = new java.text.SimpleDateFormat(CONSTANTS.YYYY_MM_DD_HH_MM_SS)
				.format(new java.util.Date(System.currentTimeMillis()));
		response.setHeader(CONSTANTS.CONTENT_DISPOSITION,
				"inline; filename=Reconciliation of Shipments/Fulfillments to Billings Report_" + reportDate + ".csv");
		BaseSpecificationBuilder<RmanReconInvoiceReportV> builder = new BaseSpecificationBuilder<>(RmanReconInvoiceReportV.class);
		Pattern pattern = Pattern.compile(SEARCH_PATTERN);
		Matcher matcher = pattern.matcher(search + ",");
		while (matcher.find()) {
			builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
		}

		if (!(matcher.matches())) {
			SimpleDateFormat formatter = new SimpleDateFormat(CONSTANTS.YYYY_MM_DD);
			RmanFiscalPeriods rfp = rmanFiscalPeriodsRepo.getOpenFiscalPeriod();
			builder.with(CONSTANTS.ACTUAL_FULFILLED_DATE, ">", formatter.format(rfp.getStartDate()));
			builder.with(CONSTANTS.ACTUAL_FULFILLED_DATE, "<", formatter.format(rfp.getEndDate()));
		}

		Specification<RmanReconInvoiceReportV> spec = builder.build();

		Page<RmanReconInvoiceReportV> page = null;
		page = rmanReconInvoiceReportVRepo.findAll(spec, prequest);
		CsvMapper mapper = new CsvMapper();
		mapper.setDateFormat(new SimpleDateFormat(CONSTANTS.MM_DD_YYYY));
		mapper.enable(JsonGenerator.Feature.IGNORE_UNKNOWN);
		CsvSchema schema = null;
		List<String> line1 = new ArrayList<>();
		
		if(columns !=null) {
			com.fasterxml.jackson.dataformat.csv.CsvSchema.Builder schemaBuilder = CsvSchema.builder().setColumnSeparator(',');
			for (String column : columns) {
				schemaBuilder.addColumn(column);
				line1.add(ExportColumns.rmanReconInvoiceRepV.get(column));
			}
			 schema = schemaBuilder.setUseHeader(false).build();
		}
		
		ObjectWriter objectWriter = mapper.writer(schema);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		try {
			objectWriter.writeValue(baos, line1);
		} catch (IOException e) {
			logger.error("Export of Reconciliation of Shipments/Fulfillments to Billings Report failed due to {} " , e.getMessage());
		}

		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(baos, 1024);
		OutputStreamWriter writerOutputStream;
		try {
			writerOutputStream = new OutputStreamWriter(bufferedOutputStream, StandardCharsets.UTF_8);
			objectWriter.writeValue(writerOutputStream, page.getContent());
			writerOutputStream.close();
		} catch (IOException e) {
			logger.error(CONSTANTS.ERROR_RECON_S_F_TO_BILL , e.getMessage());
		}

		String csvData = baos.toString();
		try {
			baos.close();
		} catch (IOException e) {
			logger.error("Export of Reconciliation of Shipments/Fulfillments to Billings Report failed due to {}" , e.getMessage());
		}
		return csvData;

	}

	@GetMapping( value = "/api/rmanReconShippedSoTrgRepSearch")
	@ResponseBody
	public Page<RmanReconShippedSoTrgRep> searchRmanReconShippedSoTrgRep(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		logger.info("Reconciliation Shipments/Fulfillments to Revenue Triggers Report Initiated");
		BaseSpecificationBuilder<RmanReconShippedSoTrgRep> builder = new BaseSpecificationBuilder<>(RmanReconShippedSoTrgRep.class);
		Pattern pattern = Pattern.compile(SEARCH_PATTERN);
		Matcher matcher = pattern.matcher(search + ",");

		while (matcher.find()) {
			builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
		}

		Specification<RmanReconShippedSoTrgRep> spec = builder.build();

		Page<RmanReconShippedSoTrgRep> page = rmanReconShippedSoTrgRepRepo.findAll(spec, pageRequest);
		if (page.getContent().isEmpty()) {
			logger.warn("No Results fetched for Reconciliation Shipments/Fulfillments to Revenue Triggers Report.");
		}
		return page;
	}

	@GetMapping(value = "/api/revmantra/reconShippedSOTrigParams")
	@ResponseBody
	public Page<RmanReconShippedSoTrgRep> revmantraReconShippedSoTrig(@RequestParam(value = "fromDate") String fromDate,
			@RequestParam(value = "toDate") String toDate, @RequestParam(value = "legalEntity") BigDecimal legalEntity,
			@PageableDefault(page = 0, size = 10) Pageable pageReq) {
		logger.info("Reconciliation Shipments/Fulfillments to Revenue Triggers Report Initiated with backend call");
		Timestamp fDate = null;
		Timestamp tDate = null;
		if (fromDate != null && !fromDate.isEmpty()) {
			fDate = RevmantraUtils.convertStringtoTimestamp(fromDate);
		}
		if (toDate != null && !toDate.isEmpty()) {
			tDate = RevmantraUtils.convertStringtoTimestamp(toDate);
		}

		return rmanConcurrentProgramsDAO.reconShippedSoTrigBkingsRepo(fDate, tDate, legalEntity, pageReq);

	}

	@GetMapping( value = "/api/rmanReconShippedSoTrgRepExport", produces = "application/vnd.ms-excel")
	@ResponseBody
	public String exportRmanReconShippedSoTrgRep(@RequestParam(value = "fromDate") String fromDate, 
			@RequestParam(value = "toDate") String toDate, @RequestParam(value = "legalEntity") BigDecimal legalEntity, @RequestParam(value="exportCols", required=false) List<String> columns,
			HttpServletResponse response) {
		logger.info(
				"Export of Reconciliation Shipments/Fulfillments to Revenue Triggers Report Initiated with backend call");

		String reportDate = new java.text.SimpleDateFormat(CONSTANTS.YYYY_MM_DD_HH_MM_SS)
				.format(new java.util.Date(System.currentTimeMillis()));
		response.setHeader(CONSTANTS.CONTENT_DISPOSITION,
				"inline; filename=Reconciliation of Shipments/Fulfillments to Revenue Report_" + reportDate + ".csv");
		Timestamp fDate = null;
		Timestamp tDate = null;
		if (fromDate != null && !fromDate.isEmpty()) {
			fDate = RevmantraUtils.convertStringtoTimestamp(fromDate);
		}
		if (toDate != null && !toDate.isEmpty()) {
			tDate = RevmantraUtils.convertStringtoTimestamp(toDate);
		}
		Page<RmanReconShippedSoTrgRep> page = null;
		page = rmanConcurrentProgramsDAO.reconShippedSoTrigBkingsRepo(fDate, tDate, legalEntity, prequest);
		CsvMapper mapper = new CsvMapper();
		mapper.setDateFormat(new SimpleDateFormat(CONSTANTS.MM_DD_YYYY));
		mapper.enable(JsonGenerator.Feature.IGNORE_UNKNOWN);
		CsvSchema schema = null;
		List<String> line1 = new ArrayList<>();
		
		if(columns !=null) {
			com.fasterxml.jackson.dataformat.csv.CsvSchema.Builder schemaBuilder = CsvSchema.builder().setColumnSeparator(',');
			for (String column : columns) {
				schemaBuilder.addColumn(column);
				line1.add(ExportColumns.rmanReconShippedSoTrgRepV.get(column));
			}
			 schema = schemaBuilder.setUseHeader(false).build();
		}
		
		ObjectWriter objectWriter = mapper.writer(schema);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		try {
			objectWriter.writeValue(baos, line1);
		} catch (IOException e) {
			logger.error(
					CONSTANTS.ERROR_RECON_S_F_TO_R_TRIGGERS , e.getMessage());
		}

		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(baos, 1024);
		OutputStreamWriter writerOutputStream;
		try {
			writerOutputStream = new OutputStreamWriter(bufferedOutputStream, StandardCharsets.UTF_8);
			objectWriter.writeValue(writerOutputStream, page.getContent());
			writerOutputStream.close();
		} catch (IOException e) {
			logger.error(CONSTANTS.ERROR_RECON_S_F_TO_R_TRIGGERS , e.getMessage());
		}
		String csvData = baos.toString();
		try {
			baos.close();
		} catch (IOException e) {
			logger.error(
					CONSTANTS.ERROR_RECON_S_F_TO_R_TRIGGERS , e.getMessage());
		}
		return csvData;

	}

	@GetMapping( value = "/api/rmanReconRevtrigRecogRepSearch")
	@ResponseBody
	public Page<RmanReconRevtrigRecogRep> searchRmanReconRevtrigRecogRep(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		logger.info("Reconciliation Revenue Triggers to Recognize Revenue Report Initiated");
		BaseSpecificationBuilder<RmanReconRevtrigRecogRep> builder = new BaseSpecificationBuilder<>(RmanReconRevtrigRecogRep.class);
		Pattern pattern = Pattern.compile(SEARCH_PATTERN);
		Matcher matcher = pattern.matcher(search + ",");

		while (matcher.find()) {
			builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
		}

		Specification<RmanReconRevtrigRecogRep> spec = builder.build();

		Page<RmanReconRevtrigRecogRep> page = rmanReconRevtrigRecogRepRepo.findAll(spec, pageRequest);
		if (page.getContent().isEmpty()) {
			logger.warn("No reults fetch for Reconciliation Revenue Triggers to Recognize Revenue Report");
		}
		return page;
	}

	@GetMapping(value = "/api/revmantra/reconRevTrigRecognizeParams")
	@ResponseBody
	public Page<RmanReconRevtrigRecogRep> revmantraReconRevTrigRecog(@RequestParam(value = "fromDate") String fromDate,
			@RequestParam(value = "toDate") String toDate, @RequestParam(value = "legalEntity") BigDecimal legalEntity,
			@PageableDefault(page = 0, size = 10) Pageable pageReq) {
		logger.info("Reconciliation Revenue Triggers to Recognize Revenue Report Initiated with backend call");
		Timestamp fDate = null;
		Timestamp tDate = null;
		if (fromDate != null && !fromDate.isEmpty()) {
			fDate = RevmantraUtils.convertStringtoTimestamp(fromDate);
		}
		if (toDate != null && !toDate.isEmpty()) {
			tDate = RevmantraUtils.convertStringtoTimestamp(toDate);
		}
		return rmanConcurrentProgramsDAO.reconRevTrigRecognizeRepo(fDate, tDate, legalEntity, pageReq);

	}

	@GetMapping( value = "/api/rmanReconRevtrigRecogRepExport", produces = "application/vnd.ms-excel")
	@ResponseBody
	public String exportRmanReconRevtrigRecogRep(@RequestParam(value = "fromDate") String fromDate,
			@RequestParam(value = "toDate") String toDate, @RequestParam(value = "legalEntity") BigDecimal legalEntity, @RequestParam(value="exportCols", required=false) List<String> columns,
			HttpServletResponse response) {
		logger.info(
				"Export of Reconciliation Revenue Triggers to Recognize Revenue Report Initiated with backend call.");
		String reportDate = new java.text.SimpleDateFormat(CONSTANTS.YYYY_MM_DD_HH_MM_SS)
				.format(new java.util.Date(System.currentTimeMillis()));
		response.setHeader(CONSTANTS.CONTENT_DISPOSITION,
				"inline; filename=Reconciliation of Revenue Triggers to Recognize Revenue Report_" + reportDate
						+ ".csv");

		Timestamp fDate = null;
		Timestamp tDate = null;
		if (fromDate != null && !fromDate.isEmpty()) {
			fDate = RevmantraUtils.convertStringtoTimestamp(fromDate);
		}
		if (toDate != null && !toDate.isEmpty()) {
			tDate = RevmantraUtils.convertStringtoTimestamp(toDate);
		}
		Page<RmanReconRevtrigRecogRep> page = null;
		page = rmanConcurrentProgramsDAO.reconRevTrigRecognizeRepo(fDate, tDate, legalEntity, prequest);
		CsvMapper mapper = new CsvMapper();
		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
		mapper.enable(JsonGenerator.Feature.IGNORE_UNKNOWN);
		CsvSchema schema = null;
		List<String> line1 = new ArrayList<>();
		
		if(columns !=null) {
			com.fasterxml.jackson.dataformat.csv.CsvSchema.Builder schemaBuilder = CsvSchema.builder().setColumnSeparator(',');
			for (String column : columns) {
				schemaBuilder.addColumn(column);
				line1.add(ExportColumns.rmanReconRevtrigRecogRepV.get(column));
			}
			 schema = schemaBuilder.setUseHeader(false).build();
		}
		
		 ObjectWriter objectWriter = mapper.writer(schema);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		try {
			objectWriter.writeValue(baos, line1);
		} catch (IOException e) {
			logger.error(CONSTANTS.ERROR_RECON_R_TRIGGERS_TO_RECOG_REVENUE , e.getMessage());
		}

		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(baos, 1024);
		OutputStreamWriter writerOutputStream;
		try {
			writerOutputStream = new OutputStreamWriter(bufferedOutputStream, StandardCharsets.UTF_8);
			objectWriter.writeValue(writerOutputStream, page.getContent());
			writerOutputStream.close();
		} catch (IOException e) {
			logger.error(CONSTANTS.ERROR_RECON_R_TRIGGERS_TO_RECOG_REVENUE , e.getMessage());
		}
		String csvData = baos.toString();
		try {
			baos.close();
		} catch (IOException e) {
			logger.error(CONSTANTS.ERROR_RECON_R_TRIGGERS_TO_RECOG_REVENUE , e.getMessage());
		}
		return csvData;

	}

	@GetMapping( value = "/api/bsbReportSearch")
	@ResponseBody
	public Page<BsbReport> searchBsbReport(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		BaseSpecificationBuilder<BsbReport> builder = new BaseSpecificationBuilder<>(BsbReport.class);
		Pattern pattern = Pattern.compile(SEARCH_PATTERN);
		Matcher matcher = pattern.matcher(search + ",");

		while (matcher.find()) {
			builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
		}
		if (!(matcher.matches())) {
			RmanFiscalPeriods rfp = rmanFiscalPeriodsRepo.getOpenFiscalPeriod();
			builder.with(CONSTANTS.FINANCIAL_MONTH, ":", rfp.getPeriodName());
		}

		Specification<BsbReport> spec = builder.build();
		return bsbReportRepo.findAll(spec, pageRequest);
	}

	@GetMapping( value = "/api/bsbReportExport", produces = "application/vnd.ms-excel")
	@ResponseBody
	public String exportBsbReport(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest, HttpServletResponse response) {
		logger.info("Export of BSB Report  Initiated");
		String reportDate = new java.text.SimpleDateFormat(CONSTANTS.YYYY_MM_DD_HH_MM_SS)
				.format(new java.util.Date(System.currentTimeMillis()));
		response.setHeader(CONSTANTS.CONTENT_DISPOSITION, "inline; filename=DZS BSB Report_" + reportDate + ".csv");
		BaseSpecificationBuilder<BsbReport> builder = new BaseSpecificationBuilder<>(BsbReport.class);
		Pattern pattern = Pattern.compile(SEARCH_PATTERN);
		Matcher matcher = pattern.matcher(search + ",");
		while (matcher.find()) {
			builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
		}
		if (!(matcher.matches())) {
			RmanFiscalPeriods rfp = rmanFiscalPeriodsRepo.getOpenFiscalPeriod();
			builder.with(CONSTANTS.FINANCIAL_MONTH, ":", rfp.getPeriodName());
		}

		Specification<BsbReport> spec = builder.build();
		Page<BsbReport> bsbRepList = bsbReportRepo.findAll(spec, prequest);
		CsvMapper mapper = new CsvMapper();
		mapper.setDateFormat(new SimpleDateFormat(CONSTANTS.MM_DD_YYYY));
		mapper.enable(JsonGenerator.Feature.IGNORE_UNKNOWN);
		CsvSchema schema = CsvSchema.builder().setColumnSeparator(',').addColumn(CONSTANTS.FINANCIAL_MONTH)
				.addColumn("shipToCustomerName").addColumn("shipToCountry").addColumn("billToCustomerName")
				.addColumn("billToState").addColumn("billToCountry").addColumn("customerPo").addColumn("fob")
				.addColumn("freightTerms").addColumn("freightCarrier").addColumn("orderNumber").addColumn("orderLine")
				.addColumn("orderType").addColumn("subOrderType").addColumn("isRevenue").addColumn("salesrepName")
				.addColumn("region").addColumn("productNumber").addColumn("productFamily").addColumn("productLine")
				.addColumn("shipDate").addColumn("elementType").addColumn("contingencyApplied")
				.addColumn("invoiceNumber").addColumn("invoiceLine").addColumn("shippedQuantity")
				.addColumn("extendedCost").addColumn("shippedAmount").addColumn("division").addColumn("totalMonths")
				.addColumn("serviceCode").addColumn("endCustomer").addColumn("snExists").addColumn("username")
				.addColumn("itemType").addColumn("warrantyTransferred").addColumn("serviceStartDate")
				.addColumn("serviceEndDate").addColumn("productService").addColumn("productFamily2").addColumn("note")
				.addColumn("je").addColumn("geography10k").addColumn("concatenate").addColumn("source")
				.addColumn("extendedWarranty").addColumn("reasonForExclusion").addColumn("serviceMaintLegacy")
				.addColumn("reasonForExclusion2").addColumn("serviceMaintNewParts").addColumn("reasonForExclusion3")
				.setUseHeader(false).build();
		ObjectWriter objectWriter = mapper.writer(schema);

		List<String> line1 = new ArrayList<>();
		line1.add("Financial Month");
		line1.add("Ship to Customer");
		line1.add("Ship to Country");
		line1.add("Bill to Customer");
		line1.add("Bill to State");
		line1.add("Bill to Country");
		line1.add("Cutomer PO#");
		line1.add("FOB");
		line1.add("Fright Terms");
		line1.add("Freight Carrier");
		line1.add("SO#");
		line1.add("SO Line#");
		line1.add("Order Type");
		line1.add("Sub Order Type");
		line1.add("Is Revenue");
		line1.add("Salesrep Name");
		line1.add("Region");
		line1.add("Product Name");
		line1.add("Product Family");
		line1.add("Product Line");
		line1.add("Shipped Date");
		line1.add("Element Type");
		line1.add("Contingency Applied");
		line1.add("Invoice Number");
		line1.add("Invoice Line#");
		line1.add("Shipped Quantity");
		line1.add("Extended Cost");
		line1.add("Shipped Amount");
		line1.add("Division");
		line1.add("Total Months");
		line1.add("Service Code");
		line1.add("End Customer");
		line1.add("SN Exits");
		line1.add("Username");
		line1.add("Item Type");
		line1.add("Warranty Transferred");
		line1.add("Service Start Date");
		line1.add("Service End Date");
		line1.add("Product Service");
		line1.add("Product Family2");
		line1.add("Note");
		line1.add("JE");
		line1.add("Geography-10K");
		line1.add("Concatenate");
		line1.add("Source");
		line1.add("Extended Warranty");
		line1.add("Reason for Exclusion");
		line1.add("Service Maint Legacy");
		line1.add("Reason for Exclusion2");
		line1.add("Service Maint New Parts");
		line1.add("Reason for Exclusion3");
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		try {
			objectWriter.writeValue(baos, line1);
		} catch (IOException e) {
			logger.error("Getting error while exporting BSB Report due to  {}" , e.getMessage());
		}

		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(baos, 1024);
		OutputStreamWriter writerOutputStream;
		try {
			writerOutputStream = new OutputStreamWriter(bufferedOutputStream, StandardCharsets.UTF_8);
			objectWriter.writeValue(writerOutputStream, bsbRepList.getContent());
			writerOutputStream.close();
		} catch (IOException e) {
			logger.error(CONSTANTS.ERROR_BSB_REPORT_EXPORT , e.getMessage());
		}
		String csvData = baos.toString();
		try {
			baos.close();
		} catch (IOException e) {
			logger.error(CONSTANTS.ERROR_BSB_REPORT_EXPORT , e.getMessage());
		}
		return csvData;
	}

	@GetMapping(value = "/api/revmantra/setcurrentPeriod")
	@ResponseBody
	public void currentPeriodSet(@RequestParam(value = "asOfPeriod") String asOfPeriod) {

		if (asOfPeriod != null) {
			rmanConcurrentProgramsDAO.executePeriod(asOfPeriod);
		} else {
			RmanFiscalPeriods rfp = rmanFiscalPeriodsRepo.getOpenFiscalPeriod();
			rmanConcurrentProgramsDAO.executePeriod(rfp.getPeriodName());
		}

	}

	@GetMapping( value = "/api/rmanDzsGlAccountingVSearch")
	@ResponseBody
	public Page<RmanDzsGlAccountingV> searchRmanDzsGlAccountingV(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest) {
		BaseSpecificationBuilder<RmanDzsGlAccountingV> builder = new BaseSpecificationBuilder<>(RmanDzsGlAccountingV.class);
		Pattern pattern = Pattern.compile(SEARCH_PATTERN);
		Matcher matcher = pattern.matcher(search + ",");

		while (matcher.find()) {
			builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
		}

		if (!(matcher.matches())) {
			RmanFiscalPeriods rfp = rmanFiscalPeriodsRepo.getOpenFiscalPeriod();
			builder.with(CONSTANTS.PERIOD_NAME, ":", rfp.getPeriodName());
		}

		Specification<RmanDzsGlAccountingV> spec = builder.build();

		return rmanDzsGlAccountingVRepo.findAll(spec, pageRequest);
	}

	@GetMapping( value = "/api/rmanDzsGlAccountingVExport", produces = "application/vnd.ms-excel")
	@ResponseBody
	public String exportRmanDzsGlAccountingV(@RequestParam(value = "search") String search,
			@PageableDefault(page = 0, size = 10) Pageable pageRequest, HttpServletResponse response) {
		logger.info("Export of DZS Account Analasis Report  Initiated");
		String reportDate = new java.text.SimpleDateFormat(CONSTANTS.YYYY_MM_DD_HH_MM_SS)
				.format(new java.util.Date(System.currentTimeMillis()));
		response.setHeader(CONSTANTS.CONTENT_DISPOSITION,
				"inline; filename=DZS Account Analysis Report_" + reportDate + ".csv");
		BaseSpecificationBuilder<RmanDzsGlAccountingV> builder = new BaseSpecificationBuilder<>(RmanDzsGlAccountingV.class);
		Pattern pattern = Pattern.compile(SEARCH_PATTERN);
		Matcher matcher = pattern.matcher(search + ",");
		while (matcher.find()) {
			builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
		}
		if (!(matcher.matches())) {
			RmanFiscalPeriods rfp = rmanFiscalPeriodsRepo.getOpenFiscalPeriod();
			builder.with(CONSTANTS.PERIOD_NAME, ":", rfp.getPeriodName());
		}

		Specification<RmanDzsGlAccountingV> spec = builder.build();
		Page<RmanDzsGlAccountingV> glList = rmanDzsGlAccountingVRepo.findAll(spec, prequest);
		CsvMapper mapper = new CsvMapper();
		mapper.setDateFormat(new SimpleDateFormat(CONSTANTS.MM_DD_YYYY));
		mapper.enable(JsonGenerator.Feature.IGNORE_UNKNOWN);
		CsvSchema schema = CsvSchema.builder().setColumnSeparator(',').addColumn("note").addColumn("contName")
				.addColumn("elementType").addColumn("cust").addColumn("customer").addColumn("po").addColumn("so")
				.addColumn("sourceLineId").addColumn("soLine").addColumn("productName").addColumn("productLine")
				.addColumn("division").addColumn("invoice").addColumn("deliveredDate")
				.addColumn("dealArrangementNumber").addColumn("dealLineNumber").addColumn("dealArrangementName")
				.addColumn("accountClass").addColumn("lineStatus").addColumn("glDate").addColumn(CONSTANTS.PERIOD_NAME)
				.addColumn("drCr").addColumn("account").addColumn("accountDescription").addColumn("tcur")
				.addColumn("fcur").addColumn("amountTc").addColumn("amountFc").addColumn("postedFlag")
				.addColumn("entryType").setUseHeader(false).build();
		ObjectWriter objectWriter = mapper.writer(schema);

		List<String> line1 = new ArrayList<>();
		line1.add("Note");
		line1.add("Contingency Name");
		line1.add("Element Type");
		line1.add("Cust#");
		line1.add("Customer");
		line1.add("PO#");
		line1.add("SO#");
		line1.add("Source Line Id");
		line1.add("SO Line#");
		line1.add("Product Name");
		line1.add("Product Line");
		line1.add("Division");
		line1.add("Invoice#");
		line1.add("Delivered Date");
		line1.add("Revenue Contract Number");
		line1.add("Deal Line #");
		line1.add("Revenue Contract Name");
		line1.add("Account Class");
		line1.add("Line Status");
		line1.add("GL Date");
		line1.add("Period");
		line1.add("Debit/Credit");
		line1.add("Account");
		line1.add("Account Description");
		line1.add("T-CURR");
		line1.add("F-CURR");
		line1.add("Amount in TC");
		line1.add("Amount in FC");
		line1.add("Posted Flag");
		line1.add("Entry Type");
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		try {
			objectWriter.writeValue(baos, line1);
		} catch (IOException e) {
			logger.error(CONSTANTS.ERROR_ACCOUNT_ANALYSIS_REPORT_EXPORT , e.getMessage());
		}

		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(baos, 1024);
		OutputStreamWriter writerOutputStream;
		try {
			writerOutputStream = new OutputStreamWriter(bufferedOutputStream, StandardCharsets.UTF_8);
			objectWriter.writeValue(writerOutputStream, glList.getContent());
			writerOutputStream.close();
		} catch (IOException e) {
			logger.error(CONSTANTS.ERROR_ACCOUNT_ANALYSIS_REPORT_EXPORT , e.getMessage());
		}

		String csvData = baos.toString();
		try {
			baos.close();
		} catch (IOException e) {
			logger.error(CONSTANTS.ERROR_ACCOUNT_ANALYSIS_REPORT_EXPORT , e.getMessage());
		}
		return csvData;
	}
	
	
	@GetMapping(value = "/api/reports/forecastingReport")
	@ResponseBody
	public String ayaraForecastingReport(@RequestParam(value = "arrgLevel", required = false) String arrgLevel
			,@RequestParam(value = "arrgId", required = false) BigDecimal arrgId
			,@RequestParam(value = "fromPeriod", required = false) String fromPeriod
			,@RequestParam(value = "toPeriod", required = false) String toPeriod) {
		logger.info("Ayara Forecasting Detail Report Initiated");
		
		return rmanConcurrentProgramsDAO.ayaraForecastReport(arrgLevel,arrgId!=null ? arrgId : new BigDecimal(-1), fromPeriod, toPeriod);
	}

	@GetMapping(value = "/api/reports/exportForecastingReport", produces = "application/vnd.ms-excel")
	@ResponseBody
	public String exportAyaraForecastingReport(@RequestParam(value = "arrgLevel", required = false) String arrgLevel
			,@RequestParam(value = "arrgId", required = false) BigDecimal arrgId
			,@RequestParam(value = "fromPeriod", required = false) String fromPeriod
			,@RequestParam(value = "toPeriod", required = false) String toPeriod
			,@RequestParam(value="exportCols", required=false) List<String> exportCols
			,HttpServletResponse response
			) {
		logger.info("Export of Ayara Forecasting Detail Report Initiated");
		String reportDate = new java.text.SimpleDateFormat(CONSTANTS.YYYY_MM_DD_HH_MM_SS)
				.format(new java.util.Date(System.currentTimeMillis()));
		response.setHeader(CONSTANTS.CONTENT_DISPOSITION, "inline; filename=Ayara_FCST_Report_" + reportDate + ".csv");
		String json = rmanConcurrentProgramsDAO.ayaraForecastReport(arrgLevel,arrgId!=null ? arrgId : new BigDecimal(-1), fromPeriod, toPeriod);

		try {

			JsonNode arrNode = new ObjectMapper().readTree(json).get(CONSTANTS.CONTENT);
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
					String replacedStr = str.replaceAll(CONSTANTS.SPECIAL_CHARS, "").trim(); 
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
			return getCSVData(CONSTANTS.ERROR_FORECAST_DETAIL_REPORT_EXPORT, baos);
		} catch (UnsupportedEncodingException | JsonGenerationException | JsonMappingException  e) {
			logger.error(CONSTANTS.ERROR_FORECAST_DETAIL_REPORT_EXPORT , e.getMessage());
		} catch (IOException e) {
			logger.error(CONSTANTS.ERROR_FORECAST_DETAIL_REPORT_EXPORT , e.getMessage());
		}
		return null;
	}
	
	@GetMapping(value = "/api/reports/activeQuotesArmReport")
	@ResponseBody
	public String ayaraActiveQuotesARMReport(@RequestParam(value = "arrgLevel", required = false) String arrgLevel
			,@RequestParam(value = "quoteStatus", required = false) String quoteStatus
			,@RequestParam(value = "fromDate", required = false) String fromDate
			,@RequestParam(value = "toDate", required = false) String toDate) {
		logger.info("Ayara Active Quotes ARM Report Initiated");
		
		return rmanConcurrentProgramsDAO.ayaraActiveQuotesARMReport(arrgLevel,quoteStatus, fromDate, toDate);
	}

	@GetMapping(value = "/api/reports/exportActiveQuotesArmReport", produces = "application/vnd.ms-excel")
	@ResponseBody
	public String exportAyaraActiveQuotesARMReport(@RequestParam(value = "arrgLevel", required = false) String arrgLevel
			,@RequestParam(value = "quoteStatus", required = false) String quoteStatus
			,@RequestParam(value = "fromDate", required = false) String fromDate
			,@RequestParam(value = "toDate", required = false) String toDate
			,@RequestParam(value="exportCols", required=false) List<String> exportCols
			,HttpServletResponse response
			) {
		logger.info("Export of Ayara Active Quotes ARM Report Initiated");
		String reportDate = new java.text.SimpleDateFormat(CONSTANTS.YYYY_MM_DD_HH_MM_SS)
				.format(new java.util.Date(System.currentTimeMillis()));
		response.setHeader(CONSTANTS.CONTENT_DISPOSITION, "inline; filename=Ayara_Active_Quotes_ARM_Report_" + reportDate + ".csv");
		
		String json = rmanConcurrentProgramsDAO.ayaraActiveQuotesARMReport(arrgLevel,quoteStatus, fromDate, toDate);

		try {

			JsonNode arrNode = new ObjectMapper().readTree(json).get(CONSTANTS.CONTENT);
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
					String replacedStr = str.replaceAll(CONSTANTS.SPECIAL_CHARS, "").trim(); 
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
			return getCSVData(CONSTANTS.ERROR_ACTIVE_QUOTES_ARM_REPORT_EXPORT, baos);
		} catch (UnsupportedEncodingException | JsonGenerationException | JsonMappingException e) {
			logger.error(CONSTANTS.ERROR_ACTIVE_QUOTES_ARM_REPORT_EXPORT , e.getMessage());
		} catch (IOException e) {
			logger.error(CONSTANTS.ERROR_ACTIVE_QUOTES_ARM_REPORT_EXPORT , e.getMessage());
		}
		return null;
	}

	@GetMapping(value = "/api/reports/actualsArmReport")
	@ResponseBody
	public String ayaraActualsARMReport(@RequestParam(value = "arrgLevel", required = false) String arrgLevel
			,@RequestParam(value = "fromDate", required = false) String fromDate
			,@RequestParam(value = "toDate", required = false) String toDate) {
		logger.info("Ayara Atuals ARM Report Initiated");
		return rmanConcurrentProgramsDAO.ayaraActualsARMReport(arrgLevel,fromDate, toDate);
	}

	@GetMapping(value = "/api/reports/exportActualsArmReport", produces = "application/vnd.ms-excel")
	@ResponseBody
	public String exportAyaraActualsArmReport(@RequestParam(value = "arrgLevel", required = false) String arrgLevel
			,@RequestParam(value = "fromDate", required = false) String fromDate
			,@RequestParam(value = "toDate", required = false) String toDate
			,@RequestParam(value="exportCols", required=false) List<String> exportCols
			,HttpServletResponse response
			) {
		logger.info("Export of Ayara Actuals ARM Report Initiated");
		String reportDate = new java.text.SimpleDateFormat(CONSTANTS.YYYY_MM_DD_HH_MM_SS)
				.format(new java.util.Date(System.currentTimeMillis()));
		response.setHeader(CONSTANTS.CONTENT_DISPOSITION, "inline; filename=Ayara_Actuals_ARM_Report_" + reportDate + ".csv");
		String json = rmanConcurrentProgramsDAO.ayaraActualsARMReport(arrgLevel, fromDate, toDate);

		try {

			JsonNode arrNode = new ObjectMapper().readTree(json).get(CONSTANTS.CONTENT);
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
					String replacedStr = str.replaceAll(CONSTANTS.SPECIAL_CHARS, "").trim(); 
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
			
			return getCSVData(CONSTANTS.ERROR_ACTUALS_ARM_REPORT_EXPORT, baos);
		} catch (UnsupportedEncodingException | JsonGenerationException | JsonMappingException e) {
			logger.error(CONSTANTS.ERROR_ACTUALS_ARM_REPORT_EXPORT , e.getMessage());
		} catch (IOException e) {
			logger.error(CONSTANTS.ERROR_ACTUALS_ARM_REPORT_EXPORT , e.getMessage());
		}
		return null;
	}
	
	@GetMapping(value = "/api/reports/ayaraActiveAndActuals")
	@ResponseBody
	public String ayaraActiveAndActualsReport(@RequestParam(value = "arrgLevel", required = false) String arrgLevel
			,@RequestParam(value = "docType", required = false) String docType
			,@RequestParam(value = "quoteStatus", required = false) String quoteStatus
			,@RequestParam(value = "fromDate", required = false) String fromDate
			,@RequestParam(value = "toDate", required = false) String toDate) {
		logger.info("Ayara Active Vs Actuals Report Initiated");
		return rmanConcurrentProgramsDAO.ayaraActualVsActiveReport(arrgLevel,docType, quoteStatus,fromDate, toDate);
	}
	
	@GetMapping(value = "/api/reports/exportActualsVsActiveArmReport", produces = "application/vnd.ms-excel")
	@ResponseBody
	public String exportActualsVsActiveArmReport(@RequestParam(value = "arrgLevel", required = false) String arrgLevel
			,@RequestParam(value = "docType", required = false) String docType
			,@RequestParam(value = "quoteStatus", required = false) String quoteStatus
			,@RequestParam(value = "fromDate", required = false) String fromDate
			,@RequestParam(value = "toDate", required = false) String toDate
			,@RequestParam(value="exportCols", required=false) List<String> exportCols
			,HttpServletResponse response
			) {
		logger.info("Export of Ayara Actuals ARM Report Initiated");
		String reportDate = new java.text.SimpleDateFormat(CONSTANTS.YYYY_MM_DD_HH_MM_SS)
				.format(new java.util.Date(System.currentTimeMillis()));
		response.setHeader(CONSTANTS.CONTENT_DISPOSITION, "inline; filename=Ayara_Actuals_Active_ARM_Report_" + reportDate + ".csv");
		String json = rmanConcurrentProgramsDAO.ayaraActualVsActiveReport(arrgLevel,docType, quoteStatus, fromDate, toDate);

		try {

			JsonNode arrNode = new ObjectMapper().readTree(json).get(CONSTANTS.CONTENT);
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
					String replacedStr = str.replaceAll(CONSTANTS.SPECIAL_CHARS, "").trim(); 
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
			
			return getCSVData(CONSTANTS.ERROR_ACTUALS_VS_ACTIVE_ARM_REPORT_EXPORT, baos);
		} catch (UnsupportedEncodingException | JsonGenerationException | JsonMappingException e) {
			logger.error(CONSTANTS.ERROR_ACTUALS_VS_ACTIVE_ARM_REPORT_EXPORT , e.getMessage());
		} catch (IOException e) {
			logger.error(CONSTANTS.ERROR_ACTUALS_VS_ACTIVE_ARM_REPORT_EXPORT , e.getMessage());
		}
		return null;
	}
	
	@GetMapping(value = "/api/reports/generateActiveQuotesARMChart")
	@ResponseBody
	public String generateActiveQuotesARMChart(@RequestParam(value = "quoteStatus", required = false) String quoteStatus
			,@RequestParam(value = "arrgLevel", required = false) String arrgLevel
			,@RequestParam(value = "fromDate", required = false) String fromDate
			,@RequestParam(value = "toDate", required = false) String toDate) {
		logger.info("Active Quotes Chart Initiated");
		return rmanConcurrentProgramsDAO.ayaraActiveQuotesARMChart(quoteStatus,arrgLevel,fromDate, toDate);
	}
	

	@GetMapping(value = "/api/reports/generateActualsARMChart")
	@ResponseBody
	public String generateActualsARMChart(@RequestParam(value = "arrgLevel", required = false) String arrgLevel
			,@RequestParam(value = "fromDate", required = false) String fromDate
			,@RequestParam(value = "toDate", required = false) String toDate) {
		logger.info("Actuals ARM Chart Initiated");
		return rmanConcurrentProgramsDAO.ayaraActualsARMChart(arrgLevel,fromDate, toDate);
	}
	

	@GetMapping(value = "/api/reports/generateActualVsActiveChart")
	@ResponseBody
	public String generateActualVsActiveChart(@RequestParam(value = "arrgLevel", required = false) String arrgLevel
			,@RequestParam(value = "docType", required = false) String docType
			,@RequestParam(value = "quoteStatus", required = false) String quoteStatus
			,@RequestParam(value = "fromDate", required = false) String fromDate
			,@RequestParam(value = "toDate", required = false) String toDate) {
		logger.info("Active Vs Actuals Chart Initiated");
		return rmanConcurrentProgramsDAO.ayaraActualVsActiveChart(arrgLevel,docType,quoteStatus,fromDate, toDate);
	}
	
	public String getCSVData(String reportErrorMsg, ByteArrayOutputStream baos) {
		String csvData = baos.toString();
		try {
			baos.close();
		} catch (IOException e) {
			logger.error(reportErrorMsg , e.getMessage());
		}
		return csvData;
	}

}
