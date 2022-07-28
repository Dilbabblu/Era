package com.forsys.revmantra.model;

import java.math.BigDecimal;
import java.util.List;

public class TargetContTemplates {
	private BigDecimal contRuleHeaderId;
	private List<BigDecimal> rmanContTemplateList;
	
	public BigDecimal getContRuleHeaderId() {
		return contRuleHeaderId;
	}
	public void setContRuleHeaderId(BigDecimal contRuleHeaderId) {
		this.contRuleHeaderId = contRuleHeaderId;
	}
	public List<BigDecimal> getRmanContTemplateList() {
		return rmanContTemplateList;
	}
	public void setRmanContTemplateList(List<BigDecimal> rmanContTemplateList) {
		this.rmanContTemplateList = rmanContTemplateList;
	}
	@Override
	public String toString() {
		return "TargetContTemplates [contRuleHeaderId=" + contRuleHeaderId + ", rmanContTemplateList="
				+ rmanContTemplateList + "]";
	}
	
	
	
}
