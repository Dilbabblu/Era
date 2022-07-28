package com.forsys.revmantra.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="RMAN_RECON_INVOICE_REPORT_V")
public class RmanReconInvoiceReportV {

    @Column(name="DEAL_ARRANGEMENT_NUMBER")
    private String dealArrangementNumber;

    @Column(name="END_CUSTOMER_NAME")
    private String endCustomerName;

    @Column(name="FX_DATE")
    private Timestamp fxDate;

    @Column(name="ACCTD_CURRENCY")
    private String acctdCurrency;

    @Column(name="REP_UNIT_SELLING_PRICE")
    private BigDecimal repUnitSellingPrice;

    @Column(name="INVOICED_DATE")
    private Timestamp invoicedDate;

    @Column(name="DEAL_ARRANGEMENT_NAME")
    private String dealArrangementName;

    @Column(name="INVOICE_CURRENCY")
    private String invoiceCurrency;

    @Column(name="INVOICED_QUANTITY")
    private BigDecimal invoicedQuantity;

    @Column(name="REVENUE_AMOUNT")
    private BigDecimal revenueAmount;

    @Column(name="PRODUCT_DESCRIPTION")
    private String productDescription;

    @Column(name="DEAL_ARRANGEMENT_BASIS")
    private String dealArrangementBasis;

    @Column(name="FX_RATE")
    private BigDecimal fxRate;
    
    @Id
    @Column(name="SNO")
    private BigDecimal sno;

    @Column(name="SHIPPED_QUANTITY")
    private BigDecimal shippedQuantity;

    @Column(name="DEAL_NUMBER")
    private String dealNumber;

    @Column(name="ITEM_TYPE")
    private String itemType;

    @Column(name="ACTUAL_FULFILLED_DATE")
    private Timestamp actualFulfilledDate;

    @Column(name="SALES_NODE_LEVEL2")
    private String salesNodeLevel2;

    @Column(name="SALES_NODE_LEVEL3")
    private String salesNodeLevel3;

    @Column(name="DEAL_LINE_NUMBER")
    private BigDecimal dealLineNumber;

    @Column(name="SOURCE_LINE_NUMBER")
    private String sourceLineNumber;

    @Column(name="LEGAL_ENTITY_ID")
    private BigDecimal legalEntityId;

    @Column(name="DEAL_HEADER_ID")
    private BigDecimal dealHeaderId;

    @Column(name="INVOICE_NUMBER")
    private String invoiceNumber;

    @Column(name="ACCTD_REV_AMOUNT")
    private BigDecimal acctdRevAmount;

    @Column(name="PRODUCT_NAME")
    private String productName;

    @Column(name="CUSTOMER_PO_NUM")
    private String customerPoNum;

    @Column(name="SALES_NODE_LEVEL1")
    private String salesNodeLevel1;

    @Column(name="BOOKED_DATE")
    private Timestamp bookedDate;

    @Column(name="DEAL_ARRANGEMENT_ID")
    private BigDecimal dealArrangementId;

    @Column(name="TRANSACTION_PRICE")
    private BigDecimal transactionPrice;

    @Column(name="LEGAL_ENTITY_NAME")
    private String legalEntityName;

    @Column(name="REP_UNIT_LIST_PRICE")
    private BigDecimal repUnitListPrice;

    @Column(name="INVOICE_LINE_NUMBER")
    private String invoiceLineNumber;

    @Column(name="ORDER_NUMBER")
    private BigDecimal orderNumber;

    @Column(name="ORDERED_DATE")
    private Timestamp orderedDate;

    @Column(name="ORDERED_QUANTITY")
    private BigDecimal orderedQuantity;

	@Column(name="SOURCE_LINE_ID")
    private String sourceLineId;
    
    public String getSourceLineId() {
		return sourceLineId;
	}

	public void setSourceLineId(String sourceLineId) {
		this.sourceLineId = sourceLineId;
	}

    public String getDealArrangementNumber() { 
        return this.dealArrangementNumber;
    }

    public void setDealArrangementNumber(String dealArrangementNumber) { 
        this.dealArrangementNumber=dealArrangementNumber;
    }
    public String getEndCustomerName() { 
        return this.endCustomerName;
    }

    public void setEndCustomerName(String endCustomerName) { 
        this.endCustomerName=endCustomerName;
    }
    public Timestamp getFxDate() { 
        return this.fxDate;
    }

    public void setFxDate(Timestamp fxDate) { 
        this.fxDate=fxDate;
    }
    public String getAcctdCurrency() { 
        return this.acctdCurrency;
    }

    public void setAcctdCurrency(String acctdCurrency) { 
        this.acctdCurrency=acctdCurrency;
    }
    public BigDecimal getRepUnitSellingPrice() { 
        return this.repUnitSellingPrice;
    }

    public void setRepUnitSellingPrice(BigDecimal repUnitSellingPrice) { 
        this.repUnitSellingPrice=repUnitSellingPrice;
    }
    public Timestamp getInvoicedDate() { 
        return this.invoicedDate;
    }

    public void setInvoicedDate(Timestamp invoicedDate) { 
        this.invoicedDate=invoicedDate;
    }
    public String getDealArrangementName() { 
        return this.dealArrangementName;
    }

    public void setDealArrangementName(String dealArrangementName) { 
        this.dealArrangementName=dealArrangementName;
    }
    public String getInvoiceCurrency() { 
        return this.invoiceCurrency;
    }

    public void setInvoiceCurrency(String invoiceCurrency) { 
        this.invoiceCurrency=invoiceCurrency;
    }
    public BigDecimal getInvoicedQuantity() { 
        return this.invoicedQuantity;
    }

    public void setInvoicedQuantity(BigDecimal invoicedQuantity) { 
        this.invoicedQuantity=invoicedQuantity;
    }
    public BigDecimal getRevenueAmount() { 
        return this.revenueAmount;
    }

    public void setRevenueAmount(BigDecimal revenueAmount) { 
        this.revenueAmount=revenueAmount;
    }
    public String getProductDescription() { 
        return this.productDescription;
    }

    public void setProductDescription(String productDescription) { 
        this.productDescription=productDescription;
    }
    public String getDealArrangementBasis() { 
        return this.dealArrangementBasis;
    }

    public void setDealArrangementBasis(String dealArrangementBasis) { 
        this.dealArrangementBasis=dealArrangementBasis;
    }
    public BigDecimal getFxRate() { 
        return this.fxRate;
    }

    public void setFxRate(BigDecimal fxRate) { 
        this.fxRate=fxRate;
    }
    public BigDecimal getSno() { 
        return this.sno;
    }

    public void setSno(BigDecimal sno) { 
        this.sno=sno;
    }
    public BigDecimal getShippedQuantity() { 
        return this.shippedQuantity;
    }

    public void setShippedQuantity(BigDecimal shippedQuantity) { 
        this.shippedQuantity=shippedQuantity;
    }
    public String getDealNumber() { 
        return this.dealNumber;
    }

    public void setDealNumber(String dealNumber) { 
        this.dealNumber=dealNumber;
    }
    public String getItemType() { 
        return this.itemType;
    }

    public void setItemType(String itemType) { 
        this.itemType=itemType;
    }
    public Timestamp getActualFulfilledDate() { 
        return this.actualFulfilledDate;
    }

    public void setActualFulfilledDate(Timestamp actualFulfilledDate) { 
        this.actualFulfilledDate=actualFulfilledDate;
    }
    public String getSalesNodeLevel2() { 
        return this.salesNodeLevel2;
    }

    public void setSalesNodeLevel2(String salesNodeLevel2) { 
        this.salesNodeLevel2=salesNodeLevel2;
    }
    public String getSalesNodeLevel3() { 
        return this.salesNodeLevel3;
    }

    public void setSalesNodeLevel3(String salesNodeLevel3) { 
        this.salesNodeLevel3=salesNodeLevel3;
    }
    public BigDecimal getDealLineNumber() { 
        return this.dealLineNumber;
    }

    public void setDealLineNumber(BigDecimal dealLineNumber) { 
        this.dealLineNumber=dealLineNumber;
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
    public BigDecimal getDealHeaderId() { 
        return this.dealHeaderId;
    }

    public void setDealHeaderId(BigDecimal dealHeaderId) { 
        this.dealHeaderId=dealHeaderId;
    }
    public String getInvoiceNumber() { 
        return this.invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) { 
        this.invoiceNumber=invoiceNumber;
    }
    public BigDecimal getAcctdRevAmount() { 
        return this.acctdRevAmount;
    }

    public void setAcctdRevAmount(BigDecimal acctdRevAmount) { 
        this.acctdRevAmount=acctdRevAmount;
    }
    public String getProductName() { 
        return this.productName;
    }

    public void setProductName(String productName) { 
        this.productName=productName;
    }
    public String getCustomerPoNum() { 
        return this.customerPoNum;
    }

    public void setCustomerPoNum(String customerPoNum) { 
        this.customerPoNum=customerPoNum;
    }
    public String getSalesNodeLevel1() { 
        return this.salesNodeLevel1;
    }

    public void setSalesNodeLevel1(String salesNodeLevel1) { 
        this.salesNodeLevel1=salesNodeLevel1;
    }
    public Timestamp getBookedDate() { 
        return this.bookedDate;
    }

    public void setBookedDate(Timestamp bookedDate) { 
        this.bookedDate=bookedDate;
    }
    public BigDecimal getDealArrangementId() { 
        return this.dealArrangementId;
    }

    public void setDealArrangementId(BigDecimal dealArrangementId) { 
        this.dealArrangementId=dealArrangementId;
    }
    public BigDecimal getTransactionPrice() { 
        return this.transactionPrice;
    }

    public void setTransactionPrice(BigDecimal transactionPrice) { 
        this.transactionPrice=transactionPrice;
    }
    public String getLegalEntityName() { 
        return this.legalEntityName;
    }

    public void setLegalEntityName(String legalEntityName) { 
        this.legalEntityName=legalEntityName;
    }
    public BigDecimal getRepUnitListPrice() { 
        return this.repUnitListPrice;
    }

    public void setRepUnitListPrice(BigDecimal repUnitListPrice) { 
        this.repUnitListPrice=repUnitListPrice;
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
    public Timestamp getOrderedDate() { 
        return this.orderedDate;
    }

    public void setOrderedDate(Timestamp orderedDate) { 
        this.orderedDate=orderedDate;
    }
    public BigDecimal getOrderedQuantity() { 
        return this.orderedQuantity;
    }

    public void setOrderedQuantity(BigDecimal orderedQuantity) { 
        this.orderedQuantity=orderedQuantity;
    }

}