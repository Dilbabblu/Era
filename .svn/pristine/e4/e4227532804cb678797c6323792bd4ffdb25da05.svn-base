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

import com.forsys.revmantra.listener.RmanLegalEntitiesListener;

@Entity
@EntityListeners(RmanLegalEntitiesListener.class)
@Table(name = "RMAN_LEGAL_ENTITIES")
public class RmanLegalEntities {

	@Column(name = "REPORTING_CURRENCY")
	private String reportingCurrency;

	@Column(name = "DEF_REV_COGS_ID")
	private BigDecimal defRevCogsId;

	@Column(name = "LAST_UPDATE_DATE")
	private Timestamp lastUpdateDate;

	@Column(name = "LEDGER_NAME")
	private String ledgerName;

	@Column(name = "CURRENCY_CODE")
	private String currencyCode;

	@Column(name = "CREATED_BY")
	private BigDecimal createdBy;

	@Column(name = "ATTRIBUTE3")
	private String attribute3;

	@Column(name = "COGS_ACCOUNT_ID")
	private BigDecimal cogsAccountId;

	@Column(name = "ALLOCATION_CURRENCY")
	private String allocationCurrency;

	@Column(name = "LAST_UPDATED_BY")
	private BigDecimal lastUpdatedBy;

	@Column(name = "ATTRIBUTE2")
	private String attribute2;

	@Column(name = "ATTRIBUTE1")
	private String attribute1;

	@Column(name = "PERIOD_TYPE")
	private String periodType;

	@Column(name = "DEF_REV_ACCOUNT_ID")
	private BigDecimal defRevAccountId;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RMAN_LEGAL_ENTITIES_seq_gen")
	@SequenceGenerator(name = "RMAN_LEGAL_ENTITIES_seq_gen", sequenceName = "RMAN_LEGAL_ENTITIES_S", allocationSize=1)
	@Column(name = "LEGAL_ENTITY_ID")
	private BigDecimal legalEntityId;

	@Column(name = "ROUNDING_PRECISION")
	private BigDecimal roundingPrecision;

	@Column(name = "REV_ACCOUNT_ID")
	private BigDecimal revAccountId;

	@Column(name = "DEF_COGS_ACCOUNT_ID")
	private BigDecimal defCogsAccountId;

	@Column(name = "CREATION_DATE")
	private Timestamp creationDate;

	@Column(name = "ENABLED_FLAG")
	private String enabledFlag;

	@Column(name = "CURRENCY_FORMAT")
	private String currencyFormat;

	@Column(name = "ATTRIBUTE5")
	private String attribute5;

	@Column(name = "NAME")
	private String name;

	@Column(name = "ATTRIBUTE4")
	private String attribute4;

	@Column(name = "LOCALE")
	private String locale;

	@Column(name = "FUNCTIONAL_CURRENCY")
	private String functionalCurrency;

	@Column(name = "DEFERRED_COGS")
	private String deferredCogs;

	@Column(name = "CALENDAR")
	private String calendar;

	@Column(name = "DEFFERED_ACCOUNT")
	private String defferedAccount;

	@Column(name = "COMPANY_CODE")
	private String companyCode;

	@Column(name = "DESCRIPTION")
	private String description;
	
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
	
	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	public String getReportingCurrency() {
		return this.reportingCurrency;
	}

	public void setReportingCurrency(String reportingCurrency) {
		this.reportingCurrency = reportingCurrency;
	}

	public BigDecimal getDefRevCogsId() {
		return this.defRevCogsId;
	}

	public void setDefRevCogsId(BigDecimal defRevCogsId) {
		this.defRevCogsId = defRevCogsId;
	}

	public Timestamp getLastUpdateDate() {
		return this.lastUpdateDate;
	}

	public void setLastUpdateDate(Timestamp lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getLedgerName() {
		return this.ledgerName;
	}

	public void setLedgerName(String ledgerName) {
		this.ledgerName = ledgerName;
	}

	public String getCurrencyCode() {
		return this.currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public BigDecimal getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(BigDecimal createdBy) {
		this.createdBy = createdBy;
	}

	public String getAttribute3() {
		return this.attribute3;
	}

	public void setAttribute3(String attribute3) {
		this.attribute3 = attribute3;
	}

	public BigDecimal getCogsAccountId() {
		return this.cogsAccountId;
	}

	public void setCogsAccountId(BigDecimal cogsAccountId) {
		this.cogsAccountId = cogsAccountId;
	}

	public String getAllocationCurrency() {
		return this.allocationCurrency;
	}

	public void setAllocationCurrency(String allocationCurrency) {
		this.allocationCurrency = allocationCurrency;
	}

	public BigDecimal getLastUpdatedBy() {
		return this.lastUpdatedBy;
	}

	public void setLastUpdatedBy(BigDecimal lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public String getAttribute2() {
		return this.attribute2;
	}

	public void setAttribute2(String attribute2) {
		this.attribute2 = attribute2;
	}

	public String getAttribute1() {
		return this.attribute1;
	}

	public void setAttribute1(String attribute1) {
		this.attribute1 = attribute1;
	}

	public String getPeriodType() {
		return this.periodType;
	}

	public void setPeriodType(String periodType) {
		this.periodType = periodType;
	}

	public BigDecimal getDefRevAccountId() {
		return this.defRevAccountId;
	}

	public void setDefRevAccountId(BigDecimal defRevAccountId) {
		this.defRevAccountId = defRevAccountId;
	}

	public BigDecimal getLegalEntityId() {
		return this.legalEntityId;
	}

	public void setLegalEntityId(BigDecimal legalEntityId) {
		this.legalEntityId = legalEntityId;
	}

	public BigDecimal getRoundingPrecision() {
		return this.roundingPrecision;
	}

	public void setRoundingPrecision(BigDecimal roundingPrecision) {
		this.roundingPrecision = roundingPrecision;
	}

	public BigDecimal getRevAccountId() {
		return this.revAccountId;
	}

	public void setRevAccountId(BigDecimal revAccountId) {
		this.revAccountId = revAccountId;
	}

	public BigDecimal getDefCogsAccountId() {
		return this.defCogsAccountId;
	}

	public void setDefCogsAccountId(BigDecimal defCogsAccountId) {
		this.defCogsAccountId = defCogsAccountId;
	}

	public Timestamp getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public String getEnabledFlag() {
		return this.enabledFlag;
	}

	public void setEnabledFlag(String enabledFlag) {
		this.enabledFlag = enabledFlag;
	}

	public String getCurrencyFormat() {
		return this.currencyFormat;
	}

	public void setCurrencyFormat(String currencyFormat) {
		this.currencyFormat = currencyFormat;
	}

	public String getAttribute5() {
		return this.attribute5;
	}

	public void setAttribute5(String attribute5) {
		this.attribute5 = attribute5;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAttribute4() {
		return this.attribute4;
	}

	public void setAttribute4(String attribute4) {
		this.attribute4 = attribute4;
	}

	public String getLocale() {
		return this.locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getFunctionalCurrency() {
		return this.functionalCurrency;
	}

	public void setFunctionalCurrency(String functionalCurrency) {
		this.functionalCurrency = functionalCurrency;
	}

	public String getDeferredCogs() {
		return this.deferredCogs;
	}

	public void setDeferredCogs(String deferredCogs) {
		this.deferredCogs = deferredCogs;
	}

	public String getCalendar() {
		return this.calendar;
	}

	public void setCalendar(String calendar) {
		this.calendar = calendar;
	}

	public String getDefferedAccount() {
		return this.defferedAccount;
	}

	public void setDefferedAccount(String defferedAccount) {
		this.defferedAccount = defferedAccount;
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

	@Override
	public String toString() {
		return "RmanLegalEntities [reportingCurrency=" + reportingCurrency + ", defRevCogsId=" + defRevCogsId
				+ ", lastUpdateDate=" + lastUpdateDate + ", ledgerName=" + ledgerName + ", currencyCode=" + currencyCode
				+ ", createdBy=" + createdBy + ", attribute3=" + attribute3 + ", cogsAccountId=" + cogsAccountId
				+ ", allocationCurrency=" + allocationCurrency + ", lastUpdatedBy=" + lastUpdatedBy + ", attribute2="
				+ attribute2 + ", attribute1=" + attribute1 + ", periodType=" + periodType + ", defRevAccountId="
				+ defRevAccountId + ", legalEntityId=" + legalEntityId + ", roundingPrecision=" + roundingPrecision
				+ ", revAccountId=" + revAccountId + ", defCogsAccountId=" + defCogsAccountId + ", creationDate="
				+ creationDate + ", enabledFlag=" + enabledFlag + ", currencyFormat=" + currencyFormat + ", attribute5="
				+ attribute5 + ", name=" + name + ", attribute4=" + attribute4 + ", locale=" + locale
				+ ", functionalCurrency=" + functionalCurrency + ", deferredCogs=" + deferredCogs + ", calendar="
				+ calendar + ", defferedAccount=" + defferedAccount + ", companyCode=" + companyCode + ", description="
				+ description + ", additionalAttribute1=" + additionalAttribute1 + ", additionalAttribute2="
				+ additionalAttribute2 + ", additionalAttribute3=" + additionalAttribute3 + ", additionalAttribute4="
				+ additionalAttribute4 + ", additionalAttribute5=" + additionalAttribute5 + "]";
	}

		
	
}