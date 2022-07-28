package com.forsys.revmantra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.RmanDealDetails;

@RepositoryRestResource(collectionResourceRel = "RMAN_DEAL_DETAILS", path = "RMAN_DEAL_DETAILS")
public interface RmanDealDetailsRepository extends PagingAndSortingRepository<RmanDealDetails, java.math.BigDecimal>,
		JpaRepository<RmanDealDetails, java.math.BigDecimal>, JpaSpecificationExecutor<RmanDealDetails> {
	
	/*
	 * RmanDealDetails save(RmanDealDetails rmanDealDetails);
	 * 
	 * @Query("select SUM(case when a.parentLineId is null then a.extendedSellingAmount end) from RmanDealDetails a where   a.dealArrangementId=?1"
	 * ) BigDecimal arrangementTotal(BigDecimal pDealArragId);
	 */
	
}
