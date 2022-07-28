package com.forsys.revmantra.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="RMAN_FC_CONVERSION_TYPES")
public class RmanFcConversionTypesLookup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CONVERSION_TYPE")
    private String conversionType;

    @Column(name="DESCRIPTION")
    private String description;



    public String getConversionType() { 
        return this.conversionType;
    }

    public void setConversionType(String conversionType) { 
        this.conversionType=conversionType;
    }
    public String getDescription() { 
        return this.description;
    }

    public void setDescription(String description) { 
        this.description=description;
    }

}