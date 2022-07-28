package com.forsys.revmantra.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.cpk.id.ConversionRatesPkId;
import com.forsys.revmantra.model.RmanConversionRatesInt;

@RepositoryRestResource(collectionResourceRel = "RMAN_CONVERSION_RATES_INT", path = "RMAN_CONVERSION_RATES_INT")
public interface RmanConversionRatesIntRepository extends PagingAndSortingRepository<RmanConversionRatesInt,ConversionRatesPkId>, JpaRepository<RmanConversionRatesInt, ConversionRatesPkId>, JpaSpecificationExecutor<RmanConversionRatesInt> {

	List<RmanConversionRatesInt> findByInterfaceStatusAndProcessId(String interfaceStatus,String batchId);

}
