package com.forsys.revmantra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.RmanLookupsV;

@RepositoryRestResource(collectionResourceRel = "RMAN_LOOKUPS_V", path = "RMAN_LOOKUPS_V")
public interface RmanLookupsVRepository extends PagingAndSortingRepository<RmanLookupsV, java.lang.String>, JpaRepository<RmanLookupsV, java.lang.String>, JpaSpecificationExecutor<RmanLookupsV> {

	RmanLookupsV findBylookupTypeNameAndLookupDescription(String lookupTypeName,String LookUpDescription);
	RmanLookupsV findBylookupTypeNameAndLookupCode(String lookupTypeName,String LookUpCode);

}
