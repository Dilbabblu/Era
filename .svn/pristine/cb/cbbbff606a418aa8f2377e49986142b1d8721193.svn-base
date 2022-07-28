package com.forsys.revmantra.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.RmanOrderBookingsV;

@RepositoryRestResource(collectionResourceRel = "RMAN_ORDER_BOOKINGS_V", path = "RMAN_ORDER_BOOKINGS_V")
public interface RmanOrderBookingsVRepository extends PagingAndSortingRepository<RmanOrderBookingsV, java.math.BigDecimal>, JpaRepository<RmanOrderBookingsV, java.math.BigDecimal>, JpaSpecificationExecutor<RmanOrderBookingsV> {

    List<RmanOrderBookingsV> findByArrangementId(BigDecimal arrangementId);

}
