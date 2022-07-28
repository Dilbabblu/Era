package com.forsys.revmantra.listener;

import java.sql.Timestamp;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.forsys.revmantra.model.RmanDealDetails;

public class RmanDealDetailsListener {

	/**
	 * automatic property set before any database persistence
	 */
	@PrePersist
	public void prePersist(RmanDealDetails rmanDealDetails) {
		rmanDealDetails.setLastUpdatedDate(new Timestamp(System.currentTimeMillis()));
		rmanDealDetails.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		rmanDealDetails.setCreatedBy(BaseListener.getCurrentUserId());
		rmanDealDetails.setLastUpdatedBy(BaseListener.getCurrentUserId());
	}

	@PreUpdate
	public void preUpdate(RmanDealDetails rmanDealDetails) {
		rmanDealDetails.setLastUpdatedDate(new Timestamp(System.currentTimeMillis()));
		rmanDealDetails.setLastUpdatedBy(BaseListener.getCurrentUserId());
	}

}
