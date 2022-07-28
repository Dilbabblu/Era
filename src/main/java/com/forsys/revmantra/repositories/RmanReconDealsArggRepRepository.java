package com.forsys.revmantra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.RmanReconDealsArggRep;

@RepositoryRestResource(collectionResourceRel = "RMAN_RECON_DEALS_ARGG_REP", path = "RMAN_RECON_DEALS_ARGG_REP")
public interface RmanReconDealsArggRepRepository extends PagingAndSortingRepository<RmanReconDealsArggRep, java.lang.String>, JpaRepository<RmanReconDealsArggRep, java.lang.String>, JpaSpecificationExecutor<RmanReconDealsArggRep> {

    

}
