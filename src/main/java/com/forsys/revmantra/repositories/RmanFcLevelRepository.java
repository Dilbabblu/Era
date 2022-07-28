package com.forsys.revmantra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.RmanFcLevel;

@RepositoryRestResource(collectionResourceRel = "RMAN_FC_LEVEL", path = "RMAN_FC_LEVEL")
public interface RmanFcLevelRepository extends PagingAndSortingRepository<RmanFcLevel, java.math.BigDecimal>, JpaRepository<RmanFcLevel, java.math.BigDecimal>, JpaSpecificationExecutor<RmanFcLevel> {

    

}
