/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eoh.digital.config.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

/**
 *
 * @author valentine
 */
@Entity
@Table(name = "AUDIT")
public class Audit implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer auditId;
    
    @NotNull
    @Column(name = "auditDate", unique = true, nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date auditDate;
    
    @NotNull
    @Column(name = "auditTime", unique = true, nullable = false)
    @Temporal(javax.persistence.TemporalType.TIME)
    private Date auditTime;
    
    @NotNull
    @Column(name = "accountViewed", unique = true, nullable = false)
    private String accountViewed;

    @Column(name = "username", unique = true, nullable = true)
    private String username;

    public Integer getAuditId() {
        return auditId;
    }

    public void setAuditId(Integer auditId) {
        this.auditId = auditId;
    }

    public Date getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public String getAccountViewed() {
        return accountViewed;
    }

    public void setAccountViewed(String accountViewed) {
        this.accountViewed = accountViewed;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.auditId);
        hash = 37 * hash + Objects.hashCode(this.auditDate);
        hash = 37 * hash + Objects.hashCode(this.auditTime);
        hash = 37 * hash + Objects.hashCode(this.accountViewed);
        hash = 37 * hash + Objects.hashCode(this.username);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Audit other = (Audit) obj;
        if (!Objects.equals(this.accountViewed, other.accountViewed)) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.auditId, other.auditId)) {
            return false;
        }
        if (!Objects.equals(this.auditDate, other.auditDate)) {
            return false;
        }
        if (!Objects.equals(this.auditTime, other.auditTime)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Audit{" + "auditId=" + auditId + ", auditDate=" + auditDate + ", auditTime=" + auditTime + ", accountViewed=" + accountViewed + ", username=" + username + '}';
    }
    
    

}
