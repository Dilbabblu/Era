package com.forsys.revmantra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.RmanContLinkTemplateV;

@RepositoryRestResource(collectionResourceRel = "RMAN_CONT_LINK_TEMPLATE_V", path = "RMAN_CONT_LINK_TEMPLATE_V")
public interface RmanContLinkTemplateVRepository extends PagingAndSortingRepository<RmanContLinkTemplateV, java.math.BigDecimal>, JpaRepository<RmanContLinkTemplateV, java.math.BigDecimal>, JpaSpecificationExecutor<RmanContLinkTemplateV> {

    

}
