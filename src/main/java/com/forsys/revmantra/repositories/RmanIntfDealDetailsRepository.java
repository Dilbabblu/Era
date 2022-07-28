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

import com.forsys.revmantra.model.RmanIntfDealDetails;
import com.forsys.revmantra.model.RmanIntfUniqueRecord;

@RepositoryRestResource(collectionResourceRel = "RMAN_INTF_DEAL_DETAILS", path = "RMAN_INTF_DEAL_DETAILS")
public interface RmanIntfDealDetailsRepository extends PagingAndSortingRepository<RmanIntfDealDetails, RmanIntfUniqueRecord>, JpaRepository<RmanIntfDealDetails, RmanIntfUniqueRecord>, JpaSpecificationExecutor<RmanIntfDealDetails> {

    List<RmanIntfDealDetails> findByInterfaceStatusAndProcessId(String status,BigDecimal processId);
    
    List<RmanIntfDealDetails> findByDealNumberAndInterfaceStatus(String dealNumber,String status);
    
    @Query(value = "select source_line_ref_id,interface_error from RMAN_INTF_DEAL_DETAILS where INTERFACE_STATUS = 'E' and DEAL_NUMBER = :quoteNumber",nativeQuery = true)
    List<Object[]> getErrorList(@Param("quoteNumber") String quoteNumber);
   
    @Transactional
    void deleteByArrangementNumberIn(List<String> arrangementNumbers);
    
}
