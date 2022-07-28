package com.forsys.revmantra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.RmanDefRollforwardReportV;

@RepositoryRestResource(collectionResourceRel = "RMAN_DEF_ROLLFORWARD_REPORT_V", path = "RMAN_DEF_ROLLFORWARD_REPORT_V")
public interface RmanDefRollforwardReportVRepository extends PagingAndSortingRepository<RmanDefRollforwardReportV, java.math.BigDecimal>, JpaRepository<RmanDefRollforwardReportV, java.math.BigDecimal>, JpaSpecificationExecutor<RmanDefRollforwardReportV> {


}
