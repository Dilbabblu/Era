package com.forsys.revmantra.listener;

import java.sql.Timestamp;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.forsys.revmantra.model.RmanFcBuckets;

public class RmanFcBucketsListener {

	/**
	 * automatic property set before any database persistence
	 */
	@PrePersist
	public void prePersist(RmanFcBuckets rmanFcBuckets) {

		rmanFcBuckets.setStartDate(new Timestamp(System.currentTimeMillis()));
		rmanFcBuckets.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		rmanFcBuckets.setCreatedBy(BaseListener.getCurrentUserId());
		rmanFcBuckets.setLastUpdatedDate(new Timestamp(System.currentTimeMillis()));
		rmanFcBuckets.setLastUpdatedBy(BaseListener.getCurrentUserId());
		rmanFcBuckets.setVersion(new java.math.BigDecimal(1));

	}

	@PreUpdate
	public void preUpdate(RmanFcBuckets rmanFcBuckets) {

		rmanFcBuckets.setLastUpdatedDate(new Timestamp(System.currentTimeMillis()));
		rmanFcBuckets.setLastUpdatedBy(BaseListener.getCurrentUserId());

	}

}
