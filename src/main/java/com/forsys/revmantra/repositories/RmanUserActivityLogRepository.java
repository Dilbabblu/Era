package com.forsys.revmantra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.RmanUserActivityLog;

@RepositoryRestResource(collectionResourceRel = "RMAN_USER_ACTIVITY_LOG", path = "RMAN_USER_ACTIVITY_LOG")
public interface RmanUserActivityLogRepository extends PagingAndSortingRepository<RmanUserActivityLog, java.math.BigDecimal>, JpaRepository<RmanUserActivityLog, java.math.BigDecimal>, JpaSpecificationExecutor<RmanUserActivityLog> {

    

}
