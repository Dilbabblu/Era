package com.forsys.revmantra.listener;

import java.sql.Timestamp;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.forsys.revmantra.model.AyaraSspGroupingRuleDimensions;

public class AyaraSspGroupingRuleDimensionsListener {

    /**
     * automatic property set before any database persistence
     */
        
    @PrePersist
	public void prePersist(AyaraSspGroupingRuleDimensions ayaraSspGroupingRuleDimensions) {

    	ayaraSspGroupingRuleDimensions.setCreationDate(new Timestamp(System.currentTimeMillis()));
    	ayaraSspGroupingRuleDimensions.setCreatedBy(BaseListener.getCurrentUserId());
    	ayaraSspGroupingRuleDimensions.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
    	ayaraSspGroupingRuleDimensions.setLastUpdatedBy(BaseListener.getCurrentUserId());
	}
	
	@PreUpdate
	public void preUpdate(AyaraSspGroupingRuleDimensions ayaraSspGroupingRuleDimensions) {

		ayaraSspGroupingRuleDimensions.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
		ayaraSspGroupingRuleDimensions.setLastUpdatedBy(BaseListener.getCurrentUserId());
	}

    
}
