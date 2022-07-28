package com.forsys.revmantra.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.RmanGlAccountsInterface;

@RepositoryRestResource(collectionResourceRel = "RMAN_GL_ACCOUNTS_INTERFACE", path = "RMAN_GL_ACCOUNTS_INTERFACE")
public interface RmanGlAccountsInterfaceRepository
		extends PagingAndSortingRepository<RmanGlAccountsInterface, java.math.BigDecimal>,
		JpaRepository<RmanGlAccountsInterface, java.math.BigDecimal>,
		JpaSpecificationExecutor<RmanGlAccountsInterface> {

	List<RmanGlAccountsInterface> findByInterfaceStatusAndRequestId(String status, BigDecimal reqId);

}
