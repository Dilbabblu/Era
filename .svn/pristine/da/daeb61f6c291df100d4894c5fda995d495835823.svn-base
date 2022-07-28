package com.forsys.revmantra.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="RMAN_ENTITY_PARAMETERS_V")
public class RmanEntityParametersVLookup {

    @Column(name="PARAMETER_NAME")
    private String parameterName;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="RMAN_ENTITY_PARAMETERS_V_seq_gen")
    @SequenceGenerator(name="RMAN_ENTITY_PARAMETERS_V_seq_gen", sequenceName="RMAN_ENTITY_PARAMETERS_V_S")
    @Column(name="ENTITY_PARAMETER_ID")
    private BigDecimal entityParameterId;



    public String getParameterName() { 
        return this.parameterName;
    }

    public void setParameterName(String parameterName) { 
        this.parameterName=parameterName;
    }
    public BigDecimal getEntityParameterId() { 
        return this.entityParameterId;
    }

    public void setEntityParameterId(BigDecimal entityParameterId) { 
        this.entityParameterId=entityParameterId;
    }

}