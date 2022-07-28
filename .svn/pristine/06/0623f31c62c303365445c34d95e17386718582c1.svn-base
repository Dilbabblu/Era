package com.forsys.revmantra.custom;

import java.math.BigDecimal;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.forsys.revmantra.model.AnalyticalReportData;
import com.forsys.revmantra.model.AyaraSalesForceQuoteResponse;
import com.forsys.revmantra.model.ProspectiveDeals;
import com.forsys.revmantra.model.RmanDefRollforwardReportV;
import com.forsys.revmantra.model.RmanErrorsInfo;
import com.forsys.revmantra.model.RmanReconDealsArggRep;
import com.forsys.revmantra.model.RmanReconRevtrigRecogRep;
import com.forsys.revmantra.model.RmanReconShippedSoTrgRep;
import com.forsys.revmantra.model.RmanReconSosrcToBkingsRep;
import com.forsys.revmantra.model.RmanSalesforceQuoteLine;
import com.forsys.revmantra.model.RmanTrxDetailReport;
import com.forsys.revmantra.pojo.ResponseData;

public interface RmanConcurrentProgramsDAO {
	
	public void revmantraProcessContracts();

	public boolean revmantraDealSubmitFMVProcess();

	public boolean revmantraDealVCUpdate(BigDecimal arrangementId);

	public boolean revmantraDealAllocationProcess(BigDecimal arrangementId);

	public List<ProspectiveDeals> revmantraProspectiveList(BigDecimal arrgId);

	public boolean revmantraMergeDeals(BigDecimal arrgId, BigDecimal[] dealLines, BigDecimal trgArrangementId);

	public boolean revmantraSplitDeals(BigDecimal arrgId, BigDecimal[] dealLines, String arrgNumber, String arrgName);
	
	public oracle.sql.ARRAY revmantraUndeliveredDeals(BigDecimal arrgId);

	public boolean revmantraProcessProspectiveDeals(BigDecimal arrgId, String arrgNumber, String arrgName,
			List<ProspectiveDeals> pdealLines);

	public boolean revmantraRetrospectiveDeals(BigDecimal arrgId);

	public List<ProspectiveDeals> testProspectiveDealsData(BigDecimal arrgId, BigDecimal[] dealLines);

	public boolean updatePOBIdForContracts();

	public boolean reAllocation(BigDecimal dealArrangementId);

	public boolean callEventBasedRevRec(BigDecimal orderLineId);

	public boolean importOrderEvents();

	public String validateArrangementExists(String arrgNumber, String arrgName);

	public List<RmanErrorsInfo> soLink(BigDecimal ordeNumber, BigDecimal srcArrgId, BigDecimal trgDealId);

	public String waterFallRepDetails(BigDecimal fromArrgId, BigDecimal toArrgId, String fromPeriod, String toPeriod,
			String po, String so, BigDecimal legalEntity);

	public void waterFallReportParams(String fromPeriod, String toPeriod, Integer lagalEntityId);

	public Page<RmanReconDealsArggRep> reconParamsReports(Timestamp pfromDate, Timestamp ptoDate,
			BigDecimal plegalEntity, Pageable pageRequest);

	public Page<RmanReconSosrcToBkingsRep> reconSoSrcToBkingsRepo(Timestamp pfromDate, Timestamp ptoDate,
			BigDecimal plegalEntity, Pageable pageRequest);

	public Page<RmanReconShippedSoTrgRep> reconShippedSoTrigBkingsRepo(Timestamp pfromDate, Timestamp ptoDate,
			BigDecimal plegalEntity, Pageable pageRequest);

	public Page<RmanReconRevtrigRecogRep> reconRevTrigRecognizeRepo(Timestamp pfromDate, Timestamp ptoDate,
			BigDecimal plegalEntity, Pageable pageRequest);

	public String relinkPO(String srcPO, BigDecimal srcArrgNum, String trgPO, BigDecimal trgArrgNum);

	public String unlinkPO(String srcPO, BigDecimal srcArrgNum);

	public Page<RmanDefRollforwardReportV> rmanDefRollforwardReportVParamSet(String pAccountPeriodType,
			String pAsOfPeriod, String dealArrangementNumber, String so, String po, Pageable pageRequest);

	public List<RmanDefRollforwardReportV> rmanDefRollforwardReportVParamSetResults(String pAccountPeriodType,
			String pAsOfPeriod, String dealArrangementNumber, String so, String po);

	public Page<RmanTrxDetailReport> transactionDetailsRepo(Timestamp pfromDate, Timestamp ptoDate,
			BigDecimal plegalEntity, Pageable pageRequest);

	public Page<RmanTrxDetailReport> transactionDetailsRepoData(BigDecimal pfromArrg, BigDecimal ptoArrg,
			String arrgType, String custName, String po, String region, String periodName, Pageable pageRequest);

	public BigDecimal checkOpenOrderLineExists(BigDecimal ordNumber);

	public void executePeriod(String asOfPeriod);

	public String updateGLStatus(String period);

	public void deleteOrdersInetrface(String fileType, BigDecimal[] sourceLines);
	
	public void deleteAllExceptions(BigDecimal[] trxIds);
	
	public String dealForecastDetails(BigDecimal pArrgId,String orsFlag);
	//orsFlag -- OutSide RevFlo System Call
	
	public List<RmanSalesforceQuoteLine> processSFQuotes(String quoteNumber) ;
	
	public AyaraSalesForceQuoteResponse processSFQuotesWithExceptions(String quoteNumber) ;
	
	public boolean revmantraLTandSTReversal();

	public String pivotReport1(String startDate, String endDate);
	
	public List<AnalyticalReportData> pivotReport(String startDate, String endDate);
	
	public ResponseData processRmanRoleFunctions(String responsibilityId);
	
	public String getDashboardArrangementFigures(String fyear, String dDimension, String quarter, String period);
	
	public String dealForecastAcualDetails(BigDecimal pArrgId);
	
	public String revmantraGenerateSSP(BigDecimal bookId, String sspType, String sspCalc, BigDecimal fromRange, BigDecimal toRange, String amount,
			String date, Timestamp srcFrom, Timestamp srcTo, Timestamp targetFrom, Timestamp targetTo, String ruleName, BigDecimal userId);
	
	public boolean releaseContingency(String headerId, String fromDate, String toDate, String customerNumber, String productGroup, String productFamily, String productLine, String orderNumber, String customerPo, String releaseDate);

	public ResponseData processSplit(BigDecimal srcRc, BigDecimal[] sourceContractHeaderIds, String flag);
	
	public ResponseData processMerge(BigDecimal srcRc, BigDecimal[] sourceContractHeaderIds, BigDecimal trgRc, String flag);
	
	public String ayaraForecastActualDetails(String periodType);
	/*
	 * AYAR-1790 By Chandra on JAN 05th 2022
	 */
	public String actualRevenueScheduleReport(BigDecimal arrgId);
	
	/*
	 * AYAR-1891 By Chandra on MAY 02nd 2022
	 */
	public String ayaraForecastReport(String arrangementLevel,BigDecimal arrangementId,String fromPeriod,String toPeriod);
	
	public String ayaraActiveQuotesARMReport(String arrangementLevel,String quoteStatus,String fromDate,String toDate);
	
	public String ayaraActualsARMReport(String arrangementLevel,String fromDate,String toDate);
	
	public String ayaraActualVsActiveReport(String arrgLevel, String docType, String quoteStatus, String fromDate, String toDate);
	
	public String ayaraActiveQuotesARMChart(String quoteStatus, String arrgLevel, String fromDate, String toDate);
	
	public String ayaraActualsARMChart(String arrgLevel, String fromDate, String toDate);
	
	public String ayaraActualVsActiveChart(String arrgLevel, String docType, String quoteStatus, String fromDate, String toDate);
}
