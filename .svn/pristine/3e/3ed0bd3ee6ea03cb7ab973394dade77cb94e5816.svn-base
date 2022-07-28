package com.forsys.revmantra.listener;

import java.sql.Timestamp;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.forsys.revmantra.model.AyaraUserTableColumns;

public class AyaraUserTableColumnsListener {

    /**
     * automatic property set before any database persistence
     */
    @PrePersist
    public void prePersist(AyaraUserTableColumns ayaraUserTableColumns) {
    	ayaraUserTableColumns.setCreationDate(new Timestamp(System.currentTimeMillis()));
    	ayaraUserTableColumns.setCreatedBy(BaseListener.getCurrentUserId());
    	ayaraUserTableColumns.setLastUpdatedBy(BaseListener.getCurrentUserId());
    	ayaraUserTableColumns.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
    	ayaraUserTableColumns.setUserId(BaseListener.getCurrentUserId());
    }
     
    @PreUpdate
	public void preUpdate(AyaraUserTableColumns ayaraUserTableColumns) {
    	ayaraUserTableColumns.setLastUpdatedBy(BaseListener.getCurrentUserId());
    	ayaraUserTableColumns.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
    }
    
}
