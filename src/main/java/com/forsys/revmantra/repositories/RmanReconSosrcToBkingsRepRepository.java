package com.forsys.revmantra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.RmanReconSosrcToBkingsRep;

@RepositoryRestResource(collectionResourceRel = "RMAN_RECON_SOSRC_TO_BKINGS_REP", path = "RMAN_RECON_SOSRC_TO_BKINGS_REP")
public interface RmanReconSosrcToBkingsRepRepository extends PagingAndSortingRepository<RmanReconSosrcToBkingsRep, java.lang.String>, JpaRepository<RmanReconSosrcToBkingsRep, java.lang.String>, JpaSpecificationExecutor<RmanReconSosrcToBkingsRep> {

    

}
