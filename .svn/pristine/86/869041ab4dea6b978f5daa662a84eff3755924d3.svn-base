package com.forsys.revmantra.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.SSPBooks;

@RepositoryRestResource(collectionResourceRel = "AYARA_SSP_BOOKS", path = "AYARA_SSP_BOOKS")
public interface SSPBooksRepository  extends PagingAndSortingRepository<SSPBooks, java.math.BigDecimal>,
JpaRepository<SSPBooks, java.math.BigDecimal>, JpaSpecificationExecutor<SSPBooks>{
	
	List<SSPBooks> findByBookName(String bookName);
	List<SSPBooks> findByStatus(String status);
	List<SSPBooks> findByStatusIgnoreCase(String status);
	
}
