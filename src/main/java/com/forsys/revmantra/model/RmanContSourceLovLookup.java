package com.forsys.revmantra.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="RMAN_CONT_SOURCE_LOV")
public class RmanContSourceLovLookup {

    @Column(name="SOURCE_NAME")
    private String sourceName;

    @Id
    @Column(name="SOURCE_HEADER_ID")
    private BigDecimal sourceHeaderId;



    public String getSourceName() { 
        return this.sourceName;
    }

    public void setSourceName(String sourceName) { 
        this.sourceName=sourceName;
    }
    public BigDecimal getSourceHeaderId() { 
        return this.sourceHeaderId;
    }

    public void setSourceHeaderId(BigDecimal sourceHeaderId) { 
        this.sourceHeaderId=sourceHeaderId;
    }

}