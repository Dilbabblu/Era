package com.forsys.revmantra.listener;

import java.sql.Timestamp;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.forsys.revmantra.model.RmanIntfDealDetails;

public class RmanIntfDealDetailsListener {
	
	@PrePersist
	public void prePersist(RmanIntfDealDetails rmanIntfDealDetails) {

		rmanIntfDealDetails.setCreationDate(new Timestamp(System.currentTimeMillis()));
		rmanIntfDealDetails.setCreatedBy(BaseListener.getCurrentUserId());
	}
	
	@PreUpdate
	public void preUpdate(RmanIntfDealDetails rmanIntfDealDetails) {

		rmanIntfDealDetails.setCreationDate(new Timestamp(System.currentTimeMillis()));
		rmanIntfDealDetails.setCreatedBy(BaseListener.getCurrentUserId());
	}

	
}
