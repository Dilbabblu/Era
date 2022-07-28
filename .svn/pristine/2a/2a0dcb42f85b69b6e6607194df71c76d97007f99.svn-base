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
import com.forsys.revmantra.model.RmanResponsibilities;
import com.forsys.revmantra.utils.BeanUtil;
import com.forsys.revmantra.utils.RevmantraUtils;

public class RmanResponsibilitiesListener {

	/**
	 * automatic property set before any database persistence
	 */
	@PrePersist
	public void prePersist(RmanResponsibilities rmanResponsibilities) {
		rmanResponsibilities.setCreatedBy(BaseListener.getCurrentUserId());
		rmanResponsibilities.setCreationDate(new Timestamp(System.currentTimeMillis()));
		rmanResponsibilities.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
		rmanResponsibilities.setLastUpdatedBy(BaseListener.getCurrentUserId());
		rmanResponsibilities.setCreatedUser(BaseListener.getUserInfo().getFullName());
		rmanResponsibilities.setUpdatedUser(BaseListener.getUserInfo().getFullName());

	}

	@PreUpdate
	public void preUpdate(RmanResponsibilities rmanResponsibilities) {
		rmanResponsibilities.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
		rmanResponsibilities.setLastUpdatedBy(BaseListener.getCurrentUserId());
		rmanResponsibilities.setUpdatedUser(BaseListener.getUserInfo().getFullName());

	}
	
	@PostPersist
	public void postPersist(RmanResponsibilities rmanResponsibilities) {
/**		perform(rmanResponsibilities,Action.INSERTED); */
	}
	

	@PostUpdate
	public void postUpdate(RmanResponsibilities rmanResponsibilities) {
/**		perform(rmanResponsibilities,Action.UPDATED); */
		
	}
	
	@PostRemove
	public void postRemove(RmanResponsibilities rmanResponsibilities) {
/**		perform(rmanResponsibilities,Action.DELETED); */
	}
	
	@Transactional(TxType.MANDATORY)
    private void perform(RmanResponsibilities rmanResponsibilities, Action action) {
		EntityManager entityManager = BeanUtil.getBean(EntityManager.class);
        RevmantraUtils.createLog(entityManager, "RESPONSIBILITIES", "", action.name(),String.valueOf(rmanResponsibilities.getResponsibilityId()),rmanResponsibilities.getResponsibilityName(),BaseListener.getCurrentUser());
		
    }

}
