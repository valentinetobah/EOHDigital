/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eoh.digital.config.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

/**
 *
 * @author valentine
 */
@Entity
@Table(name = "INVOICE")
public class Invoice implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int invoiceId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accountId")
    private Account account;

    @NotNull
    @Column(name = "openingBalance", nullable = false)
    private BigDecimal openingBalance;

    @NotNull
    @Column(name = "closingBalance", nullable = false)
    private BigDecimal closingBalance;

    @NotNull
    @Column(name = "invoiceDueDate", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date invoiceDueDate;
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "invoice")
    private List<Itemised> ItemisedList;

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public BigDecimal getOpeningBalance() {
        return openingBalance;
    }

    public void setOpeningBalance(BigDecimal openingBalance) {
        this.openingBalance = openingBalance;
    }

    public BigDecimal getClosingBalance() {
        return closingBalance;
    }

    public void setClosingBalance(BigDecimal closingBalance) {
        this.closingBalance = closingBalance;
    }

    public Date getInvoiceDueDate() {
        return invoiceDueDate;
    }

    public void setInvoiceDueDate(Date invoiceDueDate) {
        this.invoiceDueDate = invoiceDueDate;
    }

    public List<Itemised> getItemisedList() {
        return ItemisedList;
    }

    public void setItemisedList(List<Itemised> ItemisedList) {
        this.ItemisedList = ItemisedList;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.invoiceId;
        hash = 37 * hash + Objects.hashCode(this.account);
        hash = 37 * hash + Objects.hashCode(this.openingBalance);
        hash = 37 * hash + Objects.hashCode(this.closingBalance);
        hash = 37 * hash + Objects.hashCode(this.invoiceDueDate);
        hash = 37 * hash + Objects.hashCode(this.ItemisedList);
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
        final Invoice other = (Invoice) obj;
        if (this.invoiceId != other.invoiceId) {
            return false;
        }
        if (!Objects.equals(this.account, other.account)) {
            return false;
        }
        if (!Objects.equals(this.openingBalance, other.openingBalance)) {
            return false;
        }
        if (!Objects.equals(this.closingBalance, other.closingBalance)) {
            return false;
        }
        if (!Objects.equals(this.invoiceDueDate, other.invoiceDueDate)) {
            return false;
        }
        if (!Objects.equals(this.ItemisedList, other.ItemisedList)) {
            return false;
        }
        return true;
    }
    
    

    @Override
    public String toString() {
        return "Invoice{" + "invoiceId=" + invoiceId + ", account=" 
                + account + ", openingBalance=" 
                + openingBalance + ", closingBalance=" 
                + closingBalance + ", invoiceDueDate=" 
                + invoiceDueDate + ", ItemisedList=" 
                + ItemisedList + '}';
    }
     
}
