package com.forsys.revmantra.listener;

import java.sql.Timestamp;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.forsys.revmantra.model.RmanEntityParameters;

public class RmanEntityParametersListener {

	/**
	 * automatic property set before any database persistence
	 */
	@PrePersist
	public void prePersist(RmanEntityParameters rmanEntityParameters) {

		rmanEntityParameters.setCreationDate(new Timestamp(System.currentTimeMillis()));
		rmanEntityParameters.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
		rmanEntityParameters.setCreatedBy(BaseListener.getCurrentUserId());
		rmanEntityParameters.setLastUpdatedBy(BaseListener.getCurrentUserId());
		rmanEntityParameters.setEnabledFlag("Y");

	}

	@PreUpdate
	public void preUpdate(RmanEntityParameters rmanEntityParameters) {

		rmanEntityParameters.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
		rmanEntityParameters.setLastUpdatedBy(BaseListener.getCurrentUserId());

	}

}
