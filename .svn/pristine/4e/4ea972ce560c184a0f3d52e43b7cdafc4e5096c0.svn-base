package com.forsys.revmantra.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.RmanFmvRulesDef;

@RepositoryRestResource(collectionResourceRel = "RMAN_FMV_RULES_DEF", path = "RMAN_FMV_RULES_DEF")
public interface RmanFmvRulesDefRepository extends PagingAndSortingRepository<RmanFmvRulesDef, java.math.BigDecimal>,
		JpaRepository<RmanFmvRulesDef, java.math.BigDecimal>, JpaSpecificationExecutor<RmanFmvRulesDef> {

	public List<RmanFmvRulesDef> findByFmvRuleNameIgnoreCase(String name);
	
	RmanFmvRulesDef findByAdditionalAttribute1IgnoreCase(String externalId);

}
