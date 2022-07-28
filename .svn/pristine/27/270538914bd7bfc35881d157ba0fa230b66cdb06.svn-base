package com.forsys.revmantra.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.RmanFcBuckets;

@RepositoryRestResource(collectionResourceRel = "RMAN_FC_BUCKETS", path = "RMAN_FC_BUCKETS")
public interface RmanFcBucketsRepository extends PagingAndSortingRepository<RmanFcBuckets, java.math.BigDecimal>,
		JpaRepository<RmanFcBuckets, java.math.BigDecimal>, JpaSpecificationExecutor<RmanFcBuckets> {

	@Query("select f from RmanFcBuckets f where CURRENT_DATE between f.startDate and case when f.endDate is null then CURRENT_DATE else f.endDate end")
	List<RmanFcBuckets> RmanFcBucketsActiveList();
}
