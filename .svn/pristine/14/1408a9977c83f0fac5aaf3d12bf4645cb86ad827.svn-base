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
import com.forsys.revmantra.model.RmanRoleFunctions;
import com.forsys.revmantra.utils.BeanUtil;
import com.forsys.revmantra.utils.RevmantraUtils;

public class RmanRoleFunctionsListener {

	@PrePersist
	public void prePersist(RmanRoleFunctions rmanRoleFunctions) {
		rmanRoleFunctions.setCreatedBy(BaseListener.getCurrentUserId());
		rmanRoleFunctions.setCreationDate(new Timestamp(System.currentTimeMillis()));
		rmanRoleFunctions.setLastUpdatedBy(BaseListener.getCurrentUserId());
		rmanRoleFunctions.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
		rmanRoleFunctions.setCreatedUser(BaseListener.getUserInfo().getFullName());
		rmanRoleFunctions.setUpdatedUser(BaseListener.getUserInfo().getFullName());
	}
	
	@PreUpdate
	public void preUpdate(RmanRoleFunctions rmanRoleFunctions) {
		rmanRoleFunctions.setLastUpdatedBy(BaseListener.getCurrentUserId());
		rmanRoleFunctions.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
		rmanRoleFunctions.setUpdatedUser(BaseListener.getUserInfo().getFullName());
	}
	
	@PostPersist
	public void postPersist(RmanRoleFunctions rmanRoleFunctions) {
/**		perform(rmanRoleFunctions,Action.INSERTED); */
	}
	

	@PostUpdate
	public void postUpdate(RmanRoleFunctions rmanRoleFunctions) {
/**		perform(rmanRoleFunctions,Action.UPDATED); */
		
	}
	
	
	@PostRemove
	public void postRemove(RmanRoleFunctions rmanRoleFunctions) {
/**		perform(rmanRoleFunctions,Action.DELETED); */
	}
	
	
	@Transactional(TxType.MANDATORY)
    private void perform(RmanRoleFunctions rmanRoleFunctions, Action action) {
		EntityManager entityManager = BeanUtil.getBean(EntityManager.class);
			RevmantraUtils.createLog(entityManager, "ROLE PERMISSIONS", "", action.name(),rmanRoleFunctions.getRoleid()+"~"+rmanRoleFunctions.getFunctionId(),"Function:"+rmanRoleFunctions.getFunctionId()+"~R:"+String.valueOf(rmanRoleFunctions.getRead())+"~W:"+String.valueOf(rmanRoleFunctions.getWrite())+"~U:"+String.valueOf(rmanRoleFunctions.getUpload()),BaseListener.getCurrentUser());
		
     }

}


