package com.forsys.revmantra.repositories;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.RmanInvoiceLinesInterface;

@RepositoryRestResource(collectionResourceRel = "RMAN_INVOICE_LINES_INTERFACE", path = "RMAN_INVOICE_LINES_INTERFACE")
public interface RmanInvoiceLinesInterfaceRepository extends PagingAndSortingRepository<RmanInvoiceLinesInterface, java.math.BigDecimal>, JpaRepository<RmanInvoiceLinesInterface, java.math.BigDecimal>, JpaSpecificationExecutor<RmanInvoiceLinesInterface> {

	List<RmanInvoiceLinesInterface> findByInterfaceStatusAndProcessId(String interfaceStatus,String processId);
	
	@Query(value = "SELECT ADDITIONAL_ATTRIBUTE5,ERROR_MESSAGE FROM RMAN_INVOICE_LINES_INTERFACE "
			+ "WHERE INTERFACE_STATUS = 'E' AND PROCESS_ID=:processId", nativeQuery = true)
	List<Object[]> getInvoiceFailedList(@Param("processId") String processId); 
	
	@Transactional
    void deleteBySourceInvoiceLineIdIn(List<BigDecimal> sourceInvoiceLineIds);

}
