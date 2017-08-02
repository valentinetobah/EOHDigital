/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eoh.digital.config.service;

import com.eoh.digital.config.model.Account;
import com.eoh.digital.dao.AbstractFacade.AbstractFacade;
import org.hibernate.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author valentine
 */
@Service("accountService")
@Transactional
public class AccountService extends AbstractFacade<Integer, Account> {

    public Account findAccountByAccountNumber(String account) {
        String hql = "FROM Account acc WHERE acc.accountNumber = :accountNumber";
        Query query = getSession().createQuery(hql);
        query.setParameter("accountNumber", account);
        Account accountList = (Account)query.uniqueResult();
        if(accountList == null){
            return null;
        }
        return accountList;
    }

    public String getAccountNumber(Integer accountId) {

        String hql
                = "select acc.accountNumber from Account acc WHERE acc.accountId =:accountId";
        Query query = getSession().createQuery(hql);
        query.setParameter("accountId", accountId);
        String accountNumber= (String)query.uniqueResult();

        return accountNumber;
    }
}
