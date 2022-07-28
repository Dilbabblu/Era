package com.forsys.revmantra.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="RMAN_DEAL_ARRANGEMENTS")
public class ArrangementRmanDeal {

    @Column(name="DEAL_COSED_DATE")
    private Timestamp dealCosedDate;

    @Column(name="ATTRIBUTE30")
    private String attribute30;

    @Column(name="LAST_UPDATE_DATE")
    private Timestamp lastUpdateDate;

    @Column(name="DEAL_ARRANGEMENT_BASIS")
    private String dealArrangementBasis;

    @Column(name="DEAL_ARRANGEMENT_KEY")
    private String dealArrangementKey;

    @Column(name="DEAL_ARRANGEMENT_TOTAL")
    private BigDecimal dealArrangementTotal;

    @Column(name="CHANGE_REASON")
    private String changeReason;

    @Column(name="ATTRIBUTE29")
    private String attribute29;

    @Column(name="ATTRIBUTE28")
    private String attribute28;

    @Column(name="DEAL_ARRANGEMENT_TYPE")
    private String dealArrangementType;

    @Column(name="ATTRIBUTE27")
    private String attribute27;

    @Column(name="DEAL_APPROVAL_DATE")
    private Timestamp dealApprovalDate;

    @Column(name="ATTRIBUTE26")
    private String attribute26;

    @Column(name="MASTER_ARRG_ID")
    private BigDecimal masterArrgId;

    @Column(name="DEAL_NAME")
    private String dealName;

    @Column(name="ATTRIBUTE3")
    private String attribute3;

    @Column(name="CREATED_BY")
    private BigDecimal createdBy;

    @Column(name="ATTRIBUTE2")
    private String attribute2;

    @Column(name="LAST_UPDATED_BY")
    private BigDecimal lastUpdatedBy;

    @Column(name="ATTRIBUTE1")
    private String attribute1;

    @Column(name="DEAL_ARRANGEMENT_SOURCE")
    private String dealArrangementSource;

    @Column(name="SALES_CONTACT")
    private String salesContact;

    @Column(name="LEGAL_ENTITY_ID")
    private BigDecimal legalEntityId;

    @Column(name="CREATION_DATE")
    private Timestamp creationDate;

    @Column(name="ATTRIBUTE9")
    private String attribute9;

    @Column(name="ATTRIBUTE8")
    private String attribute8;

    @Column(name="ATTRIBUTE7")
    private String attribute7;

    @Column(name="ATTRIBUTE6")
    private String attribute6;

    @Column(name="ATTRIBUTE5")
    private String attribute5;

    @Column(name="ATTRIBUTE4")
    private String attribute4;

    @Column(name="ALLOCATION_ELIGIBLE")
    private String allocationEligible;

    @Column(name="DEAL_AGREEMENT_ID")
    private String dealAgreementId;

    @Column(name="DEAL_ARRANGEMENT_STATUS")
    private String dealArrangementStatus;

    @Column(name="ATTRIBUTE10")
    private String attribute10;

    @Column(name="END_CUSTOMER_NAME")
    private String endCustomerName;

    @Column(name="DEAL_ARRANGEMENT_NUMBER")
    private String dealArrangementNumber;

    @Column(name="MASTER_ARRG_NAME")
    private String masterArrgName;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="REV_MANAGER_ID",nullable=false,insertable = false,updatable=false) RmanUsers managerUser;
    
	@Column(name="REV_MANAGER_ID")
    private BigDecimal revManagerId;

    @Column(name="ATTRIBUTE14")
    private String attribute14;

    @Column(name="ATTRIBUTE13")
    private String attribute13;

    @Column(name="ARRANGEMENT_CURRENCY")
    private String arrangementCurrency;

    @Column(name="ATTRIBUTE12")
    private String attribute12;

    @Column(name="MSA_NAME")
    private String msaName;

    @Column(name="ATTRIBUTE11")
    private String attribute11;

    @Column(name="DEAL_APPROVED_BY")
    private BigDecimal dealApprovedBy;

    @Column(name="DEAL_ARRANGEMENT_NAME")
    private String dealArrangementName;

    @Column(name="END_CUSTOMER_NUMBER")
    private String endCustomerNumber;

    @Column(name="CUSTOMER_CONTACT")
    private String customerContact;

    @Column(name="DEAL_ID")
    private String dealId;

    @Column(name="DEAL_ARRANGEMENT_SA_ME")
    private String dealArrangementSaMe;

    @Column(name="DEAL_NUMBER")
    private String dealNumber;

    @Column(name="ATTRIBUTE21")
    private String attribute21;

    @Column(name="SALES_NODE_LEVEL4")
    private String salesNodeLevel4;

    @Column(name="ATTRIBUTE20")
    private String attribute20;

    @Column(name="MSA_NUMBER")
    private String msaNumber;

    @Column(name="SALES_NODE_LEVEL2")
    private String salesNodeLevel2;

    @Column(name="SALES_NODE_LEVEL3")
    private String salesNodeLevel3;

    @Column(name="DEAL_ARRANGEMENT_QTR")
    private String dealArrangementQtr;

    @Column(name="ATTRIBUTE25")
    private String attribute25;

    @Column(name="ATTRIBUTE24")
    private String attribute24;

    @Column(name="ATTRIBUTE23")
    private String attribute23;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="REV_ACCOUNTANT_ID",nullable=false,insertable = false,updatable=false) RmanUsers analystUser;
    
    @Column(name="REV_ACCOUNTANT_ID")
    private BigDecimal revAccountantId;

    @Column(name="ATTRIBUTE22")
    private String attribute22;

    @Column(name="REASON_CODE")
    private String reasonCode;

    @Column(name="MASTER_ARRG_FLAG")
    private String masterArrgFlag;

    @Column(name="SALES_NODE_LEVEL1")
    private String salesNodeLevel1;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RMAN_DEAL_ARRANGEMENTS_seq_gen")
    @SequenceGenerator(name="RMAN_DEAL_ARRANGEMENTS_seq_gen", sequenceName="RMAN_DEAL_HEADER_ID_S",allocationSize=1)
    @Column(name="DEAL_ARRANGEMENT_ID")
    private BigDecimal dealArrangementId;

    @Column(name="LEGAL_ENTITY_NAME")
    private String legalEntityName;

    @Column(name="ATTRIBUTE18")
    private String attribute18;

    @Column(name="ATTRIBUTE17")
    private String attribute17;

    @Column(name="ATTRIBUTE16")
    private String attribute16;

    @Column(name="ATTRIBUTE15")
    private String attribute15;

    @Column(name="DEAL_AGREEMENT_NAME")
    private String dealAgreementName;

    @Column(name="ATTRIBUTE19")
    private String attribute19;
/**
 @OneToOne(fetch = FetchType.EAGER)
 @JoinColumn(name="DEAL_ARRANGEMENT_STATUS",insertable = false, updatable = false )
    private RmanLookupsV rmanLookupsV;
 @OneToOne(fetch = FetchType.EAGER)
 @JoinColumn(name="DEAL_ARRANGEMENT_BASIS",insertable = false, updatable = false )
    private RmanLookupsV rmanLookupsV1;
 @OneToOne(fetch = FetchType.EAGER)
 @JoinColumn(name="REV_ACCOUNTANT_ID",insertable = false, updatable = false )
    private RmanUsers rmanUsers;
 @OneToOne(fetch = FetchType.EAGER)
 @JoinColumn(name="REV_MANAGER_ID",insertable = false, updatable = false )
    private RmanUsers rmanUsers1;*/


    public Timestamp getDealCosedDate() { 
        return this.dealCosedDate;
    }

    public void setDealCosedDate(Timestamp dealCosedDate) { 
        this.dealCosedDate=dealCosedDate;
    }
    public String getAttribute30() { 
        return this.attribute30;
    }

    public void setAttribute30(String attribute30) { 
        this.attribute30=attribute30;
    }
    public Timestamp getLastUpdateDate() { 
        return this.lastUpdateDate;
    }

    public void setLastUpdateDate(Timestamp lastUpdateDate) { 
        this.lastUpdateDate=lastUpdateDate;
    }
    public String getDealArrangementBasis() { 
        return this.dealArrangementBasis;
    }

    public void setDealArrangementBasis(String dealArrangementBasis) { 
        this.dealArrangementBasis=dealArrangementBasis;
    }
    public String getDealArrangementKey() { 
        return this.dealArrangementKey;
    }

    public void setDealArrangementKey(String dealArrangementKey) { 
        this.dealArrangementKey=dealArrangementKey;
    }
    public BigDecimal getDealArrangementTotal() { 
        return this.dealArrangementTotal;
    }

    public void setDealArrangementTotal(BigDecimal dealArrangementTotal) { 
        this.dealArrangementTotal=dealArrangementTotal;
    }
    public String getChangeReason() { 
        return this.changeReason;
    }

    public void setChangeReason(String changeReason) { 
        this.changeReason=changeReason;
    }
    public String getAttribute29() { 
        return this.attribute29;
    }

    public void setAttribute29(String attribute29) { 
        this.attribute29=attribute29;
    }
    public String getAttribute28() { 
        return this.attribute28;
    }

    public void setAttribute28(String attribute28) { 
        this.attribute28=attribute28;
    }
    public String getDealArrangementType() { 
        return this.dealArrangementType;
    }

    public void setDealArrangementType(String dealArrangementType) { 
        this.dealArrangementType=dealArrangementType;
    }
    public String getAttribute27() { 
        return this.attribute27;
    }

    public void setAttribute27(String attribute27) { 
        this.attribute27=attribute27;
    }
    public Timestamp getDealApprovalDate() { 
        return this.dealApprovalDate;
    }

    public void setDealApprovalDate(Timestamp dealApprovalDate) { 
        this.dealApprovalDate=dealApprovalDate;
    }
    public String getAttribute26() { 
        return this.attribute26;
    }

    public void setAttribute26(String attribute26) { 
        this.attribute26=attribute26;
    }
    public BigDecimal getMasterArrgId() { 
        return this.masterArrgId;
    }

    public void setMasterArrgId(BigDecimal masterArrgId) { 
        this.masterArrgId=masterArrgId;
    }
    public String getDealName() { 
        return this.dealName;
    }

    public void setDealName(String dealName) { 
        this.dealName=dealName;
    }
    public String getAttribute3() { 
        return this.attribute3;
    }

    public void setAttribute3(String attribute3) { 
        this.attribute3=attribute3;
    }
    public BigDecimal getCreatedBy() { 
        return this.createdBy;
    }

    public void setCreatedBy(BigDecimal createdBy) { 
        this.createdBy=createdBy;
    }
    public String getAttribute2() { 
        return this.attribute2;
    }

    public void setAttribute2(String attribute2) { 
        this.attribute2=attribute2;
    }
    public BigDecimal getLastUpdatedBy() { 
        return this.lastUpdatedBy;
    }

    public void setLastUpdatedBy(BigDecimal lastUpdatedBy) { 
        this.lastUpdatedBy=lastUpdatedBy;
    }
    public String getAttribute1() { 
        return this.attribute1;
    }

    public void setAttribute1(String attribute1) { 
        this.attribute1=attribute1;
    }
    public String getDealArrangementSource() { 
        return this.dealArrangementSource;
    }

    public void setDealArrangementSource(String dealArrangementSource) { 
        this.dealArrangementSource=dealArrangementSource;
    }
    public String getSalesContact() { 
        return this.salesContact;
    }

    public void setSalesContact(String salesContact) { 
        this.salesContact=salesContact;
    }
    public BigDecimal getLegalEntityId() { 
        return this.legalEntityId;
    }

    public void setLegalEntityId(BigDecimal legalEntityId) { 
        this.legalEntityId=legalEntityId;
    }
    public Timestamp getCreationDate() { 
        return this.creationDate;
    }

    public void setCreationDate(Timestamp creationDate) { 
        this.creationDate=creationDate;
    }
    public String getAttribute9() { 
        return this.attribute9;
    }

    public void setAttribute9(String attribute9) { 
        this.attribute9=attribute9;
    }
    public String getAttribute8() { 
        return this.attribute8;
    }

    public void setAttribute8(String attribute8) { 
        this.attribute8=attribute8;
    }
    public String getAttribute7() { 
        return this.attribute7;
    }

    public void setAttribute7(String attribute7) { 
        this.attribute7=attribute7;
    }
    public String getAttribute6() { 
        return this.attribute6;
    }

    public void setAttribute6(String attribute6) { 
        this.attribute6=attribute6;
    }
    public String getAttribute5() { 
        return this.attribute5;
    }

    public void setAttribute5(String attribute5) { 
        this.attribute5=attribute5;
    }
    public String getAttribute4() { 
        return this.attribute4;
    }

    public void setAttribute4(String attribute4) { 
        this.attribute4=attribute4;
    }
    public String getAllocationEligible() { 
        return this.allocationEligible;
    }

    public void setAllocationEligible(String allocationEligible) { 
        this.allocationEligible=allocationEligible;
    }
    public String getDealAgreementId() { 
        return this.dealAgreementId;
    }

    public void setDealAgreementId(String dealAgreementId) { 
        this.dealAgreementId=dealAgreementId;
    }
    public String getDealArrangementStatus() { 
        return this.dealArrangementStatus;
    }

    public void setDealArrangementStatus(String dealArrangementStatus) { 
        this.dealArrangementStatus=dealArrangementStatus;
    }
    public String getAttribute10() { 
        return this.attribute10;
    }

    public void setAttribute10(String attribute10) { 
        this.attribute10=attribute10;
    }
    public String getEndCustomerName() { 
        return this.endCustomerName;
    }

    public void setEndCustomerName(String endCustomerName) { 
        this.endCustomerName=endCustomerName;
    }
    public String getDealArrangementNumber() { 
        return this.dealArrangementNumber;
    }

    public void setDealArrangementNumber(String dealArrangementNumber) { 
        this.dealArrangementNumber=dealArrangementNumber;
    }
    public String getMasterArrgName() { 
        return this.masterArrgName;
    }

    public void setMasterArrgName(String masterArrgName) { 
        this.masterArrgName=masterArrgName;
    }
    public BigDecimal getRevManagerId() { 
        return this.revManagerId;
    }

    public void setRevManagerId(BigDecimal revManagerId) { 
    	RmanUsers rmanUser = new RmanUsers();
    	rmanUser.setRmanUserId(revManagerId);
    	this.setManagerUser(rmanUser);
    	this.revManagerId = revManagerId;
    }
    
    public String getAttribute14() { 
        return this.attribute14;
    }

    public void setAttribute14(String attribute14) { 
        this.attribute14=attribute14;
    }
    public String getAttribute13() { 
        return this.attribute13;
    }

    public void setAttribute13(String attribute13) { 
        this.attribute13=attribute13;
    }
    public String getArrangementCurrency() { 
        return this.arrangementCurrency;
    }

    public void setArrangementCurrency(String arrangementCurrency) { 
        this.arrangementCurrency=arrangementCurrency;
    }
    public String getAttribute12() { 
        return this.attribute12;
    }

    public void setAttribute12(String attribute12) { 
        this.attribute12=attribute12;
    }
    public String getMsaName() { 
        return this.msaName;
    }

    public void setMsaName(String msaName) { 
        this.msaName=msaName;
    }
    public String getAttribute11() { 
        return this.attribute11;
    }

    public void setAttribute11(String attribute11) { 
        this.attribute11=attribute11;
    }
    public BigDecimal getDealApprovedBy() { 
        return this.dealApprovedBy;
    }

    public void setDealApprovedBy(BigDecimal dealApprovedBy) { 
        this.dealApprovedBy=dealApprovedBy;
    }
    public String getDealArrangementName() { 
        return this.dealArrangementName;
    }

    public void setDealArrangementName(String dealArrangementName) { 
        this.dealArrangementName=dealArrangementName;
    }
    public String getEndCustomerNumber() { 
        return this.endCustomerNumber;
    }

    public void setEndCustomerNumber(String endCustomerNumber) { 
        this.endCustomerNumber=endCustomerNumber;
    }
    public String getCustomerContact() { 
        return this.customerContact;
    }

    public void setCustomerContact(String customerContact) { 
        this.customerContact=customerContact;
    }
    public String getDealId() { 
        return this.dealId;
    }

    public void setDealId(String dealId) { 
        this.dealId=dealId;
    }
    public String getDealArrangementSaMe() { 
        return this.dealArrangementSaMe;
    }

    public void setDealArrangementSaMe(String dealArrangementSaMe) { 
        this.dealArrangementSaMe=dealArrangementSaMe;
    }
    public String getDealNumber() { 
        return this.dealNumber;
    }

    public void setDealNumber(String dealNumber) { 
        this.dealNumber=dealNumber;
    }
    public String getAttribute21() { 
        return this.attribute21;
    }

    public void setAttribute21(String attribute21) { 
        this.attribute21=attribute21;
    }
    public String getSalesNodeLevel4() { 
        return this.salesNodeLevel4;
    }

    public void setSalesNodeLevel4(String salesNodeLevel4) { 
        this.salesNodeLevel4=salesNodeLevel4;
    }
    public String getAttribute20() { 
        return this.attribute20;
    }

    public void setAttribute20(String attribute20) { 
        this.attribute20=attribute20;
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
    public String getSalesNodeLevel3() { 
        return this.salesNodeLevel3;
    }

    public void setSalesNodeLevel3(String salesNodeLevel3) { 
        this.salesNodeLevel3=salesNodeLevel3;
    }
    public String getDealArrangementQtr() { 
        return this.dealArrangementQtr;
    }

    public void setDealArrangementQtr(String dealArrangementQtr) { 
        this.dealArrangementQtr=dealArrangementQtr;
    }
    public String getAttribute25() { 
        return this.attribute25;
    }

    public void setAttribute25(String attribute25) { 
        this.attribute25=attribute25;
    }
    public String getAttribute24() { 
        return this.attribute24;
    }

    public void setAttribute24(String attribute24) { 
        this.attribute24=attribute24;
    }
    public String getAttribute23() { 
        return this.attribute23;
    }

    public void setAttribute23(String attribute23) { 
        this.attribute23=attribute23;
    }
    public BigDecimal getRevAccountantId() { 
        return this.revAccountantId;
    }

    public void setRevAccountantId(BigDecimal revAccountantId) { 
    	RmanUsers rmanUser = new RmanUsers();
    	rmanUser.setRmanUserId(revAccountantId);
    	this.setAnalystUser(rmanUser);
    	this.revAccountantId = revAccountantId;
    }
    public String getAttribute22() { 
        return this.attribute22;
    }

    public void setAttribute22(String attribute22) { 
        this.attribute22=attribute22;
    }
    public String getReasonCode() { 
        return this.reasonCode;
    }

    public void setReasonCode(String reasonCode) { 
        this.reasonCode=reasonCode;
    }
    public String getMasterArrgFlag() { 
        return this.masterArrgFlag;
    }

    public void setMasterArrgFlag(String masterArrgFlag) { 
        this.masterArrgFlag=masterArrgFlag;
    }
    public String getSalesNodeLevel1() { 
        return this.salesNodeLevel1;
    }

    public void setSalesNodeLevel1(String salesNodeLevel1) { 
        this.salesNodeLevel1=salesNodeLevel1;
    }
    public BigDecimal getDealArrangementId() { 
        return this.dealArrangementId;
    }

    public void setDealArrangementId(BigDecimal dealArrangementId) { 
        this.dealArrangementId=dealArrangementId;
    }
    public String getLegalEntityName() { 
        return this.legalEntityName;
    }

    public void setLegalEntityName(String legalEntityName) { 
        this.legalEntityName=legalEntityName;
    }
    public String getAttribute18() { 
        return this.attribute18;
    }

    public void setAttribute18(String attribute18) { 
        this.attribute18=attribute18;
    }
    public String getAttribute17() { 
        return this.attribute17;
    }

    public void setAttribute17(String attribute17) { 
        this.attribute17=attribute17;
    }
    public String getAttribute16() { 
        return this.attribute16;
    }

    public void setAttribute16(String attribute16) { 
        this.attribute16=attribute16;
    }
    public String getAttribute15() { 
        return this.attribute15;
    }

    public void setAttribute15(String attribute15) { 
        this.attribute15=attribute15;
    }
    public String getDealAgreementName() { 
        return this.dealAgreementName;
    }

    public void setDealAgreementName(String dealAgreementName) { 
        this.dealAgreementName=dealAgreementName;
    }
    public String getAttribute19() { 
        return this.attribute19;
    }

    public void setAttribute19(String attribute19) { 
        this.attribute19=attribute19;
    }
    
    public RmanUsers getManagerUser() {
		return managerUser;
	}

	public void setManagerUser(RmanUsers managerUser) {
		this.managerUser = managerUser;
	}

	public RmanUsers getAnalystUser() {
		return analystUser;
	}

	public void setAnalystUser(RmanUsers analystUser) {
		this.analystUser = analystUser;
	}
    
}