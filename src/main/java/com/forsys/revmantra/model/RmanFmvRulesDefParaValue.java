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

import com.forsys.revmantra.listener.RmanFmvRulesDefParaValueListener;

@Entity
@EntityListeners(RmanFmvRulesDefParaValueListener.class)
@Table(name = "RMAN_FMV_RULES_DEF_PARA_VALUE")
public class RmanFmvRulesDefParaValue {

	@Column(name = "ATTRIBUTE10")
	private String attribute10;

	@Column(name = "DEAL_FLAG")
	private String dealFlag;

	@Column(name = "ATTRIBUTE14")
	private String attribute14;

	@Column(name = "ATTRIBUTE13")
	private String attribute13;

	@Column(name = "RULE_HEADER_ID")
	private BigDecimal ruleHeaderId;

	@Column(name = "ATTRIBUTE12")
	private String attribute12;

	@Column(name = "ATTRIBUTE11")
	private String attribute11;

	@Column(name = "LAST_UPDATE_DATE")
	private Timestamp lastUpdateDate;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RMAN_FMV_RULES_DEF_PARA_VALUE_seq_gen")
	@SequenceGenerator(name = "RMAN_FMV_RULES_DEF_PARA_VALUE_seq_gen", sequenceName = "RMAN_FMV_RULES_PARA_VALUE_S", allocationSize=1)
	@Column(name = "PARAMETER_VALUE_ID")
	private BigDecimal parameterValueId;

	@Column(name = "PARAMETER_ID")
	private BigDecimal parameterId;

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

	@Column(name = "ATTRIBUTE8")
	private String attribute8;

	@Column(name = "ATTRIBUTE7")
	private String attribute7;

	@Column(name = "ATTRIBUTE6")
	private String attribute6;

	@Column(name = "ATTRIBUTE5")
	private String attribute5;

	@Column(name = "ATTRIBUTE4")
	private String attribute4;

	@Column(name = "PARAMETER_GROUP")
	private BigDecimal parameterGroup;

	@Column(name = "FMV_RULE_DEF_ID")
	private BigDecimal fmvRuleDefId;

	@Column(name = "ATTRIBUTE15")
	private String attribute15;

	@Column(name = "QUALIFIER")
	private String qualifier;

	@Column(name = "AND_OR")
	private String andOr;

	@Column(name = "PARAMETER_VALUE")
	private String parameterValue;

	@OneToOne(fetch = FetchType.EAGER)

	@JoinColumn(name = "QUALIFIER", insertable = false, updatable = false)
	private RmanLookupsV rmanLookupsV;

	@OneToOne(fetch = FetchType.EAGER)

	@JoinColumn(name = "AND_OR", insertable = false, updatable = false)
	private RmanLookupsV rmanLookupsV1;

	@OneToOne(fetch = FetchType.EAGER)

	@JoinColumn(name = "PARAMETER_ID", insertable = false, updatable = false)
	private RmanEntityParametersV rmanEntityParametersV;

	public RmanEntityParametersV getRmanEntityParametersV() {
		return rmanEntityParametersV;
	}

	public void setRmanEntityParametersV(RmanEntityParametersV rmanEntityParametersV) {
		this.rmanEntityParametersV = rmanEntityParametersV;
	}

	public String getAttribute10() {
		return this.attribute10;
	}

	public void setAttribute10(String attribute10) {
		this.attribute10 = attribute10;
	}

	public String getDealFlag() {
		return this.dealFlag;
	}

	public void setDealFlag(String dealFlag) {
		this.dealFlag = dealFlag;
	}

	public String getAttribute14() {
		return this.attribute14;
	}

	public void setAttribute14(String attribute14) {
		this.attribute14 = attribute14;
	}

	public String getAttribute13() {
		return this.attribute13;
	}

	public void setAttribute13(String attribute13) {
		this.attribute13 = attribute13;
	}

	public BigDecimal getRuleHeaderId() {
		return this.ruleHeaderId;
	}

	public void setRuleHeaderId(BigDecimal ruleHeaderId) {
		this.ruleHeaderId = ruleHeaderId;
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

	public Timestamp getLastUpdateDate() {
		return this.lastUpdateDate;
	}

	public void setLastUpdateDate(Timestamp lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public BigDecimal getParameterValueId() {
		return this.parameterValueId;
	}

	public void setParameterValueId(BigDecimal parameterValueId) {
		this.parameterValueId = parameterValueId;
	}

	public BigDecimal getParameterId() {
		return this.parameterId;
	}

	public void setParameterId(BigDecimal parameterId) {
		this.parameterId = parameterId;
	}

	public String getAttribute3() {
		return this.attribute3;
	}

	public void setAttribute3(String attribute3) {
		this.attribute3 = attribute3;
	}

	public String getAttribute2() {
		return this.attribute2;
	}

	public BigDecimal getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(BigDecimal createdBy) {
		this.createdBy = createdBy;
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

	public BigDecimal getParameterGroup() {
		return this.parameterGroup;
	}

	public void setParameterGroup(BigDecimal parameterGroup) {
		this.parameterGroup = parameterGroup;
	}

	public BigDecimal getFmvRuleDefId() {
		return this.fmvRuleDefId;
	}

	public void setFmvRuleDefId(BigDecimal fmvRuleDefId) {
		this.fmvRuleDefId = fmvRuleDefId;
	}

	public String getAttribute15() {
		return this.attribute15;
	}

	public void setAttribute15(String attribute15) {
		this.attribute15 = attribute15;
	}

	public String getQualifier() {
		return this.qualifier;
	}

	public void setQualifier(String qualifier) {
		this.qualifier = qualifier;
	}

	public String getAndOr() {
		return this.andOr;
	}

	public void setAndOr(String andOr) {
		this.andOr = andOr;
	}

	public String getParameterValue() {
		return this.parameterValue;
	}

	public void setParameterValue(String parameterValue) {
		this.parameterValue = parameterValue;
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

}