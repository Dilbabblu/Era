package com.forsys.revmantra.repositories;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.RmanDealArrangements;

@RepositoryRestResource(collectionResourceRel = "RMAN_DEAL_ARRANGEMENTS", path = "RMAN_DEAL_ARRANGEMENTS")
public interface RmanDealArrangementsRepository
		extends PagingAndSortingRepository<RmanDealArrangements, java.math.BigDecimal>,
		JpaRepository<RmanDealArrangements, java.math.BigDecimal>, JpaSpecificationExecutor<RmanDealArrangements> {

	RmanDealArrangements findByDealArrangementId(BigDecimal id);
	RmanDealArrangements findByDealArrangementNumber(String dealArrgNumber);
	RmanDealArrangements findByDealArrangementKey(String dealArrgKey);
	
	RmanDealArrangements findByAttribute11(String processInstanceId); //Fetch the Record based on Process Instance Id
	
	@Query("select dealArrangementBasis from RmanDealArrangements where dealArrangementId= ?1")
	String getByDealArrangementId(BigDecimal arrgId);

}
