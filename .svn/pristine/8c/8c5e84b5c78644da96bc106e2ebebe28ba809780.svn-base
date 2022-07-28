package com.forsys.revmantra.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.AyaraApprovalRules;

@RepositoryRestResource(collectionResourceRel = "AYARA_APPROVAL_RULES", path = "AYARA_APPROVAL_RULES")
public interface AyaraApprovalRulesRepository extends PagingAndSortingRepository<AyaraApprovalRules, java.math.BigDecimal>,JpaRepository<AyaraApprovalRules, BigDecimal>,JpaSpecificationExecutor<AyaraApprovalRules> {
	
	List<AyaraApprovalRules> findByEntityId(BigDecimal legalEntityId);
	
	List<AyaraApprovalRules> findByEntityIdAndActiveFlagOrderByRankingAsc(BigDecimal legalEntityId,String activeFlag);
	
	AyaraApprovalRules findByEntityIdAndActiveFlagAndRankingOrderByRankingAsc(BigDecimal legalEntityId,String activeFlag,String ranking);
	
	AyaraApprovalRules findByRuleId(BigDecimal ruleId);
	
	AyaraApprovalRules findByEntityIdAndRanking(BigDecimal entityId,BigDecimal ranking);
	
}
