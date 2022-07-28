package com.forsys.revmantra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.RmanContSourceLov;

@RepositoryRestResource(collectionResourceRel = "RMAN_CONT_SOURCE_LOV", path = "RMAN_CONT_SOURCE_LOV")
public interface RmanContSourceLovRepository extends PagingAndSortingRepository<RmanContSourceLov, java.math.BigDecimal>, JpaRepository<RmanContSourceLov, java.math.BigDecimal>, JpaSpecificationExecutor<RmanContSourceLov> {

    

}
