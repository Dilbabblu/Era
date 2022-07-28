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
import javax.persistence.Transient;

import org.hibernate.annotations.JoinColumnOrFormula;
import org.hibernate.annotations.JoinColumnsOrFormulas;
import org.hibernate.annotations.JoinFormula;

import com.forsys.revmantra.listener.RmanFmvRulesDefListener;

@Entity
@EntityListeners(RmanFmvRulesDefListener.class)
@Table(name = "RMAN_FMV_RULES_DEF")
public class RmanFmvRulesDef {

	@Column(name = "QUARTER_START_DATE")
	private Timestamp quarterStartDate;

	@Column(name = "DEAL_FLAG")
	private String dealFlag;

	@Column(name = "ATTRIBUTE30")
	private String attribute30;

	@Column(name = "LAST_UPDATE_DATE")
	private Timestamp lastUpdateDate;

	@Column(name = "APPROVER_ID")
	private BigDecimal approverId;

	@Column(name = "ATTRIBUTE29")
	private String attribute29;

	@Column(name = "ATTRIBUTE28")
	private String attribute28;

	@Column(name = "ATTRIBUTE27")
	private String attribute27;

	@Column(name = "ATTRIBUTE26")
	private String attribute26;

	@Column(name = "ATTRIBUTE3")
	private String attribute3;

	@Column(name = "CREATED_BY")
	private BigDecimal createdBy;

	@Column(name = "ATTRIBUTE2")
	private String attribute2;

	@Column(name = "LAST_UPDATED_BY")
	private BigDecimal lastUpdatedBy;

	@Column(name = "ATTRIBUTE1")
	private String attribute1;

	@Column(name = "CREATION_DATE")
	private Timestamp creationDate;

	@Column(name = "ATTRIBUTE9")
	private String attribute9;

	@Column(name = "FMV_PRICE")
	private BigDecimal fmvPrice;

	@Column(name = "ATTRIBUTE8")
	private String attribute8;

	@Column(name = "ATTRIBUTE7")
	private String attribute7;

	@Column(name = "ATTRIBUTE6")
	private String attribute6;

	@Column(name = "QUARTER_NAME")
	private String quarterName;

	@Column(name = "ATTRIBUTE5")
	private String attribute5;

	@Column(name = "ATTRIBUTE4")
	private String attribute4;

	@Column(name = "FMV_PCT")
	private BigDecimal fmvPct;

	@Column(name = "MIN")
	private BigDecimal min;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RMAN_FMV_RULES_DEF_seq_gen")
	@SequenceGenerator(name = "RMAN_FMV_RULES_DEF_seq_gen", sequenceName = "RMAN_FMV_RULES_DEF_S", allocationSize=1)
	@Column(name = "FMV_RULE_DEF_ID")
	private BigDecimal fmvRuleDefId;

	@Column(name = "ATTRIBUTE10")
	private String attribute10;

	@Column(name = "ATTRIBUTE14")
	private String attribute14;

	@Column(name = "MAX")
	private BigDecimal max;

	@Column(name = "ATTRIBUTE13")
	private String attribute13;

	@Column(name = "ATTRIBUTE12")
	private String attribute12;

	@Column(name = "ATTRIBUTE11")
	private String attribute11;

	@Column(name = "FMV_CATEGORY")
	private String fmvCategory;

	@Column(name = "QUARTER_END_DATE")
	private Timestamp quarterEndDate;

	@Column(name = "MEDIAN")
	private BigDecimal median;

	@Column(name = "FMV_RULE_STATUS")
	private String fmvRuleStatus;

	@Column(name = "FMV_RULE_NAME")
	private String fmvRuleName;

	@Column(name = "ATTRIBUTE21")
	private String attribute21;

	@Column(name = "ATTRIBUTE20")
	private String attribute20;

	@Column(name = "ATTRIBUTE25")
	private String attribute25;

	@Column(name = "ATTRIBUTE24")
	private String attribute24;

	@Column(name = "ATTRIBUTE23")
	private String attribute23;

	@Column(name = "ATTRIBUTE22")
	private String attribute22;

	@Column(name = "ENABLED_FLAG")
	private String enabledFlag;

	@Column(name = "ATTRIBUTE18")
	private String attribute18;

	@Column(name = "ATTRIBUTE17")
	private String attribute17;

	@Column(name = "ATTRIBUTE16")
	private String attribute16;

	@Column(name = "ATTRIBUTE15")
	private String attribute15;

	@Column(name = "VSOE")
	private String vsoe;

	@Column(name = "FMV_TYPE")
	private String fmvType;
	
	@Column(name = "LEGAL_ENTITY_ID")
	private BigDecimal legalEntityId;
	
	@Column(name = "BOOK_ID")
	private BigDecimal bookId;
	
	
	@OneToOne(fetch=FetchType.LAZY,optional=true)
	@JoinColumn(name="LEGAL_ENTITY_ID",insertable=false,updatable=false,referencedColumnName="LEGAL_ENTITY_ID")
	private RmanLegalEntities rmanLegalEntities;
	
	@Transient
	private String legalEntityName;
	
	@Transient
	public String getLegalEntityName(){
		return rmanLegalEntities!=null ? rmanLegalEntities.getName() : "";
	}
	
	
	public BigDecimal getLegalEntityId() {
		return legalEntityId;
	}

	public void setLegalEntityId(BigDecimal legalEntityId) {
		this.legalEntityId = legalEntityId;
	}

	

	@Column(name = "ATTRIBUTE19")
	private String attribute19;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumnsOrFormulas({
		@JoinColumnOrFormula(column = @JoinColumn(name = "FMV_CATEGORY", insertable = false, updatable = false,referencedColumnName = "LOOKUP_CODE")),
		@JoinColumnOrFormula(formula = @JoinFormula(value= "'FMV_CATEGORY'",referencedColumnName = "LOOKUP_TYPE_NAME"))
	})
	private RmanLookupsV rmanLookupsV;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumnsOrFormulas({
		@JoinColumnOrFormula(column = @JoinColumn(name = "FMV_TYPE", insertable = false, updatable = false,referencedColumnName = "LOOKUP_CODE")),
		@JoinColumnOrFormula(formula = @JoinFormula(value= "'FMV_TYPE'",referencedColumnName = "LOOKUP_TYPE_NAME"))
	})
	private RmanLookupsV rmanLookupsV1;

	public Timestamp getQuarterStartDate() {
		return this.quarterStartDate;
	}

	public void setQuarterStartDate(Timestamp quarterStartDate) {
		this.quarterStartDate = quarterStartDate;
	}

	public String getDealFlag() {
		return this.dealFlag;
	}

	public void setDealFlag(String dealFlag) {
		this.dealFlag = dealFlag;
	}

	public String getAttribute30() {
		return this.attribute30;
	}

	public void setAttribute30(String attribute30) {
		this.attribute30 = attribute30;
	}

	public Timestamp getLastUpdateDate() {
		return this.lastUpdateDate;
	}

	public void setLastUpdateDate(Timestamp lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public BigDecimal getApproverId() {
		return this.approverId;
	}

	public void setApproverId(BigDecimal approverId) {
		this.approverId = approverId;
	}

	public String getAttribute29() {
		return this.attribute29;
	}

	public void setAttribute29(String attribute29) {
		this.attribute29 = attribute29;
	}

	public String getAttribute28() {
		return this.attribute28;
	}

	public void setAttribute28(String attribute28) {
		this.attribute28 = attribute28;
	}

	public String getAttribute27() {
		return this.attribute27;
	}

	public void setAttribute27(String attribute27) {
		this.attribute27 = attribute27;
	}

	public String getAttribute26() {
		return this.attribute26;
	}

	public void setAttribute26(String attribute26) {
		this.attribute26 = attribute26;
	}

	public String getAttribute3() {
		return this.attribute3;
	}

	public void setAttribute3(String attribute3) {
		this.attribute3 = attribute3;
	}

	public BigDecimal getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(BigDecimal createdBy) {
		this.createdBy = createdBy;
	}

	public String getAttribute2() {
		return this.attribute2;
	}

	public void setAttribute2(String attribute2) {
		this.attribute2 = attribute2;
	}

	public BigDecimal getLastUpdatedBy() {
		return this.lastUpdatedBy;
	}

	public void setLastUpdatedBy(BigDecimal lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public String getAttribute1() {
		return this.attribute1;
	}

	public void setAttribute1(String attribute1) {
		this.attribute1 = attribute1;
	}

	public Timestamp getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public String getAttribute9() {
		return this.attribute9;
	}

	public void setAttribute9(String attribute9) {
		this.attribute9 = attribute9;
	}

	public BigDecimal getFmvPrice() {
		return this.fmvPrice;
	}

	public void setFmvPrice(BigDecimal fmvPrice) {
		this.fmvPrice = fmvPrice;
	}

	public String getAttribute8() {
		return this.attribute8;
	}

	public void setAttribute8(String attribute8) {
		this.attribute8 = attribute8;
	}

	public String getAttribute7() {
		return this.attribute7;
	}

	public void setAttribute7(String attribute7) {
		this.attribute7 = attribute7;
	}

	public String getAttribute6() {
		return this.attribute6;
	}

	public void setAttribute6(String attribute6) {
		this.attribute6 = attribute6;
	}

	public String getQuarterName() {
		return this.quarterName;
	}

	public void setQuarterName(String quarterName) {
		this.quarterName = quarterName;
	}

	public String getAttribute5() {
		return this.attribute5;
	}

	public void setAttribute5(String attribute5) {
		this.attribute5 = attribute5;
	}

	public String getAttribute4() {
		return this.attribute4;
	}

	public void setAttribute4(String attribute4) {
		this.attribute4 = attribute4;
	}

	public BigDecimal getFmvPct() {
		return this.fmvPct;
	}

	public void setFmvPct(BigDecimal fmvPct) {
		this.fmvPct = fmvPct;
	}

	public BigDecimal getMin() {
		return this.min;
	}

	public void setMin(BigDecimal min) {
		this.min = min;
	}

	public BigDecimal getFmvRuleDefId() {
		return this.fmvRuleDefId;
	}

	public void setFmvRuleDefId(BigDecimal fmvRuleDefId) {
		this.fmvRuleDefId = fmvRuleDefId;
	}

	public String getAttribute10() {
		return this.attribute10;
	}

	public void setAttribute10(String attribute10) {
		this.attribute10 = attribute10;
	}

	public String getAttribute14() {
		return this.attribute14;
	}

	public void setAttribute14(String attribute14) {
		this.attribute14 = attribute14;
	}

	public BigDecimal getMax() {
		return this.max;
	}

	public void setMax(BigDecimal max) {
		this.max = max;
	}

	public String getAttribute13() {
		return this.attribute13;
	}

	public void setAttribute13(String attribute13) {
		this.attribute13 = attribute13;
	}

	public String getAttribute12() {
		return this.attribute12;
	}

	public void setAttribute12(String attribute12) {
		this.attribute12 = attribute12;
	}

	public String getAttribute11() {
		return this.attribute11;
	}

	public void setAttribute11(String attribute11) {
		this.attribute11 = attribute11;
	}

	public String getFmvCategory() {
		return this.fmvCategory;
	}

	public void setFmvCategory(String fmvCategory) {
		this.fmvCategory = fmvCategory;
	}

	public Timestamp getQuarterEndDate() {
		return this.quarterEndDate;
	}

	public void setQuarterEndDate(Timestamp quarterEndDate) {
		this.quarterEndDate = quarterEndDate;
	}

	public BigDecimal getMedian() {
		return this.median;
	}

	public void setMedian(BigDecimal median) {
		this.median = median;
	}

	public String getFmvRuleStatus() {
		return this.fmvRuleStatus;
	}

	public void setFmvRuleStatus(String fmvRuleStatus) {
		this.fmvRuleStatus = fmvRuleStatus;
	}

	public String getFmvRuleName() {
		return this.fmvRuleName;
	}

	public void setFmvRuleName(String fmvRuleName) {
		this.fmvRuleName = fmvRuleName;
	}

	public String getAttribute21() {
		return this.attribute21;
	}

	public void setAttribute21(String attribute21) {
		this.attribute21 = attribute21;
	}

	public String getAttribute20() {
		return this.attribute20;
	}

	public void setAttribute20(String attribute20) {
		this.attribute20 = attribute20;
	}

	public String getAttribute25() {
		return this.attribute25;
	}

	public void setAttribute25(String attribute25) {
		this.attribute25 = attribute25;
	}

	public String getAttribute24() {
		return this.attribute24;
	}

	public void setAttribute24(String attribute24) {
		this.attribute24 = attribute24;
	}

	public String getAttribute23() {
		return this.attribute23;
	}

	public void setAttribute23(String attribute23) {
		this.attribute23 = attribute23;
	}

	public String getAttribute22() {
		return this.attribute22;
	}

	public void setAttribute22(String attribute22) {
		this.attribute22 = attribute22;
	}

	public String getEnabledFlag() {
		return this.enabledFlag;
	}

	public void setEnabledFlag(String enabledFlag) {
		this.enabledFlag = enabledFlag;
	}

	public String getAttribute18() {
		return this.attribute18;
	}

	public void setAttribute18(String attribute18) {
		this.attribute18 = attribute18;
	}

	public String getAttribute17() {
		return this.attribute17;
	}

	public void setAttribute17(String attribute17) {
		this.attribute17 = attribute17;
	}

	public String getAttribute16() {
		return this.attribute16;
	}

	public void setAttribute16(String attribute16) {
		this.attribute16 = attribute16;
	}

	public String getAttribute15() {
		return this.attribute15;
	}

	public void setAttribute15(String attribute15) {
		this.attribute15 = attribute15;
	}

	public String getVsoe() {
		return this.vsoe;
	}

	public void setVsoe(String vsoe) {
		this.vsoe = vsoe;
	}

	public String getFmvType() {
		return this.fmvType;
	}

	public void setFmvType(String fmvType) {
		this.fmvType = fmvType;
	}

	public String getAttribute19() {
		return this.attribute19;
	}

	public void setAttribute19(String attribute19) {
		this.attribute19 = attribute19;
	}

	public RmanLookupsV getRmanLookupsV() {
		return rmanLookupsV;
	}

	public void setRmanLookupsV(RmanLookupsV rmanLookupsV) {
		this.rmanLookupsV = rmanLookupsV;
	}

	public RmanLookupsV getRmanLookupsV1() {
		return rmanLookupsV1;
	}

	public void setRmanLookupsV1(RmanLookupsV rmanLookupsV1) {
		this.rmanLookupsV1 = rmanLookupsV1;
	}
	

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

	public BigDecimal getBookId() {
		return bookId;
	}

	public void setBookId(BigDecimal bookId) {
		this.bookId = bookId;
	}	
	
}