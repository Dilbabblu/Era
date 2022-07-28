package com.forsys.revmantra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.RmanReconRevtrigRecogRep;

@RepositoryRestResource(collectionResourceRel = "RMAN_RECON_REVTRIG_RECOG_REP", path = "RMAN_RECON_REVTRIG_RECOG_REP")
public interface RmanReconRevtrigRecogRepRepository extends PagingAndSortingRepository<RmanReconRevtrigRecogRep, java.lang.String>, JpaRepository<RmanReconRevtrigRecogRep, java.lang.String>, JpaSpecificationExecutor<RmanReconRevtrigRecogRep> {

    

}
