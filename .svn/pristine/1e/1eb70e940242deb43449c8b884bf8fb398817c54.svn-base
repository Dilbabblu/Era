package com.forsys.revmantra.cpk.id;

import java.io.Serializable;

public class RmanLookupCodesPkId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1254493584740566103L;

	private String lookupTypeName;

	private String lookupCode;

	public RmanLookupCodesPkId() {
		super();
	}

	public RmanLookupCodesPkId(String lookupTypeCode, String lookupCode) {
		this.lookupTypeName = lookupTypeCode;
		this.lookupCode = lookupCode;
	}

	public String getLookupTypeName() {
		return lookupTypeName;
	}

	public void setLookupTypeName(String lookupTypeCode) {
		this.lookupTypeName = lookupTypeCode;
	}

	public String getLookupCode() {
		return lookupCode;
	}

	public void setLookupCode(String lookupCode) {
		this.lookupCode = lookupCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lookupCode == null) ? 0 : lookupCode.hashCode());
		result = prime * result + ((lookupTypeName == null) ? 0 : lookupTypeName.hashCode());
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
		RmanLookupCodesPkId other = (RmanLookupCodesPkId) obj;
		if (lookupCode == null) {
			if (other.lookupCode != null)
				return false;
		} else if (!lookupCode.equals(other.lookupCode))
			return false;
		if (lookupTypeName == null) {
			if (other.lookupTypeName != null)
				return false;
		} else if (!lookupTypeName.equals(other.lookupTypeName))
			return false;
		return true;
	}

}
