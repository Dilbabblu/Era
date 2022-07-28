package com.forsys.revmantra.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.RmanFiscalPeriodsInterface;

@RepositoryRestResource(collectionResourceRel = "RMAN_FISCAL_PERIODS_INTERFACE", path = "RMAN_FISCAL_PERIODS_INTERFACE")
public interface RmanFiscalPeriodsInterfaceRepository extends PagingAndSortingRepository<RmanFiscalPeriodsInterface, java.lang.String>, JpaRepository<RmanFiscalPeriodsInterface, java.lang.String>, JpaSpecificationExecutor<RmanFiscalPeriodsInterface> {
	List<RmanFiscalPeriodsInterface> findByInterfaceStatusAndInterfaceProcessId(String status, BigDecimal processId);
}
