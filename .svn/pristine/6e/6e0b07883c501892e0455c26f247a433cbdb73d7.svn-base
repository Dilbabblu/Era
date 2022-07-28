package com.forsys.revmantra.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.forsys.revmantra.cpk.id.RmanInvoicesStgPkId;
import com.forsys.revmantra.listener.RmanInvoicesStgListener;


@Entity
@EntityListeners(RmanInvoicesStgListener.class)
@Table(name="RMAN_INVOICES_STG")
@IdClass(RmanInvoicesStgPkId.class)
public class RmanInvoicesStg {

    @Column(name="FX_DATE")
    private Timestamp fxDate;

    @Column(name="INVOICE_SOURCE")
    private String invoiceSource;

    @Column(name="ERROR_MESSAGE")
    private String errorMessage;

    @Column(name="SALES_ORDER_NUMBER")
    private String salesOrderNumber;

    @Column(name="SALES_ORDER_LINE")
    private String salesOrderLine;

    @Column(name="INVOICED_DATE")
    private Timestamp invoicedDate;

    @Column(name="SALES_ORDER_LINE_ID")
    private String salesOrderLineId;
    
    @Id
    @Column(name="SOURCE_INVOICE_LINE_ID")
    private BigDecimal sourceInvoiceLineId;

    @Column(name="INVOICE_CURRENCY")
    private String invoiceCurrency;

    @Column(name="SERVICE_PERIOD")
    private String servicePeriod;

    @Column(name="USD_AMOUNT")
    private BigDecimal usdAmount;

    @Column(name="REVENUE_AMOUNT")
    private BigDecimal revenueAmount;

    @Column(name="FX_RATE")
    private BigDecimal fxRate;

    @Column(name="ACTUAL_SHIPPED_DATE")
    private Timestamp actualShippedDate;

    @Column(name="SOURCE_INVOICE_ID")
    private BigDecimal sourceInvoiceId;

    @Column(name="INVOICE_TYPE")
    private String invoiceType;

    @Column(name="SERVICE_START_DATE")
    private Timestamp serviceStartDate;
    
    @Id
    @Column(name="PROCESS_ID")
    private String processId;

    @Column(name="SERVICE_DURATION")
    private BigDecimal serviceDuration;

    @Column(name="QUANTITY_INVOICED")
    private BigDecimal quantityInvoiced;

    @Column(name="LINE_TYPE")
    private String lineType;

    @Column(name="BILLING_UOM")
    private String billingUom;

    @Column(name="INVOICE_NUMBER")
    private String invoiceNumber;

    @Column(name="ACCTD_REV_AMOUNT")
    private BigDecimal acctdRevAmount;

    @Column(name="GL_DATE")
    private Timestamp glDate;

    @Column(name="ACCOUNTING_RULE_NAME")
    private String accountingRuleName;

    @Column(name="SERVICE_END_DATE")
    private Timestamp serviceEndDate;

    @Column(name="PROCESS_FLAG")
    private String processFlag;

    @Column(name="INVOICE_TRX_TYPE")
    private String invoiceTrxType;

    @Column(name="INVOICE_LINE_NUMBER")
    private String invoiceLineNumber;

    @Column(name="RMAN_ACCT_RULE_ID")
    private BigDecimal rmanAcctRuleId;
    
    @Column(name="CREATED_BY")
    private BigDecimal createdBy;
    
    @Column(name="DEBIT_ACCOUNT")
    private String debitAccount;
    
    @Column(name="CREDIT_ACCOUNT")
    private String creditAccount;
    
    @Column(name="UNIT_SELLING_PRICE")
    private BigDecimal unitSellingPrice;
    
    @Column(name="ACCTD_CURRENCY")
    private String acctdCurrency;
    
    public BigDecimal getUnitSellingPrice() {
		return unitSellingPrice;
	}

	public String getAcctdCurrency() {
		return acctdCurrency;
	}

	public void setAcctdCurrency(String acctdCurrency) {
		this.acctdCurrency = acctdCurrency;
	}

	public void setUnitSellingPrice(BigDecimal unitSellingPrice) {
		this.unitSellingPrice = unitSellingPrice;
	}

	public String getDebitAccount() {
		return debitAccount;
	}

	public void setDebitAccount(String debitAccount) {
		this.debitAccount = debitAccount;
	}

	public String getCreditAccount() {
		return creditAccount;
	}

	public void setCreditAccount(String creditAccount) {
		this.creditAccount = creditAccount;
	}

	public BigDecimal getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(BigDecimal createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getFxDate() { 
        return this.fxDate;
    }

    public void setFxDate(Timestamp fxDate) { 
        this.fxDate=fxDate;
    }
    public String getInvoiceSource() { 
        return this.invoiceSource;
    }

    public void setInvoiceSource(String invoiceSource) { 
        this.invoiceSource=invoiceSource;
    }
    public String getErrorMessage() { 
        return this.errorMessage;
    }

    public void setErrorMessage(String errorMessage) { 
        this.errorMessage=errorMessage;
    }
    public String getSalesOrderNumber() { 
        return this.salesOrderNumber;
    }

    public void setSalesOrderNumber(String salesOrderNumber) { 
        this.salesOrderNumber=salesOrderNumber;
    }
    public String getSalesOrderLine() { 
        return this.salesOrderLine;
    }

    public void setSalesOrderLine(String salesOrderLine) { 
        this.salesOrderLine=salesOrderLine;
    }
    public Timestamp getInvoicedDate() { 
        return this.invoicedDate;
    }

    public void setInvoicedDate(Timestamp invoicedDate) { 
        this.invoicedDate=invoicedDate;
    }
    public String getSalesOrderLineId() { 
        return this.salesOrderLineId;
    }

    public void setSalesOrderLineId(String salesOrderLineId) { 
        this.salesOrderLineId=salesOrderLineId;
    }
    public BigDecimal getSourceInvoiceLineId() { 
        return this.sourceInvoiceLineId;
    }

    public void setSourceInvoiceLineId(BigDecimal sourceInvoiceLineId) { 
        this.sourceInvoiceLineId=sourceInvoiceLineId;
    }
    public String getInvoiceCurrency() { 
        return this.invoiceCurrency;
    }

    public void setInvoiceCurrency(String invoiceCurrency) { 
        this.invoiceCurrency=invoiceCurrency;
    }
    public String getServicePeriod() { 
        return this.servicePeriod;
    }

    public void setServicePeriod(String servicePeriod) { 
        this.servicePeriod=servicePeriod;
    }
    public BigDecimal getUsdAmount() { 
        return this.usdAmount;
    }

    public void setUsdAmount(BigDecimal usdAmount) { 
        this.usdAmount=usdAmount;
    }
    public BigDecimal getRevenueAmount() { 
        return this.revenueAmount;
    }

    public void setRevenueAmount(BigDecimal revenueAmount) { 
        this.revenueAmount=revenueAmount;
    }
    public BigDecimal getFxRate() { 
        return this.fxRate;
    }

    public void setFxRate(BigDecimal fxRate) { 
        this.fxRate=fxRate;
    }
    public Timestamp getActualShippedDate() { 
        return this.actualShippedDate;
    }

    public void setActualShippedDate(Timestamp actualShippedDate) { 
        this.actualShippedDate=actualShippedDate;
    }
    public BigDecimal getSourceInvoiceId() { 
        return this.sourceInvoiceId;
    }

    public void setSourceInvoiceId(BigDecimal sourceInvoiceId) { 
        this.sourceInvoiceId=sourceInvoiceId;
    }
    public String getInvoiceType() { 
        return this.invoiceType;
    }

    public void setInvoiceType(String invoiceType) { 
        this.invoiceType=invoiceType;
    }
    public Timestamp getServiceStartDate() { 
        return this.serviceStartDate;
    }

    public void setServiceStartDate(Timestamp serviceStartDate) { 
        this.serviceStartDate=serviceStartDate;
    }
    public String getProcessId() { 
        return this.processId;
    }

    public void setProcessId(String processId) { 
        this.processId=processId;
    }
    public BigDecimal getServiceDuration() { 
        return this.serviceDuration;
    }

    public void setServiceDuration(BigDecimal serviceDuration) { 
        this.serviceDuration=serviceDuration;
    }
    public BigDecimal getQuantityInvoiced() { 
        return this.quantityInvoiced;
    }

    public void setQuantityInvoiced(BigDecimal quantityInvoiced) { 
        this.quantityInvoiced=quantityInvoiced;
    }
    public String getLineType() { 
        return this.lineType;
    }

    public void setLineType(String lineType) { 
        this.lineType=lineType;
    }
    public String getBillingUom() { 
        return this.billingUom;
    }

    public void setBillingUom(String billingUom) { 
        this.billingUom=billingUom;
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
    public Timestamp getGlDate() { 
        return this.glDate;
    }

    public void setGlDate(Timestamp glDate) { 
        this.glDate=glDate;
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
    public String getProcessFlag() { 
        return this.processFlag;
    }

    public void setProcessFlag(String processFlag) { 
        this.processFlag=processFlag;
    }
    public String getInvoiceTrxType() { 
        return this.invoiceTrxType;
    }

    public void setInvoiceTrxType(String invoiceTrxType) { 
        this.invoiceTrxType=invoiceTrxType;
    }
    public String getInvoiceLineNumber() { 
        return this.invoiceLineNumber;
    }

    public void setInvoiceLineNumber(String invoiceLineNumber) { 
        this.invoiceLineNumber=invoiceLineNumber;
    }
    public BigDecimal getRmanAcctRuleId() { 
        return this.rmanAcctRuleId;
    }

    public void setRmanAcctRuleId(BigDecimal rmanAcctRuleId) { 
        this.rmanAcctRuleId=rmanAcctRuleId;
    }

}