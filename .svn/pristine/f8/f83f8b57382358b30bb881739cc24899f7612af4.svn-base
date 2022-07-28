package com.forsys.revmantra.listener;

import java.sql.Timestamp;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.forsys.revmantra.model.AyaraSspGroupingRules;

public class AyaraSspGroupingRulesListener {

    /**
     * automatic property set before any database persistence
     */
    @PrePersist
	public void prePersist(AyaraSspGroupingRules ayaraSspGroupingRules) {

    	ayaraSspGroupingRules.setCreationDate(new Timestamp(System.currentTimeMillis()));
    	ayaraSspGroupingRules.setCreatedBy(BaseListener.getCurrentUserId());
    	ayaraSspGroupingRules.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
    	ayaraSspGroupingRules.setLastUpdatedBy(BaseListener.getCurrentUserId());
	}
	
	@PreUpdate
	public void preUpdate(AyaraSspGroupingRules ayaraSspGroupingRules) {

		ayaraSspGroupingRules.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
		ayaraSspGroupingRules.setLastUpdatedBy(BaseListener.getCurrentUserId());
	}


    
}
