package com.forsys.revmantra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.RmanFmvRulesExportV;

@RepositoryRestResource(collectionResourceRel = "RMAN_FMV_RULES_EXPORT_V", path = "RMAN_FMV_RULES_EXPORT_V")
public interface RmanFmvRulesExportVRepository extends PagingAndSortingRepository<RmanFmvRulesExportV, java.lang.String>, JpaRepository<RmanFmvRulesExportV, java.lang.String>, JpaSpecificationExecutor<RmanFmvRulesExportV> {

    

}
