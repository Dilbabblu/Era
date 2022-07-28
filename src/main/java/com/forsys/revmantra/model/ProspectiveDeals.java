package com.forsys.revmantra.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ProspectiveDeals {
	/*
	 * Bug No: AYAR-403
	 * Added the @JsonFormat(pattern="yyyy-MM-dd") for the ContractStartDate,
	 * ContractEndDate,ServiceStartDate and ServiceEndDate	 
	 * attributes to format the date to ISO standard instead of Timestamp 
	 * @author chandra kota on 2021-JUN-01
	 */
	private BigDecimal dealArrangementId;
	private BigDecimal quantity;
	private BigDecimal unitListPrice;
	private BigDecimal unitSellingPrice;
	private String dealNumber;
	private BigDecimal dealLineNumber;
	private String productName;
	private String uomCode;
	private String dealCurrencyCode;
	private BigDecimal conversionRate;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Timestamp contractStartDate;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Timestamp contractEndDate;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Timestamp serviceStartDate;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Timestamp serviceEndDate;
	
	private BigDecimal dealLineId;
	private BigDecimal undeliveredQty;
	private BigDecimal undQty;
	private String arrgType;
	private String bundleFlag;

	public BigDecimal getDealArrangementId() {
		return dealArrangementId;
	}

	public void setDealArrangementId(BigDecimal dealArrangementId) {
		this.dealArrangementId = dealArrangementId;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getUnitListPrice() {
		return unitListPrice;
	}

	public void setUnitListPrice(BigDecimal unitListPrice) {
		this.unitListPrice = unitListPrice;
	}

	public BigDecimal getUnitSellingPrice() {
		return unitSellingPrice;
	}

	public void setUnitSellingPrice(BigDecimal unitSellingPrice) {
		this.unitSellingPrice = unitSellingPrice;
	}

	public String getDealNumber() {
		return dealNumber;
	}

	public void setDealNumber(String dealNumber) {
		this.dealNumber = dealNumber;
	}

	public BigDecimal getDealLineNumber() {
		return dealLineNumber;
	}

	public void setDealLineNumber(BigDecimal dealLineNumber) {
		this.dealLineNumber = dealLineNumber;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getUomCode() {
		return uomCode;
	}

	public void setUomCode(String uomCode) {
		this.uomCode = uomCode;
	}

	public String getDealCurrencyCode() {
		return dealCurrencyCode;
	}

	public void setDealCurrencyCode(String dealCurrencyCode) {
		this.dealCurrencyCode = dealCurrencyCode;
	}

	public BigDecimal getConversionRate() {
		return conversionRate;
	}

	public void setConversionRate(BigDecimal conversionRate) {
		this.conversionRate = conversionRate;
	}

	public Timestamp getContractStartDate() {
		return contractStartDate;
	}

	public void setContractStartDate(Timestamp contractStartDate) {
		this.contractStartDate = contractStartDate;
	}

	public Timestamp getContractEndDate() {
		return contractEndDate;
	}

	public void setContractEndDate(Timestamp contractEndDate) {
		this.contractEndDate = contractEndDate;
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

	public BigDecimal getDealLineId() {
		return dealLineId;
	}

	public void setDealLineId(BigDecimal dealLineId) {
		this.dealLineId = dealLineId;
	}

	public BigDecimal getUndeliveredQty() {
		return undeliveredQty;
	}

	public void setUndeliveredQty(BigDecimal undeliveredQty) {
		this.undeliveredQty = undeliveredQty;
	}

	public BigDecimal getUndQty() {
		return undQty;
	}

	public void setUndQty(BigDecimal undQty) {
		this.undQty = undQty;
	}

	public String getArrgType() {
		return arrgType;
	}

	public void setArrgType(String arrgType) {
		this.arrgType = arrgType;
	}

	public String getBundleFlag() {
		return bundleFlag;
	}

	public void setBundleFlag(String bundleFlag) {
		this.bundleFlag = bundleFlag;
	}

	public Object[] toSQLStructObject() {

		return new Object[] { this.dealArrangementId, this.quantity, this.unitListPrice, this.unitSellingPrice,
				this.dealNumber, this.dealLineNumber, this.productName, this.uomCode, this.dealCurrencyCode,
				this.conversionRate, this.contractStartDate, this.contractEndDate, this.serviceStartDate,
				this.serviceEndDate, this.dealLineId, this.undeliveredQty, this.undQty, this.arrgType,
				this.bundleFlag };
	}

}
