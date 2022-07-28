package com.forsys.revmantra.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.AyaraDocTransactionsInt;

@RepositoryRestResource(collectionResourceRel = "AYARA_DOC_TRANSACTIONS_INT", path = "AYARA_DOC_TRANSACTIONS_INT")
public interface AyaraDocTransactionsIntRepository extends PagingAndSortingRepository<AyaraDocTransactionsInt, java.math.BigDecimal>, JpaRepository<AyaraDocTransactionsInt, java.math.BigDecimal>, JpaSpecificationExecutor<AyaraDocTransactionsInt> {

    List<AyaraDocTransactionsInt> findByProcessFlagAndProcessId(String pProcessFlg,BigDecimal pProcessId);
    
    @Query(value = "SELECT DOCUMENT_LINE_ID,EXCEPTION_MESSAGE FROM AYARA_DOC_TRANSACTIONS_INT "
			+ "WHERE PROCESS_FLAG='E' AND EXCEPTION_MESSAGE IS NOT NULL AND PROCESS_ID=:processId ", nativeQuery = true)
	List<Object[]> getFailedDocumentsList(@Param("processId") BigDecimal processId);
	
	@Query(value = "SELECT HEADER_ATTRIBUTE15 FROM AYARA_DOC_TRANSACTIONS_INT "
			+ "WHERE PROCESS_FLAG='N' AND EXCEPTION_MESSAGE IS NULL AND PROCESS_ID=:processId GROUP BY HEADER_ATTRIBUTE15", nativeQuery = true)
	List<Object[]> getProcessedDocKeyList(@Param("processId") BigDecimal processId);
}
