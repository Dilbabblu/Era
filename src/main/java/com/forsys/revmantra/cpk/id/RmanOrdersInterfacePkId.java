package com.forsys.revmantra.cpk.id;

import java.io.Serializable;
import java.math.BigDecimal;

public class RmanOrdersInterfacePkId  implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BigDecimal sourceLineId;
	
	private String fileType;
	
	public BigDecimal getSourceLineId() {
		return sourceLineId;
	}
	public void setSourceLineId(BigDecimal sourceLineId) {
		this.sourceLineId = sourceLineId;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sourceLineId == null) ? 0 : sourceLineId.hashCode());
		result = prime * result + ((fileType == null) ? 0 : fileType.hashCode());
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
		RmanOrdersInterfacePkId other = (RmanOrdersInterfacePkId) obj;
		if (sourceLineId == null) {
			if (other.sourceLineId != null)
				return false;
		} else if (!sourceLineId.equals(other.sourceLineId))
			return false;
		if (fileType == null) {
			if (other.fileType != null)
				return false;
		} else if (!fileType.equals(other.fileType))
			return false;
		
		return true;
	}
	
	

}
