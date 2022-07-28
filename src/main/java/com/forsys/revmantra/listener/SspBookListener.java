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
import com.forsys.revmantra.model.SSPBooks;
import com.forsys.revmantra.utils.BeanUtil;
import com.forsys.revmantra.utils.RevmantraUtils;

public class SspBookListener {
	
	@PrePersist
	public void prePersist(SSPBooks sspBook) {
		sspBook.setCreationDate(new Timestamp(System.currentTimeMillis()));
		sspBook.setCreatedBy(BaseListener.getCurrentUserId());
		sspBook.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
		sspBook.setLastUpdatedBy(BaseListener.getCurrentUserId());
	}
	
	@PreUpdate
	public void preUpdate(SSPBooks sspBook) {
		sspBook.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
		sspBook.setLastUpdatedBy(BaseListener.getCurrentUserId());
	}
	
	@PostPersist
	public void postPersist(SSPBooks sspBook) {
		perform(sspBook, Action.INSERTED);
	}
	
	@PostUpdate
	public void postUpdate(SSPBooks sspBook) {
		perform(sspBook, Action.UPDATED);
	}
	
	@PostRemove
	public void postRemove(SSPBooks sspBook) {
		perform(sspBook, Action.DELETED);
	}
	
	@Transactional(TxType.MANDATORY)
    private void perform(SSPBooks sspBook, Action action) {
		EntityManager entityManager = BeanUtil.getBean(EntityManager.class);
        RevmantraUtils.createLog(entityManager, "SSP BOOK", "STATUS", action.name(),String.valueOf(sspBook.getBookId()),sspBook.getBookName(),BaseListener.getCurrentUser());
	}

}

