package com.forsys.revmantra.repositories;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.RmanFiscalPeriods;

@RepositoryRestResource(collectionResourceRel = "RMAN_FISCAL_PERIODS", path = "RMAN_FISCAL_PERIODS")
public interface RmanFiscalPeriodsRepository extends PagingAndSortingRepository<RmanFiscalPeriods, java.math.BigDecimal>, JpaRepository<RmanFiscalPeriods, java.math.BigDecimal>, JpaSpecificationExecutor<RmanFiscalPeriods> {

    @Query(value="select to_char(min(start_date),'yyyymmdd') as periodDate from rman_fiscal_periods where upper(period_name)=upper(?1) and adjustment_period_flag='N'",
    		nativeQuery=true)
    String getPeriodStartDate(String periodName);
    
    @Query(value="select to_char(max(end_date),'yyyymmdd') as periodDate from rman_fiscal_periods where upper(period_name)=upper(?1) and adjustment_period_flag='N'",
    		nativeQuery=true)
    String getPeriodEndDate(String periodName);
    @Query("select p from RmanFiscalPeriods p where p.openFlag='Y'")
	RmanFiscalPeriods getOpenFiscalPeriod();
    
    RmanFiscalPeriods findByPeriodNameIgnoreCase(String periodName);
    
    @Query(value = "select * from ayr_period_year_v", nativeQuery = true)
    List<BigDecimal> getFinancialYears();
    
    @Query(value = "select * from ayr_dimension_v", nativeQuery = true)
    List<String> getPeriodDimensions();
    
    @Query( nativeQuery = true, value = "SELECT VALIDATE_PERIOD_STATUS_CHANGE(:periodName, :periodStatus, :startDate, :endDate) FROM dual")
	String validatePeriodStatus(@org.springframework.data.repository.query.Param("periodName") String periodName, @org.springframework.data.repository.query.Param("periodStatus") String periodStatus, 
			@org.springframework.data.repository.query.Param("startDate") Date startDate, @org.springframework.data.repository.query.Param("endDate") Date endDate);
    
    RmanFiscalPeriods findByAdditionalAttribute1IgnoreCase(String externalId);
    
    
    
}
