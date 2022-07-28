package com.forsys.revmantra.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import com.forsys.revmantra.listener.AyaraRCTaskApprovalStatusListener;

@Entity
@EntityListeners(AyaraRCTaskApprovalStatusListener.class)
@Table(name = "AYARA_RC_TASK_APPROVAL_STATUS")
public class AyaraRCTaskApprovalStatus {
	
	@Id
	@Column(name="TASK_ID")
	private String taskId;
	
	@Column(name="RC_NUMBER")
	private BigDecimal rcNumber;
	
	@Column(name="TASK_ACTION")
	private String taskAction;
	
	@Column(name="APPROVE_PROCESS_ID")
	private String approveProcessId;
	
	@Column(name="ATTRIBUTE1")
	private String attribute1;
	
	@Column(name="ATTRIBUTE2")
	private String attribute2;
	
	@Column(name="ATTRIBUTE3")
	private String attribute3;
	
	@Column(name="ATTRIBUTE4")
	private String attribute4;
	
	@Column(name="ATTRIBUTE5")
	private String attribute5;
	
	@Column(name="CREATED_BY")
	private BigDecimal createdBy;
	
	@Column(name="CREATION_DATE")
	private Timestamp creationDate;
	
	@Column(name="LAST_UPDATED_BY")
	private BigDecimal lastUpdatedBy;
	
	@Column(name="LAST_UPDATE_DATE")
	private Timestamp lastUpdateDate;

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public BigDecimal getRcNumber() {
		return rcNumber;
	}

	public void setRcNumber(BigDecimal rcNumber) {
		this.rcNumber = rcNumber;
	}

	public String getApproveProcessId() {
		return approveProcessId;
	}

	public void setApproveProcessId(String approveProcessId) {
		this.approveProcessId = approveProcessId;
	}

	public String getAttribute1() {
		return attribute1;
	}

	public void setAttribute1(String attribute1) {
		this.attribute1 = attribute1;
	}

	public String getAttribute2() {
		return attribute2;
	}

	public void setAttribute2(String attribute2) {
		this.attribute2 = attribute2;
	}

	public String getAttribute3() {
		return attribute3;
	}

	public void setAttribute3(String attribute3) {
		this.attribute3 = attribute3;
	}

	public String getAttribute4() {
		return attribute4;
	}

	public void setAttribute4(String attribute4) {
		this.attribute4 = attribute4;
	}

	public String getAttribute5() {
		return attribute5;
	}

	public void setAttribute5(String attribute5) {
		this.attribute5 = attribute5;
	}

	public BigDecimal getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(BigDecimal createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public BigDecimal getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(BigDecimal lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Timestamp getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Timestamp lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getTaskAction() {
		return taskAction;
	}

	public void setTaskAction(String taskAction) {
		this.taskAction = taskAction;
	}

	@Override
	public String toString() {
		return "AyaraRCTaskApprovalStatus [taskId=" + taskId + ", rcNumber=" + rcNumber + ", taskAction=" + taskAction
				+ ", approveProcessId=" + approveProcessId + "]";
	}

		
}
