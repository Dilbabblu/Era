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


@Entity
@Table(name="RMAN_INVOICE_LINES_INTERFACE")
public class RmanInvoiceLinesInterface {

    @Column(name="FX_DATE")
    private Timestamp fxDate;

    @Column(name="ACCTD_CURRENCY")
    private String acctdCurrency;

    @Column(name="INVOICE_SOURCE")
    private String invoiceSource;

    @Column(name="QUANTITY")
    private BigDecimal quantity;

    @Column(name="SALES_ORDER_NUMBER")
    private String salesOrderNumber;

    @Column(name="ORIG_LAST_UPDATED_BY")
    private BigDecimal origLastUpdatedBy;

    @Column(name="INVOICE_CURRENCY")
    private String invoiceCurrency;

    @Column(name="LAST_UPDATE_DATE")
    private Timestamp lastUpdateDate;

    @Column(name="ACTUAL_SHIPPED_DATE")
    private Timestamp actualShippedDate;

    @Column(name="INVOICE_TYPE")
    private String invoiceType;

    @Column(name="UNIT_SELLING_PRICE")
    private BigDecimal unitSellingPrice;

    @Column(name="CREATED_BY")
    private BigDecimal createdBy;

    @Column(name="LAST_UPDATED_BY")
    private BigDecimal lastUpdatedBy;

    @Column(name="COGS_AMOUNT")
    private BigDecimal cogsAmount;

    @Column(name="ORIG_CREATED_BY")
    private BigDecimal origCreatedBy;

    @Column(name="DEBIT_ACCOUNT")
    private String debitAccount;

    @Column(name="SOURCE_LINE_NUMBER")
    private String sourceLineNumber;

    @Column(name="SOURCE_ORDER_LINE_ID")
    private BigDecimal sourceOrderLineId;

    @Column(name="CREATION_DATE")
    private Timestamp creationDate;

    @Column(name="GL_DATE")
    private Timestamp glDate;

    @Column(name="ORIG_LAST_UPDATE_DATE")
    private Timestamp origLastUpdateDate;

    @Column(name="INTERFACE_PROCESS_ID")
    private BigDecimal interfaceProcessId;

    @Column(name="RMAN_ACCT_RULE_ID")
    private BigDecimal rmanAcctRuleId;

    @Column(name="RMAN_LINE_ID")
    private BigDecimal rmanLineId;

    @Column(name="RMAN_INVOICE_LINE_ID")
    private BigDecimal rmanInvoiceLineId;

    @Column(name="ERROR_MESSAGE")
    private String errorMessage;

    @Column(name="ORIG_CREATION_DATE")
    private Timestamp origCreationDate;

    @Column(name="INVOICED_DATE")
    private Timestamp invoicedDate;
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RMAN_INVOICE_LINES_seq_gen")
    @SequenceGenerator(name="RMAN_INVOICE_LINES_seq_gen", sequenceName="RMAN_INVOICE_LINES_S", allocationSize=1)
    @Column(name="SOURCE_INVOICE_LINE_ID")
    private BigDecimal sourceInvoiceLineId;

    @Column(name="SERVICE_PERIOD")
    private String servicePeriod;

    @Column(name="USD_AMOUNT")
    private BigDecimal usdAmount;

    @Column(name="REVENUE_AMOUNT")
    private BigDecimal revenueAmount;

    @Column(name="ERROR_FLAG")
    private String errorFlag;

    @Column(name="INTERFACE_STATUS")
    private String interfaceStatus;

    @Column(name="FX_RATE")
    private BigDecimal fxRate;

    @Column(name="SOURCE_INVOICE_ID")
    private BigDecimal sourceInvoiceId;

    @Column(name="SERVICE_START_DATE")
    private Timestamp serviceStartDate;

    @Column(name="SERVICE_DURATION")
    private BigDecimal serviceDuration;

    @Column(name="LINE_TYPE")
    private String lineType;

    @Column(name="COGS_ACCOUNT")
    private String cogsAccount;

    @Column(name="INVOICE_NUMBER")
    private String invoiceNumber;

    @Column(name="ACCTD_REV_AMOUNT")
    private BigDecimal acctdRevAmount;

    @Column(name="PID")
    private String pid;

    @Column(name="ACCOUNTING_RULE_NAME")
    private String accountingRuleName;

    @Column(name="SERVICE_END_DATE")
    private Timestamp serviceEndDate;

    @Column(name="INVOICE_TRX_TYPE")
    private String invoiceTrxType;

    @Column(name="INVOICE_LINE_NUMBER")
    private String invoiceLineNumber;

    @Column(name="PROCESSED_DATE")
    private Timestamp processedDate;

    @Column(name="CREDIT_ACCOUNT")
    private String creditAccount;
    
    @Column(name="SALES_ORDER_LINE")
    private String salesOrderLine;
    
    @Column(name="SALES_ORDER_LINE_ID")
    private String salesOrderLineId;
    
    @Column(name="QUANTITY_INVOICED")
    private BigDecimal quantityInvoiced;

    @Column(name="PROCESS_FLAG")
    private String processFlag;
    
    @Column(name="PROCESS_ID")
    private String processId;
    
    @Column(name = "FILE_NAME")
	private String fileName;
	
	@Column(name = "FILE_TYPE")
	private String fileType;
    
	@Column(name= "ADDITIONAL_ATTRIBUTE1")
	private String additionalAttribute1;
	
	@Column(name= "ADDITIONAL_ATTRIBUTE2")
	private String additionalAttribute2;
	
	@Column(name= "ADDITIONAL_ATTRIBUTE3")
	private String additionalAttribute3;
	
	@Column(name= "ADDITIONAL_ATTRIBUTE4")
	private String additionalAttribute4;
	
	@Column(name= "ADDITIONAL_ATTRIBUTE5")
	private String additionalAttribute5;
    
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
    public String getInvoiceSource() { 
        return this.invoiceSource;
    }

    public void setInvoiceSource(String invoiceSource) { 
        this.invoiceSource=invoiceSource;
    }
    public BigDecimal getQuantity() { 
        return this.quantity;
    }

    public void setQuantity(BigDecimal quantity) { 
        this.quantity=quantity;
    }
    public String getSalesOrderNumber() { 
        return this.salesOrderNumber;
    }

    public void setSalesOrderNumber(String salesOrderNumber) { 
        this.salesOrderNumber=salesOrderNumber;
    }
    public BigDecimal getOrigLastUpdatedBy() { 
        return this.origLastUpdatedBy;
    }

    public void setOrigLastUpdatedBy(BigDecimal origLastUpdatedBy) { 
        this.origLastUpdatedBy=origLastUpdatedBy;
    }
    public String getInvoiceCurrency() { 
        return this.invoiceCurrency;
    }

    public void setInvoiceCurrency(String invoiceCurrency) { 
        this.invoiceCurrency=invoiceCurrency;
    }
    public Timestamp getLastUpdateDate() { 
        return this.lastUpdateDate;
    }

    public void setLastUpdateDate(Timestamp lastUpdateDate) { 
        this.lastUpdateDate=lastUpdateDate;
    }
    public Timestamp getActualShippedDate() { 
        return this.actualShippedDate;
    }

    public void setActualShippedDate(Timestamp actualShippedDate) { 
        this.actualShippedDate=actualShippedDate;
    }
    public String getInvoiceType() { 
        return this.invoiceType;
    }

    public void setInvoiceType(String invoiceType) { 
        this.invoiceType=invoiceType;
    }
    public BigDecimal getUnitSellingPrice() { 
        return this.unitSellingPrice;
    }

    public void setUnitSellingPrice(BigDecimal unitSellingPrice) { 
        this.unitSellingPrice=unitSellingPrice;
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
    public BigDecimal getCogsAmount() { 
        return this.cogsAmount;
    }

    public void setCogsAmount(BigDecimal cogsAmount) { 
        this.cogsAmount=cogsAmount;
    }
    public BigDecimal getOrigCreatedBy() { 
        return this.origCreatedBy;
    }

    public void setOrigCreatedBy(BigDecimal origCreatedBy) { 
        this.origCreatedBy=origCreatedBy;
    }
    public String getDebitAccount() { 
        return this.debitAccount;
    }

    public void setDebitAccount(String debitAccount) { 
        this.debitAccount=debitAccount;
    }
    public String getSourceLineNumber() { 
        return this.sourceLineNumber;
    }

    public void setSourceLineNumber(String sourceLineNumber) { 
        this.sourceLineNumber=sourceLineNumber;
    }
    public BigDecimal getSourceOrderLineId() { 
        return this.sourceOrderLineId;
    }

    public void setSourceOrderLineId(BigDecimal sourceOrderLineId) { 
        this.sourceOrderLineId=sourceOrderLineId;
    }
    public Timestamp getCreationDate() { 
        return this.creationDate;
    }

    public void setCreationDate(Timestamp creationDate) { 
        this.creationDate=creationDate;
    }
    public Timestamp getGlDate() { 
        return this.glDate;
    }

    public void setGlDate(Timestamp glDate) { 
        this.glDate=glDate;
    }
    public Timestamp getOrigLastUpdateDate() { 
        return this.origLastUpdateDate;
    }

    public void setOrigLastUpdateDate(Timestamp origLastUpdateDate) { 
        this.origLastUpdateDate=origLastUpdateDate;
    }
    public BigDecimal getInterfaceProcessId() { 
        return this.interfaceProcessId;
    }

    public void setInterfaceProcessId(BigDecimal interfaceProcessId) { 
        this.interfaceProcessId=interfaceProcessId;
    }
    public BigDecimal getRmanAcctRuleId() { 
        return this.rmanAcctRuleId;
    }

    public void setRmanAcctRuleId(BigDecimal rmanAcctRuleId) { 
        this.rmanAcctRuleId=rmanAcctRuleId;
    }
    public BigDecimal getRmanLineId() { 
        return this.rmanLineId;
    }

    public void setRmanLineId(BigDecimal rmanLineId) { 
        this.rmanLineId=rmanLineId;
    }
    public BigDecimal getRmanInvoiceLineId() { 
        return this.rmanInvoiceLineId;
    }

    public void setRmanInvoiceLineId(BigDecimal rmanInvoiceLineId) { 
        this.rmanInvoiceLineId=rmanInvoiceLineId;
    }
    public String getErrorMessage() { 
        return this.errorMessage;
    }

    public void setErrorMessage(String errorMessage) { 
        this.errorMessage=errorMessage;
    }
    public Timestamp getOrigCreationDate() { 
        return this.origCreationDate;
    }

    public void setOrigCreationDate(Timestamp origCreationDate) { 
        this.origCreationDate=origCreationDate;
    }
    public Timestamp getInvoicedDate() { 
        return this.invoicedDate;
    }

    public void setInvoicedDate(Timestamp invoicedDate) { 
        this.invoicedDate=invoicedDate;
    }
    public BigDecimal getSourceInvoiceLineId() { 
        return this.sourceInvoiceLineId;
    }

    public void setSourceInvoiceLineId(BigDecimal sourceInvoiceLineId) { 
        this.sourceInvoiceLineId=sourceInvoiceLineId;
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
    public String getErrorFlag() { 
        return this.errorFlag;
    }

    public void setErrorFlag(String errorFlag) { 
        this.errorFlag=errorFlag;
    }
    public String getInterfaceStatus() { 
        return this.interfaceStatus;
    }

    public void setInterfaceStatus(String interfaceStatus) { 
        this.interfaceStatus=interfaceStatus;
    }
    public BigDecimal getFxRate() { 
        return this.fxRate;
    }

    public void setFxRate(BigDecimal fxRate) { 
        this.fxRate=fxRate;
    }
    public BigDecimal getSourceInvoiceId() { 
        return this.sourceInvoiceId;
    }

    public void setSourceInvoiceId(BigDecimal sourceInvoiceId) { 
        this.sourceInvoiceId=sourceInvoiceId;
    }
    public Timestamp getServiceStartDate() { 
        return this.serviceStartDate;
    }

    public void setServiceStartDate(Timestamp serviceStartDate) { 
        this.serviceStartDate=serviceStartDate;
    }
    public BigDecimal getServiceDuration() { 
        return this.serviceDuration;
    }

    public void setServiceDuration(BigDecimal serviceDuration) { 
        this.serviceDuration=serviceDuration;
    }
    public String getLineType() { 
        return this.lineType;
    }

    public void setLineType(String lineType) { 
        this.lineType=lineType;
    }
    public String getCogsAccount() { 
        return this.cogsAccount;
    }

    public void setCogsAccount(String cogsAccount) { 
        this.cogsAccount=cogsAccount;
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
    public String getPid() { 
        return this.pid;
    }

    public void setPid(String pid) { 
        this.pid=pid;
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
    public Timestamp getProcessedDate() { 
        return this.processedDate;
    }

    public void setProcessedDate(Timestamp processedDate) { 
        this.processedDate=processedDate;
    }
    public String getCreditAccount() { 
        return this.creditAccount;
    }

    public void setCreditAccount(String creditAccount) { 
        this.creditAccount=creditAccount;
    }

	public String getSalesOrderLine() {
		return salesOrderLine;
	}

	public void setSalesOrderLine(String salesOrderLine) {
		this.salesOrderLine = salesOrderLine;
	}

	public String getSalesOrderLineId() {
		return salesOrderLineId;
	}

	public void setSalesOrderLineId(String salesOrderLineId) {
		this.salesOrderLineId = salesOrderLineId;
	}

	public BigDecimal getQuantityInvoiced() {
		return quantityInvoiced;
	}

	public void setQuantityInvoiced(BigDecimal quantityInvoiced) {
		this.quantityInvoiced = quantityInvoiced;
	}

	public String getProcessFlag() {
		return processFlag;
	}

	public void setProcessFlag(String processFlag) {
		this.processFlag = processFlag;
	}

	public String getProcessId() {
		return processId;
	}

	public void setProcessId(String processId) {
		this.processId = processId;
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

	public String getAdditionalAttribute1() {
		return additionalAttribute1;
	}

	public void setAdditionalAttribute1(String additionalAttribute1) {
		this.additionalAttribute1 = additionalAttribute1;
	}

	public String getAdditionalAttribute2() {
		return additionalAttribute2;
	}

	public void setAdditionalAttribute2(String additionalAttribute2) {
		this.additionalAttribute2 = additionalAttribute2;
	}

	public String getAdditionalAttribute3() {
		return additionalAttribute3;
	}

	public void setAdditionalAttribute3(String additionalAttribute3) {
		this.additionalAttribute3 = additionalAttribute3;
	}

	public String getAdditionalAttribute4() {
		return additionalAttribute4;
	}

	public void setAdditionalAttribute4(String additionalAttribute4) {
		this.additionalAttribute4 = additionalAttribute4;
	}

	public String getAdditionalAttribute5() {
		return additionalAttribute5;
	}

	public void setAdditionalAttribute5(String additionalAttribute5) {
		this.additionalAttribute5 = additionalAttribute5;
	}
    
	
    

}