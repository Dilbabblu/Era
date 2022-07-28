package com.forsys.revmantra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.RmanDealGmAsv;

@RepositoryRestResource(collectionResourceRel = "RMAN_DEAL_GM_ASV", path = "RMAN_DEAL_GM_ASV")
public interface RmanDealGmAsvRepository extends PagingAndSortingRepository<RmanDealGmAsv, java.math.BigDecimal>, JpaRepository<RmanDealGmAsv, java.math.BigDecimal>, JpaSpecificationExecutor<RmanDealGmAsv> {

    

}
