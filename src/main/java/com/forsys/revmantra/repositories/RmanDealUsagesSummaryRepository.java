package com.forsys.revmantra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.RmanDealUsagesSummary;

@RepositoryRestResource(collectionResourceRel = "RMAN_DEAL_USAGES_SUMMARY", path = "RMAN_DEAL_USAGES_SUMMARY")
public interface RmanDealUsagesSummaryRepository extends PagingAndSortingRepository<RmanDealUsagesSummary, java.math.BigDecimal>, JpaRepository<RmanDealUsagesSummary, java.math.BigDecimal>, JpaSpecificationExecutor<RmanDealUsagesSummary> {

    

}
