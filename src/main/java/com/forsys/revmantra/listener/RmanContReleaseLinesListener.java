package com.forsys.revmantra.listener;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.forsys.revmantra.model.RmanContReleaseLines;

public class RmanContReleaseLinesListener {

    /**
     * automatic property set before any database persistence
     */
    @PreUpdate
    @PrePersist
    public void prePersist(RmanContReleaseLines rmanContReleaseLines) {
    	/** No-code */
    }
    
}
