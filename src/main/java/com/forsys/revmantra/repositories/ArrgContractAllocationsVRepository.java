package com.forsys.revmantra.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.ArrgContractAllocationsV;

@RepositoryRestResource(collectionResourceRel = "ARRG_CONTRACT_ALLOCATIONS_V", path = "ARRG_CONTRACT_ALLOCATIONS_V")
public interface ArrgContractAllocationsVRepository extends PagingAndSortingRepository<ArrgContractAllocationsV, java.math.BigDecimal>, JpaRepository<ArrgContractAllocationsV, java.math.BigDecimal>, JpaSpecificationExecutor<ArrgContractAllocationsV> {

	@Query("select SUM(case when a.parentLineId is null then a.lineAmount end),SUM(a.vc),SUM(a.allocableAmount),SUM(a.fmvAmount),SUM(a.allocationAmount),SUM(a.allocationAmountFc),SUM(a.cvInOutAmount),SUM(case when a.parentLineId is null then a.extendedListAmount end),SUM(a.esp),SUM(a.espinst) from ArrgContractAllocationsV a where   a.dealArrangementId=?1")
	List<Object[]> allocationTotals(BigDecimal pDealArragId);
	
	@Query("select ca from ArrgContractAllocationsV ca where ca.dealNumber in (:orders)")
	List<ArrgContractAllocationsV> getAllocations(@Param("orders") List<BigDecimal> orderNumbers);
	
	@Query("select ca from ArrgContractAllocationsV ca where ca.dealArrangementId=?1")
	List<ArrgContractAllocationsV> getAllocationsStatusByDealArrgId(BigDecimal dealArrangementId);

}
