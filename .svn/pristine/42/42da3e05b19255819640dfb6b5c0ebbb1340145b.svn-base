package com.forsys.revmantra.model;

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

import com.forsys.revmantra.listener.RmanRulesHeaderListener;


@Entity
@EntityListeners(RmanRulesHeaderListener.class)
@Table(name="RMAN_RULES_HEADER")
public class RmanRulesHeader {

    @Column(name="ATTRIBUTE10")
    private String attribute10;

    @Column(name="DEAL_FLAG")
    private String dealFlag;

    @Column(name="ATTRIBUTE30")
    private String attribute30;

    @Column(name="ATTRIBUTE14")
    private String attribute14;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RMAN_RULES_HEADER_seq_gen")
    @SequenceGenerator(name="RMAN_RULES_HEADER_seq_gen", sequenceName="RMAN_RULES_HEADER_S", allocationSize=1)
    @Column(name="RULE_HEADER_ID")
    private BigDecimal ruleHeaderId;

    @Column(name="ATTRIBUTE13")
    private String attribute13;

    @Column(name="ATTRIBUTE12")
    private String attribute12;

    @Column(name="ATTRIBUTE11")
    private String attribute11;

    @Column(name="RULE_NAME")
    private String ruleName;

    @Column(name="RULE_MASTER_ID")
    private BigDecimal ruleMasterId;

    @Column(name="LAST_UPDATE_DATE")
    private Timestamp lastUpdateDate;

    @Column(name="RULE_END_DATE")
    private Timestamp ruleEndDate;

    @Column(name="SEQUENCE_NUMBER")
    private BigDecimal sequenceNumber;

    @Column(name="APPROVER_ID")
    private BigDecimal approverId;

    @Column(name="RULE_CATEGORY")
    private String ruleCategory;

    @Column(name="DESCRIPTION")
    private String description;

    @Column(name="ATTRIBUTE29")
    private String attribute29;

    @Column(name="ATTRIBUTE28")
    private String attribute28;

    @Column(name="ATTRIBUTE27")
    private String attribute27;

    @Column(name="ATTRIBUTE26")
    private String attribute26;

    @Column(name="RULE_START_DATE")
    private Timestamp ruleStartDate;

    @Column(name="ATTRIBUTE3")
    private String attribute3;

    @Column(name="ATTRIBUTE21")
    private String attribute21;

    @Column(name="CREATED_BY")
    private BigDecimal createdBy;

    @Column(name="ATTRIBUTE2")
    private String attribute2;

    @Column(name="ATTRIBUTE20")
    private String attribute20;

    @Column(name="LAST_UPDATED_BY")
    private BigDecimal lastUpdatedBy;

    @Column(name="ATTRIBUTE1")
    private String attribute1;

    @Column(name="ATTRIBUTE25")
    private String attribute25;

    @Column(name="ATTRIBUTE24")
    private String attribute24;

    @Column(name="ATTRIBUTE23")
    private String attribute23;

    @Column(name="ATTRIBUTE22")
    private String attribute22;

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

    @Column(name="ATTRIBUTE18")
    private String attribute18;

    @Column(name="ATTRIBUTE17")
    private String attribute17;

    @Column(name="ATTRIBUTE16")
    private String attribute16;

    @Column(name="ATTRIBUTE15")
    private String attribute15;

    @Column(name="ATTRIBUTE19")
    private String attribute19;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="RULE_CATEGORY",insertable = false, updatable = false )
    private RmanLookupsV rmanLookupsV;


    public String getAttribute10() { 
        return this.attribute10;
    }

    public void setAttribute10(String attribute10) { 
        this.attribute10=attribute10;
    }
    public String getDealFlag() { 
        return this.dealFlag;
    }

    public void setDealFlag(String dealFlag) { 
        this.dealFlag=dealFlag;
    }
    public String getAttribute30() { 
        return this.attribute30;
    }

    public void setAttribute30(String attribute30) { 
        this.attribute30=attribute30;
    }
    public String getAttribute14() { 
        return this.attribute14;
    }

    public void setAttribute14(String attribute14) { 
        this.attribute14=attribute14;
    }
    public BigDecimal getRuleHeaderId() { 
        return this.ruleHeaderId;
    }

    public void setRuleHeaderId(BigDecimal ruleHeaderId) { 
        this.ruleHeaderId=ruleHeaderId;
    }
    public String getAttribute13() { 
        return this.attribute13;
    }

    public void setAttribute13(String attribute13) { 
        this.attribute13=attribute13;
    }
    public String getAttribute12() { 
        return this.attribute12;
    }

    public void setAttribute12(String attribute12) { 
        this.attribute12=attribute12;
    }
    public String getAttribute11() { 
        return this.attribute11;
    }

    public void setAttribute11(String attribute11) { 
        this.attribute11=attribute11;
    }
    public String getRuleName() { 
        return this.ruleName;
    }

    public void setRuleName(String ruleName) { 
        this.ruleName=ruleName;
    }
    public BigDecimal getRuleMasterId() { 
        return this.ruleMasterId;
    }

    public void setRuleMasterId(BigDecimal ruleMasterId) { 
        this.ruleMasterId=ruleMasterId;
    }
    public Timestamp getLastUpdateDate() { 
        return this.lastUpdateDate;
    }

    public void setLastUpdateDate(Timestamp lastUpdateDate) { 
        this.lastUpdateDate=lastUpdateDate;
    }
    public Timestamp getRuleEndDate() { 
        return this.ruleEndDate;
    }

    public void setRuleEndDate(Timestamp ruleEndDate) { 
        this.ruleEndDate=ruleEndDate;
    }
    public BigDecimal getSequenceNumber() { 
        return this.sequenceNumber;
    }

    public void setSequenceNumber(BigDecimal sequenceNumber) { 
        this.sequenceNumber=sequenceNumber;
    }
    public BigDecimal getApproverId() { 
        return this.approverId;
    }

    public void setApproverId(BigDecimal approverId) { 
        this.approverId=approverId;
    }
    public String getRuleCategory() { 
        return this.ruleCategory;
    }

    public void setRuleCategory(String ruleCategory) { 
        this.ruleCategory=ruleCategory;
    }
    public String getDescription() { 
        return this.description;
    }

    public void setDescription(String description) { 
        this.description=description;
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
    public String getAttribute27() { 
        return this.attribute27;
    }

    public void setAttribute27(String attribute27) { 
        this.attribute27=attribute27;
    }
    public String getAttribute26() { 
        return this.attribute26;
    }

    public void setAttribute26(String attribute26) { 
        this.attribute26=attribute26;
    }
    public Timestamp getRuleStartDate() { 
        return this.ruleStartDate;
    }

    public void setRuleStartDate(Timestamp ruleStartDate) { 
        this.ruleStartDate=ruleStartDate;
    }
    public String getAttribute3() { 
        return this.attribute3;
    }

    public void setAttribute3(String attribute3) { 
        this.attribute3=attribute3;
    }
    public String getAttribute21() { 
        return this.attribute21;
    }

    public void setAttribute21(String attribute21) { 
        this.attribute21=attribute21;
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
    public String getAttribute20() { 
        return this.attribute20;
    }

    public void setAttribute20(String attribute20) { 
        this.attribute20=attribute20;
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
    public String getAttribute22() { 
        return this.attribute22;
    }

    public void setAttribute22(String attribute22) { 
        this.attribute22=attribute22;
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
    public String getAttribute19() { 
        return this.attribute19;
    }

    public void setAttribute19(String attribute19) { 
        this.attribute19=attribute19;
    }
  public RmanLookupsV getRmanLookupsV() {
         return rmanLookupsV;
    }

    public void setRmanLookupsV(RmanLookupsV rmanLookupsV) {
         this.rmanLookupsV=rmanLookupsV;
    }


}