package com.forsys.revmantra.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import com.forsys.revmantra.listener.RmanEventsListener;

@Entity
@EntityListeners(RmanEventsListener.class)
@Table(name = "RMAN_EVENTS")
public class RmanEvents {

	@Column(name = "CREATED_BY")
	private BigDecimal createdBy;

	@Column(name = "LAST_UPDATED_BY")
	private BigDecimal lastUpdatedBy;

	@Column(name = "EVENT_DATE")
	private Timestamp eventDate;

	@Column(name = "TRANSACTION_SOURCE")
	private String transactionSource;

	@Column(name = "ERROR_MESSAGE")
	private String errorMessage;

	@Column(name = "COGS_AMOUNT")
	private BigDecimal cogsAmount;
	@Id
	@Column(name = "ORDER_LINE_ID")
	private BigInteger orderLineId;

	@Column(name = "EVENT_NAME")
	private String eventName;

	@Column(name = "ORDER_LINE_NO")
	private String orderLineNo;

	@Column(name = "CREATION_DATE")
	private Timestamp creationDate;

	@Column(name = "LAST_UPDATE_LOGIN")
	private BigDecimal lastUpdateLogin;

	@Column(name = "LAST_UPDATE_DATE")
	private Timestamp lastUpdateDate;

	@Column(name = "TRANSACTION_TYPE")
	private String transactionType;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "ORDER_NUMBER")
	private BigDecimal orderNumber;

	@Column(name = "SERVICE_START_DATE")
	private Timestamp serviceStartDate;

	@Column(name = "SERVICE_END_DATE")
	private Timestamp serviceEndDate;

	@Column(name = "PRODUCT_NAME")
	private String productName;
	
	@Column(name = "ATTRIBUTE1")
	private String attribute1;

	public BigDecimal getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(BigDecimal createdBy) {
		this.createdBy = createdBy;
	}

	public BigDecimal getLastUpdatedBy() {
		return this.lastUpdatedBy;
	}

	public void setLastUpdatedBy(BigDecimal lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Timestamp getEventDate() {
		return this.eventDate;
	}

	public void setEventDate(Timestamp eventDate) {
		this.eventDate = eventDate;
	}

	public String getTransactionSource() {
		return this.transactionSource;
	}

	public void setTransactionSource(String transactionSource) {
		this.transactionSource = transactionSource;
	}

	public String getErrorMessage() {
		return this.errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getOrderLineId() {
		return this.orderLineId.toString();

	}

	public void setOrderLineId(BigInteger orderLineId) {
		this.orderLineId = orderLineId;
	}

	public String getEventName() {
		return this.eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getOrderLineNo() {
		return this.orderLineNo;
	}

	public void setOrderLineNo(String orderLineNo) {
		this.orderLineNo = orderLineNo;
	}

	public Timestamp getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public BigDecimal getLastUpdateLogin() {
		return this.lastUpdateLogin;
	}

	public void setLastUpdateLogin(BigDecimal lastUpdateLogin) {
		this.lastUpdateLogin = lastUpdateLogin;
	}

	public Timestamp getLastUpdateDate() {
		return this.lastUpdateDate;
	}

	public void setLastUpdateDate(Timestamp lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getTransactionType() {
		return this.transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getOrderNumber() {
		return this.orderNumber;
	}

	public void setOrderNumber(BigDecimal orderNumber) {
		this.orderNumber = orderNumber;
	}

	public BigDecimal getCogsAmount() {
		return this.cogsAmount;
	}

	public void setCogsAmount(BigDecimal cogsAmount) {
		this.cogsAmount = cogsAmount;
	}

	public Timestamp getServiceStartDate() {
		return serviceStartDate;
	}

	public void setServiceStartDate(Timestamp serviceStartDate) {
		this.serviceStartDate = serviceStartDate;
	}

	public Timestamp getServiceEndDate() {
		return serviceEndDate;
	}

	public void setServiceEndDate(Timestamp serviceEndDate) {
		this.serviceEndDate = serviceEndDate;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getAttribute1() {
		return attribute1;
	}

	public void setAttribute1(String attribute1) {
		this.attribute1 = attribute1;
	}
	
	

}