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
import com.forsys.revmantra.model.RmanUserResponsibilities;
import com.forsys.revmantra.utils.BeanUtil;
import com.forsys.revmantra.utils.RevmantraUtils;

public class RmanUserResponsibilitiesListener {

	/**
	 * automatic property set before any database persistence
	 */
	@PrePersist
	public void prePersist(RmanUserResponsibilities rmanUserResponsibilities) {
		rmanUserResponsibilities.setCreationDate(new Timestamp(System.currentTimeMillis()));
		rmanUserResponsibilities.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
		rmanUserResponsibilities.setCreatedBy(BaseListener.getCurrentUserId());
		rmanUserResponsibilities.setLastUpdatedBy(BaseListener.getCurrentUserId());
		rmanUserResponsibilities.setCreatedUser(BaseListener.getUserInfo().getFullName());
		rmanUserResponsibilities.setUpdatedUser(BaseListener.getUserInfo().getFullName());

	}

	@PreUpdate
	public void preUpdate(RmanUserResponsibilities rmanUserResponsibilities) {
		rmanUserResponsibilities.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
		rmanUserResponsibilities.setLastUpdatedBy(BaseListener.getCurrentUserId());
		rmanUserResponsibilities.setUpdatedUser(BaseListener.getUserInfo().getFullName());
	}
	
	@PostPersist
	public void postPersist(RmanUserResponsibilities rmanUserResponsibilities) {
/**		perform(rmanUserResponsibilities,Action.INSERTED); */
	}
	

	@PostUpdate
	public void postUpdate(RmanUserResponsibilities rmanUserResponsibilities) {
/**		perform(rmanUserResponsibilities,Action.UPDATED); */
		
	}
	
	@PostRemove
	public void postRemove(RmanUserResponsibilities rmanUserResponsibilities) {
/**		perform(rmanUserResponsibilities,Action.DELETED); */
	}
	
	
	@Transactional(TxType.MANDATORY)
    private void perform(RmanUserResponsibilities rmanUserResponsibilities, Action action) {
		EntityManager entityManager = BeanUtil.getBean(EntityManager.class);
			RevmantraUtils.createLog(entityManager, "USER RESPONSIBILITIES", "", action.name(),String.valueOf(rmanUserResponsibilities.getRmanUserId())+"~"+String.valueOf(rmanUserResponsibilities.getResponsibilityId()),rmanUserResponsibilities.getRmanResponsibilities()!=null?rmanUserResponsibilities.getRmanResponsibilities().getResponsibilityName():"",BaseListener.getCurrentUser());
	}

}
