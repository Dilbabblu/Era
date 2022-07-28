package com.forsys.revmantra.cpk.id;

import java.io.Serializable;
import java.math.BigDecimal;

public class RmanInvoicesStgPkId implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BigDecimal sourceInvoiceLineId;
    private String processId;
	public BigDecimal getSourceInvoiceLineId() {
		return sourceInvoiceLineId;
	}
	public void setSourceInvoiceLineId(BigDecimal sourceInvoiceLineId) {
		this.sourceInvoiceLineId = sourceInvoiceLineId;
	}
	public String getProcessId() {
		return processId;
	}
	public void setProcessId(String processId) {
		this.processId = processId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((processId == null) ? 0 : processId.hashCode());
		result = prime * result + ((sourceInvoiceLineId == null) ? 0 : sourceInvoiceLineId.hashCode());
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
		RmanInvoicesStgPkId other = (RmanInvoicesStgPkId) obj;
		if (processId == null) {
			if (other.processId != null)
				return false;
		} else if (!processId.equals(other.processId))
			return false;
		if (sourceInvoiceLineId == null) {
			if (other.sourceInvoiceLineId != null)
				return false;
		} else if (!sourceInvoiceLineId.equals(other.sourceInvoiceLineId))
			return false;
		return true;
	}
	
	 
}
