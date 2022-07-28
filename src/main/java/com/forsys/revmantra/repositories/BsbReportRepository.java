package com.forsys.revmantra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.BsbReport;

@RepositoryRestResource(collectionResourceRel = "BSB_REPORT", path = "BSB_REPORT")
public interface BsbReportRepository extends PagingAndSortingRepository<BsbReport, java.lang.String>, JpaRepository<BsbReport, java.lang.String>, JpaSpecificationExecutor<BsbReport> {

    

}
