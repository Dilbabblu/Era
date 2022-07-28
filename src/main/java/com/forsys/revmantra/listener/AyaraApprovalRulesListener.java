package com.forsys.revmantra.listener;

import java.sql.Timestamp;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.forsys.revmantra.model.AyaraApprovalRules;

public class AyaraApprovalRulesListener {
	/**
     * automatic property set before any database persistence
     */
	@PrePersist
    public void prePersist(AyaraApprovalRules ayaraApprovalRules) {
		ayaraApprovalRules.setCreatedBy(BaseListener.getCurrentUserId());
		ayaraApprovalRules.setCreationDate(new Timestamp(System.currentTimeMillis()));
		ayaraApprovalRules.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
		ayaraApprovalRules.setLastUpdatedBy(BaseListener.getCurrentUserId());
    }
    
    
    @PreUpdate
    public void preUpdate(AyaraApprovalRules ayaraApprovalRules) {	
    	ayaraApprovalRules.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
    	ayaraApprovalRules.setLastUpdatedBy(BaseListener.getCurrentUserId());
    }
}
