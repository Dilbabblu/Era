package com.forsys.revmantra.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.RmanUsageSummaryInterface;

@RepositoryRestResource(collectionResourceRel = "RMAN_USAGE_SUMMARY_INTERFACE", path = "RMAN_USAGE_SUMMARY_INTERFACE")
public interface RmanUsageSummaryInterfaceRepository extends PagingAndSortingRepository<RmanUsageSummaryInterface, java.math.BigDecimal>, JpaRepository<RmanUsageSummaryInterface, java.math.BigDecimal>, JpaSpecificationExecutor<RmanUsageSummaryInterface> {

    List<RmanUsageSummaryInterface> findByInterfaceStatusAndInterfaceProcessId(String status, BigDecimal batchId);
    
    @Query(value = "SELECT SF_USAGE_SUMMARY_ID,ERROR_MESSAGE FROM RMAN_USAGE_SUMMARY_INTERFACE "
    		+ "WHERE INTERFACE_STATUS='E' AND INTERFACE_PROCESS_ID=:batchId", nativeQuery = true)
    List<Object[]> getFailedUsageSummaries(@Param("batchId") BigDecimal batchId);

}
