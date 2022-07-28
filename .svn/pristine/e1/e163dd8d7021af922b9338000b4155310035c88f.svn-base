package com.forsys.revmantra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.RmanEntityParametersV;

@RepositoryRestResource(collectionResourceRel = "RMAN_ENTITY_PARAMETERS_V", path = "RMAN_ENTITY_PARAMETERS_V")
public interface RmanEntityParametersVRepository extends PagingAndSortingRepository<RmanEntityParametersV, java.math.BigDecimal>, JpaRepository<RmanEntityParametersV, java.math.BigDecimal>, JpaSpecificationExecutor<RmanEntityParametersV> {

	RmanEntityParametersV findByEntityCategoryAndParameterName(String entityCategory,String parameterName);

}
