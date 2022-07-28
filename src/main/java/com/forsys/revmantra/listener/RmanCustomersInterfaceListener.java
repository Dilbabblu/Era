package com.forsys.revmantra.listener;

import java.sql.Timestamp;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.forsys.revmantra.model.RmanCustomersInterface;

public class RmanCustomersInterfaceListener {

    /**
     * automatic property set before any database persistence
     */
        
    @PrePersist
	public void prePersist(RmanCustomersInterface rmanCustomersInterface) {

    	rmanCustomersInterface.setCreationDate(new Timestamp(System.currentTimeMillis()));
    	rmanCustomersInterface.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
    	rmanCustomersInterface.setCreatedBy(BaseListener.getCurrentUserId());
    	rmanCustomersInterface.setLastUpdatedBy(BaseListener.getCurrentUserId());
	}

	@PreUpdate
	public void preUpdate(RmanCustomersInterface rmanCustomersInterface) {

		rmanCustomersInterface.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
		rmanCustomersInterface.setLastUpdatedBy(BaseListener.getCurrentUserId());
	}
    
}
