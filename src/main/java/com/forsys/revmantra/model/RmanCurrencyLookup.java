package com.forsys.revmantra.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="RMAN_CURRENCY")
public class RmanCurrencyLookup {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="RMAN_CURRENCY_seq_gen")
    @SequenceGenerator(name="RMAN_CURRENCY_seq_gen", sequenceName="CURRENCY_S")
    @Column(name="CURRENCY_CODE")
    private String currencyCode;

    @Column(name="NAME")
    private String name;



    public String getCurrencyCode() { 
        return this.currencyCode;
    }

    public void setCurrencyCode(String currencyCode) { 
        this.currencyCode=currencyCode;
    }
    public String getName() { 
        return this.name;
    }

    public void setName(String name) { 
        this.name=name;
    }

}