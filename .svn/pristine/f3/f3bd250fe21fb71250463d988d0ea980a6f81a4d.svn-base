package com.forsys.revmantra.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="RMAN_LOOKUPS_V")
public class RmanLookupsVLookup {

    @Column(name="LOOKUP_DESCRIPTION")
    private String lookupDescription;

    @Id
    @Column(name="LOOKUP_CODE")
    private String lookupCode;



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