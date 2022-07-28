package com.forsys.revmantra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.RmanDealHeaders;

@RepositoryRestResource(collectionResourceRel = "RMAN_DEAL_HEADERS", path = "RMAN_DEAL_HEADERS")
public interface RmanDealHeadersRepository extends PagingAndSortingRepository<RmanDealHeaders, java.math.BigDecimal>, JpaRepository<RmanDealHeaders, java.math.BigDecimal>, JpaSpecificationExecutor<RmanDealHeaders> {

    
	RmanDealHeaders findByDealArrangementId(java.math.BigDecimal id);
	RmanDealHeaders findByDealNumber(String dealArrgNumber);
}
