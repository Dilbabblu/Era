package com.forsys.revmantra.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="RMAN_ARRANGEMENTS_ALL_V")
public class RmanArrangementsAllV {

    @Column(name="DEAL_FLAG")
    private String dealFlag;

    @Column(name="END_CUSTOMER_NAME")
    private String endCustomerName;

    @Column(name="MASTER_ARRG_NAME")
    private String masterArrgName;

    @Column(name="ARRANGEMENT_SOURCE")
    private String arrangementSource;

    @Column(name="REV_MANAGER_ID")
    private BigDecimal revManagerId;

    @Column(name="ARRANGEMENT_CURRENCY")
    private String arrangementCurrency;

    @Column(name="MSA_NAME")
    private String msaName;

    @Column(name="CONTRACT_FLAG")
    private String contractFlag;

    @Column(name="END_CUSTOMER_NUMBER")
    private String endCustomerNumber;

    @Column(name="LAST_UPDATE_DATE")
    private Timestamp lastUpdateDate;

    @Column(name="CUSTOMER_CONTACT")
    private String customerContact;

    @Column(name="CHANGE_REASON")
    private String changeReason;

    @Column(name="ARRANGEMENT_TOTAL")
    private BigDecimal arrangementTotal;

    @Column(name="ARRANGEMENT_NAME")
    private String arrangementName;

    @Column(name="MASTER_ARRG_ID")
    private BigDecimal masterArrgId;

    @Column(name="DEAL_NUMBER")
    private String dealNumber;

    @Column(name="ARRANGEMENT_BASIS")
    private String arrangementBasis;

    @Column(name="DEAL_NAME")
    private String dealName;

    @Column(name="REP_CURR_CODE")
    private String repCurrCode;

    @Column(name="CREATED_BY")
    private BigDecimal createdBy;

    @Column(name="SALES_NODE_LEVEL4")
    private String salesNodeLevel4;

    @Column(name="LAST_UPDATED_BY")
    private BigDecimal lastUpdatedBy;

    @Column(name="MSA_NUMBER")
    private String msaNumber;

    @Column(name="SALES_NODE_LEVEL2")
    private String salesNodeLevel2;

    @Column(name="CALCUATION_METHOD")
    private String calcuationMethod;

    @Column(name="SALES_NODE_LEVEL3")
    private String salesNodeLevel3;

    @Column(name="SALES_CONTACT")
    private String salesContact;

    @Column(name="ARRANGEMENT_NUMBER")
    private String arrangementNumber;

    @Column(name="LEGAL_ENTITY_ID")
    private BigDecimal legalEntityId;

    @Column(name="REV_ACCOUNTANT_ID")
    private BigDecimal revAccountantId;

    @Column(name="REASON_CODE")
    private String reasonCode;

    @Column(name="CREATION_DATE")
    private Timestamp creationDate;

    @Column(name="GUIDANCE_TYPE")
    private String guidanceType;

    @Column(name="ARRANGEMENT_KEY")
    private String arrangementKey;

    @Column(name="MASTER_ARRG_FLAG")
    private String masterArrgFlag;

    @Column(name="CUSTOMER_PO_NUM")
    private String customerPoNum;
    
    @Column(name="DEAL_NUM")
    private String dealNum;
    
    @Column(name="GROUPING_RULE")
    private String groupingRule;

    @Id
    @Column(name="SNO")
    private BigDecimal sno;
    
    public BigDecimal getSno() {
        return sno;
    }

    public void setSno(BigDecimal sno) {
        this.sno = sno;
    }

    @Column(name="ARRANGEMENT_ID")
    private BigDecimal arrangementId;

    @Column(name="SALES_NODE_LEVEL1")
    private String salesNodeLevel1;

    @Column(name="ARRANGEMENT_TYPE")
    private String arrangementType;

    @Column(name="ALLOCATION_ELIGIBLE")
    private String allocationEligible;

    @Column(name="GUIDANCE_NAME")
    private String guidanceName;

    @Column(name="LEGAL_ENTITY_NAME")
    private String legalEntityName;

    @Column(name="ARRANGEMENT_STATUS")
    private String arrangementStatus;

    @Column(name="ORDER_NUMBER")
    private BigDecimal orderNumber;

    @Column(name="ARRANGEMENT_QTR")
    private String arrangementQtr;
    

    @Column(name="CONT_APPLIED")
    private String contApplied;
    
    @Column(name="LAST_ARRG_MODIFIED_DATE")
    private Timestamp lastArrgModifiedDate;
    
    @Column(name="PROJECT_NUMBER")
    private String projectNumber;
    
    public String getDealFlag() { 
        return this.dealFlag;
    }

    public void setDealFlag(String dealFlag) { 
        this.dealFlag=dealFlag;
    }
    public String getEndCustomerName() { 
        return this.endCustomerName;
    }

    public void setEndCustomerName(String endCustomerName) { 
        this.endCustomerName=endCustomerName;
    }
    public String getMasterArrgName() { 
        return this.masterArrgName;
    }

    public void setMasterArrgName(String masterArrgName) { 
        this.masterArrgName=masterArrgName;
    }
    public String getArrangementSource() { 
        return this.arrangementSource;
    }

    public void setArrangementSource(String arrangementSource) { 
        this.arrangementSource=arrangementSource;
    }
    public BigDecimal getRevManagerId() { 
        return this.revManagerId;
    }

    public void setRevManagerId(BigDecimal revManagerId) { 
        this.revManagerId=revManagerId;
    }
    public String getArrangementCurrency() { 
        return this.arrangementCurrency;
    }

    public void setArrangementCurrency(String arrangementCurrency) { 
        this.arrangementCurrency=arrangementCurrency;
    }
    public String getMsaName() { 
        return this.msaName;
    }

    public void setMsaName(String msaName) { 
        this.msaName=msaName;
    }
    public String getContractFlag() { 
        return this.contractFlag;
    }

    public void setContractFlag(String contractFlag) { 
        this.contractFlag=contractFlag;
    }
    public String getEndCustomerNumber() { 
        return this.endCustomerNumber;
    }

    public void setEndCustomerNumber(String endCustomerNumber) { 
        this.endCustomerNumber=endCustomerNumber;
    }
    public Timestamp getLastUpdateDate() { 
        return this.lastUpdateDate;
    }

    public void setLastUpdateDate(Timestamp lastUpdateDate) { 
        this.lastUpdateDate=lastUpdateDate;
    }
    public String getCustomerContact() { 
        return this.customerContact;
    }

    public void setCustomerContact(String customerContact) { 
        this.customerContact=customerContact;
    }
    public String getChangeReason() { 
        return this.changeReason;
    }

    public void setChangeReason(String changeReason) { 
        this.changeReason=changeReason;
    }
    public BigDecimal getArrangementTotal() { 
        return this.arrangementTotal;
    }

    public void setArrangementTotal(BigDecimal arrangementTotal) { 
        this.arrangementTotal=arrangementTotal;
    }
    public String getArrangementName() { 
        return this.arrangementName;
    }

    public void setArrangementName(String arrangementName) { 
        this.arrangementName=arrangementName;
    }
    public BigDecimal getMasterArrgId() { 
        return this.masterArrgId;
    }

    public void setMasterArrgId(BigDecimal masterArrgId) { 
        this.masterArrgId=masterArrgId;
    }
    public String getDealNumber() { 
        return this.dealNumber;
    }

    public void setDealNumber(String dealNumber) { 
        this.dealNumber=dealNumber;
    }
    public String getArrangementBasis() { 
        return this.arrangementBasis;
    }

    public void setArrangementBasis(String arrangementBasis) { 
        this.arrangementBasis=arrangementBasis;
    }
    public String getDealName() { 
        return this.dealName;
    }

    public void setDealName(String dealName) { 
        this.dealName=dealName;
    }
    public String getRepCurrCode() { 
        return this.repCurrCode;
    }

    public void setRepCurrCode(String repCurrCode) { 
        this.repCurrCode=repCurrCode;
    }
    public BigDecimal getCreatedBy() { 
        return this.createdBy;
    }

    public void setCreatedBy(BigDecimal createdBy) { 
        this.createdBy=createdBy;
    }
    public String getSalesNodeLevel4() { 
        return this.salesNodeLevel4;
    }

    public void setSalesNodeLevel4(String salesNodeLevel4) { 
        this.salesNodeLevel4=salesNodeLevel4;
    }
    public BigDecimal getLastUpdatedBy() { 
        return this.lastUpdatedBy;
    }

    public void setLastUpdatedBy(BigDecimal lastUpdatedBy) { 
        this.lastUpdatedBy=lastUpdatedBy;
    }
    public String getMsaNumber() { 
        return this.msaNumber;
    }

    public void setMsaNumber(String msaNumber) { 
        this.msaNumber=msaNumber;
    }
    public String getSalesNodeLevel2() { 
        return this.salesNodeLevel2;
    }

    public void setSalesNodeLevel2(String salesNodeLevel2) { 
        this.salesNodeLevel2=salesNodeLevel2;
    }
    public String getCalcuationMethod() { 
        return this.calcuationMethod;
    }

    public void setCalcuationMethod(String calcuationMethod) { 
        this.calcuationMethod=calcuationMethod;
    }
    public String getSalesNodeLevel3() { 
        return this.salesNodeLevel3;
    }

    public void setSalesNodeLevel3(String salesNodeLevel3) { 
        this.salesNodeLevel3=salesNodeLevel3;
    }
    public String getSalesContact() { 
        return this.salesContact;
    }

    public void setSalesContact(String salesContact) { 
        this.salesContact=salesContact;
    }
    public String getArrangementNumber() { 
        return this.arrangementNumber;
    }

    public void setArrangementNumber(String arrangementNumber) { 
        this.arrangementNumber=arrangementNumber;
    }
    public BigDecimal getLegalEntityId() { 
        return this.legalEntityId;
    }

    public void setLegalEntityId(BigDecimal legalEntityId) { 
        this.legalEntityId=legalEntityId;
    }
    public BigDecimal getRevAccountantId() { 
        return this.revAccountantId;
    }

    public void setRevAccountantId(BigDecimal revAccountantId) { 
        this.revAccountantId=revAccountantId;
    }
    public String getReasonCode() { 
        return this.reasonCode;
    }

    public void setReasonCode(String reasonCode) { 
        this.reasonCode=reasonCode;
    }
    public Timestamp getCreationDate() { 
        return this.creationDate;
    }

    public void setCreationDate(Timestamp creationDate) { 
        this.creationDate=creationDate;
    }
    public String getGuidanceType() { 
        return this.guidanceType;
    }

    public void setGuidanceType(String guidanceType) { 
        this.guidanceType=guidanceType;
    }
    public String getArrangementKey() { 
        return this.arrangementKey;
    }

    public void setArrangementKey(String arrangementKey) { 
        this.arrangementKey=arrangementKey;
    }
    public String getMasterArrgFlag() { 
        return this.masterArrgFlag;
    }

    public void setMasterArrgFlag(String masterArrgFlag) { 
        this.masterArrgFlag=masterArrgFlag;
    }
    public String getCustomerPoNum() { 
        return this.customerPoNum;
    }

    public void setCustomerPoNum(String customerPoNum) { 
        this.customerPoNum=customerPoNum;
    }
    public BigDecimal getArrangementId() { 
        return this.arrangementId;
    }

    public void setArrangementId(BigDecimal arrangementId) { 
        this.arrangementId=arrangementId;
    }
    public String getSalesNodeLevel1() { 
        return this.salesNodeLevel1;
    }

    public void setSalesNodeLevel1(String salesNodeLevel1) { 
        this.salesNodeLevel1=salesNodeLevel1;
    }
    public String getArrangementType() { 
        return this.arrangementType;
    }

    public void setArrangementType(String arrangementType) { 
        this.arrangementType=arrangementType;
    }
    public String getAllocationEligible() { 
        return this.allocationEligible;
    }

    public void setAllocationEligible(String allocationEligible) { 
        this.allocationEligible=allocationEligible;
    }
    public String getGuidanceName() { 
        return this.guidanceName;
    }

    public void setGuidanceName(String guidanceName) { 
        this.guidanceName=guidanceName;
    }
    public String getLegalEntityName() { 
        return this.legalEntityName;
    }

    public void setLegalEntityName(String legalEntityName) { 
        this.legalEntityName=legalEntityName;
    }
    public String getArrangementStatus() { 
        return this.arrangementStatus;
    }

    public void setArrangementStatus(String arrangementStatus) { 
        this.arrangementStatus=arrangementStatus;
    }
    public BigDecimal getOrderNumber() { 
        return this.orderNumber;
    }

    public void setOrderNumber(BigDecimal orderNumber) { 
        this.orderNumber=orderNumber;
    }
    public String getArrangementQtr() { 
        return this.arrangementQtr;
    }

    public void setArrangementQtr(String arrangementQtr) { 
        this.arrangementQtr=arrangementQtr;
    }

	public String getContApplied() {
		return contApplied;
	}

	public void setContApplied(String contApplied) {
		this.contApplied = contApplied;
	}

	public Timestamp getLastArrgModifiedDate() {
		return lastArrgModifiedDate;
	}

	public void setLastArrgModifiedDate(Timestamp lastArrgModifiedDate) {
		this.lastArrgModifiedDate = lastArrgModifiedDate;
	}

	public String getProjectNumber() {
		return projectNumber;
	}

	public void setProjectNumber(String projectNumber) {
		this.projectNumber = projectNumber;
	}

	public String getDealNum() {
		return dealNum;
	}

	public void setDealNum(String dealNum) {
		this.dealNum = dealNum;
	}

	public String getGroupingRule() {
		return groupingRule;
	}

	public void setGroupingRule(String groupingRule) {
		this.groupingRule = groupingRule;
	}
	

}