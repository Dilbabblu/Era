package com.forsys.revmantra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.RmanContHeader;

@RepositoryRestResource(collectionResourceRel = "RMAN_CONT_HEADER", path = "RMAN_CONT_HEADER")
public interface RmanContHeaderRepository extends PagingAndSortingRepository<RmanContHeader, java.math.BigDecimal>,
		JpaRepository<RmanContHeader, java.math.BigDecimal>, JpaSpecificationExecutor<RmanContHeader> {

	RmanContHeader findByRuleName(String ruleName);

}
