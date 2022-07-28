package com.forsys.revmantra.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RMAN_GL_ACCOUNTING_V")
public class RmanGlAccountingV {

	@Column(name = "ACCOUNT_DESCRIPTION")
	private String accountDescription;

	@Column(name = "AMOUNT_FC")
	private BigDecimal amountFc;

	@Column(name = "SOURCE_LINE_NUMBER")
	private String sourceLineNumber;

	@Column(name = "DR_CR")
	private String drCr;

	@Column(name = "POSTED_FLAG")
	private String postedFlag;

	@Column(name = "LINE_STATUS")
	private String lineStatus;

	@Column(name = "GL_DATE")
	private Timestamp glDate;

	@Column(name = "CURRENCY_CODE")
	private String currencyCode;

	@Column(name = "PERIOD_NAME")
	private String periodName;

	@Column(name = "ACCOUNT")
	private String account;

	@Column(name = "AMOUNT_TC")
	private BigDecimal amountTc;

	@Column(name = "ORDER_NUMBER")
	private BigDecimal orderNumber;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RMAN_INTERFACE_ID")
	private BigDecimal rmanInterfaceId;

	@Column(name = "DEAL_ARRANGEMENT_ID")
	private BigDecimal dealArrangementId;

	@Column(name = "DEAL_ARRANGEMENT_NUMBER")
	private String dealArrangementNumber;

	@Column(name = "DEAL_ARRANGEMENT_NAME")
	private String dealArrangementName;

	@Column(name = "ACCOUNT_CLASS")
	private String accountClass;

	@Column(name = "FUNCTIONAL_CURRENCY")
	private String functionalCurrency;

	@Column(name = "SOURCE_LINE_ID")
	private String sourceLineId;

	@Column(name = "DEAL_LINE_NUMBER")
	private BigDecimal dealLineNumber;
	
	@Column(name = "DEAL_LINE_ID")
	private BigDecimal dealLineId;

	@Column(name = "ENTRY_TYPE")
	private String entryType;
	
	@Column(name = "SF_REF_LINE_ID")
	private String sfRefLineId;
	

	public String getSourceLineId() {
		return sourceLineId;
	}

	public BigDecimal getDealLineId() {
		return dealLineId;
	}

	public void setDealLineId(BigDecimal dealLineId) {
		this.dealLineId = dealLineId;
	}

	public void setSourceLineId(String sourceLineId) {
		this.sourceLineId = sourceLineId;
	}

	public String getDealArrangementNumber() {
		return dealArrangementNumber;
	}

	public void setDealArrangementNumber(String dealArrangementNumber) {
		this.dealArrangementNumber = dealArrangementNumber;
	}

	public String getDealArrangementName() {
		return dealArrangementName;
	}

	public void setDealArrangementName(String dealArrangementName) {
		this.dealArrangementName = dealArrangementName;
	}

	public String getAccountDescription() {
		return this.accountDescription;
	}

	public void setAccountDescription(String accountDescription) {
		this.accountDescription = accountDescription;
	}

	public BigDecimal getAmountFc() {
		return this.amountFc;
	}

	public void setAmountFc(BigDecimal amountFc) {
		this.amountFc = amountFc;
	}

	public String getSourceLineNumber() {
		return this.sourceLineNumber;
	}

	public void setSourceLineNumber(String sourceLineNumber) {
		this.sourceLineNumber = sourceLineNumber;
	}

	public String getDrCr() {
		return this.drCr;
	}

	public void setDrCr(String drCr) {
		this.drCr = drCr;
	}

	public String getPostedFlag() {
		return this.postedFlag;
	}

	public void setPostedFlag(String postedFlag) {
		this.postedFlag = postedFlag;
	}

	public String getLineStatus() {
		return this.lineStatus;
	}

	public void setLineStatus(String lineStatus) {
		this.lineStatus = lineStatus;
	}

	public Timestamp getGlDate() {
		return this.glDate;
	}

	public void setGlDate(Timestamp glDate) {
		this.glDate = glDate;
	}

	public String getCurrencyCode() {
		return this.currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getPeriodName() {
		return this.periodName;
	}

	public void setPeriodName(String periodName) {
		this.periodName = periodName;
	}

	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public BigDecimal getAmountTc() {
		return this.amountTc;
	}

	public void setAmountTc(BigDecimal amountTc) {
		this.amountTc = amountTc;
	}

	public BigDecimal getOrderNumber() {
		return this.orderNumber;
	}

	public void setOrderNumber(BigDecimal orderNumber) {
		this.orderNumber = orderNumber;
	}

	public BigDecimal getRmanInterfaceId() {
		return this.rmanInterfaceId;
	}

	public void setRmanInterfaceId(BigDecimal rmanInterfaceId) {
		this.rmanInterfaceId = rmanInterfaceId;
	}

	public BigDecimal getDealArrangementId() {
		return this.dealArrangementId;
	}

	public void setDealArrangementId(BigDecimal dealArrangementId) {
		this.dealArrangementId = dealArrangementId;
	}

	public String getAccountClass() {
		return accountClass;
	}

	public void setAccountClass(String accountClass) {
		this.accountClass = accountClass;
	}

	public String getFunctionalCurrency() {
		return functionalCurrency;
	}

	public void setFunctionalCurrency(String functionalCurrency) {
		this.functionalCurrency = functionalCurrency;
	}

	public BigDecimal getDealLineNumber() {
		return dealLineNumber;
	}

	public void setDealLineNumber(BigDecimal dealLineNumber) {
		this.dealLineNumber = dealLineNumber;
	}

	public String getEntryType() {
		return entryType;
	}

	public void setEntryType(String entryType) {
		this.entryType = entryType;
	}

	public String getSfRefLineId() {
		return sfRefLineId;
	}

	public void setSfRefLineId(String sfRefLineId) {
		this.sfRefLineId = sfRefLineId;
	}
	
	

}