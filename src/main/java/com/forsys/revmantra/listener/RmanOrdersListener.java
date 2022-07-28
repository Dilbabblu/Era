package com.forsys.revmantra.listener;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.forsys.revmantra.model.RmanOrders;

public class RmanOrdersListener {

    /**
     * automatic property set before any database persistence
     */
    @PreUpdate
    @PrePersist
    public void prePersist(RmanOrders rmanOrders) {
    	/** No-code */
    }
    
}
