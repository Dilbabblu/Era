package com.forsys.revmantra.listener;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import com.forsys.revmantra.model.AyaraRcApprovalHistoryV;

public class AyaraRcApprovalHistoryVListener {

    /**
     * automatic property set before any database persistence
     */
    @PreUpdate
    @PrePersist
    public void prePersist(AyaraRcApprovalHistoryV ayaraRcApprovalHistoryV) {

    }
    
}
