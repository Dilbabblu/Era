package com.forsys.revmantra.repositories;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.AyaraFileUploadStorage;

@RepositoryRestResource(collectionResourceRel = "AYARA_UPLOAD_FILE_STORAGE", path = "AYARA_UPLOAD_FILE_STORAGE")
public interface AyaraFileUploadStorageRepository extends PagingAndSortingRepository<AyaraFileUploadStorage, java.math.BigDecimal>, JpaRepository<AyaraFileUploadStorage, java.math.BigDecimal>, JpaSpecificationExecutor<AyaraFileUploadStorage> {
	AyaraFileUploadStorage findByProcessId(BigDecimal processId);
}
