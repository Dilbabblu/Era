package com.forsys.revmantra.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="RMAN_ENTITY_PARAMETERS_V")
public class RmanEntityParametersV {

    @Column(name="TABLE_NAME")
    private String tableName;

    @Column(name="START_DATE_ACTIVE")
    private Timestamp startDateActive;

    @Column(name="ENTITY_ID")
    private BigDecimal entityId;

    @Column(name="ENTITY_CATEGORY")
    private String entityCategory;

    @Column(name="COLUMN_NAME")
    private String columnName;

    @Column(name="ENTITY_DESCRIPTION")
    private String entityDescription;

    @Column(name="ENABLED_FLAG")
    private String enabledFlag;

    @Column(name="COLUMN_SEQUENCE")
    private BigDecimal columnSequence;

    @Column(name="PARAMETER_NAME")
    private String parameterName;

    @Id
//    @GeneratedValue(strategy=GenerationType.AUTO, generator="RMAN_ENTITY_PARAMETERS_V_seq_gen")
//    @SequenceGenerator(name="RMAN_ENTITY_PARAMETERS_V_seq_gen", sequenceName="RMAN_ENTITY_PARAMETERS_V_S")
    @Column(name="ENTITY_PARAMETER_ID")
    private BigDecimal entityParameterId;

    @Column(name="COLUMN_TYPE")
    private String columnType;

    @Column(name="PARAMETER_DESCRIPTION")
    private String parameterDescription;

    @Column(name="END_DATE_ACTIVE")
    private Timestamp endDateActive;

    @Column(name="COLUMN_SIZE")
    private BigDecimal columnSize;

    @Column(name="ENTITY_NAME")
    private String entityName;



    public String getTableName() { 
        return this.tableName;
    }

    public void setTableName(String tableName) { 
        this.tableName=tableName;
    }
    public Timestamp getStartDateActive() { 
        return this.startDateActive;
    }

    public void setStartDateActive(Timestamp startDateActive) { 
        this.startDateActive=startDateActive;
    }
    public BigDecimal getEntityId() { 
        return this.entityId;
    }

    public void setEntityId(BigDecimal entityId) { 
        this.entityId=entityId;
    }
    public String getEntityCategory() { 
        return this.entityCategory;
    }

    public void setEntityCategory(String entityCategory) { 
        this.entityCategory=entityCategory;
    }
    public String getColumnName() { 
        return this.columnName;
    }

    public void setColumnName(String columnName) { 
        this.columnName=columnName;
    }
    public String getEntityDescription() { 
        return this.entityDescription;
    }

    public void setEntityDescription(String entityDescription) { 
        this.entityDescription=entityDescription;
    }
    public String getEnabledFlag() { 
        return this.enabledFlag;
    }

    public void setEnabledFlag(String enabledFlag) { 
        this.enabledFlag=enabledFlag;
    }
    public BigDecimal getColumnSequence() { 
        return this.columnSequence;
    }

    public void setColumnSequence(BigDecimal columnSequence) { 
        this.columnSequence=columnSequence;
    }
    public String getParameterName() { 
        return this.parameterName;
    }

    public void setParameterName(String parameterName) { 
        this.parameterName=parameterName;
    }
    public BigDecimal getEntityParameterId() { 
        return this.entityParameterId;
    }

    public void setEntityParameterId(BigDecimal entityParameterId) { 
        this.entityParameterId=entityParameterId;
    }
    public String getColumnType() { 
        return this.columnType;
    }

    public void setColumnType(String columnType) { 
        this.columnType=columnType;
    }
    public String getParameterDescription() { 
        return this.parameterDescription;
    }

    public void setParameterDescription(String parameterDescription) { 
        this.parameterDescription=parameterDescription;
    }
    public Timestamp getEndDateActive() { 
        return this.endDateActive;
    }

    public void setEndDateActive(Timestamp endDateActive) { 
        this.endDateActive=endDateActive;
    }
    public BigDecimal getColumnSize() { 
        return this.columnSize;
    }

    public void setColumnSize(BigDecimal columnSize) { 
        this.columnSize=columnSize;
    }
    public String getEntityName() { 
        return this.entityName;
    }

    public void setEntityName(String entityName) { 
        this.entityName=entityName;
    }

}