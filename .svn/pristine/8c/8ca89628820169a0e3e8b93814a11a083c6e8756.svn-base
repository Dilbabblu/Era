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
import com.forsys.revmantra.model.RmanContHeader;
import com.forsys.revmantra.utils.BeanUtil;
import com.forsys.revmantra.utils.RevmantraUtils;

public class RmanContHeaderListener {
	
	/**
	 * automatic property set before any database persistence
	 */
	@PrePersist
	public void prePersist(RmanContHeader rmanContHeader) {
		
		
		rmanContHeader.setCreationDate(new Timestamp(System.currentTimeMillis()));
		rmanContHeader.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
		rmanContHeader.setCreatedBy(BaseListener.getCurrentUserId());
		rmanContHeader.setLastUpdatedBy(BaseListener.getCurrentUserId());
		
	}
	

	@PreUpdate
	public void preUpdate(RmanContHeader rmanContHeader) {
		rmanContHeader.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
		rmanContHeader.setLastUpdatedBy(BaseListener.getCurrentUserId());
	}
	
	@PostPersist
	public void postPersist(RmanContHeader rmanContHeader) {
/**		perform(rmanContHeader,Action.INSERTED); */
	}
	

	@PostUpdate
	public void postUpdate(RmanContHeader rmanContHeader) {
/**		perform(rmanContHeader,Action.UPDATED); */
		
	}
	
	@PostRemove
	public void postRemove(RmanContHeader rmanContHeader) {
/**		perform(rmanContHeader,Action.DELETED); */
	}
	
	@Transactional(TxType.MANDATORY)
    private void perform(RmanContHeader rmanContHeaderNew, Action action) {
		EntityManager entityManager = BeanUtil.getBean(EntityManager.class);
        RevmantraUtils.createLog(entityManager, "CONTINGENCY CODES", "", action.name(),String.valueOf(rmanContHeaderNew.getRuleHeaderId()),rmanContHeaderNew.getRuleName(),BaseListener.getCurrentUser());
		
    }


}
