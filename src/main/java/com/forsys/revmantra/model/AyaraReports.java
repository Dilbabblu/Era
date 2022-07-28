package com.forsys.revmantra.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="AYARA_REPORTS")
public class AyaraReports {

    @Column(name="REPORT_PATH")
    private String reportPath;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="SNO")
    private BigDecimal sno;

    @Column(name="REPORT_NAME")
    private String reportName;

    @Column(name="ENABLED_FLAG")
    private String enabledFlag;

    @Column(name="REPORT_CODE")
    private String reportCode;
    
    @Column(name="REPORT_TYPE")
    private String reportType;

    public String getReportPath() { 
        return this.reportPath;
    }

    public void setReportPath(String reportPath) { 
        this.reportPath=reportPath;
    }
    public BigDecimal getSno() { 
        return this.sno;
    }

    public void setSno(BigDecimal sno) { 
        this.sno=sno;
    }
    public String getReportName() { 
        return this.reportName;
    }

    public void setReportName(String reportName) { 
        this.reportName=reportName;
    }
    public String getEnabledFlag() { 
        return this.enabledFlag;
    }

    public void setEnabledFlag(String enabledFlag) { 
        this.enabledFlag=enabledFlag;
    }

	public String getReportCode() {
		return reportCode;
	}

	public void setReportCode(String reportCode) {
		this.reportCode = reportCode;
	}
	
	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

}