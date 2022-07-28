package com.forsys.revmantra.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.RmanProductsInterface;

@RepositoryRestResource(collectionResourceRel = "RMAN_PRODUCTS_INTERFACE", path = "RMAN_PRODUCTS_INTERFACE")
public interface RmanProductsInterfaceRepository
		extends PagingAndSortingRepository<RmanProductsInterface, java.math.BigDecimal>,
		JpaRepository<RmanProductsInterface, java.math.BigDecimal>, JpaSpecificationExecutor<RmanProductsInterface> {

	List<RmanProductsInterface> findByInterfaceStatusAndInterfaceProcessId(String status, BigDecimal processId);

}
