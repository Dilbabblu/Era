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
import com.forsys.revmantra.model.RmanLookupCodes;
import com.forsys.revmantra.utils.BeanUtil;
import com.forsys.revmantra.utils.RevmantraUtils;

public class RmanLookupCodesListener {

	/**
	 * automatic property set before any database persistence
	 */
	@PrePersist
	public void prePersist(RmanLookupCodes rmanLookupCodes) {
		rmanLookupCodes.setCreationDate(new Timestamp(System.currentTimeMillis()));
		rmanLookupCodes.setCreatedBy(BaseListener.getCurrentUserId());
		rmanLookupCodes.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
		rmanLookupCodes.setLastUpdatedBy(BaseListener.getCurrentUserId());
		rmanLookupCodes.setSeededFlag("Y");

	}

	@PreUpdate
	public void preUpdate(RmanLookupCodes rmanLookupCodes) {
		rmanLookupCodes.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
		rmanLookupCodes.setLastUpdatedBy(BaseListener.getCurrentUserId());
		rmanLookupCodes.setSeededFlag("Y");

	}
	
	@PostPersist
	public void postPersist(RmanLookupCodes rmanLookupCodes) {
/**		perform(rmanLookupCodes,Action.INSERTED); */
	}
	

	@PostUpdate
	public void postUpdate(RmanLookupCodes rmanLookupCodes) {
/**		perform(rmanLookupCodes,Action.UPDATED); */
		
	}
	
	@PostRemove
	public void postRemove(RmanLookupCodes rmanLookupTypes) {
/**		perform(rmanLookupTypes,Action.DELETED); */
	}
	
	@Transactional(TxType.MANDATORY)
    private void perform(RmanLookupCodes rmanLookupCodes, Action action) {
		EntityManager entityManager = BeanUtil.getBean(EntityManager.class);
        RevmantraUtils.createLog(entityManager, "LOOKUP CODES", "", action.name(),rmanLookupCodes.getLookupTypeCode()+"-"+rmanLookupCodes.getLookupCode(),rmanLookupCodes.getLookupCode(),BaseListener.getCurrentUser());
		
    }

}
