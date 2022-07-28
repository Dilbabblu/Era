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
import com.forsys.revmantra.model.RmanLookupTypes;
import com.forsys.revmantra.utils.BeanUtil;
import com.forsys.revmantra.utils.RevmantraUtils;

public class RmanLookupTypesListener {

	/**
	 * automatic property set before any database persistence
	 */
	@PrePersist
	public void prePersist(RmanLookupTypes rmanLookupTypes) {
		rmanLookupTypes.setCreationDate(new Timestamp(System.currentTimeMillis()));
		rmanLookupTypes.setCreatedBy(BaseListener.getCurrentUserId());
		rmanLookupTypes.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
		rmanLookupTypes.setLastUpdatedBy(BaseListener.getCurrentUserId());
		rmanLookupTypes.setSeededFlag("N");

	}

	@PreUpdate
	public void preUpdate(RmanLookupTypes rmanLookupTypes) {
		rmanLookupTypes.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
		rmanLookupTypes.setLastUpdatedBy(BaseListener.getCurrentUserId());

	}
	
	@PostPersist
	public void postPersist(RmanLookupTypes rmanLookupTypes) {
/**		perform(rmanLookupTypes,Action.INSERTED); */
	}
	

	@PostUpdate
	public void postUpdate(RmanLookupTypes rmanLookupTypes) {
/**		perform(rmanLookupTypes,Action.UPDATED); */
		
	}
	
	@PostRemove
	public void postRemove(RmanLookupTypes rmanLookupTypes) {
/**		perform(rmanLookupTypes,Action.DELETED); */
	}
	
	@Transactional(TxType.MANDATORY)
    private void perform(RmanLookupTypes rmanLookupTypes, Action action) {
		EntityManager entityManager = BeanUtil.getBean(EntityManager.class);
        RevmantraUtils.createLog(entityManager, "LOOKUP TYPES", "", action.name(),rmanLookupTypes.getLookupTypeName(),rmanLookupTypes.getLookupTypeName(),BaseListener.getCurrentUser());
		
    }

}
