package com.forsys.revmantra.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.forsys.revmantra.listener.AyaraReleaseLogTblListener;


@Entity	
@EntityListeners(AyaraReleaseLogTblListener.class)
@Table(name="AYARA_RELEASE_LOG_TBL")
public class AyaraReleaseLogTbl {

    @Column(name="CREATED_BY")
    private String createdBy;

    @Column(name="LAST_UPDATED_BY")
    private String lastUpdatedBy;

    @Column(name="RELEASE_DATE")
    private Timestamp releaseDate;

    @Id
    @Column(name="FIRMWARE_VERSION")
    private BigDecimal firmwareVersion;

    @Column(name="CREATION_DATE")
    private Timestamp creationDate;

    @Column(name="LAST_UPDATE_DATE")
    private Timestamp lastUpdateDate;

    @Column(name="RELEASE_NOTES")
    private String releaseNotes;
    
    @Transient
    private List<String> releaseNotesList;



    public String getCreatedBy() { 
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) { 
        this.createdBy=createdBy;
    }
    public String getLastUpdatedBy() { 
        return this.lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) { 
        this.lastUpdatedBy=lastUpdatedBy;
    }
    public Timestamp getReleaseDate() { 
        return this.releaseDate;
    }

    public void setReleaseDate(Timestamp releaseDate) { 
        this.releaseDate=releaseDate;
    }
    public BigDecimal getFirmwareVersion() { 
        return this.firmwareVersion;
    }

    public void setFirmwareVersion(BigDecimal firmwareVersion) { 
        this.firmwareVersion=firmwareVersion;
    }
    public Timestamp getCreationDate() { 
        return this.creationDate;
    }

    public void setCreationDate(Timestamp creationDate) { 
        this.creationDate=creationDate;
    }
    public Timestamp getLastUpdateDate() { 
        return this.lastUpdateDate;
    }

    public void setLastUpdateDate(Timestamp lastUpdateDate) { 
        this.lastUpdateDate=lastUpdateDate;
    }
    public String getReleaseNotes() { 
        return this.releaseNotes;
    }

    public void setReleaseNotes(String releaseNotes) { 
        this.releaseNotes=releaseNotes;
    }

	public List<String> getReleaseNotesList() {
		return releaseNotesList;
	}

	public void setReleaseNotesList(List<String> releaseNotesList) {
		this.releaseNotesList = releaseNotesList;
	}
    
}