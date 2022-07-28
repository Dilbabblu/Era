package com.forsys.revmantra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.RmanDzsGlAccountingV;

@RepositoryRestResource(collectionResourceRel = "RMAN_DZS_GL_ACCOUNTING_V", path = "RMAN_DZS_GL_ACCOUNTING_V")
public interface RmanDzsGlAccountingVRepository
		extends PagingAndSortingRepository<RmanDzsGlAccountingV, java.math.BigDecimal>,
		JpaRepository<RmanDzsGlAccountingV, java.math.BigDecimal>, JpaSpecificationExecutor<RmanDzsGlAccountingV> {

}
