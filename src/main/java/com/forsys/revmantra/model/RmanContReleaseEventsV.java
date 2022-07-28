package com.forsys.revmantra.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RMAN_CONT_RELEASE_EVENTS_V")
public class RmanContReleaseEventsV {

	@Column(name = "DEAL_ARRANGEMENT_NUMBER")
	private String dealArrangementNumber;

	@Column(name = "LINE_NUM")
	private String lineNum;

	@Column(name = "DEAL_LINE_NUMBER")
	private BigDecimal dealLineNumber;

	@Column(name = "SOURCE_LINE_ID")
	private BigDecimal sourceLineId;

	@Column(name = "SOURCE_LINE_NUMBER")
	private String sourceLineNumber;

	@Column(name = "REVENUE")
	private BigDecimal revenue;

	@Column(name = "APPLY_TYPE")
	private String applyType;

	@Column(name = "DEAL_ARRANGEMENT_NAME")
	private String dealArrangementName;

	@Column(name = "CONTINGENCY_NAME")
	private String contingencyName;

	@Column(name = "DEAL_ARRANGEMENT_ID")
	private BigDecimal dealArrangementId;

	@Column(name = "RANKING")
	private BigDecimal ranking;

	@Column(name = "TEMPLATE_NAME")
	private String templateName;

	@Column(name = "DEFERRED_AMOUNT")
	private BigDecimal deferredAmount;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SNO")
	private BigDecimal sno;

	@Column(name = "DEAL_NUMBER")
	private String dealNumber;

	@Column(name = "SO")
	private BigDecimal so;

	@Column(name = "DEFERRED_RELEASE_AMOUNT")
	private BigDecimal deferredReleaseAmount;

	@Column(name = "UNDEFERRED_AMOUNT")
	private String undeferredAmount;

	@Column(name = "DELIVERED_AMOUNT")
	private BigDecimal deliveredAmount;

	@Column(name = "BOOKED_AMOUNT")
	private BigDecimal bookedAmount;

	@Column(name = "DEAL_LINE_ID")
	private BigDecimal dealLineId;

	@Column(name = "RULE_CATEGORY")
	private String ruleCategory;

	@Column(name = "TRX_CURRENCY")
	private String trxCurrency;

	/**
	 * @Column(name="CURRENT_DATE") private Timestamp currentDate;
	 */

	public String getDealArrangementNumber() {
		return this.dealArrangementNumber;
	}

	public void setDealArrangementNumber(String dealArrangementNumber) {
		this.dealArrangementNumber = dealArrangementNumber;
	}

	public String getLineNum() {
		return this.lineNum;
	}

	public void setLineNum(String lineNum) {
		this.lineNum = lineNum;
	}

	public BigDecimal getDealLineNumber() {
		return this.dealLineNumber;
	}

	public void setDealLineNumber(BigDecimal dealLineNumber) {
		this.dealLineNumber = dealLineNumber;
	}

	public BigDecimal getSourceLineId() {
		return this.sourceLineId;
	}

	public void setSourceLineId(BigDecimal sourceLineId) {
		this.sourceLineId = sourceLineId;
	}

	public String getSourceLineNumber() {
		return this.sourceLineNumber;
	}

	public void setSourceLineNumber(String sourceLineNumber) {
		this.sourceLineNumber = sourceLineNumber;
	}

	public BigDecimal getRevenue() {
		return this.revenue;
	}

	public void setRevenue(BigDecimal revenue) {
		this.revenue = revenue;
	}

	public String getApplyType() {
		return this.applyType;
	}

	public void setApplyType(String applyType) {
		this.applyType = applyType;
	}

	public String getDealArrangementName() {
		return this.dealArrangementName;
	}

	public void setDealArrangementName(String dealArrangementName) {
		this.dealArrangementName = dealArrangementName;
	}

	public String getContingencyName() {
		return this.contingencyName;
	}

	public void setContingencyName(String contingencyName) {
		this.contingencyName = contingencyName;
	}

	public BigDecimal getDealArrangementId() {
		return this.dealArrangementId;
	}

	public void setDealArrangementId(BigDecimal dealArrangementId) {
		this.dealArrangementId = dealArrangementId;
	}

	public BigDecimal getRanking() {
		return this.ranking;
	}

	public void setRanking(BigDecimal ranking) {
		this.ranking = ranking;
	}

	public String getTemplateName() {
		return this.templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public BigDecimal getDeferredAmount() {
		return this.deferredAmount;
	}

	public void setDeferredAmount(BigDecimal deferredAmount) {
		this.deferredAmount = deferredAmount;
	}

	public BigDecimal getSno() {
		return this.sno;
	}

	public void setSno(BigDecimal sno) {
		this.sno = sno;
	}

	public String getDealNumber() {
		return this.dealNumber;
	}

	public void setDealNumber(String dealNumber) {
		this.dealNumber = dealNumber;
	}

	public BigDecimal getSo() {
		return this.so;
	}

	public void setSo(BigDecimal so) {
		this.so = so;
	}

	public BigDecimal getDeferredReleaseAmount() {
		return this.deferredReleaseAmount;
	}

	public void setDeferredReleaseAmount(BigDecimal deferredReleaseAmount) {
		this.deferredReleaseAmount = deferredReleaseAmount;
	}

	public String getUndeferredAmount() {
		return this.undeferredAmount;
	}

	public void setUndeferredAmount(String undeferredAmount) {
		this.undeferredAmount = undeferredAmount;
	}

	public BigDecimal getDeliveredAmount() {
		return this.deliveredAmount;
	}

	public void setDeliveredAmount(BigDecimal deliveredAmount) {
		this.deliveredAmount = deliveredAmount;
	}

	public BigDecimal getBookedAmount() {
		return this.bookedAmount;
	}

	public void setBookedAmount(BigDecimal bookedAmount) {
		this.bookedAmount = bookedAmount;
	}

	public BigDecimal getDealLineId() {
		return this.dealLineId;
	}

	public void setDealLineId(BigDecimal dealLineId) {
		this.dealLineId = dealLineId;
	}

	public String getRuleCategory() {
		return this.ruleCategory;
	}

	public void setRuleCategory(String ruleCategory) {
		this.ruleCategory = ruleCategory;
	}

	public String getTrxCurrency() {
		return trxCurrency;
	}

	public void setTrxCurrency(String trxCurrency) {
		this.trxCurrency = trxCurrency;
	}

	/**
	 * public Timestamp getCurrentDate() { return this.currentDate; }
	 * 
	 * public void setCurrentDate(Timestamp currentDate) {
	 * this.currentDate=currentDate; }
	 */

}