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
import com.forsys.revmantra.model.RmanRuleParameterValue;
import com.forsys.revmantra.utils.BeanUtil;
import com.forsys.revmantra.utils.RevmantraUtils;

public class RmanRuleParameterValueListener {

	/**
	 * automatic property set before any database persistence
	 */

	@PrePersist
	public void prePersist(RmanRuleParameterValue rmanRuleParameterValue) {
		rmanRuleParameterValue.setCreationDate(new Timestamp(System.currentTimeMillis()));
		rmanRuleParameterValue.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
		rmanRuleParameterValue.setCreatedBy(BaseListener.getCurrentUserId());
		rmanRuleParameterValue.setLastUpdatedBy(BaseListener.getCurrentUserId());

	}

	@PreUpdate
	public void preUpdate(RmanRuleParameterValue rmanRuleParameterValue) {

		rmanRuleParameterValue.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
		rmanRuleParameterValue.setLastUpdatedBy(BaseListener.getCurrentUserId());

	}
	
	@PostPersist
	public void postPersist(RmanRuleParameterValue rmanRuleParameterValue) {
/**		perform(rmanRuleParameterValue,Action.INSERTED); */
	}
	

	@PostUpdate
	public void postUpdate(RmanRuleParameterValue rmanRuleParameterValue) {
/**		perform(rmanRuleParameterValue,Action.UPDATED); */
		
	}
	
	@PostRemove
	public void postRemove(RmanRuleParameterValue rmanRuleParameterValue) {
/**		perform(rmanRuleParameterValue,Action.DELETED); */
	}
	
	@Transactional(TxType.MANDATORY)
    private void perform(RmanRuleParameterValue rmanRuleParameterValue, Action action) {
		EntityManager entityManager = BeanUtil.getBean(EntityManager.class);
        RevmantraUtils.createLog(entityManager, "ARRANGEMENT RULE PARAMETERS", "", action.name(),String.valueOf(rmanRuleParameterValue.getParameterValueId()),rmanRuleParameterValue.getRmanEntityParametersV()!=null?rmanRuleParameterValue.getRmanEntityParametersV().getParameterName():"",BaseListener.getCurrentUser());
	}


}
