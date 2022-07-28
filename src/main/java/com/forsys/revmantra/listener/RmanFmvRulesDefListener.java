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
import com.forsys.revmantra.model.RmanFmvRulesDef;
import com.forsys.revmantra.utils.BeanUtil;
import com.forsys.revmantra.utils.RevmantraUtils;

public class RmanFmvRulesDefListener {

	/**
	 * automatic property set before any database persistence
	 */
	
	@PrePersist
	public void prePersist(RmanFmvRulesDef rmanFmvRulesDef) {

		rmanFmvRulesDef.setEnabledFlag("Y");
		rmanFmvRulesDef.setCreationDate(new Timestamp(System.currentTimeMillis()));
		rmanFmvRulesDef.setCreatedBy(BaseListener.getCurrentUserId());
		rmanFmvRulesDef.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
		rmanFmvRulesDef.setLastUpdatedBy(BaseListener.getCurrentUserId());
		
	}

	@PreUpdate
	public void preUpdate(RmanFmvRulesDef rmanFmvRulesDef) {
		rmanFmvRulesDef.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
		rmanFmvRulesDef.setLastUpdatedBy(BaseListener.getCurrentUserId());
	}
	
	@PostPersist
	public void postPersist(RmanFmvRulesDef rmanFmvRulesDef) {
/**		perform(rmanFmvRulesDef,Action.INSERTED); */
	}
	

	@PostUpdate
	public void postUpdate(RmanFmvRulesDef rmanFmvRulesDef) {
/**		perform(rmanFmvRulesDef,Action.UPDATED); */
		
	}
	
	@PostRemove
	public void postRemove(RmanFmvRulesDef rmanFmvRulesDef) {
/**		perform(rmanFmvRulesDef,Action.DELETED); */
	}
	
	@Transactional(TxType.MANDATORY)
    private void perform(RmanFmvRulesDef rmanFmvRulesDef, Action action) {
		EntityManager entityManager = BeanUtil.getBean(EntityManager.class);
        RevmantraUtils.createLog(entityManager, "SSP RULES", "RULE STATUS", action.name(),String.valueOf(rmanFmvRulesDef.getFmvRuleDefId()),rmanFmvRulesDef.getFmvRuleName(),BaseListener.getCurrentUser());
	}

	
}
