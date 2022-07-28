package com.forsys.revmantra.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.SspRulesInterface;

@RepositoryRestResource(collectionResourceRel = "SSP_RULES_INTERFACE", path = "SSP_RULES_INTERFACE")
public interface SspRulesInterfaceRepository
		extends PagingAndSortingRepository<SspRulesInterface, java.math.BigDecimal>,
		JpaRepository<SspRulesInterface, java.math.BigDecimal>, JpaSpecificationExecutor<SspRulesInterface> {

	List<SspRulesInterface> findByProcessFlagAndProcessId(String processFlag, String processId);

}
