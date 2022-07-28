package com.forsys.revmantra.listener;

import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.forsys.revmantra.model.Action;
import com.forsys.revmantra.model.RmanAccountSetup;
import com.forsys.revmantra.utils.BeanUtil;
import com.forsys.revmantra.utils.RevmantraUtils;

public class RmanAccountSetupListener {

	 /**
     * automatic property set before any database persistence
     */
    @PrePersist
    public void prePersist(RmanAccountSetup rmanAccountSetup) {

    	rmanAccountSetup.setCreationDate(new Timestamp(System.currentTimeMillis()));
    	rmanAccountSetup.setLastUpdatedDate(new Timestamp(System.currentTimeMillis()));
    	rmanAccountSetup.setCreatedBy(BaseListener.getCurrentUserId());
    	rmanAccountSetup.setLastUpdatedBy(BaseListener.getCurrentUserId());
	}

	@PreUpdate
	public void preUpdate(RmanAccountSetup rmanAccountSetup) {

		rmanAccountSetup.setLastUpdatedDate(new Timestamp(System.currentTimeMillis()));
		rmanAccountSetup.setLastUpdatedBy(BaseListener.getCurrentUserId());
	}
	
	@PostPersist
	public void postPersist(RmanAccountSetup rmanAccountSetup) {
/**		perform(rmanAccountSetup,Action.INSERTED); */
	}
	

	@PostUpdate
	public void postUpdate(RmanAccountSetup rmanAccountSetup) {
/**		perform(rmanAccountSetup,Action.UPDATED); */
		
	}
	
	@PostRemove
	public void postRemove(RmanAccountSetup rmanAccountSetup) {
/**		perform(rmanAccountSetup,Action.DELETED); */
	}
	
	@Transactional(TxType.MANDATORY)
    private void perform(RmanAccountSetup rmanAccountSetup, Action action) {
		EntityManager entityManager = BeanUtil.getBean(EntityManager.class);
        RevmantraUtils.createLog(entityManager, "ACCOUNT SETUP", "",action.name(),String.valueOf(rmanAccountSetup.getAcctSetupId()),rmanAccountSetup.getAccountingStructure(),BaseListener.getCurrentUser());
		
    }

    
}
