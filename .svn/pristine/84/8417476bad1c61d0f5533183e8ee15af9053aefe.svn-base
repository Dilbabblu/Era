package com.forsys.revmantra.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="AYARA_INT_RECORD_EXCEPTIONS_V")
public class AyaraIntRecordExceptionsV {

    @Column(name="RECORD_LINE_NUMBER")
    private String recordLineNumber;

    @Column(name="RECORD_NUMBER")
    private String recordNumber;

    @Column(name="ERROR_MESSAGE")
    private String errorMessage;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="SNO")
    private BigDecimal sno;

    @Column(name="RECORD_TYPE")
    private String recordType;

    @Column(name="RECORD_LINE_ID")
    private String recordLineId;



    public String getRecordLineNumber() { 
        return this.recordLineNumber;
    }

    public void setRecordLineNumber(String recordLineNumber) { 
        this.recordLineNumber=recordLineNumber;
    }
    public String getRecordNumber() { 
        return this.recordNumber;
    }

    public void setRecordNumber(String recordNumber) { 
        this.recordNumber=recordNumber;
    }
    public String getErrorMessage() { 
        return this.errorMessage;
    }

    public void setErrorMessage(String errorMessage) { 
        this.errorMessage=errorMessage;
    }
    public BigDecimal getSno() { 
        return this.sno;
    }

    public void setSno(BigDecimal sno) { 
        this.sno=sno;
    }
    public String getRecordType() { 
        return this.recordType;
    }

    public void setRecordType(String recordType) { 
        this.recordType=recordType;
    }
    public String getRecordLineId() { 
        return this.recordLineId;
    }

    public void setRecordLineId(String recordLineId) { 
        this.recordLineId=recordLineId;
    }

}