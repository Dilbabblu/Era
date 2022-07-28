package com.forsys.revmantra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.RmanCurrency;

@RepositoryRestResource(collectionResourceRel = "RMAN_CURRENCY", path = "RMAN_CURRENCY")
public interface RmanCurrencyRepository extends PagingAndSortingRepository<RmanCurrency, java.lang.String>, JpaRepository<RmanCurrency, java.lang.String>, JpaSpecificationExecutor<RmanCurrency> {

    

}
