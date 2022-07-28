package com.forsys.revmantra.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.forsys.revmantra.listener.AyaraSspGroupingRuleDimensionsListener;


@Entity
@EntityListeners(AyaraSspGroupingRuleDimensionsListener.class)
@Table(name="AYARA_SSP_GROUPING_RULE_DIMENSIONS")
public class AyaraSspGroupingRuleDimensions {

    @Column(name="ATTRIBUTE3")
    private String attribute3;

    @Column(name="DIMENSION_NAME")
    private String dimensionName;

    @Column(name="ATTRIBUTE2")
    private String attribute2;

    @Column(name="ATTRIBUTE1")
    private String attribute1;

    @Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AYARA_SSP_GROUPING_RULE_DIMENSIONS_seq_gen")
	@SequenceGenerator(name = "AYARA_SSP_GROUPING_RULE_DIMENSIONS_seq_gen", sequenceName = "AYARA_SSP_GROUPING_RULE_DIMENSIONS_S", allocationSize=1)
    @Column(name="DIMENSION_ID")
    private BigDecimal dimensionId;

    @Column(name="AND_OR")
    private String andOr;

    @Column(name="ATTRIBUTE5")
    private String attribute5;

    @Column(name="ATTRIBUTE4")
    private String attribute4;
    
    @Column(name="GROUP_ID")
    private BigDecimal groupId;

    @Column(name="CREATION_DATE")
	private Timestamp creationDate;
	
	@Column(name="CREATED_BY")
	private BigDecimal createdBy;
	
	@Column(name="LAST_UPDATE_DATE")
	private Timestamp lastUpdateDate;
	
	@Column(name="LAST_UPDATED_BY")
	private BigDecimal lastUpdatedBy;
	
    
    @OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ATTRIBUTE3", insertable = false, updatable = false)
	private RmanLookupsV rmanLookupsV;

	
    public RmanLookupsV getRmanLookupsV() {
		return rmanLookupsV;
	}

	public void setRmanLookupsV(RmanLookupsV rmanLookupsV) {
		this.rmanLookupsV = rmanLookupsV;
	}

	public String getAttribute3() { 
        return this.attribute3;
    }

    public void setAttribute3(String attribute3) { 
        this.attribute3=attribute3;
    }
    public String getDimensionName() { 
        return this.dimensionName;
    }

    public void setDimensionName(String dimensionName) { 
        this.dimensionName=dimensionName;
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
    public BigDecimal getDimensionId() { 
        return this.dimensionId;
    }

    public void setDimensionId(BigDecimal dimensionId) { 
        this.dimensionId=dimensionId;
    }
    public String getAndOr() { 
        return this.andOr;
    }

    public void setAndOr(String andOr) { 
        this.andOr=andOr;
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
    
    public BigDecimal getGroupId() {
		return groupId;
	}

	public void setGroupId(BigDecimal groupId) {
		this.groupId = groupId;
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