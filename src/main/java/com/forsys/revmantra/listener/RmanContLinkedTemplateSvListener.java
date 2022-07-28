package com.forsys.revmantra.listener;

import java.sql.Timestamp;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.forsys.revmantra.model.RmanContLinkedTemplateSv;

public class RmanContLinkedTemplateSvListener {

	/**
	 * automatic property set before any database persistence
	 */
	@PrePersist
	public void prePersist(RmanContLinkedTemplateSv rmanContLinkedTemplateSv) {
		rmanContLinkedTemplateSv.setCreationDate(new Timestamp(System.currentTimeMillis()));
		rmanContLinkedTemplateSv.setCreatedBy(BaseListener.getCurrentUserId());
		rmanContLinkedTemplateSv.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
		rmanContLinkedTemplateSv.setLastUpdatedBy(BaseListener.getCurrentUserId());
	}

	@PreUpdate
	public void preUpdate(RmanContLinkedTemplateSv rmanContLinkedTemplateSv) {
		rmanContLinkedTemplateSv.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
		rmanContLinkedTemplateSv.setLastUpdatedBy(BaseListener.getCurrentUserId());
	}

}
