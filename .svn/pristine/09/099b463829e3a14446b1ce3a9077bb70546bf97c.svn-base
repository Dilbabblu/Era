package com.forsys.revmantra.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.RmanProductsFileArchive;

@RepositoryRestResource(collectionResourceRel = "RMAN_PRODUCTS_FILE_ARCHIVE", path = "RMAN_PRODUCTS_FILE_ARCHIVE")
public interface RmanProductsFileArchiveRepository extends PagingAndSortingRepository<RmanProductsFileArchive, java.math.BigDecimal>, JpaRepository<RmanProductsFileArchive, java.math.BigDecimal>, JpaSpecificationExecutor<RmanProductsFileArchive> {

	 List<RmanProductsFileArchive> findByGroupId(String groupId);


}
