package com.forsys.revmantra.salesforce;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class ArrangementGroupingRules {

	private String ruleName;
	private String ruleCategory;
	private String description;
	private Timestamp ruleStartDate;
	private Timestamp ruleEndDate;
	private BigDecimal ruleHeaderId;
	private BigDecimal sequenceNumber;
	public String getRuleName() {
		return ruleName;
	}
	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}
	public String getRuleCategory() {
		return ruleCategory;
	}
	public void setRuleCategory(String ruleCategory) {
		this.ruleCategory = ruleCategory;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Timestamp getRuleStartDate() {
		return ruleStartDate;
	}
	public void setRuleStartDate(Timestamp ruleStartDate) {
		this.ruleStartDate = ruleStartDate;
	}
	public Timestamp getRuleEndDate() {
		return ruleEndDate;
	}
	public void setRuleEndDate(Timestamp ruleEndDate) {
		this.ruleEndDate = ruleEndDate;
	}
	public BigDecimal getRuleHeaderId() {
		return ruleHeaderId;
	}
	public void setRuleHeaderId(BigDecimal ruleHeaderId) {
		this.ruleHeaderId = ruleHeaderId;
	}
	public BigDecimal getSequenceNumber() {
		return sequenceNumber;
	}
	public void setSequenceNumber(BigDecimal sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}
	@Override
	public String toString() {
		return "ArrangementGroupingRules [ruleName=" + ruleName + ", ruleCategory=" + ruleCategory + ", description="
				+ description + ", ruleStartDate=" + ruleStartDate + ", ruleEndDate=" + ruleEndDate + ", ruleHeaderId="
				+ ruleHeaderId + ", sequenceNumber=" + sequenceNumber + "]";
	}
	
	
	
	

}
