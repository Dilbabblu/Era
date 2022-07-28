package com.forsys.revmantra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.AyaraSspGroupingRuleDimensions;

@RepositoryRestResource(collectionResourceRel = "AYARA_SSP_GROUPING_RULE_DIMENSIONS", path = "AYARA_SSP_GROUPING_RULE_DIMENSIONS")
public interface AyaraSspGroupingRuleDimensionsRepository extends PagingAndSortingRepository<AyaraSspGroupingRuleDimensions, java.math.BigDecimal>, JpaRepository<AyaraSspGroupingRuleDimensions, java.math.BigDecimal>, JpaSpecificationExecutor<AyaraSspGroupingRuleDimensions> {

    

}
