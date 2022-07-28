package com.forsys.revmantra.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.RmanSspOrdersFileArchive;

@RepositoryRestResource(collectionResourceRel = "RMAN_SSP_ORDERS_FILE_ARCHIVE", path = "RMAN_SSP_ORDERS_FILE_ARCHIVE")
public interface RmanSspOrdersFileArchiveRepository extends PagingAndSortingRepository<RmanSspOrdersFileArchive, java.math.BigDecimal>, JpaRepository<RmanSspOrdersFileArchive, java.math.BigDecimal>, JpaSpecificationExecutor<RmanSspOrdersFileArchive> {

	List<RmanSspOrdersFileArchive> findByGroupId(String groupId);

}
