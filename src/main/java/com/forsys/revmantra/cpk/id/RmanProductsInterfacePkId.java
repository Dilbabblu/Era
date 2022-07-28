package com.forsys.revmantra.cpk.id;

import java.io.Serializable;
import java.math.BigDecimal;

public class RmanProductsInterfacePkId implements Serializable {
	
	private BigDecimal sourceProductId;
	
	private BigDecimal productOrgId;

	public BigDecimal getSourceProductId() {
		return sourceProductId;
	}

	public void setSourceProductId(BigDecimal sourceProductId) {
		this.sourceProductId = sourceProductId;
	}

	public BigDecimal getProductOrgId() {
		return productOrgId;
	}

	public void setProductOrgId(BigDecimal productOrgId) {
		this.productOrgId = productOrgId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productOrgId == null) ? 0 : productOrgId.hashCode());
		result = prime * result + ((sourceProductId == null) ? 0 : sourceProductId.hashCode());
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
		RmanProductsInterfacePkId other = (RmanProductsInterfacePkId) obj;
		if (productOrgId == null) {
			if (other.productOrgId != null)
				return false;
		} else if (!productOrgId.equals(other.productOrgId))
			return false;
		if (sourceProductId == null) {
			if (other.sourceProductId != null)
				return false;
		} else if (!sourceProductId.equals(other.sourceProductId))
			return false;
		return true;
	}
	
	
	

}
