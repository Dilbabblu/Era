package com.forsys.revmantra.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.forsys.revmantra.listener.AyaraRcApprovalHistoryVListener;
import java.lang.String;
import java.sql.Timestamp;
import java.math.BigDecimal;


@Entity
@EntityListeners(AyaraRcApprovalHistoryVListener.class)
@Table(name="AYARA_RC_APPROVAL_HISTORY_V")
public class AyaraRcApprovalHistoryV {

    @Column(name="USER_COMMENT")
    private String userComment;

    @Column(name="TASK_STATUS")
    private String taskStatus;

    @Column(name="COMMENT_BY")
    private String commentBy;

    @Column(name="TASK_NAME")
    private String taskName;

    @Column(name="COMMENT_DATE")
    private Timestamp commentDate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="COMMENT_ID")
    private String commentId;

    @Column(name="USER_ID")
    private String userId;

    @Column(name="PID")
    private String pid;

    @Column(name="ARRANGEMENT_ID")
    private BigDecimal arrangementId;



    public String getUserComment() { 
        return this.userComment;
    }

    public void setUserComment(String userComment) { 
        this.userComment=userComment;
    }
    public String getTaskStatus() { 
        return this.taskStatus;
    }

    public void setTaskStatus(String taskStatus) { 
        this.taskStatus=taskStatus;
    }
    public String getCommentBy() { 
        return this.commentBy;
    }

    public void setCommentBy(String commentBy) { 
        this.commentBy=commentBy;
    }
    public String getTaskName() { 
        return this.taskName;
    }

    public void setTaskName(String taskName) { 
        this.taskName=taskName;
    }
    public Timestamp getCommentDate() { 
        return this.commentDate;
    }

    public void setCommentDate(Timestamp commentDate) { 
        this.commentDate=commentDate;
    }
    public String getCommentId() { 
        return this.commentId;
    }

    public void setCommentId(String commentId) { 
        this.commentId=commentId;
    }
    public String getUserId() { 
        return this.userId;
    }

    public void setUserId(String userId) { 
        this.userId=userId;
    }
    public String getPid() { 
        return this.pid;
    }

    public void setPid(String pid) { 
        this.pid=pid;
    }
    public BigDecimal getArrangementId() { 
        return this.arrangementId;
    }

    public void setArrangementId(BigDecimal arrangementId) { 
        this.arrangementId=arrangementId;
    }

}