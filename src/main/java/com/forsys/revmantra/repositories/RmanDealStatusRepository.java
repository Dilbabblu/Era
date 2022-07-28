package com.forsys.revmantra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.RmanDealStatus;

@RepositoryRestResource(collectionResourceRel = "RMAN_DEAL_STATUS", path = "RMAN_DEAL_STATUS")
public interface RmanDealStatusRepository extends PagingAndSortingRepository<RmanDealStatus, java.math.BigDecimal>,
		JpaRepository<RmanDealStatus, java.math.BigDecimal>, JpaSpecificationExecutor<RmanDealStatus> {
	RmanDealStatus findByDealHeaderId(java.math.BigDecimal dealHeaderId);
	RmanDealStatus findByDealArrangementNumber(String arrgId);
}
