package com.forsys.revmantra.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="RMAN_ARRG_WATER_FALL_REP_V2")
public class RmanArrgWaterFallRepV2 {

    @Column(name="PERIOD7")
    private BigDecimal period7;

    @Column(name="DEAL_ARRANGEMENT_NUMBER")
    private String dealArrangementNumber;

    @Column(name="PERIOD8")
    private BigDecimal period8;

    @Column(name="PERIOD5")
    private BigDecimal period5;

    @Column(name="REV_MANAGER_ID")
    private BigDecimal revManagerId;

    @Column(name="PERIOD6")
    private BigDecimal period6;

    @Column(name="CURRENT_PERIOD")
    private String currentPeriod;

    @Column(name="PERIOD3")
    private BigDecimal period3;

    @Column(name="PERIOD4")
    private BigDecimal period4;

    @Column(name="MSA_NAME")
    private String msaName;

    @Column(name="PERIOD1")
    private BigDecimal period1;

    @Column(name="PERIOD2")
    private BigDecimal period2;

    @Column(name="ELEMENT_TYPE")
    private String elementType;

    @Column(name="DEAL_ARRANGEMENT_NAME")
    private String dealArrangementName;

    @Column(name="CONTRACT_QUANTITY")
    private BigDecimal contractQuantity;

    @Column(name="FUTURE")
    private BigDecimal future;

    @Column(name="PERIOD9")
    private BigDecimal period9;

    @Column(name="PRODUCT_DESCRIPTION")
    private String productDescription;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="SNO")
    private BigDecimal sno;

    @Column(name="UNIT_SELLING_PRICE")
    private BigDecimal unitSellingPrice;

    @Column(name="DEAL_NAME")
    private String dealName;

    @Column(name="CREATED_BY")
    private BigDecimal createdBy;

    @Column(name="PERIOD12")
    private BigDecimal period12;

    @Column(name="MSA_NUMBER")
    private String msaNumber;

    @Column(name="PERIOD11")
    private BigDecimal period11;

    @Column(name="PRODUCT_GROUP")
    private String productGroup;

    @Column(name="DEAL_LINE_NUMBER")
    private BigDecimal dealLineNumber;

    @Column(name="PERIOD10")
    private BigDecimal period10;

    @Column(name="SOURCE_LINE_NUMBER")
    private String sourceLineNumber;

    @Column(name="LEGAL_ENTITY_ID")
    private BigDecimal legalEntityId;

    @Column(name="REV_ACCOUNTANT_ID")
    private BigDecimal revAccountantId;

    @Column(name="CREATION_DATE")
    private Timestamp creationDate;

    @Column(name="INVOICE_NUMBER")
    private String invoiceNumber;

    @Column(name="SOLUTION")
    private String solution;

    @Column(name="PRODUCT_NAME")
    private String productName;

    @Column(name="DEAL_ARRANGEMENT_ID")
    private BigDecimal dealArrangementId;

    @Column(name="PRODUCT_TYPE")
    private String productType;

    @Column(name="REVENUE_START_DATE")
    private String revenueStartDate;

    @Column(name="LEGAL_ENTITY_NAME")
    private String legalEntityName;

    @Column(name="INVOICE_LINE_NUMBER")
    private String invoiceLineNumber;

    @Column(name="ORDER_NUMBER")
    private BigDecimal orderNumber;

    @Column(name="ORDERED_QUANTITY")
    private BigDecimal orderedQuantity;

    @Column(name="DISTRIBUTION_AMOUNT")
    private BigDecimal distributionAmount;

    @Column(name="REVENUE_END_DATE")
    private String revenueEndDate;



    public BigDecimal getPeriod7() { 
        return this.period7;
    }

    public void setPeriod7(BigDecimal period7) { 
        this.period7=period7;
    }
    public String getDealArrangementNumber() { 
        return this.dealArrangementNumber;
    }

    public void setDealArrangementNumber(String dealArrangementNumber) { 
        this.dealArrangementNumber=dealArrangementNumber;
    }
    public BigDecimal getPeriod8() { 
        return this.period8;
    }

    public void setPeriod8(BigDecimal period8) { 
        this.period8=period8;
    }
    public BigDecimal getPeriod5() { 
        return this.period5;
    }

    public void setPeriod5(BigDecimal period5) { 
        this.period5=period5;
    }
    public BigDecimal getRevManagerId() { 
        return this.revManagerId;
    }

    public void setRevManagerId(BigDecimal revManagerId) { 
        this.revManagerId=revManagerId;
    }
    public BigDecimal getPeriod6() { 
        return this.period6;
    }

    public void setPeriod6(BigDecimal period6) { 
        this.period6=period6;
    }
    public String getCurrentPeriod() { 
        return this.currentPeriod;
    }

    public void setCurrentPeriod(String currentPeriod) { 
        this.currentPeriod=currentPeriod;
    }
    public BigDecimal getPeriod3() { 
        return this.period3;
    }

    public void setPeriod3(BigDecimal period3) { 
        this.period3=period3;
    }
    public BigDecimal getPeriod4() { 
        return this.period4;
    }

    public void setPeriod4(BigDecimal period4) { 
        this.period4=period4;
    }
    public String getMsaName() { 
        return this.msaName;
    }

    public void setMsaName(String msaName) { 
        this.msaName=msaName;
    }
    public BigDecimal getPeriod1() { 
        return this.period1;
    }

    public void setPeriod1(BigDecimal period1) { 
        this.period1=period1;
    }
    public BigDecimal getPeriod2() { 
        return this.period2;
    }

    public void setPeriod2(BigDecimal period2) { 
        this.period2=period2;
    }
    public String getElementType() { 
        return this.elementType;
    }

    public void setElementType(String elementType) { 
        this.elementType=elementType;
    }
    public String getDealArrangementName() { 
        return this.dealArrangementName;
    }

    public void setDealArrangementName(String dealArrangementName) { 
        this.dealArrangementName=dealArrangementName;
    }
    public BigDecimal getContractQuantity() { 
        return this.contractQuantity;
    }

    public void setContractQuantity(BigDecimal contractQuantity) { 
        this.contractQuantity=contractQuantity;
    }
    public BigDecimal getFuture() { 
        return this.future;
    }

    public void setFuture(BigDecimal future) { 
        this.future=future;
    }
    public BigDecimal getPeriod9() { 
        return this.period9;
    }

    public void setPeriod9(BigDecimal period9) { 
        this.period9=period9;
    }
    public String getProductDescription() { 
        return this.productDescription;
    }

    public void setProductDescription(String productDescription) { 
        this.productDescription=productDescription;
    }
    public BigDecimal getSno() { 
        return this.sno;
    }

    public void setSno(BigDecimal sno) { 
        this.sno=sno;
    }
    public BigDecimal getUnitSellingPrice() { 
        return this.unitSellingPrice;
    }

    public void setUnitSellingPrice(BigDecimal unitSellingPrice) { 
        this.unitSellingPrice=unitSellingPrice;
    }
    public String getDealName() { 
        return this.dealName;
    }

    public void setDealName(String dealName) { 
        this.dealName=dealName;
    }
    public BigDecimal getCreatedBy() { 
        return this.createdBy;
    }

    public void setCreatedBy(BigDecimal createdBy) { 
        this.createdBy=createdBy;
    }
    public BigDecimal getPeriod12() { 
        return this.period12;
    }

    public void setPeriod12(BigDecimal period12) { 
        this.period12=period12;
    }
    public String getMsaNumber() { 
        return this.msaNumber;
    }

    public void setMsaNumber(String msaNumber) { 
        this.msaNumber=msaNumber;
    }
    public BigDecimal getPeriod11() { 
        return this.period11;
    }

    public void setPeriod11(BigDecimal period11) { 
        this.period11=period11;
    }
    public String getProductGroup() { 
        return this.productGroup;
    }

    public void setProductGroup(String productGroup) { 
        this.productGroup=productGroup;
    }
    public BigDecimal getDealLineNumber() { 
        return this.dealLineNumber;
    }

    public void setDealLineNumber(BigDecimal dealLineNumber) { 
        this.dealLineNumber=dealLineNumber;
    }
    public BigDecimal getPeriod10() { 
        return this.period10;
    }

    public void setPeriod10(BigDecimal period10) { 
        this.period10=period10;
    }
    public String getSourceLineNumber() { 
        return this.sourceLineNumber;
    }

    public void setSourceLineNumber(String sourceLineNumber) { 
        this.sourceLineNumber=sourceLineNumber;
    }
    public BigDecimal getLegalEntityId() { 
        return this.legalEntityId;
    }

    public void setLegalEntityId(BigDecimal legalEntityId) { 
        this.legalEntityId=legalEntityId;
    }
    public BigDecimal getRevAccountantId() { 
        return this.revAccountantId;
    }

    public void setRevAccountantId(BigDecimal revAccountantId) { 
        this.revAccountantId=revAccountantId;
    }
    public Timestamp getCreationDate() { 
        return this.creationDate;
    }

    public void setCreationDate(Timestamp creationDate) { 
        this.creationDate=creationDate;
    }
    public String getInvoiceNumber() { 
        return this.invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) { 
        this.invoiceNumber=invoiceNumber;
    }
    public String getSolution() { 
        return this.solution;
    }

    public void setSolution(String solution) { 
        this.solution=solution;
    }
    public String getProductName() { 
        return this.productName;
    }

    public void setProductName(String productName) { 
        this.productName=productName;
    }
    public BigDecimal getDealArrangementId() { 
        return this.dealArrangementId;
    }

    public void setDealArrangementId(BigDecimal dealArrangementId) { 
        this.dealArrangementId=dealArrangementId;
    }
    public String getProductType() { 
        return this.productType;
    }

    public void setProductType(String productType) { 
        this.productType=productType;
    }
    public String getRevenueStartDate() { 
        return this.revenueStartDate;
    }

    public void setRevenueStartDate(String revenueStartDate) { 
        this.revenueStartDate=revenueStartDate;
    }
    public String getLegalEntityName() { 
        return this.legalEntityName;
    }

    public void setLegalEntityName(String legalEntityName) { 
        this.legalEntityName=legalEntityName;
    }
    public String getInvoiceLineNumber() { 
        return this.invoiceLineNumber;
    }

    public void setInvoiceLineNumber(String invoiceLineNumber) { 
        this.invoiceLineNumber=invoiceLineNumber;
    }
    public BigDecimal getOrderNumber() { 
        return this.orderNumber;
    }

    public void setOrderNumber(BigDecimal orderNumber) { 
        this.orderNumber=orderNumber;
    }
    public BigDecimal getOrderedQuantity() { 
        return this.orderedQuantity;
    }

    public void setOrderedQuantity(BigDecimal orderedQuantity) { 
        this.orderedQuantity=orderedQuantity;
    }
    public BigDecimal getDistributionAmount() { 
        return this.distributionAmount;
    }

    public void setDistributionAmount(BigDecimal distributionAmount) { 
        this.distributionAmount=distributionAmount;
    }
    public String getRevenueEndDate() { 
        return this.revenueEndDate;
    }

    public void setRevenueEndDate(String revenueEndDate) { 
        this.revenueEndDate=revenueEndDate;
    }

}