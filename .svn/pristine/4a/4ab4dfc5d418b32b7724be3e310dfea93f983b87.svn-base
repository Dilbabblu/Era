package com.forsys.revmantra.listener;

import java.sql.Timestamp;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.forsys.revmantra.model.AyaraDocTransactionsInt;

/*
 *  Created the AyaraDocTransactionsIntListener Class  for Single Interface Table
 *  #AYAR-479 By Chandra on 9th Jun 2021
 */

public class AyaraDocTransactionsIntListener {

    /**
     * automatic property set before any database persistence
     */
	@PrePersist
    public void prePersist(AyaraDocTransactionsInt ayaraDocTransactionsInt) {
		ayaraDocTransactionsInt.setCreatedBy(BaseListener.getCurrentUser());
		ayaraDocTransactionsInt.setCreationDate(new Timestamp(System.currentTimeMillis()));
		ayaraDocTransactionsInt.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
		ayaraDocTransactionsInt.setLastUpdatedBy(BaseListener.getCurrentUser());
    }
    
    
    @PreUpdate
    public void preUpdate(AyaraDocTransactionsInt ayaraDocTransactionsInt) {	
    	ayaraDocTransactionsInt.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
		ayaraDocTransactionsInt.setLastUpdatedBy(BaseListener.getCurrentUser());
    }

}
