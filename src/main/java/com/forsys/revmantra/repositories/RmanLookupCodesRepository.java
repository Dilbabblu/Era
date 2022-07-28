package com.forsys.revmantra.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.RmanLookupCodes;

@RepositoryRestResource(collectionResourceRel = "RMAN_LOOKUP_CODES", path = "RMAN_LOOKUP_CODES")
public interface RmanLookupCodesRepository extends PagingAndSortingRepository<RmanLookupCodes, java.math.BigDecimal>,
		JpaRepository<RmanLookupCodes, java.math.BigDecimal>, JpaSpecificationExecutor<RmanLookupCodes> {
	@Query("select lc from RmanLookupCodes lc where lc.lookupTypeCode  IN (:typeNamesList) ")
	List<RmanLookupCodes> fetchAllLookupCodes(@Param("typeNamesList")List<String> lTypeList);
}
