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
import com.forsys.revmantra.model.RmanContTemplate;
import com.forsys.revmantra.utils.BeanUtil;
import com.forsys.revmantra.utils.RevmantraUtils;

public class RmanContTemplateListener {

    /**
     * automatic property set before any database persistence
     */
    
    @PrePersist
    public void prePersist(RmanContTemplate rmanContTemplate) {
        
        rmanContTemplate.setCreationDate(new Timestamp(System.currentTimeMillis()));
        rmanContTemplate.setCreatedBy(BaseListener.getCurrentUserId());
        rmanContTemplate.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
        rmanContTemplate.setLastUpdatedBy(BaseListener.getCurrentUserId());
    }   
    
    @PreUpdate
    public void preUpdate(RmanContTemplate rmanContTemplate) {
        
        rmanContTemplate.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
        rmanContTemplate.setLastUpdatedBy(BaseListener.getCurrentUserId());
    }  
    
    @PostPersist
	public void postPersist(RmanContTemplate rmanContTemplate) {
/**		perform(rmanContTemplate,Action.INSERTED); */
	}
	

	@PostUpdate
	public void postUpdate(RmanContTemplate rmanContTemplate) {
/**		perform(rmanContTemplate,Action.UPDATED); */
		
	}
	
	@PostRemove
	public void postRemove(RmanContTemplate rmanContTemplate) {
/**		perform(rmanContTemplate,Action.DELETED); */
	}
	
	@Transactional(TxType.MANDATORY)
    private void perform(RmanContTemplate rmanContTemplate, Action action) {
		EntityManager entityManager = BeanUtil.getBean(EntityManager.class);
        RevmantraUtils.createLog(entityManager, "CONTINGENCY TEMPLATES", "", action.name(),String.valueOf(rmanContTemplate.getTemplateId()),rmanContTemplate.getTemplateName(),BaseListener.getCurrentUser());
		
    }
    
}
