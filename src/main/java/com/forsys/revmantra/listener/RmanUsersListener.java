package com.forsys.revmantra.listener;

import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.forsys.revmantra.model.Action;
import com.forsys.revmantra.model.RmanUsers;
import com.forsys.revmantra.utils.BeanUtil;
import com.forsys.revmantra.utils.RevmantraUtils;

public class RmanUsersListener {

	/**
	 * automatic property set before any database persistence
	 */
	@PrePersist
	public void prePersist(RmanUsers rmanUsers) {
		rmanUsers.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
		rmanUsers.setCreationDate(new Timestamp(System.currentTimeMillis()));
		rmanUsers.setLastUpdatedBy(BaseListener.getCurrentUserId());
		rmanUsers.setCreatedBy(BaseListener.getCurrentUserId());
		rmanUsers.setCreatedUser(BaseListener.getUserInfo().getFullName());
		rmanUsers.setUpdatedUser(BaseListener.getUserInfo().getFullName());
		rmanUsers.setAttribute4(UUID.randomUUID().toString());
	}

	@PreUpdate
	public void preUpdate(RmanUsers rmanUsers) {
		if(null != BaseListener.getCurrentUserId() && null != BaseListener.getUserInfo()) {
			rmanUsers.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
			rmanUsers.setLastUpdatedBy(BaseListener.getCurrentUserId());
			rmanUsers.setUpdatedUser(BaseListener.getUserInfo().getFullName());
		}
	}
	
	@PostPersist
	public void postPersist(RmanUsers rmanUsers) {
/**		perform(rmanUsers,Action.INSERTED); */
	}
	

	@PostUpdate
	public void postUpdate(RmanUsers rmanUsers) {
/**		perform(rmanUsers,Action.UPDATED); */
		
	}
	
	@PostRemove
	public void postRemove(RmanUsers rmanUsers) {
/**		perform(rmanUsers,Action.DELETED); */
	}
	
	@Transactional(TxType.MANDATORY)
    private void perform(RmanUsers rmanUsers, Action action) {
		EntityManager entityManager = BeanUtil.getBean(EntityManager.class);
        RevmantraUtils.createLog(entityManager, "USERS", "", action.name(),String.valueOf(rmanUsers.getRmanUserId()),rmanUsers.getUserName(),BaseListener.getCurrentUser());
		
    }

}
