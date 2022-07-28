package com.forsys.revmantra.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import com.forsys.revmantra.listener.RmanContReleaseLinesListener;

@Entity
@EntityListeners(RmanContReleaseLinesListener.class)
@Table(name = "RMAN_CONT_RELEASE_LINES")
public class RmanContReleaseLines {

	@Column(name = "ATTRIBUTE30")
	private String attribute30;

	@Column(name = "INVOICE_HOLD")
	private String invoiceHold;

	@Column(name = "SOURCE_LINE_ID")
	private BigDecimal sourceLineId;

	@Column(name = "RULE_HEADER_ID")
	private BigDecimal ruleHeaderId;

	@Column(name = "RELEASE_COGS")
	private BigDecimal releaseCogs;

	@Column(name = "APPLY_TYPE")
	private String applyType;

	@Column(name = "SOURCE_HEADER_ID")
	private BigDecimal sourceHeaderId;

	@Column(name = "LAST_UPDATE_DATE")
	private Timestamp lastUpdateDate;

	@Column(name = "EVENT")
	private String event;

	@Column(name = "RANKING")
	private BigDecimal ranking;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "ATTRIBUTE29")
	private String attribute29;

	@Column(name = "ATTRIBUTE28")
	private String attribute28;

	@Column(name = "ATTRIBUTE27")
	private String attribute27;

	@Column(name = "AVG_CONT_ACCEPT_DUR")
	private BigDecimal avgContAcceptDur;

	@Column(name = "ATTRIBUTE26")
	private String attribute26;

	@Column(name = "ATTRIBUTE3")
	private String attribute3;

	@Column(name = "CREATED_BY")
	private BigDecimal createdBy;

	@Column(name = "TRANS_HEADER_ID")
	private BigDecimal transHeaderId;

	@Column(name = "MAX_DURATION")
	private BigDecimal maxDuration;

	@Column(name = "ATTRIBUTE2")
	private String attribute2;

	@Column(name = "LAST_UPDATED_BY")
	private BigDecimal lastUpdatedBy;

	@Column(name = "ATTRIBUTE1")
	private String attribute1;

	@Column(name = "APPLICATION_LEVEL")
	private String applicationLevel;

	@Column(name = "SO_HEADER_ID")
	private BigDecimal soHeaderId;

	@Column(name = "REVENUE")
	private BigDecimal revenue;

	@Column(name = "CREATION_DATE")
	private Timestamp creationDate;

	@Column(name = "ATTRIBUTE9")
	private String attribute9;

	@Column(name = "ATTRIBUTE8")
	private String attribute8;

	@Column(name = "ATTRIBUTE7")
	private String attribute7;

	@Column(name = "PRODUCT_NAME")
	private String productName;

	@Column(name = "ATTRIBUTE6")
	private String attribute6;

	@Column(name = "ATTRIBUTE5")
	private String attribute5;

	@Column(name = "RELEASE_TYPE")
	private String releaseType;

	@Column(name = "ATTRIBUTE4")
	private String attribute4;

	@Column(name = "COMPLETE_FLAG")
	private String completeFlag;

	@Column(name = "DEAL_NUM")
	private String dealNum;

	@Column(name = "SO_LINE_ID")
	private BigDecimal soLineId;

	@Column(name = "RELEASE_REVENUE")
	private BigDecimal releaseRevenue;

	@Column(name = "ATTRIBUTE10")
	private String attribute10;

	@Column(name = "ATTRIBUTE14")
	private String attribute14;

	@Column(name = "ATTRIBUTE13")
	private String attribute13;

	@Column(name = "ATTRIBUTE12")
	private String attribute12;

	@Column(name = "CONT_EVENT_TYPE")
	private String contEventType;

	@Column(name = "APPLICATION")
	private String application;

	@Column(name = "ATTRIBUTE11")
	private String attribute11;

	@Column(name = "COGS")
	private BigDecimal cogs;

	@Column(name = "COMMENTS")
	private String comments;

	@Column(name = "TEMPLATE_ID")
	private BigDecimal templateId;

	@Column(name = "DEFERRED_RELEASE")
	private BigDecimal deferredRelease;

	@Column(name = "RULE_CATEGORY")
	private String ruleCategory;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "DEFERRED_METHOD")
	private String deferredMethod;

	@Column(name = "ATTRIBUTE21")
	private String attribute21;

	@Column(name = "ATTRIBUTE20")
	private String attribute20;

	@Column(name = "TRANS_LINE_ID")
	private BigDecimal transLineId;

	@Column(name = "ATTRIBUTE25")
	private String attribute25;

	@Column(name = "ATTRIBUTE24")
	private String attribute24;

	@Column(name = "ATTRIBUTE23")
	private String attribute23;

	@Column(name = "ATTRIBUTE22")
	private String attribute22;

	@Column(name = "AUTO_RELEASE_DAYS")
	private BigDecimal autoReleaseDays;

	@Column(name = "PERCENTAGE")
	private BigDecimal percentage;

	@Column(name = "DEAL_ARRANGEMENT_ID")
	private BigDecimal dealArrangementId;

	@Column(name = "ELEMENT")
	private String element;

	@Column(name = "PO_HEADER_ID")
	private BigDecimal poHeaderId;

	@Column(name = "ATTRIBUTE18")
	private String attribute18;

	@Column(name = "ATTRIBUTE17")
	private String attribute17;

	@Column(name = "ATTRIBUTE16")
	private String attribute16;

	@Column(name = "ATTRIBUTE15")
	private String attribute15;

	@Column(name = "REBATE")
	private BigDecimal rebate;

	@Id
	@Column(name = "RELEASE_LINE_ID")
	private BigDecimal releaseLineId;

	@Column(name = "PO_LINE_ID")
	private BigDecimal poLineId;

	@Column(name = "ATTRIBUTE19")
	private String attribute19;

	@Column(name = "CUSTOMER_PAYMENT")
	private String customerPayment;
	
	@Column(name = "RELEASE_DATE")
	private Timestamp releaseDate;

	public String getCustomerPayment() {
		return customerPayment;
	}

	public void setCustomerPayment(String customerPayment) {
		this.customerPayment = customerPayment;
	}

	public String getAttribute30() {
		return this.attribute30;
	}

	public void setAttribute30(String attribute30) {
		this.attribute30 = attribute30;
	}

	public String getInvoiceHold() {
		return this.invoiceHold;
	}

	public void setInvoiceHold(String invoiceHold) {
		this.invoiceHold = invoiceHold;
	}

	public BigDecimal getSourceLineId() {
		return this.sourceLineId;
	}

	public void setSourceLineId(BigDecimal sourceLineId) {
		this.sourceLineId = sourceLineId;
	}

	public BigDecimal getRuleHeaderId() {
		return this.ruleHeaderId;
	}

	public void setRuleHeaderId(BigDecimal ruleHeaderId) {
		this.ruleHeaderId = ruleHeaderId;
	}

	public BigDecimal getReleaseCogs() {
		return this.releaseCogs;
	}

	public void setReleaseCogs(BigDecimal releaseCogs) {
		this.releaseCogs = releaseCogs;
	}

	public String getApplyType() {
		return this.applyType;
	}

	public void setApplyType(String applyType) {
		this.applyType = applyType;
	}

	public BigDecimal getSourceHeaderId() {
		return this.sourceHeaderId;
	}

	public void setSourceHeaderId(BigDecimal sourceHeaderId) {
		this.sourceHeaderId = sourceHeaderId;
	}

	public Timestamp getLastUpdateDate() {
		return this.lastUpdateDate;
	}

	public void setLastUpdateDate(Timestamp lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getEvent() {
		return this.event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public BigDecimal getRanking() {
		return this.ranking;
	}

	public void setRanking(BigDecimal ranking) {
		this.ranking = ranking;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public BigDecimal getAvgContAcceptDur() {
		return this.avgContAcceptDur;
	}

	public void setAvgContAcceptDur(BigDecimal avgContAcceptDur) {
		this.avgContAcceptDur = avgContAcceptDur;
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

	public BigDecimal getTransHeaderId() {
		return this.transHeaderId;
	}

	public void setTransHeaderId(BigDecimal transHeaderId) {
		this.transHeaderId = transHeaderId;
	}

	public BigDecimal getMaxDuration() {
		return this.maxDuration;
	}

	public void setMaxDuration(BigDecimal maxDuration) {
		this.maxDuration = maxDuration;
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

	public String getApplicationLevel() {
		return this.applicationLevel;
	}

	public void setApplicationLevel(String applicationLevel) {
		this.applicationLevel = applicationLevel;
	}

	public BigDecimal getSoHeaderId() {
		return this.soHeaderId;
	}

	public void setSoHeaderId(BigDecimal soHeaderId) {
		this.soHeaderId = soHeaderId;
	}

	public BigDecimal getRevenue() {
		return this.revenue;
	}

	public void setRevenue(BigDecimal revenue) {
		this.revenue = revenue;
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

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
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

	public String getReleaseType() {
		return this.releaseType;
	}

	public void setReleaseType(String releaseType) {
		this.releaseType = releaseType;
	}

	public String getAttribute4() {
		return this.attribute4;
	}

	public void setAttribute4(String attribute4) {
		this.attribute4 = attribute4;
	}

	public String getCompleteFlag() {
		return this.completeFlag;
	}

	public void setCompleteFlag(String completeFlag) {
		this.completeFlag = completeFlag;
	}

	public String getDealNum() {
		return this.dealNum;
	}

	public void setDealNum(String dealNum) {
		this.dealNum = dealNum;
	}

	public BigDecimal getSoLineId() {
		return this.soLineId;
	}

	public void setSoLineId(BigDecimal soLineId) {
		this.soLineId = soLineId;
	}

	public BigDecimal getReleaseRevenue() {
		return this.releaseRevenue;
	}

	public void setReleaseRevenue(BigDecimal releaseRevenue) {
		this.releaseRevenue = releaseRevenue;
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

	public String getContEventType() {
		return this.contEventType;
	}

	public void setContEventType(String contEventType) {
		this.contEventType = contEventType;
	}

	public String getApplication() {
		return this.application;
	}

	public void setApplication(String application) {
		this.application = application;
	}

	public String getAttribute11() {
		return this.attribute11;
	}

	public void setAttribute11(String attribute11) {
		this.attribute11 = attribute11;
	}

	public BigDecimal getCogs() {
		return this.cogs;
	}

	public void setCogs(BigDecimal cogs) {
		this.cogs = cogs;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public BigDecimal getTemplateId() {
		return this.templateId;
	}

	public void setTemplateId(BigDecimal templateId) {
		this.templateId = templateId;
	}

	public BigDecimal getDeferredRelease() {
		return this.deferredRelease;
	}

	public void setDeferredRelease(BigDecimal deferredRelease) {
		this.deferredRelease = deferredRelease;
	}

	public String getRuleCategory() {
		return this.ruleCategory;
	}

	public void setRuleCategory(String ruleCategory) {
		this.ruleCategory = ruleCategory;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDeferredMethod() {
		return this.deferredMethod;
	}

	public void setDeferredMethod(String deferredMethod) {
		this.deferredMethod = deferredMethod;
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

	public BigDecimal getTransLineId() {
		return this.transLineId;
	}

	public void setTransLineId(BigDecimal transLineId) {
		this.transLineId = transLineId;
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

	public BigDecimal getAutoReleaseDays() {
		return this.autoReleaseDays;
	}

	public void setAutoReleaseDays(BigDecimal autoReleaseDays) {
		this.autoReleaseDays = autoReleaseDays;
	}

	public BigDecimal getPercentage() {
		return this.percentage;
	}

	public void setPercentage(BigDecimal percentage) {
		this.percentage = percentage;
	}

	public BigDecimal getDealArrangementId() {
		return this.dealArrangementId;
	}

	public void setDealArrangementId(BigDecimal dealArrangementId) {
		this.dealArrangementId = dealArrangementId;
	}

	public String getElement() {
		return this.element;
	}

	public void setElement(String element) {
		this.element = element;
	}

	public BigDecimal getPoHeaderId() {
		return this.poHeaderId;
	}

	public void setPoHeaderId(BigDecimal poHeaderId) {
		this.poHeaderId = poHeaderId;
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

	public BigDecimal getRebate() {
		return this.rebate;
	}

	public void setRebate(BigDecimal rebate) {
		this.rebate = rebate;
	}

	public BigDecimal getReleaseLineId() {
		return this.releaseLineId;
	}

	public void setReleaseLineId(BigDecimal releaseLineId) {
		this.releaseLineId = releaseLineId;
	}

	public BigDecimal getPoLineId() {
		return this.poLineId;
	}

	public void setPoLineId(BigDecimal poLineId) {
		this.poLineId = poLineId;
	}

	public String getAttribute19() {
		return this.attribute19;
	}

	public void setAttribute19(String attribute19) {
		this.attribute19 = attribute19;
	}

	public Timestamp getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Timestamp releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	

}