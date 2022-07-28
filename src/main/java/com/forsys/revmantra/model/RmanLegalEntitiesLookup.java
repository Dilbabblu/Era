package com.forsys.revmantra.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="RMAN_LEGAL_ENTITIES")
public class RmanLegalEntitiesLookup {

    @Id
    private BigDecimal legalEntityId;

    @Column(name="NAME")
    private String name;



    public BigDecimal getLegalEntityId() { 
        return this.legalEntityId;
    }

    public void setLegalEntityId(BigDecimal legalEntityId) { 
        this.legalEntityId=legalEntityId;
    }
    public String getName() { 
        return this.name;
    }

    public void setName(String name) { 
        this.name=name;
    }

}