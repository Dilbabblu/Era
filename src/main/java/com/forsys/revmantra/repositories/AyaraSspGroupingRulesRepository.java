package com.forsys.revmantra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.AyaraSspGroupingRules;

@RepositoryRestResource(collectionResourceRel = "AYARA_SSP_GROUPING_RULES", path = "AYARA_SSP_GROUPING_RULES")
public interface AyaraSspGroupingRulesRepository extends PagingAndSortingRepository<AyaraSspGroupingRules, java.math.BigDecimal>, JpaRepository<AyaraSspGroupingRules, java.math.BigDecimal>, JpaSpecificationExecutor<AyaraSspGroupingRules> {

    

}
