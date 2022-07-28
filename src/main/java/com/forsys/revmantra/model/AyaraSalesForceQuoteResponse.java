package com.forsys.revmantra.model;

import java.util.List;

public class AyaraSalesForceQuoteResponse {
	private List<RmanSalesforceQuoteLine> sfQuoteLines;
	
	private List<SfQuoteLineExceptions> sfQuoteLineExceptions;

	public List<RmanSalesforceQuoteLine> getSfQuoteLines() {
		return sfQuoteLines;
	}

	public void setSfQuoteLines(List<RmanSalesforceQuoteLine> sfQuoteLines) {
		this.sfQuoteLines = sfQuoteLines;
	}

	public List<SfQuoteLineExceptions> getSfQuoteLineExceptions() {
		return sfQuoteLineExceptions;
	}

	public void setSfQuoteLineExceptions(List<SfQuoteLineExceptions> sfQuoteLineExceptions) {
		this.sfQuoteLineExceptions = sfQuoteLineExceptions;
	}
}
