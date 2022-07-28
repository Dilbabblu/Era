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
import com.forsys.revmantra.model.RmanRevenueTemplates;
import com.forsys.revmantra.utils.BeanUtil;
import com.forsys.revmantra.utils.RevmantraUtils;

public class RmanRevenueTemplatesListener {

	@PrePersist
	public void prePersist(RmanRevenueTemplates rmanRevenueTemplates) {

		rmanRevenueTemplates.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		rmanRevenueTemplates.setLastUpdatedDate(new Timestamp(System.currentTimeMillis()));
		rmanRevenueTemplates.setCreatedBy(BaseListener.getCurrentUserId());
		rmanRevenueTemplates.setLastUpdatedBy(BaseListener.getCurrentUserId());
	}

	@PreUpdate
	public void preUpdate(RmanRevenueTemplates rmanRevenueTemplates) {

		rmanRevenueTemplates.setLastUpdatedDate(new Timestamp(System.currentTimeMillis()));
		rmanRevenueTemplates.setLastUpdatedBy(BaseListener.getCurrentUserId());
	}
	
	@PostPersist
	public void postPersist(RmanRevenueTemplates rmanRevenueTemplates) {
/**		perform(rmanRevenueTemplates,Action.INSERTED); */
	}
	

	@PostUpdate
	public void postUpdate(RmanRevenueTemplates rmanRevenueTemplates) {
/**		perform(rmanRevenueTemplates,Action.UPDATED); */
		
	}
	
	@PostRemove
	public void postRemove(RmanRevenueTemplates rmanRevenueTemplates) {
/**		perform(rmanRevenueTemplates,Action.DELETED); */
	}
	
	@Transactional(TxType.MANDATORY)
    private void perform(RmanRevenueTemplates rmanRevenueTemplates, Action action) {
		EntityManager entityManager = BeanUtil.getBean(EntityManager.class);
        RevmantraUtils.createLog(entityManager, "REVENUE TEMPLATES", "", action.name(),String.valueOf(rmanRevenueTemplates.getRevenueTemplateId()),rmanRevenueTemplates.getTemplateName(),BaseListener.getCurrentUser());
		
    }

}
