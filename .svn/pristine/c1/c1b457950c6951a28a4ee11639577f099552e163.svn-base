package com.forsys.revmantra.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "RMAN_ORD_LINE_BKINGS_IFRS_V")
@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "rman_deal_so_unlink_proc", procedureName = "RMAN_DEAL_PROCESS_PKG.UNLINK_SALES_ORDER_LINE", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "arrangementId", type = BigDecimal.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "soLineId", type = BigDecimal.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "userId", type = BigDecimal.class) }),
		@NamedStoredProcedureQuery(name = "rman_deal_so_link_proc", procedureName = "RMAN_DEAL_PROCESS_PKG.LINK_SALES_ORDER_LINE", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "arrangementId", type = BigDecimal.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "soLineId", type = BigDecimal.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "dealNumber", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "dealLineNumber", type = BigDecimal.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "userId", type = BigDecimal.class) }) })
public class RmanOrderLinesBookingsV {

	@Id
	@Column(name = "RMAN_LINE_ID")
	private BigDecimal orderLineId;

	@Column(name = "LIST_PRICE")
	private BigDecimal listPrice;

	public BigDecimal getSourceLineId2() {
		return sourceLineId2;
	}
	
	public String getSourceLineId() {
		return sourceLineId2.toString();
	}

	public void setSourceLineId(BigDecimal sourceLineId2) {
		this.sourceLineId2 = sourceLineId2;
	}

	@Column(name = "REVREC_ACCT_SCOPE")
	private String revrecAcctScope;

	@Column(name = "SO#")
	private BigDecimal so;

	@Column(name = "SO_LINE_NUM")
	private String soLineNum;

	@Column(name = "SOURCE_LINE_ID")
	private BigDecimal sourceLineId2;
	
	@Transient
	private String sourceLineId;

	public String getSoLineNum() {
		return soLineNum;
	}

	public void setSoLineNum(String soLineNum) {
		this.soLineNum = soLineNum;
	}

	@Column(name = "PRICE_LIST")
	private String priceList;

	@Column(name = "SHIPEED_DATE")
	private Timestamp shipeedDate;

	@Column(name = "ELEMENT_TYPE")
	private String elementType;

	@Column(name = "REVREC_END_DATE")
	private Timestamp revrecEndDate;

	@Column(name = "SHIPPED_QUANTITY")
	private BigDecimal shippedQuantity;

	@Column(name = "END_CUSTOMER")
	private String endCustomer;

	@Column(name = "REVREC_DELAY")
	private BigDecimal revrecDelay;

	@Column(name = "BOOKING_CURRENCY")
	private String bookingCurrency;

	@Column(name = "NET_PRICE")
	private BigDecimal netPrice;

	@Column(name = "REVREC_ACCT_RULE")
	private String revrecAcctRule;

	@Column(name = "PARENT_LINE_ID")
	private BigDecimal parentLineId;

	@Column(name = "CUSTOMER_PO_NUM")
	private String customerPoNum;

	@Column(name = "PRODUCT_NAME")
	private String productName;

	@Column(name = "LINE_STATUS")
	private String lineStatus;

	@Column(name = "ARRANGEMENT_ID")
	private BigDecimal arrangementId;

	@Column(name = "FUNC_CURRENCY_CODE")
	private String funcCurrencyCode;

	@Column(name = "ACCOUNTING_RULE_NAME")
	private String accountingRuleName;

	@Column(name = "ACCOUNTING_SCOPE")
	private String accountingScope;

	@Column(name = "OU_NAME")
	private String ouName;

	@Column(name = "ORDER_BOOKED_DATE")
	private Timestamp orderBookedDate;

	@Column(name = "PRODUCT_FAMILY")
	private String productFamily;

	@Column(name = "REVREC_ACCOUNT")
	private String revrecAccount;

	@Column(name = "PRODUCT_CATEGORY")
	private String productCategory;

	@Column(name = "ORDERED_QUANTITY")
	private BigDecimal orderedQuantity;

	@Column(name = "DA")
	private String da;

	@Column(name = "CONTRACT_START_DATE")
	private Timestamp contractStartDate;

	@Column(name = "CONTRACT_END_DATE")
	private Timestamp contractEndDate;

	@Column(name = "REVREC_ST_DATE")
	private Timestamp revrecStDate;

	@Column(name = "BUNDLE_FLAG")
	private String bundleFlag;

	@Column(name = "UOM")
	private String uom;

	@Column(name = "LINE_AMOUNT")
	private BigDecimal lineAmount;

	@Column(name = "BOOKED_DATE")
	private Timestamp bookedDate;

	@Column(name = "SHIP_DATE")
	private Timestamp shipDate;

	@Column(name = "BILLED_DATE")
	private Timestamp billedDate;

	@Column(name = "MILESTONE")
	private String milestone;

	@Column(name = "POB_GROUPING")
	private String pobGrouping;

	@Column(name = "POB_TEMPLATE")
	private String pobTemplate;

	@Column(name = "AMORT_RULE_REVENUE")
	private String amortRuleRevenue;

	@Column(name = "SOURCE_HEADER_ID")
	private String sourceHeaderId;

	@Column(name = "REF_ORDER_NUMBER")
	private BigDecimal refOrderNumber;

	@Column(name = "SERVICE_REF_ORDER")
	private BigDecimal serviceRefOrder;

	@Column(name = "SERVICE_REF_ORD_LINE_NUM")
	private BigDecimal serviceRefOrdLineNum;
	
	@Column(name = "CONTRACT_MODIFED")
	private String contractModifed;
	
	@Column(name = "CONTRACT_MODIFIED_DATE")
	private Timestamp contractModifiedDate;
	
	@Column(name = "LINE_COST")
	private BigDecimal lineCost;
	
	@Column(name = "MANUFACTURING_COST")
	private BigDecimal manufacturingCost;
	
	@Column(name = "CUSTOMER_NUMBER")
	private String customerNumber;
	
	@Column(name = "EXTENDED_LIST_AMOUNT")
	private BigDecimal extendedListAmount;
	
	@Column(name = "EXTENDED_SELLING_AMOUNT")
	private BigDecimal extendedSellingmount;
	
	@Column(name = "DISCOUNT_PERCENT")
	private BigDecimal discountPercent;
	
	@Column(name = "EXT_WARRANTY_SKU")
	private String extWarrantySku;
	
	@Column(name = "EXT_SERV_START_DATE")
	private Timestamp extServStartDate;
	
	@Column(name = "EXT_SERV_END_DATE")
	private Timestamp extServEndDate;
	
	@Column(name = "EXT_PERIOD")
	private String extPeriod;
	
	@Column(name = "EXT_DURATION")
	private BigDecimal extDuration;
	
	@Column(name = "EXT_LIST_PRICE")
	private BigDecimal extListPrice;
	
	@Column(name = "EXT_DISCOUNT")
	private BigDecimal extDiscount;
	
	@Column(name = "SUPPORT_SKU")
	private String supportSku;
	
	@Column(name = "SUPPORT_SERV_START_DATE")
	private Timestamp supportServStartDate;
	
	@Column(name = "SUPPORT_SERV_END_DATE")
	private Timestamp supportServEndDate;
	
	@Column(name = "SUPPORT_PERIOD")
	private String supportPeriod;
	
	@Column(name = "SUPPORT_DURATION")
	private BigDecimal supportDuration;
	
	@Column(name = "SUPPORT_LIST_PRICE")
	private BigDecimal supportListPrice;	
	
	@Column(name = "SUPPORT_DISCOUNT")
	private BigDecimal supportDiscount;
	
	@Column(name = "DEAL_NUMBER")
	private String dealNumber;
	
	@Column(name = "DEAL_LINE_NUMBER")
	private BigDecimal dealLineNumber;
	
	@Column(name = "LINE_ATTRIBUTE1")
	private String lineAttribute1;
	
	@Column(name = "LINE_ATTRIBUTE2")
	private String lineAttribute2;
	
	@Column(name = "LINE_ATTRIBUTE3")
	private String lineAttribute3;
	
	@Column(name = "LINE_ATTRIBUTE4")
	private String lineAttribute4;
	
	@Column(name = "LINE_ATTRIBUTE5")
	private String lineAttribute5;
	
	@Column(name = "LINE_ATTRIBUTE6")
	private String lineAttribute6;
	
	@Column(name = "LINE_ATTRIBUTE7")
	private String lineAttribute7;
	
	@Column(name = "LINE_ATTRIBUTE8")
	private String lineAttribute8;
	
	@Column(name = "LINE_ATTRIBUTE9")
	private String lineAttribute9;
	
	@Column(name = "LINE_ATTRIBUTE10")
	private String lineAttribute10;
	
	@Column(name = "LINE_ATTRIBUTE11")
	private String lineAttribute11;
	
	@Column(name = "LINE_ATTRIBUTE12")
	private String lineAttribute12;
	
	@Column(name = "LINE_ATTRIBUTE13")
	private String lineAttribute13;
	
	@Column(name = "LINE_ATTRIBUTE14")
	private String lineAttribute14;
	
	@Column(name = "LINE_ATTRIBUTE15")
	private String lineAttribute15;
	

	
	public String getLineAttribute1() {
		return lineAttribute1;
	}

	public void setLineAttribute1(String lineAttribute1) {
		this.lineAttribute1 = lineAttribute1;
	}

	public String getLineAttribute2() {
		return lineAttribute2;
	}

	public void setLineAttribute2(String lineAttribute2) {
		this.lineAttribute2 = lineAttribute2;
	}

	public String getLineAttribute3() {
		return lineAttribute3;
	}

	public void setLineAttribute3(String lineAttribute3) {
		this.lineAttribute3 = lineAttribute3;
	}

	public String getLineAttribute4() {
		return lineAttribute4;
	}

	public void setLineAttribute4(String lineAttribute4) {
		this.lineAttribute4 = lineAttribute4;
	}

	public String getLineAttribute5() {
		return lineAttribute5;
	}

	public void setLineAttribute5(String lineAttribute5) {
		this.lineAttribute5 = lineAttribute5;
	}

	public String getLineAttribute6() {
		return lineAttribute6;
	}

	public void setLineAttribute6(String lineAttribute6) {
		this.lineAttribute6 = lineAttribute6;
	}

	public String getLineAttribute7() {
		return lineAttribute7;
	}

	public void setLineAttribute7(String lineAttribute7) {
		this.lineAttribute7 = lineAttribute7;
	}

	public String getLineAttribute8() {
		return lineAttribute8;
	}

	public void setLineAttribute8(String lineAttribute8) {
		this.lineAttribute8 = lineAttribute8;
	}

	public String getLineAttribute9() {
		return lineAttribute9;
	}

	public void setLineAttribute9(String lineAttribute9) {
		this.lineAttribute9 = lineAttribute9;
	}

	public String getLineAttribute10() {
		return lineAttribute10;
	}

	public void setLineAttribute10(String lineAttribute10) {
		this.lineAttribute10 = lineAttribute10;
	}

	public String getLineAttribute11() {
		return lineAttribute11;
	}

	public void setLineAttribute11(String lineAttribute11) {
		this.lineAttribute11 = lineAttribute11;
	}

	public String getLineAttribute12() {
		return lineAttribute12;
	}

	public void setLineAttribute12(String lineAttribute12) {
		this.lineAttribute12 = lineAttribute12;
	}

	public String getLineAttribute13() {
		return lineAttribute13;
	}

	public void setLineAttribute13(String lineAttribute13) {
		this.lineAttribute13 = lineAttribute13;
	}

	public String getLineAttribute14() {
		return lineAttribute14;
	}

	public void setLineAttribute14(String lineAttribute14) {
		this.lineAttribute14 = lineAttribute14;
	}

	public String getLineAttribute15() {
		return lineAttribute15;
	}

	public void setLineAttribute15(String lineAttribute15) {
		this.lineAttribute15 = lineAttribute15;
	}

	public String getContractModifed() {
		return contractModifed;
	}

	public void setContractModifed(String contractModifed) {
		this.contractModifed = contractModifed;
	}

	public Timestamp getContractModifiedDate() {
		return contractModifiedDate;
	}

	public void setContractModifiedDate(Timestamp contractModifiedDate) {
		this.contractModifiedDate = contractModifiedDate;
	}

	
	public String getSourceHeaderId() {
		return sourceHeaderId;
	}

	public void setSourceHeaderId(String sourceHeaderId) {
		this.sourceHeaderId = sourceHeaderId;
	}

	public String getAmortRuleRevenue() {
		return amortRuleRevenue;
	}

	public void setAmortRuleRevenue(String amortRuleRevenue) {
		this.amortRuleRevenue = amortRuleRevenue;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public BigDecimal getLineAmount() {
		return lineAmount;
	}

	public void setLineAmount(BigDecimal lineAmount) {
		this.lineAmount = lineAmount;
	}

	public Timestamp getBookedDate() {
		return bookedDate;
	}

	public void setBookedDate(Timestamp bookedDate) {
		this.bookedDate = bookedDate;
	}

	public Timestamp getShipDate() {
		return shipDate;
	}

	public void setShipDate(Timestamp shipDate) {
		this.shipDate = shipDate;
	}

	public Timestamp getBilledDate() {
		return billedDate;
	}

	public void setBilledDate(Timestamp billedDate) {
		this.billedDate = billedDate;
	}

	public String getMilestone() {
		return milestone;
	}

	public void setMilestone(String milestone) {
		this.milestone = milestone;
	}

	public String getPobGrouping() {
		return pobGrouping;
	}

	public void setPobGrouping(String pobGrouping) {
		this.pobGrouping = pobGrouping;
	}

	public String getPobTemplate() {
		return pobTemplate;
	}

	public void setPobTemplate(String pobTemplate) {
		this.pobTemplate = pobTemplate;
	}

	public BigDecimal getListPrice() {
		return this.listPrice;
	}

	public void setListPrice(BigDecimal listPrice) {
		this.listPrice = listPrice;
	}

	public String getRevrecAcctScope() {
		return this.revrecAcctScope;
	}

	public void setRevrecAcctScope(String revrecAcctScope) {
		this.revrecAcctScope = revrecAcctScope;
	}

	public BigDecimal getSo() {
		return this.so;
	}

	public void setSo(BigDecimal so) {
		this.so = so;
	}

	public String getPriceList() {
		return this.priceList;
	}

	public void setPriceList(String priceList) {
		this.priceList = priceList;
	}

	public Timestamp getShipeedDate() {
		return this.shipeedDate;
	}

	public void setShipeedDate(Timestamp shipeedDate) {
		this.shipeedDate = shipeedDate;
	}

	public String getElementType() {
		return this.elementType;
	}

	public void setElementType(String elementType) {
		this.elementType = elementType;
	}

	public Timestamp getRevrecEndDate() {
		return this.revrecEndDate;
	}

	public void setRevrecEndDate(Timestamp revrecEndDate) {
		this.revrecEndDate = revrecEndDate;
	}

	public BigDecimal getShippedQuantity() {
		return this.shippedQuantity;
	}

	public void setShippedQuantity(BigDecimal shippedQuantity) {
		this.shippedQuantity = shippedQuantity;
	}

	public String getEndCustomer() {
		return this.endCustomer;
	}

	public void setEndCustomer(String endCustomer) {
		this.endCustomer = endCustomer;
	}

	public BigDecimal getRevrecDelay() {
		return this.revrecDelay;
	}

	public void setRevrecDelay(BigDecimal revrecDelay) {
		this.revrecDelay = revrecDelay;
	}

	public String getBookingCurrency() {
		return this.bookingCurrency;
	}

	public void setBookingCurrency(String bookingCurrency) {
		this.bookingCurrency = bookingCurrency;
	}

	public BigDecimal getNetPrice() {
		return this.netPrice;
	}

	public void setNetPrice(BigDecimal netPrice) {
		this.netPrice = netPrice;
	}

	public String getRevrecAcctRule() {
		return this.revrecAcctRule;
	}

	public void setRevrecAcctRule(String revrecAcctRule) {
		this.revrecAcctRule = revrecAcctRule;
	}

	public BigDecimal getParentLineId() {
		return this.parentLineId;
	}

	public void setParentLineId(BigDecimal parentLineId) {
		this.parentLineId = parentLineId;
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

	public String getLineStatus() {
		return this.lineStatus;
	}

	public void setLineStatus(String lineStatus) {
		this.lineStatus = lineStatus;
	}

	public BigDecimal getArrangementId() {
		return this.arrangementId;
	}

	public void setArrangementId(BigDecimal arrangementId) {
		this.arrangementId = arrangementId;
	}

	public String getFuncCurrencyCode() {
		return this.funcCurrencyCode;
	}

	public void setFuncCurrencyCode(String funcCurrencyCode) {
		this.funcCurrencyCode = funcCurrencyCode;
	}

	public String getAccountingRuleName() {
		return this.accountingRuleName;
	}

	public void setAccountingRuleName(String accountingRuleName) {
		this.accountingRuleName = accountingRuleName;
	}

	public String getAccountingScope() {
		return this.accountingScope;
	}

	public void setAccountingScope(String accountingScope) {
		this.accountingScope = accountingScope;
	}

	public String getOuName() {
		return this.ouName;
	}

	public void setOuName(String ouName) {
		this.ouName = ouName;
	}

	public Timestamp getOrderBookedDate() {
		return this.orderBookedDate;
	}

	public void setOrderBookedDate(Timestamp orderBookedDate) {
		this.orderBookedDate = orderBookedDate;
	}

	public String getProductFamily() {
		return this.productFamily;
	}

	public void setProductFamily(String productFamily) {
		this.productFamily = productFamily;
	}

	public String getRevrecAccount() {
		return this.revrecAccount;
	}

	public void setRevrecAccount(String revrecAccount) {
		this.revrecAccount = revrecAccount;
	}

	public String getProductCategory() {
		return this.productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public BigDecimal getOrderedQuantity() {
		return this.orderedQuantity;
	}

	public void setOrderedQuantity(BigDecimal orderedQuantity) {
		this.orderedQuantity = orderedQuantity;
	}

	public String getDa() {
		return this.da;
	}

	public void setDa(String da) {
		this.da = da;
	}

	public Timestamp getContractStartDate() {
		return this.contractStartDate;
	}

	public void setContractStartDate(Timestamp contractStartDate) {
		this.contractStartDate = contractStartDate;
	}

	public Timestamp getContractEndDate() {
		return this.contractEndDate;
	}

	public void setContractEndDate(Timestamp contractEndDate) {
		this.contractEndDate = contractEndDate;
	}

	public Timestamp getRevrecStDate() {
		return this.revrecStDate;
	}

	public void setRevrecStDate(Timestamp revrecStDate) {
		this.revrecStDate = revrecStDate;
	}

	public String getBundleFlag() {
		return this.bundleFlag;
	}

	public void setBundleFlag(String bundleFlag) {
		this.bundleFlag = bundleFlag;
	}

	public BigDecimal getOrderLineId() {
		return orderLineId;
	}

	public void setOrderLineId(BigDecimal orderLineId) {
		this.orderLineId = orderLineId;
	}

	public BigDecimal getRefOrderNumber() {
		return refOrderNumber;
	}

	public void setRefOrderNumber(BigDecimal refOrderNumber) {
		this.refOrderNumber = refOrderNumber;
	}

	public BigDecimal getServiceRefOrder() {
		return serviceRefOrder;
	}

	public void setServiceRefOrder(BigDecimal serviceRefOrder) {
		this.serviceRefOrder = serviceRefOrder;
	}

	public BigDecimal getServiceRefOrdLineNum() {
		return serviceRefOrdLineNum;
	}

	public void setServiceRefOrdLineNum(BigDecimal serviceRefOrdLineNum) {
		this.serviceRefOrdLineNum = serviceRefOrdLineNum;
	}

	public BigDecimal getLineCost() {
		return lineCost;
	}

	public void setLineCost(BigDecimal lineCost) {
		this.lineCost = lineCost;
	}

	public BigDecimal getManufacturingCost() {
		return manufacturingCost;
	}

	public void setManufacturingCost(BigDecimal manufacturingCost) {
		this.manufacturingCost = manufacturingCost;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public BigDecimal getExtendedListAmount() {
		return extendedListAmount;
	}

	public void setExtendedListAmount(BigDecimal extendedListAmount) {
		this.extendedListAmount = extendedListAmount;
	}

	public BigDecimal getExtendedSellingmount() {
		return extendedSellingmount;
	}

	public void setExtendedSellingmount(BigDecimal extendedSellingmount) {
		this.extendedSellingmount = extendedSellingmount;
	}

	public BigDecimal getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(BigDecimal discountPercent) {
		this.discountPercent = discountPercent;
	}

	public String getExtWarrantySku() {
		return extWarrantySku;
	}

	public void setExtWarrantySku(String extWarrantySku) {
		this.extWarrantySku = extWarrantySku;
	}

	public Timestamp getExtServStartDate() {
		return extServStartDate;
	}

	public void setExtServStartDate(Timestamp extServStartDate) {
		this.extServStartDate = extServStartDate;
	}

	public Timestamp getExtServEndDate() {
		return extServEndDate;
	}

	public void setExtServEndDate(Timestamp extServEndDate) {
		this.extServEndDate = extServEndDate;
	}

	public String getExtPeriod() {
		return extPeriod;
	}

	public void setExtPeriod(String extPeriod) {
		this.extPeriod = extPeriod;
	}

	public BigDecimal getExtDuration() {
		return extDuration;
	}

	public void setExtDuration(BigDecimal extDuration) {
		this.extDuration = extDuration;
	}

	public BigDecimal getExtListPrice() {
		return extListPrice;
	}

	public void setExtListPrice(BigDecimal extListPrice) {
		this.extListPrice = extListPrice;
	}

	public BigDecimal getExtDiscount() {
		return extDiscount;
	}

	public void setExtDiscount(BigDecimal extDiscount) {
		this.extDiscount = extDiscount;
	}

	public String getSupportSku() {
		return supportSku;
	}

	public void setSupportSku(String supportSku) {
		this.supportSku = supportSku;
	}

	public Timestamp getSupportServStartDate() {
		return supportServStartDate;
	}

	public void setSupportServStartDate(Timestamp supportServStartDate) {
		this.supportServStartDate = supportServStartDate;
	}

	public Timestamp getSupportServEndDate() {
		return supportServEndDate;
	}

	public void setSupportServEndDate(Timestamp supportServEndDate) {
		this.supportServEndDate = supportServEndDate;
	}

	public String getSupportPeriod() {
		return supportPeriod;
	}

	public void setSupportPeriod(String supportPeriod) {
		this.supportPeriod = supportPeriod;
	}

	public BigDecimal getSupportDuration() {
		return supportDuration;
	}

	public void setSupportDuration(BigDecimal supportDuration) {
		this.supportDuration = supportDuration;
	}

	public BigDecimal getSupportListPrice() {
		return supportListPrice;
	}

	public void setSupportListPrice(BigDecimal supportListPrice) {
		this.supportListPrice = supportListPrice;
	}

	public BigDecimal getSupportDiscount() {
		return supportDiscount;
	}

	public void setSupportDiscount(BigDecimal supportDiscount) {
		this.supportDiscount = supportDiscount;
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
	
	

}