package com.forsys.revmantra.repositories;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.RmanProducts;

@RepositoryRestResource(collectionResourceRel = "RMAN_PRODUCTS", path = "RMAN_PRODUCTS")
public interface RmanProductsRepository extends PagingAndSortingRepository<RmanProducts, java.math.BigDecimal>,
		JpaRepository<RmanProducts, java.math.BigDecimal>, JpaSpecificationExecutor<RmanProducts> {
	RmanProducts findByProductNameIgnoreCaseAndProductOrgId(String productName,BigDecimal productOrgId);
	RmanProducts findByProductNameIgnoreCase(String productName);
	RmanProducts findByAdditionalAttribute1IgnoreCase(String externalId);
}
