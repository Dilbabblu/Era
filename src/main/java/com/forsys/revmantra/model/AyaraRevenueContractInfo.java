package com.forsys.revmantra.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AyaraRevenueContractInfo {
	
	private String arrangementId ;
	private String comments;
	private String taskName ;
	private String decision ;
	private String arrangementTotal;
	
	public String getArrangementId() {
		return arrangementId;
	}
	public void setArrangementId(String arrangementId) {
		this.arrangementId = arrangementId;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getDecision() {
		return decision;
	}
	public void setDecision(String decision) {
		this.decision = decision;
	}
	public String getArrangementTotal() {
		return arrangementTotal;
	}
	public void setArrangementTotal(String arrangementTotal) {
		this.arrangementTotal = arrangementTotal;
	}
}
