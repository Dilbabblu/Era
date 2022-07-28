package com.forsys.revmantra.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import com.forsys.revmantra.listener.AyaraFileUploadStorageListener;

@Entity
@EntityListeners(AyaraFileUploadStorageListener.class)
@Table(name="AYARA_UPLOAD_FILE_STORAGE")
public class AyaraFileUploadStorage {
	
	@Id
	@Column(name="PROCESS_ID")
	private BigDecimal processId;
	
	@Column(name="FILE_TYPE")
	private String fileType;
	
	@Column(name="FILE_NAME")
	private String fileName;
	
	@Column(name="FILE_DATA")
	private byte[] fileData;
	
	@Column(name="CREATED_BY")
	private BigDecimal createdBy;
	
	@Column(name="CREATION_DATE")
	private Timestamp creationDate;
	
	@Column(name="ATTRIBUTE1")
	private String attribute1;
	
	@Column(name="ATTRIBUTE2")
	private String attribute2;

	public BigDecimal getProcessId() {
		return processId;
	}

	public void setProcessId(BigDecimal processId) {
		this.processId = processId;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getFileData() {
		return fileData;
	}

	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}

	
	public BigDecimal getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(BigDecimal createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public String getAttribute1() {
		return attribute1;
	}

	public void setAttribute1(String attribute1) {
		this.attribute1 = attribute1;
	}

	public String getAttribute2() {
		return attribute2;
	}

	public void setAttribute2(String attribute2) {
		this.attribute2 = attribute2;
	}
	
	
	
} 
