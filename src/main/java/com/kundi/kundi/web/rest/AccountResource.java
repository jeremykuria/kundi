package com.kundi.kundi.web.rest;


import com.kundi.kundi.domain.Account;
import com.kundi.kundi.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountResource {

    private  final Logger log = LoggerFactory.getLogger(AccountResource.class);

    private AccountService accountService;

    public AccountResource(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{groupId}")
    public List<Account> getGroupAccounts(@PathVariable Integer groupId){
        log.info("Request to get Accounts for Group: {}", groupId);

        return this.accountService.getGroupAccounts(groupId);
    }

    @PostMapping()
    public Account addGroupAccount(Account account){

        log.info("Request to Save Account: {}", account);
        
        return  this.accountService.addGroupAccount(account);
    }
}
