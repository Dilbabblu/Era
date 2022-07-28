package com.forsys.revmantra.listener;

import java.sql.Timestamp;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.forsys.revmantra.model.RmanEvents;

public class RmanEventsListener {

    /**
     * automatic property set before any database persistence
     */
    @PrePersist
    public void prePersist(RmanEvents rmanEvents) {

    	rmanEvents.setCreationDate(new Timestamp(System.currentTimeMillis()));
    	rmanEvents.setCreatedBy(BaseListener.getCurrentUserId());
    	rmanEvents.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
    	rmanEvents.setLastUpdatedBy(BaseListener.getCurrentUserId());

    }

	@PreUpdate
	public void preUpdate(RmanEvents rmanEvents) {
		rmanEvents.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
		rmanEvents.setLastUpdatedBy(BaseListener.getCurrentUserId());
	
	}

}
