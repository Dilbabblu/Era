package com.forsys.revmantra.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.forsys.revmantra.model.RmanRevDetailsV;

public interface RmanRevDetailsVRepository extends PagingAndSortingRepository<RmanRevDetailsV, java.math.BigDecimal> {
	/**
	 * 
	 * @param pDealArragId
	 * @param revType
	 * @return
	 * 
	 * Added SUM(r.REVENUE_ADJUSTMENT)
	 * for the following revTotals1,revTotals2,revTotals3 and revTotals4
	 * AYAR-1692 By Chandra on 25-10-2021
	 */
	@Query(value = "select SUM(case when r.parent_line_id is null then r.total_Allocation end),SUM(r.delivered_Alloc_Rsp),SUM(r.POST_BILLING_CONT_AMOUNT),SUM(r.POST_BILLING_DEFERRED_AMOUNT),SUM(r.POST_BILLING_ALLOCATION_AMOUNT),SUM(r.CUM_GAAP_BEG_BALANCE),SUM(r.NET_GAPP_CURR_MONTH),SUM(r.CUM_GAAP_ENDING_BALANCE),SUM(case when r.parent_line_id is null then r.TOTAL_ALLOCATION_FC end),SUM(r.DELIVERED_ALLOC_FC_RSP),SUM(r.PB_DEFERRAL_FC),SUM(case when r.parent_line_id is null then r.BOOKED_AMOUNT end),SUM(case when r.parent_line_id is null then r.SHIPPED_AMOUNT end),SUM(r.BILLED_AMOUNT),SUM(r.GAAP_UNAMORTIZED),SUM(r.BILLED_AMOUNT_FC),SUM(r.PB_ALLOC_AMOUNT_TC),SUM(r.REV_BEG_BAL_TC),SUM(r.REV_CURR_MONTH_BAL_TC),SUM(r.REV_END_BAL_TC),SUM(r.GAAP_UNAMORTIZED_TC),SUM(r.REVENUE_ADJUSTMENT) FROM TABLE(RMAN_REV_DETAILS_PKG.revenue_details(?1,?2)) r", nativeQuery = true)
	List<Object[]> revTotals1(BigDecimal pDealArragId, String revType);

	@Query(value = "select SUM(case when r.parent_line_id is null then r.total_Allocation end),SUM(r.delivered_Alloc_Rsp),SUM(r.POST_BILLING_CONT_AMOUNT),SUM(r.POST_BILLING_DEFERRED_AMOUNT),SUM(r.POST_BILLING_ALLOCATION_AMOUNT),SUM(r.CUM_GAAP_BEG_BALANCE),SUM(r.NET_GAPP_CURR_MONTH),SUM(r.CUM_GAAP_ENDING_BALANCE),SUM(case when r.parent_line_id is null then r.TOTAL_ALLOCATION_FC end),SUM(r.DELIVERED_ALLOC_FC_RSP),SUM(r.PB_DEFERRAL_FC),SUM(case when r.parent_line_id is null then r.BOOKED_AMOUNT end),SUM(case when r.parent_line_id is null then r.SHIPPED_AMOUNT end),SUM(r.BILLED_AMOUNT),SUM(r.GAAP_UNAMORTIZED),SUM(r.BILLED_AMOUNT_FC),SUM(r.PB_ALLOC_AMOUNT_TC),SUM(r.REV_BEG_BAL_TC),SUM(r.REV_CURR_MONTH_BAL_TC),SUM(r.REV_END_BAL_TC),SUM(r.GAAP_UNAMORTIZED_TC),SUM(r.REVENUE_ADJUSTMENT) FROM TABLE(RMAN_REV_DETAILS_PKG.revenue_details(?1,?2,?3)) r", nativeQuery = true)
	List<Object[]> revTotals2(BigDecimal pDealArragId, BigDecimal so, String revType);

	@Query(value = "select SUM(case when r.parent_line_id is null then r.total_Allocation end),SUM(r.delivered_Alloc_Rsp),SUM(r.POST_BILLING_CONT_AMOUNT),SUM(r.POST_BILLING_DEFERRED_AMOUNT),SUM(r.POST_BILLING_ALLOCATION_AMOUNT),SUM(r.CUM_GAAP_BEG_BALANCE),SUM(r.NET_GAPP_CURR_MONTH),SUM(r.CUM_GAAP_ENDING_BALANCE),SUM(case when r.parent_line_id is null then r.TOTAL_ALLOCATION_FC end),SUM(r.DELIVERED_ALLOC_FC_RSP),SUM(r.PB_DEFERRAL_FC),SUM(case when r.parent_line_id is null then r.BOOKED_AMOUNT end),SUM(case when r.parent_line_id is null then r.SHIPPED_AMOUNT end),SUM(r.BILLED_AMOUNT),SUM(r.GAAP_UNAMORTIZED),SUM(r.BILLED_AMOUNT_FC),SUM(r.PB_ALLOC_AMOUNT_TC),SUM(r.REV_BEG_BAL_TC),SUM(r.REV_CURR_MONTH_BAL_TC),SUM(r.REV_END_BAL_TC),SUM(r.GAAP_UNAMORTIZED_TC),SUM(r.REVENUE_ADJUSTMENT) FROM TABLE(RMAN_REV_DETAILS_PKG.revenue_details(?1,NULL,?2,?3)) r", nativeQuery = true)
	List<Object[]> revTotals3(BigDecimal pDealArragId, String soLine, String revType);

	@Query(value = "select SUM(case when r.parent_line_id is null then r.total_Allocation end),SUM(r.delivered_Alloc_Rsp),SUM(r.POST_BILLING_CONT_AMOUNT),SUM(r.POST_BILLING_DEFERRED_AMOUNT),SUM(r.POST_BILLING_ALLOCATION_AMOUNT),SUM(r.CUM_GAAP_BEG_BALANCE),SUM(r.NET_GAPP_CURR_MONTH),SUM(r.CUM_GAAP_ENDING_BALANCE),SUM(case when r.parent_line_id is null then r.TOTAL_ALLOCATION_FC end),SUM(r.DELIVERED_ALLOC_FC_RSP),SUM(r.PB_DEFERRAL_FC),SUM(case when r.parent_line_id is null then r.BOOKED_AMOUNT end),SUM(case when r.parent_line_id is null then r.SHIPPED_AMOUNT end),SUM(r.BILLED_AMOUNT),SUM(r.GAAP_UNAMORTIZED),SUM(r.BILLED_AMOUNT_FC),SUM(r.PB_ALLOC_AMOUNT_TC),SUM(r.REV_BEG_BAL_TC),SUM(r.REV_CURR_MONTH_BAL_TC),SUM(r.REV_END_BAL_TC),SUM(r.GAAP_UNAMORTIZED_TC),SUM(r.REVENUE_ADJUSTMENT) FROM TABLE(RMAN_REV_DETAILS_PKG.revenue_details(?1,?2,?3,?4)) r", nativeQuery = true)
	List<Object[]> revTotals4(BigDecimal pDealArragId, BigDecimal so, String soLineNum, String revType);
	
	/**
	 * List<RmanRevDetailsV> findByDealArrangementId(BigDecimal arrgId, BigDecimal
	 * so, String soLineNum);
	 */
	
	@Query(value = "select r.* from table(RMAN_REV_DETAILS_PKG.revenue_details(?1,?2)) r", nativeQuery = true)
	List<Object[]> listOfRevDetials1(BigDecimal pDealArragId, String revType);

	@Query(value = "select r.* from table(RMAN_REV_DETAILS_PKG.revenue_details(?1,?2,?3)) r", nativeQuery = true)
	List<Object[]> listOfRevDetials2(BigDecimal pDealArragId, BigDecimal so, String revType);

	@Query(value = "select r.* from table(RMAN_REV_DETAILS_PKG.revenue_details(?1,NULL,?2,?3)) r", nativeQuery = true)
	List<Object[]> listOfRevDetials3(BigDecimal pDealArragId, String soLine, String revType);

	@Query(value = "select r.* from table(RMAN_REV_DETAILS_PKG.revenue_details(?1,?2,?3,?4)) r", nativeQuery = true)
	List<Object[]> listOfRevDetials4(BigDecimal pDealArragId, BigDecimal so, String soLineNum, String revType);

}
