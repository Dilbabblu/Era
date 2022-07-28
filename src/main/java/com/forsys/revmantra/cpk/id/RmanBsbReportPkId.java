package com.forsys.revmantra.cpk.id;

import java.io.Serializable;
import java.math.BigDecimal;

public class RmanBsbReportPkId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BigDecimal sourceLineId;
	private BigDecimal dealLineId;

	public BigDecimal getSourceLineId() {
		return sourceLineId;
	}

	public void setSourceLineId(BigDecimal sourceLineId) {
		this.sourceLineId = sourceLineId;
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
		RmanBsbReportPkId other = (RmanBsbReportPkId) obj;
		if (dealLineId == null) {
			if (other.dealLineId != null)
				return false;
		} else if (!dealLineId.equals(other.dealLineId))
			return false;
		if (sourceLineId == null) {
			if (other.sourceLineId != null)
				return false;
		} else if (!sourceLineId.equals(other.sourceLineId))
			return false;
		return true;
	}

}
