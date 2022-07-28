package com.forsys.revmantra.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.forsys.revmantra.model.RmanSalesforceQuoteLine;

@Repository
public interface RmanSalesforceQuoteLineRepository extends  JpaRepository<RmanSalesforceQuoteLine, String> {

	List<RmanSalesforceQuoteLine> findByQuoteId(BigDecimal quoteId);
	
}
