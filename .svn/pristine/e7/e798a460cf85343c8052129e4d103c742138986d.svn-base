package com.forsys.revmantra.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="RMAN_MASTER_ARRANGEMENTS_V")
public class RmanMasterArrangementsV {

    @Column(name="MASTERARRGNAME")
    private String masterarrgname;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="MASTERARRGID")
    private BigDecimal masterarrgid;



    public String getMasterarrgname() { 
        return this.masterarrgname;
    }

    public void setMasterarrgname(String masterarrgname) { 
        this.masterarrgname=masterarrgname;
    }
    public BigDecimal getMasterarrgid() { 
        return this.masterarrgid;
    }

    public void setMasterarrgid(BigDecimal masterarrgid) { 
        this.masterarrgid=masterarrgid;
    }

}