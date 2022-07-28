package com.forsys.revmantra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.RmanOrders;

@RepositoryRestResource(collectionResourceRel = "RMAN_ORDERS", path = "RMAN_ORDERS")
public interface RmanOrdersRepository extends PagingAndSortingRepository<RmanOrders, java.math.BigDecimal>, JpaRepository<RmanOrders, java.math.BigDecimal>, JpaSpecificationExecutor<RmanOrders> {

    

}
