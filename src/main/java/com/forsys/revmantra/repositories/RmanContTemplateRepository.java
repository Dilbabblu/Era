package com.forsys.revmantra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.RmanContTemplate;

@RepositoryRestResource(collectionResourceRel = "RMAN_CONT_TEMPLATE", path = "RMAN_CONT_TEMPLATE")
public interface RmanContTemplateRepository extends PagingAndSortingRepository<RmanContTemplate, java.math.BigDecimal>, JpaRepository<RmanContTemplate, java.math.BigDecimal>, JpaSpecificationExecutor<RmanContTemplate> {

    

}
