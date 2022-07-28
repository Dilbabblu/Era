package com.forsys.revmantra.custom;

import java.math.BigDecimal;
import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Struct;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.internal.SessionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.forsys.revmantra.exceptions.AyaraCustomException;
import com.forsys.revmantra.listener.BaseListener;
import com.forsys.revmantra.model.AnalyticalReportData;
import com.forsys.revmantra.model.AyaraSalesForceQuoteResponse;
import com.forsys.revmantra.model.ProspectiveDeals;
import com.forsys.revmantra.model.RmanDealArrangements;
import com.forsys.revmantra.model.RmanDefRollforwardReportV;
import com.forsys.revmantra.model.RmanErrorsInfo;
import com.forsys.revmantra.model.RmanReconDealsArggRep;
import com.forsys.revmantra.model.RmanReconRevtrigRecogRep;
import com.forsys.revmantra.model.RmanReconShippedSoTrgRep;
import com.forsys.revmantra.model.RmanReconSosrcToBkingsRep;
import com.forsys.revmantra.model.RmanSalesforceQuoteLine;
import com.forsys.revmantra.model.RmanTrxDetailReport;
import com.forsys.revmantra.model.SfQuoteLineExceptions;
import com.forsys.revmantra.pojo.ResponseData;
import com.forsys.revmantra.repositories.RmanDealArrangementsRepository;
import com.forsys.revmantra.repositories.RmanDealHeadersRepository;
import com.forsys.revmantra.repositories.RmanDefRollforwardReportVRepository;
import com.forsys.revmantra.repositories.RmanIntfDealDetailsRepository;
import com.forsys.revmantra.repositories.RmanReconDealsArggRepRepository;
import com.forsys.revmantra.repositories.RmanReconRevtrigRecogRepRepository;
import com.forsys.revmantra.repositories.RmanReconShippedSoTrgRepRepository;
import com.forsys.revmantra.repositories.RmanReconSosrcToBkingsRepRepository;
import com.forsys.revmantra.repositories.RmanSalesforceQuoteLineRepository;
import com.forsys.revmantra.repositories.RmanTrxDetailReportRepository;
import com.forsys.revmantra.utils.CONSTANTS;
import com.forsys.revmantra.utils.RevmantraUtils;

import oracle.jdbc.internal.OracleTypes;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;

@SuppressWarnings("deprecation")
@Repository
@Transactional
public class RmanConcurrentProgramsDaOImpl implements RmanConcurrentProgramsDAO {
	
	private static final Logger logger = LogManager.getLogger(RmanConcurrentProgramsDaOImpl.class);

	@PersistenceContext
	private EntityManager manager;

	@Autowired
	private RmanReconDealsArggRepRepository rmanReconDealsArggRepRepo;

	@Autowired
	private RmanReconSosrcToBkingsRepRepository rmanReconSosrcToBkingsRepRepo;

	@Autowired
	private RmanReconShippedSoTrgRepRepository rmanReconShippedSoTrgRepRepo;

	@Autowired
	private RmanReconRevtrigRecogRepRepository rmanReconRevtrigRecogRepRepo;

	@Autowired
	public RmanSalesforceQuoteLineRepository rmanSalesforceQuoteLineRepository;

	@Autowired
	public RmanDealArrangementsRepository rmanDealArrangementsRepository;
	
	@Autowired
	public RmanDealHeadersRepository rmanDealHeadersRepository;


	@Autowired
	public RmanDefRollforwardReportVRepository rmanDefRollforwardReportVRepository;

	@Autowired
	private RmanTrxDetailReportRepository rmanTrxDetailReportRepo;
	
	@Autowired
	private RmanIntfDealDetailsRepository rmanIntfDealDetailsRepository;

	
/**	@Async("taskAsyncExecutor") */
	
	@Override
	public void revmantraProcessContracts() {
		
		try {
			StoredProcedureQuery storedProcedure = manager
					.createStoredProcedureQuery("RMAN_DEAL_INTF_PKG.PROCESS_UPLOADED_DEALS2");
			storedProcedure.execute();
		} catch (Exception e) {
			logger.error("Process contracts Job failed due to {}" , e.getMessage());		
		}
	}	

	@Override
	public boolean revmantraDealSubmitFMVProcess() {
		try {
			StoredProcedureQuery storedProcedure = manager
					.createStoredProcedureQuery("RMAN_DEAL_PROCESS_PKG.FMV_PROCESS_SUBMIT");
			storedProcedure.execute();

		} catch (Exception e) {
			logger.error("Updating Fairvalues for Deal Items Job is failed due to {}" , e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean revmantraDealVCUpdate(BigDecimal arrangementId) {
		try {
			StoredProcedureQuery storedProcedure = null;
			if (arrangementId.equals(new BigDecimal(0))) {
				storedProcedure = manager
						.createStoredProcedureQuery(CONSTANTS.DEAL_VC_UPDATE_PROCESS);

			} else {
				storedProcedure = manager
						.createStoredProcedureQuery(CONSTANTS.DEAL_VC_UPDATE_PROCESS)
						.registerStoredProcedureParameter(CONSTANTS.P_DEAL_ARRG_ID, BigDecimal.class, ParameterMode.IN);
				storedProcedure.setParameter(CONSTANTS.P_DEAL_ARRG_ID, arrangementId);
			}

			storedProcedure.execute();

		} catch (Exception e) {
			logger.error("Variable Consideration for deals Job is failed due to {}" , e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean revmantraDealAllocationProcess(BigDecimal arrangementId) {
		StoredProcedureQuery storedProcedure = null;
		try {

			if (arrangementId.equals(new BigDecimal(0))) {
				storedProcedure = manager.createStoredProcedureQuery("RMAN_DEAL_RULE_PKG.RUN_ALLOCATION")
						.registerStoredProcedureParameter("p_return_status", String.class, ParameterMode.OUT)
						.registerStoredProcedureParameter("p_error_message", String.class, ParameterMode.OUT);

			} else {
				storedProcedure = manager.createStoredProcedureQuery("RMAN_DEAL_RULE_PKG.RUN_ALLOCATION")
						.registerStoredProcedureParameter("p_return_status", String.class, ParameterMode.OUT)
						.registerStoredProcedureParameter("p_error_message", String.class, ParameterMode.OUT)
						.registerStoredProcedureParameter(CONSTANTS.P_DEAL_ARRG_ID, BigDecimal.class, ParameterMode.IN);
				storedProcedure.setParameter(CONSTANTS.P_DEAL_ARRG_ID, arrangementId);
			}
			storedProcedure.execute();
			return true;
		} catch (Exception e) {
			logger.error("Allocation Process job is failed due to {}" , e.getMessage());
			return false;
		}

	}

	@Override
	public List<ProspectiveDeals> revmantraProspectiveList(BigDecimal arrgId) {

		try {
			List<Object[]> prospectiveList = manager
					.createNativeQuery(" SELECT * FROM ("
							+ "SELECT   rdd.deal_arrangement_id,"
							+ "rdd.quantity,"
							+ "rdd.unit_list_price,"
							+ "rdd.unit_selling_price,"
							+ "rdd.deal_number,"
							+ "rdd.deal_line_number,"
							+ "rdd.product_name,"
							+ "rdd.uom_code,"
							+ "rdd.deal_currency_code,"
							+ "rdd.conversion_rate,"
							+ "rdd.contract_start_date,"
							+ "rdd.contract_end_date,"
							+ "rdd.service_start_date,"
							+ "rdd.service_end_date,"
							+ "rdd.deal_line_id,"
							+ "rdd.quantity AS undelivered_Qty,"
							+ "rdd.quantity AS und_Qty"
							+ "FROM RMAN_DEAL_DETAILS rdd,"
							+ "RMAN_DEAL_ARRANGEMENTS rda"
							+ "WHERE rda.deal_arrangement_id = rdd.deal_arrangement_id"
							+ "AND rda.deal_arrangement_id = :p_arrgId"
							+ "AND NOT EXISTS (SELECT 'Y' FROM RMAN_ORDERS ro"
							+ "WHERE ro.deal_arrangement_id = rdd.deal_arrangement_id"
							+ "AND rdd.deal_number = ro.deal_number"
							+ "AND rdd.deal_line_number = ro.deal_line_number)"
							+ "UNION ALL"
							+ "SELECT rdd.deal_arrangement_id,"
							+ "rdd.quantity,"
							+ "rdd.unit_list_price,"
							+ "rdd.unit_selling_price,"
							+ "rdd.deal_number,"
							+ "rdd.deal_line_number,"
							+ "rdd.product_name,"
							+ "rdd.uom_code,"
							+ "rdd.deal_currency_code,"
							+ "rdd.conversion_rate,"
							+ "rdd.contract_start_date,"
							+ "rdd.contract_end_date,"
							+ "rdd.service_start_date,"
							+ "rdd.service_end_date,"
							+ "rdd.deal_line_id,"
							+ "(rdd.quantity-nvl(ro.fulfilled_quantity,0)) AS undelivered_Qty,"
							+ "(rdd.quantity-nvl(ro.fulfilled_quantity,0)) AS und_Qty"
							+ "FROM RMAN_ORDERS ro,"
							+ "RMAN_DEAL_DETAILS rdd,"
							+ "RMAN_DEAL_ARRANGEMENTS rda"
							+ "WHERE rda.deal_arrangement_id = rdd.deal_arrangement_id"
							+ "AND rdd.deal_arrangement_id = ro.deal_arrangement_id"
							+ "AND rdd.deal_number = ro.deal_number"
							+ "AND rdd.deal_line_number = ro.deal_line_number"
							+ "AND rda.deal_arrangement_id = :p_arrgId )"
							+ "WHERE undelivered_Qty!=0")
					.setParameter("p_arrgId", arrgId).getResultList();

			return prospectiveList.stream().map(externalToMyLocation)
					.collect(Collectors.<ProspectiveDeals> toList());
		} catch (Exception e) {
			logger.error("Getting Prospective deals failed due to {}" , e.getMessage());

			return new ArrayList<>();
		}
	}

	@Override
	public oracle.sql.ARRAY revmantraUndeliveredDeals(BigDecimal arrgId) {
		SessionImpl sessionImpl = ((SessionImpl) manager.getDelegate());
		Connection cc = sessionImpl.connection();
		CallableStatement callableStatement = null;
		try {
			callableStatement = cc.prepareCall("{call XX_DEAL_PROSPECTIVE_PROCESS.DEAL_ARRG_PROSPECTIVE_PROC(?,?)}");
			ArrayDescriptor.createDescriptor(
					"XX_DEAL_PROSPECTIVE_PROCESS.XX_PROSPECTIVE_DEALS", callableStatement.getConnection());
			callableStatement.setInt(1, Integer.valueOf(arrgId.toString()));
			callableStatement.registerOutParameter(2, OracleTypes.ARRAY,
					"XX_DEAL_PROSPECTIVE_PROCESS.XX_PROSPECTIVE_DEALS");
			callableStatement.execute();
			return (ARRAY) callableStatement.getArray(2);
		} catch (Exception e) {
			logger.error("Fetching of Undelivered deals failed due to {}" , e.getMessage());
			return null;
		} finally {
			try {
				if (callableStatement != null) {
					callableStatement.close();
				}
			} catch (SQLException e) {
				logger.error(e);
			}
		}

	}

	Function<Object[], ProspectiveDeals> externalToMyLocation = new Function<Object[], ProspectiveDeals>() {

		public ProspectiveDeals apply(Object[] o) {
			ProspectiveDeals pDeal = new ProspectiveDeals();
			pDeal.setDealArrangementId((BigDecimal) o[0]);
			pDeal.setQuantity((BigDecimal) o[1]);
			pDeal.setUnitListPrice((BigDecimal) o[2]);
			pDeal.setUnitSellingPrice((BigDecimal) o[3]);
			pDeal.setDealNumber((String) o[4]);
			pDeal.setDealLineNumber((BigDecimal) o[5]);
			pDeal.setProductName((String) o[6]);
			pDeal.setUomCode((String) o[7]);
			pDeal.setDealCurrencyCode((String) o[8]);
			pDeal.setConversionRate((BigDecimal) o[9]);
			pDeal.setContractStartDate((Timestamp) o[10]);
			pDeal.setContractEndDate((Timestamp) o[11]);
			pDeal.setServiceStartDate((Timestamp) o[12]);
			pDeal.setServiceEndDate((Timestamp) o[13]);
			pDeal.setDealLineId((BigDecimal) o[14]);
			pDeal.setUndeliveredQty((BigDecimal) o[15]);
			pDeal.setUndQty((BigDecimal) o[16]);
			return pDeal;
		}
	};

	@Override
	public boolean revmantraMergeDeals(BigDecimal arrgId, BigDecimal[] dealLines, BigDecimal trgArrangementId) {
		SessionImpl sessionImpl = ((SessionImpl) manager.getDelegate());
		Connection cc = sessionImpl.connection();
		CallableStatement callableStatement = null;
		try {
			callableStatement = cc.prepareCall("{call RMAN_DEAL_LINES_PKG.DEAL_ARRG_LINES_MERGE_PROC(?,?,?)}");

			StructDescriptor resultStruct = StructDescriptor.createDescriptor(CONSTANTS.DEAL_LINE_REC,
					callableStatement.getConnection());

			Object[] arrayOfRecords = new Object[dealLines.length];
			Object[] javaRecordArray = new Object[1];
			for (int i = 0; i < dealLines.length; i++) {
				javaRecordArray[0] = dealLines[i];
				STRUCT oracleRecord = new STRUCT(resultStruct, callableStatement.getConnection(), javaRecordArray);
				arrayOfRecords[i] = oracleRecord;

			}
			ArrayDescriptor descriptor = ArrayDescriptor.createDescriptor(CONSTANTS.DEAL_LINES,
					callableStatement.getConnection());
			ARRAY paramArray = new ARRAY(descriptor, callableStatement.getConnection(), arrayOfRecords);
			callableStatement.setBigDecimal(1, arrgId);
			callableStatement.setObject(2, paramArray);
			callableStatement.setBigDecimal(3, trgArrangementId);
			callableStatement.execute();
			return true;
		} catch (Exception e) {
			logger.error("Merge Deals process failed due to {}" , e.getMessage());
			return false;
		} finally {
			try {
				if (callableStatement != null) {
					callableStatement.close();
				}
			} catch (SQLException e) {
				logger.error(e);
			}
		}

	}

	@Override
	public boolean revmantraSplitDeals(BigDecimal arrgId, BigDecimal[] dealLines, String arrgNumber, String arrgName) {
		SessionImpl sessionImpl = ((SessionImpl) manager.getDelegate());
		Connection cc = sessionImpl.connection();
		CallableStatement callableStatement = null;
		try {
			callableStatement = cc.prepareCall("{call RMAN_DEAL_LINES_PKG.DEAL_ARRG_LINES_SPLIT_PROC(?,?,?,?)}");

			StructDescriptor resultStruct = StructDescriptor.createDescriptor(CONSTANTS.DEAL_LINE_REC,
					callableStatement.getConnection());

			Object[] arrayOfRecords = new Object[dealLines.length];
			Object[] javaRecordArray = new Object[1];
			for (int i = 0; i < dealLines.length; i++) {
				javaRecordArray[0] = dealLines[i];
				STRUCT oracleRecord = new STRUCT(resultStruct, callableStatement.getConnection(), javaRecordArray);
				arrayOfRecords[i] = oracleRecord;

			}
			ArrayDescriptor descriptor = ArrayDescriptor.createDescriptor(CONSTANTS.DEAL_LINES,
					callableStatement.getConnection());
			ARRAY paramArray = new ARRAY(descriptor, callableStatement.getConnection(), arrayOfRecords);
			callableStatement.setBigDecimal(1, arrgId);
			callableStatement.setObject(2, paramArray);
			callableStatement.setString(3, arrgNumber);
			callableStatement.setString(4, arrgName);
			callableStatement.execute();
			return true;
		} catch (Exception e) {
			logger.error("Split Deals process failed due to {}" , e.getMessage());
			return false;
		} finally {
			try {
				if (callableStatement != null) {
					callableStatement.close();
				}
			} catch (SQLException e) {
				logger.error(e);
			}
		}
	}
	
	

	@Override
	public boolean revmantraProcessProspectiveDeals(BigDecimal arrgId, String arrgNumber, String arrgName,
			List<ProspectiveDeals> pdealLines) {
		SessionImpl sessionImpl = ((SessionImpl) manager.getDelegate());
		Connection cc = sessionImpl.connection();
		CallableStatement callableStatement = null;
		try {
			callableStatement = cc.prepareCall("{call RMAN_DEAL_LINES_PKG.DEAL_ARRG_LINES_PROSP_PROC(?,?,?,?)}");

			StructDescriptor resultStruct = StructDescriptor.createDescriptor("PROSPECTIVE_DEALS_REC",
					callableStatement.getConnection());
			STRUCT[] rv = new STRUCT[pdealLines.size()];
			int i = 0;

			for (ProspectiveDeals pDeal : pdealLines) {
				rv[i++] = new STRUCT(resultStruct, callableStatement.getConnection(), pDeal.toSQLStructObject());

			}

			ArrayDescriptor descriptor = ArrayDescriptor.createDescriptor("PROSP_DEAL_LINES",
					callableStatement.getConnection());
			ARRAY paramArray = new ARRAY(descriptor, callableStatement.getConnection(), rv);
			
			callableStatement.setBigDecimal(1, arrgId);
			callableStatement.setString(2, arrgNumber);
			callableStatement.setString(3, arrgName);
			callableStatement.setObject(4, paramArray);
			callableStatement.execute();
			return true;
		} catch (Exception e) {
			logger.error("Prospective Deals process failed to create new arrangement due to {}" , e.getMessage());

			return false;
		} finally {
			try {
				if (callableStatement != null) {
					callableStatement.close();
				}
			} catch (SQLException e) {

				logger.error(CONSTANTS.DB_CON_FAILED_TO_CLOSE , e.getMessage());
			}

		}

	}

	@Override
	public boolean revmantraRetrospectiveDeals(BigDecimal arrgId) {
		StoredProcedureQuery storedProcedure = null;
		try {
			storedProcedure = manager.createStoredProcedureQuery("RMAN_DEAL_LINES_PKG.DEAL_ARRG_RETROSPECTIVE_PROC")
					.registerStoredProcedureParameter(CONSTANTS.P_DEAL_ARRG_ID, BigDecimal.class, ParameterMode.IN);

			storedProcedure.setParameter(CONSTANTS.P_DEAL_ARRG_ID, arrgId);
			storedProcedure.execute();
			return true;
		} catch (Exception e) {
			logger.error(CONSTANTS.DB_CON_FAILED_TO_CLOSE , e.getMessage());
			return false;
		}

	}
	
	@Override
	public String revmantraGenerateSSP(BigDecimal bookId, String sspType, String sspCalc, BigDecimal fromRange, BigDecimal toRange, String amount,
			String date, Timestamp srcFrom, Timestamp srcTo, Timestamp targetFrom, Timestamp targetTo, String ruleName, BigDecimal userId) {
		StoredProcedureQuery storedProcedure = null;
		try {
			 storedProcedure = manager.createStoredProcedureQuery("AYARA_PROCESS_SSP_PKG.SSP_ANALYZER")
					.registerStoredProcedureParameter("p_book_id", BigDecimal.class, ParameterMode.IN)
					.registerStoredProcedureParameter("p_ssp_type", String.class, ParameterMode.IN)
					.registerStoredProcedureParameter("p_ssp_calc", String.class, ParameterMode.IN)
					.registerStoredProcedureParameter("p_from_range", BigDecimal.class, ParameterMode.IN)
			 		.registerStoredProcedureParameter("p_to_range", BigDecimal.class, ParameterMode.IN)
			 		.registerStoredProcedureParameter("p_amount", String.class, ParameterMode.IN)
			 		.registerStoredProcedureParameter("p_date", String.class, ParameterMode.IN)
			 		.registerStoredProcedureParameter("p_src_from", Timestamp.class, ParameterMode.IN)
			 		.registerStoredProcedureParameter("p_src_to", Timestamp.class, ParameterMode.IN)
			 		.registerStoredProcedureParameter("p_target_from", Timestamp.class, ParameterMode.IN)
			 		.registerStoredProcedureParameter("p_target_to", Timestamp.class, ParameterMode.IN)
			 		.registerStoredProcedureParameter("p_rule_name", String.class, ParameterMode.IN)
			 		.registerStoredProcedureParameter(CONSTANTS.P_USER_ID, BigDecimal.class, ParameterMode.IN)
			 		.registerStoredProcedureParameter(CONSTANTS.P_STATUS, String.class, ParameterMode.OUT);
			 
			storedProcedure.setParameter("p_book_id", bookId );
			storedProcedure.setParameter("p_ssp_type", sspType );
			storedProcedure.setParameter("p_ssp_calc", sspCalc);
			storedProcedure.setParameter("p_from_range", fromRange);
			storedProcedure.setParameter("p_to_range", toRange);
			storedProcedure.setParameter("p_amount", amount);
			storedProcedure.setParameter("p_date", date );
			storedProcedure.setParameter("p_src_from", srcFrom);
			storedProcedure.setParameter("p_src_to", srcTo);
			storedProcedure.setParameter("p_target_from", targetFrom);
			storedProcedure.setParameter("p_target_to", targetTo );
			storedProcedure.setParameter("p_rule_name", ruleName);
			storedProcedure.setParameter(CONSTANTS.P_USER_ID, userId);
			storedProcedure.execute();
			return storedProcedure.getOutputParameterValue(CONSTANTS.P_STATUS).toString();
		} catch (Exception e) {
			logger.error(CONSTANTS.DB_CON_FAILED_TO_CLOSE , e.getMessage());
			return null;
		}

	}

	@Override
	public List<ProspectiveDeals> testProspectiveDealsData(BigDecimal arrgId, BigDecimal[] dealLines) {
		List<ProspectiveDeals> pList = new ArrayList<>();
		SessionImpl sessionImpl = ((SessionImpl) manager.getDelegate());
		Connection cc = sessionImpl.connection();
		CallableStatement callableStatement = null;
		final String outtypeName = "PROSPECTIVE_DEALS_REC";
		final String outtypeTableName = "PROSP_DEAL_LINES";
		try {

			callableStatement = cc.prepareCall("{call RMAN_DEAL_LINES_PKG.GET_PROSPECTIVE_DEALS(?,?,?)}");

			StructDescriptor resultStruct = StructDescriptor.createDescriptor(CONSTANTS.DEAL_LINE_REC,
					callableStatement.getConnection());

			Object[] arrayOfRecords = new Object[dealLines.length];
			Object[] javaRecordArray = new Object[1];
			for (int i = 0; i < dealLines.length; i++) {
				javaRecordArray[0] = dealLines[i];
				STRUCT oracleRecord = new STRUCT(resultStruct, callableStatement.getConnection(), javaRecordArray);
				arrayOfRecords[i] = oracleRecord;

				/** System.out.println("Deal Lines:" + i); */

			}
			ArrayDescriptor descriptor = ArrayDescriptor.createDescriptor(CONSTANTS.DEAL_LINES,
					callableStatement.getConnection());
			ARRAY paramArray = new ARRAY(descriptor, callableStatement.getConnection(), arrayOfRecords);
			callableStatement.setBigDecimal(1, arrgId);
			callableStatement.setObject(2, paramArray);
			callableStatement.registerOutParameter(3, Types.ARRAY, outtypeTableName);
			callableStatement.execute();
			Object[] data = (Object[]) ((Array) callableStatement.getObject(3)).getArray();
			StructDescriptor.createDescriptor(outtypeName.toUpperCase(),
					callableStatement.getConnection());
		
			for (Object tmp : data) {
				Struct row = (Struct) tmp;
				ProspectiveDeals pdeal = new ProspectiveDeals();
				pdeal.setDealArrangementId((BigDecimal) row.getAttributes()[0]);
				pdeal.setQuantity((BigDecimal) row.getAttributes()[1]);
				pdeal.setUnitListPrice((BigDecimal) row.getAttributes()[2]);
				pdeal.setUnitSellingPrice((BigDecimal) row.getAttributes()[3]);
				pdeal.setDealNumber((String) row.getAttributes()[4]);
				pdeal.setDealLineNumber((BigDecimal) row.getAttributes()[5]);
				pdeal.setProductName((String) row.getAttributes()[6]);
				pdeal.setUomCode((String) row.getAttributes()[7]);
				pdeal.setDealCurrencyCode((String) row.getAttributes()[8]);
				pdeal.setConversionRate((BigDecimal) row.getAttributes()[9]);
				pdeal.setContractStartDate((Timestamp) row.getAttributes()[10]);
				pdeal.setContractEndDate((Timestamp) row.getAttributes()[11]);
				pdeal.setServiceStartDate((Timestamp) row.getAttributes()[12]);
				pdeal.setServiceEndDate((Timestamp) row.getAttributes()[13]);
				pdeal.setDealLineId((BigDecimal) row.getAttributes()[14]);
				pdeal.setUndeliveredQty((BigDecimal) row.getAttributes()[15]);
				pdeal.setUndQty((BigDecimal) row.getAttributes()[16]);
				pdeal.setArrgType((String) row.getAttributes()[17]);
				pdeal.setBundleFlag((String) row.getAttributes()[18]);
				pList.add(pdeal);
			}

			logger.info("Size of ProsDeals: {}" , pList.size());
			logger.info("Getting Prospective Deals List Successfully fetched");
			return pList;

		} catch (Exception e) {
			logger.error(" Getting of Prospective Deals  failed due to {}" , e.getMessage());
			return Collections.emptyList();
		} finally {

			try {
				if (callableStatement != null) {
					callableStatement.close();
				}

			} catch (SQLException e) {
				logger.error(e);
			}

		}
	}

	@Override
	public boolean updatePOBIdForContracts() {
		try {
			StoredProcedureQuery storedProcedure = manager
					.createStoredProcedureQuery("RMAN_POB_RULE_PROCESS_PKG.DEAL_POB_RULE_PROCESS");
			storedProcedure.execute();
			return true;
		} catch (Exception e) {
			logger.error("POB Process for Contracts Job failed due to {}" , e.getMessage());
			return false;
		}

	}

	@Override
	public boolean reAllocation(BigDecimal dealArrangementId) {
		try {
			StoredProcedureQuery storedProcedure = manager
					.createStoredProcedureQuery("RMAN_DEAL_LINES_PKG.RUN_ALLOCATION")
					.registerStoredProcedureParameter(CONSTANTS.P_DEAL_ARRG_ID, BigDecimal.class, ParameterMode.IN);
			storedProcedure.setParameter(CONSTANTS.P_DEAL_ARRG_ID, dealArrangementId);
			storedProcedure.execute();

		} catch (Exception e) {
			logger.error("Re Allocation of Arrangement failed due to {}" , e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean callEventBasedRevRec(BigDecimal orderLineId) {
		try {
			StoredProcedureQuery storedProcedure = manager.createStoredProcedureQuery("RMAN_EVENT_REVREC")
					.registerStoredProcedureParameter("p_order_line_id", BigDecimal.class, ParameterMode.IN);
			storedProcedure.setParameter("p_order_line_id", orderLineId);
			storedProcedure.execute();

		} catch (Exception e) {
			logger.error("Revenue Recognition for event failed due to {}" , e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean importOrderEvents() {
		try {
			StoredProcedureQuery storedProcedure = manager
					.createStoredProcedureQuery("RMAN_PROCESS_PKG.POPULATE_EVENTS");
			storedProcedure.execute();

		} catch (Exception e) {
			logger.error("Populate Order Events Job failed due to {}" , e.getMessage());
			return false;
		}
		return true;
	}
	
	@Override
	public boolean releaseContingency(String headerId, String fromDate, String toDate, String customerNumber,
			String productGroup, String productFamily, String productLine, String orderNumber, String customerPo, String releaseDate) {
		Timestamp from = RevmantraUtils.getDateValue(fromDate);
		Timestamp to = RevmantraUtils.getDateValue(toDate);
		Timestamp relDate = RevmantraUtils.getDateValue(releaseDate);
		
		StoredProcedureQuery storedProcedure = null;
		try {
				storedProcedure = manager.createStoredProcedureQuery("AYARA_CONT_RELEASE_PROCESS_PKG.CONCURRENT_RELEASE_PROGRAM")
				.registerStoredProcedureParameter("p_cont_id", BigDecimal.class, ParameterMode.IN)
				.registerStoredProcedureParameter(CONSTANTS.P_FROM_DATE, Timestamp.class, ParameterMode.IN)
				.registerStoredProcedureParameter(CONSTANTS.P_TO_DATE, Timestamp.class, ParameterMode.IN)
				.registerStoredProcedureParameter("p_cust_number", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("p_product_family", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("p_product_group", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("p_product_line", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("p_order_num", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter(CONSTANTS.P_PO_NUM, String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("p_release_date", Timestamp.class, ParameterMode.IN)
				.registerStoredProcedureParameter(CONSTANTS.O_FLAG, String.class, ParameterMode.OUT);
		storedProcedure.setParameter("p_cont_id", new BigDecimal(headerId));
		storedProcedure.setParameter(CONSTANTS.P_FROM_DATE, from);
		storedProcedure.setParameter(CONSTANTS.P_TO_DATE, to);
		storedProcedure.setParameter("p_cust_number", customerNumber);
		storedProcedure.setParameter("p_product_family", productFamily);
		storedProcedure.setParameter("p_product_group", productGroup);
		storedProcedure.setParameter("p_product_line", productLine);
		storedProcedure.setParameter("p_order_num", orderNumber);
		storedProcedure.setParameter(CONSTANTS.P_PO_NUM, customerPo);
		storedProcedure.setParameter("p_release_date", relDate);
		storedProcedure.execute();
			return storedProcedure.getOutputParameterValue(CONSTANTS.O_FLAG).equals("Y");
		}catch(Exception e) {
			logger.error(e);
			return false;
		}
	}

	@Override
	public String validateArrangementExists(String arrgNumber, String arrgName) {
		try {
			StoredProcedureQuery storedProcedure = manager.createStoredProcedureQuery("VALIDATE_ARRANGEMENT_EXISTS")
					.registerStoredProcedureParameter("p_arrg_number", String.class, ParameterMode.IN)
					.registerStoredProcedureParameter("p_arrg_name", String.class, ParameterMode.IN)
					.registerStoredProcedureParameter(CONSTANTS.P_STATUS, String.class, ParameterMode.OUT);
			storedProcedure.setParameter("p_arrg_number", arrgNumber);
			storedProcedure.setParameter("p_arrg_name", arrgName);
			storedProcedure.execute();
			return storedProcedure.getOutputParameterValue(CONSTANTS.P_STATUS).toString();

		} catch (Exception e) {
			logger.error("Revenue Recognition for event failed due to {}" , e.getMessage());
			return null;
		}

	}

	@Override
	public List<RmanErrorsInfo> soLink(BigDecimal ordeNumber, BigDecimal srcArrgId, BigDecimal trgDealId) {
		List<RmanErrorsInfo> errorInfo = new ArrayList<>();
		try {
			StoredProcedureQuery storedProcedure = manager.createStoredProcedureQuery("RMAN_IFRS_SO_PKG.SO_LINK_PROC")
					.registerStoredProcedureParameter(CONSTANTS.P_ORDER_NUMBER, BigDecimal.class, ParameterMode.IN)
					.registerStoredProcedureParameter("p_src_arrg_id", BigDecimal.class, ParameterMode.IN)
					.registerStoredProcedureParameter("p_trg_deal_line", BigDecimal.class, ParameterMode.IN)
					.registerStoredProcedureParameter(CONSTANTS.O_FLAG, String.class, ParameterMode.OUT)
					.registerStoredProcedureParameter("o_message", String.class, ParameterMode.OUT);
			storedProcedure.setParameter(CONSTANTS.P_ORDER_NUMBER, ordeNumber);
			storedProcedure.setParameter("p_src_arrg_id", srcArrgId);
			storedProcedure.setParameter("p_trg_deal_line", trgDealId);
			storedProcedure.execute();
			RmanErrorsInfo rmanErrr = new RmanErrorsInfo();
			rmanErrr.setErrorFlag((String) storedProcedure.getOutputParameterValue(CONSTANTS.O_FLAG));
			rmanErrr.setErrorMessage((String) storedProcedure.getOutputParameterValue("o_message"));
			errorInfo.add(rmanErrr);
			return errorInfo;
		} catch (Exception e) {
			logger.error("SO Link failed due to {}" , e.getMessage());
			return new ArrayList<>();
		}

	}

	@Override
	public String waterFallRepDetails(BigDecimal fromArrgId, BigDecimal toArrgId, String fromPeriod, String toPeriod,
			String po, String so, BigDecimal legalEntity) {
		String lquery = "";
		Statement st = null;
		ResultSet rs = null;
		try {
			StoredProcedureQuery storedProcedure = manager
					.createStoredProcedureQuery("RMAN_PERIOD_PARAMS_TEST_PKG.SET_PERIOD_PARAMS")
					.registerStoredProcedureParameter("p_from_arrgId", BigDecimal.class, ParameterMode.IN)
					.registerStoredProcedureParameter("p_to_arrgId", BigDecimal.class, ParameterMode.IN)
					.registerStoredProcedureParameter(CONSTANTS.P_FROM_PERIOD, String.class, ParameterMode.IN)
					.registerStoredProcedureParameter(CONSTANTS.P_TO_PERIOD, String.class, ParameterMode.IN)
					.registerStoredProcedureParameter("p_po_number", String.class, ParameterMode.IN)
					.registerStoredProcedureParameter(CONSTANTS.P_ORDER_NUMBER, String.class, ParameterMode.IN)
					.registerStoredProcedureParameter(CONSTANTS.P_LEGAL_ENTITY, BigDecimal.class, ParameterMode.IN)
					.registerStoredProcedureParameter(CONSTANTS.O_D_QUERY, String.class, ParameterMode.OUT);

			storedProcedure.setParameter("p_from_arrgId", fromArrgId);
			storedProcedure.setParameter("p_to_arrgId", toArrgId);
			storedProcedure.setParameter(CONSTANTS.P_FROM_PERIOD, fromPeriod);
			storedProcedure.setParameter(CONSTANTS.P_TO_PERIOD, toPeriod);
			storedProcedure.setParameter("p_po_number", po);
			storedProcedure.setParameter(CONSTANTS.P_ORDER_NUMBER, so);
			storedProcedure.setParameter(CONSTANTS.P_LEGAL_ENTITY, legalEntity);
			storedProcedure.execute();

			lquery = storedProcedure.getOutputParameterValue(CONSTANTS.O_D_QUERY).toString();

			SessionImpl sessionImpl = ((SessionImpl) manager.getDelegate());
			Connection cc = sessionImpl.connection();

			st = cc.createStatement();
			rs = st.executeQuery(lquery);
			ResultSetMetaData rsMetaData = rs.getMetaData();

			int numberOfColumns = rsMetaData.getColumnCount();
			ObjectMapper mapper = new ObjectMapper();
			ArrayNode arrayNode = mapper.createArrayNode();

			int rowcount = 0;

			while (rs.next()) {
				ObjectNode obj = mapper.createObjectNode();

				for (int i = 1; i < numberOfColumns + 1; i++) {
					int columnType = rsMetaData.getColumnType(i);

					if (columnType == Types.CHAR || columnType == Types.VARCHAR || columnType == Types.LONGVARCHAR) {
						obj.put(rsMetaData.getColumnName(i),
								rs.getObject(i) != null ? rs.getObject(i).toString() : null);

					} else if (columnType == Types.INTEGER || columnType == Types.BIGINT || columnType == Types.SMALLINT
							|| columnType == Types.NUMERIC) {

						obj.put(rsMetaData.getColumnName(i),
								rs.getObject(i) != null ? new BigDecimal(rs.getObject(i).toString()) : null);

					} else if (columnType == Types.DECIMAL || columnType == Types.DOUBLE || columnType == Types.FLOAT
							|| columnType == Types.REAL) {

						obj.put(rsMetaData.getColumnName(i),
								rs.getObject(i) != null ? Double.valueOf(rs.getObject(i).toString()) : null);

					} else if (columnType == Types.TIME || columnType == Types.TIMESTAMP || columnType == Types.DATE) {

						obj.put(rsMetaData.getColumnName(i),
								rs.getObject(i) != null ? rs.getTimestamp(i).getTime() : null);

					}

				}
				arrayNode.add(obj);
				rowcount++;
			}

			if (rowcount == 0) {

				ObjectNode obj = mapper.createObjectNode();

				for (int i = 1; i < numberOfColumns + 1; i++) {
					int columnType = rsMetaData.getColumnType(i);

					if (columnType == Types.CHAR || columnType == Types.VARCHAR || columnType == Types.LONGVARCHAR) {
						obj.put(rsMetaData.getColumnName(i), rowcount > 0 ? rowcount : null);

					} else if (columnType == Types.INTEGER || columnType == Types.BIGINT || columnType == Types.SMALLINT
							|| columnType == Types.NUMERIC) {
						obj.put(rsMetaData.getColumnName(i), rowcount > 0 ? rowcount : null);

					} else if (columnType == Types.DECIMAL || columnType == Types.DOUBLE || columnType == Types.FLOAT
							|| columnType == Types.REAL) {

						obj.put(rsMetaData.getColumnName(i), rowcount > 0 ? rowcount : null);

					} else if (columnType == Types.TIME || columnType == Types.TIMESTAMP || columnType == Types.DATE) {

						obj.put(rsMetaData.getColumnName(i), rowcount > 0 ? rowcount : null);

					}

				}
				arrayNode.add(obj);

			}

			ObjectNode obj1 = mapper.createObjectNode();
			obj1.put(CONSTANTS.CONTENT, arrayNode);
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj1);

		} catch (Exception e) {
			logger.error(e);
			return null;
		} finally {
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					logger.error(e);
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					logger.error(e);
				}
			}
		}

	}

	@Override
	public void waterFallReportParams(String fromPeriod, String toPeriod, Integer lagalEntityId) {
		StoredProcedureQuery storedProcedure = manager
				.createStoredProcedureQuery("RMAN_PERIOD_PARAMS_PKG.SET_PERIOD_PARAMS")
				.registerStoredProcedureParameter(CONSTANTS.P_FROM_PERIOD, String.class, ParameterMode.IN)
				.registerStoredProcedureParameter(CONSTANTS.P_TO_PERIOD, String.class, ParameterMode.IN)
				.registerStoredProcedureParameter(CONSTANTS.P_LEGAL_ENTITY, Integer.class, ParameterMode.IN);

		storedProcedure.setParameter(CONSTANTS.P_FROM_PERIOD, fromPeriod);
		storedProcedure.setParameter(CONSTANTS.P_TO_PERIOD, toPeriod);
		if (lagalEntityId != null) {
			storedProcedure.setParameter(CONSTANTS.P_LEGAL_ENTITY, lagalEntityId);
		}
		storedProcedure.execute();

	}

	@Override
	public Page<RmanReconDealsArggRep> reconParamsReports(Timestamp pfromDate, Timestamp ptoDate,
			BigDecimal plegalEntity, Pageable pageRequest) {

		SessionImpl sessionImpl = ((SessionImpl) manager.getDelegate());
		Connection cc = sessionImpl.connection();
		CallableStatement callableStatement = null;

		try {
			callableStatement = cc.prepareCall(CONSTANTS.SET_PARAMETERS_PROC);
			if (pfromDate != null) {
				callableStatement.setTimestamp(1, pfromDate);
			} else {
				callableStatement.setTimestamp(1, null);
			}

			if (ptoDate != null) {
				callableStatement.setTimestamp(2, ptoDate);
			} else {
				callableStatement.setTimestamp(2, null);
			}

			if (plegalEntity != null) {
				callableStatement.setBigDecimal(3, plegalEntity);
			} else {
				callableStatement.setBigDecimal(3, null);
			}

			callableStatement.setString(4, null);
			callableStatement.setString(5, null);
			callableStatement.executeQuery();
			return rmanReconDealsArggRepRepo.findAll(pageRequest);

		} catch (Exception e) {
			logger.error(CONSTANTS.PARAM_PROCESS_FAILED , e.getMessage());

			return null;
		} finally {
			if (callableStatement != null) {
				try {
					callableStatement.close();
				} catch (SQLException e) {
					logger.error(e);
				}
			}

		}

	}

	@Override
	public Page<RmanReconSosrcToBkingsRep> reconSoSrcToBkingsRepo(Timestamp pfromDate, Timestamp ptoDate,
			BigDecimal plegalEntity, Pageable pageRequest) {
		SessionImpl sessionImpl = ((SessionImpl) manager.getDelegate());
		Connection cc = sessionImpl.connection();
		CallableStatement callableStatement = null;

		try {
			callableStatement = cc.prepareCall(CONSTANTS.SET_PARAMETERS_PROC);
			if (pfromDate != null) {
				callableStatement.setTimestamp(1, pfromDate);
			} else {
				callableStatement.setTimestamp(1, null);
			}

			if (ptoDate != null) {
				callableStatement.setTimestamp(2, ptoDate);
			} else {
				callableStatement.setTimestamp(2, null);
			}

			if (plegalEntity != null) {
				callableStatement.setBigDecimal(3, plegalEntity);
			} else {
				callableStatement.setBigDecimal(3, null);
			}

			callableStatement.setString(4, null);
			callableStatement.setString(5, null);
			callableStatement.executeQuery();
			return rmanReconSosrcToBkingsRepRepo.findAll(pageRequest);

		} catch (Exception e) {
			logger.error(CONSTANTS.PARAM_PROCESS_FAILED , e.getMessage());
			return null;
		} finally {
			if (callableStatement != null) {
				try {
					callableStatement.close();
				} catch (SQLException e) {
					logger.error(e);
				}
			}

		}

	}

	@Override
	public Page<RmanReconShippedSoTrgRep> reconShippedSoTrigBkingsRepo(Timestamp pfromDate, Timestamp ptoDate,
			BigDecimal plegalEntity, Pageable pageRequest) {
		SessionImpl sessionImpl = ((SessionImpl) manager.getDelegate());
		Connection cc = sessionImpl.connection();
		CallableStatement callableStatement = null;

		try {
			callableStatement = cc.prepareCall(CONSTANTS.SET_PARAMETERS_PROC);
			if (pfromDate != null) {
				callableStatement.setTimestamp(1, pfromDate);
			} else {
				callableStatement.setTimestamp(1, null);
			}

			if (ptoDate != null) {
				callableStatement.setTimestamp(2, ptoDate);
			} else {
				callableStatement.setTimestamp(2, null);
			}

			if (plegalEntity != null) {
				callableStatement.setBigDecimal(3, plegalEntity);
			} else {
				callableStatement.setBigDecimal(3, null);
			}

			callableStatement.setString(4, null);
			callableStatement.setString(5, null);
			callableStatement.executeQuery();
			return rmanReconShippedSoTrgRepRepo.findAll(pageRequest);

		} catch (Exception e) {
			logger.error(CONSTANTS.PARAM_PROCESS_FAILED , e.getMessage());

			return null;
		} finally {
			if (callableStatement != null) {
				try {
					callableStatement.close();
				} catch (SQLException e) {
					logger.error(e);
				}
			}

		}

	}

	@Override
	public Page<RmanReconRevtrigRecogRep> reconRevTrigRecognizeRepo(Timestamp pfromDate, Timestamp ptoDate,
			BigDecimal plegalEntity, Pageable pageRequest) {
		SessionImpl sessionImpl = ((SessionImpl) manager.getDelegate());
		Connection cc = sessionImpl.connection();
		CallableStatement callableStatement = null;

		try {
			callableStatement = cc.prepareCall(CONSTANTS.SET_PARAMETERS_PROC);
			if (pfromDate != null) {
				callableStatement.setTimestamp(1, pfromDate);
			} else {
				callableStatement.setTimestamp(1, null);
			}

			if (ptoDate != null) {
				callableStatement.setTimestamp(2, ptoDate);
			} else {
				callableStatement.setTimestamp(2, null);
			}

			if (plegalEntity != null) {
				callableStatement.setBigDecimal(3, plegalEntity);
			} else {
				callableStatement.setBigDecimal(3, null);
			}

			callableStatement.setString(4, null);
			callableStatement.setString(5, null);
			callableStatement.executeQuery();
			return rmanReconRevtrigRecogRepRepo.findAll(pageRequest);

		} catch (Exception e) {
			logger.error(CONSTANTS.PARAM_PROCESS_FAILED , e.getMessage());

			return null;
		} finally {
			if (callableStatement != null) {
				try {
					callableStatement.close();
				} catch (SQLException e) {
					logger.error(e);
				}
			}

		}
	}

	@Override
	public String relinkPO(String srcPO, BigDecimal srcArrgNum, String trgPO, BigDecimal trgArrgNum) {

		StoredProcedureQuery storedProcedure = null;
		try {
			storedProcedure = manager.createStoredProcedureQuery("rman_relink_delink_po_pkg.relink_proc")
					.registerStoredProcedureParameter(CONSTANTS.P_SRC_PO_NUM, String.class, ParameterMode.IN)
					.registerStoredProcedureParameter(CONSTANTS.P_SRC_ARRG_ID, BigDecimal.class, ParameterMode.IN)
					.registerStoredProcedureParameter("p_trg_po_num", String.class, ParameterMode.IN)
					.registerStoredProcedureParameter("p_target_arrangement_id", BigDecimal.class, ParameterMode.IN)
					.registerStoredProcedureParameter(CONSTANTS.P_USER, BigDecimal.class, ParameterMode.IN)
					.registerStoredProcedureParameter(CONSTANTS.O_MSG, String.class, ParameterMode.OUT);

			storedProcedure.setParameter(CONSTANTS.P_SRC_PO_NUM, srcPO);
			storedProcedure.setParameter(CONSTANTS.P_SRC_ARRG_ID, srcArrgNum);
			storedProcedure.setParameter("p_trg_po_num", trgPO);
			storedProcedure.setParameter("p_target_arrangement_id", trgArrgNum);
			storedProcedure.setParameter(CONSTANTS.P_USER,
					BaseListener.getCurrentUserId() != null ? BaseListener.getCurrentUserId() : new BigDecimal(-1));
			storedProcedure.execute();
			return (String) storedProcedure.getOutputParameterValue(CONSTANTS.O_MSG);
		} catch (Exception e) {
			logger.error("Failed the process of relink PO of {} to target PO: {} due to {} " , srcPO , trgPO , e.getMessage());
			return null;
		}

	}

	@Override
	public String unlinkPO(String srcPO, BigDecimal srcArrgNum) {
		StoredProcedureQuery storedProcedure = null;
		try {
			storedProcedure = manager.createStoredProcedureQuery("rman_relink_delink_po_pkg.delink_proc")
					.registerStoredProcedureParameter(CONSTANTS.P_SRC_PO_NUM, String.class, ParameterMode.IN)
					.registerStoredProcedureParameter(CONSTANTS.P_SRC_ARRG_ID, BigDecimal.class, ParameterMode.IN)
					.registerStoredProcedureParameter(CONSTANTS.P_USER, BigDecimal.class, ParameterMode.IN)
					.registerStoredProcedureParameter(CONSTANTS.O_MSG, String.class, ParameterMode.OUT);

			storedProcedure.setParameter(CONSTANTS.P_SRC_PO_NUM, srcPO);
			storedProcedure.setParameter(CONSTANTS.P_SRC_ARRG_ID, srcArrgNum);
			storedProcedure.setParameter(CONSTANTS.P_USER,
					BaseListener.getCurrentUserId() != null ? BaseListener.getCurrentUserId() : new BigDecimal(-1));
			storedProcedure.execute();
			return (String) storedProcedure.getOutputParameterValue(CONSTANTS.O_MSG);
		} catch (Exception e) {
			logger.error("Failed the process of unlink or delink PO of {} due to {}" , srcPO , e.getMessage());
			return null;
		}

	}

	@Override
	public Page<RmanDefRollforwardReportV> rmanDefRollforwardReportVParamSet(String pAccountPeriodType,
			String pAsOfPeriod, String dealArrangementNumber, String so, String po, Pageable pageRequest) {
		SessionImpl sessionImpl = ((SessionImpl) manager.getDelegate());
		Connection cc = sessionImpl.connection();
		CallableStatement callableStatement = null;

		try {
			callableStatement = cc.prepareCall("{call RMAN_ROLLFRWRD_REP_PARAMS_PKG.SET_PARAMS_PROC(?,?,?,?,?)}");
			if (pAccountPeriodType != null) {
				callableStatement.setString(1, pAccountPeriodType);
			} else {
				callableStatement.setString(1, null);
			}
			if (pAsOfPeriod != null) {
				callableStatement.setString(2, pAsOfPeriod);
			} else {
				callableStatement.setString(2, null);
			}
			if (dealArrangementNumber != null) {
				callableStatement.setString(3, dealArrangementNumber);
			} else {
				callableStatement.setString(3, null);
			}
			if (!so.isEmpty()) {
				callableStatement.setBigDecimal(4, new BigDecimal(so));
			} else {
				callableStatement.setBigDecimal(4, null);
			}
			if (po != null) {
				callableStatement.setString(5, po);
			} else {
				callableStatement.setString(5, null);
			}

			callableStatement.executeQuery();
			return rmanDefRollforwardReportVRepository.findAll(pageRequest);

		} catch (Exception e) {
			logger.error("Rman Deferred Revenue Roll Forward Report set Params process failed due to {}" , e.getMessage());

			return null;
		} finally {
			if (callableStatement != null) {
				try {
					callableStatement.close();
				} catch (SQLException e) {
					logger.error(e);
				}
			}

		}

	}

	@Override
	public Page<RmanTrxDetailReport> transactionDetailsRepo(Timestamp pfromDate, Timestamp ptoDate,
			BigDecimal plegalEntity, Pageable pageRequest) {
		SessionImpl sessionImpl = ((SessionImpl) manager.getDelegate());
		Connection cc = sessionImpl.connection();
		CallableStatement callableStatement = null;

		try {
			callableStatement = cc.prepareCall(CONSTANTS.SET_PARAMETERS_PROC);
			if (pfromDate != null) {
				callableStatement.setTimestamp(1, pfromDate);
			} else {
				callableStatement.setTimestamp(1, null);
			}

			if (ptoDate != null) {
				callableStatement.setTimestamp(2, ptoDate);
			} else {
				callableStatement.setTimestamp(2, null);
			}

			if (plegalEntity != null) {
				callableStatement.setBigDecimal(3, plegalEntity);
			} else {
				callableStatement.setBigDecimal(3, null);
			}

			callableStatement.setString(4, null);
			callableStatement.setString(5, null);
			callableStatement.executeQuery();
			return rmanTrxDetailReportRepo.findAll(pageRequest);

		} catch (Exception e) {
			logger.error(CONSTANTS.PARAM_PROCESS_FAILED , e.getMessage());
			return null;
		} finally {
			if (callableStatement != null) {
				try {
					callableStatement.close();
				} catch (SQLException e) {
					logger.error(e);
				}
			}

		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public Page<RmanTrxDetailReport> transactionDetailsRepoData(BigDecimal pfromArrg, BigDecimal ptoArrg,
			String arrgType, String custName, String po, String region, String periodName, Pageable pageRequest) {

		StoredProcedureQuery storedProcedure = null;
		try {
			storedProcedure = manager.createStoredProcedureQuery("RMAN_ROLLFRWRD_REP_PARAMS_PKG.SET_PARAMS_PROC")
					.registerStoredProcedureParameter(1, String.class, ParameterMode.IN)
					.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);

			storedProcedure.setParameter(1, "PTD");
			storedProcedure.setParameter(2, periodName);
			storedProcedure.execute();

		} catch (Exception e) {
			logger.error("Failed the process of executong the set curent period due to {}" , e.getMessage());
			return null;
		}

		Query query = manager.createQuery("select t from RmanTrxDetailReport t "
				+ " where t.dealArrangementId between nvl(:p_arrg_from,t.dealArrangementId) and nvl(:p_arrg_to,t.dealArrangementId) "
				+ " and (:p_arrg_type is null or t.arrangementType= :p_arrg_type)"
				+ " and (:p_customer_name is null or t.customerName=:p_customer_name)"
				+ " and (:p_po_num is null or po=:p_po_num)" + " and (:p_region is null or t.region=:p_region)");
		query.setParameter("p_arrg_from", pfromArrg);
		query.setParameter("p_arrg_to", ptoArrg);
		query.setParameter("p_arrg_type", arrgType);
		query.setParameter("p_customer_name", custName);
		query.setParameter(CONSTANTS.P_PO_NUM, po);
		query.setParameter("p_region", region);
		return (Page<RmanTrxDetailReport>) query.getResultList();
	}

	@Override
	public BigDecimal checkOpenOrderLineExists(BigDecimal ordNumber) {

		return null;
	}

	@Override
	public List<RmanDefRollforwardReportV> rmanDefRollforwardReportVParamSetResults(String pAccountPeriodType,
			String pAsOfPeriod, String dealArrangementNumber, String so, String po) {
		SessionImpl sessionImpl = ((SessionImpl) manager.getDelegate());
		Connection cc = sessionImpl.connection();
		CallableStatement callableStatement = null;

		try {
			callableStatement = cc.prepareCall("{call RMAN_ROLLFRWRD_REP_PARAMS_PKG.SET_PARAMS_PROC(?,?,?,?,?)}");
			if (pAccountPeriodType != null) {
				callableStatement.setString(1, pAccountPeriodType);
			} else {
				callableStatement.setString(1, null);
			}
			if (pAsOfPeriod != null) {
				callableStatement.setString(2, pAsOfPeriod);
			} else {
				callableStatement.setString(2, null);
			}
			if (dealArrangementNumber != null) {
				callableStatement.setString(3, dealArrangementNumber);
			} else {
				callableStatement.setString(3, null);
			}
			if (!so.isEmpty()) {
				callableStatement.setBigDecimal(4, new BigDecimal(so));
			} else {
				callableStatement.setBigDecimal(4, null);
			}
			if (po != null) {
				callableStatement.setString(5, po);
			} else {
				callableStatement.setString(5, null);
			}

			callableStatement.executeQuery();
			return rmanDefRollforwardReportVRepository.findAll();

		} catch (Exception e) {
			logger.error("Rman Deferred Revenue Roll Forward Report set Params process failed due to {}" , e.getMessage());

			return new ArrayList<>();
		} finally {
			if (callableStatement != null) {
				try {
					callableStatement.close();
				} catch (SQLException e) {
					logger.error(e);
				}
			}

		}
	}

	@Override
	public void executePeriod(String asOfPeriod) {
		StoredProcedureQuery storedProcedure = null;
		logger.info("Set for Parameter asOfPeriod : {}" , asOfPeriod);
		try {
			storedProcedure = manager.createStoredProcedureQuery("RMAN_ROLLFRWRD_REP_PARAMS_PKG.SET_PARAMS_PROC")
					.registerStoredProcedureParameter("p_period_det", String.class, ParameterMode.IN)
					.registerStoredProcedureParameter("p_as_of_period", String.class, ParameterMode.IN);

			storedProcedure.setParameter("p_period_det", "PTD");
			storedProcedure.setParameter("p_as_of_period", asOfPeriod);
			storedProcedure.execute();
			logger.info("Set for Parameter asOfPeriod : {} completed" , asOfPeriod);
		} catch (Exception e) {
			logger.error("Failed the process of executing the set curent period due to {}" , e.getMessage());

		}

	}

	@Override
	public String updateGLStatus(String period) {
		StoredProcedureQuery storedProcedure = null;
		logger.info("Closed Period : {}" , period);
		try {
			storedProcedure = manager.createStoredProcedureQuery("RMAN_UPD_GL_ACCTS_STATUS_PROC")
					.registerStoredProcedureParameter("p_period_name", String.class, ParameterMode.IN);

			storedProcedure.setParameter("p_period_name", period);
			storedProcedure.execute();
			logger.info("Closed period GL Status Update Procedure completed");
			return "Y";
		} catch (Exception e) {
			logger.error("Failed the process of executing the set curent period due to {}" , e.getMessage());
			return "N";
		}
	}

	@Override
	public void deleteOrdersInetrface(String fileType, BigDecimal[] sourceLines) {

		List<BigDecimal> slids = Arrays.asList(sourceLines);

		manager.createNativeQuery("delete from rman_orders_interface where interface_status='E' and file_type='"
				+ fileType + "' and source_line_id in ("
				+ slids.stream().map(x -> String.valueOf(x)).collect(Collectors.joining(", ")) + ")").executeUpdate();
		
	}
	
	@Override
	public void deleteAllExceptions(BigDecimal[] trxIds) {

		List<BigDecimal> slids = Arrays.asList(trxIds);

		manager.createNativeQuery("delete from AYARA_DOC_TRANSACTIONS_INT where TRX_ID in ("
				+ slids.stream().map(x -> String.valueOf(x)).collect(Collectors.joining(", ")) + ")").executeUpdate();
		
	}
	
	public String dealForecastDetails(BigDecimal pArrgId,String orsFlag) {
		String lquery = "";
		Statement st = null;
		ResultSet rs = null;
		try {
			StoredProcedureQuery storedProcedure = manager
					.createStoredProcedureQuery("RMAN_FC_PACKAGE.GET_FC_VIEW_QUERY")
					.registerStoredProcedureParameter(CONSTANTS.P_ARR_ID, BigDecimal.class, ParameterMode.IN)
					.registerStoredProcedureParameter(CONSTANTS.O_D_QUERY, String.class, ParameterMode.OUT)
					.registerStoredProcedureParameter("P_ORS", String.class, ParameterMode.IN);
			
			storedProcedure.setParameter(CONSTANTS.P_ARR_ID, pArrgId);
			storedProcedure.setParameter("P_ORS", orsFlag);
			
				
			storedProcedure.execute();
			
			lquery = storedProcedure.getOutputParameterValue(CONSTANTS.O_D_QUERY).toString();
			SessionImpl sessionImpl = ((SessionImpl) manager.getDelegate());
			Connection cc = sessionImpl.connection();

			st = cc.createStatement();
			rs = st.executeQuery(lquery);
			ResultSetMetaData rsMetaData = rs.getMetaData();

			int numberOfColumns = rsMetaData.getColumnCount();
			ObjectMapper mapper = new ObjectMapper();
			ArrayNode arrayNode = mapper.createArrayNode();
			
			int rowcount = 0;
			
			while (rs.next()) {
				ObjectNode obj = mapper.createObjectNode();

				for (int i = 1; i < numberOfColumns + 1; i++) {
					int columnType = rsMetaData.getColumnType(i);

					if (columnType == Types.CHAR || columnType == Types.VARCHAR || columnType == Types.LONGVARCHAR) {
						obj.put(rsMetaData.getColumnName(i),
								rs.getObject(i) != null ? rs.getObject(i).toString() : null);
						
					} else if (columnType == Types.INTEGER || columnType == Types.BIGINT || columnType == Types.SMALLINT
							|| columnType == Types.NUMERIC) {
						obj.put(rsMetaData.getColumnName(i),
								rs.getObject(i) != null ? new BigDecimal(rs.getObject(i).toString()) : null);

					} else if (columnType == Types.DECIMAL || columnType == Types.DOUBLE || columnType == Types.FLOAT
							|| columnType == Types.REAL) {
						
						obj.put(rsMetaData.getColumnName(i),
								rs.getObject(i) != null ? Double.valueOf(rs.getObject(i).toString()) : null);

					} else if (columnType == Types.TIME || columnType == Types.TIMESTAMP || columnType == Types.DATE) {
						
						obj.put(rsMetaData.getColumnName(i),
								rs.getObject(i) != null ? rs.getTimestamp(i).getTime() : null);

					}

				}
				arrayNode.add(obj);
				rowcount++;
			}
			
			if (rowcount==0) {
				
				ObjectNode obj = mapper.createObjectNode();

				for (int i = 1; i < numberOfColumns + 1; i++) {
					int columnType = rsMetaData.getColumnType(i);

					if (columnType == Types.CHAR || columnType == Types.VARCHAR || columnType == Types.LONGVARCHAR) {
						obj.put(rsMetaData.getColumnName(i),
								rowcount > 0 ? rowcount : null);
						
					} else if (columnType == Types.INTEGER || columnType == Types.BIGINT || columnType == Types.SMALLINT
							|| columnType == Types.NUMERIC) {
						obj.put(rsMetaData.getColumnName(i),
								rowcount > 0 ? rowcount : null);

					} else if (columnType == Types.DECIMAL || columnType == Types.DOUBLE || columnType == Types.FLOAT
							|| columnType == Types.REAL) {
						
						obj.put(rsMetaData.getColumnName(i),
								rowcount > 0 ? rowcount : null);

					} else if (columnType == Types.TIME || columnType == Types.TIMESTAMP || columnType == Types.DATE) {
												obj.put(rsMetaData.getColumnName(i),
								rowcount > 0 ? rowcount : null);

					}

				}
				arrayNode.add(obj);

			}
			
			ObjectNode obj1 = mapper.createObjectNode();
			obj1.put(CONSTANTS.CONTENT, arrayNode);
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj1);

		} catch (Exception e) {
			logger.error(e);
			return null;
		} finally {
			if(st!=null){
				try {
					st.close();
				} catch (SQLException e) {
					logger.error(e);
				}
				}
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					logger.error(e);
				}
			}
		}

	}
	
	
	public List<RmanSalesforceQuoteLine> processSFQuotesBkp(String quoteNumber) throws Exception {
		RmanDealArrangements rda=rmanDealArrangementsRepository.findByDealArrangementNumber(quoteNumber);
		
		if (rda==null){
		
			StoredProcedureQuery sfQuoteProcessProc = manager.createStoredProcedureQuery("RMAN_DEAL_INTF_PKG.PROCESS_UPLOADED_DEALS2");
			sfQuoteProcessProc.execute();
			
			rda = rmanDealArrangementsRepository.findByDealArrangementNumber(quoteNumber);
			
			if (rda!=null) {
				StoredProcedureQuery vcApplyProcedure = manager.createStoredProcedureQuery(CONSTANTS.DEAL_VC_UPDATE_PROCESS)
                        .registerStoredProcedureParameter(0, BigDecimal.class, ParameterMode.IN);
				vcApplyProcedure.setParameter(0, rda.getDealArrangementId());
				vcApplyProcedure.execute();
	
			}
		}
		
		if (rda!=null) {
			
			StoredProcedureQuery pobProcessProcedure = manager.createStoredProcedureQuery("RMAN_POB_RULE_PROCESS_PKG.DEAL_POB_RULE_PROCESS");
			pobProcessProcedure.execute();
			StoredProcedureQuery fmvProcessProcedure = manager.createStoredProcedureQuery("RMAN_DEAL_PROCESS_PKG.FMV_PROCESS_SUBMIT");
			fmvProcessProcedure.execute();
			
			StoredProcedureQuery allocationProcessProcedure = manager.createStoredProcedureQuery("RMAN_DEAL_LINES_PKG.RUN_ALLOCATION")
					                                         .registerStoredProcedureParameter(0, BigDecimal.class, ParameterMode.IN);
			allocationProcessProcedure.setParameter(0, rda.getDealArrangementId());
			allocationProcessProcedure.execute();
			
			return rmanSalesforceQuoteLineRepository.findByQuoteId(rda.getDealArrangementId());
		
		} else {
			throw new AyaraCustomException ("Deal Not Processed successfully in RevFlo System");
		}
		
			
	}
	
	@Override
	public List<RmanSalesforceQuoteLine> processSFQuotes(String quoteNumber){
		
		try{
			StoredProcedureQuery quoteProcessProc = manager.createStoredProcedureQuery("RMAN_SF_QUOTE_PROCESS_PKG.PROCESS_QUOTE")
                    .registerStoredProcedureParameter(CONSTANTS.P_QUOTE_NUMBER, String.class, ParameterMode.IN);
			quoteProcessProc.setParameter(CONSTANTS.P_QUOTE_NUMBER, quoteNumber);
			quoteProcessProc.execute();
			RmanDealArrangements rda = rmanDealArrangementsRepository.findByDealArrangementNumber(quoteNumber);
   			return rmanSalesforceQuoteLineRepository.findByQuoteId(rda.getDealArrangementId());
   		}catch(Exception e){
   			logger.error(e);
   			throw new AyaraCustomException ("Quote "+ quoteNumber +" not processed successfully in Ayara System");
		}
			
	}
	
	@Override
	public boolean revmantraLTandSTReversal() {
		try {
			StoredProcedureQuery storedProcedure = manager
					.createStoredProcedureQuery("LT_ST_ADJUSTMENTS");

			
			storedProcedure.execute();
			
		} catch (Exception e) {
			logger.error("Ayara Long Term and Short Term Reversal Job failed due to {}" , e.getMessage());
			return false;
		}
		return true;

	}
	

	@Override
	public String pivotReport1(String startDate, String endDate) {
	String lquery = "select rownum as \"id\" "
	+",rotdh.CUSTOMER_NUMBER as \"Cust #\"  "
	+",rotdh.CUSTOMER_NAME  as \"Customer\" "
	+",rotdh.PO as \"PO#\" "
	+",rotdh.ORDER_NUMBER as \"SO#\" "
	+",rotdh.DEAL_ARRANGEMENT_NUMBER as \"Arrangement Number\" "
	+",rotdh.DEAL_ARRANGEMENT_NAME as \"Arrangement Name\" "
	+",rotdh.ARRANGEMENT_TYPE as \"Arrangement Type\" "
	+",rotdh.SALES_THEATER      as \"Sales Theater\"   "  
	+",rotdh.REGION     as \"Sales Region\"             "
	+",rotdh.TERRITORY   as \"Sales Territory\" "
	+",rotdh.DEAL_NUMBER as \"Deal #\"           "  
	+",rotdh.DEAL_LINE_NUMBER as \"Deal line #\"  "      
	+",rotdh.SALESREP as \"Sales Rep\" "
	+",rotdh.PRODUCT_NAME as \"Product Name\"             "
	+",rotdh.ORDERED_QUANTITY as \"BK Qty\"                "    
	+",rotdh.BOOKED_CURRENCY as \"Transaction Currency\"   "
	+",rotdh.PRODUCT_PORTFOLIO as \"Product Portfolio\"     "  
	+",rotdh.PRODUCT_FAMILY  as \"Product Family\"         "
	+",rotdh.PRODUCT_LINE as \"Product Line\" "
	+",rotdh.ALLOCATION_AMOUNT as \"Allocated Amount (TC)\" "
	+",rotdh.ALLOCATION_AMOUNT_FC as \"Allocated Amount (FC)\" "
	+",rotdh.DELIVERED_AMOUNT as \"Delivered Amount (TC)\"      "  
	+",rotdh.BILLED_AMOUNT  as \"Billed Amt(TC)\"          "
	+",rotdh.BILLED_AMOUNT_FC as \"Billed Amt(FC)\"        "
	+",0 \"Delivered not billed (DNB)\" "
	+",rotdh.DELIVERED_ALLOC_AMOUNT as \"Delivered Allocated Price (TC)\" "
	+",rotdh.DELIVERED_ALLOC_AMOUNT_FC as \"Delivered Allocated Price (FC)\"  "
	+",rotdh.DEFERRED_AMOUNT as \"Revenue Deferred(TC)\"         "
	+",rotdh.DEFERRED_AMOUNT_FC as \"Revenue Deferred(FC)\"      "
	+",rotdh.CONT_RELEASE_DATE as \"Contingency Release Date\"   "
	+",to_number(REGEXP_SUBSTR (GET_ACC_NET_BAL_PER_LINE(rotdh.source_line_id,rotdh.deal_line_id,'TC',rotdh.period_name), '[^~]+', 1, 1)) as \"Contract Asset (TC)\" "
	+",to_number(REGEXP_SUBSTR (GET_ACC_NET_BAL_PER_LINE(rotdh.source_line_id,rotdh.deal_line_id,'TC',rotdh.period_name), '[^~]+', 1, 2)) as \"Contract Liability (TC)\" "
	+",to_number(REGEXP_SUBSTR (GET_ACC_NET_BAL_PER_LINE(rotdh.source_line_id,rotdh.deal_line_id,'TC',rotdh.period_name), '[^~]+', 1, 3)) as \"Deferred Revenue (TC)\" "
	+",to_number(REGEXP_SUBSTR (GET_ACC_NET_BAL_PER_LINE(rotdh.source_line_id,rotdh.deal_line_id,'TC',rotdh.period_name), '[^~]+', 1, 4)) as \"Clearing (TC)\" "
	+",to_number(REGEXP_SUBSTR (GET_ACC_NET_BAL_PER_LINE(rotdh.source_line_id,rotdh.deal_line_id,'FC',rotdh.period_name), '[^~]+', 1, 1)) as \"Contract Asset (FC)\" "
	+",to_number(REGEXP_SUBSTR (GET_ACC_NET_BAL_PER_LINE(rotdh.source_line_id,rotdh.deal_line_id,'FC',rotdh.period_name), '[^~]+', 1, 2)) as \"Contract Liability (FC)\" "
	+",to_number(REGEXP_SUBSTR (GET_ACC_NET_BAL_PER_LINE(rotdh.source_line_id,rotdh.deal_line_id,'FC',rotdh.period_name), '[^~]+', 1, 3)) as \"Deferred Revenue (FC)\" "
	+",to_number(REGEXP_SUBSTR (GET_ACC_NET_BAL_PER_LINE(rotdh.source_line_id,rotdh.deal_line_id,'FC',rotdh.period_name), '[^~]+', 1, 4)) as \"Clearing (FC)\" "
	+",to_number(REGEXP_SUBSTR (GET_ACC_REV_BAL_PER_LINE(rotdh.source_line_id,rotdh.deal_line_id,'TC',rotdh.period_name), '[^~]+', 1, 1)) as \"Revenue Begin Balance (TC)\" "
	+",to_number(REGEXP_SUBSTR (GET_ACC_REV_BAL_PER_LINE(rotdh.source_line_id,rotdh.deal_line_id,'TC',rotdh.period_name), '[^~]+', 1, 2)) as \"Revenue Current Balance (TC)\" "
	+",to_number(REGEXP_SUBSTR (GET_ACC_REV_BAL_PER_LINE(rotdh.source_line_id,rotdh.deal_line_id,'TC',rotdh.period_name), '[^~]+', 1, 3)) as \"Revenue End Balance (TC)\" "
	+",to_number(REGEXP_SUBSTR (GET_ACC_REV_BAL_PER_LINE(rotdh.source_line_id,rotdh.deal_line_id,'FC',rotdh.period_name), '[^~]+', 1, 1)) as \"Revenue Begin Balance (FC)\" "
	+",to_number(REGEXP_SUBSTR (GET_ACC_REV_BAL_PER_LINE(rotdh.source_line_id,rotdh.deal_line_id,'FC',rotdh.period_name), '[^~]+', 1, 2)) as \"Revenue Current Balance (FC)\" "
	+",to_number(REGEXP_SUBSTR (GET_ACC_REV_BAL_PER_LINE(rotdh.source_line_id,rotdh.deal_line_id,'FC',rotdh.period_name), '[^~]+', 1, 3)) as \"Revenue End Balance (FC)\" "
	+",rotdh.QUARTER_NAME as \"Quarter Name\" "
	+",rotdh.period_year as \"Year\" "
	+",rotdh.QUARTER_NAME as \"Quarter\" "
	+",rotdh.period_name as \"Month\" "
	+",rotdh.period_name as \"Period Name\" "
	+"from rman_orders_trx_detail_history rotdh,rman_fiscal_periods rfp "
	+"where rotdh.period_name = rfp.period_name "
	+"and rotdh.active_flag=1 "
	+"and  rotdh.eligible_flag = 'N' "
	+"and rfp.start_date between to_date('"+startDate+"','DD/MM/YYYY') and to_date('"+endDate+"','DD/MM/YYYY') ";
	Statement st = null;
	ResultSet rs = null;
	try {
	SessionImpl sessionImpl = ((SessionImpl) manager.getDelegate());
	Connection cc = sessionImpl.connection();

	st = cc.createStatement();
	rs = st.executeQuery(lquery);
	ResultSetMetaData rsMetaData = rs.getMetaData();

	int numberOfColumns = rsMetaData.getColumnCount();
	ObjectMapper mapper = new ObjectMapper();
	ArrayNode arrayNode = mapper.createArrayNode();

	while (rs.next()) {
	ObjectNode obj = mapper.createObjectNode();

	for (int i = 1; i < numberOfColumns + 1; i++) {
	int columnType = rsMetaData.getColumnType(i);

	if (columnType == Types.CHAR || columnType == Types.VARCHAR || columnType == Types.LONGVARCHAR) {
	obj.put(rsMetaData.getColumnName(i),
	rs.getObject(i) != null ? rs.getObject(i).toString() : null);

	} else if (columnType == Types.INTEGER || columnType == Types.BIGINT || columnType == Types.SMALLINT
	|| columnType == Types.NUMERIC) {

	obj.put(rsMetaData.getColumnName(i),
	rs.getObject(i) != null ? new BigDecimal(rs.getObject(i).toString()) : null);

	} else if (columnType == Types.DECIMAL || columnType == Types.DOUBLE || columnType == Types.FLOAT
	|| columnType == Types.REAL) {

	obj.put(rsMetaData.getColumnName(i),
	rs.getObject(i) != null ? Double.valueOf(rs.getObject(i).toString()) : null);

	} else if (columnType == Types.TIME || columnType == Types.TIMESTAMP || columnType == Types.DATE) {

	obj.put(rsMetaData.getColumnName(i),
	rs.getObject(i) != null ? rs.getTimestamp(i).getTime() : null);

	}

	}
	arrayNode.add(obj);
	
	}
	
	ObjectNode obj1 = mapper.createObjectNode();
	
	obj1.put("arrangements", arrayNode);
	return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj1);

	} catch (Exception e) {
	logger.error(e);
	return null;
	} finally {
	if (st != null) {
	try {
	st.close();
	} catch (SQLException e) {
	logger.error(e);
	}
	}
	if (rs != null) {
	try {
	rs.close();
	} catch (SQLException e) {
	logger.error(e);
	}
	}
	}

	}

	@Override
	public List<AnalyticalReportData> pivotReport(String startDate, String endDate) {
		
		try {
			
			List<Object[]> reportDataList = manager.
					createNativeQuery("select rownum as \"id\" "
				+ ",rotdh.CUSTOMER_NUMBER as \"Cust #\" "
				+ ",rotdh.CUSTOMER_NAME  as \"Customer\" "
				+ ",NULL as \"PO#\" "
				+ ",NULL as \"SO#\" "
				+ ",NULL as \"Arrangement Number\" "
				+ ",NULL as \"Arrangement Name\" "
				+ ",NULL as \"Arrangement Type\" "
				+ ",NULL      as \"Sales Theater\" "
				+ ",rotdh.REGION     as \"Sales Region\" "
				+ ",rotdh.TERRITORY   as \"Sales Territory\" "
				+ ",NULL as \"Deal #\" "
				+ ",NULL as \"Deal line #\" "
				+ ",rotdh.SALESREP as \"Sales Rep\" "
				+ ",rotdh.PRODUCT_NAME as \"Product Name\" "
				+ ",NULL as \"BK Qty\" "
				+ ",NULL as \"Transaction Currency\" "
				+ ",rotdh.PRODUCT_PORTFOLIO as \"Product Portfolio\" "
				+ ",rotdh.PRODUCT_FAMILY  as \"Product Family\" "
				+ ",rotdh.PRODUCT_LINE as \"Product Line\" "
				+ ",rotdh.ALLOCATION_AMOUNT as \"Allocated Amount (TC)\" "
				+ ",rotdh.ALLOCATION_AMOUNT_FC as \"Allocated Amount (FC)\" "
				+ ",rotdh.DELIVERED_AMOUNT as \"Delivered Amount (TC)\" "
				+ ",rotdh.BILLED_AMOUNT  as \"Billed Amt(TC)\" "
				+ ",rotdh.BILLED_AMOUNT_FC as \"Billed Amt(FC)\" "
				+ ",0 \"Delivered not billed (DNB)\" "
				+ ",rotdh.DELIVERED_ALLOC_AMOUNT as \"Delivered Allocated Price (TC)\" "
				+ ",rotdh.DELIVERED_ALLOC_AMOUNT_FC as \"Delivered Allocated Price (FC)\" "
				+ ",0 as \"Revenue Deferred(TC)\" "
				+ ",0 as \"Revenue Deferred(FC)\" "
				+ ",NULL as \"Contingency Release Date\" "
				+ ",rotdh.CONTRACT_ASSET_TC as \"Contract Asset (TC)\" "
				+ ",rotdh.CONTRACT_LIABILITY_TC as \"Contract Liability (TC)\" "
				+ ",rotdh.DEFERRED_REVENUE_TC as \"Deferred Revenue (TC)\" "
				+ ",rotdh.CLEARING_TC as \"Clearing (TC)\" "
				+ ",rotdh.CONTRACT_ASSET_FC as \"Contract Asset (FC)\" "
				+ ",rotdh.CONTRACT_LIABILITY_FC as \"Contract Liability (FC)\" "
				+ ",rotdh.DEFERRED_REVENUE_FC as \"Deferred Revenue (FC)\" "
				+ ",rotdh.CLEARING_FC as \"Clearing (FC)\" "
				+ ",rotdh.REVENUE_BEGIN_BALANCE_TC as \"Revenue Begin Balance (TC)\" "
				+ ",rotdh.REVENUE_CURRENT_BALANCE_TC as \"Revenue Current Balance (TC)\" "
				+ ",rotdh.REVENUE_END_BALANCE_TC as \"Revenue End Balance (TC)\" "
				+ ",rotdh.REVENUE_BEGIN_BALANCE_FC as \"Revenue Begin Balance (FC)\" "
				+ ",rotdh.REVENUE_CURRENT_BALANCE_FC as \"Revenue Current Balance (FC)\" "
				+ ",rotdh.REVENUE_END_BALANCE_FC as \"Revenue End Balance (FC)\" "
				+ ",rotdh.QTD_REVENUE_BEGIN_BALANCE_TC \"QTD Revenue Begin Balance (TC)\" "
				+ ",rotdh.QTD_CURRENT \"QTD Revenue Current Balance (TC)\" "
				+ ",rotdh.YTD_REVENUE_BEGIN_BALANCE_TC \"YTD Revenue Begin Balance (TC)\" "
				+ ",rotdh.YTD_CURRENT \"YTD Revenue Current Balance (TC)\" "
				+ ",rotdh.QUARTER as \"Quarter Name\" "
				+ ",rotdh.year as \"Year\" "
				+ ",rotdh.QUARTER as \"Quarter\" "
				+ ",rotdh.month as \"Month\" "
				+ ",rotdh.month as \"Period Name\" "
				+ "from ayara_temp_123_mv rotdh "
				+ "where  1 = 1 "
				+ "and rotdh.start_date between to_date(:startDate,'DD/MM/YYYY') and to_date(:endDate,'DD/MM/YYYY') ")
					.setParameter("startDate", startDate)
					.setParameter("endDate", endDate)
					.getResultList();
			
			return  reportDataList.stream().map(mapAnalyticalReportDataToObject)
					.collect(Collectors.<AnalyticalReportData> toList());
		} catch (Exception e) {
			logger.error("Getting Analytical Report data failed due to {}" , e.getMessage());
			return new ArrayList<>();
		
		}

	}
	
		Function<Object[], AnalyticalReportData> mapAnalyticalReportDataToObject = (Object[] o) -> {
		AnalyticalReportData data = new AnalyticalReportData();
		data.setId((BigDecimal) o[0]);
		data.setCust((String) o[1]);
		data.setCustomer((String) o[2]);
		data.setPo((String) o[3]);
		data.setSo((String) o[4]);
		data.setArrangementNumber((String) o[5]);
		data.setArrangementName((String) o[6]);
		data.setArrangementType((String) o[7]);
		data.setSalesTheater((String) o[8]);
		data.setSalesRegion((String) o[9]);
		data.setSalesTerritory((String) o[10]);
		data.setDeal((String) o[11]);
		data.setDealLine((String) o[12]);
		data.setSalesRep((String) o[13]);
		data.setProductName((String) o[14]);
		data.setBkQty((String) o[15]);
		data.setTransactionCurrency((String) o[16]);
		data.setProductPortfolio((String) o[17]);
		data.setProductFamily((String) o[18]);
		data.setProductLine((String) o[19]);
		data.setAllocatedAmtTC((BigDecimal) o[20]);
		data.setAllocatedAmtFC((BigDecimal) o[21]);
		data.setDevliveredAmtTC((BigDecimal) o[22]);
		data.setBilledAmtTC((BigDecimal) o[23]);
		data.setBilledAmtFC((BigDecimal) o[24]);
		data.setDeliveredNotBilledDNB((BigDecimal) o[25]);
		data.setDeliveredAllocatedPriceTC((BigDecimal) o[26]);
		data.setDeliveredAllocatedPriceFC((BigDecimal) o[27]);
		data.setRevenueDeferredTC((BigDecimal) o[28]);
		data.setRevenueDeferredFC((BigDecimal) o[29]);
		data.setContigencyReleaseDate((BigDecimal) o[30]);
		data.setContractAssetTC((BigDecimal) o[31]);
		data.setContractLiabilityTC((BigDecimal) o[32]);
		data.setDeferredRevenueTC((BigDecimal) o[33]);
		data.setClearingTC((BigDecimal) o[34]);
		data.setContractAssetFC((BigDecimal) o[35]);
		data.setContractLiabilityFC((BigDecimal) o[36]);
		data.setDeferredRevenueFC((BigDecimal) o[37]);
		data.setClearingFC((BigDecimal) o[38]);
		data.setRevenueBeginBalanceTC((BigDecimal) o[39]);
		data.setRevenueCurrentBalanceTC((BigDecimal) o[40]);
		data.setRevenueEndBalanceTC((BigDecimal) o[41]);
		data.setRevenueBeginBalanceFC((BigDecimal) o[42]);
		data.setRevenueCurrentBalanceFC((BigDecimal) o[43]);
		data.setRevenueEndBalanceFC((BigDecimal) o[44]);
		data.setRevenueBeginbalanceQTD((BigDecimal) o[45]);
		data.setRevenueCurrentBalanceQTD((BigDecimal) o[46]);
		data.setRevenueBeginbalanceYTD((BigDecimal) o[47]);
		data.setRevenueCurrentBalanceYTD((BigDecimal) o[48]);
		data.setQuarterName((String) o[49]);
		data.setYear((BigDecimal) o[50]);
		data.setQuarter((String) o[51]);
		data.setMonth((String) o[52]);
		data.setPeriodName((String) o[53]);
		return data;
	};

	@Override
	public AyaraSalesForceQuoteResponse processSFQuotesWithExceptions(String quoteNumber){
		AyaraSalesForceQuoteResponse sfQResponse =  new AyaraSalesForceQuoteResponse();
		try{
			StoredProcedureQuery quoteProcessProc = manager.createStoredProcedureQuery("RMAN_SF_QUOTE_PROCESS_PKG.PROCESS_QUOTE")
                    .registerStoredProcedureParameter(CONSTANTS.P_QUOTE_NUMBER, String.class, ParameterMode.IN);
			quoteProcessProc.setParameter(CONSTANTS.P_QUOTE_NUMBER, quoteNumber);
			quoteProcessProc.execute();
			// used rmanDealHeadersRepository instead of rmanDealArrangementsRepository to get Deal Arrangement Number
			if (rmanDealHeadersRepository.findByDealNumber(quoteNumber)!=null){
				sfQResponse.setSfQuoteLines(rmanSalesforceQuoteLineRepository.
						findByQuoteId(rmanDealHeadersRepository.findByDealNumber(quoteNumber).getDealArrangementId()));
					
			}
			List<SfQuoteLineExceptions> sfQuoteExceptionsList = rmanIntfDealDetailsRepository.getErrorList(quoteNumber).stream().map(externalToMySFQuoteExceptionsFunc)
					.collect(Collectors.<SfQuoteLineExceptions> toList());
			
			sfQResponse.setSfQuoteLineExceptions(sfQuoteExceptionsList);
			return sfQResponse;
   		}catch(Exception e){
   			logger.error(e);
   			throw new AyaraCustomException ("Quote "+ quoteNumber +" not processed successfully in Ayara System");
		}
	}

	Function<Object[], SfQuoteLineExceptions> externalToMySFQuoteExceptionsFunc = new Function<Object[], SfQuoteLineExceptions>() {

		public SfQuoteLineExceptions apply(Object[] o) {
			
						return new SfQuoteLineExceptions((String)o[0],(String)o[1]);
		}
	};
	
	@Override
	public ResponseData processRmanRoleFunctions(String responsibilityId) {
		ResponseData resData = new ResponseData();
		String currentUser = BaseListener.getCurrentUser();
		String pStatus = null;
		String pMessage = null;
		try {
			StoredProcedureQuery storedProcedure = manager
					.createStoredProcedureQuery("AYARA_RESPONSIBILITY_FUNC")
					.registerStoredProcedureParameter("P_RESPONSIBILITY_ID", BigDecimal.class, ParameterMode.IN)
					.registerStoredProcedureParameter("P_CREATED_USER", String.class, ParameterMode.IN)
					.registerStoredProcedureParameter(CONSTANTS.P_STATUS, String.class, ParameterMode.OUT)
					.registerStoredProcedureParameter("P_ERROR_MSG", String.class, ParameterMode.OUT);
			
			storedProcedure.setParameter("P_RESPONSIBILITY_ID", new BigDecimal(responsibilityId));
			storedProcedure.setParameter("P_CREATED_USER", currentUser);
			storedProcedure.execute();
			
			pStatus = storedProcedure.getOutputParameterValue(CONSTANTS.P_STATUS).toString();
			Object obj = storedProcedure.getOutputParameterValue("P_ERROR_MSG");
			pMessage = obj != null ? obj.toString() : null;
		}catch(Exception e){
			logger.error(e);
			resData.setStatus("Fail");
			resData.setMessage("Failed to process permissions");
			return resData;
		}
		resData.setStatus(pStatus);
		resData.setMessage(pMessage);
		return resData;
	}
	
	@Override
	public String dealForecastAcualDetails(BigDecimal pArrgId) {
		String lquery = "";
		Statement st = null;
		ResultSet rs = null;
		try {
			StoredProcedureQuery storedProcedure = manager
					.createStoredProcedureQuery("RMAN_FC_PACKAGE.GET_FC_ACTUAL_VIEW_QUERY")
					.registerStoredProcedureParameter(CONSTANTS.P_ARR_ID, BigDecimal.class, ParameterMode.IN)
					.registerStoredProcedureParameter(CONSTANTS.O_D_QUERY, String.class, ParameterMode.OUT);
			
			storedProcedure.setParameter(CONSTANTS.P_ARR_ID, pArrgId);
				
			storedProcedure.execute();
			
			lquery = storedProcedure.getOutputParameterValue(CONSTANTS.O_D_QUERY).toString();
			SessionImpl sessionImpl = ((SessionImpl) manager.getDelegate());
			Connection cc = sessionImpl.connection();

			st = cc.createStatement();
			rs = st.executeQuery(lquery);
			ResultSetMetaData rsMetaData = rs.getMetaData();

			int numberOfColumns = rsMetaData.getColumnCount();
			ObjectMapper mapper = new ObjectMapper();
			ArrayNode arrayNode = mapper.createArrayNode();
			
			int rowcount = 0;
			
			while (rs.next()) {
				ObjectNode obj = mapper.createObjectNode();

				for (int i = 1; i < numberOfColumns + 1; i++) {
					int columnType = rsMetaData.getColumnType(i);

					if (columnType == Types.CHAR || columnType == Types.VARCHAR || columnType == Types.LONGVARCHAR) {
						obj.put(rsMetaData.getColumnName(i),
								rs.getObject(i) != null ? rs.getObject(i).toString() : null);
						
					} else if (columnType == Types.INTEGER || columnType == Types.BIGINT || columnType == Types.SMALLINT
							|| columnType == Types.NUMERIC) {
						obj.put(rsMetaData.getColumnName(i),
								rs.getObject(i) != null ? new BigDecimal(rs.getObject(i).toString()) : null);

					} else if (columnType == Types.DECIMAL || columnType == Types.DOUBLE || columnType == Types.FLOAT
							|| columnType == Types.REAL) {
						
						obj.put(rsMetaData.getColumnName(i),
								rs.getObject(i) != null ? Double.valueOf(rs.getObject(i).toString()) : null);

					} else if (columnType == Types.TIME || columnType == Types.TIMESTAMP || columnType == Types.DATE) {
						
						obj.put(rsMetaData.getColumnName(i),
								rs.getObject(i) != null ? rs.getTimestamp(i).getTime() : null);

					}

				}
				arrayNode.add(obj);
				rowcount++;
			}
			
			if (rowcount==0) {
				
				ObjectNode obj = mapper.createObjectNode();

				for (int i = 1; i < numberOfColumns + 1; i++) {
					int columnType = rsMetaData.getColumnType(i);

					if (columnType == Types.CHAR || columnType == Types.VARCHAR || columnType == Types.LONGVARCHAR) {
						obj.put(rsMetaData.getColumnName(i),
								rowcount > 0 ? rowcount : null);
						
					} else if (columnType == Types.INTEGER || columnType == Types.BIGINT || columnType == Types.SMALLINT
							|| columnType == Types.NUMERIC) {
						obj.put(rsMetaData.getColumnName(i),
								rowcount > 0 ? rowcount : null);

					} else if (columnType == Types.DECIMAL || columnType == Types.DOUBLE || columnType == Types.FLOAT
							|| columnType == Types.REAL) {
						
						obj.put(rsMetaData.getColumnName(i),
								rowcount > 0 ? rowcount : null);

					} else if (columnType == Types.TIME || columnType == Types.TIMESTAMP || columnType == Types.DATE) {
												obj.put(rsMetaData.getColumnName(i),
								rowcount > 0 ? rowcount : null);

					}

				}
				arrayNode.add(obj);

			}
			
			ObjectNode obj1 = mapper.createObjectNode();
			obj1.put(CONSTANTS.CONTENT, arrayNode);
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj1);

		} catch (Exception e) {
			logger.error(e);
			return null;
		} finally {
			if(st!=null){
				try {
					st.close();
				} catch (SQLException e) {
					logger.error(e);
				}
				}
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					logger.error(e);
				}
			}
		}

	}

	@Override
	public String getDashboardArrangementFigures(String fyear, String dDimension, String quarter, String period) {
		SessionImpl sessionImpl = ((SessionImpl) manager.getDelegate());
		Connection cc = sessionImpl.connection();
		/** CallableStatement callableStatement = null; */
		String lquery = "";
		try(CallableStatement callableStatement = cc.prepareCall("{call AYARA_DASHBOARD_REP(?,?,?,?,?,?)}")) {
			
			
			/** callableStatement = cc.prepareCall("{call AYARA_DASHBOARD_REP(?,?,?,?,?,?)}"); */
			if (!fyear.isEmpty()) {
				callableStatement.setBigDecimal(1, new BigDecimal(fyear));
			} else {
				callableStatement.setBigDecimal(1, null);
			}
			if (!dDimension.isEmpty()) {
				callableStatement.setString(2, dDimension);
			} else {
				callableStatement.setString(2, null);
			}
			if (!quarter.isEmpty()) {
				callableStatement.setString(3, quarter);
			} else {
				callableStatement.setString(3, null);
			}
			if (!period.isEmpty()) {
				callableStatement.setString(4, period);
			} else {
				callableStatement.setString(4, null);
			}
			callableStatement.registerOutParameter(5, java.sql.Types.VARCHAR);
			callableStatement.registerOutParameter(6, java.sql.Types.VARCHAR);
			callableStatement.executeQuery();
			if("F".equalsIgnoreCase(callableStatement.getString(5))) {
				return null;
			}
			lquery=callableStatement.getString(6);
			
			return executeQuery(lquery);
		}catch(Exception e) {
			logger.error(e);
			return null;
			
		}
	}
	
	private String executeQuery(String query) {
		Statement st = null;
		ResultSet rs = null;
	
		try {
			SessionImpl sessionImpl = ((SessionImpl) manager.getDelegate());
			Connection cc = sessionImpl.connection();
			
			st = cc.createStatement();
			rs = st.executeQuery(query);
		
			ResultSetMetaData rsMetaData = rs.getMetaData();
			
			int numberOfColumns = rsMetaData.getColumnCount();
			ObjectMapper mapper = new ObjectMapper();
			ArrayNode arrayNode = mapper.createArrayNode();
			
			int rowcount = 0;
			
			while (rs.next()) {
				ObjectNode obj = mapper.createObjectNode();

				for (int i = 1; i < numberOfColumns + 1; i++) {
					int columnType = rsMetaData.getColumnType(i);

					if (columnType == Types.CHAR || columnType == Types.VARCHAR || columnType == Types.LONGVARCHAR) {
						obj.put(rsMetaData.getColumnName(i),
								rs.getObject(i) != null ? rs.getObject(i).toString() : null);
						
					} else if (columnType == Types.INTEGER || columnType == Types.BIGINT || columnType == Types.SMALLINT
							|| columnType == Types.NUMERIC) {
						obj.put(rsMetaData.getColumnName(i),
								rs.getObject(i) != null ? new BigDecimal(rs.getObject(i).toString()) : null);

					} else if (columnType == Types.DECIMAL || columnType == Types.DOUBLE || columnType == Types.FLOAT
							|| columnType == Types.REAL) {
						
						obj.put(rsMetaData.getColumnName(i),
								rs.getObject(i) != null ? Double.valueOf(rs.getObject(i).toString()) : null);

					} else if (columnType == Types.TIME || columnType == Types.TIMESTAMP || columnType == Types.DATE) {
						
						obj.put(rsMetaData.getColumnName(i),
								rs.getObject(i) != null ? rs.getTimestamp(i).getTime() : null);

					}

				}
				arrayNode.add(obj);
				rowcount++;
			}
			
			if (rowcount==0) {
				
				ObjectNode obj = mapper.createObjectNode();

				for (int i = 1; i < numberOfColumns + 1; i++) {
					int columnType = rsMetaData.getColumnType(i);

					if (columnType == Types.CHAR || columnType == Types.VARCHAR || columnType == Types.LONGVARCHAR) {
						obj.put(rsMetaData.getColumnName(i),
								rowcount > 0 ? rowcount : null);
						
					} else if (columnType == Types.INTEGER || columnType == Types.BIGINT || columnType == Types.SMALLINT
							|| columnType == Types.NUMERIC) {
						obj.put(rsMetaData.getColumnName(i),
								rowcount > 0 ? rowcount : null);

					} else if (columnType == Types.DECIMAL || columnType == Types.DOUBLE || columnType == Types.FLOAT
							|| columnType == Types.REAL) {
						
						obj.put(rsMetaData.getColumnName(i),
								rowcount > 0 ? rowcount : null);

					} else if (columnType == Types.TIME || columnType == Types.TIMESTAMP || columnType == Types.DATE) {
												obj.put(rsMetaData.getColumnName(i),
								rowcount > 0 ? rowcount : null);

					}

				}
				arrayNode.add(obj);

			}
			ObjectNode obj1 = mapper.createObjectNode();
			obj1.put(CONSTANTS.CONTENT, arrayNode);
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj1);

		} catch (Exception e) {
			logger.error(e);
			return null;
		} finally {
			if(st!=null){
				try {
					st.close();
				} catch (SQLException e) {
					logger.error(e);
				}
				}
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					logger.error(e);
				}
			}
		}
	}
	
	@Override
	public ResponseData processSplit(BigDecimal srcRc, BigDecimal[] sourceContractHeaderIds, String flag) {
		ResponseData resData = new ResponseData();
		String pStatus = null;
		String pMessage = null;
		SessionImpl sessionImpl = ((SessionImpl) manager.getDelegate());
		Connection cc = sessionImpl.connection();
		CallableStatement callableStatement = null;
		try {
			callableStatement = cc.prepareCall("{call AYARA_CONTRACT_PROCESS_PKG.SPLIT_PROCESS(?,?,?,?,?,?,?)}");

			StructDescriptor resultStruct = StructDescriptor.createDescriptor("DEAL_HEADERS_REC", callableStatement.getConnection());

			Object[] arrayOfRecords = new Object[sourceContractHeaderIds.length];
			Object[] javaRecordArray = new Object[1];
			for (int i = 0; i < sourceContractHeaderIds.length; i++) {
				javaRecordArray[0] = sourceContractHeaderIds[i];
				STRUCT oracleRecord = new STRUCT(resultStruct, callableStatement.getConnection(), javaRecordArray);
				arrayOfRecords[i] = oracleRecord;

			}
			ArrayDescriptor descriptor = ArrayDescriptor.createDescriptor("DEAL_HEADERS", callableStatement.getConnection());
			ARRAY paramArray = new ARRAY(descriptor, callableStatement.getConnection(), arrayOfRecords);
			callableStatement.setBigDecimal("p_source_rc", srcRc); //p_source_rc
			callableStatement.setObject("p_contract_header_id", paramArray); //p_contract_header_id
			callableStatement.setString("p_flag", flag); //p_flag
			callableStatement.setBigDecimal(CONSTANTS.P_USER_ID, BaseListener.getCurrentUserId() != null ? BaseListener.getCurrentUserId() : new BigDecimal(-1)); //p_user_id
			callableStatement.registerOutParameter("p_target_rc", Types.DECIMAL); //p_target_rc
			callableStatement.registerOutParameter("p_err_flag", Types.VARCHAR); //p_err_flag
			callableStatement.registerOutParameter("p_err_message", Types.VARCHAR); //p_err_message
			callableStatement.execute();
			pStatus = callableStatement.getString("p_err_flag");
			Object obj = callableStatement.getString("p_err_message");
			pMessage = obj != null ? obj.toString() : null;
			resData.setStatus(pStatus);
			resData.setMessage(pMessage);
			resData.setTargetArrangementId(callableStatement.getBigDecimal("p_target_rc"));
			return resData;
			
		} catch (Exception e) {
			logger.error("Split Process Failed due to: {}", e.getMessage());
			resData.setStatus("Y");
			resData.setMessage("Split Process Failed due to: "+e);
			return resData;
		} finally {
			try {
				if (callableStatement != null) {
					callableStatement.close();
				}
			} catch (SQLException e) {
				logger.error(e);
			}
		}
		
		
	}
	
	
	@Override
	public ResponseData processMerge(BigDecimal srcRc, BigDecimal[] sourceContractHeaderIds, BigDecimal trgRc, String flag) {
		ResponseData resData = new ResponseData();
		String pStatus = null;
		String pMessage = null;
		SessionImpl sessionImpl = ((SessionImpl) manager.getDelegate());
		Connection cc = sessionImpl.connection();
		CallableStatement callableStatement = null;
		try {
			callableStatement = cc.prepareCall("{call AYARA_CONTRACT_PROCESS_PKG.MERGE_PROCESS(?,?,?,?,?,?,?)}");

			StructDescriptor resultStruct = StructDescriptor.createDescriptor("DEAL_HEADERS_REC", callableStatement.getConnection());

			Object[] arrayOfRecords = new Object[sourceContractHeaderIds.length];
			Object[] javaRecordArray = new Object[1];
			for (int i = 0; i < sourceContractHeaderIds.length; i++) {
				javaRecordArray[0] = sourceContractHeaderIds[i];
				STRUCT oracleRecord = new STRUCT(resultStruct, callableStatement.getConnection(), javaRecordArray);
				arrayOfRecords[i] = oracleRecord;

			}
			ArrayDescriptor descriptor = ArrayDescriptor.createDescriptor("DEAL_HEADERS", callableStatement.getConnection());
			ARRAY paramArray = new ARRAY(descriptor, callableStatement.getConnection(), arrayOfRecords);
			callableStatement.setBigDecimal("p_src_contract_num", srcRc); //p_src_contract_num
			callableStatement.setObject("p_src_contact_headers", paramArray); //p_src_contact_headers
			callableStatement.setBigDecimal("p_trg_contract_num", trgRc); //p_trg_contract_num
			callableStatement.setBigDecimal(CONSTANTS.P_USER_ID, BaseListener.getCurrentUserId() != null ? BaseListener.getCurrentUserId() : new BigDecimal(-1)); //p_user_id
			callableStatement.setString("p_lines_flag", flag); //p_lines_flag
			callableStatement.registerOutParameter(CONSTANTS.O_ERROR_FLAG, Types.VARCHAR); //o_error_flag
			callableStatement.registerOutParameter("o_error_message", Types.VARCHAR); //o_error_message
			callableStatement.execute();
			
			
			pStatus = callableStatement.getString(CONSTANTS.O_ERROR_FLAG);
			Object obj = callableStatement.getString("o_error_message");
			pMessage = obj != null ? obj.toString() : null;
			resData.setStatus(pStatus);
			resData.setMessage(pMessage);
			
			return resData;
		} catch (Exception e) {
			logger.error("Merge Process Failed due to: {} ", e.getMessage());
			resData.setStatus("Y");
			resData.setMessage("Merge Process Failed due to: "+e);
			return resData;
		} finally {
			try {
				if (callableStatement != null) {
					callableStatement.close();
				}
			} catch (SQLException e) {
				logger.error(e);
			}
		}		
	}

	@Override
	public String ayaraForecastActualDetails(String periodType) {
		String lquery = "";
		Statement st = null;
		ResultSet rs = null;
		try {
			StoredProcedureQuery storedProcedure = manager
					.createStoredProcedureQuery("AYARA_FORECAST_ACTUAL_REPORT_PKG.GENERATE_REPORT")
					.registerStoredProcedureParameter(CONSTANTS.P_PERIOD_TYPE, String.class, ParameterMode.IN)
					.registerStoredProcedureParameter(CONSTANTS.O_QUERY, String.class, ParameterMode.OUT);
			if(periodType!=null) {
				storedProcedure.setParameter(CONSTANTS.P_PERIOD_TYPE, periodType);
			}else {
				storedProcedure.setParameter(CONSTANTS.P_PERIOD_TYPE, null);
			}
			
			
				
			storedProcedure.execute();
			
			lquery = storedProcedure.getOutputParameterValue(CONSTANTS.O_QUERY).toString();
			
			
			
			SessionImpl sessionImpl = ((SessionImpl) manager.getDelegate());
			Connection cc = sessionImpl.connection();

			st = cc.createStatement();
			rs = st.executeQuery(lquery);
			ResultSetMetaData rsMetaData = rs.getMetaData();

			int numberOfColumns = rsMetaData.getColumnCount();
			ObjectMapper mapper = new ObjectMapper();
			ArrayNode arrayNode = mapper.createArrayNode();
			
			int rowcount = 0;
			
			while (rs.next()) {
				ObjectNode obj = mapper.createObjectNode();

				for (int i = 1; i < numberOfColumns + 1; i++) {
					int columnType = rsMetaData.getColumnType(i);

					if (columnType == Types.CHAR || columnType == Types.VARCHAR || columnType == Types.LONGVARCHAR) {
						if(!rsMetaData.getColumnName(i).equalsIgnoreCase(CONSTANTS.DEAL_LINE_NO)) {
							obj.put(rsMetaData.getColumnName(i),
									rs.getObject(i) != null ? rs.getObject(i).toString() : null);
						}
						
						
					} else if (columnType == Types.INTEGER || columnType == Types.BIGINT || columnType == Types.SMALLINT
							|| columnType == Types.NUMERIC) {
						if(!rsMetaData.getColumnName(i).equalsIgnoreCase(CONSTANTS.DEAL_LINE_NO)) {
							obj.put(rsMetaData.getColumnName(i),
								rs.getObject(i) != null ? new BigDecimal(rs.getObject(i).toString()) : null);
						}

					} else if (columnType == Types.DECIMAL || columnType == Types.DOUBLE || columnType == Types.FLOAT
							|| columnType == Types.REAL) {
						if(!rsMetaData.getColumnName(i).equalsIgnoreCase(CONSTANTS.DEAL_LINE_NO)) {
							obj.put(rsMetaData.getColumnName(i),
								rs.getObject(i) != null ? Double.valueOf(rs.getObject(i).toString()) : null);
						}

					} else if ((columnType == Types.TIME || columnType == Types.TIMESTAMP || columnType == Types.DATE) && !rsMetaData.getColumnName(i).equalsIgnoreCase(CONSTANTS.DEAL_LINE_NO)) {
							obj.put(rsMetaData.getColumnName(i),
								rs.getObject(i) != null ? rs.getTimestamp(i).getTime() : null);
					}

				}
				arrayNode.add(obj);
				rowcount++;
			}
			
			if (rowcount==0) {
				
				ObjectNode obj = mapper.createObjectNode();

				for (int i = 1; i < numberOfColumns + 1; i++) {
					int columnType = rsMetaData.getColumnType(i);

					if (columnType == Types.CHAR || columnType == Types.VARCHAR || columnType == Types.LONGVARCHAR) {
						obj.put(rsMetaData.getColumnName(i),
								rowcount > 0 ? rowcount : null);
						
					} else if (columnType == Types.INTEGER || columnType == Types.BIGINT || columnType == Types.SMALLINT
							|| columnType == Types.NUMERIC) {
						obj.put(rsMetaData.getColumnName(i),
								rowcount > 0 ? rowcount : null);

					} else if (columnType == Types.DECIMAL || columnType == Types.DOUBLE || columnType == Types.FLOAT
							|| columnType == Types.REAL) {
						
						obj.put(rsMetaData.getColumnName(i),
								rowcount > 0 ? rowcount : null);

					} else if (columnType == Types.TIME || columnType == Types.TIMESTAMP || columnType == Types.DATE) {
												obj.put(rsMetaData.getColumnName(i),
								rowcount > 0 ? rowcount : null);

					}

				}
				arrayNode.add(obj);

			}
			
			ObjectNode obj1 = mapper.createObjectNode();
			obj1.put(CONSTANTS.CONTENT, arrayNode);
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj1);

		} catch (Exception e) {
			logger.error(e);
			return null;
		} finally {
			if(st!=null){
				try {
					st.close();
				} catch (SQLException e) {
					logger.error(e);
				}
				}
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					logger.error(e);
				}
			}
		}
	}
	/*
	 * AYAR-1790 By Chandra on JAN 05th 2022
	 */
	@Override
	public String actualRevenueScheduleReport(BigDecimal arrgId) {
			String lquery = "";
			Statement st = null;
			ResultSet rs = null;
			try {
				StoredProcedureQuery storedProcedure = manager
						.createStoredProcedureQuery("revenue_schedules_report_pkg.generate_pivot_report")
						.registerStoredProcedureParameter(CONSTANTS.P_ARRG_ID, BigDecimal.class, ParameterMode.IN)
						.registerStoredProcedureParameter(CONSTANTS.O_QUERY, String.class, ParameterMode.OUT)
						.registerStoredProcedureParameter(CONSTANTS.O_ERROR_MSG, String.class, ParameterMode.OUT);
				
				storedProcedure.setParameter(CONSTANTS.P_ARRG_ID, arrgId);
					
				storedProcedure.execute();
				
				lquery = storedProcedure.getOutputParameterValue(CONSTANTS.O_QUERY).toString();
				
				if(storedProcedure.getOutputParameterValue(CONSTANTS.O_ERROR_MSG) !=null ) {
					logger.error(storedProcedure.getOutputParameterValue(CONSTANTS.O_ERROR_MSG));
					 throw new AyaraCustomException(storedProcedure.getOutputParameterValue(CONSTANTS.O_ERROR_MSG).toString());
				}
				SessionImpl sessionImpl = ((SessionImpl) manager.getDelegate());
				Connection cc = sessionImpl.connection();

				st = cc.createStatement();
				rs = st.executeQuery(lquery);
				ResultSetMetaData rsMetaData = rs.getMetaData();

				int numberOfColumns = rsMetaData.getColumnCount();
				ObjectMapper mapper = new ObjectMapper();
				ArrayNode arrayNode = mapper.createArrayNode();
				
				int rowcount = 0;
				
				while (rs.next()) {
					ObjectNode obj = mapper.createObjectNode();

					for (int i = 1; i < numberOfColumns + 1; i++) {
						int columnType = rsMetaData.getColumnType(i);

						if (columnType == Types.CHAR || columnType == Types.VARCHAR || columnType == Types.LONGVARCHAR) {
							obj.put(rsMetaData.getColumnName(i),
									rs.getObject(i) != null ? rs.getObject(i).toString() : null);
							
						} else if (columnType == Types.INTEGER || columnType == Types.BIGINT || columnType == Types.SMALLINT
								|| columnType == Types.NUMERIC) {
							obj.put(rsMetaData.getColumnName(i),
									rs.getObject(i) != null ? new BigDecimal(rs.getObject(i).toString()) : null);

						} else if (columnType == Types.DECIMAL || columnType == Types.DOUBLE || columnType == Types.FLOAT
								|| columnType == Types.REAL) {
							
							obj.put(rsMetaData.getColumnName(i),
									rs.getObject(i) != null ? Double.valueOf(rs.getObject(i).toString()) : null);

						} else if (columnType == Types.TIME || columnType == Types.TIMESTAMP || columnType == Types.DATE) {
							
							obj.put(rsMetaData.getColumnName(i),
									rs.getObject(i) != null ? rs.getTimestamp(i).getTime() : null);

						}

					}
					arrayNode.add(obj);
					rowcount++;
				}
				
				if (rowcount==0) {
					
					ObjectNode obj = mapper.createObjectNode();

					for (int i = 1; i < numberOfColumns + 1; i++) {
						int columnType = rsMetaData.getColumnType(i);

						if (columnType == Types.CHAR || columnType == Types.VARCHAR || columnType == Types.LONGVARCHAR) {
							obj.put(rsMetaData.getColumnName(i),
									rowcount > 0 ? rowcount : null);
							
						} else if (columnType == Types.INTEGER || columnType == Types.BIGINT || columnType == Types.SMALLINT
								|| columnType == Types.NUMERIC) {
							obj.put(rsMetaData.getColumnName(i),
									rowcount > 0 ? rowcount : null);

						} else if (columnType == Types.DECIMAL || columnType == Types.DOUBLE || columnType == Types.FLOAT
								|| columnType == Types.REAL) {
							
							obj.put(rsMetaData.getColumnName(i),
									rowcount > 0 ? rowcount : null);

						} else if (columnType == Types.TIME || columnType == Types.TIMESTAMP || columnType == Types.DATE) {
													obj.put(rsMetaData.getColumnName(i),
									rowcount > 0 ? rowcount : null);

						}

					}
					arrayNode.add(obj);

				}
				
				ObjectNode obj1 = mapper.createObjectNode();
				obj1.put(CONSTANTS.CONTENT, arrayNode);
				return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj1);

			} catch (Exception e) {
				logger.error(e);
				return null;
			} finally {
				if(st!=null){
					try {
						st.close();
					} catch (SQLException e) {
						logger.error(e);
					}
					}
				if(rs!=null){
					try {
						rs.close();
					} catch (SQLException e) {
						logger.error(e);
					}
				}
			}
	}

	@Override
	public String ayaraForecastReport(String arrangementLevel, BigDecimal arrangementId, String fromPeriod,
			String toPeriod) {
		String lquery = "";
		Statement st = null;
		ResultSet rs = null;
		try {
			StoredProcedureQuery storedProcedure = manager
					.createStoredProcedureQuery("ayara_reports_pkg.generate_fc_report_proc")
					.registerStoredProcedureParameter(CONSTANTS.P_LEVEL, String.class, ParameterMode.IN)
					.registerStoredProcedureParameter(CONSTANTS.P_ARRG_ID, BigDecimal.class, ParameterMode.IN)
					.registerStoredProcedureParameter(CONSTANTS.P_FROM_PERIOD, String.class, ParameterMode.IN)
					.registerStoredProcedureParameter(CONSTANTS.P_TO_PERIOD, String.class, ParameterMode.IN)
					.registerStoredProcedureParameter(CONSTANTS.O_QUERY, String.class, ParameterMode.OUT)
					.registerStoredProcedureParameter(CONSTANTS.O_ERROR_FLAG, String.class, ParameterMode.OUT)
					.registerStoredProcedureParameter(CONSTANTS.O_ERROR_MSG, String.class, ParameterMode.OUT);
			
			storedProcedure.setParameter(CONSTANTS.P_LEVEL, arrangementLevel);
			storedProcedure.setParameter(CONSTANTS.P_ARRG_ID, arrangementId);
			storedProcedure.setParameter(CONSTANTS.P_FROM_PERIOD, fromPeriod);
			storedProcedure.setParameter(CONSTANTS.P_TO_PERIOD, toPeriod);
				
			storedProcedure.execute();
			
			if(storedProcedure.getOutputParameterValue(CONSTANTS.O_ERROR_FLAG).equals("Y") && storedProcedure.getOutputParameterValue(CONSTANTS.O_ERROR_MSG)!=null ) {
					logger.error(storedProcedure.getOutputParameterValue(CONSTANTS.O_ERROR_MSG));
					throw new AyaraCustomException(storedProcedure.getOutputParameterValue(CONSTANTS.O_ERROR_MSG).toString());
			}
			lquery = storedProcedure.getOutputParameterValue(CONSTANTS.O_QUERY).toString();
			
			SessionImpl sessionImpl = ((SessionImpl) manager.getDelegate());
			Connection cc = sessionImpl.connection();

			st = cc.createStatement();
			rs = st.executeQuery(lquery);
			ResultSetMetaData rsMetaData = rs.getMetaData();

			int numberOfColumns = rsMetaData.getColumnCount();
			ObjectMapper mapper = new ObjectMapper();
			ArrayNode arrayNode = mapper.createArrayNode();
			
			int rowcount = 0;
			
			while (rs.next()) {
				ObjectNode obj = mapper.createObjectNode();

				for (int i = 1; i < numberOfColumns + 1; i++) {
					int columnType = rsMetaData.getColumnType(i);

					if (columnType == Types.CHAR || columnType == Types.VARCHAR || columnType == Types.LONGVARCHAR) {
						obj.put(rsMetaData.getColumnName(i),
								rs.getObject(i) != null ? rs.getObject(i).toString() : null);
						
					} else if (columnType == Types.INTEGER || columnType == Types.BIGINT || columnType == Types.SMALLINT
							|| columnType == Types.NUMERIC) {
						obj.put(rsMetaData.getColumnName(i),
								rs.getObject(i) != null ? new BigDecimal(rs.getObject(i).toString()) : null);

					} else if (columnType == Types.DECIMAL || columnType == Types.DOUBLE || columnType == Types.FLOAT
							|| columnType == Types.REAL) {
						
						obj.put(rsMetaData.getColumnName(i),
								rs.getObject(i) != null ? Double.valueOf(rs.getObject(i).toString()) : null);

					} else if (columnType == Types.TIME || columnType == Types.TIMESTAMP || columnType == Types.DATE) {
						
						obj.put(rsMetaData.getColumnName(i),
								rs.getObject(i) != null ? rs.getTimestamp(i).getTime() : null);

					}

				}
				arrayNode.add(obj);
				rowcount++;
			}
			
			if (rowcount==0) {
				
				ObjectNode obj = mapper.createObjectNode();

				for (int i = 1; i < numberOfColumns + 1; i++) {
					int columnType = rsMetaData.getColumnType(i);

					if (columnType == Types.CHAR || columnType == Types.VARCHAR || columnType == Types.LONGVARCHAR) {
						obj.put(rsMetaData.getColumnName(i),
								rowcount > 0 ? rowcount : null);
						
					} else if (columnType == Types.INTEGER || columnType == Types.BIGINT || columnType == Types.SMALLINT
							|| columnType == Types.NUMERIC) {
						obj.put(rsMetaData.getColumnName(i),
								rowcount > 0 ? rowcount : null);

					} else if (columnType == Types.DECIMAL || columnType == Types.DOUBLE || columnType == Types.FLOAT
							|| columnType == Types.REAL) {
						
						obj.put(rsMetaData.getColumnName(i),
								rowcount > 0 ? rowcount : null);

					} else if (columnType == Types.TIME || columnType == Types.TIMESTAMP || columnType == Types.DATE) {
												obj.put(rsMetaData.getColumnName(i),
								rowcount > 0 ? rowcount : null);

					}

				}
				arrayNode.add(obj);

			}
			
			ObjectNode obj1 = mapper.createObjectNode();
			obj1.put(CONSTANTS.CONTENT, arrayNode);
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj1);

		} catch (Exception e) {
			logger.error(e);
			return null;
		} finally {
			if(st!=null){
				try {
					st.close();
				} catch (SQLException e) {
					logger.error(e);
				}
				}
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					logger.error(e);
				}
			}
		}

	}

	@Override
	public String ayaraActiveQuotesARMReport(String arrangementLevel, String quoteStatus, String fromDate,
			String toDate) {
		String lquery = "";
		Statement st = null;
		ResultSet rs = null;
		
		SessionImpl sessionImpl = ((SessionImpl) manager.getDelegate());
		Connection cc = sessionImpl.connection();
		
		try {
			StoredProcedureQuery storedProcedure = manager
					.createStoredProcedureQuery("ayara_reports_pkg.generate_active_quotes_arm_report_proc")
					.registerStoredProcedureParameter(CONSTANTS.P_LEVEL, String.class, ParameterMode.IN)
					.registerStoredProcedureParameter(CONSTANTS.P_QUOTE_STATUS, String.class, ParameterMode.IN)
					.registerStoredProcedureParameter(CONSTANTS.P_FROM_DATE, String.class, ParameterMode.IN)
					.registerStoredProcedureParameter(CONSTANTS.P_TO_DATE, String.class, ParameterMode.IN)
					.registerStoredProcedureParameter(CONSTANTS.O_QUERY, String.class, ParameterMode.OUT)
					.registerStoredProcedureParameter(CONSTANTS.O_ERROR_FLAG, String.class, ParameterMode.OUT)
					.registerStoredProcedureParameter(CONSTANTS.O_ERROR_MSG, String.class, ParameterMode.OUT);
			
			storedProcedure.setParameter(CONSTANTS.P_LEVEL, arrangementLevel);
			storedProcedure.setParameter(CONSTANTS.P_QUOTE_STATUS, quoteStatus);
			storedProcedure.setParameter(CONSTANTS.P_FROM_DATE, fromDate);
			storedProcedure.setParameter(CONSTANTS.P_TO_DATE, toDate);
			storedProcedure.execute();
			
			if(storedProcedure.getOutputParameterValue(CONSTANTS.O_ERROR_FLAG).equals("Y") && storedProcedure.getOutputParameterValue(CONSTANTS.O_ERROR_MSG)!=null ) {
					logger.error(storedProcedure.getOutputParameterValue(CONSTANTS.O_ERROR_MSG));
					throw new AyaraCustomException(storedProcedure.getOutputParameterValue(CONSTANTS.O_ERROR_MSG).toString());
			}
			
			lquery = storedProcedure.getOutputParameterValue(CONSTANTS.O_QUERY).toString();
			
			
			st = cc.createStatement();
			rs = st.executeQuery(lquery);
			ResultSetMetaData rsMetaData = rs.getMetaData();

			int numberOfColumns = rsMetaData.getColumnCount();
			ObjectMapper mapper = new ObjectMapper();
			ArrayNode arrayNode = mapper.createArrayNode();
			
			int rowcount = 0;
			
			while (rs.next()) {
				ObjectNode obj = mapper.createObjectNode();

				for (int i = 1; i < numberOfColumns + 1; i++) {
					int columnType = rsMetaData.getColumnType(i);

					if (columnType == Types.CHAR || columnType == Types.VARCHAR || columnType == Types.LONGVARCHAR) {
						obj.put(rsMetaData.getColumnName(i),
								rs.getObject(i) != null ? rs.getObject(i).toString() : null);
						
					} else if (columnType == Types.INTEGER || columnType == Types.BIGINT || columnType == Types.SMALLINT
							|| columnType == Types.NUMERIC) {
						obj.put(rsMetaData.getColumnName(i),
								rs.getObject(i) != null ? new BigDecimal(rs.getObject(i).toString()) : null);

					} else if (columnType == Types.DECIMAL || columnType == Types.DOUBLE || columnType == Types.FLOAT
							|| columnType == Types.REAL) {
						
						obj.put(rsMetaData.getColumnName(i),
								rs.getObject(i) != null ? Double.valueOf(rs.getObject(i).toString()) : null);

					} else if (columnType == Types.TIME || columnType == Types.TIMESTAMP || columnType == Types.DATE) {
						
						obj.put(rsMetaData.getColumnName(i),
								rs.getObject(i) != null ? rs.getTimestamp(i).getTime() : null);

					}

				}
				arrayNode.add(obj);
				rowcount++;
			}
			
			if (rowcount==0) {
				
				ObjectNode obj = mapper.createObjectNode();

				for (int i = 1; i < numberOfColumns + 1; i++) {
					int columnType = rsMetaData.getColumnType(i);

					if (columnType == Types.CHAR || columnType == Types.VARCHAR || columnType == Types.LONGVARCHAR) {
						obj.put(rsMetaData.getColumnName(i),
								rowcount > 0 ? rowcount : null);
						
					} else if (columnType == Types.INTEGER || columnType == Types.BIGINT || columnType == Types.SMALLINT
							|| columnType == Types.NUMERIC) {
						obj.put(rsMetaData.getColumnName(i),
								rowcount > 0 ? rowcount : null);

					} else if (columnType == Types.DECIMAL || columnType == Types.DOUBLE || columnType == Types.FLOAT
							|| columnType == Types.REAL) {
						
						obj.put(rsMetaData.getColumnName(i),
								rowcount > 0 ? rowcount : null);

					} else if (columnType == Types.TIME || columnType == Types.TIMESTAMP || columnType == Types.DATE) {
												obj.put(rsMetaData.getColumnName(i),
								rowcount > 0 ? rowcount : null);

					}

				}
				arrayNode.add(obj);

			}
			
			ObjectNode obj1 = mapper.createObjectNode();
			obj1.put(CONSTANTS.CONTENT, arrayNode);
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj1);

		} catch (Exception e) {
			logger.error(e);
			return null;
		} finally {
			if(st!=null){
				try {
					st.close();
				} catch (SQLException e) {
					logger.error(e);
				}
				}
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					logger.error(e);
				}
			}
		}

	}

	@Override
	public String ayaraActualsARMReport(String arrangementLevel, String fromDate, String toDate) {
		String lquery = "";
		Statement st = null;
		ResultSet rs = null;
		SessionImpl sessionImpl = ((SessionImpl) manager.getDelegate());
		Connection cc = sessionImpl.connection();
		try {
		    StoredProcedureQuery storedProcedure = manager
					.createStoredProcedureQuery("ayara_reports_pkg.generate_actuals_arm_report_proc")
					.registerStoredProcedureParameter(CONSTANTS.P_LEVEL, String.class, ParameterMode.IN)
					.registerStoredProcedureParameter(CONSTANTS.P_FROM_DATE, String.class, ParameterMode.IN)
					.registerStoredProcedureParameter(CONSTANTS.P_TO_DATE, String.class, ParameterMode.IN)
					.registerStoredProcedureParameter(CONSTANTS.O_QUERY, String.class, ParameterMode.OUT)
					.registerStoredProcedureParameter(CONSTANTS.O_ERROR_FLAG, String.class, ParameterMode.OUT)
					.registerStoredProcedureParameter(CONSTANTS.O_ERROR_MSG, String.class, ParameterMode.OUT);
			
			storedProcedure.setParameter(CONSTANTS.P_LEVEL, arrangementLevel);
			storedProcedure.setParameter(CONSTANTS.P_FROM_DATE, fromDate);
			storedProcedure.setParameter(CONSTANTS.P_TO_DATE, toDate);
			storedProcedure.execute();
			
			if(storedProcedure.getOutputParameterValue(CONSTANTS.O_ERROR_FLAG).equals("Y") && storedProcedure.getOutputParameterValue(CONSTANTS.O_ERROR_MSG)!=null ) {
				logger.error(storedProcedure.getOutputParameterValue(CONSTANTS.O_ERROR_MSG));
				throw new AyaraCustomException(storedProcedure.getOutputParameterValue(CONSTANTS.O_ERROR_MSG).toString());
			}
			
			lquery = storedProcedure.getOutputParameterValue(CONSTANTS.O_QUERY).toString();
			
			st = cc.createStatement();
			rs = st.executeQuery(lquery);
			ResultSetMetaData rsMetaData = rs.getMetaData();

			int numberOfColumns = rsMetaData.getColumnCount();
			ObjectMapper mapper = new ObjectMapper();
			ArrayNode arrayNode = mapper.createArrayNode();
			
			int rowcount = 0;
			
			while (rs.next()) {
				ObjectNode obj = mapper.createObjectNode();

				for (int i = 1; i < numberOfColumns + 1; i++) {
					int columnType = rsMetaData.getColumnType(i);

					if (columnType == Types.CHAR || columnType == Types.VARCHAR || columnType == Types.LONGVARCHAR) {
						obj.put(rsMetaData.getColumnName(i),
								rs.getObject(i) != null ? rs.getObject(i).toString() : null);
						
					} else if (columnType == Types.INTEGER || columnType == Types.BIGINT || columnType == Types.SMALLINT
							|| columnType == Types.NUMERIC) {
						obj.put(rsMetaData.getColumnName(i),
								rs.getObject(i) != null ? new BigDecimal(rs.getObject(i).toString()) : null);

					} else if (columnType == Types.DECIMAL || columnType == Types.DOUBLE || columnType == Types.FLOAT
							|| columnType == Types.REAL) {
						
						obj.put(rsMetaData.getColumnName(i),
								rs.getObject(i) != null ? Double.valueOf(rs.getObject(i).toString()) : null);

					} else if (columnType == Types.TIME || columnType == Types.TIMESTAMP || columnType == Types.DATE) {
						
						obj.put(rsMetaData.getColumnName(i),
								rs.getObject(i) != null ? rs.getTimestamp(i).getTime() : null);

					}

				}
				arrayNode.add(obj);
				rowcount++;
			}
			
			if (rowcount==0) {
				
				ObjectNode obj = mapper.createObjectNode();

				for (int i = 1; i < numberOfColumns + 1; i++) {
					int columnType = rsMetaData.getColumnType(i);

					if (columnType == Types.CHAR || columnType == Types.VARCHAR || columnType == Types.LONGVARCHAR) {
						obj.put(rsMetaData.getColumnName(i),
								rowcount > 0 ? rowcount : null);
						
					} else if (columnType == Types.INTEGER || columnType == Types.BIGINT || columnType == Types.SMALLINT
							|| columnType == Types.NUMERIC) {
						obj.put(rsMetaData.getColumnName(i),
								rowcount > 0 ? rowcount : null);

					} else if (columnType == Types.DECIMAL || columnType == Types.DOUBLE || columnType == Types.FLOAT
							|| columnType == Types.REAL) {
						
						obj.put(rsMetaData.getColumnName(i),
								rowcount > 0 ? rowcount : null);

					} else if (columnType == Types.TIME || columnType == Types.TIMESTAMP || columnType == Types.DATE) {
												obj.put(rsMetaData.getColumnName(i),
								rowcount > 0 ? rowcount : null);

					}

				}
				arrayNode.add(obj);

			}
			
			ObjectNode obj1 = mapper.createObjectNode();
			obj1.put(CONSTANTS.CONTENT, arrayNode);
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj1);

		} catch (Exception e) {
			logger.error(e);
			return null;
		} finally {
			if(st!=null){
				try {
					st.close();
				} catch (SQLException e) {
					logger.error(e);
				}
				}
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					logger.error(e);
				}
			}
		}

	}
	
	@Override
	public String ayaraActualVsActiveReport(String arrgLevel,String docType, String quoteStatus, String fromDate, String toDate) {
		String lquery = "";
		Statement st = null;
		ResultSet rs = null;
		SessionImpl sessionImpl = ((SessionImpl) manager.getDelegate());
		Connection cc = sessionImpl.connection();
		try {
		    StoredProcedureQuery storedProcedure = manager
					.createStoredProcedureQuery("ayara_reports_pkg.generate_active_vs_actuals_report")
					.registerStoredProcedureParameter(CONSTANTS.P_LEVEL, String.class, ParameterMode.IN)
					.registerStoredProcedureParameter(CONSTANTS.P_DOC_TYPE, String.class, ParameterMode.IN)
					.registerStoredProcedureParameter(CONSTANTS.P_QUOTE_STATUS, String.class, ParameterMode.IN)
					.registerStoredProcedureParameter(CONSTANTS.P_FROM_DATE, String.class, ParameterMode.IN)
					.registerStoredProcedureParameter(CONSTANTS.P_TO_DATE, String.class, ParameterMode.IN)
					.registerStoredProcedureParameter(CONSTANTS.O_QUERY, String.class, ParameterMode.OUT)
					.registerStoredProcedureParameter(CONSTANTS.O_ERROR_FLAG, String.class, ParameterMode.OUT)
					.registerStoredProcedureParameter(CONSTANTS.O_ERROR_MSG, String.class, ParameterMode.OUT);
		    
		    storedProcedure.setParameter(CONSTANTS.P_LEVEL, arrgLevel);
		    storedProcedure.setParameter(CONSTANTS.P_DOC_TYPE, docType);
			storedProcedure.setParameter(CONSTANTS.P_QUOTE_STATUS, quoteStatus);
			storedProcedure.setParameter(CONSTANTS.P_FROM_DATE, fromDate);
			storedProcedure.setParameter(CONSTANTS.P_TO_DATE, toDate);
			storedProcedure.execute();
			
			if(storedProcedure.getOutputParameterValue(CONSTANTS.O_ERROR_FLAG).equals("Y") && storedProcedure.getOutputParameterValue(CONSTANTS.O_ERROR_MSG)!=null) {
					logger.error(storedProcedure.getOutputParameterValue(CONSTANTS.O_ERROR_MSG));
					throw new AyaraCustomException(storedProcedure.getOutputParameterValue(CONSTANTS.O_ERROR_MSG).toString());
			}
			
			lquery = storedProcedure.getOutputParameterValue(CONSTANTS.O_QUERY).toString();
			
			st = cc.createStatement();
			rs = st.executeQuery(lquery);
			ResultSetMetaData rsMetaData = rs.getMetaData();

			int numberOfColumns = rsMetaData.getColumnCount();
			ObjectMapper mapper = new ObjectMapper();
			ArrayNode arrayNode = mapper.createArrayNode();
			
			int rowcount = 0;
			
			while (rs.next()) {
				ObjectNode obj = mapper.createObjectNode();

				for (int i = 1; i < numberOfColumns + 1; i++) {
					int columnType = rsMetaData.getColumnType(i);

					if (columnType == Types.CHAR || columnType == Types.VARCHAR || columnType == Types.LONGVARCHAR) {
						obj.put(rsMetaData.getColumnName(i),
								rs.getObject(i) != null ? rs.getObject(i).toString() : null);
						
					} else if (columnType == Types.INTEGER || columnType == Types.BIGINT || columnType == Types.SMALLINT
							|| columnType == Types.NUMERIC) {
						obj.put(rsMetaData.getColumnName(i),
								rs.getObject(i) != null ? new BigDecimal(rs.getObject(i).toString()) : null);

					} else if (columnType == Types.DECIMAL || columnType == Types.DOUBLE || columnType == Types.FLOAT
							|| columnType == Types.REAL) {
						
						obj.put(rsMetaData.getColumnName(i),
								rs.getObject(i) != null ? Double.valueOf(rs.getObject(i).toString()) : null);

					} else if (columnType == Types.TIME || columnType == Types.TIMESTAMP || columnType == Types.DATE) {
						
						obj.put(rsMetaData.getColumnName(i),
								rs.getObject(i) != null ? rs.getTimestamp(i).getTime() : null);

					}

				}
				arrayNode.add(obj);
				rowcount++;
			}
			
			if (rowcount==0) {
				
				ObjectNode obj = mapper.createObjectNode();

				for (int i = 1; i < numberOfColumns + 1; i++) {
					int columnType = rsMetaData.getColumnType(i);

					if (columnType == Types.CHAR || columnType == Types.VARCHAR || columnType == Types.LONGVARCHAR) {
						obj.put(rsMetaData.getColumnName(i),
								rowcount > 0 ? rowcount : null);
						
					} else if (columnType == Types.INTEGER || columnType == Types.BIGINT || columnType == Types.SMALLINT
							|| columnType == Types.NUMERIC) {
						obj.put(rsMetaData.getColumnName(i),
								rowcount > 0 ? rowcount : null);

					} else if (columnType == Types.DECIMAL || columnType == Types.DOUBLE || columnType == Types.FLOAT
							|| columnType == Types.REAL) {
						
						obj.put(rsMetaData.getColumnName(i),
								rowcount > 0 ? rowcount : null);

					} else if (columnType == Types.TIME || columnType == Types.TIMESTAMP || columnType == Types.DATE) {
												obj.put(rsMetaData.getColumnName(i),
								rowcount > 0 ? rowcount : null);

					}

				}
				arrayNode.add(obj);

			}
			
			ObjectNode obj1 = mapper.createObjectNode();
			obj1.put(CONSTANTS.CONTENT, arrayNode);
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj1);

		} catch (Exception e) {
			logger.error(e);
			return null;
		} finally {
			if(st!=null){
				try {
					st.close();
				} catch (SQLException e) {
					logger.error(e);
				}
				}
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					logger.error(e);
				}
			}
		}

	}
	
	@Override
	public String ayaraActiveQuotesARMChart(String quoteStatus, String arrgLevel, String fromDate, String toDate) {
		String lquery = "";
		Statement st = null;
		ResultSet rs = null;
		SessionImpl sessionImpl = ((SessionImpl) manager.getDelegate());
		Connection cc = sessionImpl.connection();
		try {
		    StoredProcedureQuery storedProcedure = manager
					.createStoredProcedureQuery("ayara_reports_pkg.generate_active_quotes_chart_proc")
					.registerStoredProcedureParameter(CONSTANTS.P_LEVEL, String.class, ParameterMode.IN)
					.registerStoredProcedureParameter(CONSTANTS.P_QUOTE_STATUS, String.class, ParameterMode.IN)
					.registerStoredProcedureParameter(CONSTANTS.P_FROM_DATE, String.class, ParameterMode.IN)
					.registerStoredProcedureParameter(CONSTANTS.P_TO_DATE, String.class, ParameterMode.IN)
					.registerStoredProcedureParameter(CONSTANTS.O_QUERY, String.class, ParameterMode.OUT)
					.registerStoredProcedureParameter(CONSTANTS.O_ERROR_FLAG, String.class, ParameterMode.OUT)
					.registerStoredProcedureParameter(CONSTANTS.O_ERROR_MSG, String.class, ParameterMode.OUT);
		    storedProcedure.setParameter(CONSTANTS.P_LEVEL, arrgLevel);
			storedProcedure.setParameter(CONSTANTS.P_QUOTE_STATUS, quoteStatus);
			storedProcedure.setParameter(CONSTANTS.P_FROM_DATE, fromDate);
			storedProcedure.setParameter(CONSTANTS.P_TO_DATE, toDate);
			storedProcedure.execute();
			
			if(storedProcedure.getOutputParameterValue(CONSTANTS.O_ERROR_FLAG).equals("Y") && storedProcedure.getOutputParameterValue(CONSTANTS.O_ERROR_MSG)!=null) {
				logger.error(storedProcedure.getOutputParameterValue(CONSTANTS.O_ERROR_MSG));
				throw new AyaraCustomException(storedProcedure.getOutputParameterValue(CONSTANTS.O_ERROR_MSG).toString());
			}
			
			lquery = storedProcedure.getOutputParameterValue(CONSTANTS.O_QUERY).toString();
			
			st = cc.createStatement();
			rs = st.executeQuery(lquery);
			ResultSetMetaData rsMetaData = rs.getMetaData();

			int numberOfColumns = rsMetaData.getColumnCount();
			ObjectMapper mapper = new ObjectMapper();
			ArrayNode arrayNode = mapper.createArrayNode();
			
			int rowcount = 0;
			
			while (rs.next()) {
				ObjectNode obj = mapper.createObjectNode();

				for (int i = 1; i < numberOfColumns + 1; i++) {
					int columnType = rsMetaData.getColumnType(i);

					if (columnType == Types.CHAR || columnType == Types.VARCHAR || columnType == Types.LONGVARCHAR) {
						obj.put(rsMetaData.getColumnName(i),
								rs.getObject(i) != null ? rs.getObject(i).toString() : null);
						
					} else if (columnType == Types.INTEGER || columnType == Types.BIGINT || columnType == Types.SMALLINT
							|| columnType == Types.NUMERIC) {
						obj.put(rsMetaData.getColumnName(i),
								rs.getObject(i) != null ? new BigDecimal(rs.getObject(i).toString()) : null);

					} else if (columnType == Types.DECIMAL || columnType == Types.DOUBLE || columnType == Types.FLOAT
							|| columnType == Types.REAL) {
						
						obj.put(rsMetaData.getColumnName(i),
								rs.getObject(i) != null ? Double.valueOf(rs.getObject(i).toString()) : null);

					} else if (columnType == Types.TIME || columnType == Types.TIMESTAMP || columnType == Types.DATE) {
						
						obj.put(rsMetaData.getColumnName(i),
								rs.getObject(i) != null ? rs.getTimestamp(i).getTime() : null);

					}

				}
				arrayNode.add(obj);
				rowcount++;
			}
			
			if (rowcount==0) {
				
				ObjectNode obj = mapper.createObjectNode();

				for (int i = 1; i < numberOfColumns + 1; i++) {
					int columnType = rsMetaData.getColumnType(i);

					if (columnType == Types.CHAR || columnType == Types.VARCHAR || columnType == Types.LONGVARCHAR) {
						obj.put(rsMetaData.getColumnName(i),
								rowcount > 0 ? rowcount : null);
						
					} else if (columnType == Types.INTEGER || columnType == Types.BIGINT || columnType == Types.SMALLINT
							|| columnType == Types.NUMERIC) {
						obj.put(rsMetaData.getColumnName(i),
								rowcount > 0 ? rowcount : null);

					} else if (columnType == Types.DECIMAL || columnType == Types.DOUBLE || columnType == Types.FLOAT
							|| columnType == Types.REAL) {
						
						obj.put(rsMetaData.getColumnName(i),
								rowcount > 0 ? rowcount : null);

					} else if (columnType == Types.TIME || columnType == Types.TIMESTAMP || columnType == Types.DATE) {
												obj.put(rsMetaData.getColumnName(i),
								rowcount > 0 ? rowcount : null);

					}

				}
				arrayNode.add(obj);

			}
			
			ObjectNode obj1 = mapper.createObjectNode();
			obj1.put(CONSTANTS.CONTENT, arrayNode);
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj1);

		} catch (Exception e) {
			logger.error(e);
			return null;
		} finally {
			if(st!=null){
				try {
					st.close();
				} catch (SQLException e) {
					logger.error(e);
				}
				}
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					logger.error(e);
				}
			}
		}

	}
	
	@Override
	public String ayaraActualsARMChart(String arrgLevel, String fromDate, String toDate) {
		String lquery = "";
		Statement st = null;
		ResultSet rs = null;
		SessionImpl sessionImpl = ((SessionImpl) manager.getDelegate());
		Connection cc = sessionImpl.connection();
		try {
		    StoredProcedureQuery storedProcedure = manager
					.createStoredProcedureQuery("ayara_reports_pkg.generate_actuals_chart_proc")
					.registerStoredProcedureParameter(CONSTANTS.P_LEVEL, String.class, ParameterMode.IN)
					.registerStoredProcedureParameter(CONSTANTS.P_FROM_DATE, String.class, ParameterMode.IN)
					.registerStoredProcedureParameter(CONSTANTS.P_TO_DATE, String.class, ParameterMode.IN)
					.registerStoredProcedureParameter(CONSTANTS.O_QUERY, String.class, ParameterMode.OUT)
					.registerStoredProcedureParameter(CONSTANTS.O_ERROR_FLAG, String.class, ParameterMode.OUT)
					.registerStoredProcedureParameter(CONSTANTS.O_ERROR_MSG, String.class, ParameterMode.OUT);
		    storedProcedure.setParameter(CONSTANTS.P_LEVEL, arrgLevel);
			storedProcedure.setParameter(CONSTANTS.P_FROM_DATE, fromDate);
			storedProcedure.setParameter(CONSTANTS.P_TO_DATE, toDate);
			storedProcedure.execute();
			
			if(storedProcedure.getOutputParameterValue(CONSTANTS.O_ERROR_FLAG).equals("Y") && storedProcedure.getOutputParameterValue(CONSTANTS.O_ERROR_MSG)!=null ) {
				logger.error(storedProcedure.getOutputParameterValue(CONSTANTS.O_ERROR_MSG));
				throw new AyaraCustomException(storedProcedure.getOutputParameterValue(CONSTANTS.O_ERROR_MSG).toString());
			}
			
			lquery = storedProcedure.getOutputParameterValue(CONSTANTS.O_QUERY).toString();
			
			st = cc.createStatement();
			rs = st.executeQuery(lquery);
			ResultSetMetaData rsMetaData = rs.getMetaData();

			int numberOfColumns = rsMetaData.getColumnCount();
			ObjectMapper mapper = new ObjectMapper();
			ArrayNode arrayNode = mapper.createArrayNode();
			
			int rowcount = 0;
			
			while (rs.next()) {
				ObjectNode obj = mapper.createObjectNode();

				for (int i = 1; i < numberOfColumns + 1; i++) {
					int columnType = rsMetaData.getColumnType(i);

					if (columnType == Types.CHAR || columnType == Types.VARCHAR || columnType == Types.LONGVARCHAR) {
						obj.put(rsMetaData.getColumnName(i),
								rs.getObject(i) != null ? rs.getObject(i).toString() : null);
						
					} else if (columnType == Types.INTEGER || columnType == Types.BIGINT || columnType == Types.SMALLINT
							|| columnType == Types.NUMERIC) {
						obj.put(rsMetaData.getColumnName(i),
								rs.getObject(i) != null ? new BigDecimal(rs.getObject(i).toString()) : null);

					} else if (columnType == Types.DECIMAL || columnType == Types.DOUBLE || columnType == Types.FLOAT
							|| columnType == Types.REAL) {
						
						obj.put(rsMetaData.getColumnName(i),
								rs.getObject(i) != null ? Double.valueOf(rs.getObject(i).toString()) : null);

					} else if (columnType == Types.TIME || columnType == Types.TIMESTAMP || columnType == Types.DATE) {
						
						obj.put(rsMetaData.getColumnName(i),
								rs.getObject(i) != null ? rs.getTimestamp(i).getTime() : null);

					}

				}
				arrayNode.add(obj);
				rowcount++;
			}
			
			if (rowcount==0) {
				
				ObjectNode obj = mapper.createObjectNode();

				for (int i = 1; i < numberOfColumns + 1; i++) {
					int columnType = rsMetaData.getColumnType(i);

					if (columnType == Types.CHAR || columnType == Types.VARCHAR || columnType == Types.LONGVARCHAR) {
						obj.put(rsMetaData.getColumnName(i),
								rowcount > 0 ? rowcount : null);
						
					} else if (columnType == Types.INTEGER || columnType == Types.BIGINT || columnType == Types.SMALLINT
							|| columnType == Types.NUMERIC) {
						obj.put(rsMetaData.getColumnName(i),
								rowcount > 0 ? rowcount : null);

					} else if (columnType == Types.DECIMAL || columnType == Types.DOUBLE || columnType == Types.FLOAT
							|| columnType == Types.REAL) {
						
						obj.put(rsMetaData.getColumnName(i),
								rowcount > 0 ? rowcount : null);

					} else if (columnType == Types.TIME || columnType == Types.TIMESTAMP || columnType == Types.DATE) {
												obj.put(rsMetaData.getColumnName(i),
								rowcount > 0 ? rowcount : null);

					}

				}
				arrayNode.add(obj);

			}
			
			ObjectNode obj1 = mapper.createObjectNode();
			obj1.put(CONSTANTS.CONTENT, arrayNode);
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj1);

		} catch (Exception e) {
			logger.error(e);
			return null;
		} finally {
			if(st!=null){
				try {
					st.close();
				} catch (SQLException e) {
					logger.error(e);
				}
				}
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					logger.error(e);
				}
			}
		}

	}
	
	@Override
	public String ayaraActualVsActiveChart(String arrgLevel,String docType, String quoteStatus, String fromDate, String toDate) {
		String lquery = "";
		Statement st = null;
		ResultSet rs = null;
		SessionImpl sessionImpl = ((SessionImpl) manager.getDelegate());
		Connection cc = sessionImpl.connection();
		try {
		    StoredProcedureQuery storedProcedure = manager
					.createStoredProcedureQuery("ayara_reports_pkg.generate_active_vs_actuals_chart_proc")
					.registerStoredProcedureParameter(CONSTANTS.P_LEVEL, String.class, ParameterMode.IN)
					.registerStoredProcedureParameter(CONSTANTS.P_DOC_TYPE, String.class, ParameterMode.IN)
					.registerStoredProcedureParameter(CONSTANTS.P_QUOTE_STATUS, String.class, ParameterMode.IN)
					.registerStoredProcedureParameter(CONSTANTS.P_FROM_DATE, String.class, ParameterMode.IN)
					.registerStoredProcedureParameter(CONSTANTS.P_TO_DATE, String.class, ParameterMode.IN)
					.registerStoredProcedureParameter(CONSTANTS.O_QUERY, String.class, ParameterMode.OUT)
					.registerStoredProcedureParameter(CONSTANTS.O_ERROR_FLAG, String.class, ParameterMode.OUT)
					.registerStoredProcedureParameter(CONSTANTS.O_ERROR_MSG, String.class, ParameterMode.OUT);
		    storedProcedure.setParameter(CONSTANTS.P_LEVEL, arrgLevel);
		    storedProcedure.setParameter(CONSTANTS.P_DOC_TYPE, docType);
		    storedProcedure.setParameter(CONSTANTS.P_QUOTE_STATUS, quoteStatus);
			storedProcedure.setParameter(CONSTANTS.P_FROM_DATE, fromDate);
			storedProcedure.setParameter(CONSTANTS.P_TO_DATE, toDate);
			storedProcedure.execute();
			
			if(storedProcedure.getOutputParameterValue(CONSTANTS.O_ERROR_FLAG).equals("Y") && storedProcedure.getOutputParameterValue(CONSTANTS.O_ERROR_MSG)!=null ) {
					logger.error(storedProcedure.getOutputParameterValue(CONSTANTS.O_ERROR_MSG));
					throw new AyaraCustomException(storedProcedure.getOutputParameterValue(CONSTANTS.O_ERROR_MSG).toString());
			}
			
			lquery = storedProcedure.getOutputParameterValue(CONSTANTS.O_QUERY).toString();
			
			st = cc.createStatement();
			rs = st.executeQuery(lquery);
			ResultSetMetaData rsMetaData = rs.getMetaData();

			int numberOfColumns = rsMetaData.getColumnCount();
			ObjectMapper mapper = new ObjectMapper();
			ArrayNode arrayNode = mapper.createArrayNode();
			
			int rowcount = 0;
			
			while (rs.next()) {
				ObjectNode obj = mapper.createObjectNode();

				for (int i = 1; i < numberOfColumns + 1; i++) {
					int columnType = rsMetaData.getColumnType(i);

					if (columnType == Types.CHAR || columnType == Types.VARCHAR || columnType == Types.LONGVARCHAR) {
						obj.put(rsMetaData.getColumnName(i),
								rs.getObject(i) != null ? rs.getObject(i).toString() : null);
						
					} else if (columnType == Types.INTEGER || columnType == Types.BIGINT || columnType == Types.SMALLINT
							|| columnType == Types.NUMERIC) {
						obj.put(rsMetaData.getColumnName(i),
								rs.getObject(i) != null ? new BigDecimal(rs.getObject(i).toString()) : null);

					} else if (columnType == Types.DECIMAL || columnType == Types.DOUBLE || columnType == Types.FLOAT
							|| columnType == Types.REAL) {
						
						obj.put(rsMetaData.getColumnName(i),
								rs.getObject(i) != null ? Double.valueOf(rs.getObject(i).toString()) : null);

					} else if (columnType == Types.TIME || columnType == Types.TIMESTAMP || columnType == Types.DATE) {
						
						obj.put(rsMetaData.getColumnName(i),
								rs.getObject(i) != null ? rs.getTimestamp(i).getTime() : null);

					}

				}
				arrayNode.add(obj);
				rowcount++;
			}
			
			if (rowcount==0) {
				
				ObjectNode obj = mapper.createObjectNode();

				for (int i = 1; i < numberOfColumns + 1; i++) {
					int columnType = rsMetaData.getColumnType(i);

					if (columnType == Types.CHAR || columnType == Types.VARCHAR || columnType == Types.LONGVARCHAR) {
						obj.put(rsMetaData.getColumnName(i),
								rowcount > 0 ? rowcount : null);
						
					} else if (columnType == Types.INTEGER || columnType == Types.BIGINT || columnType == Types.SMALLINT
							|| columnType == Types.NUMERIC) {
						obj.put(rsMetaData.getColumnName(i),
								rowcount > 0 ? rowcount : null);

					} else if (columnType == Types.DECIMAL || columnType == Types.DOUBLE || columnType == Types.FLOAT
							|| columnType == Types.REAL) {
						
						obj.put(rsMetaData.getColumnName(i),
								rowcount > 0 ? rowcount : null);

					} else if (columnType == Types.TIME || columnType == Types.TIMESTAMP || columnType == Types.DATE) {
												obj.put(rsMetaData.getColumnName(i),
								rowcount > 0 ? rowcount : null);

					}

				}
				arrayNode.add(obj);

			}
			
			ObjectNode obj1 = mapper.createObjectNode();
			obj1.put(CONSTANTS.CONTENT, arrayNode);
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj1);

		} catch (Exception e) {
			logger.error(e);
			return null;
		} finally {
			if(st!=null){
				try {
					st.close();
				} catch (SQLException e) {
					logger.error(e);
				}
				}
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					logger.error(e);
				}
			}
		}

	}
	


}
