package com.forsys.revmantra.listener;

import java.sql.Timestamp;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.forsys.revmantra.model.RmanContTransLines;

public class RmanContTransLinesListener {

	/**
	 * automatic property set before any database persistence
	 */

	@PrePersist
	public void prePersist(RmanContTransLines rmanContTransLines) {
		rmanContTransLines.setCreatedBy(BaseListener.getCurrentUserId());
		rmanContTransLines.setCreationDate(new Timestamp(System.currentTimeMillis()));
		rmanContTransLines.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
		rmanContTransLines.setLastUpdatedBy(BaseListener.getCurrentUserId());

	}

	@PreUpdate
	public void preUpdate(RmanContTransLines rmanContTransLines) {

		rmanContTransLines.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
		rmanContTransLines.setLastUpdatedBy(BaseListener.getCurrentUserId());
	}

}
