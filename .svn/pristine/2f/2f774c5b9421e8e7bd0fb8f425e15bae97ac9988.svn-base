package com.forsys.revmantra.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="RMAN_FC_METHODS")
public class RmanFcMethodsLookup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="FC_METHOD_ID")
    private BigDecimal fcMethodId;

    @Column(name="NAME")
    private String name;



    public BigDecimal getFcMethodId() { 
        return this.fcMethodId;
    }

    public void setFcMethodId(BigDecimal fcMethodId) { 
        this.fcMethodId=fcMethodId;
    }
    public String getName() { 
        return this.name;
    }

    public void setName(String name) { 
        this.name=name;
    }

}