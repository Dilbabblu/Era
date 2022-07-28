package com.forsys.revmantra.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.forsys.revmantra.listener.RmanFiscalPeriodsListener;


@Entity
@EntityListeners(RmanFiscalPeriodsListener.class)
@Table(name="RMAN_FISCAL_PERIODS")
public class RmanFiscalPeriods {

    @Column(name="QUARTER_START_DATE")
    private Timestamp quarterStartDate;

    @Column(name="CREATED_BY")
    private BigDecimal createdBy;

    @Column(name="LAST_UPDATED_BY")
    private BigDecimal lastUpdatedBy;

    @Column(name="PERIOD_YEAR")
    private BigDecimal periodYear;

    @Column(name="ADJUSTMENT_PERIOD_FLAG")
    private String adjustmentPeriodFlag;

    @Column(name="CREATION_DATE")
    private Timestamp creationDate;

    @Column(name="END_DATE")
    private Timestamp endDate;

    @Column(name="START_DATE")
    private Timestamp startDate;

    @Column(name="QUARTER_NUM")
    private BigDecimal quarterNum;

    @Column(name="SOURCE_PERIOD_ID")
    private String sourcePeriodId;

    @Column(name="LAST_UPDATE_DATE")
    private Timestamp lastUpdateDate;

    @Column(name="PERIOD_NUM")
    private BigDecimal periodNum;

    @Column(name="LEDGER_NAME")
    private String ledgerName;

    @Column(name="QUARTER_NAME")
    private String quarterName;

    @Column(name="PERIOD_NAME")
    private String periodName;

    @Column(name="ENTERED_PERIOD_NAME")
    private String enteredPeriodName;

    @Column(name="PERIOD_STATUS")
    private String periodStatus;

    @Column(name="YEAR_START_DATE")
    private Timestamp yearStartDate;
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RMAN_FISCAL_PERIODS_seq_gen")
    @SequenceGenerator(name="RMAN_FISCAL_PERIODS_seq_gen", sequenceName="RMAN_FISCAL_PERIODS_S", allocationSize=1)
    @Column(name="RMAN_PERIOD_ID")
    private BigDecimal rmanPeriodId;

    @Column(name="OPEN_FLAG")
    private String openFlag;

/**    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="PERIOD_STATUS",insertable = false, updatable = false )
    private RmanLookupsV rmanLookupsV; */


    public Timestamp getQuarterStartDate() { 
        return this.quarterStartDate;
    }

    public void setQuarterStartDate(Timestamp quarterStartDate) { 
        this.quarterStartDate=quarterStartDate;
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
    public BigDecimal getPeriodYear() { 
        return this.periodYear;
    }

    public void setPeriodYear(BigDecimal periodYear) { 
        this.periodYear=periodYear;
    }
    public String getAdjustmentPeriodFlag() { 
        return this.adjustmentPeriodFlag;
    }

    public void setAdjustmentPeriodFlag(String adjustmentPeriodFlag) { 
        this.adjustmentPeriodFlag=adjustmentPeriodFlag;
    }
    public Timestamp getCreationDate() { 
        return this.creationDate;
    }

    public void setCreationDate(Timestamp creationDate) { 
        this.creationDate=creationDate;
    }
    public Timestamp getEndDate() { 
        return this.endDate;
    }

    public void setEndDate(Timestamp endDate) { 
        this.endDate=endDate;
    }
    public Timestamp getStartDate() { 
        return this.startDate;
    }

    public void setStartDate(Timestamp startDate) { 
        this.startDate=startDate;
    }
    public BigDecimal getQuarterNum() { 
        return this.quarterNum;
    }

    public void setQuarterNum(BigDecimal quarterNum) { 
        this.quarterNum=quarterNum;
    }
    public String getSourcePeriodId() { 
        return this.sourcePeriodId;
    }

    public void setSourcePeriodId(String sourcePeriodId) { 
        this.sourcePeriodId=sourcePeriodId;
    }
    public Timestamp getLastUpdateDate() { 
        return this.lastUpdateDate;
    }

    public void setLastUpdateDate(Timestamp lastUpdateDate) { 
        this.lastUpdateDate=lastUpdateDate;
    }
    public BigDecimal getPeriodNum() { 
        return this.periodNum;
    }

    public void setPeriodNum(BigDecimal periodNum) { 
        this.periodNum=periodNum;
    }
    public String getLedgerName() { 
        return this.ledgerName;
    }

    public void setLedgerName(String ledgerName) { 
        this.ledgerName=ledgerName;
    }
    public String getQuarterName() { 
        return this.quarterName;
    }

    public void setQuarterName(String quarterName) { 
        this.quarterName=quarterName;
    }
    public String getPeriodName() { 
        return this.periodName;
    }

    public void setPeriodName(String periodName) { 
        this.periodName=periodName;
    }
    public String getEnteredPeriodName() { 
        return this.enteredPeriodName;
    }

    public void setEnteredPeriodName(String enteredPeriodName) { 
        this.enteredPeriodName=enteredPeriodName;
    }
    public String getPeriodStatus() { 
        return this.periodStatus;
    }

    public void setPeriodStatus(String periodStatus) { 
        this.periodStatus=periodStatus;
    }
    public Timestamp getYearStartDate() { 
        return this.yearStartDate;
    }

    public void setYearStartDate(Timestamp yearStartDate) { 
        this.yearStartDate=yearStartDate;
    }
    public BigDecimal getRmanPeriodId() { 
        return this.rmanPeriodId;
    }

    public void setRmanPeriodId(BigDecimal rmanPeriodId) { 
        this.rmanPeriodId=rmanPeriodId;
    }
    public String getOpenFlag() { 
        return this.openFlag;
    }

    public void setOpenFlag(String openFlag) { 
        this.openFlag=openFlag;
    }
 /**   public RmanLookupsV getRmanLookupsV() {
         return rmanLookupsV;
    }

    public void setRmanLookupsV(RmanLookupsV rmanLookupsV) {
         this.rmanLookupsV=rmanLookupsV;
    } */
    

	@Column(name = "ADDITIONAL_ATTRIBUTE1")
	private String additionalAttribute1;

	@Column(name = "ADDITIONAL_ATTRIBUTE2")
	private String additionalAttribute2;
	

	@Column(name = "ADDITIONAL_ATTRIBUTE3")
	private String additionalAttribute3;

	@Column(name = "ADDITIONAL_ATTRIBUTE4")
	private String additionalAttribute4;

	@Column(name = "ADDITIONAL_ATTRIBUTE5")
	private String additionalAttribute5;
	
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

	@Override
	public String toString() {
		return "RmanFiscalPeriods [quarterStartDate=" + quarterStartDate + ", createdBy=" + createdBy
				+ ", lastUpdatedBy=" + lastUpdatedBy + ", periodYear=" + periodYear + ", adjustmentPeriodFlag="
				+ adjustmentPeriodFlag + ", creationDate=" + creationDate + ", endDate=" + endDate + ", startDate="
				+ startDate + ", quarterNum=" + quarterNum + ", sourcePeriodId=" + sourcePeriodId + ", lastUpdateDate="
				+ lastUpdateDate + ", periodNum=" + periodNum + ", ledgerName=" + ledgerName + ", quarterName="
				+ quarterName + ", periodName=" + periodName + ", enteredPeriodName=" + enteredPeriodName
				+ ", periodStatus=" + periodStatus + ", yearStartDate=" + yearStartDate + ", rmanPeriodId="
				+ rmanPeriodId + ", openFlag=" + openFlag + ", additionalAttribute1=" + additionalAttribute1
				+ ", additionalAttribute2=" + additionalAttribute2 + ", additionalAttribute3=" + additionalAttribute3
				+ ", additionalAttribute4=" + additionalAttribute4 + ", additionalAttribute5=" + additionalAttribute5
				+ "]";
	}


}