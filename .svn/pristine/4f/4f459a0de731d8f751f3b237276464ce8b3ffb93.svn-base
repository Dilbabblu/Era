package com.forsys.revmantra.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="RMAN_CUSTOMERS")
public class RmanCustomersLookup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CUSTOMER_NUMBER")
    private String customerNumber;

    @Column(name="CUSTOMER_NAME")
    private String customerName;



    public String getCustomerNumber() { 
        return this.customerNumber;
    }

    public void setCustomerNumber(String customerNumber) { 
        this.customerNumber=customerNumber;
    }
    public String getCustomerName() { 
        return this.customerName;
    }

    public void setCustomerName(String customerName) { 
        this.customerName=customerName;
    }

}