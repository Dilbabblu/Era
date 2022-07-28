package com.forsys.revmantra.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.RmanCustomersFileArchive;

@RepositoryRestResource(collectionResourceRel = "RMAN_CUSTOMERS_FILE_ARCHIVE", path = "RMAN_CUSTOMERS_FILE_ARCHIVE")
public interface RmanCustomersFileArchiveRepository extends PagingAndSortingRepository<RmanCustomersFileArchive, java.math.BigDecimal>, JpaRepository<RmanCustomersFileArchive, java.math.BigDecimal>, JpaSpecificationExecutor<RmanCustomersFileArchive> {

    List<RmanCustomersFileArchive> findByProcessId(String groupId);

}
