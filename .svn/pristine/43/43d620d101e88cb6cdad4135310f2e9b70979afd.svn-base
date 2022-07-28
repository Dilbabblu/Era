package com.forsys.revmantra.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.forsys.revmantra.listener.RmanLookupTypesListener;


@Entity
@EntityListeners(RmanLookupTypesListener.class)
@Table(name="RMAN_LOOKUP_TYPES")
public class RmanLookupTypes {

    @Column(name="ATTRIBUTE3")
    private String attribute3;

    @Column(name="CREATED_BY")
    private BigDecimal createdBy;

    @Column(name="ATTRIBUTE2")
    private String attribute2;

    @Column(name="LAST_UPDATED_BY")
    private BigDecimal lastUpdatedBy;

    @Column(name="START_DATE_ACTIVE")
    private Timestamp startDateActive;

    @Column(name="ATTRIBUTE1")
    private String attribute1;

    @Column(name="CREATION_DATE")
    private Timestamp creationDate;

    @Column(name="MEANING")
    private String meaning;

    @Column(name="ENABLED_FLAG")
    private String enabledFlag;

    @Column(name="LAST_UPDATE_DATE")
    private Timestamp lastUpdateDate;

    @Column(name="ATTRIBUTE5")
    private String attribute5;

    @Column(name="ATTRIBUTE4")
    private String attribute4;

    @Id
    @Column(name="LOOKUP_TYPE_NAME")
    private String lookupTypeName;

    @Column(name="DESCRIPTION")
    private String description;

    @Column(name="END_DATE_ACTIVE")
    private Timestamp endDateActive;

    @Column(name="SEEDED_FLAG")
    private String seededFlag;

 @OneToOne(fetch = FetchType.EAGER)
 @JoinColumn(name="ENABLED_FLAG",insertable = false, updatable = false )
    private RmanLookupsV1 rmanLookupsV;


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
    public Timestamp getStartDateActive() { 
        return this.startDateActive;
    }

    public void setStartDateActive(Timestamp startDateActive) { 
        this.startDateActive=startDateActive;
    }
    public String getAttribute1() { 
        return this.attribute1;
    }

    public void setAttribute1(String attribute1) { 
        this.attribute1=attribute1;
    }
    public Timestamp getCreationDate() { 
        return this.creationDate;
    }

    public void setCreationDate(Timestamp creationDate) { 
        this.creationDate=creationDate;
    }
    public String getMeaning() { 
        return this.meaning;
    }

    public void setMeaning(String meaning) { 
        this.meaning=meaning;
    }
    public String getEnabledFlag() { 
        return this.enabledFlag;
    }

    public void setEnabledFlag(String enabledFlag) { 
        this.enabledFlag=enabledFlag;
    }
    public Timestamp getLastUpdateDate() { 
        return this.lastUpdateDate;
    }

    public void setLastUpdateDate(Timestamp lastUpdateDate) { 
        this.lastUpdateDate=lastUpdateDate;
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
    public String getLookupTypeName() { 
        return this.lookupTypeName;
    }

    public void setLookupTypeName(String lookupTypeName) { 
        this.lookupTypeName=lookupTypeName;
    }
    public String getDescription() { 
        return this.description;
    }

    public void setDescription(String description) { 
        this.description=description;
    }
    public Timestamp getEndDateActive() { 
        return this.endDateActive;
    }

    public void setEndDateActive(Timestamp endDateActive) { 
        this.endDateActive=endDateActive;
    }
    public String getSeededFlag() { 
        return this.seededFlag;
    }

    public void setSeededFlag(String seededFlag) { 
        this.seededFlag=seededFlag;
    }
    public RmanLookupsV1 getRmanLookupsV() {
         return rmanLookupsV;
    }

    public void setRmanLookupsV(RmanLookupsV1 rmanLookupsV) {
         this.rmanLookupsV=rmanLookupsV;
    }


}