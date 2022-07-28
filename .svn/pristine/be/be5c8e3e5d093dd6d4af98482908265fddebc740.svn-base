package com.forsys.revmantra.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RMAN_CONT_RULES_LOV")
public class RmanContRulesLov {

	@Id
	@Column(name = "RULE_HEADER_ID")
	private BigDecimal ruleHeaderId;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "RULE_NAME")
	private String ruleName;

	public BigDecimal getRuleHeaderId() {
		return ruleHeaderId;
	}

	public void setRuleHeaderId(BigDecimal ruleHeaderId) {
		this.ruleHeaderId = ruleHeaderId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRuleName() {
		return ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

}
