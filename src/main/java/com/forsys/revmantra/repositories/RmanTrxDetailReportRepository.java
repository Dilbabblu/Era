package com.forsys.revmantra.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.RmanTrxDetailReport;

@RepositoryRestResource(collectionResourceRel = "RMAN_TRX_DETAIL_REPORT", path = "RMAN_TRX_DETAIL_REPORT")
public interface RmanTrxDetailReportRepository
		extends PagingAndSortingRepository<RmanTrxDetailReport, java.math.BigDecimal>,
		JpaRepository<RmanTrxDetailReport, java.math.BigDecimal>, JpaSpecificationExecutor<RmanTrxDetailReport> {

	@Query("select t from RmanTrxDetailReport t " + " where (:p_po_num is null or po=:p_po_num)")
	Page<RmanTrxDetailReport> trxDetailsReportData(@Param("p_po_num") String po, Pageable pageRequest);

}
