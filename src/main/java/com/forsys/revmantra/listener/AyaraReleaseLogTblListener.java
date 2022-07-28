package com.forsys.revmantra.listener;

import java.sql.Timestamp;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.forsys.revmantra.model.AyaraReleaseLogTbl;

public class AyaraReleaseLogTblListener {

    /**
     * automatic property set before any database persistence
     */
    @PreUpdate
    @PrePersist
    public void prePersist(AyaraReleaseLogTbl ayaraReleaseLogTbl) {
    	ayaraReleaseLogTbl.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
    	ayaraReleaseLogTbl.setLastUpdatedBy(BaseListener.getCurrentUser());
    }
    
}
