package com.forsys.revmantra.pojo;

import java.math.BigDecimal;
import java.util.List;

import com.forsys.revmantra.model.RmanSalesforceQuoteLine;
import com.forsys.revmantra.model.SfqiExceptions;

public class ResponseData {
	private List<SfqiExceptions> exceptions;
	
	private List<RmanSalesforceQuoteLine> revenueAllocations;
	
	private String status;
	
	private String message;
	
	private BigDecimal batchId;
	
	private BigDecimal targetArrangementId;
	
	private String revenueGuidance;
	
	public List<RmanSalesforceQuoteLine> getRevenueAllocations() {
		return revenueAllocations;
	}
	public void setRevenueAllocations(List<RmanSalesforceQuoteLine> revenueAllocations) {
		this.revenueAllocations = revenueAllocations;
	}
	public List<SfqiExceptions> getExceptions() {
		return exceptions;
	}
	public void setExceptions(List<SfqiExceptions> exceptions) {
		this.exceptions = exceptions;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public BigDecimal getBatchId() {
		return batchId;
	}
	public void setBatchId(BigDecimal batchId) {
		this.batchId = batchId;
	}
	public BigDecimal getTargetArrangementId() {
		return targetArrangementId;
	}
	public void setTargetArrangementId(BigDecimal targetArrangementId) {
		this.targetArrangementId = targetArrangementId;
	}
	public String getRevenueGuidance() {
		return revenueGuidance;
	}
	public void setRevenueGuidance(String revenueGuidance) {
		this.revenueGuidance = revenueGuidance;
	}
	
	
	
}
