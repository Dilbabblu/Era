package com.forsys.revmantra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.RmanOrdersAuditV;

@RepositoryRestResource(collectionResourceRel = "RMAN_ORDERS_AUDIT_V", path = "RMAN_ORDERS_AUDIT_V")
public interface RmanOrdersAuditVRepository extends PagingAndSortingRepository<RmanOrdersAuditV, java.math.BigDecimal>, JpaRepository<RmanOrdersAuditV, java.math.BigDecimal>, JpaSpecificationExecutor<RmanOrdersAuditV> {

    

}
