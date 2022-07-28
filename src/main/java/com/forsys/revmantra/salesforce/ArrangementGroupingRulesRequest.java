package com.forsys.revmantra.salesforce;

public class ArrangementGroupingRulesRequest {
	private ArrangementGroupingRules wrap;

	public ArrangementGroupingRules getWrap() {
		return wrap;
	}

	public void setWrap(ArrangementGroupingRules wrap) {
		this.wrap = wrap;
	}

	@Override
	public String toString() {
		return "ArrangementGroupingRulesRequest [wrap=" + wrap + "]";
	}
	
}
