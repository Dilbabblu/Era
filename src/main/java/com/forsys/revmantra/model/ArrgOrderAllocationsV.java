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
@Table(name="ARRG_ORDER_ALLOCATIONS_V")
public class ArrgOrderAllocationsV {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="DEAL_LINE_ID")
    private BigDecimal dealLineId;

    @Column(name="FX_DATE")
    private Timestamp fxDate;

    @Column(name="SOURCE_LINE_ID")
    private BigDecimal sourceLineId;

    @Column(name="QUANTITY")
    private BigDecimal quantity;

    @Column(name="ARRG_LINE_NUMBER")
    private String arrgLineNumber;

    @Column(name="ELEMENT_TYPE")
    private String elementType;

    @Column(name="PARENT_LINE_NUMBER")
    private BigDecimal parentLineNumber;

    @Column(name="TOTAL_COST")
    private BigDecimal totalCost;

    @Column(name="PRODUCT_DESCRIPTION")
    private String productDescription;

    @Column(name="UNIT_SELLING_PRICE")
    private BigDecimal unitSellingPrice;

    @Column(name="SSP_HIGH")
    private BigDecimal sspHigh;

    @Column(name="UNIT_LIST_PRICE")
    private BigDecimal unitListPrice;

    @Column(name="ALLOCABLE_AMOUNT")
    private BigDecimal allocableAmount;

    @Column(name="CV_IN_OUT_AMOUNT")
    private BigDecimal cvInOutAmount;

    @Column(name="ALLOCATION_FLAG")
    private String allocationFlag;
    /**
     * changed variable name from bundleAttribitionList to bundleAttributionList
     * #AYAR-455 by Chandra Kota on 2021-JUN-03
     */
    @Column(name="BUNDLE_ATTRIBITION_LIST")
    private BigDecimal bundleAttributionList;

    @Column(name="LINE_AMOUNT")
    private BigDecimal lineAmount;

    @Column(name="POB_GROUPING")
    private String pobGrouping;

    @Column(name="PRODUCT_GROUP")
    private String productGroup;

    @Column(name="FMV_MIN")
    private BigDecimal fmvMin;

    @Column(name="FMV_AMOUNT")
    private BigDecimal fmvAmount;

    @Column(name="SOURCE_LINE_NUMBER")
    private String sourceLineNumber;

    @Column(name="DEAL_HEADER_ID")
    private BigDecimal dealHeaderId;

    @Column(name="PRODUCT_NAME")
    private String productName;

    @Column(name="CUSTOMER_PO_NUM")
    private String customerPoNum;

    @Column(name="VC")
    private BigDecimal vc;

    @Column(name="ALLOCATION_ELIGIBLE")
    private String allocationEligible;

    @Column(name="TRX_CURRENCY_CODE")
    private String trxCurrencyCode;

    @Column(name="ALLOCATION_AMOUNT_FC")
    private BigDecimal allocationAmountFc;

    @Column(name="FMV_MAX")
    private BigDecimal fmvMax;

    @Column(name="UOM_CODE")
    private String uomCode;

    @Column(name="ALLOCATION_INCLUSIVE")
    private String allocationInclusive;
    
    /**
     * changed variable name from bundleAttribitionNet to bundleAttributionNet
     * #AYAR-455 by Chandra Kota on 2021-JUN-03
     */
    @Column(name="BUNDLE_ATTRIBITION_NET")
    private BigDecimal bundleAttributionNet;

    @Column(name="SSP_LOW")
    private BigDecimal sspLow;

    @Column(name="FX_CURRENCY")
    private String fxCurrency;

    @Column(name="ALLOCATION_AMOUNT")
    private BigDecimal allocationAmount;

    @Column(name="DEAL_CURRENCY_CODE")
    private String dealCurrencyCode;

    @Column(name="FX_RATE")
    private BigDecimal fxRate;

    @Column(name="FMV_CATEGORY")
    private String fmvCategory;

    @Column(name="DEAL_NUMBER")
    private String dealNumber;

    @Column(name="REP_CURR_CODE")
    private String repCurrCode;

    @Column(name="TRX_ALLOC_UNIT_AMT")
    private BigDecimal trxAllocUnitAmt;

    @Column(name="FMV_RULE_NAME")
    private String fmvRuleName;

    @Column(name="ADDITIONAL_DISCOUNT")
    private String additionalDiscount;

    @Column(name="DEAL_LINE_NUMBER")
    private BigDecimal dealLineNumber;

    @Column(name="FMV_MEAN")
    private BigDecimal fmvMean;

    @Column(name="SOLUTION")
    private String solution;

    @Column(name="PARENT_LINE_ID")
    private BigDecimal parentLineId;

    @Column(name="DISCOUNT_TYPE")
    private String discountType;

    @Column(name="DEAL_ARRANGEMENT_ID")
    private BigDecimal dealArrangementId;

    @Column(name="ACCOUNTING_SCOPE")
    private String accountingScope;

    @Column(name="PRODUCT_TYPE")
    private String productType;

    @Column(name="SSP")
    private BigDecimal ssp;

    @Column(name="ACCOUNTING_STANDARD")
    private String accountingStandard;

    @Column(name="NET_PRICE_DISCOUNT")
    private BigDecimal netPriceDiscount;

    @Column(name="ORDER_NUMBER")
    private BigDecimal orderNumber;

    @Column(name="BUNDLE_FLAG")
    private String bundleFlag;

    @Column(name="FMV_TYPE")
    private String fmvType;
    
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
	
    public Timestamp getFxDate() { 
        return this.fxDate;
    }

    public void setFxDate(Timestamp fxDate) { 
        this.fxDate=fxDate;
    }
    public BigDecimal getSourceLineId() { 
        return this.sourceLineId;
    }

    public void setSourceLineId(BigDecimal sourceLineId) { 
        this.sourceLineId=sourceLineId;
    }
    public BigDecimal getQuantity() { 
        return this.quantity;
    }

    public void setQuantity(BigDecimal quantity) { 
        this.quantity=quantity;
    }
    public String getArrgLineNumber() { 
        return this.arrgLineNumber;
    }

    public void setArrgLineNumber(String arrgLineNumber) { 
        this.arrgLineNumber=arrgLineNumber;
    }
    public String getElementType() { 
        return this.elementType;
    }

    public void setElementType(String elementType) { 
        this.elementType=elementType;
    }
    public BigDecimal getParentLineNumber() { 
        return this.parentLineNumber;
    }

    public void setParentLineNumber(BigDecimal parentLineNumber) { 
        this.parentLineNumber=parentLineNumber;
    }
    public BigDecimal getTotalCost() { 
        return this.totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) { 
        this.totalCost=totalCost;
    }
    public String getProductDescription() { 
        return this.productDescription;
    }

    public void setProductDescription(String productDescription) { 
        this.productDescription=productDescription;
    }
    public BigDecimal getUnitSellingPrice() { 
        return this.unitSellingPrice;
    }

    public void setUnitSellingPrice(BigDecimal unitSellingPrice) { 
        this.unitSellingPrice=unitSellingPrice;
    }
    public BigDecimal getSspHigh() { 
        return this.sspHigh;
    }

    public void setSspHigh(BigDecimal sspHigh) { 
        this.sspHigh=sspHigh;
    }
    public BigDecimal getUnitListPrice() { 
        return this.unitListPrice;
    }

    public void setUnitListPrice(BigDecimal unitListPrice) { 
        this.unitListPrice=unitListPrice;
    }
    public BigDecimal getAllocableAmount() { 
        return this.allocableAmount;
    }

    public void setAllocableAmount(BigDecimal allocableAmount) { 
        this.allocableAmount=allocableAmount;
    }
    public BigDecimal getCvInOutAmount() { 
        return this.cvInOutAmount;
    }

    public void setCvInOutAmount(BigDecimal cvInOutAmount) { 
        this.cvInOutAmount=cvInOutAmount;
    }
    public String getAllocationFlag() { 
        return this.allocationFlag;
    }

    public void setAllocationFlag(String allocationFlag) { 
        this.allocationFlag=allocationFlag;
    }
    public BigDecimal getBundleAttributionList() { 
        return this.bundleAttributionList;
    }

    public void setBundleAttributionList(BigDecimal bundleAttributionList) { 
        this.bundleAttributionList=bundleAttributionList;
    }
    public BigDecimal getLineAmount() { 
        return this.lineAmount;
    }

    public void setLineAmount(BigDecimal lineAmount) { 
        this.lineAmount=lineAmount;
    }
    public String getPobGrouping() { 
        return this.pobGrouping;
    }

    public void setPobGrouping(String pobGrouping) { 
        this.pobGrouping=pobGrouping;
    }
    public String getProductGroup() { 
        return this.productGroup;
    }

    public void setProductGroup(String productGroup) { 
        this.productGroup=productGroup;
    }
    public BigDecimal getFmvMin() { 
        return this.fmvMin;
    }

    public void setFmvMin(BigDecimal fmvMin) { 
        this.fmvMin=fmvMin;
    }
    public BigDecimal getFmvAmount() { 
        return this.fmvAmount;
    }

    public void setFmvAmount(BigDecimal fmvAmount) { 
        this.fmvAmount=fmvAmount;
    }
    public String getSourceLineNumber() { 
        return this.sourceLineNumber;
    }

    public void setSourceLineNumber(String sourceLineNumber) { 
        this.sourceLineNumber=sourceLineNumber;
    }
    public BigDecimal getDealHeaderId() { 
        return this.dealHeaderId;
    }

    public void setDealHeaderId(BigDecimal dealHeaderId) { 
        this.dealHeaderId=dealHeaderId;
    }
    public String getProductName() { 
        return this.productName;
    }

    public void setProductName(String productName) { 
        this.productName=productName;
    }
    public String getCustomerPoNum() { 
        return this.customerPoNum;
    }

    public void setCustomerPoNum(String customerPoNum) { 
        this.customerPoNum=customerPoNum;
    }
    public BigDecimal getVc() { 
        return this.vc;
    }

    public void setVc(BigDecimal vc) { 
        this.vc=vc;
    }
    public String getAllocationEligible() { 
        return this.allocationEligible;
    }

    public void setAllocationEligible(String allocationEligible) { 
        this.allocationEligible=allocationEligible;
    }
    public String getTrxCurrencyCode() { 
        return this.trxCurrencyCode;
    }

    public void setTrxCurrencyCode(String trxCurrencyCode) { 
        this.trxCurrencyCode=trxCurrencyCode;
    }
    public BigDecimal getAllocationAmountFc() { 
        return this.allocationAmountFc;
    }

    public void setAllocationAmountFc(BigDecimal allocationAmountFc) { 
        this.allocationAmountFc=allocationAmountFc;
    }
    public BigDecimal getFmvMax() { 
        return this.fmvMax;
    }

    public void setFmvMax(BigDecimal fmvMax) { 
        this.fmvMax=fmvMax;
    }
    public String getUomCode() { 
        return this.uomCode;
    }

    public void setUomCode(String uomCode) { 
        this.uomCode=uomCode;
    }
    public String getAllocationInclusive() { 
        return this.allocationInclusive;
    }

    public void setAllocationInclusive(String allocationInclusive) { 
        this.allocationInclusive=allocationInclusive;
    }
    public BigDecimal getBundleAttributionNet() { 
        return this.bundleAttributionNet;
    }

    public void setBundleAttributionNet(BigDecimal bundleAttributionNet) { 
        this.bundleAttributionNet=bundleAttributionNet;
    }
    public BigDecimal getSspLow() { 
        return this.sspLow;
    }

    public void setSspLow(BigDecimal sspLow) { 
        this.sspLow=sspLow;
    }
    public String getFxCurrency() { 
        return this.fxCurrency;
    }

    public void setFxCurrency(String fxCurrency) { 
        this.fxCurrency=fxCurrency;
    }
    public BigDecimal getDealLineId() { 
        return this.dealLineId;
    }

    public void setDealLineId(BigDecimal dealLineId) { 
        this.dealLineId=dealLineId;
    }
    public BigDecimal getAllocationAmount() { 
        return this.allocationAmount;
    }

    public void setAllocationAmount(BigDecimal allocationAmount) { 
        this.allocationAmount=allocationAmount;
    }
    public String getDealCurrencyCode() { 
        return this.dealCurrencyCode;
    }

    public void setDealCurrencyCode(String dealCurrencyCode) { 
        this.dealCurrencyCode=dealCurrencyCode;
    }
    public BigDecimal getFxRate() { 
        return this.fxRate;
    }

    public void setFxRate(BigDecimal fxRate) { 
        this.fxRate=fxRate;
    }
    public String getFmvCategory() { 
        return this.fmvCategory;
    }

    public void setFmvCategory(String fmvCategory) { 
        this.fmvCategory=fmvCategory;
    }
    public String getDealNumber() { 
        return this.dealNumber;
    }

    public void setDealNumber(String dealNumber) { 
        this.dealNumber=dealNumber;
    }
    public String getRepCurrCode() { 
        return this.repCurrCode;
    }

    public void setRepCurrCode(String repCurrCode) { 
        this.repCurrCode=repCurrCode;
    }
    public BigDecimal getTrxAllocUnitAmt() { 
        return this.trxAllocUnitAmt;
    }

    public void setTrxAllocUnitAmt(BigDecimal trxAllocUnitAmt) { 
        this.trxAllocUnitAmt=trxAllocUnitAmt;
    }
    public String getFmvRuleName() { 
        return this.fmvRuleName;
    }

    public void setFmvRuleName(String fmvRuleName) { 
        this.fmvRuleName=fmvRuleName;
    }
    public String getAdditionalDiscount() { 
        return this.additionalDiscount;
    }

    public void setAdditionalDiscount(String additionalDiscount) { 
        this.additionalDiscount=additionalDiscount;
    }
    public BigDecimal getDealLineNumber() { 
        return this.dealLineNumber;
    }

    public void setDealLineNumber(BigDecimal dealLineNumber) { 
        this.dealLineNumber=dealLineNumber;
    }
    public BigDecimal getFmvMean() { 
        return this.fmvMean;
    }

    public void setFmvMean(BigDecimal fmvMean) { 
        this.fmvMean=fmvMean;
    }
    public String getSolution() { 
        return this.solution;
    }

    public void setSolution(String solution) { 
        this.solution=solution;
    }
    public BigDecimal getParentLineId() { 
        return this.parentLineId;
    }

    public void setParentLineId(BigDecimal parentLineId) { 
        this.parentLineId=parentLineId;
    }
    public String getDiscountType() { 
        return this.discountType;
    }

    public void setDiscountType(String discountType) { 
        this.discountType=discountType;
    }
    public BigDecimal getDealArrangementId() { 
        return this.dealArrangementId;
    }

    public void setDealArrangementId(BigDecimal dealArrangementId) { 
        this.dealArrangementId=dealArrangementId;
    }
    public String getAccountingScope() { 
        return this.accountingScope;
    }

    public void setAccountingScope(String accountingScope) { 
        this.accountingScope=accountingScope;
    }
    public String getProductType() { 
        return this.productType;
    }

    public void setProductType(String productType) { 
        this.productType=productType;
    }
    public BigDecimal getSsp() { 
        return this.ssp;
    }

    public void setSsp(BigDecimal ssp) { 
        this.ssp=ssp;
    }
    public String getAccountingStandard() { 
        return this.accountingStandard;
    }

    public void setAccountingStandard(String accountingStandard) { 
        this.accountingStandard=accountingStandard;
    }
    public BigDecimal getNetPriceDiscount() { 
        return this.netPriceDiscount;
    }

    public void setNetPriceDiscount(BigDecimal netPriceDiscount) { 
        this.netPriceDiscount=netPriceDiscount;
    }
    public BigDecimal getOrderNumber() { 
        return this.orderNumber;
    }

    public void setOrderNumber(BigDecimal orderNumber) { 
        this.orderNumber=orderNumber;
    }
    public String getBundleFlag() { 
        return this.bundleFlag;
    }

    public void setBundleFlag(String bundleFlag) { 
        this.bundleFlag=bundleFlag;
    }
    public String getFmvType() { 
        return this.fmvType;
    }

    public void setFmvType(String fmvType) { 
        this.fmvType=fmvType;
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