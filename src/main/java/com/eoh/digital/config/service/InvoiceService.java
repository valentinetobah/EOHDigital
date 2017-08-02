/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eoh.digital.config.service;

import com.eoh.digital.config.model.Invoice;
import com.eoh.digital.dao.AbstractFacade.AbstractFacade;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author valentine
 */
@Service("invoiceService")
@Transactional
public class InvoiceService extends AbstractFacade<Integer, Invoice> {

    public List<Invoice> findInvoicesByAccountId(Integer accountId) {
        String hql = 
                "FROM Invoice inv WHERE inv.account.accountId = :accountId";
        Query query = getSession().createQuery(hql);
        query.setParameter("accountId", accountId);
        return (List<Invoice>) query.list();
    }
}
