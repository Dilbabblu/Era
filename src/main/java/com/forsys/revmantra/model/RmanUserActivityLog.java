package com.forsys.revmantra.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="RMAN_USER_ACTIVITY_LOG")
public class RmanUserActivityLog {

    @Column(name="NEW_VALUE")
    private String newValue;

    @Column(name="OPERATION")
    private String operation;

    @Column(name="COLUMN_NAME")
    private String columnName;

    @Column(name="RECID")
    private String recid;

    @Column(name="USER_ID")
    private BigDecimal userId;

    @Column(name="USERNAME")
    private String username;

    @Column(name="RECNAME")
    private String recname;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RMAN_USER_ACTIVITY_LOG_seq_gen")
	@SequenceGenerator(name = "RMAN_USER_ACTIVITY_LOG_seq_gen", sequenceName = "RMAN_USER_ACTIVITY_LOG_S", allocationSize=1)
    @Column(name="LOG_ID")
    private BigDecimal logId;

    @Column(name="MODIFIED_DATE")
    private Timestamp modifiedDate;

    @Column(name="ENTITY_NAME")
    private String entityName;

    @Column(name="OLD_VALUE")
    private String oldValue;



    public String getNewValue() { 
        return this.newValue;
    }

    public void setNewValue(String newValue) { 
        this.newValue=newValue;
    }
    public String getOperation() { 
        return this.operation;
    }

    public void setOperation(String operation) { 
        this.operation=operation;
    }
    public String getColumnName() { 
        return this.columnName;
    }

    public void setColumnName(String columnName) { 
        this.columnName=columnName;
    }
    public String getRecid() { 
        return this.recid;
    }

    public void setRecid(String recid) { 
        this.recid=recid;
    }
    public BigDecimal getUserId() { 
        return this.userId;
    }

    public void setUserId(BigDecimal userId) { 
        this.userId=userId;
    }
    public String getUsername() { 
        return this.username;
    }

    public void setUsername(String username) { 
        this.username=username;
    }
    public String getRecname() { 
        return this.recname;
    }

    public void setRecname(String recname) { 
        this.recname=recname;
    }
    public BigDecimal getLogId() { 
        return this.logId;
    }

    public void setLogId(BigDecimal logId) { 
        this.logId=logId;
    }
    public Timestamp getModifiedDate() { 
        return this.modifiedDate;
    }

    public void setModifiedDate(Timestamp modifiedDate) { 
        this.modifiedDate=modifiedDate;
    }
    public String getEntityName() { 
        return this.entityName;
    }

    public void setEntityName(String entityName) { 
        this.entityName=entityName;
    }
    public String getOldValue() { 
        return this.oldValue;
    }

    public void setOldValue(String oldValue) { 
        this.oldValue=oldValue;
    }

}