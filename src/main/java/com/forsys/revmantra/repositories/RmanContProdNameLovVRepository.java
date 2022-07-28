package com.forsys.revmantra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.RmanContProdNameLovV;

@RepositoryRestResource(collectionResourceRel = "RMAN_CONT_PROD_NAME_LOV_V", path = "RMAN_CONT_PROD_NAME_LOV_V")
public interface RmanContProdNameLovVRepository extends PagingAndSortingRepository<RmanContProdNameLovV, java.math.BigDecimal>, JpaRepository<RmanContProdNameLovV, java.math.BigDecimal>, JpaSpecificationExecutor<RmanContProdNameLovV> {

    

}
