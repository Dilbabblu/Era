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
import com.forsys.revmantra.model.RmanRulesHeader;
import com.forsys.revmantra.utils.BeanUtil;
import com.forsys.revmantra.utils.RevmantraUtils;

public class RmanRulesHeaderListener {

	/**
	 * automatic property set before any database persistence
	 */
	@PrePersist
	public void prePersist(RmanRulesHeader rmanRulesHeader) {
		rmanRulesHeader.setRuleStartDate(new Timestamp(System.currentTimeMillis()));
		rmanRulesHeader.setCreationDate(new Timestamp(System.currentTimeMillis()));
		rmanRulesHeader.setCreatedBy(BaseListener.getCurrentUserId());
		rmanRulesHeader.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
		rmanRulesHeader.setLastUpdatedBy(BaseListener.getCurrentUserId());
	}

	@PreUpdate
	public void preUpdate(RmanRulesHeader rmanRulesHeader) {
		rmanRulesHeader.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
		rmanRulesHeader.setLastUpdatedBy(BaseListener.getCurrentUserId());
	}
	
	@PostPersist
	public void postPersist(RmanRulesHeader rmanRulesHeader) {
/**		perform(rmanRulesHeader,Action.INSERTED); */
	}
	

	@PostUpdate
	public void postUpdate(RmanRulesHeader rmanRulesHeader) {
/**		perform(rmanRulesHeader,Action.UPDATED); */
		
	}
	
	@PostRemove
	public void postRemove(RmanRulesHeader rmanRulesHeader) {
/**		perform(rmanRulesHeader,Action.DELETED); */
	}
	
	@Transactional(TxType.MANDATORY)
    private void perform(RmanRulesHeader rmanRulesHeader, Action action) {
		EntityManager entityManager = BeanUtil.getBean(EntityManager.class);
        RevmantraUtils.createLog(entityManager, "ARRANGEMENT RULES", "", action.name(),String.valueOf(rmanRulesHeader.getRuleHeaderId()),rmanRulesHeader.getRuleName(),BaseListener.getCurrentUser());
		
    }

	

}
