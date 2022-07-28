package com.forsys.revmantra.cpk.id;

import java.io.Serializable;
import java.math.BigDecimal;

public class RmanOredersPkId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RmanOredersPkId() {

	}

	private BigDecimal sno;

	private BigDecimal serviceRefOrder;

	private BigDecimal serviceRefOrdLineNum;

	public BigDecimal getSno() {
		return sno;
	}

	public void setSno(BigDecimal sno) {
		this.sno = sno;
	}

	public BigDecimal getServiceRefOrder() {
		return serviceRefOrder;
	}

	public void setServiceRefOrder(BigDecimal serviceRefOrder) {
		this.serviceRefOrder = serviceRefOrder;
	}

	public BigDecimal getServiceRefOrdLineNum() {
		return serviceRefOrdLineNum;
	}

	public void setServiceRefOrdLineNum(BigDecimal serviceRefOrdLineNum) {
		this.serviceRefOrdLineNum = serviceRefOrdLineNum;
	}

}
