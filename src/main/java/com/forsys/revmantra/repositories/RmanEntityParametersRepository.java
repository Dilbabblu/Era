package com.forsys.revmantra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.RmanEntityParameters;

@RepositoryRestResource(collectionResourceRel = "RMAN_ENTITY_PARAMETERS", path = "RMAN_ENTITY_PARAMETERS")
public interface RmanEntityParametersRepository extends PagingAndSortingRepository<RmanEntityParameters, java.math.BigDecimal>, JpaRepository<RmanEntityParameters, java.math.BigDecimal>, JpaSpecificationExecutor<RmanEntityParameters> {

    

}
