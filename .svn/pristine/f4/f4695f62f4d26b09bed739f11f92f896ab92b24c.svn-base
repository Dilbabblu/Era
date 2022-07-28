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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.forsys.revmantra.listener.RmanProductsListener;

@Entity
@EntityListeners(RmanProductsListener.class)
@Table(name = "RMAN_PRODUCTS")
public class RmanProducts implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "ATTRIBUTE30")
	private String attribute30;

	@Column(name = "END_DATE")
	private Timestamp endDate;

	@Column(name = "ELEMENT_TYPE")
	private String elementType;

	@Column(name = "LAST_UPDATE_DATE")
	private Timestamp lastUpdateDate;

	@Column(name = "PRODUCT_ORG_ID")
	private BigDecimal productOrgId;

	@Column(name = "PRODUCT_DESCRIPTION")
	private String productDescription;

	@Column(name = "ATTRIBUTE29")
	private String attribute29;

	@Column(name = "ATTRIBUTE28")
	private String attribute28;

	@Column(name = "ALLOCATION_FLAG")
	private String allocationFlag;

	@Column(name = "ATTRIBUTE27")
	private String attribute27;

	@Column(name = "ATTRIBUTE26")
	private String attribute26;

	@Column(name = "ALLOW_REVREC_WO_INVOICE")
	private String allowRevrecWoInvoice;

	@Column(name = "ATTRIBUTE3")
	private String attribute3;

	@Column(name = "CREATED_BY")
	private BigDecimal createdBy;

	@Column(name = "ATTRIBUTE2")
	private String attribute2;

	@Column(name = "LAST_UPDATED_BY")
	private BigDecimal lastUpdatedBy;

	@Column(name = "PRODUCT_ORG_NAME")
	private String productOrgName;

	@Column(name = "ATTRIBUTE1")
	private String attribute1;

	@Column(name = "REV_ACCOUNT_ID")
	private BigDecimal revAccountId;

	@Column(name = "CREATION_DATE")
	private Timestamp creationDate;

	@Column(name = "ATTRIBUTE9")
	private String attribute9;

	@Column(name = "SHIPPABLE_FLAG")
	private String shippableFlag;

	@Column(name = "ATTRIBUTE8")
	private String attribute8;

	@Column(name = "PRODUCT_NAME")
	private String productName;

	@Column(name = "ATTRIBUTE7")
	private String attribute7;

	@Column(name = "INVOICE_ENABLED_FLAG")
	private String invoiceEnabledFlag;

	@Column(name = "ATTRIBUTE6")
	private String attribute6;

	@Column(name = "ATTRIBUTE5")
	private String attribute5;

	@Column(name = "ATTRIBUTE4")
	private String attribute4;

	@Column(name = "DIRECT_CV")
	private String directCv;

	@Column(name = "PRODUCT_STATUS")
	private String productStatus;

	@Column(name = "RESIDUAL_VALUE")
	private String residualValue;

	@Column(name = "SOURCE")
	private String source;

	@Column(name = "ATTRIBUTE10")
	private String attribute10;

	@Column(name = "CV_PERCENT")
	private BigDecimal cvPercent;

	@Column(name = "SOURCE_PRODUCT_ID")
	private BigDecimal sourceProductId;

	@Column(name = "REVREC_TYPE")
	private String revrecType;

	@Column(name = "ATTRIBUTE14")
	private String attribute14;

	@Column(name = "ATTRIBUTE13")
	private String attribute13;

	@Column(name = "ATTRIBUTE12")
	private String attribute12;

	@Column(name = "ATTRIBUTE11")
	private String attribute11;

	@Column(name = "ACCT_RULE_NAME")
	private String acctRuleName;

	@Column(name = "PRODUCT_REV_ACCOUNT")
	private String productRevAccount;

	@Column(name = "PRODUCT_COGS_ACCOUNT")
	private String productCogsAccount;

	@Column(name = "PRODUCT_ORG_CODE")
	private String productOrgCode;

	@Column(name = "ATTRIBUTE21")
	private String attribute21;

	@Column(name = "COGS_ACCOUNT_ID")
	private BigDecimal cogsAccountId;

	@Column(name = "ATTRIBUTE20")
	private String attribute20;

	@Column(name = "ATTRIBUTE25")
	private String attribute25;

	@Column(name = "ATTRIBUTE24")
	private String attribute24;

	@Column(name = "FV_OPTIONAL")
	private String fvOptional;

	@Column(name = "ATTRIBUTE23")
	private String attribute23;

	@Column(name = "ATTRIBUTE22")
	private String attribute22;

	@Column(name = "START_DATE")
	private Timestamp startDate;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RMAN_PRODUCTS_seq_gen")
	@SequenceGenerator(name = "RMAN_PRODUCTS_seq_gen", sequenceName = "RMAN_PRODUCTS_S", allocationSize=1)
	@Column(name = "PRODUCT_ID")
	private BigDecimal productId;

	@Column(name = "REVENUE_TEMPLATE_ID")
	private BigDecimal revenueTemplateId;

	@Column(name = "PRODUCT_COST")
	private BigDecimal productCost;

	@Column(name = "PRODUCT_TYPE")
	private String productType;

	@Column(name = "UOM")
	private String uom;

	@Column(name = "ATTRIBUTE18")
	private String attribute18;

	@Column(name = "ATTRIBUTE17")
	private String attribute17;

	@Column(name = "REVENUE_CATEGORY")
	private String revenueCategory;

	@Column(name = "ATTRIBUTE16")
	private String attribute16;

	@Column(name = "ATTRIBUTE15")
	private String attribute15;

	@Column(name = "ATTRIBUTE19")
	private String attribute19;

	@Column(name = "BUNDLE_FLAG")
	private String bundleFlag;

	@Column(name = "INVOICING_RULE")
	private String invoicingRule;

	public String getInvoicingRule() {
		return invoicingRule;
	}

	public void setInvoicingRule(String invoicingRule) {
		this.invoicingRule = invoicingRule;
	}

	/**
	 * @OneToOne(fetch = FetchType.EAGER)
	 * 
	 * @JoinColumn(name="PRODUCT_ORG_NAME",insertable = false, updatable = false
	 * ) private RmanLegalEntities rmanLegalEntities;
	 */
	/**
	 * @OneToOne(fetch = FetchType.EAGER)
	 * 
	 * @JoinColumn(name = "ALLOCATION_FLAG", insertable = false, updatable =
	 * false) private RmanLookupsV rmanLookupsV;
	 * 
	 * @OneToOne(fetch = FetchType.EAGER)
	 * 
	 * @JoinColumn(name = "INVOICE_ENABLED_FLAG", insertable = false, updatable
	 * = false) private RmanLookupsV rmanLookupsV1;
	 */

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "REVENUE_TEMPLATE_ID", insertable = false, updatable = false)
	@NotFound(action = NotFoundAction.IGNORE)
	private RmanRevenueTemplates rmanRevenueTemplates;

	public RmanRevenueTemplates getRmanRevenueTemplates() {
		return rmanRevenueTemplates;
	}

	public void setRmanRevenueTemplates(RmanRevenueTemplates rmanRevenueTemplates) {
		this.rmanRevenueTemplates = rmanRevenueTemplates;
	}

	public String getAttribute30() {
		return this.attribute30;
	}

	public void setAttribute30(String attribute30) {
		this.attribute30 = attribute30;
	}

	public Timestamp getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public String getElementType() {
		return this.elementType;
	}

	public void setElementType(String elementType) {
		this.elementType = elementType;
	}

	public Timestamp getLastUpdateDate() {
		return this.lastUpdateDate;
	}

	public void setLastUpdateDate(Timestamp lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public BigDecimal getProductOrgId() {
		return this.productOrgId;
	}

	public void setProductOrgId(BigDecimal productOrgId) {
		this.productOrgId = productOrgId;
	}

	public String getProductDescription() {
		return this.productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getAttribute29() {
		return this.attribute29;
	}

	public void setAttribute29(String attribute29) {
		this.attribute29 = attribute29;
	}

	public String getAttribute28() {
		return this.attribute28;
	}

	public void setAttribute28(String attribute28) {
		this.attribute28 = attribute28;
	}

	public String getAllocationFlag() {
		return this.allocationFlag;
	}

	public void setAllocationFlag(String allocationFlag) {
		this.allocationFlag = allocationFlag;
	}

	public String getAttribute27() {
		return this.attribute27;
	}

	public void setAttribute27(String attribute27) {
		this.attribute27 = attribute27;
	}

	public String getAttribute26() {
		return this.attribute26;
	}

	public void setAttribute26(String attribute26) {
		this.attribute26 = attribute26;
	}

	public String getAllowRevrecWoInvoice() {
		return this.allowRevrecWoInvoice;
	}

	public void setAllowRevrecWoInvoice(String allowRevrecWoInvoice) {
		this.allowRevrecWoInvoice = allowRevrecWoInvoice;
	}

	public String getAttribute3() {
		return this.attribute3;
	}

	public void setAttribute3(String attribute3) {
		this.attribute3 = attribute3;
	}

	public BigDecimal getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(BigDecimal createdBy) {
		this.createdBy = createdBy;
	}

	public String getAttribute2() {
		return this.attribute2;
	}

	public void setAttribute2(String attribute2) {
		this.attribute2 = attribute2;
	}

	public BigDecimal getLastUpdatedBy() {
		return this.lastUpdatedBy;
	}

	public void setLastUpdatedBy(BigDecimal lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public String getProductOrgName() {
		return this.productOrgName;
	}

	public void setProductOrgName(String productOrgName) {
		this.productOrgName = productOrgName;
	}

	public String getAttribute1() {
		return this.attribute1;
	}

	public void setAttribute1(String attribute1) {
		this.attribute1 = attribute1;
	}

	public BigDecimal getRevAccountId() {
		return this.revAccountId;
	}

	public void setRevAccountId(BigDecimal revAccountId) {
		this.revAccountId = revAccountId;
	}

	public Timestamp getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public String getAttribute9() {
		return this.attribute9;
	}

	public void setAttribute9(String attribute9) {
		this.attribute9 = attribute9;
	}

	public String getShippableFlag() {
		return this.shippableFlag;
	}

	public void setShippableFlag(String shippableFlag) {
		this.shippableFlag = shippableFlag;
	}

	public String getAttribute8() {
		return this.attribute8;
	}

	public void setAttribute8(String attribute8) {
		this.attribute8 = attribute8;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getAttribute7() {
		return this.attribute7;
	}

	public void setAttribute7(String attribute7) {
		this.attribute7 = attribute7;
	}

	public String getInvoiceEnabledFlag() {
		return this.invoiceEnabledFlag;
	}

	public void setInvoiceEnabledFlag(String invoiceEnabledFlag) {
		this.invoiceEnabledFlag = invoiceEnabledFlag;
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

	public String getProductStatus() {
		return this.productStatus;
	}

	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}

	public String getResidualValue() {
		return this.residualValue;
	}

	public void setResidualValue(String residualValue) {
		this.residualValue = residualValue;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
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

	public BigDecimal getSourceProductId() {
		return this.sourceProductId;
	}

	public void setSourceProductId(BigDecimal sourceProductId) {
		this.sourceProductId = sourceProductId;
	}

	public String getRevrecType() {
		return this.revrecType;
	}

	public void setRevrecType(String revrecType) {
		this.revrecType = revrecType;
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

	public String getAttribute12() {
		return this.attribute12;
	}

	public void setAttribute12(String attribute12) {
		this.attribute12 = attribute12;
	}

	public String getAttribute11() {
		return this.attribute11;
	}

	public void setAttribute11(String attribute11) {
		this.attribute11 = attribute11;
	}

	public String getAcctRuleName() {
		return this.acctRuleName;
	}

	public void setAcctRuleName(String acctRuleName) {
		this.acctRuleName = acctRuleName;
	}

	public String getProductRevAccount() {
		return this.productRevAccount;
	}

	public void setProductRevAccount(String productRevAccount) {
		this.productRevAccount = productRevAccount;
	}

	public String getProductCogsAccount() {
		return this.productCogsAccount;
	}

	public void setProductCogsAccount(String productCogsAccount) {
		this.productCogsAccount = productCogsAccount;
	}

	public String getProductOrgCode() {
		return this.productOrgCode;
	}

	public void setProductOrgCode(String productOrgCode) {
		this.productOrgCode = productOrgCode;
	}

	public String getAttribute21() {
		return this.attribute21;
	}

	public void setAttribute21(String attribute21) {
		this.attribute21 = attribute21;
	}

	public BigDecimal getCogsAccountId() {
		return this.cogsAccountId;
	}

	public void setCogsAccountId(BigDecimal cogsAccountId) {
		this.cogsAccountId = cogsAccountId;
	}

	public String getAttribute20() {
		return this.attribute20;
	}

	public void setAttribute20(String attribute20) {
		this.attribute20 = attribute20;
	}

	public String getAttribute25() {
		return this.attribute25;
	}

	public void setAttribute25(String attribute25) {
		this.attribute25 = attribute25;
	}

	public String getAttribute24() {
		return this.attribute24;
	}

	public void setAttribute24(String attribute24) {
		this.attribute24 = attribute24;
	}

	public String getFvOptional() {
		return this.fvOptional;
	}

	public void setFvOptional(String fvOptional) {
		this.fvOptional = fvOptional;
	}

	public String getAttribute23() {
		return this.attribute23;
	}

	public void setAttribute23(String attribute23) {
		this.attribute23 = attribute23;
	}

	public String getAttribute22() {
		return this.attribute22;
	}

	public void setAttribute22(String attribute22) {
		this.attribute22 = attribute22;
	}

	public Timestamp getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public BigDecimal getProductId() {
		return this.productId;
	}

	public void setProductId(BigDecimal productId) {
		this.productId = productId;
	}

	public BigDecimal getRevenueTemplateId() {
		return this.revenueTemplateId;
	}

	public void setRevenueTemplateId(BigDecimal revenueTemplateId) {
		this.revenueTemplateId = revenueTemplateId;
	}

	public BigDecimal getProductCost() {
		return this.productCost;
	}

	public void setProductCost(BigDecimal productCost) {
		this.productCost = productCost;
	}

	public String getProductType() {
		return this.productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getUom() {
		return this.uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public String getAttribute18() {
		return this.attribute18;
	}

	public void setAttribute18(String attribute18) {
		this.attribute18 = attribute18;
	}

	public String getAttribute17() {
		return this.attribute17;
	}

	public void setAttribute17(String attribute17) {
		this.attribute17 = attribute17;
	}

	public String getRevenueCategory() {
		return this.revenueCategory;
	}

	public void setRevenueCategory(String revenueCategory) {
		this.revenueCategory = revenueCategory;
	}

	public String getAttribute16() {
		return this.attribute16;
	}

	public void setAttribute16(String attribute16) {
		this.attribute16 = attribute16;
	}

	public String getAttribute15() {
		return this.attribute15;
	}

	public void setAttribute15(String attribute15) {
		this.attribute15 = attribute15;
	}

	public String getAttribute19() {
		return this.attribute19;
	}

	public void setAttribute19(String attribute19) {
		this.attribute19 = attribute19;
	}

	public String getBundleFlag() {
		return this.bundleFlag;
	}

	public void setBundleFlag(String bundleFlag) {
		this.bundleFlag = bundleFlag;
	}

	/**
	 * public RmanLookupsV getRmanLookupsV() { return rmanLookupsV; }
	 * 
	 * public void setRmanLookupsV(RmanLookupsV rmanLookupsV) {
	 * this.rmanLookupsV = rmanLookupsV; }
	 * 
	 * public RmanLookupsV getRmanLookupsV1() { return rmanLookupsV1; }
	 * 
	 * public void setRmanLookupsV1(RmanLookupsV rmanLookupsV1) {
	 * this.rmanLookupsV1 = rmanLookupsV1; }
	 */
	

	@Column(name = "ADDITIONAL_ATTRIBUTE1")
	private String additionalAttribute1;

	@Column(name = "ADDITIONAL_ATTRIBUTE2")
	private String additionalAttribute2;
	

	@Column(name = "ADDITIONAL_ATTRIBUTE3")
	private String additionalAttribute3;

	@Column(name = "ADDITIONAL_ATTRIBUTE4")
	private String additionalAttribute4;

	@Column(name = "ADDITIONAL_ATTRIBUTE5")
	private String additionalAttribute5;
	
	public String getAdditionalAttribute1() {
		return additionalAttribute1;
	}

	public void setAdditionalAttribute1(String additionalAttribute1) {
		this.additionalAttribute1 = additionalAttribute1;
	}

	public String getAdditionalAttribute2() {
		return additionalAttribute2;
	}

	public void setAdditionalAttribute2(String additionalAttribute2) {
		this.additionalAttribute2 = additionalAttribute2;
	}

	public String getAdditionalAttribute3() {
		return additionalAttribute3;
	}

	public void setAdditionalAttribute3(String additionalAttribute3) {
		this.additionalAttribute3 = additionalAttribute3;
	}

	public String getAdditionalAttribute4() {
		return additionalAttribute4;
	}

	public void setAdditionalAttribute4(String additionalAttribute4) {
		this.additionalAttribute4 = additionalAttribute4;
	}

	public String getAdditionalAttribute5() {
		return additionalAttribute5;
	}

	public void setAdditionalAttribute5(String additionalAttribute5) {
		this.additionalAttribute5 = additionalAttribute5;
	}
}