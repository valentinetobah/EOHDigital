/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eoh.digital.config.service;

import com.eoh.digital.config.model.Contact;
import com.eoh.digital.dao.AbstractFacade.AbstractFacade;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author valentine
 */
@Service("contactService")
@Transactional
public class ContactService extends AbstractFacade<Integer, Contact> {

    public List<Contact> findContactsByAccountId(Integer accountId) {
        String hql
                = "FROM Contact ct WHERE ct.account.accountId = :accountId";
        Query query = getSession().createQuery(hql);
        query.setParameter("accountId", accountId);
        return (List<Contact>) query.list();
    }

    public String getNames(Integer accountId) {

        String hql
                = "select ct.email from Contact ct WHERE ct.account.accountId = :accountId";
        Query query = getSession().createQuery(hql);
        query.setParameter("accountId", accountId);
        String email= (String)query.uniqueResult();

        return email;
    }

}
