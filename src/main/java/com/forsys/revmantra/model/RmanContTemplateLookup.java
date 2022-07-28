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
@Table(name="RMAN_CONT_TEMPLATE")
public class RmanContTemplateLookup {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RMAN_CONT_TEMPLATE_seq_gen")
    @SequenceGenerator(name="RMAN_CONT_TEMPLATE_seq_gen", sequenceName="RMAN_CONT_TEMPLATE_S", allocationSize=1)
    @Column(name="TEMPLATE_ID")
    private BigDecimal templateId;

    @Column(name="TEMPLATE_NAME")
    private String templateName;



    public BigDecimal getTemplateId() { 
        return this.templateId;
    }

    public void setTemplateId(BigDecimal templateId) { 
        this.templateId=templateId;
    }
    public String getTemplateName() { 
        return this.templateName;
    }

    public void setTemplateName(String templateName) { 
        this.templateName=templateName;
    }

}