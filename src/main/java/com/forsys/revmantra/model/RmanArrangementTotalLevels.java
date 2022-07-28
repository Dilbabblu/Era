package com.forsys.revmantra.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="RMAN_ARRANGEMENT_TOTAL_LEVELS")
public class RmanArrangementTotalLevels {

    @Column(name="BOOKINGSAMOUNT")
    private BigDecimal bookingsamount;

    @Column(name="COGSREV")
    private BigDecimal cogsrev;

    @Column(name="REVRECOGNIZEAMOUNT")
    private BigDecimal revrecognizeamount;

    @Column(name="BILLEDAMOUNT")
    private BigDecimal billedamount;

    @Column(name="REVDEFFERED")
    private BigDecimal revdeffered;

    @Column(name="ARRANGEMENTAMOUNT")
    private BigDecimal arrangementamount;

    @Column(name="GROSSMARGIN")
    private BigDecimal grossmargin;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="DEAL_ARRANGEMENT_ID")
    private BigDecimal dealArrangementId;

    @Column(name="SHIPPEDAMOUNT")
    private BigDecimal shippedamount;



    public BigDecimal getBookingsamount() { 
        return this.bookingsamount;
    }

    public void setBookingsamount(BigDecimal bookingsamount) { 
        this.bookingsamount=bookingsamount;
    }
    public BigDecimal getCogsrev() { 
        return this.cogsrev;
    }

    public void setCogsrev(BigDecimal cogsrev) { 
        this.cogsrev=cogsrev;
    }
    public BigDecimal getRevrecognizeamount() { 
        return this.revrecognizeamount;
    }

    public void setRevrecognizeamount(BigDecimal revrecognizeamount) { 
        this.revrecognizeamount=revrecognizeamount;
    }
    public BigDecimal getBilledamount() { 
        return this.billedamount;
    }

    public void setBilledamount(BigDecimal billedamount) { 
        this.billedamount=billedamount;
    }
    public BigDecimal getRevdeffered() { 
        return this.revdeffered;
    }

    public void setRevdeffered(BigDecimal revdeffered) { 
        this.revdeffered=revdeffered;
    }
    public BigDecimal getArrangementamount() { 
        return this.arrangementamount;
    }

    public void setArrangementamount(BigDecimal arrangementamount) { 
        this.arrangementamount=arrangementamount;
    }
    public BigDecimal getGrossmargin() { 
        return this.grossmargin;
    }

    public void setGrossmargin(BigDecimal grossmargin) { 
        this.grossmargin=grossmargin;
    }
    public BigDecimal getDealArrangementId() { 
        return this.dealArrangementId;
    }

    public void setDealArrangementId(BigDecimal dealArrangementId) { 
        this.dealArrangementId=dealArrangementId;
    }
    public BigDecimal getShippedamount() { 
        return this.shippedamount;
    }

    public void setShippedamount(BigDecimal shippedamount) { 
        this.shippedamount=shippedamount;
    }

}