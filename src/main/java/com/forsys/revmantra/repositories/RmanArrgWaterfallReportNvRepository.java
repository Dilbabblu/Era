package com.forsys.revmantra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.RmanArrgWaterfallReportNv;

@RepositoryRestResource(collectionResourceRel = "RMAN_ARRG_WATERFALL_REPORT_NV", path = "RMAN_ARRG_WATERFALL_REPORT_NV")
public interface RmanArrgWaterfallReportNvRepository extends PagingAndSortingRepository<RmanArrgWaterfallReportNv, java.math.BigDecimal>, JpaRepository<RmanArrgWaterfallReportNv, java.math.BigDecimal>, JpaSpecificationExecutor<RmanArrgWaterfallReportNv> {

    

}
