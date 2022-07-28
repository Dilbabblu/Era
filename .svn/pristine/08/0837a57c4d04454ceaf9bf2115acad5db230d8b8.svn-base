package com.forsys.revmantra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.RmanPobMapping;

@RepositoryRestResource(collectionResourceRel = "RMAN_POB_MAPPING", path = "RMAN_POB_MAPPING")
public interface RmanPobMappingRepository extends PagingAndSortingRepository<RmanPobMapping, java.math.BigDecimal>, JpaRepository<RmanPobMapping, java.math.BigDecimal>, JpaSpecificationExecutor<RmanPobMapping> {

	RmanPobMapping findByStandaloneSubSkuAndParentSku(String childSku,String parentSku);
	RmanPobMapping findByAdditionalAttribute1IgnoreCase(String externalId);

}
