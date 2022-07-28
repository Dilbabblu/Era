package com.forsys.revmantra.listener;

import java.sql.Timestamp;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.forsys.revmantra.model.AyaraRCTaskApprovalStatus;

public class AyaraRCTaskApprovalStatusListener {
	/**
     * automatic property set before any database persistence
     */
	@PrePersist
    public void prePersist(AyaraRCTaskApprovalStatus ayaraRCTaskApprovalStatus) {
		ayaraRCTaskApprovalStatus.setCreatedBy(BaseListener.getCurrentUserId());
		ayaraRCTaskApprovalStatus.setCreationDate(new Timestamp(System.currentTimeMillis()));
		ayaraRCTaskApprovalStatus.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
		ayaraRCTaskApprovalStatus.setLastUpdatedBy(BaseListener.getCurrentUserId());
    }
    
    
    @PreUpdate
    public void preUpdate(AyaraRCTaskApprovalStatus ayaraRCTaskApprovalStatus) {	
    	ayaraRCTaskApprovalStatus.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
    	ayaraRCTaskApprovalStatus.setLastUpdatedBy(BaseListener.getCurrentUserId());
    }
}
