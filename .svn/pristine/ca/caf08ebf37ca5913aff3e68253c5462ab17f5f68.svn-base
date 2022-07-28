package com.forsys.revmantra.repositories;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.RmanForecastingDetails;

@RepositoryRestResource(collectionResourceRel = "RMAN_FORECASTING_DETAILS", path = "RMAN_FORECASTING_DETAILS")
public interface RmanForecastingDetailsRepository
		extends PagingAndSortingRepository<RmanForecastingDetails, java.lang.String>,
		JpaRepository<RmanForecastingDetails, java.lang.String>, JpaSpecificationExecutor<RmanForecastingDetails> {

	@Procedure(name = "populate_fc_details_proc")
	void enterForecastingDetails(@Param("arrId") BigDecimal arrId, @Param("fcLevel") BigDecimal fcLevel,
			@Param("fcBucket") BigDecimal fcBucket, @Param("fcMethod") BigDecimal fcMethod,
			@Param("fcStartDate") Timestamp fcStartDate,
			@Param("fcAllocFlag") String fcAllocFlag);

	@Procedure(name = "save_fc_distributions_proc")
	void saveForecastingDistributions(@Param("arrId") BigDecimal arrId, @Param("fcLevel") BigDecimal fcLevel,
			@Param("fcBucket") BigDecimal fcBucket, @Param("fcMethod") BigDecimal fcMethod,
			@Param("fcStartDate") Timestamp fcStartDate,@Param("fcAllocFlag") String fcAllocFlag);

}
