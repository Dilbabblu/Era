package com.forsys.revmantra.listener;

import java.sql.Timestamp;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.forsys.revmantra.model.RmanDealStatus;

public class RmanDealStatusListener {
	/**
	 * automatic property set before any database persistence
	 */

	@PrePersist
	public void prePersist(RmanDealStatus rmanDealStatus) {
		rmanDealStatus.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
		rmanDealStatus.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		rmanDealStatus.setCreatedBy(BaseListener.getCurrentUserId());
		rmanDealStatus.setLastUpdatedBy(BaseListener.getCurrentUserId());
	}

	@PreUpdate
	public void preUpdate(RmanDealStatus rmanDealStatus) {
		rmanDealStatus.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
		rmanDealStatus.setLastUpdatedBy(BaseListener.getCurrentUserId());
	}
}
