package com.forsys.revmantra.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.cpk.id.RmanUserResponsibilitiesPk;
import com.forsys.revmantra.model.RmanUserResponsibilities;

@RepositoryRestResource(collectionResourceRel = "RMAN_USER_RESPONSIBILITIES", path = "RMAN_USER_RESPONSIBILITIES")
public interface RmanUserResponsibilitiesRepository extends PagingAndSortingRepository<RmanUserResponsibilities, RmanUserResponsibilitiesPk>, JpaRepository<RmanUserResponsibilities, RmanUserResponsibilitiesPk>, JpaSpecificationExecutor<RmanUserResponsibilities> {
	
	List<RmanUserResponsibilities> findByRmanUserId(BigDecimal userId);
	List<RmanUserResponsibilities> findByResponsibilityId(BigDecimal responsibilityId);
}
