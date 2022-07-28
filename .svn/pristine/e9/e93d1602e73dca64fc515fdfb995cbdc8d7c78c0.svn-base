package com.forsys.revmantra.repositories;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.RmanContTransToRelease;

@RepositoryRestResource(collectionResourceRel = "RMAN_CONT_TRANS_TO_RELEASE", path = "RMAN_CONT_TRANS_TO_RELEASE")
public interface RmanContTransToReleaseRepository
		extends PagingAndSortingRepository<RmanContTransToRelease, java.math.BigDecimal>,
		JpaRepository<RmanContTransToRelease, java.math.BigDecimal>, JpaSpecificationExecutor<RmanContTransToRelease> {

	@Procedure(name = "rman_cont_insert_release_line_proc")
	void callRmanContInsertReleaseLine(@Param("transHeaderId") BigDecimal transHeaderId,
			@Param("transLineId") BigDecimal transLineId);

	@Query(value = "SELECT CHECK_OPEN_LINE_EXISTS(:transLineId) FROM dual", nativeQuery = true)
	String checkOpenLineExists(@Param("transLineId") BigDecimal transLineId);

	RmanContTransToRelease findByTransLineId(BigDecimal transLineId);

}
