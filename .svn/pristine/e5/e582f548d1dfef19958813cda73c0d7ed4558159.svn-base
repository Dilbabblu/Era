package com.forsys.revmantra.listener;

import java.sql.Timestamp;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.forsys.revmantra.model.RmanDealHeaders;

public class RmanDealHeadersListener {

	/**
	 * automatic property set before any database persistence
	 */

	@PrePersist
	public void prePersist(RmanDealHeaders rmanDealHeaders) {
		rmanDealHeaders.setLastUpdatedDate(new Timestamp(System.currentTimeMillis()));
		rmanDealHeaders.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		rmanDealHeaders.setCreatedBy(BaseListener.getCurrentUserId());
		rmanDealHeaders.setLastUpdatedBy(BaseListener.getCurrentUserId());
	}

	@PreUpdate
	public void preUpdate(RmanDealHeaders rmanDealHeaders) {
		rmanDealHeaders.setLastUpdatedDate(new Timestamp(System.currentTimeMillis()));
		rmanDealHeaders.setLastUpdatedBy(BaseListener.getCurrentUserId());
	}

}
