package com.forsys.revmantra.listener;

import java.sql.Timestamp;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.forsys.revmantra.model.RmanGlAccounts;

public class RmanGlAccountsListener {

	/**
	 * automatic property set before any database persistence
	 */
	@PrePersist
	public void prePersist(RmanGlAccounts rmanGlAccounts) {
		rmanGlAccounts.setCreatedBy(BaseListener.getCurrentUserId());
		rmanGlAccounts.setCreationDate(new Timestamp(System.currentTimeMillis()));
		rmanGlAccounts.setLastUpdatedBy(BaseListener.getCurrentUserId());
		rmanGlAccounts.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
	}

	@PreUpdate
	public void preUpdate(RmanGlAccounts rmanGlAccounts) {
		rmanGlAccounts.setLastUpdatedBy(BaseListener.getCurrentUserId());
		rmanGlAccounts.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
	}

}
