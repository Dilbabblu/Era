package com.forsys.revmantra.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.RmanOrderLinesBookingsV;

@RepositoryRestResource(collectionResourceRel = "RMAN_ORDER_LINES_BOOKINGS_V", path = "RMAN_ORDER_LINES_BOOKINGS_V")
public interface RmanOrderLinesBookingsVRepository
		extends PagingAndSortingRepository<RmanOrderLinesBookingsV, java.math.BigDecimal>,
		JpaRepository<RmanOrderLinesBookingsV, java.math.BigDecimal>,
		JpaSpecificationExecutor<RmanOrderLinesBookingsV> {

	@Procedure(name = "rman_deal_so_unlink_proc")
	void unlinksoLine(@Param("arrangementId") BigDecimal arrangementId, @Param("soLineId") BigDecimal soLineId,
			@Param("userId") BigDecimal loggedUserId);

	@Procedure(name = "rman_deal_so_link_proc")
	void linksoLine(@Param("arrangementId") BigDecimal arrangementId, @Param("soLineId") BigDecimal soLineId,
			@Param("dealNumber") String dealNumber, @Param("dealLineNumber") BigDecimal dealLineNumber,
			@Param("userId") BigDecimal loggedUserId);
	
	List<RmanOrderLinesBookingsV> findByArrangementIdAndSourceHeaderId(@Param("arrangementId") BigDecimal arrangementId,@Param("sourceHeaderId") String sourceHeaderId);

}
