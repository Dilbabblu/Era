package com.forsys.revmantra.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="RMAN_FCST_ACTUAL_IFRS_V")
public class RmanFcstActualDetailsV {
    @Id
    @Column(name="SNO")
    private BigDecimal sno;



    @Column(name="GL_PERIOD")
    private String glPeriod;

    @Column(name="EXPECTED_BOOKING_AMOUNT")
    private BigDecimal expectedBookingAmount;

    @Column(name="RECORD_TYPE")
    private String recordType;

    @Column(name="AMOUNT")
    private BigDecimal amount;

    @Column(name="QTY")
    private BigDecimal qty;

    @Column(name="NET_PRICE")
    private BigDecimal netPrice;

    @Column(name="ELEMENT_TYPE")
    private String elementType;

    @Column(name="START_DATE")
    private Timestamp startDate;

    @Column(name="ARRANGEMENT_NAME")
    private String arrangementName;

    @Column(name="SKU")
    private String sku;

    
    @Column(name="ARRANGEMENT_ID")
    private BigDecimal arrangementId;

    @Column(name="QUARTER_NAME")
    private String quarterName;
        

    public BigDecimal getSno() {
        return sno;
    }

    public void setSno(BigDecimal sno) {
        this.sno = sno;
    }


    public String getGlPeriod() { 
        return this.glPeriod;
    }

    public void setGlPeriod(String glPeriod) { 
        this.glPeriod=glPeriod;
    }
    public BigDecimal getExpectedBookingAmount() { 
        return this.expectedBookingAmount;
    }

    public void setExpectedBookingAmount(BigDecimal expectedBookingAmount) { 
        this.expectedBookingAmount=expectedBookingAmount;
    }
    public String getRecordType() { 
        return this.recordType;
    }

    public void setRecordType(String recordType) { 
        this.recordType=recordType;
    }
    public BigDecimal getAmount() { 
        return this.amount;
    }

    public void setAmount(BigDecimal amount) { 
        this.amount=amount;
    }
    public BigDecimal getQty() { 
        return this.qty;
    }

    public void setQty(BigDecimal qty) { 
        this.qty=qty;
    }
    public BigDecimal getNetPrice() { 
        return this.netPrice;
    }

    public void setNetPrice(BigDecimal netPrice) { 
        this.netPrice=netPrice;
    }
    public String getElementType() { 
        return this.elementType;
    }

    public void setElementType(String elementType) { 
        this.elementType=elementType;
    }
    public Timestamp getStartDate() { 
        return this.startDate;
    }

    public void setStartDate(Timestamp startDate) { 
        this.startDate=startDate;
    }
    public String getArrangementName() { 
        return this.arrangementName;
    }

    public void setArrangementName(String arrangementName) { 
        this.arrangementName=arrangementName;
    }
    public String getSku() { 
        return this.sku;
    }

    public void setSku(String sku) { 
        this.sku=sku;
    }
    public BigDecimal getArrangementId() { 
        return this.arrangementId;
    }

    public void setArrangementId(BigDecimal arrangementId) { 
        this.arrangementId=arrangementId;
    }
    public String getQuarterName() { 
        return this.quarterName;
    }

    public void setQuarterName(String quarterName) { 
        this.quarterName=quarterName;
    }

}