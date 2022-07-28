package com.forsys.revmantra.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.forsys.revmantra.listener.AyaraSspGroupingRulesListener;


@Entity
@EntityListeners(AyaraSspGroupingRulesListener.class)
@Table(name="AYARA_SSP_GROUPING_RULES")
public class AyaraSspGroupingRules {

    @Column(name="ATTRIBUTE3")
    private String attribute3;

    @Column(name="ATTRIBUTE10")
    private String attribute10;

    @Column(name="ATTRIBUTE2")
    private String attribute2;

    @Column(name="ATTRIBUTE1")
    private String attribute1;

    @Column(name="RULE_NAME")
    private String ruleName;

    @Column(name="END_DATE")
    private Timestamp endDate;

    @Column(name="START_DATE")
    private Timestamp startDate;

    @Column(name="ATTRIBUTE9")
    private String attribute9;

    @Column(name="ATTRIBUTE8")
    private String attribute8;

    @Column(name="ENABLED_FLAG")
    private String enabledFlag;

    @Column(name="ATTRIBUTE7")
    private String attribute7;

    @Column(name="ATTRIBUTE6")
    private String attribute6;

    @Column(name="ATTRIBUTE5")
    private String attribute5;

    @Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AYARA_SSP_GROUPING_RULES_seq_gen")
	@SequenceGenerator(name = "AYARA_SSP_GROUPING_RULES_seq_gen", sequenceName = "AYARA_SSP_GROUPING_RULES_S", allocationSize=1)
    @Column(name="GROUP_ID")
    private BigDecimal groupId;

    @Column(name="ATTRIBUTE4")
    private String attribute4;
    
    @Column(name="CREATION_DATE")
	private Timestamp creationDate;
	
	@Column(name="CREATED_BY")
	private BigDecimal createdBy;
	
	@Column(name="LAST_UPDATE_DATE")
	private Timestamp lastUpdateDate;
	
	@Column(name="LAST_UPDATED_BY")
	private BigDecimal lastUpdatedBy;
	
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "GROUP_ID", updatable = false, insertable = false)
    List<AyaraSspGroupingRuleDimensions> ayaraSspGroupingRuleDimensions;


    public List<AyaraSspGroupingRuleDimensions> getAyaraSspGroupingRuleDimensions() {
  		return ayaraSspGroupingRuleDimensions;
  	}

  	public void setAyaraSspGroupingRuleDimensions(List<AyaraSspGroupingRuleDimensions> ayaraSspGroupingRuleDimensions) {
  		this.ayaraSspGroupingRuleDimensions = ayaraSspGroupingRuleDimensions;
  	}

	public String getAttribute3() { 
        return this.attribute3;
    }

    public void setAttribute3(String attribute3) { 
        this.attribute3=attribute3;
    }
    public String getAttribute10() { 
        return this.attribute10;
    }

    public void setAttribute10(String attribute10) { 
        this.attribute10=attribute10;
    }
    public String getAttribute2() { 
        return this.attribute2;
    }

    public void setAttribute2(String attribute2) { 
        this.attribute2=attribute2;
    }
    public String getAttribute1() { 
        return this.attribute1;
    }

    public void setAttribute1(String attribute1) { 
        this.attribute1=attribute1;
    }
    public String getRuleName() { 
        return this.ruleName;
    }

    public void setRuleName(String ruleName) { 
        this.ruleName=ruleName;
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
    public String getAttribute9() { 
        return this.attribute9;
    }

    public void setAttribute9(String attribute9) { 
        this.attribute9=attribute9;
    }
    public String getAttribute8() { 
        return this.attribute8;
    }

    public void setAttribute8(String attribute8) { 
        this.attribute8=attribute8;
    }
    public String getEnabledFlag() { 
        return this.enabledFlag;
    }

    public void setEnabledFlag(String enabledFlag) { 
        this.enabledFlag=enabledFlag;
    }
    public String getAttribute7() { 
        return this.attribute7;
    }

    public void setAttribute7(String attribute7) { 
        this.attribute7=attribute7;
    }
    public String getAttribute6() { 
        return this.attribute6;
    }

    public void setAttribute6(String attribute6) { 
        this.attribute6=attribute6;
    }
    public String getAttribute5() { 
        return this.attribute5;
    }

    public void setAttribute5(String attribute5) { 
        this.attribute5=attribute5;
    }
    public BigDecimal getGroupId() { 
        return this.groupId;
    }

    public void setGroupId(BigDecimal groupId) { 
        this.groupId=groupId;
    }
    public String getAttribute4() { 
        return this.attribute4;
    }

    public void setAttribute4(String attribute4) { 
        this.attribute4=attribute4;
    }

	public Timestamp getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public BigDecimal getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(BigDecimal createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Timestamp lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public BigDecimal getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(BigDecimal lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
    
    

}