package com.forsys.revmantra.listener;

import java.sql.Timestamp;

import javax.persistence.PrePersist;

import com.forsys.revmantra.model.AyaraFileUploadStorage;

public class AyaraFileUploadStorageListener {
	@PrePersist
    public void prePersist(AyaraFileUploadStorage ayaraFileUploadStorage) {
		ayaraFileUploadStorage.setCreationDate(new Timestamp(System.currentTimeMillis()));
		ayaraFileUploadStorage.setCreatedBy(BaseListener.getCurrentUserId());
    	
    }
     
}
