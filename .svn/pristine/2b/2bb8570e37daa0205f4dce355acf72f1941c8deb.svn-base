package com.forsys.revmantra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.RmanRulesHeader;

@RepositoryRestResource(collectionResourceRel = "RMAN_RULES_HEADER", path = "RMAN_RULES_HEADER")
public interface RmanRulesHeaderRepository extends PagingAndSortingRepository<RmanRulesHeader, java.math.BigDecimal>, JpaRepository<RmanRulesHeader, java.math.BigDecimal>, JpaSpecificationExecutor<RmanRulesHeader> {

    RmanRulesHeader findByRuleNameIgnoreCase(String ruleName);
    RmanRulesHeader findByAttribute27IgnoreCase(String externalId);
    
}
