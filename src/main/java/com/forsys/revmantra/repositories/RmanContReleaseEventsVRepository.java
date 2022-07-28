package com.forsys.revmantra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.RmanContReleaseEventsV;

@RepositoryRestResource(collectionResourceRel = "RMAN_CONT_RELEASE_EVENTS_V", path = "RMAN_CONT_RELEASE_EVENTS_V")
public interface RmanContReleaseEventsVRepository extends PagingAndSortingRepository<RmanContReleaseEventsV, java.math.BigDecimal>, JpaRepository<RmanContReleaseEventsV, java.math.BigDecimal>, JpaSpecificationExecutor<RmanContReleaseEventsV> {

    

}
