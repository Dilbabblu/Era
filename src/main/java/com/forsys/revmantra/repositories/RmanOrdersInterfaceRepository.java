package com.forsys.revmantra.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.cpk.id.RmanOrdersInterfacePkId;
import com.forsys.revmantra.model.RmanOrdersInterface;

/**@RepositoryRestResource(collectionResourceRel = "RMAN_ORDERS_INTERFACE", path = "RMAN_ORDERS_INTERFACE") */
@RepositoryRestResource()
public interface RmanOrdersInterfaceRepository
		extends PagingAndSortingRepository<RmanOrdersInterface, RmanOrdersInterfacePkId>,
		JpaRepository<RmanOrdersInterface, RmanOrdersInterfacePkId>, JpaSpecificationExecutor<RmanOrdersInterface> {

	/**
	 * @Query(
	 * "select o from RmanOrdersInterface o where o.interfaceStatus='E' and " +
	 * "(o.lineStatus in (select l.lookupCode from RmanLookupCodes l where l.lookupTypeCode='ACCOUNTING_TRIGGER')"
	 * + "or o.lineStatus='CLOSED') " +
	 * "and (:orderNumber is null or o.orderNumber=:orderNumber) and (:sourceLineNumber is null or o.sourceLineNumber=:sourceLineNumber)"
	 * ) Page<RmanOrdersInterface> shippedOrders(@Param("orderNumber")
	 * BigDecimal orderNumber,@Param("sourceLineNumber") String
	 * sourceLineNumber,Pageable pageRequest);
	 * 
	 * @Query(
	 * "select o from RmanOrdersInterface o where o.interfaceStatus='E' and " +
	 * "o.lineStatus not in (select l.lookupCode from RmanLookupCodes l where l.lookupTypeCode='ACCOUNTING_TRIGGER')"
	 * + "and  o.lineStatus!='CLOSED' " +
	 * "and (:orderNumber is null or o.orderNumber=:orderNumber) and (:sourceLineNumber is null or o.sourceLineNumber=:sourceLineNumber)"
	 * ) Page<RmanOrdersInterface> bookedOrders(@Param("orderNumber") BigDecimal
	 * orderNumber,@Param("sourceLineNumber") String sourceLineNumber,Pageable
	 * pageRequest);
	 */

	@Query("select o from RmanOrdersInterface o where o.interfaceStatus='E' and " + "o.fileType='SHIP' "
			+ "and (:orderNumber is null or o.orderNumber=:orderNumber) and (:sourceLineNumber is null or o.sourceLineNumber=:sourceLineNumber)")
	Page<RmanOrdersInterface> shippedOrders(@Param("orderNumber") String orderNumber,
			@Param("sourceLineNumber") String sourceLineNumber, Pageable pageRequest);

	@Query("select o from RmanOrdersInterface o where o.interfaceStatus='E' and " + "o.fileType='BOOK' "
			+ "and (:orderNumber is null or o.orderNumber=:orderNumber) and (:sourceLineNumber is null or o.sourceLineNumber=:sourceLineNumber)")
	Page<RmanOrdersInterface> bookedOrders(@Param("orderNumber") String orderNumber,
			@Param("sourceLineNumber") String sourceLineNumber, Pageable pageRequest);

	@Modifying
	@Query(value = "delete from rman_orders_interface where interface_status='E' and file_type=?1 and source_line_id in (?2)", nativeQuery = true)
	void deleteOrdersInterface(String fileType, BigDecimal[] sourceLineId);

	List<RmanOrdersInterface> findByInterfaceStatusAndGroupId(String status, String groupId);
	
	@Query(value = "SELECT HEADER_ATTRIBUTE5,ERROR_MESSAGE FROM RMAN_ORDERS_INTERFACE "
			+ "WHERE INTERFACE_STATUS='E' AND GROUP_ID=:groupId", nativeQuery = true)
	List<Object[]> getFailedOrdersList(@Param("groupId") String groupId);
	
	@Query(value = "SELECT LINE_ATTRIBUTE1,ERROR_MESSAGE FROM RMAN_ORDERS_INTERFACE "
			+ "WHERE INTERFACE_STATUS='E' AND ERROR_MESSAGE IS NOT NULL AND GROUP_ID=:groupId ", nativeQuery = true)
	List<Object[]> getSfFailedOrdersList(@Param("groupId") String groupId);
}
