package com.forsys.revmantra.cpk.id;

import java.io.Serializable;
import java.math.BigDecimal;

public class AyaraUserTableColumnsPkId implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public AyaraUserTableColumnsPkId() {
		super();
	}
	
	public AyaraUserTableColumnsPkId(String pageName, String tableName, BigDecimal userId) {
		this.pageName = pageName;
		this.tableName = tableName;
		this.userId = userId;
	}
	
	private String pageName;
	
	private String tableName;
	
	private BigDecimal userId;

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public BigDecimal getUserId() {
		return userId;
	}

	public void setUserId(BigDecimal userId) {
		this.userId = userId;
	}
	
	
	
}
