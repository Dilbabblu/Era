package com.forsys.revmantra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.RmanArrgLineOfBusinessV;

@RepositoryRestResource(collectionResourceRel = "RMAN_ARRG_LINE_OF_BUSINESS_V", path = "RMAN_ARRG_LINE_OF_BUSINESS_V")
public interface RmanArrgLineOfBusinessVRepository extends PagingAndSortingRepository<RmanArrgLineOfBusinessV, java.math.BigDecimal>, JpaRepository<RmanArrgLineOfBusinessV, java.math.BigDecimal>, JpaSpecificationExecutor<RmanArrgLineOfBusinessV> {

    

}
