package com.forsys.revmantra.listener;

import java.sql.Timestamp;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.forsys.revmantra.model.RmanDealArrangements;

public class RmanDealArrangementsListener {

	/**
	 * automatic property set before any database persistence
	 */

	@PrePersist
	public void prePersist(RmanDealArrangements rmanDealArrangements) {

		rmanDealArrangements.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
		rmanDealArrangements.setCreationDate(new Timestamp(System.currentTimeMillis()));
		rmanDealArrangements.setCreatedBy(BaseListener.getCurrentUserId());
		rmanDealArrangements.setLastUpdatedBy(BaseListener.getCurrentUserId());
	}

	@PreUpdate
	public void preUpdate(RmanDealArrangements rmanDealArrangements) {
		rmanDealArrangements.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
		rmanDealArrangements.setLastUpdatedBy(BaseListener.getCurrentUserId());
	}

}
