package com.forsys.revmantra.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ARRG_CONTRACT_ALLOCATIONS_V")
public class ArrgContractAllocationsV {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DEAL_LINE_ID")
	private BigDecimal dealLineId;

	@Column(name = "ARRG_LINE_NUMBER")
	private String arrgLineNumber;

	@Column(name = "DEAL_NUMBER")
	private String dealNumber;

	@Column(name = "QUANTITY")
	private BigDecimal quantity;

	@Column(name = "BUNDLE_ATTRIBITION_LIST")
	private BigDecimal bundleAttributionList;

	@Column(name = "ELEMENT_TYPE")
	private String elementType;

	@Column(name = "ALLOCATION_AMOUNT")
	private BigDecimal allocationAmount;

	@Column(name = "PARENT_LINE_NUMBER")
	private BigDecimal parentLineNumber;

	@Column(name = "TOTAL_COST")
	private String totalCost;

	@Column(name = "DEAL_CURRENCY_CODE")
	private String dealCurrencyCode;

	@Column(name = "UNIT_SELLING_PRICE")
	private BigDecimal unitSellingPrice;

	@Column(name = "UNIT_LIST_PRICE")
	private BigDecimal unitListPrice;

	@Column(name = "FMV_CATEGORY")
	private String fmvCategory;

	@Column(name = "CV_IN_OUT_AMOUNT")
	private BigDecimal cvInOutAmount;

	@Column(name = "LINE_AMOUNT")
	private BigDecimal lineAmount;

	@Column(name = "REP_CURR_CODE")
	private String repCurrCode;

	@Column(name = "FMV_RULE_NAME")
	private String fmvRuleName;

	@Column(name = "POB_GROUPING")
	private String pobGrouping;

	@Column(name = "DEAL_LINE_NUMBER")
	private BigDecimal dealLineNumber;

	@Column(name = "PRODUCT_GROUP")
	private String productGroup;

	@Column(name = "FMV_MIN")
	private BigDecimal fmvMin;

	@Column(name = "FMV_MEAN")
	private BigDecimal fmvMean;

	@Column(name = "FMV_AMOUNT")
	private BigDecimal fmvAmount;

	@Column(name = "DEAL_HEADER_ID")
	private BigDecimal dealHeaderId;

	@Column(name = "BUNDLE_ATTRIBITION_NET")
	private BigDecimal bundleAttributionNet;

	@Column(name = "SOLUTION")
	private String solution;

	@Column(name = "PARENT_LINE_ID")
	private BigDecimal parentLineId;

	@Column(name = "PRODUCT_NAME")
	private String productName;

	@Column(name = "DEAL_ARRANGEMENT_ID")
	private BigDecimal dealArrangementId;

	@Column(name = "TRX_CURRENCY_CODE")
	private String trxCurrencyCode;

	@Column(name = "ACCOUNTING_SCOPE")
	private String accountingScope;

	@Column(name = "PRODUCT_TYPE")
	private String productType;

	@Column(name = "FMV_MAX")
	private BigDecimal fmvMax;

	@Column(name = "ACCOUNTING_STANDARD")
	private String accountingStandard;

	@Column(name = "UOM_CODE")
	private String uomCode;

	@Column(name = "ALLOCATION_INCLUSIVE")
	private String allocationInclusive;

	@Column(name = "BUNDLE_FLAG")
	private String bundleFlag;

	@Column(name = "FMV_TYPE")
	private String fmvType;

	@Column(name = "VC")
	private BigDecimal vc;

	@Column(name = "ALLOCABLE_AMOUNT")
	private BigDecimal allocableAmount;
	
	@Column(name = "SSP_LOW")
	private BigDecimal sspLow;
	
	@Column(name = "SSP_HIGH")
	private BigDecimal sspHigh;
	
	@Column(name = "SSP")
	private BigDecimal ssp;
	
	@Column(name = "NET_PRICE_DISCOUNT")
	private BigDecimal netPriceDiscount;
	
	@Column(name = "ALLOCATION_FLAG")
	private String allocationFlag;
	
	@Column(name = "FX_RATE")
	private BigDecimal fxRate;
	
	@Column(name = "FX_CURRENCY")
	private String fxCurrency;
	
	@Column(name = "FX_DATE")
	private Timestamp fxDate;
	
	@Column(name = "ALLOCATION_AMOUNT_FC")
	private BigDecimal allocationAmountFc;
	
	@Column(name = "ORDER_NUMBER")
	private String orderNumber;
	
	@Column(name = "SOURCE_LINE_NUMBER")
	private BigDecimal sourceLineNumber;
	
	@Column(name = "CUSTOMER_PO_NUM")
	private String customerPoNum;
	
	@Column(name = "DISCOUNT_TYPE")
	private String discountType;
	
	@Column(name = "ADDITIONAL_DISCOUNT")
	private String additionalDiscount;
	
	@Column(name = "PRODUCT_DESCRIPTION")
	private String productDescription;
	
	@Column(name = "EXTENDED_LIST_AMOUNT")
	private BigDecimal extendedListAmount;
	
	@Column(name="BEDP")
	private BigDecimal bedp;
	
	@Column(name="ESP")
	private BigDecimal esp;
	
	@Column(name="ESPINST")
	private BigDecimal espinst;
	
	@Column(name="REVENUE_GUIDANCE")
	private String revenueGuidance;
	
	@Column(name="COMMENTS")
	private String comments;
	
	@Column(name="ALLOCATION_MARGIN_PERCENTAGE")
	private BigDecimal allocationMarginPercentage;
	
	@Column(name="GROSS_MARGIN_PERCENTAGE")
	private BigDecimal grossMarginPercentage;
	
	public String getRevenueGuidance() {
		return revenueGuidance;
	}

	public void setRevenueGuidance(String revenueGuidance) {
		this.revenueGuidance = revenueGuidance;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getArrgLineNumber() {
		return arrgLineNumber;
	}

	public void setArrgLineNumber(String arrgLineNumber) {
		this.arrgLineNumber = arrgLineNumber;
	}

	public String getDealNumber() {
		return dealNumber;
	}

	public void setDealNumber(String dealNumber) {
		this.dealNumber = dealNumber;
	}

	public BigDecimal getVc() {
		return vc;
	}

	public void setVc(BigDecimal vc) {
		this.vc = vc;
	}

	public BigDecimal getDealLineId() {
		return this.dealLineId;
	}

	public void setDealLineId(BigDecimal dealLineId) {
		this.dealLineId = dealLineId;
	}

	public BigDecimal getQuantity() {
		return this.quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getBundleAttributionList() {
		return this.bundleAttributionList;
	}

	public void setBundleAttributionList(BigDecimal bundleAttributionList) {
		this.bundleAttributionList = bundleAttributionList;
	}

	public String getElementType() {
		return this.elementType;
	}

	public void setElementType(String elementType) {
		this.elementType = elementType;
	}

	public BigDecimal getAllocationAmount() {
		return this.allocationAmount;
	}

	public void setAllocationAmount(BigDecimal allocationAmount) {
		this.allocationAmount = allocationAmount;
	}

	public BigDecimal getParentLineNumber() {
		return this.parentLineNumber;
	}

	public void setParentLineNumber(BigDecimal parentLineNumber) {
		this.parentLineNumber = parentLineNumber;
	}

	public String getTotalCost() {
		return this.totalCost;
	}

	public void setTotalCost(String totalCost) {
		this.totalCost = totalCost;
	}

	public String getDealCurrencyCode() {
		return this.dealCurrencyCode;
	}

	public void setDealCurrencyCode(String dealCurrencyCode) {
		this.dealCurrencyCode = dealCurrencyCode;
	}

	public BigDecimal getUnitSellingPrice() {
		return this.unitSellingPrice;
	}

	public void setUnitSellingPrice(BigDecimal unitSellingPrice) {
		this.unitSellingPrice = unitSellingPrice;
	}

	public BigDecimal getUnitListPrice() {
		return this.unitListPrice;
	}

	public void setUnitListPrice(BigDecimal unitListPrice) {
		this.unitListPrice = unitListPrice;
	}

	public String getFmvCategory() {
		return this.fmvCategory;
	}

	public void setFmvCategory(String fmvCategory) {
		this.fmvCategory = fmvCategory;
	}

	public BigDecimal getCvInOutAmount() {
		return this.cvInOutAmount;
	}

	public void setCvInOutAmount(BigDecimal cvInOutAmount) {
		this.cvInOutAmount = cvInOutAmount;
	}

	public BigDecimal getLineAmount() {
		return this.lineAmount;
	}

	public void setLineAmount(BigDecimal lineAmount) {
		this.lineAmount = lineAmount;
	}

	public String getRepCurrCode() {
		return this.repCurrCode;
	}

	public void setRepCurrCode(String repCurrCode) {
		this.repCurrCode = repCurrCode;
	}

	public String getFmvRuleName() {
		return this.fmvRuleName;
	}

	public void setFmvRuleName(String fmvRuleName) {
		this.fmvRuleName = fmvRuleName;
	}

	public String getPobGrouping() {
		return this.pobGrouping;
	}

	public void setPobGrouping(String pobGrouping) {
		this.pobGrouping = pobGrouping;
	}

	public BigDecimal getDealLineNumber() {
		return this.dealLineNumber;
	}

	public void setDealLineNumber(BigDecimal dealLineNumber) {
		this.dealLineNumber = dealLineNumber;
	}

	public String getProductGroup() {
		return this.productGroup;
	}

	public void setProductGroup(String productGroup) {
		this.productGroup = productGroup;
	}

	public BigDecimal getFmvMin() {
		return this.fmvMin;
	}

	public void setFmvMin(BigDecimal fmvMin) {
		this.fmvMin = fmvMin;
	}

	public BigDecimal getFmvMean() {
		return this.fmvMean;
	}

	public void setFmvMean(BigDecimal fmvMean) {
		this.fmvMean = fmvMean;
	}

	public BigDecimal getFmvAmount() {
		return this.fmvAmount;
	}

	public void setFmvAmount(BigDecimal fmvAmount) {
		this.fmvAmount = fmvAmount;
	}

	public BigDecimal getDealHeaderId() {
		return this.dealHeaderId;
	}

	public void setDealHeaderId(BigDecimal dealHeaderId) {
		this.dealHeaderId = dealHeaderId;
	}

	public BigDecimal getBundleAttributionNet() {
		return this.bundleAttributionNet;
	}

	public void setBundleAttributionNet(BigDecimal bundleAttributionNet) {
		this.bundleAttributionNet = bundleAttributionNet;
	}

	public String getSolution() {
		return this.solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

	public BigDecimal getParentLineId() {
		return this.parentLineId;
	}

	public void setParentLineId(BigDecimal parentLineId) {
		this.parentLineId = parentLineId;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getDealArrangementId() {
		return this.dealArrangementId;
	}

	public void setDealArrangementId(BigDecimal dealArrangementId) {
		this.dealArrangementId = dealArrangementId;
	}

	public String getTrxCurrencyCode() {
		return this.trxCurrencyCode;
	}

	public void setTrxCurrencyCode(String trxCurrencyCode) {
		this.trxCurrencyCode = trxCurrencyCode;
	}

	public String getAccountingScope() {
		return this.accountingScope;
	}

	public void setAccountingScope(String accountingScope) {
		this.accountingScope = accountingScope;
	}

	public String getProductType() {
		return this.productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public BigDecimal getFmvMax() {
		return this.fmvMax;
	}

	public void setFmvMax(BigDecimal fmvMax) {
		this.fmvMax = fmvMax;
	}

	public String getAccountingStandard() {
		return this.accountingStandard;
	}

	public void setAccountingStandard(String accountingStandard) {
		this.accountingStandard = accountingStandard;
	}

	public String getUomCode() {
		return this.uomCode;
	}

	public void setUomCode(String uomCode) {
		this.uomCode = uomCode;
	}

	public String getAllocationInclusive() {
		return this.allocationInclusive;
	}

	public void setAllocationInclusive(String allocationInclusive) {
		this.allocationInclusive = allocationInclusive;
	}

	public String getBundleFlag() {
		return this.bundleFlag;
	}

	public void setBundleFlag(String bundleFlag) {
		this.bundleFlag = bundleFlag;
	}

	public String getFmvType() {
		return this.fmvType;
	}

	public void setFmvType(String fmvType) {
		this.fmvType = fmvType;
	}

	public BigDecimal getAllocableAmount() {
		return allocableAmount;
	}

	public void setAllocableAmount(BigDecimal allocableAmount) {
		this.allocableAmount = allocableAmount;
	}

	public BigDecimal getSspLow() {
		return sspLow;
	}

	public void setSspLow(BigDecimal sspLow) {
		this.sspLow = sspLow;
	}

	public BigDecimal getSspHigh() {
		return sspHigh;
	}

	public void setSspHigh(BigDecimal sspHigh) {
		this.sspHigh = sspHigh;
	}

	public BigDecimal getNetPriceDiscount() {
		return netPriceDiscount;
	}

	public void setNetPriceDiscount(BigDecimal netPriceDiscount) {
		this.netPriceDiscount = netPriceDiscount;
	}

	public String getAllocationFlag() {
		return allocationFlag;
	}

	public void setAllocationFlag(String allocationFlag) {
		this.allocationFlag = allocationFlag;
	}

	public BigDecimal getFxRate() {
		return fxRate;
	}

	public void setFxRate(BigDecimal fxRate) {
		this.fxRate = fxRate;
	}

	public String getFxCurrency() {
		return fxCurrency;
	}

	public void setFxCurrency(String fxCurrency) {
		this.fxCurrency = fxCurrency;
	}

	public Timestamp getFxDate() {
		return fxDate;
	}

	public void setFxDate(Timestamp fxDate) {
		this.fxDate = fxDate;
	}

	public BigDecimal getAllocationAmountFc() {
		return allocationAmountFc;
	}

	public void setAllocationAmountFc(BigDecimal allocationAmountFc) {
		this.allocationAmountFc = allocationAmountFc;
	}

	public BigDecimal getSsp() {
		return ssp;
	}

	public void setSsp(BigDecimal ssp) {
		this.ssp = ssp;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public BigDecimal getSourceLineNumber() {
		return sourceLineNumber;
	}

	public void setSourceLineNumber(BigDecimal sourceLineNumber) {
		this.sourceLineNumber = sourceLineNumber;
	}

	public String getCustomerPoNum() {
		return customerPoNum;
	}

	public void setCustomerPoNum(String customerPoNum) {
		this.customerPoNum = customerPoNum;
	}

	
	public String getAdditionalDiscount() {
		return additionalDiscount;
	}

	public void setAdditionalDiscount(String additionalDiscount) {
		this.additionalDiscount = additionalDiscount;
	}

	public String getDiscountType() {
		return discountType;
	}

	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public BigDecimal getExtendedListAmount() {
		return extendedListAmount;
	}

	public void setExtendedListAmount(BigDecimal extendedListAmount) {
		this.extendedListAmount = extendedListAmount;
	}

	public BigDecimal getBedp() {
		return bedp;
	}

	public void setBedp(BigDecimal bedp) {
		this.bedp = bedp;
	}

	public BigDecimal getEsp() {
		return esp;
	}

	public void setEsp(BigDecimal esp) {
		this.esp = esp;
	}

	public BigDecimal getEspinst() {
		return espinst;
	}

	public void setEspinst(BigDecimal espinst) {
		this.espinst = espinst;
	}

	public BigDecimal getAllocationMarginPercentage() {
		return allocationMarginPercentage;
	}

	public void setAllocationMarginPercentage(BigDecimal allocationMarginPercentage) {
		this.allocationMarginPercentage = allocationMarginPercentage;
	}

	public BigDecimal getGrossMarginPercentage() {
		return grossMarginPercentage;
	}

	public void setGrossMarginPercentage(BigDecimal grossMarginPercentage) {
		this.grossMarginPercentage = grossMarginPercentage;
	}

	

}