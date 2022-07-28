package com.forsys.revmantra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.RmanRevenueTemplates;

@RepositoryRestResource(collectionResourceRel = "RMAN_REVENUE_TEMPLATES", path = "RMAN_REVENUE_TEMPLATES")
public interface RmanRevenueTemplatesRepository extends PagingAndSortingRepository<RmanRevenueTemplates, java.math.BigDecimal>, JpaRepository<RmanRevenueTemplates, java.math.BigDecimal>, JpaSpecificationExecutor<RmanRevenueTemplates> {

	RmanRevenueTemplates findByTemplateNameIgnoreCase(String templateName);
	RmanRevenueTemplates findByAdditionalAttribute1IgnoreCase(String externalId);

}
