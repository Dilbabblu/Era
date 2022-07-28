package com.forsys.revmantra.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;

public class RmanIntfUniqueRecord implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    
/**    @Column(name="ARRANGEMENT_NUMBER")
    private String arrangementNumber; */

    
    @Column(name="DEAL_NUMBER")
    private String dealNumber;
    
    @Column(name="DEAL_LINE_NUMBER")
    private BigDecimal dealLineNumber;
    
    @Column(name="SOURCE_LINE_REF_ID")
    private String sourceLineRefId;
    
    
	public String getDealNumber() {
		return dealNumber;
	}

	public void setDealNumber(String dealNumber) {
		this.dealNumber = dealNumber;
	}

	public BigDecimal getDealLineNumber() {
		return dealLineNumber;
	}

	public void setDealLineNumber(BigDecimal dealLineNumber) {
		this.dealLineNumber = dealLineNumber;
	}

	public String getSourceLineRefId() {
		return sourceLineRefId;
	}

	public void setSourceLineRefId(String sourceLineRefId) {
		this.sourceLineRefId = sourceLineRefId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dealLineNumber == null) ? 0 : dealLineNumber.hashCode());
		result = prime * result + ((dealNumber == null) ? 0 : dealNumber.hashCode());
		result = prime * result + ((sourceLineRefId == null) ? 0 : sourceLineRefId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RmanIntfUniqueRecord other = (RmanIntfUniqueRecord) obj;
		if (dealLineNumber == null) {
			if (other.dealLineNumber != null)
				return false;
		} else if (!dealLineNumber.equals(other.dealLineNumber))
			return false;
		if (dealNumber == null) {
			if (other.dealNumber != null)
				return false;
		} else if (!dealNumber.equals(other.dealNumber))
			return false;
		if (sourceLineRefId == null) {
			if (other.sourceLineRefId != null)
				return false;
		} else if (!sourceLineRefId.equals(other.sourceLineRefId))
			return false;
		return true;
	}


    
    

}
