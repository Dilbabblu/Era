package com.forsys.revmantra.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Where;


@Entity
@Table(name="RMAN_LOOKUPS_V")
@Where(clause="LOOKUP_TYPE_NAME='ENABLED_FLAG'")
public class RmanLookupsV1 {

    @Column(name="LOOKUP_CODE_END_DATE")
    private Timestamp lookupCodeEndDate;

    @Column(name="LOOKUP_TYPE_NAME")
    private String lookupTypeName;

    @Column(name="LOOKUP_TYPE_ENABLED_FLAG")
    private String lookupTypeEnabledFlag;

    @Column(name="LOOKUP_CODE_ENABLED_FLAG")
    private String lookupCodeEnabledFlag;

    @Column(name="LOOKUP_TYPE_DESCRIPTION")
    private String lookupTypeDescription;

    @Column(name="LOOKUP_DESCRIPTION")
    private String lookupDescription;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="RMAN_LOOKUPS_V_seq_gen")
    @SequenceGenerator(name="RMAN_LOOKUPS_V_seq_gen", sequenceName="LOOKUP_CODE_S")
    @Column(name="LOOKUP_CODE")
    private String lookupCode;

    @Column(name="LOOKUP_TYPE_END_DATE")
    private Timestamp lookupTypeEndDate;

    @Column(name="LOOKUP_TYPE_START_DATE")
    private Timestamp lookupTypeStartDate;

    @Column(name="LOOKUP_CODE_START_DATE")
    private Timestamp lookupCodeStartDate;

    @Column(name="LOOKUP_TYPE_MEANING")
    private String lookupTypeMeaning;



    public Timestamp getLookupCodeEndDate() { 
        return this.lookupCodeEndDate;
    }

    public void setLookupCodeEndDate(Timestamp lookupCodeEndDate) { 
        this.lookupCodeEndDate=lookupCodeEndDate;
    }
    public String getLookupTypeName() { 
        return this.lookupTypeName;
    }

    public void setLookupTypeName(String lookupTypeName) { 
        this.lookupTypeName=lookupTypeName;
    }
    public String getLookupTypeEnabledFlag() { 
        return this.lookupTypeEnabledFlag;
    }

    public void setLookupTypeEnabledFlag(String lookupTypeEnabledFlag) { 
        this.lookupTypeEnabledFlag=lookupTypeEnabledFlag;
    }
    public String getLookupCodeEnabledFlag() { 
        return this.lookupCodeEnabledFlag;
    }

    public void setLookupCodeEnabledFlag(String lookupCodeEnabledFlag) { 
        this.lookupCodeEnabledFlag=lookupCodeEnabledFlag;
    }
    public String getLookupTypeDescription() { 
        return this.lookupTypeDescription;
    }

    public void setLookupTypeDescription(String lookupTypeDescription) { 
        this.lookupTypeDescription=lookupTypeDescription;
    }
    public String getLookupDescription() { 
        return this.lookupDescription;
    }

    public void setLookupDescription(String lookupDescription) { 
        this.lookupDescription=lookupDescription;
    }
    public String getLookupCode() { 
        return this.lookupCode;
    }

    public void setLookupCode(String lookupCode) { 
        this.lookupCode=lookupCode;
    }
    public Timestamp getLookupTypeEndDate() { 
        return this.lookupTypeEndDate;
    }

    public void setLookupTypeEndDate(Timestamp lookupTypeEndDate) { 
        this.lookupTypeEndDate=lookupTypeEndDate;
    }
    public Timestamp getLookupTypeStartDate() { 
        return this.lookupTypeStartDate;
    }

    public void setLookupTypeStartDate(Timestamp lookupTypeStartDate) { 
        this.lookupTypeStartDate=lookupTypeStartDate;
    }
    public Timestamp getLookupCodeStartDate() { 
        return this.lookupCodeStartDate;
    }

    public void setLookupCodeStartDate(Timestamp lookupCodeStartDate) { 
        this.lookupCodeStartDate=lookupCodeStartDate;
    }
    public String getLookupTypeMeaning() { 
        return this.lookupTypeMeaning;
    }

    public void setLookupTypeMeaning(String lookupTypeMeaning) { 
        this.lookupTypeMeaning=lookupTypeMeaning;
    }

}