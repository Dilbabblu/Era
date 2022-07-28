package com.forsys.revmantra.cpk.id;

import java.io.Serializable;
import java.math.BigDecimal;

public class RmanTrxDetailRepPkId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String sourceLineId;
	private String periodName;
	private BigDecimal dealLineId;

	public String getSourceLineId() {
		return sourceLineId;
	}

	public void setSourceLineId(String sourceLineId) {
		this.sourceLineId = sourceLineId;
	}

	public String getPeriodName() {
		return periodName;
	}

	public void setPeriodName(String periodName) {
		this.periodName = periodName;
	}

	public BigDecimal getDealLineId() {
		return dealLineId;
	}

	public void setDealLineId(BigDecimal dealLineId) {
		this.dealLineId = dealLineId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dealLineId == null) ? 0 : dealLineId.hashCode());
		result = prime * result + ((periodName == null) ? 0 : periodName.hashCode());
		result = prime * result + ((sourceLineId == null) ? 0 : sourceLineId.hashCode());
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
		RmanTrxDetailRepPkId other = (RmanTrxDetailRepPkId) obj;
		if (dealLineId == null) {
			if (other.dealLineId != null)
				return false;
		} else if (!dealLineId.equals(other.dealLineId))
			return false;
		if (periodName == null) {
			if (other.periodName != null)
				return false;
		} else if (!periodName.equals(other.periodName))
			return false;
		if (sourceLineId == null) {
			if (other.sourceLineId != null)
				return false;
		} else if (!sourceLineId.equals(other.sourceLineId))
			return false;
		return true;
	}

}
