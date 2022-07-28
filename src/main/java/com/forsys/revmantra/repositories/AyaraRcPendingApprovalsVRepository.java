package com.forsys.revmantra.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.AyaraRcPendingApprovalsV;

@RepositoryRestResource(collectionResourceRel = "AYARA_RC_PENDING_APPROVALS_V", path = "AYARA_RC_PENDING_APPROVALS_V")
public interface AyaraRcPendingApprovalsVRepository extends PagingAndSortingRepository<AyaraRcPendingApprovalsV, java.math.BigDecimal>, JpaRepository<AyaraRcPendingApprovalsV, java.math.BigDecimal>, JpaSpecificationExecutor<AyaraRcPendingApprovalsV> {

	Page<AyaraRcPendingApprovalsV> findByDelegateUserOrOriginalUser(String delegateUser, String originalUser, Pageable paging);

}
