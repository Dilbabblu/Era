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
import com.forsys.revmantra.model.RmanFmvRulesDefParaValue;
import com.forsys.revmantra.utils.BeanUtil;
import com.forsys.revmantra.utils.RevmantraUtils;

public class RmanFmvRulesDefParaValueListener {

	/**
	 * automatic property set before any database persistence
	 */
	@PrePersist
	public void prePersist(RmanFmvRulesDefParaValue rmanFmvRulesDefParaValue) {
		rmanFmvRulesDefParaValue.setCreationDate(new Timestamp(System.currentTimeMillis()));
		rmanFmvRulesDefParaValue.setCreatedBy(BaseListener.getCurrentUserId());
		rmanFmvRulesDefParaValue.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
		rmanFmvRulesDefParaValue.setLastUpdatedBy(BaseListener.getCurrentUserId());
		
	}
	@PreUpdate
	public void preUpdate(RmanFmvRulesDefParaValue rmanFmvRulesDefParaValue) {
		rmanFmvRulesDefParaValue.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
		rmanFmvRulesDefParaValue.setLastUpdatedBy(BaseListener.getCurrentUserId());
		
	}
	
	@PostPersist
	public void postPersist(RmanFmvRulesDefParaValue rmanFmvRulesDefParaValue) {
/**		perform(rmanFmvRulesDefParaValue,Action.INSERTED); */
	}
	

	@PostUpdate
	public void postUpdate(RmanFmvRulesDefParaValue rmanFmvRulesDefParaValue) {
/**		perform(rmanFmvRulesDefParaValue,Action.UPDATED); */
		
	}
	
	@PostRemove
	public void postRemove(RmanFmvRulesDefParaValue rmanFmvRulesDefParaValue) {
/**		perform(rmanFmvRulesDefParaValue,Action.DELETED); */
	}
	
	@Transactional(TxType.MANDATORY)
    private void perform(RmanFmvRulesDefParaValue rmanFmvRulesDefParaValue, Action action) {
		EntityManager entityManager = BeanUtil.getBean(EntityManager.class);
        RevmantraUtils.createLog(entityManager, "SSP RULE PARAMETERS", "",action.name(),String.valueOf(rmanFmvRulesDefParaValue.getParameterValueId()),rmanFmvRulesDefParaValue.getRmanEntityParametersV()!=null? rmanFmvRulesDefParaValue.getRmanEntityParametersV().getParameterName():"",BaseListener.getCurrentUser());
		
    }

}
