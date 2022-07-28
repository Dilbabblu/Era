package com.forsys.revmantra.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="RMAN_RESPONSIBILITIES")
public class RmanResponsibilitiesLookup {

    @Id
    @Column(name="RESPONSIBILITY_ID")
    private BigDecimal responsibilityId;

    @Column(name="RESPONSIBILITY_NAME")
    private String responsibilityName;



    public BigDecimal getResponsibilityId() { 
        return this.responsibilityId;
    }

    public void setResponsibilityId(BigDecimal responsibilityId) { 
        this.responsibilityId=responsibilityId;
    }
    public String getResponsibilityName() { 
        return this.responsibilityName;
    }

    public void setResponsibilityName(String responsibilityName) { 
        this.responsibilityName=responsibilityName;
    }

}