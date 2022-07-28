package com.forsys.revmantra.listener;

import java.sql.Timestamp;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.forsys.revmantra.model.RmanUsageSummaryInterface;

public class RmanUsageSummaryInterfaceListener {

    /**
     * automatic property set before any database persistence
     */
    
    @PrePersist
    public void prePersist(RmanUsageSummaryInterface rmanUsageSummaryInterface) {
    	rmanUsageSummaryInterface.setCreationDate(new Timestamp(System.currentTimeMillis()));
    	rmanUsageSummaryInterface.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
    	rmanUsageSummaryInterface.setCreatedBy(BaseListener.getCurrentUserId());
    	rmanUsageSummaryInterface.setLastUpdatedBy(BaseListener.getCurrentUserId());
    }
    
    @PreUpdate
    public void preUpdate(RmanUsageSummaryInterface rmanUsageSummaryInterface) {
        
    	rmanUsageSummaryInterface.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
    	rmanUsageSummaryInterface.setLastUpdatedBy(BaseListener.getCurrentUserId());
    }
    
}
