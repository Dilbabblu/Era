package com.forsys.revmantra.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.AyaraPendingSubmissionApprovalsV;

@RepositoryRestResource(collectionResourceRel = "AYARA_PENDING_SUBMISSION_APPROVALS_V", path = "AYARA_PENDING_SUBMISSION_APPROVALS_V")
public interface AyaraPendingSubmissionApprovalsVRepository extends PagingAndSortingRepository<AyaraPendingSubmissionApprovalsV, java.math.BigDecimal>, JpaRepository<AyaraPendingSubmissionApprovalsV, java.math.BigDecimal>, JpaSpecificationExecutor<AyaraPendingSubmissionApprovalsV> {

	Page<AyaraPendingSubmissionApprovalsV> findByUserName(String userName,Pageable paging);

}
