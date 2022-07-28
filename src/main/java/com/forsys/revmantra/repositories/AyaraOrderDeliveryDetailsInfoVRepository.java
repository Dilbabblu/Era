package com.forsys.revmantra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.forsys.revmantra.model.AyaraOrderDeliveryDetailsInfoV;
/*
 * AYAR-1787 By Chandra on Dec 30th 2021
 */
@RepositoryRestResource(collectionResourceRel = "AYARA_ORDER_DELIVERY_DETAILS_INFO_V", path = "AYARA_ORDER_DELIVERY_DETAILS_INFO_V")
public interface AyaraOrderDeliveryDetailsInfoVRepository  extends PagingAndSortingRepository<AyaraOrderDeliveryDetailsInfoV, java.math.BigDecimal>, JpaRepository<AyaraOrderDeliveryDetailsInfoV, java.math.BigDecimal>, JpaSpecificationExecutor<AyaraOrderDeliveryDetailsInfoV> {

}
