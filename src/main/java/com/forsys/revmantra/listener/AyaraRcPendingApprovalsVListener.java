package com.forsys.revmantra.listener;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import com.forsys.revmantra.model.AyaraRcPendingApprovalsV;

public class AyaraRcPendingApprovalsVListener {

    /**
     * automatic property set before any database persistence
     */
    @PreUpdate
    @PrePersist
    public void prePersist(AyaraRcPendingApprovalsV ayaraRcPendingApprovalsV) {

    }
    
}
