package com.forsys.revmantra.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="RMAN_CONT_HEADER_V")
public class RmanContHeaderVLookup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="RULE_HEADER_ID")
    private BigDecimal ruleHeaderId;

    @Column(name="RULE_NAME")
    private String ruleName;



    public BigDecimal getRuleHeaderId() { 
        return this.ruleHeaderId;
    }

    public void setRuleHeaderId(BigDecimal ruleHeaderId) { 
        this.ruleHeaderId=ruleHeaderId;
    }
    public String getRuleName() { 
        return this.ruleName;
    }

    public void setRuleName(String ruleName) { 
        this.ruleName=ruleName;
    }

}