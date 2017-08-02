/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eoh.digital.config.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author valentine
 */
@Entity
@Table(name = "ITEMISED")
public class Itemised implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer itemisedId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "InvoiceId")
    private Invoice invoice;

    @NotNull
    @Column(name = "callDate", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date callDate;

    @NotNull
    @Column(name = "callTime", nullable = false)
    @Temporal(javax.persistence.TemporalType.TIME)
    private Date callTime;

    @NotNull
    @Column(name = "callType", nullable = false)
    private String callType;

    @NotEmpty
    @NotNull
    @Column(name = "callCost", nullable = false)
    private BigDecimal callCost;

    
    public Itemised() {
    }
    
    public Itemised(Integer itemisedId, Date callDate, Date callTime, 
            String callType, BigDecimal callCost) {
        this.itemisedId = itemisedId;
        this.callDate = callDate;
        this.callTime = callTime;
        this.callType = callType;
        this.callCost = callCost;
    }

    public Integer getItemisedId() {
        return itemisedId;
    }

    public void setItemisedId(Integer itemisedId) {
        this.itemisedId = itemisedId;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Date getCallDate() {
        return callDate;
    }

    public void setCallDate(Date callDate) {
        this.callDate = callDate;
    }

    public Date getCallTime() {
        return callTime;
    }

    public void setCallTime(Date callTime) {
        this.callTime = callTime;
    }

    public String getCallType() {
        return callType;
    }

    public void setCallType(String callType) {
        this.callType = callType;
    }

    public BigDecimal getCallCost() {
        return callCost;
    }

    public void setCallCost(BigDecimal callCost) {
        this.callCost = callCost;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.itemisedId);
        hash = 17 * hash + Objects.hashCode(this.invoice);
        hash = 17 * hash + Objects.hashCode(this.callDate);
        hash = 17 * hash + Objects.hashCode(this.callTime);
        hash = 17 * hash + Objects.hashCode(this.callType);
        hash = 17 * hash + Objects.hashCode(this.callCost);
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
        final Itemised other = (Itemised) obj;
        if (!Objects.equals(this.callType, other.callType)) {
            return false;
        }
        if (!Objects.equals(this.itemisedId, other.itemisedId)) {
            return false;
        }
        if (!Objects.equals(this.invoice, other.invoice)) {
            return false;
        }
        if (!Objects.equals(this.callDate, other.callDate)) {
            return false;
        }
        if (!Objects.equals(this.callTime, other.callTime)) {
            return false;
        }
        if (!Objects.equals(this.callCost, other.callCost)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Itemised{" + "itemisedId=" + itemisedId + ", invoice="
                + invoice+ ", callDate=" + callDate + ", callTime=" 
                + callTime + ", callType=" + callType + ", callCost=" 
                + callCost + '}';
    }

}
