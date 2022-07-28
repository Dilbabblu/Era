package com.forsys.revmantra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.RmanFmvRulesDefParaValue;

@RepositoryRestResource(collectionResourceRel = "RMAN_FMV_RULES_DEF_PARA_VALUE", path = "RMAN_FMV_RULES_DEF_PARA_VALUE")
public interface RmanFmvRulesDefParaValueRepository extends PagingAndSortingRepository<RmanFmvRulesDefParaValue, java.math.BigDecimal>, JpaRepository<RmanFmvRulesDefParaValue, java.math.BigDecimal>, JpaSpecificationExecutor<RmanFmvRulesDefParaValue> {

	RmanFmvRulesDefParaValue findByAdditionalAttribute1IgnoreCase(String externalId);

}
