package com.forsys.revmantra.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.RmanCustomersInterface;

@RepositoryRestResource(collectionResourceRel = "RMAN_CUSTOMERS_INTERFACE", path = "RMAN_CUSTOMERS_INTERFACE")
public interface RmanCustomersInterfaceRepository
		extends PagingAndSortingRepository<RmanCustomersInterface, java.math.BigDecimal>,
		JpaRepository<RmanCustomersInterface, java.math.BigDecimal>, JpaSpecificationExecutor<RmanCustomersInterface> {

	List<RmanCustomersInterface> findByAttribute23AndAttribute24(String status, String processId);

}
