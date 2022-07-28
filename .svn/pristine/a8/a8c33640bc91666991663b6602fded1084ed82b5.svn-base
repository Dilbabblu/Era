package com.forsys.revmantra.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.forsys.revmantra.listener.RmanContTemplateListener;


@Entity
@EntityListeners(RmanContTemplateListener.class)
@Table(name="RMAN_CONT_TEMPLATE")
public class RmanContTemplate {

    @Column(name="ATTRIBUTE10")
    private String attribute10;

    @Column(name="INVOICE_HOLD")
    private String invoiceHold;

    @Column(name="ATTRIBUTE14")
    private String attribute14;

    @Column(name="ATTRIBUTE13")
    private String attribute13;

    @Column(name="ATTRIBUTE12")
    private String attribute12;

    @Column(name="COGS")
    private BigDecimal cogs;

    @Column(name="ATTRIBUTE11")
    private String attribute11;

    @Column(name="APPLY_TYPE")
    private String applyType;

    @Column(name="LAST_UPDATE_DATE")
    private Timestamp lastUpdateDate;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RMAN_CONT_TEMPLATE_seq_gen")
    @SequenceGenerator(name="RMAN_CONT_TEMPLATE_seq_gen", sequenceName="RMAN_CONT_TEMPLATE_S", allocationSize=1)
    @Column(name="TEMPLATE_ID")
    private BigDecimal templateId;

    @Column(name="DESCRIPTION")
    private String description;

    @Column(name="EFFECTIVE_END_DATE")
    private Timestamp effectiveEndDate;

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

    @Column(name="REVENUE")
    private BigDecimal revenue;

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

    @Column(name="DEFAULT_DAYS")
    private BigDecimal defaultDays;

    @Column(name="ATTRIBUTE5")
    private String attribute5;

    @Column(name="ATTRIBUTE4")
    private String attribute4;

    @Column(name="EFFECTIVE_START_DATE")
    private Timestamp effectiveStartDate;

    @Column(name="TEMPLATE_NAME")
    private String templateName;

    @Column(name="ATTRIBUTE15")
    private String attribute15;

 /**@OneToOne(fetch = FetchType.EAGER)
 @JoinColumn(name="APPLY_TYPE",insertable = false, updatable = false )
    private RmanLookupsV4 rmanLookupsV;
 @OneToOne(fetch = FetchType.EAGER)
 @JoinColumn(name="INVOICE_HOLD",insertable = false, updatable = false )
    private RmanLookupsV1 rmanLookupsV1;*/


    public String getAttribute10() { 
        return this.attribute10;
    }

    public void setAttribute10(String attribute10) { 
        this.attribute10=attribute10;
    }
    public String getInvoiceHold() { 
        return this.invoiceHold;
    }

    public void setInvoiceHold(String invoiceHold) { 
        this.invoiceHold=invoiceHold;
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
    public String getAttribute12() { 
        return this.attribute12;
    }

    public void setAttribute12(String attribute12) { 
        this.attribute12=attribute12;
    }
    public BigDecimal getCogs() { 
        return this.cogs;
    }

    public void setCogs(BigDecimal cogs) { 
        this.cogs=cogs;
    }
    public String getAttribute11() { 
        return this.attribute11;
    }

    public void setAttribute11(String attribute11) { 
        this.attribute11=attribute11;
    }
    public String getApplyType() { 
        return this.applyType;
    }

    public void setApplyType(String applyType) { 
        this.applyType=applyType;
    }
    public Timestamp getLastUpdateDate() { 
        return this.lastUpdateDate;
    }

    public void setLastUpdateDate(Timestamp lastUpdateDate) { 
        this.lastUpdateDate=lastUpdateDate;
    }
    public BigDecimal getTemplateId() { 
        return this.templateId;
    }

    public void setTemplateId(BigDecimal templateId) { 
        this.templateId=templateId;
    }
    public String getDescription() { 
        return this.description;
    }

    public void setDescription(String description) { 
        this.description=description;
    }
    public Timestamp getEffectiveEndDate() { 
        return this.effectiveEndDate;
    }

    public void setEffectiveEndDate(Timestamp effectiveEndDate) { 
        this.effectiveEndDate=effectiveEndDate;
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
    public BigDecimal getRevenue() { 
        return this.revenue;
    }

    public void setRevenue(BigDecimal revenue) { 
        this.revenue=revenue;
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
    public BigDecimal getDefaultDays() { 
        return this.defaultDays;
    }

    public void setDefaultDays(BigDecimal defaultDays) { 
        this.defaultDays=defaultDays;
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
    public Timestamp getEffectiveStartDate() { 
        return this.effectiveStartDate;
    }

    public void setEffectiveStartDate(Timestamp effectiveStartDate) { 
        this.effectiveStartDate=effectiveStartDate;
    }
    public String getTemplateName() { 
        return this.templateName;
    }

    public void setTemplateName(String templateName) { 
        this.templateName=templateName;
    }
    public String getAttribute15() { 
        return this.attribute15;
    }

    public void setAttribute15(String attribute15) { 
        this.attribute15=attribute15;
    }
   /** public RmanLookupsV4 getRmanLookupsV() {
         return rmanLookupsV;
    }

    public void setRmanLookupsV(RmanLookupsV4 rmanLookupsV) {
         this.rmanLookupsV=rmanLookupsV;
    }

    public RmanLookupsV1 getRmanLookupsV1() {
         return rmanLookupsV1;
    }

    public void setRmanLookupsV1(RmanLookupsV1 rmanLookupsV1) {
         this.rmanLookupsV1=rmanLookupsV1;
    }*/


}