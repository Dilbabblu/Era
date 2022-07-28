package com.forsys.revmantra.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.forsys.revmantra.listener.RmanFcLevelListener;


@Entity
@EntityListeners(RmanFcLevelListener.class)
@Table(name="RMAN_FC_LEVEL")
public class RmanFcLevel {

    @Column(name="CREATED_BY")
    private BigDecimal createdBy;

    @Column(name="LAST_UPDATED_DATE")
    private Timestamp lastUpdatedDate;

    @Column(name="LAST_UPDATED_BY")
    private BigDecimal lastUpdatedBy;

    @Column(name="CREATED_DATE")
    private Timestamp createdDate;

    @Column(name="END_DATE")
    private Timestamp endDate;

    @Column(name="START_DATE")
    private Timestamp startDate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="LEVEL_ID")
    private BigDecimal levelId;

    @Column(name="NAME")
    private String name;



    public BigDecimal getCreatedBy() { 
        return this.createdBy;
    }

    public void setCreatedBy(BigDecimal createdBy) { 
        this.createdBy=createdBy;
    }
    public Timestamp getLastUpdatedDate() { 
        return this.lastUpdatedDate;
    }

    public void setLastUpdatedDate(Timestamp lastUpdatedDate) { 
        this.lastUpdatedDate=lastUpdatedDate;
    }
    public BigDecimal getLastUpdatedBy() { 
        return this.lastUpdatedBy;
    }

    public void setLastUpdatedBy(BigDecimal lastUpdatedBy) { 
        this.lastUpdatedBy=lastUpdatedBy;
    }
    public Timestamp getCreatedDate() { 
        return this.createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) { 
        this.createdDate=createdDate;
    }
    public Timestamp getEndDate() { 
        return this.endDate;
    }

    public void setEndDate(Timestamp endDate) { 
        this.endDate=endDate;
    }
    public Timestamp getStartDate() { 
        return this.startDate;
    }

    public void setStartDate(Timestamp startDate) { 
        this.startDate=startDate;
    }
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