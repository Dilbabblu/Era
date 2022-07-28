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
import com.forsys.revmantra.model.RmanConversionRates;
import com.forsys.revmantra.utils.BeanUtil;
import com.forsys.revmantra.utils.RevmantraUtils;

public class RmanConversionRatesListener {

    /**
     * automatic property set before any database persistence
     */
    
    @PrePersist
    public void prePersist(RmanConversionRates rmanConversionRates) {
    	 
    	rmanConversionRates.setCreatedDate(new Timestamp(System.currentTimeMillis()));
    	rmanConversionRates.setCreatedBy(BaseListener.getCurrentUserId());
    	rmanConversionRates.setLastUpdatedDate(new Timestamp(System.currentTimeMillis()));
    	rmanConversionRates.setLastUpdatedBy(BaseListener.getCurrentUserId());
    }
    @PreUpdate
    public void preUpdate(RmanConversionRates rmanConversionRates) {
    	rmanConversionRates.setLastUpdatedDate(new Timestamp(System.currentTimeMillis()));
    	rmanConversionRates.setLastUpdatedBy(BaseListener.getCurrentUserId());
    }
    
    @PostPersist
	public void postPersist(RmanConversionRates rmanConversionRates) {
/**		perform(rmanConversionRates,Action.INSERTED); */
	}
	

	@PostUpdate
	public void postUpdate(RmanConversionRates rmanConversionRates) {
/**		perform(rmanConversionRates,Action.UPDATED); */
		
	}
	
	@PostRemove
	public void postRemove(RmanConversionRates rmanConversionRates) {
/**		perform(rmanConversionRates,Action.DELETED); */
	}
	
	@Transactional(TxType.MANDATORY)
    private void perform(RmanConversionRates rmanConversionRates, Action action) {
		EntityManager entityManager = BeanUtil.getBean(EntityManager.class);
        RevmantraUtils.createLog(entityManager, "CONVERSION RATES", "", action.name(),rmanConversionRates.getFromCurrency()+"-"+rmanConversionRates.getToCurrency()+"-"+String.valueOf(rmanConversionRates.getConversionRate()),rmanConversionRates.getFromCurrency()+"-"+rmanConversionRates.getToCurrency()+"-"+String.valueOf(rmanConversionRates.getConversionRate()),BaseListener.getCurrentUser());
		
    }
    
}
