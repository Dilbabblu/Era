package com.forsys.revmantra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.RmanUsageSummaryDetails;

@RepositoryRestResource(collectionResourceRel = "RMAN_USAGE_SUMMARY_DETAILS", path = "RMAN_USAGE_SUMMARY_DETAILS")
public interface RmanUsageSummaryDetailsRepository extends PagingAndSortingRepository<RmanUsageSummaryDetails, java.math.BigDecimal>, JpaRepository<RmanUsageSummaryDetails, java.math.BigDecimal>, JpaSpecificationExecutor<RmanUsageSummaryDetails> {

    

}
