package com.forsys.revmantra.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RMAN_RECON_DEALS_ARGG_REP")
public class RmanReconDealsArggRep {

	@Id
	@Column(name = "SNO")
	private String sno;

	@Column(name = "DEAL_NUMBER")
	private String dealNumber;

	@Column(name = "DEAL_LINE_NUMBER")
	private BigDecimal dealLineNumber;

	@Column(name = "SO")
	private String so;

	@Column(name = "SOURCE_LINE_NUMBER")
	private String sourceLineNumber;

	@Column(name = "ARRANGEMENT_NUMBER")
	private String arrangementNumber;

	@Column(name = "CREATION_DATE")
	private Timestamp creationDate;

	@Column(name = "Arrangement_Status")
	private String arrangementStatus;

	@Column(name = "TRG_QTY")
	private BigDecimal trgQty;

	@Column(name = "SRC_UNIT_PRICE")
	private BigDecimal srcUnitPrice;

	@Column(name = "TRG_UNIT_PRICE")
	private BigDecimal trgUnitPrice;

	@Column(name = "Exception")
	private String exception;

	@Column(name = "CUSTOMER_NAME")
	private String customerName;

	@Column(name = "SRC_QTY")
	private BigDecimal srcQty;

	@Column(name = "SRC_AMOUNT")
	private BigDecimal srcAmount;

	@Column(name = "Currency")
	private String currency;

	@Column(name = "Arrangement_Line_NUM")
	private String arrangementLineNum;

	@Column(name = "TRG_AMOUNT")
	private BigDecimal trgAmount;

	@Column(name = "SKU")
	private String sku;
	
	@Column(name="SOURCE_LINE_ID")
    private String sourceLineId;
    
    public String getSourceLineId() {
		return sourceLineId;
	}

	public void setSourceLineId(String sourceLineId) {
		this.sourceLineId = sourceLineId;
	}

	public BigDecimal getDealLineNumber() {
		return this.dealLineNumber;
	}

	public void setDealLineNumber(BigDecimal dealLineNumber) {
		this.dealLineNumber = dealLineNumber;
	}

	public String getSourceLineNumber() {
		return this.sourceLineNumber;
	}

	public void setSourceLineNumber(String sourceLineNumber) {
		this.sourceLineNumber = sourceLineNumber;
	}

	public String getArrangementNumber() {
		return this.arrangementNumber;
	}

	public void setArrangementNumber(String arrangementNumber) {
		this.arrangementNumber = arrangementNumber;
	}

	public Timestamp getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public String getArrangementStatus() {
		return this.arrangementStatus;
	}

	public void setArrangementStatus(String arrangementStatus) {
		this.arrangementStatus = arrangementStatus;
	}

	public BigDecimal getTrgQty() {
		return this.trgQty;
	}

	public void setTrgQty(BigDecimal trgQty) {
		this.trgQty = trgQty;
	}

	public BigDecimal getSrcUnitPrice() {
		return this.srcUnitPrice;
	}

	public void setSrcUnitPrice(BigDecimal srcUnitPrice) {
		this.srcUnitPrice = srcUnitPrice;
	}

	public BigDecimal getTrgUnitPrice() {
		return this.trgUnitPrice;
	}

	public void setTrgUnitPrice(BigDecimal trgUnitPrice) {
		this.trgUnitPrice = trgUnitPrice;
	}

	public String getException() {
		return this.exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public BigDecimal getSrcQty() {
		return this.srcQty;
	}

	public void setSrcQty(BigDecimal srcQty) {
		this.srcQty = srcQty;
	}

	public BigDecimal getSrcAmount() {
		return this.srcAmount;
	}

	public void setSrcAmount(BigDecimal srcAmount) {
		this.srcAmount = srcAmount;
	}

	public String getCurrency() {
		return this.currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getArrangementLineNum() {
		return this.arrangementLineNum;
	}

	public void setArrangementLineNum(String arrangementLineNum) {
		this.arrangementLineNum = arrangementLineNum;
	}

	public BigDecimal getTrgAmount() {
		return this.trgAmount;
	}

	public void setTrgAmount(BigDecimal trgAmount) {
		this.trgAmount = trgAmount;
	}

	public String getDealNumber() {
		return this.dealNumber;
	}

	public void setDealNumber(String dealNumber) {
		this.dealNumber = dealNumber;
	}

	public String getSo() {
		return this.so;
	}

	public void setSo(String so) {
		this.so = so;
	}

	public String getSku() {
		return this.sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

}