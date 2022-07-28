package com.forsys.revmantra.cpk.id;

import java.io.Serializable;
import java.math.BigDecimal;

public class RmanContLinkedtemplatesId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal ruleHeaderId;
	private BigDecimal templateId;

	public RmanContLinkedtemplatesId() {
		super();
	}

	public RmanContLinkedtemplatesId(BigDecimal rhId, BigDecimal tId) {
		this.ruleHeaderId = rhId;
		this.templateId = tId;
	}

	public BigDecimal getRuleHeaderId() {
		return ruleHeaderId;
	}

	public void setRuleHeaderId(BigDecimal ruleHeaderId) {
		this.ruleHeaderId = ruleHeaderId;
	}

	public BigDecimal getTemplateId() {
		return templateId;
	}

	public void setTemplateId(BigDecimal templateId) {
		this.templateId = templateId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ruleHeaderId == null) ? 0 : ruleHeaderId.hashCode());
		result = prime * result + ((templateId == null) ? 0 : templateId.hashCode());
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
		RmanContLinkedtemplatesId other = (RmanContLinkedtemplatesId) obj;
		if (ruleHeaderId == null) {
			if (other.ruleHeaderId != null)
				return false;
		} else if (!ruleHeaderId.equals(other.ruleHeaderId))
			return false;
		if (templateId == null) {
			if (other.templateId != null)
				return false;
		} else if (!templateId.equals(other.templateId))
			return false;
		return true;
	}

}
