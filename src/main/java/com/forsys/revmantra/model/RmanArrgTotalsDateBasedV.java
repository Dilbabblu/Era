package com.forsys.revmantra.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="RMAN_ARRG_TOTALS_DATE_BASED_V")
public class RmanArrgTotalsDateBasedV {
    
    @Id
    @Column(name="SNO")
    private BigDecimal sno;


    @Column(name="MONTH")
    private String month;

    @Column(name="YEAR")
    private String year;

    @Column(name="AMOUNT")
    private BigDecimal amount;

    @Column(name="TYPE")
    private String type;
    
    @Column(name="TYPE_ID")
    private BigDecimal typeId;

    @Column(name="DEAL_ARRANGEMENT_ID")
    private BigDecimal dealArrangementId;
    
    
    
    public BigDecimal getTypeId() {
        return typeId;
    }

    public void setTypeId(BigDecimal typeId) {
        this.typeId = typeId;
    }

    public BigDecimal getSno() {
        return sno;
    }

    public void setSno(BigDecimal sno) {
        this.sno = sno;
    }

    public String getMonth() { 
        return this.month;
    }

    public void setMonth(String month) { 
        this.month=month;
    }
    public String getYear() { 
        return this.year;
    }

    public void setYear(String year) { 
        this.year=year;
    }
    public BigDecimal getAmount() { 
        return this.amount;
    }

    public void setAmount(BigDecimal amount) { 
        this.amount=amount;
    }
    public String getType() { 
        return this.type;
    }

    public void setType(String type) { 
        this.type=type;
    }
    public BigDecimal getDealArrangementId() { 
        return this.dealArrangementId;
    }

    public void setDealArrangementId(BigDecimal dealArrangementId) { 
        this.dealArrangementId=dealArrangementId;
    }

}