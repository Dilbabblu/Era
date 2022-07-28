package com.forsys.revmantra.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.forsys.revmantra.listener.RmanDealDetailsListener;

@Entity
@EntityListeners(RmanDealDetailsListener.class)
@Table(name = "RMAN_DEAL_DETAILS")
public class RmanDealDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "SHIP_TO_SITE_NUM")
	private BigDecimal shipToSiteNum;

	@Column(name = "FINANCE_CONTACT_ID")
	private BigDecimal financeContactId;

	@Column(name = "ELEMENT_TYPE")
	private String elementType;

	@Column(name = "PRODUCT_ORG_ID")
	private BigDecimal productOrgId;

	@Column(name = "DIRECT_CV_AMOUNT")
	private BigDecimal directCvAmount;

	@Column(name = "PARENT_LINE_NUMBER")
	private BigDecimal parentLineNumber;

	@Column(name = "BILL_TO_COUNTRY")
	private String billToCountry;

	@Column(name = "LINE_ID")
	private BigDecimal lineId;

	@Column(name = "CHANGE_REASON")
	private String changeReason;

	@Column(name = "UNIT_SELLING_PRICE")
	private BigDecimal unitSellingPrice;

	@Column(name = "OPPORTUNITY_NAME")
	private String opportunityName;

	@Column(name = "END_CUSTOMER_NUM")
	private String endCustomerNum;

	@Column(name = "DURATION_UOM")
	private String durationUom;

	@Column(name = "DEAL_NAME")
	private String dealName;

	@Column(name = "ATTRIBUTE3")
	private String attribute3;

	@Column(name = "ATTRIBUTE2")
	private String attribute2;

	@Column(name = "ATTRIBUTE1")
	private String attribute1;

	@Column(name = "SALES_OPS_ID")
	private BigDecimal salesOpsId;

	@Column(name = "FMV_AMOUNT")
	private BigDecimal fmvAmount;

	@Column(name = "DEAL_HEADER_ID")
	private BigDecimal dealHeaderId;

	@Column(name = "ATTRIBUTE9")
	private String attribute9;

	@Column(name = "ATTRIBUTE8")
	private String attribute8;

	@Column(name = "CHILD_SELL_PRICE")
	private BigDecimal childSellPrice;

	@Column(name = "ATTRIBUTE7")
	private String attribute7;

	@Column(name = "ATTRIBUTE6")
	private String attribute6;

	@Column(name = "ATTRIBUTE5")
	private String attribute5;

	@Column(name = "ATTRIBUTE4")
	private String attribute4;

	@Column(name = "DIRECT_CV")
	private String directCv;

	@Column(name = "UOM_CODE")
	private String uomCode;

	@Column(name = "SALES_OPS_NAME")
	private String salesOpsName;

	@Column(name = "AGREEMENT_CODE")
	private String agreementCode;

	@Column(name = "FMV_RULE_DEF_ID")
	private BigDecimal fmvRuleDefId;

	@Column(name = "ATTRIBUTE10")
	private String attribute10;

	@Column(name = "CV_PERCENT")
	private BigDecimal cvPercent;

	@Column(name = "END_CUSTOMER_NAME")
	private String endCustomerName;

	@Column(name = "SERVICE_DURATION_UOM")
	private String serviceDurationUom;

	@Column(name = "FV_PERCENT")
	private BigDecimal fvPercent;

	@Column(name = "ATTRIBUTE14")
	private String attribute14;

	@Column(name = "ATTRIBUTE13")
	private String attribute13;

	@Column(name = "REP_UNIT_SELLING_PRICE")
	private BigDecimal repUnitSellingPrice;

	@Column(name = "ATTRIBUTE12")
	private String attribute12;

	@Column(name = "CUSTOMER_TYPE")
	private String customerType;

	@Column(name = "PARTNER_NAME")
	private String partnerName;

	@Column(name = "ATTRIBUTE11")
	private String attribute11;

	@Column(name = "CONT_APP_QTY")
	private BigDecimal contAppQty;

	@Column(name = "DEAL_TYPE")
	private String dealType;

	@Column(name = "ALLOCATION_AMOUNT")
	private BigDecimal allocationAmount;

	@Column(name = "SALES_CHANNEL")
	private String salesChannel;

	@Column(name = "CONTINGENCY_CODE")
	private String contingencyCode;

	@Column(name = "OPPORTUNITY_NUM")
	private String opportunityNum;

	@Column(name = "DEAL_CURRENCY_CODE")
	private String dealCurrencyCode;

	@Column(name = "CONVERSION_TYPE")
	private String conversionType;

	@Column(name = "DEAL_NUMBER")
	private String dealNumber;

	@Column(name = "DEAL_LINE_NUMBER")
	private BigDecimal dealLineNumber;

	@Column(name = "DEAL_LINE_COST")
	private BigDecimal dealLineCost;

	@Column(name = "PARENT_LINE_ID")
	private BigDecimal parentLineId;

	@Column(name = "EXPECTED_DURATION")
	private BigDecimal expectedDuration;

	@Column(name = "SERVICE_END_DATE")
	private Timestamp serviceEndDate;

	@Column(name = "LAST_UPDATED_DATE")
	private Timestamp lastUpdatedDate;

	@Column(name = "ACCOUNTING_SCOPE")
	private String accountingScope;

	@Column(name = "SHIP_TO_COUNTRY")
	private String shipToCountry;

	@Column(name = "ATTRIBUTE15")
	private String attribute15;

	@Column(name = "SALESREP_NAME")
	private String salesrepName;

	@Column(name = "EITF_SOP")
	private String eitfSop;

	@Column(name = "CONT_TRANS_HEADER_ID")
	private BigDecimal contTransHeaderId;

	@Column(name = "BUNDLE_FLAG")
	private String bundleFlag;

	@Column(name = "QUANTITY")
	private BigDecimal quantity;

	@Column(name = "CREATED_DATE")
	private Timestamp createdDate;

	@Column(name = "PRICE_LIST")
	private String priceList;

	@Column(name = "ANALYST_ID")
	private BigDecimal analystId;

	@Column(name = "BILL_TO_CUSTOMER_NUM")
	private String billToCustomerNum;

	@Column(name = "APPROVER_ID")
	private BigDecimal approverId;

	@Column(name = "BILL_TO_SITE_NUM")
	private BigDecimal billToSiteNum;

	@Column(name = "UNIT_LIST_PRICE")
	private BigDecimal unitListPrice;

	@Column(name = "CV_IN_OUT_AMOUNT")
	private BigDecimal cvInOutAmount;

	@Column(name = "EXPECTED_START_DATE")
	private Timestamp expectedStartDate;

	@Column(name = "ALLOCATION_FLAG")
	private String allocationFlag;

	@Column(name = "CREATED_BY")
	private BigDecimal createdBy;

	@Column(name = "LAST_UPDATED_BY")
	private BigDecimal lastUpdatedBy;

	@Column(name = "LEGAL_ENTITY_ID")
	private BigDecimal legalEntityId;

	@Column(name = "PRODUCT_NAME")
	private String productName;

	@Column(name = "FORECAST_CODE")
	private String forecastCode;

	@Column(name = "DEAL_STATUS")
	private String dealStatus;

	@Column(name = "TRX_CURRENCY_CODE")
	private String trxCurrencyCode;

	@Column(name = "REP_UNIT_LIST_PRICE")
	private BigDecimal repUnitListPrice;

	@Column(name = "CONVERSION_DATE")
	private Timestamp conversionDate;
	
	public BigDecimal getPobId() {
		return pobId;
	}


	public void setPobId(BigDecimal pobId) {
		this.pobId = pobId;
	}


	@Column(name = "POB_ID")
	private BigDecimal pobId;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RMAN_DEAL_DETAILS_seq_gen")
	@SequenceGenerator(name = "RMAN_DEAL_DETAILS_seq_gen", sequenceName = "RMAN_DEAL_LINE_ID_S", allocationSize=1)
	@Column(name = "DEAL_LINE_ID")
	private BigDecimal dealLineId;
	
	@Column(name = "SALES_TERRITORY")
	private String salesTerritory;

	@Column(name = "FINANCE_CONTACT")
	private String financeContact;

	@Column(name = "PAYMENT_TERMS")
	private String paymentTerms;

	@Column(name = "SUB_ELEMENT_TYPE")
	private String subElementType;

	@Column(name = "BUNDLE_PERCENT")
	private BigDecimal bundlePercent;

	@Column(name = "SERVICE_START_DATE")
	private Timestamp serviceStartDate;

	@Column(name = "BILL_TO_CUSTOMER_NAME")
	private String billToCustomerName;

	@Column(name = "REP_CURR_CODE")
	private String repCurrCode;

	@Column(name = "TRX_ALLOC_UNIT_AMT")
	private BigDecimal trxAllocUnitAmt;

	@Column(name = "AGREEMENT_NAME")
	private String agreementName;

	@Column(name = "EXPECTED_SPLIT")
	private BigDecimal expectedSplit;

	@Column(name = "SERVICE_DURATION")
	private BigDecimal serviceDuration;

	@Column(name = "CONVERSION_RATE")
	private BigDecimal conversionRate;

	@Column(name = "ARG_BASIS_LINE_NUMBER")
	private BigDecimal argBasisLineNumber;

	@Column(name = "BESP_PER_UNIT")
	private BigDecimal bespPerUnit;

	@Column(name = "DEAL_ARRANGEMENT_ID")
	private BigDecimal dealArrangementId;

	@Column(name = "AGREEMENT_NUMBER")
	private String agreementNumber;

	@Column(name = "ACCOUNINT_RULE_NAME")
	private String accounintRuleName;

	@Column(name = "CHILD_LIST_PRICE")
	private BigDecimal childListPrice;

	@Column(name = "EXPECTED_END_DATE")
	private Timestamp expectedEndDate;

	@Column(name = "DEAL_DATE")
	private Timestamp dealDate;

	@Column(name = "CONTRACT_START_DATE")
	private Timestamp contractStartDate;

	@Column(name = "CONTRACT_END_DATE")
	private Timestamp contractEndDate;
	
	@Column(name = "EXTENDED_SELLING_AMOUNT")
	private BigDecimal lineAmount;
	

	/**
	 * @OneToOne(fetch = FetchType.EAGER)
	 * 
	 * @JoinColumn(name="END_CUSTOMER_NAME",insertable = false, updatable =
	 * false ) private RmanCustomers rmanCustomers;
	 * 
	 * @OneToOne(fetch = FetchType.EAGER)
	 * 
	 * @JoinColumn(name="BILL_TO_CUSTOMER_NAME",insertable = false, updatable =
	 * false ) private RmanCustomers rmanCustomers1;
	 * 
	 * @OneToOne(fetch = FetchType.EAGER)
	 * 
	 * @JoinColumn(name="PRODUCT_NAME",insertable = false, updatable = false )
	 * private RmanProducts rmanProducts;
	 * 
	 * @OneToOne(fetch = FetchType.EAGER)
	 * 
	 * @JoinColumn(name="PRICE_LIST",insertable = false, updatable = false )
	 * private RmanPriceListHeader rmanPriceListHeader;
	 * 
	 * @OneToOne(fetch = FetchType.EAGER)
	 * 
	 * @JoinColumn(name="ACCOUNINT_RULE_NAME",insertable = false, updatable =
	 * false ) private RmanAccountingRules rmanAccountingRules;
	 */
/**	@JoinColumn(name = "PRODUCT_ORG_ID", insertable = false, updatable = false, referencedColumnName = "PRODUCT_ORG_ID"), */
	
	@ManyToOne
	@JoinColumn(name = "ACCOUNINT_RULE_NAME",referencedColumnName = "TEMPLATE_NAME",updatable = false,insertable = false,nullable = false)
	private RmanRevenueTemplates revenueTemplates;
	
	public RmanRevenueTemplates getRevenueTemplates() {
		return revenueTemplates;
	}

	public void setRevenueTemplates(RmanRevenueTemplates revenueTemplates) {
		this.revenueTemplates = revenueTemplates;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PRODUCT_ID", insertable = false, updatable = false, referencedColumnName = "PRODUCT_ID")
	@NotFound(action = NotFoundAction.IGNORE)
	private RmanProducts rmanproducts;

	
	@Transient
	private String productPortfolio;
	
	@Transient
	private String productFamily;
	
	@Transient
	private String productLine;
	
	@Transient
	private String productDescription;
	
	
	@Transient
	public String getProductPortfolio(){
		return rmanproducts!=null ? (rmanproducts.getAttribute1()!=null ? rmanproducts.getAttribute1() : "") : "";
	}
	

	@Transient
	public String getProductFamily(){
		return rmanproducts!=null ? (rmanproducts.getAttribute2()!=null ? rmanproducts.getAttribute2() : "") : "";
	}
	
	@Transient
	public String getProductLine(){
		return rmanproducts!=null ? (rmanproducts.getAttribute3()!=null ? rmanproducts.getAttribute3() : "") : "";
	}
	
	@Transient
	public String getProductDescription(){
		return rmanproducts!=null ? (rmanproducts.getProductDescription()!=null ? rmanproducts.getProductDescription() : "") : "";
	}
	
	
	@Transient
	private String acctRevRuleName;
	
	@Transient
	private String amortRevRuleName;
	
	@Transient
	public String getAcctRevRuleName(){
		String ruleRevenue = null;
		if(revenueTemplates != null) {
			ruleRevenue = revenueTemplates.getAccRuleRevenue() != null ? revenueTemplates.getAccRuleRevenue() : null;
		}
		if(ruleRevenue == null || ruleRevenue.isEmpty()) {
			ruleRevenue =  rmanproducts != null ? (rmanproducts.getRmanRevenueTemplates()!=null ?
					(rmanproducts.getRmanRevenueTemplates().getAccRuleRevenue()!=null ?
							rmanproducts.getRmanRevenueTemplates().getAccRuleRevenue() : null) : null):null;
			
		}
		return ruleRevenue;
		
		/**
		 * return rmanproducts!=null ? (rmanproducts.getRmanRevenueTemplates()!=null ?
		 * (rmanproducts.getRmanRevenueTemplates().getAccRuleRevenue()!=null ?
		 * rmanproducts.getRmanRevenueTemplates().getAccRuleRevenue() : "") : ""):"";
		 */
	}
	
	@Transient
	public String getAmortRevRuleName(){
		String amortRuleRevenue = null;
		if(revenueTemplates != null) {
			amortRuleRevenue = revenueTemplates.getRmanLookupsV6() != null ? revenueTemplates.getRmanLookupsV6().getLookupDescription() : null;
		}
		if(amortRuleRevenue == null || amortRuleRevenue.isEmpty()) {
			amortRuleRevenue =  rmanproducts!=null ? (rmanproducts.getRmanRevenueTemplates()!=null ? 
					(rmanproducts.getRmanRevenueTemplates().getRmanLookupsV6()!=null ? 
							(rmanproducts.getRmanRevenueTemplates().getRmanLookupsV6().getLookupDescription()!=null ? rmanproducts.getRmanRevenueTemplates().getRmanLookupsV6().getLookupDescription(): null) 
							: null) : null) : null; 
		}
		return amortRuleRevenue;
	}

	
	
	public BigDecimal getLineAmount() {
		return lineAmount;
	}
	
	public void setLineAmount(BigDecimal lineAmount) {
		this.lineAmount = lineAmount;
	}

	public RmanProducts getRmanproducts() {
		return rmanproducts;
	}

	public void setRmanproducts(RmanProducts rmanproducts) {
		this.rmanproducts = rmanproducts;
	}

	public BigDecimal getShipToSiteNum() {
		return this.shipToSiteNum;
	}

	public void setShipToSiteNum(BigDecimal shipToSiteNum) {
		this.shipToSiteNum = shipToSiteNum;
	}

	public BigDecimal getFinanceContactId() {
		return this.financeContactId;
	}

	public void setFinanceContactId(BigDecimal financeContactId) {
		this.financeContactId = financeContactId;
	}

	public String getElementType() {
		return this.elementType;
	}

	public void setElementType(String elementType) {
		this.elementType = elementType;
	}

	public BigDecimal getProductOrgId() {
		return this.productOrgId;
	}

	public void setProductOrgId(BigDecimal productOrgId) {
		this.productOrgId = productOrgId;
	}

	public BigDecimal getDirectCvAmount() {
		return this.directCvAmount;
	}

	public void setDirectCvAmount(BigDecimal directCvAmount) {
		this.directCvAmount = directCvAmount;
	}

	public BigDecimal getParentLineNumber() {
		return this.parentLineNumber;
	}

	public void setParentLineNumber(BigDecimal parentLineNumber) {
		this.parentLineNumber = parentLineNumber;
	}

	public String getBillToCountry() {
		return this.billToCountry;
	}

	public void setBillToCountry(String billToCountry) {
		this.billToCountry = billToCountry;
	}

	public BigDecimal getLineId() {
		return this.lineId;
	}

	public void setLineId(BigDecimal lineId) {
		this.lineId = lineId;
	}

	public String getChangeReason() {
		return this.changeReason;
	}

	public void setChangeReason(String changeReason) {
		this.changeReason = changeReason;
	}

	public BigDecimal getUnitSellingPrice() {
		return this.unitSellingPrice;
	}

	public void setUnitSellingPrice(BigDecimal unitSellingPrice) {
		this.unitSellingPrice = unitSellingPrice;
	}

	public String getOpportunityName() {
		return this.opportunityName;
	}

	public void setOpportunityName(String opportunityName) {
		this.opportunityName = opportunityName;
	}

	public String getEndCustomerNum() {
		return this.endCustomerNum;
	}

	public void setEndCustomerNum(String endCustomerNum) {
		this.endCustomerNum = endCustomerNum;
	}

	public String getDurationUom() {
		return this.durationUom;
	}

	public void setDurationUom(String durationUom) {
		this.durationUom = durationUom;
	}

	public String getDealName() {
		return this.dealName;
	}

	public void setDealName(String dealName) {
		this.dealName = dealName;
	}

	public String getAttribute3() {
		return this.attribute3;
	}

	public void setAttribute3(String attribute3) {
		this.attribute3 = attribute3;
	}

	public String getAttribute2() {
		return this.attribute2;
	}

	public void setAttribute2(String attribute2) {
		this.attribute2 = attribute2;
	}

	public String getAttribute1() {
		return this.attribute1;
	}

	public void setAttribute1(String attribute1) {
		this.attribute1 = attribute1;
	}

	public BigDecimal getSalesOpsId() {
		return this.salesOpsId;
	}

	public void setSalesOpsId(BigDecimal salesOpsId) {
		this.salesOpsId = salesOpsId;
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

	public String getAttribute9() {
		return this.attribute9;
	}

	public void setAttribute9(String attribute9) {
		this.attribute9 = attribute9;
	}

	public String getAttribute8() {
		return this.attribute8;
	}

	public void setAttribute8(String attribute8) {
		this.attribute8 = attribute8;
	}

	public BigDecimal getChildSellPrice() {
		return this.childSellPrice;
	}

	public void setChildSellPrice(BigDecimal childSellPrice) {
		this.childSellPrice = childSellPrice;
	}

	public String getAttribute7() {
		return this.attribute7;
	}

	public void setAttribute7(String attribute7) {
		this.attribute7 = attribute7;
	}

	public String getAttribute6() {
		return this.attribute6;
	}

	public void setAttribute6(String attribute6) {
		this.attribute6 = attribute6;
	}

	public String getAttribute5() {
		return this.attribute5;
	}

	public void setAttribute5(String attribute5) {
		this.attribute5 = attribute5;
	}

	public String getAttribute4() {
		return this.attribute4;
	}

	public void setAttribute4(String attribute4) {
		this.attribute4 = attribute4;
	}

	public String getDirectCv() {
		return this.directCv;
	}

	public void setDirectCv(String directCv) {
		this.directCv = directCv;
	}

	public String getUomCode() {
		return this.uomCode;
	}

	public void setUomCode(String uomCode) {
		this.uomCode = uomCode;
	}

	public String getSalesOpsName() {
		return this.salesOpsName;
	}

	public void setSalesOpsName(String salesOpsName) {
		this.salesOpsName = salesOpsName;
	}

	public String getAgreementCode() {
		return this.agreementCode;
	}

	public void setAgreementCode(String agreementCode) {
		this.agreementCode = agreementCode;
	}

	public BigDecimal getFmvRuleDefId() {
		return this.fmvRuleDefId;
	}

	public void setFmvRuleDefId(BigDecimal fmvRuleDefId) {
		this.fmvRuleDefId = fmvRuleDefId;
	}

	public String getAttribute10() {
		return this.attribute10;
	}

	public void setAttribute10(String attribute10) {
		this.attribute10 = attribute10;
	}

	public BigDecimal getCvPercent() {
		return this.cvPercent;
	}

	public void setCvPercent(BigDecimal cvPercent) {
		this.cvPercent = cvPercent;
	}

	public String getEndCustomerName() {
		return this.endCustomerName;
	}

	public void setEndCustomerName(String endCustomerName) {
		this.endCustomerName = endCustomerName;
	}

	public String getServiceDurationUom() {
		return this.serviceDurationUom;
	}

	public void setServiceDurationUom(String serviceDurationUom) {
		this.serviceDurationUom = serviceDurationUom;
	}

	public BigDecimal getFvPercent() {
		return this.fvPercent;
	}

	public void setFvPercent(BigDecimal fvPercent) {
		this.fvPercent = fvPercent;
	}

	public String getAttribute14() {
		return this.attribute14;
	}

	public void setAttribute14(String attribute14) {
		this.attribute14 = attribute14;
	}

	public String getAttribute13() {
		return this.attribute13;
	}

	public void setAttribute13(String attribute13) {
		this.attribute13 = attribute13;
	}

	public BigDecimal getRepUnitSellingPrice() {
		return this.repUnitSellingPrice;
	}

	public void setRepUnitSellingPrice(BigDecimal repUnitSellingPrice) {
		this.repUnitSellingPrice = repUnitSellingPrice;
	}

	public String getAttribute12() {
		return this.attribute12;
	}

	public void setAttribute12(String attribute12) {
		this.attribute12 = attribute12;
	}

	public String getCustomerType() {
		return this.customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public String getPartnerName() {
		return this.partnerName;
	}

	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}

	public String getAttribute11() {
		return this.attribute11;
	}

	public void setAttribute11(String attribute11) {
		this.attribute11 = attribute11;
	}

	public BigDecimal getContAppQty() {
		return this.contAppQty;
	}

	public void setContAppQty(BigDecimal contAppQty) {
		this.contAppQty = contAppQty;
	}

	public String getDealType() {
		return this.dealType;
	}

	public void setDealType(String dealType) {
		this.dealType = dealType;
	}

	public BigDecimal getAllocationAmount() {
		return this.allocationAmount;
	}

	public void setAllocationAmount(BigDecimal allocationAmount) {
		this.allocationAmount = allocationAmount;
	}

	public String getSalesChannel() {
		return this.salesChannel;
	}

	public void setSalesChannel(String salesChannel) {
		this.salesChannel = salesChannel;
	}

	public String getContingencyCode() {
		return this.contingencyCode;
	}

	public void setContingencyCode(String contingencyCode) {
		this.contingencyCode = contingencyCode;
	}

	public String getOpportunityNum() {
		return this.opportunityNum;
	}

	public void setOpportunityNum(String opportunityNum) {
		this.opportunityNum = opportunityNum;
	}

	public String getDealCurrencyCode() {
		return this.dealCurrencyCode;
	}

	public void setDealCurrencyCode(String dealCurrencyCode) {
		this.dealCurrencyCode = dealCurrencyCode;
	}

	public String getConversionType() {
		return this.conversionType;
	}

	public void setConversionType(String conversionType) {
		this.conversionType = conversionType;
	}

	public String getDealNumber() {
		return this.dealNumber;
	}

	public void setDealNumber(String dealNumber) {
		this.dealNumber = dealNumber;
	}

	public BigDecimal getDealLineNumber() {
		return this.dealLineNumber;
	}

	public void setDealLineNumber(BigDecimal dealLineNumber) {
		this.dealLineNumber = dealLineNumber;
	}

	public BigDecimal getDealLineCost() {
		return this.dealLineCost;
	}

	public void setDealLineCost(BigDecimal dealLineCost) {
		this.dealLineCost = dealLineCost;
	}

	public BigDecimal getParentLineId() {
		return this.parentLineId;
	}

	public void setParentLineId(BigDecimal parentLineId) {
		this.parentLineId = parentLineId;
	}

	public BigDecimal getExpectedDuration() {
		return this.expectedDuration;
	}

	public void setExpectedDuration(BigDecimal expectedDuration) {
		this.expectedDuration = expectedDuration;
	}

	public Timestamp getServiceEndDate() {
		return this.serviceEndDate;
	}

	public void setServiceEndDate(Timestamp serviceEndDate) {
		this.serviceEndDate = serviceEndDate;
	}

	public Timestamp getLastUpdatedDate() {
		return this.lastUpdatedDate;
	}

	public void setLastUpdatedDate(Timestamp lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getAccountingScope() {
		return this.accountingScope;
	}

	public void setAccountingScope(String accountingScope) {
		this.accountingScope = accountingScope;
	}

	public String getShipToCountry() {
		return this.shipToCountry;
	}

	public void setShipToCountry(String shipToCountry) {
		this.shipToCountry = shipToCountry;
	}

	public String getAttribute15() {
		return this.attribute15;
	}

	public void setAttribute15(String attribute15) {
		this.attribute15 = attribute15;
	}

	public String getSalesrepName() {
		return this.salesrepName;
	}

	public void setSalesrepName(String salesrepName) {
		this.salesrepName = salesrepName;
	}

	public String getEitfSop() {
		return this.eitfSop;
	}

	public void setEitfSop(String eitfSop) {
		this.eitfSop = eitfSop;
	}

	public BigDecimal getContTransHeaderId() {
		return this.contTransHeaderId;
	}

	public void setContTransHeaderId(BigDecimal contTransHeaderId) {
		this.contTransHeaderId = contTransHeaderId;
	}

	public String getBundleFlag() {
		return this.bundleFlag;
	}

	public void setBundleFlag(String bundleFlag) {
		this.bundleFlag = bundleFlag;
	}

	public BigDecimal getQuantity() {
		return this.quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public Timestamp getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getPriceList() {
		return this.priceList;
	}

	public void setPriceList(String priceList) {
		this.priceList = priceList;
	}

	public BigDecimal getAnalystId() {
		return this.analystId;
	}

	public void setAnalystId(BigDecimal analystId) {
		this.analystId = analystId;
	}

	public String getBillToCustomerNum() {
		return this.billToCustomerNum;
	}

	public void setBillToCustomerNum(String billToCustomerNum) {
		this.billToCustomerNum = billToCustomerNum;
	}

	public BigDecimal getApproverId() {
		return this.approverId;
	}

	public void setApproverId(BigDecimal approverId) {
		this.approverId = approverId;
	}

	public BigDecimal getBillToSiteNum() {
		return this.billToSiteNum;
	}

	public void setBillToSiteNum(BigDecimal billToSiteNum) {
		this.billToSiteNum = billToSiteNum;
	}

	public BigDecimal getUnitListPrice() {
		return this.unitListPrice;
	}

	public void setUnitListPrice(BigDecimal unitListPrice) {
		this.unitListPrice = unitListPrice;
	}

	public BigDecimal getCvInOutAmount() {
		return this.cvInOutAmount;
	}

	public void setCvInOutAmount(BigDecimal cvInOutAmount) {
		this.cvInOutAmount = cvInOutAmount;
	}

	public Timestamp getExpectedStartDate() {
		return this.expectedStartDate;
	}

	public void setExpectedStartDate(Timestamp expectedStartDate) {
		this.expectedStartDate = expectedStartDate;
	}

	public String getAllocationFlag() {
		return this.allocationFlag;
	}

	public void setAllocationFlag(String allocationFlag) {
		this.allocationFlag = allocationFlag;
	}

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

	public BigDecimal getLegalEntityId() {
		return this.legalEntityId;
	}

	public void setLegalEntityId(BigDecimal legalEntityId) {
		this.legalEntityId = legalEntityId;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getForecastCode() {
		return this.forecastCode;
	}

	public void setForecastCode(String forecastCode) {
		this.forecastCode = forecastCode;
	}

	public String getDealStatus() {
		return this.dealStatus;
	}

	public void setDealStatus(String dealStatus) {
		this.dealStatus = dealStatus;
	}

	public String getTrxCurrencyCode() {
		return this.trxCurrencyCode;
	}

	public void setTrxCurrencyCode(String trxCurrencyCode) {
		this.trxCurrencyCode = trxCurrencyCode;
	}

	public BigDecimal getRepUnitListPrice() {
		return this.repUnitListPrice;
	}

	public void setRepUnitListPrice(BigDecimal repUnitListPrice) {
		this.repUnitListPrice = repUnitListPrice;
	}

	public Timestamp getConversionDate() {
		return this.conversionDate;
	}

	public void setConversionDate(Timestamp conversionDate) {
		this.conversionDate = conversionDate;
	}

	public BigDecimal getDealLineId() {
		return this.dealLineId;
	}

	public void setDealLineId(BigDecimal dealLineId) {
		this.dealLineId = dealLineId;
	}

	public String getSalesTerritory() {
		return this.salesTerritory;
	}

	public void setSalesTerritory(String salesTerritory) {
		this.salesTerritory = salesTerritory;
	}

	public String getFinanceContact() {
		return this.financeContact;
	}

	public void setFinanceContact(String financeContact) {
		this.financeContact = financeContact;
	}

	public String getPaymentTerms() {
		return this.paymentTerms;
	}

	public void setPaymentTerms(String paymentTerms) {
		this.paymentTerms = paymentTerms;
	}

	public String getSubElementType() {
		return this.subElementType;
	}

	public void setSubElementType(String subElementType) {
		this.subElementType = subElementType;
	}

	public BigDecimal getBundlePercent() {
		return this.bundlePercent;
	}

	public void setBundlePercent(BigDecimal bundlePercent) {
		this.bundlePercent = bundlePercent;
	}

	public Timestamp getServiceStartDate() {
		return this.serviceStartDate;
	}

	public void setServiceStartDate(Timestamp serviceStartDate) {
		this.serviceStartDate = serviceStartDate;
	}

	public String getBillToCustomerName() {
		return this.billToCustomerName;
	}

	public void setBillToCustomerName(String billToCustomerName) {
		this.billToCustomerName = billToCustomerName;
	}

	public String getRepCurrCode() {
		return this.repCurrCode;
	}

	public void setRepCurrCode(String repCurrCode) {
		this.repCurrCode = repCurrCode;
	}

	public BigDecimal getTrxAllocUnitAmt() {
		return this.trxAllocUnitAmt;
	}

	public void setTrxAllocUnitAmt(BigDecimal trxAllocUnitAmt) {
		this.trxAllocUnitAmt = trxAllocUnitAmt;
	}

	public String getAgreementName() {
		return this.agreementName;
	}

	public void setAgreementName(String agreementName) {
		this.agreementName = agreementName;
	}

	public BigDecimal getExpectedSplit() {
		return this.expectedSplit;
	}

	public void setExpectedSplit(BigDecimal expectedSplit) {
		this.expectedSplit = expectedSplit;
	}

	public BigDecimal getServiceDuration() {
		return this.serviceDuration;
	}

	public void setServiceDuration(BigDecimal serviceDuration) {
		this.serviceDuration = serviceDuration;
	}

	public BigDecimal getConversionRate() {
		return this.conversionRate;
	}

	public void setConversionRate(BigDecimal conversionRate) {
		this.conversionRate = conversionRate;
	}

	public BigDecimal getArgBasisLineNumber() {
		return this.argBasisLineNumber;
	}

	public void setArgBasisLineNumber(BigDecimal argBasisLineNumber) {
		this.argBasisLineNumber = argBasisLineNumber;
	}

	public BigDecimal getBespPerUnit() {
		return this.bespPerUnit;
	}

	public void setBespPerUnit(BigDecimal bespPerUnit) {
		this.bespPerUnit = bespPerUnit;
	}

	public BigDecimal getDealArrangementId() {
		return this.dealArrangementId;
	}

	public void setDealArrangementId(BigDecimal dealArrangementId) {
		this.dealArrangementId = dealArrangementId;
	}

	public String getAgreementNumber() {
		return this.agreementNumber;
	}

	public void setAgreementNumber(String agreementNumber) {
		this.agreementNumber = agreementNumber;
	}

	public String getAccounintRuleName() {
		return this.accounintRuleName;
	}

	public void setAccounintRuleName(String accounintRuleName) {
		this.accounintRuleName = accounintRuleName;
	}

	public BigDecimal getChildListPrice() {
		return this.childListPrice;
	}

	public void setChildListPrice(BigDecimal childListPrice) {
		this.childListPrice = childListPrice;
	}

	public Timestamp getExpectedEndDate() {
		return this.expectedEndDate;
	}

	public void setExpectedEndDate(Timestamp expectedEndDate) {
		this.expectedEndDate = expectedEndDate;
	}

	public Timestamp getDealDate() {
		return this.dealDate;
	}

	public void setDealDate(Timestamp dealDate) {
		this.dealDate = dealDate;
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
	/**
	 * public RmanCustomers getRmanCustomers() { return rmanCustomers; }
	 * 
	 * public void setRmanCustomers(RmanCustomers rmanCustomers) {
	 * this.rmanCustomers=rmanCustomers; }
	 * 
	 * public RmanCustomers getRmanCustomers1() { return rmanCustomers1; }
	 * 
	 * public void setRmanCustomers1(RmanCustomers rmanCustomers1) {
	 * this.rmanCustomers1=rmanCustomers1; }
	 * 
	 * public RmanProducts getRmanProducts() { return rmanProducts; }
	 * 
	 * public void setRmanProducts(RmanProducts rmanProducts) {
	 * this.rmanProducts=rmanProducts; }
	 * 
	 * public RmanPriceListHeader getRmanPriceListHeader() { return
	 * rmanPriceListHeader; }
	 * 
	 * public void setRmanPriceListHeader(RmanPriceListHeader
	 * rmanPriceListHeader) { this.rmanPriceListHeader=rmanPriceListHeader; }
	 * 
	 * public RmanAccountingRules getRmanAccountingRules() { return
	 * rmanAccountingRules; }
	 * 
	 * public void setRmanAccountingRules(RmanAccountingRules
	 * rmanAccountingRules) { this.rmanAccountingRules=rmanAccountingRules; }
	 * 
	 * 
	 */
}