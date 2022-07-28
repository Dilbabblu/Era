package com.forsys.revmantra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.RmanAccountSetup;

@RepositoryRestResource(collectionResourceRel = "RMAN_ACCOUNT_SETUP", path = "RMAN_ACCOUNT_SETUP")
public interface RmanAccountSetupRepository extends PagingAndSortingRepository<RmanAccountSetup, java.math.BigDecimal>, JpaRepository<RmanAccountSetup, java.math.BigDecimal>, JpaSpecificationExecutor<RmanAccountSetup> {

	RmanAccountSetup findByAccountingStructure(String accountingStructure);
}
