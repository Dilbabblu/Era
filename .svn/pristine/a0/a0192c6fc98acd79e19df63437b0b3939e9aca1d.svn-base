package com.forsys.revmantra.listener;

import java.sql.Timestamp;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.forsys.revmantra.model.RmanFileUploadJobs;

public class RmanFileUploadJobsListener {

	/**
     * automatic property set before any database persistence
     * 
     * AYAR-1801 Commented the updated who columns with UserId and UserName by using BaseListener Class to avoid conflict with the Async Process 
     * By Chandra Kota on 05-JAN-2021
     */
    @PrePersist
    public void prePersist(RmanFileUploadJobs rmanFileUploadJobs) {
//    	rmanFileUploadJobs.setCreatedBY(BaseListener.getCurrentUserId());
    	rmanFileUploadJobs.setCreationDate(new Timestamp(System.currentTimeMillis()));
//    	rmanFileUploadJobs.setLastUpdatedBy(BaseListener.getCurrentUserId());
    	rmanFileUploadJobs.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
    	//rmanFileUploadJobs.setAttribute2(BaseListener.getUserInfo().getFullName());
    }
    
    @PreUpdate
    public void preUpdate(RmanFileUploadJobs rmanFileUploadJobs) {
//    	rmanFileUploadJobs.setLastUpdatedBy(BaseListener.getCurrentUserId());
    	rmanFileUploadJobs.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
    }

}
