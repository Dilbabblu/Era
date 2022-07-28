package com.forsys.revmantra.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.RmanUsers;

@RepositoryRestResource(collectionResourceRel = "RMAN_USERS", path = "RMAN_USERS")
public interface RmanUsersRepository extends PagingAndSortingRepository<RmanUsers, java.math.BigDecimal>,
		JpaRepository<RmanUsers, java.math.BigDecimal>, JpaSpecificationExecutor<RmanUsers> {

	RmanUsers save(RmanUsers rmanUser);

	RmanUsers findByUserNameIgnoreCase(final String userName);

	RmanUsers findByRmanUserId(final BigDecimal userId);
	
	RmanUsers findByRmanUserIdAndAttribute1(final BigDecimal userId,String entityId);
	
	RmanUsers findByUserNameIgnoreCaseAndEnabledFlag(final String userName,String enabledFlag);
	
	/**
	 * @author chandra.kota
	 * AYARA-1664
	 */
	@Query(value="select rman_user_id   \n"
			+ "      ,user_name      \n"
			+ "      ,email_address  \n"
			+ "      ,full_name      \n"
			+ "      ,entity_name    \n"
			+ "      ,entity_id      \n"
			+ "      ,user_role      \n"
			+ "      ,user_role_id   \n"
			+ "from ayara_active_delegate_users_list_v a\n"
			+ "WHERE EXISTS (SELECT 1 \n"
			+ "FROM ayara_active_delegate_users_list_v b\n"
			+ "WHERE a.user_role_id = b.user_role_id\n"
			+ "AND a.entity_id = b.entity_id\n"
			+ "AND a.user_name <> b.user_name\n"
			+ "AND b.user_name=:loggedUserName\n"
			+ ")",nativeQuery = true)
	List<Object[]> fetchDelegateUsersList(@Param("loggedUserName") String loggedUserName);
}
