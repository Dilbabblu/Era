package com.forsys.revmantra.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RMAN_DEF_ROLLFORWARD_REPORT_V")
public class RmanDefRollforwardReportV {

	@Column(name = "SOURCE_LINE_ID")
	private BigDecimal sourceLineId;

	@Column(name = "DELIVERED_ALLOCATION_AMOUNT")
	private BigDecimal deliveredAllocationAmount;

	@Column(name = "DELIVERED_ALLOCATION_AMOUNT_FC")
	private BigDecimal deliveredAllocationAmountFc;

	@Column(name = "TRANSACTION_CURRENCY")
	private String transactionCurrency;

	@Column(name = "END_DATE")
	private Timestamp endDate;

	@Column(name = "SOURCE_HEADER_ID")
	private BigDecimal sourceHeaderId;

	@Column(name = "BUNDLE_ATTRIBUTED_NET")
	private BigDecimal bundleAttributedNet;

	@Column(name = "SALES_TERITORY")
	private String salesTeritory;

	@Column(name = "PERIOD_NAME")
	private String periodName;

	@Column(name = "SALES_REGION")
	private String salesRegion;

	@Column(name = "DEAL_ARRANGEMENT_BASIS")
	private String dealArrangementBasis;

	@Column(name = "PRODUCT_PORTFOLIO")
	private String productPortfolio;

	@Column(name = "UNIT_LIST_PRICE")
	private BigDecimal unitListPrice;

	@Column(name = "SHIP_TO_CUSTOMER_NUMBER")
	private String shipToCustomerNumber;

	@Column(name = "DEAL_NAME")
	private String dealName;

	@Column(name = "LINE_AMOUNT")
	private BigDecimal lineAmount;

	@Column(name = "SSP_AMOUNT")
	private BigDecimal sspAmount;

	@Column(name = "BOOKED_AMOUNT")
	private BigDecimal bookedAmount;

	@Column(name = "DEAL_ARRANGEMENT_SOURCE")
	private String dealArrangementSource;

	@Column(name = "SOURCE_LINE_NUMBER")
	private String sourceLineNumber;

	@Column(name = "PERIOD_YEAR")
	private BigDecimal periodYear;

	@Column(name = "UNIT_NET_PRICE")
	private BigDecimal unitNetPrice;

	@Column(name = "CUSTOMER_PO_NUM")
	private String customerPoNum;

	@Column(name = "PRODUCT_NAME")
	private String productName;

	@Column(name = "QUARTER_NAME")
	private String quarterName;

	@Column(name = "RELEASE_AMOUNT")
	private BigDecimal releaseAmount;

	@Column(name = "PRODUCT_LINE")
	private String productLine;

	@Column(name = "ORDERED_QUANTITY")
	private BigDecimal orderedQuantity;

	@Column(name = "ENDING_BALANCE")
	private BigDecimal endingBalance;

	@Column(name = "REVENUE_RECOGNIZED")
	private BigDecimal revenueRecognized;

	@Column(name = "DEAL_ARRANGEMENT_STATUS")
	private String dealArrangementStatus;

	@Column(name = "DEAL_ARRANGEMENT_NUMBER")
	private String dealArrangementNumber;

	@Column(name = "POST_BILLING_DEFERRALS")
	private BigDecimal postBillingDeferrals;

	@Column(name = "POST_BILLING_DEFERRALS_FC")
	private BigDecimal postBillingDeferralsFc;

	@Column(name = "SALES_THEATER")
	private String salesTheater;

	@Column(name = "DEAL_ARRANGEMENT_NAME")
	private String dealArrangementName;

	@Column(name = "ALLOCATION_AMOUNT")
	private BigDecimal allocationAmount;

	@Column(name = "ALLOCATION_AMOUNT_FC")
	private BigDecimal allocationAmountFc;

	@Column(name = "BILL_TO_CUSTOMER_NUMBER")
	private String billToCustomerNumber;

	@Column(name = "DISCOUNT_PERCENT")
	private BigDecimal discountPercent;

	@Column(name = "DEAL_NUMBER")
	private String dealNumber;

	@Column(name = "BILL_TO_CUSTOMER")
	private String billToCustomer;

	@Column(name = "BUNDLE_ATTRIBUTED_LIST")
	private BigDecimal bundleAttributedList;

	@Column(name = "SHIP_TO_CUSTOMER")
	private String shipToCustomer;

	@Column(name = "BEGINING_BALANCE")
	private BigDecimal beginingBalance;

	@Column(name = "DEAL_LINE_NUMBER")
	private BigDecimal dealLineNumber;

	@Column(name = "START_DATE")
	private Timestamp startDate;

	@Column(name = "PERIOD_DETAIL")
	private String periodDetail;

	@Id
	@Column(name = "SNO")
	private BigDecimal sno;

	@Column(name = "DEAL_ARRANGEMENT_ID")
	private BigDecimal dealArrangementId;

	@Column(name = "UOM")
	private String uom;

	@Column(name = "ADDITION_AMOUNT")
	private BigDecimal additionAmount;

	@Column(name = "LEGAL_ENTITY_NAME")
	private String legalEntityName;

	@Column(name = "PRODUCT_FAMILY")
	private String productFamily;

	@Column(name = "ORDER_NUMBER")
	private BigDecimal orderNumber;

	@Column(name = "LINE_COST")
	private BigDecimal lineCost;

	@Column(name = "DELIVERED_AMOUNT")
	private BigDecimal deliveredAmount;

	@Column(name = "DELIVERED_DATE")
	private Timestamp deliveredDate;

	@Column(name = "CONT_NAME")
	private String contName;

	@Column(name = "ELEMENT_TYPE")
	private String elementType;

	@Column(name = "INVOICE_NUM")
	private String invoiceNum;

	@Column(name = "NOTE")
	private String note;

	@Column(name = "DIVISION")
	private String division;

	public BigDecimal getSourceLineId() {
		return this.sourceLineId;
	}

	public void setSourceLineId(BigDecimal sourceLineId) {
		this.sourceLineId = sourceLineId;
	}

	public BigDecimal getDeliveredAllocationAmount() {
		return this.deliveredAllocationAmount;
	}

	public void setDeliveredAllocationAmount(BigDecimal deliveredAllocationAmount) {
		this.deliveredAllocationAmount = deliveredAllocationAmount;
	}

	public String getTransactionCurrency() {
		return this.transactionCurrency;
	}

	public void setTransactionCurrency(String transactionCurrency) {
		this.transactionCurrency = transactionCurrency;
	}

	public Timestamp getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public BigDecimal getSourceHeaderId() {
		return this.sourceHeaderId;
	}

	public void setSourceHeaderId(BigDecimal sourceHeaderId) {
		this.sourceHeaderId = sourceHeaderId;
	}

	public BigDecimal getBundleAttributedNet() {
		return this.bundleAttributedNet;
	}

	public void setBundleAttributedNet(BigDecimal bundleAttributedNet) {
		this.bundleAttributedNet = bundleAttributedNet;
	}

	public String getSalesTeritory() {
		return this.salesTeritory;
	}

	public void setSalesTeritory(String salesTeritory) {
		this.salesTeritory = salesTeritory;
	}

	public String getPeriodName() {
		return this.periodName;
	}

	public void setPeriodName(String periodName) {
		this.periodName = periodName;
	}

	public String getSalesRegion() {
		return this.salesRegion;
	}

	public void setSalesRegion(String salesRegion) {
		this.salesRegion = salesRegion;
	}

	public String getDealArrangementBasis() {
		return this.dealArrangementBasis;
	}

	public void setDealArrangementBasis(String dealArrangementBasis) {
		this.dealArrangementBasis = dealArrangementBasis;
	}

	public String getProductPortfolio() {
		return this.productPortfolio;
	}

	public void setProductPortfolio(String productPortfolio) {
		this.productPortfolio = productPortfolio;
	}

	public BigDecimal getUnitListPrice() {
		return this.unitListPrice;
	}

	public void setUnitListPrice(BigDecimal unitListPrice) {
		this.unitListPrice = unitListPrice;
	}

	public String getShipToCustomerNumber() {
		return this.shipToCustomerNumber;
	}

	public void setShipToCustomerNumber(String shipToCustomerNumber) {
		this.shipToCustomerNumber = shipToCustomerNumber;
	}

	public String getDealName() {
		return this.dealName;
	}

	public void setDealName(String dealName) {
		this.dealName = dealName;
	}

	public BigDecimal getLineAmount() {
		return this.lineAmount;
	}

	public void setLineAmount(BigDecimal lineAmount) {
		this.lineAmount = lineAmount;
	}

	public BigDecimal getSspAmount() {
		return this.sspAmount;
	}

	public void setSspAmount(BigDecimal sspAmount) {
		this.sspAmount = sspAmount;
	}

	public BigDecimal getBookedAmount() {
		return this.bookedAmount;
	}

	public void setBookedAmount(BigDecimal bookedAmount) {
		this.bookedAmount = bookedAmount;
	}

	public String getDealArrangementSource() {
		return this.dealArrangementSource;
	}

	public void setDealArrangementSource(String dealArrangementSource) {
		this.dealArrangementSource = dealArrangementSource;
	}

	public String getSourceLineNumber() {
		return this.sourceLineNumber;
	}

	public void setSourceLineNumber(String sourceLineNumber) {
		this.sourceLineNumber = sourceLineNumber;
	}

	public BigDecimal getPeriodYear() {
		return this.periodYear;
	}

	public void setPeriodYear(BigDecimal periodYear) {
		this.periodYear = periodYear;
	}

	public BigDecimal getUnitNetPrice() {
		return this.unitNetPrice;
	}

	public void setUnitNetPrice(BigDecimal unitNetPrice) {
		this.unitNetPrice = unitNetPrice;
	}

	public String getCustomerPoNum() {
		return this.customerPoNum;
	}

	public void setCustomerPoNum(String customerPoNum) {
		this.customerPoNum = customerPoNum;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getQuarterName() {
		return this.quarterName;
	}

	public void setQuarterName(String quarterName) {
		this.quarterName = quarterName;
	}

	public BigDecimal getReleaseAmount() {
		return this.releaseAmount;
	}

	public void setReleaseAmount(BigDecimal releaseAmount) {
		this.releaseAmount = releaseAmount;
	}

	public String getProductLine() {
		return this.productLine;
	}

	public void setProductLine(String productLine) {
		this.productLine = productLine;
	}

	public BigDecimal getOrderedQuantity() {
		return this.orderedQuantity;
	}

	public void setOrderedQuantity(BigDecimal orderedQuantity) {
		this.orderedQuantity = orderedQuantity;
	}

	public BigDecimal getEndingBalance() {
		return this.endingBalance;
	}

	public void setEndingBalance(BigDecimal endingBalance) {
		this.endingBalance = endingBalance;
	}

	public BigDecimal getRevenueRecognized() {
		return this.revenueRecognized;
	}

	public void setRevenueRecognized(BigDecimal revenueRecognized) {
		this.revenueRecognized = revenueRecognized;
	}

	public String getDealArrangementStatus() {
		return this.dealArrangementStatus;
	}

	public void setDealArrangementStatus(String dealArrangementStatus) {
		this.dealArrangementStatus = dealArrangementStatus;
	}

	public String getDealArrangementNumber() {
		return this.dealArrangementNumber;
	}

	public void setDealArrangementNumber(String dealArrangementNumber) {
		this.dealArrangementNumber = dealArrangementNumber;
	}

	public BigDecimal getPostBillingDeferrals() {
		return this.postBillingDeferrals;
	}

	public void setPostBillingDeferrals(BigDecimal postBillingDeferrals) {
		this.postBillingDeferrals = postBillingDeferrals;
	}

	public String getSalesTheater() {
		return this.salesTheater;
	}

	public void setSalesTheater(String salesTheater) {
		this.salesTheater = salesTheater;
	}

	public String getDealArrangementName() {
		return this.dealArrangementName;
	}

	public void setDealArrangementName(String dealArrangementName) {
		this.dealArrangementName = dealArrangementName;
	}

	public BigDecimal getAllocationAmount() {
		return this.allocationAmount;
	}

	public void setAllocationAmount(BigDecimal allocationAmount) {
		this.allocationAmount = allocationAmount;
	}

	public String getBillToCustomerNumber() {
		return this.billToCustomerNumber;
	}

	public void setBillToCustomerNumber(String billToCustomerNumber) {
		this.billToCustomerNumber = billToCustomerNumber;
	}

	public BigDecimal getDiscountPercent() {
		return this.discountPercent;
	}

	public void setDiscountPercent(BigDecimal discountPercent) {
		this.discountPercent = discountPercent;
	}

	public String getDealNumber() {
		return this.dealNumber;
	}

	public void setDealNumber(String dealNumber) {
		this.dealNumber = dealNumber;
	}

	public String getBillToCustomer() {
		return this.billToCustomer;
	}

	public void setBillToCustomer(String billToCustomer) {
		this.billToCustomer = billToCustomer;
	}

	public BigDecimal getBundleAttributedList() {
		return this.bundleAttributedList;
	}

	public void setBundleAttributedList(BigDecimal bundleAttributedList) {
		this.bundleAttributedList = bundleAttributedList;
	}

	public String getShipToCustomer() {
		return this.shipToCustomer;
	}

	public void setShipToCustomer(String shipToCustomer) {
		this.shipToCustomer = shipToCustomer;
	}

	public BigDecimal getBeginingBalance() {
		return this.beginingBalance;
	}

	public void setBeginingBalance(BigDecimal beginingBalance) {
		this.beginingBalance = beginingBalance;
	}

	public BigDecimal getDealLineNumber() {
		return this.dealLineNumber;
	}

	public void setDealLineNumber(BigDecimal dealLineNumber) {
		this.dealLineNumber = dealLineNumber;
	}

	public Timestamp getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public String getPeriodDetail() {
		return this.periodDetail;
	}

	public void setPeriodDetail(String periodDetail) {
		this.periodDetail = periodDetail;
	}

	public BigDecimal getDealArrangementId() {
		return this.dealArrangementId;
	}

	public void setDealArrangementId(BigDecimal dealArrangementId) {
		this.dealArrangementId = dealArrangementId;
	}

	public String getUom() {
		return this.uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public BigDecimal getAdditionAmount() {
		return this.additionAmount;
	}

	public void setAdditionAmount(BigDecimal additionAmount) {
		this.additionAmount = additionAmount;
	}

	public String getLegalEntityName() {
		return this.legalEntityName;
	}

	public void setLegalEntityName(String legalEntityName) {
		this.legalEntityName = legalEntityName;
	}

	public String getProductFamily() {
		return this.productFamily;
	}

	public void setProductFamily(String productFamily) {
		this.productFamily = productFamily;
	}

	public BigDecimal getOrderNumber() {
		return this.orderNumber;
	}

	public void setOrderNumber(BigDecimal orderNumber) {
		this.orderNumber = orderNumber;
	}

	public BigDecimal getLineCost() {
		return this.lineCost;
	}

	public void setLineCost(BigDecimal lineCost) {
		this.lineCost = lineCost;
	}

	public BigDecimal getDeliveredAmount() {
		return this.deliveredAmount;
	}

	public void setDeliveredAmount(BigDecimal deliveredAmount) {
		this.deliveredAmount = deliveredAmount;
	}

	public BigDecimal getDeliveredAllocationAmountFc() {
		return deliveredAllocationAmountFc;
	}

	public void setDeliveredAllocationAmountFc(BigDecimal deliveredAllocationAmountFc) {
		this.deliveredAllocationAmountFc = deliveredAllocationAmountFc;
	}

	public BigDecimal getPostBillingDeferralsFc() {
		return postBillingDeferralsFc;
	}

	public void setPostBillingDeferralsFc(BigDecimal postBillingDeferralsFc) {
		this.postBillingDeferralsFc = postBillingDeferralsFc;
	}

	public BigDecimal getSno() {
		return sno;
	}

	public void setSno(BigDecimal sno) {
		this.sno = sno;
	}

	public Timestamp getDeliveredDate() {
		return deliveredDate;
	}

	public void setDeliveredDate(Timestamp deliveredDate) {
		this.deliveredDate = deliveredDate;
	}

	public String getContName() {
		return contName;
	}

	public void setContName(String contName) {
		this.contName = contName;
	}

	public String getElementType() {
		return elementType;
	}

	public void setElementType(String elementType) {
		this.elementType = elementType;
	}

	public String getInvoiceNum() {
		return invoiceNum;
	}

	public void setInvoiceNum(String invoiceNum) {
		this.invoiceNum = invoiceNum;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public BigDecimal getAllocationAmountFc() {
		return allocationAmountFc;
	}

	public void setAllocationAmountFc(BigDecimal allocationAmountFc) {
		this.allocationAmountFc = allocationAmountFc;
	}

}