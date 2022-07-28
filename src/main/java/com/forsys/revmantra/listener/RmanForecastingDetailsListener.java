package com.forsys.revmantra.listener;

import java.sql.Timestamp;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.forsys.revmantra.model.RmanForecastingDetails;

public class RmanForecastingDetailsListener {

	/**
	 * automatic property set before any database persistence
	 */
	@PrePersist
	public void prePersist(RmanForecastingDetails rmanForecastingDetails) {
		rmanForecastingDetails.setCreatedBy(BaseListener.getCurrentUserId());
		rmanForecastingDetails.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		rmanForecastingDetails.setLastUpdatedBy(BaseListener.getCurrentUserId());
		rmanForecastingDetails.setLastUpdatedDate(new Timestamp(System.currentTimeMillis()));
	}

	@PreUpdate
	public void preUpdate(RmanForecastingDetails rmanForecastingDetails) {
		rmanForecastingDetails.setLastUpdatedBy(BaseListener.getCurrentUserId());
		rmanForecastingDetails.setLastUpdatedDate(new Timestamp(System.currentTimeMillis()));
	}

}
