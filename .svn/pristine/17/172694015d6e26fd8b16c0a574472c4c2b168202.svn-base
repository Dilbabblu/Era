package com.forsys.revmantra.listener;

import java.sql.Timestamp;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.forsys.revmantra.model.RmanContTransToRelease;

public class RmanContTransToReleaseListener {

    /**
     * automatic property set before any database persistence
     */
    @PrePersist
    public void prePersist(RmanContTransToRelease rmanContTransToRelease) {

        rmanContTransToRelease.setCreationDate(new Timestamp(System.currentTimeMillis()));
        rmanContTransToRelease.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
        rmanContTransToRelease.setCreatedBy(BaseListener.getCurrentUserId());
        rmanContTransToRelease.setLastUpdatedBy(BaseListener.getCurrentUserId());
    }
    
    @PreUpdate
    public void preUpdate(RmanContTransToRelease rmanContTransToRelease) {
        
        rmanContTransToRelease.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
        rmanContTransToRelease.setLastUpdatedBy(BaseListener.getCurrentUserId());
    }
    
}
