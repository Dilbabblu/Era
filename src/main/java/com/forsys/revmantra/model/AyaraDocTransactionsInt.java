package com.forsys.revmantra.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.forsys.revmantra.validators.NumberValidator;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
import com.opencsv.bean.processor.PreAssignmentProcessor;
import com.opencsv.bean.validators.PreAssignmentValidator;

/*
 *  Created the Single Interface Entity Class  for all the Quote,Book,Ship and Invoice Transactions
 *  #AYAR-479 By Chandra on 9th Jun 2021
 *  #AYAR-1082 By Chandra on 23rd July 2021 added contApplyType,ContReleaseType,ContReleaseRevenue elements are added
 */

@Entity
//@EntityListeners(AyaraDocTransactionsIntListener.class)
@Table(name="AYARA_DOC_TRANSACTIONS_INT")
public class AyaraDocTransactionsInt {

    
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AYARA_DOC_TRANSACTIONS_INT_seq_gen")
    @SequenceGenerator(name="AYARA_DOC_TRANSACTIONS_INT_seq_gen", sequenceName="AYARA_DOC_TRANSACTIONS_INT_S", allocationSize=1)
    @Column(name="TRX_ID")
    private BigDecimal trxId;

	@CsvBindByName(column = "CONTINGNECY_CODE")
	@Column(name="CONTINGNECY_CODE")
    private String contingnecyCode;
	
	@PreAssignmentValidator(validator = NumberValidator.class)
	@PreAssignmentProcessor(processor = NumberValidator.class)
	@CsvBindByName(column = "CONTINGNECY_PERCENTAGE")
	@Column(name="CONTINGNECY_PERCENTAGE")
    private BigDecimal contingnecyPercentage;
	
	@Column(name="FX_DATE")
    private Timestamp fxDate;
	
	@PreAssignmentValidator(validator = NumberValidator.class)
	@PreAssignmentProcessor(processor = NumberValidator.class)
	@CsvBindByName(column = "ENTITY_ID")
    @Column(name="ENTITY_ID")
    private BigDecimal entityId;

	@PreAssignmentValidator(validator = NumberValidator.class)
	@PreAssignmentProcessor(processor = NumberValidator.class)
	@CsvBindByName(column = "UNIT_COST")
    @Column(name="UNIT_COST")
    private BigDecimal unitCost;

	@PreAssignmentValidator(validator = NumberValidator.class)
	@PreAssignmentProcessor(processor = NumberValidator.class)
	@CsvBindByName(column = "QUANTITY")
    @Column(name="QUANTITY")
    private BigDecimal quantity;

	@CsvBindByName(column = "EVENT_TYPE")
    @Column(name="EVENT_TYPE")
    private String eventType;
	
	@CsvBindByName(column = "REF_DOCUMENT_NUMBER")
    @Column(name="REF_DOCUMENT_NUMBER")
    private String refDocumentNumber;
	
	@CsvBindByName(column = "DOCUMENT_DESCRIPTION")
    @Column(name="DOCUMENT_DESCRIPTION")
    private String documentDescription;
	
	@Column(name="EXCEPTION_MESSAGE")
    private String exceptionMessage;
	
	
    @Column(name="LAST_UPDATE_DATE")
    private Timestamp lastUpdateDate;
	
	@CsvBindByName(column = "PARENT_LINE_NUMBER")
    @Column(name="PARENT_LINE_NUMBER")
    private String parentLineNumber;

    @Column(name="PRODUCT_DESCRIPTION")
    private String productDescription;
    
    @PreAssignmentValidator(validator = NumberValidator.class)
	@PreAssignmentProcessor(processor = NumberValidator.class)
    @CsvBindByName(column = "AMOUNT")
    @Column(name="AMOUNT")
    private BigDecimal amount;
    
    @PreAssignmentValidator(validator = NumberValidator.class)
	@PreAssignmentProcessor(processor = NumberValidator.class)
    @CsvBindByName(column = "UNIT_SELLING_PRICE")
    @Column(name="UNIT_SELLING_PRICE")
    private BigDecimal unitSellingPrice;
    
    @CsvBindByName(column = "OPPORTUNITY_NAME")
    @Column(name="OPPORTUNITY_NAME")
    private String opportunityName;
    
    @CsvBindByName(column = "SALES_REP")
    @Column(name="SALES_REP")
    private String salesRep;
    
    @PreAssignmentValidator(validator = NumberValidator.class)
	@PreAssignmentProcessor(processor = NumberValidator.class)
    @CsvBindByName(column = "UNIT_LIST_PRICE")
    @Column(name="UNIT_LIST_PRICE")
    private BigDecimal unitListPrice;
    
    @CsvBindByName(column = "ENTITY_NAME")
    @Column(name="ENTITY_NAME")
    private String entityName;
    
    @Column(name="PROCESS_ID")
    private BigDecimal processId;
    
    @CsvBindByName(column = "DOCUMENT_LINE_STATUS")
    @Column(name="DOCUMENT_LINE_STATUS")
    private String documentLineStatus;

    @Column(name="CREATED_BY")
    private String createdBy;

    @Column(name="LAST_UPDATED_BY")
    private String lastUpdatedBy;
    
    @CsvBindByName(column = "CUSTOMER_NUMBER")
    @Column(name="CUSTOMER_NUMBER")
    private String customerNumber;
    
    @CsvBindByName(column = "REF_LINE_NUMBER")
    @Column(name="REF_LINE_NUMBER")
    private String refLineNumber;
    
    @Column(name="CREATION_DATE")
    private Timestamp creationDate;
    
    @CsvBindByName(column = "DOCUMENT_DATE")
    @CsvDate(value = "MM/dd/yyyy")
    @Column(name="DOCUMENT_DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern="yyyy-MM-dd",timezone = "America/Los_Angeles")
    private Timestamp documentDate;
    
    @PreAssignmentValidator(validator = NumberValidator.class)
	@PreAssignmentProcessor(processor = NumberValidator.class)
    @CsvBindByName(column = "EXTENDED_LIST_AMOUNT")
    @Column(name="EXTENDED_LIST_AMOUNT")
    private BigDecimal extendedListAmount;
    
    @CsvBindByName(column = "PRODUCT_NAME")
    @Column(name="PRODUCT_NAME")
    private String productName;
    
    @CsvBindByName(column = "REGION")
    @Column(name="REGION")
    private String region;
    
    @PreAssignmentValidator(validator = NumberValidator.class)
	@PreAssignmentProcessor(processor = NumberValidator.class)
    @CsvBindByName(column = "INVENTORY_ITEM_ID")
    @Column(name="INVENTORY_ITEM_ID")
    private BigDecimal inventoryItemId;
    
    @Column(name="OPERATION_CODE")
    private String operationCode;
    
    @CsvBindByName(column = "CUSTOMER_PO")
    @Column(name="CUSTOMER_PO")
    private String customerPo;
    
    @CsvBindByName(column = "DOCUMENT_LINE_NUMBER")
    @Column(name="DOCUMENT_LINE_NUMBER")
    private String documentLineNumber;
    
    @CsvBindByName(column = "DOCUMENT_STATUS")
    @Column(name="DOCUMENT_STATUS")
    private String documentStatus;
    
    @CsvBindByName(column = "REVENUE_TEMPLATE_NAME")
    @Column(name="REVENUE_TEMPLATE_NAME")
    private String revenueTemplateName;
    
    @CsvBindByName(column = "DOCUMENT_NUMBER")
    @Column(name="DOCUMENT_NUMBER")
    private String documentNumber;
    
    @CsvBindByName(column = "LINE_ATTRIBUTE6")
    @Column(name="LINE_ATTRIBUTE6")
    private String lineAttribute6;
    
    @CsvBindByName(column = "HEADER_ATTRIBUTE10")
    @Column(name="HEADER_ATTRIBUTE10")
    private String headerAttribute10;
    
    @CsvBindByName(column = "LINE_ATTRIBUTE5")
    @Column(name="LINE_ATTRIBUTE5")
    private String lineAttribute5;
    
    @CsvBindByName(column = "HEADER_ATTRIBUTE11")
    @Column(name="HEADER_ATTRIBUTE11")
    private String headerAttribute11;
    
    @CsvBindByName(column = "LINE_ATTRIBUTE8")
    @Column(name="LINE_ATTRIBUTE8")
    private String lineAttribute8;
    
    @CsvBindByName(column = "HEADER_ATTRIBUTE1")
    @Column(name="HEADER_ATTRIBUTE1")
    private String headerAttribute1;
    
    @CsvBindByName(column = "HEADER_ATTRIBUTE12")
    @Column(name="HEADER_ATTRIBUTE12")
    private String headerAttribute12;
    
    @CsvBindByName(column = "LINE_ATTRIBUTE7")
    @Column(name="LINE_ATTRIBUTE7")
    private String lineAttribute7;
    
    @CsvBindByName(column = "HEADER_ATTRIBUTE13")
    @Column(name="HEADER_ATTRIBUTE13")
    private String headerAttribute13;
    
    @CsvBindByName(column = "LINE_ATTRIBUTE2")
    @Column(name="LINE_ATTRIBUTE2")
    private String lineAttribute2;
    
    @CsvBindByName(column = "HEADER_ATTRIBUTE14")
    @Column(name="HEADER_ATTRIBUTE14")
    private String headerAttribute14;
    
    @CsvBindByName(column = "LINE_ATTRIBUTE1")
    @Column(name="LINE_ATTRIBUTE1")
    private String lineAttribute1;
    
    @CsvBindByName(column = "HEADER_ATTRIBUTE15")
    @Column(name="HEADER_ATTRIBUTE15")
    private String headerAttribute15;
    
    @CsvBindByName(column = "LINE_ATTRIBUTE4")
    @Column(name="LINE_ATTRIBUTE4")
    private String lineAttribute4;
    
    @CsvBindByName(column = "SALES_THEATER")
    @Column(name="SALES_THEATER")
    private String salesTheater;
    
    @CsvBindByName(column = "SALES_TERRITORY")
    @Column(name="SALES_TERRITORY")
    private String salesTerritory;
    
    @CsvBindByName(column = "LINE_ATTRIBUTE3")
    @Column(name="LINE_ATTRIBUTE3")
    private String lineAttribute3;
    
    @CsvBindByName(column = "HEADER_ATTRIBUTE6")
    @Column(name="HEADER_ATTRIBUTE6")
    private String headerAttribute6;
    
    @CsvBindByName(column = "HEADER_ATTRIBUTE7")
    @Column(name="HEADER_ATTRIBUTE7")
    private String headerAttribute7;
    
    @CsvBindByName(column = "HEADER_ATTRIBUTE8")
    @Column(name="HEADER_ATTRIBUTE8")
    private String headerAttribute8;
    
    @CsvBindByName(column = "HEADER_ATTRIBUTE9")
    @Column(name="HEADER_ATTRIBUTE9")
    private String headerAttribute9;
    
    @CsvBindByName(column = "HEADER_ATTRIBUTE2")
    @Column(name="HEADER_ATTRIBUTE2")
    private String headerAttribute2;
    
    @CsvBindByName(column = "CURRENCY_CODE")
    @Column(name="CURRENCY_CODE")
    private String currencyCode;
    
    @CsvBindByName(column = "HEADER_ATTRIBUTE3")
    @Column(name="HEADER_ATTRIBUTE3")
    private String headerAttribute3;
    
    @CsvBindByName(column = "LINE_ATTRIBUTE9")
    @Column(name="LINE_ATTRIBUTE9")
    private String lineAttribute9;
    
    @CsvBindByName(column = "PROJECT_NAME")
    @Column(name="PROJECT_NAME")
    private String projectName;
    
    @CsvBindByName(column = "HEADER_ATTRIBUTE4")
    @Column(name="HEADER_ATTRIBUTE4")
    private String headerAttribute4;
    
    @CsvBindByName(column = "HEADER_ATTRIBUTE5")
    @Column(name="HEADER_ATTRIBUTE5")
    private String headerAttribute5;
    
    @CsvBindByName(column = "OPPORTUNITY_NUMBER")
    @Column(name="OPPORTUNITY_NUMBER")
    private String opportunityNumber;
    
    @CsvBindByName(column = "REF_LINE_ID")
    @Column(name="REF_LINE_ID")
    private String refLineId;
    
    @Column(name="FX_RATE")
    private BigDecimal fxRate;
    
    @CsvBindByName(column = "LINE_ATTRIBUTE12")
    @Column(name="LINE_ATTRIBUTE12")
    private String lineAttribute12;
    
    @CsvBindByName(column = "LINE_ATTRIBUTE13")
    @Column(name="LINE_ATTRIBUTE13")
    private String lineAttribute13;
    
    @CsvBindByName(column = "DOCUMENT_SOURCE")
    @Column(name="DOCUMENT_SOURCE")
    private String documentSource;
    
    @Column(name="DISCOUNT_PERCENT")
    private BigDecimal discountPercent;
    
    @CsvBindByName(column = "LINE_ATTRIBUTE10")
    @Column(name="LINE_ATTRIBUTE10")
    private String lineAttribute10;
    
    
    @Column(name="SALESREP_ID")
    private BigDecimal salesrepId;
    
    @CsvBindByName(column = "SERVICE_START_DATE")
    @CsvDate(value = "MM/dd/yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern="yyyy-MM-dd",timezone = "America/Los_Angeles")
    @Column(name="SERVICE_START_DATE")
    private Timestamp serviceStartDate;
    
    @CsvBindByName(column = "LINE_ATTRIBUTE11")
    @Column(name="LINE_ATTRIBUTE11")
    private String lineAttribute11;
    
    @CsvBindByName(column = "DEAL_NUMBER")
    @Column(name="DEAL_NUMBER")
    private String dealNumber;
    
    @CsvBindByName(column = "DOCUMENT_TYPE")
    @Column(name="DOCUMENT_TYPE")
    private String documentType;
    
    @PreAssignmentValidator(validator = NumberValidator.class)
	@PreAssignmentProcessor(processor = NumberValidator.class)
    @CsvBindByName(column = "PROJECT_ID")
    @Column(name="PROJECT_ID")
    private BigDecimal projectId;
    
    @CsvBindByName(column = "LINE_ATTRIBUTE14")
    @Column(name="LINE_ATTRIBUTE14")
    private String lineAttribute14;
    
    @CsvBindByName(column = "LINE_ATTRIBUTE15")
    @Column(name="LINE_ATTRIBUTE15")
    private String lineAttribute15;
    
    @CsvBindByName(column = "PROJECT_NUMBER")
    @Column(name="PROJECT_NUMBER")
    private String projectNumber;
    
    @CsvBindByName(column = "PARENT_LINE_ID")
    @Column(name="PARENT_LINE_ID")
    private String parentLineId;
    
    @PreAssignmentValidator(validator = NumberValidator.class)
	@PreAssignmentProcessor(processor = NumberValidator.class)
    @CsvBindByName(column = "REVENUE_TEMPLATE_ID")
    @Column(name="REVENUE_TEMPLATE_ID")
    private BigDecimal revenueTemplateId;
    
    @CsvBindByName(column = "DOCUMENT_HEADER_ID")
    @Column(name="DOCUMENT_HEADER_ID")
    private String documentHeaderId;
    
    @CsvBindByName(column = "SERVICE_END_DATE")
    @CsvDate(value = "MM/dd/yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern="yyyy-MM-dd",timezone = "America/Los_Angeles")
    @Column(name="SERVICE_END_DATE")
    private Timestamp serviceEndDate;
    
    @Column(name="PROCESS_FLAG")
    private String processFlag;
    
    @CsvBindByName(column = "DOCUMENT_CATEGORY")
    @Column(name="DOCUMENT_CATEGORY")
    private String documentCategory;
    
    @CsvBindByName(column = "DOCUMENT_LINE_ID")
    @Column(name="DOCUMENT_LINE_ID")
    private String documentLineId;
    
    @CsvBindByName(column = "UOM")
    @Column(name="UOM")
    private String uom;
    
    @CsvBindByName(column = "CUSTOMER_NAME")
    @Column(name="CUSTOMER_NAME")
    private String customerName;

    @Column(name="PROCESSED_DATE")
    private Timestamp processedDate;

    @CsvBindByName(column = "CONT_APPLY_TYPE")
    @Column(name="CONT_APPLY_TYPE")
    private String contApplyType;
    
    @CsvBindByName(column = "CONT_RELEASE_TYPE")
    @Column(name="CONT_RELEASE_TYPE")
    private String contReleaseType;
    
    @CsvBindByName(column = "CONT_RELEASE_REVENUE")
    @Column(name="CONT_RELEASE_REVENUE")
    private BigDecimal contReleaseRevenue;

    public String getContingnecyCode() { 
        return this.contingnecyCode;
    }

    public void setContingnecyCode(String contingnecyCode) { 
        this.contingnecyCode=contingnecyCode;
    }
    public Timestamp getFxDate() { 
        return this.fxDate;
    }

    public void setFxDate(Timestamp fxDate) { 
        this.fxDate=fxDate;
    }
    public BigDecimal getEntityId() { 
        return this.entityId;
    }

    public void setEntityId(BigDecimal entityId) { 
        this.entityId=entityId;
    }
    public BigDecimal getUnitCost() { 
        return this.unitCost;
    }

    public void setUnitCost(BigDecimal unitCost) { 
        this.unitCost=unitCost;
    }
    public BigDecimal getQuantity() { 
        return this.quantity;
    }

    public void setQuantity(BigDecimal quantity) { 
        this.quantity=quantity;
    }
    public String getEventType() { 
        return this.eventType;
    }

    public void setEventType(String eventType) { 
        this.eventType=eventType;
    }
    public String getRefDocumentNumber() { 
        return this.refDocumentNumber;
    }

    public void setRefDocumentNumber(String refDocumentNumber) { 
        this.refDocumentNumber=refDocumentNumber;
    }
    public String getDocumentDescription() { 
        return this.documentDescription;
    }

    public void setDocumentDescription(String documentDescription) { 
        this.documentDescription=documentDescription;
    }
    public String getExceptionMessage() { 
        return this.exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) { 
        this.exceptionMessage=exceptionMessage;
    }
    public Timestamp getLastUpdateDate() { 
        return this.lastUpdateDate;
    }

    public void setLastUpdateDate(Timestamp lastUpdateDate) { 
        this.lastUpdateDate=lastUpdateDate;
    }
    public String getParentLineNumber() { 
        return this.parentLineNumber;
    }

    public void setParentLineNumber(String parentLineNumber) { 
        this.parentLineNumber=parentLineNumber;
    }
    public String getProductDescription() { 
        return this.productDescription;
    }

    public void setProductDescription(String productDescription) { 
        this.productDescription=productDescription;
    }
    public BigDecimal getAmount() { 
        return this.amount;
    }

    public void setAmount(BigDecimal amount) { 
        this.amount=amount;
    }
    public BigDecimal getUnitSellingPrice() { 
        return this.unitSellingPrice;
    }

    public void setUnitSellingPrice(BigDecimal unitSellingPrice) { 
        this.unitSellingPrice=unitSellingPrice;
    }
    public String getOpportunityName() { 
        return this.opportunityName;
    }

    public void setOpportunityName(String opportunityName) { 
        this.opportunityName=opportunityName;
    }
    public String getSalesRep() { 
        return this.salesRep;
    }

    public void setSalesRep(String salesRep) { 
        this.salesRep=salesRep;
    }
    public BigDecimal getUnitListPrice() { 
        return this.unitListPrice;
    }

    public void setUnitListPrice(BigDecimal unitListPrice) { 
        this.unitListPrice=unitListPrice;
    }
    public String getEntityName() { 
        return this.entityName;
    }

    public void setEntityName(String entityName) { 
        this.entityName=entityName;
    }
    public BigDecimal getProcessId() { 
        return this.processId;
    }

    public void setProcessId(BigDecimal processId) { 
        this.processId=processId;
    }
    public String getDocumentLineStatus() { 
        return this.documentLineStatus;
    }

    public void setDocumentLineStatus(String documentLineStatus) { 
        this.documentLineStatus=documentLineStatus;
    }
    public String getCreatedBy() { 
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) { 
        this.createdBy=createdBy;
    }
    public String getLastUpdatedBy() { 
        return this.lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) { 
        this.lastUpdatedBy=lastUpdatedBy;
    }
    public String getCustomerNumber() { 
        return this.customerNumber;
    }

    public void setCustomerNumber(String customerNumber) { 
        this.customerNumber=customerNumber;
    }
    public String getRefLineNumber() { 
        return this.refLineNumber;
    }

    public void setRefLineNumber(String refLineNumber) { 
        this.refLineNumber=refLineNumber;
    }
    public Timestamp getCreationDate() { 
        return this.creationDate;
    }

    public void setCreationDate(Timestamp creationDate) { 
        this.creationDate=creationDate;
    }
    public Timestamp getDocumentDate() { 
        return this.documentDate;
    }

    public void setDocumentDate(Timestamp documentDate) { 
    	this.documentDate=documentDate;
    }
    public BigDecimal getExtendedListAmount() { 
        return this.extendedListAmount;
    }

    public void setExtendedListAmount(BigDecimal extendedListAmount) { 
        this.extendedListAmount=extendedListAmount;
    }
    public String getProductName() { 
        return this.productName;
    }

    public void setProductName(String productName) { 
        this.productName=productName;
    }
    public String getRegion() { 
        return this.region;
    }

    public void setRegion(String region) { 
        this.region=region;
    }
    public BigDecimal getInventoryItemId() { 
        return this.inventoryItemId;
    }

    public void setInventoryItemId(BigDecimal inventoryItemId) { 
        this.inventoryItemId=inventoryItemId;
    }
    public String getOperationCode() { 
        return this.operationCode;
    }

    public void setOperationCode(String operationCode) { 
        this.operationCode=operationCode;
    }
    public String getCustomerPo() { 
        return this.customerPo;
    }

    public void setCustomerPo(String customerPo) { 
        this.customerPo=customerPo;
    }
    public String getDocumentLineNumber() { 
        return this.documentLineNumber;
    }

    public void setDocumentLineNumber(String documentLineNumber) { 
        this.documentLineNumber=documentLineNumber;
    }
    public String getDocumentStatus() { 
        return this.documentStatus;
    }

    public void setDocumentStatus(String documentStatus) { 
        this.documentStatus=documentStatus;
    }
    public String getRevenueTemplateName() { 
        return this.revenueTemplateName;
    }

    public void setRevenueTemplateName(String revenueTemplateName) { 
        this.revenueTemplateName=revenueTemplateName;
    }
    public String getDocumentNumber() { 
        return this.documentNumber;
    }

    public void setDocumentNumber(String documentNumber) { 
        this.documentNumber=documentNumber;
    }
    public String getLineAttribute6() { 
        return this.lineAttribute6;
    }

    public void setLineAttribute6(String lineAttribute6) { 
        this.lineAttribute6=lineAttribute6;
    }
    public String getHeaderAttribute10() { 
        return this.headerAttribute10;
    }

    public void setHeaderAttribute10(String headerAttribute10) { 
        this.headerAttribute10=headerAttribute10;
    }
    public String getLineAttribute5() { 
        return this.lineAttribute5;
    }

    public void setLineAttribute5(String lineAttribute5) { 
        this.lineAttribute5=lineAttribute5;
    }
    public String getHeaderAttribute11() { 
        return this.headerAttribute11;
    }

    public void setHeaderAttribute11(String headerAttribute11) { 
        this.headerAttribute11=headerAttribute11;
    }
    public String getLineAttribute8() { 
        return this.lineAttribute8;
    }

    public void setLineAttribute8(String lineAttribute8) { 
        this.lineAttribute8=lineAttribute8;
    }
    public String getHeaderAttribute1() { 
        return this.headerAttribute1;
    }

    public void setHeaderAttribute1(String headerAttribute1) { 
        this.headerAttribute1=headerAttribute1;
    }
    public String getHeaderAttribute12() { 
        return this.headerAttribute12;
    }

    public void setHeaderAttribute12(String headerAttribute12) { 
        this.headerAttribute12=headerAttribute12;
    }
    public String getLineAttribute7() { 
        return this.lineAttribute7;
    }

    public void setLineAttribute7(String lineAttribute7) { 
        this.lineAttribute7=lineAttribute7;
    }
    public String getHeaderAttribute13() { 
        return this.headerAttribute13;
    }

    public void setHeaderAttribute13(String headerAttribute13) { 
        this.headerAttribute13=headerAttribute13;
    }
    public String getLineAttribute2() { 
        return this.lineAttribute2;
    }

    public void setLineAttribute2(String lineAttribute2) { 
        this.lineAttribute2=lineAttribute2;
    }
    public String getHeaderAttribute14() { 
        return this.headerAttribute14;
    }

    public void setHeaderAttribute14(String headerAttribute14) { 
        this.headerAttribute14=headerAttribute14;
    }
    public String getLineAttribute1() { 
        return this.lineAttribute1;
    }

    public void setLineAttribute1(String lineAttribute1) { 
        this.lineAttribute1=lineAttribute1;
    }
    public String getHeaderAttribute15() { 
        return this.headerAttribute15;
    }

    public void setHeaderAttribute15(String headerAttribute15) { 
        this.headerAttribute15=headerAttribute15;
    }
    public String getLineAttribute4() { 
        return this.lineAttribute4;
    }

    public void setLineAttribute4(String lineAttribute4) { 
        this.lineAttribute4=lineAttribute4;
    }
    public String getSalesTheater() { 
        return this.salesTheater;
    }

    public void setSalesTheater(String salesTheater) { 
        this.salesTheater=salesTheater;
    }
    public String getSalesTerritory() { 
        return this.salesTerritory;
    }

    public void setSalesTerritory(String salesTerritory) { 
        this.salesTerritory=salesTerritory;
    }
    public String getLineAttribute3() { 
        return this.lineAttribute3;
    }

    public void setLineAttribute3(String lineAttribute3) { 
        this.lineAttribute3=lineAttribute3;
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
    public String getCurrencyCode() { 
        return this.currencyCode;
    }

    public void setCurrencyCode(String currencyCode) { 
        this.currencyCode=currencyCode;
    }
    public String getHeaderAttribute3() { 
        return this.headerAttribute3;
    }

    public void setHeaderAttribute3(String headerAttribute3) { 
        this.headerAttribute3=headerAttribute3;
    }
    public String getLineAttribute9() { 
        return this.lineAttribute9;
    }

    public void setLineAttribute9(String lineAttribute9) { 
        this.lineAttribute9=lineAttribute9;
    }
    public String getProjectName() { 
        return this.projectName;
    }

    public void setProjectName(String projectName) { 
        this.projectName=projectName;
    }
    public String getHeaderAttribute4() { 
        return this.headerAttribute4;
    }

    public void setHeaderAttribute4(String headerAttribute4) { 
        this.headerAttribute4=headerAttribute4;
    }
    public String getHeaderAttribute5() { 
        return this.headerAttribute5;
    }

    public void setHeaderAttribute5(String headerAttribute5) { 
        this.headerAttribute5=headerAttribute5;
    }
    public String getOpportunityNumber() { 
        return this.opportunityNumber;
    }

    public void setOpportunityNumber(String opportunityNumber) { 
        this.opportunityNumber=opportunityNumber;
    }
    public String getRefLineId() { 
        return this.refLineId;
    }

    public void setRefLineId(String refLineId) { 
        this.refLineId=refLineId;
    }
    public BigDecimal getFxRate() { 
        return this.fxRate;
    }

    public void setFxRate(BigDecimal fxRate) { 
        this.fxRate=fxRate;
    }
    public String getLineAttribute12() { 
        return this.lineAttribute12;
    }

    public void setLineAttribute12(String lineAttribute12) { 
        this.lineAttribute12=lineAttribute12;
    }
    public String getLineAttribute13() { 
        return this.lineAttribute13;
    }

    public void setLineAttribute13(String lineAttribute13) { 
        this.lineAttribute13=lineAttribute13;
    }
    public String getDocumentSource() { 
        return this.documentSource;
    }

    public void setDocumentSource(String documentSource) { 
        this.documentSource=documentSource;
    }
    public BigDecimal getDiscountPercent() { 
        return this.discountPercent;
    }

    public void setDiscountPercent(BigDecimal discountPercent) { 
        this.discountPercent=discountPercent;
    }
    public String getLineAttribute10() { 
        return this.lineAttribute10;
    }

    public void setLineAttribute10(String lineAttribute10) { 
        this.lineAttribute10=lineAttribute10;
    }
    public BigDecimal getSalesrepId() { 
        return this.salesrepId;
    }

    public void setSalesrepId(BigDecimal salesrepId) { 
        this.salesrepId=salesrepId;
    }
    public Timestamp getServiceStartDate() { 
        return this.serviceStartDate;
    }

    public void setServiceStartDate(Timestamp serviceStartDate) { 
    	this.serviceStartDate=serviceStartDate;
    }
    public String getLineAttribute11() { 
        return this.lineAttribute11;
    }

    public void setLineAttribute11(String lineAttribute11) { 
        this.lineAttribute11=lineAttribute11;
    }
    public String getDealNumber() { 
        return this.dealNumber;
    }

    public void setDealNumber(String dealNumber) { 
        this.dealNumber=dealNumber;
    }
    public String getDocumentType() { 
        return this.documentType;
    }

    public void setDocumentType(String documentType) { 
        this.documentType=documentType;
    }
    public BigDecimal getProjectId() { 
        return this.projectId;
    }

    public void setProjectId(BigDecimal projectId) { 
        this.projectId=projectId;
    }
    public String getLineAttribute14() { 
        return this.lineAttribute14;
    }

    public void setLineAttribute14(String lineAttribute14) { 
        this.lineAttribute14=lineAttribute14;
    }
    public String getLineAttribute15() { 
        return this.lineAttribute15;
    }

    public void setLineAttribute15(String lineAttribute15) { 
        this.lineAttribute15=lineAttribute15;
    }
    public BigDecimal getTrxId() { 
        return this.trxId;
    }

    public void setTrxId(BigDecimal trxId) { 
        this.trxId=trxId;
    }
    public String getProjectNumber() { 
        return this.projectNumber;
    }

    public void setProjectNumber(String projectNumber) { 
        this.projectNumber=projectNumber;
    }
    public String getParentLineId() { 
        return this.parentLineId;
    }

    public void setParentLineId(String parentLineId) { 
        this.parentLineId=parentLineId;
    }
    public BigDecimal getRevenueTemplateId() { 
        return this.revenueTemplateId;
    }

    public void setRevenueTemplateId(BigDecimal revenueTemplateId) { 
        this.revenueTemplateId=revenueTemplateId;
    }
    public String getDocumentHeaderId() { 
        return this.documentHeaderId;
    }

    public void setDocumentHeaderId(String documentHeaderId) { 
        this.documentHeaderId=documentHeaderId;
    }
    public Timestamp getServiceEndDate() { 
        return this.serviceEndDate;
    }

    public void setServiceEndDate(Timestamp serviceEndDate) { 
    	this.serviceEndDate=serviceEndDate;
    }
    public String getProcessFlag() { 
        return this.processFlag;
    }

    public void setProcessFlag(String processFlag) { 
        this.processFlag=processFlag;
    }
    public String getDocumentCategory() { 
        return this.documentCategory;
    }

    public void setDocumentCategory(String documentCategory) { 
        this.documentCategory=documentCategory;
    }
    public String getDocumentLineId() { 
        return this.documentLineId;
    }

    public void setDocumentLineId(String documentLineId) { 
        this.documentLineId=documentLineId;
    }
    public String getUom() { 
        return this.uom;
    }

    public void setUom(String uom) { 
        this.uom=uom;
    }
    public String getCustomerName() { 
        return this.customerName;
    }

    public void setCustomerName(String customerName) { 
        this.customerName=customerName;
    }
    public Timestamp getProcessedDate() { 
        return this.processedDate;
    }

    public void setProcessedDate(Timestamp processedDate) { 
        this.processedDate=processedDate;
    }

	public BigDecimal getContingnecyPercentage() {
		return contingnecyPercentage;
	}

	public void setContingnecyPercentage(BigDecimal contingnecyPercentage) {
		this.contingnecyPercentage = contingnecyPercentage;
	}
	
	

	public String getContApplyType() {
		return contApplyType;
	}

	public void setContApplyType(String contApplyType) {
		this.contApplyType = contApplyType;
	}

	public String getContReleaseType() {
		return contReleaseType;
	}

	public void setContReleaseType(String contReleaseType) {
		this.contReleaseType = contReleaseType;
	}

	public BigDecimal getContReleaseRevenue() {
		return contReleaseRevenue;
	}

	public void setContReleaseRevenue(BigDecimal contReleaseRevenue) {
		this.contReleaseRevenue = contReleaseRevenue;
	}

	@Override
	public String toString() {
		return "AyaraDocTransactionsInt [amount=" + amount + ", contApplyType=" + contApplyType + ", contingnecyCode="
				+ contingnecyCode + ", contingnecyPercentage=" + contingnecyPercentage + ", contReleaseRevenue="
				+ contReleaseRevenue + ", contReleaseType=" + contReleaseType + ", createdBy=" + createdBy
				+ ", creationDate=" + creationDate + ", currencyCode=" + currencyCode + ", customerName=" + customerName
				+ ", customerNumber=" + customerNumber + ", customerPo=" + customerPo + ", dealNumber=" + dealNumber
				+ ", discountPercent=" + discountPercent + ", documentCategory=" + documentCategory + ", documentDate="
				+ documentDate + ", documentDescription=" + documentDescription + ", documentHeaderId="
				+ documentHeaderId + ", documentLineId=" + documentLineId + ", documentLineNumber=" + documentLineNumber
				+ ", documentLineStatus=" + documentLineStatus + ", documentNumber=" + documentNumber
				+ ", documentSource=" + documentSource + ", documentStatus=" + documentStatus + ", documentType="
				+ documentType + ", entityId=" + entityId + ", entityName=" + entityName + ", eventType=" + eventType
				+ ", extendedListAmount=" + extendedListAmount + ", inventoryItemId=" + inventoryItemId
				+ ", opportunityName=" + opportunityName + ", opportunityNumber=" + opportunityNumber
				+ ", parentLineId=" + parentLineId + ", parentLineNumber=" + parentLineNumber + ", processedDate="
				+ processedDate + ", productName=" + productName + ", projectNumber=" + projectNumber + ", quantity="
				+ quantity + ", refDocumentNumber=" + refDocumentNumber + ", refLineId=" + refLineId
				+ ", refLineNumber=" + refLineNumber + ", region=" + region + ", revenueTemplateName="
				+ revenueTemplateName + ", salesRep=" + salesRep + ", salesrepId=" + salesrepId + ", serviceEndDate="
				+ serviceEndDate + ", serviceStartDate=" + serviceStartDate + ", unitCost=" + unitCost
				+ ", unitListPrice=" + unitListPrice + ", unitSellingPrice=" + unitSellingPrice + ", uom=" + uom + "]";
	}

		
	
    
	
    

}