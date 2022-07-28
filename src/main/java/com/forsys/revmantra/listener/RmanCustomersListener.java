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
import com.forsys.revmantra.model.RmanCustomers;
import com.forsys.revmantra.utils.BeanUtil;
import com.forsys.revmantra.utils.RevmantraUtils;

public class RmanCustomersListener {

    /**
     * automatic property set before any database persistence
     */
    @PrePersist
    public void prePersist(RmanCustomers rmanCustomers) {
    	rmanCustomers.setCreatedBy(BaseListener.getCurrentUserId());
    	rmanCustomers.setCreationDate(new Timestamp(System.currentTimeMillis()));
    	rmanCustomers.setLastUpdatedBy(BaseListener.getCurrentUserId());
    	rmanCustomers.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
    }
    
    @PreUpdate
    public void preUpdate(RmanCustomers rmanCustomers) {
    	rmanCustomers.setLastUpdatedBy(BaseListener.getCurrentUserId());
    	rmanCustomers.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
    }

	@PostPersist
	public void postPersist(RmanCustomers rmanCustomers) {
/**		perform(rmanCustomers,Action.INSERTED); */
	}
	

	@PostUpdate
	public void postUpdate(RmanCustomers rmanCustomers) {
/**		perform(rmanCustomers,Action.UPDATED); */
		
	}
	
	@PostRemove
	public void postRemove(RmanCustomers rmanCustomers) {
/**		perform(rmanCustomers,Action.DELETED); */
	}
	
	@Transactional(TxType.MANDATORY)
    private void perform(RmanCustomers rmanCustomers, Action action) {
		EntityManager entityManager = BeanUtil.getBean(EntityManager.class);
        RevmantraUtils.createLog(entityManager, "CUSTOMERS", "", action.name(),String.valueOf(rmanCustomers.getCustomerId()),rmanCustomers.getCustomerNumber(),BaseListener.getCurrentUser());
		
    }

}
