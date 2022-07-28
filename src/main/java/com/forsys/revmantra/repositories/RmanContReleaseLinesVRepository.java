package com.forsys.revmantra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.RmanContReleaseLinesV;

@RepositoryRestResource(collectionResourceRel = "RMAN_CONT_RELEASE_LINES_V", path = "RMAN_CONT_RELEASE_LINES_V")
public interface RmanContReleaseLinesVRepository extends PagingAndSortingRepository<RmanContReleaseLinesV, java.math.BigDecimal>, JpaRepository<RmanContReleaseLinesV, java.math.BigDecimal>, JpaSpecificationExecutor<RmanContReleaseLinesV> {

    

}
