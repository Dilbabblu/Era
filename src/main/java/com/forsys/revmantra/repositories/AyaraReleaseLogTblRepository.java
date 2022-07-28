package com.forsys.revmantra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.AyaraReleaseLogTbl;

@RepositoryRestResource(collectionResourceRel = "AYARA_RELEASE_LOG_TBL", path = "AYARA_RELEASE_LOG_TBL")
public interface AyaraReleaseLogTblRepository extends PagingAndSortingRepository<AyaraReleaseLogTbl, java.math.BigDecimal>, JpaRepository<AyaraReleaseLogTbl, java.math.BigDecimal>, JpaSpecificationExecutor<AyaraReleaseLogTbl> {

    

}
