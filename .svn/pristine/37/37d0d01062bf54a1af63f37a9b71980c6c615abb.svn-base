package com.forsys.revmantra.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="RMAN_FMV_RULES_EXPORT_V")
public class RmanFmvRulesExportV {

    @Column(name="FMV_RULE_NAME")
    private String fmvRuleName;

    @Column(name="QUARTER_START_DATE")
    private Timestamp quarterStartDate;

    @Column(name="MIN")
    private BigDecimal min;
    
    @Column(name="PARAMETER_NAME1")
    private String parameterName1;
    

    @Column(name="PARAMETER_NAME2")
    private String parameterName2;

    @Column(name="MAX")
    private BigDecimal max;

    @Column(name="FMV_CATEGORY")
    private String fmvCategory;
    
    @Id
    @Column(name="FMV_RULE_DEF_ID")
    private BigDecimal fmvRuleDefId;

    @Column(name="QUARTER_END_DATE")
    private Timestamp quarterEndDate;

    @Column(name="FMV_RULE_STATUS")
    private String fmvRuleStatus;

    @Column(name="PARAMETER_VALUE1")
    private String parameterValue1;
    
    @Column(name="PARAMETER_VALUE2")
    private String parameterValue2;

    
    @Column(name="FMV_TYPE")
    private String fmvType;

    @Column(name="MEDIAN")
    private BigDecimal median;
    
    @Column(name="FMV_PRICE")
    private BigDecimal fmvPrice;

	@Column(name="CURRENCY")
    private String currency;
    
    public BigDecimal getMedian() {
		return median;
	}

	public void setMedian(BigDecimal median) {
		this.median = median;
	}

	public BigDecimal getFmvPrice() {
		return fmvPrice;
	}

	public void setFmvPrice(BigDecimal fmvPrice) {
		this.fmvPrice = fmvPrice;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

    public String getFmvRuleName() { 
        return this.fmvRuleName;
    }

    public void setFmvRuleName(String fmvRuleName) { 
        this.fmvRuleName=fmvRuleName;
    }
    public Timestamp getQuarterStartDate() { 
        return this.quarterStartDate;
    }

    public void setQuarterStartDate(Timestamp quarterStartDate) { 
        this.quarterStartDate=quarterStartDate;
    }
    public BigDecimal getMin() { 
        return this.min;
    }

    public void setMin(BigDecimal min) { 
        this.min=min;
    }
   
    public BigDecimal getMax() { 
        return this.max;
    }

    public void setMax(BigDecimal max) { 
        this.max=max;
    }
    public String getFmvCategory() { 
        return this.fmvCategory;
    }

    public void setFmvCategory(String fmvCategory) { 
        this.fmvCategory=fmvCategory;
    }
    public BigDecimal getFmvRuleDefId() { 
        return this.fmvRuleDefId;
    }

    public void setFmvRuleDefId(BigDecimal fmvRuleDefId) { 
        this.fmvRuleDefId=fmvRuleDefId;
    }
    public Timestamp getQuarterEndDate() { 
        return this.quarterEndDate;
    }

    public void setQuarterEndDate(Timestamp quarterEndDate) { 
        this.quarterEndDate=quarterEndDate;
    }
    public String getFmvRuleStatus() { 
        return this.fmvRuleStatus;
    }

    public void setFmvRuleStatus(String fmvRuleStatus) { 
        this.fmvRuleStatus=fmvRuleStatus;
    }
       public String getFmvType() { 
        return this.fmvType;
    }

    public void setFmvType(String fmvType) { 
        this.fmvType=fmvType;
    }

	public String getParameterName1() {
		return parameterName1;
	}

	public void setParameterName1(String parameterName1) {
		this.parameterName1 = parameterName1;
	}

	public String getParameterName2() {
		return parameterName2;
	}

	public void setParameterName2(String parameterName2) {
		this.parameterName2 = parameterName2;
	}

	public String getParameterValue1() {
		return parameterValue1;
	}

	public void setParameterValue1(String parameterValue1) {
		this.parameterValue1 = parameterValue1;
	}

	public String getParameterValue2() {
		return parameterValue2;
	}

	public void setParameterValue2(String parameterValue2) {
		this.parameterValue2 = parameterValue2;
	}

	    
}