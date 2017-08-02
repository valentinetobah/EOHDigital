/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eoh.digital.config.service;

import com.eoh.digital.config.model.Audit;
import com.eoh.digital.dao.AbstractFacade.AbstractFacade;
import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author valentine
 */
@Service("auditService")
@Transactional
public class AuditService extends AbstractFacade<Integer, Audit> {
    
      public void saveAudit(String accountNumber, String userName){
          
        Audit audit = new Audit();
          
        audit.setAccountViewed(accountNumber); 
        audit.setAuditDate(new Date());
        audit.setAuditTime(new Date());
        audit.setUsername(userName);
        
        persist(audit);
          
      }
}
