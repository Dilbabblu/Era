package com.forsys.revmantra.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.forsys.revmantra.cpk.id.AyaraUserTableColumnsPkId;
import com.forsys.revmantra.listener.AyaraUserTableColumnsListener;


@Entity
@EntityListeners(AyaraUserTableColumnsListener.class)
@IdClass(AyaraUserTableColumnsPkId.class)
@Table(name="AYARA_USER_TABLE_COLUMNS")
public class AyaraUserTableColumns {

    @Column(name="CREATED_BY")
    private BigDecimal createdBy;

    @Column(name="ATTRIBUTE3")
    private String attribute3;

    @Column(name="LAST_UPDATED_BY")
    private BigDecimal lastUpdatedBy;

    @Column(name="ATTRIBUTE2")
    private String attribute2;

    @Id
    @Column(name="TABLE_NAME")
    private String tableName;

    @Column(name="ATTRIBUTE1")
    private String attribute1;

    @Column(name="CREATION_DATE")
    private Timestamp creationDate;

    @Id
    @Column(name="USER_ID")
    private BigDecimal userId;

    @Column(name="TABLE_COLUMNS")
    private String tableColumns;

    @Column(name="LAST_UPDATE_DATE")
    private Timestamp lastUpdateDate;

    @Column(name="ATTRIBUTE5")
    private String attribute5;

    @Column(name="ATTRIBUTE4")
    private String attribute4;

    @Column(name="SNO")
    private BigDecimal sno;

    @Id
    @Column(name="PAGE_NAME")
    private String pageName;



    public BigDecimal getCreatedBy() { 
        return this.createdBy;
    }

    public void setCreatedBy(BigDecimal createdBy) { 
        this.createdBy=createdBy;
    }
    public String getAttribute3() { 
        return this.attribute3;
    }

    public void setAttribute3(String attribute3) { 
        this.attribute3=attribute3;
    }
    public BigDecimal getLastUpdatedBy() { 
        return this.lastUpdatedBy;
    }

    public void setLastUpdatedBy(BigDecimal lastUpdatedBy) { 
        this.lastUpdatedBy=lastUpdatedBy;
    }
    public String getAttribute2() { 
        return this.attribute2;
    }

    public void setAttribute2(String attribute2) { 
        this.attribute2=attribute2;
    }
    public String getTableName() { 
        return this.tableName;
    }

    public void setTableName(String tableName) { 
        this.tableName=tableName;
    }
    public String getAttribute1() { 
        return this.attribute1;
    }

    public void setAttribute1(String attribute1) { 
        this.attribute1=attribute1;
    }
    public Timestamp getCreationDate() { 
        return this.creationDate;
    }

    public void setCreationDate(Timestamp creationDate) { 
        this.creationDate=creationDate;
    }
    public BigDecimal getUserId() { 
        return this.userId;
    }

    public void setUserId(BigDecimal userId) { 
        this.userId=userId;
    }
    public String getTableColumns() { 
        return this.tableColumns;
    }

    public void setTableColumns(String tableColumns) { 
        this.tableColumns=tableColumns;
    }
    public Timestamp getLastUpdateDate() { 
        return this.lastUpdateDate;
    }

    public void setLastUpdateDate(Timestamp lastUpdateDate) { 
        this.lastUpdateDate=lastUpdateDate;
    }
    public String getAttribute5() { 
        return this.attribute5;
    }

    public void setAttribute5(String attribute5) { 
        this.attribute5=attribute5;
    }
    public String getAttribute4() { 
        return this.attribute4;
    }

    public void setAttribute4(String attribute4) { 
        this.attribute4=attribute4;
    }
    public BigDecimal getSno() { 
        return this.sno;
    }

    public void setSno(BigDecimal sno) { 
        this.sno=sno;
    }
    public String getPageName() { 
        return this.pageName;
    }

    public void setPageName(String pageName) { 
        this.pageName=pageName;
    }

}