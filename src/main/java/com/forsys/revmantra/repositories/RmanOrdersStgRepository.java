package com.forsys.revmantra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.RmanOrdersStg;

@RepositoryRestResource(collectionResourceRel = "RMAN_ORDERS_STG", path = "RMAN_ORDERS_STG")
public interface RmanOrdersStgRepository extends PagingAndSortingRepository<RmanOrdersStg, java.math.BigDecimal>,
		JpaRepository<RmanOrdersStg, java.math.BigDecimal>, JpaSpecificationExecutor<RmanOrdersStg> {
}
