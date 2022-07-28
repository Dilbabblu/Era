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

import com.forsys.revmantra.listener.RmanFcMethodsListener;


@Entity
@EntityListeners(RmanFcMethodsListener.class)
@Table(name="RMAN_FC_METHODS")
public class RmanFcMethods {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="FC_METHOD_ID")
    private BigDecimal fcMethodId;

    @Column(name="CREATED_BY")
    private BigDecimal createdBy;

    @Column(name="LAST_UPDATED_DATE")
    private Timestamp lastUpdatedDate;

    @Column(name="LAST_UPDATED_BY")
    private BigDecimal lastUpdatedBy;

    @Column(name="DESCRIPTION")
    private String description;

    @Column(name="CREATED_DATE")
    private Timestamp createdDate;

    @Column(name="VERSION")
    private BigDecimal version;

    @Column(name="END_DATE")
    private Timestamp endDate;

    @Column(name="START_DATE")
    private Timestamp startDate;

    @Column(name="NAME")
    private String name;



    public BigDecimal getFcMethodId() { 
        return this.fcMethodId;
    }

    public void setFcMethodId(BigDecimal fcMethodId) { 
        this.fcMethodId=fcMethodId;
    }
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
    public String getDescription() { 
        return this.description;
    }

    public void setDescription(String description) { 
        this.description=description;
    }
    public Timestamp getCreatedDate() { 
        return this.createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) { 
        this.createdDate=createdDate;
    }
    public BigDecimal getVersion() { 
        return this.version;
    }

    public void setVersion(BigDecimal version) { 
        this.version=version;
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
    public String getName() { 
        return this.name;
    }

    public void setName(String name) { 
        this.name=name;
    }

}