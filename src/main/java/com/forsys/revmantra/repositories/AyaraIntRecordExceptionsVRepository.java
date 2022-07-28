package com.forsys.revmantra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.AyaraIntRecordExceptionsV;

@RepositoryRestResource(collectionResourceRel = "AYARA_INT_RECORD_EXCEPTIONS_V", path = "AYARA_INT_RECORD_EXCEPTIONS_V")
public interface AyaraIntRecordExceptionsVRepository extends PagingAndSortingRepository<AyaraIntRecordExceptionsV, java.math.BigDecimal>, JpaRepository<AyaraIntRecordExceptionsV, java.math.BigDecimal>, JpaSpecificationExecutor<AyaraIntRecordExceptionsV> {

    

}
