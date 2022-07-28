package com.forsys.revmantra.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.ArrgOrderAllocationsV;

@RepositoryRestResource(collectionResourceRel = "ARRG_ORDER_ALLOCATIONS_V", path = "ARRG_ORDER_ALLOCATIONS_V")
public interface ArrgOrderAllocationsVRepository extends PagingAndSortingRepository<ArrgOrderAllocationsV, java.math.BigDecimal>, JpaRepository<ArrgOrderAllocationsV, java.math.BigDecimal>, JpaSpecificationExecutor<ArrgOrderAllocationsV> {

	@Query("select SUM(case when a.parentLineId is null then a.lineAmount end),SUM(a.vc),SUM(a.allocableAmount),SUM(a.fmvAmount),SUM(a.allocationAmount),SUM(a.allocationAmountFc),SUM(a.cvInOutAmount),SUM(case when a.parentLineId is null then a.extendedListAmount end),SUM(a.esp),SUM(a.espinst) from ArrgOrderAllocationsV a where   a.dealArrangementId=?1")
	List<Object[]> allocationTotals(BigDecimal pDealArragId);
	
	@Query("select ca from ArrgOrderAllocationsV ca where ca.dealArrangementId=?1")
	List<ArrgOrderAllocationsV> getAllocationsStatusByDealArrgId(BigDecimal dealArrangementId);

}
