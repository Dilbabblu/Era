package com.forsys.revmantra.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="RMAN_ARRG_LINE_OF_BUSINESS_V")
public class RmanArrgLineOfBusinessV {

    @Column(name="LINE_OF_BUSINESS")
    private String lineOfBusiness;
    
    
    
    @Id
    @Column(name="SNO")
    private BigDecimal sno;

    @Column(name="LINE_OF_BUSINESS_NAME")
    private String lineOfBusinessName;

    @Column(name="AMOUNT")
    private BigDecimal amount;

    @Column(name="DEAL_ARRANGEMENT_ID")
    private BigDecimal dealArrangementId;



    public String getLineOfBusiness() { 
        return this.lineOfBusiness;
    }

    public void setLineOfBusiness(String lineOfBusiness) { 
        this.lineOfBusiness=lineOfBusiness;
    }
    public BigDecimal getSno() { 
        return this.sno;
    }

    public void setSno(BigDecimal sno) { 
        this.sno=sno;
    }
    public String getLineOfBusinessName() { 
        return this.lineOfBusinessName;
    }

    public void setLineOfBusinessName(String lineOfBusinessName) { 
        this.lineOfBusinessName=lineOfBusinessName;
    }
    public BigDecimal getAmount() { 
        return this.amount;
    }

    public void setAmount(BigDecimal amount) { 
        this.amount=amount;
    }
    public BigDecimal getDealArrangementId() { 
        return this.dealArrangementId;
    }

    public void setDealArrangementId(BigDecimal dealArrangementId) { 
        this.dealArrangementId=dealArrangementId;
    }

}