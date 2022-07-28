package com.forsys.revmantra.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="RMAN_BOOKED_ORDERS_ARCHIVE")
public class RmanBookedOrdersArchive {

    @Column(name="SOURCE_LINE_ID")
    private BigDecimal sourceLineId;

    @Column(name="PRICE_LIST")
    private String priceList;

    @Column(name="TERRITORY")
    private String territory;

    @Column(name="ORGINAL_ORDER_NUMBER")
    private BigDecimal orginalOrderNumber;

    @Column(name="SOURCE_HEADER_ID")
    private BigDecimal sourceHeaderId;

    @Column(name="SALESREP")
    private String salesrep;

    @Column(name="FILE_NAME")
    private String fileName;

    @Column(name="ORGINAL_LINE_ID")
    private BigDecimal orginalLineId;

    @Column(name="PERIOD_NAME")
    private String periodName;

    @Column(name="BILL_TO_COUNTRY")
    private String billToCountry;

    @Column(name="CANCELLED_QTY")
    private BigDecimal cancelledQty;

    @Column(name="SUPPORT_PERIOD")
    private String supportPeriod;

    @Column(name="UNIT_SELLING_PRICE")
    private BigDecimal unitSellingPrice;

    @Column(name="EXTENDED_SELLING_AMOUNT")
    private BigDecimal extendedSellingAmount;

    @Column(name="UNIT_LIST_PRICE")
    private BigDecimal unitListPrice;

    @Column(name="BOOKING_ENTITY_NAME")
    private String bookingEntityName;

    @Column(name="SHIP_TO_CUSTOMER_NUMBER")
    private String shipToCustomerNumber;

    @Column(name="SUPPORT_SERV_START_DATE")
    private Timestamp supportServStartDate;

    @Column(name="CREATED_BY")
    private BigDecimal createdBy;

    @Column(name="PRODUCT_ORG_NAME")
    private String productOrgName;

    @Column(name="SOURCE_LINE_NUMBER")
    private String sourceLineNumber;

    @Column(name="CUSTOMER_NUMBER")
    private String customerNumber;

    @Column(name="EXT_PERIOD")
    private String extPeriod;

    @Column(name="CREATION_DATE")
    private Timestamp creationDate;

    @Column(name="SCHEDULE_SHIP_DATE")
    private Timestamp scheduleShipDate;

    @Column(name="EXTENDED_LIST_AMOUNT")
    private BigDecimal extendedListAmount;

    @Column(name="SUPPORT_LIST_PRICE")
    private BigDecimal supportListPrice;

    @Column(name="CUSTOMER_PO_NUM")
    private String customerPoNum;

    @Column(name="PRODUCT_NAME")
    private String productName;

    @Column(name="LINE_STATUS")
    private String lineStatus;

    @Column(name="REGION")
    private String region;

    @Column(name="SUPPORT_SERV_END_DATE")
    private Timestamp supportServEndDate;

    @Column(name="GROUP_ID")
    private String groupId;

    @Column(name="ORGINAL_LINE_NUMBER")
    private String orginalLineNumber;

    @Column(name="SUPPORT_DISCOUNT")
    private BigDecimal supportDiscount;

    @Column(name="ORDERED_QUANTITY")
    private BigDecimal orderedQuantity;

    @Column(name="SHIPPING_ORG_CODE")
    private String shippingOrgCode;

    @Column(name="TRAINING_SKU")
    private String trainingSku;

    @Column(name="SOLD_TO_CUSTOMER")
    private String soldToCustomer;

    @Column(name="EXT_LIST_PRICE")
    private BigDecimal extListPrice;

    @Column(name="SUPPORT_DURATION")
    private BigDecimal supportDuration;

    @Column(name="BILL_TO_CUSTOMER_NUMBER")
    private String billToCustomerNumber;

    @Column(name="LINE_CATEGORY_CODE")
    private String lineCategoryCode;

    @Column(name="SERVICE_PERIOD")
    private String servicePeriod;

    @Column(name="CANCELLED_DATE")
    private Timestamp cancelledDate;

    @Column(name="EXT_DISCOUNT")
    private BigDecimal extDiscount;

    @Id
    @Column(name="SNO")
    private BigDecimal sno;

    @Column(name="EXT_SERV_START_DATE")
    private Timestamp extServStartDate;

    @Column(name="SHIPPED_QUANTITY")
    private BigDecimal shippedQuantity;

    @Column(name="FULFILLED_QUANTITY")
    private BigDecimal fulfilledQuantity;

    @Column(name="EXT_SERV_END_DATE")
    private Timestamp extServEndDate;

    @Column(name="DISCOUNT_PERCENT")
    private BigDecimal discountPercent;

    @Column(name="ORDER_STATUS")
    private String orderStatus;

    @Column(name="SERVICE_START_DATE")
    private Timestamp serviceStartDate;

    @Column(name="BILL_TO_CUSTOMER")
    private String billToCustomer;

    @Column(name="REVREC_HOLD_TYPE")
    private String revrecHoldType;

    @Column(name="SHIPPING_ENTITY_NAME")
    private String shippingEntityName;

    @Column(name="PERIOD_END_DATE")
    private Timestamp periodEndDate;

    @Column(name="ACTUAL_FULFILLED_DATE")
    private Timestamp actualFulfilledDate;

    @Column(name="SHIP_TO_CUSTOMER")
    private String shipToCustomer;

    @Column(name="SUPPORT_SKU")
    private String supportSku;

    @Column(name="SERVICE_DURATION")
    private BigDecimal serviceDuration;

    @Column(name="BOOKING_CURRENCY")
    private String bookingCurrency;

    @Column(name="ORDER_TYPE")
    private String orderType;

    @Column(name="BOOKED_DATE")
    private Timestamp bookedDate;

    @Column(name="SERVICE_END_DATE")
    private Timestamp serviceEndDate;

    @Column(name="DOMESTIC_INTERNATIONAL")
    private String domesticInternational;

    @Column(name="EXT_DURATION")
    private BigDecimal extDuration;

    @Column(name="ORDER_NUMBER")
    private BigDecimal orderNumber;

    @Column(name="SHIP_TO_COUNTRY")
    private String shipToCountry;

    @Column(name="ORDERED_DATE")
    private Timestamp orderedDate;

    @Column(name="EXT_WARRANTY_SKU")
    private String extWarrantySku;

    @Column(name="PERCENTAGE_SPLIT")
    private BigDecimal percentageSplit;

    @Column(name="FILE_TYPE")
    private String fileType;

    @Column(name="PROCESSED_DATE")
    private Timestamp processedDate;

    @Column(name="LINE_COST")
    private BigDecimal lineCost;



    public BigDecimal getSourceLineId() { 
        return this.sourceLineId;
    }

    public void setSourceLineId(BigDecimal sourceLineId) { 
        this.sourceLineId=sourceLineId;
    }
    public String getPriceList() { 
        return this.priceList;
    }

    public void setPriceList(String priceList) { 
        this.priceList=priceList;
    }
    public String getTerritory() { 
        return this.territory;
    }

    public void setTerritory(String territory) { 
        this.territory=territory;
    }
    public BigDecimal getOrginalOrderNumber() { 
        return this.orginalOrderNumber;
    }

    public void setOrginalOrderNumber(BigDecimal orginalOrderNumber) { 
        this.orginalOrderNumber=orginalOrderNumber;
    }
    public BigDecimal getSourceHeaderId() { 
        return this.sourceHeaderId;
    }

    public void setSourceHeaderId(BigDecimal sourceHeaderId) { 
        this.sourceHeaderId=sourceHeaderId;
    }
    public String getSalesrep() { 
        return this.salesrep;
    }

    public void setSalesrep(String salesrep) { 
        this.salesrep=salesrep;
    }
    public String getFileName() { 
        return this.fileName;
    }

    public void setFileName(String fileName) { 
        this.fileName=fileName;
    }
    public BigDecimal getOrginalLineId() { 
        return this.orginalLineId;
    }

    public void setOrginalLineId(BigDecimal orginalLineId) { 
        this.orginalLineId=orginalLineId;
    }
    public String getPeriodName() { 
        return this.periodName;
    }

    public void setPeriodName(String periodName) { 
        this.periodName=periodName;
    }
    public String getBillToCountry() { 
        return this.billToCountry;
    }

    public void setBillToCountry(String billToCountry) { 
        this.billToCountry=billToCountry;
    }
    public BigDecimal getCancelledQty() { 
        return this.cancelledQty;
    }

    public void setCancelledQty(BigDecimal cancelledQty) { 
        this.cancelledQty=cancelledQty;
    }
    public String getSupportPeriod() { 
        return this.supportPeriod;
    }

    public void setSupportPeriod(String supportPeriod) { 
        this.supportPeriod=supportPeriod;
    }
    public BigDecimal getUnitSellingPrice() { 
        return this.unitSellingPrice;
    }

    public void setUnitSellingPrice(BigDecimal unitSellingPrice) { 
        this.unitSellingPrice=unitSellingPrice;
    }
    public BigDecimal getExtendedSellingAmount() { 
        return this.extendedSellingAmount;
    }

    public void setExtendedSellingAmount(BigDecimal extendedSellingAmount) { 
        this.extendedSellingAmount=extendedSellingAmount;
    }
    public BigDecimal getUnitListPrice() { 
        return this.unitListPrice;
    }

    public void setUnitListPrice(BigDecimal unitListPrice) { 
        this.unitListPrice=unitListPrice;
    }
    public String getBookingEntityName() { 
        return this.bookingEntityName;
    }

    public void setBookingEntityName(String bookingEntityName) { 
        this.bookingEntityName=bookingEntityName;
    }
    public String getShipToCustomerNumber() { 
        return this.shipToCustomerNumber;
    }

    public void setShipToCustomerNumber(String shipToCustomerNumber) { 
        this.shipToCustomerNumber=shipToCustomerNumber;
    }
    public Timestamp getSupportServStartDate() { 
        return this.supportServStartDate;
    }

    public void setSupportServStartDate(Timestamp supportServStartDate) { 
        this.supportServStartDate=supportServStartDate;
    }
    public BigDecimal getCreatedBy() { 
        return this.createdBy;
    }

    public void setCreatedBy(BigDecimal createdBy) { 
        this.createdBy=createdBy;
    }
    public String getProductOrgName() { 
        return this.productOrgName;
    }

    public void setProductOrgName(String productOrgName) { 
        this.productOrgName=productOrgName;
    }
    public String getSourceLineNumber() { 
        return this.sourceLineNumber;
    }

    public void setSourceLineNumber(String sourceLineNumber) { 
        this.sourceLineNumber=sourceLineNumber;
    }
    public String getCustomerNumber() { 
        return this.customerNumber;
    }

    public void setCustomerNumber(String customerNumber) { 
        this.customerNumber=customerNumber;
    }
    public String getExtPeriod() { 
        return this.extPeriod;
    }

    public void setExtPeriod(String extPeriod) { 
        this.extPeriod=extPeriod;
    }
    public Timestamp getCreationDate() { 
        return this.creationDate;
    }

    public void setCreationDate(Timestamp creationDate) { 
        this.creationDate=creationDate;
    }
    public Timestamp getScheduleShipDate() { 
        return this.scheduleShipDate;
    }

    public void setScheduleShipDate(Timestamp scheduleShipDate) { 
        this.scheduleShipDate=scheduleShipDate;
    }
    public BigDecimal getExtendedListAmount() { 
        return this.extendedListAmount;
    }

    public void setExtendedListAmount(BigDecimal extendedListAmount) { 
        this.extendedListAmount=extendedListAmount;
    }
    public BigDecimal getSupportListPrice() { 
        return this.supportListPrice;
    }

    public void setSupportListPrice(BigDecimal supportListPrice) { 
        this.supportListPrice=supportListPrice;
    }
    public String getCustomerPoNum() { 
        return this.customerPoNum;
    }

    public void setCustomerPoNum(String customerPoNum) { 
        this.customerPoNum=customerPoNum;
    }
    public String getProductName() { 
        return this.productName;
    }

    public void setProductName(String productName) { 
        this.productName=productName;
    }
    public String getLineStatus() { 
        return this.lineStatus;
    }

    public void setLineStatus(String lineStatus) { 
        this.lineStatus=lineStatus;
    }
    public String getRegion() { 
        return this.region;
    }

    public void setRegion(String region) { 
        this.region=region;
    }
    public Timestamp getSupportServEndDate() { 
        return this.supportServEndDate;
    }

    public void setSupportServEndDate(Timestamp supportServEndDate) { 
        this.supportServEndDate=supportServEndDate;
    }
    public String getGroupId() { 
        return this.groupId;
    }

    public void setGroupId(String groupId) { 
        this.groupId=groupId;
    }
    public String getOrginalLineNumber() { 
        return this.orginalLineNumber;
    }

    public void setOrginalLineNumber(String orginalLineNumber) { 
        this.orginalLineNumber=orginalLineNumber;
    }
    public BigDecimal getSupportDiscount() { 
        return this.supportDiscount;
    }

    public void setSupportDiscount(BigDecimal supportDiscount) { 
        this.supportDiscount=supportDiscount;
    }
    public BigDecimal getOrderedQuantity() { 
        return this.orderedQuantity;
    }

    public void setOrderedQuantity(BigDecimal orderedQuantity) { 
        this.orderedQuantity=orderedQuantity;
    }
    public String getShippingOrgCode() { 
        return this.shippingOrgCode;
    }

    public void setShippingOrgCode(String shippingOrgCode) { 
        this.shippingOrgCode=shippingOrgCode;
    }
    public String getTrainingSku() { 
        return this.trainingSku;
    }

    public void setTrainingSku(String trainingSku) { 
        this.trainingSku=trainingSku;
    }
    public String getSoldToCustomer() { 
        return this.soldToCustomer;
    }

    public void setSoldToCustomer(String soldToCustomer) { 
        this.soldToCustomer=soldToCustomer;
    }
    public BigDecimal getExtListPrice() { 
        return this.extListPrice;
    }

    public void setExtListPrice(BigDecimal extListPrice) { 
        this.extListPrice=extListPrice;
    }
    public BigDecimal getSupportDuration() { 
        return this.supportDuration;
    }

    public void setSupportDuration(BigDecimal supportDuration) { 
        this.supportDuration=supportDuration;
    }
    public String getBillToCustomerNumber() { 
        return this.billToCustomerNumber;
    }

    public void setBillToCustomerNumber(String billToCustomerNumber) { 
        this.billToCustomerNumber=billToCustomerNumber;
    }
    public String getLineCategoryCode() { 
        return this.lineCategoryCode;
    }

    public void setLineCategoryCode(String lineCategoryCode) { 
        this.lineCategoryCode=lineCategoryCode;
    }
    public String getServicePeriod() { 
        return this.servicePeriod;
    }

    public void setServicePeriod(String servicePeriod) { 
        this.servicePeriod=servicePeriod;
    }
    public Timestamp getCancelledDate() { 
        return this.cancelledDate;
    }

    public void setCancelledDate(Timestamp cancelledDate) { 
        this.cancelledDate=cancelledDate;
    }
    public BigDecimal getExtDiscount() { 
        return this.extDiscount;
    }

    public void setExtDiscount(BigDecimal extDiscount) { 
        this.extDiscount=extDiscount;
    }
    public BigDecimal getSno() { 
        return this.sno;
    }

    public void setSno(BigDecimal sno) { 
        this.sno=sno;
    }
    public Timestamp getExtServStartDate() { 
        return this.extServStartDate;
    }

    public void setExtServStartDate(Timestamp extServStartDate) { 
        this.extServStartDate=extServStartDate;
    }
    public BigDecimal getShippedQuantity() { 
        return this.shippedQuantity;
    }

    public void setShippedQuantity(BigDecimal shippedQuantity) { 
        this.shippedQuantity=shippedQuantity;
    }
    public BigDecimal getFulfilledQuantity() { 
        return this.fulfilledQuantity;
    }

    public void setFulfilledQuantity(BigDecimal fulfilledQuantity) { 
        this.fulfilledQuantity=fulfilledQuantity;
    }
    public Timestamp getExtServEndDate() { 
        return this.extServEndDate;
    }

    public void setExtServEndDate(Timestamp extServEndDate) { 
        this.extServEndDate=extServEndDate;
    }
    public BigDecimal getDiscountPercent() { 
        return this.discountPercent;
    }

    public void setDiscountPercent(BigDecimal discountPercent) { 
        this.discountPercent=discountPercent;
    }
    public String getOrderStatus() { 
        return this.orderStatus;
    }

    public void setOrderStatus(String orderStatus) { 
        this.orderStatus=orderStatus;
    }
    public Timestamp getServiceStartDate() { 
        return this.serviceStartDate;
    }

    public void setServiceStartDate(Timestamp serviceStartDate) { 
        this.serviceStartDate=serviceStartDate;
    }
    public String getBillToCustomer() { 
        return this.billToCustomer;
    }

    public void setBillToCustomer(String billToCustomer) { 
        this.billToCustomer=billToCustomer;
    }
    public String getRevrecHoldType() { 
        return this.revrecHoldType;
    }

    public void setRevrecHoldType(String revrecHoldType) { 
        this.revrecHoldType=revrecHoldType;
    }
    public String getShippingEntityName() { 
        return this.shippingEntityName;
    }

    public void setShippingEntityName(String shippingEntityName) { 
        this.shippingEntityName=shippingEntityName;
    }
    public Timestamp getPeriodEndDate() { 
        return this.periodEndDate;
    }

    public void setPeriodEndDate(Timestamp periodEndDate) { 
        this.periodEndDate=periodEndDate;
    }
    public Timestamp getActualFulfilledDate() { 
        return this.actualFulfilledDate;
    }

    public void setActualFulfilledDate(Timestamp actualFulfilledDate) { 
        this.actualFulfilledDate=actualFulfilledDate;
    }
    public String getShipToCustomer() { 
        return this.shipToCustomer;
    }

    public void setShipToCustomer(String shipToCustomer) { 
        this.shipToCustomer=shipToCustomer;
    }
    public String getSupportSku() { 
        return this.supportSku;
    }

    public void setSupportSku(String supportSku) { 
        this.supportSku=supportSku;
    }
    public BigDecimal getServiceDuration() { 
        return this.serviceDuration;
    }

    public void setServiceDuration(BigDecimal serviceDuration) { 
        this.serviceDuration=serviceDuration;
    }
    public String getBookingCurrency() { 
        return this.bookingCurrency;
    }

    public void setBookingCurrency(String bookingCurrency) { 
        this.bookingCurrency=bookingCurrency;
    }
    public String getOrderType() { 
        return this.orderType;
    }

    public void setOrderType(String orderType) { 
        this.orderType=orderType;
    }
    public Timestamp getBookedDate() { 
        return this.bookedDate;
    }

    public void setBookedDate(Timestamp bookedDate) { 
        this.bookedDate=bookedDate;
    }
    public Timestamp getServiceEndDate() { 
        return this.serviceEndDate;
    }

    public void setServiceEndDate(Timestamp serviceEndDate) { 
        this.serviceEndDate=serviceEndDate;
    }
    public String getDomesticInternational() { 
        return this.domesticInternational;
    }

    public void setDomesticInternational(String domesticInternational) { 
        this.domesticInternational=domesticInternational;
    }
    public BigDecimal getExtDuration() { 
        return this.extDuration;
    }

    public void setExtDuration(BigDecimal extDuration) { 
        this.extDuration=extDuration;
    }
    public BigDecimal getOrderNumber() { 
        return this.orderNumber;
    }

    public void setOrderNumber(BigDecimal orderNumber) { 
        this.orderNumber=orderNumber;
    }
    public String getShipToCountry() { 
        return this.shipToCountry;
    }

    public void setShipToCountry(String shipToCountry) { 
        this.shipToCountry=shipToCountry;
    }
    public Timestamp getOrderedDate() { 
        return this.orderedDate;
    }

    public void setOrderedDate(Timestamp orderedDate) { 
        this.orderedDate=orderedDate;
    }
    public String getExtWarrantySku() { 
        return this.extWarrantySku;
    }

    public void setExtWarrantySku(String extWarrantySku) { 
        this.extWarrantySku=extWarrantySku;
    }
    public BigDecimal getPercentageSplit() { 
        return this.percentageSplit;
    }

    public void setPercentageSplit(BigDecimal percentageSplit) { 
        this.percentageSplit=percentageSplit;
    }
    public String getFileType() { 
        return this.fileType;
    }

    public void setFileType(String fileType) { 
        this.fileType=fileType;
    }
    public Timestamp getProcessedDate() { 
        return this.processedDate;
    }

    public void setProcessedDate(Timestamp processedDate) { 
        this.processedDate=processedDate;
    }
    public BigDecimal getLineCost() { 
        return this.lineCost;
    }

    public void setLineCost(BigDecimal lineCost) { 
        this.lineCost=lineCost;
    }

}