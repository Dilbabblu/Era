package com.forsys.revmantra.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RMAN_RECON_SHIPPED_SO_TRG_REP")
public class RmanReconShippedSoTrgRep {

	@Column(name = "SRC_DELIVERED_QTY")
	private BigDecimal srcDeliveredQty;

	@Id
	@Column(name = "SNO")
	private BigDecimal sno;

	@Column(name = "ARRANGEMENT_NUMBER")
	private String arrangementNumber;

	@Column(name = "EXCEPTION")
	private String exception;

	@Column(name = "EVENT_RECEIVED")
	private String eventReceived;

	@Column(name = "REV_TRIGGER_FOR_SKU")
	private String revTriggerForSku;

	@Column(name = "ENTITY")
	private String entity;

	@Column(name = "DELIVERED_DATE")
	private Timestamp deliveredDate;

	@Column(name = "ARRG_LINE_NUM")
	private String arrgLineNum;

	@Column(name = "SO_LINE_NUM")
	private String soLineNum;

	@Column(name = "ARRANGEMENT_NAME")
	private String arrangementName;

	@Column(name = "SO")
	private BigDecimal so;

	@Column(name = "SKU")
	private String sku;

	@Column(name = "TRG_DELIVERED_QTY")
	private BigDecimal trgDeliveredQty;
	
	@Column(name="SOURCE_LINE_ID")
    private String sourceLineId;
    
    public String getSourceLineId() {
		return sourceLineId;
	}

	public void setSourceLineId(String sourceLineId) {
		this.sourceLineId = sourceLineId;
	}

	public BigDecimal getSrcDeliveredQty() {
		return this.srcDeliveredQty;
	}

	public void setSrcDeliveredQty(BigDecimal srcDeliveredQty) {
		this.srcDeliveredQty = srcDeliveredQty;
	}

	public String getArrangementNumber() {
		return this.arrangementNumber;
	}

	public void setArrangementNumber(String arrangementNumber) {
		this.arrangementNumber = arrangementNumber;
	}

	public String getException() {
		return this.exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public String getEventReceived() {
		return this.eventReceived;
	}

	public void setEventReceived(String eventReceived) {
		this.eventReceived = eventReceived;
	}

	public String getRevTriggerForSku() {
		return this.revTriggerForSku;
	}

	public void setRevTriggerForSku(String revTriggerForSku) {
		this.revTriggerForSku = revTriggerForSku;
	}

	public String getEntity() {
		return this.entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public Timestamp getDeliveredDate() {
		return this.deliveredDate;
	}

	public void setDeliveredDate(Timestamp deliveredDate) {
		this.deliveredDate = deliveredDate;
	}

	public String getArrgLineNum() {
		return this.arrgLineNum;
	}

	public void setArrgLineNum(String arrgLineNum) {
		this.arrgLineNum = arrgLineNum;
	}

	public String getSoLineNum() {
		return this.soLineNum;
	}

	public void setSoLineNum(String soLineNum) {
		this.soLineNum = soLineNum;
	}

	public String getArrangementName() {
		return this.arrangementName;
	}

	public void setArrangementName(String arrangementName) {
		this.arrangementName = arrangementName;
	}

	public BigDecimal getSo() {
		return this.so;
	}

	public void setSo(BigDecimal so) {
		this.so = so;
	}

	public String getSku() {
		return this.sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public BigDecimal getTrgDeliveredQty() {
		return this.trgDeliveredQty;
	}

	public void setTrgDeliveredQty(BigDecimal trgDeliveredQty) {
		this.trgDeliveredQty = trgDeliveredQty;
	}

	public BigDecimal getSno() {
		return sno;
	}

	public void setSno(BigDecimal sno) {
		this.sno = sno;
	}

}