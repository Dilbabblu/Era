package com.forsys.revmantra.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="RMAN_FC_BUCKETS")
public class RmanFcBucketsLookup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="BUCKET_ID")
    private BigDecimal bucketId;

    @Column(name="NAME")
    private String name;



    public BigDecimal getBucketId() { 
        return this.bucketId;
    }

    public void setBucketId(BigDecimal bucketId) { 
        this.bucketId=bucketId;
    }
    public String getName() { 
        return this.name;
    }

    public void setName(String name) { 
        this.name=name;
    }

}