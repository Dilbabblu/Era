package com.forsys.revmantra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.RmanFileUploadJobs;

@RepositoryRestResource(collectionResourceRel = "RMAN_FILE_UPLOAD_JOBS", path = "RMAN_FILE_UPLOAD_JOBS")
public interface RmanFileUploadJobsRepository extends PagingAndSortingRepository<RmanFileUploadJobs, java.lang.String>, JpaRepository<RmanFileUploadJobs, java.lang.String>, JpaSpecificationExecutor<RmanFileUploadJobs> {
	
	/*
	 * AYAR-1801 Added the SpringDataJPA Method findByJobId to fetch the Job Info based on the jobId
	 * By Chandra Kota on 05-JAN-2021
	 */
	RmanFileUploadJobs findByJobId(String jobId);

}
