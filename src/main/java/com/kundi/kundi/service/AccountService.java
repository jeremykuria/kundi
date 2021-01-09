package com.kundi.kundi.service;

import com.kundi.kundi.domain.Account;
import com.kundi.kundi.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    private final Logger log = LoggerFactory.getLogger(AccountService.class);

    private final AccountRepository accountRepository;


    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    public List<Account> getGroupAccounts(Integer groupId){
        log.info("Getting Accounts for Group: {}", groupId);

        return this.accountRepository.findByGroupId(groupId);
    }

    public Account addGroupAccount(Account account){

       return this.accountRepository.save(account);

    }


    public Optional<Account> getAccountById(Long accountId) {

        return this.accountRepository.findById(accountId);
    }

    public void updateAccountBalance(Long accountId, double amount) {
        Optional<Account> account = Optional.of(new Account(accountId));

        account.get().setBalance(account.get().getBalance() + amount);


    }


}
