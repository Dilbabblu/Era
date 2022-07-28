package com.forsys.revmantra.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.cpk.id.RmanContLinkedtemplatesId;
import com.forsys.revmantra.model.RmanContLinkedTemplateSv;

@RepositoryRestResource(collectionResourceRel = "RMAN_CONT_LINKED_TEMPLATE_SV", path = "RMAN_CONT_LINKED_TEMPLATE_SV")
public interface RmanContLinkedTemplateSvRepository extends PagingAndSortingRepository<RmanContLinkedTemplateSv, RmanContLinkedtemplatesId>, JpaRepository<RmanContLinkedTemplateSv, RmanContLinkedtemplatesId>, JpaSpecificationExecutor<RmanContLinkedTemplateSv> {

   List<RmanContLinkedTemplateSv> findByRuleHeaderId(BigDecimal ruleHeaderId);
   
}
