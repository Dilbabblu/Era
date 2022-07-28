package com.forsys.revmantra.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="RMAN_USERS")
public class RmanUsersLookup {

    @Column(name="FULL_NAME")
    private String fullName;

    @Id
    @Column(name="RMAN_USER_ID")
    private BigDecimal rmanUserId;



    public String getFullName() { 
        return this.fullName;
    }

    public void setFullName(String fullName) { 
        this.fullName=fullName;
    }
    public BigDecimal getRmanUserId() { 
        return this.rmanUserId;
    }

    public void setRmanUserId(BigDecimal rmanUserId) { 
        this.rmanUserId=rmanUserId;
    }

}