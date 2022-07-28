package com.forsys.revmantra.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.forsys.revmantra.cpk.id.AllTabColumnscpkId;

@Entity
@Table(name = "ALL_TAB_COLUMNS")
@IdClass(AllTabColumnscpkId.class)
public class AllTabColumns {

	@Id
	@Column(name = "TABLE_NAME")
	private String tableName;

	@Id
	@Column(name = "COLUMN_NAME")
	private String columnName;

	@Column(name = "DATA_LENGTH")
	private BigDecimal dataLength;
	
	@Id
	@Column(name = "OWNER")
	private String owner;

	@Column(name = "DATA_TYPE")
	private String dataType;

	public String getTableName() {
		return this.tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getColumnName() {
		return this.columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public BigDecimal getDataLength() {
		return this.dataLength;
	}

	public void setDataLength(BigDecimal dataLength) {
		this.dataLength = dataLength;
	}

	public String getOwner() {
		return this.owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getDataType() {
		return this.dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

}