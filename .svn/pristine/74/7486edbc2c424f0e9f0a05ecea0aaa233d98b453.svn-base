package com.forsys.revmantra.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="RMAN_INVOICE_HEADERS_V")
public class RmanInvoiceHeadersV {

    @Column(name="FX_RATE")
    private BigDecimal fxRate;

    @Column(name="FX_DATE")
    private Timestamp fxDate;
    
    @Id
    @Column(name="SOURCE_INVOICE_ID")
    private BigDecimal sourceInvoiceId;

    @Column(name="INVOICE_TYPE")
    private String invoiceType;

    @Column(name="INVOICE_TRX_TYPE")
    private String invoiceTrxType;

    @Column(name="INVOICE_SOURCE")
    private String invoiceSource;

    @Column(name="SALES_ORDER_NUMBER")
    private String salesOrderNumber;

    @Column(name="INVOICE_NUMBER")
    private String invoiceNumber;

    @Column(name="INVOICED_DATE")
    private Timestamp invoicedDate;

    @Column(name="INVOICE_AMOUNT")
    private BigDecimal invoiceAmount;

    @Column(name="INVOICE_CURRENCY")
    private String invoiceCurrency;

    @Column(name="ARRANGEMENT_ID")
    private BigDecimal arrangementId;

    @Column(name="ACCTD_CURRENCY")
    private String acctdCurrency;

    public String getAcctdCurrency() {
		return acctdCurrency;
	}

	public void setAcctdCurrency(String acctdCurrency) {
		this.acctdCurrency = acctdCurrency;
	}

	public BigDecimal getFxRate() { 
        return this.fxRate;
    }

    public void setFxRate(BigDecimal fxRate) { 
        this.fxRate=fxRate;
    }
    public Timestamp getFxDate() { 
        return this.fxDate;
    }

    public void setFxDate(Timestamp fxDate) { 
        this.fxDate=fxDate;
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
    public String getInvoiceTrxType() { 
        return this.invoiceTrxType;
    }

    public void setInvoiceTrxType(String invoiceTrxType) { 
        this.invoiceTrxType=invoiceTrxType;
    }
    public String getInvoiceSource() { 
        return this.invoiceSource;
    }

    public void setInvoiceSource(String invoiceSource) { 
        this.invoiceSource=invoiceSource;
    }
    public String getSalesOrderNumber() { 
        return this.salesOrderNumber;
    }

    public void setSalesOrderNumber(String salesOrderNumber) { 
        this.salesOrderNumber=salesOrderNumber;
    }
    public String getInvoiceNumber() { 
        return this.invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) { 
        this.invoiceNumber=invoiceNumber;
    }
    public Timestamp getInvoicedDate() { 
        return this.invoicedDate;
    }

    public void setInvoicedDate(Timestamp invoicedDate) { 
        this.invoicedDate=invoicedDate;
    }
    public BigDecimal getInvoiceAmount() { 
        return this.invoiceAmount;
    }

    public void setInvoiceAmount(BigDecimal invoiceAmount) { 
        this.invoiceAmount=invoiceAmount;
    }
    public String getInvoiceCurrency() { 
        return this.invoiceCurrency;
    }

    public void setInvoiceCurrency(String invoiceCurrency) { 
        this.invoiceCurrency=invoiceCurrency;
    }
    public BigDecimal getArrangementId() { 
        return this.arrangementId;
    }

    public void setArrangementId(BigDecimal arrangementId) { 
        this.arrangementId=arrangementId;
    }

}