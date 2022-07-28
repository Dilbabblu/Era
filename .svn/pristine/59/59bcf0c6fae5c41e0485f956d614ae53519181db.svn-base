package com.forsys.revmantra.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="RMAN_FC_LEVEL")
public class RmanFcLevelLookup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="LEVEL_ID")
    private BigDecimal levelId;

    @Column(name="NAME")
    private String name;



    public BigDecimal getLevelId() { 
        return this.levelId;
    }

    public void setLevelId(BigDecimal levelId) { 
        this.levelId=levelId;
    }
    public String getName() { 
        return this.name;
    }

    public void setName(String name) { 
        this.name=name;
    }

}