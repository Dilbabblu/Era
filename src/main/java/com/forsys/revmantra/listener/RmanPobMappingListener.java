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
import com.forsys.revmantra.model.RmanPobMapping;
import com.forsys.revmantra.utils.BeanUtil;
import com.forsys.revmantra.utils.RevmantraUtils;

public class RmanPobMappingListener {

	 /**
     * automatic property set before any database persistence
     */
    @PrePersist
    public void prePersist(RmanPobMapping rmanPobMapping) {

    	rmanPobMapping.setCreationDate(new Timestamp(System.currentTimeMillis()));
    	rmanPobMapping.setLastUpdatedDate(new Timestamp(System.currentTimeMillis()));
    	rmanPobMapping.setCreatedBy(BaseListener.getCurrentUserId());
    	rmanPobMapping.setLastUpdatedBy(BaseListener.getCurrentUserId());
	}

	@PreUpdate
	public void preUpdate(RmanPobMapping rmanPobMapping) {

		rmanPobMapping.setLastUpdatedDate(new Timestamp(System.currentTimeMillis()));
		rmanPobMapping.setLastUpdatedBy(BaseListener.getCurrentUserId());
	}
	
	@PostPersist
	public void postPersist(RmanPobMapping rmanPobMapping) {
/**		perform(rmanPobMapping,Action.INSERTED); */
	}
	

	@PostUpdate
	public void postUpdate(RmanPobMapping rmanPobMapping) {
/**		perform(rmanPobMapping,Action.UPDATED); */
		
	}
	
	@PostRemove
	public void postRemove(RmanPobMapping rmanPobMapping) {
/**		perform(rmanPobMapping,Action.DELETED); */
	}
	
	@Transactional(TxType.MANDATORY)
    private void perform(RmanAccountSetup rmanAccountSetup, Action action) {
		EntityManager entityManager = BeanUtil.getBean(EntityManager.class);
        RevmantraUtils.createLog(entityManager, "ACCOUNT SETUP", "", action.name(),String.valueOf(rmanAccountSetup.getAcctSetupId()),rmanAccountSetup.getAccountingStructure(),BaseListener.getCurrentUser());
		
    }

    
}
