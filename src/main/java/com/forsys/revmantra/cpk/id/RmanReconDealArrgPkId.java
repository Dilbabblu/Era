package com.forsys.revmantra.cpk.id;

import java.io.Serializable;
import java.math.BigDecimal;

public class RmanReconDealArrgPkId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String dealNumber;
	private BigDecimal dealLineNumber;
	private String so;
	private String sourceLineNumber;
	private String arrangementNumber;

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

	public String getSo() {
		return so;
	}

	public void setSo(String so) {
		this.so = so;
	}

	public String getSourceLineNumber() {
		return sourceLineNumber;
	}

	public void setSourceLineNumber(String sourceLineNumber) {
		this.sourceLineNumber = sourceLineNumber;
	}

	public String getArrangementNumber() {
		return arrangementNumber;
	}

	public void setArrangementNumber(String arrangementNumber) {
		this.arrangementNumber = arrangementNumber;
	}

}
