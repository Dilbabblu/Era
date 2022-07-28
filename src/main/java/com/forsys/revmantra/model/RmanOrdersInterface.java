package com.forsys.revmantra.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.forsys.revmantra.cpk.id.RmanOrdersInterfacePkId;
import com.forsys.revmantra.validators.NumberValidator;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
import com.opencsv.bean.processor.PreAssignmentProcessor;
import com.opencsv.bean.validators.PreAssignmentValidator;


@Entity
@IdClass(RmanOrdersInterfacePkId.class)
@Table(name="RMAN_ORDERS_INTERFACE")
public class RmanOrdersInterface {
	
	/**@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "RMAN_ORDERS_STG_seq_gen")
	@SequenceGenerator(name = "RMAN_ORDERS_STG_seq_gen", sequenceName = "RMAN_ORDERS_STG_S")
	@Column(name = "SNO")
	private BigDecimal sno;*/
	
	@PreAssignmentValidator(validator = NumberValidator.class)
	@PreAssignmentProcessor(processor = NumberValidator.class)
	@CsvBindByName(column = "SOURCE_LINE_ID")
	@Id
    @Column(name="SOURCE_LINE_ID")
    private BigDecimal sourceLineId;

	@Id
	@Column(name = "FILE_TYPE")
	private String fileType;
	
	
    @Column(name="ORIG_LAST_UPDATED_BY")
    private BigDecimal origLastUpdatedBy;

	@CsvBindByName(column = "TERRITORY")
    @Column(name="TERRITORY")
    private String territory;

    @Column(name="LINE_NUM")
    private String lineNum;

	@CsvBindByName(column = "SALES_REP")
    @Column(name="SALESREP")
    private String salesrep;

	@PreAssignmentValidator(validator = NumberValidator.class)
	@PreAssignmentProcessor(processor = NumberValidator.class)
	@CsvBindByName(column = "SHIPPING_ENTITY_ID")
    @Column(name="SHIPPING_ENTITY_ID")
    private BigDecimal shippingEntityId;

    @Column(name="PRODUCT_ORG_ID")
    private BigDecimal productOrgId;

	@CsvBindByName(column = "BILL_TO_COUNTRY")
    @Column(name="BILL_TO_COUNTRY")
    private String billToCountry;

	@PreAssignmentValidator(validator = NumberValidator.class)
	@PreAssignmentProcessor(processor = NumberValidator.class)
	@CsvBindByName(column = "CANCELLED_QTY")
    @Column(name="CANCELLED_QTY")
    private BigDecimal cancelledQty;

	@PreAssignmentValidator(validator = NumberValidator.class)
	@PreAssignmentProcessor(processor = NumberValidator.class)
	@CsvBindByName(column = "SELLING_PRICE")
    @Column(name="UNIT_SELLING_PRICE")
    private BigDecimal unitSellingPrice;

	@PreAssignmentValidator(validator = NumberValidator.class)
	@PreAssignmentProcessor(processor = NumberValidator.class)
	@CsvBindByName(column = "TOP_MODEL_LINE_ID")
    @Column(name="TOP_MODEL_LINE_ID")
    private BigDecimal topModelLineId;

    @Column(name="FOB_POINT_CODE")
    private String fobPointCode;

    @Column(name="ORIG_CREATED_BY")
    private BigDecimal origCreatedBy;

    @Column(name="SERVICE_REF_ORDER")
    private BigDecimal serviceRefOrder;

    @CsvBindByName(column = "BILL_TO_COUNTRY")
    @Column(name="BILL_TO_LOCATION")
    private String billToLocation;

	@CsvBindByName(column = "SCHEDULE_SHIP_DATE" )
	@CsvDate(value = "MM/dd/yyyy")
    @Column(name="SCHEDULE_SHIP_DATE")
    private Timestamp scheduleShipDate;

    @CsvBindByName(column = "CUSTOMER_PO")
    @Column(name="CUSTOMER_PO_NUM")
    private String customerPoNum;

    @Column(name="INTERFACE_PROCESS_ID")
    private BigDecimal interfaceProcessId;

	@CsvBindByName(column = "REGION")
    @Column(name="REGION")
    private String region;

    @Column(name="RMAN_ACCT_RULE_ID")
    private BigDecimal rmanAcctRuleId;

	@PreAssignmentValidator(validator = NumberValidator.class)
	@PreAssignmentProcessor(processor = NumberValidator.class)
	@CsvBindByName(column = "ORDERED_QUANTITY")
    @Column(name="ORDERED_QUANTITY")
    private BigDecimal orderedQuantity;

	@CsvBindByName(column = "SHIPPING_ORG_CODE")
    @Column(name="SHIPPING_ORG_CODE")
    private String shippingOrgCode;

    @Column(name="TASK_ID")
    private BigDecimal taskId;

    @CsvBindByName(column = "LINE_ATTRIBUTE6")
    @Column(name="LINE_ATTRIBUTE6")
    private String lineAttribute6;

    @CsvBindByName(column = "LINE_ATTRIBUTE5")
    @Column(name="LINE_ATTRIBUTE5")
    private String lineAttribute5;

    @Column(name="HEADER_ATTRIBUTE10")
    private String headerAttribute10;

    @Column(name="LINE_ATTRIBUTE8")
    private String lineAttribute8;

    @Column(name="HEADER_ATTRIBUTE11")
    private String headerAttribute11;

    @CsvBindByName(column = "LINE_ATTRIBUTE7")
    @Column(name="LINE_ATTRIBUTE7")
    private String lineAttribute7;

    @Column(name="HEADER_ATTRIBUTE12")
    private String headerAttribute12;

	@CsvBindByName(column = "SOLD_TO_CUSTOMER")
    @Column(name="SOLD_TO_CUSTOMER")
    private String soldToCustomer;

	@CsvBindByName(column = "LINE_ATTRIBUTE2")
    @Column(name="LINE_ATTRIBUTE2")
    private String lineAttribute2;

    @Column(name="HEADER_ATTRIBUTE13")
    private String headerAttribute13;

    @Column(name="LINE_ATTRIBUTE1")
    private String lineAttribute1;

    @Column(name="HEADER_ATTRIBUTE14")
    private String headerAttribute14;

    @Column(name="ORIG_CREATION_DATE")
    private Timestamp origCreationDate;

    @CsvBindByName(column = "LINE_ATTRIBUTE4")
    @Column(name="LINE_ATTRIBUTE4")
    private String lineAttribute4;

    @Column(name="HEADER_ATTRIBUTE15")
    private String headerAttribute15;

    @Column(name="REP_UNIT_SELLING_PRICE")
    private BigDecimal repUnitSellingPrice;

	@CsvBindByName(column = "LINE_ATTRIBUTE3")
    @Column(name="LINE_ATTRIBUTE3")
    private String lineAttribute3;

    @Column(name="LINE_ATTRIBUTE9")
    private String lineAttribute9;

    @Column(name="ERROR_FLAG")
    private String errorFlag;

	@CsvBindByName(column = "CANCELLED_DATE")
	@CsvDate(value = "MM/dd/yyyy")
    @Column(name="CANCELLED_DATE")
    private Timestamp cancelledDate;

    @Column(name="FX_RATE")
    private BigDecimal fxRate;

    @Column(name="OBJ_VERSION_NUMBER")
    private BigDecimal objVersionNumber;

    @Column(name="LINE_ATTRIBUTE12")
    private String lineAttribute12;

	@PreAssignmentValidator(validator = NumberValidator.class)
	@PreAssignmentProcessor(processor = NumberValidator.class)
	@CsvBindByName(column = "SHIPPED_QUANTITY")
    @Column(name="SHIPPED_QUANTITY")
    private BigDecimal shippedQuantity;

    @Column(name="LINE_ATTRIBUTE13")
    private String lineAttribute13;

    @Column(name="LINE_ATTRIBUTE10")
    private String lineAttribute10;

    @Column(name="LINE_ATTRIBUTE11")
    private String lineAttribute11;

	@CsvBindByName(column = "SHIP_TO_COUNTRY")
    @Column(name="SHIP_TO_LOCATION")
    private String shipToLocation;

    @Column(name="EXPENDITURE_TYPE")
    private String expenditureType;

	@CsvBindByName(column = "DEAL_NUMBER")
    @Column(name="DEAL_NUMBER")
    private String dealNumber;

	@CsvBindByName(column = "BILL_TO_CUSTOMER")
    @Column(name="BILL_TO_CUSTOMER")
    private String billToCustomer;

	@CsvBindByName(column = "OPPORTUNITY NUMBER")
    @Column(name="LINE_ATTRIBUTE14")
    private String lineAttribute14;

    @Column(name="PROJECT_ID")
    private BigDecimal projectId;

	@CsvBindByName(column = "OPPORTUNITY NAME")
    @Column(name="LINE_ATTRIBUTE15")
    private String lineAttribute15;

	@CsvBindByName(column = "SHIP_TO_CUSTOMER")
    @Column(name="SHIP_TO_CUSTOMER")
    private String shipToCustomer;

    @Column(name="REF_ORDER_NUMBER")
    private String refOrderNumber;

	@PreAssignmentValidator(validator = NumberValidator.class)
	@PreAssignmentProcessor(processor = NumberValidator.class)
	@CsvBindByName(column = "DEAL_LINE_NUMBER")
    @Column(name="DEAL_LINE_NUMBER")
    private BigDecimal dealLineNumber;

    @CsvBindByName(column = "BOOKING_CURRENCY")
    @Column(name="BOOKING_CURRENCY")
    private String bookingCurrency;

    @Column(name="LINE_TYPE")
    private String lineType;

    @CsvBindByName(column = "PROJECT_NUMBER")
    @Column(name="PROJECT_NUMBER")
    private String projectNumber;

    @CsvBindByName(column = "ORDER_TYPE")
    @Column(name="ORDER_TYPE")
    private String orderType;

    @Column(name="REVREC_ACCT_RULE")
    private String revrecAcctRule;

    @Column(name="ROLE_NAME")
    private String roleName;

	@CsvBindByName(column = "BOOKED_DATE")
	@CsvDate(value = "MM/dd/yyyy")
    @Column(name="BOOKED_DATE")
    private Timestamp bookedDate;

    @Column(name="ACCOUNTING_RULE_NAME")
    private String accountingRuleName;

	@CsvBindByName(column = "SERVICE_END_DATE")
	@CsvDate(value = "MM/dd/yyyy")
    @Column(name="SERVICE_END_DATE")
    private Timestamp serviceEndDate;

	@CsvBindByName(column = "DOMESTIC_INTERNATIONAL")
    @Column(name="DOMESTIC_INTERNATIONAL")
    private String domesticInternational;

    @Column(name="TASK_NUMBER")
    private String taskNumber;

	@CsvBindByName(column = "SHIP_TO_COUNTRY")
    @Column(name="SHIP_TO_COUNTRY")
    private String shipToCountry;

    @Column(name="REVENUE_CATEGORY")
    private String revenueCategory;

    @Column(name="PROCESSED_DATE")
    private Timestamp processedDate;

    @Column(name="ORDER_NUM_MODIFIER")
    private String orderNumModifier;

    @Column(name="REVREC_ST_DATE")
    private Timestamp revrecStDate;

    @Column(name="FX_DATE")
    private Timestamp fxDate;

    @Column(name="REVREC_ACCT_SCOPE")
    private String revrecAcctScope;

	@CsvBindByName(column = "PRICE_LIST")
    @Column(name="PRICE_LIST")
    private String priceList;

//	@PreAssignmentValidator(validator = NumberValidator.class)
//	@PreAssignmentProcessor(processor = NumberValidator.class)
	@CsvBindByName(column = "REFERENCE_ORDER_NUMBER")
    @Column(name="ORGINAL_ORDER_NUMBER")
    private String orginalOrderNumber;

    @Column(name="PROJECT_COST")
    private BigDecimal projectCost;

	@PreAssignmentValidator(validator = NumberValidator.class)
	@PreAssignmentProcessor(processor = NumberValidator.class)
	@CsvBindByName(column = "HEADER_ID")
    @Column(name="SOURCE_HEADER_ID")
    private BigDecimal sourceHeaderId;

    @Column(name="LAST_UPDATE_DATE")
    private Timestamp lastUpdateDate;

	@PreAssignmentValidator(validator = NumberValidator.class)
	@PreAssignmentProcessor(processor = NumberValidator.class)
	@CsvBindByName(column = "REFERECE_LINE_ID")
    @Column(name="ORGINAL_LINE_ID")
    private BigDecimal orginalLineId;

    @Column(name="FOB")
    private String fob;

	@PreAssignmentValidator(validator = NumberValidator.class)
	@PreAssignmentProcessor(processor = NumberValidator.class)
	@CsvBindByName(column = "LIST_PRICE")
    @Column(name="UNIT_LIST_PRICE")
    private BigDecimal unitListPrice;

    @Column(name="BOOKING_ENTITY_NAME")
    private String bookingEntityName;

    @Column(name="CREATED_BY")
    private BigDecimal createdBy;

    @Column(name="LAST_UPDATED_BY")
    private BigDecimal lastUpdatedBy;

    @Column(name="REVREC_DELAY")
    private BigDecimal revrecDelay;

	@CsvBindByName(column = "PRODUCT_ORG_NAME")
    @Column(name="PRODUCT_ORG_NAME")
    private String productOrgName;

	@PreAssignmentValidator(validator = NumberValidator.class)
	@PreAssignmentProcessor(processor = NumberValidator.class)
	@CsvBindByName(column = "SOURCE_LINE_NUMBER")
    @Column(name="SOURCE_LINE_NUMBER")
    private String sourceLineNumber;

    @Column(name="TASK_NAME")
    private String taskName;

    @Column(name="CREATION_DATE")
    private Timestamp creationDate;

    @Column(name="SHIPPABLE_FLAG")
    private String shippableFlag;

	@CsvBindByName(column = "PRODUCT_NAME")
    @Column(name="PRODUCT_NAME")
    private String productName;

	@CsvBindByName(column = "LINE_STATUS")
    @Column(name="LINE_STATUS")
    private String lineStatus;

    @Column(name="STD_WARRANTY")
    private BigDecimal stdWarranty;

    @Column(name="ORIG_LAST_UPDATE_DATE")
    private Timestamp origLastUpdateDate;

	@PreAssignmentValidator(validator = NumberValidator.class)
	@PreAssignmentProcessor(processor = NumberValidator.class)
	@CsvBindByName(column = "LINK_TO_LINE_ID")
    @Column(name="LINK_TO_LINE_ID")
    private BigDecimal linkToLineId;

	@CsvBindByName(column = "REFERENCE_LINE_NUMBER")
    @Column(name="ORGINAL_LINE_NUMBER")
    private String orginalLineNumber;

    @Column(name="REP_UNIT_LIST_PRICE")
    private BigDecimal repUnitListPrice;

    @Column(name="RMAN_LINE_ID")
    private BigDecimal rmanLineId;

    @Column(name="HEADER_ATTRIBUTE1")
    private String headerAttribute1;

    @Column(name="ERROR_MESSAGE")
    private String errorMessage;

    @CsvBindByName(column = "HEADER_ATTRIBUTE6")
    @Column(name="HEADER_ATTRIBUTE6")
    private String headerAttribute6;

    @CsvBindByName(column = "HEADER_ATTRIBUTE7")
    @Column(name="HEADER_ATTRIBUTE7")
    private String headerAttribute7;

    @Column(name="HEADER_ATTRIBUTE8")
    private String headerAttribute8;

    @Column(name="HEADER_ATTRIBUTE9")
    private String headerAttribute9;

    @CsvBindByName(column = "HEADER_ATTRIBUTE2")
    @Column(name="HEADER_ATTRIBUTE2")
    private String headerAttribute2;

    @Column(name="FMV_HISTORY_FLAG")
    private String fmvHistoryFlag;

    @CsvBindByName(column = "HEADER_ATTRIBUTE3")
    @Column(name="HEADER_ATTRIBUTE3")
    private String headerAttribute3;

	@CsvBindByName(column = "LINE_CATEGORY_CODE")
    @Column(name="LINE_CATEGORY_CODE")
    private String lineCategoryCode;

	@CsvBindByName(column = "SERVICE_PERIOD")
    @Column(name="SERVICE_PERIOD")
    private String servicePeriod;

	@CsvBindByName(column = "HEADER_ATTRIBUTE4")
    @Column(name="HEADER_ATTRIBUTE4")
    private String headerAttribute4;

    @Column(name="PROJECT_NAME")
    private String projectName;

    @Column(name="HEADER_ATTRIBUTE5")
    private String headerAttribute5;

    @Column(name="SERVICE_REF_ORD_LINE_NUM")
    private BigDecimal serviceRefOrdLineNum;

    @Column(name="INTERFACE_STATUS")
    private String interfaceStatus;

    @Column(name="REVREC_END_DATE")
    private Timestamp revrecEndDate;

	@PreAssignmentValidator(validator = NumberValidator.class)
	@PreAssignmentProcessor(processor = NumberValidator.class)
	@CsvBindByName(column = "FULFILLED_QUANTITY")
    @Column(name="FULFILLED_QUANTITY")
    private BigDecimal fulfilledQuantity;

	@CsvBindByName(column = "ORDER_STATUS")
    @Column(name="ORDER_STATUS")
    private String orderStatus;

	@CsvBindByName(column = "SERVICE_START_DATE")
	@CsvDate(value = "MM/dd/yyyy")
    @Column(name="SERVICE_START_DATE")
    private Timestamp serviceStartDate;

    @Column(name="END_CUSTOMER")
    private String endCustomer;

	@CsvBindByName(column = "REV_REC_HOLD_TYPE")
    @Column(name="REVREC_HOLD_TYPE")
    private String revrecHoldType;

	@CsvBindByName(column = "ACTUAL_FULFILLED_DATE")
	@CsvDate(value = "MM/dd/yyyy")
    @Column(name="ACTUAL_FULFILLED_DATE")
    private Timestamp actualFulfilledDate;

    @Column(name="CARVE_OUT_FLAG")
    private String carveOutFlag;

	@PreAssignmentValidator(validator = NumberValidator.class)
	@PreAssignmentProcessor(processor = NumberValidator.class)
	@CsvBindByName(column = "SERVICE_DURATION")
    @Column(name="SERVICE_DURATION")
    private BigDecimal serviceDuration;

    @Column(name="SERVICE_NUMBER")
    private BigDecimal serviceNumber;

    @Column(name="PRODUCT_ID")
    private BigDecimal productId;

    @Column(name="INVOICE_FLAG")
    private String invoiceFlag;

	@PreAssignmentValidator(validator = NumberValidator.class)
	@PreAssignmentProcessor(processor = NumberValidator.class)
	@CsvBindByName(column = "BOOKING_ENTITY_ID")
    @Column(name="BOOKING_ENTITY_ID")
    private BigDecimal bookingEntityId;

    @Column(name="EXT_WARRANTY")
    private BigDecimal extWarranty;

    @Column(name="ORDER_SOURCE")
    private String orderSource;

    @Column(name="REVREC_ACCOUNT")
    private String revrecAccount;

//	@PreAssignmentValidator(validator = NumberValidator.class)
//	@PreAssignmentProcessor(processor = NumberValidator.class)
	@CsvBindByName(column = "ORDER_NUMBER")
    @Column(name="ORDER_NUMBER")
    private String orderNumber;

	@CsvBindByName(column = "ORDERED_DATE")
	@CsvDate(value = "MM/dd/yyyy")
    @Column(name="ORDERED_DATE")
    private Timestamp orderedDate;

	@PreAssignmentValidator(validator = NumberValidator.class)
	@PreAssignmentProcessor(processor = NumberValidator.class)
	/** #AYAR-417 Anil Mullamuri on 25-MAY-2021 **/
	@CsvBindByName(column = "UNIT_COST")
	/** #AYAR-417 Madhu Sri Thota on 31-MAY-2021 **/
    @Column(name="LINE_COST")
    private BigDecimal lineCost;

    @Column(name="RELEASED_STATUS")
    private String releasedStatus;

	@CsvBindByName(column = "CUSTOMER_NUMBER")
    @Column(name = "CUSTOMER_NUMBER")
	private String customerNumber;
	
	@CsvBindByName(column = "BILL_TO_CUSTOMER_NUMBER")
	@Column(name = "BILL_TO_CUSTOMER_NUMBER")
	private String billToCustomerNumber;
	
	@CsvBindByName(column = "SHIP_TO_CUSTOMER_NUMBER")
	@Column(name = "SHIP_TO_CUSTOMER_NUMBER")
	private String shipToCustomerNumber;
	
	@PreAssignmentValidator(validator = NumberValidator.class)
	@PreAssignmentProcessor(processor = NumberValidator.class)
	@CsvBindByName(column = "EXTENDED_LIST_AMT")
	@Column(name = "EXTENDED_LIST_AMOUNT")
	private BigDecimal extendedListAmount;
	
	@PreAssignmentValidator(validator = NumberValidator.class)
	@PreAssignmentProcessor(processor = NumberValidator.class)
	@CsvBindByName(column = "EXT_SELLING_AMT")
	@Column(name = "EXTENDED_SELLING_AMOUNT")
	private BigDecimal extendedSellingmount;
	
	@PreAssignmentValidator(validator = NumberValidator.class)
	@PreAssignmentProcessor(processor = NumberValidator.class)
	@CsvBindByName(column = "DISCOUNT_PERCENT")
	@Column(name = "DISCOUNT_PERCENT")
	private BigDecimal discountPercent;
	
	@CsvBindByName(column = "EXT_WARRANTY_SKU")
	@Column(name = "EXT_WARRANTY_SKU")
	private String extWarrantySku;
	
	@CsvBindByName(column = "EXT_SERV_START_DATE")
	@CsvDate(value = "MM/dd/yyyy")
	@Column(name = "EXT_SERV_START_DATE")
	private Timestamp extServStartDate;
	
	@CsvBindByName(column = "EXT_SERV_END_DATE")
	@CsvDate(value = "MM/dd/yyyy")
	@Column(name = "EXT_SERV_END_DATE")
	private Timestamp extServEndDate;
	
	@CsvBindByName(column = "EXT_PERIOD")
	@Column(name = "EXT_PERIOD")
	private String extPeriod;
	
	@PreAssignmentValidator(validator = NumberValidator.class)
	@PreAssignmentProcessor(processor = NumberValidator.class)
	@CsvBindByName(column = "EXT_DURATION")
	@Column(name = "EXT_DURATION")
	private BigDecimal extDuration;
	
	@PreAssignmentValidator(validator = NumberValidator.class)
	@PreAssignmentProcessor(processor = NumberValidator.class)
	@CsvBindByName(column = "EXT_LIST_PRICE")
	@Column(name = "EXT_LIST_PRICE")
	private BigDecimal extListPrice;
	
	@PreAssignmentValidator(validator = NumberValidator.class)
	@PreAssignmentProcessor(processor = NumberValidator.class)
	@CsvBindByName(column = "EXT_DISCOUNT")
	@Column(name = "EXT_DISCOUNT")
	private BigDecimal extDiscount;
	
	@CsvBindByName(column = "SUPPORT_SKU")
	@Column(name = "SUPPORT_SKU")
	private String supportSku;
	
	@CsvBindByName(column = "SUPPORT_SERV_START_DATE")
	@CsvDate(value = "MM/dd/yyyy")
	@Column(name = "SUPPORT_SERV_START_DATE")
	private Timestamp supportServStartDate;
	
	@CsvBindByName(column = "SUPPORT_SERV_END_DATE")
	@CsvDate(value = "MM/dd/yyyy")
	@Column(name = "SUPPORT_SERV_END_DATE")
	private Timestamp supportServEndDate;
	
	@CsvBindByName(column = "SUPPORT_PERIOD")
	@Column(name = "SUPPORT_PERIOD")
	private String supportPeriod;
	
	@PreAssignmentValidator(validator = NumberValidator.class)
	@PreAssignmentProcessor(processor = NumberValidator.class)
	@CsvBindByName(column = "SUPPORT_DURATION")
	@Column(name = "SUPPORT_DURATION")
	private BigDecimal supportDuration;
	
	@PreAssignmentValidator(validator = NumberValidator.class)
	@PreAssignmentProcessor(processor = NumberValidator.class)
	@CsvBindByName(column = "SUPPORT_LIST_PRICE")
	@Column(name = "SUPPORT_LIST_PRICE")
	private BigDecimal supportListPrice;	
	
	@PreAssignmentValidator(validator = NumberValidator.class)
	@PreAssignmentProcessor(processor = NumberValidator.class)
	@CsvBindByName(column = "SUPPORT_DISCOUNT")
	@Column(name = "SUPPORT_DISCOUNT")
	private BigDecimal supportDiscount;
	
	@Column(name = "SHIPPING_ENTITY_NAME")
	private String shippingEntityName;
	
	@Column(name = "GROUP_ID")
	private String groupId;
	
	@CsvBindByName(column = "TRAINING")
	@Column(name = "TRAINING_SKU")
	private String trainingSku;
	
	@PreAssignmentValidator(validator = NumberValidator.class)
	@PreAssignmentProcessor(processor = NumberValidator.class)
	@CsvBindByName(column = "PERCENTAGE_SPLIT")
	@Column(name = "PERCENTAGE_SPLIT")
	private BigDecimal percentageSplit;
	
	@Column(name = "FILE_NAME")
	private String fileName;
	
	@Column(name="ORIG_RMAN_LINE_ID")
    private BigDecimal origRmanLineId;
    
	
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


	public String getShippingEntityName() {
		return shippingEntityName;
	}

	public void setShippingEntityName(String shippingEntityName) {
		this.shippingEntityName = shippingEntityName;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}


    public BigDecimal getOrigRmanLineId() { 
        return this.origRmanLineId;
    }

    public void setOrigRmanLineId(BigDecimal origRmanLineId) { 
        this.origRmanLineId=origRmanLineId;
    }
    public BigDecimal getSourceLineId() { 
        return this.sourceLineId;
    }

    public void setSourceLineId(BigDecimal sourceLineId) { 
        this.sourceLineId=sourceLineId;
    }
    public BigDecimal getOrigLastUpdatedBy() { 
        return this.origLastUpdatedBy;
    }

    public void setOrigLastUpdatedBy(BigDecimal origLastUpdatedBy) { 
        this.origLastUpdatedBy=origLastUpdatedBy;
    }
    public String getTerritory() { 
        return this.territory;
    }

    public void setTerritory(String territory) { 
        this.territory=territory;
    }
    public String getLineNum() { 
        return this.lineNum;
    }

    public void setLineNum(String lineNum) { 
        this.lineNum=lineNum;
    }
    public String getSalesrep() { 
        return this.salesrep;
    }

    public void setSalesrep(String salesrep) { 
        this.salesrep=salesrep;
    }
    public BigDecimal getShippingEntityId() { 
        return this.shippingEntityId;
    }

    public void setShippingEntityId(BigDecimal shippingEntityId) { 
        this.shippingEntityId=shippingEntityId;
    }
    public BigDecimal getProductOrgId() { 
        return this.productOrgId;
    }

    public void setProductOrgId(BigDecimal productOrgId) { 
        this.productOrgId=productOrgId;
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
    public BigDecimal getUnitSellingPrice() { 
        return this.unitSellingPrice;
    }

    public void setUnitSellingPrice(BigDecimal unitSellingPrice) { 
        this.unitSellingPrice=unitSellingPrice;
    }
    public BigDecimal getTopModelLineId() { 
        return this.topModelLineId;
    }

    public void setTopModelLineId(BigDecimal topModelLineId) { 
        this.topModelLineId=topModelLineId;
    }
    public String getFobPointCode() { 
        return this.fobPointCode;
    }

    public void setFobPointCode(String fobPointCode) { 
        this.fobPointCode=fobPointCode;
    }
    public BigDecimal getOrigCreatedBy() { 
        return this.origCreatedBy;
    }

    public void setOrigCreatedBy(BigDecimal origCreatedBy) { 
        this.origCreatedBy=origCreatedBy;
    }
    public BigDecimal getServiceRefOrder() { 
        return this.serviceRefOrder;
    }

    public void setServiceRefOrder(BigDecimal serviceRefOrder) { 
        this.serviceRefOrder=serviceRefOrder;
    }
    public String getBillToLocation() { 
        return this.billToLocation;
    }

    public void setBillToLocation(String billToLocation) { 
        this.billToLocation=billToLocation;
    }
    public Timestamp getScheduleShipDate() { 
        return this.scheduleShipDate;
    }

    public void setScheduleShipDate(Timestamp scheduleShipDate) { 
        this.scheduleShipDate=scheduleShipDate;
    }
    public String getCustomerPoNum() { 
        return this.customerPoNum;
    }

    public void setCustomerPoNum(String customerPoNum) { 
        this.customerPoNum=customerPoNum;
    }
    public BigDecimal getInterfaceProcessId() { 
        return this.interfaceProcessId;
    }

    public void setInterfaceProcessId(BigDecimal interfaceProcessId) { 
        this.interfaceProcessId=interfaceProcessId;
    }
    public String getRegion() { 
        return this.region;
    }

    public void setRegion(String region) { 
        this.region=region;
    }
    public BigDecimal getRmanAcctRuleId() { 
        return this.rmanAcctRuleId;
    }

    public void setRmanAcctRuleId(BigDecimal rmanAcctRuleId) { 
        this.rmanAcctRuleId=rmanAcctRuleId;
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
    public BigDecimal getTaskId() { 
        return this.taskId;
    }

    public void setTaskId(BigDecimal taskId) { 
        this.taskId=taskId;
    }
    public String getLineAttribute6() { 
        return this.lineAttribute6;
    }

    public void setLineAttribute6(String lineAttribute6) { 
        this.lineAttribute6=lineAttribute6;
    }
    public String getLineAttribute5() { 
        return this.lineAttribute5;
    }

    public void setLineAttribute5(String lineAttribute5) { 
        this.lineAttribute5=lineAttribute5;
    }
    public String getHeaderAttribute10() { 
        return this.headerAttribute10;
    }

    public void setHeaderAttribute10(String headerAttribute10) { 
        this.headerAttribute10=headerAttribute10;
    }
    public String getLineAttribute8() { 
        return this.lineAttribute8;
    }

    public void setLineAttribute8(String lineAttribute8) { 
        this.lineAttribute8=lineAttribute8;
    }
    public String getHeaderAttribute11() { 
        return this.headerAttribute11;
    }

    public void setHeaderAttribute11(String headerAttribute11) { 
        this.headerAttribute11=headerAttribute11;
    }
    public String getLineAttribute7() { 
        return this.lineAttribute7;
    }

    public void setLineAttribute7(String lineAttribute7) { 
        this.lineAttribute7=lineAttribute7;
    }
    public String getHeaderAttribute12() { 
        return this.headerAttribute12;
    }

    public void setHeaderAttribute12(String headerAttribute12) { 
        this.headerAttribute12=headerAttribute12;
    }
    public String getSoldToCustomer() { 
        return this.soldToCustomer;
    }

    public void setSoldToCustomer(String soldToCustomer) { 
        this.soldToCustomer=soldToCustomer;
    }
    public String getLineAttribute2() { 
        return this.lineAttribute2;
    }

    public void setLineAttribute2(String lineAttribute2) { 
        this.lineAttribute2=lineAttribute2;
    }
    public String getHeaderAttribute13() { 
        return this.headerAttribute13;
    }

    public void setHeaderAttribute13(String headerAttribute13) { 
        this.headerAttribute13=headerAttribute13;
    }
    public String getLineAttribute1() { 
        return this.lineAttribute1;
    }

    public void setLineAttribute1(String lineAttribute1) { 
        this.lineAttribute1=lineAttribute1;
    }
    public String getHeaderAttribute14() { 
        return this.headerAttribute14;
    }

    public void setHeaderAttribute14(String headerAttribute14) { 
        this.headerAttribute14=headerAttribute14;
    }
    public Timestamp getOrigCreationDate() { 
        return this.origCreationDate;
    }

    public void setOrigCreationDate(Timestamp origCreationDate) { 
        this.origCreationDate=origCreationDate;
    }
    public String getLineAttribute4() { 
        return this.lineAttribute4;
    }

    public void setLineAttribute4(String lineAttribute4) { 
        this.lineAttribute4=lineAttribute4;
    }
    public String getHeaderAttribute15() { 
        return this.headerAttribute15;
    }

    public void setHeaderAttribute15(String headerAttribute15) { 
        this.headerAttribute15=headerAttribute15;
    }
    public BigDecimal getRepUnitSellingPrice() { 
        return this.repUnitSellingPrice;
    }

    public void setRepUnitSellingPrice(BigDecimal repUnitSellingPrice) { 
        this.repUnitSellingPrice=repUnitSellingPrice;
    }
    public String getLineAttribute3() { 
        return this.lineAttribute3;
    }

    public void setLineAttribute3(String lineAttribute3) { 
        this.lineAttribute3=lineAttribute3;
    }
    public String getLineAttribute9() { 
        return this.lineAttribute9;
    }

    public void setLineAttribute9(String lineAttribute9) { 
        this.lineAttribute9=lineAttribute9;
    }
    public String getErrorFlag() { 
        return this.errorFlag;
    }

    public void setErrorFlag(String errorFlag) { 
        this.errorFlag=errorFlag;
    }
    public Timestamp getCancelledDate() { 
        return this.cancelledDate;
    }

    public void setCancelledDate(Timestamp cancelledDate) { 
        this.cancelledDate=cancelledDate;
    }
    public BigDecimal getFxRate() { 
        return this.fxRate;
    }

    public void setFxRate(BigDecimal fxRate) { 
        this.fxRate=fxRate;
    }
    public BigDecimal getObjVersionNumber() { 
        return this.objVersionNumber;
    }

    public void setObjVersionNumber(BigDecimal objVersionNumber) { 
        this.objVersionNumber=objVersionNumber;
    }
    public String getLineAttribute12() { 
        return this.lineAttribute12;
    }

    public void setLineAttribute12(String lineAttribute12) { 
        this.lineAttribute12=lineAttribute12;
    }
    public BigDecimal getShippedQuantity() { 
        return this.shippedQuantity;
    }

    public void setShippedQuantity(BigDecimal shippedQuantity) { 
        this.shippedQuantity=shippedQuantity;
    }
    public String getLineAttribute13() { 
        return this.lineAttribute13;
    }

    public void setLineAttribute13(String lineAttribute13) { 
        this.lineAttribute13=lineAttribute13;
    }
    public String getLineAttribute10() { 
        return this.lineAttribute10;
    }

    public void setLineAttribute10(String lineAttribute10) { 
        this.lineAttribute10=lineAttribute10;
    }
    public String getLineAttribute11() { 
        return this.lineAttribute11;
    }

    public void setLineAttribute11(String lineAttribute11) { 
        this.lineAttribute11=lineAttribute11;
    }
    public String getShipToLocation() { 
        return this.shipToLocation;
    }

    public void setShipToLocation(String shipToLocation) { 
        this.shipToLocation=shipToLocation;
    }
    public String getExpenditureType() { 
        return this.expenditureType;
    }

    public void setExpenditureType(String expenditureType) { 
        this.expenditureType=expenditureType;
    }
    public String getDealNumber() { 
        return this.dealNumber;
    }

    public void setDealNumber(String dealNumber) { 
        this.dealNumber=dealNumber;
    }
    public String getBillToCustomer() { 
        return this.billToCustomer;
    }

    public void setBillToCustomer(String billToCustomer) { 
        this.billToCustomer=billToCustomer;
    }
    public String getLineAttribute14() { 
        return this.lineAttribute14;
    }

    public void setLineAttribute14(String lineAttribute14) { 
        this.lineAttribute14=lineAttribute14;
    }
    public BigDecimal getProjectId() { 
        return this.projectId;
    }

    public void setProjectId(BigDecimal projectId) { 
        this.projectId=projectId;
    }
    public String getLineAttribute15() { 
        return this.lineAttribute15;
    }

    public void setLineAttribute15(String lineAttribute15) { 
        this.lineAttribute15=lineAttribute15;
    }
    public String getShipToCustomer() { 
        return this.shipToCustomer;
    }

    public void setShipToCustomer(String shipToCustomer) { 
        this.shipToCustomer=shipToCustomer;
    }
    public String getRefOrderNumber() { 
        return this.refOrderNumber;
    }

    public void setRefOrderNumber(String refOrderNumber) { 
        this.refOrderNumber=refOrderNumber;
    }
    public BigDecimal getDealLineNumber() { 
        return this.dealLineNumber;
    }

    public void setDealLineNumber(BigDecimal dealLineNumber) { 
        this.dealLineNumber=dealLineNumber;
    }
    public String getBookingCurrency() { 
        return this.bookingCurrency;
    }

    public void setBookingCurrency(String bookingCurrency) { 
        this.bookingCurrency=bookingCurrency;
    }
    public String getLineType() { 
        return this.lineType;
    }

    public void setLineType(String lineType) { 
        this.lineType=lineType;
    }
    public String getProjectNumber() { 
        return this.projectNumber;
    }

    public void setProjectNumber(String projectNumber) { 
        this.projectNumber=projectNumber;
    }
    public String getOrderType() { 
        return this.orderType;
    }

    public void setOrderType(String orderType) { 
        this.orderType=orderType;
    }
    public String getRevrecAcctRule() { 
        return this.revrecAcctRule;
    }

    public void setRevrecAcctRule(String revrecAcctRule) { 
        this.revrecAcctRule=revrecAcctRule;
    }
    public String getRoleName() { 
        return this.roleName;
    }

    public void setRoleName(String roleName) { 
        this.roleName=roleName;
    }
    public Timestamp getBookedDate() { 
        return this.bookedDate;
    }

    public void setBookedDate(Timestamp bookedDate) { 
        this.bookedDate=bookedDate;
    }
    public String getAccountingRuleName() { 
        return this.accountingRuleName;
    }

    public void setAccountingRuleName(String accountingRuleName) { 
        this.accountingRuleName=accountingRuleName;
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
    public String getTaskNumber() { 
        return this.taskNumber;
    }

    public void setTaskNumber(String taskNumber) { 
        this.taskNumber=taskNumber;
    }
    public String getShipToCountry() { 
        return this.shipToCountry;
    }

    public void setShipToCountry(String shipToCountry) { 
        this.shipToCountry=shipToCountry;
    }
    public String getRevenueCategory() { 
        return this.revenueCategory;
    }

    public void setRevenueCategory(String revenueCategory) { 
        this.revenueCategory=revenueCategory;
    }
    public Timestamp getProcessedDate() { 
        return this.processedDate;
    }

    public void setProcessedDate(Timestamp processedDate) { 
        this.processedDate=processedDate;
    }
    public String getOrderNumModifier() { 
        return this.orderNumModifier;
    }

    public void setOrderNumModifier(String orderNumModifier) { 
        this.orderNumModifier=orderNumModifier;
    }
    public Timestamp getRevrecStDate() { 
        return this.revrecStDate;
    }

    public void setRevrecStDate(Timestamp revrecStDate) { 
        this.revrecStDate=revrecStDate;
    }
    public Timestamp getFxDate() { 
        return this.fxDate;
    }

    public void setFxDate(Timestamp fxDate) { 
        this.fxDate=fxDate;
    }
    public String getRevrecAcctScope() { 
        return this.revrecAcctScope;
    }

    public void setRevrecAcctScope(String revrecAcctScope) { 
        this.revrecAcctScope=revrecAcctScope;
    }
    public String getPriceList() { 
        return this.priceList;
    }

    public void setPriceList(String priceList) { 
        this.priceList=priceList;
    }
    public String getOrginalOrderNumber() { 
        return this.orginalOrderNumber;
    }

    public void setOrginalOrderNumber(String orginalOrderNumber) { 
        this.orginalOrderNumber=orginalOrderNumber;
    }
    public BigDecimal getProjectCost() { 
        return this.projectCost;
    }

    public void setProjectCost(BigDecimal projectCost) { 
        this.projectCost=projectCost;
    }
    public BigDecimal getSourceHeaderId() { 
        return this.sourceHeaderId;
    }

    public void setSourceHeaderId(BigDecimal sourceHeaderId) { 
        this.sourceHeaderId=sourceHeaderId;
    }
    public Timestamp getLastUpdateDate() { 
        return this.lastUpdateDate;
    }

    public void setLastUpdateDate(Timestamp lastUpdateDate) { 
        this.lastUpdateDate=lastUpdateDate;
    }
    public BigDecimal getOrginalLineId() { 
        return this.orginalLineId;
    }

    public void setOrginalLineId(BigDecimal orginalLineId) { 
        this.orginalLineId=orginalLineId;
    }
    public String getFob() { 
        return this.fob;
    }

    public void setFob(String fob) { 
        this.fob=fob;
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
    public BigDecimal getCreatedBy() { 
        return this.createdBy;
    }

    public void setCreatedBy(BigDecimal createdBy) { 
        this.createdBy=createdBy;
    }
    public BigDecimal getLastUpdatedBy() { 
        return this.lastUpdatedBy;
    }

    public void setLastUpdatedBy(BigDecimal lastUpdatedBy) { 
        this.lastUpdatedBy=lastUpdatedBy;
    }
    public BigDecimal getRevrecDelay() { 
        return this.revrecDelay;
    }

    public void setRevrecDelay(BigDecimal revrecDelay) { 
        this.revrecDelay=revrecDelay;
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
    public String getTaskName() { 
        return this.taskName;
    }

    public void setTaskName(String taskName) { 
        this.taskName=taskName;
    }
    public Timestamp getCreationDate() { 
        return this.creationDate;
    }

    public void setCreationDate(Timestamp creationDate) { 
        this.creationDate=creationDate;
    }
    public String getShippableFlag() { 
        return this.shippableFlag;
    }

    public void setShippableFlag(String shippableFlag) { 
        this.shippableFlag=shippableFlag;
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
    public BigDecimal getStdWarranty() { 
        return this.stdWarranty;
    }

    public void setStdWarranty(BigDecimal stdWarranty) { 
        this.stdWarranty=stdWarranty;
    }
    public Timestamp getOrigLastUpdateDate() { 
        return this.origLastUpdateDate;
    }

    public void setOrigLastUpdateDate(Timestamp origLastUpdateDate) { 
        this.origLastUpdateDate=origLastUpdateDate;
    }
    public BigDecimal getLinkToLineId() { 
        return this.linkToLineId;
    }

    public void setLinkToLineId(BigDecimal linkToLineId) { 
        this.linkToLineId=linkToLineId;
    }
    public String getOrginalLineNumber() { 
        return this.orginalLineNumber;
    }

    public void setOrginalLineNumber(String orginalLineNumber) { 
        this.orginalLineNumber=orginalLineNumber;
    }
    public BigDecimal getRepUnitListPrice() { 
        return this.repUnitListPrice;
    }

    public void setRepUnitListPrice(BigDecimal repUnitListPrice) { 
        this.repUnitListPrice=repUnitListPrice;
    }
    public BigDecimal getRmanLineId() { 
        return this.rmanLineId;
    }

    public void setRmanLineId(BigDecimal rmanLineId) { 
        this.rmanLineId=rmanLineId;
    }
    public String getHeaderAttribute1() { 
        return this.headerAttribute1;
    }

    public void setHeaderAttribute1(String headerAttribute1) { 
        this.headerAttribute1=headerAttribute1;
    }
    public String getErrorMessage() { 
        return this.errorMessage;
    }

    public void setErrorMessage(String errorMessage) { 
        this.errorMessage=errorMessage;
    }
    public String getHeaderAttribute6() { 
        return this.headerAttribute6;
    }

    public void setHeaderAttribute6(String headerAttribute6) { 
        this.headerAttribute6=headerAttribute6;
    }
    public String getHeaderAttribute7() { 
        return this.headerAttribute7;
    }

    public void setHeaderAttribute7(String headerAttribute7) { 
        this.headerAttribute7=headerAttribute7;
    }
    public String getHeaderAttribute8() { 
        return this.headerAttribute8;
    }

    public void setHeaderAttribute8(String headerAttribute8) { 
        this.headerAttribute8=headerAttribute8;
    }
    public String getHeaderAttribute9() { 
        return this.headerAttribute9;
    }

    public void setHeaderAttribute9(String headerAttribute9) { 
        this.headerAttribute9=headerAttribute9;
    }
    public String getHeaderAttribute2() { 
        return this.headerAttribute2;
    }

    public void setHeaderAttribute2(String headerAttribute2) { 
        this.headerAttribute2=headerAttribute2;
    }
    public String getFmvHistoryFlag() { 
        return this.fmvHistoryFlag;
    }

    public void setFmvHistoryFlag(String fmvHistoryFlag) { 
        this.fmvHistoryFlag=fmvHistoryFlag;
    }
    public String getHeaderAttribute3() { 
        return this.headerAttribute3;
    }

    public void setHeaderAttribute3(String headerAttribute3) { 
        this.headerAttribute3=headerAttribute3;
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
    public String getHeaderAttribute4() { 
        return this.headerAttribute4;
    }

    public void setHeaderAttribute4(String headerAttribute4) { 
        this.headerAttribute4=headerAttribute4;
    }
    public String getProjectName() { 
        return this.projectName;
    }

    public void setProjectName(String projectName) { 
        this.projectName=projectName;
    }
    public String getHeaderAttribute5() { 
        return this.headerAttribute5;
    }

    public void setHeaderAttribute5(String headerAttribute5) { 
        this.headerAttribute5=headerAttribute5;
    }
    public BigDecimal getServiceRefOrdLineNum() { 
        return this.serviceRefOrdLineNum;
    }

    public void setServiceRefOrdLineNum(BigDecimal serviceRefOrdLineNum) { 
        this.serviceRefOrdLineNum=serviceRefOrdLineNum;
    }
    public String getInterfaceStatus() { 
        return this.interfaceStatus;
    }

    public void setInterfaceStatus(String interfaceStatus) { 
        this.interfaceStatus=interfaceStatus;
    }
    public Timestamp getRevrecEndDate() { 
        return this.revrecEndDate;
    }

    public void setRevrecEndDate(Timestamp revrecEndDate) { 
        this.revrecEndDate=revrecEndDate;
    }
    public BigDecimal getFulfilledQuantity() { 
        return this.fulfilledQuantity;
    }

    public void setFulfilledQuantity(BigDecimal fulfilledQuantity) { 
        this.fulfilledQuantity=fulfilledQuantity;
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
    public String getEndCustomer() { 
        return this.endCustomer;
    }

    public void setEndCustomer(String endCustomer) { 
        this.endCustomer=endCustomer;
    }
    public String getRevrecHoldType() { 
        return this.revrecHoldType;
    }

    public void setRevrecHoldType(String revrecHoldType) { 
        this.revrecHoldType=revrecHoldType;
    }
    public Timestamp getActualFulfilledDate() { 
        return this.actualFulfilledDate;
    }

    public void setActualFulfilledDate(Timestamp actualFulfilledDate) { 
        this.actualFulfilledDate=actualFulfilledDate;
    }
    public String getCarveOutFlag() { 
        return this.carveOutFlag;
    }

    public void setCarveOutFlag(String carveOutFlag) { 
        this.carveOutFlag=carveOutFlag;
    }
    public BigDecimal getServiceDuration() { 
        return this.serviceDuration;
    }

    public void setServiceDuration(BigDecimal serviceDuration) { 
        this.serviceDuration=serviceDuration;
    }
    public BigDecimal getServiceNumber() { 
        return this.serviceNumber;
    }

    public void setServiceNumber(BigDecimal serviceNumber) { 
        this.serviceNumber=serviceNumber;
    }
    public BigDecimal getProductId() { 
        return this.productId;
    }

    public void setProductId(BigDecimal productId) { 
        this.productId=productId;
    }
    public String getInvoiceFlag() { 
        return this.invoiceFlag;
    }

    public void setInvoiceFlag(String invoiceFlag) { 
        this.invoiceFlag=invoiceFlag;
    }
    public BigDecimal getBookingEntityId() { 
        return this.bookingEntityId;
    }

    public void setBookingEntityId(BigDecimal bookingEntityId) { 
        this.bookingEntityId=bookingEntityId;
    }
    public BigDecimal getExtWarranty() { 
        return this.extWarranty;
    }

    public void setExtWarranty(BigDecimal extWarranty) { 
        this.extWarranty=extWarranty;
    }
    public String getOrderSource() { 
        return this.orderSource;
    }

    public void setOrderSource(String orderSource) { 
        this.orderSource=orderSource;
    }
    public String getRevrecAccount() { 
        return this.revrecAccount;
    }

    public void setRevrecAccount(String revrecAccount) { 
        this.revrecAccount=revrecAccount;
    }
    public String getOrderNumber() { 
        return this.orderNumber;
    }

    public void setOrderNumber(String orderNumber) { 
        this.orderNumber=orderNumber;
    }
    public Timestamp getOrderedDate() { 
        return this.orderedDate;
    }

    public void setOrderedDate(Timestamp orderedDate) { 
        this.orderedDate=orderedDate;
    }
    public BigDecimal getLineCost() { 
        return this.lineCost;
    }

    public void setLineCost(BigDecimal lineCost) { 
        this.lineCost=lineCost;
    }
    public String getReleasedStatus() { 
        return this.releasedStatus;
    }

    public void setReleasedStatus(String releasedStatus) { 
        this.releasedStatus=releasedStatus;
    }

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
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

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
    
    

}