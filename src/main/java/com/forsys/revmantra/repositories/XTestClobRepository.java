package com.forsys.revmantra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.XTestClob;

@RepositoryRestResource(collectionResourceRel = "JSON_DOCUMENTS", path = "JSON_DOCUMENTS")
public interface XTestClobRepository
		extends PagingAndSortingRepository<XTestClob, java.math.BigDecimal>,
		JpaRepository<XTestClob, java.math.BigDecimal>, JpaSpecificationExecutor<XTestClob> {

}