package com.forsys.revmantra.cpk.id;

import java.io.Serializable;

public class RmanLookupCodesPkId2 implements Serializable {

	private String lookupTypeCode;

	private String lookupCode;

	public RmanLookupCodesPkId2() {
		super();
	}

	public RmanLookupCodesPkId2(String lTypeCOde, String lcode) {
		this.lookupTypeCode = lTypeCOde;
		this.lookupCode = lcode;
	}

	public String getLookupTypeCode() {
		return lookupTypeCode;
	}

	public void setLookupTypeCode(String lookupTypeCode) {
		this.lookupTypeCode = lookupTypeCode;
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
		result = prime * result + ((lookupTypeCode == null) ? 0 : lookupTypeCode.hashCode());
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
		RmanLookupCodesPkId2 other = (RmanLookupCodesPkId2) obj;
		if (lookupCode == null) {
			if (other.lookupCode != null)
				return false;
		} else if (!lookupCode.equals(other.lookupCode))
			return false;
		if (lookupTypeCode == null) {
			if (other.lookupTypeCode != null)
				return false;
		} else if (!lookupTypeCode.equals(other.lookupTypeCode))
			return false;
		return true;
	}
	
	

}
