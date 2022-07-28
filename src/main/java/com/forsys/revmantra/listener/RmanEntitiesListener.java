package com.forsys.revmantra.listener;

import java.sql.Timestamp;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.forsys.revmantra.model.RmanEntities;

public class RmanEntitiesListener {

	/**
	 * automatic property set before any database persistence
	 */
	@PrePersist
	public void prePersist(RmanEntities rmanEntities) {
		rmanEntities.setCreationDate(new Timestamp(System.currentTimeMillis()));
		rmanEntities.setCreatedBy(BaseListener.getCurrentUserId());
		rmanEntities.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
		rmanEntities.setLastUpdatedBy(BaseListener.getCurrentUserId());

	}

	@PreUpdate
	public void preUpdate(RmanEntities rmanEntities) {
		rmanEntities.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
		rmanEntities.setLastUpdatedBy(BaseListener.getCurrentUserId());

	}

}
