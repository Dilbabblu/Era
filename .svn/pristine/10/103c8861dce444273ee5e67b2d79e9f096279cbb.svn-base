package com.forsys.revmantra.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.RmanDealRfcstV;

@RepositoryRestResource(collectionResourceRel = "RMAN_DEAL_RFCST_V", path = "RMAN_DEAL_RFCST_V")
public interface RmanDealRfcstVRepository extends PagingAndSortingRepository<RmanDealRfcstV, java.math.BigDecimal>, JpaRepository<RmanDealRfcstV, java.math.BigDecimal>, JpaSpecificationExecutor<RmanDealRfcstV> {

    List<RmanDealRfcstV> findByArrangementId(java.math.BigDecimal arrgId);

}
