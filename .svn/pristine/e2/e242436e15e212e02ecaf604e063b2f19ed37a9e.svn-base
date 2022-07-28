package com.forsys.revmantra.repositories;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.AyaraActiveDelegateUsersListV;

@RepositoryRestResource(collectionResourceRel = "AYARA_ACTIVE_DELEGATE_USERS_LIST_V", path = "AYARA_ACTIVE_DELEGATE_USERS_LIST_V")
public interface AyaraActiveDelegateUsersListVRepository extends PagingAndSortingRepository<AyaraActiveDelegateUsersListV, java.math.BigDecimal>,JpaRepository<AyaraActiveDelegateUsersListV, BigDecimal>,JpaSpecificationExecutor<AyaraActiveDelegateUsersListV> {
	AyaraActiveDelegateUsersListV findByUserName(String userName);
}
