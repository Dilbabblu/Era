package com.forsys.revmantra.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="RMAN_CONT_SOURCE_LOV_IFRS_V")
public class RmanContSourceLov {

    @Column(name="APPLICATION_LEVEL")
    private String applicationLevel;

    @Column(name="SOURCE_LINE_ID")
    private BigDecimal sourceLineId;

    @Column(name="PRE_POST_BOOKING")
    private String prePostBooking;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="SNO")
    private BigDecimal sno;

    @Column(name="SOURCE_NAME")
    private String sourceName;

    @Column(name="SOURCE_HEADER_ID")
    private BigDecimal sourceHeaderId;

    @Column(name="DEAL_ARRANGEMENT_ID")
    private BigDecimal dealArrangementId;

    @Column(name="SOURCE_LINE")
    private String sourceLine;



    public String getApplicationLevel() { 
        return this.applicationLevel;
    }

    public void setApplicationLevel(String applicationLevel) { 
        this.applicationLevel=applicationLevel;
    }
    public BigDecimal getSourceLineId() { 
        return this.sourceLineId;
    }

    public void setSourceLineId(BigDecimal sourceLineId) { 
        this.sourceLineId=sourceLineId;
    }
    public String getPrePostBooking() { 
        return this.prePostBooking;
    }

    public void setPrePostBooking(String prePostBooking) { 
        this.prePostBooking=prePostBooking;
    }
    public BigDecimal getSno() { 
        return this.sno;
    }

    public void setSno(BigDecimal sno) { 
        this.sno=sno;
    }
    public String getSourceName() { 
        return this.sourceName;
    }

    public void setSourceName(String sourceName) { 
        this.sourceName=sourceName;
    }
    public BigDecimal getSourceHeaderId() { 
        return this.sourceHeaderId;
    }

    public void setSourceHeaderId(BigDecimal sourceHeaderId) { 
        this.sourceHeaderId=sourceHeaderId;
    }
    public BigDecimal getDealArrangementId() { 
        return this.dealArrangementId;
    }

    public void setDealArrangementId(BigDecimal dealArrangementId) { 
        this.dealArrangementId=dealArrangementId;
    }
    public String getSourceLine() { 
        return this.sourceLine;
    }

    public void setSourceLine(String sourceLine) { 
        this.sourceLine=sourceLine;
    }

}