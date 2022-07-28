package com.forsys.revmantra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.RmanReconShippedSoTrgRep;

@RepositoryRestResource(collectionResourceRel = "RMAN_RECON_SHIPPED_SO_TRG_REP", path = "RMAN_RECON_SHIPPED_SO_TRG_REP")
public interface RmanReconShippedSoTrgRepRepository extends PagingAndSortingRepository<RmanReconShippedSoTrgRep, java.lang.String>, JpaRepository<RmanReconShippedSoTrgRep, java.lang.String>, JpaSpecificationExecutor<RmanReconShippedSoTrgRep> {

    

}
