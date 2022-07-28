package com.forsys.revmantra.repositories;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.RmanResponsibilities;

@RepositoryRestResource(collectionResourceRel = "RMAN_RESPONSIBILITIES", path = "RMAN_RESPONSIBILITIES")
public interface RmanResponsibilitiesRepository extends PagingAndSortingRepository<RmanResponsibilities, java.math.BigDecimal>, JpaRepository<RmanResponsibilities, java.math.BigDecimal>, JpaSpecificationExecutor<RmanResponsibilities> {

	RmanResponsibilities findByResponsibilityName(String responsibilityName);
	RmanResponsibilities findByResponsibilityId(BigDecimal responsibilityId);

}
