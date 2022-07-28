package com.forsys.revmantra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.cpk.id.RmanInvoicesStgPkId;
import com.forsys.revmantra.model.RmanInvoicesStg;

@RepositoryRestResource(collectionResourceRel = "RMAN_INVOICES_STG", path = "RMAN_INVOICES_STG")
public interface RmanInvoicesStgRepository extends PagingAndSortingRepository<RmanInvoicesStg, RmanInvoicesStgPkId>, JpaRepository<RmanInvoicesStg, RmanInvoicesStgPkId>, JpaSpecificationExecutor<RmanInvoicesStg> {

    

}
