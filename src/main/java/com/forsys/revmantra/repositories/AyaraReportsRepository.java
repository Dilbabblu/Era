package com.forsys.revmantra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.AyaraReports;

@RepositoryRestResource(collectionResourceRel = "AYARA_REPORTS", path = "AYARA_REPORTS")
public interface AyaraReportsRepository extends PagingAndSortingRepository<AyaraReports, java.math.BigDecimal>, JpaRepository<AyaraReports, java.math.BigDecimal>, JpaSpecificationExecutor<AyaraReports> {

    

}
