package com.forsys.revmantra.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.RmanBookedOrdersArchive;

@RepositoryRestResource(collectionResourceRel = "RMAN_BOOKED_ORDERS_ARCHIVE", path = "RMAN_BOOKED_ORDERS_ARCHIVE")
public interface RmanBookedOrdersArchiveRepository extends PagingAndSortingRepository<RmanBookedOrdersArchive, java.math.BigDecimal>, JpaRepository<RmanBookedOrdersArchive, java.math.BigDecimal>, JpaSpecificationExecutor<RmanBookedOrdersArchive> {

    List<RmanBookedOrdersArchive> findByGroupId(String groupId);

}
