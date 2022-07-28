package com.forsys.revmantra.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.forsys.revmantra.listener.RmanFcBucketsListener;


@Entity
@EntityListeners(RmanFcBucketsListener.class)
@Table(name="RMAN_FC_BUCKETS")
public class RmanFcBuckets {

    @Column(name="ATTRIBUTE10")
    private String attribute10;

    @Column(name="ATTRIBUTE14")
    private String attribute14;

    @Column(name="ATTRIBUTE13")
    private String attribute13;

    @Column(name="CREATED_DATE")
    private Timestamp createdDate;

    @Column(name="ATTRIBUTE12")
    private String attribute12;

    @Column(name="ATTRIBUTE11")
    private String attribute11;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RMAN_FC_BUCKETS_seq_gen")
    @SequenceGenerator(name="RMAN_FC_BUCKETS_seq_gen", sequenceName="RMAN_FC_BUCKET_S", allocationSize=1)
    @Column(name="BUCKET_ID")
    private BigDecimal bucketId;

    @Column(name="END_DATE")
    private Timestamp endDate;

    @Column(name="NUMBER_OF_YEARS")
    private BigDecimal numberOfYears;

    @Column(name="ATTRIBUTE3")
    private String attribute3;

    @Column(name="CREATED_BY")
    private BigDecimal createdBy;

    @Column(name="ATTRIBUTE2")
    private String attribute2;

    @Column(name="LAST_UPDATED_BY")
    private BigDecimal lastUpdatedBy;

    @Column(name="ATTRIBUTE1")
    private String attribute1;

    @Column(name="NUMBER_OF_BUCKETS")
    private BigDecimal numberOfBuckets;

    @Column(name="START_DATE")
    private Timestamp startDate;

    @Column(name="ATTRIBUTE9")
    private String attribute9;

    @Column(name="ATTRIBUTE8")
    private String attribute8;

    @Column(name="ATTRIBUTE7")
    private String attribute7;

    @Column(name="LATEST_FLAG")
    private String latestFlag;

    @Column(name="ATTRIBUTE6")
    private String attribute6;

    @Column(name="ATTRIBUTE5")
    private String attribute5;

    @Column(name="NAME")
    private String name;

    @Column(name="ATTRIBUTE4")
    private String attribute4;

    @Column(name="LAST_UPDATED_DATE")
    private Timestamp lastUpdatedDate;

    @Column(name="NUMBER_OF_QTRS")
    private BigDecimal numberOfQtrs;

    @Column(name="VERSION")
    private BigDecimal version;

    @Column(name="NUMBER_OF_PERIODS")
    private BigDecimal numberOfPeriods;

    @Column(name="ATTRIBUTE15")
    private String attribute15;



    public String getAttribute10() { 
        return this.attribute10;
    }

    public void setAttribute10(String attribute10) { 
        this.attribute10=attribute10;
    }
    public String getAttribute14() { 
        return this.attribute14;
    }

    public void setAttribute14(String attribute14) { 
        this.attribute14=attribute14;
    }
    public String getAttribute13() { 
        return this.attribute13;
    }

    public void setAttribute13(String attribute13) { 
        this.attribute13=attribute13;
    }
    public Timestamp getCreatedDate() { 
        return this.createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) { 
        this.createdDate=createdDate;
    }
    public String getAttribute12() { 
        return this.attribute12;
    }

    public void setAttribute12(String attribute12) { 
        this.attribute12=attribute12;
    }
    public String getAttribute11() { 
        return this.attribute11;
    }

    public void setAttribute11(String attribute11) { 
        this.attribute11=attribute11;
    }
    public BigDecimal getBucketId() { 
        return this.bucketId;
    }

    public void setBucketId(BigDecimal bucketId) { 
        this.bucketId=bucketId;
    }
    public Timestamp getEndDate() { 
        return this.endDate;
    }

    public void setEndDate(Timestamp endDate) { 
        this.endDate=endDate;
    }
    public BigDecimal getNumberOfYears() { 
        return this.numberOfYears;
    }

    public void setNumberOfYears(BigDecimal numberOfYears) { 
        this.numberOfYears=numberOfYears;
    }
    public String getAttribute3() { 
        return this.attribute3;
    }

    public void setAttribute3(String attribute3) { 
        this.attribute3=attribute3;
    }
    public BigDecimal getCreatedBy() { 
        return this.createdBy;
    }

    public void setCreatedBy(BigDecimal createdBy) { 
        this.createdBy=createdBy;
    }
    public String getAttribute2() { 
        return this.attribute2;
    }

    public void setAttribute2(String attribute2) { 
        this.attribute2=attribute2;
    }
    public BigDecimal getLastUpdatedBy() { 
        return this.lastUpdatedBy;
    }

    public void setLastUpdatedBy(BigDecimal lastUpdatedBy) { 
        this.lastUpdatedBy=lastUpdatedBy;
    }
    public String getAttribute1() { 
        return this.attribute1;
    }

    public void setAttribute1(String attribute1) { 
        this.attribute1=attribute1;
    }
    public BigDecimal getNumberOfBuckets() { 
        return this.numberOfBuckets;
    }

    public void setNumberOfBuckets(BigDecimal numberOfBuckets) { 
        this.numberOfBuckets=numberOfBuckets;
    }
    public Timestamp getStartDate() { 
        return this.startDate;
    }

    public void setStartDate(Timestamp startDate) { 
        this.startDate=startDate;
    }
    public String getAttribute9() { 
        return this.attribute9;
    }

    public void setAttribute9(String attribute9) { 
        this.attribute9=attribute9;
    }
    public String getAttribute8() { 
        return this.attribute8;
    }

    public void setAttribute8(String attribute8) { 
        this.attribute8=attribute8;
    }
    public String getAttribute7() { 
        return this.attribute7;
    }

    public void setAttribute7(String attribute7) { 
        this.attribute7=attribute7;
    }
    public String getLatestFlag() { 
        return this.latestFlag;
    }

    public void setLatestFlag(String latestFlag) { 
        this.latestFlag=latestFlag;
    }
    public String getAttribute6() { 
        return this.attribute6;
    }

    public void setAttribute6(String attribute6) { 
        this.attribute6=attribute6;
    }
    public String getAttribute5() { 
        return this.attribute5;
    }

    public void setAttribute5(String attribute5) { 
        this.attribute5=attribute5;
    }
    public String getName() { 
        return this.name;
    }

    public void setName(String name) { 
        this.name=name;
    }
    public String getAttribute4() { 
        return this.attribute4;
    }

    public void setAttribute4(String attribute4) { 
        this.attribute4=attribute4;
    }
    public Timestamp getLastUpdatedDate() { 
        return this.lastUpdatedDate;
    }

    public void setLastUpdatedDate(Timestamp lastUpdatedDate) { 
        this.lastUpdatedDate=lastUpdatedDate;
    }
    public BigDecimal getNumberOfQtrs() { 
        return this.numberOfQtrs;
    }

    public void setNumberOfQtrs(BigDecimal numberOfQtrs) { 
        this.numberOfQtrs=numberOfQtrs;
    }
    public BigDecimal getVersion() { 
        return this.version;
    }

    public void setVersion(BigDecimal version) { 
        this.version=version;
    }
    public BigDecimal getNumberOfPeriods() { 
        return this.numberOfPeriods;
    }

    public void setNumberOfPeriods(BigDecimal numberOfPeriods) { 
        this.numberOfPeriods=numberOfPeriods;
    }
    public String getAttribute15() { 
        return this.attribute15;
    }

    public void setAttribute15(String attribute15) { 
        this.attribute15=attribute15;
    }

}