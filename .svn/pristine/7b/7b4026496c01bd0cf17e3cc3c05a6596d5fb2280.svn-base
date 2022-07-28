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
import com.forsys.revmantra.model.RmanProducts;
import com.forsys.revmantra.utils.BeanUtil;
import com.forsys.revmantra.utils.RevmantraUtils;

public class RmanProductsListener {

	/**
	 * automatic property set before any database persistence
	 */
	@PrePersist
	public void prePersist(RmanProducts rmanProducts) {
		rmanProducts.setCreatedBy(BaseListener.getCurrentUserId());
		rmanProducts.setCreationDate(new Timestamp(System.currentTimeMillis()));
		rmanProducts.setLastUpdatedBy(BaseListener.getCurrentUserId());
		rmanProducts.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
	}

	@PreUpdate
	public void preUpdate(RmanProducts rmanProducts) {
		rmanProducts.setLastUpdatedBy(BaseListener.getCurrentUserId());
		rmanProducts.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
	}
	

	@PostPersist
	public void postPersist(RmanProducts rmanProducts) {
/**		perform(rmanProducts,Action.INSERTED); */
	}
	

	@PostUpdate
	public void postUpdate(RmanProducts rmanProducts) {
/**		perform(rmanProducts,Action.UPDATED); */
		
	}
	
	@PostRemove
	public void postRemove(RmanProducts rmanProducts) {
/**		perform(rmanProducts,Action.DELETED); */
	}
	
	@Transactional(TxType.MANDATORY)
    private void perform(RmanProducts rmanProducts, Action action) {
		EntityManager entityManager = BeanUtil.getBean(EntityManager.class);
        RevmantraUtils.createLog(entityManager, "PRODUCTS", "", action.name(),String.valueOf(rmanProducts.getProductId()),rmanProducts.getProductName(),BaseListener.getCurrentUser());
		
    }

}
