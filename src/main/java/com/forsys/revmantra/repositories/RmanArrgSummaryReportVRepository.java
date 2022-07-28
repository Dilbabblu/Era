package com.forsys.revmantra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.RmanArrgSummaryReportV;

@RepositoryRestResource(collectionResourceRel = "RMAN_ARRG_SUMMARY_REPORT_V", path = "RMAN_ARRG_SUMMARY_REPORT_V")
public interface RmanArrgSummaryReportVRepository extends PagingAndSortingRepository<RmanArrgSummaryReportV, java.math.BigDecimal>, JpaRepository<RmanArrgSummaryReportV, java.math.BigDecimal>, JpaSpecificationExecutor<RmanArrgSummaryReportV> {

    

}
