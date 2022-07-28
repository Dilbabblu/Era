package com.forsys.revmantra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.RmanLegalEntities;

@RepositoryRestResource(collectionResourceRel = "RMAN_LEGAL_ENTITIES", path = "RMAN_LEGAL_ENTITIES")
public interface RmanLegalEntitiesRepository
		extends PagingAndSortingRepository<RmanLegalEntities, java.math.BigDecimal>,
		JpaRepository<RmanLegalEntities, java.math.BigDecimal>, JpaSpecificationExecutor<RmanLegalEntities> {
	RmanLegalEntities findByNameIgnoreCase(String name);
	RmanLegalEntities findByAdditionalAttribute1(String externalId);
}
