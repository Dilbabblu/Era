package com.forsys.revmantra.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Where;


@Entity
@Table(name="RMAN_LOOKUPS_V")
@Where(clause="LOOKUP_TYPE_NAME='ACCOUNTING_STANDARD'")
public class RmanLookupsContV {

    
    @Column(name="LOOKUP_TYPE_NAME")
    private String lookupTypeName;


    @Column(name="LOOKUP_DESCRIPTION")
    private String lookupDescription;

    @Id
    @Column(name="LOOKUP_CODE")
    private String lookupCode;


    public String getLookupTypeName() { 
        return this.lookupTypeName;
    }

    public void setLookupTypeName(String lookupTypeName) { 
        this.lookupTypeName=lookupTypeName;
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

}