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
import com.forsys.revmantra.model.RmanFiscalPeriods;
import com.forsys.revmantra.utils.BeanUtil;
import com.forsys.revmantra.utils.RevmantraUtils;

public class RmanFiscalPeriodsListener {

	/**
	 * automatic property set before any database persistence
	 */
	@PrePersist
	public void prePersist(RmanFiscalPeriods rmanFiscalPeriods) {
		rmanFiscalPeriods.setCreatedBy(BaseListener.getCurrentUserId());
		rmanFiscalPeriods.setCreationDate(new Timestamp(System.currentTimeMillis()));
		rmanFiscalPeriods.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
		rmanFiscalPeriods.setLastUpdatedBy(BaseListener.getCurrentUserId());
	}

	@PreUpdate
	public void preUpdate(RmanFiscalPeriods rmanFiscalPeriods) {
		rmanFiscalPeriods.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
		rmanFiscalPeriods.setLastUpdatedBy(BaseListener.getCurrentUserId());
	}
	
	@PostPersist
	public void postPersist(RmanFiscalPeriods rmanFiscalPeriods) {
/**		perform(rmanFiscalPeriods,Action.INSERTED); */
	}
	

	@PostUpdate
	public void postUpdate(RmanFiscalPeriods rmanFiscalPeriods) {
/**		perform(rmanFiscalPeriods,Action.UPDATED); */
		
	}
	
	@PostRemove
	public void postRemove(RmanFiscalPeriods rmanFiscalPeriods) {
/**		perform(rmanFiscalPeriods,Action.DELETED); */
	}
	
	@Transactional(TxType.MANDATORY)
    private void perform(RmanFiscalPeriods rmanFiscalPeriods, Action action) {
		EntityManager entityManager = BeanUtil.getBean(EntityManager.class);
        RevmantraUtils.createLog(entityManager, "ACCOUNTING PERIODS", "", action.name(),String.valueOf(rmanFiscalPeriods.getRmanPeriodId()),rmanFiscalPeriods.getPeriodName(),BaseListener.getCurrentUser());
		
    }

}
