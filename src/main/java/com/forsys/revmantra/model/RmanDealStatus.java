package com.forsys.revmantra.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import com.forsys.revmantra.listener.RmanDealStatusListener;

@Entity
@EntityListeners(RmanDealStatusListener.class)
@Table(name = "RMAN_DEAL_STATUS")
public class RmanDealStatus {
	@Id
	@Column(name = "DEAL_HEADER_ID")
	private BigDecimal dealHeaderId;

	@Column(name = "DEAL_STATUS")
	private String dealStatus;

	@Column(name = "ANALYST_ID", nullable = true)
	private BigDecimal analystId;

	@Column(name = "ANALYST_COMMENTS")
	private String analystComments;

	@Column(name = "APPROVER_ID")
	private BigDecimal approverId;

	@Column(name = "APPROVER_COMMENTS")
	private String approverComments;

	@Column(name = "APPROVED_BY")
	private BigDecimal approvedBy;

	@Column(name = "APPROVAL_DATE")
	private Timestamp approvalDate;

	@Column(name = "SUBMITTED_BY")
	private BigDecimal submittedBy;

	@Column(name = "SUBMISSION_DATE")
	private Timestamp submissionDate;

	@Column(name = "CREATED_DATE")
	private Timestamp createdDate;

	@Column(name = "CREATED_BY")
	private BigDecimal createdBy;

	@Column(name = "LAST_UPDATED_DATE")
	private Timestamp lastUpdateDate;

	@Column(name = "LAST_UPDATED_BY")
	private BigDecimal lastUpdatedBy;

	@Column(name = "PROCESS_INSTANCE_ID")
	private BigDecimal process_instance_id;

	@Column(name = "DEAL_ARRANGEMENT_NUMBER")
	private String dealArrangementNumber;

	public BigDecimal getProcess_instance_id() {
		return process_instance_id;
	}

	public void setProcess_instance_id(BigDecimal process_instance_id) {
		this.process_instance_id = process_instance_id;
	}

	public BigDecimal getDealHeaderId() {
		return dealHeaderId;
	}

	public void setDealHeaderId(BigDecimal dealHeaderId) {
		this.dealHeaderId = dealHeaderId;
	}

	public String getDealStatus() {
		return dealStatus;
	}

	public void setDealStatus(String dealStatus) {
		this.dealStatus = dealStatus;
	}

	public BigDecimal getAnalystId() {
		return analystId;
	}

	public void setAnalystId(BigDecimal analystId) {
		this.analystId = analystId;
	}

	public String getAnalystComments() {
		return analystComments;
	}

	public void setAnalystComments(String analystComments) {
		this.analystComments = analystComments;
	}

	public BigDecimal getApproverId() {
		return approverId;
	}

	public void setApproverId(BigDecimal approverId) {
		this.approverId = approverId;
	}

	public String getApproverComments() {
		return approverComments;
	}

	public void setApproverComments(String approverComments) {
		this.approverComments = approverComments;
	}

	public BigDecimal getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(BigDecimal approvedBy) {
		this.approvedBy = approvedBy;
	}

	public Timestamp getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(Timestamp approvalDate) {
		this.approvalDate = approvalDate;
	}

	public BigDecimal getSubmittedBy() {
		return submittedBy;
	}

	public void setSubmittedBy(BigDecimal submittedBy) {
		this.submittedBy = submittedBy;
	}

	public Timestamp getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(Timestamp submissionDate) {
		this.submissionDate = submissionDate;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public BigDecimal getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(BigDecimal createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Timestamp lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public BigDecimal getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(BigDecimal lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public String getDealArrangementNumber() {
		return dealArrangementNumber;
	}

	public void setDealArrangementNumber(String dealArrangementNumber) {
		this.dealArrangementNumber = dealArrangementNumber;
	}

}
