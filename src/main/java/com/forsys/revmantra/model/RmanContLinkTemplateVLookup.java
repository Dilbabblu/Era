package com.forsys.revmantra.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="RMAN_CONT_LINK_TEMPLATE_V")
public class RmanContLinkTemplateVLookup {

    @Column(name="TEMPLATE_NAME")
    private String templateName;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="TEMPLATE_ID")
    private BigDecimal templateId;



    public String getTemplateName() { 
        return this.templateName;
    }

    public void setTemplateName(String templateName) { 
        this.templateName=templateName;
    }
    public BigDecimal getTemplateId() { 
        return this.templateId;
    }

    public void setTemplateId(BigDecimal templateId) { 
        this.templateId=templateId;
    }

}