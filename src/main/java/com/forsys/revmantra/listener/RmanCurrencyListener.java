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
import com.forsys.revmantra.model.RmanCurrency;
import com.forsys.revmantra.utils.BeanUtil;
import com.forsys.revmantra.utils.RevmantraUtils;

public class RmanCurrencyListener {

    /**
     * automatic property set before any database persistence
     */
    @PrePersist
    public void prePersist(RmanCurrency rmanCurrency) {
    
    	rmanCurrency.setCreationDate(new Timestamp(System.currentTimeMillis()));
    	rmanCurrency.setLastUpdatedDate(new Timestamp(System.currentTimeMillis()));
    	rmanCurrency.setCreatedBy(BaseListener.getCurrentUserId());
    	rmanCurrency.setLastUpdatedBy(BaseListener.getCurrentUserId());
	}

	@PreUpdate
	public void preUpdate(RmanCurrency rmanCurrency) {

		rmanCurrency.setLastUpdatedDate(new Timestamp(System.currentTimeMillis()));
		rmanCurrency.setLastUpdatedBy(BaseListener.getCurrentUserId());
	}
	
	@PostPersist
	public void postPersist(RmanCurrency rmanCurrency) {
/**	perform(rmanCurrency,Action.INSERTED); */
	}
	

	@PostUpdate
	public void postUpdate(RmanCurrency rmanCurrency) {
/**	perform(rmanCurrency,Action.UPDATED); */
		
	}
	
	@PostRemove
	public void postRemove(RmanCurrency rmanCurrency) {
/**	perform(rmanCurrency,Action.DELETED); */
	}
	
	@Transactional(TxType.MANDATORY)
    private void perform(RmanCurrency rmanCurrency, Action action) {
		EntityManager entityManager = BeanUtil.getBean(EntityManager.class);
        RevmantraUtils.createLog(entityManager, "CURRENCIES", "", action.name(),rmanCurrency.getCurrencyCode(),rmanCurrency.getName(),BaseListener.getCurrentUser());
		
    }

}
