package com.forsys.revmantra.repositories;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.RmanContTransLines;

@RepositoryRestResource(collectionResourceRel = "RMAN_CONT_TRANS_LINES", path = "RMAN_CONT_TRANS_LINES")
public interface RmanContTransLinesRepository extends PagingAndSortingRepository<RmanContTransLines, java.math.BigDecimal>, JpaRepository<RmanContTransLines, java.math.BigDecimal>, JpaSpecificationExecutor<RmanContTransLines>{

   @Procedure(name="rman_cont_release_proc")
   void callRmanContRelease(@Param("transHeaderId") BigDecimal transHeaderId,
                            @Param("transLineId") BigDecimal transLineId
           );
}
