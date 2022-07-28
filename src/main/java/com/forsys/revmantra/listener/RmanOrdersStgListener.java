package com.forsys.revmantra.listener;

import java.sql.Timestamp;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.forsys.revmantra.model.RmanOrdersStg;

public class RmanOrdersStgListener {

	/**
	 * automatic property set before any database persistence
	 */

	@PrePersist
	public void prePersist(RmanOrdersStg rmanOrdersStg) {
		rmanOrdersStg.setCreatedBy(BaseListener.getCurrentUserId());
		rmanOrdersStg.setCreationDate(new Timestamp(System.currentTimeMillis()));
		rmanOrdersStg.setLastUpdatedBy(BaseListener.getCurrentUserId());
		rmanOrdersStg.setLastUpdatedDate(new Timestamp(System.currentTimeMillis()));
	}

	@PreUpdate
	public void preUpdate(RmanOrdersStg rmanOrdersStg) {
		rmanOrdersStg.setLastUpdatedBy(BaseListener.getCurrentUserId());
		rmanOrdersStg.setLastUpdatedDate(new Timestamp(System.currentTimeMillis()));
	}

}
