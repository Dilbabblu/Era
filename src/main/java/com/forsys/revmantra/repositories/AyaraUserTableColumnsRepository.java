package com.forsys.revmantra.repositories;

import java.math.BigDecimal;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.cpk.id.AyaraUserTableColumnsPkId;
import com.forsys.revmantra.model.AyaraUserTableColumns;

@RepositoryRestResource(collectionResourceRel = "AYARA_USER_TABLE_COLUMNS", path = "AYARA_USER_TABLE_COLUMNS")
public interface AyaraUserTableColumnsRepository extends PagingAndSortingRepository<AyaraUserTableColumns, AyaraUserTableColumnsPkId>, 
										JpaRepository<AyaraUserTableColumns, AyaraUserTableColumnsPkId>, JpaSpecificationExecutor<AyaraUserTableColumns> {

	@Cacheable(cacheNames="userTableColumns", key="#p0.concat('-').concat(#p1).concat('-').concat(#p2)", unless="#result == null")
    AyaraUserTableColumns findByPageNameAndTableNameAndUserId(String pageName,String tableName,BigDecimal userId);
	
	@SuppressWarnings("unchecked")
	@CachePut(cacheNames="userTableColumns", key="#p0.pageName.concat('-').concat(#p0.tableName).concat('-').concat(#p0.userId)")
	AyaraUserTableColumns save(AyaraUserTableColumns ayaraUserTables);

}
