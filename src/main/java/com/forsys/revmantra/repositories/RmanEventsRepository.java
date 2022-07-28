package com.forsys.revmantra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.RmanEvents;

@RepositoryRestResource(collectionResourceRel = "RMAN_EVENTS", path = "RMAN_EVENTS")
public interface RmanEventsRepository extends PagingAndSortingRepository<RmanEvents, java.math.BigInteger>,
		JpaRepository<RmanEvents, java.math.BigInteger>, JpaSpecificationExecutor<RmanEvents> {

}
