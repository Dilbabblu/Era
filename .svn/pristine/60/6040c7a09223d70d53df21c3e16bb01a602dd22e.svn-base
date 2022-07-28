package com.forsys.revmantra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.RmanRuleParameterValue;

@RepositoryRestResource(collectionResourceRel = "RMAN_RULE_PARAMETER_VALUE", path = "RMAN_RULE_PARAMETER_VALUE")
public interface RmanRuleParameterValueRepository extends PagingAndSortingRepository<RmanRuleParameterValue, java.math.BigDecimal>, JpaRepository<RmanRuleParameterValue, java.math.BigDecimal>, JpaSpecificationExecutor<RmanRuleParameterValue> {

	RmanRuleParameterValue findByAttribute28IgnoreCase(String externalId);

}
