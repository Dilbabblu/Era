package com.forsys.revmantra.cpk.id;

import java.io.Serializable;
import java.math.BigDecimal;

public class RmanUserResponsibilitiesPk implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal rmanUserId;
	private BigDecimal responsibilityId;
	
	public RmanUserResponsibilitiesPk(){
		super();
	}
	
	public RmanUserResponsibilitiesPk(BigDecimal rmanUserId,BigDecimal responsibilityId){
		this.rmanUserId = rmanUserId;
		this.responsibilityId = responsibilityId;
	}
	
		public BigDecimal getRmanUserId() {
		return rmanUserId;
	}

	public void setRmanUserId(BigDecimal rmanUserId) {
		this.rmanUserId = rmanUserId;
	}

	public BigDecimal getResponsibilityId() {
		return responsibilityId;
	}

	public void setResponsibilityId(BigDecimal responsibilityId) {
		this.responsibilityId = responsibilityId;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((responsibilityId == null) ? 0 : responsibilityId.hashCode());
		result = prime * result + ((rmanUserId == null) ? 0 : rmanUserId.hashCode());
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
		RmanUserResponsibilitiesPk other = (RmanUserResponsibilitiesPk) obj;
		if (responsibilityId == null) {
			if (other.responsibilityId != null)
				return false;
		} else if (!responsibilityId.equals(other.responsibilityId))
			return false;
		if (rmanUserId == null) {
			if (other.rmanUserId != null)
				return false;
		} else if (!rmanUserId.equals(other.rmanUserId))
			return false;
		return true;
	}


}
