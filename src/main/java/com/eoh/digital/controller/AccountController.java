/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eoh.digital.controller;

import com.eoh.digital.config.dto.AccountDTO;
import com.eoh.digital.config.model.Account;
import com.eoh.digital.config.model.Contact;
import com.eoh.digital.config.model.Invoice;
import com.eoh.digital.config.model.Itemised;
import com.eoh.digital.config.service.AccountService;
import com.eoh.digital.config.service.AuditService;
import com.eoh.digital.config.service.ContactService;
import com.eoh.digital.config.service.InvoiceService;
import com.eoh.digital.config.service.ItemisedService;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.ui.ModelMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author valentine
 */
@Controller
@RequestMapping("/")
public class AccountController {

    @Autowired
    AccountService accountService;

    @Autowired
    AuditService auditService;

    @Autowired
    ContactService contactService;

    @Autowired
    InvoiceService invoiceService;

    @Autowired
    ItemisedService itemisedService;

    @RequestMapping(method = RequestMethod.GET)
    public String displayIndex(ModelMap model) {
        model.addAttribute("accountDTO", new AccountDTO());

        return "index";
    }

    @RequestMapping(value = "/display", method = {RequestMethod.POST, RequestMethod.GET})
    public String displaySearch(ModelMap model,
            @RequestParam(required = false) String accountNumber, @RequestParam(required = false) Integer offset, @RequestParam(required = false) Integer maxResults) {

        if (accountNumber != null) {
            if (accountNumber.isEmpty()) {
                String errormessage = "Please enter account number to search";
                model.addAttribute("errormessage", errormessage);
                return "index";
            }

            if (accountNumber.length() != 8) {
                String errormessage = "Account number must be 8 characters";
                model.addAttribute("errormessage", errormessage);
                return "index";
            }

            Pattern pattern = Pattern.compile("^(A)(\\d{7})$");
            Matcher matcher = pattern.matcher(accountNumber);
            if (!matcher.matches()) {
                String errormessage = "Account number must start with a capital letter, "
                        + " followed by 7 numbers e.g D24555555";
                model.addAttribute("errormessage", errormessage);
                return "index";
            }
        }

        Account account
                = accountService.findAccountByAccountNumber(accountNumber);

        if (account == null) {
            String errormessage = "Account number does not exist";
            model.addAttribute("errormessage", errormessage);
            return "index";
        }

        List<Contact> contacts
                = contactService.findContactsByAccountId(account.getAccountId());

        List<Invoice> invoices
                = invoiceService.findInvoicesByAccountId(account.getAccountId());

        List<Itemised> itemisedCallsList
                = itemisedService.findItemisedCallsByAccountId(account.getAccountId(), offset, maxResults);

        String username = contactService.getNames(account.getAccountId());
        String accountViewed = accountService.getAccountNumber(account.getAccountId());
        auditService.saveAudit(accountViewed, username);

        model.addAttribute("account", account);
        model.addAttribute("contacts", contacts);
        model.addAttribute("invoices", invoices);
        model.addAttribute("itemised", itemisedCallsList);
        model.addAttribute("count", itemisedService.count(account.getAccountId()));
        model.addAttribute("offset", offset);   
        model.addAttribute("accountNumber", accountNumber);  
        
        System.out.println("offset value: "+offset);

        return "search";
    }

}
