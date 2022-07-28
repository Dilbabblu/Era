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
@Table(name="RMAN_DEAL_USAGES_SUMMARY_V")
public class RmanDealUsagesSummary {

    @Column(name="ATTRIBUTE3")
    private String attribute3;

    @Column(name="ATTRIBUTE2")
    private String attribute2;

    @Column(name="DEAL_LINE_ID")
    private BigDecimal dealLineId;

    @Column(name="ATTRIBUTE1")
    private String attribute1;

    @Column(name="USAGE_END_DATE")
    private Timestamp usageEndDate;

    @Column(name="SOURCE_LINE_ID")
    private BigDecimal sourceLineId;

    @Column(name="USAGE_AMOUNT")
    private BigDecimal usageAmount;

    @Column(name="USAGE_QTY")
    private BigDecimal usageQty;

    @Column(name="ATTRIBUTE5")
    private String attribute5;

    @Column(name="ATTRIBUTE4")
    private String attribute4;

    @Column(name="DELIVERY_UOM")
    private String deliveryUom;

    @Column(name="USG_SUMMARY_LINE_NUM")
    private BigDecimal usgSummaryLineNum;

    @Column(name="USAGE_START_DATE")
    private Timestamp usageStartDate;

    @Column(name="DELIVERY_INTF_DATE")
    private Timestamp deliveryIntfDate;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RMAN_DEAL_USAGES_SUMMARY_seq_gen")
    @SequenceGenerator(name="RMAN_DEAL_USAGES_SUMMARY_seq_gen", sequenceName="RMAN_DEAL_USAGES_SUMMARY_S", allocationSize=1)
    @Column(name="USG_SUMMARY_ID")
    private BigDecimal usgSummaryId;

    @Column(name="USAGE_RATE_PER_UNIT")
    private BigDecimal usageRatePerUnit;

    @Column(name="DELIVERY_PERIOD")
    private String deliveryPeriod;
    
    @Column(name="ORDER_NUMBER")
    private BigDecimal orderNumber;
    
    @Column(name="SOURCE_LINE_NUMBER")
    private BigDecimal sourceLineNumber;

    @Column(name="SERVICE_START_DATE")
    private Timestamp serviceStartDate;
    
    @Column(name="SERVICE_END_DATE")
    private Timestamp serviceEndDate;

    public String getAttribute3() { 
        return this.attribute3;
    }

    public void setAttribute3(String attribute3) { 
        this.attribute3=attribute3;
    }
    public String getAttribute2() { 
        return this.attribute2;
    }

    public void setAttribute2(String attribute2) { 
        this.attribute2=attribute2;
    }
    public BigDecimal getDealLineId() { 
        return this.dealLineId;
    }

    public void setDealLineId(BigDecimal dealLineId) { 
        this.dealLineId=dealLineId;
    }
    public String getAttribute1() { 
        return this.attribute1;
    }

    public void setAttribute1(String attribute1) { 
        this.attribute1=attribute1;
    }
    public Timestamp getUsageEndDate() { 
        return this.usageEndDate;
    }

    public void setUsageEndDate(Timestamp usageEndDate) { 
        this.usageEndDate=usageEndDate;
    }
    public BigDecimal getSourceLineId() { 
        return this.sourceLineId;
    }

    public void setSourceLineId(BigDecimal sourceLineId) { 
        this.sourceLineId=sourceLineId;
    }
    public BigDecimal getUsageAmount() { 
        return this.usageAmount;
    }

    public void setUsageAmount(BigDecimal usageAmount) { 
        this.usageAmount=usageAmount;
    }
    public BigDecimal getUsageQty() { 
        return this.usageQty;
    }

    public void setUsageQty(BigDecimal usageQty) { 
        this.usageQty=usageQty;
    }
    public String getAttribute5() { 
        return this.attribute5;
    }

    public void setAttribute5(String attribute5) { 
        this.attribute5=attribute5;
    }
    public String getAttribute4() { 
        return this.attribute4;
    }

    public void setAttribute4(String attribute4) { 
        this.attribute4=attribute4;
    }
    public String getDeliveryUom() { 
        return this.deliveryUom;
    }

    public void setDeliveryUom(String deliveryUom) { 
        this.deliveryUom=deliveryUom;
    }
    public BigDecimal getUsgSummaryLineNum() { 
        return this.usgSummaryLineNum;
    }

    public void setUsgSummaryLineNum(BigDecimal usgSummaryLineNum) { 
        this.usgSummaryLineNum=usgSummaryLineNum;
    }
    public Timestamp getUsageStartDate() { 
        return this.usageStartDate;
    }

    public void setUsageStartDate(Timestamp usageStartDate) { 
        this.usageStartDate=usageStartDate;
    }
    public Timestamp getDeliveryIntfDate() { 
        return this.deliveryIntfDate;
    }

    public void setDeliveryIntfDate(Timestamp deliveryIntfDate) { 
        this.deliveryIntfDate=deliveryIntfDate;
    }
    public BigDecimal getUsgSummaryId() { 
        return this.usgSummaryId;
    }

    public void setUsgSummaryId(BigDecimal usgSummaryId) { 
        this.usgSummaryId=usgSummaryId;
    }
    public BigDecimal getUsageRatePerUnit() { 
        return this.usageRatePerUnit;
    }

    public void setUsageRatePerUnit(BigDecimal usageRatePerUnit) { 
        this.usageRatePerUnit=usageRatePerUnit;
    }
    public String getDeliveryPeriod() { 
        return this.deliveryPeriod;
    }

    public void setDeliveryPeriod(String deliveryPeriod) { 
        this.deliveryPeriod=deliveryPeriod;
    }

	public BigDecimal getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(BigDecimal orderNumber) {
		this.orderNumber = orderNumber;
	}

	public BigDecimal getSourceLineNumber() {
		return sourceLineNumber;
	}

	public void setSourceLineNumber(BigDecimal sourceLineNumber) {
		this.sourceLineNumber = sourceLineNumber;
	}

	public Timestamp getServiceStartDate() {
		return serviceStartDate;
	}

	public void setServiceStartDate(Timestamp serviceStartDate) {
		this.serviceStartDate = serviceStartDate;
	}

	public Timestamp getServiceEndDate() {
		return serviceEndDate;
	}

	public void setServiceEndDate(Timestamp serviceEndDate) {
		this.serviceEndDate = serviceEndDate;
	}
    
    

}