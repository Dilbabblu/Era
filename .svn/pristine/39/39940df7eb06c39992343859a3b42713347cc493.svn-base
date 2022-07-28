package com.forsys.revmantra.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.forsys.revmantra.listener.RmanIntfDealDetailsListener;

@Entity
@EntityListeners(RmanIntfDealDetailsListener.class)
@Table(name="RMAN_INTF_DEAL_DETAILS")
@IdClass(RmanIntfUniqueRecord.class)
public class RmanIntfDealDetails {
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO, generator = "RMAN_INTF_DEAL_DETAILS_seq_gen")
//	@SequenceGenerator(name = "RMAN_INTF_DEAL_DETAILS_seq_gen", sequenceName = "RMAN_INTF_DEAL_DETAILS_S")
	@Column(name="SEQ_ID")
	private BigDecimal seqId;
	
	@Column(name = "ARRANGEMENT_NUMBER")
	private String arrangementNumber;
	
	@Id
	@Column(name = "DEAL_NUMBER")
	private String dealNumber;
	
	@Id
	@Column(name = "DEAL_LINE_NUMBER")
	private BigDecimal dealLineNumber;

	@Id
	@Column(name="SOURCE_LINE_REF_ID")
	private String sourceLineRefId;
	
	
	@Column(name = "ENTITY_NAME")
	private String entityName;
	
	
	@Column(name = "FX_DATE")
	private Timestamp fxDate;

	
	@Column(name = "ARRANGEMENT_SOURCE")
	private String arrangementSource;

	
	@Column(name = "UNIT_COST")
	private BigDecimal unitCost;

	
	@Column(name = "INTERFACE_ERROR")
	private String interfaceError;

	
	@Column(name = "QUANTITY")
	private BigDecimal quantity;

	
	@Column(name = "PRICE_LIST")
	private String priceList;

	
	@Column(name = "END_DATE")
	private Timestamp endDate;

	
	@Column(name = "ADDITIONAL_ATTRIBUTE1")
	private String additionalAttribute1;

	
	@Column(name = "ADDITIONAL_ATTRIBUTE2")
	private String additionalAttribute2;

	
	@Column(name = "ADDITIONAL_ATTRIBUTE3")
	private String additionalAttribute3;

	
	@Column(name = "UNIT_SELLING_PRICE")
	private BigDecimal unitSellingPrice;

	
	@Column(name = "UNIT_LIST_PRICE")
	private BigDecimal unitListPrice;

	
	@Column(name = "DEAL_NAME")
	private String dealName;

	
	@Column(name = "DURATION_UOM")
	private String durationUom;

	

	
	@Column(name = "PRODUCT_NAME")
	private String productName;

	
	@Column(name = "AGREEMENT_ID")
	private String agreementId;

	
	@Column(name = "OPERATION_CODE")
	private String operationCode;

	
	@Column(name = "MASTER_ARRG_NAME")
	private String masterArrgName;

	
	@Column(name = "ALLOCATION_EXCLUDE_FLAG")
	private String allocationExcludeFlag;

	
	@Column(name = "FV_PERCENT")
	private BigDecimal fvPercent;

	
	@Column(name = "MSA_NAME")
	private String msaName;

	
	@Column(name = "CURRENCY_CODE")
	private String currencyCode;

	
	@Column(name = "INTERFACE_STATUS")
	private String interfaceStatus;

	
	@Column(name = "FX_RATE")
	private BigDecimal fxRate;

	

	
	@Column(name = "BILL_TO_CUSTOMER_NAME")
	private String billToCustomerName;

	
	@Column(name = "ARRANGEMENT_NAME")
	private String arrangementName;

	
	@Column(name = "ARRANGEMENT_BASIS")
	private String arrangementBasis;

	
	@Column(name = "AGREEMENT_NAME")
	private String agreementName;

	
	@Column(name = "SALES_NODE_LEVEL4")
	private String salesNodeLevel4;

	
	@Column(name = "ADDITIONAL_LINE_ATTRIBUTE3")
	private String additionalLineAttribute3;

	
	@Column(name = "SALES_NODE_LEVEL2")
	private String salesNodeLevel2;

	
	@Column(name = "ADDITIONAL_LINE_ATTRIBUTE1")
	private String additionalLineAttribute1;

	
	@Column(name = "MSA_NUMBER")
	private BigDecimal msaNumber;

	
	@Column(name = "SALES_NODE_LEVEL3")
	private String salesNodeLevel3;

	
	@Column(name = "ADDITIONAL_LINE_ATTRIBUTE2")
	private String additionalLineAttribute2;

	

	
	@Column(name = "BESP_PER_UNIT")
	private BigDecimal bespPerUnit;

	
	@Column(name = "START_DATE")
	private Timestamp startDate;

	
	@Column(name = "PARENT_LINE_ID")
	private BigDecimal parentLineId;

	
	@Column(name = "MASTER_ARRG_FLAG")
	private String masterArrgFlag;

	
	@Column(name = "SALES_NODE_LEVEL1")
	private String salesNodeLevel1;

	
	@Column(name = "ACCOUNTING_RULE_NAME")
	private String accountingRuleName;

	
	@Column(name = "CONTRACT_UNIT_TYPE")
	private String contractUnitType;

	
	@Column(name = "CUSTOMER_NAME")
	private String customerName;

	
	@Column(name = "DURATION")
	private BigDecimal duration;

	
	@Column(name = "EITF_SOP")
	private String eitfSop;

	
	@Column(name = "BUNDLE_FLAG")
	private String bundleFlag;
	
	@Column(name = "ARRG_SOURCE")
	private String arrgSource;

	@Column(name = "ARRG_BASIS")
	private String arrgBasis;

	@Column(name = "CREATED_BY")
	private BigDecimal createdBy;
	
	   
	@Column(name="ADJUSTMENT_AMOUNT")
	private BigDecimal adjustmentAmount;
	
	@Column(name="REBATE_PERCENT")
	private BigDecimal rebatePercent;
	
	@Column(name="PROCESS_ID")
	private BigDecimal processId;
	
	@Column(name="PROCESS_DATE")
	private Timestamp processDate;
	
	@Column(name="CREATION_DATE")
	private Timestamp creationDate;
	
	@Column(name="FILE_NAME")
	private String fileName;
	
	@Column(name="FILE_TYPE")
	private String fileType;
	
	@Column(name="CUSTOMER_NUMBER")
	private String customerNumber;
	
	
	@Column(name="EXTENDED_LIST_AMOUNT")
	private BigDecimal extendedListAmount;
	
	@Column(name="EXTENDED_SELLING_AMOUNT")
	private BigDecimal extendedSellingAmount;
	

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getArrangementNumber() {
		return arrangementNumber;
	}

	public void setArrangementNumber(String arrangementNumber) {
		this.arrangementNumber = arrangementNumber;
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

	public Timestamp getFxDate() {
		return fxDate;
	}

	public void setFxDate(Timestamp fxDate) {
		this.fxDate = fxDate;
	}

	public String getArrangementSource() {
		return arrangementSource;
	}

	public void setArrangementSource(String arrangementSource) {
		this.arrangementSource = arrangementSource;
	}

	public BigDecimal getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(BigDecimal unitCost) {
		this.unitCost = unitCost;
	}

	public String getInterfaceError() {
		return interfaceError;
	}

	public void setInterfaceError(String interfaceError) {
		this.interfaceError = interfaceError;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public String getPriceList() {
		return priceList;
	}

	public void setPriceList(String priceList) {
		this.priceList = priceList;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

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

	public BigDecimal getUnitSellingPrice() {
		return unitSellingPrice;
	}

	public void setUnitSellingPrice(BigDecimal unitSellingPrice) {
		this.unitSellingPrice = unitSellingPrice;
	}

	public BigDecimal getUnitListPrice() {
		return unitListPrice;
	}

	public void setUnitListPrice(BigDecimal unitListPrice) {
		this.unitListPrice = unitListPrice;
	}

	public String getDealName() {
		return dealName;
	}

	public void setDealName(String dealName) {
		this.dealName = dealName;
	}

	public String getDurationUom() {
		return durationUom;
	}

	public void setDurationUom(String durationUom) {
		this.durationUom = durationUom;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getAgreementId() {
		return agreementId;
	}

	public void setAgreementId(String agreementId) {
		this.agreementId = agreementId;
	}

	public String getOperationCode() {
		return operationCode;
	}

	public void setOperationCode(String operationCode) {
		this.operationCode = operationCode;
	}

	public String getMasterArrgName() {
		return masterArrgName;
	}

	public void setMasterArrgName(String masterArrgName) {
		this.masterArrgName = masterArrgName;
	}

	public String getAllocationExcludeFlag() {
		return allocationExcludeFlag;
	}

	public void setAllocationExcludeFlag(String allocationExcludeFlag) {
		this.allocationExcludeFlag = allocationExcludeFlag;
	}

	public BigDecimal getFvPercent() {
		return fvPercent;
	}

	public void setFvPercent(BigDecimal fvPercent) {
		this.fvPercent = fvPercent;
	}

	public String getMsaName() {
		return msaName;
	}

	public void setMsaName(String msaName) {
		this.msaName = msaName;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getInterfaceStatus() {
		return interfaceStatus;
	}

	public void setInterfaceStatus(String interfaceStatus) {
		this.interfaceStatus = interfaceStatus;
	}

	public BigDecimal getFxRate() {
		return fxRate;
	}

	public void setFxRate(BigDecimal fxRate) {
		this.fxRate = fxRate;
	}

	public String getBillToCustomerName() {
		return billToCustomerName;
	}

	public void setBillToCustomerName(String billToCustomerName) {
		this.billToCustomerName = billToCustomerName;
	}

	public String getArrangementName() {
		return arrangementName;
	}

	public void setArrangementName(String arrangementName) {
		this.arrangementName = arrangementName;
	}

	public String getArrangementBasis() {
		return arrangementBasis;
	}

	public void setArrangementBasis(String arrangementBasis) {
		this.arrangementBasis = arrangementBasis;
	}

	public String getAgreementName() {
		return agreementName;
	}

	public void setAgreementName(String agreementName) {
		this.agreementName = agreementName;
	}

	public String getSalesNodeLevel4() {
		return salesNodeLevel4;
	}

	public void setSalesNodeLevel4(String salesNodeLevel4) {
		this.salesNodeLevel4 = salesNodeLevel4;
	}

	public String getAdditionalLineAttribute3() {
		return additionalLineAttribute3;
	}

	public void setAdditionalLineAttribute3(String additionalLineAttribute3) {
		this.additionalLineAttribute3 = additionalLineAttribute3;
	}

	public String getSalesNodeLevel2() {
		return salesNodeLevel2;
	}

	public void setSalesNodeLevel2(String salesNodeLevel2) {
		this.salesNodeLevel2 = salesNodeLevel2;
	}

	public String getAdditionalLineAttribute1() {
		return additionalLineAttribute1;
	}

	public void setAdditionalLineAttribute1(String additionalLineAttribute1) {
		this.additionalLineAttribute1 = additionalLineAttribute1;
	}

	public BigDecimal getMsaNumber() {
		return msaNumber;
	}

	public void setMsaNumber(BigDecimal msaNumber) {
		this.msaNumber = msaNumber;
	}

	public String getSalesNodeLevel3() {
		return salesNodeLevel3;
	}

	public void setSalesNodeLevel3(String salesNodeLevel3) {
		this.salesNodeLevel3 = salesNodeLevel3;
	}

	public String getAdditionalLineAttribute2() {
		return additionalLineAttribute2;
	}

	public void setAdditionalLineAttribute2(String additionalLineAttribute2) {
		this.additionalLineAttribute2 = additionalLineAttribute2;
	}

	public BigDecimal getBespPerUnit() {
		return bespPerUnit;
	}

	public void setBespPerUnit(BigDecimal bespPerUnit) {
		this.bespPerUnit = bespPerUnit;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public BigDecimal getParentLineId() {
		return parentLineId;
	}

	public void setParentLineId(BigDecimal parentLineId) {
		this.parentLineId = parentLineId;
	}

	public String getMasterArrgFlag() {
		return masterArrgFlag;
	}

	public void setMasterArrgFlag(String masterArrgFlag) {
		this.masterArrgFlag = masterArrgFlag;
	}

	public String getSalesNodeLevel1() {
		return salesNodeLevel1;
	}

	public void setSalesNodeLevel1(String salesNodeLevel1) {
		this.salesNodeLevel1 = salesNodeLevel1;
	}

	public String getAccountingRuleName() {
		return accountingRuleName;
	}

	public void setAccountingRuleName(String accountingRuleName) {
		this.accountingRuleName = accountingRuleName;
	}

	public String getContractUnitType() {
		return contractUnitType;
	}

	public void setContractUnitType(String contractUnitType) {
		this.contractUnitType = contractUnitType;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public BigDecimal getDuration() {
		return duration;
	}

	public void setDuration(BigDecimal duration) {
		this.duration = duration;
	}

	public String getEitfSop() {
		return eitfSop;
	}

	public void setEitfSop(String eitfSop) {
		this.eitfSop = eitfSop;
	}

	public String getBundleFlag() {
		return bundleFlag;
	}

	public void setBundleFlag(String bundleFlag) {
		this.bundleFlag = bundleFlag;
	}

	public String getArrgSource() {
		return arrgSource;
	}

	public void setArrgSource(String arrgSource) {
		this.arrgSource = arrgSource;
	}

	public String getArrgBasis() {
		return arrgBasis;
	}

	public void setArrgBasis(String arrgBasis) {
		this.arrgBasis = arrgBasis;
	}

	public BigDecimal getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(BigDecimal createdBy) {
		this.createdBy = createdBy;
	}

	public String getSourceLineRefId() {
		return sourceLineRefId;
	}

	public void setSourceLineRefId(String sourceLineRefId) {
		this.sourceLineRefId = sourceLineRefId;
	}

	public BigDecimal getAdjustmentAmount() {
		return adjustmentAmount;
	}

	public void setAdjustmentAmount(BigDecimal adjustmentAmount) {
		this.adjustmentAmount = adjustmentAmount;
	}
	
	public BigDecimal getRebatePercent() {
		return rebatePercent;
	}

	public void setRebatePercent(BigDecimal rebatePercent) {
		this.rebatePercent = rebatePercent;
	}

	public BigDecimal getProcessId() {
		return processId;
	}

	public void setProcessId(BigDecimal processId) {
		this.processId = processId;
	}

	public Timestamp getProcessDate() {
		return processDate;
	}

	public void setProcessDate(Timestamp processDate) {
		this.processDate = processDate;
	}

	public Timestamp getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public BigDecimal getSeqId() {
		return seqId;
	}

	public void setSeqId(BigDecimal seqId) {
		this.seqId = seqId;
	}

	public BigDecimal getExtendedListAmount() {
		return extendedListAmount;
	}

	public void setExtendedListAmount(BigDecimal extendedListAmount) {
		this.extendedListAmount = extendedListAmount;
	}

	public BigDecimal getExtendedSellingAmount() {
		return extendedSellingAmount;
	}

	public void setExtendedSellingAmount(BigDecimal extendedSellingAmount) {
		this.extendedSellingAmount = extendedSellingAmount;
	}
	
	
	
}