package com.forsys.revmantra.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.forsys.revmantra.listener.RmanOrdersStgListener;

@Entity
@EntityListeners(RmanOrdersStgListener.class)
@Table(name = "RMAN_ORDERS_STG")
public class RmanOrdersStg {

	@Column(name = "PRICE_LIST")
	private String priceList;

	@Column(name = "ORGINAL_ORDER_NUMBER")
	private BigDecimal orginalOrderNumber;

	@Column(name = "TOP_MODEL_LINE_ID")
	private BigDecimal topModelLineId;

	@Column(name = "BILL_TO_COUNTRY")
	private String billToCountry;

	@Column(name = "UNIT_SELLING_PRICE")
	private BigDecimal unitSellingPrice;

	@Column(name = "SALES_REP")
	private String salesRep;

	@Column(name = "FOB")
	private String fob;

	@Column(name = "UNIT_LIST_PRICE")
	private BigDecimal unitListPrice;

	@Column(name = "BOOKING_ENTITY_NAME")
	private String bookingEntityName;

	@Column(name = "FOB_POINT_CODE")
	private String fobPointCode;

	@Column(name = "CREATED_BY")
	private BigDecimal createdBy;

	@Column(name = "LAST_UPDATED_BY")
	private BigDecimal lastUpdatedBy;

	@Column(name = "PRODUCT_ORG_NAME")
	private String productOrgName;

	@Column(name = "SERVICE_REF_ORDER")
	private BigDecimal serviceRefOrder;

	@Column(name = "SOURCE_LINE_NUMBER")
	private String sourceLineNumber;

	@Column(name = "BILL_TO_LOCATION")
	private String billToLocation;

	@Column(name = "CREATION_DATE")
	private Timestamp creationDate;

	@Column(name = "SCHEDULE_SHIP_DATE")
	private Timestamp scheduleShipDate;

	@Column(name = "SHIPPABLE_FLAG")
	private String shippableFlag;

	@Column(name = "CUSTOMER_PO_NUM")
	private String customerPoNum;

	@Column(name = "PRODUCT_NAME")
	private String productName;

	@Column(name = "LINE_STATUS")
	private String lineStatus;

	@Column(name = "STD_WARRANTY")
	private BigDecimal stdWarranty;

	@Column(name = "ORGINAL_LINE_NUMBER")
	private String orginalLineNumber;

	@Column(name = "ORDERED_QUANTITY")
	private BigDecimal orderedQuantity;

	@Column(name = "SHIPPING_ORG_CODE")
	private String shippingOrgCode;

	@Column(name = "SOLD_TO_CUSTOMER")
	private String soldToCustomer;

	@Column(name = "ERROR_MESSAGE")
	private String errorMessage;

	@Column(name = "SERVICE_PERIOD")
	private String servicePeriod;

	@Column(name = "ERROR_FLAG")
	private String errorFlag;

	@Column(name = "SERVICE_REF_ORD_LINE_NUM")
	private BigDecimal serviceRefOrdLineNum;

	@Column(name = "SHIPPED_QUANTITY")
	private BigDecimal shippedQuantity;

	@Column(name = "FULFILLED_QUANTITY")
	private BigDecimal fulfilledQuantity;

	@Column(name = "LINK_TO_LINE_ID")
	private BigDecimal linkToLineId;

	@Column(name = "ORDER_STATUS")
	private String orderStatus;

	@Column(name = "SERVICE_START_DATE")
	private Timestamp serviceStartDate;

	@Column(name = "END_CUSTOMER")
	private String endCustomer;

	@Column(name = "DEAL_NUMBER")
	private String dealNumber;

	@Column(name = "BILL_TO_CUSTOMER")
	private String billToCustomer;

	@Column(name = "SHIPPING_ENTITY_NAME")
	private String shippingEntityName;

	@Column(name = "ACTUAL_FULFILLED_DATE")
	private Timestamp actualFulfilledDate;

	@Column(name = "SHIP_TO_CUSTOMER")
	private String shipToCustomer;

	@Column(name = "REF_ORDER_NUMBER")
	private BigDecimal refOrderNumber;

	@Column(name = "DEAL_LINE_NUMBER")
	private BigDecimal dealLineNumber;

	@Column(name = "CARVE_OUT_FLAG")
	private String carveOutFlag;

	@Column(name = "SERVICE_DURATION")
	private BigDecimal serviceDuration;

	@Column(name = "BOOKING_CURRENCY")
	private String bookingCurrency;

	@Column(name = "LINE_TYPE")
	private String lineType;

	@Column(name = "ORDER_TYPE")
	private String orderType;

	@Column(name = "INVOICE_FLAG")
	private String invoiceFlag;

	@Column(name = "BOOKED_DATE")
	private Timestamp bookedDate;

	@Column(name = "SERVICE_END_DATE")
	private Timestamp serviceEndDate;

	@Column(name = "LAST_UPDATED_DATE")
	private Timestamp lastUpdatedDate;

	@Column(name = "PROCESS_FLAG")
	private String processFlag;

	@Column(name = "UOM")
	private String uom;

	@Column(name = "EXT_WARRANTY")
	private BigDecimal extWarranty;

	@Column(name = "ORDER_SOURCE")
	private String orderSource;

	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ORDER_NUMBER")
	private BigDecimal orderNumber;
	
	@Column(name = "DOMESTIC_INTERNATIONAL")
	private String domesticInternational;
	
	@Column(name = "REGION")
	private String region;
	
	@Column(name = "TERRITORY")
	private String territory;
	
	@Column(name = "REVREC_HOLD_TYPE")
	private String revrecHoldType;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RMAN_ORDERS_STG_seq_gen")
	@SequenceGenerator(name = "RMAN_ORDERS_STG_seq_gen", sequenceName = "RMAN_ORDERS_STG_S", allocationSize=1)
	@Column(name = "SNO")
	private BigDecimal sno;

	@Column(name = "SHIP_TO_COUNTRY")
	private String shipToCountry;

	@Column(name = "LINE_COST")
	private BigDecimal lineCost;

	@Column(name = "ORDERED_DATE")
	private Timestamp orderedDate;

	@Column(name = "ORDER_NUM_MODIFIER")
	private String orderNumModifier;

	@Column(name = "GROUP_ID")
	private String groupId;
	
	@Column(name = "CANCELLED_QTY")
	private BigDecimal cancelledQty;
	
	@Column(name = "CANCELLED_DATE")
	private Timestamp cancelledDate;
	
	@Column(name = "LINE_CATEGORY_CODE")
	private String lineCategoryCode;
	
	@Column(name = "SOURCE_HEADER_ID")
	private BigDecimal sourceHeaderId;
	
	@Column(name = "SOURCE_LINE_ID")
	private BigDecimal sourceLineId;
	
	@Column(name = "ORGINAL_LINE_ID")
	private BigDecimal orginalLineId;
	
	@Column(name = "CUSTOMER_NUMBER")
	private String customerNumber;
	
	@Column(name = "BILL_TO_CUSTOMER_NUMBER")
	private String billToCustomerNumber;
	
	@Column(name = "SHIP_TO_CUSTOMER_NUMBER")
	private String shipToCustomerNumber;
	
	@Column(name = "EXTENDED_LIST_AMOUNT")
	private BigDecimal extendedListAmount;
	
	@Column(name = "EXTENDED_SELLING_AMOUNT")
	private BigDecimal extendedSellingmount;
	
	@Column(name = "DISCOUNT_PERCENT")
	private BigDecimal discountPercent;
	
	@Column(name = "EXT_WARRANTY_SKU")
	private String extWarrantySku;
	
	@Column(name = "EXT_SERV_START_DATE")
	private Timestamp extServStartDate;
	
	@Column(name = "EXT_SERV_END_DATE")
	private Timestamp extServEndDate;
	
	@Column(name = "EXT_PERIOD")
	private String extPeriod;
	
	@Column(name = "EXT_DURATION")
	private BigDecimal extDuration;
	
	@Column(name = "EXT_LIST_PRICE")
	private BigDecimal extListPrice;
	
	@Column(name = "EXT_DISCOUNT")
	private BigDecimal extDiscount;
	
	@Column(name = "SUPPORT_SKU")
	private String supportSku;
	
	@Column(name = "SUPPORT_SERV_START_DATE")
	private Timestamp supportServStartDate;
	
	@Column(name = "SUPPORT_SERV_END_DATE")
	private Timestamp supportServEndDate;
	
	@Column(name = "SUPPORT_PERIOD")
	private String supportPeriod;
	
	@Column(name = "SUPPORT_DURATION")
	private BigDecimal supportDuration;
	
	@Column(name = "SUPPORT_LIST_PRICE")
	private BigDecimal supportListPrice;	
	
	@Column(name = "SUPPORT_DISCOUNT")
	private BigDecimal supportDiscount;
	
	@Column(name = "TRAINING_SKU")
	private String trainingSku;
	
	@Column(name = "PERCENTAGE_SPLIT")
	private BigDecimal percentageSplit;
	
	public String getTrainingSku() {
		return trainingSku;
	}

	public void setTrainingSku(String trainingSku) {
		this.trainingSku = trainingSku;
	}

	public BigDecimal getPercentageSplit() {
		return percentageSplit;
	}

	public void setPercentageSplit(BigDecimal percentageSplit) {
		this.percentageSplit = percentageSplit;
	}

	

	public BigDecimal getOrginalLineId() {
		return orginalLineId;
	}

	public void setOrginalLineId(BigDecimal orginalLineId) {
		this.orginalLineId = orginalLineId;
	}

	public BigDecimal getSourceHeaderId() {
		return sourceHeaderId;
	}

	public void setSourceHeaderId(BigDecimal sourceHeaderId) {
		this.sourceHeaderId = sourceHeaderId;
	}

	public BigDecimal getSourceLineId() {
		return sourceLineId;
	}

	public void setSourceLineId(BigDecimal sourceLineId) {
		this.sourceLineId = sourceLineId;
	}

	public String getLineCategoryCode() {
		return lineCategoryCode;
	}

	public void setLineCategoryCode(String lineCategoryCode) {
		this.lineCategoryCode = lineCategoryCode;
	}

	public BigDecimal getCancelledQty() {
		return cancelledQty;
	}

	public void setCancelledQty(BigDecimal cancelledQty) {
		this.cancelledQty = cancelledQty;
	}

	public Timestamp getCancelledDate() {
		return cancelledDate;
	}

	public void setCancelledDate(Timestamp cancelledDate) {
		this.cancelledDate = cancelledDate;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getPriceList() {
		return this.priceList;
	}

	public void setPriceList(String priceList) {
		this.priceList = priceList;
	}

	public BigDecimal getOrginalOrderNumber() {
		return this.orginalOrderNumber;
	}

	public void setOrginalOrderNumber(BigDecimal orginalOrderNumber) {
		this.orginalOrderNumber = orginalOrderNumber;
	}

	public BigDecimal getTopModelLineId() {
		return this.topModelLineId;
	}

	public void setTopModelLineId(BigDecimal topModelLineId) {
		this.topModelLineId = topModelLineId;
	}

	public String getBillToCountry() {
		return this.billToCountry;
	}

	public void setBillToCountry(String billToCountry) {
		this.billToCountry = billToCountry;
	}

	public BigDecimal getUnitSellingPrice() {
		return this.unitSellingPrice;
	}

	public void setUnitSellingPrice(BigDecimal unitSellingPrice) {
		this.unitSellingPrice = unitSellingPrice;
	}

	public String getSalesRep() {
		return this.salesRep;
	}

	public void setSalesRep(String salesRep) {
		this.salesRep = salesRep;
	}

	public String getFob() {
		return this.fob;
	}

	public void setFob(String fob) {
		this.fob = fob;
	}

	public BigDecimal getUnitListPrice() {
		return this.unitListPrice;
	}

	public void setUnitListPrice(BigDecimal unitListPrice) {
		this.unitListPrice = unitListPrice;
	}

	public String getBookingEntityName() {
		return this.bookingEntityName;
	}

	public void setBookingEntityName(String bookingEntityName) {
		this.bookingEntityName = bookingEntityName;
	}

	public String getFobPointCode() {
		return this.fobPointCode;
	}

	public void setFobPointCode(String fobPointCode) {
		this.fobPointCode = fobPointCode;
	}

	public BigDecimal getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(BigDecimal createdBy) {
		this.createdBy = createdBy;
	}

	public BigDecimal getLastUpdatedBy() {
		return this.lastUpdatedBy;
	}

	public void setLastUpdatedBy(BigDecimal lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public String getProductOrgName() {
		return this.productOrgName;
	}

	public void setProductOrgName(String productOrgName) {
		this.productOrgName = productOrgName;
	}

	public BigDecimal getServiceRefOrder() {
		return this.serviceRefOrder;
	}

	public void setServiceRefOrder(BigDecimal serviceRefOrder) {
		this.serviceRefOrder = serviceRefOrder;
	}

	public String getSourceLineNumber() {
		return this.sourceLineNumber;
	}

	public void setSourceLineNumber(String sourceLineNumber) {
		this.sourceLineNumber = sourceLineNumber;
	}

	public String getBillToLocation() {
		return this.billToLocation;
	}

	public void setBillToLocation(String billToLocation) {
		this.billToLocation = billToLocation;
	}

	public Timestamp getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public Timestamp getScheduleShipDate() {
		return this.scheduleShipDate;
	}

	public void setScheduleShipDate(Timestamp scheduleShipDate) {
		this.scheduleShipDate = scheduleShipDate;
	}

	public String getShippableFlag() {
		return this.shippableFlag;
	}

	public void setShippableFlag(String shippableFlag) {
		this.shippableFlag = shippableFlag;
	}

	public String getCustomerPoNum() {
		return this.customerPoNum;
	}

	public void setCustomerPoNum(String customerPoNum) {
		this.customerPoNum = customerPoNum;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getLineStatus() {
		return this.lineStatus;
	}

	public void setLineStatus(String lineStatus) {
		this.lineStatus = lineStatus;
	}

	public BigDecimal getStdWarranty() {
		return this.stdWarranty;
	}

	public void setStdWarranty(BigDecimal stdWarranty) {
		this.stdWarranty = stdWarranty;
	}

	public String getOrginalLineNumber() {
		return this.orginalLineNumber;
	}

	public void setOrginalLineNumber(String orginalLineNumber) {
		this.orginalLineNumber = orginalLineNumber;
	}

	public BigDecimal getOrderedQuantity() {
		return this.orderedQuantity;
	}

	public void setOrderedQuantity(BigDecimal orderedQuantity) {
		this.orderedQuantity = orderedQuantity;
	}

	public String getShippingOrgCode() {
		return this.shippingOrgCode;
	}

	public void setShippingOrgCode(String shippingOrgCode) {
		this.shippingOrgCode = shippingOrgCode;
	}

	public String getSoldToCustomer() {
		return this.soldToCustomer;
	}

	public void setSoldToCustomer(String soldToCustomer) {
		this.soldToCustomer = soldToCustomer;
	}

	public String getErrorMessage() {
		return this.errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getServicePeriod() {
		return this.servicePeriod;
	}

	public void setServicePeriod(String servicePeriod) {
		this.servicePeriod = servicePeriod;
	}

	public String getErrorFlag() {
		return this.errorFlag;
	}

	public void setErrorFlag(String errorFlag) {
		this.errorFlag = errorFlag;
	}

	public BigDecimal getServiceRefOrdLineNum() {
		return this.serviceRefOrdLineNum;
	}

	public void setServiceRefOrdLineNum(BigDecimal serviceRefOrdLineNum) {
		this.serviceRefOrdLineNum = serviceRefOrdLineNum;
	}

	public BigDecimal getShippedQuantity() {
		return this.shippedQuantity;
	}

	public void setShippedQuantity(BigDecimal shippedQuantity) {
		this.shippedQuantity = shippedQuantity;
	}

	public BigDecimal getFulfilledQuantity() {
		return this.fulfilledQuantity;
	}

	public void setFulfilledQuantity(BigDecimal fulfilledQuantity) {
		this.fulfilledQuantity = fulfilledQuantity;
	}

	public BigDecimal getLinkToLineId() {
		return this.linkToLineId;
	}

	public void setLinkToLineId(BigDecimal linkToLineId) {
		this.linkToLineId = linkToLineId;
	}

	public String getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Timestamp getServiceStartDate() {
		return this.serviceStartDate;
	}

	public void setServiceStartDate(Timestamp serviceStartDate) {
		this.serviceStartDate = serviceStartDate;
	}

	public String getEndCustomer() {
		return this.endCustomer;
	}

	public void setEndCustomer(String endCustomer) {
		this.endCustomer = endCustomer;
	}

	public String getDealNumber() {
		return this.dealNumber;
	}

	public void setDealNumber(String dealNumber) {
		this.dealNumber = dealNumber;
	}

	public String getBillToCustomer() {
		return this.billToCustomer;
	}

	public void setBillToCustomer(String billToCustomer) {
		this.billToCustomer = billToCustomer;
	}

	public String getShippingEntityName() {
		return this.shippingEntityName;
	}

	public void setShippingEntityName(String shippingEntityName) {
		this.shippingEntityName = shippingEntityName;
	}

	public Timestamp getActualFulfilledDate() {
		return this.actualFulfilledDate;
	}

	public void setActualFulfilledDate(Timestamp actualFulfilledDate) {
		this.actualFulfilledDate = actualFulfilledDate;
	}

	public String getShipToCustomer() {
		return this.shipToCustomer;
	}

	public void setShipToCustomer(String shipToCustomer) {
		this.shipToCustomer = shipToCustomer;
	}

	public BigDecimal getRefOrderNumber() {
		return this.refOrderNumber;
	}

	public void setRefOrderNumber(BigDecimal refOrderNumber) {
		this.refOrderNumber = refOrderNumber;
	}

	public BigDecimal getDealLineNumber() {
		return this.dealLineNumber;
	}

	public void setDealLineNumber(BigDecimal dealLineNumber) {
		this.dealLineNumber = dealLineNumber;
	}

	public String getCarveOutFlag() {
		return this.carveOutFlag;
	}

	public void setCarveOutFlag(String carveOutFlag) {
		this.carveOutFlag = carveOutFlag;
	}

	public BigDecimal getServiceDuration() {
		return this.serviceDuration;
	}

	public void setServiceDuration(BigDecimal serviceDuration) {
		this.serviceDuration = serviceDuration;
	}

	public String getBookingCurrency() {
		return this.bookingCurrency;
	}

	public void setBookingCurrency(String bookingCurrency) {
		this.bookingCurrency = bookingCurrency;
	}

	public String getLineType() {
		return this.lineType;
	}

	public void setLineType(String lineType) {
		this.lineType = lineType;
	}

	public String getOrderType() {
		return this.orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getInvoiceFlag() {
		return this.invoiceFlag;
	}

	public void setInvoiceFlag(String invoiceFlag) {
		this.invoiceFlag = invoiceFlag;
	}

	public Timestamp getBookedDate() {
		return this.bookedDate;
	}

	public void setBookedDate(Timestamp bookedDate) {
		this.bookedDate = bookedDate;
	}

	public Timestamp getServiceEndDate() {
		return this.serviceEndDate;
	}

	public void setServiceEndDate(Timestamp serviceEndDate) {
		this.serviceEndDate = serviceEndDate;
	}

	public Timestamp getLastUpdatedDate() {
		return this.lastUpdatedDate;
	}

	public void setLastUpdatedDate(Timestamp lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getProcessFlag() {
		return this.processFlag;
	}

	public void setProcessFlag(String processFlag) {
		this.processFlag = processFlag;
	}

	public String getUom() {
		return this.uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public BigDecimal getExtWarranty() {
		return this.extWarranty;
	}

	public void setExtWarranty(BigDecimal extWarranty) {
		this.extWarranty = extWarranty;
	}

	public BigDecimal getOrderNumber() {
		return this.orderNumber;
	}

	public void setOrderNumber(BigDecimal orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getShipToCountry() {
		return this.shipToCountry;
	}

	public void setShipToCountry(String shipToCountry) {
		this.shipToCountry = shipToCountry;
	}

	public Timestamp getOrderedDate() {
		return this.orderedDate;
	}

	public void setOrderedDate(Timestamp orderedDate) {
		this.orderedDate = orderedDate;
	}

	public String getOrderNumModifier() {
		return this.orderNumModifier;
	}

	public void setOrderNumModifier(String orderNumModifier) {
		this.orderNumModifier = orderNumModifier;
	}

	public String getOrderSource() {
		return orderSource;
	}

	public void setOrderSource(String orderSource) {
		this.orderSource = orderSource;
	}

	public BigDecimal getSno() {
		return sno;
	}

	public void setSno(BigDecimal sno) {
		this.sno = sno;
	}

	public BigDecimal getLineCost() {
		return lineCost;
	}

	public void setLineCost(BigDecimal lineCost) {
		this.lineCost = lineCost;
	}

	public String getDomesticInternational() {
		return domesticInternational;
	}

	public void setDomesticInternational(String domesticInternational) {
		this.domesticInternational = domesticInternational;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getTerritory() {
		return territory;
	}

	public void setTerritory(String territory) {
		this.territory = territory;
	}

	public String getRevrecHoldType() {
		return revrecHoldType;
	}

	public void setRevrecHoldType(String revrecHoldType) {
		this.revrecHoldType = revrecHoldType;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getExtWarrantySku() {
		return extWarrantySku;
	}

	public void setExtWarrantySku(String extWarrantySku) {
		this.extWarrantySku = extWarrantySku;
	}

	public Timestamp getExtServStartDate() {
		return extServStartDate;
	}

	public void setExtServStartDate(Timestamp extServStartDate) {
		this.extServStartDate = extServStartDate;
	}

	public Timestamp getExtServEndDate() {
		return extServEndDate;
	}

	public void setExtServEndDate(Timestamp extServEndDate) {
		this.extServEndDate = extServEndDate;
	}

	public String getExtPeriod() {
		return extPeriod;
	}

	public void setExtPeriod(String extPeriod) {
		this.extPeriod = extPeriod;
	}

	public BigDecimal getExtDuration() {
		return extDuration;
	}

	public void setExtDuration(BigDecimal extDuration) {
		this.extDuration = extDuration;
	}

	public BigDecimal getExtListPrice() {
		return extListPrice;
	}

	public void setExtListPrice(BigDecimal extListPrice) {
		this.extListPrice = extListPrice;
	}

	public BigDecimal getExtDiscount() {
		return extDiscount;
	}

	public void setExtDiscount(BigDecimal extDiscount) {
		this.extDiscount = extDiscount;
	}

	public String getSupportSku() {
		return supportSku;
	}

	public void setSupportSku(String supportSku) {
		this.supportSku = supportSku;
	}

	public Timestamp getSupportServStartDate() {
		return supportServStartDate;
	}

	public void setSupportServStartDate(Timestamp supportServStartDate) {
		this.supportServStartDate = supportServStartDate;
	}

	public Timestamp getSupportServEndDate() {
		return supportServEndDate;
	}

	public void setSupportServEndDate(Timestamp supportServEndDate) {
		this.supportServEndDate = supportServEndDate;
	}

	public String getSupportPeriod() {
		return supportPeriod;
	}

	public void setSupportPeriod(String supportPeriod) {
		this.supportPeriod = supportPeriod;
	}

	public BigDecimal getSupportDuration() {
		return supportDuration;
	}

	public void setSupportDuration(BigDecimal supportDuration) {
		this.supportDuration = supportDuration;
	}

	public BigDecimal getSupportListPrice() {
		return supportListPrice;
	}

	public void setSupportListPrice(BigDecimal supportListPrice) {
		this.supportListPrice = supportListPrice;
	}

	public BigDecimal getSupportDiscount() {
		return supportDiscount;
	}

	public void setSupportDiscount(BigDecimal supportDiscount) {
		this.supportDiscount = supportDiscount;
	}

	public String getBillToCustomerNumber() {
		return billToCustomerNumber;
	}

	public void setBillToCustomerNumber(String billToCustomerNumber) {
		this.billToCustomerNumber = billToCustomerNumber;
	}

	public String getShipToCustomerNumber() {
		return shipToCustomerNumber;
	}

	public void setShipToCustomerNumber(String shipToCustomerNumber) {
		this.shipToCustomerNumber = shipToCustomerNumber;
	}

	public BigDecimal getExtendedListAmount() {
		return extendedListAmount;
	}

	public void setExtendedListAmount(BigDecimal extendedListAmount) {
		this.extendedListAmount = extendedListAmount;
	}

	public BigDecimal getExtendedSellingmount() {
		return extendedSellingmount;
	}

	public void setExtendedSellingmount(BigDecimal extendedSellingmount) {
		this.extendedSellingmount = extendedSellingmount;
	}

	public BigDecimal getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(BigDecimal discountPercent) {
		this.discountPercent = discountPercent;
	}
	
	
}