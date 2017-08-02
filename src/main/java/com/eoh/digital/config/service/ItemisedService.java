/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eoh.digital.config.service;

import com.eoh.digital.config.model.Audit;
import com.eoh.digital.config.model.Contact;
import com.eoh.digital.config.model.Itemised;
import com.eoh.digital.dao.AbstractFacade.AbstractFacade;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author valentine
 */
@Service("itemisedService")
@Transactional
public class ItemisedService extends AbstractFacade<Integer, Itemised> {

    @SuppressWarnings("unchecked")
    public List<Itemised> findItemisedCallsByAccountId(Integer accountId) {
        String hql
                = "FROM Itemised item WHERE item.invoice.account.accountId = :accountId";
        Query query = getSession().createQuery(hql);
        query.setParameter("accountId", accountId);

        return (List<Itemised>) query.list();

    }

    @SuppressWarnings("unchecked")
    public List<Itemised> findItemisedCallsByAccountId(Integer accountId, Integer offset, Integer maxResults) {
        String hql
                = "FROM Itemised item WHERE item.invoice.account.accountId = :accountId";
        Query query = getSession().createQuery(hql);
        query.setParameter("accountId", accountId);
        query.setFirstResult(offset != null ? offset : 0);
        query.setMaxResults(maxResults != null ? maxResults : 10);
        return (List<Itemised>) query.list();

    }

    @SuppressWarnings("unchecked")
    public int count(Integer accountId) {
        String hql = "FROM Itemised item WHERE item.invoice.account.accountId = :accountId ";
        Query query = getSession().createQuery(hql);
        query.setParameter("accountId", accountId);
        return query.list().size();

    }

}
