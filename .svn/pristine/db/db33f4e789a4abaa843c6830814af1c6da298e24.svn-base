package com.forsys.revmantra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.RmanCustomers;

@RepositoryRestResource(collectionResourceRel = "RMAN_CUSTOMERS", path = "RMAN_CUSTOMERS")
public interface RmanCustomersRepository extends PagingAndSortingRepository<RmanCustomers, java.math.BigDecimal>, JpaRepository<RmanCustomers, java.math.BigDecimal>, JpaSpecificationExecutor<RmanCustomers> {

	RmanCustomers findByCustomerNumber(String cutomerNumber);
	RmanCustomers findByAdditionalAttribute1(String externalId);
}
