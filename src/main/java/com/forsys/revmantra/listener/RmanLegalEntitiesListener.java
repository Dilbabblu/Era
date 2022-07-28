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
import com.forsys.revmantra.model.RmanLegalEntities;
import com.forsys.revmantra.utils.BeanUtil;
import com.forsys.revmantra.utils.RevmantraUtils;

public class RmanLegalEntitiesListener {

	/**
	 * automatic property set before any database persistence
	 */
	@PrePersist
	public void prePersist(RmanLegalEntities rmanLegalEntities) {

		rmanLegalEntities.setCreationDate(new Timestamp(System.currentTimeMillis()));
		rmanLegalEntities.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
		rmanLegalEntities.setCreatedBy(BaseListener.getCurrentUserId());
		rmanLegalEntities.setLastUpdatedBy(BaseListener.getCurrentUserId());

	}

	@PreUpdate
	public void preUpdate(RmanLegalEntities rmanLegalEntities) {

		rmanLegalEntities.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
		rmanLegalEntities.setLastUpdatedBy(BaseListener.getCurrentUserId());

	}
	
	 	@PostPersist
		public void postPersist(RmanLegalEntities rmanLegalEntities) {
/**			perform(rmanLegalEntities,Action.INSERTED); */
		}
		

		@PostUpdate
		public void postUpdate(RmanLegalEntities rmanLegalEntities) {
/**			perform(rmanLegalEntities,Action.UPDATED); */
			
		}
		
		@PostRemove
		public void postRemove(RmanLegalEntities rmanLegalEntities) {
/**			perform(rmanLegalEntities,Action.DELETED); */
		}
		
		@Transactional(TxType.MANDATORY)
	    private void perform(RmanLegalEntities rmanLegalEntities, Action action) {
			EntityManager entityManager = BeanUtil.getBean(EntityManager.class);
	        RevmantraUtils.createLog(entityManager, "LEGAL ENTITIES", "", action.name(),String.valueOf(rmanLegalEntities.getLegalEntityId()),rmanLegalEntities.getName(),BaseListener.getCurrentUser());
			
	    }

}
